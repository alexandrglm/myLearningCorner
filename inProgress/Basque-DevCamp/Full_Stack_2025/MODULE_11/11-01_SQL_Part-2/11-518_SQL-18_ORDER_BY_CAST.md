# 11-518 SQL 18 - ORDER BY and CAST

## ORDER BY

**ORDER BY** sorts the results according to a specific column.

### Syntax

```sql
SELECT columns
FROM table
ORDER BY column [ASC | DESC];
```

- **ASC**: Ascending (A-Z, 0-9) - default
- **DESC**: Descending (Z-A, 9-0)

### Examples

```sql
-- Descending alphabetical order
SELECT guides_title FROM guides
ORDER BY guides_title DESC;

-- Ascending alphabetical order
SELECT guides_title FROM guides
ORDER BY guides_title ASC;
```

## Problem: Ordering Numbers as VARCHAR

If a numeric column is stored as VARCHAR, the order will be alphabetical, not numeric:

```sql
SELECT guides_revenue FROM guides
ORDER BY guides_revenue DESC;
```

Incorrect result: 750, 750, 500, 1300, 1000
(Orders as strings: "750" < "1000" alphabetically)

## Solution: CAST

**CAST** temporarily converts the data type during the query.

### Syntax

```sql
CAST(column AS data_type)
```

### Complete Example

```sql
SELECT guides_revenue, guides_title
FROM guides
ORDER BY CAST(guides_revenue AS UNSIGNED) DESC;
```

Correct result: 1300, 1000, 750, 750, 500

## Common CAST Types

- **UNSIGNED**: Unsigned integer (positive numbers only)
- **SIGNED**: Signed integer (positive and negative)
- **DECIMAL**: Decimal numbers
- **CHAR**: Text string
- **DATE**: Date
- **DATETIME**: Date and time

## Why This Happens

- Legacy applications may have incorrectly typed data
- VARCHAR stores numbers as text
- SQL treats VARCHAR as alphanumeric characters
- The alphabetical order of strings differs from numeric order

## When to Use CAST

- Sort numbers stored as text
- Sum values that are not the correct type
- Compare data of different types
- Work with poorly structured legacy data

## ORDER BY by Default

Without ORDER BY, SQL returns records in ID order (insertion order).

## Best Practice

In database design: use the correct data type from the start (INT for numbers, not VARCHAR).

But when working with legacy data, CAST is your solution.
