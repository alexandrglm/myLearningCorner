# MODULE 04 - 028: JavaScript

## Functions (3) - Expressions vs Declarations

---

1. Function Declarations  
2. Function Expressions  
3. Key Differences and Use Cases  
4. Hoisting Behavior  
5. Best Practices and Patterns  

****

JavaScript provides two primary ways to define functions, each with distinct characteristics. Understanding these differences is crucial for:

- Writing predictable code  
- Properly structuring applications  
- Leveraging JavaScript's flexibility  
- Avoiding common pitfalls  

The choice between expressions and declarations affects hoisting, scope, and code organization.

****

## 1. Function Declarations

Traditional function syntax with name and definition:

```js
function greet() {
  return "Hello!";
}
```

**Characteristics:**

- Hoisted to the top of their scope  
- Can be called before declaration  
- Must have a name (non-anonymous)  
- Ideal for standalone, reusable functions  

Example usage:

```js
// Can be called before declaration
console.log(greet()); // "Hello!"

function greet() {
  return "Hello!";
}
```

****

## 2. Function Expressions

Functions assigned to variables or properties:

```js
const greet = function() {
  return "Hello!";
};
```

**Variations:**

- Anonymous: `function() {...}`  
- Named: `function myFunc() {...}`  
- Arrow functions (ES6+): `() => {...}`  

**Characteristics:**

- Not hoisted (only variable declaration is)  
- Can be anonymous or named  
- Created when execution reaches them  
- Ideal for:
  - Conditional function creation  
  - Callbacks  
  - Immediately Invoked Function Expressions (IIFEs)  

****

## 3. Key Differences

| Feature            | Declaration   | Expression       |
| ------------------ | ------------- | ---------------- |
| Hoisting           | Fully hoisted | Variable hoisted |
| Anonymous          | Never         | Possible         |
| Block Scope        | No            | Yes              |
| Call Before Define | Yes           | No               |
| Use in Statements  | Limited       | Flexible         |

**Practical Example:**

```js
// Function expression in conditional

let operation;
if (useAddition) {
  operation = function(a, b) { return a + b; };
} else {
  operation = function(a, b) { return a - b; };
}

// Function declaration would fail here
if (useAddition) {
  function add(a, b) { return a + b; } // Avoid - behavior varies
}
```

****

## 4. Hoisting Behavior

### Function Declarations

Completely hoisted - can be called anywhere in scope:

```js
works(); // "It works!"

function works() {
  return "It works!";
}
```

### Function Expressions

Only the variable declaration is hoisted:

```js
try {

    works(); // TypeError
} catch (e) {
    console.log(e); // works is not a function
}

var works = function() {
    
    return "Doesn't work yet!";
};
```

****

## 5. Best Practices and Patterns

### When to Use Declarations

- For main program functionality  
- When you need hoisting  
- For clearer stack traces (named functions)  

### When to Use Expressions

- For callbacks and event handlers  
- In conditional logic  
- For IIFE patterns  
- When passing functions as arguments  

### Modern Patterns

**Arrow Functions (ES6+):**

```js
const greet = () => "Hello!";
```

**Named Function Expressions:**

```js
const factorial = function calc(n) {
    return n <= 1 ? 1 : n * calc(n - 1);
};
```

**Immediately Invoked Function Expression (IIFE):**

    (function() {
      console.log("Runs immediately");
    })();

****

## Advanced Considerations

### Block-Level Declarations

In strict mode, function declarations in blocks behave differently across browsers. Prefer expressions:

```js
'use strict';
if (true) {
  function risky() {} // Behavior varies
  const safe = function() {}; // Consistent
}
```

### Memory Implications

Named function expressions can help with:

- Debugging (meaningful stack traces)  
- Self-referencing  
- Better code readability  

****

## Code Examples

Basic comparison:

```js
// Declaration
function declared() {
  return "I'm hoisted!";
}

// Expression
const expressed = function() {
  return "I'm not hoisted!";
};
```

Conditional function creation:

    const getFormatFunction = (formatType) => {
      if (formatType === 'uppercase') {
        return function(text) {
          return text.toUpperCase();
        };
      }
      return function(text) {
        return text.toLowerCase();
      };
    };

## Resources

- [MDN: Function Expressions](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/function)  
- [JavaScript.info: Function Expressions](https://javascript.info/function-expressions)  
- [W3Schools: JavaScript Functions](https://www.w3schools.com/js/js_functions.asp)  

---

## Video Lesson Speech

This lesson introduces function expressions in JavaScript. Additionally,
 we'll examine the key differences between function expressions and 
traditional function declarations.

****

The idea of functions is so important in javascript that there are a number of ways that we can use them. 
So far we've talked about building functions using this type of syntax where you say something like function greeting and then inside of it we can return something like Hey there. 

```javascript
function greeting(){
return "Hi there!";
}
```

And this all works. 

Now, this is what is called a function declaration. But now we also have another option in javascript and it's what is called a function expression. Now you may also hear these referred to as anonymous function or even named anonymous function expressions. Typically I just call them function expressions and that's usually what you'll hear them called in the regular development circles. But now let's talk about what the syntax for that is. Because the flow is a little bit different and there are some very subtle differences between function declarations like we have right here and function expressions.

To start off with an expression a function expression is a function that is stored inside of a variable. So in other words what we would do is actually change this to say var greeting equals so we perform our assignment and then we can just say function. We don't name it. That's where the anonymous part comes in. And here we can just return say Hi there again and this is going to perform pretty much the same way in most cases. 

```javascript
var greeting = function () {
return 'Hi there again';
};
```

This is all pretty basic and this is the syntax and actually I'm missing one thing. You're also supposed to have a semi-colon at the end of a function expression or else some of the things like a Linter which checks for code quality would throw an error. So that is a function expression. Now your very first question may be why in the world do we need a second way of writing functions. This seems to be exactly the same as what we have here.

Let's test it out just to make sure. I say console log greeting and then pass this and let's rename this one we'll say greeting to and. Now if I copy this and call greeting two both of these should run. 

```javascript
var greetingTwo = function () {
return 'Hi there again';
};

console.log(greeting());
console.log(gretingTwo());

//"Hi there!"
//"Hi there again"
```

And we have. Hi there. And hi there again. So this is all working properly and once again we're getting back to the question on why in the world would I need this. 

Well let's get rid of these two and I'll put them in the show notes so that you have access to them. 

But now let's go and let's build a program where you can see why this is so important. So I'm going to start off by saying var age and let's set it equal to 3 years old. And now we're going to create a conditional. So we say if age is less than or equal to 10 then I want you to do everything inside of here. So what we're going to do and this is something that's getting us a little bit closer to real-world development. Imagine a scenario where you had a Web site for a restaurant and part of the process was if you check to see if the user was under 10 years old then you're going to go and build a kid's menu and you're going to build a kid's menu for them and that way you would have some dynamic behavior. So I'm going to create a function called build menu and I'm gonna use a function expression. So if I say var build menu and set it equal to the function and then inside of it where you're not going to build the menu obviously I'm just going to say return Kids menu and then put a semicolon at the end of the return statement and one after the last curly bracket. 

Now if I console log this out where I call build menu and then make sure you put your parens at the end of it. If I hit clear and run this you can see it says kids menu. 

```javascript
var age = 3;

if (age <= 10) {
  var buildMenu = function () {
    return "Kids' Menu";
  };
console.log(buildMenu());
}
//"Kid's menu"
```

Now let's see if we could do the same thing. So what we've done essentially is we have a conditional here and we're saying I only want you to go through this process of building the menu. If the age is less than or equal to 10 imagine this also saying that you have a web application where if a certain condition is met then you want to go run an API query. So you want to call some other server and have other things brought back. Well, you need to build a function in order to do that. So can we build, can we write a traditional function and declaration this way? Well, let's try. If I say buildMenuTwo just with the regular function declaration and inside of it say return and then say another kids menu put a semicolon at the end and now let's copy the console.log and change it to buildMenuTwo. 

```javascript
function buildMenuTwo () {
return "Another kids' menu";
}

console.log(buildMenu());
console.log(buildMenuTwo());
}

// "Kid's menu"
//"Another kids' menu"
```

Now, what do you think is going to happen if I hit clear, and hit run? Both of them still come out. So what gives?

Because I told you I was going to show you the difference between the two. Well, the difference is apparent for certain javascript engines. So right here this all seems to work exactly the same. If you remember back to one of the very first videos where I showed you around CodePen when I showed you right here in the top right-hand side where it has a javascript analyzer. 

![medium](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Javascript+images/analyze-js-button.png)

Let's run this and see what it has to say. Well, it liked our function expression it said everything there is perfectly fine moving down here though. Now we have an error where it says the function declarations should not be placed in blocks. And when they mean in blocks they mean inside of curly braces in things like a conditional or a try-catch block or something like that. And that is exactly what we're trying to do we're trying to generate a function on the fly and that is not what function declarations were intended to do that is what a function expression was intended for. 

So it says should not be placed in blocks, use and it even tells us right here which is nice. Use a function expression, or move the statement to the top of the outer function. So this is something very important and this is going to start getting having close this out. This is starting to get us closer to building dynamic type of applications because you are going to have many times where you need to build functions on the fly. You may want to store a function inside of an object and all those things are not what you would do with a standard type of function declaration. This is what you would use for a straight right out of the box kind of functions whereas function expressions are more modular. 

That's the easiest way to try to remember this is if you have something that you need to be able to move around or a function you need to be able to create at any given point. That is what function expressions are for, whereas a declaration like this is only when you have it outside of that block. So you'd have something like this and then that would work exactly the way that it was intended for but not in how we were trying to do it right here. So that is how you can work with function expressions or anonymous functions in javascript just like we have right here and also a walkthrough on the difference between function expressions and function declarations.

```javascript
var greeting = function () {
 return "Hi there!";
};

var age = 4;

if (age <= 10) {
  var buildMenu = function () {
    return "Kids' Menu";
  };

  function wrongMenuBuilder () {
    return "Wrong Kids' Menu";
  }

  console.log(buildMenu());
  console.log(wrongMenuBuilder());
}
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_d_03_function_expression.js)

---

## Coding Exercise

Build a function expression called myFunction and have it return true

```js
var myFunction
```
