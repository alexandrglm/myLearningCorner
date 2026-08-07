# 11-519 SQL 19 - Delete Records (DELETE)

## DELETE Syntax

```sql
DELETE FROM table
WHERE condition;
```

## Basic Example

```sql
DELETE FROM users
WHERE users_id = 199;
```

## ⚠️ CRITICAL: Always Use WHERE

**NEVER forget the WHERE** or you will delete ALL records in the table.

## Recommended Workflow

### 1. Verify Before Deleting

```sql
SELECT * FROM users
WHERE users_id = 199;
```

Confirms that the record exists and is the correct one.

### 2. Use Transactions for Protection

```sql
BEGIN;

DELETE FROM users
WHERE users_id = 199;

-- Verify that it was deleted
SELECT * FROM users
WHERE users_id = 199;

-- If everything is correct: COMMIT;
-- If there is an error: ROLLBACK;
```

### 3. Rollback if Necessary

```sql
ROLLBACK;
```

Reverts the deletion and restores the record.

## DELETE is Permanent

Without using BEGIN/ROLLBACK, once DELETE is executed, **there is no way to recover the data**.

## Best Practices

1. **Always verify first** with SELECT using the same WHERE clause
2. **Use BEGIN/ROLLBACK** when you are not 100% sure
3. **Never DELETE without WHERE** (unless you really want to empty the table)
4. **Make a backup** before mass deletes

## DELETE vs TRUNCATE

- **DELETE**: Removes specific records with WHERE
- **TRUNCATE**: Empties the entire table (faster, but cannot use WHERE)

```sql
-- Deletes a specific record
DELETE FROM users WHERE users_id = 199;

-- Empties the entire table
TRUNCATE TABLE users;
```

## Verify Afterwards

```sql
-- After DELETE, verify
SELECT * FROM users
WHERE users_id = 199;
```

If it returns 0 records, the deletion was successful.

## DELETE is Easy, But Dangerous

DELETE is one of the simplest commands in SQL, but also one of the most dangerous. Always proceed with caution.
