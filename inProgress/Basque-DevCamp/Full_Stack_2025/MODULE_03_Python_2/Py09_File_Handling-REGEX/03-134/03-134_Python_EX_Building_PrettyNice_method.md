# MODULE 03 - 134: Python - Exercise

# Build a Pretty Price Method



This coding exercise focuses on **formatting prices** for an e-commerce application. The goal is to **normalize prices** to follow a more attractive pattern, commonly used in retail (e.g., rounding to `.99` or `.95`).

This guide will help you:

* ✅ Implement a **flexible price formatting function**.  

* ✅ Handle **both whole numbers and decimal inputs**.  

* ✅ Use **Python's built-in type-checking** to improve function usability.

🔗 **Reference:** [Python Type Checking (`isinstance`)](https://docs.python.org/3/library/functions.html#isinstance)

---

## 🔹 Understanding the Problem

The function should:

- Accept a **gross price** (e.g., `3.21`).
- Allow customization of the **price extension** (e.g., `.99` or `.95`).
- Support **both whole numbers (99) and decimals (0.99)** as extensions.

### ✅ Desired callbacks & outputs

```python
pretty_price(3.20, 0.99)  # Returns: 3.99
pretty_price(3.20, 99)    # Returns: 3.99
pretty_price(3.20, 95)    # Returns: 3.95
pretty_price(10, 0.50)    # Returns: 10.50
```

📌 **Key Challenge:**

- Ensure that **both integer and decimal extensions work seamlessly**.

🔗 **Reference:** [Python `int()` Function](https://docs.python.org/3/library/functions.html#int)

---

## 🔹 Implementing the Solution

We will:

1. Extract the **whole number** part of the price.
2. Check if the extension is an **integer**.
3. Convert **integers to decimals** (e.g., `99 → 0.99`).
4. Return the **formatted price**.

### ✅ Pretty Price Function

```python
def pretty_price(gross_price, extension):
    base_price = int(gross_price)  # Strip decimals

    if isinstance(extension, int):  # Convert integer extension
        extension = extension * 0.01  # 99 → 0.99

    return base_price + extension
```

🔗 **Reference:** [Python `int` vs. `float`](https://docs.python.org/3/library/functions.html#int)

---

## 🔹 Testing the Function

### ✅ Example Usage

```python
print(pretty_price(3.20, 0.99))  # 3.99
print(pretty_price(3.20, 99))    # 3.99
print(pretty_price(3.20, 95))    # 3.95
print(pretty_price(10, 0.50))    # 10.50
```

📌 **What Happens?**

- `3.20 → 3` (integer conversion)
- `99 → 0.99` (integer extension correction)
- **Final Price:** `3 + 0.99 → 3.99`

🔗 **Reference:** [Python Arithmetic Operations](https://docs.python.org/3/tutorial/introduction.html#numbers)

---

## 🔹 Alternative Approach: Using a Class

For more **scalability and flexibility**, we can implement this using a class.

### ✅ Example: Class-Based Approach

```python



import math

class PrettyPrice:
    
    def __init__(self, gross_price, input_type):
        self.gross_price = gross_price
        self.input_type = input_type

    def prettify(self):
        base = math.floor(self.gross_price)
        
        if isinstance(self.input_type, int):
            decimals /= 100
            prettified_price = base + decimals
            return f'Prettified price, from {self.gross_price}, is:  {float(prettified_price)} !'

        else:

            prettified_price = base + 0.99
            return f'Prettified price, from {self.gross_price}, is:  {prettified_price} !'



```

### ✅ Using the Class

```python
price = float(input('Price to be prettfied? :  '))
input_type = input('Choose your rounding up method (0.xx / xx) :')

prettified_price = PrettyPrice(price, input_type)
print(prettified_price.prettify())
```

📌 **Why Use a Class?**

- **Encapsulation**: Keeps price formatting logic inside a single object.
- **Extendability**: Easier to add new features (e.g., currency conversion).

🔗 **Reference:** [Python OOP: Classes & Methods](https://docs.python.org/3/tutorial/classes.html)

---

## 📌 Summary

- **`pretty_price()`** formats prices for e-commerce.
- **Handles both integers and decimals** for extensions.
- **Uses `int()` to strip decimals** and `isinstance()` to convert whole numbers.
- **A class-based approach** can provide additional scalability.

---

## Video lesson Speech

In this python coding exercise, we're going to build out a pretty price 
function. And so what I mean by pretty price is I mean something that 
has a normalized price for say an e-commerce shop.

****

So this is something that I had to build out for an application recently and so I thought it would be a good idea to include it as an exercise because if you've never done this kind of thing before then the solution might not be the most intuitive.   

So what we're looking to do is to have a function so that when it's called if it's passed in a gross value.   

So say this is going to be the sale price and the sale price is 3.21 cents. The output of this function should be `3.something like 99 or 95`. 

We also want the ability to have the flexibility to say if it's going to be 99 or 95 or something else you may want it to just be flat 3 dollars and so this is going to be an 
exercise where you can do that.

Now, I want to walk through what type of solution before actually getting the solution I want to give you one hint on the solution and that is showing you how you should be able to call this function because I put in a little bit of a twist on it.   

And so I want to be able to call the function like this where I say pretty price and then like you saw before I could pass in something like 3 dollars and 20 cents and then 99 and the output of this should be something like 3 dollars and 99 cents.  

 But now I want it to be a little bit more flexible so that if I say 3 dollars and 20 cents and then pass in a decimal then I want the output to be exactly the same.

The reason why I'm doing this is, imagine that you're building out some kind of code library that other developers were going to use, and sometimes they have a whole number that they would pass in and other times they have a decimal in this scenario. I think it makes sense to have both of these working.   

So that is the set of instructions so I recommend that now you pause the video and then come back and you can watch me as I go through my own personal solution.

****

# Attempt #1

```python
# Even it's not exactly exactly what exercise should be,
# this attempt tries to joint last guides' learnings

import math

class PrettyPrice:

    def __init__(self, gross_price, input_type):
        self.gross_price = gross_price
        self.input_type = input_type

    def prettify(self):
        base = math.floor(self.gross_price)

        if isinstance(self.input_type, int):
            decimals /= 100
            prettified_price = base + decimals
            return f'Prettified price, from {self.gross_price}, is:  {float(prettified_price)} !'

        else:

            prettified_price = base + 0.99
            return f'Prettified price, from {self.gross_price}, is:  {prettified_price} !'



price = float(input('Price to be prettfied? :  '))
input_type = input('Choose your rounding up method (0.xx / xx) :')

prettified_price = PrettyPrice(price, input_type)
print(prettified_price.prettify())
```

So welcome back, if you went through that. I'm going to get rid of 
the comments here and start building this out. So I'm going to create a 
function called `pretty_price` and it's going to take two arguments. One is going to be the `gross_price` so this would be whatever that sale price is. And then another one's 
going to be the extensions so this will be something like 99, 95, or 
whatever you want the decimal extension to be. Now let's first talk 
about the easiest way to get this solved, I'm not going to worry about 
that conversion between a whole number of 95 and a 0.95 decimal.

Let's first simply build out the basic functionality, so I know that I
 need to convert that gross price. So if I have something like this, I 
know that gross price needs to be able to be converted to 3 and then I 
can tack on whatever that extension is. So let's see in the python repl 
the easiest way of doing this, so let's start that up. And so you can 
see if we go with our value here. So let's say it's going to be 3.23 
cents and I only want to get three back. Well, the way we can do that is
 we can cast this value to int.

So we have a function in python called int and if I pass x to it you 
can see that it returns the integer value which means it strips out all 
of the decimals.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Python+Coding+Exercises/Mathematical+Computation/Build+a+Pretty+Price+Method+in+Python+%23+1700/image11.png)

So if you went through the solution and you tried to do something 
where you saw the decimal and then you checked to see what the value was
 and then you tried something like floor or ceiling or anything like 
that, you really don't even need to do that in this case. All you have 
to worry about is stripping it away and converting it into an integer 
and then it's going to work. So casting that int is going to be all that
 we need to do to get the basic functionality working. So here I can say
 return and then int gross_price and then let's just add that to the 
extension. So now if I come down here and call this. So let's say pretty
 price and pass in 3.50 and then for the sake of our first example we 
are saying 0.95 cents, just like that let's print this out and see if 
this is working. So let's run it Python pretty price and that worked 
perfectly.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Python+Coding+Exercises/Mathematical+Computation/Build+a+Pretty+Price+Method+in+Python+%23+1700/image12.png)

So we have now a pretty price generator and it works very nicely 
whenever a decimal is passed like we have right here. Now let's see what
 we need to do in order to make this work for whole numbers because if 
we try this with whole numbers we change this to 95 and said 95 cents if
 we try this now then you're going to see that we end up with 98 which 
is definitely not what we're looking for.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Python+Coding+Exercises/Mathematical+Computation/Build+a+Pretty+Price+Method+in+Python+%23+1700/image13.png)

So what I can do here is I can perform a check. So inside of the 
function itself, I can add a conditional and there is a very helpful 
method here because what I need to do is I need to check to see if that 
second argument if the extension is a decimal or if it's an integer. And
 so what I can do is I can check and say `if isinstance` this is the function, this is something provided by python. So I can say `if isinstance(extension, int)` then I want to perform some other task. So what this is saying is I'm 
checking to see is this extension an instance of integer, so is it an 
integer is all it's really saying.

Then what I want to do is I want to reassign extension. So I'm gonna say `extension = extension * 0.01`.
 And so what this is going to allow us to do is I can work with the same
 variable name. Notice how I didn't have to make a single change here on
 line 5 in that return statement, I'm simply updating the value of 
extension.

So now let's test this out and see if it's working. And there we go, both of those are working perfectly.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Python+Coding+Exercises/Mathematical+Computation/Build+a+Pretty+Price+Method+in+Python+%23+1700/image14.png)

So you can see that our API is much more flexible with our function 
now. So now if you're working with a program that has decimals that are 
coming in for that extension you can pass in the decimal if you have 
whole numbers coming in then you can pass in a whole number and it will 
work nicely. So this is something that you could use in your own 
real-life e-commerce projects and I know that that is the case because I
 have pretty much this identical code inside of a project that I needed 
to add this functionality to. So great job if you went through that.

****

## Resources

- [Exercise Code](https://github.com/jordanhudgens/python-exercises/blob/master/mathematical_computation/pretty_price.py)
