# MODULE 03 - 125: Python - Dunder Methods 2: \_\_repr\_\_

***

In the previous guide, we explored the **`__str__` dunder method**, which is used to generate **human-readable** representations of objects. Now, we turn our attention to a closely related method: **`__repr__`**.

At first glance, `__repr__` appears very similar to `__str__`, but they serve **distinct purposes**:

* **`__str__`** is designed for **user-friendly output**.
* **`__repr__`** is intended for **developer-friendly debugging** and raw object representation.

🔗 **Reference:** [Python `__repr__` Method](https://docs.python.org/3/reference/datamodel.html#object.__repr__)

***

## 🔹 What Is `__repr__` and Why Use It?

The `__repr__` method provides a **precise, unambiguous representation** of an object, typically meant for **logging, debugging, and development purposes**.

### 🔍 Key Differences Between `__str__` and `__repr__`

| Method     | Purpose              | Output Type               |
| ---------- | -------------------- | ------------------------- |
| `__str__`  | User-friendly output | Readable, formatted text  |
| `__repr__` | Debugging & logging  | Raw, detailed object info |

### ✅ Example: `__str__` vs `__repr__`

```pyth
class Invoice:
    def __init__(self, client, total):
        self.client = client
        self.total = total

    def __str__(self):
        return f"Invoice from {self.client} for {self.total}"

    def __repr__(self):
        return f"Invoice({self.client}, {self.total})"

inv = Invoice("Google", 500)
print(str(inv))  # Invoice from Google for 500
print(repr(inv)) # Invoice(Google, 500)
```

📌 **What Happens?**

* `__str__` provides a **formatted description**.
* `__repr__` provides a **structured representation**, useful for debugging.

🔗 **Reference:** [Python `__str__` vs `__repr__`](https://docs.python.org/3/library/functions.html#repr)

***

## 🔹 When to Use `__repr__`

✅ **For Debugging & Logging** → `__repr__` makes it easy to inspect object attributes.\
✅ **For Data Analysis** → Helps represent raw data in structured logs.\
✅ **For Reconstructing Objects** → In some cases, `__repr__` output can be used to recreate an object.

***

## 🔹 Best Practices for `__repr__`

📌 **Always aim for clarity.** `__repr__` should output enough detail to understand the object's state.\
📌 **Follow the convention** → The best practice is to return a string that could be used to **recreate** the object.\
📌 **Use both `__str__` and `__repr__`** → `__str__` for users, `__repr__` for developers.

***

## 📌 Summary

* **`__repr__`** provides a raw, structured representation of an object.
* It is mainly used for **debugging, logging, and object introspection**.
* **`__str__` is for readable output, while `__repr__` is for developers**.
* Following best practices ensures objects are **easily identifiable and reproducible**.

***

## Video lesson Speech

In the last guide, we walked through the Dunder string method and the goal\
of Dunder string once again is to give some pretty output for the\
values and the details with our class.

***

Now there is a very similar method and it's called Dunder repr and that's what we'll talk about in this guide. If you have never seen it before it is very similar to Dunder string with the key difference being that usually Dunder repr is used more for raw output so you usually do not format it nicely. It's something that you would do like output to your logs or to an error log or something like that.

And so this is going to be a quick guide we're going to see how we can use it. And as you'll see we're going to use it almost identically to how we use Dunder string and in your day to day development you may or may not use both of these in your class. If you have a very basic class like we have right now there's not going to be a huge need to do both of them because Dunder string is going to give you the exact same details but you can imagine a class that is quite a bit larger you may want to have the ability to have even more raw output and that's really where repr comes in.

So if I say return here and now I'm going to format our invoice so it's not just this nice sentence but instead now it's going to look more like an object output. So I'm gonna say formatted string invoice do a less than sign and you don't have to do it exactly my way I'm just showing an example of what you might see in some data logs.

And so inside of here, I can put the values and inside of that put some formatted values so self.client and then a comma and then put it in curly braces self.total and for something like this you may even want to go and name the attribute. So this is a full raw dump of all of the data in the instance of the class. So here I can say here is the data that is in the client and here is the data that we have for our total.

If I save this now and I'll duplicate this line so we can see these right next to each other. I can call this exactly like how we called string where I'm just going to call repr on the entire instance of invoice and if I run this now you can see that we have different output.

![large](../../../../../../../.gitbook/assets/03-125_IMG1.png)

Now like you may have noticed there is no difference at all in regards to the implementation. The only difference is the name and then what we've done is we've changed what it represents and so that's what the common pattern you'll find in Python is that you use string for your nice output maybe something that is easy to read and then with Repr. This is the true raw data of the instance of the class.

And as you can see right here that's exactly what we've done. We have invoice from Google for 500 and then here we have the details we say invoice and then values we have client Google total 500. So my rule of thumb is whenever I use repr I wrap up all the attributes any kind of data that I know I'm going to need to use whenever I'm performing debugging and then it can be a very helpful tool both for logs and also when I'm trying to fix a bug in a program.

## Code

```python
# 03-125: Dunder __repr__

class Invoice:
    def __init__(self, invoice_id, client, total):
        self.invoice_id = invoice_id
        self.client = client
        self.total = total

    def __str__(self):
        return f'\nInvoice # {self.invoice_id}:\nFrom {self.client}.\nTotal ammount: {self.total} €'
    
    # __repr__
    def __repr__(self):
        return f'\nInvoice <value: invoice_id: {self.invoice_id}, client: {self.client}, total: {self.total}'
    
inv_client_1 = Invoice('INV-000354724','Google', 500.00)
print(str(inv_client_1))
print(repr(inv_client_1))       # Invoice <value: invoice_id: INV-000354724, client: Google, total: 500.0
```
