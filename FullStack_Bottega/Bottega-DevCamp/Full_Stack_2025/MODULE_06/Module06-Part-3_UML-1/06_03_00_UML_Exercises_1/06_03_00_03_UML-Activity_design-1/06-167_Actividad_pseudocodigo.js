/*
Pseudocódigo basado en JS con características de TypeScript 
(como tipado fuerte de tipos de datos) para definir, muy por encima,
un posible programa estilo Grading System
*/

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