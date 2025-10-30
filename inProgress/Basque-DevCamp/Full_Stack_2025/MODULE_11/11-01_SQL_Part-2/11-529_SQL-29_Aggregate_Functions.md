# 11-529 SQL 29 - Aggregate Functions (MIN, MAX, AVG, SUM, COUNT)

## What is an Aggregate Function?

An **aggregate function** takes a collection of data and returns **a single value** after applying a mathematical operation.

## The 5 Main Aggregate Functions

### 1. MIN() - Minimum Value

Returns the **smallest value** in a column.

```sql
SELECT MIN(guides_revenue) FROM guides;
-- Returns: 500
```

### 2. MAX() - Maximum Value

Returns the **largest value** in a column.

```sql
SELECT MAX(guides_revenue) FROM guides;
-- Returns: 5000
```

### 3. AVG() - Average

Returns the **average** of all values.

```sql
SELECT AVG(guides_revenue) FROM guides;
-- Returns: 1583.3333 (example)
```

**Note**: AVG with DECIMAL shows more precision (up to 4 decimals).

### 4. SUM() - Total Sum

Returns the **sum** of all values.

```sql
SELECT SUM(guides_revenue) FROM guides;
-- Returns: 9500 (sum of all revenues)
```

### 5. COUNT() - Count Records

Returns the **number of records**.

```sql
SELECT COUNT(*) FROM users;
-- Returns: 2003 (total users)
```

## General Syntax

```sql
SELECT FUNCTION(column) FROM table;
```

## COUNT(*) vs COUNT(column)

### COUNT(*)

Counts **all records**, including NULL:

```sql
SELECT COUNT(*) FROM users;
-- Counts all rows
```

### COUNT(column)

Counts only records where the column **is NOT NULL**:

```sql
SELECT COUNT(users_email) FROM users;
-- Counts only rows with email (excludes NULL)
```

## Functions with WHERE

Aggregate functions are **most useful with filters**:

```sql
-- Count only users in NY
SELECT COUNT(*) FROM addresses
WHERE addresses_state = 'NY';
-- Returns: 3

-- Average revenue of successful posts
SELECT AVG(guides_revenue) FROM guides
WHERE guides_revenue > 1000;

-- Sum of sales from last month
SELECT SUM(amount) FROM sales
WHERE sale_date >= '2025-01-01';
```

## Practical Examples

### Financial Data

```sql
-- Total income
SELECT SUM(guides_revenue) FROM guides;

-- Average revenue per guide
SELECT AVG(guides_revenue) FROM guides;

-- Most expensive guide
SELECT MAX(guides_revenue) FROM guides;

-- Cheapest guide
SELECT MIN(guides_revenue) FROM guides;
```

### User Analysis

```sql
-- Total users
SELECT COUNT(*) FROM users;

-- Users in a specific state
SELECT COUNT(*) FROM addresses
WHERE addresses_state = 'CA';

-- Users with verified email
SELECT COUNT(verified_email) FROM users
WHERE verified_email IS NOT NULL;
```

### Reports

```sql
-- Total orders this month
SELECT COUNT(*) FROM orders
WHERE order_date >= '2025-01-01';

-- Total sales for the year
SELECT SUM(total) FROM orders
WHERE YEAR(order_date) = 2025;

-- Average product price
SELECT AVG(price) FROM products
WHERE category = 'Electronics';
```

## Daily Use

These functions are used **constantly** in development:
- MIN/MAX: Find extremes
- AVG: Calculate averages
- SUM: Total values
- COUNT: Count records

## Advantages of DECIMAL for AVG

```sql
-- With DECIMAL: higher precision
AVG(guides_revenue)  -- 1583.3333

-- With INT: less precision
AVG(guides_revenue)  -- 1583
```

For financial data, DECIMAL is better because it maintains precision.

## Combining with Subqueries

```sql
-- Guides with revenue greater than average
SELECT * FROM guides
WHERE guides_revenue > (
    SELECT AVG(guides_revenue) FROM guides
);
```

## Summary Table

| Function | Purpose | Example of Use |
|----------|---------|----------------|
| MIN() | Minimum value | Lowest price |
| MAX() | Maximum value | Highest sale |
| AVG() | Average | Average revenue |
| SUM() | Total sum | Total income |
| COUNT() | Count records | Total users |

## Real-World Use Cases

### Metrics Dashboard

```sql
-- Monthly KPIs
SELECT 
    COUNT(*) as total_orders,
    SUM(total) as revenue,
    AVG(total) as avg_order_value,
    MAX(total) as largest_order,
    MIN(total) as smallest_order
FROM orders
WHERE order_date >= '2025-01-01';
```

### Product Report

```sql
-- Inventory statistics
SELECT
    COUNT(*) as total_products,
    AVG(price) as avg_price,
    SUM(stock) as total_inventory
FROM products
WHERE active = true;
```

### User Analysis

```sql
-- Users by state
SELECT COUNT(*) FROM users
WHERE created_at >= '2025-01-01'
AND created_at < '2025-02-01';
```

## Specificity with WHERE

Aggregate functions are **more useful** when combined with WHERE:

```sql
-- ❌ Less useful: everything without filter
SELECT COUNT(*) FROM orders;

-- ✅ More useful: with specific criteria
SELECT COUNT(*) FROM orders
WHERE status = 'completed'
AND order_date = CURDATE();
```

## Combine with Other Clauses

```sql
-- With subqueries
SELECT * FROM products
WHERE price < (SELECT AVG(price) FROM products);

-- With IN
SELECT COUNT(*) FROM orders
WHERE user_id IN (SELECT user_id FROM premium_users);

-- With BETWEEN
SELECT SUM(amount) FROM sales
WHERE sale_date BETWEEN '2025-01-01' AND '2025-01-31';
```

## Performance

Aggregate functions are very efficient because:
- SQL executes them directly on the server
- They are optimised for large volumes
- You don't need to bring all data to your application

## Best Practices

1. **Use WHERE** to make calculations more specific
2. **COUNT(*)** to count all records
3. **COUNT(column)** to count only non-NULL values
4. **DECIMAL** for financial data (better precision in AVG)
5. **Name the columns** when using in reports (we'll see AS later)
