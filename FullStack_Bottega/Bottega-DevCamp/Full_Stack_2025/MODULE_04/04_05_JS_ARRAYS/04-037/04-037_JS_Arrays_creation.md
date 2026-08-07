# MODULE 04 - 037: JavaScript

## Arrays (1) - Creating Arrays

***

1. Array Creation Methods
2. Array Literal vs Constructor
3. Accessing Array Elements
4. Working with Mixed Data Types

***

## 1. Array Creation Methods

JavaScript provides two primary ways to create arrays:

### Array Constructor Syntax

```js
var emptyArray = new Array(3); // Creates array with 3 empty slots

var populatedArray = new Array('A', 'B', 'C'); // Creates array with values
```

### Array Literal Syntax (Recommended)

```js
var numbers = [1, 2, 3];

var names = ['Alice', 'Bob', 'Charlie'];
```

**Differences:**

* Constructor syntax useful when you know array size but not content
* Literal syntax is more readable and commonly preferred

***

## 2. Array Literal vs Constructor

### When to Use Each

| Constructor Syntax   | Literal Syntax       |
| -------------------- | -------------------- |
| Rare edge cases      | 95% of use cases     |
| Dynamic array sizing | Fixed known elements |
| Legacy code          | Modern practice      |

**Performance Note:**\
Modern JavaScript engines optimize literal syntax better.

***

## 3. Accessing Array Elements

Arrays are zero-indexed. Access elements with bracket notation:

```js
var colors = ['red', 'green', 'blue'];

colors[0]; // "red" (first element)
colors[2]; // "blue" (third element)
```

### Nested Array Access

For multi-dimensional arrays, chain the bracket notation:

```js
var matrix = [
 [1, 2, 3],
 [4, 5, 6]
];

matrix[1][0]; // 4 (second array, first element)
```

***

## 4. Working with Mixed Data Types

JavaScript arrays can hold any combination of data types:

```js
var mixed = [
    'text', 
    42, 
    true, 
    { name: 'Alexandr' }, 
    function() { return 'Hello'; },
    ['nested', 'array']
];
```

### Accessing Mixed Elements

```js
mixed[3].name; // "Alex" (object property)
mixed[4](); // "Hello" (function execution)
mixed[5][1]; // "array" (nested array access)
```

**Common Pitfall:**\
Type confusion when mixing data types - maintain consistency where possible.

***

## 5. Best Practices and Common Pitfalls

### Do's

* Prefer literal syntax `[]` over constructor
* Use descriptive variable names
* Keep arrays homogeneous when possible
* Validate array indices before access

### Don'ts

* Avoid sparse arrays (undefined gaps)
* Don't mix unrelated data types
* Watch for reference issues with objects in arrays

### Defensive Programming Example

```js
// Safe array access

function getElement(arr, index) {
    
    if (!Array.isArray(arr)) return null;
 
    if (index >= arr.length) return null;
 
    return arr[index];
}
```

***

## Practical Applications

### Real-World Use Cases

1.  **API Responses:**

    ```js
    // Typical API response structure

    var apiResponse = [
        { id: 1, title: 'Post 1' },
        { id: 2, title: 'Post 2' }
    ];
    ```
2.  **Data Processing:**

    ```js
    // Calculating average from number array

    function getAverage(scores) {
        const sum = scores.reduce((total, num) => total + num, 0);
        return sum / scores.length;
    }
    ```
3.  **UI Component Lists:**

    ```js
    // React example using array map

    function UserList({ users }) {

        return (
            <ul> {users.map(user => <li key={user.id}>{user.name}</li>)} </ul>
        );
    }
    ```

***

## Common Mistakes and Solutions

### Mistake 1: Off-by-One Errors

```js
var colors = ['red', 'green', 'blue'];

colors[3]; // undefined (array length is 3, last index is 2)
```

**Solution:** Always remember arrays are zero-indexed.

### Mistake 2: Assuming Array Type

```js
function processItems(items) {

    // Fails if items isn't an array
    return items.map(item => item * 2);

}
```

**Solution:** Add type checking:

```js
if (!Array.isArray(items)) throw new Error('Expected array');
```

### Mistake 3: Reference vs Copy

```js
var original = [{ value: 1 }];

var copy = [...original];

copy[0].value = 2; // Also modifies original!
```

**Solution:** Deep clone when needed:

```js
var safeCopy = JSON.parse(JSON.stringify(original));
```

***

## Performance Considerations

1. **Memory Usage:**
   * Large arrays consume significant memory
   * Avoid holding unused array references
2. **Access Patterns:**
   * Index access is O(1) constant time
   * Searching is O(n) linear time
3. **Optimization Tip:**\
   For large datasets, consider typed arrays if working with numbers:

```js
var buffer = new ArrayBuffer(16);

var int32View = new Int32Array(buffer);
```

***

## Resources

* [MDN Array Documentation](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array)
* [JavaScript.info Arrays](https://javascript.info/array)
* [ECMAScript Array Specification](https://tc39.es/ecma262/#sec-array-objects)

***

## Video lesson Speech

This introductory lesson walks through the various ways that you can\
create arrays in JavaScript. Additionally, we examine how we can query\
elements in arrays using the bracket syntax.

***

In this guide, we're going to start working through what arrays are in JavaScript and how we can work with them.

There are two main ways that you can create an array and we're going to use the first syntax which is essentially a generated syntax where we create a new array object. And so I'm going to store it in a variable called `generatedArray` and the syntax for this is `new` which is a special keyword and then array. Now there are a couple of ways to do this. Say that you want an array with three elements inside of it, we can pass it in just like this.

```javascript
var generatedArray = new Array(3);
```

And this will create the array for us.

If I say `generatedArray` now you can see that we have 3 items. They're all undefined. But we do have a collection. We could even call generatedArray length and you can see that we have three items in this array. Now having 3 undefine items may not seem very helpful. So let's go and let's create a new array with some names so I can create some baseball player names here.

And now if I run

```javascript
var generatedArray = new Array('Altuve', 'Correa', 'Spring');
```

this generatedArray you can see that we have a collection of three individuals and three strings. So that is one way that you can generate an array. I don't use that way too often and the only time I'll usually use it is when I want to create an array and I don't know what the values are going to be, but I happen to know how many elements are going to be inside and then I use exactly what I did up here.

The more common way that I create an array is by creating what is called the `array literal syntax`. And so here is a VAR literal array. Obviously you could call it anything you want and here it is simply going to be using the brackets. And so I can put inside of these three items and run it. And now I have a literal array just like that.

```javascript
var literalArray = [1, 2, 3];

literalArray; // (3) [1, 2, 3]
```

Now I could obviously mix these. So those are using integers but if I wanted to I could put strings inside of it. So if I go literal array again I can reassign it to these values. And now if I call literal array it has Altuve, Correa, and Spring which is supposed to be Springer the baseball player.

```javascript
var literalArray = ['Altuve', 'Correa', 'Spring'];

literalArray;  // (3) ['Altuve', 'Correa', 'Spring']
```

I can also do just like before, I can call link that has that attribute associated with it so that those are the two most common ways.

Now I've shown you how you can have integers and I've shown you how you can have strings. But JavaScript is incredibly flexible and you can mix and match the elements in the data types inside of your arrays. So let's create a new one called mixed array. And with this mixed array you'll see we can combine anything that we want. For the most part. So I can say hi and put a integer. I can't even put another array. So I could but the ABC's is right here and this is going to be a nested array inside of it.

Make sure you separate each one with the comma and then from there I can even put in objects. Here I can put an object with a name, close the object out and the last one we're going to do may seem a little bit tricky but I can actually put a function in here as well. I could say function greeting and then inside of it console log 'hey there' and then also close it off obviously.

```javascript
var mixedArray = ['Hi', 1, ['a', 'b', 'c'], { name: 'Kristine' }, function greeting() { console.log('hey there');}]
```

And we have our mixedArray, so that should show you could put literally anything you want. It's a collection of data but JavaScript is a much more flexible with what you can put inside of your arrays than many other languages. Many languages like C or Java in those ones you have to declare the type of elements that are going to be inside of an array and that's because they have very strict compiler requirements. whereas, the JavaScript engine is much more flexible and what it allows. So that's how you can create arrays.

Now let's talk about how we can actually get things out of the arrays. So let's start with our most basic one. If we go back to literal array here the syntax for getting items out is what's called the bracket syntax so you put two brackets right here. And then inside of it you call the index of the item that you want to pull out. Early on in this course I talked about indexes in computer science starting with 0 instead of 1. We discussed that when we're talking about how we could count the characters and grab characters from a string.

We can follow the same pattern when working with arrays so right here if we want Altuve, we can pass in zero and remember it's because arrays and indexes in general start with zero.

```javascript
literalArray[0]; // "Altuve"
```

If I hit return, that pulls out Altuve and now I can use it however I want. So a very common pattern you'll see is to do something like this. I can say player name and then call the literalArray and this time let's go with the next item which is going to be 1. So I store it and now if I call player name you can see it's stored with Correa and that is very common kind of pattern that you will see in development.

```javascript
var playerName = literalArray[1];

playerName; // "Correa"
```

Now that is helpful but you may still kind of be wondering when in the world am I going to use this? That's a very common question to ask especially if you are new to development. Arrays are incredibly handy for a number of scenarios. One of the most common that I use them for is with database queries. Usually when you're building an application and you make a query to a database or to an API when you receive that data back there has to be a standard representation for how that data is sent back to you. One of the most common is to have data sent as an array and you can then loop over that data show it on the screen. And so that's one of the reasons why it's so important to understand the way that arrays and collections work.

Now let's move down the list a little bit. So we talked about how we can grab a single element. Let's also talk about how we can work with some of those more complex ones.

Remember we have our mixedArray and if I open this up you can see all of the different things that we have inside it. In the zero index, we have "Hi" in the first index, we have the integer 1 then we have an array that has an array inside of it. Then we have a object with a key value pair of name and then Kristine and then we have a function called greeting.

So how exactly can we call some of these other items. Well we already talked about how we could call the first two. Those are pretty basic where we in a call just mixed array and do something like that with the bracket syntax with the next one it may seem like this would be more tricky when you have a nested array. So what we're going to do is pass in the index 2 and whenever you want to reference that that's one thing I love about the javascript console is it gives you a really nice reference point for your indexes and different things like that.

So here I want the array but let's say that I want the "C" in the array and I know it's at the second index, I can pass in a second set of brackets so whenever you have something nested like this then you can do your very first call your very first query and then use the bracket syntax again and chain these together. Now run this and it returns "C" and you could store that in a variable or whatever you want to do with it. When you're working with nested arrays.

```javascript
mixedArray[2][2]; // "c"
```

Now let's talk about our object. We know it's in the index of 3, and because of that we're going to receive just a plain object back. So if I just say 3, this gives us an object back so don't let the end of the bracket syntax intimidate you because all you need to do is treat it like we've been treating objects this entire course. You can use the dot syntax and chain it together. Now you can have access to that name.

```javascript
mixedArray[3]; // Object {name: "Kristine"}

mixedArray[3].name; // "Kristine"
```

Now let's talk about the last one because this one I've seen trip people up a little bit. So we have our greeting and if you just call 4 that is only going to return the function greeting. But what if we actually want to call the function which is a more standard thing. Well it's going to be the exact same way that we had call a regular function. We've queried it and now we just put our nice parends at the end and it prints out 'hey there' and the function is executed.

```javascript
mixedArray[4]; // function greeting( ) { console.log('hey there');}

mixedArray[4](); // hey there
```

Now go a little bit further if you want to do things like be able to have methods inside of objects that is a very common thing to do and you can have those include it and arrays. So one of the easiest ways of understanding the way arrays work in JavaScript is just think of them as a collection of all the regular items that you've been using this entire course. So there's nothing more special about them than that. They collect everything you can put things inside of it.

It's just a way of storing it, when you want to store multiple things inside of the same variable you can. But beyond that you can treat them exactly the same way as when they were just kind of one off items stored inside of variables. So the main thing to understand is how you can properly query each one of those items just like we walk through right here.

## Resources

* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_e__01_introduction_arrays.js)

***

## Coding Exercise

Create an array that has 3 elements, there must be a least one number within the array.

```js
var myArray = []
```
