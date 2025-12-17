# MODULE 04 - 052: JavaScript

## Modern JS (3):    Arrow Functions (1)

***

1. Traditional Function Declaration
2. Function Expression
3. Arrow Functions
4. Single Argument Arrow Function
5. Multiple Arguments Arrow Function
6. Differences Between Function Expression and Arrow Functions

***

This lesson introduces **arrow functions**, one of the most essential concepts in modern JavaScript. They're concise, widely used, and sometimes visually intimidating to beginners. Let’s break down their structure, use cases, and differences from traditional functions.

***

### 1. Traditional Function Declaration

You can declare a function using the `function` keyword followed by the function name and parameters:

```js
function fullName(fName, lName) {
  console.log(`${lName}, ${fName}`);
}
fullName('Tiffany', 'Hudgens');
```

Reference: [function - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/function)

***

### 2. Function Expression

Functions can also be stored in variables. This is known as a **function expression**, and the function itself is often **anonymous**:

```js
const fullName = function(fName, lName) {
  console.log(`${fName}, ${lName}`);
};
fullName('Kristine', 'Hudgens');
```

Reference: [function expression - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/function)

***

### 3. Arrow Functions – Basic Syntax

Arrow functions are shorthand for function expressions. Here's the most basic example:

```js
const helloWorld = () => {
  console.log("Hi there");
};
helloWorld();
```

They use the arrow syntax =>, and are always either:

```
Stored in a variable, or

Immediately executed.
```

Reference: [Arrow function expressions - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions)

***

### 4. Single Argument Arrow Function

If an arrow function has **only one parameter**, you can omit the parentheses:

```js
const firstName = fname => {
  console.log(fname.toUpperCase());
};
firstName('Jordan');
```

Reference: https://javascript.info/arrow-functions-basics

***

### 5. Multiple Arguments Arrow Function

When using **two or more parameters**, parentheses are required:

```js
const fullName = (fName, lName) => {
  console.log(`${lName}, ${fName}`);
};
fullName('Kristine', 'Hudgens');
```

***

### 6. Differences between Function Expression and Arrows

Arrow functions:

* Are always anonymous.
* Must be assigned to a variable or used inline.
* Do not bind their own `this`, which is useful (or problematic) depending on context (covered in next lesson).

Reference: [Arrow function expressions - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Functions/Arrow_functions#arrow_functions_vs_function_expressions)

***

## Video lesson Speech

In this part of the section we're going to start looking at Arrow\
functions, now arrow functions are one of the most critical things to\
learn in modern javascript. You're going to see them all over the place\
and if you have never seen them before if you've never worked with them\
before, they can look a little bit intimidating.

***

They look completely different than any other type of function declaration that you've seen if you've just been doing plain vanilla javascript. In older versions. So as a review let's talk about two ways that you can create a function in javascript.

The first is going to be a regular function declaration. So if I say function and say fullName. Say fName and lName for a first name and last name. Now I can console log this and say and I'm going to use our more modern versions of string interpolation here, and I’ll say fname and then I'll just add this to the last name.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Screen+Shot+2017-10-26+at+7.36.31+PM.png)

That is all I have to do. And now if I call this so, if I say full name it's going to print out the names that I give it so I'll pass in Kristine and Hudgens. If I run this code right here. It turns out Kristine Hudgens no surprise.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Screen+Shot+2017-10-26+at+7.44.56+PM.png)

Now that's one way of doing it. And I'm going to copy this and coming down. I'm going to do a second way, and that is by using a function expression. Remember that's where we declare a function but we store them inside of a variable.

The variables still going to be called fullName. So I'm going to say fullName and then we're going to have a function but we don't have to declare full name like this anymore. Now we can just say function and then this is what's called an anonymous function, but we still call it the exact same way.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Screen+Shot+2017-10-26+at+7.52.18+PM.png)

So if I save and then run this then we get the exact same output. So the first one is a function declaration. The second one is a function expression.

Now we're going to talk about the arrow function because it is a new way and it is incredibly popular, so popular in fact that you are going to see it in so many different applications that I wanted to dedicate an entire little mini part of the course just to arrow functions. Eventually, we are going to replicate our full name function as an arrow one.

One thing that I've found helps students out a lot when it comes to understanding arrow functions is by you declaring the world's most simple arrow function in the world. So the way I do that is with a Hello world. So say hello world and set this with no parameters and I'm going to step through all of this in a second, then I'm going to pass in an arrow. That's the name of the arrow function it's because it has a equals followed by a greater than sign. And then we're going to pass a code block here inside of curly braces. Console log and then inside of that I'll say hi there. And that's the semicolon. And I do have to put a semicolon right after this.\
But then I do have to call hello world the same way we'd call a function.

So now I can call hello world if I hit clear and then run this one. Now it's going to just print out. Hi there just like this.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Screen+Shot+2017-10-26+at+8.35.31+PM.png)

So this is the world's most basic arrow function. First, it always has to be stored inside of a variable or executed right away. We're not going to get into the immediately executing functions yet. We can worry about those later.

For right now, just think of arrow functions are like anonymous functions so they're very similar to function expressions like we have up here. But instead of adding the function name we just have these parens followed by an arrow followed by what we want to execute.

Now the number one thing that I want to focus on with this is first not just the syntax but also just so you do not get intimidated when you see these because it is the exact same thing as what we're doing up here.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Screen+Shot+2017-10-26+at+7.52.18+PM.png)

There are just a few subtle differences in the changes, and we're going to go through the times where you want to use an arrow function, versus when you'd want to use something else.

For right now I just want to show you the similarities so you can get used to this kind of syntax. So here this is our base case hello world example. Just to reiterate you store it in a variable you set that equal to parens, and if you have arguments that's where the parens would go. Then we have an arrow then we have the process we want to run.

So now with all of that in place let's talk about taking it a step further. Now the next one I'm going to do is the way that you can implement an arrow function if you only have a single argument.`// Arrow function with shorthand function argument for single arguments firstName = fname => { console.log(fname.toUpperCase()); } firstName('Jordan');`

So here I can say firstName and this is to be the name of the function. And then I'm going to pass a single argument which will be fname and then give the arrow function and then I'm going to copy my console log up here.

So inside of this, I'm just going to pass in the argument which is fname and then I'm also going to call a function on it, just so you can see that you can do that.

`// Arrow function with shorthand function argument for single arguments firstName = fname => { console.log(fname.toUpperCase()); } firstName('Jordan');`

So I'm going to say to uppercase which will make it all capitalized and it's a function. So I pass it in just like that.

Now I can call first name pass in the value, and now if I clear and run this is going to print out. Kristine, I misspelled my own daughter's name. She wouldn't like that but it is going to run. So it's going to print out the name. And it also ran this function on it.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Screen+Shot+2017-10-26+at+8.50.27+PM.png)

It converted it to uppercase so this is exactly the way that you can do it when you only have a single argument. Now if you remember earlier I said that the parens are where you put your arguments and if you have more than one then yes you do need to have parens but as a shortcut and you will see both syntaxes. If you only have a single argument then it does not need the parens around it.

Now if you want to. It is going to have no effect. I can have run and everything runs exactly the same it's up to you if you want to use them or not. And I'm going to save them just like this in case you do want to remember the syntax.

Now the next one we're going to talk about is what you want to do if you have multiple arguments, this is where we're going to get into replicating these functions up here.

```js
// Same function written as function declaration
function fullName (fName, lName) { 
  console.log(`${lName}, ${fName}`);
}
fullName('Tiffany', 'Hudgens');

// Same function written as function expression
fullName = function (fName, lName) {
  console.log(`${fName}, ${lName}`);
}
fullName('Kristine', 'Hudgens');

// Basic arrow function
helloWorld = () => { console.log("Hi there"); }
helloWorld();
```

So now I'm going to do a couple of things. I'm going to just copy this syntax. Just so we can have that. Except I to change it to full name, and then for the arguments, I now am going to wrap it in parentheses, say, fname and lname just like this. Followed by the arrow and followed by our expression by what the process is we want to actually run.

```js
// Arrow function with multiple arguments
fullName = (fName, lName) => { console.log(`${lName}, ${fName}`); }
fullName('Kristine', 'Hudgens');
```

Just to show you that there are the exact same. I'm going to copy this paste it down here. Clear. And now I can call and let's copy this again just so you can see there is literally no difference in when we're calling these. So now I'll call full name pass in these values.

Now if I run this it prints out. Kristine Hudgins. Exactly like before. So that's one big thing I want you to take away from this guide, is that an arrow function is just another way of defining a function it's another way of setting up some process that you want to wrap up you want to encapsulate and then you want to call it later which is at its most base case it is exactly what a function is.

It's simply a little bit more of a clean way of doing it. And if you're thinking that this is completely pointless because you've already spent a ton of time learning how to remember function followed by name followed by arguments and even the anonymous way of doing it and you think that this is pointless it's not quite.\
And in the next guide, we're going to get into the subtle differences on when you do want to use an arrow function and when you may not want to do it in it all is based on how it works inside of other functions. And inside of, later on, INSIDE of classes so that's where you get into in the next guide.

***

## Code

```js
// Same function written as function declaration
function fullName (fName, lName) { 
  console.log(`${lName}, ${fName}`);
}
fullName('Tiffany', 'Hudgens');

// Same function written as function expression
fullName = (fName, lName) => { 
  console.log(`${lName}, ${fName}`);
}
fullName('Kristine', 'Hudgens');

// Basic arrow function
helloWorld = () => { console.log("Hi there"); }
helloWorld();

// Arrow function with shorthand function argument for single arguments
firstName = fname => { console.log(fname.toUpperCase()); }
firstName('Jordan');

// Arrow function with multiple arguments
fullName = (fName, lName) => { console.log(`${lName}, ${fName}`); }
fullName('Kristine', 'Hudgens');
```

***

## Coding Exercise

Use a function expression called `userInfo` with three arguments for `city`, `state`, and `zip`. It must return `Lehi, UT 84043`.
