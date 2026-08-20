# MODULE 04 - 070:    JavaScript

## Promises (2), Grouping Promises using `promise.all`

***

1. Introduction to `Promise.all`
2. How `Promise.all` Works
3. Error Handling with `Promise.all`
4. Use Cases

***

### 1. Introduction to `Promise.all`

`Promise.all` is a method that groups multiple promises into a single promise. It resolves when **all input promises resolve** or rejects immediately if **any promise rejects**.

**Why Use It?**

* Execute asynchronous tasks in parallel.
* Simplify code by handling multiple promises as a single unit.
* Maintain order of results corresponding to input promises.

***

### 2. How `Promise.all` Works

#### Syntax:

```js
Promise.all([promise1, promise2, ...])  
  .then(results => /* process results */)  
  .catch(error => /* handle error */);  
```

**Example**

```js
const greeting = new Promise((resolve) => resolve("Hi there"));  
const updateAccount = new Promise((resolve) => resolve("Updating login..."));  

Promise.all([greeting, updateAccount])  
  .then(results => {  
    results.forEach(activity => console.log(activity));  
    // Output: "Hi there", "Updating login..."  
  });  
```

**Key Behavior**:

* Returns an **array of resolved values** in the same order as input promises.
* If **all promises resolve**, `.then()` receives the array.
* If **any promise rejects**, `.catch()` triggers immediately with the first error.

***

### 3. Error Handling with `Promise.all`

#### Rejection Scenario:

```js
const greeting = new Promise((resolve, reject) => reject("Oops!"));  
const updateAccount = new Promise((resolve) => resolve("Updated"));  

Promise.all([greeting, updateAccount])  
  .catch(err => console.error(err)); // Output: "Oops!"  
```

**Important Notes**:

* A single rejection skips all other promises and triggers `.catch()`.
* Avoid calling both `resolve` and `reject` in the same promise (only the first call takes effect).

***

### 4. Use Cases

1.  **Parallel API Calls**:

    ```js
    const userPromise = fetch("/api/user");  
    const postsPromise = fetch("/api/posts");  

    Promise.all([userPromise, postsPromise])  
      .then(([userData, postsData]) => renderUI(userData, postsData));  
    ```
2. **Database Transactions**: Update multiple records atomically.
3. **Aggregating Data**: Combine results from independent asynchronous operations.

***

### Best Practices

* Use `Promise.all` to handle multiple asynchronous tasks in parallel.
* Results are ordered and aggregated into an array.
* A single rejection causes the entire group to fail—plan error handling carefully.
* Ideal for independent operations like API calls or database queries.

1. **Independent Promises**: Use `Promise.all` only for promises that don’t depend on each other.
2. **Order Preservation**: Results array order matches input promises.
3. **Error Handling**: Always include `.catch()` to avoid unhandled rejections.
4. **Avoid Side Effects**: Ensure individual promises don’t modify shared state.

**Anti-Pattern**:

```js
// Avoid nesting promises unnecessarily  
promise1.then(result1 => {  
  promise2.then(result2 => {  
    // ...  
  });  
});  
```

**Better Approach**:

```js
Promise.all([promise1, promise2])  
  .then(([result1, result2]) => {  
    // Process results together  
  });  
```

***

### References

* [Promise.all() - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Promise/all)
* https://javascript.info/promise-api
* [JavaScript Promises](https://www.w3schools.com/js/js_promise.asp)

***

## Video lesson Speech

So far in this section of the course, we've analyzed how we can work\
with promises and Javascript. We've seen how we can create a promise\
from scratch and how we can implement a resolve and a reject function to\
see exactly what we want to do when a promise succeeds versus when it\
fails.

***

We've also analyzed how we can work with different functions that return promises such as `fetch` which gives us the ability to connect to outside APIs.

Now in this guide we're going to focus on how we can group promises together. This is a common pattern that you'll see where you have various promises that are very similar. And when that's the case we can actually put those together and then treat them as a group of promises and we can do this using a term called `Promise all`.

So I'm going to build a couple promises here.

One's going to be const greeting and so I'm going to say new promise. `const greeting = new Promise(())` And as always we're going to add a resolve and a reject and we're going to use an arrow function and inside of it I'm just going to return a few different strings so if it works we're going to say hi there and then I'll add a semicolon at the end and then if it doesn't work we're going to say oops bad greeting. And that is going to be our first promise.

```js
const greeting = new Promise((resolve, reject) =>{
  resolve('Hi there');
  reject('Oops, bad greeting');
});
```

Then the next one I'm just going to copy and paste this and this one is going to just say update account. So new promise everything is the same. And here we're going to say updating log in and then for the reject were going to say something like error updating an account with login.

```js
const updateAccount = new Promise((resolve, reject) => {
  resolve('Updating last login...');
  reject('Error updating account with login.');
});
```

So what I'm trying to mimic here is a number of different processes that you might do if you're building a web or a mobile application where you want to render out a greeting to a user. But whenever they log in you also want to update their account and let the system know that that user has logged in. So both of these processes are going to need to run every time a user logs into the system. And so because of that, it makes sense to treat them the same. So instead of calling update account and then adding a `.then` and then a `.catch` and all of those processes what we can do is leverage `promise all` so that we can treat it the same. And then we can just loop over these.

So on the next line say const loginActivities and then I'm going to set this equal to Promise.all and pass in an array of promises. So I'm going to say a greeting and then updateAccount.

```js
const loginActivities = Promise.all([greeting, updateAccount]);
```

And now if I try to log this out let's see what we get. So I'm going to say console.log(loginActivities) I'll save and run. And what we get is just a promise back so we don't get our resolve or anything.

```js
const loginActivities = Promise.all([greeting, updateAccount]);
console.log(loginActivitites);  // [object Promise] {}
```

And if you're wondering why it's because we need to treat this as a set of promises and so because of that, that means that we are going to have to iterate over this because it's an array. And then from there, we're going to use our `.then` call to be able to call it and see exactly what we want to do.

So let's clear the console out and now I'm going to get rid of this console.log statement and I'm going to say loginActivities and I can call `.then` directly on it.

And if you're wondering how we can do that it's because `promise all` as you saw when I console logged this out it returns a promise itself.

Now it's a different type of promise because it has multiple promises inside of it and that's an important kind of idea to remember. But you can call `.then` directly on this.

Technically we could have chained it on to the end of the const loginActivities statement. But I'm just putting it here on its own line so that you can see how it works and it's a little bit easier to read so I'm going say `.then` and I'll say res and that's just short for response. And here I'm going to be able to use an arrow function so we're going to say loginActivities.then

```js
loginActivities.then(res => {

})
```

because it's returning a promise that's going to return the data of that promise so it's going to go out. It's going to check for each one of these resolves statements and assuming that these are working properly which these ones will because they're just returning a string. But if this was contacting a database or performing a greeting via an API or anything like that then it may fail or it may work.

What this is going to allow us to do is to manage that process properly. So now we're going to get back the response of that promise and then that response is going to have a collection. And so let's just test this out really quick so I can say console.log(res); and now if I save and run this then you'll see that we get back both of our responses.

```js
//["Hi there", "Updating login..."]
```

So this is going to return an array of the resolves if one of these had failed it would return an array resolve and then reject. In this case, both of them are passing so we're getting both of those back. So far so good. But we're not done yet because I want each one of these and I want to be able to treat them individually.

So what I can do is say res and then just call forEach on this activity and then pass that an arrow function. And now I can access that directly so I can say console log activity.

```js
loginActivities.then(res => {
  res.forEach(activity => {
    console.log(activity);
  })
})
```

And now if I hit save and I run this.

You can see it prints out both of those elements it prints out the greeting and the update accounts so both those promises worked. And we were able to iterate over them.

Now if you're unfamiliar with what we're doing here forEach gives us the ability to iterate over an array. We know that res here the response and that is the data we get back when we call .then on the promise res is going to contain an array so we can simply call the forEach function on it. It'll iterate over, activity is the iteration variable so this is going to be the activity for greeting the first time through. And then it will be the activity for update account the second time through. And then we just console log it in a real application whether it be a re-act application or angular or Ionic. Then you would probably render this on a screen or contact a database anything like that. But this is a way where you can group promises together by leveraging promise all so that you can make your code more efficient and easier to read.

***

## Code

```js
const greeting = new Promise((resolve, reject) =>{
  resolve('Hi there');
  reject('Oops, bad greeting');
});

const updateAccount = new Promise((resolve, reject) => {
  resolve('Updating last login...');
  reject('Error updating account with login.');
});

const loginActivities = Promise.all([greeting, updateAccount]);

loginActivities.then(res => {
  res.forEach(activity => {
    console.log(activity);
  })
})
```
