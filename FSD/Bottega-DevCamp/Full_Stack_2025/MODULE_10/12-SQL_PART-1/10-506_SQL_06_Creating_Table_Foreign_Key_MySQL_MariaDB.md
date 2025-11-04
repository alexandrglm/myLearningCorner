# 10-506: SQL_06_Creating_Table_Foreign_Key_MySQL_MariaDB

---

## **[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-create-table-foreign-key-mysql) - Adapted for Linux Debian + MariaDB**

## 🎯 Foreign Keys: Relationships Between Tables

Create the **addresses** table with a **Foreign Key** that connects to the **users** table - complete relational structure.

**✅ Relationship**: One user can have multiple addresses.

## 🛠️ Create Addresses Table

### Right-Click Create Table

1. **Schema** `devcamp_sql_course_schema`
2. **Right-click "Tables"** → "Create Table..."
3. **Table Name**: `addresses`

## 📋 Define Columns

### Primary Key

```
addresses_id    INT    PK, NN, AI, UQ
```

### Address Fields

```
addresses_street_one     VARCHAR(45)     NN
addresses_street_two     VARCHAR(45)     (optional)
addresses_city           VARCHAR(45)     NN
addresses_state          VARCHAR(2)      NN
addresses_postal_code    VARCHAR(20)     NN
```

**Why VARCHAR for postal_code?**:

* **Flexibility** - allows "12345-6789" with hyphen
* **INT would reject** format with non-numeric characters

**addresses_state VARCHAR(2)**:

* **US abbreviations** - "AZ", "NY", "CA"
* **2 characters** are sufficient

## 🔧 Foreign Key Column

### Connector Column

```
addresses_users_id    INT
```

**Configuration**:

* ❌ **No PK** - not a primary key
* ❌ **No UQ** - allow multiple addresses per user
* ❌ **No AI** - value comes from users.users_id

**Logic**:

* **Same user, multiple addresses** - `addresses_users_id` repeats
* **Connection** - value must exist in `users.users_id`

## 🎨 Configure Foreign Key

### "Foreign Keys" Tab

1. **Click "Foreign Keys" tab**
2. **Foreign Key Name**: `fk_addresses_users`
3. **Column**: `addresses_users_id`
4. **Referenced Table**: `users`
5. **Referenced Column**: `users_id`

### On Delete Cascade

**Select "CASCADE"**:

```
On Delete: CASCADE
```

**Meaning**:

* **User deleted** → all their addresses are deleted automatically
* **Integrity** - prevents orphaned addresses
* **Best practice** - keeps the database clean

## 🚀 Generated SQL

### Click "Apply" - Review Script

```sql
CREATE TABLE `devcamp_sql_course_schema`.`addresses` (
  `addresses_id` INT NOT NULL AUTO_INCREMENT,
  `addresses_street_one` VARCHAR(45) NOT NULL,
  `addresses_street_two` VARCHAR(45) NULL,
  `addresses_city` VARCHAR(45) NOT NULL,
  `addresses_state` VARCHAR(2) NOT NULL,
  `addresses_postal_code` VARCHAR(20) NOT NULL,
  `addresses_users_id` INT NULL,
  PRIMARY KEY (`addresses_id`),
  INDEX `fk_addresses_users_idx` (`addresses_users_id` ASC),
  CONSTRAINT `fk_addresses_users`
    FOREIGN KEY (`addresses_users_id`)
    REFERENCES `users` (`users_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION
);
```

**Key Elements**:

* **CONSTRAINT** - defines the foreign key
* **REFERENCES** - points to `users.users_id`
* **ON DELETE CASCADE** - removes addresses if the user is deleted
* **Automatic INDEX** - optimises joins

## 🎯 Verify Structure

### Expand Schema

```
devcamp_sql_course_schema/
└── Tables/
    ├── users
    └── addresses
        ├── Columns (7)
        ├── Indexes
        └── Foreign Keys
            └── fk_addresses_users → users.users_id
```

**Right-click "Foreign Keys"** - view the full relationship.

## 📋 Concepts: Foreign Keys

### What is a Foreign Key?

**A column that references a Primary Key in another table**:

* **Connects tables** - relational structure
* **Ensures integrity** - value must exist in referenced table
* **Does not allow duplication of PK** - but allows multiple references

### One-to-Many Relationship

**1 User → Many Addresses**:

```
users.users_id = 1
  ↓
addresses.addresses_users_id = 1 (address A)
addresses.addresses_users_id = 1 (address B)
addresses.addresses_users_id = 1 (address C)
```

### Cascade Actions

**ON DELETE CASCADE**:

* User deleted → addresses deleted automatically

**ON UPDATE CASCADE** (optional):

* users_id updated → addresses_users_id updated automatically

## 🔧 Troubleshooting

### Error: "Cannot add foreign key constraint"

**Common causes**:

1. **Types do not match** - both columns must be INT
2. **Referenced table does not exist** - create `users` first
3. **Referenced column does not exist** - verify `users.users_id`

**Verify types**:

```sql
DESCRIBE users;
DESCRIBE addresses;
```

### Error: "Incorrect foreign key definition"

**Solution**:

* **Referenced column must be PK or UNIQUE**
* `users.users_id` must be PRIMARY KEY

---
