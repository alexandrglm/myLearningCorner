# 04-004    LAB 01 - Exceptions in Java

When something is correct in most circumstances but is different or off-beat once in a while, it is called an exception. In Java, it is the same.   

**Exceptions are events that disrupt the normal flow of a program.**   

Say for example when you are dividing numbers based on numbers input by a user. The expectation is that the user will never enter 0 as the divisor as zero division is invalid. But if the user enters 0, it is an exceptional case which you have to handle.

## Types of Exceptions

- **`CHECKED Exceptions`** – These are exceptions that are checked at compile-time. The programmer must handle or declare them.

- **`UNCHECKED Exceptions`** – These are exceptions that are checked at runtime. They are usually caused by logical errors in the code. You may have encountered this kind of exceptions in some of the labs you have done so far in the course.

---

## Step 1: Create a Project Directory

Run the following command:

```bash
mkdir my_exception_proj
```

## Step 2: Create the Directory Structure

Run the following code to create the directory structure:

```bash
mkdir -p my_exception_proj/src
mkdir -p my_exception_proj/classes
mkdir -p my_exception_proj/test
cd my_exception_proj
```

## Step 3: Create ExceptionTrial.java File

Create a file named `ExceptionTrial.java` inside the src directory:

```bash
touch /home/project/my_exception_proj/src/ExceptionTrial.java
```

Click the following button to open the file for editing.

## Step 4: Add Program Content

Read each statement in the following code carefully. What kind of exception do you think you may encounter in the code? Copy and paste it in `ExceptionTrial.java`:

```java
import java.util.Scanner;

public class ExceptionTrial {
    public static void main(String s[]) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        // Initialise an array to store up to 5 strings
        String strArr[] = new String[5];
        // Variable to track the current index for adding strings
        int strIdx = 0;
        // Infinite loop to keep the program running until the user chooses to exit
        while (true) {
            // Display the menu options to the user
            System.out.println(
                "Press 1 to add String, " +
                "\n2 to get String from a particular index, " +
                "\n3 to get the length string in any index, " +
                "\n4 to get all the strings in the array " +
                "\nany other key to exit");
            // Read the user's choice
            String userAction = scanner.nextLine();
            // Option 1: Add a string to the array
            if (userAction.equals("1")) {
                // Check if the array is already full
                if (strIdx == 5) {
                    System.out.println("There are already 5 strings in the array!");
                } else {
                    // Prompt the user to enter a string
                    System.out.println("Enter the String ");
                    String inputStr = scanner.nextLine();
                    // Add the string to the array and increment the index
                    strArr[strIdx++] = inputStr;
                }
            }
            // Option 2: Retrieve a string from a specific index
            else if (userAction.equals("2")) {
                // Prompt the user to enter the index
                System.out.println("Enter the index you want to retrieve ");
                int retIdx = Integer.parseInt(scanner.nextLine());
                // Retrieve and print the string at the specified index
                System.out.println(strArr[retIdx]);
            }
            // Option 3: Get the length of a string at a specific index
            else if (userAction.equals("3")) {
                // Prompt the user to enter the index
                System.out.println("Enter the index you check the length of ");
                int retIdx = Integer.parseInt(scanner.nextLine());
                // Retrieve the string at the specified index and print its length
                System.out.println(strArr[retIdx].length());
            }
            // Option 4: Get all the strings in the array
            else if (userAction.equals("4")) {
                for (int i=0; i<5; i++) {
                    System.out.println(strArr[i]);
                }
            }
            // Exit the program if the user enters any other key
            else {
                break;
            }
        }
    }
}
```

### Program Overview

The program is interactive and allows the user to perform operations on an array of strings. It demonstrates basic input/output, array manipulation, and control flow.

This program allows the user to:

- Add strings to an array
- Retrieve a string from a specific index in the array
- Get the length of a string at a specific index
- Get all the strings in the array
- Exit the program

### Potential Exceptions

As you look through the code, you will see possibilities of exceptions:

- **`ArrayIndexOutOfBoundsException`** – If the user enters an index greater than or equal to 5 (or less than 0), it will throw an `ArrayIndexOutOfBoundsException`

- **`NullPointerException`** – If the user tries to retrieve the length of a string at an index that hasn't been populated yet, it will throw a `NullPointerException`

- **`NumberFormatException`** – If the user enters a non-integer value when prompted for an index, `Integer.parseInt()` will throw a `NumberFormatException`

## Step 5: Compile the Java Program

Compile the Java program, specifying the destination directory as the classes directory that you created:

```bash
javac -d classes src/ExceptionTrial.java
```

## Step 6: Set the CLASSPATH Variable

Set the `CLASSPATH` variable:

```bash
export CLASSPATH=$CLASSPATH:/home/project/my_exception_proj/classes
```

## Step 7: Run the Program

Run the program and test with variable combinations:

```bash
java ExceptionTrial
```

---

## Observing Exceptions

As you see these exceptions have interrupted the flow of the program. The code abruptly exits when the exception is thrown. You can handle these exceptions to ensure that they don't interrupt the flow of the program.

### `ArrayIndexOutOfBoundsException`

When the index being retrieved is invalid (a valid integer but less than 0 or greater than 4, given the length of the array is 5):

```
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
1
Enter the String 
Sears Tower
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
2
Enter the index you want to retrieve 
7
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 5
        at ExceptionTrial.main(ExceptionTrial.java:49)
```

### `NumberFormatException`

When the index position is meant to be entered as a number but it is not:

```
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
3
Enter the index you check the length of 
two
Exception in thread "main" java.lang.NumberFormatException: For input string: "two"
        at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
        at java.base/java.lang.Integer.parseInt(Integer.java:588)
        at java.base/java.lang.Integer.parseInt(Integer.java:685)
        at ExceptionTrial.main(ExceptionTrial.java:56)
```

### `NullPointerException`

When the user tries to retrieve the length of a string at an index that hasn't been populated yet:

```
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
3
Enter the index you check the length of 
2
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "<local2>[<local5>]" is null
        at ExceptionTrial.main(ExceptionTrial.java:59)
```
