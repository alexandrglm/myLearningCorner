# 03-146\_MongoDB-1\_Installing-LINUX-MongoDBAtlasAWS

## Module 03 - 146: MongoDB (1)

## MongoDB on Linux + MongoDB Atlas AWS Cluster setup

The original guide explains how to install MongoDB for MAC users but,so that for those Linux users, these steps explains how to set it up.

Additionally, this guide explains how to install MongoDB without it being system-wide, as well as installing it system-wide. It's suggested to use a non system-wide when posible.

On the other hand, this guide also includes how to set up a free MongoDB Atlas Cluster at AWS (at least while MongoDB allows free accounts for students), to be able to use a remote database or integrate remote MongoDB into our projects.

Finally, a default connection to Atlas@AWS will be performed and explained.

***

## 1) MongoDB Debian 12 alike setup

### A)    Mongo-sh system-wide for shell access + Mongod server/daemon from binaries

1. Add the latest MongoDB sources [from official site](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/):

```bash
# Importinf .asc/gpg for apt update
curl -fsSL https://www.mongodb.org/static/pgp/server-8.0.asc | \   sudo gpg -o /usr/share/keyrings/mongodb-server-8.0.gpg \   --dearmor
```

* Adding to sources (These sources could be mordenized)

```bash
echo "deb [ signed-by=/usr/share/keyrings/mongodb-server-8.0.gpg ] http://repo.mongodb.org/apt/debian bookworm/mongodb-org/8.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-8.0.list
```

* Getting it

```bash
sudo apt-get update && sudo apt-get install -y mongodb-org
```

2. Getting latest MongoDB Community Server bins, **for the required project folder**:

```bash
curl https://fastdl.mongodb.org/linux/mongodb-linux-x86_64-debian12-8.0.5.tgz

tar -xvz ./mongodb-linux-x86_64-debian12-8.0.5.tgz ./mongodb
```

3. Setting up the mongod.conf file from our project root folder:

```yaml
storage:
    dbPath: ./data/db
systemLog:
    destination: file
    path: ./logs/mongod.log
    logAppend: true
net:
    bindIp: 127.0.0.1
    port: 27017
```

4. Starting the Mongod server, in one terminal tab:

```bash
$ ./mongodb/bin/mongod --config ~/<path-for-the-mongodb-project>/mongod.conf
```

5. Starting the Mongo shell:

```bash
$ mongosh
Current Mongosh Log ID:    *
Connecting to:        mongodb://*
Using MongoDB:        8.0.5
Using Mongosh:        2.4.2

For mongosh info see: https://www.mongodb.com/docs/mongodb-shell/


To help improve our products, anonymous usage data is collected 
and sent to MongoDB periodically (https://www.mongodb.com/legal/privacy-policy).
You can opt-out by running the disableTelemetry() command.

------
   The server generated these startup warnings when booting

test>
```

***

## 2) MongoDB Atlas at Amazon AWS Cluster setup

This part of the guide provides an outline on how to set up and connect a MongoDB Atlas cluster on Amazon AWS, for the moment, free of charge.

Once configured, this action can replace the "Mongod" daemon installed system-wide as it can be accessed through a wide range of methods:

* The local shell in Terminal.
* The official MongoDB WebGUI framework, from the AWS panel.
* A webservice like Render (its free plan accepts connecting both services), or in your own back-end of your own server, with the multitude of languages available to develop using Mongo.

**By default, this mini-course will cover Shell access (JavaScript/JSON alike), and Python back-end using PyMongo**.

***

### General Procedures from AWS side

From: https://www.mongodb.com/docs/atlas/

What will you need?

*   A MongoDB (free) registered account (https://www.mongodb.com/cloud/atlas/register)

    ![MongoDB Atlas Account types](../../../../../../.gitbook/assets/03-146_IMG01.png)
* b

### What is MongoDB Atlas?

_MongoDB Atlas is a multi-cloud database service by the same people that build MongoDB. Atlas simplifies deploying and managing your databases while offering the versatility you need to build resilient and performant global applications on the cloud providers of your choice._

#### 1) Deploy a Database

**1.1 Choose a cluster type** : **FREE CLUSTER**

_Play around with a **free cluster**, launch a serverless instance, or define a dedicated cluster configuration for your application._

![IMG](../../../../../../.gitbook/assets/03-146_IMG02.png)

_To choose a deployment type, see Database Deployment Types._

**1.2 Choose a Cloud Provider and Region: Amazon AWS @ your nearest location**

_Deploy your database to the same cloud provider and region as your applications to reduce latency and standardize security controls._

![img](../../../../../../.gitbook/assets/03-146_IMG03.png)

#### 2)     Secure the Database

**2.1 Add IP Access List Entries**

_Define an IP access list for your cluster._

**This can include the IPs of your server, or your webservice on Render, Vercel, etc; or, your IP/DynDNS to access from your shell**.

![Atlas IP configs](../../../../../../.gitbook/assets/03-146_IMG04.png)

**2.2 Manage Database Users**

_Define how your team members and applications authenticate to your database and what data they can access_.

![MongoDB Atlas Accounts](../../../../../../.gitbook/assets/03-146_IMG05.png)

**This means you can create different users, with different permissions, as needed. It is mandatory that you create one, and I suggest to NOT use the default username/passwords of your MongoDB account.**

#### 3)    Connect the Database

**3.1 Choose a Connection Type**

_Connect to your database using the MongoDB Shell, one ofMongoDB's native language drivers, MongoDB Compass, or theMongoDB Connector for BI._

![img](../../../../../../.gitbook/assets/03-146_IMG06.png)

**From this point on, everything is created and configured, so that, how you configure and connect your service depends on the use you are going to make of it (Shell, WebGUI, Render/Vercel/etc...).**

***

## 3) Connecting to MongoDB Atlas via shell

MongoDB Atlas provides a straightforward Connections/Access setup.

To access it via the local shell, we need at least `mongosh` installed (via sources, via apt install, ....).

We will create a .conf file and a shell script for quick access.

Remember to store "secrets" (access paths, username/password, etc.) in a safe place.

1. **Via shell script `./atlas_login.sh`**

```bash
   #!/bin/bash
   
   echo "Atlas user:  "
   read user
   echo "Atlas Pass: "
   read -s password
   uri="mongodb://<your_FULL_mongoDB_path>"
   
   # 
   mongosh "$uri" --apiVersion 1 \
   --tls  \
   --authenticationDatabase admin \
   --username "$user" --password "$password"
```

Expected Output:

```bash
   $ bash ./mongo_shell.sh 
   Atlas user:  
   <user>
   Atlas Pass: 
   Current Mongosh Log ID:    *
   Connecting to:        mongodb://
   
   Using MongoDB:        8.0.5 (API Version 1)
   Using Mongosh:        2.4.2
   
   For mongosh info see: https://www.mongodb.com/docs/mongodb-shell/
   
   Atlas * [primary] test> 
```

Since here, you are enable to start creating, configuring, handling, your database.

***

[database – Database level operations - PyMongo 4.11 documentation](https://pymongo.readthedocs.io/en/4.11/api/pymongo/database.html#pymongo.database.Database.create_collection)

***

```markdown
# Installing MongoDB on Linux

## Install MongoDB Community Edition[](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#install-mongodb-community-edition "Permalink to this heading")

## [

](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#install-mongodb-community-edition "Permalink to this heading")

Follow these steps to install MongoDB Community Edition using the `apt` package manager.

1

### Import the public key.[](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#import-the-public-key. "Permalink to this heading")

### [

](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#import-the-public-key. "Permalink to this heading")

From a terminal, install `gnupg` and `curl` if they are not already
available:


sudo apt-get install gnupg curl


To import the MongoDB public GPG key, run the following command:


curl -fsSL https://www.mongodb.org/static/pgp/server-8.0.asc | \   sudo gpg -o /usr/share/keyrings/mongodb-server-8.0.gpg \   --dearmor


2

### Create the list file.[](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#create-the-list-file. "Permalink to this heading")

### [

](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#create-the-list-file. "Permalink to this heading")

Create the list file for Debian 12 (Bookworm):


echo "deb [ signed-by=/usr/share/keyrings/mongodb-server-8.0.gpg ] http://repo.mongodb.org/apt/debian bookworm/mongodb-org/8.0 main" | sudo tee /etc/apt/sources.list.d/mongodb-org-8.0.list


3

### Reload the package database.[](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#reload-the-package-database. "Permalink to this heading")

### [

](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#reload-the-package-database. "Permalink to this heading")

Issue the following command to reload the local package database:


sudo apt-get update


4

### Install MongoDB Community Server.[](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#install-mongodb-community-server. "Permalink to this heading")

### [

](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#install-mongodb-community-server. "Permalink to this heading")

You can install either the latest stable version of MongoDB or a
specific version of MongoDB.

To install the latest stable version, issue the following


sudo apt-get install -y mongodb-org


## Run MongoDB Community Edition[](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#run-mongodb-community-edition "Permalink to this heading")

## [

](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#run-mongodb-community-edition "Permalink to this heading")

### ulimit Considerations[](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#ulimit-considerations "Permalink to this heading")

### [

](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#ulimit-considerations "Permalink to this heading")

Most Unix-like operating systems limit the system resources that a
process may use. These limits may negatively impact MongoDB operation,
and should be adjusted. See [UNIX `ulimit` Settings for Self-Managed Deployments](https://www.mongodb.com/docs/manual/reference/ulimit/) for the recommended
settings for your platform.

## Note

If the `ulimit` value for number of open files is under `64000`, MongoDB
generates a startup warning.

### Directories[](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#directories "Permalink to this heading")

### [

](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#directories "Permalink to this heading")

By default, a MongoDB instance stores:

- its data files in `/var/lib/mongodb`

- its log files in `/var/log/mongodb`

If you installed via the package manager, these default directories are
created during the installation.

If you installed manually by downloading the tarballs, you can create
the directories using `mkdir -p <directory>` or `sudo mkdir -p <directory>` depending on the user that will run MongoDB. (See your
linux man pages for information on `mkdir` and `sudo`.)

By default, MongoDB runs using the `mongodb` user account. If you
change the user that runs the MongoDB process, you **must** also modify
the permission to the `/var/lib/mongodb` and `/var/log/mongodb` directories to give this user access to these directories.

To specify a different log file directory and data file directory, edit
the [`systemLog.path`](https://www.mongodb.com/docs/manual/reference/configuration-options/#mongodb-setting-systemLog.path) and [`storage.dbPath`](https://www.mongodb.com/docs/manual/reference/configuration-options/#mongodb-setting-storage.dbPath) settings in
the `/etc/mongod.conf`. Ensure that the user running MongoDB has
access to these directories.

### Procedure[](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#procedure "Permalink to this heading")

### [

](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-debian/#procedure "Permalink to this heading")

Follow these steps to run MongoDB Community Edition on your system.
These instructions assume that you are using the official `mongodb-org` package -- not the unofficial `mongodb` package provided by
Debian -- and are using the default settings.

**Init System**

To run and manage your [`mongod`](https://www.mongodb.com/docs/manual/reference/program/mongod/#mongodb-binary-bin.mongod) process, you will be using
your operating system's built-in [init system](https://www.mongodb.com/docs/manual/reference/glossary/#std-term-init-system). Recent versions of
Linux tend to use **systemd** (which uses the `systemctl` command),
while older versions of Linux tend to use **System V init** (which uses
the `service` command).

If you are unsure which init system your platform uses, run the
following command:


ps --no-headers -o comm 1


Then select the appropriate tab below based on the result:

- `systemd` - select the **systemd (systemctl)** tab below.

- `init` - select the **System V Init (service)** tab below.

****

## A. Via Docker:

If you want even greater isolation, you can use Docker to run MongoDB in a container.   

This ensures MongoDB doesn’t interact with your system at all.

1. **Install Docker**:

- Follow the official instructions to install Docker: [Install Docker](https://docs.docker.com/engine/install/).

2. **Run MongoDB in a Container**:

- Use the following command to start a MongoDB container:

  bash
  docker run -d --name mongodb-course -p 27017:27017 -v ~/projects/mongodb-course/data/db:/data/db mongo

- This mounts the `~/projects/mongodb-course/data/db` folder to the container for data persistence.
3. **Connect to the Container**:

- Use the `mongo` shell to connect to the container:

  bash
  mongo --host 127.0.0.1 --port 27017


---

## B. Via Sources

### **1. Download MongoDB Binaries**

Instead of installing MongoDB via Docker, you can download the binaries and run them directly from a project folder.

1. **Download MongoDB**:

- Go to the [MongoDB Community Download Page](https://www.mongodb.com/try/download/community).

- Select the appropriate version for your Linux distribution and download the `.tgz` file.

2. **Extract the Binaries**:

- Open a terminal and navigate to the folder where you downloaded the `.tgz` file.

- Extract the archive:

  bash
  tar -xvzf mongodb-linux-x86_64-<version>.tgz


- Move the extracted folder to your project directory (e.g., `~/projects/mongodb-course`):

  bash
  mv mongodb-linux-x86_64-<version> ~/projects/mongodb-course/mongodb


****

### **2. Set Up MongoDB for Your Project**

Now that you have the binaries in your project folder, configure MongoDB to run in an isolated environment.

1. **Create Data and Logs Folders**:

1. MongoDB needs a folder to store data and another for logs. Create these folders inside your project directory:

   bash
   mkdir -p ~/projects/mongodb-course/data/db
   mkdir -p ~/projects/mongodb-course/logs


2. **Create a Configuration File**:

1. Create a configuration file (`mongod.conf`) in your project folder:

   bash
   nano ~/projects/mongodb-course/mongod.conf


2. Add the following basic configuration:

   bash
   storage:
     dbPath: /home/<your-username>/projects/mongodb-course/data/db
   systemLog:
     destination: file
     path: /home/<your-username>/projects/mongodb-course/logs/mongod.log
     logAppend: true
   net:
     bindIp: 127.0.0.1
     port: 27017


3. Save and close the file.

****

### **3. Run MongoDB**

You can now start MongoDB from your project folder.

1. **Start the MongoDB Server**:

* Navigate to the `bin` folder inside the extracted MongoDB directory:

  bash
  cd ~/projects/mongodb-course/mongodb/bin


* Start the MongoDB server using the configuration file:

  bash
  ./mongod --config ~/projects/mongodb-course/mongod.conf


2. **Verify MongoDB is Running**:

* Open another terminal and connect to MongoDB using the `mongo` shell:

  bash
  ./mongo --host 127.0.0.1 --port 27017


* If the connection is successful, you’ll see the MongoDB shell prompt.

****

### **4. Stop MongoDB**

When you’re done working with MongoDB, stop the server by pressing `Ctrl + C` in the terminal where it’s running.

****

### **5. Using MongoDB in Your Project**

Now that MongoDB is running, you can use it for your project. Here are some basic commands to get started:

#### **Create a Database**

bash
use mydatabase


#### **Create a Collection**

bash
db.createCollection("mycollection")


#### **Insert a Document**

bash
db.mycollection.insertOne({ name: "Alice", age: 25 })


#### **Query Documents**

bash
db.mycollection.find({ age: { $gt: 20 } })


#### **Delete a Database**

bash
db.dropDatabase()


****

### **6. Clean Up**

When you’re done with the course, simply delete the project folder to remove MongoDB:

bash
rm -rf ~/projects/mongodb-course


If you used Docker, stop and remove the container:

bash
docker stop mongodb-course
docker rm mongodb-course


****

# C. Via apt, SYSTEM-WIDE (Be careful)

### Step 1: Install MongoDB

To install MongoDB, use the package manager of your distribution:

- **Debian/Ubuntu:**  `sudo apt update & sudop apt install -y mongodb`
- **Fedora**:  `sudo dnf install -y mongodb`
- **Arch Linux (AUR package available):** `yay -S mongodb-bin`

### Step 3: Create the Data Directory

MongoDB stores its data in `/data/db`. You need to create this directory manually:

bash
sudo mkdir -p /data/db
sudo chown -R `id -un` /data/db


### Step 4: Start MongoDB

To start the MongoDB daemon, run:

bash
mongod


You can verify if MongoDB is running by opening a new terminal and typing:  

bash
mongo


If everything is set up correctly, this will open the MongoDB shell.

****

## Resources

- [Official MongoDB Installation Guide](https://www.mongodb.com/docs/manual/installation/)
- [Install MongoDB Community Edition on Linux](https://www.mongodb.com/docs/manual/administration/install-on-linux/)

****

## Video lesson Speech

### How to Install MongoDB on a Mac

In this guide we're going to walk through how to install and configure Mongo on your system.

****

Now if you do not have homebrew installed and  your on a Mac then go to [brew.sh](https://brew.sh/)  and then copy this line of code right here 


/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"


and then open up your terminal and paste it in. So here is the terminal. So if you do not have a brew already installed then you can run it right here and it will go through, it might take a few minutes but it will install and then once you have that you'll be ready to install Mongo. The first command to run will be `brew update`. Now I've already run `brew update` on my system and if you've recently done it then you don't have to either. Brew update will just make sure that you have the latest version of homebrew if you already had it installed.  After that  run `brew install mongodb`.  If you run that then homebrew will go out and  find all the dependencies and build the entire system for you and you will be up and running with it. I already have Mongo on my system so I do not need to run the command but it's a pretty basic command to run. You don't have to be an sudo or anything like that for this specific command. Now after that has run then go and create a data directory. To do this  you're going to type in `mkdir -p /data/db`. 

This is the directory that Mongo needs because that's where it's going to store all of the data and it's going to store it right inside of this directory. So I already have this on my system and the way I can know that is if I type ls and then run it. You can see that I have each one of the collections right here. If you are new to Mongo and you don't have it installed on your system then you need to create that directory. Now another thing that you will have to do is you're going to have to update the permissions on this directory so type in

sudo chown -R `id -un`  /data/db 


 What that's going to do is it's going to update the permissions for that directory so that you can run all of the various commands and we can actually get going with Mongo. So once you type that you'll have to enter your password in and then you will be good to go. Now I've already run that so I don't need to run that specific command. Once you've gone through all of that the way that you can test to make sure that your system is working is to startup the Mongo. It's called the Mongo demon and so you can type in `mongod` just like that and if you hit return it should start everything up. Now you can open up in a new terminal by typing `command t` and now if I just type `mongo` it's going to open up a mongo shell for me right here and I can get up and running. So if you follow all those commands you'll be able to get Mongo on your system and you can start with the rest of the course. 

## Resources

- [Updated Installation and Configuration Guide (2023)](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/)
- [Installation and Configuration Guide](https://treehouse.github.io/installation-guides/mac/mongo-mac.html)
```
