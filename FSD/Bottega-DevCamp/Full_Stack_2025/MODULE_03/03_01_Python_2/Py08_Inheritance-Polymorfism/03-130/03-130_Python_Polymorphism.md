# 03-130\_Python\_Polymorphism

### MODULE 03 - 130: Python - Polymorphism

Polymorphism is a core concept in **object-oriented programming (OOP)** that allows objects of different classes to be treated as instances of the same class through **shared interfaces**.

This guide will help you understand:\
✅ How polymorphism enables **method overriding** in child classes.\
✅ Why **abstract classes** enforce structure in class hierarchies.\
✅ How **real-world applications** leverage polymorphism for flexibility.

🔗 **Reference:** [Python Polymorphism](https://docs.python.org/3/tutorial/classes.html#inheritance)

***

### 🔹 Understanding Polymorphism

Polymorphism means **“many forms”**—a single method name can have different behaviors across multiple classes.

📌 **Why is this important?**

* Reduces code duplication.
* Increases **scalability** in large applications.
* Encourages **reusability** of logic across different object types.

#### ✅ Example: Parent Class with an Abstract Method

```python
class Html:
    def __init__(self, content):
        self.content = content

    def render(self):
        raise NotImplementedError("Subclass must implement render method")
```

📌 **Key Takeaways:**

* **The `render` method is abstract** → It forces child classes to implement it.
* If a subclass does not define `render()`, Python will **raise an error**.
* This prevents incomplete or inconsistent implementations.

🔗 **Reference:** [Python Abstract Base Classes](https://docs.python.org/3/library/abc.html)

***

### 🔹 Implementing Polymorphism with Subclasses

We create multiple child classes (`Heading` and `Div`) that **override** the `render()` method differently.

#### ✅ Example: Implementing Custom HTML Elements

```python
class Heading(Html):
    def render(self):
        return f'<h1>{self.content}</h1>'

class Div(Html):
    def render(self):
        return f'<div>{self.content}</div>'
```

📌 **What Happens?**

* Each child class **inherits from `Html`**.
* They **implement `render()` differently**, following the required interface.
* The `Heading` class wraps content in `<h1>`, while `Div` uses `<div>`.

🔗 **Reference:** [Python Method Overriding](https://docs.python.org/3/tutorial/classes.html#inheritance)

***

### 🔹 Using Polymorphism in Practice

Now that our classes are set up, let's **use them dynamically** without needing to know their exact types.

#### ✅ Example: Using a List of Different Objects

```python
tags = [
    Div("Some content"),
    Heading("My Amazing Heading"),
    Div("Another div")
]

for tag in tags:
    print(str(tag) + ': ' + tag.render())
```

📌 **Why is this powerful?**

* **We don’t need to check types manually**—we simply call `render()`.
* The correct method is executed based on **the object’s class**.
* Adding new HTML elements is **easy**, without modifying existing logic.

🔗 **Reference:** [Python Dynamic Typing](https://docs.python.org/3/glossary.html#term-duck-typing)

***

### 🔹 Enforcing Structure with Abstract Classes

We used `raise NotImplementedError` to force child classes to implement `render()`. However, Python provides a **built-in way** to enforce this: the `abc` module.

#### ✅ Example: Using an Abstract Base Class (ABC)

```python
from abc import ABC, abstractmethod

class Html(ABC):
    def __init__(self, content):
        self.content = content

    @abstractmethod
    def render(self):
        pass  # Forces subclasses to define this method
```

📌 **Key Takeaways:**

* `ABC` stands for **Abstract Base Class**.
* The `@abstractmethod` decorator ensures **every subclass must implement `render()`**.
* **Prevents errors** when developers forget to implement a required method.

🔗 **Reference:** [Python `abc` Module](https://docs.python.org/3/library/abc.html)

***

### 🔹 Real-World Applications of Polymorphism

✅ **Web Frameworks** → Django & Flask use class-based views with polymorphism.\
✅ **GUI Development** → UI elements (buttons, text fields) share a common interface.\
✅ **Game Development** → Different characters have shared `move()` and `attack()` methods.

📌 **When Should You Use Polymorphism?**

* When **multiple classes share behavior** but require different implementations.
* When **you want to write flexible code** that adapts to new requirements.
* When enforcing **consistent interfaces** in large applications.

***

### 📌 Summary

* **Polymorphism** allows objects of different classes to share the same method name but with different behaviors.
* **Abstract methods** enforce implementation in subclasses.
* **Using lists of objects dynamically** makes code more flexible and scalable.
* **The `abc` module** provides a built-in way to enforce method implementation.

***

### Video lesson Speech

In the last guide, we walked through the concept of inheritance in\
python. Inheritance by itself is a helpful tool but usually you're going\
to find inheritance is coupled with the concept called polymorphism and\
that is what we're going to walk through in this guide.

***

I've put together a fun example because it's\
something that I've seen real-world code libraries actually utilize. And\
so what we're going to do is we're going to build out an HTML class so\
you can think of this as a tool that can render HTML on the page. And\
then we're going to build multiple subclasses that allow you to render\
custom versions of that HTML.

So I'm going to start off with creating the parent class and this is\
going to be called just HTML out. And inside of it, it's going to have a\
Dunder init method. So I'm gonna say init, it's going to get self and\
then it's going to get content and it's simply going to store that\
content inside of an instance variable. So I'll say self.content equals\
content and then I'm going to create an abstract function and this is\
going to be called render and I'm going explain in a second why this\
class and why this function is an abstract one.

So you say render self and then I'm going to say `raise NotImplementedError` and then inside it'll say subclass must implement render method.

```python
def render(self):
 raise NotImplementedError('Subclass must implement render method')
```

Okay, this may look a little bit weird to you if you've never seen it\
before. But what I am doing here is I don't actually want anyone to\
ever call this HTML class. And this is going to be a common convention\
that you see whenever you're using very complex systems. If you're\
building out a massive application you're going to see this pattern\
followed where you want to create a class that you don't want the end\
user to actually connect with. But instead, you're going to create what\
is called an abstract class and then this abstract class has the sole\
purpose of holding and storing shared behavior and then only the\
inherited classes so only the child classes are going to be the ones\
that ever called this class.

So if I come down all the way here I'm going to create a few more\
classes so I'm going to create a Heading class. So it's going to be\
class Heading and it's going to inherit from the abstract HTML class and\
then it is going to call this render function pass in self and then it\
is going to return a formatted string of H1 and then it's going to take\
in self.content and then we're going to close off that h1 tag and that's\
all we need to do.

```python
return f'<h1>{self.content}</h1>'
```

Now I can create another class here called div, so I'm going to say\
class divide. It's also going to inherit from the HTML class and then\
it's going to have its own render method which is going to take in self\
and then from here it's going to return its own formatted string of div\
and then inside self.content close off that div tag right there. And now\
we can create our own HTML tags.

So I can create a list here called tags and then inside of it I'm\
going to add some elements so I'm going to say tags and then here I can\
call my div class, pass in some content for that div and then I'm going\
to create a Heading element. So I'll say Heading and then this is going\
to be some big heading and then let's have another dev here. So div and\
say another div and that is going to be the last element in our list.

I'm going to save this and then let's actually iterate through the\
list so I'll say for tag in tags. I want you to print out and let's grab\
the string value so I'm going to say str tag which is going to give us\
just the string representation. I'm going to concatenate that with a\
colon. And then let's add that on to tag.render or we're going to call\
our render function.

```python
class Div(Html):
 def render(self):
 return f'<div>{self.content}</div>'

tags = [
 Div('Some content'), 
Heading('My Amazing Heading'), 
Div('Another div')
 ]

for tag in tags:
 print(str(tag) + ': ' + tag.render())
```

So if you've never seen code that looks like this do not worry we are\
going to walk through it right afterward and we're guessing exactly\
what's going on. But first, let's try to run it. So you're going to run\
python oop\_guide.

![large](../../../../../../../.gitbook/assets/03-130_IMG1.png)

And right here it's just printing out everything so it looks like we\
do not have any typos or anything like that. So you can see it's\
printing out the main object and it says Div object, Heading object, and\
then Div object. So this is working properly and then we have our HTML\
content. So we have div and it's wrapping up 'Some content'. So now that\
we know it works and we can take our debugging content out of there.

I just wanted you to be able to see that we have the correct classes\
that are called. You can tell right here when you look at main. We do\
not have any reference at all to the HTML parent class we're only\
calling those child classes. So if I saved this let's run it again and\
get a clean copy and look at that we have rendered our own HTML, we have\
created an abstract class, and then we have created these inherited\
child classes here that are really using the same method.

And whenever we come and we are actually communicating with our API\
so when we're going and we're creating a div and a heading and another\
div. What we're doing is we're using polymorphism. And so polymorphism\
it's a very big word that represents something that's actually kind of\
straightforward which is and it's all in the name poly means many and\
morphism comes from the word meaning to change. Which means it can have\
many changes or one item can have many forms.

So what we have here is we have at the very top a render function and\
the reason why I have placed it in this kind of weird syntax where I\
have raise NotImplementedError. The reason why I'm doing this is because\
I never want anyone to actually call the HTML class I only want it to\
be this inherited class and you could imagine that you could add other\
different methods that could be shared inside of here and then only the\
child classes would have access to them. And this protects against any\
other classes that we create.

So say we created a UL tag or some other HTML element and if it\
forgot to access this render function then we would get an error and it\
would say you need to access that function in order to work. Now I\
actually got the idea of this exercise from the react framework in\
JavaScript. React has this concept of component classes kind of like\
what we have right here and if you try to create a component class and\
you do not call the render functions or even use the exact same name you\
get an error.

And so that's exactly what we have right here where we have these\
subclasses and we are ensuring that they have a render method so that\
they can have that shared behavior. And so what we've done is we have\
had these two classes that both are using the same method as what we\
have up here in the parent class but we've changed their behavior and\
that's what polymorphism does is it's when you have a child class that\
inherits these methods from a parent class and then it overrides the\
behavior.

So right here we have access to content in all child classes but in\
this case, we decided to wrap that content in an H1 tag. Here we decided\
to wrap it in a div tag and so we have different behavior with these\
child classes and because of it, we have some pretty powerful behavior\
in a very short amount of code. You can see we only have a few different\
classes here but we were actually able to create our own custom HTML\
generator just by doing that and we leverage Object-oriented programming\
we leveraged inheritance and polymorphism.

***

### Code

```python
# 03 - 130

class Html:
    def __init__(self, content):
        self.content = content

    def render(self):
        raise NotImplementedError('Subclass must implement render method')


class Heading(Html):
    def render(self):
        return f'<h1>{self.content}</h1>'

class Div(Html):
    def render(self):
        return f'<div>{self.content}</div>'

tags = [ Div('Some Content'), Heading('This is a Heading'), Div('Another Div') ]

for tag in tags:
    print( str(tag) + ': ' + tag.render() )
```
