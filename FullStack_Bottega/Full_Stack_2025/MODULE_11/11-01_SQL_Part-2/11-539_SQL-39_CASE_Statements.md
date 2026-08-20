# 11-539 SQL 39 - CASE Statements (Conditional Logic)

## What is CASE?

**CASE** is the way to implement conditional logic (if-else) in SQL. It allows you to evaluate conditions and return different values based on the result.

- **CASE**: Conditional if-else logic in SQL
- **Syntax**: CASE WHEN...THEN...ELSE...END
- **Alias required**: Always use AS
- **Format**: Indent for readability
- **Order matters**: First match wins
- **ELSE optional**: Without ELSE returns NULL
- **Use**: SELECT, WHERE, ORDER BY, UPDATE, GROUP BY
- **Powerful**: Transforms data without application logic

## Syntax

```sql
CASE 
    WHEN condition1 THEN result1
    WHEN condition2 THEN result2
    ELSE default_result
END
```

## Complete Example

```sql
SELECT 
    guides_title,
    CASE 
        WHEN guides_revenue > 1000 THEN 'Best Seller'
        WHEN guides_revenue < 600 THEN 'Not Displayed'
        ELSE 'Average Sellers'
    END AS 'status'
FROM guides;
```

## Result

| guides_title | status |
|-------------|--------|
| My Blog | Best Seller |
| Another Post | Not Displayed |
| Great Guide | Average Sellers |

## CASE Structure

### 1. CASE Keyword
Starts the conditional block.

### 2. WHEN ... THEN
Defines each condition and its result:
```sql
WHEN guides_revenue > 1000 THEN 'Best Seller'
```

### 3. ELSE
Default case (catch-all):
```sql
ELSE 'Average Sellers'
```

### 4. END
Closes the CASE block.

### 5. AS (Alias)
Names the calculated column:
```sql
END AS 'status'
```

## Readable Format

CASE statements should be formatted with indentation:

```sql
SELECT 
    guides_title,
    CASE 
        WHEN guides_revenue > 1000 THEN 'Best Seller'
        WHEN guides_revenue < 600 THEN 'Not Displayed'
        ELSE 'Average Sellers'
    END AS 'status'
FROM guides;
```

**Why format matters**:
- Easy to read
- Easy to debug
- Clear where each condition starts and ends

## Example Logic

```
If revenue > 1000     → "Best Seller"
If revenue < 600      → "Not Displayed"
Everything else       → "Average Sellers"
   (between 600 and 1000)
```

## Order of Evaluation

CASE evaluates conditions **in order**:
1. Check first WHEN condition
2. If true, return that THEN
3. If false, move to next WHEN
4. If none match, return ELSE

### Important: First Match Wins

```sql
CASE 
    WHEN revenue > 500 THEN 'High'        -- Evaluated first
    WHEN revenue > 1000 THEN 'Very High'  -- Never reached
    ELSE 'Low'
END
```

If revenue = 1500, returns "High" (not "Very High") because the first condition already matched.

## ELSE is Optional

```sql
CASE 
    WHEN guides_revenue > 1000 THEN 'Best Seller'
    WHEN guides_revenue < 600 THEN 'Not Displayed'
END AS 'status'
```

Without ELSE, non-matching values return **NULL**.

## Practical Use Cases

### 1. Categorise Products by Price

```sql
SELECT 
    product_name,
    price,
    CASE 
        WHEN price < 50 THEN 'Budget'
        WHEN price < 200 THEN 'Mid-Range'
        ELSE 'Premium'
    END AS 'price_category'
FROM products;
```

### 2. Convert Status Codes to Text

```sql
SELECT 
    order_id,
    CASE 
        WHEN status = 0 THEN 'Pending'
        WHEN status = 1 THEN 'Processing'
        WHEN status = 2 THEN 'Shipped'
        WHEN status = 3 THEN 'Delivered'
        ELSE 'Unknown'
    END AS 'status_label'
FROM orders;
```

### 3. Age to Categories

```sql
SELECT 
    user_name,
    age,
    CASE 
        WHEN age < 18 THEN 'Minor'
        WHEN age < 65 THEN 'Adult'
        ELSE 'Senior'
    END AS 'age_group'
FROM users;
```

### 4. Discount Levels

```sql
SELECT 
    customer_name,
    total_purchases,
    CASE 
        WHEN total_purchases > 10000 THEN 0.20
        WHEN total_purchases > 5000 THEN 0.15
        WHEN total_purchases > 1000 THEN 0.10
        ELSE 0.05
    END AS 'discount_rate'
FROM customers;
```

### 5. Priority Flags

```sql
SELECT 
    ticket_id,
    CASE 
        WHEN urgency = 'critical' THEN 1
        WHEN urgency = 'high' THEN 2
        WHEN urgency = 'medium' THEN 3
        ELSE 4
    END AS 'priority'
FROM support_tickets
ORDER BY priority;
```

## CASE in Different Contexts

### In SELECT

```sql
SELECT 
    product_name,
    CASE 
        WHEN stock > 100 THEN 'In Stock'
        ELSE 'Low Stock'
    END AS 'availability'
FROM products;
```

### In WHERE

```sql
SELECT *
FROM orders
WHERE 
    CASE 
        WHEN priority = 'high' THEN total > 100
        ELSE total > 500
    END;
```

### In ORDER BY

```sql
SELECT *
FROM users
ORDER BY 
    CASE 
        WHEN role = 'admin' THEN 1
        WHEN role = 'moderator' THEN 2
        ELSE 3
    END;
```

### In UPDATE

```sql
UPDATE products
SET discount = 
    CASE 
        WHEN price > 1000 THEN 0.20
        WHEN price > 500 THEN 0.15
        ELSE 0.10
    END;
```

## CASE with Calculations

```sql
SELECT 
    product_name,
    price,
    CASE 
        WHEN category = 'electronics' THEN price * 1.15
        WHEN category = 'clothing' THEN price * 1.08
        ELSE price * 1.10
    END AS 'price_with_tax'
FROM products;
```

## Multiple Conditions in WHEN

```sql
SELECT 
    user_name,
    CASE 
        WHEN age < 18 AND country = 'US' THEN 'US Minor'
        WHEN age >= 18 AND country = 'US' THEN 'US Adult'
        WHEN country != 'US' THEN 'International'
        ELSE 'Unknown'
    END AS 'user_category'
FROM users;
```

## Nested CASE Statements (Advanced)

```sql
SELECT 
    product_name,
    CASE 
        WHEN category = 'electronics' THEN
            CASE 
                WHEN price > 1000 THEN 'Premium Electronics'
                ELSE 'Standard Electronics'
            END
        WHEN category = 'clothing' THEN 'Apparel'
        ELSE 'Other'
    END AS 'product_classification'
FROM products;
```

## CASE vs Application Logic

### ❌ In the Application (JavaScript)

```javascript
const orders = await db.query("SELECT * FROM orders");
orders.forEach(order => {
    if (order.total > 1000) {
        order.priority = 'High';
    } else if (order.total > 500) {
        order.priority = 'Medium';
    } else {
        order.priority = 'Low';
    }
});
```

### ✅ In SQL (CASE)

```sql
SELECT 
    *,
    CASE 
        WHEN total > 1000 THEN 'High'
        WHEN total > 500 THEN 'Medium'
        ELSE 'Low'
    END AS 'priority'
FROM orders;
```

**Advantages of CASE in SQL**:
- Faster (processed on server)
- Less code in application
- Data comes ready to use

## CASE with GROUP BY

```sql
SELECT 
    CASE 
        WHEN age < 25 THEN '18-24'
        WHEN age < 35 THEN '25-34'
        WHEN age < 50 THEN '35-49'
        ELSE '50+'
    END AS 'age_range',
    COUNT(*) AS 'users'
FROM users
GROUP BY 
    CASE 
        WHEN age < 25 THEN '18-24'
        WHEN age < 35 THEN '25-34'
        WHEN age < 50 THEN '35-49'
        ELSE '50+'
    END;
```

## CASE with Aggregate Functions

```sql
SELECT 
    category,
    SUM(CASE WHEN status = 'sold' THEN 1 ELSE 0 END) AS 'sold',
    SUM(CASE WHEN status = 'available' THEN 1 ELSE 0 END) AS 'available'
FROM products
GROUP BY category;
```

## Report with Multiple CASE Statements

```sql
SELECT 
    product_name,
    CASE 
        WHEN price < 100 THEN 'Budget'
        WHEN price < 500 THEN 'Mid'
        ELSE 'Premium'
    END AS 'price_tier',
    CASE 
        WHEN stock > 50 THEN 'High Stock'
        WHEN stock > 10 THEN 'Medium Stock'
        ELSE 'Low Stock'
    END AS 'stock_level',
    CASE 
        WHEN rating >= 4.5 THEN '★★★★★'
        WHEN rating >= 3.5 THEN '★★★★'
        ELSE '★★★'
    END AS 'rating_display'
FROM products;
```

## NULL Values in CASE

```sql
SELECT 
    user_name,
    CASE 
        WHEN email IS NULL THEN 'No Email'
        WHEN email = '' THEN 'Empty Email'
        ELSE email
    END AS 'email_display'
FROM users;
```

## Simple CASE vs Searched CASE

### Searched CASE (seen here)

```sql
CASE 
    WHEN condition1 THEN result1
    WHEN condition2 THEN result2
END
```

### Simple CASE

```sql
CASE column
    WHEN value1 THEN result1
    WHEN value2 THEN result2
END
```

Example:
```sql
SELECT 
    CASE status
        WHEN 0 THEN 'Inactive'
        WHEN 1 THEN 'Active'
        WHEN 2 THEN 'Suspended'
    END AS 'status_label'
FROM users;
```

## Best Practices

1. **Always use AS** to name the CASE column
2. **Format with indentation** for readability
3. **Include ELSE** when possible (avoid NULLs)
4. **Order conditions** from most to least specific
5. **Mutually exclusive conditions** to avoid confusion

## Common Errors

### ❌ Forget END

```sql
CASE 
    WHEN price > 100 THEN 'High'
-- Missing END
```

### ❌ Forget THEN

```sql
CASE 
    WHEN price > 100 'High'  -- Missing THEN
END
```

### ❌ Incorrect Order

```sql
CASE 
    WHEN price > 0 THEN 'Has Price'        -- Too general first
    WHEN price > 1000 THEN 'Expensive'     -- Never reached
END
```
