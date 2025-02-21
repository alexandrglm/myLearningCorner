# MODULE 03 - 081: Python - Loops using lists, dictionaries, tuples



****

## Video lesson Speech

In this section on Python loops we are going to walk through how we can iterate over collections of data inside of our Python programs and in this guide we're going to take a look at three key types of data structures that we can loop through and we're going to utilize the same type of looping mechanism for each one of them.

****

So right here as you can see I have a basic list of strings

```python
players = ['Altuve', 'Bregman', 'Correa', 'Gattis']
```

### for...in with Lists

If I want to loop over each one of these, I'm going to use what is called a `for...in` loo.

 I can say `for` and then this first element I'm going to give might look a little bit confusing because it looks like I'm just making it up.   

And `in` a second it's going to make sense of how we can use this.  

 But I'm going to say for player in players follow that by a colon and then hit return.

```python
for player in players:
```

Now, it's very key that if you are using a text editor that doesn't automatically indent for you that you do have at least two or four spaces here on the left-hand side.   

I'll show you why that is needed here:

It's because python does force you to utilize indentation for code blocks. So for this, I'm going to say `for player in players` and I simply want to print out each one of these items.   

So, now, if I call this you'll see that it prints out each one of the strings Altuve to all the way through Gattis.

![large](03-081_IMG1.png)

Now, before we go on to tuples or dictionaries,  let's take a step back and see exactly what is going on right here.   

So, this player this is a common convention when you're iterating over a collection like we are right here.   

So, the word players is the variable. This is a direct mapping to players right here.

![large](03-081_IMG2.png)

So this, we need to keep the name here identical because this is the collection we're iterating over.  

 However, this first variable right here is a block variable or an iterator variable depending on your preference.   

With this, this could be named anything. And so there's 
nothing specific about using the word player here.

If I said X and then change this to x then this would still work:

![large](03-081_IMG3.png)

So, if I run this you can see that it still works exactly the same way.   

What you define here is completely up to you, what it represents is that each time that this loop goes through and iterates, it is going to change the value for the iterator variable.   

So, the first time that it iterates that X, and I'm going to change this back to player and I'll say why here in a second.   

But this player variable here this block variable is going to be equal to Altuve. Then when the for loop goes through again then the player variable is going to be equal to Bregman. Then it's going to be Correa and then Gattis, and so on so forth, if you 
had a million items that you were iterating over the player value here would change a million times.

Now, **the common convention**, whenever you were using a for-in loop just like we're doing here, is that **if you have a collection that has a plural name then the block variable that you are going to use should be named with a singular word of this plural collection**.   

So, if we have the word as we have right here players and this is the name of the 
collection then player is a great name for the block variable.

Imagine a scenario where you had a different kind of collection.   

So, say that you had some geometry kind of problem and you were iterating over a set of squares.   

You could say four square's in squares and this would be the common convention.   

Notice how we have a plural here which this is a collection and then our block variable is just the singular form of that and that is the common convention that you're going to use whenever you're using for in loops.

So, this is how you can iterate over a list.  

****

### for...in with Tuples

 Now, if we change this list and we change this to be a tuple it will work exactly the same way and that's one of the very nice things about working with tuples and 
lists is they do have a bit of shared performance and behavior.  

So, if I hit run now you can see this works exactly the same way.

![large](03-081_IMG4.png)

So, you can work with both of those data structures and treat them very similarly when it comes to looping.

****

### for...in with Dictionaries

Now, let's talk about how we can work with dictionaries.   

So, I'm going to create a player's dictionary here, and inside of it, I'm going to set 
up a series of key-value pairs so I'm going to have a second base.   

And this one's going to be Altuve and then we'll have a third base. This one
 will be Bregman and then shortstop this will be Correa and our last one
 here will be the DH and this one will be Gattis.

```python
players = {
 '2b': 'Altuve',
 '3b': 'Bregman',
 'ss': 'Correa',
 'dh': 'Gattis'
}
```

So, very similar to what we had with the list. But now we are using a key-value dictionary.   

So, now if we want to loop through this type of data structure the syntax we're going to use for our for in loop is very similar except now as you might imagine we have a couple of different elements here to work with we're not only working with a list item so we're not working with a single element.

Now, we need to grab the key and the value.   

And there's a way to do that where I can say for and now instead of just giving one block variable, I'm going to supply two words here so I'm going to say position and then player in player's dot items.   

And this is a function so remember that and this should be a colon right here at the end.

```python
for position, player in players.items():
```

And so remember when we discuss the items function, or remember items allow us to create a view into our dictionary, so it gives us access to get all of the items and because of how a for-in loop works we can pass two variables here and python is going to be smart enough to separate it out.  

So the very first time that it iterates through the very first item is going to be assigned with the first position.

So, our block variable position is going to be equal to the key which is second base and then player is going to be equal to the value which in this case is Altuve.   

The next time players positions going to be third base and player is going to be Bragman and all the way down the list and we can test this out so I can say here print position and here I'm just giving a string and now I'm using actual block variable and 
let's just copy this and now I'll say Player Name and this will now say player.   

And now let's run this and see if this is working and it is.   

You can see the first iteration has the position of second base and the player name of Altuve so this is working perfectly.

![large](03-081_IMG5.png)

Now, one little thing I want to point out before we finish this guide is, **the importance of indentation**.   

Right here imagine that I wrote this for loop but I didn't have print indented just like this.

```python
for player in players:
 print(player)
```

You are going to have an error if you try to run this and repl will give you a little syntax error X right here

![large](03-081_IMG6.png)

But, if you're using some other type of local development environment that doesn't have these kinds of Checker's then you are going to run into an odd error called an indentation error I'm gonna run it right now and you'll see it and you can see it as indentation error expected an indented block.

![large](03-081_IMG6.png)



So, whenever you see this colon in Python you will most likely need to have the next set of code so anything inside of this is called a code block.

And so, you will have to have all of the rest of the code indented with either two spaces or 4 spaces.   

Most text editors will do this automatically so you don't really have to worry about it much.   

But we haven't talked about indentation when it comes to python and so I wanted
 to make sure that you are aware of that.

****

## Code

```python
players = ['Altuve', 'Bregman', 'Correa', 'Gattis']
players = ('Altuve', 'Bregman', 'Correa', 'Gattis')

for player in players:
 print(player)
players = {
 '2b': 'Altuve',
 '3b': 'Bregman',
 'ss': 'Correa',
 'dh': 'Gattis'
}

for position, player in players.items():
 print('Position', position)
 print('Player', player)
```
