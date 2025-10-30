# 11-512 SQL 12 - Query All Records (SELECT)

## Basic SELECT Syntax

```sql
SELECT * FROM users;
```

## Why is SELECT * a Bad Practice?

Although it works, **using `SELECT *` is not recommended**:

1. **Performance issues**: It brings all data from all columns
2. **Can crash the system** with large volumes of data (millions of records)
3. **Lack of clarity**: It is not clear what data is being returned
4. **Maintainability**: You have to check the schema to know what columns exist

## Specifying Columns

### Single column
```sql
SELECT users_name FROM users;
```

### Multiple columns
```sql
SELECT users_name, users_email FROM users;
```

## Advantages of Specifying Columns

- **Better performance**: It only brings the necessary data
- **Clearer**: You can see exactly what data is being returned
- **Better documentation**: Other developers (or yourself in the future) know what values are available
- **Avoids confusion**: When using `*`, columns like `guides_id` and `guides_users_id` can look similar

## Running Queries in MySQL Workbench

- **Without selection**: Executes all queries in the script
- **With selection (highlight)**: Executes only the selected query
- Each query returns a results tab

## Example of Multiple Queries

```sql
USE devcamp_sql_course_schema;

SELECT users_name, users_email FROM users;
SELECT * FROM addresses;
SELECT * FROM guides;
```

## Note on Foreign Keys

- `guides_users_id` is a foreign key, it is not the same as `guides_id`
- Using `SELECT *` can be confusing when seeing similar IDs that have different purposes
