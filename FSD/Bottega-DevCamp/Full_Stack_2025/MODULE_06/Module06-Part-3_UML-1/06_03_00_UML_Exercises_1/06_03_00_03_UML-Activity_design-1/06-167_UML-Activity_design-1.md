# Ejercicio UML: Diseñar un Diagrama de Actividad para un programa simple

## 0. Origen

Desde la guía _06-166, UML -> "Elements of a UML Activity Diagram"_ y la posterior, _06-167, UML -> "How to Design an Activity Diagram for an Online Grading System"_, recibimos a través de un ejemplo sencillo los distintos elementos típicos de un Diagrama de Actividades.

Vamos a expandir el ejemplo, realizar el mismo diagrama, desde cero, tratando de incorporar elementos típicos y generales de UML (como frames/marcos, comentarios) y, finalmente, desarrollar de manera básica un pseudo-código de ejemplo que aplique a lo que tratamos de explicar con este diagrama.

## 1. En Lenguaje Contextual

Se definen varios actores:

* El **Alumno**, que va a examinarse con un test adecuado.
* El **Sistema**, que genera test adecuado cuando el mentor se lo indica, examina al alumno pregunta a pregunta y recaba un informe final que será entregafo al mentor, almacenando los resultados cuando el mentor corrija y valide estos.
* El **Mentor**, quien asigna los temas a examinar y, junto al informe entregado por el sistema, califica los resultados del alumno para ser almacenados en el sistema.

Primero, vamos a especificar TODOS los elementos típicos de un diagrama de actividades:

1. **Estado Inicial (Initial State )**\
   Es el propósito inicial de nuestra actividad concreta (Quiz) para nuestro programa "Grading System".
2. **Estado/Punto de Actividad/Acción (Activity/Action State)**\
   Será cada acción realizada dentro de nuestra actividad después de nuestro estado inicial.

Son Acciones como:

* "Generar un set de preguntas"
* "Confirmar el set y Comenzar"
* "Lanzar una pregunta al alumno"
* "Responder cada pregunta"
* "Corregir y validar resultados"

3. **Flujo de Acción (Action Flow)**\
   De un Punto de Acción a otro, existe esa acción realizada. Esta acción es el Flujo de acción.

Por ejemplo, para el Mentor poder examinar un Quiz, el sistema debe haber realizado un paso previo, que es "generar un informe de respuestas emitidas por el alumno".

Cuando éste se realiza y se traslada al Mentor, este es uno de los flujos de acción de nuestro programa.

4. **Punto de Decisión (Decision/Branch Point)**\
   Puntos del programa donde **siempre tenemos un flujo de entrada y dos (o más) posibles ramas/salidas**.

Representados por un diamante (rombo o cuadrado girado 45 grados), a nivel de ejecución, **no son ramas paralelas**, es decir, son estilo **"OR"** y sólo se ejecutará una u otra acción.

Como apunte, añadir que también existen ramas paralelas de ejecución, estilo **"AND"**, representadas por "barras gruesas" de entrada y salida, cuyas condiciones, todas las que se dispongan, deben cumplirse para realizar una salida. \*\*No es el caso de este programa, Grading System, pero está bien señalarlas.

5. **Guardas/Ramas (Guards)**

De cada punto de decisión, tendremos diferentes ramas.\
En nuestro programa Grading System, no se trata de las respuestas del alumno en si mismas sino si **el alumno contestó la última pregunta, para continuar con el Flujo de Acción, o quedan preguntas sin responder y el sistema debe seguir lanzando preguntas.**

6. **Estado Final (Final State)**

Cuando todas las acciones han sido realizadas, llegamos a un punto o estado final de nuestra actividad.

En el propósito de nuestra actividad Quiz, una vez que:

* El alumno contesta todas las preguntas.
* El sistema genera un informe de respuestas para el Mentor.
* El Mentor corrige y valida las acciones del alumno ...
* ... éste, el Mentor, pide al sistema almacenar los datos de calificaciones del alumno. **Este será el estado final**

1. **Carriles (Swim Lanes)**

Por cada actor (cada parte participante en nuestra actividad "Quiz", de nuestro programa "Grading System"), disponemos de un carril.

Como cada Punto de Acción (Cada Acción) recae sobre un actor u otro, es importante definirlos correctamente y saber "a quién"/"dónde" asignar cada fase/paso/propósito/estado.

**Esta es la característima más fundamental de los Diagramas de Actividad"**

## 2. Diagrama de Actividad

![large](<../../../../../../../.gitbook/assets/Diagram 2025-06-13 22-21-16.png>)

Desarrollado en [UMLetino](https://www.umletino.com/umletino.html).

```xml
<!-- Código de UMLetino (es muy mejorable)-->
<diagram program="umletino" version="15.1"><zoom_level>15</zoom_level><element><id>UMLFrame</id><coordinates><x>0</x><y>0</y><w>1470</w><h>1245</h></coordinates><panel_attributes>act			Quiz (GradingSystem)
--
</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLObject</id><coordinates><x>255</x><y>120</y><w>315</w><h>945</h></coordinates><panel_attributes>Mentor
valign=top

</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLObject</id><coordinates><x>570</x><y>120</y><w>315</w><h>945</h></coordinates><panel_attributes>Sistema
valign=top</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLObject</id><coordinates><x>255</x><y>75</y><w>930</w><h>990</h></coordinates><panel_attributes>&lt;&lt;Quiz&gt;&gt;
valign=top
</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLSpecialState</id><coordinates><x>390</x><y>210</y><w>60</w><h>60</h></coordinates><panel_attributes>type=initial</panel_attributes><additional_attributes></additional_attributes></element><element><id>Relation</id><coordinates><x>435</x><y>225</y><w>315</w><h>90</h></coordinates><panel_attributes>lt=&lt;-</panel_attributes><additional_attributes>190;40;190;10;10;10</additional_attributes></element><element><id>Relation</id><coordinates><x>840</x><y>315</y><w>225</w><h>90</h></coordinates><panel_attributes>lt=&lt;-</panel_attributes><additional_attributes>130;40;130;10;10;10</additional_attributes></element><element><id>Relation</id><coordinates><x>720</x><y>390</y><w>240</w><h>105</h></coordinates><panel_attributes>lt=&lt;-</panel_attributes><additional_attributes>10;50;10;10;140;10</additional_attributes></element><element><id>Relation</id><coordinates><x>840</x><y>495</y><w>225</w><h>90</h></coordinates><panel_attributes>lt=&lt;-</panel_attributes><additional_attributes>130;40;130;10;10;10</additional_attributes></element><element><id>UMLSpecialState</id><coordinates><x>975</x><y>675</y><w>120</w><h>120</h></coordinates><panel_attributes>type=decision
¿Es la Última
Pregunta?
bg=yellow</panel_attributes><additional_attributes></additional_attributes></element><element><id>Relation</id><coordinates><x>1020</x><y>615</y><w>45</w><h>90</h></coordinates><panel_attributes>lt=&lt;-</panel_attributes><additional_attributes>10;40;10;10</additional_attributes></element><element><id>Relation</id><coordinates><x>540</x><y>525</y><w>465</w><h>255</h></coordinates><panel_attributes>lt=&lt;- NO</panel_attributes><additional_attributes>130;10;130;140;290;140</additional_attributes></element><element><id>Relation</id><coordinates><x>840</x><y>780</y><w>240</w><h>90</h></coordinates><panel_attributes>lt=&lt;- SI</panel_attributes><additional_attributes>10;40;130;40;130;10</additional_attributes></element><element><id>Relation</id><coordinates><x>390</x><y>840</y><w>255</w><h>120</h></coordinates><panel_attributes>lt=&lt;-</panel_attributes><additional_attributes>10;60;10;10;150;10</additional_attributes></element><element><id>UMLSpecialState</id><coordinates><x>690</x><y>945</y><w>60</w><h>60</h></coordinates><panel_attributes>type=final
</panel_attributes><additional_attributes></additional_attributes></element><element><id>Relation</id><coordinates><x>510</x><y>960</y><w>210</w><h>45</h></coordinates><panel_attributes>lt=&lt;-</panel_attributes><additional_attributes>120;10;10;10</additional_attributes></element><element><id>UMLState</id><coordinates><x>615</x><y>285</y><w>240</w><h>75</h></coordinates><panel_attributes>Generar un set 
  de preguntas </panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLState</id><coordinates><x>930</x><y>375</y><w>210</w><h>75</h></coordinates><panel_attributes>Confirmar e Iniciar
type=sender</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLState</id><coordinates><x>615</x><y>465</y><w>240</w><h>75</h></coordinates><panel_attributes>Lanzar Pregunta
type=receiver</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLState</id><coordinates><x>930</x><y>555</y><w>210</w><h>75</h></coordinates><panel_attributes>Responder Pregunta</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLState</id><coordinates><x>615</x><y>810</y><w>240</w><h>75</h></coordinates><panel_attributes>Generar Informe</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLState</id><coordinates><x>315</x><y>930</y><w>210</w><h>75</h></coordinates><panel_attributes>Corregir y Validar</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLNote</id><coordinates><x>15</x><y>240</y><w>225</w><h>180</h></coordinates><panel_attributes>ESTADO INICIAL
--
Inicio del propósito de
nuestra actividad:

- Examinar al  alumno
bg=blue</panel_attributes><additional_attributes></additional_attributes></element><element><id>Relation</id><coordinates><x>225</x><y>225</y><w>195</w><h>105</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>110;10;10;50</additional_attributes></element><element><id>UMLNote</id><coordinates><x>420</x><y>1125</y><w>210</w><h>105</h></coordinates><panel_attributes>ESTADO FINAL
--
- Almacenar resultados
bg=blue</panel_attributes><additional_attributes></additional_attributes></element><element><id>Relation</id><coordinates><x>540</x><y>990</y><w>180</w><h>165</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>100;10;10;90</additional_attributes></element><element><id>UMLNote</id><coordinates><x>1080</x><y>1080</y><w>240</w><h>150</h></coordinates><panel_attributes>GUARDAS / RAMAS
--
Posibilidades, cada rama:
     - "Si"
     - "NO"
bg=blue</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLObject</id><coordinates><x>885</x><y>120</y><w>300</w><h>945</h></coordinates><panel_attributes>Alumno
valign=top</panel_attributes><additional_attributes></additional_attributes></element><element><id>Relation</id><coordinates><x>1035</x><y>795</y><w>150</w><h>315</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>10;10;80;190</additional_attributes></element><element><id>Relation</id><coordinates><x>960</x><y>750</y><w>225</w><h>360</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>10;10;130;220</additional_attributes></element><element><id>UMLNote</id><coordinates><x>1200</x><y>705</y><w>255</w><h>135</h></coordinates><panel_attributes>PUNTO DE DECISION
--
   Abarca desde el punto de
   actividad al propio rombo.
bg=blue</panel_attributes><additional_attributes></additional_attributes></element><element><id>UMLNote</id><coordinates><x>1215</x><y>300</y><w>225</w><h>195</h></coordinates><panel_attributes>CARRILES (SWIM LANES)
--
Una por actor:
- Mentor - Sistema - Alumno
bg=blue</panel_attributes><additional_attributes></additional_attributes></element><element><id>Relation</id><coordinates><x>465</x><y>150</y><w>780</w><h>225</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>10;10;500;130</additional_attributes></element><element><id>Relation</id><coordinates><x>780</x><y>150</y><w>465</w><h>225</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>10;10;290;130</additional_attributes></element><element><id>Relation</id><coordinates><x>1050</x><y>150</y><w>195</w><h>225</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>10;10;110;130</additional_attributes></element><element><id>Relation</id><coordinates><x>1095</x><y>720</y><w>135</w><h>75</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>10;10;70;30</additional_attributes></element><element><id>UMLNote</id><coordinates><x>15</x><y>825</y><w>210</w><h>165</h></coordinates><panel_attributes>FLUJOS DE ACCION
--

      Cada paso, cada 
      flujo de acción.
   Representados por
     flechas continuas.
bg=blue
bg=blue</panel_attributes><additional_attributes></additional_attributes></element><element><id>Relation</id><coordinates><x>210</x><y>840</y><w>225</w><h>90</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>130;10;10;40</additional_attributes></element><element><id>UMLNote</id><coordinates><x>15</x><y>525</y><w>210</w><h>150</h></coordinates><panel_attributes>PUNTOS DE ACCION
--

  Cada fase, cada paso, 
será un Punto de Acción
           o Actividad.
bg=blue</panel_attributes><additional_attributes></additional_attributes></element><element><id>Relation</id><coordinates><x>210</x><y>345</y><w>420</w><h>285</h></coordinates><panel_attributes>lt=&lt;..</panel_attributes><additional_attributes>260;10;10;170</additional_attributes></element></diagram>

```

## 3. Desarrollo del código

A grandes rasgos, podemos definir todos estos objetos / clases:

* "Alumno", quien podría conformarse de su propia clase que defina "los datos personales del alumno", el "identificador del alumno", el "curso realizado" y sus respectivas "asignaturas, o módulos", el "profesor asignado", y otros datos.
* "Mentor", quien del mismo modo, provendrá de su propia clase la cual identifique qué Mentor es (datos), qué Alumnos tutoriza, etc.
* "Preguntas". Podría ser un gran "array" (objeto de objetos). En su construcción, a través de su propia clase, tendría diferentes atributos como "Asignatura", "Lección", "Respuesta".

También identificamos los siguientes objetos-Funciones:

* Funcion "Examinar Al Alumno":
* Recibida las instrucciones del mentor para examinar a un alumno determinado, recaba las preguntas pertinentes.
* Interactúa con el alumno, una vez recabadas las preguntas, para que éste confirme que se debe iniciar el test.
* Lanza preguntas al alumno, espera su respuesta y verifica si quedan preguntas pendientes de respuesta o no, para finalizar el proceso de examinación y generar un informe que remite al Mentor.
* Función "Labores del Mentor"
* Emite las instrucciones-requisitos al sistema para que éste examine al alumno.
* Recibe el informe de todo el proceso de examinación realizado en la función "Examinar Al Alumno".
* Evalúa el proceso, realiza las acciones pertinentes para con el Alumno/el proceso de Examinación del alumno.
* Pide almacenar los resultados en el sistema.

Se pueden deducir otras funciones secundarias necesarias para poder realizar la actividad Quiz/el programa Grading System, como:

* Hacer login en el sistema
* Determinar el rol (Alumno, Mentor, cualquier otro)
* Registrar acciones del alumno durante la sesión de examinación
* Registrar fechas, datos de cualquier otro tipo, etc.
* Manejar distintas bases de datos (Alumnos, Mentores, Cursos, Asignaturas, Preguntas, etc...)

De ello, y aunque sólo tenemos una Actividad (Quiz) de todo el programa (Grading System), podemos realizar un pseudo-código:

```js
class Alumno {

    constructor(nombre, id, curso) {

        this.nombre = nombre;
        this.id = id;
        this.curso = curso;
    }

    confirmarExamen(){

        // Y su respectiva lógica

    }

    responderPregunta() {
        // Y su respectiva lógica
    }

}

class Mentor {

    constructor(nombre, id, curso, grupoAlumnos) {
        this.nombre = nombre;
        this.id = id;
        this.curso = curso;
        this.grupoAlumnos = grupoAlumnos();
    }
    


    solicitaExamen(){
        // Y su respectiva lógica
        return Auxiliares.recabaPreguntas()

    }

    examina() {
        // Y su respectiva lógica
        return SesionDeCorreccion.almacenarResultados()
    }

}



class SesionDeExamen {

    recabaPreguntas(){
        // Y su respectiva lógica
    }

    lanzaPreguntas() {
        
        // Y su respectiva lógica
        if ( ... ) {
            ...
        } else {
            return this.ultimaPregunta()
        }

    }
    registraEventos(){
        // Y su respectiva lógica
    }

    compruebaTodasRespondidas() {

        if ( !ultimaPregunta ) {

            return this.lanzaPreguntas()
        }

        this.finalizaExamen()
    }

    finalizaExamen(){
        // Y su respectiva lógica
        SesionDeCorreccion.recibirInformes()

    }
}

class SesionDeCorreccion {

    recibirInformes() {
        // Y su respectiva lógica
    }

    almacenarResultados(){
        // Y su respectiva lógica
    }
}

class Auxiliares {

    grupoAlumnos() {
        // Y su respectiva lógica
    }
    loginUsuarios() {
        // Y su respectiva lógica
    }
}


// etc etc etc
```
