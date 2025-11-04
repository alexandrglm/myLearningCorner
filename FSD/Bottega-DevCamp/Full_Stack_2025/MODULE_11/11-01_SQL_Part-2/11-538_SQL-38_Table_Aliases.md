# 11-538 SQL 38 - Table Aliases

## What are Table Aliases?

**Table aliases** are short names assigned to tables to simplify queries, especially when working with multiple tables.

## Details


- **Table aliases**: Short names for tables
- **Syntax**: `FROM table t` or `FROM table AS t`
- **Use**: `t.column` in SELECT, WHERE, ORDER BY
- **One table**: Optional, more verbose
- **Multiple tables**: **Essential** for clarity
- **Convention**: 1-2 logical letters
- **Doesn't affect**: Column names in result
- **Preparation**: Fundamental for JOINs (next section)

## Syntax

```sql
SELECT t.column
FROM table AS t;

-- Or without AS (more common)
SELECT t.column
FROM table t;
```

## Comparison Operators

Before the example, note that you can use:
- `=` - Equals
- `>` - Greater than
- `<` - Less than
- `>=` - Greater than or equal
- `<=` - Less than or equal
- `<>` or `!=` - Not equal

## Query Without Alias

```sql
SELECT guides_title, guides_revenue
FROM guides
WHERE guides_revenue > 600;
```

Works perfectly, but not scalable.

## Query With Table Alias

```sql
SELECT g.guides_title, g.guides_revenue
FROM guides g
WHERE g.guides_revenue > 600;
```

Same result, but with table prefix.

## How It Works

1. **Define alias**: `FROM guides g`
2. **Use alias**: `g.guides_title`, `g.guides_revenue`
3. **The alias represents the table** throughout the query

## Why Doesn't It Seem Useful Now?

With **a single table**, table aliases seem unnecessary:
- More code to write
- Same result
- No apparent benefit

## When DOES IT BECOME USEFUL?

### With Multiple Tables (JOINs)

```sql
SELECT 
    u.users_name,
    u.users_email,
    a.addresses_city,
    a.addresses_state
FROM users u
JOIN addresses a ON u.users_id = a.addresses_users_id;
```

**Benefits**:
- **Clarity**: You immediately know which column comes from which table
- **Brevity**: `u.users_name` instead of `users.users_name`
- **Necessary**: Some columns may exist in both tables

## Example with Name Conflict

Imagine both tables have an `id` column:

```sql
-- ❌ Ambiguous - which id?
SELECT id, name
FROM users
JOIN orders ON users.id = orders.user_id;

-- ✅ Clear with aliases
SELECT u.id, o.id, u.name
FROM users u
JOIN orders o ON u.id = o.user_id;
```

## Naming Convention

### Common Aliases

- First letter: `users → u`, `orders → o`, `products → p`
- Initials: `user_profiles → up`, `order_items → oi`
- Logical abbreviations: `customers → cust`, `invoices → inv`

### Example

```sql
SELECT 
    u.name,
    o.order_date,
    p.product_name,
    oi.quantity
FROM users u
JOIN orders o ON u.id = o.user_id
JOIN order_items oi ON o.id = oi.order_id
JOIN products p ON oi.product_id = p.id;
```

Each table has a **one or two-letter** alias.

## With vs Without AS

Both syntaxes are valid:

```sql
-- With AS (more explicit)
FROM guides AS g

-- Without AS (more common)
FROM guides g
```

**Recommendation**: Without `AS` is more common and concise.

## Doesn't Affect Column Names

Table aliases **DO NOT rename columns** in the result:

```sql
SELECT g.guides_title
FROM guides g;
```

The column is still called `guides_title`, not `g.guides_title`.

## Aliases in WHERE and ORDER BY

You can use the alias throughout the query:

```sql
SELECT g.guides_title, g.guides_revenue
FROM guides g
WHERE g.guides_revenue > 600
ORDER BY g.guides_title;
```

## Anticipated Example: Multiple Tables

This will be very useful when you learn JOINs:

```sql
SELECT 
    g.guides_title,
    g.guides_revenue,
    u.users_name,
    u.users_email
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id
WHERE g.guides_revenue > 1000;
```

**Without aliases it would be**:
```sql
SELECT 
    guides.guides_title,
    guides.guides_revenue,
    users.users_name,
    users.users_email
FROM guides
JOIN users ON guides.guides_users_id = users.users_id
WHERE guides.guides_revenue > 1000;
```

Longer and less readable.

## Self-Joins (Advanced)

Aliases are **mandatory** for self-joins:

```sql
-- Employees and their managers (same table)
SELECT 
    e.name AS 'Employee',
    m.name AS 'Manager'
FROM employees e
JOIN employees m ON e.manager_id = m.id;
```

Without aliases, it would be impossible to distinguish the two references to `employees`.

## Visual Comparison

### One Table (Not Critical)
```sql
-- Without alias (ok)
SELECT guides_title FROM guides;

-- With alias (verbose)
SELECT g.guides_title FROM guides g;
```

### Multiple Tables (Critical)
```sql
-- Without alias (confusing)
SELECT guides.title, users.name
FROM guides
JOIN users ON guides.user_id = users.id;

-- With alias (clear)
SELECT g.title, u.name
FROM guides g
JOIN users u ON g.user_id = u.id;
```

## When to Use Table Aliases

### ✅ Always Use With:
- JOINs (multiple tables)
- Self-joins
- Complex queries
- Subqueries

### ❌ Optional With:
- Single-table queries
- Very simple queries

### 🤷 Personal Preference
For consistency, some developers **always** use aliases.

## Progressive Example

### Simple (One Table)
```sql
SELECT * FROM users;
```

### With Alias (Preparing for Joins)
```sql
SELECT u.* FROM users u;
```

### With Join (Alias Necessary)
```sql
SELECT u.*, a.*
FROM users u
JOIN addresses a ON u.id = a.user_id;
```

## Best Practices

1. **Aliases of 1-2 letters** for tables
2. **Consistent** throughout the query
3. **Logical**: `u` for users, `p` for products
4. **Always in JOINs** for clarity
5. **Optional but useful** in simple queries

## Full Name vs Alias

```sql
-- Full name (verbose)
SELECT guides.guides_title
FROM guides
WHERE guides.guides_revenue > 600;

-- Alias (concise)
SELECT g.guides_title
FROM guides g
WHERE g.guides_revenue > 600;
```
