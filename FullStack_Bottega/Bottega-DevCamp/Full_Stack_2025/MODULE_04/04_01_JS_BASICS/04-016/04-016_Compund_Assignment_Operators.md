# Module 04-016: JavaScript - Compounds

## Compound Assignment Operator

***

1. Common Compound Assignments
2. Logical Operators
3.
4. Full Operator Reference

***

#### ⚠️ This guide expands the original guide content by explaining Compound Logicals and, therefore, the Logical Operators as I think is the proper moment to know about them.

***

## Common Compound Operators

Compound operators combine assignment with arithmetic operations:

```js
let total = 0;
total += 5;            // Equivalent to: total = total + 5
```

Key Characteristics:

* Shorthand for common operations
* Modifies variable in place
* Returns the new value
* Works with all arithmetic operators

***

## Common Compound Assignments

### Basic Arithmetic Operations

```js
let value = 10;

value += 5;    // Addition: 15

value -= 3;    // Subtraction: (15 - 3) = 12
value *= 2;    // Multiplication: (12 * 2) = 24
value /= 4;    // Division: (24 / 4) = 6
value %= 6;    // Modulus: ( 6 % 5) = 1
value **= 3;    // Exponentiation: ( 3**1 ) =) 1
```

### String Concatenation

```js
let message = 'Hello';

message += ' World';     // "Hello World"
```

***

## Practical Use Cases

1. **Running Totals**

```js
let cartTotal = 0;

cartTotal += item1.price;
cartTotal += item2.price;
```

2. **Score Tracking**

```js
let score = 100;

score -= penaltyPoints;

score += bonusPoints;
```

3. **Exponential Growth**

```js
let bacteria = 2;

bacteria **= 10;     // 2^10 = 1024
```

4. **String Code Building**

```js
let html = '';

html += '<header>';
html += '<main>';
html += '</main>';
```

***

## Operator Precedence

Compound operators have lower precedence than standalone arithmetic:

```js
let x = 5;

x *= 2 + 3; // 25 (not 13)
```

Evaluation Order:

1. Right-side expression (`2 + 3 = 5`)
2. Compound operation (`5 * 5 = 25`)

***

## Complete Reference Table

| Operator | Example   | Equivalent   | Description                            |
| -------- | --------- | ------------ | -------------------------------------- |
| +=       | x += y    | x = x + y    | Addition assignment                    |
| -=       | x -= y    | x = x - y    | Subtraction assignment                 |
| \*=      | x \*= y   | x = x \* y   | Multiplication assignment              |
| /=       | x /= y    | x = x / y    | Division assignment                    |
| %=       | x %= y    | x = x % y    | Remainder (modulo) assignment          |
| \*\*=    | x \*\*= y | x = x \*\* y | Exponentiation assignment              |
| &&=      | x &&= y   | x && (x = y) | Logical AND assignment (ES2021)        |
|  = x     |           |              | Logical OR assignment (ES2021)         |
| ??=      | x ??= y   | x ?? (x = y) | Nullish coalescing assignment (ES2021) |

## Logical Operators

### Core Logical Operators

| Operator | Name               | Example  | Description                                                |
| -------- | ------------------ | -------- | ---------------------------------------------------------- |
| &&       | Logical AND        | a && b   | Returns `b` if `a` is truthy, otherwise returns `a`.       |
| \|\|     | Logical OR         | a \|\| b | Returns `a` if `a` is truthy, otherwise returns `b`.       |
| !        | Logical NOT        | !a       | Returns `false` if `a` is truthy, `true` if `a` is falsy.  |
| ??       | Nullish Coalescing | a ?? b   | Returns `b` only if `a` is `null` or `undefined` (ES2020). |

***

## Advanced Logical Concepts

### Short-Circuit Evaluation

```js
// && stops if first operand is falsy
false && console.log("Never runs");

// || stops if first operand is truthy
true || console.log("Never runs");
```

### Practical Patterns

1.  **Default Values**

    ```js
    const username = input || "Anonymous";
    ```
2.  **Conditional Property Access**

    ```js
    const street = user.address && user.address.street;
    ```
3.  **Nullish Coalescing vs OR**

    ```js
    const count = 0;

    count || 10;    // 10 (0 is falsy)

    count ?? 10;    // 0 (only null/undefined trigger fallback)
    ```

***

## Operator Precedence Hierarchy

1. Grouping `()`
2. NOT `!`
3. Arithmetic `* / % + -`
4. Comparison `< <= > >=`
5. Equality `== != === !==`
6. AND `&&`
7. OR `||`
8. Nullish Coalescing `??`
9. Assignment `= += -=`

Example:

```js
5 + 3 * 2 > 10 && 4 || null  

// Evaluates as ((5 + (3*2)) > 10) && 4) || null
```

***

## Practical Applications

### 1. Feature Toggling

```js
const showAdvanced = user.isAdmin && features.advancedEnabled;
```

### 2. Configuration Fallbacks

```js
const apiTimeout = config.timeout ?? 5000;
```

## 3. Safe Navigation

```js
const email = user.profile && user.profile.contact && user.profile.contact.email;

// Modern alternative: user.profile?.contact?.email (ES2020)
```

### 4. Compound Logical Assignments

```js
// Only assign if current value is falsy

let cache = null;

cache ||= fetchData(); 



// Only assign if current value is null/undefined

let settings = {};

settings.theme ??= 'dark';
```

***

## Remember

1. **Implicit Type Conversion**
   * `+=` with strings performs concatenation
   * Other operators convert strings to numbers
2. **Readability vs Brevity**
   * Best for simple in-place modifications
   * Consider standard syntax for complex operations
3. **Initialization Requirement**
   *   Variables must be declared before use

       ```js
       let total; 
       total += 5; // NaN (total was undefined)
       ```
4. **Immutable Alternatives**
   *   For functional programming, consider:

       ```js
       const newTotal = oldTotal + value;
       ```
5. **Type Coercion**

* Logical operators use truthy/falsy evaluation
* Use `===` for strict type comparisons when needed

6. **Readability**

* Avoid complex nested logical expressions
* Consider temporary variables for clarity

7. **Modern Alternatives**

* Optional chaining (`?.`) often replaces `&&` checks
* Nullish coalescing (`??`) is safer than `||` for numeric 0

8. **Performance**

* Short-circuiting can optimize code
* Complex logical tests may impact readability

***

## Resources

* [Logical OR assignment (||=) - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Logical_OR_assignment)
* https://es.javascript.info/logical-operators
* [W3Schools: JavaScript Operators Reference](https://www.w3schools.com/jsref/jsref_operators.asp)

***

## VIdeo lesson Speech

This lesson examines how to work with the Compound Assignment Operator in JavaScript.

***

Now that we've talked about operators. Let's talk about something called the `compound assignment` operator and I'm going make one little change here in case you're wondering if you ever want to have your console take up the entire window you come up to the top right-hand side here you can undock it into a separate window and you can see that it takes up the entire window.

![large](../../../../../../.gitbook/assets/04-016_IMG1.png)

![large](../../../../../../.gitbook/assets/04-016_IMG2.png)

So just a little bit more room now.

Additionally, I have one other thing I'm going to show you in the show notes. I'm going to give you access to this entire set of assignment operators but we'll go through a few examples here. I'm going to use the entire window just to make it a little bit easier to see.

Let's talk about what `assignment` is. Now we've been using assignment ever since we started writing javascript code. You're probably pretty used to it. Assignment is saying something like var name and then setting up a name

```javascript
var name = 'Tiffany';
```

And that is assignment the equals represents assignment.

Now javascript gives us the ability to have the regular assignment but also to have that assignment perform tasks. So for example say that you want to add items up so say that we want to add up a total set of grades to see the total number of scores. I can say var sum and assign it equal to zero.

```javascript
var sum = 0;
```

And now let's create some grades.

I'm going to say var gradeOne = 100.

```javascript
var gradeOne = 100;
```

and then var gradeTwo = 80.

```javascript
var gradeTwo = 80;
```

Now with both of these items in place say that we wanted to add these if you wanted to just add both of them together you definitely could do something like sum = (gradeOne + gradeTwo); and that would work.

However, one thing I want to show you is, there are many times where you don't have gradeOne or gradeTwo in a variable. You may have those stored in a database and then you're going to loop through that full set of records. And so you need to be able to add them on the fly. And so that's what a `compound assignment` operator can do.

Let's use one of the more basic ones which is to have the addition assignment.

```javascript
sum += gradeOne; // 100
```

Now you can see that sum is equal to 100.

Then if I do

```javascript
sum += gradeTwo; // 180
```

If we had 100 grades we could simply add them just like that.

Essentially what this is equal to is it's a shorthand for saying something like

sum = sum + whatever the next one is say, that we had a gradeThree, it would be the same as doing that. So it's performing assignment, but it also is performing an operation. That's the reason why it's called a compound assignment operator.

Now in addition to having the ability to sum items up, you could also do the same thing with the other operators. In fact literally, every one of the operators that we just went through you can use those in order to do this compound assignment. Say that you wanted to do multiplication you could do sum astrix equals and then gradeTwo and now you can see it equals fourteen thousand four hundred.

```javascript
sum *= gradeTwo; // 14400
```

This is that was the exact same as doing sum = whatever the value of sum was times gradeTwo. That gives you the exact same type of process so that is how you can use the compound assignment operators. And if you reference the guide that is included in the show notes. You can see that we have them for each one of these from regular equals all the way through using exponents.

Then for right now don't worry about the bottom items. These are getting into much more advanced kinds of fields like `bitwise` operators and right and left shift assignments. So everything you need to focus on is actually right at the top for how we're going to be doing this. This is something that you will see in a javascript code. I wanted to include it, so when you see it you're not curious about exactly what's happening.

It's a great shorthand syntax for whenever you want to do assignment but also perform an operation at the same time.

```javascript
var name = 'Tiffany';

var sum = 0;

var gradeOne = 100;

var gradeTwo = 80;

sum += gradeOne; // 100

sum; // 100

sum += gradeTwo; // 180

sum *= gradeTwo; // 14400
```

## Resources

* [Documentation for Compound Assignment Operators](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Expressions_and_Operators)
* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_b_17_compound_assignment_operators.js)

***

## Coding Exercise

You need 250 lemons and 36 limes for your lemonade. Whats your total number of fruit?

```js
//Use Compound Assignment Operators to solve the above problem

function mathTest() {
    //please do not delete this
    var sum = 0;

    //Delete this and assign your variables, then do some math

    //please do not delete this
    return sum;
}

mathTest();
```
