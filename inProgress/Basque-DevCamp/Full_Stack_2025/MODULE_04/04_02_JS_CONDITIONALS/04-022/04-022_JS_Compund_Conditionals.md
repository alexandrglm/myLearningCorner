# MODULE 04 - 022: JavaScript

## Conditions (2) - Compounds Conditionals

****

1. Understanding Compound Conditionals
2. Logical Operators Deep Dive
3. Age Verification System
4. Common Patterns & Best Practices
5. Edge Cases & Validation

---

## Understanding Compound Conditionals

Compound conditionals allow you to test multiple conditions in a structured way:

```javascript
if (condition1) {

     // Runs if condition1 is true

} else if (condition2) {

     // Runs if condition1 is false AND condition2 is true

} else {

     // Runs if all above conditions are false

}
```

- Evaluated top-to-bottom

- Only one block executes (the first true condition)

- `else` acts as final catch-all

***

## Logical Operators Deep Dive

### AND Operator (`&&`)

```js
// Both conditions must be true

if (age >= 16 && age < 25) {

     console.log("Eligible for driver's license but not rental");

}
```

### OR Operator (`||`)

```js
// Either condition can be true

if (age < 5 || age > 65) {

     console.log("Eligible for discounts");

}
```

### NOT Operator (`!`)

```js
// Inverts the condition

if (!hasLicense) {

  console.log("Cannot drive");

}
```

---

## Age Verification System

Complete age-based permission system:

```js
var age = 20;

if (age <= 10) {

 // Child permissions

    console.log("Kid menu access");

    console.log("No driving privileges");

} else if (age >= 11 && age <= 15) {

     // Pre-license age

     console.log("No kid menu");

     console.log("Learner's permit eligible");

} else if (age >= 16 && age < 18) {

     // Provisional license

     console.log("Driver's license with restrictions");

} else if (age >= 18 && age < 25) {

     // Full license but rental restrictions

     console.log("Full driving privileges");

     console.log("Car rental with young driver fee");

} else if (age >= 25) {

     // Full privileges

     console.log("All access granted");

} else {

     // Invalid age handling

     console.log("Age verification failed");

}
```

---

## Common Patterns & Best Practices

### 1. Range Checking

```js
// Clear range definition

if (value >= min && value <= max) {
     // In range
}
```

### 2. Input Validation

```js
if (!username || !password) {

    console.log("Missing credentials");

}
```

### 3. Feature Flags

```js
if (user.isAdmin || featureFlags.newDashboard) {

    showAdvancedFeatures();

}
```

### 4. Early Returns

```js
function processOrder(order) {

    if (!order) return "Invalid order";

    if (order.canceled) return "Order canceled";

    // Main processing...

}
```

---

## Edge Cases & Validation

Always account for:

- Invalid data types (`null`, `undefined`)

- Boundary conditions

- Negative numbers

- Non-integer values

```js
var age = "twenty"; // Bad input example

if (typeof age !== 'number' || age < 0) {

    console.log("Invalid age input");

    return;
}
```

---

## Additional Resources

[Compound Conditionals](https://csci.lakeforest.edu/mirza/csci107/examples/L16_JS_Conditionals/5_conditional_statements3.html)

[Making decisions in your code — conditionals - Learn web development | MDN](https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Scripting/Conditionals)

[MDN Logical Operators](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Logical_Operators)

[JavaScript Comparison Table](https://dorey.github.io/JavaScript-Equality-Table/)

###### Out of order, but remarkable:

[Defensive Programming Techniques](https://wiki.c2.com/?DefensiveProgramming)

****

## Video lesson Speech

This guide examines how to implement compound conditionals in a JavaScript program.

****

In the last guide, we walk through how to have if-else statements with our conditionals. This is a very common pattern and you're going to be using if-else blocks just by themselves quite a bit. 

However, javascript also has the ability to set up multiple scenarios. This is called the if-else if type of conditional. What I want to do is to set up a full range of scenarios. So this is going to check to see if, you are old enough to eat from the kids' menu, if you're old enough to drive, and if you're old enough to rent a car. Then set up different types of age ranges. This is where our conditional is actually going to search within a range and then output whether the user or whoever has that age is able to perform those tasks.

Right here we're going to keep this part the same. So if age is less than 10 then you can eat from the kids' menu. 

```javascript
if (age <= 10) {
  console.log("You can eat from the kid's menu");
```

But I'm also going to add a few other ones. This is going to say you are not old enough to drive. And then also you are not old enough to rent a car. So instead of an if-else statement, we're going to get rid of that entirely. I'm going to say else if and put in a range, the way that you can set up a range in javascript. Is I can say age is greater than 10. Then we use AND by putting in double ampersands. Age is less than 25. Then we want this to happen. 

```javascript
if (age <= 10) {
  console.log("You can eat from the kid's menu");
  console.log("You are not old enough to drive");
  console.log("You are not old enough to rent a car");
} else if (age >= 16 && age < 25) {

}
```

So let's review what is going on here. 

The syntax for having another conditional. So not just an else. The else is kind of like something that is always going to run if this is false. Now what we're doing is we're saying in a scenario where the age is less than or is greater than 10 and the age is less than 25. What our program does, is it's going to check the left conditional and then if this is true. It's going to come and check the right conditional. Now if both of them are true everything that happens inside of the curly brackets is going to go on now if it comes across and sees that age is greater than 10 and so that would be true but age is not less than 25. Say, this is for someone who's 40 years old then this is going to be false and the entire thing is going to be false and it's going to go on to the next conditional if there is one. 

That's how a range works. So I'm just going to copy all of the console logs. "You can eat from the kids' menu" is going to change to, "You can not eat from the kids' menu".

The next one, "You are not old enough to drive" is going to be "You are old enough to drive". And then the last one is "You are not old enough to rent a car". This one is still the case. 

We've already done a decent amount of work. Let's see if this is going to work. 

```javascript
var age = 8;

if (age <= 10) {
  console.log("You can eat from the kid's menu");
  console.log("You are not old enough to drive");
  console.log("You are not old enough to rent a car");
} else if (age >= 10 && age < 25) {
  console.log("You can not eat from the kid's menu");
  console.log("You are old enough to drive");
  console.log("You are not old enough to rent a car");
```

If I run this, it says "you can eat from the kids' menu". "You're not old enough to drive". "Not old enough to rent a car". That's because the age is 8 and it hits age is less than or equal to 10. So this all worked. 

Now let's change up this age to be somewhere else. 

Now we're going to say age = 16 and it has to be greater than or equal to 16
`else if (age >= 16 && age < 25)`. It won't work at 10. I don't think we want a lot of 10-year-olds on the road. 

Now if we have a greater than or equal to 16 if we run this, then it says "you cannot eat from the kids' menu". That's good. "You are old enough to drive" and then "you are not old enough to rent a car". Everything there is working perfectly. Now let's change it up one more time before we continue on and we'll say someone who's 30 years old if I run. Nothing happens, that's because the age of 30 is greater than 16 but it is also greater than 25. So it doesn't match both of these conditionals so in order to get this to work there are a couple things we could do. 

One we could put just a regular else so we could put an else here and everything would work. 

```javascript
else {
console.log('something');
}
```

And we'll see if this works when it is 30. 

Now if this runs you can see it prints out "something" and that is fine, in some types of conditions. However, if you want to be more explicit. You want to make sure that what you're looking for is also what you're going to find. Then we would be better to do another if-else. 

The reason why I would want to do that is let's imagine a scenario where age is an even number but it's something else. So say it you know it's a string or some kind of bad piece of data. This console log may actually come and happen or anything inside of here may happen. It would be better if we were explicit, this guarantees that we're not just going to fall into a default. But instead, we're going to check to look for another specific type of condition. 

Now what I can do is say we don't need a second one. We can just say if age is greater than or equal to 25. I want you to do all of this. Here we can say "you cannot eat from the kids' menu", "You are old enough to drive", and "you are old enough to rent a car". If we run this again you can see that it worked. We can also be more confident in how that is being processed. If somebody puts a bad piece of data as our age, it is not going to hit our default.

That is a little bug, that I have seen in a number of programs where the developer didn't think it all the way through and they just had three conditions and they assumed that if 1 and 2 were not met then that last one is fine to just throw it in the else block because everything could fit inside there. 

However, there are plenty of times where I've seen that lead to some very disturbing side effects. Imagine a scenario right here where you were building a program said this. This essentially, a validation little code library. Imagine you put this in a web program and you put this last one just as regular else. And somebody who just happened to not have a name so era an age they went in there and so say it was set to null or something like that and instead of it printing out an error message, instead it told them they could rent a car that would be a really bad thing so make sure whenever you're building these types of conditionals that you're examining all of the possible scenarios and how you want your program to behave. In review, this is the syntax, and essentially the best way to write a multiple type of condition including being explicit even when you think that everything is going to fall inside of a specific condition. 

```javascript
// We recognize that there is a hole is this code logic covering ages 11 -15. As was discussed in the lesson this does happen.
// Try playing with the code and fixing the hole in the logic for practice.
var age = 30;

if (age <= 10) {
  console.log("You can eat from the kid's menu");
  console.log("You are not old enough to drive");
  console.log("You are not old enough to rent a car");
} else if (age >= 16 && age < 25) {
  console.log("You can not eat from the kid's menu");
  console.log("You are old enough to drive");
  console.log("You are not old enough to rent a car");
} else if (age >= 25) {
  console.log("You can not eat from the kid's menu");
  console.log("You are old enough to drive");
  console.log("You are old enough to rent a car");
}
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_c_03_compound_conditionals.js)

****

# Coding Exercise

Create a condition that allows a 15 year old to get a permit, but can't get a license.

```js
function kid() {
    age = GiveYourKidAnAge;

    if (EnterYourConditionsHere) {
        return true;
    }
}
```
