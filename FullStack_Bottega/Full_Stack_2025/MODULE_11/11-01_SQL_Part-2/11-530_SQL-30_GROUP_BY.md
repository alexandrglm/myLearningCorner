# 11-530 SQL 30 - GROUP BY with Aggregate Functions

## What is GROUP BY?

**GROUP BY** groups records that have equal values in specified columns and allows you to apply aggregate functions to each group.

## Syntax

GROUP BY + Aggregate Functions = **Powerful Reports in 3 Lines**:

```sql
SELECT column, AGGREGATE_FUNCTION(column)
FROM table
GROUP BY column;
```

## Basic Example: Count by State

```sql
SELECT addresses_state, COUNT(addresses_state)
FROM addresses
GROUP BY addresses_state;
```

**Result**:
| addresses_state | COUNT |
|----------------|-------|
| AZ | 1 |
| NY | 3 |

## How GROUP BY Works

1. **Groups** records with the same value in the specified column
2. **Applies** the aggregate function to each group
3. **Returns** one result per group

### Visualisation

```
Original data:
user_id | revenue
1       | 500
1       | 750
2       | 1500
2       | 1000

GROUP BY user_id + SUM(revenue):
user_id | SUM(revenue)
1       | 1250
2       | 2500
```

## Example: Count by City

```sql
SELECT addresses_city, COUNT(addresses_city)
FROM addresses
GROUP BY addresses_city;
```

**Result**:
| addresses_city | COUNT |
|---------------|-------|
| Manhattan | 2 |
| Phoenix | 1 |
| Queens | 1 |

## Practical Example: Revenue per User

```sql
SELECT guides_users_id, SUM(guides_revenue)
FROM guides
GROUP BY guides_users_id;
```

**What does it do?**
- Groups all guides by user
- Sums the revenue for each user
- Returns how much each user generated

**Result**:
| guides_users_id | SUM(revenue) |
|----------------|--------------|
| 1 | 1250 |
| 2 | 2500 |

## Advantages of GROUP BY

### 1. Fast Reports

With just 3 lines of code, you can generate complex reports:

```sql
SELECT user_id, SUM(amount)
FROM orders
GROUP BY user_id;
```

### 2. Performance

SQL is **much faster** at doing these operations than your code:
- ❌ Fetch all data and process it in JavaScript/Python
- ✅ Let SQL group and sum on the server

### 3. Simplicity

Without GROUP BY, you would have to:
1. Fetch all records
2. Create a loop
3. Create a dictionary/object
4. Sum manually

With GROUP BY, SQL does it all automatically.

## Aggregate Functions with GROUP BY

### COUNT - Count by Group

```sql
SELECT category, COUNT(*)
FROM products
GROUP BY category;
```

### SUM - Sum by Group

```sql
SELECT user_id, SUM(order_total)
FROM orders
GROUP BY user_id;
```

### AVG - Average by Group

```sql
SELECT department, AVG(salary)
FROM employees
GROUP BY department;
```

### MAX - Maximum by Group

```sql
SELECT category, MAX(price)
FROM products
GROUP BY category;
```

### MIN - Minimum by Group

```sql
SELECT city, MIN(temperature)
FROM weather
GROUP BY city;
```

## Multiple Aggregate Functions

You can use several functions in the same query:

```sql
SELECT 
    guides_users_id,
    COUNT(*) as total_guides,
    SUM(guides_revenue) as total_revenue,
    AVG(guides_revenue) as avg_revenue
FROM guides
GROUP BY guides_users_id;
```

## Real-World Use Cases

### Sales Dashboard

```sql
SELECT 
    sales_person_id,
    COUNT(*) as total_sales,
    SUM(amount) as total_revenue,
    AVG(amount) as avg_sale
FROM sales
WHERE sale_date >= '2025-01-01'
GROUP BY sales_person_id;
```

### Users by Location

```sql
SELECT 
    state,
    COUNT(*) as total_users
FROM users
GROUP BY state
ORDER BY total_users DESC;
```

### Products Sold by Category

```sql
SELECT 
    category,
    COUNT(*) as products_sold,
    SUM(quantity) as total_quantity
FROM order_items
GROUP BY category;
```

### Revenue by Month

```sql
SELECT 
    MONTH(order_date) as month,
    SUM(total) as monthly_revenue
FROM orders
WHERE YEAR(order_date) = 2025
GROUP BY MONTH(order_date);
```

## GROUP BY with WHERE

You can filter BEFORE grouping:

```sql
SELECT guides_users_id, SUM(guides_revenue)
FROM guides
WHERE guides_revenue > 500
GROUP BY guides_users_id;
```

First filter (WHERE), then group (GROUP BY).

## Delegate Computation to SQL

**Important philosophy**: When SQL can do the work, let it do it.

### ❌ Bad (inefficient)

```javascript
// Fetch all data
const guides = await query("SELECT * FROM guides");

// Process it in code
const userRevenue = {};
guides.forEach(guide => {
    if (!userRevenue[guide.user_id]) {
        userRevenue[guide.user_id] = 0;
    }
    userRevenue[guide.user_id] += guide.revenue;
});
```

### ✅ Good (efficient)

```javascript
// SQL does all the work
const userRevenue = await query(`
    SELECT guides_users_id, SUM(guides_revenue)
    FROM guides
    GROUP BY guides_users_id
`);
```

## GROUP BY Rule

**Every column in SELECT that is NOT inside an aggregate function MUST be in GROUP BY**.

```sql
-- ✅ Correct
SELECT user_id, COUNT(*)
FROM orders
GROUP BY user_id;

-- ❌ Error: 'order_date' must be in GROUP BY
SELECT user_id, order_date, COUNT(*)
FROM orders
GROUP BY user_id;

-- ✅ Correct
SELECT user_id, order_date, COUNT(*)
FROM orders
GROUP BY user_id, order_date;
```

## GROUP BY Multiple Columns

You can group by more than one column:

```sql
SELECT state, city, COUNT(*)
FROM addresses
GROUP BY state, city;
```

Groups by the **combination** of state and city.

## Order of Execution

```sql
SELECT user_id, SUM(amount)      -- 3. Selects
FROM orders                       -- 1. From where
WHERE status = 'completed'        -- 2. Filters
GROUP BY user_id                  -- 4. Groups
ORDER BY SUM(amount) DESC;        -- 5. Orders
```

## Alias with AS (Preview)

You can name the calculated columns:

```sql
SELECT 
    guides_users_id,
    SUM(guides_revenue) as total_revenue,
    COUNT(*) as total_guides
FROM guides
GROUP BY guides_users_id;
```

## Recommended Practice

Experiment with different combinations:
- GROUP BY with COUNT
- GROUP BY with SUM
- GROUP BY with AVG, MAX, MIN
- GROUP BY with WHERE
- Multiple columns in GROUP BY

