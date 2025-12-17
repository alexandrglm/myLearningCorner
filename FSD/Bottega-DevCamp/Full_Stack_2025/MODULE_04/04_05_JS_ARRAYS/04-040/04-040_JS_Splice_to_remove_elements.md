# MODULE 04 - 040: JavaScript

## Using splice() to remove Array Elements

***

* Removing items by index
* Dynamically locating items with `indexOf()`
* Understanding `splice()` return values
* Removing multiple elements

***

## Removing items by index

You can remove an item at a specific position using the `splice()` method. The syntax is:

```javascript
array.splice(index, numberOfItemsToRemove);


var arr = ['Altuve', 'Bregman', 'Correa', 'Springer'];

arr.splice(2, 1); // removes 'Correa'
console.log(arr); // ['Altuve', 'Bregman', 'Springer']

```

***

## Dynamically locating items with `indexOf()`

If you don't know the index of the item you want to remove, use `indexOf()` to find it:

```js
var foundElement = arr.indexOf('Correa'); // returns 2

arr.splice(foundElement, 1);

console.log(arr); // ['Altuve', 'Bregman', 'Springer']
```

This pattern is useful for dynamic data, such as lists coming from a database.

***

## Understanding `splice()` return values

The `splice()` method returns a **new array** containing the removed items — even if only one item is removed:

```js
var removed = arr.splice(2, 1);

console.log(removed); // ['Correa']

console.log(typeof removed); // object (it's an array)
```

f you expect a string or number and use the returned value directly, you might get unexpected behavior unless you extract the item like so:

```js
var name = removed[0]; // 'Correa'
```

***

## Removing multiple elements

You can also remove more than one item at once:

```js
var arr = ['Altuve', 'Bregman', 'Correa', 'Springer'];

arr.splice(1, 2); // removes 'Bregman' and 'Correa'

console.log(arr); // ['Altuve', 'Springer']
```

Or use both techniques together:

```js
var arr = ['Altuve', 'Bregman', 'Correa', 'Springer'];

var found = arr.indexOf('Correa');

arr.splice(found, 1); // remove 'Correa'

arr.splice(1, 2);     // remove 'Bregman', 'Springer'

console.log(arr);     // ['Altuve']
```

***

### **Reference**:

[Source Code on GitHub](https://github.com/rails-camp/javascript-programming/blob/master/section_e_03_splice.js)

***

## Video Lesson Speech

This guide teaches you how to implement the splice function in\
JavaScript in order to remove items at specific locations in an array.

***

So far we've covered how to create arrays and then also how to add in remove from the front or the back of the arrays. But we haven't talked about how we can actually remove items from the middle of them which is something that you have after do on a relatively regular basis.

```javascript
var arr = ['Altuve', 'Bregman', 'Correa', 'Springer'];
```

I'm going to paste in the array right here, It's one we've been working with our array of baseball player names. And here I want to pull out and then remove Correa. So right here. Remember indexes start at zero. So we have an index of 0 1 2 and 3. The way that we can do this is by using what is called the splice function.

I could do something like this where I say array splice and then it takes two arguments. The first is the index and the next argument is how many items we want to remove. So in that case I would say two and then one if I just wanted to remove Correa. Then we'd be left with an array of three items.

```javascript
arr.splice(2, 1);
```

However, that may not seem like the most intuitive thing because in most cases you don't know the exact index so you have to find it. So you don't know that Correa is 2, imagine this is coming in from a database query and this has to be dynamic. You can't hard code 2 in but you can search for one of those elements and that's what we're going to start off with.

So I'm going to say var foundElement and then this is going to be set equal to arr and then I'm going to use a function called indexOf. So what indexOf does is it allows you to search by value. So I can pass in Correa right here and this is going to do is it's going to return the index that it finds Correa at.

```javascript
var foundElement = arr.indexOf('Correa');

foundElement; // 2
```

So if I hit return now my found element is equal to 2 because that is the index Correa is out. So now what I can do is say arr.splice and then just put foundElement and then if I only want to remove Correa I can just do 1.

```javascript
arr.splice(foundElement, 1); // ["Correa"]
```

So if I hit return now it pulls Correa out and you can see that it pulls it out. This is a kind of important note splice always returns an array. So even though we only called for one item we and we only got one item it got returned to us as an array. Technically it returned an array of length 1 and that means that we have to be careful.

Imagine a scenario where I wanted to do arr.splice and I pass in the index and then I pass 1 in and then I want to do something like calling a function on that. I expect it to be a string but it's not, it returns an array. I'd have to do something like that and then I'd have to call with the bracket syntax zero to grab that element. Just a little caveat that can be tricky, I've run into scenarios where I thought I was getting a string but ended up getting an array of one element, and then it wouldn't accept the functions I was sending to it. Until I found out that OK I am not working with a string I am working with an array.

So this is just a little thing that I have experienced in real-world applications. So that is how we can run those in now we can also do other things so say I have an array and say I want to take out the remaining items. I can do arr.splice and this is going to start at index 1 and I want to take out 2 items.

```javascript
arr; // ["Altuve", "Bregman", "Springer"]

arr.splice(1, 2); // ["Bregman", "Springer"]

arr; // ["Altuve"]
```

This is going to return an array of 2 and now if I call arr again it only contains Altuve.

So we now have removed each of the items except the very first 1 but instead of using functions like pop or shift to remove those items, we were able to select items much more specifically based on their value like we did right here and also their index. Lastly, we have the ability to not just pull one item off but to pull off as many items as we want.

```javascript
var arr = ['Altuve', 'Bregman', 'Correa', 'Springer'];

var foundElement = arr.indexOf('Correa');

foundElement; // 2

arr.splice(foundElement, 1); // ["Correa"]

arr; // ["Altuve", "Bregman", "Springer"]

arr.splice(1, 2); // ["Bregman", "Springer"]

arr; // ["Altuve"]
```

## Resources

* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_e_03_splice.js)

***

## Coding Exercise

Use the method splice on the array to leave the first 3 values in the array, and have the splice return "Springer".

```js
```
