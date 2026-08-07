# 11-516 SQL 16 - BEGIN and ROLLBACK (Transactions)

## Problem

When executing UPDATE or DELETE, the changes are permanent. If you make a mistake, there is no way to undo it.

## Solution: Transactions

**Transactions** allow you to test changes and revert them if something goes wrong.

## Syntax in MySQL

```sql
BEGIN;

UPDATE guides
SET guides_title = 'Oops'
WHERE guides_users_id = 1;

-- Verify changes
SELECT * FROM guides;

-- Revert changes
ROLLBACK;
```

## How It Works

1. **BEGIN**: Starts a transaction
2. **Execute queries**: UPDATE, DELETE, INSERT, etc.
3. **Verify**: Run SELECT to check if it is correct
4. **ROLLBACK**: Reverts all changes since BEGIN

## What is a Transaction?

A **transaction** is a set of operations that can be:
- **Committed** (made permanent)
- **Rolled back** (completely undone)

## Transaction History

- Database engines with transaction support maintain a **transaction history**
- This record allows you to return to previous states
- **Not all databases support transactions**

## ⚠️ Considerations

### Specific to MySQL

This syntax is for MySQL with **InnoDB** engine:
- Other engines may not support transactions
- Other DBMS (Oracle, SQL Server) may have different syntax
- Consult the documentation specific to your database

### When to Use

- Complex scripts where you're not 100% sure
- Experiments with data
- Mass updates
- When learning SQL (good practice)

## Recommended Workflow

```sql
BEGIN;

-- Make changes
UPDATE table SET column = 'value' WHERE condition;

-- Verify
SELECT * FROM table WHERE condition;

-- If correct: COMMIT; (make permanent)
-- If wrong: ROLLBACK; (revert)
```

## Making Changes Permanent

If after verifying everything is correct:
```sql
COMMIT;
```

This makes the changes permanent and closes the transaction.

## Best Practice

Using BEGIN/ROLLBACK is considered a **good practice**, especially when you are learning or making important changes.
