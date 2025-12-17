# 03-096\_Python\_Method-Functions\_intro

### MODULE 03 - 096: Python - Methods/Functions

If you've never encountered these concepts before, think of **functions** as stored **procedures** that can be called from anywhere in your program. Instead of writing the same logic multiple times, you can define it once inside a function and reuse it as needed.

This makes your program **more efficient, modular, and easier to maintain**. Let's dive deeper into how this works. 🚀

***

### 🔹 Understanding Functions: Input, Process, and Output

A function consists of **three main components**:

1. **Input** → The data passed to the function.
2. **Process** → The logic inside the function.
3. **Output** → The result returned after execution.

#### Real-World Analogy

Imagine a **gumball machine** 🎰:

* You insert a **blue gumball** → This is the **input**.
* The machine processes it using internal mechanisms.
* You receive a **pink gumball** as output.

The same logic applies to functions: you pass **input values**, the function processes them, and you get **output**.

***

### 🛠 Why Use Functions?

You might wonder: _Why not just write code directly without functions?_

💡 **The Power of Functions:**

* **Reusability** → Call the same function from different parts of your program.
* **Efficiency** → Avoid duplicating code, keeping your program clean.
* **Maintainability** → If a process needs updating, you only modify it in **one place** instead of searching throughout your entire codebase.

***

### 📊 Example: Predicting Housing Prices 🏡

Now, let's apply functions to a **real-world scenario**: building a **machine learning system** to predict housing prices.

📌 **The function workflow:**

1. Takes **input values**, such as house features and historical data.
2. Processes the data to determine patterns.
3. Returns a **predicted price**.

#### 📈 Visual Representation:

1️⃣ Input → House details (square footage, location, price history)\
2️⃣ Processing → Compare against historical data using statistical models\
3️⃣ Output → Predicted house price

By using a function for this task, we ensure **consistency** across the program, enabling multiple parts of the application to access the same logic **without duplicating code**.

***

### 🔄 Function Flexibility: Making Updates Easily

One of the biggest benefits of functions is **scalability**.

For example, if we initially designed our housing price function to focus on **square footage**, but later realize **neighborhood** is a more critical factor, we only need to update **one function**.

Instead of editing multiple sections of the program, we modify the function once, and the change propagates **everywhere** it is used. 🛠✅

***

### 📌 Summary

* **Functions** encapsulate logic for easy reuse and efficiency.
* They consist of **input, process, and output**.
* Using functions minimizes code duplication and simplifies maintenance.
* They make complex tasks like **machine learning predictions** easier to manage.
* Updating a function once applies changes **everywhere it is used**.

***

### Video lesson Speech

Hi and welcome to the section on methods and functions in Python.

Now, if you've never heard of a method or function, a very high level understanding of what they do is they can store procedures and processes and then you can call those from any other part of your application.

***

Now don't worry if that is a little bit fuzzy\
I'm going to give you a few examples and then we're going to go into\
many more examples throughout this section. Now I have our trusty\
gumball here and one of our cups. Now I want you to think of the cup as a\
method or a function. And this gumball right here is the input.

There are three components whenever you think of a method or function\
and that is the input which is what you're going to pipe into it. The\
function itself is those stored sets of processes and then the output\
which is what you want to get back whenever you call that function. So\
my goal with our very basic little function here is I want to insert a\
blue gumball and I want to get a pink one back.

So all of the magic is going to happen inside of the cup. So I'm\
going to put my input in it's going to do all of its processes this\
might be a set of tasks such as looping such as swapping out variables\
implementing conditionals all of the different tools that we have taken\
and we've gone through throughout from day one of this course all the\
way through now each one of those can be implemented inside of a\
function.

Now after the process is done a pink gumball comes out and no I'm not\
going to be taking my magic show on the road. But the one nice thing\
about this is you may wonder why wouldn't I just implement all of those\
processes just by themselves because technically as you've seen we\
haven't used function's up to this point. And so you could technically\
do that.

However the this is where the power functions come in is that this\
same process or a little gumball magic machine here. This can be called\
from anywhere else in the program. So if you have 10 other spots in the\
program that need to call the same process you don't have to duplicate\
your code ten times. You can simply call that same process once and then\
from each spot you can make the same call and it's going to make a much\
more efficient program. And when it comes to building professional\
Python applications then that is really the best way to do it. Let's go\
through another example now.

Now we're going to talk about how we could use functions in building\
out something a little bit more realistic than our gumball machine.\
We're going to talk about how we could build out a machine learning\
system using functions. So right here I'm going to draw a small graph\
and let's say that our function is supposed to be able to predict a\
housing price in a particular city. So we could create a function here\
and so I'm just going to say something like predict\_price and now this\
function is going to take in a few inputs.

![large](../../../../../../../../.gitbook/assets/03-096_IMG1.png)

So it might take in a current house whatever house that you're\
wanting to estimate. So we could just say house this is the first\
argument. So you know how we had our blue gumball that went in. That is\
one of the inputs but we can pass in many inputs and then we could say\
something like historical data and so we would pass in two different\
inputs instead of putting one ball in imagine putting two in one is\
going to be the house we want to predict and then all of the historical\
data inside of that function we are going to be able to work with this\
historical data so we could build some type of dictionary or a list that\
takes in all of the home prices. So it maybe takes them in and it bases\
where it puts them on this graph based on maybe the square footage of\
the home and then it also has the price and this is a very common\
machine learning algorithm.

![large](../../../../../../../../.gitbook/assets/03-096_IMG2.png)

I don't want you to worry about all of this. I'm just giving you an\
example of the power that you could utilize whenever you're working with\
a function. All of this could be used throughout your entire program.\
Now we take the House which has a price and square footage and we draw\
right here and based on the rest of the graph data we could draw a line\
and see an estimate on historical prices. What this home's value would\
be worth. That is a very common process when it comes to implementing\
machine learning algorithms and we could build all of this functionality\
directly into a function.

And then if we have one page of our application that wants to predict\
prices all we have to do is call this one function. If we have a\
completely different part of the application that wants to perform the\
same process we can call the one function. We don't have to worry about\
copying and duplicating all the code and performing different tasks like\
that.

Now another reason why this is so beneficial is imagine that we have a\
scenario where this function gets called ten times throughout your\
application and then we look and we see that all of these processes\
having all of these home prices and all of these things that it's\
actually wrong and that we need to fix it. We don't care about the\
square footage we actually want to switch it to something like the\
neighborhood and we realize a neighborhood is more critical than the\
square footage that's going to change all of the data inside of here and\
it's going to have to redo that entire process.

If we had simply copied and pasted all of this code ten times\
throughout the application we would end up having to go and find every\
spot where we made that change and we would end up having a very\
inefficient development workflow and that's part of the reason why\
functions and methods were created because if we are simply calling this\
function from different parts of the application then we only have to\
make one change and then it will automatically populate throughout the\
rest of the program.
