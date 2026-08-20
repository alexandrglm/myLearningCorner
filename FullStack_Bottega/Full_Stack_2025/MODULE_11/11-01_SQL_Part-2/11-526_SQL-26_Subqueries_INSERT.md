# 11-526 SQL 26 - Subqueries in INSERT

## The Problem

When inserting a record with a foreign key, you need to know the ID:

```sql
INSERT INTO guides(guides_title, guides_users_id)
VALUES('Guide by John', 2006);  -- How do we know it's 2006?
```

**Problems:**
- You must manually search for the ID before inserting
- In a database with thousands of users, it's impractical
- Prone to human error
- Not dynamic

## The Solution: Subquery in INSERT

```sql
INSERT INTO guides(guides_revenue, guides_title, guides_users_id, guides_qty)
VALUES(
    500,
    'Guide by John',
    (SELECT users_id FROM users WHERE users_name = 'John' LIMIT 1),
    300
);
```

## How It Works

1. **SQL executes the subquery first**:
   ```sql
   SELECT users_id FROM users WHERE users_name = 'John' LIMIT 1
   ```
   Returns: `2006`

2. **The value is injected into the INSERT**:
   ```sql
   VALUES(500, 'Guide by John', 2006, 300)
   ```

3. **The complete record is inserted**

## Anatomy of INSERT with Subquery

```sql
INSERT INTO table(column1, column2, column_fk, column3)
VALUES(
    'hardcoded_value',
    'another_value',
    (SELECT id FROM another_table WHERE condition LIMIT 1),  -- Subquery
    'final_value'
);
```

## Example Step by Step

### Step 1: Insert User

```sql
INSERT INTO users(users_name, users_email)
VALUES('John', 'john@snow.com');
```

### Step 2: Insert Guide with Subquery

```sql
INSERT INTO guides(guides_revenue, guides_title, guides_users_id, guides_qty)
VALUES(
    500,
    'Guide by John',
    (SELECT users_id FROM users WHERE users_email = 'john@snow.com' LIMIT 1),
    300
);
```

## LIMIT 1 in the Subquery

**Important**: Always use `LIMIT 1` when the subquery must return a single value:

```sql
(SELECT users_id FROM users WHERE users_name = 'John' LIMIT 1)
```

This ensures only one ID is returned, even if there are multiple matches.

## Search by Unique Values

In production, search by **unique** values rather than names:

```sql
-- ❌ Not recommended (there may be multiple "Johns")
WHERE users_name = 'John'

-- ✅ Recommended (email is unique)
WHERE users_email = 'john@snow.com'
```

## Mixing Hardcoded and Dynamic Values

You can combine:
- **Hardcoded values**: `500`, `'Guide by John'`, `300`
- **Dynamic values**: The subquery finds the user_id

```sql
VALUES(
    500,                    -- Hardcoded
    'Guide by John',        -- Hardcoded
    (SELECT ...),           -- Dynamic
    300                     -- Hardcoded
)
```

## Verify the Result

```sql
SELECT * FROM guides
ORDER BY guides_id DESC
LIMIT 5;
```

Verify that the guide was inserted with the correct user_id.

## Practical Use Cases

### Create Order for a User

```sql
INSERT INTO orders(order_date, user_id, total)
VALUES(
    NOW(),
    (SELECT users_id FROM users WHERE users_email = 'customer@email.com'),
    150.00
);
```

### Assign Product to Category

```sql
INSERT INTO products(product_name, category_id, price)
VALUES(
    'Laptop',
    (SELECT category_id FROM categories WHERE category_name = 'Electronics'),
    999.99
);
```

### Link Comment to Post

```sql
INSERT INTO comments(comment_text, post_id, user_id)
VALUES(
    'Great post!',
    (SELECT post_id FROM posts WHERE post_slug = 'my-first-post'),
    (SELECT user_id FROM users WHERE username = 'johndoe')
);
```

## Multiple Subqueries in an INSERT

You can use several subqueries:

```sql
INSERT INTO orders(user_id, product_id, quantity)
VALUES(
    (SELECT user_id FROM users WHERE email = 'user@test.com'),
    (SELECT product_id FROM products WHERE sku = 'PROD-123'),
    5
);
```

## Advantages in Production

1. **No manual searches needed**: SQL finds the ID automatically
2. **Less error-prone**: No chance of copying the wrong ID
3. **More dynamic**: Works even if IDs change
4. **Cleaner code**: Everything in one operation
5. **More professional**: Appropriate for production systems

## Common Error: Multiple Results

```sql
-- ❌ ERROR if there are multiple Johns
(SELECT users_id FROM users WHERE users_name = 'John')

-- ✅ CORRECT - only takes the first one
(SELECT users_id FROM users WHERE users_name = 'John' LIMIT 1)
```

Without LIMIT 1, if the subquery returns multiple values, the INSERT will fail.

## Note on guides_qty

If your guides table does not have the `guides_qty` column, simply omit it:

```sql
INSERT INTO guides(guides_revenue, guides_title, guides_users_id)
VALUES(
    500,
    'Guide by John',
    (SELECT users_id FROM users WHERE users_name = 'John' LIMIT 1)
);
```

## Best Practices

1. **Always use LIMIT 1** in subqueries that must return a single value
2. **Search by unique values** (email, username, etc.)
3. **Verify afterwards** with SELECT that it inserted correctly
4. **Use transactions** (BEGIN/ROLLBACK) when inserting critical data

## Importance in Production

Subqueries in INSERT are **essential** in production environments where:
- IDs change constantly
- You have thousands or millions of records
- You need automation
- Data is dynamic

This pattern is used constantly in real applications, reports, and maintenance scripts.
