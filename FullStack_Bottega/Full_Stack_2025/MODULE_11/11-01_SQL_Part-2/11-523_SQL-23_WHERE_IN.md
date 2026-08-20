# 11-523 SQL 23 - WHERE IN (Cleaner Code)

## The Problem

To search for multiple values in the same column, you could use multiple OR statements:

```sql
SELECT * FROM addresses
WHERE addresses_city = 'Queens'
OR addresses_city = 'Manhattan'
OR addresses_city = 'Phoenix'
OR addresses_city = 'Brooklyn';
```

**Problems:**
- Verbose and repetitive code
- Difficult to read with many values
- Not scalable (imagine 100 cities)
- Not professional

## The Solution: WHERE IN

```sql
SELECT * FROM addresses
WHERE addresses_city IN ('Queens', 'Manhattan', 'Phoenix', 'Brooklyn');
```

## WHERE IN Syntax

```sql
SELECT * FROM table
WHERE column IN (value1, value2, value3, ...);
```

## Equivalence

These two queries are **exactly the same**:

```sql
-- Using OR (verbose)
WHERE city = 'Queens' OR city = 'Manhattan'

-- Using IN (clean)
WHERE city IN ('Queens', 'Manhattan')
```

## Advantages of WHERE IN

1. **Cleaner code**: Easy to read and maintain
2. **Scalable**: Adding more values is simple
3. **Professional**: More elegant coding style
4. **Same result**: Performance equivalent to multiple OR statements
5. **Less repetition**: Column name appears only once

## NOT IN

You can also exclude multiple values:

```sql
SELECT * FROM addresses
WHERE addresses_city NOT IN ('Queens', 'Manhattan');
```

Returns all records **except** Queens and Manhattan.

## Data Types in IN

### Strings

```sql
WHERE city IN ('New York', 'Los Angeles', 'Chicago')
```

### Numbers

```sql
WHERE users_id IN (1, 5, 10, 15, 20)
```

### Dates

```sql
WHERE order_date IN ('2025-01-01', '2025-02-01', '2025-03-01')
```

## Practical Use Cases

### Filter Specific Users

```sql
SELECT * FROM users
WHERE users_id IN (1, 5, 10, 23, 45);
```

### Multiple States

```sql
SELECT * FROM addresses
WHERE addresses_state IN ('NY', 'CA', 'TX', 'FL');
```

### Exclude Categories

```sql
SELECT * FROM products
WHERE category NOT IN ('discontinued', 'out-of-stock');
```

### IDs from a List

```sql
-- IDs of inactive users
SELECT * FROM orders
WHERE user_id IN (SELECT user_id FROM inactive_users);
```

## Visual Comparison

```sql
-- ❌ Difficult to read with many values
WHERE city = 'A' OR city = 'B' OR city = 'C' OR city = 'D' OR city = 'E'

-- ✅ Clean and clear
WHERE city IN ('A', 'B', 'C', 'D', 'E')
```

## MySQL Workbench Tip

Instead of clicking the "lightning bolt" button, use:
- **Command + Return** (Mac)
- **Ctrl + Enter** (Windows/Linux)

To execute the selected code more quickly.

## When to Use WHERE IN

Use WHERE IN when:
- You are searching for multiple values in the same column
- You have a list of specific IDs
- You want more professional and clean code
- The number of values makes OR unmanageable

## Best Practice

Always prefer `WHERE IN` over multiple `OR` statements when you are comparing the same column with multiple values.
