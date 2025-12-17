# Ejercicio Pseudo-Código UML a Distintos lenguajes.

## UML Class / UML Object

## Encapsulación

## ES6 Closures / ES2022 this

***

### 0. Origen

Tomando como ejemplo la siguiente definición para una clase típica, para **JAVA**, que maneja datos de usuario y aplica ficticiamente un descuento a un precio:

```
// UML Class Definition
Customer
+ name: String
+ email: String
+ calculateDiscount(): Money

```

```
// Generated Java Code

public class Customer {
    private String name;
    private String email;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Money calculateDiscount() {
        // Implementation to be added
        return null;
    }
}
```

## 1. Esqueleto Básico

Basándote en el UML:

* Clase `Customer`
* Propiedades públicas: `name` (string) y `email` (string)
* Método público: `calculateDiscount()` que retorna un `number`

¿Cómo definirías la clase `Customer` en JavaScript? Empieza con la estructura básica.

```js
// 1. Esqueleto Básico, haciendo públicos las variables name y email

class Customer {

    constructor(name, email){

        this.name = name;
        this.email = email;
    }

    calculateDiscount() {

        /*
         * Fijamos un integer directamente
         * Más adelante podemos, dado el ejemplo,
         * especificar una operación matemática de dto.
         */
        return 127.99 - ( ( 127.99 * 12 ) / 100 )  
    }

}

```

### 2. Haciendo las variables no públicas, con getter / setter, usando ES2022.

* ¿Cómo modificarías tu clase Customer para usar get y set en lugar del acceso directo a las propiedades?

_Pista: Necesitarás decidir cómo almacenar internamente los valores (¿propiedades privadas con # o alguna convención?) y luego crear los getters/setters públicos._

Intenta reescribir tu clase usando propiedades privadas #name y #email, con sus respectivos getters y setters. ¿Cómo quedaría la estructura completa?.\
Incluye:

```
- Las propiedades privadas
- El constructor (que ahora debe asignar a las propiedades privadas)
- Los getters y setters
- El método calculateDiscount()
```

```js
class Customer {

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

```

### 3. Enfoques de uso

* ¿En qué situaciones reales necesitarías controlar cómo se accede o modifica una propiedad, versus simplemente permitir acceso directo?
* ¿Se te ocurre algún ejemplo donde podrías querer "interceptar" cuando alguien lee o cambia el `name` o `email`?

A la hora de querer crear un objeto de dicha clase, y tratar de implementar alguna función para algún objetivo, como validación de entrada.

Por ejemplo, estos son casos reales:

1. Implementar un sistema de validación de entrada de email
2. Reformateo de cadenas a .toUpperCase()
3. Métodos de consola para debug, warn, etc...

```js

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

```

### 4. ¿Cuál de estos casos te parece más práctico para el desarrollo real?

En etapas de desarrollo, cualquier método que nos ayude a lanzar Error, o alguna extensión de error.

También cualquier método de consola, como log, debug, warn, o alerts.

### 5. Si instanciamos una clase, dado el código actual, ¿Qué ocurriría?

```js
// Instanciación

let customer = new Customer('juan', 'email-sin-arroba')
```

Recibiríamos un error con el mensaje que hemos específicado ("Email tiene que llevar @").

### 5. Y, ¿Cómo era todo antes de ES2022? JS Closures, "a la antigua usanza", sin `constructor()`, haciénolo manualmente

* Las propiedades privadas `#` no existían en JavaScript antes de ES2022.\
  En sintaxis antigua solo teníamos la convención `_` (que no es realmente privada).\
  ¿Cómo lo harías " a la vieja usanza " ?

A través de una función (que usaremos PascalCase para este ejercicio, para asemejarla a la class), y **closures**, es decir, creando nuevos objetos privados, de alcance protegido, a la propia función, respecto a los públicos.

```js
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
```

### 6. Volviendo a UML

* Basándote en tu función Customer actual (que emula "a la antigua usanza" las clases, usando closure, con propiedades privadas, getters/setters, validaciones), ¿cómo representarías esto en UML?

Respecto a la clase Customer, con getter/setter explícitos, usaremos un diagrama de Clases con las siguientes características:

1. Nombre de Clase: Customer
2. Atributos:
   * \[Privado - ] name: String
   * \[Privado - ] email: String
   * \[Publico +] Customer(String, String)
3. Métodos:
   * \[Publico +] getName(): String
   * \[Publico +] setName(String): void
   * \[Publico +] getMail(): String
   * \[Publico +] setMail(String): void
   * \[Publico +] calculateDiscount(): Integer

* **Datos privados / Métodos públicos**
* Nuestras variables name y email son **privadas**.\
  Las customerX son sólo parámetros del consturctor, **no se consideran entonces para definir en UML**
* Los **getter / setter son siempre públicos**.\
  Son la "interfaz pública" para acceder a los datos privados.

La Sintáxis , con el software UMLetino por ejemplo, sería:

```
Customer
--
- name:	String
- email:	String

+ Customer(String, String)
--
+ getName():			String
+ setName(String):		void

+ getEmail():			String
+ setEmail(String):		void

+ calculateDiscount():	Number	

```

![large](../../../../../../../.gitbook/assets/Class-Customer_conGETTER.png)

\*\* Es importante señalar que UML, al final, no define código, sino conceptos de diseño.\*\*

La función `Customer()`:

* Tiene estado (name, email)
* Tiene comportamiento (getName, setName, etc.)
* Tiene encapsulación (datos privados, interfaz pública)
* Se puede instanciar (new Customer())

Eso ES una clase conceptualmente, sin importar si usas:

* class en JavaScript moderno
* function con closures
* function con prototipos
* class en Java/C#
* etc

En nuestro código "antiguo" como en el moderno, donde estamos especificando variables privadas, da igual si usamos una clase o lo hacemos "a la antigua usanza" usando una función con sus getter/setter, **en ambos casos es perfectamente aceptable usar Diagrama de Clases**.

### 7. UML actual, simplificado, sin variables privadas con interfaz pública.

![large](../../../../../../../.gitbook/assets/Class-Customer_SIMPLIFIC.png)

```
Customer
--
+ name:	String
+ email:	String

+ Customer(String, String)
--
+ calculateDiscount():	Number	
```
