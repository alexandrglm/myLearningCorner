# 🔸 SESSION #3 FUNCTIONS (Part 1)

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
  

# 🔸 TS Best Practices (2) ✅✅✅

### ✅✅✅ Code is easy to be understood

- ✅ By giving self-explicative names to vars, functions, ...
- ✅ Var, values, params., functions,... anything follows a clear way to be named.
  
  ```text
  This is **camelCase** typing ✅  
  And this is **snake_Case** typing ✅ 
  
  
  But this is **aproblematicwayoftypingtobeavoided** ❌
  ```
  

- ✅ By using **JSDoc** method on each function:
  

````
```ts
/**
 * This is a documenting JSDoc method
 * Best Practices with functions:
 * Giving a self-explicative name 
 */
````

## ✅✅✅ Code is explicit even the redundance

### ✅ Avoid the ': ANY' type

*Any* data type is not explicitly nor implicitly used.

Instead of using any, try defining specific types to ensure type safety in your code.

By always declaring the data type, code compilation and execution is prevented from unwanted behaviours, errors, and so on.

✅ CORRECT:

```ts
let correctWay: string = `It has to be a string. Another data type will cause errors`;
```

❌ WRONG:

```ts
let wrongWay = `This lets implicetely ANY type and will bring a lot of errors, warnings, breakpoints... Avoid it`
```

### ✅ Define explicit types for both parameters and return values.

This helps avoid errors and improves code clarity.

```ts
// Definyng the type for the next object

type employeeType = {
    name7: string;
    surname7: string;
    age7: number;
};

// Creating the object whose content has to fit the previous type definitons, so...

let employeeTyped: employeeType = {
    name7: "Martin",
    surname7: "Gonzalez",
    age7: 42
};
```

## ✅✅✅ Code is consice, efficient

### ✅ Function Overloading

Function overloading handles multiple function signatures with different types or numbers of parameters.

We use the function overloading when a to-do decision has to be donde depending on what kind of value has been given.

❌ WRONG:

```ts
function showError(errorType: string): void {
    console.log("An error has ocurred", errorType);
}

❌ WRONG:❌ WRONG:❌ WRONG:❌ WRONG:❌ WRONG:❌ WRONG:
function showError(errorType: number, codeType: number): void {
    // WRONG WRONG WRONG
    console.log("An error has ocurred:" errorType, codeType)
}
❌ WRONG:❌ WRONG:❌ WRONG:❌ WRONG:❌ WRONG:❌ WRONG:
```

✅ CORRECT:

```ts
function showError(errorType: string | number): void {
 console.log("An error has ocurred", errorType);
}
```

✅ CORRECT:

```ts
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
```

❌ WRONG:

```ts
let name0, surname0, age0 = undefined;

function manyParams(name0: string, surname0?: string, age0: number = 18){
    if (surname0) {
        console.log(`${name0} ${surname0} is ${age0} years old`)
    } else {
        console.log(`${name0} is ${age0} years old`)   
    }
};
```

### ✅ Parameter Passing Verification:

Make sure to define optional parameters, default values, and variable-length parameters as needed, and also can ve "verified" by the compiler.

### ✅ Arrow Functions and Callbacks:

Use of arrow functions and anonymous functions to get a more concise code and handle callback functions more efficiently.

```ts
let employee = {
    name6: "Pepe",
    surname6: "Juarez",
    age6: 36
}

const employeeAge = (employee) => `${employee.name6} is ${employee.age6} years old`;
```

---

# 🔸 Variable Scoope

Scope determines the accessibility (visibility) of variables.

There are 2 kind of "family" scooping, one of which was deprecated since ECMA6, but needs to be explained for the sake of understanding well what scooping means/defines:

1. **Block / Local / Function** scoope
2. **Global** Scope

#### ⚡ (DEPRECATED) Block scope:

Since ECMA6 (2015) introduced `let`and `const` keywords, these two keywords are which provide the Block Scope, so:

- Variables declared with the `var` keyword ❌**can NOT**❌ have block scope.
  
- Variables declared inside a `{ } block` ✅**CAN**✅ be accessed from outside the block.
  
- Variables `{ inside a block}` ❌cannot❌ be accesed from outside it.
  
  ```ts
  {
  let x = 2;
  }
  // x can NOT be used here 
  ```
  

```ts
{
  var x = 2;
}
// x CAN be used here 
```

#### ⚡ Local scope:

Variables declared within a JavaScript function, are LOCAL to the function:

```ts
// code here can NOT use carName

function myFunction() {
  let carName = "Volvo";
  // code here CAN use carName
}

// code here can NOT use carName 
```

So, **Local variables have Function Scope**:

- They can only be accessed from within the function.
  
- Since local variables are only recognized inside their functions, variables with the same name can be used in different functions.
  
- Local variables are created when a function starts, and deleted when the function is completed.
  

#### ⚡ Function scope:

Means that every function creates a new scope, so:

- Variables defined inside a function are not accessible (visible) from outside the function.
  
- Variables declared with `var`, `let` and `const` are quite similar when declared inside a function.
  

```ts
function myFunction() {
  var carName = "Volvo";   // Function Scope
}
```

```ts
function myFunction() {
  let carName = "Volvo";   // Function Scope
}
```

```ts
function myFunction() {
  const carName = "Volvo";   // Function Scope
}
```

#### ⚡ Global scope:

The easiest to be understood:

- A variable **declared outside** a function **becomes GLOBAL** to the entire code.

```ts
let carName = "Volvo";
// code here can use carName

function myFunction() {
// code here can also use carName
}
```

---

# 🔸 Functions

> Function: A block of code designed to perform an action.

A simple schema:

```ts
function name(parameter1: type, parameter2: type, parameter3: type): type {
  // code to be executed here
}

function name(); // The invocation // The function call.
```

---

## <u>FUNCTION DEFINITIONS</u>

### ⚡ Function Declarations

A shown in the previous schema, declared functions always has the shown structure, **starting with a FUNCTION CONSTRUCTOR()**.

Declared functions are not executed immediately. They are "saved for later use", and will be executed later, when they are invoked (called upon).

### ⚡ Function Expressions

But, a function can also be defined using a **expression**:

```ts
const x = function (a, b) {return a * b};
```

After a function expression has been stored in a variable, the variable can be used as a function:

```ts
const x = function (a, b) {return a * b};
let z = x(4, 3); // 
```

- A function expression is an **anonymous** function (An unnamed function).
- Functions stored in variables do not need function names. They are always invoked (called) using the variable name.

### ⚡ Function Hoisting

Hoisting is the default behaviour of **moving declarations to the top of its current scoope**.

Code hoisting applies to variable and functions declarations, but not to functions expressions.

That's why a function can be called **before** it has been declared. E.g.:

```ts
myFunction(5);

function myFunction(y) {
  return y * y;
} 
```

### ⚡ Self-Invoking functions

Function expressions can be self-invoked.

A self-invoking expression is invoked (started) automatically, without being called.

Function expressions will execute automatically when the expression is followed by the constructor **()**.

You have to add parentheses around the function to indicate that it is a function expression:

```ts
(function () {
  let x = "Hello!!";
})(); // The () ending invokes the function
```

### ⚡ Functions as Values

A function can be used as a value:

```ts
function myFunction(a, b) {
  return a * b;
}

let x = myFunction(4, 3); // myFunction is being used as the 'x' variable value
```

Also, a function can be used as a expression:

```ts
function myFunction(a, b) {
  return a * b;
}

let x = myFunction(4, 3) * 2; // The expression is ( myFunction(4, 3) plus the rest ) 
```

### ⚡ Functions as Objects (using methods)

The `typeof` operator returns "function" for functions.

But, functions can best be described as objects.

Functions have both `properties` and `methods`.

- *arguments*.**length** property returns the number of arguments received when the function was invoked:
  
  ```ts
  function myFunction(a, b) {
  return arguments.length;
  } 
  ```
  
- **toString()** method returns the function as a string:
  
  ```ts
  function myFunction(a, b) {
  return a * b;
  }
  ```
  

let text = myFunction.toString();

````
To clarify this,:

>- A function defined as the property of an object, is called a method to the object.  
>
>- A function designed to create new objects, is called an object constructor.~

### ⚡ Arrow functions  
Same as declaring any function, but:  
1. Can be invoked at any time.
2. Can be used as entry params., as a callbak, like *"When X thing is executed, Y thing is told to do A thing*.


Allows a **short syntax** for the function expression. 
```ts
// ES5 and earlier
var x = function(x, y) {
  return x * y;
}

// Since ES6
const x = (x, y) => x * y;
````

But, ... :

1. Arrow functions do not let their own **this** keyword, so that they are **not well suited for defining object methods**.
  
2. Arrow functions **are not hoisted**. They **must be defined before** they are used.
  
3. A function expression **is always a constant** so that avoiding the use of variables makes the sense.
  
4. You can only omit the return keyword and the curly brackets if the function is a single statement. Because of this, it might be a good habit to always keep them:
  
  ```ts
  const x = (x, y) => { return x * y };
  ```
  

---

## <u>FUNCTION PARAMETERS</u>

### Function Parameters and Arguments

### ⚡    Parameter rules

1. Function definitions do not specify data types for parameters.
2. Functions do not perform type checking on the passed arguments.
3. Functions do not check the number of parameters received.

### ⚡    Default paramenters

If a function is called with **missing arguments (less than declared)**, the missing values are set to `undefined`.

If a function is called with **too many arguments (more than declared)**, these arguments can be reached using the arguments object.

Sometimes this is acceptable, but sometimes **it's better to assign a default value** to the parameter:

```ts
function myFunction(x, y) {
  if (y === undefined) {
    y = 2;
  }
}
```

### ⚡    Default parameter values

```ts
function myFunction(x, y = 10) {
  return x + y;
}
myFunction(5);

// If y is not passed or undefined, then y = 10
```

### ⚡    Function parameters using Rest Operator (...)

The rest parameter (...) allows a function to treat an indefinite number of arguments as an array:

```ts
function sum(...args) {
  let sum = 0;
  for (let arg of args) sum += arg;
  return sum;
}

let x = sum(4, 9, 16, 25, 29, 100, 66, 77);
```

### ⚡    The arguments Object

Functions have a built-in object called the arguments object.

The argument object contains an array of the arguments used when the function was called (invoked).

This way you can simply use a function to find (for instance) the highest value in a list of numbers:

```ts
avaScript functions have a built-in object called the arguments object.

The argument object contains an array of the arguments used when the function was called (invoked).

This way you can simply use a function to find (for instance) the highest value in a list of numbers:
```

Or creating a function to sum all input values:

```ts
x = sumAll(1, 123, 500, 115, 44, 88);

function sumAll() {
  let sum = 0;
  for (let i = 0; i < arguments.length; i++) {
    sum += arguments[i];
  }
  return sum;
}
```

## 🔸 FUNCTION OVERLOADING

TypeScript allows overloading the functions by enabling to be declared the same function but with many differents patterns (values, params.), as needed..

That's like this due to the needed improvements of code flexibility and legibility, also at compiling.

- Here are defined two methods for the function `greeting()`. One of both allows a string type argument; the other don't:
  
  ```ts
  function greeting(name: string): void;
  function greeting(): void;
  function greeting(name?: string): void {
    if (name) {
        console.log(`Hello, ${name}!`);
    } else {
        console.log(`Hello!`);
    }
  }
  
  greeting("Juan"); // Will log "Hello, Juan!"
  greeting(); // Will log "Hello!"
  ```
  

## 🔸 FUNCTION ARGUMENTS - Passing values to.

When defining functions, you can explicitly specify parameters to ensure the correct data types are passed. 
Additionally, you can make some parameters optional or have default values by adding `:?` when declaring them.  

### Arguments are passed as values

The parameters, in a function call, are the function's arguments.

- ### Arguments are passed by `value`:
  
  The function only gets to know the values, not the argument's locations.  
  If a function changes an argument's value, it does not change the parameter's original value.  
  **Changes to arguments are not visible (reflected) outside the function.**  
  

- ### Objects are passed by Reference
  
   **Object references are values**, so that **objects behaves like they are passed by reference**.  
  If a function changes an object property, it changes the original value.
  
  **Changes to object properties are visible (reflected) outside the function.**
  

#### ⚡ CASE 1: Optional

`name` is an **optional parameter**, so that the function can be **invoked without passing a value** for the variable.

```ts
function farewellPerson(name?: string): void {
 if (name) {
 console.log(`Bye, ${name}!`);
 } else {
 console.log("Bye!");
 }
} 
farewellPerson(); // "Bye!"
farewellPerson("Ana"); // "Bye, Ana!"
```

#### ⚡ CASE 2: Predefined value parameters

`name` **has a pre-parametrized value** ("Pepe").
If a value is not passed to function argument, the pre-parametrized value will be used.
If there's an argument passed, this will be used.

```ts
function farewellPersonWithDefault(name: string = "Pepe"): void {
    console.log(`Bye, ${name}`);
}

farewellPersonWithDefault();  // "Bye, Pepe"
farewellPersonWithDefault("Alba");  // "Bye, Alba"
```

#### ⚡ CASE 3: Rest (...) Paramenters

- A rest `...argument` (*"dot dot dot Operator plus argument"* structure)* allows differnt list of variables, as an array.
- **Useful when we don't know how many values** will be function-passed.

```
function exampleMultiParams(...names: string[]): void {
    names.forEach(name => {
        console.log(name);
    });
}

exampleMultiParams("Martin", "Pepe", "Juan");  // "Martin", "Pepe", "Juan"
```

#### ⚡CASE 4: As an Embebbed and/or Unknown function

Given the function 'getPaysheet' with 2 parameters:

- 'employeeTyped': The object ... as employeeType type defined previosly.
- 'ammount': A function "() => void", which is an empty callback (VOID returns NOTHING).

This function choose if the object meets the conditions, or not, to follow with the declared function ( if the employee has to get the monthly payroll, or not due to the nature of being retired depending on the age):

```ts
const getPaysheet = (employeeTyped: employeeType, ammount: () => void): void => {
 if ( employeeTyped.age7 >= 70 ) {
 return // return nothing, do nothing, the object doesn't meet the conditions
 } else {
 ammount() // callback to be executed if the object meet the conditions
 }
};

const employeeCollectsPayroll = (employeeTyped: employeeType): void => {
 console.log(`${employeeTyped.name7} ${employeeTyped.surname7} collects the monthly payroll`);
};

getPaysheet(employeeTyped, () => employeeCollectsPayroll(employeeTyped));

const getPaysheet = (employeeTyped: employeeType, ammount: () => void): void => {
 if ( employeeTyped.age7 >= 70 ) {
 return // return nothing, do nothing, the object doesn't meet the conditions
 } else {
 ammount() // callback to be executed if the object meet the conditions
 }
};

const employeeCollectsPayroll = (employeeTyped: employeeType): void => {
 console.log(`${employeeTyped.name7} ${employeeTyped.surname7} collects the monthly payroll`);
};

getPaysheet(employeeTyped, () => employeeCollectsPayroll(employeeTyped));




```

Unknown function (function expression) was integred since ECMA6.

---

# Asyncs, Generators, Workers, Sagas.

- **Async Functions (`async/await`)**: These handle asynchronous operations (like API calls) in a linear, readable way, pausing at `await` and resuming when the promise resolves.
- **Generators**: Offer more manual control over the flow, pausing and resuming execution at specific points, allowing more complex workflows without directly relying on asynchronous promises.
- **Workers**: Used for background tasks, often in scenarios requiring separation of concerns, such as in Redux-Saga where tasks (e.g., data fetching) are handled independently of the main UI thread.
- **Sagas**: Ideal for managing complex asynchronous flows, like waiting for multiple actions or handling retries, cancellations, and sequencing in libraries like Redux-Saga.

- **Async/await** is for simplifying async operations.
- **Generators** give manual control over execution.
- **Workers** handle independent tasks or side effects.
- **Sagas** manage complex async flows, often in large applications with multiple interdependent async actions.

## 🔸 `async function` VS `function* generator`

Async functions, which work with promises, are used when a function may need its own time to be executed. It has its start status, its waiting status and its end status.

On the other hand, a function generator can be used in the same way as asynchronous functions, but they differ in what an ending status process means.

#### ⚡ Asynchronous functions (`async` / `await` )

Here, we got a new TS keyword: `await`

```ts
async function exampleAsync(): Promise<string> {

    //Await
    await console.log("This is the task (a console.log) to be done when awaiting for the promise");
    console.log("This is the task to be done when the promise has been reached ")
    return "Completed";
};
```

Then, the function can be invoked by using many methods as statuses: `.then`, `.catch`, `finally`.

```ts
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
```

#### Promise methods explainded:

- `.then` = When the promise is reached, do this.
  
- `.catch` = Catch an status, as an error, at the function execution time.
  
- `.finally` = When everything is done, do this.
  

---

## ⚡ Generators, Workers, and Sagas

A **generator** (defined with `function*`) is a kind of function that **can pause its execution and later being resumed**. *

```ts
function* exampleGenerator() {

    // yield word! -> As a suscription mode, to emit new values
    let index = 0;
    while (index < 5) {
        yield index++;
    }
};

// Next, save the function generator value
let generator = exampleGenerator();

// Now, we invoke the new values

console.log(generator.next().value); // will be 0
console.log(generator.next().value); // will be 1
console.log(generator.next().value); // will be 2
console.log(generator.next().value); // will be 3

// . . . 
```

#### **Workers and Sagas**

- **Watcher**: A function that listens for events or conditions, triggering processes or delegating tasks.
- **Worker**: A function that performs specific tasks (e.g., API calls, data processing). It is invoked by the watcher for task execution.

In a saga pattern, the **watcher** manages the flow, delegating the execution of tasks to workers, which produce values or handle async tasks.

```ts
function* watcher(aValue: number) {

    yield aValue; // here, a value its emitted as the initial status

    yield* workerGenerator(aValue); // here, we invoke the worker emissions to give a new values (statusses)

    yield aValue + 10; // here, we add the last given value

}

function* workerGenerator(aValue: number) {
    yield aValue + 1;
    yield aValue + 2;
    yield aValue + 3;

}

let generatorSaga = watcher(0);

console.log(generatorSaga.next().value); // will be 0 (done by the Watcher)
console.log(generatorSaga.next().value); // will be 1 (done by the Watcher)
console.log(generatorSaga.next().value); // will be 2 (done by the Watcher)
console.log(generatorSaga.next().value); // will be 3 (done by the Watcher)
console.log(generatorSaga.next().value); // will be 10 (done by the Watcher)### **Use Cases**
```

### **Normal Functions vs Async/Generators/Sagas**

- **Normal Functions**: Execute sequentially; if async behavior is needed, callbacks or promises must be manually managed.
- **Async Functions**: Allow for cleaner, more readable asynchronous code, pausing with `await`.
- **Generators**: Provide fine-grained control over execution, ideal for workflows where you need to pause and resume at specific points, even for async tasks.
- **Sagas**: Best for managing complex async flows, handling multiple asynchronous operations, side effects, or workflows in a predictable and structured way.

---

📖 Our *index.ts* typed on this lesson:

```ts
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

/* Function Overloading */

// Dos formas de hacer lo mismo.
// Podemos devolver propiedades
console.log(nameAndSurname); // Console: Martin Gonzalez
console.log(exampleReturn("Martin", "Gonzalez")) // Console: Martin Gonzalez


/* By FACTOR SPREADING*/
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
// Sin especificar tipo, estamos dando paso a que la variable employee tenga implicitamente ANY type

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
Unknown function (function expression).
Integred since ECMA6.
*/

// // //  HNASTA AQUI, "PASAR CALLBACKS"

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
```
