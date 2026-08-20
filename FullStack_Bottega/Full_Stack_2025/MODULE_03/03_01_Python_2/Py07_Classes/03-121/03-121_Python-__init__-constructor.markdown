# Module 03 - 121: Python - Guide to Python's \_\_init\_\_ Constructor Function

Now that you know the basic syntax for creating a class and a function inside Python, in this guide, we are going to extend that knowledge and see how we can add **data** to our classes.

***

When it comes to working with **object-oriented programming** (and this is pretty much the case for every programming language), classes are made up of **data** and **behavior**.

The behavior is taken care of with functions. So, whenever someone says that you need to have behavior inside a class, what they mean is that you need to define a set of functions.

The **data** is going to be a little bit different. Python specifically handles data in classes differently than many other programming languages.

So, we're going to walk through exactly how that works and the syntax for it. I'm going to delete all of the code from our last example because we're going to use a different example, and we're going to start by implementing what is known as a **constructor function**.

***

## The `__init__` Constructor Function

In Python, the way you create a constructor function is by using the `__init__` method. The correct way to type it is:

```python
__init__
```

This is a special reserved function inside the Python language. Do not create your own function called `__init__`.

This is something that's available to classes, and the way that constructor functions like `__init__` work is that this function will be **automatically called** whenever you instantiate the class.

So, when you create an instance of the class (e.g., `inv_one`), it is first going to come to this `__init__` function and process everything inside of it. Specifically, for our use case, it is going to add the **data** into the class.

The very first argument you pass is going to be `self` because every function inside a Python class needs `self`.

Then, we're going to pass a couple of other arguments, such as `client` and `total`. These are just the items that we're going to use to build our invoice.

Inside the `__init__` function, we're going to add the data directly to the class. The way you do that is by using `self`:

```python
class Invoice:
def init(self, client, total):
self.client = client
self.total = total
```

Here, we're creating two new variables (`self.client` and `self.total`) that are related directly to the instance. If we create `inv_one` and set the client name to `'Google'`, then `self.client` will equal `'Google'`. That's how you assign those values.

## Adding Behavior with a Function

Now that we've added data to our class, let's create a function to format the invoice. We'll call this function `formatter`, and it will take `self` as its first argument, just like every other function in a class.\
Inside the `formatter` function, we'll return a formatted string that includes the client's name and the total amount they owe:

```python
def formatter(self):
    return f'{self.client} owes: ${self.total}'
```

This function uses **f-strings** (formatted string literals) to dynamically insert the `client` and `total` values into the string.

***

## Instantiating the Class

Now, let's instantiate a few invoices. We'll create one for `Google` and another for `SnapChat`:

```python
google = Invoice('Google', 100)
snapchat = Invoice('SnapChat', 200)
```

Here, we're passing the client name and the total amount owed as arguments to the `Invoice` class.

## Printing the Formatted Invoices

To actually display the formatted invoices, we'll call the `formatter` method on each instance and print the result:

```python
print(google.formatter())
print(snapchat.formatter())
```

When you run this code, it will print:

```bash
Google owes: $100
SnapChat owes: $200
```

![large](../../../../../../../.gitbook/assets/03-121_IMG1.png)

***

## Summary

Let's review exactly what's going on here:

1. We created a class called `Invoice`.
2. We defined a constructor function (`__init__`) that takes `self`, `client`, and `total` as arguments.
3. Inside the constructor, we assigned the `client` and `total` values to the instance using `self.client` and `self.total`.
4. We created a `formatter` function that formats a string using the `client` and `total` values.
5. We instantiated two invoices (`google` and `snapchat`) and printed the formatted results.

This is how you can work with **data** and **behavior** (functions) inside a Python class.

***

## Code

```python
# 03-121: __init__ constructor

class Invoice:

    def __init__(self, client, total):
        self.client = client
        self.total = total

    def formatter(self):
        return f'{self.client} owes: ${self.total}'

google = Invoice('Google', 100)
snapchat = Invoice('SnapChat', 200)

print(google.formatter())
print(snapchat.formatter())
```

***

## Coding Exercise

Using our `Garage` class from the previous guide, add a constructor method that builds a property named `size`, which will represent how many cars will fit in the garage as an integer. Instantiate the `home` object to be a 2 car garage.

```python
class Garage:
  # Add your constructor here

  def open_door(self):
    return "The door opens"

home = Garage() # instantiate with a garage size here
```
