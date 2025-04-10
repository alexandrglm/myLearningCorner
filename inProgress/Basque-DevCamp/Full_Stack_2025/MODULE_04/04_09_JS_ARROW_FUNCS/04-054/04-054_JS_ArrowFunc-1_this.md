# MODULE 04 - 054: JavaScript

## Modern JS (5): `this`

---

---

## Video lesson Speech

Now that you're familiar with arrow functions and their syntax in this 
guide I want to walk through the reason why arrow functions are 
important. What we're going to do is build out an invoice function, and 
we're going to see that the way that arrow functions interact with this 
keyword is completely different than how just standard function 
expressions and declarations are.

****

So let's start off by just creating a base function here called invoice and I'm going to create a tax rate and assign it to this. I am going to say this.taxRate set equal to say 6 percent. 

![large](./04-054_IMG1.png)

```Javascript
function Invoice() {
  this.taxRate = 0.06;
}
```

Now, this may look very weird if you're coming from a different language because what we're essentially doing is we are adding an attribute to a function, and that is not something you would do in many other languages. You wouldn't do this in Ruby, Java, C, or C++ because this is a very weird way of doing it. We're essentially treating this invoice like it is a class and there's a very specific reason why we're doing that. It's because for years and years javascript did not have an object-oriented type of syntax. It didn't have classes until the last couple of years and because every type of function inside of javascript is an object and objects can have attributes. What developers started doing is they just started adding attributes to functions just like regular objects and so were actually able to treat this like a normal one. So if I do some mean like const inv and create a new invoice I can console log, and I have full access to this value so I can say inv.taxRate and if I console.log of this out is going to print out 6 percent just like that. 

![large](./04-054_IMG2.png)

```js
 function Invoice(subTotal) {
  this.taxRate = 0.06;
}

const inv = new Invoice();
console.log(inv.taxRate)
```

The reason for that is because taxRate is simply an attribute inside of the object. It's just a key-value pair that we can have access to if you don't believe me then try to console log out inv. Run this. 

![large](./04-054_IMG3.png)

```js
function Invoice(subTotal) {
  this.taxRate = 0.06;
}

const inv = new Invoice();
console.log(inv)
```

You can see it's just an object that doesn't get treated as a function because functions are nested inside of objects when a new one is created. So we have this object with a tax rate. Now that's not the point of this guide, but it is such a critical part of javascript that I want to reiterate it a number of times. Because I personally struggled when I was originally trying to learn javascript because it was so much different than many of the other languages out there and it was mainly because of little nuance things like this. Once I started to recognize that pretty much everything in Javascript was an object and that I could add attributes, functions, and all of these things into it. Then it became much more straightforward to understand how it worked. So that with that aside done now let's talk about the real reason that we're here which is to learn about arrow functions.  

I'm going to create a function inside of invoice called this.total which is a function expression, and I'm going to use a tool called set interval. What set intervals are going to do is set Interval is a part of a very large object. It's an all part of the window object, and because of that, it has a very nasty little secret up its sleeve. Whenever you try to use the this keyword, So whenever I want access to any of the attributes inside of a parent object if I wrap it in the setInterval, it's not going to give me this that I thought that I was about to get. So I'm going to create a function inside of set interval. That's just going to be called something like total numbers or something like that. It doesn't really matter because it's not going to work. But I'm going to show the reason why. So set interval takes in two arguments. The first is a function, and the next is the interval you actually want it to run. So 2000 means it'll be run every two seconds.  

![large](./04-054_IMG4.png)

Now I want to try to console log a total, and the way I can figure out this total would be to multiply the tax rate. So I'll say this.taxRates and multiply that by a subtotal.  I am going to have to create one. So you say this subtotal and let's add this to our invoice, we're going to say we need a subtotal and then we can add it to the object itself. So say this subtotal is equal to the subtotal it gets passed in and we can make up a number we can just say 200. 

![large](./04-054_IMG5.png)

So what's going to happen is when we create a new invoice. It's going to store it inside of the attribute here, and then we have access to it. However, we need it so we can say tax rate multiplied by the subtotal and then we're going to add this subtotal. Now, this may seem like it would work.

![large](./04-054_IMG6.png)

```js
function Invoice(subTotal) {
    this.taxRate = 0.06;
    this.subtotal = subTotal;
    this.total = setInterval(function totalNumbers() {
    console.log((this.taxRate * this.subTotal) + this.subTotal);
  }, 2000);
}

const inv = new Invoice(200);
inv.total();
}
```

If I call inv.total and call it like a normal function, I'm going to clear and run. You guys see something interesting happens where it says not NaN and which stands for not a number. 

![large](./04-054_IMG7.png)

That's kind of weird because we know these are all numbers that are getting passed in. We can multiply two numbers and then add another one. So the fact it's not a numbers kind of weird. So let's just debug it a little bit. Now let's try to console log just the value of this. So now I say. Clear and run. 

![large](./04-054_IMG8.png)

We're going to see something kind of interesting. Look at this. 

![large](./04-054_IMG9.png)

It prints out that the log got skipped because it was too large for the console. Well, let's open up the javascript console. You can do that by if you're on a Mac with command option J. That's going to pull it up, and you can see this is what's getting printed out and it is not what you may have thought was going to get printed out. 

![large](./04-054_IMG10.png)

It is. It should have just printed out that same invoice object. But it's not because it was called from within set interval. This is a very common thing to happen if you have a using center interval something you do quite a bit in modern development. You may want to call an API every one minute to see if any new data came in or you may want to check on as set up a listener and watch for user changes anything like that. It's a very common thing, but you want to be able to reference the object that you're inside. So using this window object is pretty nasty and so if I click on window, you can see all of the different types of key-value pairs and all these different functions that are inside of it. 

![large](./04-054_IMG11.png)

It's pretty massive. This is not what we wanted to refer to when we called this we simply wanted to have access to our tax rate and our subtotal. Well, that's a very cool thing is that that's where arrow functions come in. I can get rid of all of this and then keep the ends. Change it to an arrow function here and clear. Now if I hit run right after I hit save. 

![large](./04-054_IMG12.png)

Now you can see this is referring to our object. So now we have a subtotal and a tax rate our totals giving one just because it's only just returning the interval. We're not worried about that right now. So now that we have that now, we can have access, and we can use our code here. So now we can multiply the tax rate by the subtotal at it, and we have access to all of those values. So now if I click run you can see that it's printing out the right amount. It's taking the 200. It multiplies that by the tax rate than adding it to the total and returning that. Console logging now that entire amount.

![large](./04-054_IMG13.png)

```js
function Invoice(subTotal) {
  this.taxRate = 0.06;
  this.subTotal = subTotal;

  this.total = setInterval(() => {
    console.log((this.taxRate * this.subTotal) + this.subTotal);
    // console.log(this);
  }, 2000);
}

const inv = new Invoice(200);
inv.total();
```

You notice the only change we made was we converted it from one type of function just by a normal function declaration into an arrow function. This is probably the primary reason why you'd want to use arrow functions. They are they're very helpful to use in any other kind of scenario. It's something that you will see a lot in any applications you work on, and the natural question that you should probably be asking right now is would I ever use any other type of function besides an arrow function? The answer to that is yes for the same exact reason of that, with why it deals with this and how it uses just the parent scope. It uses the scope that it is inside of. 
There are many times where you don't want that there may be times where you use something like set interval you do want access to the window object or whatever is inside. In those cases that's when you would use a regular function declaration. Having an understanding of how it works with this and what as access to is something that's important. That will help you decide when you want to use it when you don't. I will tell you from say a percentage point of view I probably use arrow functions now in my javascript development 75% of the time. It gives me access to this that I usually want. It is also just a shorter way of writing functions. 

****

## Code

```js
function Invoice(subTotal) {
  this.taxRate = 0.06;
  this.subTotal = subTotal;

  this.total = setInterval(() => {
    console.log((this.taxRate * this.subTotal) + this.subTotal);
    // console.log(this);
  }, 2000);
}

const inv = new Invoice(200);
inv.total();
```

****

## Coding Exercise

This code snippet represents an unfinished savings calculator. Your goal is 
to calculate 30 percent of this month's paycheck, totaled at $2000. Pass
 the paycheck amount in the correct spot and instantiate the object in 
order to return the correct deposit amount.

```js
function SavingCalc(paycheck) {
  this.percent = 0.30;
  this.paycheck = paycheck;

  this.deposit = function() {
    return (this.percent * this.paycheck)
  }
}

const piggyBank = new SavingCalc();
```
