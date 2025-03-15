# MODULE 03-157: MongoDB (12)

## Using the `findOne` Method in MongoDB to Query for a Single Document

---

## Video lesson Speech

This is going to be a quick guide on how to drill down and become more 
specific with our search queries. Specifically, in being more specific 
with how many elements get returned.

****

During the break, I created another book for Blink. If I do 

```js
db.books.find({name: "Blink"})
```

Then right here you'll see that we have two items and one other item I wanted to tell you about was there are many times where you want to be able to see how many elements match a query and you can use the length function for that.  

 And so you can call length with parens and you can see that that returns 2. So it's going to let you know how many documents are inside that query.  

 So you can see that we have two.   

Now let's imagine that you are cognizant that your system has two documents in it that are gonna match equerry but you only want to return one.   

Well in a regular web application or mobile type of application system then you'd have to be able to take care of that on the programming side.   

But if you want to take care of it on the query side you also have the ability to do that here.   

So I'm going to get rid of this link call and instead of saying find I'm going to say findOne. Now if I return this you can see it does a couple of things. 

![large](./03-157_IMG1.png)

It only returns one item.

Also, I didn't have to add the pretty function at the end of it so it just brings that back and it formats it in a very nice and easy to read format.   

And so now what we can do is in our application we can be confident that we're only going to get back one document which means that if you're calling this and you're rendering it say, in a mobile app you don't have to worry about what you need to do if you get one versus two versus 10 documents back.  

 You don't have to worry about iterating through them.   

You know that you're going to get this one object back. You can then call name on it.   

You can check for its published date. You can then iterate through the list of authors all of those kinds of things.   

So this is something that may not seem like a very big deal until you actually get into building applications with Mongo.   

And what this allows you to do is to be explicit with the number of elements that you're going to get back because that is going to change the way they actually write your code.   

And so it's nice to have this flexibility where you can return multiple items or you can be guaranteed to only get one.

****

## Code

```js
db.books.findOne({ name: "OOP Programming" } )
```
