# Module 03 - 091: Python - Ternary operator (Elvis)

## Module 03 - 091: Python - Ternary operator (Elvis)

In the previous guide, we explored three different types of conditional statements in Python. Now, we will extend that by introducing the **ternary operator**, also known as **Elvis**, which allows you to create a compact `if-else` statement in a single line.

---

## 📌 The Importance of Readability

While the ternary operator is useful, it should be used with caution. Overuse can make code harder to read and maintain. As stated in [PEP 20](https://www.python.org/dev/peps/pep-0020/), **"Simple is better than complex."** ✅

A well-implemented ternary operator can improve clarity, but if misused, it can add unnecessary complexity. Always consider whether a standard `if-else` statement would be more readable. 🧐

---

## 🎯 Understanding the Ternary Operator

A **ternary operator** allows you to condense a traditional `if-else` statement into a single line. This is especially useful when assigning values based on a condition.

### 🛠 Structure:

```
value_if_true if condition else value_if_false
```

### 🔍 Example:

Imagine a web application that checks if a user has admin privileges.

- If the user is an **admin**, they **can access** the dashboard.
- If they are **not an admin**, access is **denied**.

A traditional `if-else` statement would require multiple lines. With the ternary operator, the same logic is condensed into a single line, making the code more compact and readable. 🏆

---

## ⚖️ Comparing Traditional and Ternary Approaches

### **🔹 Standard `if-else` Approach**

1. The role is checked.
2. If it is **admin**, access is granted.
3. Otherwise, access is denied.
4. The result is assigned to a variable.

### **⚡ Ternary Operator Approach**

1. The condition is checked **inline**.
2. The appropriate value is assigned **directly**.
3. The code remains concise and clear.

---

## ✅ Best Practices for Using the Ternary Operator

🔹 **Keep it readable** → If a ternary expression spans multiple lines, a standard `if-else` is preferable.  

🔹 **Use it for simple conditions** → If logic requires complex operations, stick with a traditional conditional block.  

🔹 **Ensure clarity** → The statement should read as naturally as possible.

---

## 📌 Summary

- The **ternary operator** allows for a compact `if-else` assignment.
- It **should enhance readability**, not reduce it.
- Always balance **conciseness** with **clarity**.
- If a ternary expression becomes too complex, a traditional `if-else` block is the 

****

## Video lesson Speech

In the last guide, we walk through how you could build three different types of conditional statements in python.  

 And now what I want to do is extend that and show you how you can use what is called the `ternary operator` , a.k.a. as Elvis, which allows you to create a if else statement.

****

Now, I'm going to give a caveat to this and it is that you need to be careful with how you implement ternary operators because there are many times where developers learn how to do this and they don't realize that what they're doing is actually adding complexity to their application because ternary operators can be slightly more 
challenging to read if they're not implemented correctly.   

Referencing [PEP 20](https://www.python.org/dev/peps/pep-0020/) , which is the Zen of Python that we've discussed before, If you scroll down the third item on the Zen of Python is that simple is better than complex.

![large](./03-091_IMG1.png)

And so, I will show you how to implement ternary operators because these are going to be constructs that you're going to see in a number of Python programs but I am going to give the warning that you need to be careful and you need to make sure that when you implement these that they are better than simply going with a standard if-else statement.   

Because if you make your code harder to read it's going to be more challenging for you when you go back and look at the code in the future.  

 But it's also going to be more challenging for other developers that you're working with.   

So with all that being said now let's see what the syntax is.

## If/Else regular statements

So, imagine that you're building out some kind of web application that needs to have an authorization component.   

If I create a variable here called `role` and imagine that you have a user logged in who's an admin from here what we want to do is we want to check to see if role is
 set to admin.  

 So, when that user logs in and we check to see their credentials if it says that their role is admin then we want them to access the dashboard.

And if not, say they're a guest user then we do not. 

 What I'm going to do is I'm going to create another variable here called auth and then this is where we're going to store the output of our ternary operator and so I'm going to add a space and equals because we're performing an assignment and I'm going to say it can access if role is equal to admin else cannot access and that is the ternary operator syntax.

```python
role = 'admin'

auth = 'can access' if role == 'admin' else 'cannot access'
```

and so now I say print(auth) what this is going to do is it can print out that that user who's logged in can access the system.

![large](03-091_IMG2.png)

If I type guessed here and run it you can see that it says that they cannot access the system.

![large](03-091_IMG3.png)

This is a pretty standard approach and this is, in my opinion, a good way of being able to build out a ternary operator because my rule of thumb is that whenever I'm building out a conditional if it can read as close to normal language as possible then that can be a good scenario where a ternary operator can be used because then it is clear.

So, what we're saying here is that you can access this if the role is set to admin.   

If not then you cannot access it.   

And so that is essentially what a Ternary operator does is it just reorganizes what a typical conditional does for us.  

 And so one of the best ways if you never worked with ternary operators in the past they can look very odd and so one of the best ways that I think there is to understand it is to actually create a normal conditional so you can see the mapping.   

So, here, I'm going to say if and let me uncomment this role right here.

I say "*if role is equal to admin then I am gonna say can access, else cannot access*".

In this case, what I'm doing is I'm just going to return the value or I'm going to set it equal to auth so I can say auth is equal to this or it's equal to this value.   

And now I can just print auth just like we did before. So if I run this you can see 'can access'.

![large](./03-091_IMG4.png)

If this is anything else.   

It could be guest, it could be student, it could be gibberish, it doesn't matter if it's anything besides admin it's going to say cannot access.   

So now that we have all of that and now we can actually sit down and go through it and compare and see what this mapping looks like.   

I'll give us a little bit more room so it's all on one line and that is one rule of thumb if your ternary operator gets so long that starts breaking into multiple lines then it is probably something that should use the traditional syntax.

Just because it's harder to read and it can lead to syntax errors and typos or spelling mistakes and things like that. So let's see what this mapping looks like.

![large](03-091_IMG4.png)

You can see that we're assigning here whatever the result of the ternary operator is so you can see that if that condition is true you place that first.   

So this is the same thing as if we come down into our traditional setup here we are saying that we want to set can access into the auth variables. So if role is equal to admin then to perform this task. And so that first and foremost is what you're going to place in a ternary operator is exactly what you want to happen if the condition is 
true. And then next you place your condition.

So, as you can see, this code here is identical to what we have here on  line 5.   

So this is just where you put your conditional statement and then you have your else statement and you have your else right here.  

 Now, you can probably see just by looking at these few lines of code.   

**One of the nice benefits of using a ternary operator and that is that you only need to have this assignment placed here one time**.  

 So, in this case, we placed the assignment operator here and here for auth and with the ternary operator all we had to do was say I want to assign whatever the value is whether it's true like we have here or if it's false it is going to store whatever that value is.

So, in that sense, this is a very good example of when to use the ternary operator because in this scenario we have a clear mapping for what happens when a rule is set to an admin versus what happens when it's not.   

So this would be a scenario where you could do that.   

Now you should have a good idea, not only on the traditional syntax for setting up conditionals but also now for this one line ternary operator syntax.

## Code

```python
# 03-091: Ternary operator (elvis)

# If/Else regular statements

role = 'admin'

if role == 'admin':
    auth = 'is allowed.'

else:
    auth = 'is NOT allowed'

print(f'The user "{role}"', auth)



# Using Ternary operator

role = 'admin'
auth = 'is allowed.' if role == 'admin' else 'is NOT allowed.'

print(f'The user "{role}"', auth)
```

****

## Codign Exercise

Write a ternary operator that sets "language_check" to True if "language" is set as "python", and sets it to False if it's not.

```python
language = "python"

language_check = # Write your code here
```
