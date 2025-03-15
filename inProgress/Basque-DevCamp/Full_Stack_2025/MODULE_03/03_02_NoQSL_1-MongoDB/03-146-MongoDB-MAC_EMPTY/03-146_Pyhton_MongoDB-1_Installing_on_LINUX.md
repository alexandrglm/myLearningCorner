# Module 03 - 146: MongoDB (1)

The original guide explains how to install MongoDB for MAC users but,so that for those Linux users, these steps explains how to set it up.  

Additionally, this guide explains how to install MongoDB without it being system-wide, as well as installing it system-wide.   

I recommend the first option.

****

# Installing MongoDB on Linux

****

## A. Via Docker:

If you want even greater isolation, you can use Docker to run MongoDB in a container.   

This ensures MongoDB doesn’t interact with your system at all.

1. **Install Docker**:
   
   - Follow the official instructions to install Docker: [Install Docker](https://docs.docker.com/engine/install/).

2. **Run MongoDB in a Container**:
   
   - Use the following command to start a MongoDB container:
     
     ```bash
     docker run -d --name mongodb-course -p 27017:27017 -v ~/projects/mongodb-course/data/db:/data/db mongo
     ```
- This mounts the `~/projects/mongodb-course/data/db` folder to the container for data persistence.
3. **Connect to the Container**:
   
   - Use the `mongo` shell to connect to the container:
     
     ```bash
     mongo --host 127.0.0.1 --port 27017
     ```

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
     
     ```bash
     tar -xvzf mongodb-linux-x86_64-<version>.tgz
     ```
   
   - Move the extracted folder to your project directory (e.g., `~/projects/mongodb-course`):
     
     ```bash
     mv mongodb-linux-x86_64-<version> ~/projects/mongodb-course/mongodb
     ```

****

### **2. Set Up MongoDB for Your Project**

Now that you have the binaries in your project folder, configure MongoDB to run in an isolated environment.

1. **Create Data and Logs Folders**:
   
   1. MongoDB needs a folder to store data and another for logs. Create these folders inside your project directory:
      
      ```bash
      mkdir -p ~/projects/mongodb-course/data/db
      mkdir -p ~/projects/mongodb-course/logs
      ```

2. **Create a Configuration File**:
   
   1. Create a configuration file (`mongod.conf`) in your project folder:
      
      ```bash
      nano ~/projects/mongodb-course/mongod.conf
      ```
   
   2. Add the following basic configuration:
      
      ```bash
      storage:
        dbPath: /home/<your-username>/projects/mongodb-course/data/db
      systemLog:
        destination: file
        path: /home/<your-username>/projects/mongodb-course/logs/mongod.log
        logAppend: true
      net:
        bindIp: 127.0.0.1
        port: 27017
      ```
   
   3. Save and close the file.

****

### **3. Run MongoDB**

You can now start MongoDB from your project folder.

1. **Start the MongoDB Server**:
   
   * Navigate to the `bin` folder inside the extracted MongoDB directory:
     
     ```bash
     cd ~/projects/mongodb-course/mongodb/bin
     ```
   
   * Start the MongoDB server using the configuration file:
     
     ```bash
     ./mongod --config ~/projects/mongodb-course/mongod.conf
     ```

2. **Verify MongoDB is Running**:
   
   * Open another terminal and connect to MongoDB using the `mongo` shell:
     
     ```bash
     ./mongo --host 127.0.0.1 --port 27017
     ```
   
   * If the connection is successful, you’ll see the MongoDB shell prompt.

****

### **4. Stop MongoDB**

When you’re done working with MongoDB, stop the server by pressing `Ctrl + C` in the terminal where it’s running.

****

### **5. Using MongoDB in Your Project**

Now that MongoDB is running, you can use it for your project. Here are some basic commands to get started:

#### **Create a Database**

```bash
use mydatabase
```

#### **Create a Collection**

```bash
db.createCollection("mycollection")
```

#### **Insert a Document**

```bash
db.mycollection.insertOne({ name: "Alice", age: 25 })
```

#### **Query Documents**

```bash
db.mycollection.find({ age: { $gt: 20 } })
```

#### **Delete a Database**

```bash
db.dropDatabase()
```

****

### **6. Clean Up**

When you’re done with the course, simply delete the project folder to remove MongoDB:

```bash
rm -rf ~/projects/mongodb-course
```

If you used Docker, stop and remove the container:

```bash
docker stop mongodb-course
docker rm mongodb-course
```

****

# C. Via apt, SYSTEM-WIDE (Be careful)



### Step 1: Install MongoDB

To install MongoDB, use the package manager of your distribution:

- **Debian/Ubuntu:**  `sudo apt update & sudop apt install -y mongodb`
- **Fedora**:  `sudo dnf install -y mongodb`
- **Arch Linux (AUR package available):** `yay -S mongodb-bin`

### Step 3: Create the Data Directory

MongoDB stores its data in `/data/db`. You need to create this directory manually:

```bash
sudo mkdir -p /data/db
sudo chown -R `id -un` /data/db
```

### Step 4: Start MongoDB

To start the MongoDB daemon, run:

```bash
mongod
```

You can verify if MongoDB is running by opening a new terminal and typing:  

```bash
mongo
```

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

```
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

and then open up your terminal and paste it in. So here is the terminal. So if you do not have a brew already installed then you can run it right here and it will go through, it might take a few minutes but it will install and then once you have that you'll be ready to install Mongo. The first command to run will be `brew update`. Now I've already run `brew update` on my system and if you've recently done it then you don't have to either. Brew update will just make sure that you have the latest version of homebrew if you already had it installed.  After that  run `brew install mongodb`.  If you run that then homebrew will go out and  find all the dependencies and build the entire system for you and you will be up and running with it. I already have Mongo on my system so I do not need to run the command but it's a pretty basic command to run. You don't have to be an sudo or anything like that for this specific command. Now after that has run then go and create a data directory. To do this  you're going to type in `mkdir -p /data/db`. 

This is the directory that Mongo needs because that's where it's going to store all of the data and it's going to store it right inside of this directory. So I already have this on my system and the way I can know that is if I type ls and then run it. You can see that I have each one of the collections right here. If you are new to Mongo and you don't have it installed on your system then you need to create that directory. Now another thing that you will have to do is you're going to have to update the permissions on this directory so type in

```
sudo chown -R `id -un`  /data/db 
```

 What that's going to do is it's going to update the permissions for that directory so that you can run all of the various commands and we can actually get going with Mongo. So once you type that you'll have to enter your password in and then you will be good to go. Now I've already run that so I don't need to run that specific command. Once you've gone through all of that the way that you can test to make sure that your system is working is to startup the Mongo. It's called the Mongo demon and so you can type in `mongod` just like that and if you hit return it should start everything up. Now you can open up in a new terminal by typing `command t` and now if I just type `mongo` it's going to open up a mongo shell for me right here and I can get up and running. So if you follow all those commands you'll be able to get Mongo on your system and you can start with the rest of the course. 

## Resources

- [Updated Installation and Configuration Guide (2023)](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-os-x/)
- [Installation and Configuration Guide](https://treehouse.github.io/installation-guides/mac/mongo-mac.html)
