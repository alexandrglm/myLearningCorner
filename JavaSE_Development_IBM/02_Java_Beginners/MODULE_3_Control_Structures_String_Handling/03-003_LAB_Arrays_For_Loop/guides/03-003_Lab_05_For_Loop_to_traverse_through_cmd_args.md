# 03-003 LAB 05 - For Loops to Traverse Through Command Line Arguments

Command line arguments are code that you provide after `java <classname>` when you run a Java program. Command line arguments are useful ways you can provide user input to the program.

## Step 1: Open the File

Click the **Open ArrayAccess.java in IDE** button to open the file for editing if the IDE environment is not already open.

## Step 2: Add Program Content

Read each statement in the following program to understand how the method considers the `main` method's input parameters. Paste the following content in `ArrayAccess.java`:

```java
public class ArrayAccess {
    public static void main(String s[]) {
        int num_args = s.length;
        System.out.println("the length of the array is " + num_args);
        for (int i=0; i<num_args; i++) {
            System.out.println(s[i]);
        }
    }
}
```

### Code Explanation

- **`int num_args = s.length;`** - Creates a variable named `num_args` and stores the value of the length of the array of command line arguments in it.

## Step 3: Compile the Java Program

Compile the Java program, specifying the destination directory using the classes directory that you previously created:

```bash
javac -d classes src/ArrayAccess.java
```

## Step 4: Run the Java Program (Without Arguments)

Now run the Java program:

```bash
java ArrayAccess
```

You will not see any output as the code did not pass command line arguments.

## Step 5: Run the Java Program (With Arguments)

Run the Java program again. However, with this run include the following command line arguments when running the program:

```bash
java ArrayAccess first second third fourth fifth
```

Here `first`, `second`, `third`, `fourth`, and `fifth` are command line arguments.

### Expected Output

You will see the following output:

```
the length of the array is 5
first
second
third
fourth
fifth
```

You can see that the loop iterated through the command line arguments array for as long as there was an element remaining to process. The code also printed the element details.
