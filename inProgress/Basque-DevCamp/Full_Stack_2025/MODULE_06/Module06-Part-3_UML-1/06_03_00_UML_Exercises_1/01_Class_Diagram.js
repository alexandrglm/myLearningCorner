// Class Diagram examples using JS

/*

CLASS DIAGRAM for class User

- CLASS NAME:   Users
- ATTRIBUTES:   username, password, Realname
- METHODS:      userInfo(), sendLogin()

So...

Users
--
+ username: String
- password: String
+ realname: Fullname
--
+ userInfo()
+ sendLogin()




Fullname
--
- firstName:    String
- surname:      String
+ username:     String
--
+ showRecord(firstName, surname, username): String


*/




class Usuario {
    constructor(username, password, nombreReal) {

        this.username = username;
        this.password = password;
        this.nombreReal = nombreReal;
    
    }

    userInfo() {
    
        return `USER -> ${this.username}\nNombre real: ${this.nombreReal.userRecord()}`;
    
    }

    sendLogin() {
    
        return `Login to ${this.username} account ...`;
    
    }
}

class NombreReal {

    constructor(nombre, apellidos, username) {
    
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.username = username;
    
    }

    userRecord() {
    
        console.debug('[DEBUG] La clase NombreReal ha sido usada');
        return `${this.apellidos.toUpperCase()}, ${this.nombre}`;
    
    }
}

let nombre = new NombreReal('Pepito', 'Perez Piscinas', 'pepito');
let user = new Usuario('pepito', 'contraseñaDePepito1234', nombre);

console.log( user.userInfo() );
console.log( user.sendLogin() );
