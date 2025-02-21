# MODULE 03 - 080: Python: Control Structures -> Loops



****

## Video lesson Speech

Nice work going through that section on data structures that's going to be one of the largest sections of this entire course. And now we're going to switch it up a little bit and now we're going to talk about loops.  

****

You may be curious about why I have a gumball machine here:

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+Programming+with+Python/Python+Loops/Introduction+to+Python+Loops+%23+1437/image1.png)

Part of the reason is that we have two different types of loops inside of python.   

And what we're going to do with our gumball machine is see how they are different from each other.   

So, the two types of loops are:

* **for-in loop**s 

* **while** loops
  
  

Let's talk about what the differences are, because both of them can be used to iterate over collections over a range of numbers over lists anything like that.

There is a very key difference though that I want you to understand before we dive into the syntax and see how they can be used.   

So, as you can see with our gumball machine right here, if I were to turn this knob 
and pull it out like that I get a gumball.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Introduction+to+Programming+with+Python/Python+Loops/Introduction+to+Python+Loops+%23+1437/image2.png)

Now, you can see we have a large number of gumballs in here and I don't know the exact count but it's definitely in the hundreds.   

A **for-in loop** would be the ability to turn this knob many times but only as many
 times as there are gumballs in here.   

In other words, if I have 250 gumballs in this machine a for-in loop will turn this knob and let a gumball fall out 250 times.

That is a very nice thing about for in loops because you as a developer you don't have to keep track or even know how many items are in a list in a tuple or in a dictionary you can simply iterate over it.  

If there is one it will go through it one time, if there are 5,000 you'll go through 5,000 times.

### While

The second type of loop is a while loop.  Now, a while loop is very different.   

It's a little bit more low level, it's not quite as intelligent as a for-in loop.

A while loop will continue as many times as you want it to go.   

So, in other words, if we have 250 gumballs in here and I set a while loop to perform this task, and I don't tell the while loop when to stop even after I've gone through and I've spun the knob 250 times the while loop will keep ongoing.   

It will do it a thousand times, 2000 times, they'll keep on going and in fact, if you don't 
implement a while loop properly then you will run into what's called an infinite loop where the program will never stop and eventually the computer or the server will just crash.

What you have to do when working with a while loop is you as a developer need to actually tell it when to stop.   

One of the most common questions that I get from students when I'm teaching them these two types of loops is when in the world would I ever want to use a while loop if a for-in loop does everything and it's easier.

Well, the answer is that you're going to be using a for-in loop most likely about 95 percent of the time I simply want to show you both options 1 in case you ever come across a while loop you'll understand exactly how it works but there also are a few edge cases well where a while loop does work better than a for-in loop and we'll talk about what those are.

****

## Code examples

```python
# 03-080. Control Structures -> Loops
import random


# for...in

numbers = []

for number in range(10):
    numbers.append(str(random.randint(0, 10000)))

print(numbers)



# while 

numbers_while = []

while len(numbers_while) < 10:
    do: numbers_while.append(str(random.randint(0, 1000)))

print(numbers_while)


```
