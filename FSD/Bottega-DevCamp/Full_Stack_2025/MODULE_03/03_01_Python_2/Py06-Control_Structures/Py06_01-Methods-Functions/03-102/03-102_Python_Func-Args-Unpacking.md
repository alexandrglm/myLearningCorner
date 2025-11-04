# MODULE 03 - 102: Python - Function Arguments Unpacking

When defining functions in Python, we sometimes need to work with an **unknown number of arguments**. Instead of specifying a fixed number of parameters, we can use **argument unpacking** to allow a function to accept a variable-length list of arguments.

This feature is extremely useful in cases where we need to handle dynamic input sizes efficiently. 🚀

🔗 **Reference:** [Python Argument Unpacking](https://docs.python.org/3/tutorial/controlflow.html#arbitrary-argument-lists)

---

## 🔹 Using `*args` for Unpacking Positional Arguments

### ✅ Example: Creating a Flexible Greeting Function

```
def greeting(*args):
    print("Hi " + " ".join(args))
```

Calling the function with different numbers of arguments:

```
greeting("Kristine", "Hudgens")  # Hi Kristine Hudgens
greeting("Tiffany", "M.", "Hudgens")  # Hi Tiffany M. Hudgens
```

📌 **What Happens?**

- The `*args` syntax allows the function to accept **any number of arguments**.
- The arguments are collected into a **tuple**, which can be iterated over or manipulated as needed.
- `" ".join(args)` concatenates all passed arguments into a single string.

🔗 **Reference:** [Python](https://docs.python.org/3/library/stdtypes.html#str.join) [`join()`](https://docs.python.org/3/library/stdtypes.html#str.join) [Method](https://docs.python.org/3/library/stdtypes.html#str.join)

---

## 🔹 Understanding `*args` as a Tuple

When we use `*args`, Python **packs** the arguments into a tuple.

### ✅ Example: Checking the Data Type

```
def show_args(*args):
    print(args)

show_args("Apple", "Banana", "Cherry")
```

📌 **What Happens?**

- The function prints a **tuple** containing the passed values: `("Apple", "Banana", "Cherry")`.
- Since tuples are immutable, `args` cannot be modified directly.

🔗 **Reference:** [Python Tuples](https://docs.python.org/3/tutorial/datastructures.html#tuples-and-sequences)

---

## 🔹 Mixing `*args` with Regular Arguments

We can combine `*args` with regular function parameters.

### ✅ Example: Adding a Time of Day Parameter

```
def greeting(time_of_day, *args):
    print(f"Hi {' '.join(args)}, I hope you're having a good {time_of_day}!")
```

Calling the function:

```
greeting("Morning", "Tiffany", "Hudgens")
greeting("Afternoon", "Kristine", "M.", "Hudgens")
```

📌 **What Happens?**

- The first argument is assigned to `time_of_day`.
- The remaining arguments are collected in `args`.
- The function outputs a personalized message with the names and time of day.

---

## 📌 Summary

- `*args` allows functions to accept **any number of positional arguments**.
- The arguments are **stored in a tuple**, making them immutable.
- `*args` can be used **alongside regular parameters** to create more dynamic functions.
- Understanding argument unpacking improves **flexibility** when designing Python functions.

****

## Video lesson Speech

As we continue our discussion on function arguments in python in this lesson we're going to examine how we can integrate the concept of unpacking into a function argument collection.

****

What that means is there are many times where you have a function that needs to take in a collection of data.   

So, you may not know if you're going to have one element or if you're going to have 50 elements and you can't simply place a hard-coded list of items the way we placed here inside of our full name function.

There are plenty of times where this will work when you know you're going to have exactly two arguments passed to the function.   

However, imagine a scenario where you need more than two and so we're going to 
start by creating a greeting function.

So, I'm gonna say def greeting and inside of this.   

The syntax for using unpacking is that you're going to start off with a star and then the common convention is to name the argument list args and so this is going to be something that you're going to see in so many Python programs and it is common to simply use the name args which is short for arguments and then you need to have an asterisk in front of that args name.   

Because what this represents is an unpacked version or a list of items that are going to be passed into the function.  

 And so if I create the function definition like that I can say print and then from here, 
I'm going to use just standard string interpellation.   

Just so we can have it nice and separate it out.

So I'm gonna say hi give it a space and then concatenate the arguments on top of this and so how can we do that?   

Well, the easiest way is to simply give an empty string so I'm going to use an empty 
string with a space and then say .join and then pass in args.   

Whenever you're passing this in, **notice that you do not need to use the asterisk 
that is only what is needed inside of the function declaration itself**.

```python
def gretting(*args):
 print('Hi ' + ' '.join(args))
```

Now, if I want to call this I can call my greeting function and if I only pass in 2 items so if I want to pass in just two names here this will still work. So if I run this you can see it as Hi Tiffany Hudgens.

![large](./03-102_IMG1.png)

So that works perfectly.

But no,  if I want to pass in a first middle and last name so I could say Kristine and then M Hudgens so notice here I am passing in 3 different arguments.   

If I run this you can see that this works exactly the same way:

![large](./03-102_IMG2.png)

This is a very powerful tool and if you've never seen this before it might look a little bit weird.   

So, let's dive into what is occurring here.  

 I'm going to comment out this print statement and let's simply print out our arg. So I'm gonna say print and then let's print out whatever gets passed in. So if I run this you can see that we are actually **working with tuples**.

![large](./03-102_IMG3.png)

So if you remember back to our long discussion on data structures in python and you if you're wondering why it was important to understand and work with tuples when you already had a data structure such as lists.   

This is a very very big reason why and it's because any time you're going to be working with unpacking and working with argument lists such as we have right here you are going to be working directly with the tuple data structure.  

That means if you didn't have a solid grounding on what tuples were what functions were available to them and so on and so forth then you are going to be struggling with what you could do and what kind of behavior you could implement when you're working with them and I promise you if you work on any type of serious python program you're going to be working with unpacking quite a bit.

A number of machine learning algorithms also take in this unpacking and this args kind of concept in their functions and so it's very important to understand what that builds for you.   

And, another point I'd really like to reiterate is that this args keyword here. This is the 
common convention and **it is the best practice to use**.   

However, I do want to make sure that you do not think that is a required concept and it's a required keyword.

Technically I could change this and I could say names right here so I've changed the argument definition and also how I've called it. And now if I run this you can see it works exactly the same way.

![large](./03-102_IMG4.png)

The reason why I would not recommend this even though it works is that this goes against the python convention.   

Pretty much every single python program that you're going to run into such as a big machine learning library that you bring in when you go and you look at the source code you're going to see that they use the args keyword and so that is something that I would highly recommend that you would also utilize.

So, in addition to working with args, you are not limited when you're passing in this unpacking kind of argument you're not limited to only passing in a collection of data.   

So imagine a scenario where you want your greeting to also take in the time of day.   

So I could say time_of_day as the first argument and then I can pass in args as the 
second argument and what this is doing is, now we are working with two 
different types of arguments.

We were working with a traditional positional argument here and what 
that means is anytime you call greeting the first argument needs to be 
the time of day and then after that, we're passing in the args and so we
 can run this it's not going to work properly yet but you can see if we 
can run it and you can see it still works.

![large](./03-102_IMG5.png)

However, it is taking in the first value and it's assigning that to 
time_of_day, so let's fix that. I'm going to say for this first one I'm 
going to say this one's going to be morning and then for the second one 
I'll say afternoon. And so this now has the time of day assigned and 
then all of the values after it are going to be wrapped inside of the 
args tuple.

And so you still need to use your join which if you remember back to when we're working with lists and tuples join allows you to take in a collection and then it joins it, turns it into a string, and then it combines anything that we start off with.   

So, if we start off with an empty string then it takes that tuple and it simply puts an empty space in between each one of the values.   

If I were to do a dash it would place a dash in between. But the key term to remember with join is that it takes in a collection and then it converts it and outputs a string.

So, now, if I have this I can say hi and then I can join the values and if I want I can also convert all of this so that it uses a formatted string so we can read it a little bit easier.   

Now that I think you understand the basic concept and so I can say hi and then pass in our join statement by using a string literal syntax here so I can say hi and this is going to put in all their names.   

And then after this, I can say I hope that you are having a good and then paste in time_of_day and make sure you end that quote.

And now, if I run this you can see that it says Hi tiffany Hudgens.   

I hope you're having a good morning. And then next It says Hi Kristine M. Hudgies.   I hope that you were having a good afternoon.

![large](./03-102_IMG6.png)

So as you can see by leveraging unpacking we're able to create a much more flexible interface for our function.   

We are no longer limited by forcing our users to have just a first name and the last name we could take in any number of names and then we can wrap that inside of this 
argument list unpack it inside of the function body itself and then we can use it and actually have something that works for our program.

****

## Code

```python
def greeting(*args):
 print('Hi ' + ' '.join(args))
greeting('Kristine', 'M', 'Hudgens')
greeting('Tiffany', 'Hudgens')

def greeting(*names):
 print('Hi ' + ' '.join(names))
greeting('Kristine', 'M', 'Hudgens')
greeting('Tiffany', 'Hudgens')

def greeting(time_of_day, *args):
 print(f"Hi {' '.join(args)}, I hope that you're having a good {time_of_day}")
greeting('Afternoon', 'Kristine', 'M', 'Hudgens')
greeting('Morning', 'Tiffany', 'Hudgens')
```
