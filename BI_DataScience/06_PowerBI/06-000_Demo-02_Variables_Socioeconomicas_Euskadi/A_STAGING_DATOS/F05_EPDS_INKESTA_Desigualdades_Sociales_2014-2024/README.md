# Encuesta de Pobreza y Desigualdades Sociales (EPDS)

- SOURCE: https://www.euskadi.eus/encuesta-de-pobreza-y-desigualdades-sociales-epds/web01-s2enple/es/

---

## Por tablas disponibles

### Últimas tablas estadísticas realizadas:

- Tablas estadísticas de la Encuesta de Pobreza y Desigualdades Sociales (EPDS) 2024

### Tablas estadísticas anteriores:

- Tablas estadísticas del módulo de EPDS-Pobreza de la Encuesta de Necesidades Sociales 2022 
- Tablas estadísticas de la Encuesta de Pobreza y Desigualdades Sociales (EPDS) 2020
- Tablas estadísticas del Módulo EPDS-Pobreza de la Encuesta de Necesidades Sociales 2018
- Tablas estadísticas de la Encuesta de Pobreza y Desigualdades Sociales (EPDS) 2016

---

### 2014

- Tablas estadísticas del módulo EPDS-Pobreza de la Encuesta de Necesidades Sociales 2014
XLSX (109.74 KB) - 1. Pobreza y precariedad en la dimension de mantenimiento (ingresos disponibles).xlsx
XLSX (103.11 KB) - 2. Pobreza y precariedad en la dimension de acumulacion.xlsx
XLSX (82.91 KB) - 3. Indicadores sinteticos de pobreza y precariedad real.xlsx
XLSX (148.91 KB) - 4. Situaciones de pobreza y de precariedad segun variables socio-demograficas.xlsx
**XLSX (87.51 KB) - 5. Situaciones de pobreza y de precariedad por territorio historico y comarca.xlsx**
XLSX (80.09 KB) - 6. Indicadores de desigualdad.xlsx

---

### 2016

**XLSX (87.51 KB) - 5. Situaciones de pobreza y de precariedad por territorio historico y comarca.xlsx**

---

### 2018

Completo

---

### 2020

Completo

---

### 2022

Completo

---

### 2024

Completo


---

## Por Valor del Dato

## Eje Central de la Correlación Multivariante

La pobreza y la exclusión social constituyen el principal nexo de unión entre:

- **Desempleo** (Bloque B)
- **Acceso a la vivienda** (Bloque E)
- **Educación** (Bloque D)
- **Criminalidad** (Bloque A)

Podrían cruzarse directamente el perfil de los hogares vulnerables con:

- Tasas de criminalidad
- Recepción de ayudas sociales
- Otros indicadores socioeconómicos del proyecto

---

## Ventana Temporal del Rango Núcleo

Las ediciones disponibles de la EPDS:

- 2014
- 2016
- 2018
- 2020
- 2022
- 2024

encajan perfectamente con el **Rango Núcleo (2012–2022)** definido en la Sesión 2 y permiten extender el análisis de forma consistente hasta **2024**.

Al ser encuestas **bianuales**, proporciona una periodicidad adecuada para estudiar tendencias sin introducir el exceso de variabilidad que presentan muchos indicadores anuales.

---

## Riqueza de Segmentación (Más allá del dato macro)

A diferencia de los indicadores generales de desempleo, la EPDS ofrece un elevado nivel de desagregación, incluyendo variables como:

- Tipología de hogar
- Presencia de menores
- Nivel educativo alcanzado
- Origen de la población

Esta información aporta una gran profundidad analítica y resulta especialmente útil para:

- Relacionar pobreza con alfabetización y nivel educativo
- Analizar diferencias entre perfiles de hogares
- Integrar modelos lingüísticos y variables educativas
- Enriquecer el modelo

---

# Por Estructura de los Datos

## Estructura Multihoja

Múltiples hojas, normalmente organizadas por temática:

- Hogares
- Personas
- Tipos de pobreza
- Intensidad de la exclusión
- Otras tablas estadísticas

Será necesario inspeccionar previamente los nombres de las hojas (`xls.sheet_names`) para seleccionar únicamente aquellas que mantengan la granularidad:

> **Territorio Histórico × Año**

---

## Formato "Ancho" vs. "Largo"

Las tablas de Eustat suelen distribuir los años en columnas (formato **ancho**).

Para integrarlas correctamente en el área de *staging*, será necesario aplicar una transformación de:

- **Anular dinamización de columnas (Unpivot)** en Power Query.
- O la transformación equivalente en Python.

El objetivo es obtener el formato largo normalizado definido para el proyecto:

| TH | Año | Indicador | Valor | Unidad | Fuente_Código |
|----------------------|----:|-----------|------:|---------|----------------|

---

### Otros

1. Hacer **Tabla resumen de pobreza de los hogares por Territorio Histórico y año.**
2. Hacer **Tabla de intensidad de la exclusión social por Territorio Histórico y año.**

Estas dos tablas proporcionan una base sólida para comenzar el análisis y podrán ampliarse posteriormente con nuevas dimensiones si el modelo lo requiere.
