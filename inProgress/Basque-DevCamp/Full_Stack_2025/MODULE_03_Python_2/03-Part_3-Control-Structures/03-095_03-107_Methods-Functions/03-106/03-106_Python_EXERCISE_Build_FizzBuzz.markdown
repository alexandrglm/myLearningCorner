# MODULE 03 - 106: Python - Exercise

## 🎯 Build a FizzBuzz

This exercise will test your ability to combine multiple programming concepts in Python. The challenge is based on **FizzBuzz**, a common coding interview question.

You will implement a function that prints numbers following specific rules, applying:

- **Loops**
- **Conditionals**
- **Mathematical operators**
- **Functions**

---

## 📌 Task Requirements

1️⃣ **Print numbers from 1 to 100**.

2️⃣ **Apply the following rules**:

- If a number is **a multiple of 3**, print **"Fizz"** instead.
- If a number is **a multiple of 5**, print **"Buzz"** instead.
- If a number is **a multiple of both 3 and 5**, print **"FizzBuzz"** instead.

### 🔹 Example Output:

```
1
2
Fizz
4
Buzz
...
14
FizzBuzz
```

3️⃣ **Extend functionality**:

- The function should **accept a maximum value** instead of being hardcoded to 100.
- It should work for any positive integer (e.g., 20, 500, 1000, etc.).

---

✅ **Define a function** to handle the logic dynamically.
✅ **Use a loop** to iterate through numbers.
✅ **Implement multiple conditionals** to check divisibility.
✅ **Apply mathematical operators** for checking multiples.



****

## Video lesson Speech

We've come to our first exercise that you are going to build out in this section of the course. What we're going to build out is something that combines all of the different knowledge that you learned up to this point and the project that we're going to implement is one of the more popular coding interview questions out there, which is called the fizz buzz exercise.

****

What we're going to do is outlined right here.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+Programming+with+Python/Python+Methods+and+Functions/Project+Requirements%3A+Build+FizzBuzz+in+Python+%23+1497/image1.png)

So, we're going to write a program that prints the numbers from 1 to 100, but for multiples of 3 it prints Fizz.   

So, it prints a string of fizz instead of the number.

But, for the multiples of five it prints Buzz for the numbers which are multiples of both 5 and 3.

Then, you're going to print out fizz buzz.   

And so just to give an idea of what this is going to look like you're going to print out something that is 1, 2, 3, 4, ..... 

But, instead of where we have a number 3 right here, this instead is going to be the string Fizz and instead of the number 5 this is going to be Buzz.

```python
1
2
Fizz
4
Buzz
```

Then, if we continue this down the line until we get to 15 then this is going to be FizzBuzz.   

Just like we have right there and it doesn't stop at 15, I want you to print out the numbers from 1 to 100.   

For extra credit for the function that you're going to build and you can call the
 function FizzBuzz, I want you to be able to pass in an arbitrary max of value.

In other words, even though I said to have 1 to 100 I want the function to be able to take any kind of maximum numbe.   

So, you could pass in 20 and they'll print out 1 to 20 following the same rules outlined above.   

Or, you could pass in 1000 and you'll print out 1 to 1000 while still following all of the same rules.

So, nothing in this is going to be hardcoded.   

Instead you are going to implement pretty much every kind of system that we've worked on so far.   

So, you're going to build out a function you are going to work with looping.   

Then you're going to work with multiple conditionals and then you're going to be working with mathematical operators in order to get all of this working, so you need to include each one of these four components in order to successfully complete the exercise.

Once you're done submit it to your instructor for approval and then continue moving on in the course.

****

# Exercise Attempt #1:

```python
# 03-106: FizzBuzz exercise

"""
Write a program that prints the numbers from 1 t 100.
But, for multiples of 3, print 'Fizz'.
For multiples of 5, print 'Buzz'.
For numbers that are multiples of both, print "FizzBuzz"
"""

# 1st approach

numbers = list(range(1,101))
print(numbers)

for num in range(1,101):
    if (num % 3 == 0) and (num % 5 == 0):
        print('FizzBuzz') 
    elif num % 3 == 0:
        print('Fizz')
    elif num % 5 == 0:
        print('Buzz')
    else:
        print(num)



# 2nd Approach: Implementing logic as a function

def Fizz_Buzz():

    print('\nWelcome to the Fizz-Buzz exercise!\n')
    start = int(input("Please, Select the start number: "))
    stop = int(input("Please, select the stop number: "))

    for num in range(start, stop + 1):
        if num % 3 == 0 and num % 5 == 0:
            print('FizzBuzz') 
        elif num % 3 == 0:
            print('Fizz')
        elif num % 5 == 0:
            print('Buzz')
        else:
            print(num)

Fizz_Buzz()
```
