


// 1. Esqueleto Básico, haciendo públicos las variables name y email

// class Customer {

//     constructor(name, email){

//         this.name = name;
//         this.email = email;
//     }

//     calculateDiscount() {

//         /*
//          * Fijamos un integer directamente
//          * Más adelante podemos, dado el ejemplo,
//          * especificar una operación matemática de dto.
//          */
//         return 127.99 - ( ( 127.99 * 12 ) / 100 )  
//     }

// }



// 2. Usando explícitamente get y set ES6, no this.

/*
class Customer {

    // Aquí, con #, las propiedades son realmente privadas
    #name;
    #email;

    constructor(name, email) {

        this.#name = this.name;
        this.#email = this.email;

    }

    get name(){

        return this.#name
    }
    set name(value){

        this.#name = value;

    }

    get email(){

        return this.#email
    }
    set email(value){

        this.#email = value;

    }

    calculateDiscount() {

        return 12.99
    }
}
*/

// 3. Enfoques de uso

// 3.1 Validación de entrada - Formateo de cadenas

/*
class Customer {

    #name;
    #email;

    constructor(name, email){

        this.#name = name;
        this.#email = email;
    }
    get name() {
        return this.#name;
    }
    // Formateo de cadena, nombre siempre mayúsculas
    set name(value) {
        this.#name = value.toUpperCase();
    }

    // Validación de entrada de datos
    get email(){
        return this.#email;
    }
    set email(value){

        // Implementamos validación, if !value.content
        if ( !value.includes('@') ) {

            // Además, añadimos un método de consola para debug
            console.warn('[WARN] No se ha intoducido un email válido')
            
            // Lanzamos el error por validación
            throw new Error('Email tiene que llevar @')

        }

        this.#email = value;
    }

    calculateDiscount() {
        return 12.99;
    }
}
*/



// 5. Retrotrayendo la class a JS closures

function Customer(customerName, customerEmail) {

    // Hacemos nuestro constructor, de las vars públicas, a las privadas para nuestra closure
    let name = customerName;
    let email = customerEmail;

    //Nos "inventamos" los getter/setters directamente, con su lógica
    return {

        getName:    function() {

            return name;

        },

        setName:    function(value) {

            name = value.toUpperCase();
        
        },

        getMail:    function() {

            return email

        },

        setMail:    function(value) {

            if ( !value.includes('@') ) {

                console.warn('[WARN] -> Email no lleva @')
                throw new Error('Email inválido')
            }

            email = value;

        },

        calculateDiscount:  function(){

            return 12.99;
        }
    }


}