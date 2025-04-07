# MODULE 04 - 071:    JavaScript

## Async / Await (0), Introduction

---

---

## Video lesson Speech

I'm really excited that we're in this section of the course because in 
this course we're going to get into one of the biggest advantages to 
working with modern javascript compared with older versions. In this 
section we're going to be discussing the async and await processes 
inside of javascript.

****

Now before we get into that and in this guide, we're going to take an introductory view of how we can work with them and then later on we're going to get into more complex examples.  

But before we can do this I think it's important to take a little bit of time to go back into history and see why async and await have been so widely accepted by the javascript community and it's because they solve a very important problem that javascript developers have been having to deal with for years and that is the callback hell kind of problem. 

So if you have never heard of that concept you can google it and find out all of the details along with a number of examples. But essentially what callback hell is, it's a process that you had to implement in order to build out complex processes where you wanted it to dictate when one workflow would happen compared with another one. 

To take a good example let's say that we have a user who logs in. So we're going to say a user logs into the system and when that happens we want a number of tasks to occur.

The first thing is we need to verify credentials then if that works then what we want to do is we want to actually redirect them to the right page say to the dashboard page then we need to update the database account and let the database know that this user is logged in.

Then after that, they're going to check and say make a few API calls to bring in user data, etc. Now what typically would happen is this would go on for a very long time because of the way that javascript works and how it is asynchronous by nature. What you had to do is you had to build all of these nested callbacks and some of these get very complex because you couldn't have the API calls to bring the user data in till you had each one of these other items that had processed first.

And so what you essentially had to do was hardcode every potential process that was going to occur to make sure that it didn't happen too early and it didn't happen out of order. So each one of these processes needed to be built into the system to make sure that it was not going to happen before it's time. 

Now promises allow us to control that a little bit better. So if you went through the promise section you have been able to see how you can call a promise then you can call `.then` on it, you can even call nested promises inside of those `.then`s. And so that was a good step in the right direction. However, a number of javascript developers started noticing that even their promises started to get very messy and they were essentially using promises in the same way that they use these old callbacks and so they had promises that started to look like this. And so what async and await allow us to do is to dictate this entire process in a much more efficient format. 

That's where we're going to get into and we're going to mimic a real-world example we're not going to go into all of the details of each one of these but we're going to mimic what happens when you log a user into the system and we're going to use promises and combine those with async and await. So I mean you start off by creating a const variable called login and this is going to store a function I'll have it store an arrow function.

It won't take any arguments and inside of this, we're going to return a promise. I'm going to say return new promise and this is going to take a resolve and reject argument. And so inside of that, we're going to put everything that we want to run. 

```js
const login = () => {
  return new Promise((resolve, reject) => {

  })
}
```

Now I want to have a timer in this because I want to mimic a type of process that doesn't happen right away. So we're going to have the login take two seconds and so in order to do that you say setTimeout and then inside of this I'm going to pass in a function that I want to occur and I'm using arrow functions for all of these. And then inside of this we'll just return our resolve and I'm just going to return a string that says 'User logged in...' In a real-world example, this would communicate with the database and return that user data. So I'll close that off and since this is setTimeout then we need to pass in a second argument of 2000 milliseconds and that's how long I want it to pause before it runs. And so this is our login function here. So it's going to return a promise and I'm not going to worry about putting the reject in here because we're not going to run into any rejects, later on, I'm going to show you how to implement that. But that's going to be in a more complex example dealing with API. For right now I simply want to show you a base case for how to work with async and await. So this is our login process.

Now I'm going to now say that one thing that we want to do after a user is logged in is we want to update their account. So here I'm going to say update account and then inside the string everything else will stay the same. I'll say 'Updating last login' and that is our update account function. 

```js
const login = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('User logged in...');
    }, 2000);
  });
}
```

Obviously, in a real-world example, this would communicate with a database or an API and let the system know what user called and logged in. And then it would update their account. 

Now if you can see that both of these items are they need to happen in a sequential manner. So imagine a scenario where update account occurs before the login it's going to cause an error because you need to be able to pass in the login details and verify that the user has logged in, appropriately. In order to update the account so this is a great example of a process where async and await are very helpful because we can now dictate the order that these items are going to occur. If we simply called both of them then whatever one happened the fastest would be the one that would return first. And so if update account happened faster then we would run into an error and that's a reason why we need the async and await.

Now the way that you can do this is you're going to create a function and you start off with the word async and you simply do that rate before the function declarations you say async function and we'll call this loginActivities and it's just a normal function and inside of it, I'm going to store a variable so I'm going to say const returnedLogin and inside of this I'll say await log in. So what this is doing is this is going to call the login function the same one that we have right up here and then it is going to because it works with the promise by prepending await right here what it's going to do is it's going to say I do not want anything else to occur until this process has completed once it's completed we're going to store whatever got returned right into this returned login. So, in this case, it's going to be user logged in the text but in a real-world example. It would return the user credentials, their name, and those kinds of things. 

So just to make sure that this one will work I'll do console.log and then returnedLogin.

And let's just make sure that this part of it is working so far before we add the updateAccount. So if I had run it's going to wait about two seconds then print in the console. Here we have it the "User logged in..."

```js
async function loginActivities() {
  const returnedLogin = await login();
  console.log(returnedLogin);
}

loginActivities():    // "User logged in..."
```

Everything is working properly. Now let's go and let's do the same thing for our update account. So I'm going to create something that says returned update account. It's going to have an await and now I can call updateAccount. So it's going to say await updateAccount and then let's console.log this. Now if all of this works properly what this is going to do is it's going to create a workflow where we've now dictated when each one of these processes will occur. Now if you go and you look at some of the examples of callback hell you will see all kinds of crazy nested javascript code that's incredibly difficult to read and very bug-ridden. And what you'll see here and what you'll see with code that uses await and async is we've now been able to simply declare a list of when we want each one of these processes to occur in the order we want them to occur. If you're coming from other programming languages such as Ruby or Java or those kinds of languages this may not seem like a very big deal because that's the way that those languages work by default. But with javascript and its asynchronous nature the order in which functions are called and returned especially asynchronous functions that perform tasks that take a few seconds or even longer than that kind of process actually gets a little bit convoluted. And so that's the whole need. That's a reason why it's needed to have this async and await function.

Now let's hit save and make sure it works. What should happen is the login should occur. And then two seconds later update account should occur. And that's as you can see in the console that is exactly what happened. 

So this is an introduction to how you can implement async and await in javascript.

## Code

```js
const login = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('User logged in...');
    }, 2000);
  });
}

const updateAccount = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('Updating last login...');
    }, 2000);
  });
}

async function loginActivities() {
  const returnedLogin = await login();
  console.log(returnedLogin);

  const returnedUpdateAccount = await updateAccount();
  console.log(returnedUpdateAccount);
}

loginActivities();
```
