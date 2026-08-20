# 10-509 SQL 09 - Data Types MySQL/MariaDB

***

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/sql-data-types)

[Material PDF](../../../../../inProgress/Basque-DevCamp/Full_Stack_2025/MODULE_10/12-SQL_PART-1/deep-dive-sql-data-types.pdf)

***

## Data Types in SQL

Comprehensive exploration of SQL data types - correct selection according to each use case.

## Complete List of Data Types

`CHAR`, `VARCHAR`, `BOOLEAN`, `SMALLINT`, `INT`, `DECIMAL`, `FLOAT`, `DATETIME`, `CLOB`, `BLOB`

## CHAR - Character

### Features

* Fixed-length string - always takes the defined space
* Reserves entire memory
* Range: 1-255 characters

### Proper Use

```sql
phone_number    CHAR(10)    -- '5551234567'
ssn             CHAR(9)     -- '123456789'
state_code      CHAR(2)     -- 'AZ'
```

Use when: Exact length is known.

### Improper Use

```sql
name    CHAR(50)    -- wastes memory if name is short
age     CHAR(3)     -- 42 is NOT a string
```

## VARCHAR - Variable Character

### Features

* Variable-length string - adjusts dynamically
* Dynamic memory - only uses necessary space
* Range: 1-65,535 characters
* Slightly slower than CHAR

### Proper Use

```sql
email           VARCHAR(80)
username        VARCHAR(50)
description     VARCHAR(500)
```

Use when: Variable or unknown length.

### Improper Use

```sql
phone       VARCHAR(10)    -- better as CHAR(10)
age         VARCHAR(3)     -- 42 is integer
active      VARCHAR(10)    -- 'true' better as BOOLEAN
```

## BOOLEAN

### Features

* True/False only
* Valid values: `true`, `false`, `TRUE`, `FALSE`

### Proper Use

```sql
is_active       BOOLEAN    -- true
is_archived     BOOLEAN    -- FALSE
has_premium     BOOLEAN    -- true
```

### Improper Use

```sql
status    BOOLEAN    -- 1 (not valid)
active    BOOLEAN    -- 'yes' (not valid)
flag      BOOLEAN    -- 0 (not valid)
```

## SMALLINT

### Features

* Range: -32,768 to 32,768
* Automatically truncates decimals

### Proper Use

```sql
age             SMALLINT    -- 42
quantity        SMALLINT    -- -150
year_offset     SMALLINT    -- 2024
```

Note: 42.5 becomes 42 (automatically truncated)

### Improper Use

```sql
population    SMALLINT    -- 50000 (out of range)
price         SMALLINT    -- 19.99 becomes 19
```

## INT - Integer

### Features

* Range: -2,147,483,648 to 2,147,483,648
* Popular for IDs and large counts

### Proper Use

```sql
users_id        INT    -- 1,234,567
views_count     INT    -- 9,876,543
population      INT    -- 3,500,000
```

### Improper Use

```sql
price       INT    -- 42.99 becomes 42
name        INT    -- 'John' not valid
```

## DECIMAL

### Features

* Exact precision - critical for finance
* Syntax: `DECIMAL(precision, scale)`
  * precision: total digits
  * scale: digits after the decimal

### Proper Use

```sql
price           DECIMAL(10, 2)    -- 99999999.99
salary          DECIMAL(8, 2)     -- 123456.78
tax_rate        DECIMAL(5, 4)     -- 9.8340
```

Examples:

* `DECIMAL(4, 3)` returns 9.834
* `DECIMAL(7, 2)` returns 42215.85

### Improper Use

```sql
huge_number    DECIMAL(50, 2)    -- Maximum 38 digits
```

Use for: Money, exact financial calculations.

## FLOAT

### Features

* Approximation - NOT exact
* Giant numbers - up to 1.79 × 10^308
* Faster than DECIMAL

### Proper Use

```sql
scientific_data     FLOAT
large_calculations  FLOAT
coordinates         FLOAT
```

### Improper Use

```sql
account_balance    FLOAT    -- use DECIMAL
price              FLOAT    -- use DECIMAL
```

Important Issue: 9.5 may be stored as 9.4999999

```sql
SELECT * FROM table WHERE value = 9.5;  -- may fail
```

Never use for money or exact values.

## DATETIME

### Features

* Range: 1753-01-01 to 9999-12-31
* Format: `YYYY-MM-DD HH:MM:SS.fraction`

### Proper Use

```sql
created_at      DATETIME    -- '2025-01-15 14:30:45'
updated_at      DATETIME    -- '2024-12-01 00:00:00'
login_time      DATETIME    -- '2025-10-06 09:15:30.123'
```

### Improper Use

```sql
birth_date    DATETIME    -- '01-15-2025' (incorrect format)
timestamp     DATETIME    -- 1704067200 (not valid)
event_date    DATETIME    -- 'Jan 15, 2025' (not valid)
```

Variants:

* `DATE` - date only
* `TIME` - time only
* `DATETIME` - both

## CLOB - Character Large Object

### Features

* Up to 2 GB of text
* Rarely used

### Proper Use

```sql
full_book_text      CLOB
massive_document    CLOB
```

### Improper Use

```sql
blog_post       CLOB    -- VARCHAR is enough
description     CLOB    -- VARCHAR(500) is better
```

Use only if: Text > 65,535 characters.

## BLOB - Binary Large Object

### Features

* Up to 2 GB of binary data
* Stores images directly in DB

### Proper Use

```sql
profile_image       BLOB
pdf_document        BLOB
binary_file         BLOB
```

### Improper Use

```sql
image_path    VARCHAR(255)    -- 'https://cdn.com/img.jpg' (better practice)
```

Note: Nowadays, storing URLs is preferred over direct files.

## Quick Selection Guide

### Text

* Fixed known length → `CHAR`
* Variable length → `VARCHAR`
* Massive text → `CLOB`

### Numbers

* Small integers → `SMALLINT`
* Normal integers → `INT`
* Money/finance → `DECIMAL`
* Scientific/approximate → `FLOAT`

### Others

* True/False → `BOOLEAN`
* Dates/times → `DATETIME`
* Binary files → `BLOB`

## Practical Examples

### Users Table

```sql
users_id            INT
username            VARCHAR(50)
email               VARCHAR(80)
age                 SMALLINT
is_active           BOOLEAN
created_at          DATETIME
profile_picture     BLOB
```

### Products Table

```sql
product_id          INT
name                VARCHAR(100)
price               DECIMAL(10, 2)
stock_quantity      SMALLINT
weight              FLOAT
in_stock            BOOLEAN
```

### Financial Table

```sql
transaction_id      INT
amount              DECIMAL(12, 2)    -- NEVER FLOAT
tax                 DECIMAL(5, 4)
account_balance     DECIMAL(15, 2)
timestamp           DATETIME
```

## Common Mistakes

### FLOAT for Money

```sql
-- BAD
price    FLOAT

-- GOOD
price    DECIMAL(10, 2)
```

### VARCHAR for Numbers

```sql
-- BAD
age      VARCHAR(3)

-- GOOD
age      SMALLINT
```

### INT with Decimals

```sql
-- BAD: 42.99 becomes 42 (truncated)
price    INT

-- GOOD
price    DECIMAL(6, 2)
```

***
