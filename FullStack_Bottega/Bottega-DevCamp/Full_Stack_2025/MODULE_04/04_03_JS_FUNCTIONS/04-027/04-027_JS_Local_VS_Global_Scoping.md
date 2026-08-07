# 04-027\_JS\_Local\_VS\_Global\_Scoping

## MODULE 04 - 027:     JavaScript

### Functions (2), Variable Scope

***

1. Global vs Local Scope
2. Scope Chain and Hierarchy
3. Variable Shadowing
4. Best Practices for Scope Management
5. Common Pitfalls and How to Avoid Them

***

Variable **scope** in JavaScript determines where variables are accessible in your code. Understanding scope is crucial for:

* Preventing naming collisions
* Managing memory efficiently
* Writing maintainable code
* Avoiding common bugs

JavaScript uses function-level scope (with `var`) and block-level scope (with `let`/`const`), creating distinct accessibility regions for variables.

***

### 1. Global vs Local Scope

#### Global Scope

Variables declared outside any function are globally accessible:

```js
// Global variable
var globalUser = {
  name: 'Global User',
  email: 'global@example.com'
};

function showUser() {
  console.log(globalUser.name); // Accessible
}
```

**Issues with Global Variables:**

* Can be modified from anywhere
* Risk of naming collisions
* Make code harder to debug
* Pollute the shared namespace

***

#### Local (Function) Scope

Variables declared inside a function are only accessible within it:

```js
function createUser() {
  // Local variable
  var localUser = {
    name: 'Local User',
    email: 'local@example.com'
  };
  console.log(localUser.name); // Works
}

console.log(localUser.name); // ReferenceError
```

***

### 2. Scope Chain and Hierarchy

JavaScript uses lexical scoping - inner functions can access outer function variables, but not vice versa:

```js
var outerVar = 'I am outside';

function outerFunction() {
  var middleVar = 'I am in the middle';

  function innerFunction() {
    var innerVar = 'I am inside';
    console.log(outerVar); // Accessible
    console.log(middleVar); // Accessible
  }

  console.log(innerVar); // ReferenceError
}
```

Key points:

* Inner scopes can access outer scope variables
* Outer scopes cannot access inner scope variables
* Sibling scopes cannot access each other's variables

***

### 3. Variable Shadowing

When a local variable shares its name with a global variable:

```js
var userName = 'Global';

function showName() {
  var userName = 'Local'; // Shadows global
  console.log(userName); // "Local"
}

console.log(userName); // "Global"
```

**Important Notes:**

* Shadowing doesn't modify the original variable
* Can lead to confusion if overused
* Modern ES6 `let` and `const` prevent accidental shadowing in blocks

***

### 4. Best Practices for Scope Management

#### Minimize Global Variables

* Use IIFEs (Immediately Invoked Function Expressions) to encapsulate code
* Leverage module patterns
* Consider modern module systems (ES6 modules, CommonJS)

#### Prefer Block Scope

Use `let` and `const` for tighter scope control:

```js
if (true) {
  let blockScoped = 'Only exists here';
  const PI = 3.14; // Also block-scoped
}
```

#### Avoid Implicit Globals

Always declare variables properly:

```js
function badPractice() {
  undeclaredVar = 'Oops! Global!'; // Anti-pattern
}
```

#### Use Descriptive Names

Reduce collision risk with specific names:

```js
// Better
var appCurrentUser = {...};

// Riskier
var user = {...};
```

***

### 5. Common Pitfalls and Solutions

#### Accidental Globals

**Problem:**

```js
function createUser() {
     user = { name: 'Oops' }; // Missing var/let/const
 }
```

**Solution:** Always use declaration keywords.

\*\*### Hoisting Surprises

**Problem:**

```js
console.log(hoisted); // undefined
     var hoisted = 'Value';
```

**Solution:** Use `let`/`const` or declare at top.

***

#### Closure Scope Issues

**Problem:**

```js
for (var i = 0; i < 3; i++) {
     setTimeout(() => console.log(i), 100); // Always 3
}
```

**Solution:** Use `let` for block scope in loops.

***

### Modern JavaScript Scope Features

#### Block Scoping with let/const

ES6 introduced block-level scoping:

```js
if (true) {
     let blockVar = 'scoped';
     const MAX = 100;
}

console.log(blockVar); // ReferenceError
```

#### Temporal Dead Zone

`let` and `const` declarations aren't hoisted:

```js
console.log(tdzVar); // ReferenceError
let tdzVar = 'value';
```

#### Module Scope

ES6 modules create file-level scope:

```js
// module.js
const privateVar = 'hidden';
export publicVar = 'visible';
```

***

***

### More Code Examples

Global vs local scope:

```js
var global = 'Accessible everywhere';

function checkScope() {
  var local = 'Only accessible here';
  console.log(global); // Works
}

console.log(local); // ReferenceError
```

Block scope with let:

```js
if (true) {
  let secret = 'Inside block';
  const CODE = 123;
}
console.log(secret); // ReferenceError
```

IIFE pattern for encapsulation:

```js
(function() {
  var privateVar = 'Hidden from outside';
  // Your code here
})();
```

***

Resources

* [MDN: Variable Scope](https://developer.mozilla.org/en-US/docs/Glossary/Scope)
* [JavaScript.info: Closures](https://javascript.info/closure)
* [W3Schools: JavaScript Scope](https://www.w3schools.com/js/js_scope.asp)

***

### Video Lesson Speech

This lesson examines JavaScript scope. Specifically, it walks through\
the differences between local and global scope for JavaScript variables,\
along with discussing the best practices associated with both options.

***

In this guide we're going to talk about a very important topic in javascript development and that is going to be variable scope.

So far throughout this course is pretty much everything that we've done has been with variables that are in what's called the global scope. What that means is that if we had a full program that each one of these variables would actually be made available to all of the different functions modules classes they'd have access to it. And as you're about to see that can lead to some very confusing bugs and is definitely considered an anti-pattern. So it's very important to understand exactly how variable scope works in javascript so that we can utilize it properly, we can organize our code the right way, and also so we're not going to run into weird behavior where we have one value that is available and could accidentally be called or even overridden later on in a program.

So what we're going to do is I'm going to create a variable here and I'm just going to call it user object and it's going to be an object for just a simple user. So say sample@devcamp.com and they'll have a FULL NAME attribute as well. And this will be Kristine Hudgens.

```javascript
var userObj = {
email: 'sample@devcamp.com',
fullName: 'Kristine Hudgens'
}
```

Nothing really new there, I'm using an object instead of just a plain old string or something. So you can get in the practice of using them because you are going to be using objects quite a bit in your javascript development journey.

The next thing is let's build a function, the reason why this specific guide is included in this module is that I couldn't include it in the earlier one where we were just talking about variables because you can't really talk about variable scope in javascript without talking about functions because they are directly related to each other and functions are really required in order to organize your variables properly.

So we're going to build a function here and we're going to call it dashboard greeting. Essentially what this is going to be is it's going to be a function that says hi to the user when they log into a web site it's a pretty common feature to add to applications. The very first thing we are going to do is console log and say Hi there and then right after that put a dot and then say concat pass in the User object dot fullname. And now if we want to run this we'd just because it's a function we have to call it. So say dashboard greeting and then hit run and right there it says "Hi there, Kristine Hudgins" it took the object and pulled out the full name and then it concatenated it with our greeting.

```javascript
function dashboardGreeting(){
console.log("Hi there, ".concat(userObj.fullName));
}

dashboardGreeting();     // "Hi there, Kristine Hudgens"
```

Everything there worked. Now if you're coming from a different language than already this variable scope might seem a little bit weird because our function had access to the user object variable. And certain languages do not allow that kind of scope and they do it because they're more strict where javascript is much more flexible as you're about to see. So all of that already works. Now let's talk about some of the issues associated with this. I'm going paste in this variable declaration and assignment up here but instead of Kristine, I'm going to change the name. So now that I place this variable declaration inside of the function this is what is called a local variable, it is local to the function. If I hit run you can see it says "Hi there, Tiffany Hudgens".

```javascript
function dashboardGreeting() {
  var userObj = {
    email: 'sample@example.com',
    fullName: 'Tiffany Hudgens'
  }
  console.log("Hi there, ".concat(userObj.fullName));
}

dashboardGreeting();  // "Hi there, Tiffany Hudgens"
```

This performed an override. But now you may be asking, that seems pretty logical. That is exactly what it should be doing because we redeclare it and reassigned it and changed the value. Well here is where it starts to get a little bit tricky. Let's come down here and say console log and we'll go with userObj.fullname.

Now, what do you think is going to happen here? We already declared and assigned our user object variable with these values then we took the same variable or I should say what was named the same. And then inside of the function, we added different values. Now, we can see what we had in the function. And now we're going to be able to see what our user object is actually set to. If I hit run, now we can see that it prints out. Tiffany Hudgins but then it prints out Kristine. So what exactly is going on?

Well, this is where it gets into the local scope. So when we talk about variable scope it gets routed through and it's managed with the function. So in other words the user object here is actually local to this function. So the only values or the only time you can use these values are while you're inside of the function. Everything outside of that is considered out of scope. And this leads me to one of the most important things that I hope you remember from this guide and that is that you need to be incredibly careful when it comes to what's called polluting the global scope. polluting the global variable scope.

The reason for that is right here we've just created a global variable. If we have a program that has hundreds of files we may rename. Or we may name another variable later on user object. So it's a generic enough name we may rename it and then accidentally override that value and then all of a sudden our program breaks what if the new user object doesn't even have a full name function but we just overrode it with something new. That could lead to all kinds of issues, the best practice is to not even have any global variables or to have a very limited number of them because whenever they're in functions you can use them the way they're supposed to without having that weird type of behavior.

Now I want to add one caveat before we finish and that is that I'm going to put that code back. Now there's one very weird thing that if you have never seen it before might seem a little bit tricky. If I get rid of the VAR declaration then you're going to see something kind of odd. I'm going to clear this out. Hit run and look at that. Now our user object is no longer within the scope of the function. This is no longer local. So that is something they have to be very careful on. And it's one of the reasons why it's very important to put VAR or LET whenever you're declaring a variable.

The reason for it is because if you get out of the habit of doing that then there's a very good chance that you might accidentally and even while inside of a function you may accidentally create a global variable. So that's what the syntax is if you want to create a global variable while in a function then you just leave off the VAR keyword and it will simply go create it, the way if you remember back to when we talked about javascript variable hoisting. It'll pull it up and it'll treat it as a regular variable.

That's definitely something that you want to avoid. And so I recommend whenever you're using these functions you want to make sure you keep them local. Make sure you put a VAR there and then try to prevent yourself from using too many global variables because you will run into a number of very confusing bugs. So that is an introduction to variable scope in javascript.

```javascript
var userObj = {
  email: 'sample@example.com',
  fullName: 'Kristine Hudgens'
}

function dashboardGreeting() {
  var userObj = {
    email: 'sample2@example.com',
    fullName: 'Jordan Hudgens'
  }
  console.log("Hi there, ".concat(userObj.fullName));
}

dashboardGreeting();
console.log(userObj.fullName);
```

### Resources

* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_d_02_variable_scope.js)

***

##
