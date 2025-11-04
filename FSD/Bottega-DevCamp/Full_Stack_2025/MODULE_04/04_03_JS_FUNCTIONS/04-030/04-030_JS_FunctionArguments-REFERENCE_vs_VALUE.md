# MODULE 04 - 030: JavaScript

## Functions (5) - Reference vs Value

---

1. Understanding Passing Mechanisms  
2. Primitive Types (Pass by Value)  
3. Objects (Pass by Reference)  
4. Avoiding Unintended Mutations  
5. Practical Patterns and Solutions  

****

JavaScript handles function arguments differently based on their type. This **pass-by-value vs pass-by-reference** behavior affects:

- Data integrity  
- Function side effects  
- Memory efficiency  
- Expected vs actual outcomes  

These mechanisms prevents subtle bugs and informs better design decisions.

****

## 1. Core Concepts

### Pass by Value

- Creates a copy of the original value  
- Changes don't affect the original  
- Applies to primitives:  
  - String  
  - Number  
  - Boolean  
  - Null  
  - Undefined  
  - Symbol  

### Pass by Reference

- Passes a reference to the original object  
- Changes affect the original  
- Applies to:  
  - Objects  
  - Arrays  
  - Functions  

****

## 2. Primitive Types (Pass by Value)

### Behavior Example

```js
let count = 10;

function increment(num) {
    num = num + 1;
    
    return num;

}

increment(count); // 11
console.log(count); // 10 (unchanged)
```

**Key Characteristics:**

- Function works with a copy  
- Original remains untouched  
- Simple predictable behavior  

****

## 3. Objects (Pass by Reference)

### Behavior Example

```js
const user = { name: 'Alex' };

function updateName(obj) {
     obj.name = 'Jamie';
     return obj;

}

updateName(user); // { name: 'Jamie' }
console.log(user); // { name: 'Jamie' } (modified)
```

**Key Implications:**

- Functions can modify original objects  
- Can lead to unintended side effects  
- Requires careful handling  

****

## 4. Avoiding Unintended Mutations

### Strategy 1: Object Copying

Create shallow copies before modification:

```js
function safeUpdate(obj) {

    const copy = { ...obj }; // Spread operator

    copy.property = 'new value';

    return copy;
}
```

### Strategy 2: Specific Property Passing

Pass only needed primitive values:

```js
function updateName(name) {

    return 'New ' + name;

}

user.name = updateName(user.name);
```

### Strategy 3: Object Freezing

Prevent modifications to important objects:

```js
const config = Object.freeze({ apiUrl: '...' });

function unsafeUpdate(config) {

    config.apiUrl = 'hacked'; // Throws in strict mode

}
```

****

## 5. Practical Patterns

### Immutable Update Pattern

```js
const updatedUser = {

    ...user,
    name: 'Updated Name'

};
```

### Defensive Copying

```js
function processData(data) {

    const internalData = JSON.parse(JSON.stringify(data));
    // Work with internalData

}
```

### Pure Functions

Functions that don't modify inputs:

```js
function pureFullName(user) {

    return `${user.first} ${user.last}`;

}
```

****

## Advanced Considerations

### Nested Objects

Shallow copies don't protect nested references:

```js
const original = { nested: { value: 1 } };
const copy = { ...original };

copy.nested.value = 2; // Affects original!
```

Solution: Deep cloning libraries like Lodash's `cloneDeep`

### Performance Implications

- Pass by value: More memory usage for large data  
- Pass by reference: More efficient but riskier  

### ES6 Proxies

For advanced reference control:

```js
const protectedUser = new Proxy(user, {

    set() { throw new Error('Read-only!'); }

});
```

****

## Code Examples

Pass by value demonstration:

```js
let age = 30;

function changeAge(a) {
    a = 40;
    return a;

}

changeAge(age); // 40
console.log(age); // 30
```

Pass by reference demonstration:

```js
const car = { make: 'Toyota' };

function repaint(c) {
    c.color = 'blue';
    return c;
}

repaint(car); // { make: 'Toyota', color: 'blue' }
console.log(car); // Modified original
```

Safe object update:

```js
const product = { id: 1, price: 100 };

function discount(p) {

    const copy = { ...p };
    copy.price *= 0.9;

return copy;
}

const saleItem = discount(product);
```

## Resources

- [MDN: Primitive vs Reference](https://developer.mozilla.org/en-US/docs/Glossary/Primitive)  
- [JavaScript.info: Object References](https://javascript.info/object-copy)  
- [W3Schools: JavaScript Objects](https://www.w3schools.com/js/js_object_definition.asp)  

****

****

## Video Lesson Speech

This guide discusses the key differences between passing arguments via reference and passing them by value.

****

Now that we've discussed what parameters are and how function arguments work. I'd be remiss if I didn't go into detail and talk about the types of items you can pass into javascript functions. So if we pass in an object you may be surprised to learn that it behaves much differently than if you passed in a variable. And the reason for this is because we have the concept of `reference vs value` and this can be very confusing especially if you've never seen it before. But essentially the way it works is when it comes to arguments in Javascript functions you are going to pass in objects and those are going to get treated by reference which means they're not actually grabbing the values they're grabbing a reference to the original object. 

Whereas if you pass in a variable it is simply going to essentially make a copy of that variable or of that variable's value and it's going to use that. This can have some pretty far-reaching implications if you've never seen it before so I'm going to start off by creating an object here. I'm going to say some user and give it just an attribute of a name so I'm going to say Jordan and that is our someUser. 

```javascript
var someUser = {
name: 'Jordan'
}
```

Now let's create a function. So function and I'm going to make a function declaration here called nameFormatter. It's going to take in a user which we're going to pass a user object in and it is going to return the user.name, but let's imagine that we did something to change the value of the name.

```javascript
function nameFormatter (user) {
    return user.name = 'Oops';
}
```

So if we did that everything is going to work. 

But we're going to have a little bit of some weird behavior. So if I say nameFormatter and I'm going to pass in some user as the argument it returns "Oops" which is pretty much what you'd expect that it would return.

```javascript
nameFormatter(someUser); // "Oops"
```

But now what happens if we pass in some user?

```javascript
someUser; // Object {name: "Oops"}
```

Now we can see that some user the object has its name and it's changed to Oops. That is probably not what we're going for when we're passing that value in. 

Now let's see how it works with variables. Let's create a variable so I'm going to say var and just say some name equals Tiffany.

```javascript
var someName = 'Tiffany';
```

Now we can create a function again. So when you say function and someOtherNameFormatter and this is just going to take in a name it's not going to take in the full object. And here if I say return and then name equals Oops and closeout that block, everything seems like it works. And now if I called someOtherNameFormatter and pass in our variable it prints out Oops. 

```javascript
function someOtherNameFormatter(name) {
    return name = 'Oops';
}

someOtherNameFormatter(someName); // "Oops"
```

So far so good. Everything seems like it's working the exact same way. 

But now if I look for someName again you can see it's still equal to Tiffany. So this is the main difference. When we pass an object in as an argument it is going to be treated as a reference which means that the function is going to go and look at the reference to the object.

So in this case when we called some user it got redirected up to someUser and it said Ok someUser has a name attribute. And now we're going to change it. Given our function declaration rules, we're going to change that user's name to Oops. And that is part of what we're doing we're doing more than just returning this. We're also performing all the tasks inside of it. And so it went and had a side effect. And this is what a visual side effect is called is where you run a function and the function does more work than you thought it was going to do. It performs other tasks than simply what you were intending for it to do and that can lead to some very weird, very confusing types of bugs. 

Now if we come down and we come to our second variable where we have someName and when we call another function and notice this is doing the exact same thing the only difference is it's not an object so we're not using the dot notation but essentially we're grabbing the whatever we've passed in and then we're setting it equal to something else when we call this function, we get are something else, we get our Oops and that's what we're looking to do. Then if you call the original value that got passed in right here you look for that argument. It did not go change the value of the variable. That is the key difference between something that is passed by value and something that is passed by reference. 

Now one of the first questions you may have is, what happens when I need to pass in an object? How can I do that?

One of the most logical ways that I've seen to do that is to actually just pass in the actual value itself. I'm going to copy this function so you can see everything is exactly the same. And here I am going to say userName just so we can be more explicit about it and instead of calling and traversing using the dot notation here. I'm going to hit return and I'm going to create another object because this one's already been changed here or let me just change it so we can see that someName or I should say someUser.name 

```javascript
function nameFormatter (userName) {
return userName = 'Oops';
}
someUser.name; // "Oops"
```

You can see right now it's Oops. Let's fix that. Remember we can change an object value by simply calling it just like this. And now if you call some userName again now you can see it's been updated. So what we can do is with our nameFormatter the way that we've changed it up. If I call nameFormatter, now and instead of passing in the whole object I just pass in someUser.name then let's see if this is any different. So I run this. It still prints out Oops everything is exactly the way we'd expect. Now if I say someUser.name now, you can see that it has not changed the value and that is how you can pass in an object without having its reference points change. In other words without having that weird side effect where the value in the object got updated and now you can treat the parameters and the attributes inside of your objects the same way that you'd treat a variable.

```javascript
var someUser = {
    name: 'Jordan'
}

function nameFormatter (user) {
    return user.name = 'Oops';
}

nameFormatter(someUser); // "Oops"

someUser; // Object {name: "Oops"}

var someName = 'Tiffany';

function someOtherNameFormatter(name) {
    return name = 'Oops';
}

someOtherNameFormatter(someName); // "Oops"

someName; // "Tiffany"

function nameFormatter (userName) {
    return userName = 'Oops';
}

someUser.name; // "Oops"

someUser.name = 'Kristine';

nameFormatter(someUser.name); // "Oops"

someUser.name; // "Kristine"
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_d_05_reference_vs_value.js)

****

## Coding Exercise

Overwrite the `someUser.name` value so that it says "Jordan" instead of "Blank".

```js

```
