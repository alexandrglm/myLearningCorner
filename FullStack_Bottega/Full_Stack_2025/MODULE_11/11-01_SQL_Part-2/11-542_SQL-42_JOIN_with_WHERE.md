# 11-542 SQL 42 - JOIN with WHERE (Multiple Conditions)

## WHERE in JOINs

You can use WHERE with JOINs the same as in normal queries.

- WHERE works the same in JOINs
- AND/OR for multiple conditions
- You can filter by columns from any joined table
- JOINs only expand your filtering options

## Filter by Joined Table

```sql
SELECT * 
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id
WHERE u.users_name = 'Tiffany';
```

Returns only guides written by Tiffany.

## Filter by Main Table

```sql
SELECT * 
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id
WHERE g.guides_revenue > 700;
```

Returns guides with revenue greater than 700 and their users.

## Multiple Conditions with AND

```sql
SELECT * 
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id
WHERE g.guides_revenue > 700
AND u.users_name = 'Tiffany';
```

Returns guides with revenue > 700 **and** written by Tiffany.

## Multiple Conditions with OR

```sql
SELECT * 
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id
WHERE g.guides_revenue > 700
AND u.users_name = 'Tiffany'
OR u.users_name = 'Kristine';
```

Returns guides with revenue > 700 written by Tiffany **or** Kristine.

## Key Concept

**JOINs are normal queries** - they just give you access to more columns.

With JOIN you can:
- Filter by columns from any joined table
- Use AND, OR as always
- Combine conditions from multiple tables

## JOINs Give Access to More Data

Without JOIN:
```sql
WHERE guides_revenue > 700  -- Only columns from guides
```

With JOIN:
```sql
WHERE g.guides_revenue > 700    -- Columns from guides
AND u.users_name = 'Tiffany'    -- And columns from users
```
