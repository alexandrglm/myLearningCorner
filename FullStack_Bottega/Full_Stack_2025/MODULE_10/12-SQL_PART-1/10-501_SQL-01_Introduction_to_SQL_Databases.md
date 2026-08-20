# 10-501: SQL_01_Introduction_to_SQL_Databases

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-sql-databases)**
---

## 🎯 What is SQL?

SQL (Structured Query Language) is a **relational** database system that allows you to store and manage data in an organised and efficient manner.

## 🛠️ History and Evolution

### Flat Files
**Old method of storage**:
- Data stored in **simple files**
- Each new record **added to the end**
- **Persistence** - data remained after closing program

### Problems with Flat Files
**Example with Twitter**:
- **Tweet** needs reference to **user**
- **User data** mixed with **tweet data**
- **Likes, retweets, responses** all in same file
- **Relational** data becomes **disorganised**

## 🔧 Advantages of SQL

### Relational Data
**Multiple connected tables**:
- **Tweets table** - stores tweet content
- **Users table** - user information  
- **Likes table** - record of likes
- **Retweets table** - record of retweets

### References Between Tables
**Relationship system**:
- Tweet **belongs to** user
- Tweet **has many** likes
- Tweet **has many** retweets
- User **has many** tweets

## 📋 Relational Model

### Data Organisation
Instead of:
```
GIANT_SINGLE_FILE.txt
User1|Tweet1|5likes|3retweets|User2|Tweet2|...
```

SQL uses:
```
USERS TABLE
id | name | email

TWEETS TABLE  
id | content | user_id | created_at

LIKES TABLE
id | user_id | tweet_id
```

### System Advantages
- **Small, focused** tables
- **Clear references** between data
- **Efficient queries**
- **Simple maintenance**

## 🚀 Modern Applications

### Current Use Cases
**SQL remains popular for**:
- **Banking systems** - account and transaction management
- **Business applications** - ERP, CRM, inventory
- **Login systems** - authentication and users
- **E-commerce** - products, orders, customers

### Why It's Still Relevant
- **Natural logic** for modelling data
- **Mature, stable** technology
- **Proven performance** in production
- **Established standards**

## 📋 Key Concepts

### Relational Database
Database that organises information in **tables related** to each other.

### SQL Database Types
Next guide will explore different types of SQL databases and their specific characteristics.

### Modelling Data
Process of **organising information** into logical structures that reflect real-world relationships.

---
