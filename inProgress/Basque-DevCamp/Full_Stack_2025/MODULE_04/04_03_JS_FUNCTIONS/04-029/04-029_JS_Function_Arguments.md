## MODULE 04 - 029: JavaScript

## Functions (4) - Arguments and Parameters

---

1. Parameter Basics  
2. Default Parameter Values  
3. Argument Handling  
4. ES6 Default Parameters  
5. Common Patterns and Best Practices  

****

Function **arguments** (values passed) and **parameters** (variables listed in function definition) are fundamental to creating flexible, reusable functions in JavaScript. Proper use of parameters enables:

- Data customization for function behavior  
- Optional configurations  
- Clear function interfaces  
- Better code organization  

Understanding argument handling is crucial for building robust applications.

****

## 1. Parameter Basics

### Defining Parameters

Parameters are specified in the function declaration:

```js
function greet(firstName, lastName) {

    return `Hello ${firstName} ${lastName}!`;
}
```

### Passing Arguments

Arguments are the actual values passed during function calls:

```js
greet('John', 'Doe');         // "Hello John Doe!"
```

**Key Characteristics:**

- JavaScript is loosely typed (no parameter type enforcement)  
- Parameters are locally scoped to the function  
- Arguments are passed by value (primitives) or reference (objects)  

****

## 2. Default Parameter Values

### Traditional Approach (Pre-ES6)

Using the **OR (`||`)** operator pattern:

```js
function createUser(name, role) {

    role = role || 'user'; // Default if undefined
    return { name, role };
}
```

**Limitations:**

- Falsy values (`0`, `''`, `false`) trigger defaults  
- Requires additional variable assignment  

### Modern ES6 Default Parameters

Cleaner syntax with direct defaults:

```js
function createUser(name, role = 'user') {
    
    return { name, role };

}
```

**Benefits:**

- More readable  
- Only applies when parameter is `undefined`  
- Can use expressions as defaults  

****

## 3. Argument Handling

### Missing Arguments

Unprovided parameters become `undefined`:

```js
function logArgs(a, b) {
    
    console.log(a, b);

}

logArgs(1); // 1 undefined
```

### Extra Arguments

Additional arguments are ignored (but accessible via `arguments` object):

```js
logArgs(1, 2, 3);     // 1 2
```

### The `arguments` Object

Array-like object containing all passed arguments:

```js
function sum() {

    let total = 0;
    
    for (let i = 0; i < arguments.length; i++) {
        total += arguments[i];
    }

    return total;
}
```

**Note:** Avoid `arguments` in modern code - use rest parameters instead.

****

## 4. ES6+ Parameter Features

### Rest Parameters

Capture remaining arguments as an array:

```js
function listStudents(teacher, ...students) {

    console.log(`Teacher: ${teacher}`);
    console.log(`Students: ${students.join(', ')}`);

}
```

### Destructured Parameters

Unpack objects/arrays directly in parameters:

```js
function displayUser({ name, age = 18 }) {
    
    console.log(`${name}, ${age} years old`);

}
```

### Parameter Validation

Modern patterns for robust functions:

```js
function createAccount(username, password) {
    if (typeof username !== 'string') {
        throw new TypeError('Username must be a string');
    }
    
    // ... implementation
}
```

****

## 5. Common Patterns and Best Practices

### Optional Parameters

Place optional parameters last:

```js
function configure(options = {}, requiredParam) {
 
    // Bad - required after optional
}

function configure(requiredParam, options = {}) {
  
    // Good pattern
}
```

### Parameter Documentation

Use JSDoc for clarity:

```js
/**
 * Calculates total price
 * @param {number} basePrice - The item price
 * @param {number} [taxRate=0.05] - Optional tax rate
 */
function calculateTotal(basePrice, taxRate = 0.05) {
    
    return basePrice * (1 + taxRate);

}
```

### Avoid Side Effects

Don't modify parameter objects directly:

```js
function updateProfile(user) {
    
    user.lastUpdated = new Date(); // Mutates original!
     
    // Better: return new object
    return { ...user, lastUpdated: new Date() };

}
```

****

## Advanced Considerations

### Default Parameter Scope

Later parameters can reference earlier ones:

```js
function createElement(type = 'div', content = `New ${type}`) {
  
    return { type, content };

}
```

### Temporal Dead Zone

Parameters have TDZ like `let`/`const`:

```js
function example(a = b, b) {} // ReferenceError
```

### Parameter Evaluation

Defaults are evaluated at call time:

```js
let count = 0;

function increment(step = ++count) {
    
    return step;

}

increment(); // 1
increment(); // 2
```

****

## Code Examples

Basic parameter usage:

```js
function formatName(first, last) {

    return `${last}, ${first}`;

}

formatName('John', 'Doe'); // "Doe, John"
```

ES6 default parameters:

```js
function createPost(title, content = '', tags = []) {

    return { title, content, tags };

}
```

Rest parameters:

```js
function teamRoster(coach, ...players) {
    
    return { coach, players };

}
```

## Resources

- [MDN: Functions](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Functions)  
- [JavaScript.info: Function Parameters](https://javascript.info/function-basics#parameters)  
- [W3Schools: JavaScript Function Parameters](https://www.w3schools.com/js/js_function_parameters.asp)  

---

---

## Video Lesson Speech

This guide describes how to utilize function arguments/parameters in 
javaScript. Additionally, we'll examine how to define default values for
 function arguments.

****

So far we've covered a number of different characteristics with functions both with declarations and expressions. And now we're going to get into how we can actually pass data into functions with function arguments. Now you may also hear these called function parameters and that's what we're going to go through now. 

The very first thing I'm going to create is a function and this is going to be something that I consider a more real-world, mainly because I build this function on a pretty regular basis for the applications I built. So this is going to be called fullName and this is going to take in a firstName and a lastName and then it's going to kind of format them in a way that maybe is considered a little bit more formal. So here is a first name followed by the last name. And these are the function arguments we have. The first parameter right here and then the second one here followed by a comma. 

```javascript
function fullName(firstName, lastName) {
}
```

Now the way that this works is when you pass in one of these words you can use it however you want inside of this function block so in between the curly braces you can treat this just like a variable. Or any other kind of data points you can reference it in whatever value you pass in when you call it is what is it's going to represent during the execution of the function.

So here what I'm going to say is return and I'll say lastName and then toUppercase and you don't have to do this one part of this is just to show you a way of formalizing a name and so you can see that you can do more than just call it. You can also perform various functions on top of the data that you're calling. 

So here I'm going to say .toUpperCase and then I'm going to concat this with a comma and a space and then I'm going to add the firstName on top of it and also say .toUpperCase for that one as well. And then I'm going to close it off and that is all we need to do. 

```javascript
function fullName(firstName, lastName) {
return lastName.toUpperCase() + ", " + firstName.toUpperCase();
}
```

Just to review what we have here is a function declaration with two arguments. And you could also say these are two parameters. The first one is first name. Second one's last name. Now if I ran this, this was going to act kind of weird so if I run the function just by itself. Essentially what this is saying is we just tried to call a function of two uppercase and we weren't able to do that because there was nothing there because it was undefined. So how do we fix this?

Well, this is where we actually pass in real-world values. So here you say Kristine comma and then Hudgins. Now let's try to run this, running this you can see this now work. So it took in the last name it took in both the first name and last name and then we're able to call the last name we made all of the characters uppercase. Then we added a common space and then the first name all uppercase So everything here is working perfectly fine. 

One thing that can be a little bit confusing is, let's create another function. So this is going to be a function and we're just going to call it our sample function with our arg1 and arg2. And now if I want to do something like console log arg1 and then console.log arg2. If I call this if I just say sample and don't pass in any arguments you can see that it prints out undefined and then it returns undefined.

```javascript
function sample(arg1, arg2) {
console.log(arg1);
console.log(arg2);
}

sample();   //undefined
```

So many programming languages would throw an error right here and for a good reason, it's because the function was supposed to have two arguments but nothing got put in. The reason we received an error earlier is that we actually tried to call a function on top of one of those parameters. Now though where we're just passing in and console logging it then javascript does not complain. This is part of one of the issues or one of the complaints people do have with javascript is it is very easy to build a program that does not throw an error but simultaneously doesn't actually work right. And this is a great example of that in languages that are more strict. If you tried to declare a function here and then you tried to call it without the parameters that you required it would throw an error and it would say like the way the programming language Ruby says that you tried to call a method or a function that has multiple arguments but you didn't pass any. 

That's pretty common among most programming languages, not javascript though it's very flexible and so it will let you run this which can lead to some confusing types of things. so you need to make sure that you're very careful with how you are calling those, and also how you're declaring them. 

I'm going to cover one other task here. Which is how to be able to build something and to have default values because that's a very common thing that you need to perform. Whenever you are building out these types of systems, whenever you're using arguments are many times where you will build a function it'll have, say two arguments inside of it that need to be supplied and then one of them you want to make optional. 

How can we do that? Well I'm going to copy our full name function here I'm going to use it but I'm going to add in another parameter so I'm going to say language so we could say this is the first name last name. This is the language that is spoken and we want to have a default argument. In fact, let me put this because it can be a little bit challenging to edit items in the console. Let's go into CodePen. So we have full name, first name, last name, and language. And I want to do something here where we're concatenating languages well. So I can say like a little dash and a space and then concatenate that with just language. Now the way that you can do this is to say that I was to try to console.log the sound, console.log file name, and pass in let's see Jordan Hudgins and nothing else.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Javascript+images/fullName-example.png)

If I were to run this now we'd get Jordan Hudgins in an undefined which is not what we're looking for. I want to have something where English is the default language but we can override it if we want to. 

The way you can override that here is, I can say language and then set this equal to so we can perform assignment here and we can say language or English. 

```javascript
language = language || 'English';
```

And if I run this you can see that this now says English even though we didn't define it. And just to be careful I need to also make this a var. Clear this out and hit run, and you get extra points if you can guess why I wanted to do this. This actually goes back to our conversation on the variable scope. I accidentally when I left var out here I created an accidental global variable which would be a very bad idea. So I created var to make sure that this is specific and local just to the function. And what in the world was I doing here? This may look kind of weird. 

If you remember back to when we're talking about compound conditionals we talked about how you can have multiple conditionals by using two ampersands in a row that is essentially the programming way of saying. And well when you have two pipes(`||`) in a row and in case you're wondering where the pipe is on your keyboard if you've never used it it is the key right under delete or backspace and right of return or enter. So this if you put two of these together what javascript interprets this as is the word or. 

What this is going to do, just to follow it from a data flow perspective. We have the full name with first name last name and the language. Now var language equals language or English. And the way that this works is the javascript engine looks at it and it checks to see is the language defined. If it is it's just going to put that inside and it's going to skip this entirely. However, if it finds this to be undefined then it says well let's look at the right-hand side. So either use this or use this. And if it finds something here then it will store that inside of language. So that is one of the common ways of defining a default value. And so now if I come here and instead I want to change this to be something like Spanish if I clear this out and run this now it gets overridden and it's Spanish because here what happened is when it found the argument of language it stored it and then it skipped over everything here and it just stored it inside our language variable which is what we are returning. So that is how the arguments work inside of javascript. 

```javascript
function fullName(firstName, lastName, language) {
    var language = language || 'English';
    return lastName.toUpperCase() + ", " + firstName.toUpperCase() + " - " + language;
}

console.log(fullName('Jordan', 'Hudgens', 'Spanish'));
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_d_04_function_arguments.js)

****

## Coding Exercise

Create a function called sum that adds two arguments together and returns the sum of the two numbers.

```js

```
