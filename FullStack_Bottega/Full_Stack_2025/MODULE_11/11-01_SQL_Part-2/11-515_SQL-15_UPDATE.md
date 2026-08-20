# 11-515 SQL 15 - Update Records (UPDATE)

## Basic UPDATE Syntax

```sql
UPDATE table
SET column = 'new_value'
WHERE condition;
```

## Simple Example

```sql
UPDATE users
SET users_email = 'update@test.com'
WHERE users_id = 2;
```

## Components of UPDATE

1. **UPDATE table**: Specifies which table to modify
2. **SET column = value**: Defines which column to change and its new value
3. **WHERE condition**: **CRITICAL** - specifies which records to update

## ⚠️ IMPORTANCE OF WHERE

**NEVER forget the WHERE** or you will update ALL records in the table.

### Safe Mode in MySQL Workbench

- MySQL Workbench has "Safe Mode" active by default
- Prevents accidentally updating or deleting all records
- Blocks UPDATE/DELETE queries without proper WHERE clause
- Can be deactivated, but is NOT recommended

## UPDATE with Multiple Conditions

### Using AND

```sql
UPDATE guides
SET guides_title = 'Something Else'
WHERE guides_title = 'Another Post'
AND guides_users_id = 2;
```

**AND** allows you to be more specific:
- Updates only records that meet ALL criteria
- Useful for limiting changes to a specific user's records

### ⚠️ Beware of OR

OR can update more records than expected:
```sql
-- DANGEROUS: could update many more records
WHERE guides_title = 'Another Post'
OR guides_users_id = 2;  -- All records of user 2 will be updated
```

## Verifying Results

Before UPDATE:
```sql
SELECT * FROM users WHERE users_id = 2;
```

After UPDATE, verify:
```sql
SELECT * FROM users WHERE users_id = 2;
```

## SQL Response

When you execute UPDATE, SQL returns:
- **Rows matched**: How many records matched the WHERE clause
- **Rows changed**: How many were actually modified
- **0 rows affected**: No records matched the criteria

## Example with No Matches

```sql
UPDATE guides
SET guides_title = 'Something Else Again'
WHERE guides_title = 'Something Else'
AND guides_users_id = 1;  -- If this combination doesn't exist, 0 rows affected
```

## Best Practices

1. Always use WHERE (except if you really want to update everything)
2. First run SELECT with the same WHERE to verify what will be updated
3. Use AND to be more specific
4. Verify afterwards with SELECT that the change was correct
