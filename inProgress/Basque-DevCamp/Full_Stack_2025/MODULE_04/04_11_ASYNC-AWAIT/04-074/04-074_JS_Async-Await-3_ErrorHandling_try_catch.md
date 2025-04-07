# MODULE 04 - 074:    JavaScript

## Async / Await (3), Implementing Error Handling Async / Await

---

---

## Video lesson Speech

In the last guide, we saw how we could leverage the async and await 
process inside a javascript to be able to control when APIs can be 
called.

****

Now this works great assuming that these APIs will work 100 percent of the time. However that is rarely the case, it's very important to be able to set up a process for what you want to happen when an API fails. That could be as simple as simply logging to the user and letting them know that there is an issue. 

Say that you wanted to render someone's Instagram photos inside of a profile page. If there is an error with Instagram or there are some delays with their API you want to place a little spot on the page that says there was an error contacting Instagram and then it may try again at a certain point in time. What we want to do here is see how we can leverage the same process. 

Now if you followed along with all of the promise guides you know how you can have a `.then` combined with a `.catch`. However, if you're working with multiple promises and you're combining that with await then you really should be implementing a different type of way of catching those errors. 

I'm going to show you two different ways that we can do it by leveraging try and catch blocks. So the easiest way would be to simply say try and then you could wrap this entire set of promise calls inside of a try and catch block so I could come here and then say catch will catch the error and then I need to wrap this up properly. And so now what we can do is catch the error and we can do something like console.logging it in a real-life application you would most likely add this to an error log so that you could reference it later.

Now if we perform some type of error such as calling this API that it needs to be over https and say HTTP then this is going to give us our error and it's going to console.log it so I can run and you can see that we have an error that says failed to fetch. Now one issue with this is right now the entire process is going to halt if it runs into an error. So if I run https and call this here and save it run again then you're going to see that this time it returned the post and the error itself doesn't really tell us what happened it says that it failed to fetch. But if say that you had 10 different APIs that you were querying here you don't know which one failed and so that's something that is important to know. So what we can do is actually have multiple try catch blocks. 

So here I can say try and then I can catch this here pass in an error that's required for the catch method and now I can console log the error but I can also be more specific so I can console a log and say there was an error with the daily smarty API. 

```js
try {
    const reposPromise = fetch('https://api.github.com/users/jordanhudgens/repos');
    const repos = await reposPromise.then(res => res.json());
    console.log(repos);
  } catch(err) {
    console.log(err);
    console.log('There was an error with the DailySmarty API');
  }
}
```

And now we can go and replicate the same thing so I can say try and right here we'll wrap this up and instead of just printing out the error then we can print out the error right below this and instead of daily smarty we'll say GitHub

```js
try {
    const reposPromise = fetch('https://api.github.com/users/jordanhudgens/repos');
    const repos = await reposPromise.then(res => res.json());
    console.log(repos);
  } catch(err) {
    console.log(err);
    console.log('There was an error with the GitHub API');
  }
}
```

Now what we can do is hit clear and now we have two different try catch blocks and now we'll have much more information if there is a problem. 

So here with the GitHub one, we should have information to know which API is causing the issue. So if I hit run you can see that we get our post back so that's good. Then we get our error and then it says there was an error with the GitHub API. So that tells us much more information than before and now if I go and I switch the error so that it's on the daily smarty side hit save and run.

Now we're going to get an error that says there was an error with the daily smarty API but we still get all of our repos from GitHub. And so this is a way that you can wrap up each individual promise inside of a function. 

Now when it comes to understanding when you would want to do this versus wrapping all of the processes up. My rule of thumb is if you want to have the entire process stop once it runs into an error and not continue with any of the ones further down. Take for example if you have promises that are connected. So in other words, if this was an authentication promise for GitHub then you wouldn't want to wrap them up individually. You'd want to have them all inside of a single try catch because you don't want any of those future promises to even be attempted once an error has occurred.

In this kind of situation where we're contacting two different API's then if this one fails we may still want this one to process and so that's when you would wrap it up like this. It's just a couple different ways that you can do that and this is kind of a standard industry way for catching errors when you're working with an async and await type of promise situation. 

****

## Code

```js
async function queryApis() {
    try {
        const postsPromise = fetch('http://api.dailysmarty.com/posts');
        const posts = await postsPromise.then(res => res.json());
        console.log(posts);

    } catch(err) {
        console.log(err);
        console.log('There was an error with the DailySmarty API');
    }

    try {
        const reposPromise = fetch('https://api.github.com/users/jordanhudgens/repos');
        const repos = await reposPromise.then(res => res.json());
        console.log(repos);
    } catch(err) {
        console.log(err);
        console.log('There was an error with the GitHub API');
    }

}

queryApis();
```
