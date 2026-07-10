# 05-007:	Técnicas de representación de datos

![](./img/05-026.img)

Crear un gráfico a partir de una tabla de excel o incluso un SQL como los que se han utilizado hasta hace unos años es bastante sencillo. Las variables apenas pasaban las 100 columnas y no todas estaban relacionadas entre sí. Sin embargo, a medida que se agregan e interrelacionan variables esto se vuelve más complicado.  

* **Datos Estructurados (Tradicional):** Crear gráficos a partir de tablas de Excel o consultas SQL era sencillo cuando las variables apenas superaban las 100 columnas y no estaban interrelacionadas. Para métricas limpias como ventas o ingresos, los **gráficos sencillos** siguen siendo más que suficientes.

Para datos estructurados, como ventas, ingresos, etc, los gráficos sencillos son más que suficiente. Sin embargo, para la los datos desestructurados, como textos o imágenes, captados con sistemas de Big Data, hace falta otro tipo de técnica para visualizar la información adecuadamente.

* **Datos Desestructurados (Big Data):** A medida que las variables se multiplican y se interconectan, todo se complica. Para gestionar flujos complejos de datos masivos como textos o imágenes, se vuelven indispensables **técnicas avanzadas de visualización**.


---

## Gráficos relacionales
![](./img/05-027.img)

Son especialmente útiles para estudiar la relación de los clientes con una compañía y el nivel de penetración de nuestros productos en cada hogar. Por ejemplo, ¿de los clientes de una compañía telefónica, cuántos tienen solo línea móvil, cuántos tienen pack completo y cuántos han mostrado interés en servicios adicionales como TV bajo demanda o coberturas? ¿Cómo se relacionan dichos productos con los consumidores y qué datos sociodemográficos cumplen?

---

## Nube de palabras
![](./img/05-028.img)

Para encontrar la moda en una serie de textos. Este gráfico es especialmente indicado para extraer insights a través de la escucha activa en Redes Sociales, pues te permite relacionar tu marca o keywords concretas con aquello que se comenta de ellas, el sentimiento (bueno, neutro o malo) con el que se comenta y el volumen de interacciones que genera. En próximos artículos veremos cómo esto, asociado a usuarios y propuestas políticas concretas, afectaron a las elecciones de Estados Unidos en 2012 y 2016 e incluso a las de España del año pasado.

---

## Diseño de mapas de color
![](./img/05-029.img)

Utilizados para comparar datos que tienen mucha distancia entre si: por ejemplo en el caso de una compañía que quiera medir la aceptación geográfica de su servicio o producto, o el potencial de clientes se encuentran en un lugar determinado en relación con su situación socioeconómica. Pueden ser de dos tipos:

* **📌 Mapa Cuadriculado:** Ideal para matrices de datos densas (como expresiones genéticas o correlaciones numéricas puras).

* **🗺️ Mapa Cartográfico:** Superpone la densidad de los datos directamente sobre mapas geográficos reales.

---

## Diagramas de dispersión
![](./img/05-030.img)

Uno de los primeros métodos de visualización de datos, debido a que no pueden mostrar por sí mismas más de tres variables para cada registro, ya que se utilizan coordenadas cartesianas para obtener los valores de las variables.

* **Limitación espacial:** No suelen mostrar de forma directa más de **tres variables** por registro.
* **Mecanismo:** Utilizan **coordenadas cartesianas** para mapear los valores fijos de las variables.

En la siguiente gráfica podemos observar la calidad en cuanto a la puntualidad de varias aerolíneas, atendiendo a los minutos de retraso en el despegue del avión.

---

## La clave de representación de datos
![](./img/05-031.img)

* Se encuentra en **seleccionar la representación visual** que queremos extraer a nuestros datos.
* Se realiza en función del **tipo de conclusión que queremos hallar**.
* Es decir, escoger la representación según la **hipótesis que queramos demostrar**.

---

## Herramientas para la visualización de datos: 	Power BI
![](./img/05-032.img)

### ¿Qué es Power BI?

* **Definición:** Power BI es, probablemente con Tableau o Qlik, la herramienta SaaS líder del mercado de herramientas de BI.
* **Características clave:**
  * No están necesariamente monitorizadas por el equipo de IT.
  * Resultan más flexibles y adecuadas para el día a día de las empresas que lo utilizan.

![](./img/05-033.img)

* **Informe Anual:** La consultora **Gartner** publica anualmente su informe sobre los diferentes proveedores de este tipo de software destinados a BI.
* **Formato:** Cuenta con un cuadrante comparativo de las distintas soluciones comerciales.
* **Resultado:** En dicho cuadrante aparece destacada la herramienta de Microsoft.

---

### Comparativa de soluciones tecnológicas elaborada por Gartner:
![](./img/05-034.img)

* **Ejes del cuadrante:**
  * **Eje vertical:** Ability to execute *(Capacidad de ejecución)*
  * **Eje horizontal:** Completeness of vision *(Integridad de visión)*
* **Categorías del cuadrante:**
  * Challengers
  * Leaders *(Destaca: **Microsoft**)*
  * Niche Players
  * Visionaries

> 📅 **Referencia temporal del gráfico:** As of January 2020

---

## Business Intelligence: Enfoque en Tableau y Power BI

- **Vídeo de Apoyo:** https://www.youtube.com/watch?v=GBSdCGMpU1Q

> **Tableau y Power BI lideran el mercado de la analítica.**

Tableau destaca por ser una suite robusta que permite desde la ingeniería básica de datos (**Prep**), pasando por el diseño avanzado (**Desktop**), hasta la distribución en la nube o servidores locales (**Online/Server**), consolidándose como una habilidad imprescindible para cualquier profesional del mundo de los datos.

---

### 1. Introducción al Business Intelligence (BI) y Tableau

**Tableau** es una de las herramientas de análisis de datos e Inteligencia de Negocios (**Business Intelligence**) más utilizadas y potentes del mercado.  

Su lema principal, *"Changing the way you think about data"* (**Cambiando la forma de ver los datos**), define su propósito fundamental: transformar datos en bruto en información visual y comprensible.  

El **Business Intelligence (BI)** se define como la práctica de entender los datos para obtener información relevante sobre un negocio a través de **visualizaciones**, **cuadros de mando (dashboards)** y diferentes metodologías de **análisis predictivo o descriptivo**. Tableau facilita este proceso mediante una interfaz intuitiva basada en hacer clic y arrastrar (*drag-and-drop*).

---

### 2. Los 4 Componentes Clave del Ecosistema Tableau

Tableau no es una única aplicación, sino un entorno compuesto por **cuatro herramientas principales** diseñadas para cubrir todo el ciclo de vida del dato:

1. Tableau Prep
2. Tableau Desktop
3. Tableau Online
4. Tableau Server



#### A. 	Tableau Prep
![](./img/05-035.img)

> **Definición:** Es una herramienta de **ETL (Extract, Transform, and Load / Extraer, Transformar y Cargar)** orientada a la limpieza y preparación del dato.

> **Propósito:** Automatizar los procesos de limpieza de datos. Un científico o analista de datos suele pasar hasta el **80% de su tiempo** depurando datos; Tableau Prep reduce drásticamente este margen temporal.

---

#### B. 	Tableau Desktop
![](./img/05-036.img)

> **Definición:** La aplicación de escritorio principal del entorno.

> **Propósito:** Es donde se lleva a cabo el núcleo del análisis de datos. En ella se diseñan los gráficos, informes interactivos y los cuadros de mando finales. Es la herramienta central que se enseña en cualquier formación académica sobre Tableau.

---

#### C. 	Tableau Online
![](./img/05-037.img)

> **Definición:** La vertiente en la nube (**SaaS**) del entorno.

> **Propósito:** Almacenar, gestionar y consultar las hojas de trabajo, dashboards y fuentes de datos en la nube de Tableau. Responde a la tendencia global del BI de abandonar los archivos locales para centralizar la computación y el acceso a través de la web.

---

#### D. 	Tableau Server
![](./img/05-038.img)

> **Definición:** Plataforma empresarial para la gobernanza y compartición de datos.

> **Propósito:** Pensada para grandes organizaciones que requieren alojar sus datos de forma privada, ya sea de manera local (**on-premises**) o en nubes privadas, permitiendo la administración segura de accesos y la colaboración en equipo.

---

### 3. Tableau Public vs. Tableau Desktop

Para usuarios individuales y estudiantes existe una distinción crucial en cuanto a licencias:

#### **Tableau Desktop**

- Es de pago, enfocado al sector empresarial, y cuenta con una versión de prueba de **14 días**.
- Permite guardar archivos de forma local y privada.

#### **Tableau Public**

- Es una versión totalmente gratuita que conserva la gran mayoría de funcionalidades analíticas de la versión Desktop.
- La restricción clave es que los datos y libros de trabajo son públicos: obligatoriamente deben guardarse en la nube de Tableau Public, por lo que no es apto para empresas con políticas de privacidad o datos sensibles.

---

### 4. Tipos de Licencias y Roles de Usuario

El acceso a Tableau en entornos compartidos se estructura en **tres niveles o perfiles de coste escalonado**:

- **Creator (Creador):** Acceso completo para transformar datos (Tableau Prep) y diseñar visualizaciones (Tableau Desktop).

- **Explorer (Explorador):** Modifica o profundiza en informes ya creados sobre la plataforma web.

- **Viewer (Visor):** Usuario de consulta que únicamente consume e interactúa con los cuadros de mando terminados.

---

### 5. El Mercado del BI: Tableau vs. Power BI (Cuadrante Mágico de Gartner)

#### 	Cuadrante Mágico de Gartner para Plataformas de Analítica y Business Intelligence

Gartner clasifica anualmente los softwares del sector basándose en su **"habilidad de ejecución"** y la **"integridad de su visión"**.

- **Microsoft Power BI:** Posicionado como el líder absoluto y el software más avanzado del mercado debido a su accesibilidad e integración con el ecosistema de Microsoft.

- **Tableau:** Posicionado firmemente como el segundo mejor software del mundo y colíder del cuadrante, destacando por su potencia visual y flexibilidad de exploración de datos.

- **Otros competidores:** Detrás de ellos se sitúan herramientas como **Qlik**, **ThoughtSpot** y **Salesforce** (empresa que de hecho adquirió Tableau).

---