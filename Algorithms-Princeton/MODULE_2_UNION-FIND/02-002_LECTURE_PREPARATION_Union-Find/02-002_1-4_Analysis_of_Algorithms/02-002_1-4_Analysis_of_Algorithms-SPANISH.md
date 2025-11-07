# 1.4: Análisis de Algoritmos

## Preguntas Fundamentales

A medida que los programadores ganan experiencia utilizando computadoras para resolver problemas difíciles y procesar grandes volúmenes de datos, surgen dos preguntas fundamentales:

- **¿Cuánto tiempo tardará mi programa?**
- **¿Por qué mi programa se queda sin memoria?**

Estas preguntas dependen de muchos factores: propiedades de la computadora, características de los datos y la implementación del algoritmo.  

A pesar de esta complejidad, enfoques directos basados en el **método científico** proporcionan respuestas útiles.

---

## Método Científico para el Análisis de Algoritmos

El método científico se aplica efectivamente para comprender el tiempo de ejecución del programa:

1. **Observar** alguna característica con mediciones precisas
2. **Formular una hipótesis** de un modelo consistente con las observaciones
3. **Predecir** eventos utilizando la hipótesis
4. **Verificar** las predicciones a través de observaciones adicionales
5. **Validar** repitiendo hasta que la hipótesis y las observaciones concuerden

**Principios clave**:
- Los experimentos deben ser **reproducibles** (otros pueden validar los resultados)
- Las hipótesis deben ser **refutables** (demostrablemente incorrectas cuando son erróneas)
- Validamos la consistencia con las observaciones, nunca la corrección absoluta

---

## Observar el Rendimiento del Programa

### Realizar Mediciones Cuantitativas

**Ventaja sobre las ciencias naturales**: Podemos simplemente ejecutar el programa—cada ejecución es un experimento científico que relaciona el programa con el mundo físico.

### Tamaño del Problema y Tiempo de Ejecución

**Observaciones cualitativas**:

1. **El tamaño del problema** caracteriza la dificultad computacional (tamaño de entrada o argumento de línea de comandos)
2. **El tiempo de ejecución aumenta con el tamaño del problema**, pero ¿en cuánto?
3. **El tiempo de ejecución es a menudo relativamente insensible a la entrada en sí**—depende principalmente del tamaño del problema

Cuando esta relación se mantiene, nos enfocamos en cuantificar la relación entre el tamaño del problema y el tiempo de ejecución.

### Ejemplo: ThreeSum

**Problema**: Contar tripletas en N enteros que sumen 0.

```java
public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }
}
```

**Entrada de prueba**: 1Mints.txt (1 millón de enteros aleatorios)

**Pregunta**: ¿Cuántas tripletas suman 0? ¿Cómo se relaciona el tiempo de ejecución con el tamaño del problema N?

---

## Medir el Tiempo de Ejecución

### Tipo de Datos Cronómetro

**Propósito**: Medir el tiempo de ejecución del programa de manera confiable.

```java
public class Stopwatch {
    private final long start;
    
    public Stopwatch() {
        start = System.currentTimeMillis();
    }
    
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
```

**Ventaja clave**: Permite mediciones precisas para la generación de datos experimentales.

### Resultados Experimentales

**Programa DoublingTest**: Genera matrices de entrada aleatoria, duplicando el tamaño en cada paso, midiendo los tiempos de ejecución de ThreeSum.

| N | Tiempo (segundos) |
|---|---|
| 250 | 0.0 |
| 500 | 0.0 |
| 1,000 | 0.1 |
| 2,000 | 0.8 |
| 4,000 | 6.4 |
| 8,000 | 51.1 |

---

## Analizar Datos Experimentales

### Análisis en Gráfico Log-Log

Graficar datos en **escala log-log** revela una **línea recta con pendiente 3**, sugiriendo:

$$\lg(T(N)) = 3 \lg N + \lg a$$

Equivalente a:

$$T(N) = a N^3$$

**Resolviendo para *a***: Usando T(8000) = 51.1 segundos:
$$a = 9.98 \times 10^{-11}$$

**Modelo predictivo**:
$$T(N) = 9.98 \times 10^{-11} \cdot N^3$$

**Predicción**: T(16,000) ≈ 408.8 segundos (≈ 6.8 minutos). Real: 409.3 segundos.

---

## Modelos Matemáticos

### Perspectiva de Knuth

A pesar de los factores complicadores, es posible construir modelos matemáticos que describan el tiempo de ejecución del programa.

**Dos factores primarios determinan el tiempo de ejecución total**:

1. **Coste de ejecutar cada instrucción** (propiedad de computadora/compilador/SO)
2. **Frecuencia de ejecución de cada instrucción** (propiedad del programa/entrada)

Multiplicar frecuencias por costes y sumar para todas las instrucciones produce el tiempo de ejecución.

### Aproximaciones con Tilde

Los análisis de frecuencia producen expresiones matemáticas complejas. **La notación tilde (~)** simplifica ignorando términos de orden inferior:

**Definición**: $g(N) \sim f(N)$ indica que $g(N)/f(N) \to 1$ conforme $N \to \infty$.

**Ejemplo**: 
$$\frac{N^3}{6} - \frac{N^2}{2} - \frac{N}{3} \sim \frac{N^3}{6}$$

**Aproximaciones típicas con tilde**:

| Función | Aproximación Tilde | Orden de Crecimiento |
|---------|------------------|-------------------|
| $N^3/6 - N^2/2 - N/3$ | $\sim N^3/6$ | $N^3$ |
| $N^2/2 - N/2$ | $\sim N^2/2$ | $N^2$ |
| $\lg N + 1$ | $\sim \lg N$ | $\lg N$ |
| $3$ | $\sim 3$ | $1$ |

### Órdenes de Crecimiento Comunes

| Orden | Descripción | Función |
|-------|---|----------|
| 1 | Constante | Constante |
| $\lg N$ | Logarítmico | Logaritmo binario |
| $N$ | Lineal | Lineal |
| $N \lg N$ | Linealítmico | Divide y conquista |
| $N^2$ | Cuadrático | Bucles anidados |
| $N^3$ | Cúbico | Triple bucle anidado |
| $2^N$ | Exponencial | Búsqueda exhaustiva |

---

## Anatomía del Análisis de ThreeSum

**Frecuencias de instrucción**:

| Instrucción | Bloque | Frecuencia | Tiempo Total |
|----------|--------|-----------|-----------|
| E: `cnt++` | $t_0$ | *x* (dependiente de entrada) | $t_0 x$ |
| D: prueba `if` | $t_1$ | $N^3/6 - N^2/2 - N/3$ | $t_1(N^3/6 - N^2/2 - N/3)$ |
| C: `for k` | $t_2$ | $N^2/2 - N/2$ | $t_2(N^2/2 - N/2)$ |
| B: `for j` | $t_3$ | $N$ | $t_3 N$ |
| A: `for i` | $t_4$ | $1$ | $t_4$ |

**Total general** (asumiendo *x* pequeño):
$$\sim \frac{t_1}{6} N^3$$

**Orden de crecimiento**: $N^3$

**Bucle interno**: Las instrucciones ejecutadas más frecuentemente dominan el tiempo de ejecución.

---

## Modelos de Coste y Proposiciones

### Modelo de Coste

Un **modelo de coste** define operaciones básicas para algoritmos que resuelven problemas específicos.

**Ejemplo (3-suma)**: Contar **accesos a matriz** (lecturas/escrituras).

### Proposición B

**El algoritmo de fuerza bruta para 3-suma utiliza $\sim N^3/2$ accesos a matriz.**

**Prueba**: El algoritmo accede a 3 números para cada una de $\sim N^3/6$ tripletas.
$$3 \times \frac{N^3}{6} = \frac{N^3}{2}$$

---

## Desarrollar Modelos de Tiempo de Ejecución

**Pasos**:

1. **Desarrollar modelo de entrada** (definición de tamaño del problema)
2. **Identificar el bucle interno** (instrucciones ejecutadas con mayor frecuencia)
3. **Definir modelo de coste** (operaciones en el bucle interno)
4. **Determinar frecuencia de ejecución** (análisis matemático requerido)

### Ejemplo de Búsqueda Binaria

- **Modelo de entrada**: Matriz de tamaño N
- **Bucle interno**: Instrucciones de un solo bucle while
- **Modelo de coste**: Operación de comparación
- **Análisis**: Como máximo $\lg N + 1$ comparaciones

### Ejemplo de Lista Blanca

- **Modelo de entrada**: N números en lista blanca, M números de entrada estándar (M >> N)
- **Bucle interno**: Bucle while en búsqueda binaria
- **Modelo de coste**: Operación de comparación
- **Análisis**: Como máximo $M(\lg N + 1)$ comparaciones
- **Orden de crecimiento**: $M \lg N$

---

## Clasificaciones de Orden de Crecimiento

### Tiempo Constante - 1

```java
a = b + c;
```

El programa ejecuta operaciones fijas; el tiempo de ejecución es independiente de N.

### Logarítmico - lg N

```java
// Búsqueda binaria (véase página 47)
```

Apenas más lento que constante. La base del logaritmo es irrelevante para el orden de crecimiento.

### Lineal - N

```java
double max = a[0];
for (int i = 1; i < N; i++)
    if (a[i] > max) max = a[i];
```

Tiempo constante por elemento de entrada. El tiempo de ejecución es proporcional a N.

### Linealítmico - N lg N

```java
// Mergesort (Algoritmo 2.4)
// Quicksort (Algoritmo 2.5)
```

Prototípico: algoritmos de divide y conquista.

### Cuadrático - N²

```java
for (int i = 0; i < N; i++)
    for (int j = i+1; j < N; j++)
        if (a[i] + a[j] == 0)
            cnt++;
```

Dos bucles anidados procesando todos los pares.

### Cúbico - N³

```java
for (int i = 0; i < N; i++)
    for (int j = i+1; j < N; j++)
        for (int k = j+1; k < N; k++)
            if (a[i] + a[j] + a[k] == 0)
                cnt++;
```

Tres bucles anidados (p. ej., ThreeSum).

### Exponencial - 2^N

Extremadamente lento; impracticable para N grande. Crítico en teoría de algoritmos.

---

## Diseñar Algoritmos Más Rápidos

### Problema de 2-Suma

**Fuerza bruta**: Cuadrático ($N^2$)

**Solución más rápida**: Ordenar, luego búsqueda binaria para complementos.

```java
public class TwoSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            if (BinarySearch.rank(-a[i], a) > i)
                cnt++;
        return cnt;
    }
}
```

**Tiempo de ejecución**: $N \lg N$ (ordenamiento) + $N \lg N$ (búsquedas binarias) = $N \lg N$

### Problema de 3-Suma

**Fuerza bruta**: Cúbico ($N^3$)

**Solución más rápida**: Ordenar, luego para cada par, búsqueda binaria del complemento.

```java
public class ThreeSumFast {
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                if (BinarySearch.rank(-a[i]-a[j], a) > j)
                    cnt++;
        return cnt;
    }
}
```

**Tiempo de ejecución**: $N^2 \lg N$

### Comparación

| Algoritmo | Complejidad Temporal |
|-----------|-----------------|
| TwoSum | $N^2$ |
| TwoSumFast | $N \lg N$ |
| ThreeSum | $N^3$ |
| ThreeSumFast | $N^2 \lg N$ |

---

## Experimentos de Duplicación de Proporción

**Atajo simple** para predecir rendimiento y determinar el orden de crecimiento:

1. **Desarrollar generador de entrada** (modelo de entrada realista)
2. **Ejecutar programa DoublingRatio** (calcula proporción de tiempos de ejecución consecutivos)
3. **Ejecutar hasta que las proporciones se aproximen al límite** $2^b$

**Conclusiones**:
- Orden de crecimiento ≈ $N^b$
- Predecir tiempos de ejecución futuros multiplicando el último tiempo por $2^b$

### Ejemplo (ThreeSum)

| N | Tiempo (s) | Proporción |
|---|----------|-------|
| 250 | 0.0 | 2.7 |
| 500 | 0.0 | 4.8 |
| 1,000 | 0.1 | 6.9 |
| 2,000 | 0.8 | 7.7 |
| 4,000 | 6.4 | 8.0 |
| 8,000 | 51.1 | 8.0 |
| 16,000 | 408.8 | 8.0 |
| 32,000 | 3,270.4 | 8.0 |
| 64,000 | 26,163.2 | 8.0 |

**La proporción se aproxima a 8** → Orden de crecimiento ≈ $N^3$ (ya que $2^3 = 8$)

### Proposición C (Proporción de Duplicación)

Si $T(N) \sim a N^b \lg N$, entonces:
$$T(2N)/T(N) \sim 2^b$$

---

## Predicción de Rendimiento

### Viabilidad de Problemas Grandes

**Pregunta**: ¿Resolverá mi programa este problema en tiempo razonable?

**Respuesta**: Usar el orden de crecimiento para extrapolar.

**Ejemplo** (el programa tarda pocas horas para N):

| Orden | Función | Tiempo para 10N | Tiempo (10x más rápido) |
|-------|----------|-------------|------------------|
| Lineal | $N$ | Un día | Pocas horas |
| Linealítmico | $N \lg N$ | Un día | Pocas horas |
| Cuadrático | $N^2$ | Pocas semanas | Un día |
| Cúbico | $N^3$ | Varios meses | Pocas semanas |
| Exponencial | $2^N$ | Nunca | Nunca |

### Consideración de la Ley de Moore

**Ley de Moore**: ~2x velocidad cada 18 meses, ~10x cada 5 años.

**Problema**: No se puede mantenerse el ritmo con algoritmos cuadráticos/cúbicos:
- Cuadrático: computadora 2x más rápida → resolver problemas ~$\sqrt{2}$x más grandes
- Cúbico: computadora 2x más rápida → resolver problemas $\sqrt[3]{2}$x más grandes
- La prueba de duplicación de proporción determina si el algoritmo es cuadrático/cúbico (proporción ≠ 2)

---

## Advertencias y Consideraciones

### Constantes Grandes

Ignorar coeficientes constantes puede engañar si las constantes son grandes (p. ej., $c = 10^6$).

### Bucle Interno No Dominante

La suposición de que el bucle interno domina puede fallar; el modelo de coste puede necesitar refinamiento.

### Variación del Tiempo de Instrucción

Los sistemas modernos utilizan **caché**; acceder a elementos en matrices enormes toma más tiempo si no son contiguos.

### Consideraciones del Sistema

Múltiples programas compiten por recursos; los resultados pueden no ser reproducibles.

### Dependencia de la Entrada

El tiempo de ejecución puede variar ampliamente según la entrada. La modificación de ThreeSum ("¿existe la tripleta?") varía de constante a cúbica.

### Múltiples Parámetros del Problema

Los algoritmos a menudo tienen múltiples parámetros. Ejemplo: la lista blanca tiene tanto N (tamaño de lista blanca) como M (tamaño de entrada).

---

## Manejo de la Dependencia de la Entrada

### Modelos de Entrada

**Enfoque**: Modelar el tipo de entrada cuidadosamente.

**Desafíos**:
- El modelo puede ser poco realista
- El análisis puede ser matemáticamente difícil

### Garantías de Rendimiento de Caso Peor

**Enfoque**: Vista pesimista—¿cuál es el tiempo de ejecución en el peor caso?

**Aplicaciones**: Reactores nucleares, marcapasos, frenos de vehículos (riesgo de falla catastrófica).

**Proposición D**: Las implementaciones de lista vinculada de Bag, Stack, Queue tienen operaciones de **caso peor en tiempo constante**.

### Algoritmos Aleatorizados

**Enfoque**: Introducir aleatoriedad para garantías probabilísticas.

**Ejemplos**:
- **Quicksort**: Caso peor cuadrático, pero linealítmico con aleatorización
- **Dispersión (Hashing)**: Caso peor lineal, pero tiempo constante probabilísticamente

Garantías: Probabilidad de falla < probabilidad de que la computadora sea alcanzada por un rayo.

### Análisis Amortizado

**Enfoque**: Distribuir el coste de operación cara entre muchas operaciones.

**Ejemplo**: Stack de matriz redimensionable—un único push puede tomar tiempo lineal, pero el promedio es constante.

**Proposición E**: Stack de matriz redimensionable tiene **accesos a matriz promedio constante** por operación.

---

## Análisis de Memoria

### Tipos Primitivos

| Tipo | Bytes |
|------|-------|
| boolean | 1 |
| byte | 1 |
| char | 2 |
| int | 4 |
| float | 4 |
| long | 8 |
| double | 8 |

### Objetos

**Memoria = sobrecarga de objeto (16 bytes) + variables de instancia + relleno (múltiplo de 8)**

**Ejemplos**:
- `Integer`: 24 bytes
- `Date` (3 int): 32 bytes
- `Counter` (referencia String + int): 32 bytes

### Listas Vinculadas

**Node** (clase interna): 40 bytes (16 sobrecarga + 8 extra + 8 referencia de artículo + 8 referencia siguiente)

**Stack de N Enteros**: 32 + 64N bytes

### Matrices

| Tipo | Memoria |
|------|---------|
| `int[N]` | ~4N |
| `double[N]` | ~8N |
| `Date[N]` | ~40N |
| `double[M][N]` | ~8MN |

### Cadenas de Caracteres

**Objeto String**: 40 bytes (sobrecarga + 3 ints + referencia de matriz)

**String de longitud N**: 64 + 2N bytes

**Subcadena**: 40 bytes (reutiliza matriz de caracteres)

---

## Perspectiva

### Equilibrar Rendimiento y Claridad

**Error más común**: Optimización prematura excesiva.

**Sabiduría**: *"La optimización prematura es la raíz de todo mal"* — C.A.R. Hoare

**Orden de prioridades**:
1. **Código claro y correcto**
2. **Optimización de rendimiento** (solo si beneficio significativo)

### Cuándo Optimizar

**Ignorar rendimiento** si:
- El tiempo de ejecución es insignificante (pocos segundos)
- El coste de desarrollo del algoritmo mejorado supera el ahorro de tiempo de ejecución

**Perseguir optimización** si:
- El algoritmo de fuerza bruta cuadrático se ejecuta durante días
- Alternativa lineal/linealítmica disponible
- Manejo de tamaños de problema enormes

---

## Resumen

**Conclusión clave**: Comprender el **orden de crecimiento** le permite predecir el rendimiento del programa, comprender las limitaciones computacionales y tomar decisiones informadas sobre algoritmos.

Combinar el **método científico** (experimentos), **análisis matemático** (modelos de coste) y **validación empírica** proporciona un marco poderoso para el análisis de algoritmos y la optimización de programas.
