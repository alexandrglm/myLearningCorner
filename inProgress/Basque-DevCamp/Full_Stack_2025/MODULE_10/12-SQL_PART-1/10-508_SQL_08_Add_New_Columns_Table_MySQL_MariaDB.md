# 10-508: SQL_08_Add_New_Columns_Table_MySQL_MariaDB

---

## **[Original Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-add-new-columns-table-mysql) - Adapted for Linux Debian + MariaDB**

## 🎯 Create Guides Table and Add Columns

Create the **guides** table with a foreign key to **users**, using the **DECIMAL** data type and add columns after creating the table.

## 🛠️ Create Guides Table

### Right-Click Create Table

```
Table Name: guides
```

## 📋 Initial Columns

### Primary Key

```
guides_id    INT    PK, NN, AI, UQ
```

### Revenue Column

```
guides_revenue    DECIMAL    NN
```

**Why DECIMAL?**:

* **Mathematical operations** - SUM, AVG work correctly
* **Precision** - currency requires exact decimals
* **Not VARCHAR** - you cannot add strings

### Foreign Key

```
guides_users_id    INT    NN
```

## 🔧 Configure Foreign Key

### "Foreign Keys" Tab

```
Foreign Key Name: fk_guides_users
Column: guides_users_id
Referenced Table: users
Referenced Column: users_id
On Delete: CASCADE
```

### On Delete Options

**CASCADE**:

* Deleted user → related guides are deleted
* **Typically used** - Twitter deletes tweets if the user is removed

**SET NULL**:

* Deleted user → guides_users_id = NULL
* Guides remain but without an owner
* **Requires extra logic** - handle NULL in queries
* **Problem**: How to display user name if NULL?

**Recommendation**: Use CASCADE by default.

## 🚀 Generated SQL

```sql
CREATE TABLE `devcamp_sql_course_schema`.`guides` (
  `guides_id` INT NOT NULL AUTO_INCREMENT,
  `guides_revenue` DECIMAL NOT NULL,
  `guides_users_id` INT NOT NULL,
  PRIMARY KEY (`guides_id`),
  INDEX `fk_guides_users_idx` (`guides_users_id` ASC),
  CONSTRAINT `fk_guides_users`
    FOREIGN KEY (`guides_users_id`)
    REFERENCES `users` (`users_id`)
    ON DELETE CASCADE
);
```

**Click "Apply"** → table created.

## 🎨 Add Column to Existing Table

### Method 1: Edit Table (GUI)

1. **Click wrench icon** 🔧 on `guides` table
2. **New empty row** in columns list
3. **Configure**:

```
guides_title    VARCHAR(150)    NN
```

4. **Click "Apply"**

### Generated SQL

```sql
ALTER TABLE `devcamp_sql_course_schema`.`guides`
ADD COLUMN `guides_title` VARCHAR(150) NOT NULL
AFTER `guides_users_id`;
```

**AFTER clause** - positions column after `guides_users_id`.

### Method 2: Direct SQL

```sql
ALTER TABLE guides
ADD COLUMN guides_title VARCHAR(150) NOT NULL;
```

## 📋 Final Structure

```
guides/
├── guides_id           INT           PK, NN, AI, UQ
├── guides_revenue      DECIMAL       NN
├── guides_users_id     INT           NN, FK → users.users_id
└── guides_title        VARCHAR(150)  NN
```

## 🎯 Verify Creation

### Expand Schema

```
devcamp_sql_course_schema/
└── Tables/
    ├── users
    ├── addresses
    └── guides
        ├── Columns (4)
        └── Foreign Keys
            └── fk_guides_users → users.users_id
```

## 🔧 Data Types: DECIMAL

### Use of DECIMAL

**Syntax**:

```
DECIMAL(precision, scale)
DECIMAL(10, 2)  -- 10 total digits, 2 decimal places
```

**Example**:

* `DECIMAL(10, 2)` → maximum 99999999.99
* **Exact precision** - does not round like FLOAT

**For currency**:

```
guides_revenue    DECIMAL(10, 2)
```

## 🎨 Complete Relationships

### Relational Structure

```
users (1) ──────< addresses (many)
  │
  └──────< guides (many)
```

**1 User**:

* Multiple addresses
* Multiple guides

---
