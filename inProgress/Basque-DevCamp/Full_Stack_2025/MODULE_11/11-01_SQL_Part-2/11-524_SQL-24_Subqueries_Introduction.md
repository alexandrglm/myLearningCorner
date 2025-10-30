# 11-524 SQL 24 - Subqueries Introduction

## What is a Subquery?

A **subquery** (subquery) is a query nested within another query. It allows you to execute multiple queries simultaneously.

## The Problem Without Subqueries

To find the record with the maximum revenue, you would have to:

1. First find the maximum value manually
2. Then hardcode that value in another query

```sql
-- Step 1: Discover that the max is 5000
-- Step 2: Hardcode the value
SELECT guides_title, guides_revenue
FROM guides
WHERE guides_revenue = 5000;  -- Hardcoded value
```

**Problem:** What if you don't know the maximum value? What if it changes?

## The Solution: Subqueries

```sql
SELECT guides_title, guides_revenue
FROM guides
WHERE guides_revenue = (
    SELECT MAX(CAST(guides_revenue AS UNSIGNED))
    FROM guides
);
```

## Anatomy of a Subquery

```sql
SELECT columns
FROM table
WHERE column = (
    -- SUBQUERY starts here
    SELECT function(column)
    FROM table
    -- SUBQUERY ends here
);
```

## How It Works

1. **The subquery executes first** (inside the parentheses)
2. **It returns a value**
3. **That value is used in the main query**

### Example Step by Step

```sql
WHERE guides_revenue = (SELECT MAX(...))
```

1. Subquery executes: `SELECT MAX(...)` → returns 5000
2. Main query becomes: `WHERE guides_revenue = 5000`
3. Main query is executed

## Common Functions in Subqueries

### MAX - Maximum Value

```sql
SELECT guides_title, guides_revenue
FROM guides
WHERE guides_revenue = (
    SELECT MAX(CAST(guides_revenue AS UNSIGNED))
    FROM guides
);
```

### MIN - Minimum Value

```sql
SELECT guides_title, guides_revenue
FROM guides
WHERE guides_revenue = (
    SELECT MIN(CAST(guides_revenue AS UNSIGNED))
    FROM guides
);
```

## CAST in Subqueries

If the column is VARCHAR but contains numbers:

```sql
CAST(guides_revenue AS UNSIGNED)
```

This ensures that MAX and MIN work numerically, not alphabetically.

## Why Use Subqueries?

### 1. Dynamic Data

You don't always know the values you need to search for:
- The maximum may change
- IDs may vary
- The most recent dates change constantly

### 2. Professional Applications

In real systems:
- Data changes constantly
- You cannot hardcode values
- You need queries that adapt automatically

### 3. Complex Queries

They allow you to solve problems that require multiple steps in a single query.

## Use Cases

### Find Record with Highest Value

```sql
SELECT *
FROM products
WHERE price = (SELECT MAX(price) FROM products);
```

### Find Users with Most Orders

```sql
SELECT *
FROM users
WHERE users_id = (
    SELECT user_id
    FROM orders
    GROUP BY user_id
    ORDER BY COUNT(*) DESC
    LIMIT 1
);
```

### Compare with Average

```sql
SELECT *
FROM sales
WHERE amount > (SELECT AVG(amount) FROM sales);
```

## Types of Subqueries

### Scalar Subquery

Returns a **single value**:
```sql
WHERE column = (SELECT MAX(column) FROM table)
```

### Row Subquery

Returns a **complete row** (we'll see more later).

### Table Subquery

Returns **multiple rows** (we'll see more later).

## Important

- Subqueries **always go in parentheses**
- The subquery executes **before** the main query
- They can be in WHERE, SELECT, FROM, HAVING

## Main Advantage

**Working with dynamic data** - You don't need to know in advance what values you're searching for.
