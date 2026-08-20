# 10-505: SQL_05_Creating_Table_MySQL_MariaDB

---
**[Original Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-create-table-mysql) - Adapted for Linux Debian + MariaDB**
---

## 🎯 Create First Table in MariaDB

Complete process to build **users** table with columns, data types, primary key and validations using **MySQL Workbench with MariaDB**.

**✅ Schema created** - now build table structure within workspace.

## 🛠️ Access Schema

### Connect and Navigate
1. **Open MySQL Workbench**
2. **Double-click** "MariaDB Local" connection
3. **Left panel "SCHEMAS"** - verify `devcamp_sql_course_schema`
4. **Click** schema name - expand to see structure

### Verify Initial State
```
devcamp_sql_course_schema/
└── Tables (empty)
```

**No tables yet** - we'll create the first.

## 📧 Create Table: GUI Method

### Step 1: Start Table Creation

#### Option 1: Top-Left Icon
**Find**: **"Create a new table in the active schema in connected server"**
- **Click** table icon
- **Requires** schema selected/active

#### Option 2: Right-Click (Recommended)
1. **Expand** `devcamp_sql_course_schema`
2. **Right-click** on "Tables"
3. **Select**: "Create Table..."

### Step 2: Configure Table Name

**Dialog box "new table"**:
```
Table Name: users
```

**Why "users"?**:
- **Plural** - standard convention (represents multiple records)
- **Descriptive** - clearly identifies content
- **No prefixes** - base table of system

**Not a real table yet** - needs columns defined before applying.

## 📋 Create Columns and Data Types

### Concept: What are Columns?

**Columns = fields of the table**:
- **Similar to Excel** - vertical structure
- **Define what data** to store in each record
- **Require type** - can't put any data

### Column 1: users_id (Primary Key)

#### Configure Primary Key
**Click** on `<click to edit>` first row:

```
Column Name: users_id
Datatype: INT
```

**Options to select**:
- ✅ **PK** (Primary Key) - unique identifier
- ✅ **NN** (Not Null) - never empty
- ✅ **AI** (Auto Increment) - increments automatically
- ✅ **UQ** (Unique) - always unique values

**Lower right panel confirms**:
```
Primary Key: ✓
Not Null: ✓
Auto Increment: ✓
Unique: ✓
```

#### Why Primary Key?

**Need for unique identifier**:
- **Two users "Jordan Hudgens"** - how to differentiate them?
- **Email addresses** - can change
- **Integer ID** - never changes, always unique

**Advantages of INT as Primary Key**:
- **Fast indexing** - much faster than VARCHAR
- **Auto-increment** - generates values automatically
- **Efficient relationships** - connect tables by ID

**Auto-increment system**:
- **User 1**: `users_id = 1`
- **User 2**: `users_id = 2`
- **User 3**: `users_id = 3`

### Column 2: users_name

#### Configure Name Field
**Second row**:

```
Column Name: users_name
Datatype: VARCHAR(100)
```

**Options**:
- ❌ **PK** - not primary key
- ❌ **NN** - allow creating user without name
- ❌ **UQ** - names can repeat

**VARCHAR(100)**:
- **Variable Character** - variable length string
- **100 characters max** - reasonable limit for names
- **Flexible** - adjusts space according to content

### Column 3: users_email

#### Configure Email Field
**Third row**:

```
Column Name: users_email
Datatype: VARCHAR(80)
```

**Options**:
- ❌ **PK** - not primary key
- ✅ **NN** (Not Null) - email mandatory
- ✅ **UQ** (Unique) - don't allow duplicate emails

**Why these validations?**:
- **Not Null** - user must have email for login
- **Unique** - prevent duplicate accounts
- **80 characters** - standard email length

**Business logic**:
- **Login via email** - requires unique email
- **Two users same email** - impossible to distinguish
- **Validation at DB level** - guarantees integrity

## 🎨 Data Types: Fundamental Concept

### Why Data Types?

**MySQL needs to know what data type to store**:
- **Validation** - prevent incorrect data
- **Performance** - optimise storage
- **Calculations** - correct mathematical operations

### Example: Consequence of Wrong Data Type

**Scenario**:
```
Sales table with "amount" column
Datatype: DECIMAL

Someone enters: "John Doe" in amount
```

**Problem if you try**:
```sql
SELECT SUM(amount) FROM sales;
```

**Error**: Can't add numbers + name.

**Prevention**: MySQL **rejects** inserting "John Doe" into DECIMAL column.

### Main Data Types

**Numeric**:
- **INT** - integers (-2147483648 to 2147483647)
- **DECIMAL** - numbers with precise decimals
- **FLOAT/DOUBLE** - numbers with approximate decimals

**Text**:
- **VARCHAR(n)** - variable length strings up to n
- **TEXT** - long texts without specific limit
- **CHAR(n)** - fixed length strings exactly n

**Others**:
- **DATE** - dates (YYYY-MM-DD)
- **DATETIME** - date and time
- **BOOLEAN** - true/false

## 📧 Final Table Structure

### Summary of Columns Defined

```
users
├── users_id      INT          PK, NN, AI, UQ
├── users_name    VARCHAR(100)
└── users_email   VARCHAR(80)  NN, UQ
```

**Naming convention**:
- **Table prefix** - `users_id`, `users_name`, `users_email`
- **Snake_case** - underscores between words
- **Descriptive** - clarity about content

## 📋 Indexes (Basic Concept)

### What are Indexes?

**"Indexes" tab in dialog box**:
- **PRIMARY** - automatic index on `users_id`
- **users_email_UNIQUE** - index on email for being unique

**Function of indexes**:
- **Rapid queries** - searches much faster
- **Optimisation** - MySQL finds data efficiently
- **Automatic** - created automatically with PK and UQ

**Don't modify now** - deep dive in later guides.

## 🚀 Apply Table Creation

### Step 1: Review SQL Script

**Click "Apply"**:
```
Review the SQL script to be applied to the database
```

**Generated SQL**:
```sql
CREATE TABLE `devcamp_sql_course_schema`.`users` (
  `users_id` INT NOT NULL AUTO_INCREMENT,
  `users_name` VARCHAR(100) NULL,
  `users_email` VARCHAR(80) NOT NULL,
  PRIMARY KEY (`users_id`),
  UNIQUE INDEX `users_id_UNIQUE` (`users_id` ASC),
  UNIQUE INDEX `users_email_UNIQUE` (`users_email` ASC)
);
```

**Elements of SQL**:
- **CREATE TABLE** - main command
- **Schema.table** - full location
- **Column definitions** - types and constraints
- **PRIMARY KEY** - PK definition
- **UNIQUE INDEX** - automatic indexes

### Step 2: Execute Script

**Click "Apply"**:
- **Executes SQL** - creates table in database
- **Green checkmark** - successful execution
- **Message**: "SQL statement was successfully applied"

**Click "Close"** - return to GUI.

## 🎯 Verify Table Created

### Navigation in SCHEMAS Panel

```
devcamp_sql_course_schema/
└── Tables/
    └── users
        ├── Columns
        │   ├── users_id
        │   ├── users_name
        │   └── users_email
        ├── Indexes
        ├── Foreign Keys
        └── Triggers
```

**Right-click on "Columns"** - see detail of each column with types and constraints.

## 📧 Foreign Keys (Advanced Concept)

**"Foreign Keys" tab empty**:
- **Not possible yet** - we only have 1 table
- **Foreign Key** - connects table with another
- **Requires multiple tables** - next guides

**Future example**:
```
Table "guides"
Foreign Key: users_id → users.users_id
```

**Meaning**: "This guide was written by this specific user".

## 🎨 Troubleshooting

### Error: "Schema not selected"
**Solution**:
```
1. Click schema name
2. Verify schema is expanded
3. Try right-click option on Tables
```

### Error: "Table already exists"
**Solution in MySQL Workbench**:
```
1. Expand Tables
2. Right-click on "users" table
3. Select "Drop Table..."
4. Confirm
5. Recreate table
```

**Solution via Command Line**:
```sql
DROP TABLE users;
```

### Warning: "Datatype too large"
**VARCHAR(100) vs VARCHAR(10000)**:
- **Use only necessary** - avoid wasting memory
- **Reasonable for names** - 100 characters sufficient
- **Emails** - 80 characters standard

## 📋 Key Concepts

### Naming Conventions

**Table names**:
- **Plural** - `users`, `posts`, `guides`
- **Lowercase** - avoid case-sensitivity issues

**Column names**:
- **Table prefix** - `users_id`, `users_email`
- **Snake_case** - `first_name`, `created_at`
- **Descriptive** - immediate clarity

### Primary Key Best Practices

**Always use INT auto-increment**:
- ✅ **Uniqueness guaranteed** - doesn't depend on user data
- ✅ **Performance** - fast indexing
- ✅ **Relationships** - efficient foreign keys
- ❌ **Don't use email/username** - can change, are VARCHAR (slow)

### Not Null vs Null

**Not Null (NN)**:
- **Mandatory data** - doesn't allow empty values
- **Use for**: emails, passwords, critical data

**Null allowed**:
- **Optional data** - allows record without value
- **Use for**: names, descriptions, optional fields

### Unique Constraint

**Unique (UQ)**:
- **No duplicates** - each value only once
- **Use for**: emails, usernames, unique codes

**Without Unique**:
- **Duplicates allowed** - multiple records same value
- **Use for**: names, descriptions, categories

## 🎯 Final Verification

### ✅ Table Creation Checklist
- [x] **Active schema** - `devcamp_sql_course_schema`
- [x] **Table "users"** created successfully
- [x] **Primary Key** - `users_id` INT auto-increment
- [x] **Name column** - `users_name` VARCHAR(100) optional
- [x] **Email column** - `users_email` VARCHAR(80) unique, not null
- [x] **SQL executed** - `CREATE TABLE` successful
- [x] **Automatic indexes** - PRIMARY and email_UNIQUE
- [x] **Table visible** - SCHEMAS panel shows structure

### Ready For
- **Insert data** - add user records
- **Queries** - SELECT, UPDATE, DELETE
- **Relations** - connect with other future tables

---
