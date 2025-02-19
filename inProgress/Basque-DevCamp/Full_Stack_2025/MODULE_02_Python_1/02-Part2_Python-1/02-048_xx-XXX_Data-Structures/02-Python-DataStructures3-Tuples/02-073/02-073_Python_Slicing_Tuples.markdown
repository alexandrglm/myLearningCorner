# MODULE 02 - 073: Python - Slicing Tuples / .slice() with reassignment operators



****

## Video speech lesson

So far in the section on Python tuples we've analyzed how to create tuples and one of the most important components that we walk through is the difference between a tuple and a Python list and we're going to extend that knowledge in this guide as we talk about how we can slice tuples.

****

You're going to be pleasantly surprised that **if you are familiar with how you can slice Python lists that knowledge is going to carry directly into how you can work with tuples.**   

And so this is going to be a quick guide because the **syntax is nearly identical.**

However, I wanted to make sure that we covered it just so you were aware that you could treat a tuple in the same way that you treat a list as it relates to slices.

****

So I'm going to create a print statement right here and I'm going to call post and with post I can use a standard range so say I want to start at the very beginning so I want to grab that first element.   

I can skip over that first expression here so I'll have to type thing in and then say I want to grab the first 2 elements I can pass in the index of.

 And this is going to return 'Python basics' and 'Intro guide to Python' so if I run this you can see that it returns a tuple of those first two elements.

![large](02-073_IMG1.png)

Now that is **one of the key differences** when it comes to a **tuple versus a list** if you remember whenever you run a slice or arrange in a list it returns a list of the items that you requested.

**When you're working with slices with tuples it's going to return a tuple** so, hopefully, that's pretty intuitive.   

**It's going to keep the same data structure regardless of if you're working with a list or a tuple.**   

Now, all of the same rules apply when it comes to working with tuple elements which means that you can pass in 3 different arguments here.   

So,  say that I want to skip the first element and I want to grab the index of 1, so, this is going to be this intro guide to Python right here.  

 And then I want to go all the way to the end I can skip the second argument and then I can pass in the interval I can pass in the step counter here of 2.   

So, if you remember back to when we talked about ranges and when we
 talked about slices, this is  **the same exact syntax** so that carries directly into working with tuples.

So now if I run this command

![large](02-073_IMG2.png)

you're going to see that the first element or I should say the element with an index of 1 is intro guide to Python so it gives us that end because we added a step of 2 it skipped this Some cool Python content and then it brought us published.

**That is exactly the same way that a slice works inside of a list and inside of a string and so we're able to perform that same task when we're working with Python tuples.**

## Code

```python
post = ('Python Basics', 'Intro guide to Python', 'Some cool python content', 'published')
print(post[1::2])
```
