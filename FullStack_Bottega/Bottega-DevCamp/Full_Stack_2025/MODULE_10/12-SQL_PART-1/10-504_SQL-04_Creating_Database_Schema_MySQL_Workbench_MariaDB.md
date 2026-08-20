# 10-504: SQL_04_Creating_Database_Schema_MySQL_Workbench_MariaDB

---
**[Original Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-database-schema-mysql-workbench) - Adapted for Linux Debian + MariaDB**
---

## 🎯 Create Database Schema with MariaDB

Process to create database workspace using **MySQL Workbench with MariaDB** on Linux Debian.

**✅ Schema = Workspace that groups all our related tables**

## 🛠️ Installing MySQL Workbench (Linux Debian)

### Download MySQL Workbench 8.0.43

#### Option 1: Direct Download (Recommended)
1. **Go to**: https://dev.mysql.com/downloads/file/?id=544369
2. **Click "Download"** (doesn't require creating Oracle account)
3. **Save**: `mysql-workbench-community_8.0.43-1ubuntu24.04_amd64.deb`

#### Option 2: Via wget
```bash
wget https://dev.mysql.com/get/Downloads/MySQLGUITools/mysql-workbench-community_8.0.43-1ubuntu24.04_amd64.deb
```

### Install DEB Package
```bash
# Navigate to download directory
cd ~/Downloads

# Install MySQL Workbench
sudo apt install ./mysql-workbench-community_8.0.43-1ubuntu24.04_amd64.deb

# If broken dependencies, resolve
sudo apt install -f
```

### Verify Installation
```bash
mysql-workbench --version
```

**Expected output**:
```
MySQL Workbench CE (GPL) 8.0.43 build 2765097 (64 bits)
```

## 📧 Connect MySQL Workbench to MariaDB

### Create New Connection
1. **Open MySQL Workbench**
2. **Click** the **+** next to "MySQL Connections"
3. **Configure connection**:
   - **Connection Name**: `MariaDB Local`
   - **Hostname**: `127.0.0.1`
   - **Port**: `3306`
   - **Username**: `root`
   - **Password**: `[Store in Vault]` → enter your password

### Compatibility Warning
**Expected message**:
```
Incompatible/nonstandard server version detected (10.x.x-MariaDB)
MySQL Workbench features may not work properly
```

**Action**: **Click "Continue Anyway"** - it's just a warning, everything works perfectly.

### Test Connection
**Click "Test Connection"** → should show "Successfully made the MySQL connection"

## 📋 Create Database Schema

### Step 1: Connect to Database
1. **Double-click** the "MariaDB Local" connection
2. **Wait** for the interface to load
3. **Verify connection** - should appear in tab

### Step 2: Create Schema Via GUI

#### Visual Method (Recommended)
1. **Find icon** in top-left corner: **"Create a new schema in the connected server"**
2. **Click** the **cylinder/database** icon
3. **Dialog box opens** in new tab

#### Configure Schema
```
Schema Name: devcamp_sql_course_schema
Default Collation: [leave default]
```

**Why this name?**:
- **Descriptive** - indicates schema purpose
- **No spaces** - avoids syntax issues
- **Snake_case** - standard SQL convention

### Step 3: Review SQL Script

**Click "Apply"** → window appears:
```
Review the SQL script to be applied to the database
```

**Auto-generated SQL**:
```sql
CREATE SCHEMA `devcamp_sql_course_schema` ;
```

**MySQL Workbench advantages**:
- **Generates SQL automatically** - don't write from scratch
- **Shows preview** - understand what command executes
- **Learn syntax** - see actual SQL generated

### Step 4: Apply Changes

1. **Click "Apply"** to execute
2. **Confirmation message**: "SQL statement was successfully applied to the database"
3. **Click "Close"**

## 🎨 Verify Created Schema

### GUI Navigation
**Left panel "SCHEMAS"**:
- Expand schema list
- **Find**: `devcamp_sql_course_schema`
- **Expand schema** → show: Tables, Views, Stored Procedures, Functions

### Schema Structure
```
devcamp_sql_course_schema/
├── Tables (empty for now)
├── Views
├── Stored Procedures  
└── Functions
```

**Why empty?** - We just created the workspace, tables created in next guides.

## 🚀 Alternative Method: Command Line

### Create Schema via Terminal
```bash
# Connect to MariaDB
mysql -u root -p

# Create schema
CREATE SCHEMA devcamp_sql_course_schema;

# Verify schemas
SHOW DATABASES;

# Exit
EXIT;
```

**Identical result** - GUI vs Command Line execute same SQL.

## 📧 Navigation and Exploration

### Explore Existing Schema
**If you have other schemas**:
1. **Click** schema name
2. **Expand "Tables"** 
3. **View structure**: columns, indexes, foreign keys

### Adjust Panel Width
**If name too long**:
- **Drag** separator bar to the right
- **Expand panel** to see full names

## 📋 Key Concepts

### What is a Schema?
- **Workspace** - workspace for grouping data
- **Namespace** - avoids conflicts between different projects  
- **Container** - groups logically related tables
- **Organisation** - defines where tables exist and how they relate

### Schema vs Database
**In MariaDB/MySQL**:
- **Schema = Database** (interchangeable terms)
- **Schema** - more technical/formal term
- **Database** - more common/simple term

### Relationship with Tables
**Schema contains**:
- **Multiple tables** - users, products, orders, etc.
- **Relationships** - foreign keys between tables
- **Indexes** - for optimisation
- **Constraints** - business rules

## 🎯 Troubleshooting

### Error: "Cannot connect to database"
```bash
# Verify MariaDB running
sudo systemctl status mariadb

# If not active, start
sudo systemctl start mariadb
```

### Error: "Access denied"
```bash
# Verify correct password
mysql -u root -p

# If fails, reset password
sudo mysql
ALTER USER 'root'@'localhost' IDENTIFIED BY 'newpassword';
FLUSH PRIVILEGES;
```

### MySQL Workbench won't open
```bash
# Verify installation
mysql-workbench --version

# Install missing dependencies
sudo apt install -f
```

## 🎨 Final Verification

### ✅ Schema Creation Checklist
- [x] **MySQL Workbench** installed and working
- [x] **Connection to MariaDB** configured correctly
- [x] **Compatibility warning** successfully ignored
- [x] **Schema "devcamp_sql_course_schema"** created
- [x] **SQL command** executed: `CREATE SCHEMA devcamp_sql_course_schema ;`
- [x] **SCHEMAS panel** shows new schema
- [x] **Empty structure** visible (Tables, Views, etc.)

---
