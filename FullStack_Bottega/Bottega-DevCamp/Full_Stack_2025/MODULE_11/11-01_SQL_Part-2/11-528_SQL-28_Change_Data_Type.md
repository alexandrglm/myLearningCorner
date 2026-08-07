# 11-528 SQL 28 - Change Column Data Type

## The Problem

If a numeric column is stored as VARCHAR, functions can give incorrect results:

```sql
SELECT MIN(guides_revenue) FROM guides;
-- Returns: 1000 (incorrect, should be 500)
```

This happens because MIN treats values as strings, not numbers.

## Temporary Solution: CAST

You can use CAST to temporarily convert:

```sql
SELECT MIN(CAST(guides_revenue AS UNSIGNED))
FROM guides;
-- Returns: 500 (correct)
```

**Problem**: You must use CAST in every query.

## Permanent Solution: Change the Data Type

### Step 1: Access the Table

In MySQL Workbench:
1. Click on the **wrench** icon next to the table
2. The table structure editor opens

### Step 2: Change the Data Type

1. Find the `guides_revenue` column
2. Change from `VARCHAR` to `DECIMAL` (or `FLOAT`)
3. Click **Apply**

### Step 3: Confirm

SQL generates:
```sql
ALTER TABLE guides
MODIFY COLUMN guides_revenue DECIMAL NOT NULL;
```

Click **Apply** to execute.

## DECIMAL vs FLOAT

### DECIMAL
- **Exact precision**
- **Recommended for financial data**
- No rounding errors
- Example: money, prices, monetary quantities

### FLOAT
- **Approximate precision**
- Faster for scientific calculations
- May have minimal rounding errors
- Example: scientific measurements, coordinates

### For Financial Data: Use DECIMAL

```sql
-- ✅ Correct for money
guides_revenue DECIMAL(10, 2)  -- 10 total digits, 2 decimals

-- ❌ Not recommended for money
guides_revenue FLOAT
```

## After the Change

Now functions work without CAST:

```sql
-- Before (needed CAST)
SELECT MIN(CAST(guides_revenue AS UNSIGNED)) FROM guides;

-- After (works directly)
SELECT MIN(guides_revenue) FROM guides;
-- Returns: 500 (correct)
```

## ALTER TABLE (SQL Command)

To change the data type manually:

```sql
ALTER TABLE guides
MODIFY COLUMN guides_revenue DECIMAL(10, 2) NOT NULL;
```

### DECIMAL Parameters

```sql
DECIMAL(precision, scale)
```

- **Precision**: Total number of digits
- **Scale**: Number of digits after the decimal point

Examples:
- `DECIMAL(10, 2)`: up to 99,999,999.99
- `DECIMAL(8, 2)`: up to 999,999.99
- `DECIMAL(5, 2)`: up to 999.99

## Problems with VARCHAR for Numbers

### 1. Incorrect Ordering

```sql
-- As VARCHAR: 1000, 1500, 500, 750
-- As DECIMAL: 500, 750, 1000, 1500
```

### 2. Incorrect Aggregate Functions

```sql
-- MIN, MAX, AVG, SUM do not work correctly
```

### 3. Constant Need for CAST

```sql
-- You must do this in every query
CAST(column AS type)
```

## Legacy Data

In old applications (legacy), it is common to find:
- Numbers stored as VARCHAR
- Dates in text format
- Booleans as strings ('true'/'false')

**Solution**: Change data types when possible.

## When NOT to Change

Keep VARCHAR when:
- The "numbers" are really codes (e.g.: "001", "002")
- You need to preserve leading zeroes (e.g.: "00123")
- Values can contain letters (e.g.: "N/A", "TBD")

## Check Current Data Type

```sql
DESCRIBE guides;
-- or
SHOW COLUMNS FROM guides;
```

Shows the data type of each column.

## Recommended Workflow

1. **Identify problematic columns**: VARCHAR that should be numeric
2. **Make a backup**: Always before modifying structure
3. **Change data type**: Use ALTER TABLE or GUI
4. **Verify**: Test queries without CAST
5. **Update queries**: Remove unnecessary CAST from code

## Complete Example

```sql
-- Initial state
SELECT MIN(guides_revenue) FROM guides;  -- 1000 (incorrect)

-- Change type
ALTER TABLE guides
MODIFY COLUMN guides_revenue DECIMAL(10, 2) NOT NULL;

-- After change
SELECT MIN(guides_revenue) FROM guides;  -- 500 (correct)
```

## Best Practice

**For financial data, always use DECIMAL**:
- Avoids rounding errors
- Exact precision
- Standard in financial applications

## Important Note

Once you change the data type, aggregate functions (MIN, MAX, SUM, AVG) will work correctly without needing CAST.
