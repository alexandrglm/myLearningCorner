# 10-507: SQL_07_Changing_Columns_MySQL_Tables_MariaDB

---

## **[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/guide-changing-columns-mysql-tables) - Adapted for Linux Debian + MariaDB**

## 🎯 Modifying Columns in Existing Tables

Correcting an error in the **addresses** table - make `addresses_users_id` NOT NULL because an address must always belong to a user.

## 🛠️ Open Table for Editing

### GUI Method

1. **Expand** `devcamp_sql_course_schema` → `Tables`
2. **Hover** over the `addresses` table
3. **Click** the **wrench icon** 🔧
4. **It opens** in a new editing tab

## 🔧 Modify Column

### Change addresses_users_id

**In the column list**:

1. **Locate** the row `addresses_users_id`
2. **Check** the **NN** (Not Null) box
3. **Click "Apply"**

## 📋 Generated SQL

### Review Script

```sql
ALTER TABLE `devcamp_sql_course_schema`.`addresses` 
DROP FOREIGN KEY `fk_addresses_users`;

ALTER TABLE `devcamp_sql_course_schema`.`addresses` 
CHANGE COLUMN `addresses_users_id` `addresses_users_id` INT NOT NULL;

ALTER TABLE `devcamp_sql_course_schema`.`addresses` 
ADD CONSTRAINT `fk_addresses_users`
  FOREIGN KEY (`addresses_users_id`)
  REFERENCES `users` (`users_id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;
```

**Process**:

1. **DROP FOREIGN KEY** - temporarily removes the constraint
2. **CHANGE COLUMN** - modifies the column to NOT NULL
3. **ADD CONSTRAINT** - recreates the foreign key

### Click "Apply" → "Close"

## 🎨 Reasoning Behind the Change

### Why NOT NULL on addresses_users_id?

**An address without a user does not make sense**:

* **Queries** - we always need to know who it belongs to
* **Integrity** - an address must have an owner
* **Mandatory relationship** - prevents orphaned addresses

### Comparison with addresses_street_two

**street_two may be NULL**:

* **Optional** - not everyone has a flat/unit
* **Valid real cases** - many addresses do not include a secondary address
* **Flexibility** - allows entries without this value

## ⚠️ Precautions

### Tables with Existing Data

**If the table has millions of records**:

* **ALTER TABLE is slow** - may take a long time
* **Table is locked** - unavailable during modification
* **Better approach** - scheduled migrations in production

**For this course**:

* **Tables are empty** - instantaneous modification
* **No problem** - use GUI directly

## 🔧 Alternative Method: Direct SQL

### ALTER TABLE Command

```sql
ALTER TABLE addresses 
MODIFY addresses_users_id INT NOT NULL;
```

**Simpler** if there is no foreign key to recreate.

### With Foreign Key

```sql
-- Remove FK
ALTER TABLE addresses DROP FOREIGN KEY fk_addresses_users;

-- Modify column
ALTER TABLE addresses MODIFY addresses_users_id INT NOT NULL;

-- Recreate FK
ALTER TABLE addresses 
ADD CONSTRAINT fk_addresses_users 
FOREIGN KEY (addresses_users_id) 
REFERENCES users(users_id) 
ON DELETE CASCADE;
```

## 🎯 Verify the Change

### Check Column Definition

**Right-click** `addresses` → **Columns**:

```
addresses_users_id    INT    NN, FK
```

**✅ NN enabled** - change applied successfully.

---

