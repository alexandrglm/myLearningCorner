# 11-533 SQL 33 - Add Column and Populate with RAND()

## Details

1. **Add column**: ALTER TABLE or GUI
2. **RAND()**: Generates random numbers 0-1
3. **RAND() * N**: Generates random numbers 0-N
4. **FLOOR()**: Converts to integers
5. **Useful for**: Prototyping, testing, demos
6. **Always use**: BEGIN/ROLLBACK for protection
7. **Disable Safe Mode**: Necessary for UPDATE without WHERE

---

## Add New Column

### Method 1: MySQL Workbench GUI

1. Click the **wrench** icon next to the table
2. Scroll to the end of the columns
3. Add new row:
   - **Name**: `guides_qty` (or the name you want)
   - **Type**: `INT`
   - **Not Null**: ✓ (if required)
4. Click **Apply**
5. Confirm changes

### Method 2: SQL Command

```sql
ALTER TABLE guides
ADD COLUMN guides_qty INT NOT NULL;
```

## Initial Result

After adding the column:

```sql
SELECT * FROM guides;
```

All values will be **0** (default value for INT NOT NULL).

## RAND() Function

**RAND()** generates random numbers between 0 and 1.

```sql
SELECT RAND();  -- Returns e.g.: 0.847263
```

### RAND() with Multiplier

```sql
RAND() * 1000  -- Returns numbers between 0 and 1000
```

## Populate Column with Random Data

```sql
USE devcamp_sql_course_schema;

SET SQL_SAFE_UPDATES = 0;

BEGIN;

UPDATE guides
SET guides_qty = RAND() * 1000;

SELECT * FROM guides;  -- Verify

-- If correct: COMMIT
-- If not: ROLLBACK
```

## How It Works

1. **RAND()** generates random number (e.g.: 0.753)
2. **× 1000** multiplies it (e.g.: 753)
3. **UPDATE** assigns that value to each row
4. Each row gets a different random value

### Example of Results

| guides_id | guides_qty |
|-----------|-----------|
| 1 | 847 |
| 2 | 293 |
| 3 | 612 |
| 4 | 159 |
| 5 | 934 |

Each record has a different random number.

## ⚠️ Note about Keyboard Shortcut

In MySQL Workbench:
- **Command/Ctrl + Enter** executes only the last selected line
- To execute multiple lines, use the **lightning bolt** button

```sql
-- ❌ Only executes last line with Command+Enter
SET SQL_SAFE_UPDATES = 0;
UPDATE guides SET guides_qty = RAND() * 1000;

-- ✅ Use the lightning bolt to execute everything
```

## Verify Changes

```sql
SELECT * FROM guides;
```

You should see the new `guides_qty` column populated with random numbers.

## Range of Random Numbers

Control the range by adjusting the multiplier:

```sql
-- Between 0 and 100
RAND() * 100

-- Between 0 and 1000
RAND() * 1000

-- Between 0 and 5000
RAND() * 5000

-- Between 50 and 150
50 + (RAND() * 100)
```

## RAND() with FLOOR for Integers

RAND() returns decimals. For exact integers:

```sql
UPDATE guides
SET guides_qty = FLOOR(RAND() * 1000);
```

**FLOOR()** rounds down:
- `847.23` → `847`
- `293.87` → `293`

## Use in Prototyping

### Why Use RAND()?

When developing applications you need:
- Realistic test data
- Many records with variety
- Quickly populate tables for testing

### Without RAND() (Manual)

```sql
-- Insert 1000 records manually... 😱
INSERT INTO guides (guides_qty) VALUES (347);
INSERT INTO guides (guides_qty) VALUES (892);
-- ... 998 more lines ...
```

### With RAND() (Automatic)

```sql
-- Populate 1000 records in 1 second
UPDATE guides SET guides_qty = RAND() * 1000;
```

## Practical Applications

### 1. Populate Product Stock

```sql
UPDATE products
SET stock = RAND() * 500;
```

### 2. Simulate Ratings

```sql
UPDATE reviews
SET rating = FLOOR(1 + (RAND() * 5));  -- Between 1 and 5
```

### 3. Generate Random Prices

```sql
UPDATE products
SET price = 10 + (RAND() * 990);  -- Between $10 and $1000
```

### 4. Test Data for Inventory

```sql
UPDATE inventory
SET quantity = FLOOR(RAND() * 1000),
    last_updated = NOW();
```

## Complete Example Script

```sql
USE devcamp_sql_course_schema;

-- 1. Temporarily disable Safe Mode
SET SQL_SAFE_UPDATES = 0;

-- 2. Start transaction
BEGIN;

-- 3. Populate with random data
UPDATE guides
SET guides_qty = FLOOR(RAND() * 1000);

-- 4. Verify results
SELECT guides_id, guides_title, guides_qty
FROM guides;

-- 5. If correct, confirm:
COMMIT;

-- 5b. If something went wrong, revert:
-- ROLLBACK;
```

## Advantages

1. **Fast**: Populates thousands of records instantly
2. **Automatic**: No need for manual data
3. **Varied**: Each record is different
4. **Scalable**: Works with 10 or 10,000 records

## Use Cases

### Development and Prototyping

```sql
-- Create realistic test data
UPDATE orders
SET total_amount = 10 + (RAND() * 990);
```

### Performance Testing

```sql
-- Populate millions of records for load testing
UPDATE test_data
SET value = RAND() * 1000000;
```

### Demonstration

```sql
-- Create dashboards with varied data
UPDATE sales
SET daily_revenue = 1000 + (RAND() * 9000);
```

## Combining RAND() with Other Values

```sql
UPDATE guides
SET 
    guides_qty = FLOOR(RAND() * 1000),
    guides_revenue = 100 + (RAND() * 900);
```

## ⚠️ Do Not Use in Production

**RAND() is for test data**, not for:
- Real user data
- Actual financial information
- Production records

## Alternatives to RAND()

### Sequences

```sql
-- Incremental values
UPDATE guides
SET guides_qty = guides_id * 10;
```

### Fixed Values

```sql
-- Same value for all
UPDATE guides
SET guides_qty = 100;
```

### Conditional Values

```sql
-- Based on another column
UPDATE guides
SET guides_qty = 
    CASE 
        WHEN guides_revenue > 1000 THEN 500
        ELSE 100
    END;
```

## Result of RAND()

The values are **pseudo-random**:
- Each execution gives different results
- Occasionally there may be duplicates
- Statistically uniform distribution
