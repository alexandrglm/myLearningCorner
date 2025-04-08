# MODULE 04 - 057: JavaScript

# Modern JS (7): Passing Objects as Function Arguments by Leveraging Deconstruction

---



1. The `user` Object Example

2. Traditional vs. Destructured Parameters

3. Real-World Use Case

4. Syntax Requirements

5. Benefits

****

Object destructuring in function parameters is a powerful feature in modern JavaScript that helps clean up and simplify how you pass and handle objects in function calls.

****

### 1. The `user` Object Example

Imagine you're working with user data returned from an API. Instead of manually extracting each value, you can pass the full object to a function and destructure what you need directly in the parameter list.

```js
const user = {
  name: 'Kristine',
  email: 'kristine@devcamp.com'
};
```

****

### 2. Traditional vs. Destructured Parameters

**Without destructuring:**

```js
const renderUser = (user) => {
  console.log(`${user.name}: ${user.email}`);
};
```

**With destructuring (cleaner and more readable):**

```js
const renderUser = ({ name, email }) => {
  console.log(`${name}: ${email}`);
};

renderUser(user);
```

This approach eliminates the need to access properties inside the function body.

****

### 3. Real-World Use Case

This technique is common in frameworks like **React**, **Angular**, or when writing clean, modular code in **Node.js**.  


You'll often receive large objects from APIs, and destructuring allows you to grab only what you need in a lightweight, readable format.

---

### 5. Syntax Requirements

Be aware:

- The **keys** in the destructured parameters **must match** the actual object properties.

- If you attempt to use renamed or undefined keys like `n` instead of `name`, destructuring will fail.



YEP!:

```js
({ name, email }) => ...
```

NOPE!

```js
({ n, e }) => ... // Fails unless object has those exact keys
```

### Benefits

- **Cleaner function declarations**

- **Avoids redundancy** in accessing properties

- **Improves code readability**, especially in collaborative environments

- **Reduces parameter overload** in functions expecting complex data

****

## References

* [Destructuring - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Destructuring#function_parameters)

* https://javascript.info/destructuring-assignment#function-parameters-destructuring



---

## Video lesson Speech

Now that you know how to perform basic deconstruction in javascript and 
you know how to perform tasks such as being able to swap variable 
values. Now let's extend that knowledge, and we're going to see how we 
can perform deconstruction in using functions in javascript and more 
specifically how we can combine objects and functions, and have 
deconstruction connect those two for us.

****

So here is an example we're going to build out. So we're going to create an object here called user, and inside of this, we're going to have a few keys. One is going to be a name, and then we're going to have an email. 

![large](./04-057_IMG1.png)

The reason why I'm using this example is that I think this is very close to a real-world type of scenario. A time when you're going to use this type of deconstruction and what we're going to be talking about is when you may be performing a task such as querying some outside API. You might be given a user object like this with all kinds of different keys and values. In older versions of javascript what you'd have to do is you'd have to create some type of function, that could pull out each one of those values, you'd iterate over the keys, you'd grab the values you'd store them inside of other variables. Then you could pass that into the function you want to perform the task. But with modern versions of javascript what you can do is actually use deconstruction with the object. 

Right here I'm going to use the arrow syntax to create a function, and the function is going to be called render user. Inside of the argument, we're going to pass in an object. Now, this is very important when it comes to deconstruction. There may be times where you're building out types of functions, and you have arguments where the argument name doesn't matter. So if you had a name and an email you could do something like "N" and "E" that would be horrible naming. 

![large](./04-057_IMG2.png)

It would be difficult for people reading the code to see what you're talking about but it would still work in many cases. However, when it comes to deconstruction, it will not work. So the way that it operates inside of javascript is this type of key. So these keys have to be mapped exactly. So here, it does have to say "name", and it does have to say "email". What the function's going to look for when it's performing this deconstruction process, is it's going to run a check to see if it finds these types of attributes it finds these keys inside of the object that's being passed in. 

![large](./04-057_IMG3.png)

So now that we have that you use the arrow function and inside of the curly brackets we would just go to a console log. I am just going to say console.log and using string interpolation. Let's say that we have here the name and I just want a colon to separate that and the e-mail address. So here I'll say name and e-mail and that's it. 

![large](./04-057_IMG4.png)

The way that this is going to work is when we pass in the value instead of passing in user.name and user.email what we can do is pass in the entire object. Right here I can say just renderUser and then pass in the user itself. Right here what that's doing is it's passing in the entire object very similar to how it would work if you are working with an API or you're passing around objects, and now you don't have to worry about going in and explicitly typing in each set of values. 

![large](./04-057_IMG5.png)

This is a nice way of cleaning up the number of arguments that you're passing into a specific function call. Now I save this; this should print out the name and email. Now hitting run you can see it does, so we have our name right here. Followed by a colon followed by the e-mail address.

![large](./04-057_IMG6.png)

This is something you're going to see quite a bit out in the modern types of applications whether it be angular or react or these types of services anything that uses the latest versions of javascript. You're going to see this type of syntax, where you're going to see a function argument and you're going to see this list. But it's going to be wrapped inside of these curly braces and so whenever you see that you'll know that what it's looking for is instead of a variable being passed and looking for an object. And then you can simply pass in an object that has these matching keys and then from there you can access these, directly right side of the function body itself.

****

## Code

```js
const user = {
  name: 'Kristine',
  email: 'kristine@devcamp.com'
}

const renderUser = ({ name, email }) => {
  console.log(`${name}: ${email}`);
}

renderUser(user);
```

****

## Coding Exercise

You  need to check on your bank info but can't get the information to show 
up. Find the missing code and the one syntax error so the test can pass!

```js
const bank = {
  accountNum: 454812259,
  name: 'John Doe',
  balance: 1257
}

const bankInfo = ({accounNum,}) => {
  return (`Hi ${name}! Your current balance is $${balance}. Account#: ${accountNum}.`)
}

bankInfo(bank);
```
