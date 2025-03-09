# MODULE 03 - 128: Python - Class vs. Instance Attributes

Throughout this section on **object-oriented programming (OOP)** in Python, we’ve been working extensively with **attributes**. However, we’ve primarily focused on **instance attributes**, which belong to individual objects.

In this guide, we’ll explore the fundamental differences between:

- **Instance attributes** → Unique to each object.
- **Class attributes** → Shared across all instances of a class.

🔗 **Reference:** [Python Classes and Instances](https://docs.python.org/3/tutorial/classes.html#class-and-instance-variables)

---

## 🔹 Instance Attributes

An **instance attribute** is specific to an object (instance) of a class. Each instance maintains its own separate copy of the attribute.

### ✅ Example: Defining Instance Attributes

```python
class Website:
    def __init__(self, title):
        self.title = title
```

📌 **Key Takeaways:**

- The `__init__` method initializes **each instance** with a unique `title`.
- `self.title` stores the attribute at the **instance level**.

---

## 🔹 Creating Instances and Accessing Attributes

When we create multiple instances, each one has its own `title`:

```python
ws1 = Website("My Website Title")
ws2 = Website("My Second Title")

print(ws1.title)  # My Website Title
print(ws2.title)  # My Second Title
```

📌 **What Happens?**

- `ws1.title` and `ws2.title` store **different values**, meaning they do not share the same attribute.
- The attributes **exist independently** for each object.

🔗 **Reference:** [Python Instance Attributes](https://docs.python.org/3/tutorial/classes.html#instance-objects)

---

## 🔹 Using `__dict__` to Inspect Instance Attributes

Python provides the `__dict__` attribute to inspect an object’s stored attributes.

```python
print(ws1.__dict__)
print(ws2.__dict__)
```

### 📝 Example Output:

```
{'title': 'My Website Title'}
{'title': 'My Second Title'}
```

📌 **Why Is This Useful?**

- It reveals **all attributes associated with an instance**.
- It helps distinguish between **instance and class attributes**.

🔗 **Reference:** [Python `__dict__` Method](https://docs.python.org/3/library/stdtypes.html#object.__dict__)

---

## 🔹 Class Attributes

Unlike instance attributes, a **class attribute** is shared across all instances of a class. It is **defined outside the `__init__` method** and belongs to the class itself.

### ✅ Example: Defining a Class Attribute

```python
class DifferentWebsite:
    title = "My Class Title"
```

📌 **Key Takeaways:**

- `title` is **not inside `__init__`**, meaning it is a **class attribute**.
- All instances of `DifferentWebsite` will share **the same `title` value**.

---

## 🔹 Creating Instances and Accessing Class Attributes

```python
dw1 = DifferentWebsite()
dw2 = DifferentWebsite()

print(dw1.title)  # My Class Title
print(dw2.title)  # My Class Title
```

📌 **What Happens?**

- Both `dw1` and `dw2` reference the **same `title` value**.
- Changing `dw1.title` affects **only that instance**, but modifying `DifferentWebsite.title` affects **all instances**.

🔗 **Reference:** [Python Class Attributes](https://docs.python.org/3/tutorial/classes.html#class-and-instance-variables)

---

## 🔹 Key Differences: Instance vs. Class Attributes

| Attribute Type         | Defined In         | Unique Per Instance? | Shared Across Instances? |
| ---------------------- | ------------------ | -------------------- | ------------------------ |
| **Instance Attribute** | `__init__`         | ✅ Yes                | ❌ No                     |
| **Class Attribute**    | Outside `__init__` | ❌ No                 | ✅ Yes                    |

📌 **When to Use Each?**

- **Use instance attributes** when **each object needs its own data**.
- **Use class attributes** for values that should be **shared** across all instances.

---

## 🔹 Using `__dict__` to Inspect Class Attributes

Class attributes **do not appear** in an instance’s `__dict__`, because they are stored at the class level.

```python
print(dw1.__dict__)  # {}
```

📌 **What Happens?**

- The dictionary is **empty** because class attributes **do not belong to instances**.

However, accessing `DifferentWebsite.__dict__` **does** show the class attributes.

```python
print(DifferentWebsite.__dict__)
```

🔗 **Reference:** [Python `__dict__` and Class Attributes](https://docs.python.org/3/library/stdtypes.html#object.__dict__)

---

## 📌 Summary

- **Instance attributes** belong to individual objects → Defined inside `__init__`.
- **Class attributes** are shared across all instances → Defined outside `__init__`.
- Use `__dict__` to inspect **instance attributes**.
- Class attributes are **not stored in `__dict__`** at the instance level but can be found in the class itself.

****

## Video lesson Speech

Throughout this section on object-oriented programming in Python, we've been 
working with attributes in relation to classes quite a bit. But for the 
most part everything that we've done has been related to instance 
attributes.

****

What I mean by that is if I were to create a class here and I'll call it class website. And inside of here, I'm going to have a Dunder init constructor. So say init and then this is going to receive self and it's also going to receive the title of the website inside of here. I'm going to set this attributes value or I should say this instance attributes value to self.title and set this equal to whatever title that gets passed in. 

```python
class Website:
    def __init__(self, title):
        self.title = title
```

Now if I were to call this class, so if I were to instantiate it, so I'm gonna say ws equals Website and then inside of it I'll just pass in 'My Website Title' and then if I want access to this I'll need to print it out so say print ws.title and let's print this out so `python oop_guide.py` and you can see it prints out My Website Title and that's working properly. 

![large](./03-128_IMG1.png)

Now another helpful Dunder method here is if I were to simply call out `ws.__dict__` which is going to convert this to a dictionary. If I run this again you can see that this is a pretty helpful way of seeing all of the attributes and their values. 

![large](./03-128_IMG2.png)

So here you can see that we have a dictionary now that says 'title' and then 'My Website Title' which is exactly what we created. So this is an instance attribute and what that means is it's an attribute that belongs to this specific instance. If I were to come down here and create another instance so if I were to come down here and say ws_two I would need to pass in another value here so I could say second title and then when I say ws_two this is going to print out the second version of this if I switch over here and print it out. You can see that we have title my website title and then title second title. 

![large](./03-128_IMG3.png)

So far this is exactly what we've covered here in this section and what I want to do is reinforce that these are data values that are specific to this instance. 

What I want to talk about now is a class attribute and so I'm going to come up here and let's comment all of this out so I'm going to just give some room to work with here on the bottom but will be able to still see all of our code. So now coming down here I'm going to create another class and this is going to be `class DifferentWebsite`. And then this is not even going to take in a constructor. But instead what I'm going to do is I'm just going to pass in a variable here so I'm just going to say title equals my class title and now what I can do is I can create an instance of this class. And so here I can say dw for different website equals different website and I do not have to pass anything in there 

Now if I want to print this out I can say print dw here and then dot the Dunder dict function here just so he can see what we have access to. And now if I do this you can see we don't get any attributes. 

![large](./03-128_IMG4.png)

So this is kind of interesting right because you would think that we set our title we hardcoded it inside of our Website class or a different website class and you'd think that we would have access to it in the same way that we had access to our values up here. That is one of the key differences between having what is called a class attribute which is what we have here on line 13 versus an instance attribute. 

So if I come back over here and I want to have access to title, if I run this you can see it prints out perfectly. 

![large](./03-128_IMG5.png)

My class title and so we have access to the values but they are not treated the exact same way as what we had up here. Because this is a class attribute and so it is something that simply belongs to the class, you can think of this very similar to having a function or a method inside of the class. It's something that is hardcoded in and you can have access to it and if you come down here and do exactly what we did before. So if I say dw_two and dw_two again as you may guess right here. This is going to simply print out my class title twice.

![large](./03-128_IMG6.png)

And so the difference between a class attribute and an instance attribute really comes down to the name, I think it was named very well, a class attribute is an attribute that belongs to the class definition. So it's hardcoded directly into the class and then you can call it whenever you need it. 

An instance attribute belongs to the instance, just like you see right here. We needed to pass that value in directly into the instance whenever we created it and for every other instance of the class we had to pass in a different value and then we were able to have access to it. 

Now like I showed over here one of the easiest ways if you're working with someone else's code and you're simply calling it and you're not even looking at the source code. You can use that Dunder dict function right here to be able to print all of the values out to see which ones you have access to that are class attributes versus which ones are instance attributes.

****

## Code

```python
class Website:
  def __init__(self, title):
    self.title = title


ws = Website('My Website Title')
print(ws.__dict__)

ws_two = Website('My Second Title')
print(ws_two.__dict__)


class DifferentWebsite:
  title = 'My Class Title'

dw = DifferentWebsite()
print(dw.title)

dw_two = DifferentWebsite()
print(dw_two.title)
```
