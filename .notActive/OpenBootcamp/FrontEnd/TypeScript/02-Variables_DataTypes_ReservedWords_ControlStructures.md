# 02-Variables\_DataTypes\_ReservedWords\_ControlStructures

## **TypeScript 02: Variables, Data Types, Reserved Words, and Control Structures**

### **🔹 Understanding Type Systems in Programming**

#### **📌 Typed vs Non-Typed Languages**

* **Typed Languages**: Require explicit type definitions for variables (e.g., TypeScript, C, Java, Rust).
* **Non-Typed Languages**: Do not enforce strict type definitions (e.g., JavaScript, Python, PHP).

#### **📌 Static vs Dynamic Typing**

* **Dynamically Typed**: Variables can change their type at runtime.
  * Example: JavaScript, PHP, Ruby, Python.
* **Statically Typed**: Variables have fixed types known at compile-time.
  * Example: TypeScript, C, C++, Java.

#### **📌 Strong vs Weak Typing**

* **Strongly Typed**: Enforces strict type rules (e.g., TypeScript, Python).
* **Weakly Typed**: Allows implicit type conversions (e.g., JavaScript, PHP).

📖 **Official Docs:** [TypeScript Handbook - Basics](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html)

***

### **🔹 Declaring Variables in TypeScript**

In TypeScript, variables are declared using `var`, `let`, and `const`:

```ts
let name: string = "Alice";
const age: number = 30;
var isOnline: boolean = true;
```

* `let` → Block-scoped, preferred over `var`.
* `const` → Immutable (read-only) variables.
* `var` → Function-scoped (avoid using it in modern TypeScript).

📖 **Official Docs:** [TypeScript Variable Declarations](https://www.typescriptlang.org/docs/handbook/variable-declarations.html)

***

### **🔹 Reserved Words in TypeScript**

#### **1️⃣ Reserved Keywords**

Words that have predefined meanings in TypeScript and cannot be used as variable names:

```ts
break, case, catch, class, const, continue, debugger, default, delete, do,
else, enum, export, extends, false, finally, for, function, if, import,
in, instanceof, new, null, return, super, switch, this, throw, true,
try, typeof, var, void, while, with
```

#### **2️⃣ Strict Mode Reserved Words**

Additional words reserved in strict mode:

```ts
as, async, await, implements, interface, let, package, private, protected,
public, static, synchronized, volatile, yield
```

📖 **Official Docs:** [TypeScript Keywords](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html#type-annotations)

***

### **🔹 Best Practices in TypeScript**

#### ✅ **Use Template Literals for String Concatenation**

Instead of:

```ts
console.log("Hello, " + name + ". How are you?");
```

Use:

```ts
console.log(`Hello, ${name}. How are you?`);
```

📖 **Official Docs:** [Template Literals](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Template_literals)

#### ✅ **Always Specify Data Types**

```ts
let year: number = 2024;
let fullName: string = "Alice Johnson";
let isActive: boolean = true;
```

📖 **Official Docs:** [Type Annotations](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html#type-annotations)

#### ✅ **Use `any` with Caution**

The `any` type allows changing a variable's type dynamically, but it should be used sparingly as it removes TypeScript’s type safety.

```ts
let value: any = "Hello";
value = 42;  // No error, but bad practice
```

📖 **Official Docs:** [The `any` Type](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html#any)

***

### **🔹 TypeScript Built-in Data Types**

| **Type**    | **Example**                                   |
| ----------- | --------------------------------------------- |
| `string`    | `let name: string = "Alice";`                 |
| `number`    | `let age: number = 30;`                       |
| `boolean`   | `let isOnline: boolean = true;`               |
| `undefined` | `let value: undefined;`                       |
| `null`      | `let empty: null = null;`                     |
| `void`      | Used in functions that do not return a value. |
| `object`    | `{ id: 1, name: "John" }`                     |

📖 **Official Docs:** [Basic Types](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html#the-primitives-string-number-and-boolean)

***

### **🔹 Conditional Structures**

#### **1️⃣ Ternary Operator**

```ts
const result = age > 18 ? "Adult" : "Minor";
```

#### **2️⃣ If-Else**

```ts
if (age > 18) {
    console.log("Adult");
} else {
    console.log("Minor");
}
```

#### **3️⃣ Switch Statement**

```ts
switch (age) {
    case 18:
        console.log("Just turned adult");
        break;
    case 21:
        console.log("Legal drinking age");
        break;
    default:
        console.log("Just another year");
}
```

📖 **Official Docs:** [Control Flow](https://www.typescriptlang.org/docs/handbook/2/narrowing.html)

***

### **🔹 Loop Structures**

#### **1️⃣ For Loop**

```ts
for (let i = 0; i < 5; i++) {
    console.log(i);
}
```

#### **2️⃣ While Loop**

```ts
let count = 0;
while (count < 5) {
    console.log(count);
    count++;
}
```

#### **3️⃣ Do-While Loop**

```ts
let counter = 0;
do {
    console.log(counter);
    counter++;
} while (counter < 5);
```

📖 **Official Docs:** [Loops and Iteration](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html#arrays)

***

### **🚀 Summary & Key Takeaways**

✔ TypeScript is a **statically typed** language that enforces type safety.\
✔ Use `let` and `const` instead of `var` for variable declarations.\
✔ Always specify data types for variables (`string`, `number`, `boolean`, etc.).\
✔ Avoid using `any` unless absolutely necessary.\
✔ Use `template literals` for string interpolation.\
✔ Follow best practices for clean and maintainable TypeScript code.\
✔ Use `control structures` and `loops` efficiently for flow control.

📖 **Official Docs:** [TypeScript Handbook](https://www.typescriptlang.org/docs/handbook/2/everyday-types.html)

***

### Original guide:

## 🔸 DEFINITIONS

### Type Data Casting: Defining types of languages by data type.

#### Typed Languages / Non-Typed languages

#### Static type / Dynamic Type

* **DYNAMIC TYPED:** _Not Compiled / Type Datacasting allowed_

As the propper name tells, dynamics are flexible on data casting. A value can be a string, then a number, then a boolean.\
Dynamic languages, as JavaScript, give results in a simple way but, when the project is growing, debugging/correcting errors becomes a nightmare.\
Dynamics verifies the types on-exec so that debugging/correcting/mitigating errors can be made late enough.\
Examples of dynamic languages: JavaScript, PHP, Ruby, Perl, ...

* **STATIC TYPED**: _Compiled / Forbidden Type Datacasting_

On the other hand, Static Typed languages does not allow to change a data type on a var value.\
Debugging process can be made on time due to the compilation process instead of discovering them on execution time.\
Example of static typed languages are C, C#, C+, C++, Java, Kotlin, Rust, ...

#### _Strong Typed_ / _Weak Typed_ Languages

It refers how many strict or not is a language to permit changes in the data type from a variable.

* A resctrictive **Strong** Typed language won't allow the data casting. There are few exceptions when parsing integers to flotaing point numbers.
* A permissive **Weak** Typed language allows to change the data on the-fly, in a simple way.

***

### Values: var / const

A variable can be defined with `var`, `let` or a `const` (A constant, a value that cannot change).

***

## 🔸 TypeScript Reserved Words

#### 1. **Reserved Words**

| Reserved Words |
| -------------- |
| `break`        |
| `case`         |
| `catch`        |
| `class`        |
| `const`        |
| `continue`     |
| `debugger`     |
| `default`      |
| `delete`       |
| `do`           |
| `else`         |
| `enum`         |
| `export`       |
| `extends`      |
| `false`        |
| `finally`      |
| `for`          |
| `function`     |
| `if`           |
| `import`       |
| `in`           |
| `instanceof`   |
| `new`          |
| `null`         |
| `return`       |
| `super`        |
| `switch`       |
| `this`         |
| `throw`        |
| `true`         |
| `try`          |
| `typeof`       |
| `var`          |
| `void`         |
| `while`        |
| `with`         |

#### 2. **Strict Mode Reserved Words**

| Strict Mode Reserved Words |
| -------------------------- |
| `as`                       |
| `async`                    |
| `await`                    |
| `implements`               |
| `interface`                |
| `let`                      |
| `package`                  |
| `private`                  |
| `protected`                |
| `public`                   |
| `static`                   |
| `synchronized`             |
| `volatile`                 |
| `yield`                    |

#### 3. **Contextual Keywords**

| Contextual Keywords |
| ------------------- |
| `abstract`          |
| `any`               |
| `byte`              |
| `boolean`           |
| `char`              |
| `constructor`       |
| `declare`           |
| `get`               |
| `int`               |
| `module`            |
| `require`           |
| `number`            |
| `set`               |
| `string`            |
| `symbol`            |
| `type`              |
| `from`              |
| `of`                |

***

## 🔸 TS Best Practices (1) ✅✅✅

#### ✅ Using Backtips (\`) when concatening phrases.

Given a variable called name ( `let name = Pepito`), there are many syntax ways to create concatenated phrases, but one of them is the prefered:

_"Hello, " + name + ". How are you"_\
&#xNAN;_"How are you", name, "?"_

_`Where were you born, ${name} ?`_ » **This is the best syntax mode**.\
TS concatenating allows "string" COMMA variable COMMA ...

#### ✅ Even being refundant, always declare the data type.

```ts
var year: number = 2024;
var name: string = "Jane";
var onlineStatus: boolean = false;
```

***

#### ✅ _ANY_ reserved word.

A value can be data-type changed by using `: any` reserved word, but it has to be used with caution (_: any_ breaks the strongness type of TypeScript).

```ts
var surname: any = "Jhonson"; // ANY word lets changing data type
surname = 3; // This will be accepted, a warning won't be shown at console/debugging process
```

***

## 🔸 DATA TYPES

### BUILT-IN DATA TYPES:

1. String
2. Number (Integer "int", Biginteger "bigint", Floating, NaN, ...)
3. Bolean
4. Undefined
5. Null
6. Void
7. Symbol
8. Object

***

#### ⚡ DATA TYPE in ARRAYS, LISTS, ...

```ts
let toDoList: string[] = ["Task 1", "Task 2"]; // varname: type[]

let values: (string | number | boolean)[] = [false, "Hola", true, 36]; //varname: (type | type | type)
```

***

#### ⚡ NUMBERED VALUES (enum)

Enum defines a set of named constants.\
Their order, if unspecified, starts from 0. They can be ordered (numbered, lettered) as needed.

*   1st. Defining the enumerating variable and its options-attributes.

    ```ts
    enum Situation {
      Completed,
      Incompleted,
      Pending
    }
    ```
*   2nd. Giving what status has another (the desired) object:

    ```ts
    let taskStatus: Situation = Situation.Completed;
    ```

enum WinningPoint {\
first = 1,\
second, // When the first enumerated value is given, the next values follow its order so, it's not needed to define them\
third\
}

let winningMarathon: WinningPoint = WinningPoint.second;

````
***


# INTERFACES:
An interface defines how a class or object should behave. It specifies a set of methods or functions that a class must implement.

```TS
// From here, we can create variables which follow the TaskInterface

let Task1: TaskInterface = {
    Named: "Example",
    Situation: Situation.Pending,
    PriorTo: 10
};

console.log(`Task: ${Task1.Named}`);

 * In this example:
 *   - `TaskInterface` defines an interface with three properties: 
      - `Named`: a string representing the task name.
      - `Situation`: a value of the `Situation` type (enum or custom type).
      - `PriorTo`: a number representing the task priority.
 *   - `Task1` is a variable that is declared to be of type `TaskInterface`. 
     This ensures that `Task1` adheres to the structure defined by the interface.
 */
````

***

#### ⚡ Assigning Multiple Values/Variables

1. **Expanded assignment**: Assigning each property to a separate variable individually.
2. **Destructuring assignment**: Extracting multiple properties at once using a concise syntax.

```ts
let myTask = {
    NameMyTask: 'My Task', 
    SituationMyTask: Situation.Completed, 
    PriorToMyTask: 1 
};
```

**1 - EXPANDED ASSIGNMENT**

```ts
let MyTitle = myTask.NameMyTask; 
let MySituation = myTask.SituationMyTask;
let MyPriorTo = myTask.PriorToMyTask;
```

**2 - DESTRUCTURING ASSIGNMENT**

```ts
let { NameMyTask, SituationMyTask, PriorToMyTask } = myTask;
```

***

### SPREAD SYNTAX (Factored spread, variable propagation)

The spread syntax allows you to "spread" the elements of an iterable (like an array) into another array or the properties of an object into another object.

#### ⚡ By using LISTS

```ts
let shoppingCartMonday: string[] = ["Model1", "Model2"];
let shoppingCartTuesday: string[] = [...shoppingCartMonday, "Model3", "Model4"];
let shoppingCartWednesday: boolean[] = [false]; 

let shoppingCartEntireWeek = [...shoppingCartMonday, ...shoppingCartTuesday]; 
```

#### ⚡ By using OBJECTS

```ts
let SituationApp = {
    username: "admin",
    session: 3,
    jwr: "ABDEFG"
};

let newSituationApp = { 
    ...SituationApp, 
    session: 4 
};
```

***

### TYPES of TypeScript: Creating new types.

```ts
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
```

***

## CONTROL STRUCTURES

### 🔸 CONDITIONALS

#### ⚡ Ternary operator:

```ts
console.log(car.year < 2012 ? `Car: ${car.year} is older` : `Car: ${car.year} is newer`);
```

***

#### ⚡ If ... else

```ts
let error4: boolean = false; // Declaring a variable for the condition
if (error4) {
    console.log(`There are errors`);
} else {
    console.log(`There are no errors`);
}
```

***

#### ⚡ If ... else if ... else

```ts
if (car.year < 2010) {
    console.log(`Coche: ${car.name} is old`);
} else if (car.year == 2010) {
    console.log(`Coche: ${car.name} is from 2010`);
} else {
    console.log(`Coche: ${car.name} is new`);
}
```

***

#### ⚡ Switch statement

```ts
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
```

***

## 🔸 LOOPS

```ts
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
```

#### ⚡ FOR loop

Iterates a specific number of times based on a counter variable.

```ts
for (let index = 0; index < newTaskList.length; index++) {
  const task = newTaskList[index];
  console.log(`FOR LOOP: ${index} - ${task.Named}`);
}
```

#### ⚡ forEach loop

Executes a function for each element in an array.

```ts
newTaskList.forEach((task: TaskInterface, index: number) => {
  console.log(`${index} - ${task.Named}`);
});
```

#### ⚡ FOR....IN loop

Iterates over the enumerable properties of an object (including inherited ones).\
It's generally not recommended to use for-in loops with arrays as it iterates over indexes (strings) instead of actual elements.\
⚠️⚠️⚠️ This FOR....IN example is out of coding lesson due to the nature of the loop, which could break our entire code.

```ts
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
```

#### ⚡ WHILE loop

Executes a code block repeatedly as long as a condition is true

```ts
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
```

#### ⚡ DO...WHILE loop

Executes a code block at least once, then repeats as long as a condition is true.

```ts
let counter = 0;

do {
    counter++;
} while (counter < 5);

console.log(`DO-WHILE loop: Counter: ${counter}`); 
```

***

📖 _index.ts_ typed on this lesson:

```ts
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
```

### Source:

[OpenBootCamp - TypeScript course](https://www.youtube.com/watch?v=wutMZAg2t_4\&list=PLkVpKYNT_U9egW5padLMHmnTPb6xm4hLf\&index=3)
