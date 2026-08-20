# 11-536 SQL 36 - Control Flow Introduction

## What is Control Flow?

**Control Flow** allows you to execute conditional logic in SQL:
- **If** a condition is true → do something
- **If not** → do something else

It is the equivalent of `if-else` in programming languages.

## Why Use Control Flow in SQL?

### Common Problem

You have a column with numeric values in the DB:
```
status
0  (active)
1  (inactive)
2  (suspended)
```

But you want to display descriptive text, not numbers.

### Solution: Control Flow

SQL can **process and transform** the data before returning it:

```sql
-- Instead of seeing: 0, 1, 2
-- You can see: "Active", "Inactive", "Suspended"
```

## CASE: The Main Tool

The **CASE statement** is the way to implement control flow in SQL.

### Conceptual Syntax

```sql
CASE 
    WHEN condition1 THEN result1
    WHEN condition2 THEN result2
    ELSE default_result
END
```

## Conceptual Example

### Data in the DB
```
user_id | status
1       | 0
2       | 1
3       | 0
```

### With CASE
```sql
SELECT 
    user_id,
    CASE 
        WHEN status = 0 THEN 'Active'
        WHEN status = 1 THEN 'Inactive'
        ELSE 'Unknown'
    END as status_label
FROM users;
```

### Result
```
user_id | status_label
1       | Active
2       | Inactive
3       | Active
```

## Common Use Cases

### 1. Transform Codes to Text

```sql
-- 0/1 → Yes/No
-- 0/1/2 → Low/Medium/High
-- Codes → Descriptions
```

### 2. Categorise Data

```sql
-- Prices → "Cheap", "Moderate", "Expensive"
-- Ages → "Child", "Teen", "Adult", "Senior"
-- Numeric ranges → Labels
```

### 3. Readable Reports

```sql
-- Integer flags → Descriptive text
-- States → Clear messages
-- Technical values → User-friendly format
```

## Advantages of Control Flow in SQL

### 1. Data Ready to Display

You don't need to process in the application:
```javascript
// ❌ Without CASE: process in code
users.forEach(user => {
    user.statusLabel = user.status === 0 ? 'Active' : 'Inactive';
});

// ✅ With CASE: SQL does it
// Data already comes formatted
```

### 2. Performance

SQL is faster at transforming data than your application code.

### 3. Simplicity

One query does everything, no additional backend logic.

### 4. Reports

Perfect for generating ready-to-consume reports.

## Types of Control Flow

In this section we will learn:

### CASE Statements

- Transform values
- Categorise data
- Complex conditional logic

### IF/ELSE Logic

- Simple conditionals
- Validations
- Binary decisions

## Comparison with Programming Languages

### JavaScript
```javascript
if (status === 0) {
    return "Active";
} else if (status === 1) {
    return "Inactive";
} else {
    return "Unknown";
}
```

### SQL (CASE)
```sql
CASE 
    WHEN status = 0 THEN 'Active'
    WHEN status = 1 THEN 'Inactive'
    ELSE 'Unknown'
END
```

## Examples of Transformations

### Status Flags

```sql
-- 0 → "Active"
-- 1 → "Inactive"
-- 2 → "Suspended"
```

### Priority Levels

```sql
-- 1 → "High"
-- 2 → "Medium"
-- 3 → "Low"
```

### Boolean Values

```sql
-- 0 → "No"
-- 1 → "Yes"
```

### Numeric Ranges

```sql
-- 0-18 → "Minor"
-- 19-64 → "Adult"
-- 65+ → "Senior"
```

## Real-World Applications

### Admin Dashboard

Instead of showing cryptic codes, display clear text:
```
User Status: 0  →  User Status: Active
Payment: 2      →  Payment: Pending
```

### Executive Reports

```
Category: 3  →  Category: Premium
Tier: 1      →  Tier: Gold
Risk: 5      →  Risk: Critical
```

### Data Exports

CSVs and Excel with data already formatted for human reading.

## Flexibility

CASE can be used in:
- **SELECT**: Transform columns
- **WHERE**: Filter conditionally
- **ORDER BY**: Sort by complex logic
- **GROUP BY**: Group by dynamic categories

## When to Use Control Flow?

### ✅ Use Control Flow When:

- You need to transform codes to text
- You want to categorise numeric values
- Reports must be readable for humans
- Reduce logic in the application

### ❌ Don't Use If:

- Data is already in the correct format
- Transformation is too complex
- Better to do it in the application
