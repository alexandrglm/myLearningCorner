 🔸 SESSION #3  FUNCTIONS

Abstract:

* Functions
* Variable Scooping
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
 
# 🔸 Variable Scoope

Scope determines the accessibility (visibility) of variables.

There are 2 types of scope, and another one whose usability was deprecated since ECMA6:

1. Function Scope / Local scoope  
At the function side.

2. Global Scope  
At the entire code side.

3. Block Scope. Deprecated, but has to be explained in order to understand in a proper way the scooping.  

#### ⚡ (DEPRECATED) Block scope:  

Variables `{ inside a block}` ❌cannot❌ be accesed  from outside it.
```ts
{
  let x = 2;
}
// x can NOT be used here 
```

Since ES6 (2015) introduced `let`and `const` keywords, these two keywords are which provide the Block Scope, so:  

- Variables declared with the var keyword ❌**can NOT**❌ have block scope.

- Variables declared inside a { } block ✅**CAN**✅ be accessed from outside the block. 

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

#### ⚡ Function scope:  
The easiest to be understood:  
- A variable **declared outside** a function **becomes GLOBAL** to the entire code.  

```ts
let carName = "Volvo";
// code here can use carName

function myFunction() {
// code here can also use carName
}
```

## Functions

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
  

