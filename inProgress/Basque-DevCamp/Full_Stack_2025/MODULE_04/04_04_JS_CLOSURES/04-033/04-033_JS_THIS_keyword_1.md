## MODULE 04 - 033: JavaScript

## The `this` Keyword - Part 1: Fundamentals and Context

---

1. Understanding `this` Binding  
2. Global Context  
3. Function Context  
4. Event Handler Context 

****

The **`this`** keyword in JavaScript is a special identifier that **refers to the execution context of a function**.  

 Its value is determined by how a function is called, not where it's defined.   

Understanding `this` is crucial for:

- Object-oriented programming in JavaScript  
- Event handling  
- Working with classes and prototypes  
- Managing function context  

****

## 1. Core Concepts of `this`

### Dynamic Binding

Unlike other languages, `this` in JavaScript is dynamically bound based on invocation:

```js
function showContext() {
    console.log(this);
}

// Different contexts:

showContext(); // Window (global)

obj.method = showContext;
obj.method(); // obj

button.addEventListener('click', showContext); // button element
```

### Binding Rules

`this` is determined by:

1. **Default binding**: Global/window object (or undefined in strict mode)  
2. **Implicit binding**: Containing object  
3. **Explicit binding**: Using call/apply/bind  
4. **New binding**: Constructor calls  

****

## 2. Global Context

When used outside any function or object:

```js
console.log(this); // Window (browser) or global (Node.js)
```

**Strict Mode Behavior:**

```js
'use strict';
 function test() {
 console.log(this); // undefined
 }
```

**Key Points:**

- In modules and strict mode, global `this` is undefined  
- Avoid polluting global `this` with variables  

****

## 3. Function Context

### Regular Functions

`this` refers to the caller:

```js
function regularFunction() {
    console.log(this);
}

regularFunction(); // Window/global

obj.method = regularFunction;
obj.method(); // obj
```

### Arrow Functions

Lexically bound - inherit `this` from surrounding scope:

```js
const arrowFunction = () => {

    console.log(this); // Uses surrounding context

};
```

**Comparision:**

| Feature        | Regular Function | Arrow Function |
| -------------- | ---------------- | -------------- |
| `this` binding | Dynamic          | Lexical        |
| Arguments      | Has `arguments`  | No `arguments` |
| Constructor    | Can be used      | Cannot be used |

****

## 4. Event Handler Context

When used in DOM event handlers, `this` refers to the element:

```js
button.addEventListener('click', function() {

    console.log(this); // button element

});
```

**jQuery Example:**

```js
$('.btn').click(function() {

    console.log($(this)); // jQuery wrapped element

});
```

**Important Note:**  
Arrow functions in event handlers lose element binding:

```js
button.addEventListener('click', () => {

    console.log(this); // Window/global (usually not what you want)

});
```

****

## 5. Common Pitfalls and Solutions

### Lost Context

Problem:

```js
const obj = {

    value: 42,

    getValue: function() {

        return this.value;
    }
};

const fn = obj.getValue;

fn(); // undefined
```

Solutions:

1. **Bind**: `const boundFn = obj.getValue.bind(obj);`  
2. **Arrow**: Store as arrow function initially  
3. **Wrapper**: `() => obj.getValue()`

### Nested Functions

Problem:

```js
const obj = {

    items: [1, 2, 3],
    process: function() {

        this.items.forEach(function(item) {

            console.log(this); // Window!

        });
    }
};
```

Solutions:

1. **Store `this`**: 
   
   ```javascript
   process: function() {
   
       const self = this;
       this.items.forEach(function(item) {
   
           console.log(self); // obj
       });
   }
   ```

2. **Arrow function**:
   
   ```javascript
   process: function() {
   
       this.items.forEach(item => {
   
           console.log(this); // obj
       });
   }
   ```

****

## More Code Examples

Basic context demonstration:

```js
const person = {

    name: 'Alexandr',
    greet: function() {

        return `Hello, ${this.name}!`;

    }

};

person.greet(); // "Hello, Alexandr!"
```

Event handler context:

```js
document.querySelector('button').addEventListener('click', function() {

    this.classList.add('active'); // 'this' is the button

});
```

Class context:

```js
class User {

    constructor(name) {

        this.name = name;
    }

    sayHi() {

        return `Hi ${this.name}`;
    }

}
```

## Resources

- [MDN: `this`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/this)  
- [JavaScript.info: Object Methods](https://javascript.info/object-methods)  
- [W3Schools: JavaScript `this`](https://www.w3schools.com/js/js_this.asp)  

****

## Video Lesson Speech

This guide discusses how the 'this' keyword is used in real world JavaScript programs.

****

In this guide I'm going to introduce and walk through a real world scenario of a topic in javascript development that can be a little bit confusing especially to new developers but also it can be confusing to even more experienced developers just because it has a few caveats and a few things that are more challenging to understand and the key word is `this`. So `this` is a very special word in Javascript. And if you've never seen it before then it might be a little bit hard to understand at first which is why I'm not even going to get into writing code for it right in the middle because I think one of the easiest ways to understand it. 

Is actually to be able to see how it's used in a real world scenario. So I'm going to come here I'm on the dev camp library page here and I'm going to come and select one of these elements and one thing you may notice is I have this little hover effect here. And when you hover over one of the library items it gives a short synopsis on what is happening. And I actually use javascript when I was building in this feature. So I want to show exactly how I was able to do that. So I'm going to come here and select one of these items so you can see that we have these images and we also have these buttons. And so we have a bunch of different things that we can select.

Let me open this up in the inspector and just so you can see all of the different items that you have available. You have of course buttons, and then if you open this up you can see that this has that button that you just saw right here. What I want to do is actually because this button is a thing that I'm looking to grab i'm going to select button guide and now switch back to the console i'm going to write a little `Jquery`. Now I know this is not a `Jquery` course but `Jquery` is javascript it's just a layer on top of javascript and so I want to show you kind of a more practical way that you'd be able to use this for a real world app. This is a feature like I mentioned I already just built. So here I'm going to select it so I'm going to look for the button guide and then I'm going to create what's called a click handler which means it's going to look to see and it's going to wait for me to click on this item. 

I'm going to say click(function(event). Now do not worry about this. Like I said this isn't a `Jquery` course we're not going to get into all the details on jquery just yet you can go through the jquery course for those kinds of things. But what we have here is essentially we're building a listener that's waiting for an event to happen and in this case it's waiting for us to click on this button guide or on any of the button guides because one thing to note every one of these has this button guide. So when you have a scenario like this where if you scroll down you can see there are dozens of courses. We don't want to hard code in these values so we don't want to say OK, yes this is for the rails course, this is for photo course, this is for an API course.

You wouldn't want to do that because, one that would be very very slow from a development perspective you'd have to go back and hard code each one of those values every single time and it wouldn't be scalable every time that I create a new course. I'd have to go create a new javascript function to say oh yeah make sure you take in this new course and build this one handler on top of that. 

Instead I just add a selector for the button guide that watches for everything and then I wait for a click or in the case of this feature that I built, I waited for a hover event. So inside of it there's a couple things I need to do. First I'm going to take that event and I'm just going to say preventDefault(). That's simply saying I do not want when someone clicks on this, I don't want it to actually go to the next page for the sake of the script. Don't worry about that once again, that's where you're just waiting and listening for something and it's more for the sake of this demo. This is the part I want to show you. So here I want to say console log then do a dollar sign and once again this is jquery. I'll show you the syntax for pure vanilla javascript after this.

I'm going to just console.log(this) the jquery part is the one that has the dollar sign the part to keep in mind is just this. So now if I close this out it's going to look like this all put together.

```javascript
$('.btn-guide').click(function(event) {
    event.preventDefault();
    console.log($(this));
});
```

What this went and did, is it found 17 courses or it found 17 of these buttons that we're looking for this button guide. So it found all of these, and that's kind of helpful but right now it's not what we really need. Imagine if you were tasked with building a feature kind of like this one where you wanted javascript on a hover or on a click or something to make a certain set of descriptions appear. So here we have all these descriptions. How do we know which one was hovered over in order to pull up the content. Well that is where this comes in so handy because what this refers to is the specific item that we're looking to process the specific item that we're looking to do our work with. So imagine in this case what I built in was a hover effect that said, OK, when you hover over something that has this class I want you to do such and such type thing. 

In this case I want you to show this set of values but I want you to do it only on this so I only want you to show it when you hover over this rail scores only show the description for this Rail's course if not just keep it hidden. Same thing for each one of these. So coming down to example a little bit more now that we've done all of this. Now watch what happens if I come and I click on one of those buttons which is the one we selected one that preventDefault made it so it doesn't continue to the course.

Now look it printed out this, remember that's what the console log was we said we want you to just print out this object. And so that's what it did. It picked out what, got selected which in this case was, Learn Rails from Scratch course. If I click on here I can see all of the items associated with it. I can come here and see where the base URI is, I can see here that classes that were associated with that button and I can even see where it's pointing to. So everything and you can also get the innerHTML, you could do something like where you hover over and the content changes. Because if you have access to see it here that means you also have access to change it or do anything that you want with it. 

So this is pretty cool, this is a way of and I hope this is a helpful example for understanding how this works. And you know let's look at the code just one more time. And so what we have here this is referring to what ever it's looking for. So whatever we click on it's referring to that specific item it is something that gives you the ability to make your code much more dynamic because you don't have to hard code in the values that you're looking for you're actually able to build your selectors in a way where when someone clicks on something you know what they clicked on. So it makes it so that you don't have to know the future. You don't have to know what content is going to be there.

This really gets at the heart of what makes javascript so powerful is because you're able to allow the user as they're navigating your application to click on, to hover over things to type things in. But because of this you're able to know what they're on and then you're able to build your own custom functionality on top of that. So this was kind of an introduction to this in the next guide we're going to walk through how we can actually program with it and build it into our own programs.

```javascript
$('.btn-guide').click(function(event) {
    event.preventDefault();
    console.log($(this));
});
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_d_08_introduction_this.js)

****

## Coding Exercise

Follow the instructions below to utilize the `this` keyword to create a new person with the name of Jordan

```js
class Person {
    constructor(name){
this.name = name;
  }
}

const yourPerson = new Person('enterTheNameInHere');
```
