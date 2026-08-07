# 11-548 SQL 48 - Database Normalisation

## What is Normalisation?

**Normalisation** is a set of best practices for building efficient and well-modelled databases.

## Example: "Ugly Table" (Poorly Designed Table)

```
ugly_table:
id | username | user_email | street_one | street_two | City | state | zip | Status
```

### Problems

1. **Duplicate data**: If a user has 2 addresses, username and email are duplicated
2. **Complex updates**: Changing name requires updating multiple rows
3. **Problematic authentication**: Duplicate email doesn't work for login

## Principle 1: One Table, One Purpose

### ❌ Bad (Everything in one table)
```
users_and_addresses:
id | username | email | street | city | state
```

### ✅ Good (Separate tables)
```
users:
users_id | users_name | users_email

addresses:
addresses_id | addresses_street | addresses_users_id (FK)
```

## Principle 2: Appropriate Data Types

### ❌ Bad: Status as VARCHAR
```
Status VARCHAR(45)  -- "active", "inactive", "suspended"
```

Problems:
- Slow searches
- Possible typos ("activ", "Active")
- Uses more space

### ✅ Good: Status as INT
```
status INT  -- 0=active, 1=inactive, 2=suspended
```

Advantages:
- Fast searches
- No typos
- Less space
- Use CASE for readable reports

## Principle 3: Validations and Constraints

### ❌ Bad: No constraints
```
email VARCHAR(255)  -- Can be NULL, duplicate
```

### ✅ Good: With constraints
```
email VARCHAR(255) NOT NULL UNIQUE
```

Ensures data integrity.

## Principle 4: Consistent Naming

### ❌ Bad: Mixed styles
```
username         -- snake_case
user_email       -- snake_case
streetTwo        -- camelCase
City             -- PascalCase
state            -- lowercase
```

### ✅ Good: Uniform style
```
users_name       -- consistent snake_case
users_email
addresses_street_two
addresses_city
addresses_state
```

## Real Problem: Tables with 50-60 Columns

In unnormalised legacy applications:
- Difficult to maintain
- Duplicate data
- Millions of records to migrate
- Nightmare to clean up

## Solution: Foreign Keys

Instead of duplicating data, use relationships:

```sql
-- User with 2 addresses
users:
1 | John | john@test.com

addresses:
1 | 123 Main St | 1 (FK to users)
2 | 456 Oak Ave | 1 (FK to users)
```

JOIN to get everything together.

## Validations: Application vs Database

**In frameworks** (Rails, etc.): Application validations are OK

**Pure database**: ALWAYS validate in DB for integrity

## Normalisation and Performance

Normalised tables:
- Less duplication = less space
- Simpler updates
- Queries with JOINs (learnt in course)

## Summary of Normalisation

1. **Separate concepts**: One table per entity
2. **Correct types**: INT for status/flags, not VARCHAR
3. **Constraints**: NOT NULL, UNIQUE where appropriate
4. **Consistent naming**: One style throughout the DB
5. **Avoid duplication**: Use foreign keys and JOINs

## When to Normalise

- When designing DB from scratch
- When detecting duplicate columns
- When having tables with 10+ unrelated columns
- When seeing repeated patterns

## Best Practice

Think about normalisation **from the start** of design. It's much easier than normalising later with millions of records.
