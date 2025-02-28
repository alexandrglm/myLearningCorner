# MODULE 03 - 097: Python - Functions, Basic Syntax

Functions are one of the most foundational building blocks in Python programming. They allow us to **store procedures and processes** that can be reused multiple times throughout our application.

In this guide, we will explore **how to define functions, work with arguments, and make functions dynamic**. Let's break it down step by step. 🚀

🔗 **Reference:** [Python Functions Documentation](https://docs.python.org/3/tutorial/controlflow.html#defining-functions)

---

## 🔹 Defining a Basic Function

To create a function in Python, we use the **`def` keyword** followed by the function name and parentheses `()`.

### ✅ Syntax

```
def function_name():
    # Indented block with function logic
    print("Hello, world!")
```

- The **colon (`:`)** indicates the start of the function block.
- Everything inside the function is **indented**, just like loops and conditionals.
- To **call** the function, simply use its name followed by parentheses:

```
function_name()
```

📌 **Key Rule:** Python follows **PEP 8**, which recommends using **snake_case** for function names, just like variables.

🔗 **Reference:** [PEP 8 - Function Naming](https://peps.python.org/pep-0008/#function-and-variable-names)

---

## 🔹 Working with Function Arguments

Functions become more useful when they accept **arguments**—values passed into them when called.

### ✅ Example: Creating a Full Name Function

A function can accept **parameters** (placeholders) that receive values during execution:

```
def full_name(first, last):
    print(f"{first} {last}")
```

Calling the function with arguments:

```
full_name("Kristine", "Hudgens")
```

🔹 **Key Concept:** Arguments allow functions to be **dynamic** and reusable.

🔗 **Reference:** [Python Function Arguments](https://docs.python.org/3/tutorial/controlflow.html#more-on-defining-functions)

---

## 🔹 Using Conditionals Inside Functions

Functions can contain **logic** such as `if` statements to perform checks and return different results based on conditions.

### ✅ Example: Authentication Function

```
def auth(email, password):
    if email == "kristine@hudgens.com" and password == "secret":
        print("Authorized")
    else:
        print("Not Authorized")
```

Calling with different values:

```
auth("kristine@hudgens.com", "secret")  # ✅ Authorized
auth("wrong@email.com", "secret")  # ❌ Not Authorized
```

🔹 **Key Concept:** Functions can **evaluate conditions** and return different outputs.

🔗 **Reference:** [Python Conditionals](https://docs.python.org/3/tutorial/controlflow.html#if-statements)

---

## 🔹 Functions Without Arguments

A function **does not always require arguments**. For example, a function that prints numbers from **1 to 100**:

```
def hundred():
    for num in range(1, 101):
        print(num)
```

Calling:

```
hundred()
```

📌 **Key Rule:** If a function doesn’t need input, leave the parentheses empty.

🔗 **Reference:** [Python `range()` Function](https://docs.python.org/3/library/stdtypes.html#range)

---

## 🔹 Making Functions More Dynamic

Instead of hardcoding values, we can pass a **dynamic argument** to control the loop range:

```
def counter(max_value):
    for num in range(1, max_value + 1):
        print(num)
```

Calling:

```
counter(50)  # Prints numbers 1 to 50
```

🔹 **Key Concept:** Arguments **increase flexibility** in function behavior.

---

## 📌 Summary

- **Functions** store reusable logic, making programs more efficient.
- Defined using `def function_name():` followed by an indented block.
- **Arguments** allow functions to accept inputs and produce different outputs.
- Functions can include **conditionals** for decision-making.
- Functions can be **static (fixed values)** or **dynamic (accepting inputs)**.

****

## Video lesson Speech

Functions are one of the most foundational building blocks when it comes to building programs in python. In this guide, we're going to walk through the basic syntax and also examine a few of the different options that we can utilize whenever we're building out this type of behavior in to our programs.

****

I'm going to start with one of the most basic examples of how to create a function in python.   

It is going to be a function that generates a full name when supplied with a first and a 
last name. And so the way that you create a function is you start off with the keyword def.

So, we are going to define this function and it's going to be called `full_name` and the traditional way and the prescribed way that you should be naming your functions in python is to use this snake case kind of syntax so the same type of syntax that you utilize whenever you are creating variables should be the same way that you name your functions.   

So, before we get into a real full name function let's first start off with a base case.  

 So the syntax is you start off with the word def than the name of your function and then you end it with parentheses and then a colon.

```python
def full_name():
```

So very similar to how we have worked with loops and also how we have
 worked with conditionals is the same syntax that you're going to use 
whenever you're building out functions. With the difference being these 
parens here at the end and we're going to walk through how we can work 
with those parens as well.

So I'm going to start off by creating this and then coming down into 
the code block. Much like loops and conditionals you need to also have 
proper indentation so if you tried to create a function and you started 
typing the block of the function right in line with your def you are 
going to get an error. So come down on the next line and indent it and 
then from here you can put any type of behavior that you want to 
implement. So from here I can say print and just say hi. And now if I 
come down a few lines and the common convention in Python is to have two
 lines of space between the function definition and the next line that 
you're going to use.

So if I'm going to call this function I can say full_name and then 
give parens because that's going to execute the function and notice how I
 have two lines right here.

![large](./03-097_IMG1.png)

This makes the code more readable and you will see that in 
traditional Python programs this is the structure for this. Now if I run
 this code you can see that it prints out hi on the right-hand side so 
everything there is working properly.

![large](./03-097_IMG1.png)

But this is pretty boring so let's come and let's actually add some true dynamic behavior to this. So our full name needs to take in a first
 name and a last name. So inside of the parens I'm going to put the 
words first and last and the formal term for these words that I'm 
putting inside the parens are `function arguments` and we're going to talk quite a bit about function arguments as we go through this section.

But essentially what this allows us to do is to pass in values so 
whenever we call our full_name function we're going to pass in different
 words. So, in this case, we're going to pass in strings. But you could 
also pass in all kinds of objects you could pass in dictionaries you 
could pass in lists you could pass in other functions there are all 
kinds of things that you can use as function arguments.

But for the case of our first true function, I'm simply going to pass
 into strings which are going to be a first name and a last name. Now 
coming inside of our print statement we can now use where ever these 
values are. So I'm going to use our formatting string interpellation 
process. I'm gonna say f and then follow it up with the string and then 
we can have curly braces here where I say first and then we can have 
more curly braces with a space in between them.

Last, finish it off with an ending apostrophe right here so we have a full string.

```python
def full_name(first, last):
 print(f'{first} {last}')
full_name()
```

And now if I try to call full_name just like this I'm going to get an
 error. So, if I run this you can see that it gives me a TypeError.

![large](./03-097_IMG3.png)

The explanation is that full_name is missing two required positional arguments so these positional arguments are first and the last and what Python is telling me is that full_name needs to be supplied those elements. So here I can pass in two strings so Kristine and then Hudgens and if I run this you can see that it prints this out correctly.

![large](./03-097_IMG4.png)

Now, that may not seem like a very big deal because technically we could have done the exact same thing by just calling our print statement but what full name is allowing us to do, is imagine that you have a program and you want to be able to build out this kind of functionality and call this full name function from anywhere.   

You can do this and now you can simply pass in values and have this full name function that does all of the work for you.

![large](./03-097_IMG5.png)

Now, this may seem like a dead-simple example and it is. It is really our first true function that we've built out.   

But I also want to say that the full_name function is a method that I build into almost every application that I build-out.   

Imagine working in on the Facebook application and when you log in it says hi and then your name. That is nothing more than what we have here. So that is pretty cool.   

You have the ability to build out into lines of code and the way of encapsulating
 an entire process. And then you can call it from anywhere else that you need it in your application, so that is a basic example.

Now, let's build out something with a little bit more complex so I'm going to build out an authentication system so I'm gonna say def auth and then it's going to take a couple of arguments so it's going to take in an email and a password:

```python
def auth(email, password):
```

Now what I want to do is I want to show you that we can build all kinds of different processes inside of function so if I want to integrate a conditional here I can say if email is equal to [Kristine@Hudgens.com](mailto:Kristine@Hudgens.com) and the password is equal to secret and give us a little bit more room here so it can all be on one line.

```python
if email == 'kristine@hudgens.com' and password == 'secret':
```

So if that is the case then I'm going to print out authorized and then I can add an else statement here and then I can print out not authorized.

So, now, if I come down here and I call our auth function and pass in something that's not valid.  

 So, if I say [jordan@hudgens.com](mailto:jordan@hudgens.com) and I pass in the secret password so everything here is the same except for my name. So if I attempt to do this it's going to say not authorized.

![large](./03-097_IMG6.png)

But if I change this username or this email address here and run it again. Now you can see that it is authorized.

![large](./03-097_IMG7.png)

So we have effectively built in a full condition right into this auth function and now we can call this from anywhere else in the program.   

So far we've walked through two examples of how to work with functions in python. We walked through a very basic full name function that took in two positional arguments and then printed them out with special formatting.   

Then we built out an auth function that has a conditional built into it.

****

## No args.

Now lastly I want to show you how you can build out a function that takes no arguments so I can say def and then hundred

```python
def hundred
```

and what I'm going to do is I'm going to build out a function that 
prints out the first hundred numbers so I'm going to say def hundred. 
And like we did in the very beginning we're going to pass in no 
arguments to the parentheses right here we are simply going to have a 
blank set of arguments end it with a colon and now inside of here we're 
going to integrate a loop so I can say for in and then I need to give an
 argument here I'm gonna say for numb in range and we'll pass in 1 to 
101. And this is going to go through it's going to create a range of 100
 items going from 1 to 100.

```python
def hundred():
 for num in range(1, 101):
```

And then I simply want to print that out. So I want to print num out 
and now if you want to call this you can call hundred have it execute by
 having parens at the end. And now if you run this code you can see that
 it has printed out the numbers 1 through 100 so even though we didn't 
pass in any values here it still worked.

![large](./03-097_IMG8.png)

Now if you wanted to add some level of complexity so say that you 
wanted to create a function that say, was called counter and you wanted 
the value to be dynamic so you could say def counter and then have it 
take in a max value and then you can actually call it max_value. I'm 
going to put this inside of the range. So instead of 101, this is going 
to be dynamic and so now if I say 501 and run this you can see that it 
prints out to five hundred.

![large](./03-097_IMG9.png)

So we're able to take a very basic example where we simply hardcoded 
the value in and then you saw how with a few very small changes such as 
passing in an argument here we were able to make our loop dynamic.

So those are three examples of how to build a function in python.

****

## Code

```python
# 03-097: Functions, basic syntax


def full_name():
    print('Hi')

full_name()




# With positional args
# Now, a functions, is a method

def full_name_args(first, last):
    print(f'{first} {last}')

full_name_args('Kristine', 'Hudgens')  
full_name_args('AnotherName', 'AnotherSurname')  




# Authorizing example

def auth(email, password):
    if email == 'thecorrect@mail.com' and password == 'secret':
        print('Authorized')
    else:
        print('Not Authorized')

auth('theINCORRECT@mail.com', 'secret')
auth('thecorrect@mail.com', 'secret')




# No args.

def hundred():
    for num in range(1,101):
        print(num)

hundred()

## Converted into a Counter

def counter(max_value):
    for num in range(1, max_value):
        print(num)

counter(68)
```

****

## CodingExercise

```python

```
