# MODULE 04 - 041: JavaScript

## Loops (1) - Intro

****



- Traditional `for` loop
- `for...in` loop
- `forEach()` method
- Looping and index logic

---

## Traditional `for` loop

The `for` loop gives you full control over iteration by letting you define:

1. A start value (`var i = 0`)
2. A condition (`i < array.length`)
3. An increment (`i++`)

```js
var players = ['Altuve', 'Bregman', 'Correa', 'Springer'];

for (var i = 0; i < players.length; i++) {
  console.log(players[i]);
}
```

### Why `i < array.length` instead of `<=`?

Arrays are **zero-indexed**, so the last element is at index `array.length - 1`. Using `<` prevents trying to access an undefined index.

This ... :

```js
i < players.length

```

...is equivalent to:

```js
i <= players.length - 1
```

****

## `for...in` loop

This loop simplifies syntax when iterating over **indexes** of an array:

```js
var players = ['Altuve', 'Bregman', 'Correa', 'Springer'];

for (player in players) {
    
    console.log(players[player]);

}
```

****

## `forEach()` method

`forEach()` is a **functional approach** to iterating over arrays. It automatically handles the iteration and gives you access to each item directly:

```js
players.forEach(function(element) {
    
    console.log(element);

});
```

This method is concise, readable (and fits well with modern JavaScript frameworks like React).

****

## Looping and index logic

Important considerations when looping:

- `array.length` gives the count of items, not the highest index.

- Always use `<` in your loop conditions unless you need inclusive behavior.

- `forEach` and `for...in` handle boundaries internally and safely.

****

## **Reference**:

[Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_f_01_for_loops.js)



****

## Video lesson Speech

This lesson walks through the three types of For loops provided by 
JavaScript: traditional for loops, the for in loop, and the functional 
forEach loop.

****

One of the most common ways to use loops in javascript development is when you are looping through collections of data. That's where our first example is going to take us. I created a player's array right here and it's just an array of strings. 

```javascript
var players = [
  'Altuve',
  'Bregman',
  'Correa',
  'Springer'
];
```

We're going to loop over it and I'm going to show you two different ways that you can do this. We're going to use two different types of what are called "for loops." 

The syntax is going to be for and then inside of this, we have to put an entire expression. We have to declare three things, first, we have to declare a variable that is going to be used throughout the loop, then we have to declare a condition which means we want you to keep looping until this condition is not met and then the last one is some type of incrementor.

If you've never heard of any of those terms at all don't worry we're going to go through this and we'll go through this one pretty slowly. First thing like I said we need to declare and assign a variable. I'm going to say var i = 0. 

```javascript
for (var i = 0; )
```

The next thing we're going to do is we have to declare a conditional. Now what this condition is going to do is as it's looping with each iteration it's going to check to see if this condition is true. if it's true it's going to keep going, as soon as the condition is false, then it's going to exit out of the loop. So I'm going to now say i is less than players.length. 

```javascript
for (var i = 0; i < players.length;
```

So what I'm saying here is we have our players array you know that we can call .length on this to give us the full list of items so here it's going players length is going to be 4. So what we're saying is I want you to loop through this entire array until I which starts at 0 is greater than or equal to players length. So as long as i is less than players length then it is going to keep going. 

So how in the world does i change? Well, that is the last part of the expression here. So now I'm going to say i ++, remember our ++ incrementor this is where it comes in very handy. With each iteration with each time we go through the loop, I start to zero but then the next time it goes through the loop it is going to change to 1. Then it's going to check to see has this changed, is this still true? If so, we're going to keep going as soon as in this case as soon as it gets to the spot where i is equal to or greater and then players length which is in this case 4, it's going to exit out. 

One little caveat if you've never worked with loops before this may seem kind of confusing because we know players length is going to be 4 but we're saying that i is less than players length then that's what we're looking for. Why wouldn't it be less than or equal to? we're going to get into an example on why that is. 

The next thing you do is you put in curly brackets and we'll say console log players and remember how we can grab the element is by being index and in this case, i, because it's starting at 0, represents the index. 

```javascript
for (var i = 0; i < players.length; i++) {
  console.log(players[i]);
}
```

If I hit run this is going to run through and it worked we have Altuve, Bregman, Correa, and Springer. 

So how exactly is this working because a logical thought might be that players length because it's 4 and we have 4 items in here that we would want this to be less than or equal to. Well if I hit clear and run this again you'll see that it worked. We have Altuve all the way through Springer but the last one it returns undefined. The reason for that is because remember our indexes start at zero. 

So whatever your length is in your array it's always going to be one greater than the last index value. So this starts at 0 that is assigned when it's going through and it's hitting Altuve. When it comes back up, remember it gets changed and it's going to get incremented to 1 that represents the index for Bregman. Then it goes through again, it's going to be 2 which is Correa then Springer is going to be 3. So in the case where this is put together properly, it is still going to go through. 

That is our last item, as soon as it comes back up and it gets changed to 4 it checks and says OK is i, in this case, is 4 less than the player's length. No, it's not. OK. Exit the loop we're done and there's nothing else that's going to happen. So that's exactly what's happening. That's what we want, this is something I'm harping on this a little bit because it's very important. As you look through other people's code you're going to see so many times where they call something like array length minus 1. 

And if you haven't seen this and you don't understand why that's necessary you're going to wonder why they have i minus 1 all over the place. Technically you could do something like this, you could say this would work if I said i was less than or equal to the players length minus 1. If I run this and now it all works properly so we could either say i is less than or equal to the player's length minus 1 or the way that I usually do it is I just say that i is less than the players length. This is to me it's a little bit easier to read. 

So this is the first way of doing it and it's OK. For loops can be very handy, they've been in computer science for decades and decades. However, I personally whenever I'm using this type of programming construct where I'm looping over a collection I like to use a little bit more modern kind of for loop, and that is called the for-in loop. 

So I'm going to get rid of this I'll keep it in the show notes so you can access it there. 

```javascript
var players = [
  'Altuve',
  'Bregman',
  'Correa',
  'Springer'
];
```

And so how for in loops work is you say for then you declare an iterator variable. The common convention is to use whatever your array has a plural name like players the common convention is to make your iterator variable to be singular. So here I'm going to say for player in player's come down here and say console log players and then player. 

Now one important thing to note here, player doesn't actually represent the value. Player represents the index. We can see that here if we want. So here let me do another console log. Just so he can see exactly what is what player represents so clear. 

```javascript
for (player in players) {
console.log(player);
console.log(players[player]);
}
```

If I run this you can see we have Altuve and zero. Now we have 1 followed by Bregman. So what this is doing. It's very similar to our original for loop that we put together. The only difference is we don't have to put in our own conditions. We also don't have to have an incrementor, the reason for that is because for-in automatically does that work for you because it can see that we are only going to loop as many times over as many elements that are contained inside of the collection. 

This is something that is definitely a little bit more modern. You will see this in quite a few of the applications in the frameworks that are out there now for loops are still very handy to work with especially if you're working with non-collection data. 

There are many times where I will have to work with something that is not an easy array like this instead it's something a little bit more abstract or more dynamic and I have to control the parameters to be a little bit more strict. Whereas here what this does is it relies on the understanding that we only care about iterating over a collection as many times and for as many elements as are in the collection. 

This is something I would do if I were to be iterating over say a database query. That's something that's a little bit more common. And I'm also going to walk through another example and it's going to be our last one for this guide.

For has another option which is called the For Each loop. So we have our FOR loop. Now let's talk about our For Each loop.

I call this players so say players and forEach. Inside of this, we have a number of items that we put inside of it. This gets more into how we can pass functions around. 

```javascript
players.forEach(function(element) {
console.log(element);
});
```

So after we've called for each on players we're going to pass in a function. So here is a function and it takes an argument but we're technically not going to be passing an argument in because all of this happens automatically and I'll show you what that means here in a second. So now I can say console log and then the element and then let's close this off and hit clear. 

If I hit run now you can see this does exactly the same thing. So for each is something that is relatively new to javascript for years we just had for and then for in came into play. And both of those were fantastic for in worked very nicely with collections but now probably one the most modern things you will see is a For Each loop.

If you notice this takes a very similar pattern to the rest of the code that we've been writing. This looks much more functional. This is a function being called on a collection. This fits a little bit more with a modern javascript programming paradigm. And so you're going to see this a lot. This is one of the ones I use quite a bit now just because I really like the syntax it's in very nice but also because it is truly functional. it gives me the ability to place this inside of say an object or placing this inside of another function I want to be able to iterate through. 

As you get into working with a framework such as angular or react you're going to see this type of design pattern quite a bit. 

So in review, we just covered three different types of for loops we covered a traditional for loop. We covered a for-in loop and lastly, we covered the more functional version of it which is the For Each loop. 

```javascript
var players = [
  'Altuve',
  'Bregman',
  'Correa',
  'Springer'
];

for (player in players) {
  console.log(players[player]);
}

for (var i = 0; i < players.length; i++) {
  console.log(players[i]);
}

players.forEach(function(element) {
  console.log(element);
});
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_f_01_for_loops.js)

****

## Coding Exercise

Create an array called "members" with 5 elements. Write a traditional for loop
 that uses an iterator and iterates through the array and console logs 
each member

```js
//
```
