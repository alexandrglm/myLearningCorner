# MODULE 04 - 068:    JavaScript

## Promises (0), Introduction

***

1. What Are Promises?
2. Why Use Promises?
3. Promise States
4. Creating a Promise
5. Handling Outcomes: `.then()` and `.catch()`

***

### 1. What Are Promises?

A **Promise** in JavaScript is an object representing the eventual completion (or failure) of an **asynchronous operation**. It acts as a placeholder for a value that will be available later, allowing non-blocking code execution.

Promises are essential for:

* API calls.
* File I/O operations.
* Database queries.
* Any task with unpredictable completion time.

***

### 2. Why Use Promises?

Before Promises, asynchronous tasks relied on callbacks, leading to "callback hell" (deeply nested code). Promises:

* Simplify asynchronous code.
* Improve readability with chaining (`.then()`, `.catch()`).
* Provide structured error handling.

**Example**: Fetching data from an API without freezing the UI.

***

### 3. Promise States

A Promise has three states:

1. **Pending**: Initial state (not yet resolved or rejected).
2. **Fulfilled (Resolved)**: Operation completed successfully.
3. **Rejected**: Operation failed.

Once a Promise is resolved or rejected, it **cannot change state**.

***

### 4. Creating a Promise

Use the `Promise` constructor, which takes a function with `resolve` and `reject` parameters.

**Syntax**:

```js
const myPromise = new Promise((resolve, reject) => {  
  // Asynchronous logic here  
  if (success) resolve(result);  
  else reject(error);  
});  
```

**Example**: Simulating an API call with `setTimeout`:

```js
const sleepyGreeting = new Promise((resolve, reject) => {  
  setTimeout(() => {  
    resolve("Hello...");  
  }, 2000);  

  setTimeout(() => {  
    reject(Error("Too sleepy..."));  
  }, 2000);  
});  
```

_(Note: In practice, only one state (resolve/reject) is triggered based on conditions.)_

***

### 5. Handling Outcomes: `.then()` and `.catch()`

* **`.then()`**: Handles resolved Promises.
* **`.catch()`**: Handles rejected Promises.

**Example**:

```js
sleepyGreeting  
  .then((data) => {  
    console.log(data); // "Hello..." after 2 seconds  
  })  
  .catch((err) => {  
    console.error(err); // Error: "Too sleepy..."  
  });  
```

**Key Points**:

* `.then()` receives the resolved value.
* `.catch()` receives the error object.
* Promises can be chained for sequential operations.

***

### 6. Real-World Use Cases

1.  **API Requests**: Fetch data without blocking the UI.

    ```js
    fetch("https://api.example.com/data")  
      .then((response) => response.json())  
      .catch((error) => console.error("Fetch failed:", error));  
    ```
2. **File Uploads**: Handle upload success/failure
3. **User Authentication**: Manage login processes asynchronously.

***

### 7. Best Practices

* Promises manage asynchronous operations elegantly.
* Use `.then()` for success and `.catch()` for errors.
* Avoid blocking the main thread with asynchronous design.
* **Always Handle Errors**: Use `.catch()` to avoid unhandled promise rejections.
* **Avoid Nesting**: Chain `.then()` calls instead of nesting Promises.
* **Use `async/await`**: For cleaner syntax (builds on Promises).
* **Return Promises in Functions**: For reusability.

**NOPE!**:

```js
// Nested Promises (hard to read)  
getUser().then((user) => {  
  getPosts(user).then((posts) => {  
    console.log(posts);  
  });  
});  
```

**YEP!**:

```js
// Chained Promises  
getUser()  
  .then((user) => getPosts(user))  
  .then((posts) => console.log(posts));  
```

***

### References

* [Promise - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise)
* https://javascript.info/promise-basics
* [JavaScript Promises](https://www.w3schools.com/js/js_promise.asp)

***

## Video lesson Speech

In this module of the course, we're going to be walking through the\
concept of 'Promises' in javascript. Now if you've never worked with\
javascript promises the concept may seem a little bit foreign.

***

In this guide, I want to focus on taking a step back and being able to understand how promises work at a high level because that's going to help you understand how you can work with them in more complex situations.

One of the most common ways to use promises is when you're communicating with outside APIs. Let's take a use case, for example.

Imagine that I'm calling on the Twitter API and I want to get all of the posts. So I'm going to call an endpoint and I'm going to receive those posts back. Well, what happens if Twitter happens to be down? What would happen in my application is that a user would go to the page but then they would just see this buffering and it would have a pretty bad impact on the user experience. And so what a promise allows us to do. Is a promise would allow us to call the Twitter API show our page and then whenever the posts do arrive from the API then show the posts.

Now, this is one of the most common reasons why people like to use javascript is because of what's called its `asynchronous nature`. And that means that you can perform tasks like this where you can call outside services and these API's and you can pick and choose which elements on your page or in your application will load right away versus which ones may take a little bit longer.

That's the reason why `promises` are such a critical part of understanding javascript development because they deal specifically with the user experience.

Many years ago, back when I started developing and started building out PHP applications the way this flow would work, was that first scenario, I would call some type of outside service or a database. And then what would happen is if it was a slow query or if the API was a little bit slower than I was expecting then it would cause users to just have to sit there and watch the page load and that is a bad experience. We want to try to avoid that from occurring, so that's what we're going to get in with promises.

In this guide, it's going to be a dead simple "Hello world" type of example because promises are a little bit complex.

They definitely have a few moving pieces. And if you try to dive right into some more advanced examples then you might miss some of the most important components. So what we're going to do is we're going to create a greeting object here so I'm going to say let And we're going to call it sleepyGreeting. And the way you create a promise is you say new promise. So we're creating a new instance of this promise and we're storing it inside of sleepyGreeting. Now a promise takes two arguments. The first argument is going to be called resolve and the second one is going to be called reject.

```js
let sleepyGreeting = new Promise((resolve, reject))
```

and we're going to get into what these actually represent.

Another way in older versions of javascript the common convention was to use something like success and then failure or error or something like that.

```js
let sleepyGreeting = new Promise((success, failure))
```

But the most common convention now is to use resolve and reject. So that's what we're going to stick with and we'll walk through what those mean later on.

I'm going to use an arrow function and we're going to pass this in a code block now because we have these two arguments of resolve and reject.

```js
let sleepyGreeting = new Promise((resolve, reject) => {

})
```

What that means is that a promise is expected to either work or it's expected to have some kind of error or some kind of issue. And so what we're doing when we're building a promise is we're telling our program that you're going to get something back you're going to either get back the successful type of response so if you're communicating with an API you're going to get back that API data and then you can deal with it. Or if there's an error then we're going to give you an error back and we're going to be able to tell you how to deal with that. And so that's part of the reason why promises can be a little bit confusing to new developers is because they're very different than just building a standard method.

Typically when you're building a function or a class you don't spend a lot of your time having to figure out what happens if an error occurs. What a promise it does is it forces you to build the entire system and have a 50/50 split, where 50 percent of your time is spent building what happens if the situation works and the promise comes back and you get that response and then 50 percent of the time is going to be spent building what process you want to have happen if an error occurs. Getting that in your mindset is definitely a very important part of understanding how promises work.

So I'm going to create two setTimeout functions so I'm going to say set timeout and this is the reason why I'm calling sleepyGreeting because typically whenever you're creating a promise or you're working with promises. One of the rules is that your expectation is that whatever you get back is not going to happen immediately. It may take a few milliseconds or may even take a few seconds. And so by placing a setTimeout in here. What that allows us to do is to be able to manage that and kind of mimic what we would get if we were calling an API or something like that. Now, later on, we are going to get into that and you're going to see how all of that works in a real-world example. But for this specific guide, I want you to simply see all of the components that are needed. So setTimeout we're going to use an arrow function as usual in this one as well. And so here inside of setTimeout, I'm going to call resolve. So here I'm going to call resolve and anything inside of here is what is going to run if the sleepyGreeting promise is successful. So here I'm going to just say "Hello" because it's sleepy and then I'm going to pass this in with two seconds because what that means is that in 2000 milliseconds or two seconds then it's going to resolve this and it's going to return "Hello"

```js
let sleepyGreeting = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve('Hello....')
  }, 2000);
})
```

Now, that is if our promise is successful, if not I'm going to create what happens if it's not successful. So I'm going to hit copy and now I'm going to call another setTimeout here. But instead, of a resolve as you may guess we are going to build in what we want to happen if there's a rejection. But I'm not going to simply return the string right here. Instead, I'm going to return an error so I'm going say Error with a capital E because this is an actual module inside a javascript. An error takes a function and what we can do here is pass in wherever we want. So any type of content or any details if this were an API it may say something like the API is not responding or whatever it is that we want to add so that whenever we call this promise we'll know how to manage it. So here I'm just going to say 'Too sleepy...' and that's all we need to do and this is our entire promise right here.

```js
let sleepyGreeting = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve('Hello....')
  }, 2000);

  setTimeout(() => {
    reject(Error('Too sleepy...'))
  }, 2000);
});
```

So we've created a promise and we've set up two scenarios. We've set up the scenario in the first item, where it was successful where the promise comes back and everything worked properly and we said this is what we want to happen if it is successful if it resolves to be proper. Now I also set up a reject and reject is this second item. The second alternative where say the API didn't work then we're going to pass and reject and then it is going to throw this error.

Now that we have the blueprint for our promise set up now we can actually call this. I can just call sleepyGreeting just like I would a function. I can say sleepyGreeting and the common convention you can obviously put this on one line and do something like this. But the common convention whenever you're working with promises because they can become very complex is to put them on multiple lines so I can say sleepyGreeting add some indentation and then say `.then` and `.then` is a reserved word and it's something that a promise expects.

Then inside of this, I'm going to say data, give it an arrow function with a code block. And here I can say console log data and then that's all we need to do for the .then

```js
sleepyGreeting
  .then(data => {
    console.log(data);
  })
```

Now let's stop right here because this was a decent amount of code and a number of these things and these concepts are pretty important.

I want you to realize what's going on. The way that promises work is you saw how it expects the success and the failures to potential outcomes. But then when you call that promise, what it expects is for you to call the promises it's self and then pass in the keyword `.then` because what this is saying, and this is written in a very specific way so that you could read it as close to natural language as possible because what we are essentially saying is when you call sleepyGreeting what happens when you get the response back is, I want you to `.then` do everything inside of this code block.

`.then` gets access to `data` and `data` is a specific type of element. We are not just making this up. What `data` is whenever this promise comes back. So imagine it's calling in API what gets returned would be the `data` in this case the `data` is just our 'Hello' string. But it also could be a set of json post requests or tweets or whatever you're doing when you're calling this. So .then is something very special we're not just adding it and hard coding it in there. We're saying that I am expecting when I call .then to get access to the data and then in this case we're just going to console log it.

Now, this is what happens if everything goes right. So if your API call goes right then it's going to get all of the data and then we have access to it. Now that we have .then the other thing that we need to do is build in what's called a .catch. Now .catch speaks directly to reject. So .catch is mapped to reject just like .then is mapped to resolve. So what I can do is put .catch on a new line. And I'm going to say .catch and it's going to try to catch the error so I'm going to do another arrow function and inside of this, I'll say console.error in this case and pass in the error, and then this is it. This is how you can call a promise.

```js
let sleepyGreeting = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve('Hello....')
  }, 2000);

  setTimeout(() => {
    reject(Error('Too sleepy...'))
  }, 2000);
});

sleepyGreeting
  .then(data => {
    console.log(data);
  })
  .catch(err => {
    console.error(err);
  });
```

We have the promise name followed by .then followed by whatever we want to do with the data received back from the promise and then we have our .catch which is this is going to catch the error. We're going to have access to the error. So what data is to .then error is to .catch and then we're just going to console log out that error. So with all of that in place let's save and let's see if all of this is working.

I'm going to hit run and it should take two seconds and it should give us back our Hello. And there you go.

![small](../../../../../../.gitbook/assets/04-068_IMG1.png)

So this is working.

All of this is set up properly so this is kind of your base skeleton. Now, we're not going to be able to error out sleepyGreeting just because it doesn't have any outside dependencies. All it's doing is simply being called, what I can do though is if I comment the resolved section out this will mimic what would happen if we did have an error such as some type of error calling an API or whatever a promise is expecting.

Now if I hit run again what's going to happen is it's going to go two seconds and then just like this. It gives us our object error.

![small](../../../../../../.gitbook/assets/04-068_IMG2.png)

So what happened is it called sleepyGreeting it did it's setTimeout and it called the reject because it couldn't find to resolve.

That's the expected behavior of the way a promise works. If you do not pass in the situation you want to occur when we have a resolve or a successful type of situation. Then reject gets called by default so this worked because it looked for the reject call it looked inside of setTimeout. It waited two seconds and then it passed in the error. So everything is working as it should.

To review this is a dead simple kind of promise.

A promise gives us the ability to make an outside API call and really do any kinda task where we should not have an expectation of the task occurring in real-time. So if we're building some type of system or some type of feature where we do not have an expectation of whatever we're doing happening right away such as making a database query or an outside API call then what we can do is utilize a promise and part of the reason why I wanted to have a dedicated guide to a very simplified version of this is because when it comes to javascript development one of the most important tasks that you're going to be doing is communicating with outside services.

Javascript's nature is built around communicating with outside services whether they're databases backend APIs or anything else that sits outside of the application. All of the different frameworks such as react, angular, view each one of these javascript frameworks gets its data from communicating with outside services. And so since utilizing tools such as `promises` are the linchpin in being able to make sure that that process happens as smoothly as possible.

It's definitely important to be able to take a step back and understand how a `promise` works and see exactly what types of components it needs in order to function properly.

## Code

```js
let sleepyGreeting = new Promise((resolve, reject) => {
  setTimeout(() => {
    resolve('Hello....')
  }, 2000);

  setTimeout(() => {
    reject(Error('Too sleepy...'))
  }, 2000);
});

sleepyGreeting
  .then(data => {
    console.log(data);
  })
  .catch(err => {
    console.error(err);
  });
```
