# 04-023\_JS\_Swithc\_Statement

## # MODULE 04 - 023: JavaScript

### Conditions (3) - Switch Statement

***

* Switch Statement Fundamentals
* Syntax Breakdown
* Practical Use Cases
* Comparison with If-Else

***

### Switch Statement Fundamentals

The switch statement evaluates an expression and executes code blocks based on matching cases:

```js
var fruit = 'apple';

switch(fruit) {

    case 'orange':
        console.log('Oranges are $0.59 a pound');
        break;

    case 'apple':
        console.log('Apples are $0.32 a pound');
        break;    

    default:
        console.log('Sorry, we are out of ' + fruit);
}
```

* Strict equality comparison (===)
* Case-sensitive matching
* Requires `break` statements to prevent fall-through
* Optional `default` case for no matches

***

### Syntax Breakdown

#### Basic Structure

```js
switch(expression) {

    case value1:

        // Code to execute

        break;

    case value2:

        // Different code

        break;

    default:

        // Default case
}
```

***

#### Type Checking Example

```js
var dataPoint = true;

switch(typeof dataPoint) {

    case 'string':
        console.log('String type');
        break;

    case 'number':
        console.log('Number type');
        break;

    case 'boolean':
        console.log('Boolean type');
        break;

    default:
        console.log('Other type');
}
```

***

### Practical Use Cases

#### 1. Menu Systems

```js
var menuOption = 2;

switch(menuOption) {
 case 1:
 openSettings();
 break;
 case 2:
 saveDocument();
 break;
 case 3:
 printDocument();
 break;
}
```

#### 2. State Machines

```js
var gameState = 'loading';

switch(gameState) {
 case 'loading':
 showLoadingScreen();
 break;
 case 'playing':
 startGame();
 break;
 case 'paused':
 showPauseMenu();
 break;
}
```

#### 3. Simple Routing

```js
var route = '/about';

switch(route) {
 case '/':
 renderHome();
 break;
 case '/about':
 renderAbout();
 break;
 case '/contact':
 renderContact();
 break;
}
```

***

### Comparison with If-Else

#### When to Use Switch:

* Testing single variable against multiple values
* More than 3-4 conditions
* Need for cleaner, more readable code

#### When to Use If-Else:

* Complex conditions with logical operators
* Range-based conditions
* Testing different variables

***

### Common Pitfalls

#### 1. Missing Break Statements

```js
var num = 1;

switch(num) {
 case 1:
 console.log('One'); // Falls through
 case 2:
 console.log('Two'); // Also executes
 break;
}
```

#### 2. Case Sensitivity

```js
var color = 'Red';

switch(color) {
 case 'red': // Won't match 'Red'
 console.log('Lowercase red');
 break;
}
```

#### 3. Incorrect Comparisons

```js
var score = 90;

switch(true) { // Alternative pattern
 case score >= 90:
 grade = 'A';
 break;
 case score >= 80:
 grade = 'B';
 break;
}
```

***

### Best Practices

1. Always include `break` unless intentional fall-through
2. Put `default` case last (even if empty)
3. Group related cases together
4. Keep case blocks short (extract to functions if needed)
5. Comment intentional fall-throughs

```js
switch(day) {
 case 1:
 case 2:
 case 3:
 case 4:
 case 5:
 console.log('Weekday');
 break; // Intentional fall-through
 case 6:
 case 7:
 console.log('Weekend');
 break;
 default:
 console.log('Invalid day');
}
```

***

### Resources

[switch - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/switch)

[JavaScript Design Patterns – Explained with Examples](https://www.freecodecamp.org/news/javascript-design-patterns-explained/)

https://medium.com/@raygunio/best-practices-for-writing-clean-maintainable-javascript-cca3d4174f5a

***

### Video lesson Speech

In this guide you'll learn how to work with JavaScript switch\
statements. The example we'll walk through will examine how to check for\
the data type of a variable

***

Now that we've covered multiple ways that we can implement conditionals in javascript. I want to give you an alternative approach we focused on building if, and if-else, and then if else if type of conditionals. But now there is another one that is good to have an understanding of. It's not quite as popular as if-else you're going to see that probably the most in the wild but this still is something that's good to know and there are scenarios where it works quite well.

It's called a case statement. A case statement gives you the ability to build your own scenarios. Now, this doesn't work quite as well as if-else in say for the program that we built with that age scenario type tool usually you'll see Case statements when there is just a single set of scenario options and it's checking just to see if something is equal or not and if that seems a little bit obscure, don't worry I think it'll make a little bit more sense when we're actually building it out.

So first I'm going to create a variable called datapoint and we'll set the sequel to 'Hi there' just a regular string.

```javascript
var dataPoint = 'Hi there';
```

What our program is going to do, is it's going to take in the data point and no matter what's inside it's going to output what data type that specific piece of value was what that variable was. So the syntax for this is to say switch and then put inside whatever type of value you want. In my case, I want to do type of data point. Remember what type of does? It checks to see what type of value your data is. So if I open up the console and I say `typeof 'Hi there';` this is going to say it is a string.

That's all we're doing. We want to see whatever the data type is, that we're going to be using. So that is going to return String number it's going to return whatever the data type is. Then we're going to follow that with curly brackets and inside of here, we're going to call our scenarios. We're going to create them.

The first one is a case and then string followed by a colon and then anything inside of this is what we want to happen if the typeof returns, in this case, a string. So here just go to a console log and say it is a string. And we're excited about it. So we put an exclamation mark. So the next thing you have to do is call a break. What this is going to do is it's going to say that we found our case. We have our scenario, now break and skip all of the other scenarios. So if you don't put break in there you're going to run into some weird bugs.

```javascript
switch (typeof dataPoint) {
  case "string":
    console.log("It's a string");
    break;
```

Next, we want to set up another case. Here we're going to say case for number and give a colon and now everything inside of it is going to be pretty much the same except just the output. So I'm going to put this inside of it. But instead of saying it's a string we're going to say it's a number. Now copy all of that for the next one.

Make sure you have your indentation proper It should all be lined up just like I have it. And for this one I say boolean and this will say it's either true or false because those are the only options that it can have.

```javascript
 case "boolean":
    console.log("It's a boolean");
    break;
```

And that is going to be it for this moment. I'm going to show you how to do something else later.

This is everything that we'll need to get this working. Right here we have data point 'Hi there'. So this should match the string. If we did everything right. So if I hit run it matches so it says it's a string. So everything there is working properly. If I change our datapoint and change it to say 5 and hit run. Now it's going to say that it's a number.

Now there are other times where we might want to have a default. The usual case for that is not to use it as a catchall. Remember when we went through our nested and our compound if-else. Remember I said you don't want to use an else to just catch everything that wasn't caught above. case statements are the exact same thing. Say that you had five different data types you're checking for. You don't want to put the fifth one as the default. You want to declare it the same way we did with our case, but now if you want something that says, say an error message you can create what's called a default. The default doesn't know what it's going to get, because of that it's going to not require a scenario.

Then we're just going to console log no matches.

```javascript
default:
    console.log('No matches');
```

This one also does not require a break, remember a break is telling the program to end it and the switch statement with the default, is only going to come here if none of the other cases were met. So it doesn't need that default. Let's run it, everything still works exactly the same. If I come up and instead of 5 pass in an object hit run it's going to say no matches. Because an object is not a string a number or a boolean. So that is how you can leverage switch statements in Javascript in order to build your own conditionals.

```javascript
var dataPoint = {};

switch (typeof dataPoint) {
  case "string":
    console.log("It's a string");
    break;
  case "number":
    console.log("It's a number");
    break;
  case "boolean":
    console.log("It's a boolean");
    break;
  default:
    console.log('No matches');
}
```

### Resources

* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_c_04_case_statement.js)

***

## Coding Exercise

Write a switch statement that always returns: _"number"_

```js
function switchStatement() {

    //Write your switch statement within this function

}

switchStatement();
```
