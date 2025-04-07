# MODULE 04 - 073:    JavaScript

## Async / Await (2), Using Async / Await for Communicating with Outside APIs

---

---

## Video lesson Speech

This is going to be a really fun guide because in this one we're going 
to learn how we can leverage our new knowledge of async and await to be 
able to work with real API's.

****

## NOTICE !

### Dailysmarty is currently not accessible.

### You may use any free access API for this project to see the functionality.

### We recommend [https://jsonplaceholder.typicode.com/](https://jsonplaceholder.typicode.com/).

### Instructions for usage: [JSONPlaceholder - Guide](https://jsonplaceholder.typicode.com/guide/)

****

We're going to work with multiple APIs and see how we can control when the data gets sent back to us and specifically the order that the APIs are called and the two pieces we're going to be dealing with are going to be the daily smarty posts API and then the GitHub API.

Now I'm using mine which you can see my username right here. Feel free to use your own so that you can be pulling in your own set of repos. But this is what we're going to be calling and combining in our guide. 

So I'm going to just put these up as comments just so we can reference them and we're going to start by building an asynchronous function.

And if you remember the way we do that is we start off by saying async and then give it a function declaration. I'm going to call this one queryApis, it's not going to take in any arguments and now we're going to build our promises and we're going to leverage the `fetch` method in order to do that so I can simply say const posts promise and then this is going to go out and it's going to fetch the API and so we're going to have it fetch the daily smart one first and then that is all we need to do for the promise. 

```js
async function queryApis() {
  const postsPromise = fetch('https://api.dailysmarty.com/posts');
}
```

And if you remember that is simply going to return a promise that it's going to go and resolve this post API. But we still need to call `.then` we need to convert it to `json` because we're working with the `json` data type. And for that, that's where we're going to call our await function. So here I'm going to create another variable and say const posts equals await and then I can just copy our post promise right here and then call `.then` and then we're going to pass a function to `.then` and because we want to tell the promise exactly what we want to do with it and in this case I simply want to say res which is short for response give it an arrow function and then say res.json and that is a function we'll call it with parens and that's all we need to do. 

```js
async function queryApis() {
  const postsPromise = fetch('https://api.dailysmarty.com/posts');
  const posts = await postsPromise.then(res => res.json());
}
```

So now if I want to say console log posts and if I save this and run this then this should all work and it should go grab us our posts. 

Now I suppose it would be helpful to actually call the function. So make sure you call that. 

```js
async function queryApis() {
  const postsPromise = fetch('https://api.dailysmarty.com/posts');
  const posts = await postsPromise.then(res => res.json());
  console.log(posts);
}
```

And now hit save. Run it again.

It's going to go pull out our posts from the daily smarty API you can see each one of the most recent posts so all of that is working. Now, as nice as that is async and await really shine when working with multiple promises and so that's a reason why we're going to be working with two APIs in this guide.

I'm going to hit copy on all of this and now we're going to be working with our set of git repos. So here instead of post promise, I'm going to call this repos promise. And then it's going to `fetch` everything from the GitHub repo and then here instead of posts we'll just say repos and everything else should be able to stay the same.

```js
const reposPromise = fetch('https://api.github.com/users/jordanhudgens/repos');
  const repos = await reposPromise.then(res => res.json());
  console.log(repos);
}
```

We're going to hit clear on the console hit save and if all of this works what should happen is our API post should be brought back from daily smarty and then and only after then it should go out and contact GitHub and then return the list of repos and now if I come up and hit run then it's going to go out and it did exactly what we hoped it would do. It brought back our daily smarty posts right here we can see each one of those then it brought back all of the posts. 

Now the cool thing about this is no matter how many times we run this and even if the daily smarty API is running slow for a few minutes and the GitHub one is running really fast it's still going to give these back to us in this specific order because we've wrapped this entire process up in the async and then we call await on each one of these promises. 

Where this becomes very powerful is when we're working with data and we don't know when the return value is going to come back such as with APIs or database connections. And if you imagine a situation where this entire process revolved around the first promise being something say where we are authenticating with GitHub so say we're sending our login credentials to GitHub and then each one of the other API calls requires those login credentials. Then this type of process is absolutely necessary because we wouldn't be able to make the next few API calls if the first one hadn't already gone through and so that is part of the reason why using these kinds of tools like async and await have become so popular in the javascript community because we're able to control this. 

If I run this a few more times you'll see on the bottom right there every single time we run it we always get our posts first and then we get our repo's second which is exactly what we want to do. So very nice if you went through this you now know how to use async and await and combine that with communicating with outside APIs. 

In the next guide, we're going to see how we can leverage a try and catch block inside of this to be able to see what happens when an error occurs with one of the API calls. 

## Code

```js
async function queryApis() {
  const postsPromise = fetch('https://api.dailysmarty.com/posts');
  const posts = await postsPromise.then(res => res.json());
  console.log(posts);

  const reposPromise = fetch('https://api.github.com/users/jordanhudgens/repos');
  const repos = await reposPromise.then(res => res.json());
  console.log(repos);
}

queryApis();
```
