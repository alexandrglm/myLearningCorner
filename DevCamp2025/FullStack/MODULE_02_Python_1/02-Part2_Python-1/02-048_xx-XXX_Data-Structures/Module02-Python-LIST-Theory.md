# MODULE 02 - Python

## LISTs - Theory

****

**📌 Introduction to Lists in Python**

A **list** in Python is an **ordered, mutable collection** that can store multiple data types. Lists allow **modifications**, meaning we can add, remove, and modify elements dynamically.

### **🔹 Key Features of Lists**

✔ **Ordered** – Elements maintain their insertion order.  
✔ **Mutable** – Lists can be changed after creation.  
✔ **Heterogeneous** – Can store different data types (integers, strings, floats, etc.).  
✔ **Indexed** – Elements can be accessed via index values.

---

## **🛠️ Creating Lists**

Lists are defined using square brackets `[]`.

```python
# Empty list
empty_list = []

# List with elements
numbers = [1, 2, 3, 4, 5]

# Mixed data types
mixed_list = ["Python", 3.14, True, 42]

print(numbers)  # Output: [1, 2, 3, 4, 5]
```

---

## **🎯 Accessing Elements**

Python lists use **zero-based indexing**, meaning the first element is at index `0`.

```python
languages = ["Python", "Java", "C++"]

print(languages[0])  # Output: Python
print(languages[-1])  # Output: C++ (Negative indexing: last element)
```

✔ **Negative indices** allow access from the end of the list (`-1` is the last element, `-2` the second-last, etc.).

---

## **✏️ Modifying Lists**

Lists allow modification after creation.

```python
fruits = ["Apple", "Banana", "Cherry"]
fruits[1] = "Blueberry"  # Modifying an element
print(fruits)  # Output: ['Apple', 'Blueberry', 'Cherry']
```

---

## **➕ Adding Elements**

Python provides multiple ways to add elements to a list:

```python
fruits = ["Apple", "Banana"]

# Append: Adds element at the end
fruits.append("Cherry")  
print(fruits)  # ['Apple', 'Banana', 'Cherry']

# Insert: Adds element at a specific index
fruits.insert(1, "Blueberry")
print(fruits)  # ['Apple', 'Blueberry', 'Banana', 'Cherry']

# Extend: Merge another list
fruits.extend(["Mango", "Grapes"])
print(fruits)  # ['Apple', 'Blueberry', 'Banana', 'Cherry', 'Mango', 'Grapes']
```

---

## **🗑️ Removing Elements**

Elements can be removed using different methods:

```python
numbers = [1, 2, 3, 4, 5]

# Remove by value
numbers.remove(3)
print(numbers)  # [1, 2, 4, 5]

# Remove by index (pop returns the removed element)
numbers.pop(1)
print(numbers)  # [1, 4, 5]

# Clear: Removes all elements
numbers.clear()
print(numbers)  # []
```

---

## **📊 Common List Methods**

| Method         | Description                        |
| -------------- | ---------------------------------- |
| `append(x)`    | Adds `x` to the end of the list    |
| `insert(i, x)` | Inserts `x` at index `i`           |
| `remove(x)`    | Removes first occurrence of `x`    |
| `pop(i)`       | Removes and returns element at `i` |
| `clear()`      | Removes all elements from the list |
| `index(x)`     | Returns index of `x`               |
| `count(x)`     | Counts occurrences of `x`          |
| `sort()`       | Sorts the list in ascending order  |
| `reverse()`    | Reverses the list                  |
| `copy()`       | Returns a copy of the list         |

---

## **🎯 List Slicing**

Slicing allows extracting sublists.

```python
nums = [10, 20, 30, 40, 50, 60]
print(nums[1:4])   # [20, 30, 40]
print(nums[:3])    # [10, 20, 30] (from start)
print(nums[3:])    # [40, 50, 60] (to end)
print(nums[::2])   # [10, 30, 50] (every second element)
```

---

## **🔄 Looping Through Lists**

You can iterate over lists using loops.

```python
colors = ["red", "green", "blue"]

for color in colors:
    print(color)
```

Using `enumerate()` to get index and value:

```python
for index, color in enumerate(colors):
    print(f"Index {index}: {color}")
```

---

## **📌 List Comprehension (Advanced)**

List comprehensions offer a concise way to create lists.

```python
squares = [x**2 for x in range(1, 6)]
print(squares)  # [1, 4, 9, 16, 25]

# Filtering
evens = [x for x in range(10) if x % 2 == 0]
print(evens)  # [0, 2, 4, 6, 8]
```

---

## **🚀 Summary & Key Takeaways**

✔ **Lists store multiple items in an ordered, mutable structure.**  
✔ **They support indexing, slicing, and iteration.**  
✔ **Common operations include adding, modifying, and removing elements.**  
✔ **List comprehensions provide an efficient way to create lists.
