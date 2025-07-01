# Module 04-010: JavaScript `typeof` Operator

## Perform Type Casting in JavaScript

1. Basic Usage
2. Special Cases 
3. Practical Applications  
4. 

---

The `typeof` operator is JavaScript's built-in tool for **type checking** variables and values. It returns a string indicating the data type of its operand, which is crucial because:

- Different data types support different methods
- Many functions require specific input types
- Helps prevent runtime errors through type validation

> "Knowing your data types is like knowing the tools in your workshop - you can't use a hammer where you need a screwdriver."  
> — JavaScript Best Practices

---

## Basic Usage

```javascript
typeof operand

// or

typeof(operand)
```

****

### Primitive Type Checks

```js
typeof 12;          // "number"

typeof 'Astros';    // "string"

typeof true;        // "boolean"

typeof undefined;   // "undefined"

typeof Symbol();    // "symbol" (ES6+)

typeof 42n;         // "bigint" (ES2020+)
```

****

### Object Types

```js
typeof { name: "Kristine" };  // "object"

typeof [1, 2, 3];             // "object" (not "array")

typeof null;                  // "object" (never-fixed bug)

typeof function() {};         // "function"

typeof NaN;                    // number (Not Assigned Number)
```

****

## Special Cases

1. `NaN` -> Not Assigned Number -> **Number**

2. **Null Quirk**  
   
   `typeof null` returns `"object"` due to a historical JavaScript bug that can't be fixed without breaking existing code.

3. **Function Identification**  
   Functions are technically objects, but `typeof` helpfully returns `"function"`

4. **Array Detection**  
   For arrays, use `Array.isArray()` instead:

```js
Array.isArray([1, 2, 3]);  // true
```

****

## Practical Applications

### 1. Input Validation

```js
function calculateTax(amount) {

if (typeof amount !== 'number') {

    throw new Error('Tax amount must be a number');
    }

    return amount * 0.2;
}
```

### 2. Optional UI Elements

```js
function setDefaultAge(user) {
  if (typeof user.age === 'undefined') {
    user.age = 18;
  }
}
```

### 3. Default Value Assignment

```js
function setDefaultAge(user) {
  if (typeof user.age === 'undefined') {
    user.age = 18;
  }
}
```

****

## Common Pitfalls

1. **Undefined vs. Undeclared**
   
   ```js
   typeof undeclaredVar;  // "undefined" (no error)
   undeclaredVar;         // ReferenceError
   ```

2. **Constructor Objects**
   
   ```js
   typeof new String('hello');  // "object" (not "string")
   ```

3. **NaN Detection**
   Use `Number.isNaN()` instead of `typeof` for NaN checks.

****

## Reference Table

| Value     | `typeof` Return |
| --------- | --------------- |
| Number    | "number"        |
| String    | "string"        |
| Boolean   | "boolean"       |
| undefined | "undefined"     |
| null      | "object"        |
| Array     | "object"        |
| Object    | "object"        |
| Function  | "function"      |
| Symbol    | "symbol"        |
| BigInt    | "bigint"        |

****

## References

* https://javascript.info/types#type-typeof

* [typeof - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/typeof)

* [ECMAScript® 2025 Language&nbsp;Specification](https://tc39.es/ecma262/#sec-typeof-operator)

****

## Video lesson Speech

Checking for a component's data type in JavaScript can be very important
 since the data type determines the types of functions that can be 
passed. In this guide we'll examine how you can check for data types in 
JavaScript.

****

Now that we've discussed variables and the various data types related to javascript. Let's see how we can find out what kind of data type a specific element is. This may not seem like the most important thing but you will actually see as you get further down in the course and also as you build out projects that this is incredibly important because you need to be able to know what type of object you're working with, what type of data type you're working with. 

Because if you don't know that then you're not going to know what types of functions you can call on them which is something you're going to be doing pretty much all day long. So let's talk about how we can do that. I am not using CodePen for this one. I'm using the regular javascript console in the browser's developer tools. The reason for that is because I like how it shows returned elements not just the items that get printed out. I don't want to console log each one of these. In order to find this out see what type of data type something fits into, there is the type of function, you can pass something to it. Right here I can pass 12, run it and you can see that it tells us that 12 is a type of number. 

```javascript
typeof 12;
"number"
```

Now if I pass in a string

```javascript
typeof 'Astros';
"string"
```

it will tell me that this is a string so this is a way of being able to quickly check to see what type of data element something is.
If we want to keep on going down the line of some of the other ones if you want to check to see if something is a Boolean, you do type of true and it'll tell you Boolean. 

```javascript
typeof true;
"boolean"
```

We could go down the list on each one of these. I'm only going to do one more which is the object.
If I do

```javascript
typeof { name: "Kristine" };
"object"
```

this is going to tell me this is an object.

You can see that we have a number, a string, a boolean, and an object. This is something that's pretty helpful but it probably doesn't make a ton of sense on why you'd want to use that. So let's go through a little bit of a more practical example. Right here, I can say 

```javascript
var age;
undefined
```

you can see that this is undefined. 

Now imagine a program where all the code isn't right in front of you because many times you're going to be using code libraries and you're not going to have the nice list of every one of the variables or functions you have access to and you may also not know what type of data they're returning. Because imagine one scenario where age gets sent to you as a string. So in other words it might be 12, but it might be 12 represented as a string, or it could be an integer like our example or the number data type. 

That is something that is very important to know. Now that we have our variable, pretend it's way up in some other file we can't even see it. We can run a program and say

```javascript
typeof age; 
"undefined"
```

Right now, it's undefined. Undefined is a type we can check to see has something been set. If not it's going to be equal to undefined and then we can go and see what is there. Another thing you could also do is say that you wanted to see if there were any values inside of it you could do.

Is set    `age = null`

Now if I say 

```javascript
typeof age;
"object"
```

you can see now it's an object.

That is something to keep in mind that null is going to return object, in this case, it was stored in the age variable a good example of that would be, imagine that you know a web application and you weren't sure if all of the values that were coming back are going to be full. 

You knew what you had access to, but you didn't know which elements actually had something. For example, I talked about if you had a web application and one of the attributes was a Twitter username but it's optional, it may or may not have information. If it does have it you may want to do something like make it clickable and go to the Twitter profile page. If it doesn't exist you don't want the link to show up at all. 

In that case, you can check to see if it's this value is undefined, or in this case, is that value null? If it is then I don't even want you to show that element whatsoever. That's just kind of one very basic example of why this high level of checking can be important, and when it can be very helpful. Another would be the age example that I gave earlier where age might sometimes be a string, or sometimes might be a number depending on what its data type is. That's going to determine what types of functions you can pass to it.

That is something that is very important to know and good to keep in mind it's starting to get into things that are slightly more advanced but I don't want to go through this without giving you an idea on how you can check for data types because later on in the course when we do, do that kind of thing I want you to already have an introduction to it in your mind. So that is how you can check for the data type of any element inside a javascript.

```javascript
typeof 12;
// "number"

typeof 'Astros';
// "string"

typeof true;
// "boolean"

typeof { name: "Kristine" };
// "object"

var age;
// undefined

typeof age;
// "undefined"

age = null;
// null

typeof age;
// "object"
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_b_11_typeof.js)
