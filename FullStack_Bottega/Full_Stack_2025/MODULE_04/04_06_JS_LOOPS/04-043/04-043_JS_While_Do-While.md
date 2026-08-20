# MODULE 04 - 043: JavaScript

## Loops (3) - While and Do-While

---



Although `for` loops are the most commonly used in JavaScript, there are other types such as `while` and `do...while` that are useful in specific scenarios—especially when the number of iterations is unknown or when you need a block to execute at least once.

****

## 1. `while` Loop

A `while` loop executes **as long as the condition is true**. The condition is checked **before** the code block runs. If the condition is false at the beginning, the loop won’t run at all.

### Syntax:

```js
while (condition) {
  // code to execute
}
```

### Example

```js
var players = [
  'Altuve',
  'Bregman',
  'Correa',
  'Springer'
];

var i = 0;
while (i < players.length) {
  console.log(players[i]);
  i++;
}

```

🧠 The key here is to remember to **manually increment** the iterator, otherwise the loop could run forever (infinite loop).



📚 Reference:

- MDN Web Docs: [while](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/while)

****

## 2. `do...while` Loop

A `do...while` loop guarantees that the code block runs **at least once**, because the condition is evaluated **after** the first execution.

### Syntax:

```js
do {
    // code to execute
} while (condition);

```

### Example:

```js
var players = [
  'Altuve',
  'Bregman',
  'Correa',
  'Springer'
];

var i = 21;
do {
  console.log(players[i]);
  i++;
} while (i < players.length);

```

In this example, the loop prints `undefined` once, because `players[21]` doesn't exist. But the loop still executes at least one time—**regardless of the condition**.

📚 Reference:

- MDN Web Docs: [do...while](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/do...while)

- https://javascript.info/while-for#do-while



****

## 3. Key Differences Between `while` and `do...while`

| Feature            | `while`                      | `do...while`                     |
| ------------------ | ---------------------------- | -------------------------------- |
| Condition check    | Before first execution       | After first execution            |
| Guaranteed to run? | No                           | Yes, at least once               |
| Common use cases   | When loop may not run at all | When loop must run at least once |

---

## 4. Real-World Use Case for `do...while`

A great use case for a `do...while` loop is **game development**. Imagine a game loop that must always render at least once before checking if the player has won or lost. A `do...while` loop is perfect in that scenario.

***

## References

[javascript-programming/section_f_03_while_loops.js at master · rails-camp/javascript-programming · GitHub](https://github.com/rails-camp/javascript-programming/blob/master/section_f_03_while_loops.js)



---

## Video lesson Speech

This lesson examines how you can work with Do and Do/While loops in JavaScript programs.

****

So far we've covered a number of the loop types, everything from "for" all the way through the functional "for each." We also saw how we can iterate over an object.

I want to talk about two more loops. These loops are nowhere near as popular as the "for" variety that we've already discussed. However, it would be a bad job on my part if I didn't tell you about them because there are still times where they can be useful and also if you're working on legacy applications you're more likely to run into these at some point or another because some developers prefer them. 

They're not my personal preference so you won't find them in very many of the applications that I make but they still serve a purpose and I am going to point out one specific scenario later on which this is a perfect fit for a looping mechanism.

First, let's talk about the "while" and then the "do while" loop. First, we need to declare an iterator variable we can call it anything that we want. We also have our array up here. While loops do not have the same type of setup that a for loop has even a traditional for loop where you can put the variable inside of the function expression itself. Now with loops, we have to declare it outside. 

So first and foremost that is a good thing but it also can be about things. It might be an issue where we're having to declare a variable outside of the scope of the loop which means we have access to it even afterward, that may or may not be something that you want. 

So now that we've declared our variable let's create the while loop. 

```javascript
var players = [
  'Altuve',
  'Bregman',
  'Correa',
  'Springer'
];

var i = 0;
while (i < players.length) {
  console.log(players[i]);
  i++;
}
```

So you say while i is less than players.length, this is pretty similar to the conditional that we put in the for loop, I want to console log out players and then grab the index because i's functioning as an index. Now it's very important we do not run this right now and the reason is that this will throw what's called an infinite loop. 

If you've noticed we don't have anything that changes the value of i yet when we had our traditional for loop if you remember the very last item on the list was an incrementor, just like the same way where we had to assign a value to i in this case we have to also manually create our own incrementor. Inside of the While loop. I'm going to say i ++ and now this will work. 

Every time it comes through the loop it's going to increase it's going to come back up here it's going to check to see is i less than the players length which in this case we know is 4. If so it's going to keep going as soon as it's equal to or greater than it's going to stop the execution. 

If I hit run this runs and it works we get all 4 of our players printed out. So that is good. 

That is a traditional while loop, it has a close cousin called the "do while" loop, and the syntax for that is very similar except almost in reverse. 

You take out this entire while portion and you put it at the very end of your expression or out of your block. At the top where while was now, you say do and this is why it's called a do-while loop. 

```javascript
var players = [
  'Altuve',
  'Bregman',
  'Correa',
  'Springer'
];

var i = 21;
do {
  console.log(players[i]);
  i++;
} while (i < players.length)
```

When you have do and then while right here it is going to give you a slightly different set of behavior. It is because with a do loop the condition is checked after the iteration, with a while loop it's checked first. 

That may not seem like a big deal and if I hit clear right here and then run it everything works identically in this scenario and that's perfectly fine. However, let's imagine a scenario where I set i equal to 21. 

If I hit clear and hit run only one thing gets to print out and it's undefined. Now if I would have done that for the while loop nothing would have been printed out and just so you know I'm not lying to you. Let me do it right now. So now if I do the same thing with my while loop and run nothing gets printed out and that is the main difference is that with a while loop it does its conditional check first. With a do-while loop, it is always going to go through the program at least one time. 

You may think that that sounds weird and that you would never have a reason to use a do-while loop, actually, I have through the years found myself needing to use a do-while loop even more than a while loop. Mainly because I never really use a while loop because for loops work much better. However a do-while loop can do something that none of the other loops can do, that is it can perform and guarantee that it will run at least one time. 

Imagine that you're building a game if you're building a game and you always want one process to run at least once you want to have that guarantee then your game can use a do-while loop and in fact, that is one of the most common times that I see do while loops used is in games where you want a process that runs at least once.

Say that you have a player who's playing your game and you want to be guaranteed that the program is going to run at least one time then if they keep on winning then it can check that in the while condition and it can keep on looping through. You always have that one guaranteed one in the beginning. 

That's one of the more common spots where you'll see a do while implemented. In review, we talked about two different types of loops talked about while and do while. We talked about their positives negatives what you have to do from a syntax perspective and then finished off with a practical example on why you'd want to use a do-while loop in a game type of scenario. 

```javascript
var players = [
  'Altuve',
  'Bregman',
  'Correa',
  'Springer'
];

var i = 0;
while (i < players.length) {
  console.log(players[i]);
  i++;
}

var i = 21;
do {
  console.log(players[i]);
  i++;
} while (i < players.length)
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_f_03_while_loops.js)

****

## Coding Exercise

In the below starter code, place 4 dog names (elements) of your choice. Write a while loop that iterates through the `dogHouse` array. The iterator variable must be named "data".

```js

```
