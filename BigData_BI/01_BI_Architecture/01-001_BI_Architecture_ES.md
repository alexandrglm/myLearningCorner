# 01-001: ¿Qué es BI - Inteligencia de Negocios?

![](./img/01-001.png)

En una sociedad en donde estamos inundados de datos, las compañías precisan de sistemas que les permitan analizar la ingente cantidad de información y transformarla en algo útil y de valor.

La inteligencia de negocios o Business Intelligence responde, precisamente a esta necesidad, pretendiendo ofrecer modelos predictivos en base a hechos históricos que brinde a las empresas un mejor posicionamiento competitivo y una mayor satisfacción de sus clientes.

---

![](./img/01-002.png)

Este concepto crítico no es nuevo y desde su definición en los años 60, su evolución ha sido constante.

BI no se puede definir como una tecnología o como una herramienta. Su definición es más amplia.

> **Se entiende por Business Intelligence** el conjunto de tecnologías, metodologías y estrategias enfocadas a tratar los datos que tiene una empresa y convertirlos en conocimiento útil que permita tomar mejores decisiones y mejorar su eficacia y competitividad.

---

![](./img/01-004.png)

## Algunas de las Tecnologías que Forman Parte de Business Intelligence

* Origen de los datos
* Carga de datos en un repositorio central
* Transformación de datos
* Extracción de datos
* Data Warehouse
* Minería de datos y modelado
* OLAP - OLTP
* Presentación de la información
* Informes
* Cuadros de mando

---

## Necesidad de la Inteligencia de Negocios

![](./img/01-005.png)
![](./img/01-006.png)

Estas son algunas situaciones en las que la implantación de un sistema de Business Intelligence es necesaria:

1. Toma de decisiones sin fundamento
2. Problemas de comunicación dentro o fuera de la empresa
3. Uso masivo y descentralizado de tablas Excel
4. Enfoque de regresión múltiple para el análisis de la varianza
5. La información no fluye entre departamentos o llega duplicada
6. Hay silos de información
7. Tareas de ventas y marketing ineficientes
8. Volumen excesivo de información que la hace inmanejable
9. Procesos manuales

---

![](./img/01-007.png)

## La Implantación de un Sistema de Business Intelligence Responde a Preguntas Como

| # | Pregunta |
|---|----------|
| **01** | ¿Qué sucedió? |
| **02** | ¿Por qué sucedió? |
| **03** | ¿Dónde estamos ahora? |
| **04** | ¿Qué va a pasar? |

---

La implantación de un proyecto de inteligencia de negocio es un proceso complejo para el que es preciso seguir unas buenas prácticas.

Las buenas prácticas ayudan a lograr los objetivos, coordinando de manera efectiva:

* La tecnología
* Las estrategias
* Las metodologías

---

![](./img/01-008.png)

## ¿Cuándo no Existe una Estrategia de BI?

Es posible detectar que no existe una estrategia cuando detectamos algunos de los siguientes puntos dentro de una organización:

* El departamento de informática es la causa de todos los problemas
* El BI no es crítico para la dirección
* BI se considera lo mismo que reporting
* Siguen existiendo información descentralizada
* No es posible medir resultados ni saber el porqué sucedieron las cosas
* Data Mining es lo mismo que BI
* No se invierte ni en tecnología ni en RRHH expertos en BI
* Se piensa que la BI es sólo para directivos o mandos intermedios

---

## La Implantación de una Estrategia de Inteligencia de Negocio

![](./img/01-009.png)
![](./img/01-010.png)

Es un proceso a largo plazo y complejo que implica múltiples departamentos, procesos y recursos entre los que es conveniente destacar:

### 01. Crear un Centro de Competencia de BI

> Unifica conocimiento en tecnologías, metodologías, estrategia, liderado por un sponsor a nivel ejecutivo y ejecutado por analistas de negocio.

### 02. Definir Estándares

> Para unificar tanto las tecnologías existentes como las futuras.

### 03. Medir los Resultados de Aplicaciones Analíticas

> Mediante herramientas de data mining o similares que faciliten la toma de decisiones.

### 04. Aprender de los Éxitos y Fracasos

> Revisando casos de estudio y consultando a las empresas del sector para determinar qué ha funcionado y qué no.

### 05. Evangelizar la Organización

> Concienciar a todo el personal, desde la dirección hasta el último empleado.

---

![](./img/01-011.png)

> Este tipo de proyectos suponen una transformación cultural de toda la organización en donde es necesario tener respuesta a alguna de las siguientes preguntas:

* ¿Qué problemas o necesidades de negocio se busca resolver?
* ¿A qué en particular se debe dar respuesta y con qué prioridad?
* ¿De qué manera obtenemos respuesta actualmente?
* ¿Qué fuentes de datos y desde qué departamentos son necesarias? (marketing, operaciones, recursos humanos, etc.)
* ¿Cómo es la calidad de los datos?
* ¿Qué cantidad de datos debe ser guardada como histórico?
* ¿Con qué frecuencia deben estar actualizados los datos?

---

## EDA - Análisis Exploratorio de Datos

![](./img/01-012.png)

### ¿Qué es el EDA?

El **análisis exploratorio de datos** es un enfoque de análisis de datos para revelar las características importantes de un conjunto de datos, principalmente a través de la visualización.

Hay que conocer bien los datos:

* Distribuciones (simétrica, normal, sesgada)
* Problemas de calidad de los datos
* Valores atípicos
* Correlaciones e interrelaciones
* Relaciones funcionales
* Atributos derivados, claves primarias, claves foráneas, etc.
* Atributos estáticos, atributos dinámicos, etc.

---

## Introducción al Análisis Exploratorio de Datos (EDA)

![](./img/01-013.png)

### 1

> El análisis exploratorio de datos se refiere al proceso de realizar investigaciones iniciales sobre la naturaleza de los datos para identificar patrones, interceptar anomalías, evaluar hipótesis y chequear asunciones con la ayuda de estadísticos y herramientas de representación gráfica.

### 2

> Es una práctica muy recomendada para comprender la naturaleza de los datos y tratar de extraer tanta información como se pueda de inicio.

---

## Importancia del EDA

![](./img/01-014.png)

* Encontrar las características y variables más relevantes del dataset de datos
* Testear hipótesis o probar asunciones sobre las características del conjunto de datos
* Comprobar la calidad de los datos y la información para el procesamiento posterior
* Proporcionar insights o conclusiones relevantes sobre los datos a los interesados
* Verificar las relaciones existentes en los datos
* Buscar patrones atípicos en la estructura de los datos

---

## Proceso del Análisis Exploratorio de Datos (EDA)

![](./img/01-015.png)

```mermaid
graph LR
    A[Objetivo de negocio] --> B[Requisitos]
    B --> C[Recolección de datos]
    C --> D[EDA: definición del modelo]
    D --> E[Evaluación]
    E --> F[Asegurar funcionamiento]
    F --> G[Despliegue]
    G --> H[Monitorización]

    style A fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style B fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style C fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style D fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style E fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style F fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style G fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
    style H fill:#E2FA42,stroke:#333,stroke-width:1px,round:10px
```

### 1. Objetivo de Negocio

Definir qué se desea conseguir.

**Ejemplo:** Empresa de Agricultura → Conocer las tendencias de mercado, para poder actuar con ventaja ante la competencia.

### 2. Requisitos

Para ello, deben formularse una serie de requisitos de datos a analizar.

**Ejemplo:** Histórico de ventas junto con datos contextualizados.

### 3. Recolección de Datos

En base a los requisitos formulados.

### 4. EDA: Definición del Modelo

Se utiliza para dar respuesta al modelo del esquema de inferencia que se persigue.

### 5. Evaluación

### 6. Asegurar Funcionamiento

### 7. Despliegue

Todo ello da lugar al despliegue.

### 8. Monitorización

Finalmente, se realiza una monitorización del rendimiento, para asegurar la correcta respuesta. Este paso da lugar a una nueva iteración, que permite añadir datos, redefinir el modelo, o incluso modificar los objetivos de negocio.

---

## Dos Tipologías de Datos

![](./img/01-016.png)

* **Datos estructurados:** archivo CSV, archivo Excel, base de datos, etc.
* **Datos no estructurados:** vídeo, imagen, sonido, etc.

---

## Consejos Importantes a la Hora de Analizar Datos Preliminares

### Obtén una Idea General de los Datos

![](./img/01-017.png)

#### 1

> Asegúrate de que tu primera visualización esté basada en datos (sin modelos).

#### 2

> Piensa en lo interactivo y lo visual:
> * **Los humanos son los mejores reconocedores de patrones**
> * Utiliza tantas dimensiones como le permitan tus datos (2, 3, x, y, z, espacio, color, tiempo, etc.)

#### 3

> La visualización es útil en las primeras etapas de la minería de datos:
> * Detectar valores atípicos (por ejemplo, evaluar la calidad de los datos)
> * Comprobar los supuestos (por ejemplo, ¿distribuciones normales o sesgadas?)
> * Identificar datos brutos útiles y transformaciones (por ejemplo, log(x))

#### Conclusión

¡Siempre merece la pena examinar los datos!

---
