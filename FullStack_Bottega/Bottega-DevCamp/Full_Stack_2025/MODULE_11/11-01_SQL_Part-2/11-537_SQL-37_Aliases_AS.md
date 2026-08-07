# 11-537 SQL 37 - Aliases (AS) and Export to CSV

## What are Aliases?

**Aliases** allow you to temporarily rename columns in the result of a query using the keyword **AS**.

* AS: Temporarily renames columns
* Syntax: column AS 'New Name'
* Quotes: Needed for spaces, recommended always
* Export CSV: Clean and professional headers
* Use: Reports, calculated fields, aggregate functions
* Temporary: Doesn't change DB structure
* Essential: For control flow and CASE statements (next)


## Syntax

```sql
SELECT column AS 'New Name'
FROM table;
```

## The Problem

Column names in the DB can be unfriendly:

```sql
SELECT 
    addresses_street_one,
    addresses_street_two,
    addresses_city,
    addresses_state,
    addresses_postal_code
FROM addresses;
```

**Result**:
| addresses_street_one | addresses_street_two | addresses_city | ... |
|---------------------|---------------------|---------------|-----|

These names are technical and not presentable for executives or reports.

## The Solution: Aliases

```sql
SELECT 
    addresses_street_one AS 'Street',
    addresses_street_two AS 'Street 2',
    addresses_city AS 'City',
    addresses_state AS 'State',
    addresses_postal_code AS 'Postal Code'
FROM addresses;
```

**Result**:
| Street | Street 2 | City | State | Postal Code |
|--------|----------|------|-------|-------------|

Much cleaner and more professional.

## Two Ways to Use AS

### Without Quotes (no spaces)

```sql
SELECT addresses_city AS city
FROM addresses;
```

✅ Works if the alias **has no spaces**.

### With Quotes (with spaces)

```sql
SELECT addresses_city AS 'City Name'
FROM addresses;
```

✅ Works even with spaces.

## Recommendation: Always Use Quotes

```sql
-- ✅ Recommended (consistent and clear)
SELECT 
    addresses_street_one AS 'Street',
    addresses_city AS 'City'
FROM addresses;

-- ❌ Not recommended (inconsistent)
SELECT 
    addresses_street_one AS Street,  -- without quotes
    addresses_city AS 'City Name'    -- with quotes
FROM addresses;
```

**Why always use quotes:**
1. **Clarity**: Easy to see what's an alias and what's not
2. **Flexibility**: Allows spaces when you need them
3. **Consistency**: Same style throughout your code

## Export to CSV

### Step 1: Execute Query with Aliases

```sql
SELECT 
    addresses_street_one AS 'Street',
    addresses_city AS 'City',
    addresses_state AS 'State'
FROM addresses;
```

### Step 2: Export

In MySQL Workbench:
1. Execute the query
2. Right-click on the results
3. **Export** → **CSV**
4. Save file

### Step 3: Open in Excel

The CSV file will have clean headers:
```
Street,City,State
123 Main St,New York,NY
456 Oak Ave,Los Angeles,CA
```

## Advantages in Reports

### Without Aliases
```
addresses_street_one | addresses_city | addresses_state
```
❌ Technical, unprofessional

### With Aliases
```
Street | City | State
```
✅ Clean, professional, presentable

## Aliases with Calculated Fields

```sql
SELECT 
    product_name AS 'Product',
    price AS 'Unit Price',
    quantity AS 'Qty',
    price * quantity AS 'Total'
FROM order_items;
```

Calculated fields **need** aliases to be readable.

## Aliases in Different Contexts

### SELECT (Columns)

```sql
SELECT 
    users_name AS 'Name',
    users_email AS 'Email'
FROM users;
```

### Aggregate Functions

```sql
SELECT 
    COUNT(*) AS 'Total Users',
    AVG(age) AS 'Average Age',
    SUM(revenue) AS 'Total Revenue'
FROM users;
```

### GROUP BY

```sql
SELECT 
    category AS 'Category',
    COUNT(*) AS 'Product Count',
    AVG(price) AS 'Average Price'
FROM products
GROUP BY category;
```

### Tables (Table Aliases)

```sql
SELECT 
    u.users_name AS 'Name',
    a.addresses_city AS 'City'
FROM users AS u
JOIN addresses AS a ON u.users_id = a.addresses_users_id;
```

## Aliases for Functions

```sql
SELECT 
    UPPER(users_name) AS 'Name (Uppercase)',
    LOWER(users_email) AS 'Email (Lowercase)',
    CONCAT(first_name, ' ', last_name) AS 'Full Name'
FROM users;
```

## Complete Report Example

```sql
SELECT 
    'Q1 2025' AS 'Period',
    department AS 'Department',
    COUNT(*) AS 'Orders',
    SUM(total) AS 'Revenue',
    AVG(total) AS 'Avg Order',
    MAX(total) AS 'Largest Order',
    MIN(total) AS 'Smallest Order'
FROM sales
WHERE order_date BETWEEN '2025-01-01' AND '2025-03-31'
GROUP BY department;
```

**Export to CSV** → Executive report ready.

## Aliases and Control Flow (Next)

Aliases are essential for CASE statements:

```sql
SELECT 
    users_name AS 'Name',
    CASE 
        WHEN status = 0 THEN 'Active'
        WHEN status = 1 THEN 'Inactive'
    END AS 'Status'
FROM users;
```

Without an alias, the column name would be: `CASE WHEN status = 0 THEN 'Active'...` (ugly).

## Aliases vs Literal Labels

### Literal Labels (previous guide)

```sql
SELECT 'Email:', users_email
FROM users;
```
Adds **extra columns** with text.

### Aliases (this guide)

```sql
SELECT users_email AS 'Email'
FROM users;
```
**Renames** the existing column.

## Real-World Use Cases

### Dashboard

```sql
SELECT 
    DATE_FORMAT(order_date, '%Y-%m') AS 'Month',
    COUNT(*) AS 'Orders',
    SUM(total) AS 'Revenue'
FROM orders
GROUP BY DATE_FORMAT(order_date, '%Y-%m');
```

### User Report

```sql
SELECT 
    users_id AS 'ID',
    users_name AS 'Name',
    users_email AS 'Email Address',
    created_at AS 'Member Since'
FROM users
ORDER BY created_at DESC;
```

### Financial Report

```sql
SELECT 
    category AS 'Category',
    SUM(revenue) AS 'Total Revenue',
    SUM(cost) AS 'Total Cost',
    SUM(revenue - cost) AS 'Net Profit'
FROM transactions
GROUP BY category;
```

## Single Quotes vs Double Quotes

In MySQL:
- **Single quotes** (`'`): For aliases
- **Double quotes** (`"`): Also work, but less standard

```sql
-- ✅ Preferred
SELECT column AS 'Alias'

-- ✅ Also works
SELECT column AS "Alias"

-- ❌ Error (backticks are for table/column names)
SELECT column AS `Alias`
```

## Spaces in Aliases

```sql
-- ✅ Correct with quotes
SELECT column AS 'Full Name'

-- ❌ Error without quotes
SELECT column AS Full Name  -- Syntax error
```

## Aliases Don't Change the DB

Aliases are **temporary** only for the query result:

```sql
SELECT users_email AS 'Email'
FROM users;
```

- The column in the DB is still `users_email`
- It only displays as `Email` in the result
- It doesn't affect the table structure

## Performance

Aliases **do not affect** performance - they're just cosmetic in the result.

## Best Practices

1. **Always use quotes** for consistency
2. **Descriptive names** in aliases
3. **Use for reports** that are exported
4. **Always alias calculated fields** for clarity
5. **Alias aggregate functions** for readability

## Export with Professional Format

```sql
SELECT 
    order_id AS 'Order #',
    customer_name AS 'Customer',
    order_date AS 'Date',
    total AS 'Amount',
    status AS 'Status'
FROM orders
ORDER BY order_date DESC;
```

Export → CSV → Excel → **Professional report** ready to deliver.
