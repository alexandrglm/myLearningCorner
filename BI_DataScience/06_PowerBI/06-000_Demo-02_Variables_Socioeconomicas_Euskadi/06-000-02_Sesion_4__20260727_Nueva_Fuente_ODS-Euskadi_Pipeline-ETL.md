# SESIÓN 4 - [2026 JUL, 27]


---
## Objetivos de la sesión

- Importación de datos, y diseño del pipeline ETL, para comenzar a trabajar en minado, ltransofrmación, limpieza, adecuación.

-	Tras definir en la sesión anterior la arquitectura general del proyecto y el modelo de datos, esta sesión se centra en construir el **primer proceso ETL completo** sobre una fuente de datos masiva y homogénea (diseñar un proceso de extracción, transformación y limpieza), que sea:
	* Escalable
	* Reutilizable
	* Automatizable
	* Fácilmente mantenible

---

## Nuevo hallazgo: Indicadores ODS Euskadi

-  [**Indicadores de la Agenda 2030 de Euskadi**](https://sdg.eustat.eus/es/)

A diferencia de muchas otras fuentes de Eustat, donde gran parte de la información aparece en tablas dinámicas o visualizaciones, esta plataforma ofrece directamente los datos originales en formato **CSV**, siguiendo la codificación oficial de los Objetivos de Desarrollo Sostenible (ODS).

Este descubrimiento cambia completamente la estrategia inicial del proyecto.

### Ventajas

* Los datos se encuentran ya estructurados.
* Existe un CSV independiente por cada indicador.
* La nomenclatura sigue el estándar internacional de los ODS.
* Resulta muy sencillo automatizar futuras actualizaciones.
* Permite construir un pipeline ETL completamente reproducible.

### Inconvenientes

* Multitud de datos desagregados que requieren comprender de antemano el futuro uso-enfoque a la hora de aplicarlos.

### Backup de Indicadores ODS, Mapa
La colección está formada aproximadamente por:

* **173 archivos CSV**
* Un archivo por indicador ODS.
* Rango años fijo para todos los valoes, 2010~2023

| Código ODS | Indicador |
|---|---|
| 1-1-1 | Proporción de la población que vive por debajo del umbral internacional de pobreza, desglosada por sexo, edad, situación laboral y ubicación geográfica (urbana o rural) |
| 1-2-1 | Proporción de la población que vive por debajo del umbral nacional de pobreza, desglosada por sexo y edad |
| 1-2-2 | Proporción de hombres, mujeres y niños/as de todas las edades que viven en la pobreza, en todas sus dimensiones, con arreglo a las definiciones nacionales |
| 1-3-1 | Proporción de la población cubierta por sistemas o niveles mínimos de protección social, desglosada por sexo, distinguiendo entre los niños/as, las personas desempleadas, los ancianos/as, las personas con discapacidad, las mujeres embarazadas, los recién nacidos/as, las víctimas de accidentes de trabajo, las personas pobres y las personas vulnerables |
| 1-4-1 | Proporción de la población que vive en hogares con acceso a los servicios básicos |
| 1-4-2 | Proporción del total de la población adulta con derechos seguros de tenencia de la tierra |
| 1-5-1 | Número de personas muertas, desaparecidas y afectadas directamente atribuido a desastres por cada 100.000 habitantes |
| 1-5-2 | Pérdidas económicas directas atribuidas a los desastres en relación con el producto interno bruto (PIB) mundial |
| 1-5-3 | Número de países que adoptan y aplican estrategias nacionales de reducción del riesgo de desastres en consonancia con el Marco de Sendái |
| 1-5-4 | Proporción de gobiernos locales que adoptan y aplican estrategias locales de reducción del riesgo de desastres en consonancia con las estrategias nacionales |
| 1-a-1 | Total de subvenciones de asistencia oficial para el desarrollo destinadas a la reducción de la pobreza en porcentaje de la renta nacional bruta del país beneficiario |
| 1-a-2 | Proporción del gasto público total que se dedica a servicios esenciales (educación, salud y protección social) |
| 1-b-1 | Gasto público social en favor de las personas pobres |
| 2-1-1 | Prevalencia de la subalimentación |
| 2-1-2 | Prevalencia de la inseguridad alimentaria moderada o grave entre la población, según la escala de experiencia de inseguridad alimentaria |
| 2-2-1 | Prevalencia del retraso del crecimiento entre las y los niños menores de 5 años |
| 2-2-2 | Prevalencia de la malnutrición entre las y los niños menores de 5 años, desglosada por tipo (emaciación y sobrepeso) |
| 2-2-3 | Prevalencia de la anemia en las mujeres de entre 15 y 49 años, desglosada por embarazo |
| 2-2-4 | Prevalencia del umbral mínimo de diversidad alimentaria, por grupo de población |
| 2-2-E1 | Tasa de obesidad de la población adulta según el índice de masa corporal (IMC) (Indicador UE sdg_02_10) |
| 2-3-1 | Volumen de producción por unidad de trabajo desglosado por tamaño y tipo de explotación (agropecuaria/ganadera/forestal) |
| 2-3-2 | Media de ingresos de los productores de alimentos en pequeña escala, desglosada por sexo y condición indígena |
| 2-4-1 | Proporción de la superficie agrícola en que se practica una agricultura productiva y sostenible |
| 2-4-E1 | Superficie dedicada a la agricultura ecológica (Indicador UE sdg_02_40) |
| 2-4-E2 | Emisiones de amoníaco de la agricultura y ganadería (Indicador UE sdg_02_60) |
| 2-5-1 | Número de recursos genéticos vegetales y animales para la alimentación y la agricultura preservados en instalaciones de conservación |
| 2-5-2 | Proporción de razas y variedades locales consideradas en riesgo de extinción |
| 2-a-1 | Índice de orientación agrícola para el gasto público |
| 2-a-2 | Total de corrientes oficiales de recursos destinado al sector agrícola |
| 2-b-1 | Subsidios a la exportación de productos agropecuarios |
| 2-c-1 | Indicador de anomalías en los precios de los alimentos |
| 3-1-1 | Tasa de mortalidad materna |
| 3-1-2 | Proporción de partos atendidos por personal sanitario especializado |
| 3-2-1 | Tasa de mortalidad de niños/as menores de 5 años |
| 3-2-2 | Tasa de mortalidad neonatal |
| 3-3-1 | Número de nuevas infecciones por el VIH por cada 1.000 habitantes no infectados/as, desglosado por sexo, edad y poblaciones clave |
| 3-3-2 | Incidencia de la tuberculosis por cada 100.000 habitantes |
| 3-3-3 | Incidencia de la malaria por cada 1.000 habitantes |
| 3-3-4 | Incidencia de la hepatitis B por cada 100.000 habitantes |
| 3-3-5 | Número de personas que requieren intervenciones contra enfermedades tropicales desatendidas |
| 3-4-1 | Tasa de mortalidad atribuida a las enfermedades cardiovasculares, el cáncer, la diabetes o las enfermedades respiratorias crónicas |
| 3-4-2 | Tasa de mortalidad por suicidio |
| 3-4-E1 | Tasa de participación en los programas de cribado poblacional de cáncer (Indicador Gobierno Vasco) |
| 3-4-E2 | Esperanza de vida al nacer (Indicador Gobierno Vasco) |
| 3-5-1 | Cobertura de los tratamientos de trastornos por abuso de sustancias adictivas |
| 3-5-2 | Consumo de alcohol per cápita (a partir de los 15 años) durante un año civil en litros de alcohol puro |
| 3-6-1 | Tasa de mortalidad por lesiones debidas a accidentes de tráfico |
| 3-7-1 | Proporción de mujeres en edad de procrear que cubren sus necesidades de planificación familiar con métodos modernos |
| 3-7-2 | Tasa de fecundidad de las adolescentes (entre 10 y 14 años y entre 15 y 19 años) por cada 1.000 mujeres de ese grupo de edad |
| 3-8-1 | Cobertura de los servicios de salud esenciales |
| 3-8-2 | Proporción de la población con grandes gastos sanitarios por hogar como porcentaje del total de gastos o ingresos de los hogares |
| 3-9-1 | Tasa de mortalidad atribuida a la contaminación de los hogares y del aire ambiente |
| 3-9-2 | Tasa de mortalidad atribuida al agua insalubre, el saneamiento deficiente y la falta de higiene |
| 3-9-3 | Tasa de mortalidad atribuida a intoxicaciones involuntarias |
| 3-a-1 | Prevalencia del consumo actual de tabaco a partir de los 15 años de edad |
| 3-b-1 | Proporción de la población inmunizada con todas las vacunas incluidas en cada programa nacional |
| 3-b-2 | Total neto de asistencia oficial para el desarrollo destinado a los sectores de la investigación médica y la atención sanitaria básica |
| 3-b-3 | Índice de acceso a los productos sanitarios |
| 3-c-1 | Densidad y distribución del personal sanitario |
| 3-d-1 | Capacidad prevista en el Reglamento Sanitario Internacional (RSI) y preparación para emergencias de salud |
| 3-d-2 | Porcentaje de infecciones del torrente sanguíneo debidas a determinados organismos resistentes a los antimicrobianos |
| 4-1-1 | Proporción de niños/as y adolescentes que han alcanzado al menos un nivel mínimo de competencia en lectura y matemáticas, desglosada por sexo |
| 4-1-2 | Tasa de finalización (educación primaria, secundaria inferior y secundaria superior) |
| 4-1-E1 | Tasa de abandono escolar prematuro de la población de 18-24 años (Indicador UE sdg_04_10) |
| 4-2-1 | Proporción de niños/as de 24 a 59 meses cuyo desarrollo es adecuado en cuanto a la salud, el aprendizaje y el bienestar psicosocial |
| 4-2-2 | Tasa de participación en el aprendizaje organizado (un año antes de la edad oficial de ingreso en la educación primaria), desglosada por sexo |
| 4-3-1 | Tasa de participación de personas jóvenes y adultas en la educación y formación académica y no académica en los últimos 12 meses |
| 4-4-1 | Proporción de personas jóvenes y adultas con competencias en tecnología de la información y las comunicaciones (TIC) |
| 4-5-1 | Índices de paridad para todos los indicadores de educación de esta lista que puedan desglosarse |
| 4-6-1 | Proporción de la población en un grupo de edad determinado que ha alcanzado al menos un nivel fijo de competencia funcional en alfabetización y aritmética |
| 4-7-1 | Grado en que la educación para la ciudadanía mundial y para el desarrollo sostenible se incorporan en las políticas nacionales de educación |
| 4-a-1 | Proporción de escuelas que ofrecen servicios básicos, desglosada por tipo de servicio |
| 4-b-1 | Volumen de la asistencia oficial para el desarrollo destinada a becas |
| 4-c-1 | Proporción de docentes con las calificaciones mínimas requeridas, desglosada por nivel educativo |
| 5-1-1 | Determinar si existen o no marcos jurídicos para promover, hacer cumplir y supervisar la igualdad y la no discriminación por razón de sexo |
| 5-2-1 | Proporción de mujeres y niñas a partir de 15 años que han sufrido violencia física, sexual o psicológica a manos de su pareja en los últimos 12 meses |
| 5-2-2 | Proporción de mujeres y niñas a partir de 15 años que han sufrido violencia sexual a manos de personas que no eran su pareja en los últimos 12 meses |
| 5-3-1 | Proporción de mujeres de entre 20 y 24 años que estaban casadas o mantenían una unión estable antes de cumplir los 15 años y antes de cumplir los 18 años |
| 5-3-2 | Proporción de niñas y mujeres de entre 15 y 49 años que han sufrido mutilación genital femenina |
| 5-4-1 | Proporción de tiempo dedicado al trabajo doméstico y asistencial no remunerado, desglosada por sexo, edad y ubicación |
| 5-5-1 | Proporción de escaños ocupados por mujeres en los parlamentos nacionales y los gobiernos locales |
| 5-5-2 | Proporción de mujeres en cargos directivos |
| 5-6-1 | Proporción de mujeres de entre 15 y 49 años que toman sus propias decisiones informadas sobre las relaciones sexuales, el uso de anticonceptivos y la atención de la salud reproductiva |
| 5-6-2 | Número de países con leyes y reglamentos que garantizan el acceso pleno e igualitario a los servicios de salud sexual y reproductiva |
| 5-a-1 | Proporción de la población agrícola con derechos de propiedad o derechos seguros sobre tierras agrícolas, desglosada por sexo |
| 5-a-2 | Proporción de países cuyo ordenamiento jurídico garantiza la igualdad de derechos de la mujer a la propiedad o el control de las tierras |
| 5-b-1 | Proporción de personas que poseen un teléfono móvil, desglosada por sexo |
| 5-c-1 | Proporción de países con sistemas para el seguimiento de la igualdad de género y el empoderamiento de las mujeres |
| 6-1-1 | Proporción de la población que utiliza servicios de suministro de agua potable gestionados sin riesgos |
| 6-2-1 | Proporción de la población que utiliza servicios de saneamiento gestionados sin riesgos y de lavado de manos con agua y jabón |
| 6-3-1 | Proporción de los flujos de aguas residuales domésticas e industriales tratados de manera adecuada |
| 6-3-2 | Proporción de masas de agua de buena calidad |
| 6-4-1 | Cambio en el uso eficiente de los recursos hídricos con el paso del tiempo |
| 6-4-2 | Nivel de estrés hídrico: extracción de agua dulce en proporción a los recursos de agua dulce disponibles |
| 6-5-1 | Grado de gestión integrada de los recursos hídricos |
| 6-5-2 | Proporción de la superficie de cuencas transfronterizas sujetas a arreglos operacionales para la cooperación en materia de aguas |
| 6-6-1 | Cambio en la extensión de los ecosistemas relacionados con el agua con el paso del tiempo |
| 6-a-1 | Volumen de la asistencia oficial para el desarrollo destinada al agua y el saneamiento |
| 6-b-1 | Proporción de dependencias administrativas locales que han establecido políticas para la participación de las comunidades locales en la gestión del agua y el saneamiento |
| 7-1-1 | Proporción de la población que tiene acceso a la electricidad |
| 7-1-2 | Proporción de la población cuya fuente primaria de energía son los combustibles y tecnologías limpios |
| 7-2-1 | Proporción de energía renovable en el consumo final total de energía |
| 7-3-1 | Intensidad energética medida en función de la energía primaria y el PIB |
| 7-a-1 | Corrientes financieras internacionales hacia los países en desarrollo para apoyar la investigación y el desarrollo de energías limpias |
| 7-b-1 | Capacidad instalada de generación de energía renovable en los países en desarrollo y en los países desarrollados (vatios per cápita) |
| 8-1-1 | Tasa de crecimiento anual del PIB real per cápita |
| 8-2-1 | Tasa de crecimiento anual del PIB real por persona empleada |
| 8-3-1 | Proporción de empleo informal con respecto al empleo total, desglosada por sector y sexo |
| 8-4-1 | Huella material en términos absolutos, huella material per cápita y huella material por PIB |
| 8-4-2 | Consumo material interno en términos absolutos, per cápita y por PIB |
| 8-5-1 | Ingreso medio por hora de las personas empleadas, desglosado por sexo, edad, ocupación y discapacidad |
| 8-5-2 | Tasa de desempleo, desglosada por sexo, edad y personas con discapacidad |
| 8-5-E1 | Tasa de ocupación de la población (Indicador UE sdg_08_30) |
| 8-6-1 | Proporción de jóvenes (entre 15 y 24 años) que no cursan estudios, no están empleados/as ni reciben capacitación |
| 8-7-1 | Proporción y número de niños/as de entre 5 y 17 años que realizan trabajo infantil |
| 8-8-1 | Lesiones ocupacionales mortales y no mortales por cada 100.000 trabajadores |
| 8-8-2 | Nivel de cumplimiento nacional de los derechos laborales (libertad de asociación y negociación colectiva) |
| 8-9-1 | PIB generado directamente por el turismo en proporción al PIB total y a la tasa de crecimiento |
| 8-9-2 | Personas empleadas en el sector del turismo |
| 8-10-1 | Número de sucursales de bancos comerciales y cajeros automáticos por cada 100.000 personas adultas |
| 8-10-2 | Proporción de adultos/as que tienen una cuenta en un banco u otra institución financiera |
| 8-a-1 | Compromisos y desembolsos en relación con la iniciativa Ayuda para el Comercio |
| 8-b-1 | Existencia de una estrategia nacional organizada y en marcha para el empleo de las personas jóvenes |
| 9-1-1 | Proporción de la población rural que vive a menos de 2 km de una carretera transitable todo el año |
| 9-1-2 | Volumen de transporte de pasajeros y carga, desglosado por medio de transporte |
| 9-2-1 | Valor añadido del sector manufacturero en proporción al PIB y per cápita |
| 9-2-2 | Empleo del sector manufacturero en proporción al empleo total |
| 9-3-1 | Proporción del valor añadido total del sector industrial correspondiente a las pequeñas industrias |
| 9-3-2 | Proporción de las pequeñas industrias que han obtenido un préstamo o una línea de crédito |
| 9-4-1 | Emisiones de CO2 por unidad de valor añadido |
| 9-4-E1 | Intensidad de las emisiones atmosféricas de la industria manufacturera (Indicador UE sdg_09_70) |
| 9-5-1 | Gastos en investigación y desarrollo en proporción al PIB |
| 9-5-2 | Número de personas investigadoras (equivalente a tiempo completo) por cada millón de habitantes |
| 9-a-1 | Total de apoyo internacional oficial destinado a la infraestructura |
| 9-b-1 | Proporción del valor añadido por la industria de tecnología mediana y alta en el valor añadido total |
| 9-c-1 | Proporción de la población con cobertura de red móvil, desglosada por tecnología |
| 10-1-1 | Tasas de crecimiento per cápita de los gastos o ingresos de los hogares del 40% más pobre de la población y la población total |
| 10-2-1 | Proporción de personas que viven por debajo del 50% de la mediana de los ingresos |
| 10-3-1 | Proporción de la población que declara haberse sentido personalmente discriminada o acosada en los últimos 12 meses |
| 10-4-1 | Proporción del PIB generada por el trabajo |
| 10-4-2 | Impacto redistributivo de la política fiscal en el índice de Gini |
| 10-5-1 | Indicadores de solidez financiera |
| 10-6-1 | Proporción de miembros y derechos de voto de los países en desarrollo en organizaciones internacionales |
| 10-7-1 | Costo de la contratación sufragado por el empleado/a en proporción a los ingresos mensuales percibidos en el país de destino |
| 10-7-2 | Proporción de países que han aplicado políticas migratorias bien gestionadas |
| 10-7-3 | Número de personas muertas o desaparecidas en el proceso de migración hacia un destino internacional |
| 10-7-4 | Proporción de la población integrada por refugiados/as, desglosada por país de origen |
| 10-a-1 | Proporción de líneas arancelarias que se aplican a las importaciones de los países menos adelantados y los países en desarrollo con arancel cero |
| 10-b-1 | Corrientes totales de recursos para el desarrollo |
| 10-c-1 | Costo de las remesas en proporción a las sumas remitidas |
| 11-1-1 | Proporción de la población urbana que vive en barrios marginales, asentamientos informales o viviendas inadecuadas |
| 11-2-1 | Proporción de la población que tiene fácil acceso al transporte público |
| 11-3-1 | Relación entre la tasa de consumo de tierras y la tasa de crecimiento de la población |
| 11-3-2 | Proporción de ciudades que cuentan con una estructura de participación directa de la sociedad civil en la planificación y gestión urbanas |
| 11-4-1 | Total de gastos per cápita destinados a la preservación, protección y conservación de todo el patrimonio cultural y natural |
| 11-5-1 | Número de personas muertas, desaparecidas y afectadas directamente atribuido a desastres por cada 100.000 personas |
| 11-5-2 | Pérdidas económicas directas atribuidas a los desastres en relación con el producto interno bruto (PIB) mundial |
| 11-5-3 | Daños en la infraestructura crítica y número de interrupciones de los servicios básicos, atribuidos a desastres |
| 11-6-1 | Proporción de residuos sólidos municipales recogidos y administrados en instalaciones controladas |
| 11-6-2 | Niveles medios anuales de partículas finas en suspensión (PM2.5 y PM10) en las ciudades |
| 11-7-1 | Proporción media de la superficie edificada de las ciudades que se dedica a espacios abiertos para uso público |
| 11-7-2 | Proporción de personas que han sido víctimas de acoso no sexual o sexual en los últimos 12 meses |
| 11-a-1 | Número de países que cuentan con políticas urbanas nacionales o planes de desarrollo regionales |
| 11-b-1 | Número de países que adoptan y aplican estrategias nacionales de reducción del riesgo de desastres |
| 11-b-2 | Proporción de gobiernos locales que adoptan y aplican estrategias locales de reducción del riesgo de desastres |
| 11-c-1 | Total de asistencia oficial para el desarrollo destinados a infraestructuras urbanas, por sector |
| 12-1-1 | Número de países que elaboran, adoptan o aplican instrumentos de política destinados a apoyar la transición hacia modalidades de consumo y producción sostenibles |
| 12-2-1 | Huella material en términos absolutos, huella material per cápita y huella material por PIB |
| 12-2-2 | Consumo material interno en términos absolutos, per cápita y por PIB |
| 12-3-1 | Índice de pérdidas de alimentos e índice de desperdicio de alimentos |
| 12-4-1 | Número de partes en los acuerdos ambientales multilaterales sobre desechos peligrosos y otros productos químicos |
| 12-4-2 | Desechos peligrosos generados per cápita y proporción de desechos peligrosos tratados |
| 12-5-1 | Tasa nacional de reciclado, en toneladas de material reciclado |
| 12-6-1 | Número de empresas que publican informes sobre sostenibilidad |
| 12-7-1 | Número de países que aplican políticas y planes de acción sostenibles en materia de adquisiciones públicas |
| 12-8-1 | Grado en que la educación para la ciudadanía mundial y el desarrollo sostenible se incorporan en las políticas nacionales de educación |
| 12-a-1 | Capacidad instalada de generación de energía renovable en los países en desarrollo y en los países desarrollados |
| 12-b-1 | Aplicación de instrumentos normalizados de contabilidad para hacer un seguimiento de la sostenibilidad del turismo |
| 12-c-1 | Cuantía de los subsidios a los combustibles fósiles (producción y consumo) por unidad del PIB |
| 13-1-1 | Número de personas muertas, desaparecidas y afectadas directamente atribuido a desastres por cada 100.000 personas |
| 13-1-2 | Número de países que adoptan y aplican estrategias nacionales de reducción del riesgo de desastres |
| 13-1-3 | Proporción de gobiernos locales que adoptan y aplican estrategias locales de reducción del riesgo de desastres |
| 13-2-1 | Número de países con contribuciones determinadas a nivel nacional, estrategias a largo plazo y planes nacionales de adaptación |
| 13-2-2 | Emisiones totales de gases de efecto invernadero por año |
| 13-3-1 | Grado en que la educación para la ciudadanía mundial y el desarrollo sostenible se incorporan en las políticas nacionales de educación |
| 13-a-1 | Cantidades proporcionadas y movilizadas en dólares al año en relación con el objetivo de movilización colectiva de 100.000 millones de dólares |
| 13-b-1 | Número de países menos adelantados y pequeños Estados insulares en desarrollo con contribuciones determinadas a nivel nacional |
| 14-1-1 | Índice de eutrofización costera y densidad de detritos plásticos |
| 14-2-1 | Número de países que aplican enfoques basados en los ecosistemas para gestionar las zonas marinas |
| 14-3-1 | Acidez media del mar (pH) medida en un conjunto convenido de estaciones de muestreo representativas |
| 14-4-1 | Proporción de poblaciones de peces cuyos niveles son biológicamente sostenibles |
| 14-5-1 | Cobertura de las zonas protegidas en relación con las zonas marinas |
| 14-6-1 | Grado de aplicación de instrumentos internacionales cuyo objetivo es combatir la pesca ilegal, no declarada y no reglamentada |
| 14-7-1 | Proporción del PIB correspondiente a la pesca sostenible |
| 14-a-1 | Proporción del presupuesto total de investigación asignada a la investigación en tecnología marina |
| 14-b-1 | Grado de aplicación de un marco jurídico que proteja los derechos de acceso para la pesca en pequeña escala |
| 14-c-1 | Número de países que avanzan en la ratificación de instrumentos relacionados con la Convención de las Naciones Unidas sobre el Derecho del Mar |
| 15-1-1 | Superficie forestal en proporción a la superficie total |
| 15-1-2 | Proporción de lugares importantes para la biodiversidad terrestre y del agua dulce incluidos en zonas protegidas |
| 15-1-E1 | Superficie de las áreas terrestres protegidas (km2 y porcentaje) (Indicador UE sdg_15_20) |
| 15-2-1 | Avances hacia la gestión forestal sostenible |
| 15-3-1 | Proporción de tierras degradadas en comparación con la superficie total |
| 15-4-1 | Lugares importantes para la biodiversidad de las montañas incluidos en zonas protegidas |
| 15-4-2 | Índice de cobertura verde de las montañas y proporción de terreno montañoso degradado |
| 15-5-1 | Índice de la Lista Roja |
| 15-6-1 | Número de países que han adoptado marcos para asegurar una distribución justa y equitativa de los beneficios de los recursos genéticos |
| 15-7-1 | Proporción de especímenes de flora y fauna silvestre comercializados procedentes de la caza furtiva o el tráfico ilícito |
| 15-8-1 | Proporción de países que han aprobado legislación para la prevención o el control de las especies exóticas invasoras |
| 15-9-1 | Número de países con metas nacionales acordes al Marco Mundial de Biodiversidad de Kunming-Montreal |
| 15-a-1 | Asistencia oficial para el desarrollo destinada a la conservación y el uso sostenible de la biodiversidad |
| 15-b-1 | Asistencia oficial para el desarrollo destinada a la conservación y el uso sostenible de la biodiversidad (gestión forestal) |
| 15-c-1 | Proporción de especímenes de flora y fauna silvestre comercializados procedentes de la caza furtiva o el tráfico ilícito |
| 16-1-1 | Número de víctimas de homicidios intencionales por cada 100.000 habitantes, desglosado por sexo y edad |
| 16-1-2 | Muertes relacionadas con conflictos por cada 100.000 habitantes |
| 16-1-3 | Proporción de la población que ha sufrido violencia física, psicológica o sexual en los últimos 12 meses |
| 16-1-4 | Proporción de la población que se siente segura al caminar sola en su zona de residencia después de que oscurece |
| 16-1-E1 | Población que reporta ocurrencia de delitos, violencia o vandalismo en su área (Indicador UE sdg_16_20) |
| 16-2-1 | Proporción de niños/as de entre 1 y 17 años que han sufrido castigo físico o agresión psicológica a manos de sus cuidadores |
| 16-2-2 | Número de víctimas de la trata de personas por cada 100.000 habitantes |
| 16-2-3 | Proporción de mujeres y hombres jóvenes de entre 18 y 29 años que sufrieron violencia sexual antes de cumplir los 18 años |
| 16-3-1 | Proporción de víctimas de violencia física, psicológica o sexual que han notificado su victimización a las autoridades competentes |
| 16-3-2 | Proporción de personas detenidas que no han sido condenadas en el conjunto de la población reclusa total |
| 16-3-3 | Proporción de la población que ha accedido a algún mecanismo oficial u oficioso de solución de controversias |
| 16-4-1 | Valor total de las corrientes financieras ilícitas entrantes y salientes |
| 16-4-2 | Proporción de armas incautadas, encontradas o entregadas cuyo origen o contexto ilícitos han sido determinados |
| 16-5-1 | Proporción de personas que han pagado un soborno a un funcionario público en los últimos 12 meses |
| 16-5-2 | Proporción de negocios que han pagado un soborno a un funcionario público en los últimos 12 meses |
| 16-6-1 | Gastos primarios del gobierno en proporción al presupuesto aprobado originalmente |
| 16-6-2 | Proporción de la población que se siente satisfecha con su última experiencia de los servicios públicos |
| 16-7-1 | Proporciones de plazas en las instituciones nacionales y locales en comparación con la distribución nacional |
| 16-7-2 | Proporción de la población que considera que la adopción de decisiones es inclusiva y responde a sus necesidades |
| 16-8-1 | Proporción de miembros y derechos de voto de los países en desarrollo en organizaciones internacionales |
| 16-9-1 | Proporción de niños/as menores de 5 años cuyo nacimiento se ha registrado ante una autoridad civil |
| 16-10-1 | Número de casos verificados de asesinato, secuestro, desaparición forzada, detención arbitraria y tortura de periodistas y defensores/as de los derechos humanos |
| 16-10-2 | Número de países que adoptan y aplican garantías para el acceso público a la información |
| 16-a-1 | Existencia de instituciones nacionales independientes de derechos humanos, en cumplimiento de los Principios de París |
| 16-b-1 | Proporción de la población que declara haberse sentido personalmente discriminada o acosada en los últimos 12 meses |
| 17-1-1 | Total de ingresos del gobierno en proporción al PIB, desglosado por fuente |
| 17-1-2 | Proporción del presupuesto nacional financiado por impuestos internos |
| 17-2-1 | Asistencia oficial para el desarrollo neta, total y para los países menos adelantados, en proporción al INB de los donantes del CAD-OCDE |
| 17-3-1 | Recursos financieros adicionales movilizados para los países en desarrollo procedentes de múltiples fuentes |
| 17-3-2 | Volumen de remesas (en dólares de los Estados Unidos) en proporción al PIB total |
| 17-4-1 | Servicio de la deuda en proporción a las exportaciones de bienes, servicios e ingresos primarios |
| 17-5-1 | Número de países que adoptan y aplican sistemas de promoción de las inversiones en favor de los países en desarrollo |
| 17-6-1 | Número de abonados/as a servicios de banda ancha fija por cada 100 habitantes, desglosado por velocidad |
| 17-7-1 | Total de los fondos destinados a promover el desarrollo, la transferencia y la difusión de tecnologías ecológicamente racionales |
| 17-8-1 | Proporción de personas que utilizan Internet |
| 17-9-1 | Valor en dólares de la asistencia oficial para el desarrollo comprometida para los países en desarrollo |
| 17-10-1 | Promedio arancelario mundial ponderado |
| 17-11-1 | Participación de los países en desarrollo y los países menos adelantados en las exportaciones mundiales |
| 17-12-1 | Promedio ponderado de los aranceles que enfrentan los países en desarrollo y los países menos adelantados |
| 17-13-1 | Tablero macroeconómico |
| 17-14-1 | Número de países que cuentan con mecanismos para mejorar la coherencia de las políticas de desarrollo sostenible |
| 17-15-1 | Grado de utilización de los marcos de resultados y las herramientas de planificación de los propios países |
| 17-16-1 | Número de países que informan de sus progresos en los marcos de múltiples interesados para el desarrollo sostenible |
| 17-17-1 | Suma en dólares prometida a las alianzas público-privadas centradas en la infraestructura |
| 17-18-1 | Indicadores de la capacidad estadística |
| 17-18-2 | Número de países cuya legislación nacional sobre estadísticas cumple los Principios Fundamentales de las Estadísticas Oficiales |
| 17-18-3 | Número de países que cuentan con un plan estadístico nacional plenamente financiado y en proceso de aplicación |
| 17-19-1 | Valor en dólares de todos los recursos proporcionados para fortalecer la capacidad estadística de los países en desarrollo |
| 17-19-2 | Proporción de países que han realizado un censo de población y vivienda en los últimos diez años y registrado nacimientos y defunciones |



---

### Deriva del Proyecto

Inicialmente la intención era importar únicamente los indicadores útiles para el proyecto.  
  
  
Pero, n lugar de seleccionar únicamente algunos indicadores, se construirá un **repositorio completo de los Indicadores ODS Euskadi**, que convivirá en paralelo con el proyecto principal.

Esto permitirá:

* Conservar todos los indicadores originales
* Reutilizar posteriormente cualquier indicador adicional
* Facilitar futuras ampliaciones
* Disponer de un proyecto independiente exclusivamente dedicado a los ODS

---

## Organización inicial del trabajo

Se construye un Excel auxiliar dividido en dos partes.

### 1. Hoja Mapa (`Test_ODS_2030_EUSKADI_BBDD_completo.xlsx`)

Se crea una tabla maestra donde se recopila:

* Archivo origen
* ODS Código
* ODS Grupo Num
* ODS Grupo Nombre
* ODS Indicador Título
* Año Inicio disponible
* Año Fin dispoonible


Esta hoja actuará posteriormente como **tabla de referencia durante todo el proceso ETL**.

---

### 2. Importación completa de los CSV

- Cada CSV se importa en una hoja independiente del mismo libro Excel.

- Las hojas reciben como nombre el mismo código ODS.

- Con ello se conserva una copia íntegra del dato original antes de cualquier transformación.

---

## Filosofía del ETL

El objetivo **no** consiste en limpiar manualmente los 173 indicadores.

El objetivo consiste en diseñar un sistema que permita:

* Importar automáticamente nuevos lotes de CSV
* Aplicar siempre las mismas reglas de transformación
* Automatizar los procesos de adquisición y transformación para facilitar futuras actualizaciones

Si en el futuro Eustat publica un nuevo lote de indicadores, basta con  sustituir los CSV originales para regenerar automáticamente todo el modelo.

---

## Flujo general del proceso ETL


1.	De CSV originales
2.	Crear Mapa de Indicadores
3.	Importar PowerBi + Power Query
4.	Transformación y limpieza
5.	Modelo homogéneo alcanzado
6.	Investigación y Análisis, PowerBI

---

### Modelo de datos objetivo

La granularidad mínima continúa siendo la definida en sesiones anteriores:

```text
Territorio Histórico × Año
```

Jerarquía territorial:
1. 	Municipio
2. 	Comarca
3. 	Territorio Histórico
3. 	Euskadi Total


---

## Detalle del proceso ETL

### Adquisición

Se ofrecen todos los datos, actualizados a 22 Jul 2026, en Eustat:

- Source:	https://sdg.eustat.eus/sdg-data-prod/es/zip/all_indicators.zip

#### Creación del Mapa_Indicadores

- Python:

	- Obtener un listado completo de ODS / Indicadores
	- Matriz o diccionario, objetos codigos ODS, indicadores títulos, grupos ODS
	- Extraer el número de Objetivo ODS (primer dígito antes del primer guion)
	- Mapeo del código clave para buscar su descripción
	- Extraer Año Inicio y Año Fin leyendo de cada CVS
	- Exportar a un Excel con pandas

#### Añadir todo CSV a Mapa_Indicadores

Aunque finalmente se usarán con CVS's por separado en PowerBi, para tener una "gran tabla con todo", por conservación se añaden todos los CSV's/hoja a Mapa_Indicadores

- Escribir cada CSV en su propia hoja usando de nomnbre el ODS Código, con pandas



### Comienzo de ETL, PowerBI

Primeros pasos:

* Importar la hoja **Mapa**
* Importar automáticamente todos los CSV desde una carpeta
* Construir una única consulta con todos los indicadores

---

### Relación automática con el mapa

Utilizando el nombre del archivo (`Source.Name`) se vincula automáticamente cada consulta con la tabla de indicadores.

Resultado:  

- CSV -> ODS Código -> Indicador

---

### Eliminación de columnas auxiliares

Eliminar las siguientes columnas:

* Attributes
* Folder Path
* Fecha de creación
* Fecha de acceso

---

# Transformaciones realizadas

## Series

La columna **Series** pasa a denominarse:

```text
Subcategoría
```

Cuando el valor sea NULL:

```text
(Total absoluto de su rango temporal)
```

---

## Territorio Histórico

Transformaciones:

- NULL -> (Euskadi Total, Agregado null)


- Valores en blanco -> (Euskadi Total, Agregado En Blanco)

Pendiente validar:


`Territorios Históricos =  Euskadi Totales por agregados`

---

## Comarca

Se decide agrupar todas las comarcas a su Territorio Histórico correspondiente.

Proceso:

* Crear columna temporal `TH_TMP`.
* Aplicar correspondencias mediante Power Query

```powerquery
if List.Contains({
    "Arabako Errioxa / Rioja Alavesa",
    "Arabako Kantaurialdea / Cantábrica Alavesa",
    "Arabako Lautada / Llanada Alavesa",
    "Arabako Mendialdea / Montaña Alavesa",
    "Añana (comarca)",
    "Gorbeialdea / Estribaciones del Gorbea"
}, [Comarca]) then "Araba/Álava"
else if List.Contains({
    "Bilbo Handia / Gran Bilbao",
    "Durangaldea / Duranguesado",
    "Enkartazioak / Encartaciones",
    "Gernika-Bermeo",
    "Markina-Ondarroa",
    "Plentzia-Mungia",
    "Arratia Nerbioi / Arratia-Nervión"
}, [Comarca]) then "Bizkaia"
else if List.Contains({
    "Tolosaldea",
    "Donostialdea",
    "Goierri",
    "Urola Kosta",
    "Bidasoa Beherea / Bajo Bidasoa",
    "Debabarrena / Bajo Deba",
    "Debagoiena / Alto Deba"
}, [Comarca]) then "Gipuzkoa"
else [Territorio histórico]
```
* Eliminar la columna original.
* Renombrar `TH_TMP`.

Se documenta igualmente una versión equivalente desarrollada posteriormente mediante DAX. La sintáxis DAX es la hostia, pero sólo después del ETL, en ejecución del modelo.

---

## Magnitud (Units)

- NULLs -> (Sin Unidad Asociada)

---

## Valor

- No modificar. Decisión importante:

**Nunca convertir automáticamente los valores según el tipo de unidad.**

Especialmente importante para indicadores lógicos (`1`, `-1`) que deben conservarse exactamente igual.

Todos los valores vienen númericos en origen por algo.

---

## Sexo

Patrón observado:

Cuando el indicador representa el total de la magnitud correspondiente, el campo aparece en blanco.

Se deja pendiente seguir estudiando este comportamiento.

---

# Tipado definitivo de columnas

| Columna              | Tipo          |
| -------------------- | ------------- |
| Fecha Actualización  | Fecha         |
| Año                  | Número entero |
| Territorio Histórico | Texto         |
| Comarca              | Texto         |
| Magnitud             | Texto         |
| Valor                | Decimal       |
| Edad                 | Texto         |
| Código ODS           | Texto         |

---

# Validación del ETL

Una preocupación importante consiste en asegurar que los registros vacíos proceden realmente del origen y no de errores producidos durante las transformaciones.

Para ello se desarrollan distintas consultas Power Query destinadas a:

* Detectar filas completamente vacías
* Identificar posibles pérdidas de información;
* Verificar que el ETL mantiene intactos los datos originales.

Se implementan consultas auxiliares para detectar automáticamente registros "basura" antes de eliminarlos.

---

# Estructura común obtenida

Tras las transformaciones, todos los indicadores terminan compartiendo una estructura homogénea:

* Código ODS
* Indicador
* Subcategoría
* Fecha actualización
* Año
* Territorio Histórico
* Comarca
* Magnitud
* Valor

junto con numerosas dimensiones opcionales según el indicador:

* Sexo
* Edad
* Nivel educativo
* Grupo de ingresos
* Servicios esenciales
* Ecosistema
* Tecnología
* Actividad económica
* Profesión
* Tipo de vacuna
* Sustancia adictiva
* etc.

Esta homogeneización debería permitir combinar indicadores completamente distintos dentro de un mismo modelo de datos.
**Esto, anticipo, será un lío tremendo al agregar nuevos datos, pero se mantiene por conservación**.

---

# Decisiones temporales de ETL

## Conservar todos los indicadores

Aunque muchos de ellos probablemente no se utilizarán en el proyecto principal, se decide conservarlos todos.

Ventajas:

* reutilización futura;
* conservación histórica;
* posibilidad de construir otros proyectos derivados.

---

## Automatización

La actualización ideal consistiría únicamente en sustituir los CSV originales por una versión más reciente:
- Vía pre-procesado Python
- Vía ETL en PowerBI, Pasos Aplicados optimizados y memorizados

---

## Escalabilidad

Una vez estabilizado este pipeline, podrá reutilizarse prácticamente sin modificaciones para incorporar nuevas fuentes como:

* EPDS
* Servicios Sociales
* Criminalidad
* Vivienda
* Educación
* Empleo
* Salud

---

# Exploración paralela de Power BI

Mientras se desarrolla el ETL también se va explorando con objetos en Power BI, para entender mejor el alcance de la "gran tabla" y "cómo poder usarla"


---

# Estado del proyecto al finalizar la sesión

## Arquitectura

* ✔ Pipeline ETL definido.
* ✔ Flujo de transformación diseñado.
* ✔ Granularidad consolidada.

## Datos

* ✔ Descubierta una nueva fuente masiva de indicadores.
* ✔ Importación de los 173 CSV.
* ✔ Construido el mapa maestro de indicadores.

## Transformación

* ✔ Homogeneización del modelo
* ✔ Normalización territorial
* ✔ Definidas reglas generales de limpieza
* ✔ Diseñado el sistema de validación del ETL

## Cosas Pendientes para futuras sesiones

- Estabilizar el ETL
- Comenzar la exploración analítica en Power BI
