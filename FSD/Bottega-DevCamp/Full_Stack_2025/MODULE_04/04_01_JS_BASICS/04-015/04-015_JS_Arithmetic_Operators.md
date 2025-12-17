# Module 04-015: JavaScript - Arithmetics

## JavaScript Arithmetic Operators

***

1. Basic Arithmetic Operations
2. Modulus Operator
3. Increment/Decrement Operators
4. Unary Operators

***

## Basic Arithmetic Operations

Core mathematical operators in JavaScript:

```js
2 + 2;     // Addition: 4

10 - 3;    // Subtraction: 7

10 / 2;    // Division: 5

2 * 10;    // Multiplication: 20

2 ** 3;    // Exponentiation: 8 (2 to the power of 3)
```

* Follows standard order of operations (PEMDAS/BODMAS)
* Parentheses can override precedence
* Handles integer and floating-point numbers

***

## Modulus Operator

### % (Remainder Operator)

As seen in other languages, modules returns division remainder:

```js
5 % 2;     // 1 (5 divided by 2 leaves remainder 1)

10 % 3;     // 1

8 % 2;     // 0 (even numbers always return 0)
```

Modules Use Cases:

```js
// Check even/odd

function isEven(num) {
     
    return num % 2 === 0;
}

// Circular array indexing

const colors = ['red', 'green', 'blue'];

colors[index % colors.length];
```

***

## Increment/Decrement Operators

### Postfix vs Prefix Notation

```js
let num = 2;

num++;    // Postfix: returns 2, then increments to 3
++num;    // Prefix: increments to 4, returns 4

num--;    // Postfix: returns 4, then decrements to 3
--num;    // Prefix: decrements to 2, returns 2
```

* **Postfix:** returns original value then modifies
* **Prefix**: modifies then returns new value
* Only works on variables (not literals)

***

## Unary Operators

### Type Conversion

```js
let strNum = '100';
let convertedNum = +strNum;     // Converts to number 100

let positive = 10;
let negative = -positive;     // -10
```

**Special Cases:**

```js
+true // 1
+false // 0
+null // 0
+'hello' // NaN
```

***

## Practical Applications

1. **Counter Implementation**

```js
let counter = 0;

function increment() {

    return ++counter;

}
```

2. **Pagination Logic**

```js
function isLastPage(itemCount, itemsPerPage) {

    return itemCount % itemsPerPage === 0;

}
```

3. **Data Transformation**

```js
function celsiusToFahrenheit(celsius) {

    return celsius * 9/5 + 32;

}
```

4. **Input Validation**

```js
function isValidPercentage(num) {

    return num >= 0 && num <= 100;

}
```

***

## Remember

1. **Floating-Point Precision**
   * Use libraries like decimal.js for financial calculations
   * `0.1 + 0.2 !== 0.3` due to IEEE 754 representation
2. **PEMDAS PEDMAS (See next guide=**
   * Multiplication before addition
   * Use parentheses for clarity
3. **Type Coercion**
   * `+` can mean addition or concatenation
   * Be explicit with type conversions
4. **Error Handling, Prevents**
   * Null, NaN, Undefined, Voids, after conversions
   * Divisions by zero cases

***

## Resources

* [Expressions and operators - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators)
* [JavaScript.info: Unaries, Binaries, Operands, Operators](https://javascript.info/operators#string-concatenation-with-binary)
* [JavaScript Arithmetic](https://www.w3schools.com/js/js_arithmetic.asp)

***

## Video lesson Speech

This guide examines the full list of JavaScript arithmetic operators.\
These operators allow for programs to perform computation and can update\
numbers.

***

In this lesson, we're transitioning and we're starting to work with the number data type in javascript and specifically, we're going to analyze the various arithmetic operators available so that we can perform computation.

Now some of these are very basic, but later on, we are going to get into some more advanced kinds of operators. We're going to start off with the very basic ones and I'm going to keep the numbers very simple just so it all makes sense.

```javascript
2 + 2; // 4
```

Not too surprisingly that equals four. And that is the syntax. Now you can also wrap these in parentheses and they'll work exactly the same way. And this will mean much more when we start to talk about the order of operations. And when we want certain computations to be performed versus other ones but we'll save that for another guide.

The next one we're going to do is just

```javascript
2 - 3; // -1
```

That will give us -1 just to show that you also have the ability to work with negative numbers.

Now if I go

```javascript
10 / 2; // 5
```

So far none of this is crazy. It's more of just kind of walking through the syntax.

Now for multiplication. We use the asterisks and we use a single asterisk.

```javascript
2 * 10; // 20
```

And the reason why we use a single Asterix is because when you want to use exponents you're going to use two asterisks.

If I do

```javascript
2 ** 10; // 1024
```

That is how you can use exponents.

Now the next thing that I'm going to walk there may seem kind of weird because there actually is what's called a modulus or a remainder operator in Javascript. And so that will allow us to do, something like this

```javascript
5 % 2; // 1
```

This gives us a remainder of 1 which is accurate.

Now if you are like many students when you see that OPERATOR. The first thing that may pop in your head is I can never imagine a time where I will need to know what the remainder of something is. And technically that seems logical. However, I'm going to show you a very practical reason why this is a very powerful type of tool when used properly.

Imagine that you have a list of numbers and say that you have a table and you want to show every other record. Think of something kind of like Excel so say you're building a table that shows on a web application and you want every other table element. So either the even elements or the odd elements you want them to have a different background color. Well, how are you going to figure out? Which records are even and which ones are odd. Well technically if you use the modulus operator properly you will always know because if you do something like say `10 % 2` this is going to equal 0. Now let's look at `22222 % 2` that is also 0. If you do `6 % 2` that is also 0.

```javascript
10 % 2;
0
```

```javascript
22222 % 2;
0
```

```javascript
6 % 2;
0
```

This is where you see the modulus operator used the very most, whenever you need to find if a number is even or odd because if it is even it is always going to have a remainder of zero when it's some number % 2. So that is something that is very handy and you actually see this in quite a few programming exercises. So that's a good thing to keep in mind and that's when you would want to use it again. Those are the main operators.

Now we're going to get into some of the ones that are a little bit different. Maybe you haven't seen them before or haven't really thought about using them. I'm going to create a variable called var num. Let me set it equal to 2. And now I'm going to use what's called the `increment` operator. So here I can say num++; and this is going to increment. But there's a little bit of a twist on this. So if I hit return you can see it returns 2.

```javascript
var num =2;
undefined
```

```javascript
num++;
2
```

Whatever gets shown in the console and this is why I've been using the console lately instead of codepen. And you're perfectly fine using CodePen but when you do that you have to console log everything out and that takes longer. Right here I'd prefer for you to immediately see what gets returned. This means that you put this in a function or you call this from some other place. This is the number that gets returned which is 2.

But that doesn't make any sense because we started at two. Now I'm going to show you something that looks really weird. If I just print out the number again and hit return it's three.

```javascript
num;
3
```

Nothing happened here. It didn't change to three here. As soon as I called `Increment` this changed it. but it returns the preexisting value. So whenever you use the incrementor you put this in what's called the postfix notation postfix meaning that the operator is placed at the end. Then the number that gets returned is the first number of the preexisting number. It still does its job it still increments it. But this is something where say, that you want to keep a copy of the variable. You could have a copy of the old pre-change pre incremented version. You could store that and then your new number has been changed. So that's one example of when you'd want to use it but now say that's not very intuitive. You don't really like that. Well, you have what's called a prefix notation and that is where you put the operators upfront.

```javascript
++num;
4
```

Now I can call num and look at that. Now it's four. So it was three here and now it's four but it also returns four. I usually find myself using the prefix notation because most of the time I just forget that the postfix notation changes it. It does its increment but then it returns the old value. I've only had a few times where I really needed that type of behavior. Usually, the prefix notation is the type of syntax I use but it's good to know that they're both there.

Now that we have four let's use the `Decrementer` operator so I can do num and then two minus signs and this is going to have the identical behavior. What you think is going to happen? In viewing all of this in viewing everything that's happening here what is going to happen with this `decrement` operator. Think about it. I'm going to hit return and see what happens. It looks like nothing happened. Well let's test that hypothesis, if I type num in again we can see it did change it. It decreases it by one but because we use the postfix notation it worked exactly the same as when we did the `Incrementor`. Now if we want to do something like we did before and actually had the return value mimic what we're wanting we can do\
\--num; And now it takes it down to two which is the value. So it `decrement`ed it and it gave us the value that we expected as the returned value.

```javascript
--num;
2
```

Now we don't want you to get too confused with understanding what it means for something to be returned. We're going to go into depth on what that is and how to work with return values and really what that entire workflow is when we get to the module on functions. So that's when we're going to do that for right now just know that the value that gets returned is a value we can actually work with. We can store it in a variable we could put it in a function we could do anything we wanted to it. But for right now just realize that that is a value that comes back to us after we've run whatever process we're running.

Now there's also a little caveat to the `incrementor` and the `decrementer` and that is, that you have to call it on a variable. Watch what happens if I did this 2++;

![picture](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Javascript+images/decrementor-error.png)

that it gives us an error of uncaught reference error invalid left-hand side expression in postfix operation.

Now if you think about this, that makes sense because if you ever had an actual hard-coded value you had a number, not a variable that stored a number. We actually had a number. Why would you want to use the increment or the decorator? Because if you actually knew the number and you were the one typing it in the program wasn't generating it, it wasn't dynamic because it wasn't in a variable. If you wanted one more than two you could just type three in.

That's just a little caveat a little side note so that you can kind of think through that, there is a difference between variables and the numbers that they store. Remember variables are special containers that can hold values. Now that we have all of that, we've gone through traditional operators, we've gone through `incrementors` and `decrementers`. We only have a few more functions we're going to go through. The next one is going to be a way that we can actually flip the values so we can get a negative on this value. I'm going to call var and then someNum = 10.

And now if I want to assign this but I want the opposite. In this case, I want negative 10. Then I can do this I can say var someOtherNum and then just do minus and then some numb. And now if I call. Some other Num. this gives us negative 10.

```javascript
var someNum = 10;
undefined
```

```javascript
var someOtherNum = -someNum;
undefined
```

```javascript
someOtherNum;
-10
```

Now that may be what you expected but I just wanted to show you that, that was possible. Now we've already referenced this one when we were talking about converting different strings into numbers. But I wanted to cover the `unary` operator one more time, just because it is something that is very powerful and you're going to see it quite a bit in code. It's good to have a good idea of it.

I'm going to say

```javascript
var strNum = '100';
undefined
```

Now if I want to convert it, I can say

```javascript
var convertedNum = + strNum;
undefined
```

Now if I just want to see it.

```javasript
convertedNum;
100
```

You can see that it is no longer a string. It is now part of the number data type. Also, you didn't have to put it in a variable, that's just the common convention you're usually going to see because it's pretty rare that you just have code, for example, say that we just had `+ strNum;` This would work but I wanted to show you the kind of syntax is usually going to see out in the wild. Typically when you're converting different data types usually are going to be putting them in a variable to be used in a function or something like that.

In this guide just as a quick review, we covered all of the basic arithmetic operators from Plus(`+`) all the way through the modulus(`%`) operator. We talked about `incrementors` and `decrementers` which allow us to increase or decrease values by 1 and then we also talked about how we could flip values. And we finished off with seeing how we can convert a string-based number into a number.

```javascript
2 + 2; // 4

2 - 2; // 0

2 / 2; // 1

2 * 10; // 20

5 % 2; // 1

10 % 2; // 0

8 % 2; // 0

2 ** 10; // 1024

var num = 2;

num++; // 2

++num; // 4

num; // 4

num--; // 4

num; // 3

--num; // 2

2++; // VM3506:1 Uncaught ReferenceError: Invalid left-hand side expression in postfix operation

++2; // VM3508:1 Uncaught ReferenceError: Invalid left-hand side expression in prefix operation

var someNum = 10;

var someOtherNum = -someNum;

someOtherNum; // -10

var strNum = '100';

var convertedNum = + strNum;

convertedNum; // 100
```

## Resources

* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_b_16_arithmetic_operators.js)

***

## Coding Exercise

Add the correct arithmetic operators to make variable equal the number in the comment.

```js
numOne = 5 10 // add the right Arithmetic Operators to have it equal 15

numTwo = 90 3 // add the right Arithmetic Operators to have it equal 30

numThree = 50 25 // add the right Arithmetic Operators to have it equal 25

numFour =  20 5 // add the right Arithmetic Operators to have it equal 100
```
