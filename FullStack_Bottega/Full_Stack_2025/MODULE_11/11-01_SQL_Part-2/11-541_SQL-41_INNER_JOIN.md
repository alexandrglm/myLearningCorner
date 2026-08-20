# 11-541 SQL 41 - INNER JOIN

- **INNER JOIN**: Joins related tables
- **ON**: Defines the connection (FK = PK)
- **JOIN = INNER JOIN**: Same result
- **Aliases**: Simplify queries (g, u)
- **Specific SELECT**: Better than *
- **ORDER BY**: Works with JOINs
- **Duplicates**: Normal with 1-to-many relationships

## The Problem Without JOIN

```sql
SELECT * FROM guides;
```

Returns: `guides_id`, `guides_revenue`, `guides_users_id`, `guides_title`, `guides_qty`

We see `guides_users_id` but we don't know **who** that user is.

## What is INNER JOIN?

**INNER JOIN** allows you to map tables together to combine related data.

## Basic Syntax

```sql
SELECT * 
FROM guides
INNER JOIN users ON guides.guides_users_id = users.users_id;
```

### Components

1. **INNER JOIN table**: Which table to join
2. **ON condition**: How they connect (foreign key = primary key)

## Result

Now returns:
- All columns from `guides`
- **And** all columns from `users`

We can see who wrote each guide (name, email, etc.).

## JOIN = INNER JOIN

They are equivalent:

```sql
-- Explicit
SELECT * FROM guides
INNER JOIN users ON guides.guides_users_id = users.users_id;

-- Abbreviated (more common)
SELECT * FROM guides
JOIN users ON guides.guides_users_id = users.users_id;
```

`JOIN` is an alias for `INNER JOIN`.

## Select Specific Columns

Instead of fetching everything (`*`), specify which columns:

```sql
SELECT 
    g.guides_title,
    g.guides_revenue,
    u.users_name,
    u.users_email
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id;
```

### Advantages

- Cleaner result
- No duplicate IDs
- Only necessary data

## Use Aliases in JOINs

```sql
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id
```

- `g` = alias for `guides`
- `u` = alias for `users`

Then use: `g.column`, `u.column`

## Best Practice: One Column Per Line

```sql
SELECT 
    g.guides_title,
    g.guides_revenue,
    u.users_name,
    u.users_email
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id;
```

More readable when there are many columns.

## ORDER BY with JOINs

```sql
SELECT 
    g.guides_title,
    g.guides_revenue,
    u.users_name,
    u.users_email
FROM guides g
JOIN users u ON g.guides_users_id = u.users_id
ORDER BY g.guides_revenue DESC;
```

Orders by revenue from highest to lowest.

## Duplicates in Results

If a user has multiple guides, they will appear repeated:

```
guides_title | users_name
My Blog      | Kristine
Another Post | Kristine
Great Guide  | Tiffany
```

Kristine appears 2 times because she has 2 guides. **This is expected behaviour**.

## Order of Tables Matters

```sql
FROM guides
JOIN users
```

Start with `guides` and add info from `users`. Guides are the main focus of the result.
