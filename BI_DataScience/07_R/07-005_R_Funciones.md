# 07-005: `R` - Funciones

![](./img/07-008.png)

R viene con muchas funciones incorporadas que pueden ser útiles para realizar tareas como cálculos matemáticos, manipulación de datos, entre otras.

Además, también se puede crear  **funciones personalizadas**. 

Esto es útil para realizar una tarea específica que no está disponible en R u organizar tu código de una manera más clara y legible.

Ejemplo de cómo crear una función personalizada:

---

## Paradigma Funcional y Anatomía de una Función en R

### 1. 	`R` como Lenguaje Funcional (*First-Class Functions*)

En R, las funciones son **objetos de primera clase** (*first-class citizens*).  

Esto significa que una función se trata exactamente igual que cualquier otra variable o dato:

- Se pueden asignar a variables:
  ```r
  mi_fun <- function(...) { ... }
  ```
- Se pueden pasar como argumentos a otras funciones (base de la programación funcional con la familia `apply` o `purrr::map`).
- Pueden ser devueltas como resultado de otras funciones (*closures*).

---

### 2. 	Estructura y Componentes Principales

Toda función personalizada en R se compone de **tres elementos fundamentales**:

| Componente | Descripción |
|---|---|
| **Formals** (Argumentos) | La lista de parámetros de entrada declarados dentro de `function(...)`. R soporta valores por defecto (`function(x, na.rm = TRUE)`) y el argumento especial `...` (*ellipsis*) para pasar parámetros adicionales a funciones internas. |
| **Body** (Cuerpo) | El bloque de código encerrado entre llaves `{ }` que contiene las instrucciones a ejecutar. |
| **Environment** (Entorno) | El contexto de memoria donde la función fue creada, lo que determina cómo resuelve el alcance de sus variables (*lexical scoping*). |

---

#### Ejemplo Práctico

![](./img/07-009.png)

```r
calcula_promedio <- function(x) {
  promedio <- mean(x)
  return(promedio)
}
```

En este ejemplo, se crea una función llamada `calcula_promedio` que toma un vector como argumento y devuelve el promedio de los valores en el vector. La función utiliza la función incorporada `mean()` para calcular el promedio de los valores en el vector `x`.

Para utilizar la función, simplemente se llama y se proporcionan los argumentos necesarios. Por ejemplo, si quieres calcular el promedio de un vector `x`, escribirías `calcula_promedio(x)` en la consola de R y presionarías `Enter`.

---

## Evaluación Perezosa, Retorno Implícito y Uso en Pipelines de BI

### 1. 	Retorno Implícito vs. Explícito

Aunque en el ejemplo se utiliza la palabra clave `return(promedio)`, en la comunidad de desarrollo de R es idiomáticamente común aprovechar el **retorno implícito**:

> R devuelve automáticamente el resultado de la última expresión evaluada dentro del cuerpo de la función.

Escribir simplemente `mean(x)` al final del bloque basta para retornar el valor, sin necesidad de usar `return()` — reservando esta instrucción para salidas anticipadas (*early returns* dentro de estructuras condicionales `if`).

```r
# Estilo idiomático (retorno implícito)
calcula_promedio <- function(x) {
  mean(x)
}
```

---

### 2. Evaluación Perezosa (*Lazy Evaluation*)

Los argumentos de una función en R **no se evalúan cuando se llama a la función**, sino **únicamente cuando se utilizan por primera** vez dentro del código.  

Esto optimiza el rendimiento cuando se manejan estructuras de datos masivas en proyectos de análisis de negocio.

---

### 3. 	Abstracción de Reutilización en Power BI (ETL y *Custom Visuals*)

Cuando trabajas con R dentro del ecosistema de Business Intelligence:

- **Encapsulamiento de Métricas Complejas** 
	Crear funciones personalizadas permite empaquetar algoritmos repetitivos (como limpieza de *outliers* mediante el Rango Intercuartílico o cálculo de métricas financieras a medida) para aplicarlos a múltiples columnas o tablas dentro de `Power Query` sin duplicar código.
	
- **Procesamiento por Grupos** 
	Las funciones personalizadas se integran nativamente con *pipelines* de transformación modular usando `dplyr::group_modify()` o `lapply()`, permitiendo ejecutar modelos de cálculo independientes para distintas unidades de negocio o regiones dentro del mismo modelo tabular.

---

## 	Conexión con Power BI: Funciones como Bloques de Transformación

En un script de R ejecutado desde `Power BI Desktop` (ya sea como paso de `Power Query` o como *visual* de R), las funciones cumplen exactamente el mismo rol que en cualquier proyecto de ciencia de datos: **evitar repetir lógica** y **hacer el pipeline auditable**.

Un patrón habitual es definir una función de limpieza o cálculo que se aplique al `data.frame` recibido desde Power BI (normalmente llamado `dataset`):

```r
# Función reutilizable para tratar outliers mediante el Rango Intercuartílico (IQR)

limpia_outliers <- function(x) {
	q1 <- quantile(x, 0.25, na.rm = TRUE)
	q3 <- quantile(x, 0.75, na.rm = TRUE)
	iqr <- q3 - q1
	x[x < (q1 - 1.5 * iqr) | x > (q3 + 1.5 * iqr)] <- NA
	x
}

# Aplicada sobre una columna del dataset recibido desde Power BI

dataset$ventas_limpias <- limpia_outliers(dataset$ventas)
```

Este mismo enfoque (**definir la función una vez, aplicarla muchas veces**) es lo que permite escalar scripts de R desde un simple cálculo puntual hasta un verdadero componente reutilizable dentro de un modelo de Business Intelligence.