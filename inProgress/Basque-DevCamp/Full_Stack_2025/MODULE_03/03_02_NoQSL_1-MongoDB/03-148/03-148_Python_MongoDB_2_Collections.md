## Module 03-148: MongoDB - Collections

---

## **Index**

1. Understanding Collections
2. Creating a Collection
3. Listing Collections
4. Understanding System Indexes
5. 

---

## **Understanding Collections**

In MongoDB, collections are the equivalent of tables in relational databases. Collections store multiple documents, which are JSON-like objects containing data. Unlike tables, collections do not enforce a rigid schema, allowing flexibility in storing various data structures.

### **Key Differences Between Collections and SQL Tables:**

| Feature     | SQL Table        | MongoDB Collection |
| ----------- | ---------------- | ------------------ |
| Structure   | Fixed schema     | Schema-less        |
| Rows        | Records          | Documents          |
| Columns     | Fields           | Fields (flexible)  |
| Data Format | Structured (SQL) | JSON-like (BSON)   |

---

## **Creating a Collection**

To create a new collection in MongoDB, use the `createCollection` method:

```js
 db.createCollection("books")
```

### **Expected Output:**

```json
{ "ok" : 1 }
```

This response confirms that the collection was successfully created.

> **Note:** Unlike relational databases, MongoDB automatically creates a collection when the first document is inserted. Explicitly using `createCollection` is only necessary for advanced configurations.

---

## **Listing Collections**

To view all collections within the current database, run:

```js
show collections
```

### **Example Output:**

```
books
system.indexes
```

This output shows that the database contains a `books` collection, along with `system.indexes` (used for indexing documents).

---

## **Understanding System Indexes**

MongoDB automatically maintains a `system.indexes` collection, which stores index metadata. Indexes improve query performance by enabling efficient lookups.

> **Tip:** While you don't need to manage `system.indexes` directly, understanding how indexes work can help optimize performance. Learn more in the [MongoDB Indexing Guide](https://www.mongodb.com/docs/manual/indexes/).

---

## **Best Practices**

- **Let MongoDB create collections automatically** when inserting documents unless specific configurations are required.
- **Use meaningful collection names** (e.g., `users`, `orders`, `logs`).
- **Avoid excessively large collections** without indexing, as performance may degrade.
- **Leverage indexing strategies** to speed up queries and enhance efficiency.

---

## References

[MongoDB Docs:  Indexes](https://www.mongodb.com/docs/manual/indexes/)
