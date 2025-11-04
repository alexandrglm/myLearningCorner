# 11-522 SQL 22 - Searches with Wildcards (LIKE)

## What is a Wildcard?

A **wildcard** allows you to search for patterns within strings, not just exact matches.

## LIKE Syntax

```sql
SELECT * FROM table
WHERE column LIKE 'pattern';
```

## The % (Percentage) Operator

**%** represents zero or more characters in any position.

### Complete Search (Contains)

```sql
SELECT * FROM guides
WHERE guides_title LIKE '%my%';
```

- Searches for the word "my" in **any part** of the string
- `%` at the start: anything can come before
- `%` at the end: anything can come after

**Examples that match:**
- "My Blog"
- "Another One of my Posts"
- "Something my thing"

### Starts With

```sql
SELECT * FROM guides
WHERE guides_title LIKE 'My%';
```

Only matches if the string **starts with** "My".

**Examples that match:**
- "My Blog"
- "My Great Post"

**Does not match:**
- "Another One of my Posts"

### Ends With

```sql
SELECT * FROM guides
WHERE guides_title LIKE '%my';
```

Only matches if the string **ends with** "my".

## NOT LIKE

Searches for records that **do not** match the pattern:

```sql
SELECT * FROM guides
WHERE guides_title NOT LIKE '%My%';
```

Returns all titles that do not contain "My".

## Case Insensitive

By default, LIKE is **case insensitive** in MySQL:
- `'%my%'` matches "My", "MY", "my"

## Common Patterns

```sql
-- Contains "word" anywhere
LIKE '%word%'

-- Starts with "word"
LIKE 'word%'

-- Ends with "word"
LIKE '%word'

-- Exactly "word" (no wildcards)
LIKE 'word'

-- Second character is 'a'
LIKE '_a%'
```

## The _ (Underscore) Operator

**_** represents exactly **one** character:

```sql
-- Titles of exactly 5 characters
LIKE '_____'

-- Starts with any letter followed by 'y'
LIKE '_y%'
```

## Practical Use Cases

### User Search

```sql
-- Gmail emails
SELECT * FROM users
WHERE users_email LIKE '%@gmail.com';

-- Names starting with 'Mar'
SELECT * FROM users
WHERE users_name LIKE 'Mar%';
```

### Filter Products

```sql
-- Products containing "laptop"
SELECT * FROM products
WHERE product_name LIKE '%laptop%';
```

### Content Search

```sql
-- Posts mentioning "SQL"
SELECT * FROM posts
WHERE content LIKE '%SQL%';
```

## Most Common Use

The **most commonly used** pattern is `'%word%'` because it allows flexible searches within strings, similar to a "search" or "find" function.

## Performance

LIKE with wildcards can be slow on large tables. For more complex text searches, consider using:
- Full-text search
- Specific indices
- External search services (Elasticsearch, etc.)
