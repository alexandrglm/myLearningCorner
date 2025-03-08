# MODULE 03 - 127: Python - Iterators vs Generators

In the previous guide, we built a **custom iterator** using `__iter__` and `__next__`.   

While this method allows full control over the iteration process, it requires **a significant amount of boilerplate code**.

A more concise alternative is **generators**, which simplify iteration by using the `yield` keyword.   

This guide will compare **iterators vs. generators**, showing how both achieve the same goal with different approaches. 🚀

By the end of this guide, you'll understand:
✅ The fundamental difference between **iterators** and **generators**.  
✅ How `yield` works in Python.  
✅ Why generators are often **preferred** over traditional iterators.

🔗 **Reference:** [Python Generators](https://docs.python.org/3/tutorial/classes.html#generators)

---

## 🔹 Understanding Iterators

An **iterator** is an object that **follows Python’s iteration protocol**:  
1️⃣ Implements `__iter__()` → Returns the iterator object itself.  
2️⃣ Implements `__next__()` → Returns the next value or raises `StopIteration`.  

### ✅ Example: Custom Iterator (Manual Implementation)

```python
class Lineup:
    def __init__(self, players):
        self.players = players
        self.last_player_index = len(players) - 1

    def __iter__(self):
        self.n = 0
        return self

    def __next__(self):
        if self.n > self.last_player_index:
            self.n = 0
        player = self.players[self.n]
        self.n += 1
        return player
```

📌 **Remember :**

- We manually manage the **iteration state** (`self.n`).
- We must **reset the counter** when it exceeds the last index.
- Requires **both `__iter__()` and `__next__()`**, making it more verbose.

🔗 **Reference:** [Python Iterators](https://docs.python.org/3/tutorial/classes.html#iterators)

---

## 🔹 Introducing Generators

A **generator** simplifies iteration by replacing `__next__()` with **`yield`**, which automatically maintains the iteration state.

### ✅ Example: Rewriting the Iterator as a Generator

```python
class InfiniteLineup:
    def __init__(self, players):
        self.players = players

    def lineup(self):
        lineup_max = len(self.players)
        idx = 0

        while True:
            if idx < lineup_max:
                yield self.players[idx]
            else:
                idx = 0
                yield self.players[idx]
            idx += 1
```

📌 **What Changes?**

- **`yield` replaces `return`** → This allows Python to pause execution and resume later.
- No need for **manual state tracking** (`self.n` is gone).
- The method **automatically works as an iterator** without `__next__()`.

🔗 **Reference:** [Python `yield` Statement](https://docs.python.org/3/reference/simple_stmts.html#yield)

---

## 🔹 Key Differences: Iterators vs. Generators

| Feature                       | Iterators                              | Generators                                   |
| ----------------------------- | -------------------------------------- | -------------------------------------------- |
| **Implementation Complexity** | Requires `__iter__()` and `__next__()` | Uses `yield`, no need for `__next__()`       |
| **Memory Efficiency**         | Stores all values in memory            | Generates values on demand (lazy evaluation) |
| **State Management**          | Manual tracking (`self.n`)             | Automatically maintained by `yield`          |
| **Best Use Case**             | When custom logic is needed            | When iteration is straightforward            |

📌 **Why Choose Generators?**   

✅ **Less boilerplate** → No need for `__iter__()` and `__next__()`.  
✅ **More readable** → `yield` simplifies code structure.  
✅ **Memory efficient** → Generates values **only when needed**.  

---

## 🔹 Running the Generator

### ✅ Example: Using `next()` with a Generator

```
astros = ['Springer', 'Bregman', 'Altuve', 'Correa']
full_lineup = InfiniteLineup(astros)
astros_lineup = full_lineup.lineup()

print(next(astros_lineup))  # Springer
print(next(astros_lineup))  # Bregman
print(next(astros_lineup))  # Altuve
print(next(astros_lineup))  # Correa
print(next(astros_lineup))  # Loops back to Springer
```

📌 **What Happens?**

- Calling `next()` fetches the **next value in the sequence**.  
- Once the last player is reached, **the generator loops back automatically**.  
- Unlike a traditional iterator, **no manual state reset is needed**.  

---

## 🔹 Understanding `repr` and `str` with Generators

To make debugging easier, let’s define `__repr__` and `__str__` methods:

```
class InfiniteLineup:
    def __init__(self, players):
        self.players = players

    def __repr__(self):
        return f'InfiniteLineup({self.players})'

    def __str__(self):
        return f"InfiniteLineup with players: {', '.join(self.players)}"
```

### ✅ Example: Printing an Instance

```
print(repr(full_lineup))  # InfiniteLineup(['Springer', 'Bregman', 'Altuve', 'Correa'])
print(str(full_lineup))   # InfiniteLineup with players: Springer, Bregman, Altuve, Correa
```

📌 **Remember:**

- `__repr__` provides **technical debugging information**.
- `__str__` provides **human-readable output**.

🔗 **Reference:** [Python `__repr__` and `__str__`](https://docs.python.org/3/reference/datamodel.html#object.__repr__)

---

## 📌 Summary

- **Iterators require `__iter__()` and `__next__()`**, making them more complex.
- **Generators use `yield`**, simplifying state management and memory usage.
- **Generators automatically track their state**, reducing the need for manual counters.
- **Use iterators** when you need custom behavior.
- **Use generators** for cleaner, more efficient iteration.

****

## Video lesson Speech

In the last guide, we walked through how we could build our own custom 
iterator. And we saw how we could leverage the tools such as Dunder iter
 and Dunder next in order to build out an infinite lineup and in many 
cases that will be the approach that you want to take whenever you need 
to build your own custom behavior into the iteration process.

****

But another option that you will have access to is to build what is called a generator. And that's what we're going to walk through in this guide. So we're actually going to replicate the exact same behavior but we're going to use a different tool. And then you're going to be able to see side by side what those implementations look like so you can see which option you prefer. 

So I'm going to quit out of this. And I created a generator file that right now simply has the exact same list that we were working with before. 

![large](./03-127_IMG1.png)

So now I'm going to create a class and I'm going to call this my class infiniteLineup just so we have two different class names when you want to see them side by side. And in our infinite lineup, I'm going to start off with an init method so I'm gonna give a def double underscore init followed as usual by self and then players. So so far everything is pretty much the same.

```python
def __init__(self, players):
```

I'm gonna say self.players is equal to players so we can bring in that players list and now I'm going to create a lineup method so  `def lineup(self)` so I'll have access to players and inside of here I'm going to declare my max lineup so I'm just going to create a variable here called `lineup_max` and set this equal to the length of self.players. It's going to bring in the total list of players or the count of how many players are there and then I'm going to set the index equal to 0. 

```python
def lineup(self):
    lineup_max = len(self.players)
    idx= 0
```

Now part of the reason why I like this approach if you remember back to the last one where we had to implement quite a bit of custom behavior with all of those negative indexes and had to play around with the way that we constructed the loop. What I'm going to do here is going to be a little bit more straightforward or at least I think it's going to be easier to follow along with. 

And that is because I'm going to create on purpose an infinite loop so I'm just going to say while True so this means that this is going to continue until we tell it to stop. I'm going to have a conditional inside of here. So I'm going to say if the index is less than lineup_max then I want to and, now do not let this part scare you if you've never seen this keyword. 

This is what generator's use it's called the yield keyword. Now, this is a special keyword in python and essentially what it's doing is exactly what it says, it's yielding to the generator so I'm going to say yield to self.player's index. Else I want to set the index equal to 0 so we're resetting the index and then I still want to yield to self.players and then index. Then from there what I want to do while still inside the loop so still within this while loop I want to increment the index so I'm gonna say increment that by 1 and then that is all that we need to do. 

```python
 while True:
            if idx < lineup_max:
                yield self.players[idx]
            else:
                idx = 0
                yield self.players[idx]

            idx += 1
```

Now, I also want to add a few best-practice items so let's add a Dunder repr and Dunder string function here. So I'll add a repr function which will take in self and then this is going to return that entire object so I'll say return a formatted string and we'll just wrap this so it looks like a full object. So I'll say infiniteLineup and then pass in the values so will use our curly braces and say self.players and then close it off and then we'll create something pretty similar for the Dunder string method. And once again this is just so we can get some practice on seeing what this like.

So here you can say infiniteLineup with the players and then just pass in that list of players in something that looks a little bit prettier than what we had with repr. 

```python
  def __repr__(self):
        return f'InfiniteLineup({self.players})'

    def __str__(self):
        return f"InfiniteLineup with the players: {', '.join(self.players)}"
```

And so now this is the full implementation so let's verify that it works and then we'll walk through exactly what's going on here. 

So I'm going to give us some room. And one thing you might find interesting is even though we didn't create a Dunder iter or Dunder next method the way that we did in the last guide we're actually going to have access to a pretty similar API when it comes to calling them.

So let's start off by creating a full_lineup variable and this is going to instantiate our InfiniteLineup which will take our list of players. And now I am going to create an instance of lineup so I'll call astros_lineup and we'll set this equal to the full_lineup and then because if you notice here at the top we created a lineup method. So we simply need to call that right here so I'm gonna say full_lineup.lineup and then because it's a function we need to call it just like this. 

And now let's test this out first with our repr and string functions. So I'll say print repr and then pass in the astros_lineup and do the same thing with string just so we see that everything's working. We don't have any typos or anything like that. So I'm going to come here python generators and you can see that so far so good. 

![large](./03-127_IMG2.png)

It's simply printing out the object items and that's because we don't have anything inside of them yet so it doesn't look like we have any typos or anything. Now in between here, this is where we're going to actually call this so as you notice it didn't show us any players or anything like that and it's because we haven't started the process of generating them yet. So now I'm gonna say print and then say next just like we did when we build out our own iterators.

I mean it's a print next and then just call astros_lineup and then that is all that we have to do. So let's just create three of these so this should print out Springer, Bregman, and Altuve because it's going to start off with one then we call next again it'll move down the chain and then call Altuve for the third one. 

So let's come over here, run it again. And as you can see that is working properly. 

![large](./03-127_IMG3.png)

So right now you can see that we have each one of those three items and that is exactly what we're looking for. 

Now let me come over here. Let's create a few more of these so we'll just go through the lineup because this is an infinite lineup so we want the ability to keep on moving through it and so I run this again you can see it is working very nicely. 

![large](./03-127_IMG4.png)

You notice that and let's just double-check it to make sure we don't have a bug. We have Springer all the way down Tucker's the last one and then it starts over at Springer once again so this is working beautifully. And then we can also see down here that you notice when we printed out string here and repr notice here where it is not printing out the actual data and this is a very important thing to keep in mind. 

Whenever we created just our own plain types of string methods and are under string methods and Dunder repr ones on plain classes remember there how it was returning the string or whatever hardcoded item that we sent along. Well here, notice this is overwriting that behavior and without us actually saying that we are creating a generator. 

The fact that we and this is where all the magic happens for generators. The fact that we have yield right here and yield here and then we're calling next automatically tells python that we are creating a generator object. Notice that we didn't say generator anywhere when we created the class or the object we simply created a standard class. But whenever you put yield inside that is telling Python hey watch out we have a generator coming you need to be able to work with next and you do not have to define it. 

That's a reason why when we print this out the actual Python language is defining our repr and string so it still gives us data. It still tells us that we're calling the infinite lineup and then we're calling the lineup method and it shows where in memory it's doing that but it's actually doing that automatically for us. 

So this is something that is a little bit different than what we used last time and now let's look at this right next to each other so I'm going to open up the last guide that we had and down below you can see this is our current version. So right here we used our iter and our next methods and we built our own iteration. 

![large](./03-127_IMG5.png)

and notice here that we had to do quite a bit of work to get this working properly. We had to declare our counter, we had to work with our negative index values right here on length, and there were just a number of things that we had to do to get this working properly we had to create our own next function and declare an iter function and this worked perfectly, but it is not quite as clear in my personal opinion as what we have here in our current example. 

Typically whenever I am creating my own custom behaviors so if I were asked to build out a feature like this usually I would look to a generator and that's mainly just because I think it's a little bit easier to implement. And I think it's also pretty easy to read too. 

So right here we don't have to have all of that extra boilerplate code we don't have to declare our own Dunder next method or Dunder iter but instead, we've simply taken our values, we create our own custom function here and then inside of it we can simply call the yield and then that is going to provide all of that next type of behavior. And so I think this is a really nice way of being able to implement a custom iteration process.

****

## Code

```python
class InfiniteLineup:
    def __init__(self, players):
        self.players = players

    def lineup(self):
        lineup_max = len(self.players)
        idx = 0

        while True:
            if idx < lineup_max:
                yield self.players[idx]
            else:
                idx = 0
                yield self.players[idx]

            idx += 1

    def __repr__(self):
        return f'InfiniteLineup({self.players})'

    def __str__(self):
        return f"InfiniteLineup with the players: {', '.join(self.players)}"


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

full_lineup = InfiniteLineup(astros)
astros_lineup = full_lineup.lineup()

print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))
print(next(astros_lineup))

print(repr(full_lineup))

print(str(full_lineup))
```
