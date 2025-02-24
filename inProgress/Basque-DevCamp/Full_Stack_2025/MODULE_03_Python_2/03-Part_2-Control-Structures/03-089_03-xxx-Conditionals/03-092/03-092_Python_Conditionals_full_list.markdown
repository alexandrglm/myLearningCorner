# MODULE 03 - 092: Python - Conditionals full list

So far in this section on conditionals, we've explored different syntax options for implementing dynamic behavior in Python programs. In this guide, we will cover the **full list of comparison operators** used in Python conditionals.

---

## 📌 Comparison Operators

Comparison operators are used inside conditions to evaluate relationships between values, returning **True** or **False**.

### ✅ List of Comparison Operators:

- `==` → Equality
- `!=` → Inequality
- `<>` → Inequality (**deprecated**)
- `>` → Greater than
- `>=` → Greater than or equal to
- `<` → Less than
- `<=` → Less than or equal to

These operators allow Python programs to determine whether values are equal, different, or within a specific range.

---

## 🔹 Equality and Inequality

### **Equality (`==`)**

This operator checks if two values are **equal**.

Example scenario: Checking if a user’s login credentials match the stored username.

### **Inequality (`!=`)**

This operator checks if two values are **not equal**.

Example scenario: Restricting access to users with incorrect credentials.

🔹 **Note:** The `<>` operator was previously used for inequality but is now **deprecated** and should not be used.

---

## 🔹 Greater Than & Less Than Operators

These operators are used for **numerical** comparisons.

- `>` → Checks if a value is **greater** than another.
- `>=` → Checks if a value is **greater than or equal to** another.
- `<` → Checks if a value is **less** than another.
- `<=` → Checks if a value is **less than or equal to** another.

### ⚠️ Important:

These operators should only be used with **numbers**, as comparing strings using `>` or `<` does not always make logical sense.

---

## 🔹 Comparing Lists

Python allows comparison of **lists** using `==` and `!=`.

- `list1 == list2` → Checks if two lists are identical.
- `list1 != list2` → Checks if two lists are different.

🔹 **Use Cases:**

- Detecting duplicate data entries.
- Validating test datasets in machine learning models.

---

## 🛑 Deprecated Operator (`<>`)

The `< >` operator was an alternative way to check for inequality. However, it has been **deprecated** and should no longer be used.

🚀 **Use `!=` instead!**

---

## 📌 Summary

- **Comparison operators** allow conditions to evaluate to `True` or `False`.
- Use `==` and `!=` for **equality checks**, even with strings.
- Use `>`, `<`, `>=`, and `<=` for **numerical comparisons**.
- Lists can be compared using `==` and `!=`.
- The `< >` operator is **deprecated**—use `!=` instead.

****

## Video lesson Speech

So far in the section on conditionals, we've walked through various syntax options when it comes to implementing dynamic behavior into our Python programs.

****

In this guide, we are going to walk through the full list of comparison operators.

```python
List of comparison operators

# == Equality

# != Inequality

# <> Inequality (deprecated)

# > Greater than

# >= Greater than or equal to

# < Less than

# <= Less than or equal to
```

And so what a comparison operator is, is it is what we place inside of our condition to check for elements such as equality or inequality which means does object a equal object to b or does it not equal object b.

Then we also can test for value ranges such as checking to see if an 
element is greater than or equal to a value or if it's lesser than or 
equal to another value. And so this allows us to not only add dynamic 
behavior. It also gives us a full slew of true or false outcomes. And so
 if we're going to build in some examples we can create a variable so I 
could say something like

```python
username = 'jonsnow'
```

Then, I can check to see if the username that we get in from say a web form matches.  

 So, I can say if username is equal and you need double equals to jonsnow then I want you to print out Welcome.   

And if not I'm gonna place an else condition I'm going to print out. 'You shall not pass!' just like that.

```python
username = 'jonsnow'

if username == 'jonsnow':
 print('Welcome Jon')
else:
 print('You shall not pass!')
```

And so now if I run this code you can see it says welcome.

![large](./03-092_IMG1.png)

Because of this equality operator.   

## !=

Now, if we're looking for a different user then I can use the inequality operator(!=) here which is the exclamation mark followed by the equal sign.   

And so if you read this it really represents if the username is not equal to the value here on the right-hand side then I want you to run the code inside of the if block.   

If not so if that is not the case then I want you to run the code in this else block and so now if I run this code you can see it says "You shall not pass!"

![large](./03-092_IMG2.png)

So we've effectively flipped that conditional logic and if you remember back to our basic introduction on conditionals you remember that I said that what a condition checks for is simply a true or false value.   

So, whatever we have here in the code block such as in line 12.

This is simply checking to see if this full expression is going to be 
true or false and that is all it's looking for.

Now, a very interesting caveat is that this works well when you're talking about equality and inequality.   

This works for strings and it also works for numbers.  

 So, if I were to change this to say age set it equal to 555.   

Or actually, I guess we could go the more realistic age of 55 and then change the condition to say age.  

 Now I can add in any kind of number to compare this to. So I could say age is not equal to 90 so being very specific with our condition.   

If I run this you can see that it says welcome.

![large](./03-092_IMG3.png)

Because this is going to hit this code block for any number that is not equal to 90 and so you can see that this works.   

Equality and inequality work for both numbers and strings.   

However, you can see that here from lines 5 through 8 we have a full set of greater than and less than operators

```python
# > Greater than

# >= Greater than or equal to

# <= Less than

# <= Less than or equal to
```

and **these only work for numbers** which I think is kind of a logical approach because if we were to change everything back to a string and if I were to say the username is greater than Jon Snow let's see what happens here.  

 As you can see it says you shall not pass.

![large](./03-092_IMG4.png)

And this makes no sense.   

A string shouldn't be compared and this is not a logical approach where you say that if one string is greater than another string this is just not something that is going to read very well and so I would highly recommend to keep your strings inside of using this equality and inequality type of condition.

Now if we do switch this back to a set of numbers.   

That is where all of these greater than and less than options can go. So if I say, if the 
age is greater than 10 and if I run this then you can see it says Welcome.

![large](./03-092_IMG5.png)

And so the common convention is you're going to use your greater than and your less than symbols for any objects that are items such as numbers and then your inequality and your equality values.   

These are going to go for anything so these can be strings they can be numbers it 
can really be any type of object and so far we've only really looked at two data types.

Let's look at a list option.   

So here we can say something like user_list and inside of this. We can just create a set of users and then I'm going to create a second list and in this case, I'm going to go 
with another set of users and now we can create a condition that checks these two lists against each other so I can say if the user_list is equal to the second user_list you can do something like say they match and that's all you have to do.

I'm not going to place an else block in here because I think you 
understand that an else block is just going to run whatever happens if 
this is not the case. So now if I run this you can see that nothing gets
 printed out

![large](./03-092_IMG6.png)

because these items don't match these lists do not match.

Now , if I grab these usernames from user_list and place them in the second_list if I run this now you can see it prints out and says that they match which is exactly what we're looking for.

![large](./03-092_IMG7.png)

And you may wonder why in the world would I ever want to compare two identical lists?  

 And there are many practical times when you're going to want to implement this kind of conditional logic if you're building out algorithms and you say that you're building out a system that checks for duplicates or if you're implementing a machine learning algorithm and you're checking to see if your historical data is matching up with some of the current test data that you're working with.  

 That is another very basic example of when you're going to want to compare lists.

So far, what we've done is we've walked through this full list of comparison operators all the way from equality all the way down to less than or equal to. And we've also talked about how you can utilize these and implement them with various data structures such as numbers strings and lists and this also applies to working with tuples and dictionaries.

The last item I'm going to mention is you may notice here on line 4 I have this weird set of symbols. I have a less than symbol followed immediately by a greater than symbol (<>) and this is a deprecated operator which means that it is no longer being worked on and also that you shouldn't use it. It's the python recommendation that you do not 
use this operator anymore and it used to be another way that you could 
check for inequality and the reason why I am showing it to you here and 
why I have it on the list and I'll have it on the show notes.

It is not so that you will use it. You may notice that we didn't walk through it when we were going through our various examples but the reason why we have it here is that if you ever run into this in a python program you are really going to want to know what it does so if you're looking at some legacy python code for an older program and you come across this symbol just know that it is another way that you used to be 
able to check for inequality.  

But about moving forward you should simply use this exclamation mark followed by an equals sign (!=) and that is going to be the best way to see if items do not match.

****

## Code

```python
List of comparison operators

# == Equality

# != Inequality

# <> Inequality (deprecated)

# > Greater than

# >= Greater than or equal to

# < Less than

# <= Less than or equal to

username = 'jonsnow'

if username == 'jonsnow':
 print('Welcome Jon')
else:
 print('You shall not pass!')
age = 25

if age <= 25:
 print(f"I'm sorry, you need to be at least 25 years old")
```
