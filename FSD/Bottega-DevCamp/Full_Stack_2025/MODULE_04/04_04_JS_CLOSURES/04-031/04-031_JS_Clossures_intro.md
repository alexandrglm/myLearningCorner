# MODULE 04 - 031:     JavaScript

## Clossures.

---

1. Understanding Closures  
2. Creating and Using Closures  
3. Practical Closure Patterns  
4. Memory Considerations  
5. Real-world Use Cases  

****

**Closures** are a fundamental JavaScript concept where a function retains access to its lexical scope even when executed outside that scope. They enable:

- Data privacy and encapsulation  
- Stateful functions  
- Functional programming patterns  
- Modular code organization  

Closures are created whenever a function is defined inside another function and maintains access to the outer function's variables.

****

## 1. Core Closure Concepts

### Basic Closure Example

```js
function outer() {
  
    const secret = '123';

    function inner() {
    
        return secret; // Accesses outer function's variable
    }

    return inner;
}

const getSecret = outer();

getSecret(); // "123"
```

Characteristics:**

- Inner functions remember their creation context.
- Variables aren't garbage collected while accessible.
- Enables factory functions and modules.

### The Batting Average Example

```js
function battingAverage() {
     let hits = 100;
     let atBats = 300;

    return {

        getAverage: () => hits / atBats,
        
        updateStats: (h, a) => {
            hits += h;
            atBats += a;
        }
    };
}

const player = battingAverage();

player.getAverage(); // 0.333
player.updateStats(10, 30);
player.getAverage(); // Updated value
```

****

## 2. Creating Effective Closures

### Factory Functions

Functions that return customized closures:

```js
function createCounter(start = 0) {

    let count = start;

    return {
        increment: () => ++count,
        decrement: () => --count,
        current: () => count
    };
}

const counter = createCounter(5);

counter.increment(); // 6
```

### Private Variables

Closures enable true data privacy:

```js
function createAccount(balance) {

    let _balance = balance; // Private

    return {
        
        deposit: amount => _balance += amount,
        withdraw: amount => _balance -= amount,
        checkBalance: () => _balance
    };
}
```

****

## 3. Practical Closure Patterns

### Module Pattern

Encapsulating related functionality:

```js
const shoppingCart = (function() {
    const items = [];

    return {
        
        addItem: item => items.push(item),
        removeItem: id => items.filter(i => i.id !== id),
        getItems: () => [...items] // Return copy
    };

})();
```

### Event Handlers

Maintaining state in callbacks:

```js
function setupButtons() {
    
    const buttons = document.querySelectorAll('button');

    buttons.forEach((btn, i) => {
        btn.addEventListener('click', () => {
          console.log(`Button ${i} clicked`);
        });
    });
}
```

### Partial Application

Pre-setting function arguments:

```js
function multiply(a, b) {
    return a * b;
}

function createMultiplier(a) {
    return function(b) {
        return multiply(a, b);
    };
}

const double = createMultiplier(2);

double(5); // 10
```

****

## 4. Memory and Performance

### Memory Management

- Closures maintain references to outer variables  
- Can lead to memory leaks if not handled properly  
- Modern engines optimize closure performance  

### Garbage Collection

Variables are only collected when:

- No closures reference them  
- All referencing closures are themselves garbage collected  

### Optimization Tips

- Nullify references when done  
- Avoid unnecessary closures in loops  
- Use weak references (WeakMap) when appropriate  

****

## 5. Real-world Applications

### State Management

```js
function createStore(reducer) {
    let state = reducer(undefined, {});
    const subscribers = [];

    return {
        getState: () => state,
        dispatch: action => {
            state = reducer(state, action);
            subscribers.forEach(sub => sub());
        },
    
        subscribe: callback => {
            subscribers.push(callback);
              return () => {
                  subscribers = subscribers.filter(sub => sub !== callback);
              };
        }
    };
}
```

### API Clients

```js
function createApiClient(baseUrl) {
    return {
        get: endpoint => fetch(`${baseUrl}${endpoint}`),
        post: (endpoint, data) => fetch(`${baseUrl}${endpoint}`, {
            
            method: 'POST',
            body: JSON.stringify(data)
        })
    };
}
```

### Functional Utilities

```js
function memoize(fn) {
    const cache = new Map();

    return function(...args) {
        const key = JSON.stringify(args);
        if (cache.has(key)) return cache.get(key);

        const result = fn(...args);
        cache.set(key, result);
        return result;
      
    };
}
```

## Code Examples

Basic closure:

```js
function outer() {
    const x = 10;
    return () => x * 2;
}

const doubleX = outer();

doubleX(); // 20
```

Data privacy example:

```js
function createWallet() {
    let balance = 0;
 
    return {
        deposit: amt => balance += amt,
        withdraw: amt => balance -= amt,
        check: () => balance
    };
}
```

## Resources

- [MDN: Closures](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Closures)  
- [JavaScript.info: Closure](https://javascript.info/closure)  
- [W3Schools: JavaScript Closures](https://www.w3schools.com/js/js_function_closures.asp)  

****

## Video lesson Speech

This lesson examines how to work with JavaScript closures. This will 
include walking through how to return closures from a function.

****

This is going to be a really fun episode. In this guide, we're going to build more of a real-life type program. That is going to calculate a batting average and we're going to learn about javascript closures in order to do it. 

I'm going to create a function declaration here. I'm going to say function and then battingAverage. And this is going to take no arguments. And now inside of it, I'm going to create some local variables. One thing I like about the program we're going to build. You may notice we're going to include a number of the things that we learned in the past few sections all together here so we're going to talk about local variables talk about functions how items get returned. We're going to talk about nested functions which are, in this case, are going to be closures and then we're even in to perform some computation. 

The first thing we're going to do is set hits a local variable and set this equal to a hundred just to start off. And now var atBats set this equal to 300. 

```javascript
function battingAverage () {
  var hits = 100;
  var atBats = 300;

}
```

Now any normal program these would probably be calling a database, getting that count, and then that's how these are going to be updated. 

Now normally up to this time what we've done is we have simply returned a value. So we've taken something like hits and atBats in this case and then we return to some type of computation on those.

Now I'm going to talk about what closures are and how we can use them in order to give a more dynamic type of feel to our programs. So essentially what a closure is, is it's being able to wrap up an entire set of behavior and usually wrapped up in a function and be able to use that, pass it around, and call it however you need to. 

What we're going to do is we're going to create two closures. We're going to create one for getting the current average and then we're going to get one that is going to be updating. One is simply returning a value back kind of like querying a database. The other one is actually going to perform some action that's going to set some values and then we can call our get current average after that one. 

So I'm going to have our return statement here. Return a javascript object this is going to return an object and the object is going to contain two closures. Now one thing to keep in note, just a nomenclature kind of topic. Whenever you have an object and you have functions declared or defined inside of that javascript object those functions are technically called methods. So usually when you're going to see something like this, the proper name for them is a javascript method and our method name is going to be getCurrentAverage and just like a normal key-value pair that's going to just say getCurrentAverage and then we're going to use an anonymous function here. So I'm going to say function and then inside of this function we're just going to return our hits which is our local variable up there divided by atBats which is how you'd get an average of something.

```javascript
 return {
    getCurrentAverage: function () {
      return (hits/atBats);
    }
```

So the math isn't too crazy we're just taking our hits dividing it by atBats and that's all we need to do. So that is the first part. 

Now that is one function or one method. And now we're going to have another one and this is going to be named updateHitsAndAtBats, this one same thing it's going to have an anonymous function that's assigned to it and we'll say function hit is going to be one argument and atBat is going to be another argument and notice that even though this is an anonymous function we can pass arguments to it the same way that we would before. And this is the reason why I wanted to talk about function expressions before so that you'd be able to see how they could work as closures. So we're going to perform two tasks here first we're going to take our hits variable our local variable. We're going to increment by one or however many we want to pass in, and technically you could pass in more than one, you could pass in 10 hits if they got 10 hits and you want to update the system. Then we're going to do the same thing with atBat. So we're going to say atBats and we will increment that by atBat. 

```javascript
    updateHitsAndAtBats: function (hit, atBat) {
      hits += hit;
      atBats += atBat;
    }
```

So that's a little bit more work than usually, we've been doing each lecture. So let's kind of review it. 

We have declared a function called battingAverage. It takes no arguments and we have started it off with two variables and these are local variables local to battingAverage if we call them outside of it, it would not work. 

Now our function returns two methods. It returns a getCurrentAverage which simply is going to grab the hits, divide it by the atBats and that is going to be the current average and then we have an updater action here, we have updateHitsAndAtBats which is another method it takes two arguments a number of hits, a number of atBats. And then increments both of those. So let's see if this works I'm going to create a new instance of this batting average say var altuve, the baseball player and say battingAverage and just create it just like that. Now nothing's going to happen here. 

But now let's see what we can do, we can call console.log(altuve.getCurrentAverage());

Now let's see what we have. So if I save this and if I run this you can see that this worked. It gave us a batting average of 333 which is accurate if you divide 100 by 300. 

```javascript
var altuve = battingAverage();
console.log(altuve.getCurrentAverage());
// 333
```

Now the syntax may look kind of weird. We created this altuve variable. And we are storing the battingAverage variable of the function inside of that, because of that. Because it returns an object we can use the object dot type of traversal. So we're able to just call altuve.getCurrentAverage just like this. Just like we are creating a plain user object or some type of object just like we've done before where we create an object call a user and say user.name and it pulls in that value. We can do the exact same thing here when we're returning a function. We're able to call that function just like a normal object attribute which is something very cool. Not a lot of programming languages allow you to do something like this so this is neat. And it worked. So that works out nicely. That worked very well. 

Now let's update some things because we have our other function or method. Let's now try to change some values so I can say altuve.update and I'm just going to copy this function or this method because it's a little bit longer one so altuve.updateHitsAndAtBats. I'm going to pass in no hits and 20 atBats. Then we can call this again and that's when the cool thing is this is dynamic. If I leave the code just like it is here we should get 333 for the first console.log, but then we should get a different number for the second console.log, because we increased no hits, and we added 20 atBats. So if I run this you can see it worked. 

```javascript
var altuve = battingAverage();
console.log(altuve.getCurrentAverage());
altuve.updateHitsAndAtBats(0, 20);
console.log(altuve.getCurrentAverage());

// 0.3333333333333
// 0.3125
```

We have a batting average of 333 and in the second one when we added all those atBats without a hit his average is now.312, So this is working perfectly.

And with updateHitsAndAtBats, it took in its two arguments, it went and grabbed hits and atBats incremented them by whatever we passed in. So if we just passed in a 1 and a 1 it would've increment hits and atBats by 1 and 1. And because we're storing all of this inside of the altuve variable that allows us to do is maintain state. So if you built something like this, say you're building an eCommerce website and you're building a shopping cart you'd be able to do something exactly like this where every time they added a new item to the shopping cart you'd be able to keep track of that and you'd be able to customize their experience based on the values that they are adding into the card. 

So this is something that is very powerful and as you start to get into more professional real-world types of programs such as building types of libraries on Node or working with the Express framework or angular or one of those. You're going to see this happening a lot where you are returning not just a few values but you're actually returning objects and then those objects can be called and you can use them however you need to. Whether it's to update values, to add and create values, to perform form submissions, anything like that. 

I am excited about this one because when I look at this code this is looking a lot more like real-world application code. This is something I could see where to take out a few of these type values and slide in API calls, and all of a sudden this is communicating with an outside server and you're doing some pretty cool things. So this is exciting because this is something that you could actually be building in not too long and you're going to be building some more advanced behavior. I'd definitely recommend if this is unclear at all, go through it a few times. Customize these functions so you can become familiar with the syntax. Get an idea for how the data flow works and you'll be ready to move on in the course.

```javascript
function battingAverage () {
  var hits = 100;
  var atBats = 300;

  return {
    getCurrentAverage: function () {
      return (hits/atBats);
    },
    updateHitsAndAtBats: function (hit, atBat) {
      hits += hit;
      atBats += atBat;
    }
  }
}

var altuve = battingAverage();
console.log(altuve.getCurrentAverage());
altuve.updateHitsAndAtBats(0, 20);
console.log(altuve.getCurrentAverage());
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_d_06_closures.js)

****

## Coding Exercise

Take the variable roomOne and call the function on it to return the seats remaining.

```js
function movieTheater(){
    var seats = 50;
    var seatsSold = 28;

    return{
        remainingSeats: function(){
        return (seats - seatsSold)
        }
    }
}

var roomOne = movieTheater()

// call the remainingSeats method of the instace of movieTheater
```
