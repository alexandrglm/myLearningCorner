# MODULE 03-161: MongoDB (0)

* **Part 1: Guide to NoSQL for Developers**

* **Part 2: Complete NoSQL vs SQL guide**

****

## Part 1: Guide to NoSQL for Developers

This guide will walk through a straightforward explanation of how NoSQL databases work and when they should be used in an application.

### What are NoSQL Databases?

So first and foremost: what are NoSQL databases, and why should I care about them? The easiest way to understand the definition is that **NoSQL databases are not SQL databases**.

- **Standard relational SQL databases** such as Oracle’s SQL server or MySQL have a **tabular structure**, similar to what you’d see in an Excel spreadsheet.
- **NoSQL databases**, on the other hand, have **various types of formats** and can, therefore, be more flexible.

---

### When to Use NoSQL?

For example, imagine that you had to build an application where users were able to define their own fields, such as a survey application where one user may create a survey with two fields and another may create a survey with a hundred fields, and they need to have the ability to be named on the fly.

- **Relational databases** could technically implement this, but it would be very clunky.
- **NoSQL databases** could handle this easily by allowing the fields to be created dynamically, and then each record would be stored with its unique characteristics.

---

### Flexibility vs. Challenges

It’s important to note that one of the greatest strengths of NoSQL—its flexibility—also presents its greatest challenge.

Imagine that you are building out an inventory application that has fields that need to connect to other tables, such as a user table for the employee entering the information, a vendor table, and a tax table to calculate depreciation.

- If you were to attempt to implement a **NoSQL database** for this inventory option, you’d end up having to work very hard to map the values between the models, and it would also make for a very difficult application to maintain.
- In this case study, a **relational database (RDBMS)** would work perfectly.

---

### Choosing the Right Database

So when you’re trying to decide on which database to use, it really comes down to what the requirements of the application are.

- If you wanted to chop a tree down, you wouldn’t use a hammer; you’d use an ax because it’s basic common sense to utilize the right tool for the right job.
- It’s the same way with software development. I don’t believe in the SQL vs. NoSQL debate; they are both tools, and they are the most effective when used in an application that works well with their strengths.

---

### Guidelines for Choosing Between SQL and NoSQL

A good rule of thumb is to simply follow the guidelines given by the names themselves:

- **If you have data that relies heavily on relationships**, then it’s probably the best fit to utilize a **relational SQL database**.
- **If you have an unstructured data set that needs flexibility**, then it may be the best option to go with a database that is **Not SQL**, such as a **NoSQL database**.

---

### Example of NoSQL in MongoDB

For an example of how NoSQL looks, here is a snippet from a MongoDB database:

```json
{
 "_id": "507f1f77bcf86cd799439011",
 "name": "John Doe",
 "age": 30,
 "address": {
 "street": "123 Main St",
 "city": "Anytown",
 "state": "CA",
 "zip": "12345"
 },
 "hobbies": ["reading", "hiking", "coding"]
}
```

Notice how it really just looks like JSON code? It actually is using a form of JSON called **BSON**, short for **Binary JSON**, and it really is just a set of key-value pair data stores that can be structured however your application needs.

****

### Comparison with Relational SQL

This is in comparison with a **relational SQL table**.
 Notice how NoSQL databases encapsulate all of the data into a single object, whereas the SQL structure is built around relationships.

```sql
CREATE TABLE users (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    age INT
);

CREATE TABLE addresses (
    id INT PRIMARY KEY,
    user_id INT,
    street VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(2),
    zip VARCHAR(10),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
```

****

### Types of NoSQL Databases

If you’re interested in building 
applications with NoSQL databases, it’s important to understand that 
there is no such thing as a standard NoSQL database; there are many 
different variations.

- **Key/Value pair stores**

- **Wide-column family stores**

- **Document databases**

- **Graph databases**

I’ll place a link in the show notes where you can explore each type and see what will work best for your application.

****

## Resources

- [MongoDB document store database](https://www.mongodb.com/)

- [Redis in-memory data store](http://redis.io/)

- [Google BigTable NoSQL database](https://cloud.google.com/bigtable/

****

## Part 2: Complete NoSQL vs SQL guide

### What is SQL?

SQL, or Structured Query Language, is a programming language used to communicate with and manage relational databases. SQL databases are table-based, meaning they store data in rows and columns.   

Each row represents a unique record, and each column represents a field within that record. SQL databases are known for their ability to handle complex queries and transactions, making them ideal for applications that require strong consistency and integrity, such as financial systems.

### What is NoSQL?

NoSQL, or "Not Only SQL," is a type of database that provides a mechanism for storage and retrieval of data that is modeled in means other than the tabular relations used in 
relational databases.   

NoSQL databases are designed to handle large volumes of unstructured or semi-structured data, making them ideal for big data and real-time web applications.   

They are highly scalable and can handle large amounts of data and traffic with ease.

### Key Differences Between SQL and NoSQL

1. **Data Structure**:
   
   - **SQL**: Table-based, with rows and columns.
   
   - **NoSQL**: Document-based, key-value pairs, wide-column stores, or graph databases.

2. **Scalability**:
   
   - **SQL**: Vertically scalable (adding more power to the server).
   
   - **NoSQL**: Horizontally scalable (adding more servers).

3. **Schema**:
   
   - **SQL**: Fixed schema, meaning the structure of the data must be defined in advance.
   
   - **NoSQL**: Dynamic schema, allowing for more flexibility in data structure.

4. **Transactions**:
   
   - **SQL**: ACID-compliant (Atomicity, Consistency, Isolation, Durability).
   
   - **NoSQL**: Often BASE-compliant (Basically Available, Soft state, Eventual consistency).

5. **Use Cases**:
   
   - **SQL**: Best for complex queries, transactions, and applications requiring strong consistency.
   
   - **NoSQL**: Best for large-scale data, real-time applications, and unstructured data.

### When to Use SQL vs. NoSQL

- **Use SQL** when:
  
  - You need complex transactions and queries.
  
  - Your data is structured and relationships are important.
  
  - You require strong consistency and integrity.

- **Use NoSQL** when:
  
  - You are dealing with large volumes of unstructured or semi-structured data.
  
  - You need high scalability and flexibility.
  
  - Your application requires fast, real-time data processing.

## Reference

https://www.coursera.org/articles/nosql-vs-sql
