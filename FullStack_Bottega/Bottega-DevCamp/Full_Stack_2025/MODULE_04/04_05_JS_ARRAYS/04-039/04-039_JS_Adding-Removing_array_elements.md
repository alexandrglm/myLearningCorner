# MODULE 04 - 039: JavaScript

## Adding / Removing Array Elements

***

1. Adding Elements with `push()`
2. Removing Elements with `pop()`
3. Adding Elements at the Beginning with `unshift()`
4. Removing Elements from the Beginning with `shift()`
5.  Dynamic Array Updates

    (#conclusion)

***

In this lesson, you'll learn how to dynamically **add** and **remove elements** from JavaScript arrays.

These operations are essential in nearly every JS project, especially when handling data that changes during runtime. JavaScript provides simple, intuitive methods to manipulate arrays: `push()`, `pop()`, `unshift()`, and `shift()`.

***

## Adding Elements with `push()`

The `push()` method allows you to add elements to the **end** of an array.

```js
var todoList = ['Clean the room', 'Brush teeth'];

todoList.push('Go to the gym');
```

After calling `push()`, the `todoList` array becomes:

```js
['Clean the room', 'Brush teeth', 'Go to the gym']
```

You can also chain `push()` calls:

```js
todoList.push('Have breakfast');
```

This method **modifies the original array** and returns the new length of the array.

📌 **Reference**: [Array.prototype.push() - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/push)

***

## Removing Elements with `pop()`

To remove the **last element** from an array, use the `pop()` method:

```js
todoList.pop();
```

This will remove `'Have breakfast'`, leaving:

```js
['Clean the room', 'Brush teeth', 'Go to the gym']
```

The `pop()` method returns the element that was removed.

📌 **Reference**: [Array.prototype.pop() - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/pop)

***

## Adding Elements at the Beginning with `unshift()`

You can also add items to the **beginning** of an array using `unshift()`:

```js
todoList.unshift('Do homework');
```

Resulting in:

```js
['Do homework', 'Clean the room', 'Brush teeth', 'Go to the gym']
```

Like `push()`, this method returns the new length of the array.

📌 **Reference**: [Array.prototype.unshift() - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/unshift)

***

## Removing Elements from the Beginning with `shift()`

To remove the **first element**, use `shift()`:

```js
todoList.shift();
```

This will remove `'Do homework'`, returning the array to:

```js
['Clean the room', 'Brush teeth', 'Go to the gym']
```

Just like `pop()`, the `shift()` method returns the removed item.

📌 **Reference**: [Array.prototype.shift() - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/shift)

***

## Dynamic Array Updates

These array methods are often used together in dynamic programs such as **to-do lists**, where you constantly add new tasks and remove completed ones.

You can chain these operations to reflect real-time updates:

```js
todoList.push('Check emails');
todoList.pop();
todoList.unshift('Make coffee');
todoList.shift();
```

Each method is simple to use but incredibly powerful in practice.

***

## Video Lesson Speech

This guide walks through how to use the push, pop, shift, and unshift\
functions in JavaScript in order to add and remove array elements.

***

So now that you know how to create arrays, let's talk about how we can actually work with them. So I'm going to create a pretty basic array it's going to be the same one I talked about with the baseball players, so you can have Altuve, Bregman, Correa, and Springer.

```javascript
var arr = ['Altuve', 'Bregman', 'Correa', 'Springer'];
```

So now we have our array I can call array length and as you can see we are at four.

```javascript
arr.length; // 4
```

Now to reiterate whenever you see an array it has just like a string a built-in property called Link. Now, this is something that can kind of trip up new developers sometimes and that is that they think the length is a function because in many other languages length is a function. And so you'll see many times where someone tries to do array length and that's going to throw an error because it's not a function it is a property of the array.

That's a reason why when we click down here and we see it we see length is one of the built-in items we also have a lot of other things. This shows all of the various functions that we can call on arrays, this is very helpful and this is some of these are what we're going to go through in this guide. Specifically the ones we're going to hit our push and pop. So these two right here and then we're going to use shift and unshift. So we have shift right here and unshift right here.

I definitely recommend for you to explore each of these methods, we'll get into some of the more especially when we get into our loops and iterations section because some of these that's what they do. Such as "forEach" and "filter" and some of those. et's talk about what pop does, so if I go array.pop and this is a function so I'm going to call it just like this, this is going to return the very last item from the array.

```javascript
arr.pop(); // "Springer"
```

So this is very helpful for a couple of reasons. So now if I do array you can see we now have three items and Springer is no longer there.

```javascript
arr; // (3) ['Altuve', 'Bregman', 'Correa']
```

This is helpful because there are many times where you want to iterate over an array and you want to clean it out. Imagine building a To-Do List application or something and as you are going through you may want to pop them off that's the reference of the name we're popping items off of this array stack right here. The other nice thing is because you notice and this is the reason why we're using the javascript console to see this is when I do array.pop it pops Springer off but he also returns them.

So let's see how we can add something back in then pop them off again. So just like we have pop, we also have a function called push. So say that I wanted to put someone else in, so I wanted to put Bagwell in and add him to the list.

```javascript
arr.push('Bagwell'); // 4
```

You can see this returns 4 which means that our array now has 4 elements and now we have Bagwell here at the end. If I want to store that variable so if I want to call pop, I want to remove that item but I also want to know what I removed and maybe store in a variable then I can do that.

```javascript
var elementPopped = arr.pop(); // undefined

elementPopped; // "Bagwell"
```

Now I have element pop is going to equal what I popped off of that array. So this is something that is very common whenever you're iterating over a collection and you're wanting to remove items off using pop and push are pretty important.

Now I told you we're going to talk about four functions in this guide. So far we've talked about two and the other two shift and unshift are pretty much the contrapositives of push and pop, meaning that push and pop give you the ability to add items or remove items at the end of an array. Shift and unshift do the exact opposite, they allow you to remove items and add items at the front of the array.

So if the array content order is important to you then you can use these other items so say that I want to pull Altuve off the list. I can say

```javascript
arr.shift(); // "Altuve"
```

this is going to return Altuve the same way that when I pop Bagwell and Springer off it stored it in a variable and returned it. Same thing here we were able to pull it off, now if I call

```javascript
arr // (2) ["Bregman", "Correa"]
```

If I want to add an item to the list I can

```javascript
arr.unshift('Kyle'); 3

arr; // ['Kyle', 'Bregman', 'Correa']
```

Now there are three elements and you can see Kyle is now at the beginning. So this is a very helpful way of being able to work with arrays where we can remove items we can add them in and we can put them at the beginning, or the end of the collection.

```javascript
var arr = ['Altuve', 'Bregman', 'Correa', 'Springer'];

arr.pop(); // "Springer"

arr; // ['Altuve', 'Bregman', 'Correa']

arr.push('Bagwell'); // 4

arr; // ['Altuve', 'Bregman', 'Correa', 'Bagwell']

arr.shift(); // ['Bregman', 'Correa', 'Bagwell']

arr.unshift('Kyle'); // 4

arr; // ['Kyle', 'Bregman', 'Correa', 'Bagwell']
```

## Resources

* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_e_02_adding_removing.js)

***

## Coding Exercise

Create an array that has 4 elements and then push in a fifth element to the end of the array that says "Bagels".

```js
let array = //Write your code here
```
