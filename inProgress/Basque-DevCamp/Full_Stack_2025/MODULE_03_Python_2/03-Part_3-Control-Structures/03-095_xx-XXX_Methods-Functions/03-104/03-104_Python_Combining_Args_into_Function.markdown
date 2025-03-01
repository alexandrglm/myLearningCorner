# Module 03 - 104: Python - Combining Arguments into a Function



****

## Video lesson Speech:

So far in the section on Python functions we have walked through a number of different argument types.  

 We've walked through positional arguments.  

 We've walked through unpacking of lists of arguments and then we also saw how we could work with keyword argument lists as well.

****

In this guide, we're going to take all of that knowledge and we're 
going to combine it into a single function. So we're going to create a 
greeting function. But this function is going to perform all of the 
tasks and I'm going to show you how you can work with all of those 
various types of function arguments at the same time.

So you say def greeting, I'm going to start off with a positional 
arguments you say time of day then I'm going to give a single Asterix 
here and to say args by following the common convention and this is 
going to take in the user's name and then I'm going to work with keyword
 arguments so we're going to use double asterisks kwargs and then from 
there we are going to provide the function body.

```python
def greeting(time_of_day, *args, **kwargs):
```

So the behavior that I'm looking for is I want to print out a 
greeting to the screen for the user and then I want to iterate through 
the key-value pair of arguments and this is going to be a task list. And
 so I'm going to start off with the traditional print statement so I'll 
use a formatted string here so I'll say f and then Hi and then inside of
 this I'm going to use a string literal and pass in a join statement 
like we've done before.

So I'm going to join the args which is going to take in the full set 
of arguments and this is going to be the user's name. So this could be 
their first name, their first and last name, their first middle and last
 name, it doesn't matter it will work for any type of user. So say hi 
and then print out their name and then I'll say I hope you are having a 
great and then put inside the time of day and that will end our 
greeting.

```python
def greeting(time_of_day, *args, **kwargs):
 print(f"Hi {' '.join(args)}, I hope that you're having a good {time_of_day}")
```

Now I'll give a couple more lines and this is where we're going to 
work with our keyword arguments. So I'm going to first check to see if 
there are keyword arguments because they are optional. So I'm going to 
say if there are any keyword arguments then I want to print out a task 
list. So I'm gonna say print and then say your tasks for the day are, 
and then it's simply going to print out that list.

We're going to implement a loop, and so this is going back to what we
 learned when we talked about looping over dictionaries because remember
 a keyword argument does return a dictionary to us. So I'll say for the 
key and the value and I'm just going to say key and val in our keyword 
arguments and remember that we can't simply list over a loop over the 
dictionary just by itself. We also have to grab the items and so I'm 
going to say in keyword argument items and then from here we're going to
 print the values out.

So I'm just going to say print and we'll use a formatted string once 
again and I'll say key and then from there let's just give a little 
arrow. So this is going to be the task and then it's going to be 
whatever the value is. And so then I'll say val and that should be all 
that we need to do.

```python
for key, val in kwargs.items():
 print(f"{key} => {val}")
```

So let's come down and let's test this out by actually calling the 
functions. I'm going to call greeting and pass in some values, I'm going
 to use a slightly different syntax for passing in these values. Any 
time that you see a large number of arguments being passed into a 
function like we're going to have right here then you usually are going 
to want to place them on different lines simply for readability.

So let's pass in morning, this will be the time of day add comma at 
the end and then let's move down to the next line. And we're going to 
line these up and so now we can put in our name. So put in Kristine 
followed by Hudgens. And then let's come down. So so far if you notice 
the way I'm organizing these function calls is I'm passing in first the 
positional argument because that one does need to be placed at the very 
start of our function call and then I'm passing in the args. So this is 
our set of unpacked items that we're going to pass in right here. So 
this is the name. And lastly, as you may have guessed I'm going to pass 
in our keyword arguments.

So I can say the first task is going to be empty dishwasher and then 
the second task is going to be, take the pupper outside, and the third 
one is going to be math homework and then from there that is going to be
 the end of our function call. So just in review we have started with a 
positional argument then we passed in a set of items or which is going 
to be converted into a tuple of arguments and then we passed in a full 
set of keyword argument.

So if everything works here we should see a greeting followed by a 
full set of the arguments. If I run this you can see that that worked 
perfectly.

![large](./03-104_IMG1.png)

It says Hi Kristine Hudgens, I hope you're having a great morning 
Your tasks for the day are: first to empty the dishwasher, second take 
pupper outside, and third math homework so this works perfectly and in 
review you can see that we took each one of the potential argument 
types. We took a positional argument a unpacked set of items and then 
also our keyword arguments and we were able to combine all of those into
 a single Python function.

## Code

```python
 # 03-104: Combining all Arguments types into one Function

def greeting(time_of_day, *args, **kwargs):
    print(f'Hi {' '.join(args)}, I hope that you\'re having a good {time_of_day}.\n')

    if kwargs:
        print('Your daily tasks are:\n')

        for key, val in kwargs.items():
            print(f'{key} => {val}')

greeting(
    'Morning', 
    'Homer', 'J.', 'Simpson', 
    first = 'Prepare Coffee',
    second = 'Login',
    third = 'Wait for further instructions'
    )
```
