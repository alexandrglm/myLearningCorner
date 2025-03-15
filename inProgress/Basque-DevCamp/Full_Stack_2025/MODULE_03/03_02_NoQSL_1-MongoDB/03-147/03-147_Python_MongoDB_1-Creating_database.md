# Module 03-147: MongoDB (2)

## Creating a Database and Managing Users

---

## **Index**

1. Starting MongoDB
2. Listing Existing Databases
3. Creating a New Database
4. Understanding the `db` Object
5. Creating a Database User
6. Listing Users in a Database
7. Deleting a User

---

## **Prerequisites**

Before proceeding, ensure you have MongoDB installed and properly configured on your system. You will need to have the **MongoDB daemon** (`mongod`) running and access to the **MongoDB shell** (`mongo`).

### **Starting MongoDB**

To start the MongoDB daemon, open your terminal and run:

```bash
mongod
```

Then, open a new terminal tab or window and enter the MongoDB shell:

```bash
mongo
```

If everything is working correctly, you should see a prompt similar to:

```
MongoDB shell version vX.X.X
connecting to: mongodb://127.0.0.1:27017/test
```

---

## **Listing Existing Databases**

To view the databases currently available on your system, run:

```bash
show dbs
```

Example output:

```
administration  0.000GB
test            0.000GB
```

If you have been working with MongoDB before, you might see additional databases listed.

---

## **Creating a New Database**

To create a new database, use the `use` command followed by the database name:

```bash
use mongoCourse
```

Expected output:

```
switched to db mongoCourse
```

> **Note:** The new database **will not** appear in `show dbs` until at least one document has been inserted.

---

## **Understanding the `db` Object**

MongoDB provides a special object `db`, which always refers to the current active database. To check which database you are in, simply type:

```bash
db
```

Expected output:

```
mongoCourse
```

This confirms that all further operations will be performed on `mongoCourse`.

---

## **Creating a Database User**

Official MongoDB Documentation: 

Database users are essential for managing access control. To create a new user, execute the following JavaScript code inside the MongoDB shell:

```js
db.createUser({
  user: 'jordan',
  pwd: 'securepassword',
  customData: { startDate: new Date() },
  roles: [
    { role: 'clusterAdmin', db: 'admin' },
    { role: 'readAnyDatabase', db: 'admin' },
    'readWrite'
  ]
})
```

### **Explanation:**

- `user`: The username for the new user.
- `pwd`: The password (ensure you use a strong password in production environments).
- `customData`: Optional metadata, e.g., a timestamp for when the user was created.
- `roles`: Defines the user's permissions:
  - `clusterAdmin`: Grants cluster-wide administrative privileges.
  - `readAnyDatabase`: Allows reading from any database.
  - `readWrite`: Provides read and write access to the current database.

---

## **Listing Users in a Database**

To see all users associated with the current database, use:

```bash
db.getUsers()
```

Expected output:

```json
[
  {
    "_id": "mongoCourse.jordan",
    "user": "jordan",
    "roles": [
      { "role": "clusterAdmin", "db": "admin" },
      { "role": "readAnyDatabase", "db": "admin" },
      "readWrite"
    ]
  }
]
```

This confirms that our user `jordan` has been successfully created with the specified roles.

---

## **Deleting a User**

If you need to remove a user from the database, run:

```bash
db.dropUser('jordan')
```

Expected output:

```
true
```

To verify, check the list of users again:

```bash
db.getUsers()
```

The removed user should no longer appear in the output.

---

## **Review and Best Practices**

- **Ensure the MongoDB daemon (`mongod`) is running** before performing any database operations.
- **Use strong passwords** when creating database users, especially in production environments.
- **Regularly check user permissions** using `db.getUsers()`.
- **Do not rely solely on default roles**—customize roles based on security and access control needs.
- **Remember that a new database will not be listed** until at least one document has been inserted.

---

## References

* [MongoDB Official docs](https://www.mongodb.com/docs/manual/)

* [MongoDB Tutorial: ](https://www.mongodb.com/docs/manual/tutorial/manage-users-and-roles/)
