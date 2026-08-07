# 11-532 SQL 32 - Disable Safe Mode

## What is Safe Mode?

**Safe Mode** is a protection in MySQL that prevents:
- UPDATE without WHERE (update entire table)
- DELETE without WHERE (delete entire table)
- Accidental mass operations

## Detials

- **Safe Mode** protects against accidental mass operations
- **Disable temporarily**: `SET SQL_SAFE_UPDATES = 0;`
- **ALWAYS** use with BEGIN/ROLLBACK
- **Prefer** temporary command over preference change
- **Verify** with SELECT before COMMIT
- Useful for population scripts and intentional mass updates


## ⚠️ Important Warning

Safe Mode **protects you from yourself**. Disabling it can cause:
- Massive data loss
- Accidental updates of entire table
- Catastrophic deletions

**Use it with extreme caution in production.**

## Disable Safe Mode Temporarily

### Command

```sql
SET SQL_SAFE_UPDATES = 0;
```

This disables Safe Mode **only for the current session**.

## Complete Example with Protection

```sql
USE devcamp_sql_course_schema;

SET SQL_SAFE_UPDATES = 0;

BEGIN;

UPDATE addresses
SET addresses_city = 'Oops';  -- Without WHERE: updates ENTIRE table

SELECT * FROM addresses;  -- Verify changes

ROLLBACK;  -- Revert changes
```

## How It Works

### With Safe Mode (default)

```sql
UPDATE addresses
SET addresses_city = 'Oops';
-- ❌ ERROR: Safe mode blocks this operation
```

### Without Safe Mode

```sql
SET SQL_SAFE_UPDATES = 0;

UPDATE addresses
SET addresses_city = 'Oops';
-- ✅ Executes (updates ENTIRE table)
```

## Why Disable It Temporarily

Instead of changing global preferences:

### ❌ Bad: Change Preferences

- You disable Safe Mode globally
- Easy to forget to reactivate it
- Permanent risk

### ✅ Good: Temporary Command

```sql
SET SQL_SAFE_UPDATES = 0;  -- Only this session
```

- Only affects current session
- Resets when closing MySQL Workbench
- Safer

## Legitimate Use Cases

### 1. Population Scripts (Seeding)

```sql
SET SQL_SAFE_UPDATES = 0;

-- Populate new column for all records
UPDATE guides
SET guides_quantity = 100;
```

### 2. Intentional Mass Updates

```sql
SET SQL_SAFE_UPDATES = 0;

-- Reset all counters
UPDATE users
SET login_count = 0;
```

### 3. Data Cleanup

```sql
SET SQL_SAFE_UPDATES = 0;

-- Normalise phone number format
UPDATE users
SET phone = REPLACE(phone, '-', '');
```

## Always Use with BEGIN/ROLLBACK

**NEVER disable Safe Mode without protection**:

```sql
-- ✅ Correct: With protection
SET SQL_SAFE_UPDATES = 0;

BEGIN;

UPDATE addresses
SET addresses_city = 'NewCity';

-- Verify
SELECT * FROM addresses;

-- If correct: COMMIT
-- If wrong: ROLLBACK

ROLLBACK;  -- Revert
```

## Example of the Danger

### Without BEGIN/ROLLBACK (Dangerous)

```sql
SET SQL_SAFE_UPDATES = 0;

UPDATE addresses
SET addresses_city = 'Oops';  -- Updated EVERYTHING and it's PERMANENT!
```

### With BEGIN/ROLLBACK (Safe)

```sql
SET SQL_SAFE_UPDATES = 0;

BEGIN;

UPDATE addresses
SET addresses_city = 'Oops';

SELECT * FROM addresses;  -- Verify
-- Oh no! Changed everything

ROLLBACK;  -- Revert changes
-- Everything returns to normal
```

## Verify Before Confirming

```sql
BEGIN;

UPDATE table SET column = 'value';

-- ALWAYS verify before COMMIT
SELECT * FROM table;

-- If correct:
COMMIT;

-- If wrong:
ROLLBACK;
```

## Reactivate Safe Mode

```sql
SET SQL_SAFE_UPDATES = 1;
```

But not necessary if you use the temporary method, as it resets when closing the session.

## Change Preferences Globally (Not Recommended)

In MySQL Workbench:
1. Edit → Preferences
2. SQL Editor
3. Uncheck "Safe Updates"
4. Restart MySQL Workbench

**Not recommended** because it's easy to forget to reactivate it.

## Recommended Workflow

```sql
-- 1. Temporarily disable Safe Mode
SET SQL_SAFE_UPDATES = 0;

-- 2. Start transaction
BEGIN;

-- 3. Execute mass operation
UPDATE table SET column = 'value';

-- 4. Verify results
SELECT * FROM table;

-- 5. Confirm or revert
-- If correct:
COMMIT;
-- If wrong:
ROLLBACK;

-- 6. Safe Mode reactivates automatically when closing session
```

## When NOT to Disable

**DO NOT disable Safe Mode for**:
- Production operations without supervision
- Untested scripts
- When you're not 100% sure
- Without using BEGIN/ROLLBACK

## Common Error Without Safe Mode

```sql
-- Wanted to update ONE user
UPDATE users
SET email = 'newemail@test.com';
-- WHERE users_id = 5;  ← Forgot the WHERE!

-- Result: ALL users have the same email
```

Safe Mode would have blocked this.

## Best Practices

1. **Use only when necessary**
2. **ALWAYS with BEGIN/ROLLBACK**
3. **Verify with SELECT before COMMIT**
4. **Prefer temporary command over preference change**
5. **Document why you disabled it**

## Example of Safe Script

```sql
USE devcamp_sql_course_schema;

-- Disable Safe Mode for this operation
SET SQL_SAFE_UPDATES = 0;

-- Start transaction for protection
BEGIN;

-- Intentional mass update
UPDATE guides
SET guides_quantity = 100
WHERE guides_quantity IS NULL;

-- Verify changes
SELECT * FROM guides;

-- If everything is correct, confirm:
-- COMMIT;

-- If something went wrong, revert:
ROLLBACK;

-- Safe Mode reactivates automatically when closing session
```

