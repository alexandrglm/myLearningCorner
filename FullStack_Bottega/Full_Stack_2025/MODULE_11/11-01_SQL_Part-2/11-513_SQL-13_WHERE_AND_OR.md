# 11-513 SQL 13 - Filter Queries (WHERE, AND, OR)

## The WHERE Clause

**WHERE** allows you to filter results according to specific criteria.

### Basic Syntax

```sql
SELECT * FROM users
WHERE users_email = 'kristine@test.com';
```

Returns only the records that meet the criterion.

## OR Operator

**OR** expands the search, allowing multiple criteria where at least one must be met.

```sql
SELECT * FROM users
WHERE users_email = 'kristine@test.com'
OR users_email = 'jordan@test.com';
```

- Returns records that meet **any** of the criteria
- Expands the scope of the query
- Multiple OR statements can be chained

## AND Operator

**AND** narrows the search, requiring that **all** criteria are met.

```sql
SELECT * FROM addresses
WHERE addresses_state = 'NY'
AND addresses_city = 'Manhattan';
```

- Returns only the records that meet **all** criteria
- Reduces the scope of the query
- Multiple AND statements can be chained

### Example with Multiple AND

```sql
SELECT * FROM addresses
WHERE addresses_state = 'NY'
AND addresses_city = 'Manhattan'
AND addresses_users_id = 1;
```

Each additional AND filters the result further.

## Key Difference: OR vs AND

- **OR**: Expands results (more flexible, more records)
- **AND**: Reduces results (more specific, fewer records)

## Practical Applications

- Updating multiple specific accounts
- Searching for records with specific characteristics
- Filtering data for analysis
- WHERE is fundamental for UPDATE and DELETE (we will see more later)

## Complete Example

```sql
SELECT addresses_city, addresses_state
FROM addresses
WHERE addresses_state = 'NY';
```

Returns only city and state where the state is NY.
