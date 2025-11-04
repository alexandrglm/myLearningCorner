# MODULE 04 - 034: JavaScript

## The `this` Keyword - Part 2: Practical Patterns

---

1. Object Method Context  
2. Constructor Functions  
3. Explicit Binding  
4. Arrow Function Behavior  
5. Real-world Authorization Example  

****

Building on `this` fundamentals, we now explore **practical patterns** where proper `this` binding enables powerful object-oriented and functional programming techniques in JavaScript.

****

## 1. Object Method Context

### Basic Object Methods

`this` refers to the object when calling its methods:

```js
const user = {
    name: 'Alexandr',
    
    greet() {
    return `Hello, ${this.name}!`;
    }
};

user.greet(); // "Hello, Alexandr!"
```

### Method Sharing Pitfall

Problem when extracting methods:

```js
const greet = user.greet;

greet(); // "Hello, undefined!" (lost context)
```

Solution: Bind context

```js
const boundGreet = user.greet.bind(user);
```

****

## 2. Constructor Functions

### Traditional Constructors

`this` refers to the new instance:

```js
function User(name) {

    this.name = name;
    this.greet = function() {
        
    return `Hi ${this.name}`;
    };

}

const user = new User('Jordan');

user.greet(); // "Hi Jordan"
```

### ES6 Classes

Same behavior with cleaner syntax:

```js
class User {
    constructor(name) {
        
        this.name = name;
    }

    greet() {
      
        return `Hi ${this.name}`;
  
    }
}
```

****

## 3. Explicit Binding

### call/apply/bind

Force `this` context:

```js
function showId() {

    return this.id;

}

const obj = { id: 42 };

// Temporary binding

showId.call(obj); // 42
showId.apply(obj); // 42

// Permanent binding

const boundFn = showId.bind(obj);

boundFn(); // 42
```

### Binding Parameters

`bind` can also preset arguments:

```js
function multiply(a, b) {

    return a * b;

}

const double = multiply.bind(null, 2);

double(5); // 10
```

****

## 4. Arrow Function Behavior

### Lexical `this`

Arrow functions don't have their own `this`:

```js
const obj = {

    value: 10,
    regular: function() {
    
        return this.value; // 10
    
    },
    arrow: () => {
        
        return this.value; // undefined (or window.value)
    }

};
```

### When to Use

Good for:

- Callbacks needing parent `this`  
- Functional programming methods  
- Short anonymous functions  

Avoid for:

- Object methods  
- Prototype methods  
- DOM event handlers needing element  

****

## 5. Real-world Authorization Example

### Complete Implementation

Building on the guide example with enhancements:

```js
class ContentGuide {
    
    constructor(title, content) {

        this.title = title;
        this._content = content;
    }

    isVisibleTo(role) {

      return role === 'paid';
    }

    render(role) {

        if (this.isVisibleTo(role)) {
            return `${this.title} - ${this._content}`;
        }
        return `${this.title} - [Upgrade to view content]`;
    }
}
```

### Key Improvements:

1. Used class syntax  
2. Protected content with `_content` convention  
3. More semantic method names  
4. Return strings instead of logging  
5. Clearer upgrade message  

### Usage:

```js
const guide = new ContentGuide(
    'Modern JavaScript',
    'Closures, prototypes, and more...'
);

console.log(guide.render('free')); 
// "Modern JavaScript - [Upgrade to view content]"

console.log(guide.render('paid'));
// "Modern JavaScript - Closures, prototypes, and more..."
```

## Code Examples

Constructor pattern:

```js
function Product(name, price) {

    this.name = name;
    this.price = price;
    this.formatPrice = () => `$${this.price}`;

}

const book = new Product('JS Guide', 29.99);

book.formatPrice(); // "$29.99"
```

Bound event handler:

```js
class ToggleButton {
    constructor(element) {
        this.element = element;
        this.active = false;
        this.handleClick = this.handleClick.bind(this);
        element.addEventListener('click', this.handleClick);
    }

    handleClick() {
        this.active = !this.active;
        this.element.classList.toggle('active', this.active);
    }

}
```

## Resources

- [MDN: `this`](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/this)  
- [JavaScript.info: Object Methods](https://javascript.info/object-methods)  
- [You Don't Know JS: `this` & Object Prototypes](https://github.com/getify/You-Dont-Know-JS/blob/1st-ed/this%20&%20object%20prototypes/README.md)  

****

---

## Video Lesson Speech

This tutorial examines how to work with the 'this' keyword in JavaScript
 programs. As an example, in this guide we'll build an authorization 
engine by combining object, closures, and the 'this' keyword.

---

Now that you've seen in a real-world scenario how you can use the word this. Let's get into how we can actually use it in pure vanilla javascript and we're going to talk about one of the most common ways to use it which is inside of objects. So let's build out a program and we're going to call the object a guide. This is going to have key-value pairs but we're also going to include our own methods inside of the object so the goal of this guide is going to be able to have a title and content. 

It's supposed to have data but then it also is going to have an authorization engine. So what it's going to do is check to see if the viewing user is a paid user or if they're a free user and if they're a paid user they'll render the content out if they're a free user, they won't. They simply will only show the title, not the content. So that's something that's pretty common to build in real-world applications so here I'm going to give it a title called The Guide to programming and then give it content and we can just say content will go here. Now let's build our methods, the first one is going to be one that I'm going to call visibleToUser. And this is going to be as all of the other types of methods are anonymous functions that are assigned to whatever we name them.

In this case, we named it visibleToUser and this is going to take in one argument which is going to be viewingUserRole and inside of this, we're going to have a conditional. I'm going to say if viewingUserRole which is our argument is triple equals two paid then we're going to return true and else we're going to return false. And that is our visibleToUser method. 

```javascript
var guide = {
  title: 'Guide to Programming',
  content: 'Content goes here...',
  visibleToUser: function (viewingUserRole) {
    if (viewingUserRole === 'paid') {
      return true;
    } else {
      return false;
    }
  },
}
```

Now we're going to build a method to render the content out. So we call this renderContent. This is going to take in a user role and then inside of this we're going to build out our system. Now let me just clear up the indentation. And now we're ready to keep on building the method. So renderContent inside of this function. I'm going to check to see and say if and then we could say you may think that we'd be able to say something like, (visibleToUser(userRole). Now, what this seems like it would do is call our method up above and that is logical especially if you've come from another programming language. However, there is a little bit of a catch here and this is where this comes in. If we just tried to run this exactly as we have right now javascript is just going to skip over this. They are going to ignore what we're saying here because we need to be more explicit.

We need to say this.visibleToUser because it needs to know the exact instance that we're referring to. If we just say this broad generic visibleToUser function it's going to look through the global namespace and check to see if there is a visibleToUser function. 

If not it's just going to return undefined we're not going to have anything here. And this isn't going to work. But when we say this it knows we're referencing this objects visible to use or method that is the key right there. We are referencing this specific instance of this object because this, in a traditional kind of application what usually is going to happen is you're going to have hundreds or thousands of these guide instances. If you just called a generic form of visibleToUser. It's not going to know which one you're referencing, we need to tell it that we're referencing this one for this instance. Now that we have visibleToUser, if that is true now inside of it we want to perform some logic say console.log and once again we're going to use `this` and this is a reason why I picked out this example because I want to show how you can use `this` both for methods and also for data. 

I can say this.title, and then here and just put a dash with some spaces in between followed by this dot content. And that is all you need to do there. That is for if the user is paid, in other words, if that is the visibleToUser comes back as false, I want to say this.content and set it equal to an empty string and then I'm just going to say console.log this.title. And so this one is going to be the exact same and the reason why I'm doing this obviously since we're doing in other console log statements it is very easy to just get rid of this entirely. But I wanted to do this so you can see a few different things. 

One we've talked about how you can call methods and also how you can call attributes but you also have the ability to change the values of attributes so that's also something important I wanted to show you all three of those different ways that this can work. 

With all of that in place, I think we're ready to test this out. So let's say user equals role and I'm just going create a basic object. And for the first one let's say paid and then I'm going to call a guide and then render content. And remember we just have to pass in the user role. And this should print now the full guide to programming and content.

```javascript
      console.log(this.title + " - " + this.content);
    } else {
      this.content = '';
      console.log(this.title + " - " + this.content);
    }
  }
}

user = { role: 'paid' };
guide.renderContent(user.role);

// "Guide to programming - Content will go here"
```

Let's test this out to see if it works, and look at that! It worked. 

Now, what happens if it's a free user? If change the user role to free and I hit run again, it shows "Guide to programming - " and the rest is blank. So this is working perfectly. We have our own little authorization engine here where it can check to see and based on a user's role it can dynamically generate a different type of content it can render content in much more of a dynamic fashion because we have the ability to call these other methods. 

This also comes in so handy when it comes to being able to encapsulate and organize our code properly because we don't have to worry about trying to pass all of that logic inside of here. Imagine if we had to put all of this code here and then input that inside of the rendered content that would really not be a great way to organize our code. It could start to get very messy quickly but by being able to leverage the concepts like `this` where you have the ability to say I want to create methods that specifically speak to this object. They completely ignore other objects in the global namespace. They're only talking about this one object that gives us the ability to be very explicit with the types of methods we're calling to know and be confident about the type of data attributes that we're working with. This definitely falls in the realm of the way that javascript programs are being built in our modern times.

```javascript
var guide = {
  title: 'Guide to Programming',
  content: 'Content goes here...',
  visibleToUser: function (viewingUserRole) {
    if (viewingUserRole === 'paid') {
      return true;
    } else {
      return false;
    }
  },
  renderContent: function(userRole) {
    if (this.visibleToUser(userRole)) {
      console.log(this.title + " - " + this.content);
    } else {
      this.content = '';
      console.log(this.title + " - " + this.content);
    }
  }
}

user = { role: 'paid' };
guide.renderContent(user.role);
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_d_09_this_keyword.js)

****

## Coding Exercise

Use 'this' to run the code and determine how many seats are left.

```js
var seats = {
  seats: 50,
  seatsSold: 28,
  remainingSeats: function(){
    return (this.seats - this.seatsSold)
    },
  enoughSeats: function(){
    if(this.remainingSeats() > 0){
      return // use this and seats to return the number of seats left.
    }
  }
}


seats.enoughSeats()
```
