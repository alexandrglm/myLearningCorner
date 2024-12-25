#  🔸 SESSION #3  FUNCTIONS

Abstract:

* Functions
* Variable Scooping
* Hoisting
* JSDoc. Documening the code in a proper way.
* Parsing objects as arguments, different ways
* Types. Creating object types.
* 
	

# 🔸 TS Best Practices (2) ✅✅✅

### ✅ Code is easy to be understood:
- By giving self-explicative names to vars, functions, ...  

- By using **JSDoc** method:

```ts
/**
 * This is a documenting JSDoc method
 * Best Practices with functions:
 * Giving a self-explicative name 
 */
```
  
  
### ✅ Code is extremely explicit even the redundance:  
- *Any* data type is not explicitly nor implicitly used.  

✅ CORRECT:
```ts
let correctWay: string = `It has to be a string. Another data type will cause errors`;
```
  
❌ WRONG:
```ts
let wrongWay = `This lets implicetely ANY type and will bring a lot of errors, warnings, breakpoints... Avoid it`
```
  

### ✅ Var, values, params., functions,... anything follows a clear way to be named.
```text
This is **camelCase** typing ✅  
And this is **snake_Case** typing ✅ 

But this is **aproblematicwayoftypingtobeavoided** ❌
```
   

### ✅ Every var value has its defined type  
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
***

# 🔸 Variable Scoope  

Scope determines the accessibility (visibility) of variables.

There are 2 kind of "family" scooping, one of which was deprecated since ECMA6, but needs to be explained for the sake of understanding well what scooping means/defines:

1. **Block / Local / Function** scoope
2. **Global** Scope  

#### ⚡ (DEPRECATED) Block scope:  
Since ES6 (2015) introduced `let`and `const` keywords, these two keywords are which provide the Block Scope, so:  

- Variables declared with the var keyword ❌**can NOT**❌ have block scope.

- Variables declared inside a { } block ✅**CAN**✅ be accessed from outside the block.
  
- Variables `{ inside a block}` ❌cannot❌ be accesed  from outside it.
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

# 🔸 Functions  
> Function: A block of code designed to perform an action.

A simple schema:
```ts
function name(parameter1: type, parameter2: type, parameter3: type): type {
  // code to be executed here
}

function name(); // The invocation
```
***
## Function Definitions

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

let text = myFunction.toString(); 
```

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
```

But, ... :
1. Arrow functions do not let their own **this** keyword, so that they are **not well suited for defining object methods**.

2. Arrow functions **are not hoisted**. They **must be defined before** they are used.

3. A function expression **is always a constant** so that avoiding the use of variables makes the sense.

4. You can only omit the return keyword and the curly brackets if the function is a single statement. Because of this, it might be a good habit to always keep them:
```ts
const x = (x, y) => { return x * y };
```
*** 


## 🔸		FUNCTION OVERLOADING  
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

greeting("Juan");  // Will log "Hello, Juan!"
greeting();        // Will log "Hello!"
```
***


## Passing parameters or arguments to a function  
 
When defining functions, you can explicitly specify parameters to ensure the correct data types are passed. 

Additionally, you can make some parameters optional or have default values by adding `:?` when declaring them.  

#### CASE 1: Optional
`name` is an **optional parameter**, so that the function can be **invoked without passing a value** for the variable.
```ts
function farewellPerson(name?: string): void {
    if (name) {
        console.log(`Bye, ${name}!`);
    } else {
        console.log("Bye!");
    }
}

farewellPerson();  // "Bye!"
farewellPerson("Ana");  // "Bye, Ana!"
```
  
#### CASE 2: Predefined value parameters  
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
  
#### CASE 3: Rest (...) Paramenters  

* A rest `...argument` (*"dot dot dot Operator plus argument"* structure)* allows differnt list of variables, as an array.  
* **Useful when we don't know how many values** will be function-passed.  

```
function exampleMultiParams(...names: string[]): void {
    names.forEach(name => {
        console.log(name);
    });
}

exampleMultiParams("Martin", "Pepe", "Juan");  // "Martin", "Pepe", "Juan"
```


```ts
function greeting(){
    let name = "Pepito";    // Variable scoope: Not globally. locally.
    console.log(`Hello ${name}!`);
    
}

greeting();     // The Invoke
```


```ts
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
```

```ts

/**
 * 
 * @param name Person name will be, as declarated, = "Pepe"
 */
function farewellPerson(name: string = "Pepe"){
    console.log(`Bye, ${name}`);
}

farewellPerson() // console: Bye, Pepe
farewellPerson("Alba"); // console: Bye, Alba
```

```ts
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
```

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

```ts
/**
 * This function defines the 'a' object data types
 * @param a A string and/or a number
 */
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
```

```ts
function exampleReturn(name0?: string, surname0?: string): string | number {
    return '${name0} ${surname0}';
}

exampleReturn(name0="Martin", surname0="Gonzalez"); 

const nameAndSurname = exampleReturn("Martin", "Gonzalez");
```
***
  

