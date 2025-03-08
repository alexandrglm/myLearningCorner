# MODULE 03 - 126: Python - Dunder Methods 3:

# Building a Custom Iterator Class -> `__iter__` / `__next__`

In this guide, we will explore **how to build a custom iterator class in Python**. Iterators are a fundamental part of Python, allowing us to loop over sequences efficiently.   

While Python provides built-in iterable objects such as **lists, dictionaries, and tuples**, sometimes we need to **create our own iteration logic** to handle specialized behaviors.

By the end of this guide, you'll understand:
✅ How iteration works internally in Python.  
✅ Why custom iterators are useful in **real-world applications**.  
✅ How to implement the `__iter__` and `__next__` methods correctly.  
✅ How to write clean, **efficient, and reusable** iterable classes.

🔗 **Reference:** [Python Iterators](https://docs.python.org/3/tutorial/classes.html#iterators)

---

## 🔹 What Is an Iterator?

An **iterator** is an object that allows **sequential traversal** of a collection, without exposing its internal structure. It follows these two principles:   

1️⃣ **Implements `__iter__()`** → Returns the iterator object itself.
2️⃣ **Implements `__next__()`** → Returns the next value in the sequence or raises `StopIteration` when the sequence ends.

### ✅ Example: Python’s Built-in Iterators

Python automatically implements iteration for lists:

```python
players = ['Springer', 'Bregman', 'Altuve']
player_iter = iter(players)  # Get an iterator
print(next(player_iter))  # Springer
print(next(player_iter))  # Bregman
```

📌 **Key Concept:** Behind the scenes, Python calls `iter()` on the list and then `next()` to retrieve each item.

🔗 **Reference:** [Python `iter()` and `next()`](https://docs.python.org/3/library/functions.html#iter)

---

## 🔹 Why Create a Custom Iterator?

Let’s say we’re building a **scoreboard system** for a baseball game.   

Each time a new player steps up to bat, we want to **retrieve the next player in the lineup**.   

However, when we reach the last player, we need to **loop back to the first player automatically**.

A regular `for` loop would **stop at the last player**, but we need continuous cycling. A **custom iterator** allows us to define this behavior **precisely**.

---

## 🔹 Implementing a Custom Iterator Class

### ✅ Step 1: Define the Class and `__init__`

```python
class Lineup:
    def __init__(self, players):
        self.players = players
        self.last_player_index = len(players) - 1
```

📌 **What Happens?**

- The `__init__` method **stores the player list**.
- `last_player_index` keeps track of the final index in the list.

---

### ✅ Step 2: Implement `__iter__()`

```python
    def __iter__(self):
        self.n = 0  # Start from the first player
        return self
```

📌 **Why Is This Needed?**

- `__iter__()` makes the object **iterable**.
- It returns **`self`** so the iterator object can be used in loops.

🔗 **Reference:** [Python `__iter__()` Method](https://docs.python.org/3/tutorial/classes.html#iterators)

---

### ✅ Step 3: Implement `__next__()`

```
    def __next__(self):
        if self.n <= self.last_player_index:
            player = self.players[self.n]
            self.n += 1
            return player
        else:
            self.n = 0  # Reset to beginning
            return self.players[self.n]
```

📌 **What Happens?**

- If `n` is **within range**, return the current player.
- If `n` **exceeds the last index**, reset to `0` and start over.

🔗 **Reference:** [Python `__next__()` Method](https://docs.python.org/3/tutorial/classes.html#iterators)

---

## 🔹 Running the Iterator

### ✅ Example Usage

```
astros = [
  'Springer', 'Bregman', 'Altuve', 'Correa',
  'Reddick', 'Gonzalez', 'McCann', 'Davis', 'Tucker'
]

astros_lineup = Lineup(astros)
process = iter(astros_lineup)

print(next(process))  # Springer
print(next(process))  # Bregman
# Keep calling next(process) to cycle through players
```

📌 **What Happens?**

- The iterator starts at **Springer**.
- Each `next(process)` call retrieves the next player.
- After reaching **Tucker**, it loops back to **Springer**.

---

## 🔹 Improving the Code: Refactoring for Clarity

### ✅ Creating a Helper Method

To make the code more readable, let’s define a method to **fetch a player**.

```
    def get_player(self, index):
        return self.players[index]
```

Now we modify `__next__()` to use `get_player()`:

```
    def __next__(self):
        if self.n <= self.last_player_index:
            player = self.get_player(self.n)
            self.n += 1
            return player
        else:
            self.n = 0
            return self.get_player(self.n)
```

📌 **Why Is This Better?** ✅ Code **reads more intuitively**.  
✅ `get_player()` clearly **describes its purpose**.  
✅ **Less duplication**, improving maintainability.

---

## 📌 Summary

- **Iterators** allow sequential access to elements without exposing internal structure.
- **Custom iterators** are useful when you need specialized iteration logic.
- A **custom class must implement**:
  - `__iter__()` → Returns the iterator object.
  - `__next__()` → Retrieves the next value (or resets if needed).
- Using a **helper method** improves code readability and efficiency.

****

## Video lesson Speech

So far in this section we've walked through a number of the Dunder methods that are available in python.

****

In this guide, we're going to walk through two very interesting ones and they're going to allow us to **build a full iterable module** inside of Python.   

And if you do not know what iteration is you have been using it ever since you learned about loop's so different tools such as lists and dictionaries and tuples those are iterable and as great as they are sometimes you may need to implement your own type of iteration and that's all we're going to walk through in this guide. 

So right here we have this list and it is a list of strings and I want you to imagine that you're building out some type of web or mobile application and every single time a new player comes up to bat you need the ability to call that next player. So when it starts you want to pronounce Springer then Bregman all the way down. 

And so far everything that I've just explained could be handled by a for in loop but what happens when we come down to Tucker? In a traditional scoreboard application, something that you might build inside of a mobile web API the behavior you'd be looking for is for Tucker to finish and then automatically go up and look at Springer again and then go all the way down and to just keep on going through it this way. 

Because when it comes to building out a dynamic program such as what you'd need to manage a scoreboard or a mobile API or anything like that you're not going to be able to hardcode how many times you want to iterate through the list and you also don't want to loop through the list you want the ability to call them one at a time. And so by creating our own custom iterable what we're going to be able to do is to have complete control over the behavior of how we loop through this collection. 

What I'm going to start off by doing is creating a new class here. This is going to be called Class Lineup and for the init methods here I'm gonna say def Dunder init and it's going to take in self along with some players and you can have yours do anything that you want. You can take in any kinds of strings or any other type of collection you just have to make sure it is a collection, a list like we have right here. Now inside of here I simply want to say self.players and set this equal to players and so now we're going to get into how we can actually make this class iterable. 

And it may help to come down to the bottom here and walk through what we want the implementation to look like so what we want it to look like when we're calling it. I want the ability to do something like this to say Astro's underscore a lineup and set this equal to our class so I'm going to instantiate our lineup class and just pass in our variables I'm going to pass in the list. 

Now the way that Python works is right here this is not going to be iterable yet. So Astro's lineup is simply an object in the way that it's looking at it right now. So the way it works is we're going to create a process and you don't have to call it a process but that is one of the common conventions that you'll hear this called. 

And so I'm going to create a process here and then I'm going to call the iter function and so this is going to be Dunder iter on the Astro's lineup so it's going to be called on the class. But now for this to work what I need to do is to actually define two types of Dunder functions inside my Lineup class so if you want to make your own iterable what you have to do is to have one function that is going to be Dunder iter and it'll get passed self and then the other one is going to be called Dunder next and so that is going to be what allows us to call next on the item. 

```python
def __iter__
def __next__
```

so what we're looking to do when we're actually going to call this is to do something like this where I say print out next process and then I can call it again and the way that I want this to work is I want the first time it goes through it to show Springer. Then next time I call process I want it to call Bregman and then when I get all the way down to the bottom and I call Tucker the next one I want it to pop all the way back up top and start the process again. 

```python
class Lineup:

    def __init__(self, players):
        self.players = players

    def __iter__(self):

    def __next__(self):

astros = [
  'Springer',
  'Bregman',
  'Altuve',
  'Correa',
  'Reddick',
  'Gonzalez',
  'McCann',
  'Davis',
  'Tucker'
]

astros_lineup = Lineup(astros)
process = iter(astros_lineup)

print(next(process))
print(next(process))
```

So let's get started on how we need to build that. So inside of iter there are two things that you need to do for this case. So any iterable needs to return self. And that is going to be something because if you're calling iter like we're doing their online 24 then we need some value returned. 

Now the other thing I'm going to do is when iter is called when line 25 now is called I want to create a counter variable so say self.n and I'm going to set it equal to zero. 

```python
self.n = 0
```

And the reason why we need this is because we need to keep track of where we are inside of our lineup. So we need to know that we are at the index of zero here and where the index of 2 right here. And then at the very end very importantly, that we are at the index of eight down here so that we can start the whole process over again. So inside of our Dunder iter method that's what we going to do. 

```python
def __iter__
  self.n = 0
  return self
```

Now the majority of the logic is going to be inside of our Dunder next function. So what I'm going to do is I'm going to check to see. So I'll say if self.n is less than the length of self.players and don't let this one scare you, we're going to clean it up in a little bit but I'm gonna say if self.n is less than the length of players -1 then I want you to perform this process. 

```python
def __next__(self):
  if self.n < (len(self.players) -1):
```

And so I'm gonna set players I'll create a new variable called player, set this equal to self.players and then because we're going to just be accessing the list we can use our brackets and say self.n then I want to return this player. But before I can do that I also need to increment our self counter. So I'm going to say self.n plus equals 1. 

```python
    def __next__(self):
        if self.n < (len(self.players) -1):
            player = self.players[self.n]
            self.n += 1
            return player
```

Okay, let's review that because if you've never written code like this, this may look a little bit odd but let's walk through exactly what we're doing. So when I call next the very first thing that's going to happen is it's going to check to see what n is so in the very first time as you can see there on line 6 the very first time n is going to be zero that's going to be our index. And then I'm going to check to see is that less than the length of the list. 

Now the reason why I need to subtract one is because technically what I want is not the actual length of the list because if you count this you can see we have nine elements inside here. I don't want the length, I want whatever the value is of the index at this last element here and that is actually going to be 8. So remember this is where off by one errors can get a little bit tricky. But Springer even though it's the first element remember it has an index of zero and then we have one two three four five six seven and eight elements.

So if we do not subtract one right here we're going to end up with off by one errors because we're comparing an index by the length where we really want to compare an index with the last index. So whenever you need to find the last index in a list you can simply call on the length which is going to give you the count of all the items and then subtract 1 and that gives you the index value or gives you the index number in the last element. 

So from there, we are simply running a query in that list, it's going to grab us that player and then from there we're going to increment self.n by one. So that's what is going to make it be iterable that's what's going to make it move down the line. Now we also need to check for the condition and instead of else just to be on the smart side what I'm going to do is an elif and here I'll say elif self.n is equal and I'm going to use the same code here so I'm going to say len self.players and then from there to say minus 1 and now inside of here I'm going to use the same code here where you say actually I'm gonna use almost the same all the same code. 

I'm grabbing the same player but instead of incrementing by one what I want to do is set self.n equal to zero again. So this is going to start the counter over and then we're going to return the player. So so far I think this is everything that we need and if some of your codes spidey sense is going off and you think that we have too much duplication in this code and that it's not easy to read, you are a hundred percent right. So we're going to come back and refactor it shortly.

But for right now let's just make sure that this is actually working and that we don't have any typos or anything like that. So I'm going to run python and then this is oop_guide.py and there we go we have our first two players that got printed out Springer and Bregman. 

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Object+Oriented+Programming+(OOP)+in+Python/How+to+Build+a+Custom+Iterator+Class+in+Python+%23+1601/image11.png)

Now let's come down because as helpful as that is, that was really the easy part a for in loop could have done that. What we want is to be able to call this as many times as we want and have iterate over our lineup and then start over again automatically. So now if I call it a bunch of times and run the same code you can see that this is working perfectly. 

![large](./03-126_IMG2.png)

So our lineup class is doing exactly what we would want an iterable lineup class to do. So it goes Springer all the way through to Tucker as you can see that matches our list. And then it automatically starts back up and it keeps on going which is exactly how you would want this type of situation to work.

Now let's get to refactoring the code because as you can see we have some duplication and also that's kind of hard to read if I were to come back to my own code that looked like this even in a few days it would take me a while to realize what's going on so we can do a lot better not even really with the process works perfectly as you can see but what we can do better is with our communication in the code. 

We can write this code so it actually makes more sense. So the first part is I don't like this long length call and the fact we're calling it twice and it doesn't really make that much intuitive sense. 

```python
    def __next__(self):
        if self.n < (len(self.players) -1):
            player = self.players[self.n]
            self.n += 1
            return player

        elif self.n < (len(self.players) -1):
            player = self.players[self.n]
            self.n = 0
            return player
```

I'm not a big fan of that so I'm going to get rid of it and I'm going to create a new instance variable so I'll say self dot and then let's be descriptive so I'm gonna say last_player_index and then set this equal to that value. So I'm going to use the exact same code where I'm saying I want the length of the player's list and then subtract 1 and then store this inside of this instance variable. 

```python
   self.last_player_index = (len(self.players) - 1)
```

So now I can call last player index from our conditionals and this is going to be so much more descriptive. If I come back and I read this code even years from now I'm going to be able to know right away that this is trying to pull in the last player index. So that is perfect, I like the way that that reads much more. I can do the same thing self.player index. Let's check our code again and make sure that everything is working and everything is still working perfectly. 

![large](./03-126_IMG3.png)

Now there's only one other thing that I would like to update here and that is that we have some duplicate code going on here in our if statement and here in our elif statement and even though it's not horrible I think we can still do a little bit better than this as well. 

So I'm going to create a function here and just call it get_player. It's going to take in self and n and then it is going to perform this process so it's going to return self.players and then we're going to pass the index or we are going to pass n to players and then that is all we should need to do and we can get rid of this call and this call. 

```python
    def __next__(self):
        if self.n < (len(self.players) -1):
            player = self.players[self.n]  <= (remove)
            self.n += 1
            return player

        elif self.n < (len(self.players) -1):
            player = self.players[self.n]  <= (remove)
            self.n = 0
            return player
```

And instead of returning player, we're going to say I want you to return self.get_player and then from there pass in self.n copy this and do the same thing in the other conditional. And now let's run this one more time. And as you can see that is still working very well. 

![large](./03-126_IMG4.png)

Now it looks like we have one little bug I'm not sure if you noticed it yet but we have a one spot where I accidentally called this too early. So do you see how if you look at the code here it skips Springer the very first time? And so what I need to do is I need to say player equals and then come over here. So I need to call this first because self.n is getting incremented too quickly. Save that and let's run it one more time and wow I cannot believe I spoke too soon once again it has been a long day recording so I apologize. 

I still need to call this because we're setting an equal to zero too quickly as you probably already guessed. So now we're going to call player. Let's save and run it. I really hope this is the last time! OK, we're running it and there we go! It is working now.

![large](./03-126_IMG5.png)

Many times whenever you're refactoring you'll run into issues like that later on in the course. I'm going to walk through how to build out different tests and automated tests so that you will not run into issues like this where you have to keep on retesting. You can simply set up expectations for your program and then when you want to perform a refactor like we just did then you don't have to be scared of you accidentally breaking the program because your tests will automatically test all of the different cases to make sure that a refactor is working. 

And in this case, you may be wondering because we didn't actually get rid of any lines of code. We're still calling player here and having to store it in the variable and it's mainly because we needed to do it for order sake. But the reason why I like this is because it's much more descriptive. So if you were to come to this code and remember one of the top goals whenever you are developing is to write code that communicates a story. 

Imagine if you were to come to this code and you didn't actually write it. Imagine that I wrote it and you were asked to implement it. Well, you'd see that you have a lineup class. Okay, that is pretty self-explanatory this is going to provide a lineup. It takes in players and then you see right away that you not only have access to players but you also have access to the last players index. So you know right away what that value is.

From there you see that it is an iterator because it implements the Dunder iter function and then you see get_player. Now right away I think this is pretty intuitive where it is explaining that this function returns a player. So now if I come down into the next function then I know that I can call this. 

It is going to return the next item in that list whatever list I pass to it and instead of putting my parsing here where I have all of these players and brackets and things like that instead I'm just saying grab me a player and call the get_player method, pass it the index store it in the variable and it's very clear that right here what this process does is it returns a player and the same thing down below in this conditional. So I think that this entire class tells a pretty clear story and for whoever is going to use it they're going to be able to pick it up and implement it. 

****

## Code

```python
class Lineup:

    def __init__(self, players):
        self.players = players
        self.last_player_index = (len(self.players) - 1)

    def __iter__(self):
        self.n = 0
        return self

    def get_player(self, n):
        return self.players[n]

    def __next__(self):
        if self.n < self.last_player_index:
            player = self.get_player(self.n)
            self.n += 1
            return player
        elif self.n == self.last_player_index:
            player = self.get_player(self.n)
            self.n = 0
            return player


astros = [
  'Springer',
  'Bregman',
  'Altuve',
  'Correa',
  'Reddick',
  'Gonzalez',
  'McCann',
  'Davis',
  'Tucker'
]

astros_lineup = Lineup(astros)
process = iter(astros_lineup)

print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
print(next(process))
```
