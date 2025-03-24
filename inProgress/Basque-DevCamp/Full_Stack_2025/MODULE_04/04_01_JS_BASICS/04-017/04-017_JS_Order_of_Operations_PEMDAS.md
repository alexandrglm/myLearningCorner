# Module 04-017: JavaScript -

# PEMDAS? PEDMAS? And... BODMAS?

## Order of Operations

****

1. PEMDAS/PEDMAS Overview

2. Operator Precedence Hierarchy

3. Parentheses and Grouping

4. Multiplication/Division Equality

5. BODMAS

---

## PEMDAS/PEDMAS Overview

### Standard Order of Operations

```js
5 + 5 * 10;     // 55 (not 100)
```



**PEMDAS Mnemonic** (US Standard):

- **P**arentheses

- **E**xponents

- **M**ultiplication

- **D**ivision

- **A**ddition

- **S**ubtraction

**PEDMAS Variant** (European Standard):

- Swaps Multiplication and Division order



**As in the end both returns the same as Multiplication/Division have equal precedence (left-to-right evaluation)**

---

## Complete Operator Precedence Table

| Precedence | Operator Type           | Operators                          | Associativity |
| ---------- | ----------------------- | ---------------------------------- | ------------- |
| 1          | Grouping                | `()`                               | n/a           |
| 2          | Exponentiation          | `**`                               | Right-to-left |
| 3          | Multiplication/Division | `*` `/` `%`                        | Left-to-right |
| 4          | Addition/Subtraction    | `+` `-`                            | Left-to-right |
| 5          | Comparison              | `<` `<=` `>` `>=`                  | Left-to-right |
| 6          | Equality                | `==` `!=` `===` `!==`              | Left-to-right |
| 7          | Logical AND             | `&&`                               | Left-to-right |
| 8          | Logical OR              | `\||`                              | Left-to-Right |
| 9          | Nullish Coalescing      | `??`                               | Left-to-right |
| 10         | Assignment              | `=` `+=` `-=` `*=` `/=` `%=` `**=` | Right-to-left |

---

## Parentheses and Grouping

### Force Evaluation Order

```js
(5 + 5) * 10;     // 100 (parentheses override default precedence)
```



### Complex Example

```js
let result = 5 + (5 * 10) / 6**2 - 1;

/*
Let's breakdown:

1:     5 * 10 = 50 (parentheses tend to be mults)
2:     6**2 = 36 (exponents)
3:     50 / 36 ≈ 1.388 (division)
4:     4. 5 + 1.388 ≈ 6.388 (addition)
5:     6.388 - 1 ≈ 5.388 (subtraction)
```

---

## Multiplication/Division Equality

### Left-to-Right Evaluation

```js
5 / 5 * 4;              // 4 (not 0.25)

8 * 4 / 16;             // 2 (not 0.5)
```


**When operators have equal precedence (like * and /), JavaScript evaluates from left to right.**

---

## Practical Examples

### Financial Calculation

```js
// Calculate total with tax and discount

let total = (subtotal * 1.08) - (subtotal * discountPercent);
```

### Game Scoring

```js
// Composite score calculation

let score = (basePoints + bonusPoints) * multiplier - penalties;
```

### Scientific Formula

```js
// Kinetic energy calculation: ½mv²

let energy = 0.5 * mass * velocity ** 2;
```

---

## Common Pitfalls

1. **Implicit Grouping Assumptions**
   
   ```js
   5 + 3 * 2 ** 2;             // 17 (not 64)
   
   // Evaluates as: 5 + (3 * (2 ** 2))
   ```

2. **Division vs Fraction Conversion**
   
   ```js
   1 / 2 * 3;                    // 1.5 (not 0.166)
   ```

3. **Exponentiation Right-Associativity**
   
   ```js
   2 ** 3 ** 2;                 // 512 (not 64)
   
   // Evaluates as 2 ** (3 ** 2)
   ```

4. ```js
   console.log(5 + "5" * 2);     // 15 (type coercion)
   ```

---

## Debugging Tips

1. **Explicit Grouping**  
   When in doubt, add parentheses to clarify intent

2. **Step-by-Step Evaluation**  
   Break complex expressions into intermediate variables:
   
   ```js
   let step1 = 5 * 10;
   let step2 = 6 ** 2;
   let result = 5 + (step1 / step2) - 1;
   ```

3. **Operator Precedence Reference**  
   Keep MDN's operator precedence table handy

4. **Code Formatting**  
   Use spacing and alignment to visually group operations:
   
   ```js
   let energy = (0.5 * mass) 
                * (velocity ** 2);
   ```
   
   

---

## And ... BODMAS? BIDMAS?

Both are **synomins for** international standard english **PEDMAS** abbreviations.



* **B**rackets - **O**rders - Divisions - Mults. - Adds. - Subs.

* **B**rackets -**I**ndices - Divisions - Mults. - Adds. - Subs.

****

## Resources

- [Operator precedence - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Operator_precedence)

- JavaScript.info: Operators

- ECMAScript Language Specification (Section 12.5)



****

## Video Lesson Speech

This guide walks through how the order of operations work in JavaScript programs, including a discussion on PEDMAS/PEMDAS.

****

In this guide, we are going to go back to some of your earlier math days and we're going to talk about the order of operations. Because the order that javascript is going to interpret your computations is very important and it may or may not be intuitive to you depending on your own math experience. 

I want to go through a basic example of this first and then we'll walk through what that order is. 

If I create a variable here called num and if you notice I'm back in code pen you can do all of this in codepen or you can do it in the javascript console or on a file on your system. It's completely up to you. But I like the way that this is going to output everything so I'm going to store it in a number and then I'm going to print that number out. 

So here I'm going to say five plus five times ten. And if I console log number out what do you think that this will output? Well, if we read this from left to right this would be five plus five which is ten times ten. So it should be a hundred. But is that what we're going to get? hit run. 

```javascript
var num = 5+ 5 * 10; // 55
```

You can see we get 55 and that is because of the order of operations that the javascript and for the most part pretty much every programming language, that I've ever worked with follows. That is, that it does not read it from left to right, instead, it dissects it and it looks to see each one of the operators, and then it puts a priority based on that. 

The way that it works, is first five is multiplied by 10, which would equal 50. Then the 50 added to 5. That's where we get 55. In the comments, I'm going to say this is called PEMDAS and if you are from the UK or in Europe I have also seen this being called PEDMAS.

We'll talk about what the difference is here in a second. For the how we're going to work with it, you will see that it really does matter. Both work perfectly fine. There is also another sentence I learned when I was a kid and it is. Please Excuse My Dear Aunt Sally and if you notice this is an acronym PEMDAS and it's just a mnemonic to be able to memorize that order. What does this represent?

Well, I'm going to use our knowledge of multi-line comments. And let's actually make this all a multi-line comment. 

```javascript
/* Order of Operations
   PEMDAS -> PEDMAS
   Please Excuse My Dear Aunt Sally
*/
```

This is the order of operations. There are both acronyms and a mnemonic. 

Now let's go and actually type it out. The P stands for parens. So parentheses are going to be the very first operator that is going to get touched.

First, it's parenthesis, then it's exponents, followed by multiplication, and then division, and then addition, and then subtraction.

```javascript
/*
Parenthesis
Exponents
Multiplication 5 / 5 * 4
Division
Addition
Subtraction
*/
```

This is where we get the, p e m d a s and that is the order. 

Let's take a larger example instead of num just equaling this, let's actually just wrap some of this up. We're going to say parentheses will say division let's say a six to the power of two. And then let's do subtraction of one. So this is quite a bit of computation right here. 

```javascript
var num = 5 + (5 * 10) / 6**2 - 1;   // 5.38
```

If I run this you can see the answer is 5.38. 

The Answer itself doesn't really matter, it's more of I want to show you exactly what the flow is going to be here. 

Now that we know this order, then you might guess that the very first time that this hits the first thing that's going to get run is this five times 10. So this is going to be at 50. Now we are going to go to the exponents, we're going to have 6 * 6 which is going to be 36 then we're going there is no more multiplication because multiplication was inside of here. So then we're going to go into divisions, we are going to have 50 divided by 36 and then we'll have 5 on then we'll go down the line.

It eventually ends up just equaling five point three. But this is the order that it follows. I definitely recommend for you to be able to learn how that works. Because if you did run into a scenario where you were performing some type of computation but you didn't organize your operators in the right way then you might end up with something that would be considered a logical error. 

We have multiple kinds of errors in programming, we have errors where the system just doesn't run. Where we get an actual error, but we also have logical errors where everything appears to have worked. But the programming logic was not accurate and because of that, the output was not accurate. So it's very important to keep in mind that you are watching not just for errors related to your program running but also ones where it's running but giving the wrong output. 

That is something that you see quite a bit especially with new developers, as they're learning is programs that run but may have some odd behavior because of things like this because of the order of operations. So I definitely recommend for you to explore that a bit. Be able to see how you can change it. Test out what happens when you change up the order when you change things from left to right and then see exactly if you understand that. 

Now the one thing I will say you may wonder why we have two different ways of reading this we have PEMDAS  and we have PEDMAS. I actually learned it with, Please excuse my dear Aunt Sally. Which is the first way and if you grew up in the U.S. then there's a good chance that that is the way you were taught as well. 

However, I have spoken with a number of individuals from European countries and they were taught this way. The reason why both of them are accurate and both of them work perfectly fine, is that when you come to multiplication and division the order does not matter. In this case, it will read it from left to right. 

In other words, if I have something like 5 / 5 * 4. This is going to be read from left to right. Let's actually test it out just to make sure that I'm not going crazy, or teaching you wrong. Now technically if it does go from left to right this should equal 1. Then 1 times 4 should equal 4. So our output should be four. And if we run this you can see it is four. 

```javascript
var num = 5 / 5 * 4;   // 4
```

Even though multiplication in our mnemonic does come before division, that side of it doesn't matter. If you have multiplication afterward it's not going to get run, it's going to be whatever is from left to right. 

I've taught multiple programming courses and this is an interesting topic because I have been told by several people that I've been wrong on both sides.

I had one course where I PEMDAS I had another course where I taught PEDMAS and both times I had people commenting saying I was teaching it improperly. Technically they are both accurate. Once you get to multiplication and division the order does not matter. It just reads it from left to right. 

The more important thing is to understand how to organize things with parentheses, exponents, and then understand that order in general. I hope that you now have a better idea or understanding, that the order of operations in javascript is very important and also how it works in your own programs.

```javascript
/* Order of Operations
   PEMDAS -> PEDMAS
   Please Excuse My Dear Aunt Sally
   Paranthesis
   Exponents
   Multiplication 5 / 5 * 4
   Division
   Addition
   Subtraction
*/

var num = 5 + (5 * 10) / 6**2 - 1;
var num = 5 / 5 * 4;
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_b_18_order_of_operations.js)

****

## Coding Exercise

Following the order of operations, make the below problem equal 76

```js
number = 6  10  7;
```
