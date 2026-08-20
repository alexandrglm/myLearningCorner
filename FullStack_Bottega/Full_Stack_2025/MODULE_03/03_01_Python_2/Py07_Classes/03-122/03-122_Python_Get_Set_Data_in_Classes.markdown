# MODULE 03 - 122: Python - How to Get and Set Data in a Python Class

In object-oriented programming (OOP), one of the core concepts is **getting and setting data** within a class. Many languages, such as **Java**, require explicit **getter** and **setter** methods to retrieve and modify attributes. However, **Python simplifies this process**, allowing direct access to attributes **without additional methods**.

This guide will explore:\
✅ How Python allows **direct access** to class attributes.\
✅ Why other languages enforce **getter and setter methods**.\
✅ When and why you might want to **control access** to attributes.

🔗 **Reference:** [Python Classes and Instances](https://docs.python.org/3/tutorial/classes.html#class-and-instance-objects)

***

## 🔹 Direct Attribute Access in Python

Unlike many programming languages, **Python allows direct access to object attributes** without the need for explicit getter and setter methods.

### ✅ Example: Getting Data

```python
class Invoice:
    def __init__(self, client, total):
        self.client = client
        self.total = total

invoice = Invoice("Google", 100)
print(invoice.client)  # Google
print(invoice.total)   # 100
```

📌 **What Happens?**

* `self.client` and `self.total` are **instance attributes**.
* We can directly access them using `invoice.client` and `invoice.total`.

🔗 **Reference:** [Python Instance Attributes](https://docs.python.org/3/tutorial/classes.html#class-and-instance-objects)

***

## 🔹 Modifying Attributes (Setting Data)

Python also allows modifying attributes **after** an object has been created.

### ✅ Example: Setting Data

```python
invoice.client = "Yahoo"
print(invoice.client)  # Yahoo
```

📌 **Key Takeaways:**

* Unlike many languages, Python lets you **override attribute values directly**.
* No need to define a separate `set_client()` method.

🔗 **Reference:** [Python Object Modification](https://docs.python.org/3/reference/datamodel.html#objects-values-and-types)

***

## 🔹 Comparing Python to Other Languages

Most **statically typed** languages enforce **encapsulation**, preventing direct access to attributes. They require:

✅ **Getter methods** to retrieve data.\
✅ **Setter methods** to modify data.

### 🛑 Example: Java (With Getters and Setters)

```java
public class Invoice {
    private String client;
    private int total;

    public Invoice(String client, int total) {
        this.client = client;
        this.total = total;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String newClient) {
        this.client = newClient;
    }
}
```

📌 **Why Do Other Languages Require This?**

* **Encapsulation** → Protects data from unintended modifications.
* **Validation** → Prevents invalid values from being set.
* **Access Control** → Allows defining **read-only** attributes.

🔗 **Reference:** [Encapsulation in Java](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)

***

## 🔹 Should You Always Use Direct Access in Python?

While Python allows **direct modification of attributes**, it is not always a best practice. **Unrestricted access can lead to unintended changes**.

### ✅ Best Practices:

* Use **direct access** when working with **simple, unprotected attributes**.
* Use **getter/setter methods** (via `@property`) when you need **controlled access**.
* Consider **private attributes (`_attribute`)** to discourage direct modification.

🔗 **Reference:** [Python Properties](https://docs.python.org/3/library/functions.html#property)

***

## 📌 Summary

* Python allows **direct access to attributes** without requiring getters and setters.
* Other languages enforce **access control** through explicit methods.
* Direct modification is **convenient but should be used carefully**.
* In future guides, we will explore **property decorators** to control attribute access.

***

## Video lesson Speech

When it comes to developing in **object-oriented programming languages**, a couple of terms that you are going to hear quite a bit are **getter** and **setter functions**.

***

If you have ever built anything in **Java** or similar languages, those are functions that you need in order to add or query data from an object.

How to Get and Set Data in a Python Class In Python, however, this entire process is actually done for you. You do not have to create your own getter or setter functions.

Now, I'm going to show in a future guide how to work with **properties**, which allow you to have control over what data you can override and what data you have access to in your object. If that doesn't make any sense to you, don't worry. We're going to walk through a number of examples. Just know that what I'm going to show you right here is not possible in the majority of popular programming languages.

The process I'm going to show you right here can be **frowned upon** because it gives you too much access and allows you to essentially do anything you want. So, I'm going to add that caveat because I don't want you to learn this and then just go wild with being able to change all your values in your classes. That's why I want to add that caveat. Later on, I'm going to show you the proper way to do it if you really need to protect your data.

But for right now, essentially, we're not going to have to change any code here whatsoever because all of the features for being able to query and override values are set for us.

I can come down here, and I only have one instance (I don't have multiple ones) just to make it easy for us to see what's going on. But because everything is an object in Python, that's what makes it possible for us to query and set values anytime we want.

We don't have to create special functions to get data because if I come down here and I want to get access to the `client` value, I can just type:

```python
print(google.client)
```

Because this is an object, when we create this `Invoice` class or when we instantiate it, it gets stored as an object inside of `google` right here inside this variable.

![large](../../../../../../../.gitbook/assets/03-122_IMG1.png)

If we want access to an attribute in that class or in that object, like `client`, we have access automatically. So, if I say:

```python
python invoice.py
```

You can see it prints out `Google` right there.

![IMG](../../../../../../../.gitbook/assets/03-122_IMG2.png)

And just like that, if I were to do the same thing for the `total`, it gives us access to `100`.

![IMG](../../../../../../../.gitbook/assets/03-122_IMG3.png)

Now, if Python is your first programming language, what I just showed you may seem logical—that you have access to those elements. But I can tell you that it is very rare that programming languages allow this level of access. Usually, you have to create specific functions to get or set values.

The other thing we can do, which is also pretty rare, is that we can **set values** after we have created the entire object. This is something pretty rare, but I'll show you right here. I'm going to keep the `client` here and come down and say:

```python
google.client = 'Yahoo'
```

Take this exact code here, and we will save it. If I switch over here\
and run this, you can see that it prints out the client. It prints out\
the first one we created, where it says `Google`, and then it allowed me on line 15 over here to override the `client` value.

![large](../../../../../../../.gitbook/assets/03-122_IMG5.png)

## VIdeo lesson Speech

So, that is in other languages called the **setter process**, where we were able to go into the object and then set a value.

Usually, you were only able to set the value when you create the class, and then\
later on, if you want to change it or override a value, you need to\
create a setter function.

But once again, because everything inside of\
Python is an object, including classes, we have the ability to reach\
into that class and override and set the value like you saw on line 15.

***

## Code

```python
class Invoice:

    def __init__(self, client, total):
        self.client = client
        self.total = total

    def formatter(self):
        return f'{self.client} owes: ${self.total}'


google = Invoice('Google', 100)

print(google.client)

google.client = 'Yahoo'

print(google.client)
```

***

## Coding Exercise

```python
# 03-122: Get an Set data in Classes

class Invoice:

    def __init__(self, client, total):
        self.client = client
        self.total = total

    def formatter(self):
        return f'{self.client} owes: ${self.total}'

google = Invoice('Google', 100)

# Getting data
print(google.client)
print(google.total)


# Setting Data

google.client = 'Yahoo'
print(google.client)
```
