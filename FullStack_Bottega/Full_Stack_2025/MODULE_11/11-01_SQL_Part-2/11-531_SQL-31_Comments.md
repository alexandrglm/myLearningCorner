# 11-531 SQL 31 - Comments in SQL

## Details


1. **Two syntaxes**: `--` and `#` for comments
2. **Shortcut**: Command/Ctrl + / to toggle
3. **Danger**: Comments become outdated
4. **Best Practice**: Minimise comments, keep necessary ones updated
5. **Rule**: If you change code, update comment
6. **Prefer**: Self-explanatory code over extensive comments

---

## Types of Comments
### 1. Single-Line Comments (--)

```sql
-- This is a single-line comment
-- This is another comment

SELECT addresses_state, COUNT(addresses_state)
FROM addresses
GROUP BY addresses_state;
```

### 2. Extended Multi-Line Comments

```sql
-- This is a summary report
-- to count states by city
SELECT addresses_state, COUNT(addresses_state)
FROM addresses
GROUP BY addresses_state;
```

### 3. Inline Comments with Hash (#)

```sql
SELECT guides_users_id, SUM(guides_revenue)
FROM guides  # For the guides table
GROUP BY guides_users_id;
```

## Syntax

### Double Dash (--)

```sql
-- Comment here
SELECT * FROM users;  -- Can also go at the end of the line
```

### Hash (#)

```sql
# Comment with hash
SELECT * FROM users;  # Inline comment
```

### Block Comments (/* */)

```sql
/*
This is a comment
spanning multiple lines
using block syntax
*/
SELECT * FROM users;
```

## Shortcut in MySQL Workbench

To comment/uncomment multiple lines:
- **Mac**: Command + /
- **Windows/Linux**: Ctrl + /

Select the lines and press the shortcut to toggle comments.

## ⚠️ Danger of Comments

### The Problem: Code Changes, Comments Don't

```sql
-- This script counts states
SELECT addresses_city, COUNT(addresses_city)  -- Wrong!
FROM addresses
GROUP BY addresses_city;
```

The comment says "states" but the code counts **cities**.

## Golden Rule: Code Changes, Comments Don't

**Common problem**:
- You write detailed comments
- You change the code later
- **You forget to update the comments**
- The comments now lie about what the code does

### Example of Obsolete Comment

```sql
-- This script deletes inactive users
DELETE FROM users
WHERE last_login < '2020-01-01'
AND premium = false;  -- Wait, now it also deletes premium users?
```

## Best Practices

### 1. Minimise Comments

**Prefer self-explanatory code**:

```sql
-- ❌ Needs comment
SELECT u.id, COUNT(*)  -- Count orders by user
FROM users u
JOIN orders o ON u.id = o.user_id
GROUP BY u.id;

-- ✅ Clear code without comment
SELECT 
    user_id,
    COUNT(*) as total_orders
FROM orders
GROUP BY user_id;
```

### 2. If You Comment, Keep It Updated

**Rule**: If you change the code, ALWAYS update the comment.

### 3. Comment the "Why", Not the "What"

```sql
-- ❌ Bad: explains the obvious
-- Select all users
SELECT * FROM users;

-- ✅ Good: explains the why
-- Users with premium expired more than 30 days ago
-- to send them renewal email
SELECT * FROM users
WHERE premium_expires < DATE_SUB(NOW(), INTERVAL 30 DAY);
```

### 4. Use Comments for Complex Scripts

```sql
-- Revenue report by user for Q1 2025
-- Excludes test users (email contains 'test')
-- Groups by month for trend analysis
SELECT 
    DATE_FORMAT(order_date, '%Y-%m') as month,
    user_id,
    SUM(total) as monthly_revenue
FROM orders
WHERE order_date BETWEEN '2025-01-01' AND '2025-03-31'
AND user_id NOT IN (SELECT id FROM users WHERE email LIKE '%test%')
GROUP BY DATE_FORMAT(order_date, '%Y-%m'), user_id;
```

## When to Use Comments

### ✅ Good Use Cases

1. **Explain complex business logic**
   ```sql
   -- Apply 15% discount for customers with over 10 orders
   -- per business policy established in Q4 2024
   ```

2. **Document non-obvious decisions**
   ```sql
   -- Using CAST because legacy data has revenue as VARCHAR
   ```

3. **Sections of long scripts**
   ```sql
   -- ============ STEP 1: Clean data ============
   -- ============ STEP 2: Calculate metrics ============
   -- ============ STEP 3: Generate report ============
   ```

4. **Important warnings**
   ```sql
   -- ⚠️ WARNING: This query may take 2-3 minutes in production
   -- ⚠️ DO NOT RUN IN PRODUCTION WITHOUT BACKUP
   ```

### ❌ Bad Use Cases

1. **Explain basic SQL syntax**
   ```sql
   -- Select from the users table
   SELECT * FROM users;
   ```

2. **Redundant comments**
   ```sql
   -- Count the users
   SELECT COUNT(*) FROM users;
   ```

3. **Comments that become obsolete quickly**
   ```sql
   -- Returns 500 users  ← This changes constantly
   ```

## Legacy Applications

In old applications, obsolete comments cause:
- **Confusion**: The comment says one thing, the code does another
- **Bugs**: Developers trust incorrect comments
- **Wasted time**: Investigating why the code doesn't do what the comment says

### Real Example

```sql
-- This script updates prices of products on sale
UPDATE products
SET price = price * 0.8
WHERE category = 'Electronics'
AND stock > 100;  -- And the sale code? Obsolete comment
```

## Philosophy of Comments

**"The best comment is code that doesn't need comments"**

Prefer:
- Descriptive variable names
- Well-structured queries
- Self-explanatory code

Over:
- Extensive comments that go out of date

## Comparative Example

### ❌ With Many Comments (prone to becoming outdated)

```sql
-- Select user
-- From the users table
-- Where the id is 5
SELECT *
FROM users
WHERE users_id = 5;
```

### ✅ Clean Code (self-explanatory)

```sql
SELECT *
FROM users
WHERE users_id = 5;
```

### ✅ Useful Comment (explains "why")

```sql
-- User 5 is the test account for QA
-- Do not delete or modify
SELECT *
FROM users
WHERE users_id = 5;
```

