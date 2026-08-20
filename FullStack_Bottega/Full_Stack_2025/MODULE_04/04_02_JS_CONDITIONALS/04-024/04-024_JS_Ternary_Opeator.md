# 04-024\_JS\_Ternary\_Opeator

## MODULE 04 - 024: JavaScript

### Conditions (4) - Ternary Operator (Elvis)

***

1. Introduction to Ternary Operator
2. Basic Ternary Syntax
3. Ternary vs If/Else Comparison
4. Nested Ternary Operators

***

The **ternary operator** (also called the conditional operator) is a concise way to write conditional statements in JavaScript. It provides a shorthand syntax for simple `if/else` decisions, especially useful when you need to:

* Return values conditionally
* Assign values based on conditions
* Embed conditional logic in JSX/React components

While traditional `if/else` statements are more readable for complex logic, ternary operators excel at simplifying straightforward conditional operations into a single line.

***

### 1. Basic Ternary Syntax

The ternary operator follows this structure:

```js
condition ? expressionIfTrue : expressionIfFalse
```

Example:

```js
let age = 20;
let canVote = age >= 18 ? 'Yes' : 'No';
console.log(canVote); // Output: 'Yes'
```

* **Condition**: The expression to evaluate
* **?** : Separates condition from possible outcomes
* **First expression**: Executes if condition is truthy
* **:** : Separates true/false outcomes
* **Second expression**: Executes if condition is falsy

***

### 2. Ternary vs If/Else Comparison

Traditional if/else:

```js
function ageVerification(age) {
    if (age > 25) {
        return 'can rent a car';
    } else {
        return "can't rent a car";
    }
}
```

Equivalent ternary:

```js
function ageVerification(age) {
    return age > 25 ? 'can rent a car' : "can't rent a car";
}
```

Benefits of ternary:

* More concise (single line)
* Can be used in return statements
* Works in JSX/React templates
* Avoids multiple code blocks

***

### 3. Practical Use Cases

#### React/JSX Conditional Rendering

```js
<div className={isActive ? 'active' : 'inactive'}></div>
```

#### Conditional Value Assignment

```js
const discount = isMember ? 0.1 : 0;
```

#### Return Different Values

```js
function getFee(isMember) {
    return isMember ? '$2.00' : '$10.00';
}
```

***

### 4. Nested Ternary Operators (Advanced)

While possible, nested ternaries can reduce readability:

```js
let response = user 
    ? user.admin ? "showing admin controls" : "Need admin rights"
    : "Please log in";
```

Alternative with parentheses for clarity:

```js
let response = user 
    ? (user.admin ? "showing admin controls" : "Need admin rights")
    : "Please log in";
```

**Recommendations:**

* Limit nesting depth
* Consider traditional if/else for complex logic
* Use clear formatting when nesting is necessary

***

### Best Practices

1. **Keep it simple**: Use for straightforward true/false conditions
2. **Avoid deep nesting**: More than 2 levels hurts readability
3. **Use parentheses**: For clarity with nested ternaries
4. **Consider alternatives**: For complex logic, if/else or switch may be better
5. **Be consistent**: Follow team/style guide conventions

***

### Resources

* [MDN: Conditional (ternary) Operator](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/Conditional_Operator)
* [W3Schools: JavaScript Ternary Operator](https://www.w3schools.com/js/js_comparisons.asp)
* [JavaScript.info: Conditional Branching](https://javascript.info/ifelse#conditional-operator)

***

##

***

### Video lesson Speech

Let's walk through the code for the ternary operator, and we're first\
going to start off by looking at why the ternary operator in JavaScript\
is necessary.

***

The reason why I'm going with this approach is because I've seen through the years that the ternary operator can be very confusing, it has a very different syntax than the regular JavaScript conditional or even the Switch statement. And so I want to first show why ternary operators are important to understand because the very first question that I usually get from a student after I have shown them how to use a ternary operator is, "Why in the world would I want to use this really weird looking syntax when I could use a regular if/else conditional or a case statement?" And it's a fair question until you see the rationale for why.

So I'm going to open up the HTML tab right here. And I'm going to write what looks like HTML but it's actually a templating engine called [JSX](https://reactjs.org/docs/jsx-in-depth.html) and so if you write any programs or you ever want to write any programs in React or Vue, then you might use JSX in order to write out your templates. So it looks a lot like HTML and for the sake of example, you can just imagine that it's HTML if you've never used it before, 'cause it looks like it.

So I'm going to create a div here. And let's imagine that I'm building out a React project and I want to show or I want to hide a div and let's say, it's a tab and the way that I can do that is by saying, className= and then in curly brackets here, I can write some JavaScript code.

Now, if I want to show or hide this specific div or this tab, or whatever it is, then I need to have some conditional logic. So say, we want to check to see if someone has the right permissions, then I can't do something like this. I can't write a regular conditional and say if, has permission === true and then on another line like this have all of my logic. That is not something that is allowed.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image11.png)

So I'm going to get rid of all of that and let's see what we can do, so this is where the ternary operator comes in. I have to write this all on one line, and what a ternary operator allows you to do is to do that, is to write an entire conditional on a single line.

So here what I could say is, has permission and then I'm going to do a question mark, and then we'll say active and I'm making all of this up right here, this is just an example to show what you may build. Then we're going to get into real examples later on. So I could say active colon and then disabled.

```javascript
<div className={hasPermission ? 'active' : 'disabled'}>
</div>
```

So what I have done here is I've provided a conditional. So this is the same thing as saying, if has permission then I want you to return active and if not, I want you to return disabled. This is the only way or the proper way I should say, for building a conditional in tools like React or Vue so that you can have some dynamic behavior built directly into your HTML and your JSX.

So this is the main reason why ternary operators are so important to learn because if you are building out any kinds of real-world front end applications, you're most likely going to have to build in something like this at some point or another.

Now that you've seen the example, I'm going to comment this out, and now let's go into the JavaScript code, and let's actually go through a real working example. I'm going to start with a basic one, and then we're going to go into a more advanced one. So I'm going to start off by creating a function here.

I'm kind of call it age, verification, it's going to take in an age, and then inside of here, I'm going to place the conditional. If you're brand new to JavaScript, and you've never heard of functions at all, do not worry, this is going to be very basic. I'm simply wrapping all the behavior up in a function, so it's easier to call it and print it out down here. So this isn't going to dive into functions and details just a wrapper for what we're going to be doing.

Here I could say, if the age is greater than 25, then I want to console log, can rent a car, and then right here we want to provide an else statement, and then say I want that to be console log is not old enough yet. And that's all that we want this function to do.

```javascript
function ageVerification(age) {
    if (age > 25) {
        console.log('can rent a car');
    } else {
        console.log('is not old enough yet');
    }
}
```

So it's pretty basic then I'm going to call this function by saying age, verification, if I say 15 here, if I save and then run it, it's going to print out that the user is not old enough.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image12.png)

If I change this to 55, and then run it again, now it's going to say they can rent the car.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image13.png)

So this is all working properly. It's an incredibly basic function and this conditional is pretty much as basic as you can get. Now, I did that on purpose. Anytime that I'm wanting to learn something new, especially something that might be a little bit more on the confusing side, I like to start off with a base case. So we're going to simply comment this out and then below here, I'm going to show you the syntax that will allow you to have a ternary operator.

We're going to use the exact same logic, we're just going to switch it up and use it with the ternary syntax. Now the way that you can do this is I'm going to store it in a variable. So I'm going to say, `let answer =` then here, I'm going to say `age > 25`, and then a question mark. Then I'm going to have it say the same thing. So I'll say I can rent a car and then colon can't rent a car. You could put is not old enough, whatever you want on that side.

So that's going to store it in a variable and then let's simply print out the value of whatever that variable is. So we'll say console log, answer, and don't worry, I know I typed all of that out pretty quickly we're going to walk through exactly what the mapping is doing and everything.

Let me hit clear, save, and then run it. And now you're going to see it says, "They can rent the car."

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image14.png)

So we're getting the exact same answers as before, if I change this to five years old and hit run, it's going to say they can't rent the car. So this is working perfectly, this is the exact same behavior we were getting when we had that conditional on the five lines of code.

So let's walk through what's going on. Right here, you can see the very first part of a ternary operator, is going to be the conditional.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image15.png)

This is exactly the same as saying if age is greater than 25, and so this is the first part, you're going to want to break your ternary operators, the easiest way to think of them is that they're broken into three parts. The first part is the conditional, the second part, so after the question mark, the second part is going to be, if that conditional is true, I want you to run this code.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image16.png)

Now if it's not, you have the colon, and now this is going to be what happens if the condition was not met. So if this is false, if the age is not greater than 25, then it's going to skip everything here and then it's going to pass the colon and say, "Okay, we want to return whatever is in this value here."

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image17.png)

Now I also could have written out the console log statement here, if you're curious about why I stored this in a variable it's really just for the sake of space because the ternary operators can get a little bit longer. So I could have done something like this.

I could have just said age is greater than 25, then I could have said console log, can rent a car. Then here, console log again and then can't rent a car, just like this. Now if I save this, clear it and run it, then you'll see that we get the exact same behavior where it says, can't rent a car.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image19.png)

But typically, because of the way that this works, whenever you have ... And let me get rid of all of that, just so it's out of the way. So whenever you have a situation where you're using a ternary operator, typically you do not want to put your console log statements actually in the true or the false values here.

So let's walk through the mapping just to make this clear because I cannot tell you how ... don't worry if this looks weird. I can't tell you how many times a student has come up to me and says, I do not like using ternary operators, they don't make any sense they look weird. I can tell you it just takes practice and what helped me the most when I was learning them is understanding what the mapping was.

Remember, the very first part of it is the first part of the conditional. And so we have, if age is greater than 25, we have age is greater than 25. They don't have the if here, but you can just imagine that the if is right in front of it. Then the question mark means that we're now going to break into whatever happens when this is true and when it's false.

This right here is the true part. This is like dropping here into line three where it says, "Can rent a car". Then after this, this little colon here, you can imagine that this is the else. So this is exactly what we have here on line four where it says else and then it says, can't rent a car. It's exactly what we have here where it says is not old enough.

This is the basic way of implementing a ternary operator. Like, you can see if you ever wanted to implement this in a React application or a Vue app, you couldn't write the code like this. If you wanted to put it on one line directly into the HTML, then you're going to have to write it like we have right here.

```javascript
age > 25 ? 'can rent a car' : "can't rent a car";
```

So that's why it's important to know. I'm going to get rid of all of this and now let's get into a little bit more of an advanced example. Before we get into this, I want to add the caveat that what I'm about to show you is important to understand but I would not recommend using it on a regular basis because the single ternary after you practiced it enough it will actually start to become very familiar to you and it's not going to look as weird as it may look the very first time or second time that you've seen it.

What I'm going to show you now is, how you can implement compound logic. So multiple conditions all into the same ternary operator, and I can tell you this is going to look very weird. I've been doing this for a number of years. And when I see a compound conditional built into a ternary, it still takes me a while to kind of dissect the code to see exactly what's happening. So I wouldn't recommend doing this.

But it is important to understand because I have run into a number of projects that I took over and I worked on, where the developer did do this. And it was important for me to understand what their logic and what their process was, because if I didn't, then I'd be lost in the codebase.

So let's walk through a more advanced example. I'm going to create another function here, I'm going to call it `adminControls`. So we're going to say that the purpose of this function is to either show or hide admin controls. Once again, this is something that is similar to a feature you may build into a React or a Vue or angular application.

So I'll say admin controls, it's going to expect to get a user. Then inside of here, let's follow the same exact process we had before. Let's get it working with a regular if/else conditional, and then we're going to turn that into a full ternary operator. So here, I first want to check to see if the user is logged in.

So I'm going to say, if user and now in JavaScript with a conditional, if you're looking for a true or false value, then you don't have to say, if user is true, you can just say, if user and it will assume you mean if the user is true, if it exists. So I'm going to say if user and then I'm going to drop down inside and I'm going to put another conditional.

I'm going to say if, so we know that we have a user, so we can be confident that we can ask the user if they're an admin. So here I'll say if `user.admin` and the same thing, we're expecting a true or false value if the user is an admin or not. Then inside of here, I'm just going to console log and say, showing admin controls.

Then if they're not an admin, we need to have some logic for that. So I'm going to say, if not, then I want to console log and say you need to be an admin. Then we also need to verify, we need to have a backup for if the user is just a guest user. So maybe the user hasn't signed in, so here I'm going to put another conditional and say else and then we'll put console log and then you need to be logged in, just like that.

```javascript
function adminControls(user) {
    if (user) {
        if (user.admin) {
            console.log('showing admin controls...');
        } else {
            console.log('you need to be an admin');
        }
    } else {
        console.log('you need to be logged in');
    }
}
```

Now let's create some examples, some kind of case studies here. I'm going to say, let and we're going to create three user types. So let user one, this is the full admin, so I'll say they have a name and this one will be Kristine, and it's admin with a value of true, so this is just a basic JavaScript object.

And here I will call admin controls and I'm going to pass in user one. Now let's save this and let's just verify that this one's working.

```javascript
let userOne = {
    name: 'Kristine',
    admin: true
}
adminControls(userOne);
```

If we run this, we should get the, showing user controls.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image20.png)

Yes, everything here is showing admin controls. That's all working properly. Let's just give ourselves a little bit of space and we're going to create a few more users. This one's going to be user two and then for this one we'll give it a different name and then admin here is going to be false. Then we're going to call it slightly differently, just like this.

```javascript
let userTwo = {
    name: 'Tiffany',
    admin: false
}
adminControls(userTwo);
```

Now if I save and I run this, we should have the, you need to be an admin.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image21.png)

So we still have our showing admin controls and now it says, "You need to be an admin." So everything there is working perfectly, they dropped into this user because it was true. But then they were not an admin, so it fell into the else statement, so everything there is working.

And the last one, let's say user three, and this is our guest user. So this is going to be a user who doesn't have any values whatsoever. So we're just gonna say user three and we're just going to say that they're, null. Now, this user three should return that you need to be logged in. Let me clear this, hit run and it should say, "You need to be logged in." Which is perfect.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image22.png)

Everything here is working and our conditional is working. But let's imagine that you need to put this in a ternary operator. Now, this is going to look very weird. Once again, I would not recommend doing this at all, just because I think it leads to unreadable code. But if you ever come across a ternary operator that looks like this, you're going to know exactly what it's doing.

I'm going to create a variable that we're going to store this. So I'm going to say let, response equal and then here we are looking ... Let me comment all this out, just so you don't get a false read on it. So we have this user argument, I'm going to say, user, then from there, we're going to start off the same way we did with our basic examples.

It's going to say, user, question marks where we're going to first check, is the user true. Then this is where it gets weird. This is where we're going to place another ternary operator inside of the very first statement. Because the way that this logic works is it's going to check to see, is this the case? Is this user, do they exist?

So it's the same thing as saying user true and then we're going to drop into what happens if it's true? Well, what happens when it's true in this example? Well, we drop into this second conditional, so that's exactly what we do here with the ternary operator. We're going to say, user.admin and then we're going to give another question mark.

Because this is like asking that second question. So we're going to say, user.admin and then here showing admin controls ... and then we're going to give what happens if they're not an admin. You need to be an admin. Now that we have that, now we need to go into that final else. This is what happens if the user didn't exist. Now we'll say, you need to be logged in. We stored all of that in the response. Let's just console log that, so we'll say console log response. Hit Save, clear this and we should get all of the exact same answers.

```javascript
let response = user ? user.admin ? "showing admin controls..." : "You need to be an admin": "You need to be logged in";
console.log(response);
```

If I hit Run, there you go. You need to be logged in, right above it was you need to be an admin, and then showing admin controls. As you can see, this looks really weird, one thing I will say is unlike the if/else conditional, the spaces and having these carriage returns where you have all of the code on different lines, that may not be allowed in the JSX, so in your React or Vue application. But you actually can have carriage returns and it is valid code.

You could make this look something like this. This is going to look possibly even weirder but the last time I ran into one of these in the wild in a project, they actually had it all on multiple lines, so I wanted to show that to you. I could say something like, user and then question mark, user admin, have the entire conditional right here. Then put this on another line, just like this.

```javascript
let response = user 
    ? user.admin ? "showing admin controls..." : "You need to be an admin"
    : "You need to be logged in";

console.log(response);
```

For some reason, with the way that JavaScript is compiled, this still will work. If I hit Clear, save, and then run this again, everything here still works. So you may see some examples, that look something like this. So if you ever see this syntax know that the developer created a ternary operator, in this case, a compounded one.

Let's walk through what's going on here, kind of line by line. Let's start at the top. So we're checking to see if the user exists. That's the same thing as just placing the user right there. Same thing as saying, user === true. If that is true, they will drop down into this next line here. And if you prefer, if this is messing you up too much, then let me put this all on a single line again, just so we can read it all from left to right.

So right here, what we're doing is we're saying is the user, do they exist? Yes. Okay. Well, now it's time to drop into another conditional. One thing that does help me whenever I'm working with this kind of code, is I like to wrap the separate ones up in parens, just like this, this makes it a little bit easier and as you'll see, this also works exactly the same way.

```javascript
let response = user ? (user.admin ? "showing admin controls..." : "You need to be an admin") : "You need to be logged in";

console.log(response);
```

Now if I hit run, everything still works but I think at least, in my opinion, this is a little bit easier to read and it shows that this is a nested conditional. Technically, you could keep on nesting them, you could have another conditional here, or you could have it in the else block. But to me, even having two of them is honestly a little bit too much. But it's your world, you get to live in it, so build your conditionals however you want. But I just hope I wouldn't have to take over your codebase if that is what you decide on doing.

So what we're just getting back to, we have the user first conditional. They drop into this conditional, this is the same thing as what we have here on lines 3 through 7. Where it says, "If this is the case, I want you to show the admin controls. If not, I want you to ... You need to be an admin." so same process.

Then finally, if the user didn't exist. If this was false, then it skips everything here until it finds the final colon and then it says you need to be logged in. So what we wrote here on line 12 is exactly the same as what we wrote on line two to 10. As you could see the behavior is identical but the difference is, if you ever need to write your conditional all on one line, then this is the syntax that will allow you to do that.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+JavaScript/JavaScript+Conditionals/Overview+of+JavaScript+Ternary+Operator+%23+2305/image23.png)

Now if this was confusing to you at all, and do not feel bad if it was, ternary operators are one of the more confusing parts of learning JavaScript, especially in the beginning. Then what my recommendation would be, is to go through the show notes. I'll provide all of this code for you. Put it into your own code pen, use it on your local system, and then play with it.

Make some changes, look and see what happens if you change something in this part of the conditional and see how it maps to what you have here in the normal if/else statement. Go through it until it starts to really sink in and make sense. Then once you get into learning about React and these other frameworks, and you see one of these ternary operators you're going to know exactly what to do.

### Code

```javascript
function ageVerification(age) {
  // if (age > 25) {
  //   console.log('can rent a car');
  // } else {
  //   console.log("can't rent a car");
  // }

  return age > 25 ? "can rent a car" : "can't rent a car";
}

ageVerification(30); //?
ageVerification(10); //?

function adminControls(user) {
  // if (user) {
  //   if (user.admin) {
  //     return 'showing admin controls...';
  //   } else {
  //     return 'You need to be an admin';
  //   }
  // } else {
  //   return 'You need to be logged in';
  // }

  return user
    ? user.admin ? "showing admin controls" : "You need to be an admin"
    : "you need to be logged in";
}

const userOne = {
  name: "Kristine",
  admin: true
};

adminControls(userOne); //?

const userTwo = null;

adminControls(userTwo); //?

const userThree = {
  name: "Tiffany",
  admin: false
};

adminControls(userThree); //?
```
