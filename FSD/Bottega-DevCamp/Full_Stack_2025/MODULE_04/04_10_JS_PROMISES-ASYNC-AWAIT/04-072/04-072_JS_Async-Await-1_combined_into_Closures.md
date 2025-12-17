# MODULE 04 - 072:    JavaScript

## Async / Await (2), Combining Async / Await with Closures to Ensure All Processes Have Run

***

1. Understanding Parallel Execution
2. Closures and Async/Await
3. Code Walkthrough
4. Benefits of This Approach\*

***

### 1. Understanding Parallel Execution

In JavaScript, **asynchronous operations** (like API calls or timers) can run in parallel if initiated simultaneously.

* **Sequential Execution**: `await` pauses execution until a promise resolves (e.g., `await login()` waits 4 seconds, then `await updateAccount()` waits 2 seconds).
* **Parallel Execution**: Start both promises upfront, then `await` their results. Total time = max(4s, 2s) = 4s.

***

### 2. Closures and Async/Await

**Closures** allow functions to retain access to variables from their parent scope. In this example:

* `login()` and `updateAccount()` are called **immediately** when passed as arguments to `loginActivities()`, starting their timers.
* The async function `loginActivities()` uses `await` to wait for their results, but the promises run concurrently.

***

### 3. Code Walkthrough

#### Code Example

```js
const login = () => {  
  return new Promise((resolve) => {  
    setTimeout(() => resolve("User logged in..."), 4000);  
  });  
};  

const updateAccount = () => {  
  return new Promise((resolve) => {  
    setTimeout(() => resolve("Updating last login..."), 2000);  
  });  
};  

async function loginActivities(loginPromise, updatePromise) {  
  const loginResult = await loginPromise;  
  console.log(loginResult);  

  const updateResult = await updatePromise;  
  console.log(updateResult);  
}  

// Start both promises immediately  
loginActivities(login(), updateAccount());  
```

#### Key Steps:

1. **Promise Initialization**:
   * `login()` and `updateAccount()` are called when passed to `loginActivities()`, starting their timers immediately.
   * `login()`: 4-second timer.
   * `updateAccount()`: 2-second timer.
2. **Parallel Execution**:
   * Both timers run in parallel.
   * `updateAccount()` resolves after 2 seconds, but its result is awaited _after_ `login()` resolves.
3. **Output Timeline**:
   * At **4 seconds**: `login()` resolves → `"User logged in..."` logs.
   * At **4 seconds**: `updateAccount()` has already resolved → `"Updating last login..."` logs immediately.

***

### 4. Benefits of This Approach

1. **Faster Execution**: Total time = duration of the longest task (4s), not the sum (6s).
2. **Resource Efficiency**: Parallel execution optimizes CPU/network usage.
3. **Code Clarity**: Maintains sequential-looking code while enabling concurrency.

***

### 5. Best Practices

* **Closures** enable retaining access to promises initialized outside an async function.
* **Parallel Execution** reduces total time by running tasks concurrently.
* Use `Promise.all()` for explicit parallel workflows.

1.  **Use `Promise.all()` for Explicit Parallelism**:

    ```js
    async function loginActivities() {  
      const [loginResult, updateResult] = await Promise.all([login(), updateAccount()]);  
      console.log(loginResult, updateResult);  
    }  
    ```

    * Clearly signals parallel execution.
    * Returns results in the order promises are resolved.
2. **Avoid Implicit Dependencies**: Ensure parallel tasks are truly independent.

***

## References

* [Closures - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Closures)
* https://javascript.info/async-await
* [Callbacks 🆚 Promises en JavaScript. ¡Entiende las diferencias y la importancia de cada una! - YouTube](https://www.youtube.com/watch?v=frm0CHyeSbE)

***

## Video lesson Speech

In the last guide, you saw how we could leverage the async and await\
system inside of javascript to be able to dictate when we wanted\
processes to run so that we wouldn't have a case, for example where we\
updated an account before a user logged in.

***

Now if you remember back to that example. The\
way that it worked is it called each one of these processes as they were\
available so as the promise got resolved then it was called then the\
process ran then the next one ran and if we had five processes each one\
of them would have run in the console in sequence and many times that is\
exactly what you want to do.

However what happens if you have a full set of processes that you\
want to run and you don't want them to appear in this type of sequence\
you want them to all come back at the same time. For example, if you\
have loginActivities you don't want the returned login in this whole\
login process to occur for it to show up and then for the next one.\
Instead, you want to have all of these processes run and then you don't\
care about what shows up on the screen until they are all done. Now,\
this is a little bit different of an example but there are only a few\
changes you need to make to make something like that possible. And I'm\
going to run this one more time just so you can see what's going on.

It's going to run the login then two seconds later it's going to\
update the account. And what we're going to do now is we're going to\
build the system so that it will run these processes and it's still\
going to take the same amount of time. But what appears down in the\
console and in a real-world application that would appear on the screen\
would actually happen exactly at the same time instead of one happening\
and the other happening a few seconds later. The way we're going to do\
this is by leveraging closures and part of the reason why I wanted to\
make this into its own guide is because when it comes to learning\
javascript working with closures can be one of the more confusing parts\
of javascript development especially for new developers and I thought\
this was a great example of how closures could be used and will\
hopefully help you understand closures in general.

Remember that a closure is simply a function but it's a function that\
can be wrapped inside of a variable and then it can be passed into\
other functions. A good example would be instead of us just calling\
loginActivities and then calling each one of the activities we want such\
as login and update account what we're going to do is we're going to\
create arguments right here. So I'm going to say login this is going to\
be the first argument that needs to be passed down and then\
updateAccount.

Now the naming of these does not matter if I wanted to call this L\
then I could call it L and then I could simply call L right here.

```js
async function loginActivities(L, updateAccount) {
 const returnedLogin = await L;
 console.log(returnedLogin);
```

This is not the function itself. This is just an argument and then a\
reference to that argument. I'm going to keep it at login. But make sure\
to remove the parens after await login because now we're not treating\
this like a function anymore. Now we're just treating it like a normal\
argument that is passed in. So I'm going to remove both of the sets of\
parens. And now all I have to do is come down to loginActivities and\
pass in these arguments. Now when I'm passing these and I am passing in\
the actual function so I have to add parens here

```js
loginActivities(login(), updateAcount());
```

and now if you come up top you can see I'm calling this const login\
closure and this const updateAccount closure. So I'm calling these two\
functions. I'm wrapping them inside of arguments of login activities and\
then inside of that I'm simply referencing it. Now because they return\
promises I can treat them exactly the same so I can call await on both\
of these. But by leveraging them as closures instead of calling the\
functions directly what our async loginActivities function is going to\
do is it's going to wrap up the entire process and instead of waiting\
two seconds to run the first one and then two seconds to run the second\
one. It is not going to show anything on the screen until all the\
processes are complete. So if I hit save right here and then run you'll\
see that in four seconds both of the processes are going to occur at the\
same time.

```js
//"User logged in..."
//"Updating last login..."
```

Now behind the scenes, it's doing exactly what it did before. The\
only difference is that now it is actually going to it's going to wait\
until all of those processes have run before it shows anything.

And just in case you're curious to see if the whole sequential\
process of using await is truly working because maybe you think that the\
only reason why login is being called first is because it was listed\
first and it takes two seconds. But what happens if say login takes four\
seconds? So login takes four seconds update account still only takes\
two seconds.

If I clear this out and save. Let's see if it still shows in the same\
order. So if I hit run again this is now going to take six total\
seconds until anything gets done. But you can see the user is logging in\
and updating last login.

```js
// "User logged in..."
// "Updating last login..."
```

So this is kind of a refresher on the importance of using await\
inside of an async function is. Now we do not have to care how long a\
process is going to run. Now we can be confident that the order that we\
call a function just like we're doing right here. The order that we\
dictate is going to be the only thing that matters and it's not going to\
matter how long they take. So for example, if we moved the await and we\
didn't make this in async function and then we called login an\
updateAccount by themselves.

All that would matter is that the updateAccount process would occur\
first and that would be a problem because without some of the details\
from the login this would run into an error and so we wouldn't want that\
to happen. But by leveraging async and await and also by combining that\
with working with closures. Now we have the ability to control exactly\
when the processes are going to occur when the details are going to be\
returned and we're able to do it in a pretty easy to read manner.

## Code

```js
const login = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('User logged in...');
    }, 4000);
  });
}

const updateAccount = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      resolve('Updating last login...');
    }, 2000);
  });
}

async function loginActivities(login, updateAccount) {
  const returnedLogin = await login;
  console.log(returnedLogin);

  const returnedUpdateAccount = await updateAccount;
  console.log(returnedUpdateAccount);
}

loginActivities(login(), updateAccount());
```
