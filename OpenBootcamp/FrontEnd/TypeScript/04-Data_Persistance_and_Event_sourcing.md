# PENDING:
⚠️⚠️⚠️Pending: Reinstall&re-configure nodejs, --dev-tools nodemon rimraf ts-node, aliases, restarting environment.


# Session 4: DATA PERSISTANCE & EVENT SOURCING

### 1. LocalStorage --> Stores data in browser (Data isn't wasted automatically, code has to delete it)
### 2. SessionStorage --> Differnce is sessionBrowser based. Data are persistent at session side.
### 3. Cookies --> Has ExpirationDate, its scope is on URl.

#### 1. LocalStorage
```ts
function saveLocalStorage(): void {

    localStorage.set("name", "Pepe");

}

function readLocalStorage(): void {
   let nameLocalStorage =  localStorage.get("name");
}
```
#### 2. SessionStorage
Same as LocalStorage:  
```ts
function saveSessionStorage(): void {

    sessionStorage.set("name", "Juan");

}

function readSessionStorage(): void {
   let nameSessionStorage =  sessionStorage.get("name");
}
```

#### 3. Cookies

While own solutions can be coded, there are some ext dependences in frameworks as npm which resolves this.

Site: https://www.npmjs.com/
Modules: Cookies (Generic)
***


### Entire tsdemo BACKUP:  
```ts
/*
import { Stats } from "fs";
import { getPriority } from "os";
import { toNamespacedPath } from "path";
import { title } from "process";
import { takeCoverage } from "v8";
*/

console.log("Creating changes"); // primera linea

/*
nuestros comentarios de prueba
*/

// Var declarations
var name: string = 'Alexandr'; // This is a global var

console.log("Hola, " + name); // Option1
console.log("How are you", name, "?"); // TS concatenating allows "string" COMMA variable COMMA ... That's to say concatenation can be COMMA separated
console.log(`How went your vacations, ${name}, ?`);

let email = "mail@mail.com" // this is a local variable
console.log(`${name}'s e-mail is ${email}`);

const PI: number = Math.PI;

// Weak typing importance: The data type shouldn't change.

// JS way
/*
var surname = "Gomez";
surname = 3; // WARN is shown, type CANNOT change
*/

// TS way
var surname2: any = "Lucendo"; // ANY word lets changing data type
surname2 = 3;

// With booleans, redundant but it defines the type
var error: boolean = false;

// Booleans undleclared, then declared
var error2;
error2 = false; // From this point, the variable is a boolean, but it's an ANY type.

var error3: boolean; // Data type has been defined, it won't able to change.
error3 = true;

console.log(`Are there any error?: ${error}`);

// Declaring Multiple Variables (Instantiation of multipe variables)
/*
let a,b,c // instant 3 variables with no initial value
let a:string,b:boolean,c:number;  // instan 3 variables with no initial value but with data type attached
*/

let a:string,b:boolean,c:number;
a = "TypeScript";
b = true;
c = 9.8;

// Built-in Types: number, string, boolean, void, null, undefined

// Data types as lists, arrays, are more complex.
let toDoList: string[] = ["Task 1", "Task 2"]; // varname: type[]

let values: (string | number | boolean)[] = [false, "Hola", true, 36]; //varname: {type | type | type}

// Numbered values:
/*
Their order, if unspecified, starts from 0.
They can be ordered (numbered, lettered) as needed.
*/

// 1st. Defining the enumerating variable and its options-attributes.
enum Situation {
    Completed,
    Incompleted,
    Pending
}

// 2nd. Giving what status has another (the desired) object:
let taskStatus: Situation = Situation.Completed;

enum WinningPoint {
    first = 1,
    second, // When the first enumerated value is given, the next values follow its order so, it's not needed to define them
    third
}

let winningMarathon: WinningPoint = WinningPoint.second;

// Interfaces

interface TaskInterface {
    Named: string;
    Situation: Situation;
    PriorTo: number;
}

// Interfaces. Creating. Using.
// From here, we can create variables which follow the TaskInterface

interface TaskInterface {
    Named: string; 
    Situation: Situation; // Assuming Situation is an enum or a type
    PriorTo: number;
}

let Task1: TaskInterface = {
    Named: "Example",
    Situation: Situation.Pending, 
    PriorTo: 10
};

console.log(`Task: ${Task1.Named}`); 

// Theory:

/**
 * Interfaces in TypeScript define a contract or a blueprint for objects. 
 * They specify the shape of an object by defining the properties and their data types.
 
 * In this example:
 *   - `TaskInterface` defines an interface with three properties: 
      - `Named`: a string representing the task name.
      - `Situation`: a value of the `Situation` type (enum or custom type).
      - `PriorTo`: a number representing the task priority.
 *   - `Task1` is a variable that is declared to be of type `TaskInterface`. 
     This ensures that `Task1` adheres to the structure defined by the interface.
 */


// Assigning Multiple Values/Variables

/**
 * This block demonstrates two ways to assign values from an object to variables:
 * 1. Expanded assignment: Assigning each property to a separate variable individually.
 * 2. Destructuring assignment: Extracting multiple properties at once using a concise syntax.
 */

let myTask = {
    NameMyTask: 'My Task', 
    SituationMyTask: Situation.Completed, 
    PriorToMyTask: 1 
};

// Expanded assignment
let MyTitle = myTask.NameMyTask; 
let MySituation = myTask.SituationMyTask;
let MyPriorTo = myTask.PriorToMyTask;

// Destructuring assignment
let { NameMyTask, SituationMyTask, PriorToMyTask } = myTask; 


// ** FACTOR SPREAD (Propagation)
// Variable assignation

/**
 * This section demonstrates the use of the spread syntax (...) to combine and manipulate arrays and objects. 
 * The spread syntax allows you to "spread" the elements of an iterable (like an array) into another array or 
 * the properties of an object into another object.
 */

// By Using LISTS
let shoppingCartMonday: string[] = ["Model1", "Model2"];
let shoppingCartTuesday: string[] = [...shoppingCartMonday, "Model3", "Model4"];
let shoppingCartWednesday: boolean[] = [false]; 

let shoppingCartEntireWeek = [...shoppingCartMonday, ...shoppingCartTuesday]; 

// By using OBJECTS
let SituationApp = {
    username: "admin",
    session: 3,
    jwr: "ABDEFG"
};

// Create a new object with the same properties as SituationApp, but with an updated session value
let newSituationApp = { 
    ...SituationApp, 
    session: 4 
};

// Types of TypeScript: Creating new types.
type Product = {
    price: number;
    name: string;
    year: number;
};

let car: Product = {
    name: "Audi",
    price: 45000,
    year: 2012
};

console.log(`Car: ${car.name}`);
console.log(car.year < 2012 ? `Car: ${car.year} is older` : `Car: ${car.year} is newer`);

// CONDITIONALS

// Ternary operator:
console.log(car.year < 2012 ? `Car: ${car.year} is older` : `Car: ${car.year} is newer`);

// If - else 
let error4: boolean = false; // Declaring a variable for the condition
if (error4) {
    console.log(`There are errors`);
} else {
    console.log(`There are no errors`);
}

// If - else if - else
if (car.year < 2010) {
    console.log(`Coche: ${car.name} is old`);
} else if (car.year == 2010) {
    console.log(`Coche: ${car.name} is from 2010`);
} else {
    console.log(`Coche: ${car.name} is new`);
}

// Switch
switch (Task1.Situation) {
    case Situation.Completed:
        console.log('Task completed');
        break;
    case Situation.Incompleted:
        console.log('Task incomplete');
        break;
    case Situation.Pending:
        console.log('Task is pending');
        break;
    default:
        console.log(`Error`);
}

try {
    // Code that may throw an error
} catch (error: any) { // Declare the type for error
    console.log("An error occurred:", error);
}

// **LOOPS**

// Given an array ...
let newTaskList: TaskInterface[] = [
    {
        Named: "Task 1",
        Situation: Situation.Completed,
        PriorTo: 2
    },
    {
        Named: "Task 2",
        Situation: Situation.Completed,
        PriorTo: 2
    },
    {
        Named: "Task 3",
        Situation: Situation.Completed,
        PriorTo: 2
    }
];

/* FOR loop 
* Iterates a specific number of times based on a counter variable
*/

for (let index = 0; index < newTaskList.length; index++) {
  const task = newTaskList[index];
  console.log(`FOR LOOP: ${index} - ${task.Named}`);
}

/* forEach loop
* Executes a function for each element in an array
*/

newTaskList.forEach((task: TaskInterface, index: number) => {
  console.log(`${index} - ${task.Named}`);
});

/* FOR....IN loop
* Iterates over the enumerable properties of an object (including inherited ones)
* It's generally not recommended to use for-in loops with arrays as it iterates over indexes (strings) instead of actual elements.
*
* This FOR....IN example is commented due to the nature of the loop, which could break our entire code.
/*
let singleTask: TaskInterface = {
    Named: "Single Task",
    Situation: Situation.Pending, 
    PriorTo: 5 
};

for (const key in singleTask) {
    if (Object.prototype.hasOwnProperty.call(singleTask, key)) {
        console.log(`FOR-IN loop: Property: ${key}, Value: ${singleTask[key]}`); 
    }
}    
*/


/* WHILE loop
* Executes a code block repeatedly as long as a condition is true
*/

let taskToProcess: TaskInterface = {
    Named: "Task to Process",
    Situation: Situation.Pending, 
    PriorTo: 1 
};

while (taskToProcess.Situation === Situation.Pending) { 
    if (taskToProcess.PriorTo >= 10) {
        taskToProcess.Situation = Situation.Completed; 
    } else {
        taskToProcess.PriorTo++; 
    }
}
console.log(`WHILE loop: Task Status: ${taskToProcess.Situation}`);

/* DO-WHILE loop
* Executes a code block at least once, then repeats as long as a condition is true
*/

let counter = 0;

do {
    counter++;
} while (counter < 5);

console.log(`DO-WHILE loop: Counter: ${counter}`); 

/* 
SESSION #3.  FUNCTIONS
Abstract:

- Best Practices (2):
  
  - Well-documented code. (JSDoc)
  - Explicit typing. (Avoiding 'any' type by declaring every type).
  - Parameters passing
  - Function Overloading.
  - Conciseness code.
- Variable Scoope & Hoisting
  
- Functions:
  
  - Declarations
  - Parameters
  - `Async Functions` VS `function* Generators`
  - `Worker`s and `Saga`s

// Functions

/**
 * This is a documenting JSDoc method
 * Best Practices with functions:
 * Giving a self-explicative name 
 */


/**
 * This is a documenting JSDoc method
 * Best Practices with functions:
 * Giving a self-explicative name 
 */
function greeting(){
    let name = "Pepito";    // Variable scoope: Not globally. locally.
    console.log(`Hello ${name}!`);
    
}

greeting();     // The Invoke

/**
 * This Function shows a greeting on the console to a person.
 * @param name The person name to be welcomed
 */

function greetingParametrised(name: string){ // strongTyped language? So, if name has been declarated as string .... string will be.
    console.log(`Hello ${name}!`);
}

const person = "Juanito";

greetingParametrised(person); //
greetingParametrised("Menganito"); //
greetingParametrised(33 as unknown as string); // Parsing values "as"... "as unknown as", magic keywords for intentionally parsing one data type to another


/**
 * 
 * @param name Person name will be, as declarated, = "Pepe"
 */
function farewellPerson(name: string = "Pepe"){
    console.log(`Bye, ${name}`);
}

farewellPerson() // console: Bye, Pepe
farewellPerson("Alba"); // console: Bye, Alba

/**
 * This function shows a farewell to the given name person, if this has been given; when not given, as we used "?:" we created both cases
 * @param nombre (Optional) The person name to be farewelled
 */

function farewellOptional(nombre?: string){
    if (nombre){
        console.log(`Bye, ${name}!`);
    } else {
        console.log(`Bye!`);
    }
}

farewellOptional(); // Console. Bye!
farewellOptional("Juanjo"); // Console: Bye, Juanjo!


let name0, surname0, age0 = undefined;

function manyParams(name0: string, surname0?: string, age0: number = 18){
    if (surname0) {
        console.log(`${name0} ${surname0} is ${age0} years old`)
    } else {
        console.log(`${name0} is ${age0} years old`)   
    }
};

manyParams("Martin"); // Console: Martin is 18 years old
manyParams("Martin", "Gonzalez"); // Console: Martin Gonzalez is 18 years old
manyParams("Martin", undefined, 30); // Console: Martin is 30 years old
manyParams("Martin", "Gonzalez", 30); // Console: Martin Gonzalez is 30 years old
manyParams(name0="Martin", surname0="Gonzalez", age0=30); // Martin San Jose is 30 years old


function greetingManyDataTypes(a: string | number ){

   if ( typeof (a) === `string` ){
    console.log("A is a string");
   } else if ( typeof (a) === `number` ){
        console.log("A is a number");
     } else {
        console.log("A is not a string nor a number");
        throw Error("A input error, not a string not a number");
     }
};

greetingManyDataTypes("Hola");
greetingManyDataTypes(3);
greetingManyDataTypes(true as unknown as number); // A boolean is not permitted because the function(params) has told to not to be other than string and/or number (as unknown as used here to pass the code as an example)




function exampleReturn(name0?: string, surname0?: string): string | number {
    return '${name0} ${surname0}';
}

exampleReturn(name0="Martin", surname0="Gonzalez"); 

const nameAndSurname = exampleReturn("Martin", "Gonzalez");

// Function Overloading


// Dos formas de hacer lo mismo.
// Podemos devolver propiedades
console.log(nameAndSurname); // Console: Martin Gonzalez
console.log(exampleReturn("Martin", "Gonzalez")) // Console: Martin Gonzalez


/* By FACTOR SPREAD*/
// No especificamos cuantos valores exactos se recibirán.

function exampleMultiParams(...names: string[]) {
    names.forEach( (name0) => {
        console.log(name0);
        return ""; // Al haber especificado ...names as a : string, something has to be returned even being "" empty
    });
}

exampleMultiParams("Martin");
exampleMultiParams("Martin", "Pepe", "Juan", "Alba");

// One more example using an array

const list4 = ["Alberto", "Pepito"];
exampleListParams(list4);

function exampleListParams(names4: string[]) {
    names4.forEach((name4) => { 
        console.log(name4);
    });
}
exampleListParams(["Alba", "Juan"]);
exampleListParams(list4);



// VOID data type example.
// VOID ... a value to aVOID ;-)


/**
 * 
 * @param names5 return VOID, nothing.
 */
function exampleListParamsVoid(...names5: string[]): void {
    names5.forEach((name5) => {
        console.log(name5);
    });
}

exampleListParamsVoid("Alba", "Juan", "Pepito");



/*
 TypeScript permits having a more interesting logic by letting functions to be worked with or without parameters

 Podemos pasar parámetros de muchas diferentes formas.

 Podemos poner valores por defecto de muchas maneras.

*/

// ARROW FUNCTION & THE EXPLANATION OF type


/* Sin especificar tipo, estamos dando paso a que la variable employee tenga implicitamente ANY type
*/

/*
let employee = { // the variable has implicity the ANY type
    name6: "Pepe",
    surname6: "Juarez",
    age6: 36
}

const employeege = (employee) => `${employee.name6} is ${employee.age6} years old`;
*/


/* Una buena práctica es crear el type de dicha variable, especificando cada type de data del array
*/

// Definyng the type for the object (employeeTyped)
type employeeType = {
    name7: string;
    surname7: string;
    age7: number;
};

/* Creating an object of employeeType type ... whose content has to fit the previous type definitons, so...
    - 'name7' as a string
    - surname7' as a string
    - 'age7' as a number
*/

let employeeTyped: employeeType = {
    name7: "Martin",
    surname7: "Gonzalez",
    age7: 42
};

/* Here, a function called employeeTypedAge is created, using the previous type defined,
it will be returner as a :string with name7, surname7 and age7 attached to.
*/
const employeeTypedAge = (employeeTyped: employeeType):string => `${employeeTyped.name7} ${employeeTyped.surname7} is ${employeeTyped.age7} years old`

// Invoking the function parsing the object as an argument
employeeTypedAge(employeeTyped);


/* Now, this function verifies if a employee can get the retirement or no
*/
const employeeTypedData = (employeeTyped: employeeType): string => {
    
    if ( employeeTyped.age7 >= 70 ) {
        return `Employee ${employeeTyped.name7} ${employeeTyped.surname7}, being ${employeeTyped.age7} years old, is allowed to get retirement`;
    } else {
        return `Employee ${employeeTyped.name7} ${employeeTyped.surname7}, being ${employeeTyped.age7} years old, is NOT allowed to get retirement`
    }
};

console.log(employeeTypedData(employeeTyped)); // "Employee Martin Gonzalez, being 42 years old, is NOT allowed to get retirement"



// Embebbed functions (a function inside another function)
/* Given the function 'getPaysheet' with 2 parameters:
    - 'employeeTyped': The object ... as employeeType type defined previosly.
    - 'ammount': A function "() => void", which is an empty callback (VOID returns NOTHING).
    
This function choose if the object meets the conditions, or not, to follow with the declared function ( if the employee has to get the monthly payroll, or not due to the nature of being retired depending on the age) */

const getPaysheet = (employeeTyped: employeeType, ammount: () => void): void => {
    if ( employeeTyped.age7 >= 70 ) {
        return // return nothing, do nothing, the object doesn't meet the conditions
    } else {
        ammount() // callback to be executed if the object meet the conditions
    }
};


/* Definimos otra función llamada 'employeeCollectsPayroll' que recibe un empleado como parámetro 
y simplemente imprime un mensaje indicando que el empleado ha recogido su nómina. */
const employeeCollectsPayroll = (employeeTyped: employeeType): void => {
    console.log(`${employeeTyped.name7} ${employeeTyped.surname7} collects the monthly payroll`);
};
    
/* Llamamos a 'getPaysheet' nuevamente, pero esta vez pasamos 'employeeCollectsPayroll' 
    como un callback. Para pasar esta función, la envolvemos en una función anónima (lambda) */
getPaysheet(employeeTyped, () => employeeCollectsPayroll(employeeTyped));

/*
* ASYNC FUNCTIONS & GENERATOR FUNCTIONS
*/
 
// Async functions
// "En algun momento quiero que esta tarea se ejecute"

async function exampleAsync(): Promise<string> {

    //Await
    await console.log("Tarea a completar antes de seguir con la secuencia de instrucciones");
    console.log("La promesa se alcanzó ergo tarea se ha compleado")
    return "Completed";
};

// .then
exampleAsync().then ((answer) => {
    console.log("Answer", answer)
});
// .catch
exampleAsync().catch ((error) => {
    console.log("An error has been catched")
});
// .finally
exampleAsync().finally(() => "All task done.");


/* promise methods explainded:
* .then = Cuando la promesa se alcanza, entonces haz esto
* .catch = Atrapa un estado, por ejemplo de error, en toda la ejecución
* .finally = Cuando todo ha terminado, haz esto.
*/



// Generator Functions
// como un iterador
// Pueden emitir nuevos valores, que se van "escuchando" y procesando


function* exampleGenerator() {

    // yield word! -> para emitir valores, como un método de suscripción

    let index = 0;
    while (index <5) {
        // Mientras el indice sea menor a 5, emitimos un valor
        yield index++;
    }
};
// Guardamos la función generadora en una variable
let generator = exampleGenerator();

// Ahora accedemos a los valores emitidos

console.log(generator.next().value); // será 0
console.log(generator.next().value); // será 1
console.log(generator.next().value); // será 2
console.log(generator.next().value); // será 3



// Worker and Saga
// se usa para gestionar el estado de la función
// haitual en react, angular, ...

function* watcher(aValue: number) {

    yield aValue; // emitimos el valor inicial

    yield* workerGenerator(aValue); // llamamos a las emisiones del worker para que emita otros valores

    yield aValue + 10; // emitimos el valor final

}

function* workerGenerator(aValue: number) {
    yield aValue + 1;
    yield aValue + 2;
    yield aValue + 3;

}

let generatorSaga = watcher(0);

console.log(generatorSaga.next().value); // será 0 (lo ha hecho el watcher)
console.log(generatorSaga.next().value); // será 1 (lo ha hecho el watcher)
console.log(generatorSaga.next().value); // será 2 (lo ha hecho el watcher)
console.log(generatorSaga.next().value); // será 3 (lo ha hecho el watcher)
console.log(generatorSaga.next().value); // será 10 (lo ha hecho el watcher)


////////////////////////////////////////////////////////////////////////////////

// Session 4: DATA PERSISTANCE & EVENT SOURCING

//  1. LocalStorage --> Stores data in browser (Data isn't wasted automatically, code has to delete it)
//  2. SessionStorage --> Differnce is sessionBrowser based. Data are persistent at session side.
//  3. Cookies --> Has ExpirationDate, its scope is on URl.


// 1. LocalStorage

function saveLocalStorage(): void {

    localStorage.set("name", "Pepe");

}

function readLocalStorage(): void {
   let nameLocalStorage =  localStorage.get("name");
}

// 2. SessionStorage

function saveSessionStorage(): void {

    sessionStorage.set("name", "Juan");

}

function readSessionStorage(): void {
   let nameSessionStorage =  sessionStorage.get("name");
}

/* 
3. Cookies

While own solutions can be coded, there are some ext dependences in frameworks as npm which resolves this.

Site: https://www.npmjs.com/



*/
```

