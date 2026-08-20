# Checkpoint12\_UML-Repaso.md

### UML 1 - FUNDAMENTOS

***

#### 06-150 - ¿Qué es UML?

U.M.L. - Unified Modeling Language:

* Tras varios años de diseño de un **sistema/lenguaje unificado y estandarizado para el modelado y análisis de Software**, en 1996 se libera la primera versión de UML por parte de \<NOMBRE EMPRESA ES ... RESEARCH? EMPIEZA POR R>
* En 1997-1999 pasa a ser un estándar adopatdo por la OMG, lo que lo convierte en estándar, universal, no propietario.
* Es una herramienta fundamental usada para el desarrollo, documentación, mantenimiento, corrección de errores, de un software, en forma de componentes visuales.
* **BENEFICIOS DE USAR UML**

1. Planificación visual desde cero
2. Reducción de Riesgos
3. Mejora de la comunicación
4. Organización y Calidad de sistemas complejos en componentes visuales
5. Eficiencia, gracias a una mejor planificación

No existe "un diagrama perfecto" para cada ocasión, mas los diagramas son idoneos, o no, según la situación que se requiera mostrar de forma visual.

***

#### 06-151 - Fases en las que UML es utilizado

Visto de manera general, definimos TRES fases:

* **PRE-DESARROLLO**
  * Diagrama de Actividades
  * Diagrama de Distribución (Deployment)
* **DESARROLLO ACTIVO**
  * Diagrama de Clases
  * Diagrama de Casos de Uso
* **POST-DEASARROLLO / MANTENIMIENTO**
  * Diagrama de Secuencia (Sequence)
  * Diagrama de Paquetes

Visto desde el estándar, podemos definirlas así:

* ANÁLISIS\
  Fase para entender los requisitos de la aplicación
* DISEÑO\
  Fases para definir y planificar la arquitectura, los componentes.
* IMPLEMENTACIÓN\
  Fase para desarrollar y crear una base/guía del desarrollo
* DOCUMENTACIÓN\
  Fase para crear toda la documentación que facilite el uso de nuestro software.
* MANTENIMIENTO

***

#### 06-152 - COMPONENTES COMUNES

Son **SEIS** los grandes componentes comunes entre los distintos tipos de diagramas:

1. FRAMES (marcos)
2. CLASSIFIERS (clasificadores)
3. ESTEREOTIPOS (Stereotypes)
4. COMMENTS/NOTES (comentarios)
5. DEPENDENCIAS (dependencies)
6. FEATURES/PROPERTIES (características/propiedades)

#### 06-153 - FRAMES (Marcos)

* Organizan y contienen los elementos de un diagrama.
* Aportan el contexto y delimitan el alcnace de lo que se está modelando.

#### 06-154 - CLASSIFIERS (Clasificadores)

* Principal función: Clasificarlo todo.
* No son una referencia directa de modelado a código, sino que clasifican conceptos abstractos.

#### 06-165 - STEREOTYPES (Estereotipos)

* Son un elemento/mecanismo que permiten extender las explicaciones contextuales sobre cualquier elemento de un daiagrama.
* Extienden las metaclases. Metaclases son "las clases de las clases".
* A diferencia de los Comentarios/Notas, éstos sí están reglados/definidos en UML:
  * Sintaxis con `<<` `Explicación` `>>`
  * Semántica breve, directa y técnica, que aporta contexto de un vistazo.

#### 06-156 - COMMENTS/NOTES (Comentarios)

Así cómo los los estereotipos aportan información contextual, los comentarios hacen lo propio, pero sin tener una forma estandarizada para hacerlo.

Símplemente irán englobados en un "rectángulo con la pestaña superior derecha doblada" (como un post-it), unido a flecha discontinua `- - - - ->` hacia el elemento al que desea aportar contexto.

No sustituyen las conversaciones con el resto de elementos de un equipo pero son una herramienta fundamental para las explicaciones, contexto, extendiendo lo que los estereotipos hacen.

#### 06-156 - DEPENDENCIES (Dependencias)

Reprensetan la forma más esencial de interacción entre un elemento UML y otro.

La base de las dependencias reside en el **emparejamiento** (coupling), el cuál implica cuánto un componente necesita de otro para su correcto funcionamiento.

Los cambios que afecten al elemento dependiente también afectarán al componente del que se depende.

Representamos las dependencias con lineas (o flechas) discontinuas `- A -----> B`

* Lineas: Discontinuas
* Flecha: Triangulo **ABIERTO**
* Dirección: Del componente dependiente (A), al componente del que se depende (B)
* Etiquetado: Opcional, nombre o `<<estereotipo >>`.

#### 06-157 - FEATURES/PROPERTIES (Caractetísticas/Propiedades)

* Bloques de construcción fundamentales, componentes "universales" de un elemento en UML.
* Definen lo que un elemento "tiene" (propiedades, atributos), y lo que un elemento "puede hacer" (operaciones-métodos, comportamiento).
* Por convención, y por la propia finalidad de UML, se utilizará una semántica clara, directa, auto-definitoria.

***

***

### UML 1 - DIAGRAMAS

#### 06-160 - Diagramas intro

Por lo general, todos los tipos de diagramas en UML responden a **DOS** categorías fundamentales:

* **Diagramas `ESTRUCTURALES` (Structural - Lo Que Tiene)**
  * Modelan cómo el sistema debe ser definido, construido
  * El estructural más utilizado, los **diagramas de clases**
* **Diagramas de `COMPORTAMIENTO` (Behavioural - Lo Que Hace)**
  * No definen la construcción del sistema, sino cómo el sistema actúa, de qué recursos/permisos/interacciones dispone, cómo debe responder ante X evento.

***

#### 06-161 - Estructurales (Structurals)

Por lo general, los principales diagramas UML que permitan estructurar y definir el propio sistema,son:

* Clases
* Despliegue (Deployment)
* Paquete (Package)

***

**Diagrama de Clases**

Ofrecen una representación visual exacta de las clases necesarias en un programa:

* Su especificación (Nombre)
* Sus atributos (lo que la clase "tiene"/puede ofrecer)
* Sus métodos/operaciones (lo que "puede hacer)
* Sus relaciones/dependencias, es decir, las **asociaciones** que tiene, en base a su **multiplicidad** (a cómo/cúantas relaciones tiene con otros elementos), su **navegabilidad** (el tipo y sentido estrictamente direccional de sus asociaciones), o el **rol** que abarcan estas (los atributos o métodos compartidos entre dependencias) y su **visibilidad**, es decir si estos son públicos, privados, protegidos, globales a nivel de paquete, ...

![IMG](https://s3-us-west-2.amazonaws.com/devcamp-pictures/UML+images/Screen+Shot+2017-10-12+at+1.56.22+PM.png)

**Sintaxis de una clase**

```
NOMBRE
<<ESTEREOTIPO (si lo hay)>>
```

```
ATRIBUTOS:

"+/-/#/~ VISIBILIDAD" "NOMBRE ATRIBUTO : "TIPO" [MULTIPLICIDAD]

```

```
MÉTODOS/OPERACIONES:

"+/-/#/~ VISIBILIDAD" "NOMBRE MÉTODO"(PARAMENTROS): "RETORNO"
```

```
Topic
-----------------
+ title : String
+ slug : String
+ createdAt : DateTime
+ updatedAt : DateTime
-----------------
+ topTen() : List<Topic>
- calculateRanking() : Integer
```

***

**Diagramas de Despliegue**

Modelan el despliegue de los distintos componentes de software/hardware respecto a nuestro programa, definiendo cómo debe ser configurada toda la arquitectura.

Están formados por **SEIS** elementos comunes:

* **NODOS (Nodes)**

Sistemas fisicos o virtuales, pero independientes, donde los distintos componentes son desplegados.

* **COMPONENTES (Components)**

Módulos de software/de aplicaciones; por componentes.

* **Artefactos/Blobs (Artifacts)**

"Piezas" de información concreta usada o creada.

Por ejemplo, una "ficha de cliente", un objeto, de su propia clase, sería un Artefactos. La ficha es "creada" en base a parámetros de su clase, y es utilizada por otros elementos. (No es la mejor explicación porque puede inducir a error respecto a los diagramas de clases, pero es útil).

* **RUTAS/NEXOS/ENLACES (Links)**

Conexiones-relaciones entre los nodos.

* **DEPENDENCIAS (Dependencies)**
* **ASOCIACIONES (ASSOCIATIONS)**

A grandes rasgos, en la industria, definimos la implementación estilo CI/CD (Integración Continua/Desarrollo Continuo - Continuous Integration/Continous Development) usando Diagramas de Despliegue.

![IMG](https://s3-us-west-2.amazonaws.com/devcamp-pictures/UML+images/Screen+Shot+2017-10-12+at+2.41.43+PM.png)

Una CI/CD típica ofrecerá:

1. **Un servidor CI principal**

Donde desarrollamos la aplicaicón, donde ubicamos todo el control de versiones.

2.  **Tres componentes/entornos separados**

    * **2.1 STAGING**

    Entorno de desarrollo y testeo.

    * **2.2 PRE-PRODUCTION**

    Entorno de testeo profundo.

    * **2.3 PRODUCTION**

    Servidor/entorno final, donde reside nuestra aplicación, en producción.

Este sistema ampliamente utilizado en la industria ofrece ventajas signitificativas (Nunca podrías pasar a producción una versión de la aplicación que pudiera contener errores y compromenter el sistema.)

***

**Diagramas de Paquete**

Son usados para mostrar y organizar las Dependencias/Relaciones a nivel de paquete.

Éstas se reprensentan con flechas discontinuas/punta abierta `A ------> B`.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/UML+images/Screen+Shot+2017-10-12+at+4.09.39+PM.png)

Los diagramas de paquete contienen estos elementos comunes:

* Tipo (de dato)
* Clasificadores
* Clases / Diagramas de Clases
* Diagramas de Casos de Uso
* Componentes
* Paquetes
* Restricciones (Constraints)
* Dependencias
* Eventos

***

#### 06-162 - De Comportamiento (Behaviourals)

Aquellos que definen cómo el sistema debería comportarse al ejecutar nuestro programa, principalmente, son **CUATRO**:

* **Diagramas de Actividad**
* **Diagramas de Casos de Uso**
* **Diagramas de Estados (State Machine)**
* **Diagramas Secuenciales**

***

**Diagramas de Actividad**

Complementan, junto a los `"Estructurales -> De Actividad"` (y los `"Comportamiento -> Casos de Uso`), la base en la que tanto desarrolladores como el resto de partes envueltas en un proyecto que tengan por qué conocer UML pueden comunicarse ya que:

* Ofrecen una sintáxis muy sencilla, directa y entendible de los estados de ejecución
* Secuencian cada "fase", "punto de acción".
* Permiten identificar los actores envueltos.

![IMG](https://s3-us-west-2.amazonaws.com/devcamp-pictures/UML+images/Screen+Shot+2017-10-13+at+10.18.53+AM.png)

**SIETE** son los elementos comunes:

1. Estado Inicial
2. Punto de Actividad
3. Flujo de Acción
4. Puntos de Decisión
5. Guardas
6. Estado Final
7. Carriles (Swim Lanes)

***

**Diagramas de Casos de Uso**

Los elementos principales de los diagramas de casos de uso serán:

1. Los propios `casos de uso`
2. Los actores
3. Sistemas/Subsistemas
4. Relaciones entre si

![IMG](https://s3-us-west-2.amazonaws.com/devcamp-pictures/UML+images/Screen+Shot+2017-10-13+at+10.22.01+AM.png)

***

**Diagramas de Estado (State Machine)**

Similares a los diagramas de Actividad, éstos tratan de mostrar un concepto casi histórico en el desarrollo de Software:

* Los estados del sistema en cada tiempo de ejecución
* Los datos/El flujo de de datos del mismo

Lo hacen intentando dividir en la mayor parte posible de piezas/pasos cada acción, decisión

Son **CINCO** los elementos comunes a un Diagrama de Estado:

1. Punto inicial
2. Elección
3. Restricciones
4. Estados
5. Transiciones

![IMG](https://s3-us-west-2.amazonaws.com/devcamp-pictures/UML+images/Screen+Shot+2017-10-13+at+10.40.54+AM.png)

***

**Diagramas de Secuencia**

Se basan en el análisis lógico de del sistema o de partes del sistema.

Definen y modelan la ejecución del código, cómo debe operar. **Muy útiles para representar gráficamente operaciones complejas**, bien en el análisis-modelado, bien para probar distintos métodos antes de comenzar a desarrollarlos.

Son **CUATRO** los elementos comunes en diagramas de secuencia:

1. Actores/Objetos (Clases) (Class Roles - Participants)
2. Barras/Cuadros de Activación ( Activation/Execution Ocurrence )
3. Mensajes
   * Mensajes que se envían, flecha continua `------>`
   * Respuestas, flechas discontinuas `<- - - -`
4. Lineas de Vida

![IMG](https://s3-us-west-2.amazonaws.com/devcamp-pictures/UML+images/Screen+Shot+2017-10-13+at+11.29.33+AM.png)

Para tratar de entender méjor qué es y cómo funciona un Diagrama de Secuencia y, tomando como ejemplo el programa Phone Parser facilitado, explicaremos:

1. En su estado inicial, el "programa" recibe un dato (un número de teléfono que formatear), que pasa a nuestra primera **barra de activación**.
2. El primero Actor es la clase Parser y su objeto (método) `parse`. Éste, hace una primera ejecución, "Eliminar cualquier carácter, excepto números". Retorna su dato.
3. Nuestro dato pasa a la segunda barra de activación. Dentro de la propia clase Parse, a la función digit\_length\_validator(), la cual retorna el dato validado (o no; su secuencia es validar, lo que haga si no cumple los criterios no se ha especificado ni se especifica en esta parte.)
4. Nuestro dato con longitud validada pasa a la tercera barra de acción, a otra clase, CountryCodes, y su objeto (función) country\_code\_validator(), la cual define qué prefijo telefónico está en uso (o define si es correcto)
5. Una vez validado en la última barra de activación, el dato retorna a la primera barra de ejecución, y se devuelve a su estado inicial, el cliente que formatea números (Parser Client).

Esto, a grandes rasgos, sería la forma de entender un diagrama de secuencia.

***

#### CLASS DIAGRAMS

#### 06-164 - Diagrama de Clases -> ELEMENTOS

* ### Clases -> Tres elementos Clave
* **Nombre de la clase**
* **Atributos de la clase**
  * \[`visibilidad` ] `nombreAtributo` : `tipo` \[ `multiplicidad`]
* **Métodos / Operaciones**
  * \[ `visibilidad` ] `nombreMetodo()` : `Valor que retorna`

Ejemplo:

```
Alumnos
--
+ nombreAlumno: String
+ apellidoAlumno: String
+ identificado: String
+ Alumnos(String, String, String) : String
--
+ imprimeInforme(): String
+ calificaAlumno(): void
```

#### 06-165 - Propiedades de atributos en Diagrama de Clases -> ASOCIACION -> MULTIPLICIDAD - NAVEGABILIDAD - ROL

*   **ASOCIACION**

    Propiedad que define la conexión entre un elemento y otro, que intenta modelar relaciones del mundo real.

    Por ejemplo, 'Cliente' y 'Pedido' son relaciones reales que, para plasmarlas en UML, en código, para un programa, serían interpretadas como clases, cada una con sus atributos y métodos pertinentes.

    Ambas estan relacionadas entre sí. Ésta es la propiedad de asociación
*   **MULTIPLICIDAD**

    Propiedad que restringe, o no, el numero de instancias que participan en la asociación de dos elementos.

    En el ejemplo de Cliente - Pedido, podriamos decir que Cliente a Pedido es relación n (muchos, `*`) a 1, es decir, un Cliente puede "existir por si mismo" teniendo cero pedidos, un pedido o muchos pedidos.

    Pedido, en cambio, sin un cliente, no tiene razón de ser.
*   **NAVEGABILIDAD**

    Tipo de relación entre un elemento y otro, capacidad de poder acceder de una clase a otra siguiendo el tipo de asociación. (bidireccional por defecto, direccional cuando un elemento es dependiente de otro pero no al revés)

#### 06-166 - Diagrama de Clases -> Ejemplo Twitter

#### ACTIVITY DIAGRAMS

#### 06-168 - Diagrama de Actividades -> ELEMENTOS

1. Punto Inicial
2. Flujo de Acción
3. Punto de Actividad
4. Punto de Decisión
5. Guardas, Ramas, Caminos
6. Punto Final
7. Carriles (Swim Lanes)

#### 06-169 - Diagrama de Actividades -> Ejemplo Grading System
