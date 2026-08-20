# 03-123\_Python\_Properties\_Decorators

## MODULE 03 - 123: Python - How to Work with Python Properties and Decorators

In the previous guide, we explored how Python allows **direct access** to class attributes.

While convenient, unrestricted access can lead to issues, especially in larger applications. **Encapsulation**—hiding or restricting access to data—helps prevent accidental modifications that could break a program.

Python provides a built-in way to **control access to attributes** using:\
✅ **Properties** (via `@property`) to create controlled getters.\
✅ **Setters** (via `@property_name.setter`) to restrict modifications.\
✅ **Naming conventions** (single `_protected` and double `__private` underscores) to indicate attribute scope.

🔗 **Reference:** [Python Properties](https://docs.python.org/3/library/functions.html#property)

***

### 🔹 Understanding Attribute Encapsulation

Python does not enforce strict **private** and **protected** attributes like other languages (e.g., Java or C++).

Instead, developers follow conventions:

| Naming Convention  | Access Level | Description                                                                   |
| ------------------ | ------------ | ----------------------------------------------------------------------------- |
| `self.attribute`   | Public       | Can be accessed and modified freely.                                          |
| `self._attribute`  | Protected    | A convention signaling "do not modify directly."                              |
| `self.__attribute` | Private      | Python name-mangles it (`_Class__attribute`), making direct access difficult. |

🔗 **Reference:** [Python Class and Instance Variables](https://docs.python.org/3/tutorial/classes.html#private-variables)

***

### 🔹 Implementing Properties in a Class

Python’s `@property` decorator allows defining **getter methods** while keeping the syntax as if accessing a normal attribute.

#### ✅ Example: Using `@property` to Define a Getter

```python
class Invoice:
    def __init__(self, client, total):
        self._client = client  # Protected attribute
        self._total = total

    @property
    def client(self):
        return self._client
```

📌 **Key Takeaways:**

* The attribute is **marked as protected** (`_client`).
* The `@property` method **acts as a getter**.
* Accessing `invoice.client` is now controlled through the method.

🔗 **Reference:** [Python `@property` Decorator](https://docs.python.org/3/library/functions.html#property)

***

### 🔹 Controlling Modifications with Setters

We can **allow controlled modification** of an attribute using `@property_name.setter`.

#### ✅ Example: Adding a Setter

```python
class Invoice:
    def __init__(self, client, total):
        self._client = client
        self._total = total

    @property
    def client(self):
        return self._client

    @client.setter
    def client(self, client):
        self._client = client
```

📌 **What Changes?**

* The `@client.setter` method **allows modifying `_client` safely**.
* Now, assigning `invoice.client = "Yahoo"` will call the setter method.

#### ✅ Example: Using the Setter

```python
invoice = Invoice("Google", 100)
print(invoice.client)  # Google

invoice.client = "Yahoo"
print(invoice.client)  # Yahoo
```

🔗 **Reference:** [Python Property Setter](https://docs.python.org/3/howto/descriptor.html#properties)

***

### 🔹 Preventing Modification with Read-Only Properties

Sometimes, we want an attribute to be **retrievable but not modifiable**. To achieve this, we define a `@property` without a setter.

#### ✅ Example: Making an Attribute Read-Only

```python
class Invoice:
    def __init__(self, client, total):
        self._client = client
        self._total = total

    @property
    def total(self):
        return self._total
```

#### 🛑 Attempting to Modify a Read-Only Property

```python
invoice = Invoice("Google", 100)
invoice.total = 200  # ❌ Raises AttributeError
```

📌 **Why Is This Useful?**

* Prevents accidental modifications.
* Ensures data integrity for values that **should not change after initialization**.

🔗 **Reference:** [Python Read-Only Properties](https://docs.python.org/3/library/functions.html#property)

***

### 🔹 Comparing Direct Access vs. Properties

| Approach                   | Flexibility | Encapsulation | Recommended For                                     |
| -------------------------- | ----------- | ------------- | --------------------------------------------------- |
| Direct Attribute Access    | High        | Low           | Small programs, simple use cases                    |
| Using `@property`          | Medium      | Medium        | Readability, guiding best practices                 |
| Using `@property` + Setter | High        | High          | Large applications, preventing accidental overrides |

***

### 📌 Summary

* **Python allows direct attribute access,** but this can lead to unintended modifications.
* **Encapsulation helps control access to attributes** and prevent accidental changes.
* **Use `@property` for controlled getters.**
* **Use `@property_name.setter` to allow safe modifications.**
* **For read-only attributes,** omit the setter method.

***

### Video lesson Speech

In the last guide, we walked through how we could get and set values inside of a Python class. However, at the very beginning of the guide, I mentioned how the practice of simply overriding and having access to all of the data inside of a class in the way that we did it—just like how we were able to grab the data right here and how we're able to set it at any time—is considered in some circles a poor practice.

***

It's perfectly fine to use in certain circumstances; however, the issues that can arise usually are ones that are a little bit more advanced and they deal with data encapsulation.

This means that imagine that you're building out this class and other different programs are going to be using it. If they accidentally override something that they shouldn't even have access to, then it could break the entire program.

That's a reason why simply letting all of your data elements be wide open in all circumstances can be bad. Now, I will add that there are plenty of times where being able to simply access these values works perfectly fine.

Usually, when you run into the issue that I'm referring to—and what I'm going to show you how you can fix—it usually happens when you're building out very large systems and you're building helper modules that other people are going to be using. That's when you really have to be very careful.

But for right now, what I'm going to show you is how to do this and use what is called the property decorator. So we're going to be able to fix the whole issue where everyone has access to all of the data.

And so we may have a situation where we want to pick and choose and say, "Okay, some of the data should be able to be accessible just like we have it right here."

![IMG](../../../../../../../.gitbook/assets/03-123_IMG1.png)

Then we want to protect some elements, so we may not want the client or the total to be able to be overridden. And so what I'm going to do is I'm gonna get rid of our print statements here at the bottom just so we don't get things mixed up, and now I'm going to come up to the top and start building out these properties.

But before I do that, one thing I want to show and talk about is a standard convention in the Python community: any time that you're dealing with data that you want to have either private or protected.

And I'll talk about what that means. Whenever you're doing that, you want to add underscores in front of it. So if you want something protected—and what that means is that anything in the class you want to have access to and any child classes.

So when we start to talk about inheritance, say that we have an invoice right here. And later on, we're going to talk about how we can create a subclass called maybe a special invoice, and it's going to inherit from the invoice. Don't worry if none of that makes sense; just know that that's a very popular process in the object-oriented programming community where you can have parent-child relationships with classes.

And so what protected means is that the child classes will have access to this data. And so whenever you want to do that, just put an underscore right in front of it. It's very important to note that there is nothing special at all about the underscore; your code is going to work exactly the same way if you have it there or not.

The underscore is a clue to you and to future developers working on your program that this data attribute should be protected.

Now, if you have a data attribute that you want to have that should only be able to be accessed inside of this one class—not even child classes—that's called a private attribute. And the common convention for using that is two underscores before the variable name.

We're not going to use the private one here; I'm just going to use the protected one because that's one of the more common ones that you're going to be using in your programs.

I'm gonna make both of these protected. I'm going to add an underscore before `client` and before `total`, and so that means that if I come down to this formatter, I'm going to do the same thing here for `self._client` and `self._total`, and they have now their own set of the correct calls.

![IMG](../../../../../../../.gitbook/assets/03-123_IMG2.png)

Now let's just verify that everything is working properly, so I'll say `print(google.formatter)`, and we shouldn't have any change whatsoever; everything should still work. If I run that, you can see everything there is still working properly. Google owes one hundred dollars, so that works.

![IMG](../../../../../../../.gitbook/assets/03-123_IMG3.png)

But now let's talk about how we can use properties. So if I come back into the class, I'm going to use an `@` symbol followed by the name `property`. And so this is going to do—this is called a decorator, and what it essentially does is it decorates, it wraps around the property that we're wanting to work with.

So the syntax for doing that is you're going to create a function now called `client`, and notice how this is mapped pretty much right here. And this is the standard convention; it's not `_client`; it's actually just the word `client`, and then you pass in `self`.

And then inside of here, you simply say `return self._client`. And so now what you can do is you can come down here, and we don't need this formatter anymore; let's just print out our Google client, and let's run it again, and that is working properly.

![IMG](../../../../../../../.gitbook/assets/03-123_IMG4.png)

![IMG](../../../../../../../.gitbook/assets/03-123_IMG4b.png)

Now, if your first question is, "Why in the world would we need to do that? Because technically, everything was already working." Well, now what we've done is we have given a clear distinction with how we've written our code on how you should treat this invoice.

So whenever I'm looking at Python code and I see that there is a property decorator here and then I see what's underneath it, this tells me that I will most likely want to access what is here at some point. So that means I have access to directly call on `client` and then get that data back.

If I come to a class—either one I've written or that someone else has written—and I just see a bunch of these `self._` items and then I see `client` and `total`, but I don't see any property decorators, what that tells me is that all of this data here is simply for the internal usage of the class and that I should not call on those directly.

And so whenever we're writing code, we're not just writing code that works; we're also writing code that communicates the story on how our programs should be run and how others should use our code. That's just as important as making sure that our programs work properly.

So a lot of the common conventions that you see me doing and also that you'll find in the Python community are just as much about code readability as they are about performance or anything related to that.

So now with all of that in place, we have our property here, and let's come and let's do the same thing for our `total`. So I'm going to come here, say `total`, and this is going to return `total`, and we'll hit save. And so everything here is working properly.

So if I come here and I want to print out the total, hit save, run it again, you can see we have access to Google and the hundred.

![IMG](../../../../../../../.gitbook/assets/03-123_IMG5.png)

So far, we've added two properties, and these take care of our getters, so this allows us to get the values of `client` and `total`.

Now let's talk about our setter values. So let's imagine a scenario where we don't want to give the ability to override the `total`, and so that is, I think, a pretty common use case for that. And so we're not going to create a setter for `total`, but we are for `client`, so we want to give the ability to override the `client` value, and the way we can do that is not with a property decorator but instead, we're going to say `@` and then whatever the name is of the value that we want the ability to override.

So I'm gonna say `@client` because that is what I'm wanting to override—this `client` value right here. I'm gonna say `@client.setter`, and then inside of here, I'm going to create a new function. So I'll say `def client`, and then pass in `self`, pass in `client`, and now I'm not going to return anything. I'm simply going to override the value in the class, so I'll say `self._client = client`.

And now if I save this, I can come down here and keep my `client` value, and then let me override it right below. So say `google.client`, and now we can set this equal to anything we want. And then I'll copy this and put it down below, and so now if everything's working, what we should have is it should print out Google for right here, it should override with Yahoo, and then it should print out Yahoo.

So save it, come over here, run it one more time, and that is working perfectly.

![IMG](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Object+Oriented+Programming+\(OOP\)+in+Python/How+to+Work+with+Python+Properties+and+Decorators+%23+1570/image16.png)

So that is how you can be very explicit with your getters and setters in Python classes.

***

### Code

```python
class Invoice:

    def __init__(self, client, total):
        self._client = client
        self._total = total

    def formatter(self):
        return f'{self._client} owes: ${self._total}'

    @property
    def client(self):
        return self._client

    @client.setter
    def client(self, client):
        self._client = client

    @property
    def total(self):
        return self._total

google = Invoice('Google', 100)

print(google.client)

google.client = 'Yahoo'

print(google.client)
```

***

## Coding Exercise

We want to ensure that our `size` attribute can be retrieved,\
but not set. Use the appropriate syntax to protect the size attribute.\
Then, use the 'property' decorator to build a getter to return the\
protected data. You do not need to instantiate the class.

```python
class Garage:
  def __init__(self, size):
    #   Protect the size attribute
    self.size = size
    self.cars = []

  # add decorator here

  def open_door(self):
    return "The door opens"
```
