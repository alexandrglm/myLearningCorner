# Correcciones y transformaciones ETL — Eustat

Fuente:

https://es.eustat.eus/bankupx/pxweb/es/DB/-/PX_010154_cepv1_ep06b.px

---

# Corrección de valores erróneos

## Ziortza-Bolivar y Usansolo

Se detectan errores en los rangos numéricos publicados para:

- Ziortza-Bolivar
- Usansolo

No es un problema del ETL sino de la fuente original (CSV de Eustat).

### Solución

Convertir explícitamente esos valores a `null`.

- **Usansolo:** todos los años (2001–2023)
- **Ziortza-Bolivar:** únicamente 2001–2005

```powerquery
= Table.FromRecords(
    List.Transform(
        Table.ToRecords(#"Columnas con nombre cambiado23"),
        each
            let
                ambito = [Ámbito Territorial],
                rec = _,
                rec1 =
                    if ambito <> null and
                       Text.Contains(ambito, "Usansolo", Comparer.OrdinalIgnoreCase)
                    then
                        Record.TransformFields(
                            rec,
                            List.Transform(
                                {2001..2023},
                                each {Text.From(_), (val) => null}
                            )
                        )
                    else
                        rec,

                rec2 =
                    if ambito <> null and
                       Text.Contains(ambito, "Ziortza", Comparer.OrdinalIgnoreCase)
                    then
                        Record.TransformFields(
                            rec1,
                            List.Transform(
                                {2001..2005},
                                each {Text.From(_), (val) => null}
                            )
                        )
                    else
                        rec1
            in
                rec2
    )
)
```

---

# Homogeneización territorial

Para construir correctamente un **modelo estrella**, donde `Dim_Territorial` actúe como dimensión maestra para todas las tablas, es necesario unificar nomenclaturas.

## Corrección

```
Arratia-Nerbioi
```

por

```
Arratia Nerbioi
```

en todas las tablas donde aparezca.

**Además:** comunicar la incidencia a Eustat para homgeneizar

---

# Crear columna **Nivel Territorial**

```powerquery
if [Ámbito Territorial] = "C.A. de Euskadi" then 1

else if
    [Ámbito Territorial] = "Araba/Álava"
    or [Ámbito Territorial] = "Bizkaia"
    or [Ámbito Territorial] = "Gipuzkoa"
then
    2

else if List.Contains({

    "Arabako Errioxa / Rioja Alavesa",
    "Arabako Kantaurialdea / Cantábrica Alavesa",
    "Arabako Lautada / Llanada Alavesa",
    "Arabako Mendialdea / Montaña Alavesa",
    "Añana (comarca)",
    "Gorbeialdea / Estribaciones del Gorbea",

    "Bilbo Handia / Gran Bilbao",
    "Durangaldea / Duranguesado",
    "Enkartazioak / Encartaciones",
    "Gernika-Bermeo",
    "Markina-Ondarroa",
    "Plentzia-Mungia",
    "Arratia-Nerbioi / Arratia-Nervión",

    "Tolosaldea",
    "Donostialdea",
    "Goierri",
    "Urola Kosta",
    "Bidasoa Beherea / Bajo Bidasoa",
    "Debabarrena / Bajo Deba",
    "Debagoiena / Alto Deba"

}, [Ámbito Territorial])

then 3

else 4
```

---

# Crear columna **Pertenece a TH** (TH Padre)

```powerquery
let

    listaAraba = {
        "Agurain/Salvatierra", "Alegría-Dulantzi", "Amurrio", "Añana", "Aramaio",
        "Armiñón", "Arraia-Maeztu", "Arratzua-Ubarrundia", "Artziniega", "Asparrena",
        "Ayala/Aiara", "Baños de Ebro/Mañueta", "Barrundia", "Berantevilla", "Bernedo",
        "Campezo/Kanpezu", "Elburgo/Burgelu", "Elciego", "Elvillar/Bilar",
        "Erriberagoitia/Ribera Alta", "Harana/Valle de Arana", "Iruña Oka/Iruña de Oca",
        "Iruraiz-Gauna", "Kripan", "Kuartango", "Labastida/Bastida", "Lagrán",
        "Laguardia", "Lanciego/Lantziego", "Lantarón", "Lapuebla de Labarca",
        "Laudio/Llodio", "Legutio", "Leza", "Moreda de Álava/Moreda Araba",
        "Navaridas", "Okondo", "Oyón-Oion", "Peñacerrada-Urizaharra",
        "Ribera Baja/Erriberabeitia", "Samaniego", "San Millán/Donemiliaga",
        "Urduña/Orduña", "Urkabustaiz", "Valdegovía/Gaubea",
        "Villabuena de Álava/Eskuernaga", "Vitoria-Gasteiz",
        "Yécora/Iekora", "Zalduondo", "Zambrana", "Zigoitia", "Zuia"
    },

    listaBizkaia = {
        "Abadiño", "Abanto y Ciérvana-Abanto Zierbena", "Ajangiz", "Alonsotegi",
        "Amorebieta-Etxano", "Amoroto", "Arakaldo", "Arantzazu", "Areatza",
        "Arrankudiaga-Zollo", "Arratzu", "Arrieta", "Arrigorriaga", "Artea",
        "Artzentales", "Atxondo", "Aulesti", "Bakio", "Balmaseda", "Barakaldo",
        "Barrika", "Basauri", "Bedia", "Berango", "Bermeo", "Berriatua", "Berriz",
        "Bilbao", "Busturia", "Derio", "Dima", "Durango", "Ea", "Elantxobe",
        "Elorrio", "Erandio", "Ereño", "Ermua", "Errigoiti", "Etxebarri",
        "Etxebarria", "Forua", "Fruiz", "Galdakao", "Galdames", "Gamiz-Fika",
        "Garai", "Gatika", "Gautegiz Arteaga", "Gernika-Lumo", "Getxo",
        "Gizaburuaga", "Gordexola", "Gorliz", "Güeñes", "Ibarrangelu",
        "Igorre", "Ispaster", "Iurreta", "Izurtza",
        "Karrantza Harana/Valle de Carranza", "Kortezubi", "Lanestosa",
        "Larrabetzu", "Laukiz", "Leioa", "Lekeitio", "Lemoa", "Lemoiz",
        "Lezama", "Loiu", "Mallabia", "Mañaria", "Markina-Xemein",
        "Maruri-Jatabe", "Mendata", "Mendexa", "Meñaka", "Morga",
        "Mundaka", "Mungia", "Munitibar-Arbatzegi Gerrikaitz", "Murueta",
        "Muskiz", "Muxika", "Nabarniz", "Orozko", "Ortuella",
        "Otxandio", "Plentzia", "Portugalete", "Santurtzi", "Sestao",
        "Sondika", "Sopela", "Sopuerta", "Sukarrieta",
        "Trucios-Turtzioz", "Ubide", "Ugao-Miraballes", "Urduliz",
        "Usansolo", "Valle de Trápaga-Trapagaran", "Zaldibar",
        "Zalla", "Zamudio", "Zaratamo", "Zeanuri",
        "Zeberio", "Zierbena", "Ziortza-Bolibar"
    },

    listaGipuzkoa = {
        "Abaltzisketa", "Aduna", "Aia", "Aizarnazabal", "Albiztur", "Alegia",
        "Alkiza", "Altzaga", "Altzo", "Amezketa", "Andoain", "Anoeta",
        "Antzuola", "Arama", "Aretxabaleta", "Arrasate/Mondragón",
        "Asteasu", "Astigarraga", "Ataun", "Azkoitia", "Azpeitia",
        "Baliarrain", "Beasain", "Beizama", "Belauntza", "Berastegi",
        "Bergara", "Berrobi", "Bidania-Goiatz", "Deba",
        "Donostia / San Sebastián", "Eibar", "Elduain", "Elgeta",
        "Elgoibar", "Errenteria", "Errezil", "Eskoriatza",
        "Ezkio-Itsaso", "Gabiria", "Gaintza", "Gaztelu", "Getaria",
        "Hernani", "Hernialde", "Hondarribia", "Ibarra", "Idiazabal",
        "Ikaztegieta", "Irun", "Irura", "Itsasondo", "Larraul",
        "Lasarte-Oria", "Lazkao", "Leaburu", "Legazpi",
        "Legorreta", "Leintz-Gatzaga", "Lezo", "Lizartza",
        "Mendaro", "Mutiloa", "Mutriku", "Oiartzun",
        "Olaberria", "Ondarroa", "Oñati", "Ordizia", "Orendain",
        "Orexa", "Orio", "Ormaiztegi", "Pasaia", "Segura",
        "Soraluze-Placencia de las Armas", "Tolosa", "Urnieta",
        "Urretxu", "Usurbil", "Villabona", "Zaldibia",
        "Zarautz", "Zegama", "Zerain", "Zestoa",
        "Zizurkil", "Zumaia", "Zumarraga"
    }

in

    if [Ámbito Territorial] = "C.A. de Euskadi" then "C.A. de Euskadi"

    else if
        [Ámbito Territorial] = "Araba/Álava"
        or [Ámbito Territorial] = "Bizkaia"
        or [Ámbito Territorial] = "Gipuzkoa"
    then
        [Ámbito Territorial]

    else if List.Contains({
        "Arabako Errioxa / Rioja Alavesa",
        "Arabako Kantaurialdea / Cantábrica Alavesa",
        "Arabako Lautada / Llanada Alavesa",
        "Arabako Mendialdea / Montaña Alavesa",
        "Añana (comarca)",
        "Gorbeialdea / Estribaciones del Gorbea"
    }, [Ámbito Territorial])
    then "Araba/Álava"

    else if List.Contains({
        "Bilbo Handia / Gran Bilbao",
        "Durangaldea / Duranguesado",
        "Enkartazioak / Encartaciones",
        "Gernika-Bermeo",
        "Markina-Ondarroa",
        "Plentzia-Mungia",
        "Arratia-Nerbioi / Arratia-Nervión"
    }, [Ámbito Territorial])
    then "Bizkaia"

    else if List.Contains({
        "Tolosaldea",
        "Donostialdea",
        "Goierri",
        "Urola Kosta",
        "Bidasoa Beherea / Bajo Bidasoa",
        "Debabarrena / Bajo Deba",
        "Debagoiena / Alto Deba"
    }, [Ámbito Territorial])
    then "Gipuzkoa"

    else if List.Contains(listaAraba, [Ámbito Territorial]) then "Araba/Álava"
    else if List.Contains(listaBizkaia, [Ámbito Territorial]) then "Bizkaia"
    else if List.Contains(listaGipuzkoa, [Ámbito Territorial]) then "Gipuzkoa"
    else null
```

---

# Crear códigos INE para todos los niveles territoriales

Objetivo:

- Azure Maps
- Shape Maps
- Mapas coropléticos
- Compatibilidad con otros sistemas GIS

## INE-5

```powerquery
let
    // ==================== COMUNIDAD AUTÓNOMA ====================
    caEuskadi = {
        {"C.A. de Euskadi", "04"}
    },
    
    // ==================== TERRITORIOS HISTÓRICOS ====================
    territorios = {
        {"Araba/Álava", "01"},
        {"Bizkaia", "48"},
        {"Gipuzkoa", "20"}
    },
    
    // ==================== COMARCAS - ARABA/ÁLAVA ====================
    comarcasAraba = {
        {"Arabako Errioxa / Rioja Alavesa", "01"},
        {"Arabako Kantaurialdea / Cantábrica Alavesa", "01"},
        {"Arabako Lautada / Llanada Alavesa", "01"},
        {"Arabako Mendialdea / Montaña Alavesa", "01"},
        {"Añana (comarca)", "01"},
        {"Gorbeialdea / Estribaciones del Gorbea", "01"}
    },
    
    // ==================== COMARCAS - BIZKAIA ====================
    comarcasBizkaia = {
        {"Bilbo Handia / Gran Bilbao", "48"},
        {"Durangaldea / Duranguesado", "48"},
        {"Enkartazioak / Encartaciones", "48"},
        {"Gernika-Bermeo", "48"},
        {"Markina-Ondarroa", "48"},
        {"Plentzia-Mungia", "48"},
        {"Arratia-Nerbioi / Arratia-Nervión", "48"}
    },
    
    // ==================== COMARCAS - GIPUZKOA ====================
    comarcasGipuzkoa = {
        {"Tolosaldea", "20"},
        {"Donostialdea", "20"},
        {"Goierri", "20"},
        {"Urola Kosta", "20"},
        {"Bidasoa Beherea / Bajo Bidasoa", "20"},
        {"Debabarrena / Bajo Deba", "20"},
        {"Debagoiena / Alto Deba", "20"}
    },
    
    // ==================== MUNICIPIOS - ARABA/ÁLAVA ====================
    municipiosAraba = {
        {"Agurain/Salvatierra","01051"}, {"Alegría-Dulantzi","01001"}, {"Amurrio","01002"},
        {"Añana","01049"}, {"Aramaio","01003"}, {"Armiñón","01006"}, {"Arraia-Maeztu","01037"},
        {"Arratzua-Ubarrundia","01008"}, {"Artziniega","01004"}, {"Asparrena","01009"},
        {"Ayala/Aiara","01010"}, {"Baños de Ebro/Mañueta","01011"}, {"Barrundia","01013"},
        {"Berantevilla","01014"}, {"Bernedo","01016"}, {"Campezo/Kanpezu","01017"},
        {"Elburgo/Burgelu","01021"}, {"Elciego","01022"}, {"Elvillar/Bilar","01023"},
        {"Erriberagoitia/Ribera Alta","01046"}, {"Harana/Valle de Arana","01056"},
        {"Iruña Oka/Iruña de Oca","01901"}, {"Iruraiz-Gauna","01027"}, {"Kripan","01019"},
        {"Kuartango","01020"}, {"Labastida/Bastida","01028"}, {"Lagrán","01030"},
        {"Laguardia","01031"}, {"Lanciego/Lantziego","01032"}, {"Lantarón","01902"},
        {"Lapuebla de Labarca","01033"}, {"Laudio/Llodio","01036"}, {"Legutio","01058"},
        {"Leza","01034"}, {"Moreda de Álava/Moreda Araba","01039"}, {"Navaridas","01041"},
        {"Okondo","01042"}, {"Oyón-Oion","01043"}, {"Peñacerrada-Urizaharra","01044"},
        {"Ribera Baja/Erriberabeitia","01047"}, {"Samaniego","01052"},
        {"San Millán/Donemiliaga","01053"}, {"Urkabustaiz","01054"}, {"Urduña/Orduña","01074"},
        {"Valdegovía/Gaubea","01055"}, {"Villabuena de Álava/Eskuernaga","01057"},
        {"Vitoria-Gasteiz","01059"}, {"Yécora/Iekora","01060"}, {"Zalduondo","01061"},
        {"Zambrana","01062"}, {"Zigoitia","01018"}, {"Zuia","01063"}
    },
    
    // ==================== MUNICIPIOS - BIZKAIA ====================
    municipiosBizkaia = {
        {"Abadiño","48001"}, {"Abanto y Ciérvana-Abanto Zierbena","48002"},
        {"Amorebieta-Etxano","48003"}, {"Amoroto","48004"}, {"Arakaldo","48005"},
        {"Arantzazu","48006"}, {"Munitibar-Arbatzegi Gerrikaitz","48007"},
        {"Artzentales","48008"}, {"Arrankudiaga-Zollo","48009"}, {"Arrieta","48010"},
        {"Arrigorriaga","48011"}, {"Bakio","48012"}, {"Barakaldo","48013"},
        {"Barrika","48014"}, {"Basauri","48015"}, {"Berango","48016"}, {"Bermeo","48017"},
        {"Berriatua","48018"}, {"Berriz","48019"}, {"Bilbao","48020"}, {"Busturia","48021"},
        {"Karrantza Harana/Valle de Carranza","48022"}, {"Artea","48023"}, {"Zeanuri","48024"},
        {"Zeberio","48025"}, {"Dima","48026"}, {"Durango","48027"}, {"Ea","48028"},
        {"Etxebarri","48029"}, {"Etxebarria","48030"}, {"Elantxobe","48031"},
        {"Elorrio","48032"}, {"Ereño","48033"}, {"Ermua","48034"}, {"Fruiz","48035"},
        {"Galdakao","48036"}, {"Galdames","48037"}, {"Gamiz-Fika","48038"}, {"Garai","48039"},
        {"Gatika","48040"}, {"Gautegiz Arteaga","48041"}, {"Gordexola","48042"},
        {"Gorliz","48043"}, {"Getxo","48044"}, {"Güeñes","48045"}, {"Gernika-Lumo","48046"},
        {"Gizaburuaga","48047"}, {"Ibarrangelu","48048"}, {"Ispaster","48049"},
        {"Izurtza","48050"}, {"Lanestosa","48051"}, {"Larrabetzu","48052"}, {"Laukiz","48053"},
        {"Leioa","48054"}, {"Lemoa","48055"}, {"Lemoiz","48056"}, {"Lekeitio","48057"},
        {"Mallabia","48058"}, {"Mañaria","48059"}, {"Markina-Xemein","48060"},
        {"Maruri-Jatabe","48061"}, {"Mendata","48062"}, {"Mendexa","48063"}, {"Meñaka","48064"},
        {"Ugao-Miraballes","48065"}, {"Morga","48066"}, {"Muxika","48067"}, {"Mundaka","48068"},
        {"Mungia","48069"}, {"Aulesti","48070"}, {"Muskiz","48071"}, {"Otxandio","48072"},
        {"Ondarroa","48073"}, {"Urduña/Orduña","48074"}, {"Orozko","48075"},
        {"Sukarrieta","48076"}, {"Plentzia","48077"}, {"Portugalete","48078"},
        {"Errigoiti","48079"}, {"Valle de Trápaga-Trapagaran","48080"}, {"Lezama","48081"},
        {"Santurtzi","48082"}, {"Ortuella","48083"}, {"Sestao","48084"}, {"Sopela","48085"},
        {"Sopuerta","48086"}, {"Trucios-Turtzioz","48087"}, {"Ubide","48088"},
        {"Urduliz","48089"}, {"Balmaseda","48090"}, {"Atxondo","48091"}, {"Bedia","48092"},
        {"Areatza","48093"}, {"Igorre","48094"}, {"Zaldibar","48095"}, {"Zalla","48096"},
        {"Zaratamo","48097"}, {"Derio","48901"}, {"Erandio","48902"}, {"Loiu","48903"},
        {"Sondika","48904"}, {"Zamudio","48905"}, {"Forua","48906"}, {"Kortezubi","48907"},
        {"Murueta","48908"}, {"Nabarniz","48909"}, {"Iurreta","48910"}, {"Ajangiz","48911"},
        {"Alonsotegi","48912"}, {"Zierbena","48913"}, {"Arratzu","48914"},
        {"Ziortza-Bolibar","48915"}, {"Usansolo","48916"}
    },
    
    // ==================== MUNICIPIOS - GIPUZKOA ====================
    municipiosGipuzkoa = {
        {"Abaltzisketa","20001"}, {"Aduna","20002"}, {"Aizarnazabal","20003"},
        {"Albiztur","20004"}, {"Alegia","20005"}, {"Alkiza","20006"}, {"Altzo","20007"},
        {"Amezketa","20008"}, {"Andoain","20009"}, {"Anoeta","20010"}, {"Antzuola","20011"},
        {"Arama","20012"}, {"Aretxabaleta","20013"}, {"Asteasu","20014"}, {"Ataun","20015"},
        {"Aia","20016"}, {"Azkoitia","20017"}, {"Azpeitia","20018"}, {"Beasain","20019"},
        {"Beizama","20020"}, {"Belauntza","20021"}, {"Berastegi","20022"}, {"Berrobi","20023"},
        {"Bidania-Goiatz","20024"}, {"Zegama","20025"}, {"Zerain","20026"}, {"Zestoa","20027"},
        {"Zizurkil","20028"}, {"Deba","20029"}, {"Eibar","20030"}, {"Elduain","20031"},
        {"Elgoibar","20032"}, {"Elgeta","20033"}, {"Eskoriatza","20034"}, {"Ezkio-Itsaso","20035"},
        {"Hondarribia","20036"}, {"Gaintza","20037"}, {"Gabiria","20038"}, {"Getaria","20039"},
        {"Hernani","20040"}, {"Hernialde","20041"}, {"Ibarra","20042"}, {"Idiazabal","20043"},
        {"Ikaztegieta","20044"}, {"Irun","20045"}, {"Irura","20046"}, {"Itsasondo","20047"},
        {"Larraul","20048"}, {"Lazkao","20049"}, {"Leaburu","20050"}, {"Legazpi","20051"},
        {"Legorreta","20052"}, {"Lezo","20053"}, {"Lizartza","20054"}, {"Arrasate/Mondragón","20055"},
        {"Mutriku","20056"}, {"Mutiloa","20057"}, {"Olaberria","20058"}, {"Oñati","20059"},
        {"Orexa","20060"}, {"Orio","20061"}, {"Ormaiztegi","20062"}, {"Oiartzun","20063"},
        {"Pasaia","20064"}, {"Soraluze-Placencia de las Armas","20065"}, {"Errezil","20066"},
        {"Errenteria","20067"}, {"Leintz-Gatzaga","20068"}, {"Donostia / San Sebastián","20069"},
        {"Segura","20070"}, {"Tolosa","20071"}, {"Urnieta","20072"}, {"Usurbil","20073"},
        {"Bergara","20074"}, {"Villabona","20075"}, {"Ordizia","20076"}, {"Urretxu","20077"},
        {"Zaldibia","20078"}, {"Zarautz","20079"}, {"Zumarraga","20080"}, {"Zumaia","20081"},
        {"Mendaro","20901"}, {"Lasarte-Oria","20902"}, {"Astigarraga","20903"},
        {"Baliarrain","20904"}, {"Orendain","20905"}, {"Altzaga","20906"}, {"Gaztelu","20907"}
    },
    
    // ==================== UNIÓN DE TODOS LOS DICCIONARIOS ====================
    // Convertir todas las listas de pares a Records y combinarlas
    todosRegistros = Record.Combine({
        Record.FromList(List.Transform(caEuskadi, each _{1}), List.Transform(caEuskadi, each _{0})),
        Record.FromList(List.Transform(territorios, each _{1}), List.Transform(territorios, each _{0})),
        Record.FromList(List.Transform(comarcasAraba, each _{1}), List.Transform(comarcasAraba, each _{0})),
        Record.FromList(List.Transform(comarcasBizkaia, each _{1}), List.Transform(comarcasBizkaia, each _{0})),
        Record.FromList(List.Transform(comarcasGipuzkoa, each _{1}), List.Transform(comarcasGipuzkoa, each _{0})),
        Record.FromList(List.Transform(municipiosAraba, each _{1}), List.Transform(municipiosAraba, each _{0})),
        Record.FromList(List.Transform(municipiosBizkaia, each _{1}), List.Transform(municipiosBizkaia, each _{0})),
        Record.FromList(List.Transform(municipiosGipuzkoa, each _{1}), List.Transform(municipiosGipuzkoa, each _{0}))
    }),
    
    // ==================== FUNCIÓN DE BÚSQUEDA ====================
    BuscarCodigo = (nombre as text) as text =>
        let
            nombreLimpio = Text.Trim(nombre),
            codigo = 
                if Record.HasFields(todosRegistros, nombreLimpio) 
                then Record.Field(todosRegistros, nombreLimpio)
                else null
        in
            codigo
in
    BuscarCodigo([Ámbito Territorial])
```

---

## INE-6

Generación del código INE de seis dígitos mediante cálculo automático del dígito de control.

Pendiente.