# Module 03 - 089: Python - Control Structures -> Conditionals

In this section, we will explore **conditionals** in Python. Conditionals are one of the foundational concepts that make a program dynamic. They allow a program to make decisions and take different actions based on different conditions. Almost every application uses conditionals at some level.

---

## 📌 What Are Conditionals?

A **conditional** is a way to tell a program:

- "If one situation occurs, perform this task."
- "If a different situation occurs, perform another task."

This ability to make decisions is what makes a program truly dynamic.

---

## 💡 Real-World Example: Authentication System

Let's consider an **authentication system** that checks if a user is allowed to enter a website or mobile application.

### ✅ If the user enters the correct credentials:

- The system **grants access**.

![Authentication Success](./03-089_IMG1.png)

### ❌ If the credentials are incorrect:

- The system **denies access**.
- It may also check if the username exists in the database.
- If the username does not exist, the system may prompt the user to **register**.

![Authentication Failure](./03-089_IMG2.png)

This process can involve multiple **levels of conditionals**, leading to different scenarios based on user input.

![Conditional Flow](./03-089_IMG3.png)

---

## 🌳 Conditional Structures as Decision Trees

Think of conditionals as a **tree structure**, where each decision leads to a different path:

- If a condition is **met**, the program takes one branch.
- If the condition is **not met**, the program takes another branch.
- Additional **secondary conditions** can refine the decision-making process.

Conditionals always have a **yes/no** (true/false) outcome, making them straightforward to understand and implement.

---

## 🎯 Summary

- Conditionals make programs **dynamic** by allowing them to make decisions.
- They follow a **yes/no** logic structure.
- Complex decision trees can be built using multiple conditionals.
- Real-world applications like **authentication systems** rely on conditionals.

****

## Video lesson Speech

In this section of the course, we're going to dive into conditionals in a python. Now a conditional is one of the foundational concepts around what it takes to make a python program become dynamic.

****

By dynamic what I mean is that your program can start making decisions which is a pretty exciting and very cool feature that pretty much every type of application is going to have to have at some level or another. Now conditionals are simply a way of 
saying if one situation occurs I want you as a program to perform one 
task but if a different situation occurs I want you to perform this 
other task.

Let's take a little bit of a real-world example with this.   

So let's say that we're building out an authentication system which simply means 
we want to check to see if a user who goes to our website or our mobile application is allowed to go into the system.   

We could build something like this and this isn't the syntax.   

This is more of a visual so we can say if user, and then password are correct so we'll say correct.

![large](./03-089_IMG1.png)

Then I want to perform a couple of tasks so if the answer is yes then I want to come down here and say let into site.

![large](./03-089_IMG2.png)

But now what if it's not correct? We may have a couple of different options. So if it's no then we don't want to only say they're not allowed into the site. So that's definitely part of it we're not going to let someone who's not authorized in but we may do is have a secondary check and a secondary conditional.   

So, we say if that's not correct then no we're not going to let them into the site.   

So not authorized but then we may also want to perform some other checks to say something like "Okay, if the email they entered or the user name they entered didn't 
even exist in the system". Maybe we want to check and say "Would you like
 to register?"

![large](./03-089_IMG3.png)

Then we could have different conditionals at different levels.   

And I like to think of conditionals as these trees structures where you can have all of these different scenarios and these different actions and one thing that's beautiful about conditionals you only have to think of your conditions as having a yes or a no type answer.   

So, if that condition is met it's a yes.   

If the condition is not met it's a no.   

And then you also have the ability to branch off and give secondary conditions to make your systems even more specialized.   

So now that you have a good idea of what a conditional is let's dive into the actual 
syntax so that we can start building into our Python programs.
