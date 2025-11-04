# 11-511 SQL 11 - Insert Records (INSERT INTO)

## Seed Script

A **seed script** is a script that populates the database with test data so you can make queries and learn SQL.

## Considerations When Populating the Database

- **Insertion order**: You must be careful with foreign keys. You cannot insert an address or guide without having a user associated first.
- Start with tables that do not have dependencies (foreign keys).

## Selecting the Schema

Before inserting data, you must specify which schema to use:

```sql
USE devcamp_sql_course_schema;
```

## INSERT INTO Syntax

```sql
INSERT INTO table(column1, column2)
VALUES (value1, value2);
```

### Characteristics

- **INSERT INTO** is the command (in uppercase by convention, but not mandatory)
- SQL commands are written in uppercase by convention to differentiate them from column names
- It is not necessary to include the ID if it is auto-incrementing
- The order of the specified columns determines the order of the values

## Complete Example

```sql
INSERT INTO users(users_name, users_email)
VALUES ("Kristine", 'kristine@test.com');
```

## Column Mapping

When specifying columns, you do not need to follow the table order:

```sql
-- The order in the table might be: id, revenue, users_id, title
-- But we can insert like this:
INSERT INTO guides(guides_title, guides_users_id, guides_revenue)
VALUES ("My Blog", 1, 500);
```

## Hardcoded IDs in Seed Scripts

When you know which IDs will be generated, you can use them directly:

```sql
-- Knowing that users will have IDs 1, 2, 3
INSERT INTO addresses(addresses_users_id, ...)
VALUES (1, ...);
```

## Validations

- If there are constraints (such as unique emails), SQL will prevent duplicates
- Error messages are explicit and help identify problems

## Execution

- It is executed with the "lightning bolt" button
- A blue dot indicates correct syntax
- A red box indicates a syntax error
- SQL returns how many rows were affected by each operation
