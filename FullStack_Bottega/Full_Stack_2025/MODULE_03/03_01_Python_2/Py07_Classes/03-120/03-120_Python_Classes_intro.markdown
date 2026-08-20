# MODULE 03 - 120: Python - Introduction to Classes

In this lesson on **object-oriented programming (OOP)** in Python, we will take an introductory look at **Python classes**.b

We’ll explore how to build a basic class, analyze the syntax, and instantiate objects from it.

This guide will help you understand how Python implements classes and how they serve as **blueprints, sketches, for objects**.

🔗 **Reference:** [Python Classes Documentation](https://docs.python.org/3/tutorial/classes.html)

***

## 🔹 Setting Up the Environment

You can follow along in any Python environment, such as:

* **Repl.it**
* **Sublime Text**
* **Visual Studio Code**
* **Command Line (vim + Pipenv)**

To start a new **virtual environment**, use:

```
pipenv shell
```

This will initialize an isolated environment with Python 3.x.

***

## 🔹 Basic Class Syntax

The fundamental building block of OOP is the **class**. Here’s a simple example:

```
class Invoice:
    def greeting():
        return 'Hi there'
```

📌 **Key Takeaways:**

* **Class Definition** → Uses the `class` keyword.
* **Naming Convention** → Class names start with an **uppercase letter**.
* **Method Definition** → Inside the class, functions define behaviors.
* **No `self` yet** → This will be explained later.

🔗 **Reference:** [Python Class Syntax](https://docs.python.org/3/reference/compound_stmts.html#class-definitions)

***

## 🔹 Instantiating a Class

A **class alone does nothing**. We must create an **instance** of it.

```
inv_one = Invoice()
print(inv_one)
```

📌 **What Happens?**

* `inv_one` is an **object** created from the `Invoice` class.
*   Running the script prints:

    ```
    <main.Invoice object at 0x7f8b1c2b3d30>
    ```

    This shows the object’s memory location.

If we create another instance:

```
inv_two = Invoice()
print(inv_two)
```

Each instance is unique and stored at a different memory address.

🔗 **Reference:** [Python Instantiation](https://docs.python.org/3/tutorial/classes.html#class-instances)

***

## 🔹 Calling Class Methods

To call a method inside a class:

```
print(inv_one.greeting())
print(inv_two.greeting())
```

🚨 **Error Alert!** 🚨\
This will fail because `greeting()` lacks the `self` argument.

***

## 🔹 Fixing with `self`

In Python, **every method in a class must take `self` as its first argument**.

The `self` keyword refers to the specific instance calling the method.

### ✅ Corrected Code:

```
class Invoice:
    def greeting(self):
        return 'Hi there'

inv_one = Invoice()
print(inv_one.greeting())
```

📌 **What Changes?**

* **Added `self`** → Now the method belongs to the instance.
*   **Now it works!** It correctly prints:

    ```
    Hi there
    ```

🔗 **Reference:** [Python `self` Explained](https://docs.python.org/3/tutorial/classes.html#instance-objects)

***

## 📌 Summary

* **Classes** act as blueprints for objects.
* **Instantiation** creates an object from a class.
* **Methods** inside a class require `self` to reference the instance.

***

## Video lesson Speech

For this lesson on **object-oriented programming** in Python, we are going to take an introductory look at **Python classes**. We'll see exactly how we can build a basic class, analyze the syntax, and then build it out.

***

Now, I'm going to do all of this in **vim**, and I'm going to be using the **pipenv virtual environment**.

It's perfectly fine for you to follow along either on **Repl.it** or using the exact same process I'm doing.

You can use **Sublime Text**, **Visual Studio Code**, or anything like that. Everything we're going to be building should be able to be used in any kind of Python environment.

Part of the reason why I'm doing this is to show you exactly how I typically build programs, but also to show you that there are all kinds of different ways that you can do it.

So, I'm going to start up a new virtual environment session by typing:

```bash
pipenv shell
```

This will start up a new environment and give me **Python 3.6.3**. As you can see on the right-hand side, the environment has been activated.

![IMG](../../../../../../../.gitbook/assets/03-120_IMG1.png)

Now, I can create a file. I'm going to say:

```bash
vim invoice.py
```

I'm calling this `invoice.py` because, throughout this entire section, we're going to be building out real-world type classes. Imagine a scenario where you're building out some type of accounting system, and you need to be able to build out an invoice. That's what we're going to be doing in these guides.

***

## Basic Class Syntax

The very first thing I'm going to do is walk through the syntax. I'm going to say:

```python
class Invoice:
    def greeting():
        return 'Hi there'
```

Here, I've created a class called `Invoice`. Notice that the class name starts with an uppercase letter, which is the common convention. Inside the class, I've defined a function called `greeting`. This function doesn't take any arguments and simply returns the string `'Hi there'`.

***

## Instantiating a Class

Now, the way we call this class is by performing a process called class **instantiation**.

A class is like a blueprint for an object, but by itself, it does nothing.

**To create an object from the class, we need to instantiate it.**

Here, I'm going to instantiate the class and store it in a variable:

```python
inv_one = Invoice()
print(inv_one)
```

If I save the file and run it, you'll see that it prints out something like this:

```bash
<main.Invoice object at 0x7f8b1c2b3d30>
```

This is a pointer to the object we've created.

The `__main__` part is a special method, and the `0x7f8b1c2b3d30` is the memory address where Python is storing this invoice.

![IMG](../../../../../../../.gitbook/assets/03-120_IMG2.png)

If I create another invoice:

```python
inv_two = Invoice()
print(inv_two)
```

You'll see that it now has two instances. Both instances are using the same `Invoice` class blueprint, but they are stored in different memory locations.

![IMG](../../../../../../../.gitbook/assets/03-120_IMG3.png)

***

## Calling Class Methods

Now, to call the `greeting` function inside the class, we need to use the instance we created. For example:

```python
print(inv_one.greeting())
print(inv_two.greeting())
```

However, if I run this, I'll get an error. This is because I forgot to include the `self` argument in the `greeting` method.

**In Python, every method inside a class must take `self` as its first argument.** \*\*

**The `self` keyword refers to the instance of the class.**

Let's fix that:

```python
class Invoice:
    def greeting(self):
         return 'Hi there'
```

Now, if I run the code again:

```python
inv_one = Invoice()
print(inv_one.greeting())
```

It will print:

```bash
Hi there
```

![IMG](../../../../../../../.gitbook/assets/03-120_IMG5.png)

***

## Summary

This is the base case example for how you can create a class, instantiate that class, and then call functions inside of the class.

To recap:

* **Classes** are blueprints for objects.
* **Instantiation** is the process of creating an object from a class.
* **Methods** inside a class must take `self` as their first argument.

***

## Code

```python
# 031-120: Classes, intro

# New pipenv has been created

# A new class is created at invoice.py

"""
class Invoice:
    def greeting():
        return 'Hi there'"
"""

# Then, a class instantiation is done

"""
inv_one = Invoice()
print(inv_one)"
"""

# If we call the class an error is returned
# NOTICE: Methods inside a class must take `self` as their first argument

"""
class Invoice:
    def greeting(self):
        return 'Hi there'"
"""


# CodingExercise

"""
Create a class named Garage. Add a method to the Garage class named open_door that returns a string (EX: "The door opens").
Finally, instantiate a new object named home. You do not need to print anything.
"""

class Garage:
    def open_door(self):
        return 'The door is opening...'

home = Garage()
```

***

## Coding Exercise

Create a class named `Garage`. Add a method to the Garage class named `open_door` that returns a string (EX: "The door opens").\
Finally, instantiate a new object named `home`. You do not need to print anything.

```python
# Replace this with your code
```
