# 11-545 SQL 45 - Summary Report with 3 Tables

- COUNT with multiple JOINs counts duplicates
- Grouped subqueries: count before JOIN
- COALESCE: converts NULL to 0
- LEFT JOIN: includes all users
- Accurate report with correct counts

## Problem: COUNT with Multiple JOINs

When joining 3 tables with INNER JOIN and using COUNT:
- Massive duplicates appear
- COUNT counts **every occurrence**, not unique values
- Users are missing if they don't have data in all tables

### Example of the Problem

```sql
SELECT 
    u.users_email,
    COUNT(g.guides_id),
    COUNT(a.addresses_id)
FROM users u
LEFT JOIN guides g ON g.guides_users_id = u.users_id
LEFT JOIN addresses a ON a.addresses_users_id = u.users_id
GROUP BY u.users_email;
```

**Problem**: If a user has 3 guides and 2 addresses, COUNT returns 6 for both (3 × 2).

## Solution: COALESCE with Subqueries

```sql
SELECT 
    u.users_email AS 'Email',
    COALESCE(g.guide_count, 0) AS guide_count,
    COALESCE(a.address_count, 0) AS address_count
FROM users u
LEFT JOIN (
    SELECT COUNT(*) AS guide_count, guides_users_id
    FROM guides
    GROUP BY guides_users_id
) AS g ON g.guides_users_id = u.users_id
LEFT JOIN (
    SELECT COUNT(*) AS address_count, addresses_users_id
    FROM addresses
    GROUP BY addresses_users_id
) AS a ON a.addresses_users_id = u.users_id
ORDER BY u.users_email;
```

## How It Works

### 1. Subquery for Guides
```sql
SELECT COUNT(*) AS guide_count, guides_users_id
FROM guides
GROUP BY guides_users_id
```
Counts guides per user **before** the JOIN.

### 2. Subquery for Addresses
```sql
SELECT COUNT(*) AS address_count, addresses_users_id
FROM addresses
GROUP BY addresses_users_id
```
Counts addresses per user **before** the JOIN.

### 3. LEFT JOIN with Subqueries
Joins the already calculated counts - no duplicates.

### 4. COALESCE
```sql
COALESCE(g.guide_count, 0)
```
If the user has no guides (NULL), returns 0.

## Result

```
Email              | guide_count | address_count
dave@test.com      | 1           | 0
john@test.com      | 1           | 0
kristine@test.com  | 3           | 2
```

Accurate counts, all users included.

## Common Errors

### ❌ Direct COUNT with multiple JOINs
Counts duplicates.

### ❌ INNER JOIN
Excludes users without guides or addresses.

### ❌ Forget GROUP BY in subqueries
Does not aggregate correctly.

### ❌ Don't use COALESCE
NULLs instead of 0.

## Components Used

- SELECT
- LEFT JOIN (not INNER)
- Subqueries
- COUNT()
- COALESCE()
- GROUP BY
- ORDER BY
- Aliases

## Key Concept

**Count BEFORE joining** to avoid duplicates. Subqueries do the counting independently, then the results are joined.

