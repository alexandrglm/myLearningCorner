# Module 03 - 090: Python - Conditionals (1)

Throughout this course, we've already encountered conditionals briefly. Now, we will dive deeper into them to fully understand how to implement **dynamic and conditional logic** in Python programs.

***

## 📌 `if` Statement

The `if` statement is the foundation of conditionals in Python. It allows us to execute a block of code **only if** a certain condition is met.

* A condition is an expression that evaluates to **True** or **False**.
* If the condition is **True**, the indented block of code runs.
* If the condition is **False**, the block is skipped.

### 🛠 Example:

If a user's age is less than 25, they are not allowed to proceed.

* If the age is **15**, the condition is met, and the message is displayed.
* If the age is **25 or more**, nothing happens.

🔹 **Key Rule:** Whenever a **colon (`:`)** appears at the end of a condition, the following line **must be indented**.

***

## 📌 `if - else` Statement

The `else` statement provides an **alternative action** when the `if` condition is **not met**.

* If the condition is **True**, the first block runs.
* If the condition is **False**, the `else` block runs instead.

### 🛠 Example:

An age verification system:

* If the user is **under 25**, they are denied access.
* Otherwise, they are allowed.

🔹 **Benefit:** Ensures that a message is always displayed, regardless of the condition.

***

## 📌 `elif` (Else If) Statement

The `elif` statement allows us to **check multiple conditions** in sequence.

* The program evaluates conditions **from top to bottom**.
* The first `True` condition executes and the rest are ignored.
* If **none** of the conditions are met, the `else` block (if present) executes.

### 🛠 Example:

A car rental system that applies different rules:

* If **under 25**, the user is too young.
* If **over 100**, they are too old.
* Otherwise, they are approved.

🔹 **Advantage:** Efficiently handles multiple conditions without writing nested `if` statements.

***

## 🌳 Summary

* **`if`** → Executes a block **only if** the condition is **True**.
* **`if - else`** → Provides an **alternative** action when the condition is **False**.
* **`if - elif - else`** → Checks **multiple conditions** in order.
* **Conditionals are fundamental** for making programs dynamic.

***

## Video lesson Speech

As we've gone through this course on Python programming we've already seen a few previews of conditionals. Now in this section, we're going to dive in and analyze everything that we need to know in order to build in dynamic and conditional logic into our programs.

***

In this guide, we're going to focus on the basic syntax for implementing conditionals.

## if

So I'm going to start off with just a single condition and so I'm going to create a variable here called age and set it equal to the number 25.

```python
age = 25
```

And now the syntax for being able to build a conditional here is to say if and that is a reserved keyword in Python so I'm gonna say if age is less than 25 and then I follow this up with a colon and then when I come to a new line I need to have an indentation and we've already talked about this for our for-in loops and are while loops and it's a\
good rule of thumb in Python.

Anytime you see a colon the next line you're going to have to have indented and so now that we've implemented our basic conditional.

Now, we can say what we want to happen if this condition is true.

So, in this case, I'm just going to print something out and I'm going to say `f`, and then for this one, we don't really need formatting but I'm going to show you later on how we're going to use it.

So, I'm gonna say `I'm sorry you need to be at least 25 years old`and that is going to be everything that we need in order to get this working. So if I hit run\
you can see nothing happens.

![large](../../../../../../../../.gitbook/assets/03-090_IMG1.png)

So, why is that?

Well, it's because this condition right here was not true.

Our age was set at twenty-five.

Now, if we change age and we say 15 and now we run it you can see that it now prints out exactly like how we typed.

So it says I'm sorry you need to be at least 25 years old.

![large](../../../../../../../../.gitbook/assets/03-090_IMG2.png)

This can work for any number, so if I say 1500 years old and run this you can see nothing is going to be printed out because this condition is not true.

![large](../../../../../../../../.gitbook/assets/03-090_IMG3.png)

So, when it comes to understanding conditional logic you just have to think of setting up your conditions and assuming they're going to be either true or false. So, in this case, it is false that age is less than 25 and so this is one of the most basic kinds of conditions that you can implement.

***

## if - ese

Now, let's see how we can add a little bit more dynamic behavior to this by adding a second condition.

So, right now, we're saying if age is less than 25 then do this but as we saw whenever we have a point in time where this is not true then nothing happens in the program and there are times where you may want to implement a single condition like this.

However, a very common practice is to also have an else condition.

So what this means is if this condition here is true then it's going to run the code inside of this code block. But if this condition is false then it is going to come down here into this else code block and it's going to do whatever we have in here.

I'm going to just copy this and I'm going to keep the print statement and the format and then I'm just going to replace everything inside of it and so I'm going to say something like "You're good to go", and then inside of this I'll call age inside our curly brackets and say fits in the range to rent a car and so that is 25 years old in the US is\
the age where you can rent a car and so this is what our program is testing for.

```python
age = 1500

if age < 25:
 print(f"I'm sorry, you need to be at least 25 years old")
else:
 print(f"You're good to go, {age} fits in the range to rent a car.")
```

Now, if I run this you can see that now even though it's not true.

The age is less than 25 because we have this else statement.

Now we're going to be guaranteed that we're always going to get some kind of print out.

We're either going to have an I'm sorry you need to be at least 25 years old or what we have in this case where it says "You're good to go, 1500 years old fits in the range to rent a car."

![large](../../../../../../../../.gitbook/assets/03-090_IMG4.png)

So this is an if-else statement.

So this is where you set up one condition and if it's true it runs and if not then anything else is going to run inside of this else block. And so this takes care of two\
out of the three basic conditional statements that you're usually going\
to build.

***

## Elif

Now, what we're going to do is implement another construct which is called the else if and it has a little bit of a weird name in Python it's called `elif` but it's short for else if and what it does is it allows us to chain on additional conditions.

So, for example, say that you are building this program out as an age verification tool\
for a rental company and the rules are that someone has to be at least 25 years or older and they cannot be over a hundred years old.

So, someone who's 1500 years old like we have right here should not be able to rent a car.

So, let's come down and I'm going to keep our else block here.

But what I'm going to do is I'm going to add an else if block and it is spelled out like this `elif` and then I'll say if age is greater than a hundred then I'm going to simply take this and I'm going to just add a format here and say something like "I'm sorry"" and then curly braces whatever this age is, is too old to rent a car."

Now, if we run this we should fall into the second category. Let's hit run and that\
works.

![large](../../../../../../../../.gitbook/assets/03-090_IMG5.png)

I'm sorry, 1500 is too old to rent a car. If we change this up and we put something in the middle so we say 50 years old and run this. "You're good to go."

![large](../../../../../../../../.gitbook/assets/03-090_IMG6.png)

So, as you can see we are checking for two conditions.

So this is looking to see first if this first condition is true and if not it looks at the second condition.

And then finally if both of these are false then it goes to the final statement here where it just says OK these items are both false.

We're going to do whatever is inside of this code block.

In review, that is how you can implement three types of conditions inside a python.

***

## Code

```python
# 03-090: Conditionals: if / if else / elif


# If statement

age = 1500

if age < 25:
    print(f'I\'m sorry, you need to be at least 25 years old')




# If - Else statements

age = 1500

if age < 25:
    print(f'I\'m sorry, you need to be at least 25 years old')

else:
    print(f'You are good to go, {age} fits in the range to rent a car')



# Elif statement 

age = 1500
age_2 = 26

if age_2 < 25:
    print(f'I\'m sorry, you need to be at least 25 years old')

elif age_2 > 100:
    print(f'I\'m sorry, {age_2} is too old to rent a car')

else:
    print(f'You are good to go, {age_2} fits in the range to rent a car')
```

***

## Coding Exercise

Create a conditional that returns true, using the starting code below.

```python
answer = False

if #WriteYourConditionsHere:
  answer = True
```
