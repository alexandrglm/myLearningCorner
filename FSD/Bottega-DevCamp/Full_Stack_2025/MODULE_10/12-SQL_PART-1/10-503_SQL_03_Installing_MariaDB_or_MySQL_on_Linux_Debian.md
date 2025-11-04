# 10-503: SQL_03_Installing_MariaDB_on_Linux_Debian

---
**[Original Guide Mac](https://basque.devcamp.com/pt-full-stack-development-javascript-python-react/guide/installing-mysql-on-a-mac) - Adapted for Linux Debian with MariaDB**
---

## 🎯 Installing MariaDB on Linux Debian

Complete process to install and configure **MariaDB** (100% compatible with MySQL) on Debian/Ubuntu systems using **apt package manager**.

**✅ MariaDB = Drop-in replacement for MySQL with identical syntax**

## 🛠️ Update System

### Update Package Manager
```bash
sudo apt update
sudo apt upgrade -y
```

**Why update first?**:
- **Updated repositories** - access to more recent versions
- **Correct dependencies** - avoid installation conflicts
- **Clean system** - optimal preparation for MariaDB

## 📧 Installing MariaDB Server

### Problem: mysql-server Not Available
**Common error on Debian**:
```
Package mysql-server is not available
Error: Package 'mysql-server' has no installation candidate
However the following packages replace it: mariadb-server
```

### Solution: Install MariaDB
```bash
sudo apt install mariadb-server -y
```

**Why MariaDB instead of MySQL?**:
- **100% compatible** with MySQL syntax
- **Same creator** as original MySQL
- **Already available** in Debian repositories
- **Identical commands** - entire course works the same

### Verify Installation
```bash
mysql --version
```

**Expected output**:
```
mysql  Ver 15.1 Distrib 10.x.x-MariaDB, for debian-linux-gnu (x86_64)
```

## 📋 Service Configuration

### Start MariaDB Service
```bash
sudo systemctl start mariadb
```

**Equivalent to `sudo mysql.server start` on Mac**:
- **systemctl** is the service manager on Linux
- **start** starts the MariaDB service
- **Necessary** to connect to the database

### Verify Service Status
```bash
sudo systemctl status mariadb
```

**Expected output**:
```
● mariadb.service - MariaDB database server
   Active: active (running)
```

### Enable Automatic Start
```bash
sudo systemctl enable mariadb
```

**Auto-start on boot** - MariaDB will automatically start when system reboots.

## 🎨 Initial Security Configuration

### MariaDB Security Script
```bash
sudo mariadb-secure-installation
```

**Message from Debian**:
```
NOTE: MariaDB is secure by default in Debian. Running this script is
useless at best, and misleading at worst. This script will be
removed in a future MariaDB release in Debian.
```

**Ignore the message** - we need to configure for the course.

### Recommended Configurations for Course

**Step-by-step responses**:

```bash
Enter current password for root (enter for none): [ENTER]

Switch to unix_socket authentication [Y/n] n
# ⚠️ IMPORTANT: Answer 'n' to use password authentication

Change the root password? [Y/n] Y
New password: yourpassword
Re-enter new password: yourpassword

Remove anonymous users? [Y/n] Y
Disallow root login remotely? [Y/n] Y
Remove test database and access to it? [Y/n] Y
Reload privilege tables now? [Y/n] Y
```

### Why These Responses?

**unix_socket authentication = `n`**:
- **MySQL Workbench** requires traditional user/password
- **GUI tools** need password authentication
- **Consistency** with MySQL course guides

**Root password = `Y`**:
- **Necessary** to connect from applications
- **Required** by MySQL Workbench and other tools

## 🚀 Server Control Commands

### Start Server
```bash
sudo systemctl start mariadb
```

### Stop Server
```bash
sudo systemctl stop mariadb
```

### Restart Server
```bash
sudo systemctl restart mariadb
```

### Check if Running
```bash
sudo systemctl is-active mariadb
```

## 📧 Connect to MariaDB

### Connection as Root
```bash
mysql -u root -p
```

**Process**:
1. **Command executes** MySQL client (same command)
2. **-u root** specifies root user
3. **-p** requests password you configured
4. **Enter password** at prompt

### Exit MariaDB Shell
```sql
EXIT;
```

## 📋 Compatibility Verification

### Test MySQL Syntax
**Connect and test basic commands**:

```bash
mysql -u root -p
```

**Inside MariaDB shell**:
```sql
SHOW DATABASES;
SELECT VERSION();
CREATE DATABASE test_curso;
USE test_curso;
CREATE TABLE usuarios (id INT, nombre VARCHAR(50));
SHOW TABLES;
DROP DATABASE test_curso;
EXIT;
```

**✅ All these commands are IDENTICAL to MySQL**.

## 🎯 Common Troubleshooting

### Error: "Can't connect to MariaDB"
**Solution**:
```bash
# Check if running
sudo systemctl status mariadb

# If not running, start it
sudo systemctl start mariadb
```

### Error: "Access denied for user 'root'"
**Solution**:
```bash
# If unix_socket is enabled by mistake
sudo mysql

# Inside MariaDB, change to password auth:
ALTER USER 'root'@'localhost' IDENTIFIED BY 'yourpassword';
FLUSH PRIVILEGES;
EXIT;
```

### MariaDB Port (Optional)
```bash
# Check MariaDB port (default: 3306, same as MySQL)
sudo netstat -tlnp | grep mysql
```

## 🎨 MySQL Workbench with MariaDB

### Connect from MySQL Workbench
1. **Open MySQL Workbench**
2. **Create new connection**
3. **Connection Name**: "MariaDB Local"
4. **Hostname**: 127.0.0.1
5. **Port**: 3306
6. **Username**: root
7. **Password**: [your password]

### Expected Warning Message
```
Incompatible/nonstandard server version detected
MySQL Workbench features may not work properly
```

**Action**: **Click "Continue Anyway"** - it's just a warning, everything works.

## 📧 Complete Final Verification

### Successful Installation Test

1. **Verify service active**:
```bash
sudo systemctl status mariadb
```

2. **Connect as root**:
```bash
mysql -u root -p
```

3. **Execute test query**:
```sql
SELECT VERSION();
SHOW DATABASES;
```

4. **Test from MySQL Workbench** (optional):
- Connect with configured credentials
- Ignore compatibility warning
- Execute simple query

### ✅ Installation Checklist
- [x] **MariaDB server** installed via apt
- [x] **Service started** with systemctl  
- [x] **Password authentication** configured
- [x] **Root password** established
- [x] **Successful connection** as root
- [x] **Auto-start enabled** for boot
- [x] **MySQL compatibility** verified
- [x] **Port 3306** working

## 🎯 Key Differences with MySQL

### What Changes
- **systemctl command**: `mariadb` instead of `mysql`
- **Version output**: Shows "MariaDB" instead of "MySQL"
- **Package name**: `mariadb-server` instead of `mysql-server`

### What DOESN'T Change (100% Identical)
- ✅ **All SQL queries**
- ✅ **Connection commands** (`mysql -u root -p`)
- ✅ **Syntax for CREATE, SELECT, INSERT, UPDATE**
- ✅ **Port 3306**
- ✅ **Database and table structure**
- ✅ **Compatibility with MySQL tools**

---
