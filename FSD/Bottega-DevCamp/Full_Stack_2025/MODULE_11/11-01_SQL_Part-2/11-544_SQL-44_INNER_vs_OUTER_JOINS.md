# 11-544 SQL 44 - INNER vs OUTER JOINS

- **INNER JOIN**: Only matches, no NULL
- **RIGHT JOIN**: All from right table + matches
- **LEFT JOIN**: All from left table + matches
- **Order matters**: In OUTER JOINs, not in INNER
- **OUTER optional**: RIGHT JOIN = RIGHT OUTER JOIN
- **Focal table**: Which one you want ALL records from

## Base Query: INNER JOIN

```sql
SELECT * 
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id;
```

Returns 8 guides with their associated users.

## Key Difference

**INNER JOIN**: Does not show users without guides (ignores NULL values)
**OUTER JOIN**: Shows all records from one table, even if they don't have matches

## RIGHT JOIN (RIGHT OUTER JOIN)

```sql
SELECT * 
FROM guides g
RIGHT JOIN users u ON g.guides_users_id = u.users_id;
```

### What It Does

- Shows **all users** (right table)
- Even if they haven't written guides (NULL values in guides columns)
- Guides appear when they exist

### Focal Point: Right Table (users)

"Show all users, with guides if they have them"

## LEFT JOIN (LEFT OUTER JOIN)

```sql
SELECT * 
FROM guides g
LEFT JOIN users u ON g.guides_users_id = u.users_id;
```

### What It Does

- Shows **all guides** (left table)
- With their associated user
- Since there's a foreign key, there are no NULLs here (every guide has a user)

### Focal Point: Left Table (guides)

"Show all guides, with users if they exist"

## Order Matters in OUTER JOINS

### LEFT JOIN
```sql
FROM guides g
LEFT JOIN users u
-- Focal: guides (left)
```

### Changing Order
```sql
FROM users u
LEFT JOIN guides g
-- Focal: users (now left)
-- Result: thousands of records, all users
```

Order does NOT matter in INNER JOIN, but **it is critical in OUTER JOINS**.

## Comparison of Results

### INNER JOIN
```
guides_id | guides_title | users_id | users_name
1         | My Blog      | 1        | Kristine
2         | Tutorial     | 2        | Tiffany
```
Only users with guides (8 results)

### RIGHT JOIN (users as focal)
```
guides_id | guides_title | users_id | users_name
1         | My Blog      | 1        | Kristine
2         | Tutorial     | 2        | Tiffany
NULL      | NULL         | 3        | Jordan
NULL      | NULL         | 4        | Alex
...
```
All users, even without guides (thousands of results)

### LEFT JOIN (guides as focal)
```
guides_id | guides_title | users_id | users_name
1         | My Blog      | 1        | Kristine
2         | Tutorial     | 2        | Tiffany
```
All guides with users (8 results, same as INNER here)

## Syntax: OUTER is Optional

```sql
RIGHT JOIN        = RIGHT OUTER JOIN
LEFT JOIN         = LEFT OUTER JOIN
```

They are equivalent. "OUTER" is optional.

## Common Interview Question

**"What is the difference between INNER and OUTER JOIN?"**

**Answer**: 
- INNER: Only matches in both tables
- OUTER: All records from one table + matches from the other

## When to Use Each

### INNER JOIN
- You only want records with matches
- "Users who have written guides"

### RIGHT/LEFT JOIN
- You want all records from one table
- "All users, whether they have written guides or not"

## Focal Table

**Focal table** = The table you want ALL records from

- **RIGHT JOIN**: Right table is focal
- **LEFT JOIN**: Left table is focal


