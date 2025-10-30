# 11-534 SQL 34 - Calculated Fields

## What is a Calculated Field?

A **calculated field** is a column that is computed dynamically using mathematical operations on other columns, without being stored in the database. Calculated fields are fundamental for analysis and reporting in SQL.

## Details

- **Calculated fields**: Dynamically computed columns
- **Operators**: `*`, `/`, `+`, `-`
- **Not stored**: Calculated in real time
- **Always updated**: Use current values
- **Common use**: Revenue per unit, totals, margins, etc.
- **Next**: We will learn aliases (AS) to name calculated fields



---

## Example Problem

We have:
- `guides_revenue`: Total income
- `guides_qty`: Quantity sold

**Question**: How much does each unit sold generate?

**Answer**: `revenue / quantity`

## Basic Syntax

```sql
SELECT column1, column2, column1 / column2
FROM table;
```

## Complete Example

```sql
SELECT 
    guides_title,
    guides_revenue,
    guides_qty,
    guides_revenue / guides_qty
FROM guides;
```

**Result**:
| guides_title | guides_revenue | guides_qty | revenue/qty |
|-------------|----------------|-----------|-------------|
| My Blog | 500 | 543 | 0.92 |
| Another Post | 5000 | 552 | 9.06 |

## Mathematical Operators in SQL

```sql
-- * Multiplication
-- / Division
-- + Addition
-- - Subtraction
```

### Examples of Each Operator

```sql
-- Division
SELECT price / quantity FROM products;

-- Multiplication
SELECT price * quantity FROM orders;

-- Addition
SELECT price + tax FROM invoices;

-- Subtraction
SELECT revenue - cost FROM sales;
```

## Practical Use Cases

### 1. Revenue per Unit

```sql
SELECT 
    product_name,
    total_revenue,
    units_sold,
    total_revenue / units_sold as price_per_unit
FROM products;
```

### 2. Order Total

```sql
SELECT 
    order_id,
    price,
    quantity,
    price * quantity as order_total
FROM order_items;
```

### 3. Profit Margin

```sql
SELECT 
    product_name,
    price,
    cost,
    price - cost as profit_margin
FROM products;
```

### 4. Discount Percentage

```sql
SELECT 
    product_name,
    original_price,
    sale_price,
    (original_price - sale_price) / original_price * 100 as discount_percent
FROM products;
```

### 5. Tax

```sql
SELECT 
    product_name,
    price,
    price * 0.08 as tax,
    price + (price * 0.08) as total_with_tax
FROM products;
```

## Advantages of Calculated Fields

### 1. Takes No Space

You don't need an additional column in the database.

### 2. Always Updated

It is calculated in real time with current values.

### 3. Flexible

You can change the calculation without modifying the table structure.

## Comparison: Stored vs Calculated

### Stored (Saved)

```sql
-- You need an extra column
ALTER TABLE products ADD COLUMN total DECIMAL;

-- Update manually
UPDATE products SET total = price * quantity;
```

**Problem**: If price or quantity change, total becomes out of date.

### Calculated (Computed)

```sql
-- Calculated on the fly
SELECT price * quantity as total
FROM products;
```

**Advantage**: Always reflects current values.

## Complex Operations

### Multiple Operators

```sql
SELECT 
    product_name,
    price,
    quantity,
    tax_rate,
    (price * quantity) + (price * quantity * tax_rate) as grand_total
FROM orders;
```

### Use Parentheses for Order

```sql
-- Incorrect (without parentheses)
SELECT price + tax * quantity FROM orders;  -- tax*quantity first

-- Correct (with parentheses)
SELECT (price + tax) * quantity FROM orders;  -- addition first
```

## Calculated Fields in WHERE

You can also use calculations in WHERE:

```sql
SELECT *
FROM products
WHERE price * quantity > 1000;  -- Orders greater than $1000
```

## Avoid Division by Zero

```sql
-- ❌ Can error if quantity = 0
SELECT revenue / quantity FROM sales;

-- ✅ Protection against division by zero
SELECT 
    CASE 
        WHEN quantity = 0 THEN 0
        ELSE revenue / quantity
    END as price_per_unit
FROM sales;
```

## Real-World Example: App Store

```sql
SELECT 
    guide_title,
    total_revenue,
    units_sold,
    total_revenue / units_sold as revenue_per_unit,
    (total_revenue / units_sold) * 0.7 as developer_cut,
    (total_revenue / units_sold) * 0.3 as platform_cut
FROM guides;
```

## Default Column Name

Without an alias, the name is the operation:

```sql
SELECT guides_revenue / guides_qty
FROM guides;
```

Column is named: `guides_revenue / guides_qty` (unclear)

Later we will see **aliases** (AS) to give them descriptive names.

## Calculated Fields with GROUP BY

```sql
SELECT 
    category,
    SUM(price * quantity) as total_revenue
FROM sales
GROUP BY category;
```

## Round Results

```sql
-- 2 decimal places
SELECT ROUND(price / quantity, 2)
FROM products;

-- No decimals
SELECT FLOOR(price / quantity)
FROM products;
```

## Multi-Line Query Format

For queries with many calculated fields, use a readable format:

```sql
SELECT 
    guides_title,
    guides_revenue,
    guides_qty,
    guides_revenue / guides_qty,
    guides_revenue * 0.7,
    guides_qty * 10
FROM guides;
```

## Real-World Applications

### E-commerce

```sql
SELECT 
    product_name,
    price,
    discount_percent,
    price - (price * discount_percent / 100) as final_price
FROM products;
```

### Finance

```sql
SELECT 
    account_id,
    principal,
    interest_rate,
    years,
    principal * POWER(1 + interest_rate, years) as future_value
FROM investments;
```

### Inventory

```sql
SELECT 
    product_id,
    stock_level,
    reorder_point,
    stock_level - reorder_point as days_until_reorder
FROM inventory;
```

## Calculated Fields with Functions

```sql
SELECT 
    order_date,
    total_amount,
    DATEDIFF(NOW(), order_date) as days_since_order,
    total_amount / DATEDIFF(NOW(), order_date) as revenue_per_day
FROM orders;
```

## Order of Operations

SQL follows standard mathematical order (PEMDAS):

1. **P**arentheses
2. **E**xponents
3. **M**ultiplication/**D**ivision (left to right)
4. **A**ddition/**S**ubtraction (left to right)

```sql
-- 5 + 3 * 2 = 11 (not 16)
SELECT 5 + 3 * 2;

-- (5 + 3) * 2 = 16
SELECT (5 + 3) * 2;
```

## Performance

Calculated fields are **efficient** because:
- They are calculated only for returned records
- They take up no disk space
- SQL is optimised for these operations

## When NOT to Use Calculated Fields

### 1. Very Complex Calculations

If the calculation is extremely complex, consider:
- Stored procedures
- Materialised views
- Calculate in the application

### 2. You Need to Index the Result

You cannot create indices on calculated fields (in most DBMS).

