# MODULE 03 - 083: Python - Loop over Range()

****

## Video lesson Speech

So far in this section on loops in Python, we've talked about how we could loop through a collection of data such as a tuple a list or a dictionary.  

 And we also saw how we could treat a string like a collection of characters and iterate through that collection.

****

In this guide we're going to talk about how we can loop through ranges in python and where this is going to be a practical tool is when you know that you have a set number of times that you want to loop through some specific data set that you don't want to 
limit it to how many items are in some type of collection such as iterating over a list.

And so what we can do is actually **build a range.**   

If I type in the code for num and once again num is the iterator variable here so we 
could call this anything.   

I'm going to say num which is short for number and say for num in range and then range takes two to three arguments for our first example you say 1 comma 10 and then after that make sure that you add your colon.   

And then inside of this let's just see what happens when I print out num this is going to iterate over this range and as you can see it prints out 1 all the way through 9.

![large](03-083_IMG1.png)

You may think that this is a little confusing because I passed in the variables or the arguments of one to 10. 

**The way that a range works is very similar to when we were grabbing items and slicing items inside of a list**. 

Remember when we did that the way that Python works is it treats that the second argument here as an upper bound which means it doesn't actually go up to 10.

It goes and stops right before it gets to ten and so that is a very important feature to keep in mind because if you do not keep that in mind and you don't implement that in your programs then you could have a number of problems such as it's called an off by one error.   

That's where you build a program that works, **except that is off by one value** 
and that's pretty common for new developers and so that's a reason why I wanted to show you that.

So, that is one through ten, if we wanted to truly get the values of 1 through 10 then we can pass in 11, and then it will include that.   

And as you can see now on the right-hand side the values 1 through 10 and get printed out.

![large](03-083_IMG2.png)

****

### range(start, stop, STEP)

Now, what happens if you want to skip values?   

Well, there are a couple of ways to do this in other languages you might have to put some conditional logic in the code block here but thankfully in Python with ranges, the range function allows you to create your own intervals with an optional third argument.  

If I say one comma 11, comma 2 and then run this.   

You can see that what it does is it still goes over the same range except now instead of going with the default behavior where it simply increments by 1 in every single iteration of the loop.   

Now it goes and it skips 1 so it goes with every second value.

![large](03-083_IMG3.png)

And as you might have guessed if I change this to three and run it again it is good to go with every third value as you can see right here we have 1 4 7 and 10.

![large](03-083_IMG4.png)

And this is a really nice way of being able to create a range and then have the kind of control and flexibility for only grabbing the elements and the intervals that you actually want to show.

## Code

```python
for num in range(1, 10):
 print(num)

for num in range(1, 10, 2):
 print(num)
```
