# MODULE 03 - 124: Python - Dunder Methods 1: `__init__`

Dunder methods (short for **double underscore methods**) in Python are special methods that start and end with **two underscores** (`__`).   

These methods are built into Python and serve **specific purposes within the language**.

One of the most important dunder methods is `__init__`, which is used to **initialize objects** when they are created from a class.  

 If you're new to Python, this syntax may seem unusual at first, but understanding `__init__` is crucial for working with **object-oriented programming (OOP)** in Python.

🔗 **Reference:** [Python `__init__` Method](https://docs.python.org/3/reference/datamodel.html#object.__init__)

---

## 🔹 Why Does Python Use Dunder Methods?

Unlike other programming languages that have **private and protected methods**, Python **does not enforce strict access control**.   

Instead, Python provides dunder methods as a way to:

✅ Define **special behaviors** for objects.
✅ Establish **consistent patterns** in class-based programming.
✅ Indicate that a method is **built-in and should not be overridden** unnecessarily.

Whenever you see a **dunder method**, you should understand that it is a **predefined** method provided by Python itself.

---

## 🔹 Understanding `__init__`

The `__init__` method is automatically called when a **new instance** of a class is created.   

It allows us to set up **initial values** for the object's attributes.

### ✅ Example: Basic Class Without `__init__`

```
class Invoice:
    def greeting(self):
        return "Hi there"

inv = Invoice()
print(inv.greeting())
```

📌 **What Happens?**

- The `Invoice` class defines a method `greeting()`.
- We create an instance `inv` and call `greeting()`.
- However, this class **does not initialize any attributes**.

---

## 🔹 Adding `__init__` to Initialize Attributes

To make the class more useful, we define `__init__` to **initialize attributes** at the moment an object is created.

### ✅ Example: Defining an Invoice Class

```
class Invoice:
    def __init__(self, client, total):
        self.client = client
        self.total = total

inv = Invoice("Google", 500)
print(inv.client)  # Google
print(inv.total)   # 500
```

📌 **What Changes?**

- `__init__` assigns values (`client` and `total`) when an object is instantiated.
- Now, each `Invoice` instance carries its **own data**.

🔗 **Reference:** [Python Class Initialization](https://docs.python.org/3/tutorial/classes.html#class-definition-syntax)

---

## 🔹 The Role of `__str__`

Another important dunder method is `__str__`, which **defines how an object is printed**.

### ✅ Example: Adding `__str__`

```
class Invoice:
    def __init__(self, client, total):
        self.client = client
        self.total = total

    def __str__(self):
        return f"Invoice from {self.client} for {self.total}"

inv = Invoice("Google", 500)
print(str(inv))  # Invoice from Google for 500
```

📌 **What Happens?**

- The `__str__` method returns a **human-readable** string representation of the object.
- This is useful for **debugging** and displaying object information.

🔗 **Reference:** [Python `__str__` Method](https://docs.python.org/3/reference/datamodel.html#object.__str__)

---

## 📌 Summary

- **Dunder methods** are special methods built into Python.
- `__init__` is used to **initialize object attributes** when a class is instantiated.
- Python does not have **private/protected methods**, so dunder methods serve as predefined **special behaviors**.
- `__str__` helps in **printing objects in a readable format**.

****

# Video lesson Speech

Once again the Dunder methods are the methods that start with double underscores have some method names such as init and then they end with two more double underscores `_ _ init _ _` and if you're relatively new to Python or programming in general then this type of syntax may look very odd to you. 

I remember when I was first learning python. Whenever I would see these weird-looking methods on stack overflow or in any kind of documentation they were really confusing. I wasn't quite sure what the purpose of them was how I was supposed to use them and if they had any kind of special behavior and it wasn't until I really dove into how python worked especially the Object-Oriented Programming level that it started to make sense and so that's what I want to try to impart to you is the ability to understand this in a clear and concise manner. 

So let's first talk about this weird syntax with these double underscores in front of the name. The reason for this speaks directly to how python works with private and protected methods inside of their classes. So in many other programming languages, they don't have to use this kind of structure. They don't have to use these weird underscores or anything like that because they have what are called private methods. 

So if you're coming from a different language you might have something like this where you have the String class and this is not in I'm not using any kind of language-specific syntax I just want to show you the structure here so you'd have this string class and then inside of it you would have what are called private methods and you'd also have protected methods and anything that was private or protected would have limited visibility outside of that class. So in other words, if you went and you created some kind of string so say my name you could do something like call upcase, and then it would go and make each one of those items and place them in the upper case. 

But because they are private and protected you would get a warning any time you maybe tried to do something like this where you say def and then upcase and you would receive a warning saying hey it looks like you're trying to override a built-in method and so that you might not want to do that because that could lead to other parts of the program getting different behavior than you'd expect. 

But because python doesn't have private or protected methods what they did is they decided to create these Dunder methods so anytime you see a Dunder method in Python it means that this is a method that is given to you from the Python language directly. 

If you want to use it then you can use it but you shouldn't overwrite it or change it in any way. You should simply use it in your program in a way that is intended and in these next few guides I'm going to walk through some of the popular Dunder methods and we're going to start with one of them right now which is called Dunder string or Dunter stirred depending on how you want to pronounce it.

So I'm going to start off with an invoice class here so I'll say class Invoice and we're going to start off with a dead-simple implementation of this so I'm going to say def and then 2 underscores because this is a Dunder method str followed by two underscores followed by self 

```python
def __str__(self):
```

and so now I'm simply going to return and say this is the invoice class and now what I can do is if I come down here I can instantiate this invoice so I'm gonna say inv equals invoice and I'm not going to pass any items to it no dot there and so now I have an invoice that I can work with. 

```python
inv = Invoice()
```

And from here I can say print str and so this is where it gets cool. I can just say str inv and now if I save this file and I come over here and I run it you can see it prints out and says this is the invoice class. 

-![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Object+Oriented+Programming+(OOP)+in+Python/Overview+of+Dunder+Methods+in+Python%3A+__init__+%23+1599/image11.png)

So Python looks for this str method to be defined and if it's defined in a class it looks for what gets returned. And so in this case we're saying I just want you to return this string saying this is the invoice class. And so the goal of the str method whenever you use it in a class is to help you get some visibility into each one of whatever you've instantiated from that class. 

This is not the most helpful so let's come and let's actually create what a real implementation would look like now that we know the syntax for it. And so I'm going to come up here and start by creating a Dunder init method its going to take in self, followed by a client, and a total. And then this is going to assign self.client to client and then go and we'll do self.total and set that equal to total. 

And then when the string function and this Dunder string function we can use some string interpellation here and instead of just returning a hardcoded string we can make this dynamic so I can say invoice from self.client for and then say self.total and I can hit save now and we have to come down here and add some values so say Google and then 500. Now if I save this and run it now you can see that this prints out invoice from Google for 500. 

![large](./03-124_IMG2.png)

And so this is incredibly helpful. 

What I typically use the Dunder string method for is to have the ability to dump out all of the different values that are specific to an object and so usually when you're using Dunders string it's for debugging purposes. So if I create some kind of class in this case our invoice class and it's not it's not really showing the behavior that I'm looking for. So it has some kind of bug. 

One of the first things I'll do is all call string and wrap that around whenever I've instantiated. So in this case I'll wrapped string right around the invoice and then it will show me all of the details inside of that class so it'll show me usually what I pack in all of the different attributes in the data right there.

Say that I'm calling an API this would be a common use case I'm calling an API I'm bringing in some data and I place that inside of the class and imagine a scenario where it's not actually getting updated in the database. What I can do is call my string method my Dunder string method right here and then see all of the data that is coming in from the API. And that usually helps me figure out where the bug is. I might not be receiving the data the right way, I might be parsing it incorrectly, or anything like that. So string is a way where you can get some helpful information about whatever class you're 

working with.

****

## Code

```python
class Invoice:
  def __str__(self):
    return "This is the invoice class!"


inv = Invoice()
print(str(inv))

class Invoice:
  def __init__(self, client, total):
    self.client = client
    self.total = total

  def __str__(self):
    return f"Invoice from {self.client} for {self.total}"


inv = Invoice('Google', 500)
print(str(inv))
```
