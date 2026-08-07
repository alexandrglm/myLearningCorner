# 01-008    Lab 06 - Creating a Project and Organising in a Directory

## Introduction

Though what you have started off with is a simple program, Java is used for most advanced projects and becomes manageable when the code is organized within a project structure. It is a good habit to start with that right at the outset.

## Step 1: Create a Project Directory

Create a project directory by running the following command:

```bash
mkdir my_first_proj
```

## Step 2: Create Directory Structure

Within the project directory, segregate the source file, the output files, and the test files. Run the following code to create the directory structure:

```bash
mkdir -p my_first_proj/src
mkdir -p my_first_proj/classes
mkdir -p my_first_proj/test
cd my_first_proj
```

## Step 3: Move the Source File

Move the `MyFirstProgram.java` from the default directory where you created it, to the project's `src` directory:

```bash
mv /home/project/MyFirstProgram.java src
```

## Step 4: Remove the Old Class File

Remove the old class file that was created by compiling the Java code:

```bash
rm /home/project/MyFirstProgram.class
```

## Step 5: Compile with Output Directory

Compile the Java program, this time explicitly specifying the destination directory as the `classes` directory that you created:

```bash
javac -d classes src/MyFirstProgram.java
```

## Step 6: Try Running the Program

Try to run the Java program as done before:

```bash
java MyFirstProgram
```

This will throw `ClassNotFoundException`.

This is because the class file is not in the default directory. You need to tell the system where to look for the class file. The path where Java looks for classes is called the **classpath**.

## Step 7: Set the CLASSPATH Variable

Set the CLASSPATH variable:

```bash
export CLASSPATH=$CLASSPATH:/home/project/my_first_proj/classes
```

## Step 8: Run the Program Again

Now when you run the Java program, it will run seamlessly as expected:

```bash
java MyFirstProgram
```
