# SESION 3 - [2026 JUL, 26] 

---

## Primeras Fases, Adquisición de Datos

---

## Desde la perspectiva del PERFIL en el proyecto de ciencia de datos:

### INGENIERO DE DATOS
1.   Adquisición de los datos
2.   Almacenamiento
3.   Transformación de los datos
4.   Gestión continua

### ANALISTA DE DATOS
1.  Transforma los datos en INFORMACION DE VALOR

### ARQUITECTO DE BIG DATA
1.  Gestiona el ciclo de vida completo del dato, desde su recolección (Ingeniero), transformación (Analista), hasta su presentación
2.  Coordina a todos los profesionales presentes en el proyecto

### ESPECIALISTA EN IA
1. Desarrolla los algortimos necesarios para el buen uso del dato, fines predictivos, refuerzo de la toma de decisiones
2. Gestión de proyectos con machine learning, Deep Learning

### CIENTIFICO DE DATOS
1. Es profesional y está especializado en la materia concreta.
2.  Estudia, investiga, los datos, con enfoque I+D puro, a diferencia del Analista de Datos.

---

## Desde la Perspectiva de un poryecto de ciencia de datos vs. Contstrucción de Modelo de IA


 1.  PREPARACION DE DATOS
 2.  FEATURE ENGINEERING, EXTRACCION DE CARACTERISTICAS
 3.   MODELADO DE DATOS
 4.  PERFORMANCE MEASUREMENT
 5.  ITERACION y MEJORA

### Por TIPOS DE APRENDIZAJE
![](./img/06-000-03.png)

### Por APRENDIZAJE NO SUPERVIDADO
No aplica. 

### Por APRENDIZAJE SEMI-SUPERVISADO
1. Crar conjunto de datos de entrenamiento con datos etiquetados
2. Insertar datos NO etiquetados
3. Usar el modelo para etiquetar los nuevos datos NO etiquetados
4. Entrenamos al modelo con todo etiquetado, e iteramos

### Por APRENDIZAJE POR REFUERZO


---


## A. Staging previo de Datos

Por fuentes, al ser tan homogéneas:

- Tener distintas orquillas temporales

- Granuralidad territorial compleja (Euskadi Total / Territorio Histórico / Municipio)

Se van a extraer valores en crudo, directamente a Excel o CSV, pensando en poder reusar/importar/convertir los datos tanto para PowerBi como para cualquier otra herramienta:

La idea es tener todas las tablas con identificadores más homogéneos posibles, para poder generar después, unas tablas de DIMESION-AÑO, las cuales podrán trabajarse en PowerBi.

En teoría ... :

### 1.	RECOLECCION:	Una Tabla/fuente

- Un archivo por cada fuente numerada (01, 02.1, 03.1, 04.1...), sin transformar.
- Nombrado: `F01_tasa_criminalidad_eustat.csv`, `F07_rgi_paro.csv`, etc.
- Con URL origen y fecha de descarga, por bloque para trazabilidad.
- Carpeta por bloque temático: `/A_Criminalidad`, `/B_Empleo`, `/C_Pobreza`, `/D_Educacion`, `/E_Vivienda`, `/F_Salud`.


### 2. Definir la Granuralidad Común mínima, el nivel de análisis:

```
T.H. x AÑO
```

- Euskadi, total, como "agregado", útil por contexto
- Municipio -> Hacia arriba hasta Territorio Histórico

- Nivel objetivo: **Araba / Bizkaia / Gipuzkoa × Año**.
- **Euskadi total** --> se conserva como fila `Territorio_Histórico = "EUSKADI (Total)"`, útil solo de contexto/benchmark, pero no para correlación entre territorios.  

- **Municipal** --> agregar (suma o media ponderada por población, según el indicador) hasta Territorio Histórico. Esto es limpieza, pero se documenta la fórmula usada por fuente (no se ejecuta aún en esta fase de staging, pero se anota el criterio).

- **Comarcal** (ej. `Fuente 02.2`) --> Mapear cada comarca a su Territorio Histórico correspondiente antes de agregar.
	
### 3.	Definir el RANGO temporal

Con series desde 198x hasta 202x, se debe fijar una ventana común:

- Ejemplo, 2012~2022, donde más fuentes solapan.
- Tratar el resto de datos como "Contexto histórico", no por "Datos directos relacionados".


- **RANGO NUCLEO: 2012–2022** 
	* Donde más fuentes solapan: criminalidad, RGI/paro, pobreza, analfabetismo, discapacidad, ...

- Fuentes con series más largas (educación 1983-2025, paro 1985-2021, pobreza 1986-2025) se pueedn conservan completas en crudo, pero se etiquetan con una columna `Es_Rango_Nucleo` (TRUE/FALSE) para poder filtrar fácilmente en el modelo.

- Fuentes de un solo año (ej. `Fuente 02.2, 2023`) quedan fuera del análisis de correlación temporal, pero se pueden usar perfectamernte dato puntual de contraste.


### 4. Crear Tabla de Calendario / Dimensiones-Año, independendiente

- Tabla independiente `Dimension_Año`
	* una fila por año, rango 1983–2026 (que cubre el máximo histórico disponible)
	
- Columnas:
	*`Año`
	*`Década`
	* `Es_Rango_Nucleo` (2012-2022 = Sí)

- Esta tabla se relaciona 'n-A-MUCHOS' `1-A-MUCHOS`
	* Con cada tabla de hechos por `Año`
	* **Para EVITAR DUPLICAR la lógica de años en cada bloque**

### 5. Crear un Excel intermedio, por BLOQUE TEMATICO

Un Excel por bloque (Criminalidad, Empleo, Pobreza, Educación, Vivienda, Salud), con estructura homogénea:

| Territorio_Histórico | Año | Indicador | Valor | Unidad | Fuente_Código |
|---|---|---|---|---|---|
| Bizkaia | 2015 | Tasa_criminalidad | 4.2 | ‰ hab. | F01 |
| Araba | 2015 | Tasa_paro | 11.3 | % | F02.3 |

- El **formato largo** (una fila = un dato) es el que mejor importa y pivota Power Query, frente al formato ancho (un año por columna).

- `Indicador` normaliza nombres distintos entre fuentes (ej. "Tasa de criminalidad" vs "Índice de delitos", por lo que:
	1 **HOMOGENEIZAR, USANDO MISMO NOMBRE DE IDENTIFICADOR SI SE MIDE LO MISMO**
	2. Usar nombres distintos si no son comparables.
	
- Aquí SÏ comienza la limpieza real: unidades, decimales, nulos, territorios mal escritos.


###	6.	Importación a PowerBI

- Importación (uno por bloque) + `Dimensio_Año`.

- En Power Query: tipado de columnas, relaciones por `Año` y `Territorio_Histórico`, y creación de una `Dimension_Territorio` (3 filas: Araba, Bizkaia, Gipuzkoa) para separar dimesión de hechos.

- LO IDEAL? Modelo estrella con `Dimension_Año`, `Dimension_Territorio`, y una tabla de hechos por bloque (o una única tabla de hechos larga con columna `Bloque`).


---


# Jerarquía de Bloques de Datos Sesion 3 - 20260724

## /A_Criminalidad

**Descripción:**  
Evolución de la seguridad ciudadana, infracciones penales e índices delictivos.

**Granularidad objetivo:**  
Territorio Histórico × Año (con desagregación municipal/comarcal cuando esté disponible).

### Fuentes clave

- **[A01]** Tasa de criminalidad general (Eustat / Agenda 2030)
- **[A02 ~ A04]** VIOGEN distintos 2015~2025 (Eustat)

PENDIENTES: 
- **[A05]** Estadísticas Delictivas de la Ertzaintza (históricos y trimestrales)
- **[A06]** Indicadores Municipales de Sostenibilidad: Índice de Delitos (‰ habitantes)

---

## /B_Empleo

**Descripción:**  
Dinámicas laborales, desempleo, actividad económica y tejido de ocupación.

**Granularidad objetivo:**  
Territorio Histórico × Año (y comarcal para datos puntuales).

### Fuentes clave


PENDIENTES:   
- **[B01]** Repositorio de Actividad, Ocupación y Paro (Eustat)
- **[B01]** Población Parada Censada (por sexo y nivel formativo)
- **[B03]** Tasas de Actividad y Paro por Comarcas (40 comarcas)
- **[B04]** Actividad, Ocupación y Paro, Serie Histórica (1985–2021)

---

## /C_Pobreza

**Descripción:**  
Indicadores de vulnerabilidad económica, exclusión social, riesgo de pobreza y protección asistencial.

**Granularidad objetivo:**  
Territorio Histórico × Año

### Fuentes clave

PENDIENTES (*Algunas YA han salido en F*) :
- **[C01]** Módulo EPDS – Encuesta de Necesidades Sociales (Eustat)
- **[C02]** Pobreza y Desigualdades Sociales (series desde 1986/2008)
- **[C03]** Porcentaje de Perceptores de RGI y Parados Registrados
- **[C04]** Población en Riesgo de Pobreza y/o Exclusión Social (Tasa AROPE)
- **[C05]** Personas en Riesgo o Situación de Pobreza Extrema (Indicador 0306)
- **[C06]** Evolución de la Tasa de Riesgo de Pobreza sobre la Población Total

---

## /D_Educacion

**Descripción:**  
Niveles de instrucción, escolarización, analfabetismo y distribución de modelos lingüísticos.

**Granularidad objetivo:**  
Territorio Histórico × Año (con series históricas amplias desde los años 80).

### Fuentes clave

PENDIENTES:   
- **[D01]** Escolarización vs. Modelos Lingüísticos (A, B y D) (1983–2025)
- **[D02]** Tasas de Analfabetismo (población de 10 o más años, por edad y sexo)
- **[D03]** Modelos Lingüísticos en Centros No Universitarios

---

## /E_Vivienda

**Descripción:**  
Acceso al alquiler, esfuerzo financiero de los hogares, contratos públicos y políticas de vivienda protegida.

**Granularidad objetivo:**  
Territorio Histórico / Municipal × Año.

### Fuentes clave

PENDIENTES:   
- **[E01]** Registro de Contratos de ALOKABIDE S.A.
- **[E02]** Indicadores de Etxebide:
  - Viviendas protegidas adjudicadas
  - Eficiencia de adjudicación
  - Características de los hogares en alquiler
  - Esfuerzo económico familiar

---

## /F_Salud

**Descripción:**  
Bienestar sociosanitario, consumo de sustancias, dependencia, discapacidad, sostenibilidad de pensiones y recursos de los servicios sociales.

**Granularidad objetivo:**  
Territorio Histórico × Año (1988–2023).

### Fuentes clave

- **[F01]** Personal, Gasto y Financiación de los Servicios Sociales (1988–2023)
- **[F02]** Centros Asistenciales por Población y Tipo de Centro (1994–2023)
- **[F03]** Personas Mayores: Centros, Plazas y Usuarios (1994–2023)
- **[F04]** Discapacidad: Centros, Plazas y Usuarios (1994–2023)
- **[F05]** EPDS – Encuesta de Necesidades Sociales: Desigualdades Sociales (2014–2024)

PENDIENTES:  
- **[F15]** Consumo de Sustancias y Test de Alcoholemia (CAGE)
- **[F16]** Sostenibilidad, Discapacidad, Centros de Día y Afiliación a la Seguridad Social
