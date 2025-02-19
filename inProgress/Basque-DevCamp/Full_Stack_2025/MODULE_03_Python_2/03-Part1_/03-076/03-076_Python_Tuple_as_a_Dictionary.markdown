# MODULE 03-076: Tuples as Dictionary Keys

## Using Tuples as Dictionary Keys in Python

Tuples can serve as dictionary keys because they are immutable, unlike lists.   

This allows them to store compound key information, which is particularly useful when additional metadata is needed inside the key itself.

****

## 📌 Why Use Tuples as Dictionary Keys?

✔ **Immutability** → Tuples can't be modified, ensuring the keys remain stable.
✔ **Multiple Attributes in Keys** → Allows for cleaner data representation.
✔ **Efficient Lookup** → Dictionary keys are hashed, and tuples work well as hashable keys.
✔ **Better Organization** → Instead of concatenating strings (`"1_premier"`), we store structured data.

---

## 📌 Practical Example: E-commerce Package Tracking

Tuples as dictionary keys are a **powerful** way to structure data when dealing with **multiple attributes** per key.   

In an **e-commerce system**, they allow us to efficiently track **packages with different priorities** and retrieve products dynamically.

The packaging service tracks different shipping packages. Each package has:

- A **priority level** (e.g., 1 for high-priority, 2 for standard priority).
- A **package type** (e.g., 'premier', 'mvp', 'standard').
- A list of **product IDs** included in that package.

Instead of using simple string keys, we use **tuples as dictionary keys** to encode multiple attributes inside the key.

### **🔹 Creating the Data Structure**

```python
# Dictionary where keys are tuples (priority, package name), values are lists of product IDs
priority_index = {
    (1, 'premier')  : [1, 34, 12],
    (1, 'mvp')      : [84, 22, 24],
    (2, 'standard') : [93, 81, 3]
}
```

Here:

- `(1, 'premier')` → Represents a **high-priority** package named *Premier*.
- `(1, 'mvp')` → Another **high-priority** package named *MVP*.
- `(2, 'standard')` → Represents a **standard-priority** package named *Standard*.
- Each **tuple key** is mapped to a **list of product IDs** inside that package.

---

### **🔹 Querying the Dictionary**

#### **1️⃣ Listing Available Package Keys**

```python
# Retrieve all package keys (tuples)
print(list(priority_index.keys()))    # [(1, 'premier'), (1, 'mvp'), (2, 'standard')]
```

#### **2️⃣ Accessing Products in a Specific Package**

```python
# Retrieve products inside a specific package
print(priority_index[(1, 'mvp')])     # [84, 22, 24]    
```



****

## Video lesson Speech

In extending our knowledge on Python tuples in this guide we're going to walk through a very unique way that you can use tuples and you're going to see this in a number of various code libraries and so I want you to be familiar with it.

****

You may not choose to build this yourself from scratch but I have seen code libraries that will return a tuple in this way and so what we're going to cover is how you can use a tuple as a dictionary key and that may sound a little bit strange up until this point of course whenever we work with dictionaries the keys were always string values.

But, now, we can actually add multiple values inside of each one of those keys.   

So, what I'm going to do for an example :



Let's imagine that we had an e-commerce site and we wanted to keep track of the various packages that we had. 




We also wanted to include some metadata into the Keys, so I'm going to create a variable here called <mark>Priority index</mark> and I'm going to place a dictionary inside of it.

```python
priority_index = {
}
```

Now, the very first package I want it to have a weight of one and then because this is a tuple I can pass in another value.   

And so this package is called the premier package and then from there, I can add a 
colon and then put some product IDs like 1, 34, and 12 in a list.

```python
priority_index = {
 (1, 'premier'): [1, 34, 12],
```

Now, I can duplicate this and have a dictionary.   

The second package is also going to have a weight of 1 and then it's going to be called the **MVP package*,  and then we can pass an `84`, `22`, and `24` just made-up product 
IDs in a real application those would be coming in from the database.

Now, in this last item this last package, I'm going to give it a weight of 2 and this is just going to be called let's just call it the standard package and this is going to have its own set of ID's so it's a 93, 81, and 3.

```python
priority_index = {
 (1, 'premier'): [1, 34, 12],
 (1, 'mvp'): [84, 22, 24],
 (2, 'standard'): [93, 81, 3],
}
```

So, **what we have here is a very interesting kind of data structure** because we're combining all three of the popular Python data structures.  


 We have a dictionary, we have a tuple that is being used as a key and then the value is the list.   

And so, **what this allows us to do is actually to add metadata directly into our key**.

Usually, our keys are just strings and they have to be unique but what we have here is a situation where we can actually have multiple items in the key itself and so the way we can work with this is let's say I want to print this out.  

 I'm going to convert it to a list and then I'm going to call my priority index dictionary and then call keys on it.  

 And remember **we need to convert this to a list because if we simply call keys on priority index it's just going to give us that view where we want to have a list that we can actually work with**.

So, now, if I run this code ,you can see that we have the ability now to access these keys:

![large](./03-076_IMG1.png)

You could use all of the standard ways of grabbing them, so you could grab items and anything that we were using before you could use it with our traditional dictionaries. 

You can use here the difference is instead of a set of strings.   

Now, we get a set of tuples so say that you were building this into an application and you wanted to know what your top packages were.  

 Or say that you only wanted to feature your packages that had a weight of 1.

Then, you could loop over which we're going to learn about looping later on in the course you can loop over these keys grab the values and only select the items that have this weight of 1 and then it will ignore all the rest of them so it's a very cool way of right inside of the key itself to have some additional information.   

So, in summary, that is how you can utilize tuples in Python as your dictionary keys.

****



## Code

```python
# 03-076: Tuples as Dictionaries

# Use cases:
# An e-commerce site, package tracking service.
# Some metadata is included into the Keys.
# 

priority_index = {
    (1, 'premier')  : [1, 34, 12],
    (1, 'mvp')      : [84, 22, 24],
    (2, 'standard') : [93, 81, 3]
}

# Use cases 2:
# List all available Packaging categories:

print( list( priority_index.keys() ) )  # [(1, 'premier'), (1, 'mvp'), (2, 'standard')]


# Show what products are inside a specific package tariff:
## As a list, or original format (must know all dict keys)

print( priority_index[1, 'mvp'] )   # [84, 22, 24]



```
