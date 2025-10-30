# 11-535 SQL 35 - Custom Labels in Reports

Literal labels are commonly used for generating professional reports directly from SQL.

- **Syntax**: `'Label'` in single quotes
- **Use**: Executive reports, Excel exports
- **Advantage**: Self-explanatory data without post-processing
- **Limitation**: Adds additional columns
- **Alternative**: AS to rename columns (next guide)

## The Problem

When exporting data to Excel or CSV, column names may not be clear:

```sql
SELECT users_email, users_name FROM users;
```

**Result**:
| users_email | users_name |
|------------|-----------|
| john@test.com | John |

In Excel, this looks confusing without clear headers.

## The Solution: Literal Labels

You can add **literal text columns** with single quotes:

```sql
SELECT 'Email:', users_email, 'Name:', users_name
FROM users;
```

**Result**:
| Email: | users_email | Name: | users_name |
|--------|------------|-------|-----------|
| Email: | john@test.com | Name: | John |
| Email: | jane@test.com | Name: | Jane |

## Syntax

```sql
SELECT 'Label', column, 'Another Label', another_column
FROM table;
```

## How It Works

- **String literal** in single quotes: `'Email:'`
- Repeats in **every row** of the result
- Appears as **additional column**

## Use in Reports

### Basic Report

```sql
SELECT 
    'User ID:', users_id,
    'Email:', users_email,
    'Name:', users_name
FROM users;
```

### Financial Report

```sql
SELECT 
    'Product:', product_name,
    'Revenue:', revenue,
    'Profit:', revenue - cost
FROM sales;
```

### Status Report

```sql
SELECT 
    'Order:', order_id,
    'Status:', status,
    'Date:', order_date,
    'Total:', total_amount
FROM orders;
```

## Advantages

### 1. Ready for Excel

Exported data already has descriptive labels.

### 2. No Post-Processing

You don't need additional scripts to format in Excel.

### 3. Professional

Shows SQL mastery by delivering well-formatted reports.

### 4. Clarity

The report is self-explanatory even without column headers.

## Export to Excel/CSV

After executing the query:
1. Right-click on results
2. Export → CSV or Excel
3. The file already has the labels

## Limitations

- **Not the same as AS**: Labels are additional columns, they don't rename columns
- **Extra space**: Adds additional columns to the result
- **Repetition**: The label repeats in every row

## Comparison: Labels vs AS

### With Labels (this method)

```sql
SELECT 'Email:', users_email, 'Name:', users_name
FROM users;
```

**Result**: 4 columns
| 'Email:' | users_email | 'Name:' | users_name |
|----------|------------|---------|-----------|

### With AS (next guide)

```sql
SELECT users_email AS 'Email', users_name AS 'Name'
FROM users;
```

**Result**: 2 columns
| Email | Name |
|------|------|

## When to Use Each Method

### Use Labels ('text')

- Executive reports
- Direct export to Excel/CSV
- Need descriptive text in each row
- Printed report format

### Use AS (Alias)

- Queries for applications
- Temporarily rename columns
- Calculated fields with descriptive names
- Programmatic queries

## Example Executive Report

```sql
SELECT 
    'Department:', department,
    'Revenue:', SUM(revenue),
    'Avg Sale:', AVG(sale_amount),
    'Total Orders:', COUNT(*)
FROM sales
GROUP BY department;
```

**Result**:
```
Department: | Electronics | Revenue: | 50000 | Avg Sale: | 250 | Total Orders: | 200
Department: | Clothing    | Revenue: | 30000 | Avg Sale: | 150 | Total Orders: | 200
```

## Combine with Calculated Fields

```sql
SELECT 
    'Product:', product_name,
    'Price:', price,
    'Quantity:', quantity,
    'Total:', price * quantity
FROM order_items;
```

## Multiple Labels per Record

```sql
SELECT 
    'ID:', users_id,
    'Email:', users_email,
    'Created:', created_at,
    'Status:', CASE 
        WHEN active = 1 THEN 'Active'
        ELSE 'Inactive'
    END
FROM users
WHERE users_id < 10;
```

## Professional Report Format

```sql
SELECT 
    '=== ORDER DETAILS ===',
    'Order #:', order_id,
    'Customer:', customer_name,
    'Date:', order_date,
    '---',
    'Subtotal:', subtotal,
    'Tax:', tax,
    'Total:', subtotal + tax
FROM orders
WHERE order_date >= '2025-01-01';
```

## Use with Aggregate Functions

```sql
SELECT 
    'State:', addresses_state,
    'Total Users:', COUNT(*)
FROM addresses
GROUP BY addresses_state;
```

**Result**:
```
State: | NY | Total Users: | 150
State: | CA | Total Users: | 200
State: | TX | Total Users: | 100
```

## Labels with Emojis (UTF-8)

```sql
SELECT 
    '📧 Email:', users_email,
    '👤 Name:', users_name,
    '📅 Joined:', created_at
FROM users;
```

## Empty Strings as Visual Separators

```sql
SELECT 
    users_name,
    '',  -- Empty column as visual separator
    users_email,
    '',
    created_at
FROM users;
```

## Use Case: Metrics Dashboard

```sql
SELECT 
    'KPI Dashboard - Q1 2025',
    '',
    'Total Revenue:', SUM(revenue),
    'Total Orders:', COUNT(*),
    'Avg Order Value:', AVG(total),
    'Top Seller:', MAX(product_name)
FROM sales
WHERE order_date BETWEEN '2025-01-01' AND '2025-03-31';
```

## Conditional Labels

```sql
SELECT 
    CASE 
        WHEN status = 'active' THEN '✓ Active:'
        ELSE '✗ Inactive:'
    END,
    users_name,
    users_email
FROM users;
```

## Best Practices

1. **Use for final reports**: Not for application queries
2. **Direct export**: Ideal for Excel/CSV
3. **Clarity**: Makes the report self-explanatory
4. **Consistency**: Maintain consistent format throughout the report

## Modern Alternative: AS

For most cases, **AS** (aliases) is preferable:

```sql
-- Cleaner and more standard
SELECT 
    users_email AS 'Email Address',
    users_name AS 'Full Name'
FROM users;
```

But literal labels are useful for **printed reports** or **direct exports** where you need descriptive text in each row.

