# Proyecto Power BI: Demo 1

***

# SESION 1 - [2026 JUL, 10] 

## 1. Resumen del Proyecto
Análisis y correlación multivariante de factores socioeconómicos y de bienestar en la Comunidad Autónoma de Euskadi. El objetivo principal es identificar patrones y evaluar la correlación entre los siguientes bloques de datos:

*   **Índices de Criminalidad** (tasas de delitos e infracciones penales).
*   **Desempleo y Actividad Económica**.
*   **Nivel Educativo y Alfabetización** (escolarización obligatoria y tasas de analfabetismo).
*   **Sistemas de Protección Social** (personas perceptoras de Ayudas de Emergencia Social - AES, Renta de Garantía de Ingresos - RGI, e Ingreso Mínimo Vital - IMV).
*   **Vivienda, Salud y otros factores de vulnerabilidad**.

---

## 2. Inventario de Fuentes de Datos

### 📊 Bloque A: Criminalidad, Justicia y Seguridad

#### [Fuente 01] Tasa de Criminalidad (Eustat)
*   **Descripción:** Infracciones penales por cada 1,000 habitantes (totales, sin desglose territorial).
*   **Periodo:** Anual (2012 - 2019).
*   **Calidad de Datos:** **Baja**. No desglosa por Territorio Histórico (provincias). El rango temporal es muy limitado. 

> *Nota de diseño:* Sería ideal disponer de datos históricos desde la década de los 80 para evaluar el impacto a largo plazo de la implantación de las políticas de asistencia social pública.
*   **Enlace:** [Eustat - Tasa de Criminalidad](https://es.eustat.eus/indic/indicadoresgraficosvista.aspx?idgraf=19315&opt=1&tema=1393)

#### [Fuente 03] Justicia y Seguridad (Eustat)
*   **Descripción:** Estadísticas generales del área judicial y de seguridad en el País Vasco.
*   **Periodo:** 2010 - 2025.
*   **Enlace:** [Eustat - Justicia y Seguridad](https://es.eustat.eus/estadisticas/tema_1020/opt_0/tipo_1/ti_justicia-y-seguridad/temas.html)

#### [Fuente 03.1] Estadísticas Delictivas de la Ertzaintza
*   **Descripción:** Datos delictivos oficiales registrados por la Ertzaintza.
*   **Periodo y Calidad:**
    *   Históricos de 2021 a 2025: detallados por tipo de delito y territorio (buena calidad).
    *   Datos comparados: 2024 - 2025.
    *   Datos trimestrales actuales: 2025 - 2026.
*   **Enlace:** [Ertzaintza - Estadísticas Delictivas](https://www.ertzaintza.euskadi.eus/lfr/web/ertzaintza/estadisticas-delictivas)

#### [Fuente 06] Indicadores Municipales de Sostenibilidad: Índice de Delitos (‰ habitantes)
*   **Descripción:** Tasa de criminalidad a escala municipal.
*   **Periodo:** 2003 - 2025.
*   **Enlace:** [Open Data Euskadi - Índice de Delitos Municipal](https://opendata.euskadi.eus/catalogo/-/indicadores-municipales-de-sostenibilidad-indice-de-delitos-x2030-habitantes/)

---

### 💼 Bloque B: Población Parada y Desempleo

#### [Fuente 02] Eustat - Repositorio de Actividad, Ocupación y Paro
*   **Descripción:** Acceso general a estadísticas de empleo y situación laboral.
*   **Enlace:** [Eustat - Actividad, Ocupación y Paro](https://es.eustat.eus/estadisticas/tema_131/opt_3/tipo_1/ti_actividad-ocupacion-y-paro/temas.html)

#### [Fuente 02.1] Población Parada Censada (Eustat)
*   **Descripción:** Datos censales detallados de población parada por variables como año, sexo y nivel formativo.
*   **Enlace:** [Eustat - Población Parada Censada](https://es.eustat.eus/estadisticas/tema_265/opt_2/tipo_4/ti_poblacion-parada/temas.html)

#### [Fuente 02.2] Tasas de Actividad y Paro por Comarcas (Eustat)
*   **Descripción:** Tasas de actividad, paro y coeficiente de ocupación para la población de 16 a 64 años desglosada en las 40 comarcas de Euskadi y por sexo.
*   **Periodo:** 2023.
*   **Enlace:** [Eustat - Tasas de Paro por Comarcas](https://es.eustat.eus/elementos/ele0000400/tasas-de-actividad-y-paro-y-coeficiente-de-ocupacion-de-la-poblacion-de-16-a-64-anos-de-euskadi-por-comarcas-40-comarcas-y-sexo-/tbl0000409_c.html)

#### [Fuente 02.3] Actividad, Ocupación y Paro - Serie Histórica y Trimestral (Eustat)
*   **Descripción:** Tasa de paro histórica y tendencias de la población mayor de 16 años por trimestres.
*   **Periodo:** 1985 - 2021 (y actualización 2024).
*   **Enlace:** [Eustat - Datos de Empleo 2024](https://es.eustat.eus/estadisticas/tema_131/opt_0/ti_actividad-ocupacion-y-paro/temas.html)

---

### 🏚️ Bloque C: Pobreza, Exclusión Social y Ayudas Públicas

#### [Fuente 04] Módulo EPDS - Encuesta de Necesidades Sociales (Eustat)
*   **Descripción:** Documento PDF con el informe de la Encuesta de Necesidades Sociales centrada en pobreza.
*   **Periodo:** 2014.
*   **Enlace:** [Eustat - PDF Módulo EPDS Pobreza](https://es.eustat.eus/elementos/ele0018700/encuesta-de-necesidades-sociales/inf0018775_c.pdf)

#### [Fuente 04.1] Pobreza y Desigualdades Sociales (Eustat)
*   **Descripción:** Datos de alto valor, muy variados y altamente segmentados sobre índices de pobreza.
*   **Periodo:** Abarca desde 2008 hasta 2025 (algunos históricos se remontan a 1986).
*   **Enlace:** [Eustat - Pobreza y Desigualdades](https://es.eustat.eus/estadisticas/tema_136/opt_0/tipo_1/ti_pobreza-y-desigualdades-sociales/temas.html)

#### [Fuente 07] Porcentaje de Perceptores de RGI y Parados Registrados
*   **Descripción:** Datos cruzados que comparan de forma directa la tasa de paro con el cobro de la Renta de Garantía de Ingresos (RGI).
*   **Periodo:** 2003 - 2025.
*   **Enlace:** [Open Data Euskadi - RGI y Paro](https://opendata.euskadi.eus/catalogo/-/porcentaje-perceptores-de-rgi-y-parados-registrados/)

#### [Fuente 09] Población en Riesgo de Pobreza y/o Exclusión Social (Tasa AROPE)
*   **Descripción:** Porcentaje total de población bajo el umbral de vulnerabilidad AROPE.
*   **Periodo:** 2015 - 2022.
*   **Enlace:** [Open Data Euskadi - Tasa AROPE](https://opendata.euskadi.eus/catalogo/-/poblacion-riesgo-pobreza-o-exclusion-porcentaje-total-poblacion/)

#### [Fuente 10] Personas en Riesgo o Situación de Pobreza y/o Exclusión (Código 0306)
*   **Descripción:** Datos del indicador 0306 sobre situación de riesgo extremo.
*   **Periodo:** 2008 - 2024.

#### [Fuente 11] Evolución de la Tasa de Riesgo de Pobreza sobre la Población Total
*   **Descripción:** Histórico del porcentaje de población total en riesgo.
*   **Periodo:** 2000 - 2024.
*   **Enlace:** [Open Data Euskadi - Evolución Tasa Pobreza](https://opendata.euskadi.eus/catalogo/-/estadistica/porcentaje-de-poblacion-en-riesgo-de-pobreza-o-exclusion-sobre-el-total-de-la-poblacion/)

---

### 🏫 Bloque D: Educación y Modelos Lingüísticos

#### [Fuente 05] Escolarización vs. Modelos Lingüísticos (A, B, D)
*   **Descripción:** Datos de actividad escolar por porcentaje de alumnos matriculados en cada modelo lingüístico (D, B, A).
*   **Periodo:** 1983 - 2025.
*   **Enlace:** [Eustat - Estadística de la Actividad Escolar](https://es.eustat.eus/estadisticas/tema_68/opt_1/tipo_6/ti_estadistica-de-la-actividad-escolar/temas.html)

#### [Fuente 08] Tasas de Analfabetismo
*   **Descripción:** Niveles de analfabetismo en población de 10 años o más en la C.A. de Euskadi, segmentada por edad y sexo.
*   **Periodo:** 2013 - 2022.
*   **Enlace:** [Open Data Euskadi - Tasas de Analfabetismo](https://opendata.euskadi.eus/catalogo/-/tasas-de-analfabetismo-de-la-poblacion-de-10-y-mas-anos-de-euskadi-por-la-edad-segun-el-sexo/eustat011171/)

#### [Fuente 12] Modelos Lingüísticos en Centros No Universitarios
*   **Descripción:** Datos de frecuencia mensual sobre los modelos lingüísticos impartidos en el sistema educativo no universitario.
*   **Periodo:** 2012 - 2026.
*   **Enlace:** [Open Data Euskadi - Modelos Lingüísticos en Centros](https://opendata.euskadi.eus/catalogo/-/modelos-linguisticos-impartidos-en-los-centros-docentes-no-universitarios-de-euskadi/)

---

### 🏠 Bloque E: Vivienda y Alquiler (Alokabide / Etxebide)

#### [Fuente 13] Registro de Contratos de ALOKABIDE S.A.
*   **Descripción:** Historial de contratos gestionados por la sociedad pública de alquiler. Nota: Existe información desde 2017 a través del buscador general.
*   **Periodo:** Datos actualizados del año 2026.
*   **Enlaces:**
    *   [Open Data Euskadi - Buscador general de Alokabide](https://opendata.euskadi.eus/catalogo-datos/?r01kQry=tC:euskadi;tT:estadistica,ds_geograficos,ds_recursos_turisticos,ds_localizaciones,ds_ayudas_subvenciones,ds_contrataciones,ds_recursos_linguisticos,ds_economicos,ds_movilidad,ds_informes_estudios,ds_meteorologicos,ds_registros,ds_rrhh,ds_eventos,ds_elecciones,ds_juridicos,ds_noticias,ds_aplicaciones,ds_autorizaciones,ds_premios_concursos,ds_procedimientos_otros,ds_general;m:documentLanguage.EQ.es,OpendataEstadistic.IN.(0,1);mO:documentName.LIKE.Alokabide,documentDescription.LIKE.Alokabide;pp:r01PageSize.10;p:Inter_portal,Inter&r01SearchEngine=meta)
    *   [Open Data Euskadi - Contratos Alokabide 2026](https://opendata.euskadi.eus/catalogo/-/registro-contratos-alokabide-sociedad-alquiler-s-del-2026/)

#### [Fuente 14] Indicadores de Etxebide y Alquiler Social

*   **Viviendas Protegidas (VPO) adjudicadas por Etxebide:** Ratio por cada 1,000 habitantes en el último quinquenio.
    *   [Enlace Open Data](https://opendata.euskadi.eus/catalogo/-/indicadores-municipales-de-sostenibilidad-viviendas-protegidas-vpo-adjudicadas-por-etxebide-en-el-ultimo-quinquenio-x2030-habitantes/)
*   **Eficiencia de adjudicación Etxebide (2018 - 2025):** Viviendas adjudicadas en el último trienio por cada 100 solicitudes inscritas.
    *   [Enlace Open Data](https://opendata.euskadi.eus/catalogo/-/indicadores-municipales-de-sostenibilidad-viviendas-adjudicadas-por-etxebide-en-el-ultimo-trienio-por-cada-100-solicitudes-inscritas/)
*   **Características de Hogares en Alquiler (2024):** Cruce de datos por superficie útil, antigüedad, tipo de edificio, registro en Etxebide, ayudas de alquiler recibidas y tamaño del municipio.
    *   [Enlace Open Data](https://opendata.euskadi.eus/catalogo/-/hogares-alquiler-c-euskadi-superficie-util-vivienda-antiguedad-otros-elementos-y-tipo-edificio-tipo-alquiler-registro-etxebide-percepcion-ayudas-al-alquiler-y-tamano-municipio-p/)
*   **Finanzas del Alquiler y Esfuerzo Familiar (2026):** Análisis de renta mensual, porcentaje de ingresos del hogar destinados al pago del alquiler e ingresos medios. Segmentado por Territorio Histórico, tipo de alquiler, registro en Etxebide y percepción de ayudas.
    *   [Enlace Open Data](https://opendata.euskadi.eus/catalogo/-/hogares-regimen-alquiler-c-euskadi-renta-mensual-alquiler-porcentaje-ingresos-destinados-al-alquiler-ingresos-medios-del-hogar-renta-mensual-media-y-porcentaje-medios-ingresos-destinados-al-alquiler-/territorio-historico-tipo-alquiler-registro-etxebide-y-percepcion-ayudas-al-alquiler/)

---

### 🏥 Bloque F: Salud, Sociosanitario y Seguridad Social

#### [Fuente 15] Consumo de Sustancias y Test de Alcoholemia

*   **Tasa de consumo reciente de sustancias por grupos de edad (2012):**
    *   [Enlace Open Data](https://opendata.euskadi.eus/catalogo/-/tasa-de-consumo-reciente-de-diversas-sustancias-en-la-c-a-de-euskadi-por-grupos-de-edad/)
*   **Resultados de la población en el test CAGE sobre trastorno por consumo de alcohol (2012):**
    *   [Enlace Open Data](https://opendata.euskadi.eus/catalogo/-/distribucion-de-la-poblacion-de-la-c-a-de-euskadi-en-funcion-de-los-resultados-del-test-cage/)
*   **Evolución quinquenal del consumo de sustancias (2012 - 2016):**
    *   [Enlace Open Data](https://opendata.euskadi.eus/catalogo/-/evolucion-tasas-consumo-reciente-diversas-sustancias-c-euskadi/)

#### [Fuente 16] Sostenibilidad, Discapacidad y Centros de Día

*   **Tasa de afiliación a la Seguridad Social por pensionista (Indicador de sostenibilidad municipal):**
    *   [Enlace Open Data](https://opendata.euskadi.eus/catalogo/-/indicadores-municipales-sostenibilidad-tasa-afiliacion-seguridad-social-pensionista/)
*   **Personas usuarias de centros de día asistenciales para personas con discapacidad (2018 - 2023):** Desglose por edad, sexo, territorio histórico y titularidad del centro (público/privado %).
    *   [Enlace Open Data](https://opendata.euskadi.eus/catalogo/-/personas-usuarias-centros-dia-asistenciales-personas-discapacidad-servicios-sociales-c-euskadi-grupo-edad-y-sexo-territorio-historico-y-titularidad/)
*   **Personas con Valoración de Discapacidad (Código 0202):** Histórico 2008 - 2024.
*   **Personas con Discapacidad (Código 0302):** Histórico 2008 - 2024.

---

### 📚 Anuarios Estadísticos Generales (Multitemáticos)
Herramientas útiles para contextualizar series históricas muy largas:
*   **Anuario Estadístico Vasco (Periodo completo, 1982 - 2022):** [Eustat - Anuarios](https://es.eustat.eus/estadisticas/tema_1/opt_1/tipo_3/ti_anuario-estadistico-vasco/temas.html)
*   **Informes y Documentos Históricos de Euskadi:** [Eustat - Informes](https://es.eustat.eus/estadisticas/tema_72/opt_0/tipo_3/ti_informes-y-documentos/temas.html)


***


# SESION 2, Entorno de trabajo  - [2026 JUL, 14] 


* Previo a UD 6, guías sobre interfaz y objetos visuales (06-001, 06-002).
* Para poder trabajar en la plataforma, hay que empezar a trabajar las fases iniciales de un proyecto Big Data, las que implican **recolecar datos**, **limpiar y adecuar datos**.
* Esta sesión tratará de desarrollar estos pasos iniciales, también afianzar aspectos técnicos de la plataforma (PowerBI Desktop, PowerBI online)
* **RECOMENDADO**:	Se está usando una cuenta gratuíta de PowerBI. Como las cuentas exponen públicamente todos los datos a todos aquellos que usen el mismo subdominio, se está usando una cuenta del mail corporativo de mi propia web.


## 🛠️ Enlaces y Notas de Desarrollo de Power BI

*   **Acceso al entorno Cloud:** [Portal Web de Power BI](https://app.powerbi.com/home?redirectedFromSignup=1&experience=power-bi)


*    Power BI Desktop funciona de forma totalmente autónoma y gratuita sin necesidad de tener una cuenta activa o de pago (en entornos locales).

- **Cloud**:
	![](./img/06-000-01.png)
	
- **Desktop**:
![](./img/06-000-01.png)

*  Recomendable trabajar de forma paralela tanto en la **versión Web (Servicio)** como en **Power BI Desktop** utilizando el mismo proyecto. Esto servirá para identificar y comparar posibles discrepancias o limitaciones entre ambas interfaces, las cuales deberían ser mínimas.


### PRIMERAS PREGUNTAS QUE QUISIERA PODER RESPONDER Y VISUALIZAR

* ¿Qué relación hay entre el reparto de la riqueza, la criminalidad, la empleabilidad, la inclusión social, en una región-periodo temporal determinado?

* ¿Cuánto influye la alfabetización (incluso la relativa a modelos lingüísticos ) respecto a la inclusión social, laboral, de las personas?

* ¿Existe alguna relación entre la tasa de desempleo, la exclusión social y la salud mental tomando como factor la alfabetización? ¿Aquellos que hace 20-30 años siguieron unos itinerarios educativos, u otros, cómo se encuentran a día de hoy?

