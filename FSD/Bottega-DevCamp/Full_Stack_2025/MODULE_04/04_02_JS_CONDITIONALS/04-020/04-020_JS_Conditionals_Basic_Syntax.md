# MODULE 04 - 020: JavaScript

## Conditions (1) - Basic Syntax

***

## Video lesson Speech

This guide walks through the syntax for using conditionals in\
JavaScript. Including examining the full set of comparison operators.

***

As I mentioned in the introduction this section is going to be all about conditionals.

Conditionals give us the ability to look at either a couple of values or even multiple ones. Three, four, or five depending on what you need to check against and see how they are related to each other. We can see if they're equal to each other if one is greater than the other.

We can check to see if they are explicitly not equal to each other and then we also in javascript have the ability to check to see if they are of the same type as well. Let's talk about how we can test this and what the syntax is.

Here I'm going to do a pretty basic one and say var age and we'll say 12 years old and then we'll say var ageTwo this one will say is equal to 15.

```javascript
var age = 12;
var ageTwo = 15;
```

Now what the syntax is for checking for seeing if items are equal, we can say if age is equal to age too and then we use curly braces say console.log they are equal.

So now if we run this, this is should run absolutely nothing because they're not equal. Now if I change this to 12 hit-run you can see it prints out that they are equal because the values were changed.

![large](../../../../../../.gitbook/assets/04-020_IMG1.png)

This is the basic syntax. Now in addition to equals, we also have what's called triple equals(===). If I do three equals this is going to check to see (it's called strict equal) is what the name of the operator is, or the comparison operator.

Now if I hit run you can see it prints out once again they are equal. Everything there pretty much makes sense.

Now if I wrap ageTwo up as a string and hit run again nothing prints out. The reason for this is because strict equal checks not just on value but also type. Now if for some reason you didn't care about the type you just cared to see if they were equal in value and you wanted to allow for javascript to do its own typecasting. You can use two equals.

If I hit run you can see that it prints out. They are equal so that's what the difference is between two equals and three equals. Just to give you a little bit of an idea, this is considered a poor practice. It's very rare when you will ever want to use two equals. The reason for that is because you may run into an issue where you do two equals and that's going to allow everything inside of these curly brackets to run and some of those functions that you have inside the curly brackets. They may be expecting ageTwo, to be a number. If you allow this to go in and you allow this to be true then essentially what is going to happen is you're going to end up with a bug because you're going to have ageTwo that is acting kind of like an integer. But at the end of the day, it's still a string, The best practice is usually to have three equals. That is the most standard way of doing it.

```javascript
if (age === ageTwo) {
  console.log('They are equal');
}
```

Let's talk about some of the other ones. We have our triple equals and now let's do something similar. Now we're going to do some of the different operators. And the reason why I'm commenting it out is that you can. You'll be able to have these all in the show notes. So never get checked to see if age is equal or is not equal to ageTwo. Here the syntax for doing that is going to be a bang followed by equals followed by whatever you're trying to compare it to.

```javascript
if (age !== ageTwo) {
  console.log('Not equal');
}
```

consol.log not equal now if we run this should print out not equal. Everything there is working nicely, now just like we have our three equals four having a regular equal versus a strict. There also is another option here that is going to be strict not equals. If I run this you can see right here it's going to print out not equal but it was not equal before.

This has to deal with the same exact type of scenario. This returns true if the operands are the same type but they're not equal or they're of a different type. In other words, if I say this or 12 here and so if I run this again it still prints out that they're not equal because at the end of the day they're of a different type. So everything there is working properly and once again it's considered kind of the best practice to do the bang which is an exclamation mark followed by two equals.

We've covered four of them so far we've covered equals, strict equals not equals, and then strict not equals.

Now we have just a few more to go through. Let's set up an application that checks to see if someone is old enough to rent a car. I'm going to say if age and we'll say is greater than or equal to (which this is the right way of doing it) 25.

This is a way of saying greater than or equal to versus just greater than. Let's say greater than or equal to, old enough to rent a car.

```javascript
if (age >= 25) {
  console.log('Old enough to rent a car');
}
```

Now if I run this nothing prints out and it shouldn't. If I change age to be 25 and run it again it says old enough to rent a car. Notice that 25 is not greater than 25 it's equal to and that's where we have greater than or equal to. Now if I just did greater then and we hit run nothing prints out, that is because the difference is between greater than, and greater than or equal to, is greater than or equal to is actually looking for two conditions. It's checking to see, is this value greater than this other value or is it equal to? That's something that's, almost kind of like we said something like

```javascript
if (age == 25) {
console.log('Old enough to rent a car');
}
```

We ran that conditional it would have printed out the same thing but because we have the ability to do greater than or equal to then it simply works. Now, this does not have a strict version. We only have the ability to do greater than or equal to.

Then we also have the opposite of that. We'll say if age is less than 10 and then in the console log "you can eat from the kid menu".

```javascript
if (age < 10) {
console.log('You can eat from the kid menu');
}
```

Now if we run this nothing happens. But if we go back and change the age to 8 then it says you can eat from the kid menu. Also if you say less than or equal to and we change the age to 10, if I hit run again it now says you can eat from the kid menu because it was not less then but it was equal to.

That's the full list of the comparison operators we have. Starting at the top we have equals and strict equals. We have the other one which is going to be not equal to. And then we have strict equal to. Then we have greater than or equal to. And then we have less than or equal to. Those are going to be what you're going to be placing inside of your conditionals and the left side and the right side these are both called `operands`.

These are the values whether they're variables or just straight hardcoded values that the different comparison operators are going to be comparing.

One final note, notice that it's not required that you use a variable. There are going to be times where you are trying to compare two different dynamic values. In that case, you will be using variables. But there's also going to be times where you do want to hard code something in like we did when we added a number and you're able to do both of those things when using comparison operators in javascript.

```javascript
var age = 10;
var ageTwo = '12';

if (age === ageTwo) {
  console.log('They are equal');
}

if (age !== ageTwo) {
  console.log('Not equal');
}

if (age >= 25) {
  console.log('Old enough to rent a car');
}

if (age <= 10) {
  console.log('You can eat from the kid menu');
}
```

## Resources

* [Comparison operator documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Expressions_and_Operators)
* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_c_01_comparison_operators.js)

***

## Coding Exercise

Create a conditional that returns true, using the starting code below.

```js
answer = false;

if (input your conditions here) {
    answer = true;
}
```
