# Module 03-148: MongoDB (3)

## Collections

***

## **Index**

1. Understanding Collections
2. Creating a Collection
3. Listing Collections
4. Understanding System Indexes

***

## **Understanding Collections**

In MongoDB, collections are the equivalent of tables in relational databases. Collections store multiple documents, which are JSON-like objects containing data. Unlike tables, collections do not enforce a rigid schema, allowing flexibility in storing various data structures.

### **Key Differences Between Collections and SQL Tables:**

| Feature     | SQL Table        | MongoDB Collection |
| ----------- | ---------------- | ------------------ |
| Structure   | Fixed schema     | Schema-less        |
| Rows        | Records          | Documents          |
| Columns     | Fields           | Fields (flexible)  |
| Data Format | Structured (SQL) | JSON-like (BSON)   |

***

## **Creating a Collection - `.createCollection()`**

To create a new collection in MongoDB, use the `createCollection` method:

```mongodb
 db.createCollection("books")    # Output { ok: 1 }
```

This response confirms that the collection was successfully created.

> **Note:** Unlike relational databases, MongoDB automatically creates a collection when the first document is inserted. **Explicitly using `createCollection` is only necessary for advanced configurations**.

***

## **Listing Collections**

To view all collections within the current database, run:

```mongodb
MongoCourse> show collections

Books

```

This output shows that the database contains a `books` collection.

***

## **Understanding oldie System Indexes**

It's possible that, if you are using an Old MongoDB version (< 3.x) you'll see another file along with your collection, called `system.indexes`.

It was used for indexing documents in older versions.

Since 3.x version, the `system.indexes`collections are no longer exist.

MongoDB automatically maintained a system.indexes collection, which had stored index metadata.

***

## **Understanding how MongoDB v3.x work along with Indexes - `db.<collection>.getIndexes()`**

Indexes, in general terms, improve query performance by enabling efficient lookups.

> While you don't need to manage `system.indexes` directly, **understanding how indexes work can help optimize performance**. Learn more in the nowday's [MongoDB Indexing Guide](https://www.mongodb.com/docs/manual/indexes/).

```mongodb
MongoCourse> db.Books.getIndexes()


# Output
[ { v: 2, key: { _id: 1 }, name: '_id_' } ]


```

***

![MongoShell, creating db, and getting indexes](../../../../../../.gitbook/assets/03-148_IMG01.png)

***

## **Best Practices**

* **Let MongoDB create collections automatically** when inserting documents unless specific configurations are required.
* **Use meaningful collection names** (e.g., `users`, `orders`, `logs`).
* **Avoid excessively large collections** without indexing, as performance may degrade.
* **Leverage indexing strategies** to speed up queries and enhance efficiency.

***

## References

[# Databases and Collections in PyMongo](https://www.mongodb.com/docs/languages/python/pymongo-driver/current/databases-collections/)

***

## Video lesson Speech

Now that we have our database created and we have a user now we can start creating collections.

***

Now if you are familiar with the SQL kind of syntax then you're probably used to hearing terms such as **databases** like we have in Mongo and so then you have the idea of **tables** and that tables have columns. We don't have that same exact kind of naming inside of Mongo, we do have databases but then inside of databases we have what is called **collections**, collections are the closest kind of analogy to a table. Collections can store many documents and those documents are the actual items that you're going to be putting into the database. Before we can start saving the documents we need to create collections to store them in. So we're going to throughout this entire course be building out a database to manage books. With that in mind, we're going to once again reference our database object and then we're going to create a collection called books. Now the command for this is

```
db.createCollection('books')
```

and then put in the name of the collection itself. Now if I run this it's going to return `"ok" : 1`. This syntax that gets returned is very important in understanding how Mongo works.

![large](../../../../../../.gitbook/assets/03-148_IMG1.png)

It's also very helpful for understanding why the Javascript community and the Front End community as a whole have absolutely fallen in love with Mongo and it's because the Mongo syntax whether it's how you write it or the values that get returned is very familiar, it's very much like you are going to get in any kind of Javascript development environment. Like you see right here if you are returning this you're not getting just like an HTML or HTTP and you're working with APIs, you'd get a status code of 200. If you're working with the Redis database you would be getting the words `ok` or you might get an integer `1`. Here in Mongo, you're actually getting an object and a key-value Json type object back where the key is `ok` and then the value is `1`. If you were doing this say in an API kind of environment and you just created a collection then you would be able to get this object back and you'd be able to treat it just like pure JSON. So it's a pretty cool thing that Mongo gives us and so we're going to be able to have that kind of Javascript mindset this entire time. So now that we have that I can type `show collections` and now you can see that we have our books there where before we didn't have anything. What this means is we've added a collection and we also have this `system.indexes`. Now we don't have to worry about that. That's simply a collection that's going to store any indexes that we're using inside of the database and indexes are ways of being able to speed up queries. But we're not going to have to work with them directly.

![large](../../../../../../.gitbook/assets/03-148_IMG2.png)

For right now just know that is a way that you can create a collection and then how you can see all of the collections inside of a Mongo database.

***

## Code

```js
db.createCollection('books')
// { "ok" : 1 }

show collections
```
