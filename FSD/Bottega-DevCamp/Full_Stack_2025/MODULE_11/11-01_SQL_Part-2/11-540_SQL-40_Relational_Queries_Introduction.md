# 11-540 SQL 40 - Relational Queries Introduction

## Why Does SQL Exist?

SQL was created primarily to handle **relational data** - data where tables are connected to each other.

- **SQL = Relational DBMS**: Designed for relational data
- **Relationships**: Tables connected via foreign keys
- **Advantages**: No duplication, integrity, efficiency
- **JOINs**: Tools for relational queries
- **Types**: INNER, LEFT OUTER, RIGHT OUTER
- **This section**: Master queries that combine multiple tables

## What is a Relational Database?

**SQL is a Relational Database Management System (RDBMS)**

This means:
- Each table can **reference** another table
- Tables are **connected** through relationships
- Data is not isolated, it is **linked**

## Concept of Relationships

### Example: Social Network

**Tables**:
- `users` (users)
- `posts` (posts)

**Relationship**:
- Each post is **connected** to a user
- We know which user created each post
- One user can have multiple posts

```
User 1 ──┬── Post A
         ├── Post B
         └── Post C

User 2 ──┬── Post D
         └── Post E
```

## References Between Tables

Tables are connected through **foreign keys**:

```sql
-- Table users
users_id | users_name
1        | John
2        | Jane

-- Table posts
post_id | post_content    | user_id (FK)
101     | "Hello World"   | 1
102     | "My thoughts"   | 1
103     | "Amazing day"   | 2
```

The `user_id` column in `posts` **references** `users_id` in `users`.

## Types of Joins in This Section

We will learn how to **join tables** for complex queries:

### 1. INNER JOIN

Returns records that have matches in **both** tables.

```
Table A      Table B
   ○──────────○     ↑ Only the intersection
```

### 2. LEFT OUTER JOIN

Returns **all** records from the left table, and matches from the right.

```
Table A      Table B
   ●──────────○     ↑ All of A, matches of B
```

### 3. RIGHT OUTER JOIN

Returns **all** records from the right table, and matches from the left.

```
Table A      Table B
   ○──────────●     ↑ All of B, matches of A
```

## Why Relationships?

### Without Relationships (Duplication)

```sql
-- EVERYTHING in one table
post_id | content        | author_name | author_email
1       | "Hello"        | John        | john@test.com
2       | "World"        | John        | john@test.com
3       | "SQL is great" | Jane        | jane@test.com
```

**Problems**:
- Massive data duplication
- If John changes his email, update N places
- Waste of space
- Inconsistent data

### With Relationships (Normalised)

```sql
-- Table users
user_id | name | email
1       | John | john@test.com
2       | Jane | jane@test.com

-- Table posts
post_id | content        | user_id
1       | "Hello"        | 1
2       | "World"        | 1
3       | "SQL is great" | 2
```

**Advantages**:
- No duplication
- Change John's email: one place only
- Space efficient
- Consistent data

## Relationships in Our Current Schema

We already have relationships configured:

### users ↔ addresses
```
users.users_id ↔ addresses.addresses_users_id
```

### users ↔ guides
```
users.users_id ↔ guides.guides_users_id
```

One user can have:
- Multiple addresses
- Multiple guides

## Basic Query vs Relational Query

### Without Join (Limited)

```sql
-- Only see user_id, not the name
SELECT * FROM guides;

-- Result
guides_id | guides_title | guides_users_id
1         | "My Blog"    | 1
2         | "Tutorial"   | 2
```

We don't know who user 1 or 2 is.

### With Join (Complete)

```sql
-- See all information
SELECT g.guides_title, u.users_name
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id;

-- Result
guides_title | users_name
"My Blog"    | John
"Tutorial"   | Jane
```

Now we know who created each guide.

## Types of Relationships

### One-to-Many (One to Many)

One user can have many guides:
```
User ──┬── Guide 1
       ├── Guide 2
       └── Guide 3
```

### Many-to-Many (Many to Many)

One student can take many courses, and one course can have many students:
```
Student A ──┬── Course 1 ──┬── Student A
            │              └── Student B
Student B ──┼── Course 2 ──┬── Student B
            │              └── Student C
            └── Course 3
```

Requires intermediate table (junction table).

### One-to-One (One to One)

One user has one profile:
```
User ── Profile
```

## Importance of Foreign Keys

**Foreign keys** maintain integrity:

```sql
-- Cannot create a guide with non-existent user_id
INSERT INTO guides (guides_title, guides_users_id)
VALUES ('New Guide', 999);  -- ERROR if user 999 doesn't exist
```

## Advantages of Relational Data

1. **No redundancy**: Data stored only once
2. **Integrity**: Foreign keys prevent inconsistencies
3. **Flexibility**: Easy to add new relationships
4. **Efficiency**: Less space, faster
5. **Maintainability**: Changes in one place affect everything

## Complex Relational Queries

With joins you can:

### Combine Data from Multiple Tables

```sql
-- User, their guides, and their addresses
SELECT u.name, g.title, a.city
FROM users u
JOIN guides g ON u.id = g.user_id
JOIN addresses a ON u.id = a.user_id;
```

### Filter by Relationships

```sql
-- Guides from users in NY
SELECT g.title
FROM guides g
JOIN users u ON g.user_id = u.id
JOIN addresses a ON u.id = a.user_id
WHERE a.state = 'NY';
```

### Aggregate with Relationships

```sql
-- How many guides does each user have
SELECT u.name, COUNT(g.id) as guide_count
FROM users u
LEFT JOIN guides g ON u.id = g.user_id
GROUP BY u.name;
```

## What We Will Learn

In this section we will cover:

### INNER JOIN
- Syntax and use
- When to use
- Practical examples

### LEFT OUTER JOIN
- Difference from INNER
- Use cases
- Return all from left

### RIGHT OUTER JOIN
- Difference from INNER and LEFT
- Use cases
- Return all from right

### Complex Queries
- Multiple joins
- Filters in joins
- Aggregations with joins

## Prerequisites

We already configured relationships when we created the tables:
- ✅ Foreign keys defined
- ✅ Example data with relationships
- ✅ Understanding of aliases (useful for joins)

## Next Steps

We will start with **INNER JOIN**, the most common and fundamental type of join. Once you understand INNER JOIN, the others will be variations of the same concept.

## Key Concept

**Relationships are the heart of SQL.**

Without relationships, SQL would be just a glorified spreadsheet. With relationships, SQL becomes a powerful tool for modelling the real world where everything is connected.
