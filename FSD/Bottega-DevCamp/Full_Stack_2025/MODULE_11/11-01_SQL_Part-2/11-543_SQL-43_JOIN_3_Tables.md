# 11-543 SQL 43 - JOIN 3 Tables

- You can join 3+ tables with multiple JOINs
- Syntax: Chain `JOIN ... ON`
- Each table needs a relationship with another
- INNER JOIN creates many duplicates
- Only returns records with matches in ALL tables
- Next joins offer more control

## Syntax for 3 Tables

```sql
SELECT * 
FROM users u
JOIN guides g ON g.guides_users_id = u.users_id
JOIN addresses a ON a.addresses_users_id = u.users_id
ORDER BY g.guides_revenue DESC;
```

## How It Works

1. Start with `users`
2. **JOIN guides**: Connect via `guides_users_id`
3. **JOIN addresses**: Connect via `addresses_users_id`
4. Order by revenue

## Requirement

Each table must have a **relationship (foreign key)** with at least one of the other tables.

## Unlimited Number of JOINs

You can join as many tables as you need:

```sql
JOIN table1
JOIN table2
JOIN table3
JOIN table4
...
```

## Result

Returns:
- All columns from `users`
- All columns from `guides`
- All columns from `addresses`

## ⚠️ Problem: Duplicates

With INNER JOIN of multiple tables:
- Users appear repeated (they have multiple guides and addresses)
- Guides appear repeated
- Addresses appear repeated

### Example of Duplicates

If a user has:
- 2 guides
- 3 addresses

They will appear **6 times** in the result (2 × 3).

## ⚠️ Problem: Missing Data

INNER JOIN only returns records that have **matches in all tables**.

If you have 2000 users but only some have guides AND addresses, the result will show only those users.

### Comparison

```sql
SELECT * FROM users;
-- 2000+ users

SELECT * FROM users u
JOIN guides g ON ...
JOIN addresses a ON ...;
-- Only users with guides AND addresses
```

## Confusion in Reports

This type of result with duplicates can be confusing for:
- CSV exports
- Executive reports
- Data analysis
