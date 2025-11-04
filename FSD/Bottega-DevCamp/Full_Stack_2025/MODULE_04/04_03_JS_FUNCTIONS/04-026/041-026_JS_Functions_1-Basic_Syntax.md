# MODULE 04 - 026: JavaScript

## Functions (1) - Basic Syntax

---

1. Function Declaration Syntax  
2. Calling vs Defining Functions  
3. Return Statements vs Console Output  
4. Storing Function Results  
5. Common Patterns and Best Practices  

****

In JavaScript, **functions** are fundamental building blocks that encapsulate reusable code. They can:  

- Perform actions (like logging to console)  
- Calculate values  
- Return data for later use  
- Be passed around as variables  

Understanding function syntax and behavior is crucial for effective JavaScript programming.

****

## 1. Function Declaration Syntax

The basic structure for declaring a function:

```js
function functionName() {

    // Function body
}
```

Example:

```js
function greet() {
    console.log('Hello world!');
}
```

Function components are:

- `function` keyword  
- Function name (follows variable naming rules)  
- Parentheses `()` for parameters (empty if none)  
- Curly braces `{}` enclosing the function body  

****

## 2. Calling/Invoking vs Defining Functions

**Defining** a function stores it in memory but doesn't execute it:

```js
function sayHi() {
    console.log('Hi there');
} 
// Nothing happens yet
```

**Calling** a function executes its code:

```js
sayHi(); // Output: "Hi there"
```

The parentheses `()` are required to invoke the function.

****

## 3. Return Statements vs Console Output

### Console Output Functions

These perform actions but don't return usable values:

```js
function logMessage() {
    console.log('This appears in console');
}

let result = logMessage(); 
// Console shows: "This appears in console"
// But result === undefined
```

### Value-Returning Functions

These provide data that can be stored or used:

```js
function getMessage() {
    return 'This is returned data';
}

let message = getMessage(); 
// message === "This is returned data"
```

Key differences:

- `console.log()` outputs to console only  
- `return` provides data back to the caller  
- Void functions return `undefined` by default  

****

## 4. Storing Function Results

Returned values can be assigned to variables:

```js
function generateGreeting() {
    return 'Hello there!';
}

let greeting = generateGreeting();
console.log(greeting); // "Hello there!"
```

This pattern is essential for:

- Data processing pipelines  
- API response handling  
- Transformations between application layers  

****

## 5. Common Patterns and Best Practices

### Explicit Returns

Always prefer returning values over side effects:

```js
// YES!
function calculateTotal(price, tax) {
    return price * (1 + tax);
}

// NOPE!
function badCalculate(price, tax) {
    console.log(price * (1 + tax));
}
```

### Single Responsibility

Each function should do one thing well:

```js
// YEP!
function formatName(user) {
    return `${user.first} ${user.last}`;
}

// NOPE!
function messyFunction(user) {
    // Formats name, saves to DB, sends email...
}
```

### Naming Conventions

Use verbs that describe the function's action:

- `getUserData()`  
- `calculateTotal()`  
- `validateInput()`  

****

## Advanced Considerations

### Hoisting

Function declarations are hoisted (can be called before definition):

```js
sayHello(); // Works due to hoisting

function sayHello() {
    return 'Hello!';
}
```

### Function Expressions

Alternative syntax using variable assignment:

```js
const greet = function() {
    return 'Hello!';
};
```

### Arrow Functions (ES6+)

Modern concise syntax:

```js
const greet = () => 'Hello!';
```

****

## Resources

- [MDN: Functions](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Functions)  
- [JavaScript.info: Functions](https://javascript.info/function-basics)  
- [W3Schools: JavaScript Functions](https://www.w3schools.com/js/js_functions.asp)  

---

## Code Examples

Basic function declaration:

```js
function welcomeUser() {
    return 'Welcome to our app!';
}
```

Function with parameters:

```js
function createGreeting(name) {
    return `Hello, ${name}!`;
}
```

Storing function results:

```js
function doubleNumber(num) {
    return num * 2;
}

let doubled = doubleNumber(5); // 10
```

****

## Video lesson Speech

This introductory guide walks through how to write JavaScript functions.
 Additionally, we examine the difference between console output and 
returning values.

****

I'm really excited to get into this section on functions because when it comes down to it javascript is really built on functions and one of the things that makes javascript so much different than so many other programming languages is how it allows you to work with functions and pass them around, work with them in a much more flexible much more scalable manner than other programming languages. 

That doesn't have to make sense right now. We're going to get into that into much more detail throughout this section. This is going to be much longer than say the conditional section just because there is so much to learn about how to use functions in Javascript. 

I have the javascript console open right now and we're going to start off by just building a very basic function. The syntax for this is just going to be, say the word function followed by whatever you want to call it. I'm going to say function and then hi thereafter that you need to put parentheses. If you have a function that does not take any arguments then you just put empty parentheses. We'll get into what arguments are later on. 

For right now just know that they are other items other components objects are variables things like that you can pass into the function when you call it. So that's the first part. After that, you're going to place curly brackets{}. And so if you're working in the console it's going to put you on the next line and then eventually when we're done we're going to close out the curly brackets.

But right now we're just going to put a very basic console log statement in here. So it's going to say console log. And It'll say hi there and let's close it out with curly brackets and then it's done. 

```javascript
function hiThere(){
console.log('Hi there');
}
```

That is your very first function inside of javascript. Now you notice nothing happened. So right there it says undefined what that means is nothing got returned. Nothing happened by just defining how the functions going to be. In order to have this print out what we have to do is say hi there. Put in the parens and then a semicolon hit return. And now you can see that it printed it out. Hi there. So that is how you can call a function in javascript. 

Now I want to point something out that is incredibly important, and if you are new to programming then this may take a little while until it really seeps in and you understand exactly what's going on here. And this is the reason why I'm using the javascript console right now instead of using code Penn. because it shows what gets returned. I mentioned earlier on in the course we are going to come back and we're going to talk about what it means to return a value and now it's time to do that. 

Our function here didn't actually return anything. All it did it was it printed out to the console, Hi there. That's all well and good. However, there are very few times where you're going to be building a function that does not return anything whatsoever. And the name for that is called a void function.

What that means is this function is going to run but it's not going to return anything back. That would be would be something like where you're running a process. But the process doesn't return anything like starting up. Maybe a portion of a server or something like that. And so for right now you don't have to worry about what exactly it's doing here. So when I say function 'Hi there' console log all that's happening is it's printing to the console. 

Now if you want to have this function actually do something so that you could call the function from later on in the program and have the value of hi there returned. That is where we get into what it takes to return a value so I'm going to create a new function. It's going to be hiThereTwo. It's not going to take any arguments and inside of it. Instead of running console.log, I'm going to say return 'Hi there again'. You end the curly brackets to end that function and that's it. Now nothing still is returned yet. Whenever you define a method you're simply defining it nothing is it going to happen when you're finished. Now in order to get that to happen, we need to call it. So we're going to call hiThereTwo. And then semicolon hit return and that is where it's different.

```javascript
function hiThereTwo() {
    return 'Hi there again';
}

hiThereTwo(); // "Hi there again"
```

If you look at both of these when we called hi there, just the first one. It printed this out to the console but then it didn't return anything. When it says undefined that means that nothing got returned. In other words, you say that you wanted to call this and store the value of this inside of a variable. You would not be able to do that because right here doesn't return anything it would simply be called, it print's out to the console, and then it would be done. 

However, if you want to actually use the value of the function later on you need to return it. So that is the reason why I chose to use the javascript console for this because it shows if something was undefined meaning nothing got returned by running that code or if it did return a value. I said it a few times, and the reason I'm saying it is because this part can lead to a lot of confusion, especially for new developers. In understanding what this means, so let's go on with one other example. 

I'm going to create a new variable. And this variable is going to be stored in text. And from here I'm going to call our function. So you say hi there. Just the first one hit return. You can see hi there did get printed out. So that got printed out to the console. 

```javascript
var storedText = hiThere(); // Hi there
```

But now if I call stored text the variable you can see nothing is inside of it. 

```javascript
storedText; // undefined
```

So there is no value that got placed inside of the variable. 

So let's try this again now with another variable 

```javascript
var storedTextTwo = hiThereTwo();
storedTextTwo; // "Hi there again"
```

Make sure you put the parentheses at the end in order to call it. Now nothing got printed out. But if I call the variable and hit return you can see that now it actually printed that value out because it was returned which means that it actually got stored inside of here. This is going to be a pattern that you follow for pretty much all of your javascript development. 

Say that you're building some type of database query you're going to have a function that goes and queries the database and then you're going to store it you're going to return all of those records from the database query store it inside of a variable so that it can be printed out and shown on the page. That is how the return works it's how you're able to pass data and return data or return messages or return all of these different types of components when a function is called. 

I hope that made some sense and you now know how to build functions in javascript. Because this is a little bit more weighty of a topic. I'd definitely recommend before going on to the next video that you start to examine how you can build your own functions start to combine some of the other things that we discussed such as conditionals or anything like that put them inside and you have to get everything working but definitely try out how you can do it how you can call the functions store them in variables pass them around. Because this is going to be something that is going to help you out a lot as you continue your development journey.

```javascript
function hiThere () {
    console.log('Hi there');
}

hiThere(); // Hi there

function hiThereTwo() {
    return 'Hi there again';
}

hiThereTwo(); // "Hi there again"

var storedText = hiThere(); // Hi there

storedText; // undefined

var storedTextTwo = hiThereTwo();

storedTextTwo; // "Hi there again"
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_d_01_function_syntax.js)

****

## Coding Exercise

Create a function called `greeting` that returns a string when the function is called.

```js
//
```
