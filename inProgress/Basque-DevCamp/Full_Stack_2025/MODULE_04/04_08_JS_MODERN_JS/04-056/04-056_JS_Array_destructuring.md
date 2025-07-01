# MODULE 04 - 056: JavaScript

# Modern JS (6): Array Destructuring

---

1. Traditional Index-Based Access

2. Destructuring Arrays

3. Benefits and Use Cases

****

In modern JavaScript, **array destructuring** is a concise syntax that allows you to extract multiple values from an array and assign them to individual variables in a single line.  

It's commonly used when working with structured data, API responses, or simplifying array access logic.

****

### 1. Traditional Index-Based Access

Without destructuring, accessing multiple items from an array looks like this:

```js
const apiList = [
  'https://api.dailysmarty.com/posts',
  'https://api.github.com/users/jordanhudgens/repos',
  'https://api.github.com/users/jordanhudgens'
];

const posts = apiList[0];
const repos = apiList[1];
const profile = apiList[2];

console.log(posts);
console.log(repos);
console.log(profile);
```

This becomes verbose and error-prone as the number of array items increases.

****

### 2. Destructuring Arrays

Using ES6 array destructuring, the same task becomes more efficient:

```js
const apiList = [
  'https://api.dailysmarty.com/posts',
  'https://api.github.com/users/jordanhudgens/repos',
  'https://api.github.com/users/jordanhudgens'
];

const [posts, repos, profile] = apiList;

console.log(posts);
console.log(repos);
console.log(profile);
```

This destructuring syntax extracts each value by its index and assigns it to the variable in order.

****

### 3. Benefits and Use Cases

- **Cleaner code:** Reduce clutter when accessing multiple array values.

- **Useful in APIs:** Great for unpacking API endpoints or function returns.

- **Efficient syntax:** One line of code replaces several lines of traditional access.

Destructuring is particularly useful when:

- Working with tuples or arrays returned from functions

- Dealing with configuration lists or route maps

- Simplifying test data setup

---

### References

- [Destructuring - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring)

- https://javascript.info/destructuring-assignment

---

## Video lesson Speech

Continuing on our discussion on destructuring in javascript this is 
going to be a short guide that analyzes how we can leverage 
destructuring with arrays.

****

This is a very powerful tool. This is going to be something that you'll be using quite a bit quite possibly even on a daily basis because it is such an efficient way of grabbing elements from an array and assigning them to variables. 

Now let's talk about what we would need to do if we had an array like this where we have links to API endpoints and we want to take these from an array and we want to put them inside of a variable that we can do something with. Well, we could do something like this where I could say const and then posts and then set this equal to apiList and then grab the very first element right there.` const posts = apiList[0];`

Now if I want to `console.log(posts);` then I'll hit save and run and then it'll go through and everything their work. But this really isn't very efficient because I have three items here. Imagine a situation where I had, even more, I'd have to do this entire process three times for each one of these and give a different variable name and change where I'm calling it to be one change it to be two so on and so forth. 

What destructuring allows us to do when we deal with arrays is actually do all of this on a single line. That's what I'm going to show you how to do here. So we have three elements and the way that you can do this is you start off with const and then instead of just giving a single variable name. What we're going to do is wrap this in brackets and then we can list each one of the variables that we want to create.

```js
const [posts, repos, profile] = apiList;
```

So we'll have posts because this is an API to go grab posts. Then the next one is going to be repos. And the third one is going to be a GitHub profile. 

And what I can do here is instead of going and grabbing one of these I can just say I'm going to set each one of these equal to the API list. And what this is going to do is it's going to find the first element and it's going to assign it to post then it's going to find the second element it's going to assign it to repos. Then the third one is going to get assigned to profile. And so all of this is going to happen on a single line of javascript code. This is very powerful. 

I haven't seen this in many other programming languages. And so when I first saw it I was pretty excited because this is a process that I need to perform quite a bit when I'm working with arrays such as something like this. This is a real-life example and in later guides, we're actually going to work with this in even a more powerful way and see how we can connect to these API. And we're going to leverage this array deconstruction in order to do that. So now what I can do is call console.log posts, repos, and profile. 

```js
console.log(posts);
console.log(repos);
console.log(profile);
```

And then it's going to give us access to each one of these items.

So hit save run and now as you can see here on the console it went out and it grabbed that. So this is how you can leverage array destructuring for being able to access each one of the elements in an array and then assign it to a variable.

## Code

```js
const apiList = [
  'https://api.dailysmarty.com/posts',
  'https://api.github.com/users/jordanhudgens/repos',
  'https://api.github.com/users/jordanhudgens'
]

const [posts, repos, profile] = apiList;

console.log(posts);
console.log(repos);
console.log(profile);
```
