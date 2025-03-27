# MODULE 04 - 021: JavaScript

## Conditions (1) - IF / ELSE

---

1. **Core Comparison Operators**

2. **Conditional Structures**

3. **Truthy/Falsy Deep Dive**

4. **Practical Patterns**

5. **Performance Considerations**

6. **Common Anti-Patterns***

---

## Core Comparison Operators

### Strict vs Loose Equality

```js
// Strict equality (===) - Preferred

5 === 5 // true
5 === '5' // false (different types)

// Loose equality (==) - Avoid
5 == 5 // true
5 == '5' // true (type coercion)
```

**Key Insight**: JavaScript performs type coercion with `==`, which can lead to unexpected behavior:

```js
'' == '0' // false

0 == '' // true

false == 'false' // false
```

### Relational Operators

```js
// Numeric comparisons

10 > 5 // true
10 >= 10 // true

// String comparisons (lexicographical)

'a' < 'b' // true
'apple' > 'banana' // false
```

---

## Conditional Structures

### If/Else Statements

```js
if (temperature > 30) {
    console.log('Heat wave!');
} else if (temperature > 20) {
    console.log('Pleasant weather');
} else {
    console.log('Bring a jacket');
}
```

****

### Ternary Operator / Elvis

```js
const message = age >= 18 

? 'Access granted' 
: 'Access denied';
```

****

### Switch Statements

```js
switch(dayOfWeek) {

    case 1: 
        console.log('Monday');
        break;

    case 2:
        console.log('Tuesday');
        break;

    default:
         console.log('Weekend');
}
```

---

## Truthy/Falsy Deep Dive

### Complete Falsy List

```js
false, 0, -0, 0n, "", null, undefined, NaN
```

### Surprising Truthy Values

```js
'0', 'false', [], {}, function(){}
```

### Nullish Coalescing (??)

```js
const value = input ?? 'default';
// Only replaces null/undefined
```

---

## Practical Patterns

### Guard Clauses

```js
function processOrder(order) {
 if (!order) return null;
 if (!order.isValid) return null;
```

// Main logic here

```
}
```

### Optional Chaining

```js
const street = user?.address?.street;
```

### Logical Assignment

```js
let config = {};
config.theme ??= 'dark'; // Only assigns if nullish
```

---

## Performance Considerations

1. **Order of Conditions**: Place most likely conditions first

2. **Lookup Tables** vs switch statements

3. **Memoization** for expensive conditions

```js
// Lookup table example

const responses = {
    success: () => console.log('Success'),
     error: () => console.log('Error')
};

responses[status]?.();
```

---

## Common Anti-Patterns

### 1. Assignment in Condition

```js
if (user = findUser()) {}         // Accidental assignment
```

### 2. Deep Nesting

```js
// Bad
if (user) {
 if (user.profile) {
 // ...
 }
}

// Good

if (!user || !user.profile) return;
```

### 3. Implicit Type Coercion

```js
if (document.getElementById('myElement')) {
     
    // Element exists

}
```

---

## Real-World Applications

### Form Validation

```js
function validateForm(data) {

    if (!data.email.includes('@')) {
        return 'Invalid email';
     }

    if (data.password.length < 8) {
         return 'Password too short';
     }

    return null; // No errors
}
```

### Feature Toggles

```js
if (featureFlags.enableNewDashboard) {

    renderNewDashboard();

} else {

    renderLegacyDashboard();
}
```

### Permission Checks

```js
const canEdit = user.role === 'admin' 
|| (user.role === 'editor' && post.author === user.id);
```

---

## Resources

[if...else - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/if...else)

[MDN Comparison Operators](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Expressions_and_Operators#Comparison_operators)

[JavaScript Equality Table](https://dorey.github.io/JavaScript-Equality-Table/)

[ECMAScript Specification](https://tc39.es/ecma262/#sec-testing-and-comparison-operations)

****

## Video Lesson Speech

This guide shows how to implement if/else conditionals in JavaScript in order to give programs dynamic behavior.

***

Now that you have a basic idea on the syntax for using `conditionals` and also a good idea on the full list of the `comparison operators`. 

Let's talk about how we can give our programs more of a dynamic type of behavior. So far we've just talked about implementing `if statements` an if statement isn't too handy without also having the ability to give another option. The ability to have an if or an else, I love the way that they're described because you can read it almost like plain language. Where you can say if such and such is true. If this condition is met I want you to run everything inside of this section. Else, if not then I want you to show everything or run everything in this other section. 

Let's go through an example. I'm going to say var age is equal to 30. Now if I say age is less than or equal to 10 then we'll console log. "You can eat from the kids' menu". 

```javascript
var age = 30;

if (age <= 10) {
  console.log('You can eat from the kid menu');
} 
```

Right now if we run this, nothing is going to happen because this is not going to look in this condition and find a true statement. Remember the way that conditionals work is they check to see if a certain kind of condition is true or not. In this case, the condition is age being less than or equal to 10. 

What javascript does, is it comes in here and it looks inside of these parentheses and it says, that is not true so I'm going to ignore everything inside of here. Everything from the curly bracket down I'm going to ignore and that's fine, in certain situations. There are many times where I use just an if statement just by itself. 

However, in this situation and in many other situations you want to have some other kind of condition you want to have, this is what I want you to do if the conditional is true but I may want you to do something else if it's false. Here what we can say is just `Else` right after the curly brackets and then here we'll console log just copy up and instead of saying "you can eat from the kids' menu" say "adult menu time for you". 

```javascript
if (age <= 10) {
  console.log('You can eat from the kid menu');
} else {
  console.log('Adult menu time for you');
}
```

Now if I run this is going to go through and it's going to skip over the first condition right here, it's going to skip over everything inside the curly brackets, because this is not true. So because that's not true. It skips down to the else and then it's going to run everything inside of the last brackets. Now if I change the age to be 8, then hit run again. 

Now you can see it says "You can eat from the kids' menu". 

So that is how you can implement a basic `IF ELSE` condition inside of javascript. 

In the next guide, we're going to go through how we can add more complexity here and how we can set up a full set of scenarios for our conditions.

```javascript
var age = 30;

if (age <= 10) {
  console.log('You can eat from the kid menu');
} else {
  console.log('Adult menu time for you');
}
```

## Resources

- [Source Code](https://github.com/rails-camp/javascript-programming/blob/master/section_c_02_if_else_conditionals.js)

****

# Coding Exercise

Write a condition that returns `true` if you have more than 50 watermelons.

```js

```
