# 11-521 SQL 21 - Ranges (BETWEEN)

## What is a Range?

A **range** is a set of values between two points (start and end). For example, the range from 1 to 100 contains all numbers between 1 and 100 (inclusive).

## BETWEEN Syntax

```sql
SELECT * FROM table
WHERE column BETWEEN start_value AND end_value;
```

## Basic Example

```sql
SELECT * FROM guides
WHERE guides_revenue BETWEEN 1000 AND 5000;
```

Returns all records where revenue is between 1000 and 5000 (inclusive).

## BETWEEN is Inclusive

BETWEEN includes both endpoints:
- `BETWEEN 1000 AND 5000` includes 1000, 5000, and everything in between
- It is equivalent to: `WHERE column >= 1000 AND column <= 5000`

## NOT BETWEEN

Returns values **outside** the specified range:

```sql
SELECT * FROM guides
WHERE guides_revenue NOT BETWEEN 600 AND 1200;
```

Returns records with revenue < 600 OR revenue > 1200.

### Example

With data: 500, 750, 750, 1000, 1500

```sql
-- NOT BETWEEN 600 AND 1200
-- Returns: 500, 1500
-- Excludes: 750, 750, 1000
```

## Power of NOT BETWEEN

NOT BETWEEN is especially useful because:
- It does not just search for values below the range
- It does not just search for values above the range
- It searches for values on **both sides** of the excluded range

## Practical Use Cases

### Financial Reports

```sql
-- Sales between $10K and $50K
SELECT * FROM sales
WHERE amount BETWEEN 10000 AND 50000;

-- Sales outside the normal range
SELECT * FROM sales
WHERE amount NOT BETWEEN 5000 AND 20000;
```

### Dates

```sql
-- Records from a specific period
SELECT * FROM orders
WHERE order_date BETWEEN '2025-01-01' AND '2025-03-31';
```

### Filter Outliers

```sql
-- Exclude extreme values
SELECT * FROM data
WHERE value NOT BETWEEN -1000 AND 1000;
```

## Comparison with AND

BETWEEN is cleaner than using multiple AND statements:

```sql
-- Using BETWEEN (preferred)
WHERE revenue BETWEEN 1000 AND 5000

-- Equivalent with AND (more verbose)
WHERE revenue >= 1000 AND revenue <= 5000
```

## Applications

- Financial analysis (price ranges, revenue)
- Date filtering (time periods)
- Reports with specific thresholds
- Search for anomalous values (NOT BETWEEN)
