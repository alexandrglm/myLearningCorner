# MODULE 03-152: MongoDB (7) - Querying an specific Document in Collections

****

## Video lesson Speech

As helpful as it is to be able to perform a find query on an entire 
collection more often than not you're going to be performing some type 
of query based off of a value in that collection.

****

So here we're going to look for the work of art book so I'm going to say `db.books. find()`,  even though in the last guide you saw where we could pass in the parens by themselves. We can also pass in an object so I can say find `name` and then say `The War of Art` and then that object right there, and then I can also call `pretty` on this. Now if I run this you can see that it returns `The War of Art` book.

![large](https://s3-us-west-2.amazonaws.com/devcamp-images-mongo/Screen+Shot+2017-10-26+at+9.43.16+AM.png)

Now there is a very important item to keep in mind here and that is if I go and I call `OOP Programming` here which is something that has multiple books with that name then it's going to return all of those. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-images-mongo/Screen+Shot+2017-10-26+at+9.43.16+AM.png)

So the reason why that's important to keep in mind is, imagine in an application if you run just a regular find and you think and even if you know that you only have one item with that name it's still going to return a collection back to you which means you're going to have to iterate through it or else you're going to run into an error.  Later on, we will get into another method called **find one** where you can be assured that you're only going to get a single object back even if there are multiple items.  So in review, the command is 

```
db.books.find( {name: "OOP Programming"} ).pretty()
```

Now this is in comparison to a SQL query such as 

```
SELECT * from books WHERE name = "OOP Programming"
```

So what we just ran with our **find** method and passing it the name of **OPP Programming** if you are doing this and sequel This is what the statement would look like. So that's a way where you can just put a constraint and you can say I only want you to return back the documents that have this name. 

****

## Code

```js
db.books.find( {name: "OOP Programming"} ).pretty()
```

### SQL Equivalent

```sql
SELECT * from books WHERE name = "OOP Programming"
```
