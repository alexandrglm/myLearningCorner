# 11-517 SQL 17 - Unique Values (DISTINCT)

## What is DISTINCT?

**DISTINCT** filters out duplicates from the results of a query.

## Basic Syntax

```sql
SELECT DISTINCT column
FROM table;
```

## Simple Example

```sql
SELECT DISTINCT guides_title
FROM guides;
```

If there are 5 records with 3 different titles, it returns only 3 records (one for each unique title).

## DISTINCT with Multiple Columns

DISTINCT considers the **combination** of all specified columns:

```sql
SELECT DISTINCT guides_title, guides_users_id
FROM guides;
```

Returns unique records based on the combination of title AND user_id.

## Complete Example

Suppose these records:

| id | title    | users_id | revenue |
|----|----------|----------|---------|
| 1  | My Blog  | 1        | 500     |
| 2  | My Blog  | 2        | 1500    |
| 3  | My Blog  | 1        | 750     |

### Title Only

```sql
SELECT DISTINCT guides_title FROM guides;
```
Returns: 1 record (only "My Blog")

### Title + User ID

```sql
SELECT DISTINCT guides_title, guides_users_id FROM guides;
```
Returns: 2 records (My Blog/user1 and My Blog/user2)

### Title + User ID + Revenue

```sql
SELECT DISTINCT guides_title, guides_users_id, guides_revenue FROM guides;
```
Returns: 3 records (all are unique by the complete combination)

## How It Works

DISTINCT considers records duplicates when **ALL** the specified columns have the same values:

- If you specify 1 column: removes duplicates of that column
- If you specify 2 columns: removes duplicates of that combination
- And so on

## Practical Use

- Get a list of unique categories
- Find unique users who have performed an action
- List distinct values for filters
- Analyse data diversity

## Important

DISTINCT applies to **all columns** in the SELECT, not to individual columns. To get distinct values of individual columns separately, you would need multiple queries.
