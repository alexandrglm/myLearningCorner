# MODULE 04 - 042: JavaScript

## Loops (2) - Loop through an object

***

* Looping through object keys
* Accessing values with bracket notation
* Difference between dot and bracket syntax

***

## Looping through object keys

Use the `for...in` loop to iterate through all the **keys** of an object.

```js
var student = {
  name: 'Kristine',
  age: 12,
  city: 'Scottsdale'
};

for (var key in student) {
  console.log(key + " => " + student[key]);
}
```

Here:

* `key` is each property name (`"name"`, `"age"`, `"city"`)
* `student[key]` accesses the corresponding value (`"Kristine"`, `12`, `"Scottsdale"`)

***

## Accessing values with bracket notation

You **must** use **bracket notation** (`student[key]`) instead of **dot notation** (`student.key`) when the property name is stored in a variable:

```js
console.log(student[key]);     // ✅ works

console.log(student.key);      // ❌ incorrect — looks for a literal key called "key"
```

Dot notation only works with **static property names**:

```js
console.log(student.name); // ✅
```

Bracket notation is dynamic and necessary when iterating.

***

## Why use `var key`?

Declaring `key` with `var` (or `let`) **limits its scope** to the loop. Omitting it pollutes the global namespace, which is considered bad practice.

```js
for (var key in student) {
  // safe local variable
}
```

***

## REFERENCE

[javascript-programming/section\_f\_02\_looping\_over\_object.js at master · rails-camp/javascript-programming · GitHub](https://github.com/rails-camp/javascript-programming/blob/master/section_f_02_looping_over_object.js)

***

## Video lesson Speech

This lesson examines how you can leverage the for-in loop in order to loop over a JavaScript Object.

***

In the last guide, we talked about how we could use various for loops to be able to iterate over a collection of data. In this guide, we're going to talk about how we can do a similar technique to loop over an object.

This is something that is very common, Imagine an API call that you're making. In other words, you go out to another server say it's a service like Twitter and you pull down tweets. While those tweets are sent in many of the components are sent in an object format where they have a key-value pair kind of structure.

If you want to show that on the page then you're going to have to know how to iterate over those. One of the most common ways is to iterate over an object in javascript is to use the "for in loop" that we already walkthrough.

In order to do that we have an object here, it's a student with name age and city.

To iterate over this and print out each one of the items I'm going to say for and then var key in student. This is something in the last guide, I forgot to put a var in front of key. It still worked but it would be considered a bit of an anti-pattern because essentially I would be polluting the global namespace. Remember that whenever you just declare a variable, in this case, we just assigned it, then it would get put in the global namespace where if I put it and say var key it's going to be local to this block.

```javascript
var student = {
  name: 'Kristine',
  age: 12,
  city: 'Scottsdale'
};

for (var key in student) {
  console.log(key + " => " + student[key]);
}
```

So I'm going to say var key in student. Now inside of this, I want to print out and say key plus and then I'm going to do a little hash rocket sign here. And so an equals. You could have it do this it's completely up to you just so it can say which key is associated with which value.

Inside of this I'll say student and using the bracket notation which you know that's how you can go and grab an object. You can grab a value by the key by calling the object and passing in with brackets whatever the key is. If I pass in the key name it will pull it in. I want to show you this syntax in addition to the dot syntax that we've used up to this point.

Now if I hit run this is going to run and this worked. So I have name points to Kristine age 12 city Scottsdale so all of that is working properly.

Now if I come back here and say student.key

```javascript
var student = {
  name: 'Kristine',
  age: 12,
  city: 'Scottsdale'
};

for (var key in student) {
  console.log(key + " => " + student.key);
}
```

hit run everything still works on the key side but not on the value side and this is a reason why I wanted to show you the second type of syntax because up until this entire time we've only used the key-value pair syntax and then we used the dot syntax.

So what we've done is instead of just being able to call name or age with a dot the key doesn't get rendered quite like that. So our key is going to be processed differently than when it's like a function or an attribute call on here, it's not going to work that same way.

We have to be able to have a secondary syntax for it and that's where we use the brackets. So in this case this is the correct syntax. Many times and I would say the majority of the time you're going to do something like student.name and now work perfectly fine and that's considered the best practice but in certain cases wherein this case key is as much a true key as it is just an iterator variable. Then we need to be a little bit more explicit with it in use this bracket syntax.

So that is how you can loop over a collection that is an object using the for-in loop in javascript.

```javascript
var student = {
  name: 'Kristine',
  age: 12,
  city: 'Scottsdale'
};

for (var key in student) {
  console.log(key + " => " + student[key]);
}
```

## Resources

* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_f_02_looping_over_object.js)

***

## Coding Exercise

Create an object called "user". Assign it a username, email, phone and give\
them values. Console log the data in the same format as the video.

```js
let user = {

};
```
