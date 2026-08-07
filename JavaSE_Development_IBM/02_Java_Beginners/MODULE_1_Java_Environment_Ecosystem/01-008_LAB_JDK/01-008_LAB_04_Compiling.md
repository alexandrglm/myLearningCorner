# 01-008     Lab 04 - Compiling the Java Program

To compile a Java program, run the `javac` command followed by the name of the file you need to compile.

## Step 1: Compile the Program

```bash
javac MyFirstProgram.java
```

If all the steps were done correctly, this command will not produce any console output. It will create `MyFirstProgram.class` in the current directory. The file is in unreadable bytecode format.

## Step 2: Verify the Compiled Class

List the compiled class files:

```bash
ls *.class
```

You should see `MyFirstProgram.class` listed.

## Step 3: Run the Program

Run the class by executing the following command:

```bash
java MyFirstProgram
```

Please note that you don't have to specify the `.class` extension. You just need to specify the name of the class and the system by default will look for the class in the current directory.

The output should appear as:

```
Hello World!
```

## Step 4: Modify the Program

Now change the code to print "Welcome to Java Programming!" in addition to "Hello World!". Add the following code below the previous print statement:

```java
System.out.println("Welcome to Java Programming!");
```

Your updated program should look like this:

```java
public class MyFirstProgram {
    public static void main(String s[]) {
        System.out.println("Hello World!");
        System.out.println("Welcome to Java Programming!");
    }
}
```

## Step 5: Recompile the Program

The Java program needs to be recompiled every time a change is made, and the old `.class` file will be overwritten with the updated one:

```bash
javac MyFirstProgram.java
```

## Step 6: Run the Updated Program

Run the class by executing the following command:

```bash
java MyFirstProgram
```

The output should now appear as:

```
Hello World!
Welcome to Java Programming!
```
