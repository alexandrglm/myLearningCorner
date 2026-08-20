# 11-525 SQL 25 - Subqueries with WHERE IN

## Combining Subqueries with WHERE IN

Subqueries can return **multiple values** and be used with WHERE IN to work with dynamic collections of data.

## The Problem: Hardcoded Values

```sql
SELECT * FROM addresses
WHERE addresses_city IN ('Manhattan', 'Queens');
```

**Limitations:**
- You must know all values in advance
- If there are 500 cities, it is impossible to write them all
- Data may change and the code becomes obsolete

## The Solution: Subquery with WHERE IN

```sql
SELECT * FROM addresses
WHERE addresses_city IN (
    SELECT addresses_city
    FROM addresses
    WHERE addresses_state = 'NY'
);
```

## How It Works

1. **Subquery executes first**:
   ```sql
   SELECT addresses_city FROM addresses WHERE addresses_state = 'NY'
   ```
   Returns: `['Manhattan', 'Queens', 'Brooklyn']`

2. **Main query uses those values**:
   ```sql
   SELECT * FROM addresses WHERE addresses_city IN ('Manhattan', 'Queens', 'Brooklyn')
   ```

3. **Result**: All addresses from those cities

## Advantages

### 1. Dynamic Data
You don't need to know the values:
```sql
-- The subquery finds the values automatically
WHERE city IN (SELECT city FROM table WHERE state = 'CA')
```

### 2. Scalability
Works with 3 cities or 500 cities without changing the code.

### 3. Flexibility
The subquery can have its own complex logic:
```sql
WHERE addresses_city IN (
    SELECT addresses_city
    FROM addresses
    WHERE addresses_state = 'NY'
    AND addresses_users_id > 10
)
```

## Comparison

### Hardcoded (Limited)
```sql
-- ❌ You must know all values
WHERE city IN ('Manhattan', 'Queens')
```

### With Subquery (Dynamic)
```sql
-- ✅ Finds values automatically
WHERE city IN (
    SELECT city FROM addresses WHERE state = 'NY'
)
```

## Complex Nested Subqueries

You can add more conditions to the subquery:

```sql
SELECT * FROM addresses
WHERE addresses_city IN (
    SELECT addresses_city
    FROM addresses
    WHERE addresses_state = 'NY'
    AND addresses_users_id IN (
        SELECT users_id
        FROM users
        WHERE users_email LIKE '%@gmail.com'
    )
);
```

## Why Not Use Just WHERE?

You might think:
```sql
-- Why not just this?
SELECT * FROM addresses
WHERE addresses_state = 'NY';
```

**Reasons to use subquery:**

1. **More complex logic**: The subquery can have additional filters
2. **Table combination**: You need data from multiple tables
3. **Reusability**: The subquery can be used in multiple contexts
4. **Expressiveness**: More flexible and powerful queries

## Real-World Use Cases

### Yellow Pages Application

```sql
-- Find businesses in cities of a specific state
SELECT * FROM businesses
WHERE city IN (
    SELECT DISTINCT city
    FROM locations
    WHERE state = 'CA'
    AND population > 100000
);
```

### E-commerce System

```sql
-- Products sold in cities where shipping is free
SELECT * FROM products
WHERE product_id IN (
    SELECT product_id
    FROM orders
    WHERE city IN (
        SELECT city FROM free_shipping_zones
    )
);
```

### User Management

```sql
-- Users in cities with offices
SELECT * FROM users
WHERE city IN (
    SELECT city FROM offices WHERE active = true
);
```

## Subquery Returns Collection

Unlike the previous subquery that returned **a single value** (MAX, MIN), this one returns **multiple values**:

```sql
-- Returns ONE value
WHERE column = (SELECT MAX(column) FROM table)

-- Returns MULTIPLE values
WHERE column IN (SELECT column FROM table WHERE condition)
```

## Expressiveness and Flexibility

Subqueries with WHERE IN enable:
- More expressive queries
- Greater flexibility in filters
- Working with data that changes dynamically
- Solving complex problems in a single query

## Important

- The subquery must return **values from a single column**
- All values returned by the subquery are used in the IN
- The subquery executes **only once** before the main query

## Best Practice

Use subqueries with WHERE IN when:
- You don't know the values you need to search for
- Values may change frequently
- You need to apply complex logic to obtain the values
- You work with dynamic collections of data
