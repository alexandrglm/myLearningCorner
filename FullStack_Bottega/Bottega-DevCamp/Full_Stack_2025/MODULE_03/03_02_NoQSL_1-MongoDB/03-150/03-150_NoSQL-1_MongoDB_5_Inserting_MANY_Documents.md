# MODULE 03-150: MongoDB (5)

## Inserting Multiple Documents

***

## **Index**

1. Understanding Document Insertion (2)
2. The `insertMany()` Method

***

## **Understanding Document Insertion (2)**

In MongoDB, documents are stored in collections, and each document follows a flexible schema.

Inserting data into a collection is one of the most common operations. MongoDB provides different methods to insert documents, including:

* **`insertOne()`**: Used for inserting a single document.
* **`insertMany()`**: Used for inserting multiple documents at once. **This method expects ARRAYS, not set's/objects.**

In the previous guide, we covered `insertOne()`.

Now, we'll focus on `insertMany()`, which allows for batch insertion of documents in an efficient manner.

***

## **The `insertMany()` Method**

The `insertMany()` method enables bulk insertion of documents into a MongoDB collection.

Unlike `insertOne()`, which only takes a single document, `insertMany()` accepts an **array** of documents.

```mongodb
# Basic Sintax

  db.<collection>.insertMany([
    { document1 },
    { document2 },
    { document3 }
 ])
```

## **Inserting Multiple Documents - `db.<collection>.insertMany( {...} )`**

To insert multiple records at once, use `insertMany()` with an **array** of JSON objects.

```mongodb
// Insert multiple book documents - .insertMany())

MongoCourse> db.Books.insertMany([
  {
    "name": "Tecnofeudalismo",
    "publishedDate": new Date("2024-01-01"),
    "authors": [
      { "name": "Yanis Varoufakis" }
    ]
  },
  {
    "name": "Pyongyang: A Journey In North Korea",
    "publishedDate": new Date("2003-01-01"),
    "authors": [
      { "name": "Guy Delisle" }
    ]
  }
])
```

### **Expected Output:**

![MongoDB, .insertMany( {array} )](../../../../../../.gitbook/assets/03-150_IMG01.png)

### **Key Points:**

* Each document inside the array must follow valid **BSON** format.
* The method returns metadata, including the `acknowledged` status and a list of inserted **ObjectId** values.
* MongoDB automatically assigns a unique **\_id** field to each document if not explicitly provided.

For official documentation, refer to [MongoDB `insertMany()` documentation](https://www.mongodb.com/docs/manual/reference/method/db.collection.insertMany/).

***

## **Best Practices**

### ✅ **Use `insertMany()` for Bulk Insertions**

Instead of inserting documents one at a time, use `insertMany()` to improve efficiency and reduce database load.

### ✅ **Ensure Consistency in Document Structure**

Although MongoDB is schema-less, maintaining a consistent structure across documents simplifies queries and indexing.

### ✅ **Monitor Performance for Large Bulk Inserts**

For **very large** insertions, consider breaking them into smaller batches to avoid excessive memory usage.

### ✅ **Avoid Duplicate Entries passing Documents, not arrays**

MongoDB does not enforce uniqueness unless explicitly defined using **unique indexes**.

```mongodb
db.books.createIndex({ name: 1 }, { unique: true })


# Expected Output: name_1
```

This ensures that no two books share the same name.

***

## References

[MongoDB `**insertMany()**` Documentation](https://www.mongodb.com/docs/manual/reference/method/db.collection.insertMany/)

[MongoDB Data Modeling Best Practices:](https://www.mongodb.com/docs/manual/data-modeling/)

[MongoDB Indexes and Performance Optimization](https://www.mongodb.com/docs/manual/indexes/)

***

## Video Lesson Speech

In the last guide, we walked through how you can insert documents into a Mongo collection and that's great but that only allowed us to insert one at a time.

***

If you're building out a large application there's probably going to be a time where you're going to need to insert multiple documents at the same time and that's where the insert `many function` comes into play.

I'm going to switch to Sublime Text and create that function. We're going to start off with `db.books`. So we're going to start off with the name of our database object which represents whatever database we're using then books, the name, and the collection, and then the function is `insertMany`.

![large](../../../../../../.gitbook/assets/03-150_IMG1.png)

Now `insertMany` is a little bit different, remember that with insert it took a Javascript object, `insertMany` takes an _array_. So you're going to go with the brackets just like this.

![large](../../../../../../.gitbook/assets/03-150_IMG2.png)

Then inside of this is where we're going to place our objects. So I'm going to write the first one then I'll just paste a few more in so you don't have to watch me type all of this but it is good to practice this just so you can become familiar.

So I'm going to say _name_ _Confident Ruby_, and we're going to stick with our _publishDate_ as our second attribute there and we'll just start off with _new Date()_, obviously you could pass in a custom one and that should be a comma there.

![large](../../../../../../.gitbook/assets/03-150_IMG3.png)

Now let's pass in authors now authors can have one author or it can have multiple for this one it's just going to be a single author.

Now here we're going to pass in an object for the authors, we are going to pass in a `"name": "Avdi Grimm"`.

![large](../../../../../../.gitbook/assets/03-150_IMG4.png)

Now I'm going to go and grab some other ones that I wrote out previously and now I'll paste those in. If you notice they have the exact same structure so we have a _name_ a _publishedDate_, _authors_ and then the authors _name_.

![large](../../../../../../.gitbook/assets/03-150_IMG5.png)

So each one of these matches they're going to have the same structure, and now if I copy this come into the terminal and hit save then it's going to save those.

![large](../../../../../../.gitbook/assets/03-150_IMG6.png)

Now this gives us a different return value.

So that's very important to know if you're building out some kind of script if you're inserting a single one.

Remember that we just got that one object back. If I scroll up here we should still have it. Yes, so we have the right result of an inserted one.

Now if you are doing insert many it changes and so it gives you an acknowledged true and then inserted ID. So each one of these is the ID that the system generated.

So we'll get into how we can retrieve that ID and what it represents. But essentially what Mongo does is creates this hash value and it gives some type of unique structure to that document so that it can be retrieved and so that every document in your database is guaranteed to be unique.

You need to be able to have some level of confidence in knowing that you can retrieve that if you have nothing besides the ID. And if you're working with very large applications you will start to see IDs that look something like this just because you need the ability to make sure that no matter how many items you get if you have millions or billions of records then you have a way of keeping track of them and making sure that you still can get unique values there.

So now you should have a pretty good idea of how to insert one or insert many documents into a Mongo database.

***

## Code

```js
db.books.insertMany([
  {
    "name": "Confident Ruby",
    "publishedDate": new Date(),
    "authors": [
      { "name": "Avdi Grimm" }
    ]
  },
  {
    "name": "The War of Art",
    "publishedDate": new Date(),
    "authors": [
      {"name": "Steven Pressfield"}
    ]
  },
  {
    "name": "Blink",
    "publishedDate": new Date(),
    "authors": [
      {"name": "Malcolm Gladwell"}
    ]
  }
])
```

***

## Video Lesson Speech

In the last guide, we walked through how you can insert documents into a Mongo collection and that's great but that only allowed us to insert one at a time.

***

If you're building out a large application there's probably going to be a time where you're going to need to insert multiple documents at the same time and that's where the insert `many function` comes into play.

I'm going to switch to Sublime Text and create that function. We're going to start off with `db.books`. So we're going to start off with the name of our database object which represents whatever database we're using then books, the name, and the collection, and then the function is `insertMany`.

![large](../../../../../../.gitbook/assets/03-150_IMG1.png)

Now `insertMany` is a little bit different, remember that with insert it took a Javascript object, `insertMany` takes an _array_. So you're going to go with the brackets just like this.

![large](../../../../../../.gitbook/assets/03-150_IMG2.png)

Then inside of this is where we're going to place our objects. So I'm going to write the first one then I'll just paste a few more in so you don't have to watch me type all of this but it is good to practice this just so you can become familiar.

So I'm going to say _name_ _Confident Ruby_, and we're going to stick with our _publishDate_ as our second attribute there and we'll just start off with _new Date()_, obviously you could pass in a custom one and that should be a comma there.

![large](../../../../../../.gitbook/assets/03-150_IMG3.png)

Now let's pass in authors now authors can have one author or it can have multiple for this one it's just going to be a single author.

Now here we're going to pass in an object for the authors, we are going to pass in a `"name": "Avdi Grimm"`.

![large](../../../../../../.gitbook/assets/03-150_IMG4.png)

Now I'm going to go and grab some other ones that I wrote out previously and now I'll paste those in. If you notice they have the exact same structure so we have a _name_ a _publishedDate_, _authors_ and then the authors _name_.

![large](../../../../../../.gitbook/assets/03-150_IMG5.png)

So each one of these matches they're going to have the same structure, and now if I copy this come into the terminal and hit save then it's going to save those.

![large](../../../../../../.gitbook/assets/03-150_IMG6.png)

Now this gives us a different return value.

So that's very important to know if you're building out some kind of script if you're inserting a single one.

Remember that we just got that one object back. If I scroll up here we should still have it. Yes, so we have the right result of an inserted one.

Now if you are doing insert many it changes and so it gives you an acknowledged true and then inserted ID. So each one of these is the ID that the system generated.

So we'll get into how we can retrieve that ID and what it represents. But essentially what Mongo does is creates this hash value and it gives some type of unique structure to that document so that it can be retrieved and so that every document in your database is guaranteed to be unique.

You need to be able to have some level of confidence in knowing that you can retrieve that if you have nothing besides the ID. And if you're working with very large applications you will start to see IDs that look something like this just because you need the ability to make sure that no matter how many items you get if you have millions or billions of records then you have a way of keeping track of them and making sure that you still can get unique values there.

So now you should have a pretty good idea of how to insert one or insert many documents into a Mongo database.

***

## Code

```js
db.books.insertMany([
  {
    "name": "Confident Ruby",
    "publishedDate": new Date(),
    "authors": [
      { "name": "Avdi Grimm" }
    ]
  },
  {
    "name": "The War of Art",
    "publishedDate": new Date(),
    "authors": [
      {"name": "Steven Pressfield"}
    ]
  },
  {
    "name": "Blink",
    "publishedDate": new Date(),
    "authors": [
      {"name": "Malcolm Gladwell"}
    ]
  }
])
```
