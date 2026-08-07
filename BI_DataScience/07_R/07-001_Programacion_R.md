# 07-001:	 Programación `R`

> **R** es un **lenguaje de programación** y un **entorno de desarrollo** especializado en **análisis de datos**, **visualización** y **modelado estadístico**.

![](./img/07-001.png)
---

## 👨‍💻 Origen

R fue desarrollado en **1993** por:

- **Ross Ihaka**
- **Robert Gentleman**

📍 **Universidad de Auckland (Nueva Zelanda)**

Su objetivo fue crear una herramienta **libre**, **gratuita** y **de código abierto** para la comunidad científica e investigadora.

---

## Fundamentos Teóricos de `R` y su Rol en Business Intelligence (BI)

---

###	1.	Naturaleza y Arquitectura del Lenguaje `R`

R es un **lenguaje interpretado**, diseñado específicamente para:

- 📈 Cálculo estadístico
- 📊 Data Mining
- 📉 Visualización gráfica
- 🤖 Ciencia de datos

Su diseño deriva del lenguaje **S**, heredando un paradigma principalmente **funcional**, aunque también incorpora **programación orientada a objetos** mediante varios sistemas:

- **S3**
- **S4**
- **R6**

> 💡 A diferencia de lenguajes de propósito general como **Python** o **C++**, R fue concebido **desde su origen** para el análisis estadístico y el tratamiento eficiente de datos.

---

### 	Estructuras de datos principales

#### 	Vectores

La estructura básica de R.

- Todos los elementos son del mismo tipo.
- Permiten operaciones **vectorizadas**, evitando bucles explícitos.

Ejemplo conceptual:

```text
[2,4,6] + [1,1,1]  =  [3,5,7]
```

---

####	Matrices

Colecciones bidimensionales de datos homogéneos.

Ideales para:

- Álgebra lineal
- Estadística
- Machine Learning

---

####	Data Frames

La estructura más utilizada en análisis de datos.

Características:  

- 📋 Organización tabular.
- Cada columna puede contener un tipo distinto de dato.
- Equivalente conceptual a una **tabla relacional** de una base de datos.

Ejemplo:

| ID | Nombre | Edad | Salario |
|---:|---------|-----:|---------:|
| 1 | Ana | 29 | 32000 |
| 2 | Luis | 41 | 48000 |

---

####	Factores (*Factors*)

Tipo de dato específico para variables **categóricas**.

Ejemplos:

- Sexo
- Provincia
- Estado civil
- Nivel educativo

Facilitan numerosos análisis estadísticos.

---

###	2.	Ecosistema de Extensión: CRAN

#### 🌐 ¿Qué es CRAN?

**CRAN (Comprehensive R Archive Network)** es el repositorio oficial de paquetes de R.

Es una red mundial de servidores que permite instalar miles de librerías desarrolladas por la comunidad.

> ⭐ La enorme cantidad de paquetes disponibles es uno de los mayores puntos fuertes del lenguaje R.

---

#### 📦 Paquetes más importantes

### 🌟 Tidyverse

Conjunto de paquetes diseñados bajo una filosofía común para trabajar con datos.

Incluye herramientas como:

- **dplyr** → Manipulación de datos.
- **tidyr** → Limpieza y reorganización.
- **ggplot2** → Visualización.
- **readr** → Importación de datos.

---

### 🤖 Modelado Predictivo

R dispone de numerosas librerías para Inteligencia Artificial y análisis predictivo.

Entre las más utilizadas destacan:

- **caret**
- **tidymodels**
- **forecast**

Permiten desarrollar modelos como:

- 📈 Regresión
- 🌳 Clasificación
- ⏳ Series temporales
- 🔍 Análisis exploratorio

---

###	3.	Integración de R en Business Intelligence y Power BI

En entornos modernos de **Business Intelligence (BI)**, R actúa como un potente **motor de analítica avanzada** que complementa tecnologías como:

- SQL
- DAX
- Modelos Tabulares
- Modelos Multidimensionales

---

####	Integración nativa con Power BI

Power BI permite ejecutar scripts escritos en **R** de forma integrada.

Esto amplía enormemente sus capacidades analíticas.

---

####	Transformación e Ingesta de Datos (Power Query)

R puede utilizarse durante el proceso **ETL (Extract, Transform, Load)**.

Permite realizar transformaciones que resultan complejas o imposibles únicamente con **Power Query (M)** o **DAX**.

Algunos ejemplos:

- Limpieza avanzada de datos
- Imputación de valores nulos
- Transformaciones estadísticas
- Procesamiento de grandes conjuntos de datos

---

####	Visualización Avanzada

Power BI puede utilizar el motor gráfico de R para generar visualizaciones mediante librerías como:

- **ggplot2**
- **plotly**

Esto permite construir gráficos mucho más sofisticados que los visuales estándar.

Ejemplos:

- 📊 Diagramas de dispersión avanzados
- 🔥 Mapas de calor (*Heatmaps*)
- 🌳 Dendrogramas
- 🎻 Gráficos de violín
- 📈 Visualizaciones estadísticas personalizadas

---

####	Modelado Predictivo y Machine Learning

Power BI también puede ejecutar modelos de análisis desarrollados en R.

Entre las técnicas más habituales se encuentran:

- 🎯 Clustering (**K-Means**)
- 📈 Predicción de demanda (**ARIMA**, **Prophet**)
- 😊 Análisis de sentimiento
- 🤖 Modelos de Machine Learning

Una gran ventaja es que estos modelos pueden ejecutarse sobre los datos filtrados por el propio informe, integrando los resultados directamente en cuadros de mando interactivos.

---
