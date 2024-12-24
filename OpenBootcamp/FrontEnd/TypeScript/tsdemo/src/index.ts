/* 
* OpenBootcamp - TypeScript programm
* [x] Lesson 1: Introduction. Setting up a NodeJS environment.
* [x] Lesson 2: Language classifications - Variables - Data Types - Data casting - Reserved keywords - Control Structures
* [ ] Lesson 3: 
* [ ] Lesson 4:
* [ ] Lesson 5:
* [ ] Lesson 6:
* [ ] Lesson 7:
* [ ] Lesson 8:
*/

import { Stats } from "fs";
import { getPriority } from "os";
import { toNamespacedPath } from "path";
import { title } from "process";
import { takeCoverage } from "v8";

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
