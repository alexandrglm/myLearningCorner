# MODULE 03-151: MongoDB (6)

## Querying Documents with `find()` Method & Advanced Querying with Filters and Projections

---

## **Index**

1. Understanding the `find()` Method

2. Using `find().pretty()` for Better Readability

3. MongoDB vs SQL: Querying All Documents

4. Automatic Object IDs in MongoDB

5. Advanced Querying with Filters and Projections

6. Querying Nested Documents and Arrays

7. Sorting and Limiting Results

8. Counting Documents

9. Debugging and Best Practices

---

So far, we have focused primarily on inserting documents into MongoDB collections.   

However, retrieving and querying data is just as important.   

MongoDB provides various methods to retrieve data efficiently, with the `find()` method being the most fundamental.

In this guide, we will explore how to use `find()` to query documents and compare its functionality to SQL-based queries.   

We will also discuss MongoDB's automatic Object ID generation, advanced querying techniques, and best practices for working with MongoDB queries.  

---

## **Understanding the** `.find()` **Method**

The `find()` method in MongoDB is used to retrieve documents from a collection.  

 It works similarly to the `SELECT` statement in SQL, allowing users to fetch data that matches specific criteria.   

By default, calling `find()` without any parameters returns all documents in the collection.

### **Syntax:**

```mongodb
// Retrieve all documents in a collection 

db.Books.find()
```

### **Example Output:**

```mongodb
[
  {
    _id: ObjectId('67d9c1555c76fae2cc6b140b'),
    name: 'El Cerebro Musical',
    publishedDate: ISODate('2025-03-18T18:54:13.978Z'),
    authors: [ { name: 'Daniel J. Levitin' } ]
  },
  {
    _id: ObjectId('67d9cb025c76fae2cc6b140c'),
    name: 'Tecnofeudalismo',
    publishedDate: ISODate('2024-01-01T00:00:00.000Z'),
    authors: [ { name: 'Yanis Varoufakis' } ]
  },
  {
    _id: ObjectId('67d9cb025c76fae2cc6b140d'),
    name: 'Pyongyang: A Journey In North Korea',
    publishedDate: ISODate('2003-01-01T00:00:00.000Z'),
    authors: [ { name: 'Guy Delisle' } ]
  }
]
```

---

## Why older MongoDB versions **USED** `**find().pretty()**` **for Better Readability**

MongoDB older versions than 5.x returned data like this:

```mongodb
> db.Books.find()
{ "_id" : ObjectId("67d9c1555c76fae2cc6b140b"), "name" : "El Cerebro Musical", "publishedDate" : ISODate("2025-03-18T18:54:13.978Z"), "authors" : [ { "name" : "Daniel J. Levitin" } ] }
{ "_id" : ObjectId("67d9cb025c76fae2cc6b140c"), "name" : "Tecnofeudalismo", "publishedDate" : ISODate("2024-01-01T00:00:00.000Z"), "authors" : [ { "name" : "Yanis Varoufakis" } ] }
```

So that there were available some extending methods, like `.pretty()` or `.toArray()` allowing to  get the query return in a more "human readable" format. This method formats the output in an easily readable JSON structure:

```mongodb
# In older versions, .pretty() pretifies an JSON output ad by-default in newer versions

> db.Books.find().pretty()

{
  "_id" : ObjectId("67d9c1555c76fae2cc6b140b"),
  "name" : "El Cerebro Musical",
  "publishedDate" : ISODate("2025-03-18T18:54:13.978Z"),
  "authors" : [
    { "name" : "Daniel J. Levitin" }
  ]
}
{
  "_id" : ObjectId("67d9cb025c76fae2cc6b140c"),
  "name" : "Tecnofeudalismo",
  "publishedDate" : ISODate("2024-01-01T00:00:00.000Z"),
  "authors" : [
    { "name" : "Yanis Varoufakis" }
  ]
}
```

**It's important to understand that newest MondoDB versions includes by default this helpful output schema when a simple `db.<collection>.find()` query is performed, as long as is also important to be aware of this situation if you have to work with an older Mongo version.**

****

---

## **MongoDB vs SQL: Querying All Documents**

For users coming from a relational database background, it is useful to compare MongoDB’s `find()` method with SQL queries.

| Operation              | MongoDB Query     | SQL Equivalent         |
| ---------------------- | ----------------- | ---------------------- |
| Retrieve all documents | `db.books.find()` | `SELECT * FROM books;` |

This comparison helps in understanding MongoDB’s document-oriented approach in contrast to SQL’s table-based structure.

---

## **Automatic Object IDs in MongoDB**

MongoDB automatically generates a unique identifier (`_id`) for each document.   

This field acts similarly to a **primary key** in SQL databases and is crucial for uniquely identifying each document.

### **Example Document with Object ID:**

```mongodb
{
  "_id": ObjectId("507f191e810c19729de860ea"),
  "name": "Confident Ruby",
  "publishedDate": ISODate("2023-01-01T00:00:00Z")
}
```

* The `_id` field is automatically added if not specified.
- It ensures each document is uniquely identifiable.

- Object IDs contain encoded timestamp information, making them useful for tracking document creation times.

****

## **Advanced Querying with Filters and Projections**

### **Filtering Documents**

You can filter documents by passing a query object to the `find()` method.   

For example, to find books published after a specific date:

```mongodb
MongoCourse> db.Books.find({ publishedDate: { $gt: ISODate("2023-01-01") } })


[
  {
    _id: ObjectId('67d9c1555c76fae2cc6b140b'),
    name: 'El Cerebro Musical',
    publishedDate: ISODate('2025-03-18T18:54:13.978Z'),
    authors: [ { name: 'Daniel J. Levitin' } ]
  },
  {
    _id: ObjectId('67d9cb025c76fae2cc6b140c'),
    name: 'Tecnofeudalismo',
    publishedDate: ISODate('2024-01-01T00:00:00.000Z'),
    authors: [ { name: 'Yanis Varoufakis' } ]
  }
]
```

****

### **Projections**

Projections allow you to specify which fields to include or exclude in the results. For example, to retrieve only the `name` field:

```mongodb
db.Books.find({}, { name: 1, _id: 0 })


[
  { name: 'El Cerebro Musical' },
  { name: 'Tecnofeudalismo' },
  { name: 'Pyongyang: A Journey In North Korea' }
]
```

This query returns only the `name` field and excludes the `_id` field.

****

## **Querying Nested Documents and Arrays**

MongoDB supports querying nested documents and arrays. For example, to find books written by a specific author:

```mongodb
MongoCourse> db.Books.find({ "authors.name": "Yanis Varoufakis" })
[
  {
    _id: ObjectId('67d9cb025c76fae2cc6b140c'),
    name: 'Tecnofeudalismo',
    publishedDate: ISODate('2024-01-01T00:00:00.000Z'),
    authors: [ { name: 'Yanis Varoufakis' } ]
  }
]
```

This query searches for documents where the `authors` array contains an object with the `name` field equal to `"Yanis Varoufakis"`.

****

## **Sorting and Limiting Results**

### **Sorting** - `.sort()`

You can sort the results using the `sort()` method. For example, to sort books by `publishedDate` in descending order:

```mongodb
MongoCourse> db.Books.find().sort({ publishedDate: -1 })
[
  {
    _id: ObjectId('67d9c1555c76fae2cc6b140b'),
    name: 'El Cerebro Musical',
    publishedDate: ISODate('2025-03-18T18:54:13.978Z'),
    authors: [ { name: 'Daniel J. Levitin' } ]
  },
  {
    _id: ObjectId('67d9cb025c76fae2cc6b140c'),
    name: 'Tecnofeudalismo',
    publishedDate: ISODate('2024-01-01T00:00:00.000Z'),
    authors: [ { name: 'Yanis Varoufakis' } ]
  },
  {
    _id: ObjectId('67d9cb025c76fae2cc6b140d'),
    name: 'Pyongyang: A Journey In North Korea',
    publishedDate: ISODate('2003-01-01T00:00:00.000Z'),
    authors: [ { name: 'Guy Delisle' } ]
  }
]
```

### **Limiting** - `.limit()`

To limit the number of results, use the `limit()` method. For example, to retrieve only the first 2 books:

```mongodb
MongoCourse> db.Books.find().limit(2)



[
  {
    _id: ObjectId('67d9c1555c76fae2cc6b140b'),
    name: 'El Cerebro Musical',
    publishedDate: ISODate('2025-03-18T18:54:13.978Z'),
    authors: [ { name: 'Daniel J. Levitin' } ]
  },
  {
    _id: ObjectId('67d9cb025c76fae2cc6b140c'),
    name: 'Tecnofeudalismo',
    publishedDate: ISODate('2024-01-01T00:00:00.000Z'),
    authors: [ { name: 'Yanis Varoufakis' } ]
  }
]
```

****

## **Counting Documents** - `.countDocuments()`

To count the number of documents that match a query, use the `count()` method.   

For example, to count all books:

```mongodb
MongoCourse> db.Books.countDocuments()


3
```

To count books, for example, from published after a specific date:

```mongodb
MongoCourse> db.Books.countDocuments({ 
    publishedDate: { $gt: ISODate("2023-01-01") } 
})


2
```

![img](./03-151_IMG02.png)

****

## **Debugging and Best Practices**

### **Debugging Queries**

- Use `.explain()` to analyze the performance of a query:

```mongodb
  MongoCourse> db.Books.find().explain("executionStats")
  {
    explainVersion: '1',
    queryPlanner: {


      namespace: 'MongoCourse.Books',
      parsedQuery: {},
      indexFilterSet: false,
      queryHash: '8F2383EE',
      planCacheShapeHash: '8F2383EE',
      planCacheKey: '7DF350EE',
      optimizationTimeMillis: 0,
      maxIndexedOrSolutionsReached: false,
      maxIndexedAndSolutionsReached: false,
      maxScansToExplodeReached: false,
      prunedSimilarIndexes: false,
      winningPlan: { isCached: false, stage: 'COLLSCAN', direction: 'forward' },
      rejectedPlans: []

    },
    executionStats: {

      executionSuccess: true,
      nReturned: 3,
      executionTimeMillis: 0,
      totalKeysExamined: 0,
      totalDocsExamined: 3,
      executionStages: {
        isCached: false,
        stage: 'COLLSCAN',
        nReturned: 3,
        executionTimeMillisEstimate: 0,
        works: 4,
        advanced: 3,
        needTime: 0,
        needYield: 0,
        saveState: 0,
        restoreState: 0,
        isEOF: 1,
        direction: 'forward',
        docsExamined: 3
      }

    },
    queryShapeHash: 'CC342773C26E7E652D64DECED760BE5F66658046AC863313B9690E40EA7A4BF9',
    command: { find: 'Books', filter: {}, '$db': 'MongoCourse' },
    serverInfo: {

      host: '***',
      port: *****,
      version: '8.0.5',
      gitVersion: '***'

    },
    serverParameters: {

      internalQueryFacetBufferSizeBytes: 104857600,
      internalQueryFacetMaxOutputDocSizeBytes: 104857600,
      internalLookupStageIntermediateDocumentMaxSizeBytes: 104857600,
      internalDocumentSourceGroupMaxMemoryBytes: 104857600,
      internalQueryMaxBlockingSortMemoryUsageBytes: 104857600,
      internalQueryProhibitBlockingMergeOnMongoS: 0,
      internalQueryMaxAddToSetBytes: 104857600,
      internalDocumentSourceSetWindowFieldsMaxMemoryBytes: 104857600,
      internalQueryFrameworkControl: 'trySbeRestricted',
      internalQueryPlannerIgnoreIndexWithCollationForRegex: 1

    },
    ok: 1
  }
```

- Check for typos in field names or query operators.

- Use `printjson()` to print documents in a readable format during debugging.

****

### **Best Practices**

- Use indexes to improve query performance.

- Avoid querying large datasets without filters.

- Use projections to retrieve only the necessary fields.

- Regularly monitor and optimize your queries using `.explain()`.

****

## References

[MongoDB Querying Guide:](https://www.mongodb.com/docs/manual/tutorial/query-documents/)

[MongoDB **`find()`** Method Documentation](https://www.mongodb.com/docs/manual/reference/method/db.collection.find/)

---

## Video Lesson Speech

So far in this course, we have focused primarily on just adding 
documents but that's only one part of how Mongo is used.   

We also need to  be able to retrieve those.   

What we can do is we have a number of different find methods in Mongo that make it very straightforward to query documents.

****

What I'm going to do is I'm going to show you some of the common **find functions** but then I'm also going to give you their SQL equivalent because if you're coming from SQL than some of the various tasks we're going to be performing may seem a little bit alien. I know when I was first learning Mongo a number of these types of behaviors on the querying side especially felt kind of odd, so what really helped was having what the SQL equivalent to that code would be, and then it started to make more sense. So the first thing I'm going to do is I'm going to say `db.book.find()`, then with the parens because this is a function and if I return that you can see only the books we have created are right here. 

![large](./03-151_IMG1.png)

Now, this is the same as if I did something like saying `SELECT * from books` in SQL where I'm just saying bring everything back. Now there is a very helpful little function inside of Mongo that you can add to any of these **find functions** and it's called **pretty**, if I say `find().pretty()` this is going to return all of the records back, but it's going to return in a much nicer formatted kind of setup. 

![large](./03-151_IMG2.png)

So right here you can see that each one of the records that we created is now in the database and it also added this `_id`. Now, this happens automatically, if you remember when we did that batch create process and I showed you the object IDs. This is where it's stored so that you do not have to put this in the create statement. Mongo handles this for you and so this is very similar to a primary key in SQL. So this is the one element that you do not have to really worry about in regards to creating them because Mongo has a pretty complex algorithm in the back end that will go and it checks to make sure that no id like this is already taken. It creates this large unique cache and randomizes and then adds it right into that document. That way you always have something that you can reference so you can see you have our **id** the **name** and the **publish date**. If you scroll up you can see that not all of them are the same if you remember when we created the books that have a title instead of a name that is in there as well. 

![medium](./03-151_IMG3.png)
That's a pretty nice way of being able to see how you can query these because 

****

## Code

```js
db.books.find().pretty()
```

### SQL Equivalent

```sql
SELECT * from books
```
