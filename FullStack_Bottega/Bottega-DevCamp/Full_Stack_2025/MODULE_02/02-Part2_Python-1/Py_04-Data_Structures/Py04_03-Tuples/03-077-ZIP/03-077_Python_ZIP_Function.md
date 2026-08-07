# 03-077\_Python\_ZIP\_Function

### **Python - Zip Function (`zip()`)**

### **Overview**

The `zip()` function in Python is a built-in method that **allows combining multiple iterables (such as lists or tuples) into tuples, pairing corresponding elements together**.

It is especially useful when working with structured data, such as matrices, merging datasets, or aligning multiple sequences.

📌 **Python Documentation:** [zip()](https://docs.python.org/3/library/functions.html#zip)

***

### **🔹 Understanding `zip()`**

The `zip()` function takes two or more iterables and merges them into tuples where each tuple contains elements from the respective positions in the original iterables.

#### **Basic Syntax:**

```python
zip(iterable1, iterable2, ...)
```

* `iterable1, iterable2, ...` → The iterables that will be zipped together.
* Returns a `zip` object (an iterator of tuples).

#### **Example: Merging Two Lists**

```python
positions = ['2B', '3B', 'SS', 'DH']  # Baseball positions
players = ['Altuve', 'Bregman', 'Correa', 'Gattis']  # Players in respective positions

# Zipping the two lists together
scoreboard = zip(positions, players)

# Converting the zip object into a list
print(list(scoreboard))
```

**Output:**

```python
[('2B', 'Altuve'), ('3B', 'Bregman'), ('SS', 'Correa'), ('DH', 'Gattis')]
```

✔ Each player is paired with their respective position.

📌 **Note:** The result of `zip()` is a **zip object (iterator)**, so to view its contents, it must be converted to a list or another iterable.

***

### **🔄 Working with Different Lengths of Iterables**

If the input iterables are of unequal length, `zip()` stops at the shortest iterable, ignoring excess elements in longer iterables.

```python
positions = ['2B', '3B', 'SS']  # Only 3 positions
players = ['Altuve', 'Bregman', 'Correa', 'Gattis']  # 4 players

print(list(zip(positions, players)))
```

**Output:**

```python
[('2B', 'Altuve'), ('3B', 'Bregman'), ('SS', 'Correa')]
```

✔ The extra player (`'Gattis'`) is ignored because there is no corresponding position.

📌 **Best Practice:** If you need to ensure all elements are included, use `itertools.zip_longest()` instead:

```python
from itertools import zip_longest
print(list(zip_longest(positions, players, fillvalue='Unknown')))
```

**Output:**

```python
[('2B', 'Altuve'), ('3B', 'Bregman'), ('SS', 'Correa'), (None, 'Gattis')]
```

✔ Missing values are filled with `'Unknown'` (or another specified value).

📌 **Python Documentation:** [zip\_longest()](https://docs.python.org/3/library/itertools.html#itertools.zip_longest)

***

### **🎯 Real-World Applications of `zip()`**

#### **1️⃣ Merging Datasets**

`zip()` is commonly used to align and merge datasets, such as combining related lists into structured records.

```python
name = ['Pepito', 'Juanito', 'Menganito']
surname = ['Perez', 'Lopez', 'Diez']
id_card = ['73747274A', '0028144FH', 'token:6544df646543241sd6f4778654sdf']
id_type = ['NIF', 'PASSPORT', 'DigitalCert.']
phone = [600123123, 930025741, 699999999]

clients_records = zip(surname, name, id_type, id_card, phone)
print(list(clients_records))
```

**Output:**

```python
[
    ('Perez', 'Pepito', 'NIF', '73747274A', 600123123), 
    ('Lopez', 'Juanito', 'PASSPORT', '0028144FH', 930025741), 
    ('Diez', 'Menganito', 'DigitalCert.', 'token:6544df646543241sd6f4778654sdf', 699999999)
]
```

✔ This creates tuples of `(surname, name, id_type, id_cards)` for each client.

#### **2️⃣ Dictionary Construction with `zip()`**

You can create dictionaries using `zip()` by merging two lists: one for keys and one for values.

```python
# More use cases: Building a Dictionary

keys = ['+', '-', '*', '/']
values = ['Adds', 'Subs', 'Muls', 'Divs']

oper_dict = dict(zip(keys, values))
print(oper_dict)
```

**Output:**

```python
{'+': 'Adds', '-': 'Subs', '*': 'Muls', '/': 'Divs'}
```

✔ A dictionary is created from the zipped lists, **by wrapping our `zip(...)` onto `dict()` buil-in method.**

***

#### **3️⃣ Unzipping Data**

To extract back individual lists from a zipped object, use `zip(*zipped_data)`:

```python
# More use cases:   Unpacking Data !!! By using zip(*the_data)

scoreboard_zipped = [('2b', 'Altuve'), ('3b', 'Bregman'), ('ss', 'Correa'), ('dh', 'Gattis')]

positions_unzipped, players_unzipped = zip(*scoreboard_zipped)

print(list(positions_unzipped))
print(list(players_unzipped))
```

✔ The `*` operator unpacks the tuples back into separate lists.

**Output**

```python
['2b', '3b', 'ss', 'dh']
['Altuve', 'Bregman', 'Correa', 'Gattis']
```

***

### **📌 Summary & Best Practices**

✔ `zip()` is a powerful tool for merging multiple iterables.\
✔ Stops at the shortest iterable unless using `zip_longest()`.\
✔ Great for data transformation, dictionary creation, and structured processing.\
✔ When working with large datasets, prefer using iterators to avoid excessive memory use.

***

### Video lesson Speech

In this lesson, we're going to utilize a powerful function in the core Python library called the zip function and what this is going to allow us to do is actually **merge our lists or merge multiple lists into a set of tuples**.

***

Now, if you are in this course because you want to learn python for machine learning and data science this is going to be a very helpful tool because many of the algorithms that you build whenever you're working with machine learning algorithms are what are\
called **matrix matrices**.

What a matrix is:

* **It's a set of nested collections**.
* The `zip()` function is a great way of building those dynamically.

So, let's walk through an example.

I'm going to create a variable here called `possessions` and we're going to create a little scoreboard applicatio.

So, I'm going to say there is second base, there is third base, shortstop, and D.H.

```python
positions = ['2b', '3b', 'ss', 'dh']
```

It also needs a list of players and, **one important component to understanding whenever you're working with the zip function is the sorted order of your list**\*:

It's very important because, **if it's not sorted right, then your list or both of your lists are not going to merge properly**, so that could be an issue and it's something you have to watch out for.

So I'm going to set up another set of strings here,\
say the first item is `Altuve`, followed by `Bregman`, followed by `Correa`, followed by `Gattis`.

```python
players = ['Altuve', 'Bregman', 'Correa', 'Gattis']
```

These are mapped up so, in our scoreboard, what I want to do is to have a new collection and I want this collection to have a set of tuples where Altuve and second base are one element, third base and Bregman is another shortstop and Correa as a third and then DH and Gattis are the fourth items.

Now, if you were to try to do this manually you would need to loop over one of these elements and then you'd have to add each one of the array items or each one the list items, create a new tuple merge them together and that would be a little bit of a messy process.

That's why `zip()` does:

It allows us to merge those automatically.

So, this is what we're going to do is we're going to build a scoreboard variable and call the zip function and then for this we simply have to pass in the two lists that we want to merge.

So, you say possessions, then players.Now, if I print out our scoreboard we should have a new list and then it should have each one of these merged together as\
tuples.

Let's run this and you can see we have a zip object right here and that is one thing I do have to convert this to a list for One-Step and so let's convert this.

This returns a zip object as you can see but if we can just cast it as a list we're going to get exactly what we want.

So I run it now and it works.

![large](../../../../../../../../.gitbook/assets/03-077_IMG1.png)

So as you can see we have a list and inside of this list it has a set of four tuples.

We have our second baseman merged with Altuve, we have the third base with Bregman so on and so forth.

So, whenever you hear that you have two lists and you need to merge them together and you want to have a direct mapping.

So the first element is combined with the first element. The other list and so on and\
so forth this is where tuples come in and they can be very handy.

And this is a very common use for how python developers utilize tuples is when they are merging multiple lists together they're combining data and this can be part of a machine learning data processing side.

***

**It could be when you're building out API's and you want to merge different data components together.**

Imagine a situation where you're building out an e-commerce application and you want to merge elements from products to a shopping cart to having quantity items those kinds of things.

It's **any situation where you want to merge one data element into another and tuples and the zip function can allow you to do that.**\*\*

***

### Code

```python
# 03-077: ZIP Function zip()

# It merges many lists into a set of tuples
## Values MUST be correctly ordered, otherwise merging process will give wrong-unwanted correlations

positions = [
    '2b', '3b', 'ss', 'dh'
]

players = [
    'Altuve', 'Bregman', 'Correa', 'Gattis'
]

scoreboard = zip(positions, players)

print(list(scoreboard)) 
# [('2b', 'Altuve'), ('3b', 'Bregman'), ('ss', 'Correa'), ('dh', 'Gattis')]
# Each key has been merged with their own Values, into new immutable values, tuples.



# Another use case:

character_order = [(1, 'Ryu'), (9,'Honda'), (6, 'ChunLi')]
levels = [{'Power' : 87, 'Magic' : 155 }, {'Power' : 254, 'Magic' : 66 }, {'Power' : 188, 'Magic' : 44 }]
suit_colour = ['White', 'Blue', 'Pink']

merged_values = zip(character_order, levels, suit_colour)
print(list(merged_values))

# This can work with tuples, dictionaries and lists in origin
# Every zip-merged will be into a tuple
"""
[
((1, 'Ryu'), {'Power': 87, 'Magic': 155}, 'White'), 
((9, 'Honda'), {'Power': 254, 'Magic': 66}, 'Blue'), 
((6, 'ChunLi'), {'Power': 188, 'Magic': 44}, 'Pink')]
"""


# More use cases:   Client record

name = ['Pepito', 'Juanito', 'Menganito']
surname = ['Perez', 'Lopez', 'Diez']
id_card = ['73747274A', '0028144FH', 'token:6544df646543241sd6f4778654sdf']
id_type = ['NIF', 'PASSPORT', 'DigitalCert.']
phone = [600123123, 930025741, 699999999]

clients_records = zip(surname, name, id_type, id_card, phone)
print(list(clients_records))


# More use cases:   Building a Dictionary

keys = ['+', '-', '*', '/']
values = ['Adds', 'Subs', 'Muls', 'Divs']

oper_dict = dict(zip(keys, values))
print(oper_dict)    # {'+': 'Adds', '-': 'Subs', '*': 'Muls', '/': 'Divs'}


# More use cases:   Unpacking Data !!! By using zip(*the_data)

scoreboard_zipped = [('2b', 'Altuve'), ('3b', 'Bregman'), ('ss', 'Correa'), ('dh', 'Gattis')]

positions_unzipped, players_unzipped = zip(*scoreboard_zipped)

print(list(positions_unzipped))
print(list(players_unzipped))

```
