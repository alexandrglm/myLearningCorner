# 11-547 SQL 47 - Indexes

- **Index**: Reference point for fast searches
- **Automatic**: Primary keys and foreign keys
- **Manual**: Frequently searched columns
- **Cost**: Slower writes
- **Rule**: Index what you search, not everything
- **Locking**: Default prevents inconsistencies

## What is an Index?

An **index** is a reference point that speeds up the search for records.

## Analogy: Searching Through Lines of Text

### Without Index
```
Post 1
Post 2
Post 3
...
Post 317 <- "What I am really looking for"
```

MySQL checks **line by line** until it finds the record. With 5 million posts, it's very slow.

### With Index
```
1: Post 1
2: Post 2
3: Post 3
...
317: "What I am really looking for"
```

You can jump directly to record 317. Much faster.

## Default Indexes

MySQL Workbench creates indexes automatically:

### 1. Primary Key
```
addresses_id (PRIMARY, UNIQUE)
```

### 2. Foreign Keys
```
addresses_users_id (INDEX)
```

JOINs would be slow without an index on foreign keys.

## View Indexes

In MySQL Workbench:
1. Click on table
2. Click on inspection icon
3. Tab "Indexes"

## Create Manual Index

For columns that are searched frequently (e.g.: postal_code):

1. Select column
2. "Create index for selected columns"
3. Choose options:
   - **Algorithm**: Default (fine)
   - **Locking**: Default (allows concurrency)
   - **Type**: Non-unique (for most cases)
4. Create

## Types of Indexes

- **Non-unique**: Values can repeat
- **Unique**: Values are unique (like email)
- **Full-text**: For search engines

## Locking

**Locking** prevents inconsistencies when multiple users access simultaneously.

**Example**: 
- User A changes address from NY to AZ
- User B queries how many in NY
- Without locking: inconsistent data

Default locking is appropriate for most cases.

## Why Not Index Everything?

**Common question**: If indexes speed up queries, why not index all columns?

**Answer**: Indexes have a cost:
- Every INSERT/UPDATE must update the table **and** all indexes
- Many indexes = slow writes
- Trade-off: fast reads vs slow writes

## When to Use Indexes

### ✅ Index

- Primary keys (automatic)
- Foreign keys (automatic)
- Frequently searched columns (email, postal_code)
- Common WHERE columns

### ❌ Don't Index

- Columns never searched
- Small tables
- Columns that change constantly

## Golden Rule

Index columns that **you query frequently**, not columns that **you update frequently**.

## Performance

**With index**: Fast search (logarithmic)
**Without index**: Slow search (linear)

