# Module 03 - 087: Python - Combining lists with a for...in

In this guide, we will explore how to merge multiple lists efficiently using Python's `for...in` loop. This is particularly useful when dealing with data from different sources, such as databases or files.

***

## 📌 The Problem

Imagine you have two lists:

```python
legacy_customers = ['Alice', 'Bob']
new_customers = ['Tiffany', 'Kristine']
```

We want to merge `legacy_customers` into `new_customers` so that all names appear as individual elements in a single list.

### ❌ Incorrect Approach

If we try to merge the lists directly using:

```python
raw_db = [legacy_customers, new_customers]
print(raw_db)
```

The output will be:

```python
[['Alice', 'Bob'], ['Tiffany', 'Kristine']]
```

Here, we have a nested list instead of a flat list. This is not what we want! 🚨

***

## ✅ Correct Approach: Using a `for...in` Loop

We can use a `for...in` loop to iterate over `legacy_customers` and append each element to `new_customers`:

```python
for legacy_customer in legacy_customers:
    new_customers.append(legacy_customer)
```

Now, when we print `new_customers`, we get:

```python
['Tiffany', 'Kristine', 'Alice', 'Bob']
```

🎯 **Success!** We now have a properly merged list.

***

## 📖 Explanation

The `for...in` loop works as follows:

1. It iterates over `legacy_customers`.
2. For each item in `legacy_customers`, it appends it to `new_customers`.
3. The `append()` method adds each element individually rather than nesting the list.

This method is particularly useful when dealing with large datasets where hardcoding values is impractical.

🔗 **Reference:** [Python Official Docs - `for` Statement](https://docs.python.org/3/reference/compound_stmts.html#the-for-statement)

***

## 📝 Alternative Approaches

### **Using `extend()`** = Merging both into one directly (More Pythonic)

Instead of using a loop, we can achieve the same result using `extend()`, which appends elements individually:

```python
new_customers.extend(legacy_customers)
print(new_customers)  # ['Tiffany', 'Kristine', 'Alice', 'Bob']
```

🔗 **Reference:** [Python List `extend()` Method](https://docs.python.org/3/tutorial/datastructures.html#more-on-lists)

***

### **Using List Comprehension** (The following guide will expand this)

For a more compact solution, we can use list comprehension:

```python
new_customers = [customer for customer in new_customers] + [customer for customer in legacy_customers]
```

While this works, it's less efficient than `extend()`.

***

## Video lesson Speech

In this guide, we're going to extend our knowledge of the for-in loop to see how it can be used to merge multiple lists.

***

Imagine that we have a scenario where we have a set of legacy customers and then we have new customers. So these could be from a different database or from just a file that contains a list of usernames anything like that. And so we have two lists and we need to combine them.

So we want to add Alice and Bob to the list that contains Tiffany and Kristine.

```python
legacy_customers = ['Alice', 'Bob']
new_customers = ['Tiffany', 'Kristine']
```

Well, you may think that we can do something like this where we could just say that the raw database. So just raw\_db equals and then combine legacy customers and then new customers. Let's see what this gives us if I say print raw\_db this is going to print out Alice and Bob inside of their own list and then Tiffany and Kristine inside of their list.

![IMG](../../../../../../../../.gitbook/assets/03-087_IMG1.png)

Essentially all we've done is we've created a list that contains multiple lists which is not what we want. So I'm going to copy this just to walk through what we're actually going for. I'll add this is a comment.

So right now this is what we get but what we actually want is all of the strings to just be separate elements so we want to have four string elements instead of two list elements. So this is what we're actually looking to do and we can leverage the for-in loop in order to accomplish this.

So what I can do is I can say for legacy\_customer so this is just our iterator variable here. I'm gonna say for legacy\_customer in legacy\_customers. I can then call our new customers list, so this is calling say imagine it's a new database or something like that. So I'm saying new customers and then I can just call the append function. So this is a function available inside of the list data type so I'm gonna say append and then legacy\_customer and that is all I have to do.

```python
for legacy_customer in legacy_customers:
 new_customers.append(legacy_customer)
```

So now I can say print and have our new customers so we don't even need to create a new list. We can simply tack on our legacy customers into this new customers list. And if I run this you can see we get the desired output.

![IMG](../../../../../../../../.gitbook/assets/03-087_IMG2.png)

So right here instead of having a list that contains two nested lists instead, we have simply added on to our new\_customers database here and we've tacked on Alice and Bob. So the way that this is able to work is because we've utilized the for-in loop. So all we're doing is we're iterating through our legacy customer lists so we're just iterating through Alice and Bob and then with each loop we are saying I'm calling this new customers list here.

And then I simply want you to tack on the values. I want you to append the legacy customer as a new element on new customers. And so this may seem kind of trivial when we only have 2 items but imagine that you have 200.

Those are 200 items you would not want to have to code from scratch. In a real-life application, you wouldn't even know how many items you are going to be adding on so you couldn't hard code it in. But with a for-in loop, you can simply iterate over one list and then add each one of those elements into the new one.

The reason why this is able to work when what we have here online for didn't is this simply combined both of the lists and it treated them like two elements but with a for-in loop what we're doing is we are iterating over a preexisting list and we're not even treating these elements as anything except normal strings.

So this would be the same as if we said I want you to add one string element on to new\_customers. Then the next time around I want you to add this other one and so on and so forth. So that is how you can create and combine multiple lists together using the for-in loop in Python.

***

## Code

```python
# 03-087: Combining list with for...in

legacy_customers = ['Alice', 'Bob']
new_customers = ['Tiffany', 'Kristine']


# Merging list
raw_db = [legacy_customers, new_customers]

print(raw_db)           # [['Alice', 'Bob'], ['Tiffany', 'Kristine']]



# Using a for...in

for legacy_customer in legacy_customers:
    new_customers.append(legacy_customer)

print(new_customers)    # ['Tiffany', 'Kristine', 'Alice', 'Bob']


# More ways to combine lists

# .extend() - Merging both into one directly

users = ['root', 'user1']
pwd = ['rootPass', 'user1Pass']

users.extend(pwd)
print(users)


# Using list comprehesion (The following guide will expand this)

users = ['root', 'user1']
pwd = ['rootPass', 'user1Pass']

users = [user for user in users] + [single_pwd for single_pwd in pwd ]
print(users)
```

***

## Coding Exercise

Write a for loop that takes each number from the numbers list, increments it by 1, and adds it to the result list.

```python
```
