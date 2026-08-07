# MODULE 03-152: MongoDB (7)

## Querying a Specific Document in Collections

***

## **Index**

1. Querying a Specific Document
2. Handling Multiple Matches
3. Comparing MongoDB and SQL Queries

***

In many real-world scenarios, retrieving all documents is inefficient. Instead, we often need to query for a specific document based on a field value. MongoDB provides the `find()` method, which allows filtering documents by specific criteria.

In this guide, we will explore how to query a single document in MongoDB using `find()`, handle multiple matches, and compare it with SQL queries.

***

## **Querying a Specific Document**

To retrieve a specific document, we pass a query object to `find()`. This object specifies the condition the document must meet.

```mongodb
// Query a book by name

MongoCourse> db.Books.find({ name: "Tecnofeudalismo" })


[
  {
    _id: ObjectId('67d9cb025c76fae2cc6b140c'),
    name: 'Tecnofeudalismo',
    publishedDate: ISODate('2024-01-01T00:00:00.000Z'),
    authors: [ { name: 'Yanis Varoufakis' } ]
  }
]
```

This query returns only documents where the `name` field matches "Tecnofeudalismo".

***

## **Handling Multiple Matches**

The `find()` method returns **all** matching documents.

If multiple documents have the same `name`, they will all be included in the output.

```mongodb
// Query multiple documents with the same name

MongoCourse> db.Books.find({ "authors.name" : "Guy Delisle"  })
[
  {
    _id: ObjectId('67d9cb025c76fae2cc6b140d'),
    name: 'Pyongyang: A Journey In North Korea',
    publishedDate: ISODate('2003-01-01T00:00:00.000Z'),
    authors: [ { name: 'Guy Delisle' } ]
  },
  {
    _id: ObjectId('67d9da355c76fae2cc6b1410'),
    name: 'Shenzen: A Travelogue from China',
    publishedDate: ISODate('2000-01-01T00:00:00.000Z'),
    authors: [ { name: 'Guy Delisle' } ]
  }
]
```

If multiple books exist with the same key or key.subkey (**use .dotNotation**) the result will contain all of them.

This behavior is different from SQL, where primary keys ensure unique values.

To retrieve only the first matching document, use `findOne()`:

```mongodb
// Retrieve only the first matching document

MongoCourse> db.Books.findOne({ "authors.name" : "Guy Delisle"  })

{
  _id: ObjectId('67d9cb025c76fae2cc6b140d'),
  name: 'Pyongyang: A Journey In North Korea',
  publishedDate: ISODate('2003-01-01T00:00:00.000Z'),
  authors: [ { name: 'Guy Delisle' } ]
}
```

This ensures that only **one** document is returned, even if multiple matches exist.

![img](../../../../../../.gitbook/assets/03-152_IMG02.png)

***

## **Comparing MongoDB and SQL Queries**

For those familiar with SQL, the equivalent of MongoDB’s `find()` method is the `SELECT` statement with a `WHERE` clause.

| Operation                        | MongoDB Query                                   | SQL Equivalent                                                |
| -------------------------------- | ----------------------------------------------- | ------------------------------------------------------------- |
| Find a document by name          | `db.books.find({ name: "OOP Programming" })`    | `SELECT * FROM books WHERE name = 'OOP Programming';`         |
| Find the first matching document | `db.books.findOne({ name: "OOP Programming" })` | `SELECT * FROM books WHERE name = 'OOP Programming' LIMIT 1;` |

***

## References

[MongoDB `**find()**`\*\* Method Documentation:](https://www.mongodb.com/docs/manual/reference/method/db.collection.find/)

[MongoDB `**findOne()**` Method Documentation:](https://www.mongodb.com/docs/manual/reference/method/db.collection.findOne/)

***

## Video lesson Speech

As helpful as it is to be able to perform a find query on an entire\
collection more often than not you're going to be performing some type\
of query based off of a value in that collection.

***

So here we're going to look for the work of art book so I'm going to say `db.books. find()`, even though in the last guide you saw where we could pass in the parens by themselves. We can also pass in an object so I can say find `name` and then say `The War of Art` and then that object right there, and then I can also call `pretty` on this. Now if I run this you can see that it returns `The War of Art` book.

![IMG](../../../../../../.gitbook/assets/03-152_IMG1.png)

Now there is a very important item to keep in mind here and that is if I go and I call `OOP Programming` here which is something that has multiple books with that name then it's going to return all of those.

![IMG](../../../../../../.gitbook/assets/03-152_IMG2.png)

So the reason why that's important to keep in mind is, imagine in an application if you run just a regular find and you think and even if you know that you only have one item with that name it's still going to return a collection back to you which means you're going to have to iterate through it or else you're going to run into an error. Later on, we will get into another method called **find one** where you can be assured that you're only going to get a single object back even if there are multiple items. So in review, the command is

```
db.books.find( {name: "OOP Programming"} ).pretty()
```

Now this is in comparison to a SQL query such as

```
SELECT * from books WHERE name = "OOP Programming"
```

So what we just ran with our **find** method and passing it the name of **OPP Programming** if you are doing this and sequel This is what the statement would look like. So that's a way where you can just put a constraint and you can say I only want you to return back the documents that have this name.

***

## Code

```js
db.books.find( {name: "OOP Programming"} ).pretty()
```

### SQL Equivalent

```sql
SELECT * from books WHERE name = "OOP Programming"
```
