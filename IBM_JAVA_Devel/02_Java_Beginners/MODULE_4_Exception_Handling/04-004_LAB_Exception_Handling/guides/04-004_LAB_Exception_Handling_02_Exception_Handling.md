# 04-004    LAB 02 - Exception Handling

You will now work with the same program, but this time you will handle the exceptions so the program can continue to work until the user opts out.

---

## Step 1: Open the File for Editing

Click the following button to open the file for editing, if it is not already open.

## Step 2: Replace with Updated Code

Replace the existing code with the following code that includes exception handling:

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
                try {
                    // Prompt the user to enter the index
                    System.out.println("Enter the index you want to retrieve ");
                    int retIdx = Integer.parseInt(scanner.nextLine());
                    System.out.println("String at index " + retIdx + ": " + strArr[retIdx]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid index! Please enter an index between 0 and " + (strArr.length - 1));
                }
            }
            // Option 3: Get the length of a string at a specific index
            else if (userAction.equals("3")) {
                try {
                    // Prompt the user to enter the index
                    System.out.println("Enter the index you check the length of ");
                    int retIdx = Integer.parseInt(scanner.nextLine());
                    System.out.println("Length of string at index " + retIdx + ": " + strArr[retIdx].length());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid index! Please enter an index between 0 and " + (strArr.length - 1));
                } catch (NullPointerException e) {
                    System.out.println("No string exists at the specified index!");
                }
            }
            // Option 4: Get all the strings in the array
            else if (userAction.equals("4")) {
                System.out.println("Strings in the array:");
                for (int i = 0; i < strIdx; i++) {
                    if (strArr[i] != null) {
                        System.out.println("Index " + i + ": " + strArr[i]);
                    } else {
                        System.out.println("Index " + i + ": (null)");
                    }
                }
            }
            // Exit the program if the user enters any other key
            else {
                break;
            }
        }
        // Close the scanner to avoid resource leak
        scanner.close();
    }
}
```

## Step 3: Compile the Java Program

Compile the Java program, specifying the destination directory as the classes directory that you created:

```bash
javac -d classes src/ExceptionTrial.java
```

## Step 4: Run the Program

Run the program and test with variable combinations:

```bash
java ExceptionTrial
```

---

## Observing Exception Handling

With the updated code, the program now gracefully handles exceptions and continues running. Here are some examples:

### `ArrayIndexOutOfBoundsException` Handled

When the index being retrieved is invalid:

```
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
2
Enter the index you want to retrieve 
7
Invalid index! Please enter an index between 0 and 4
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
```

### `NumberFormatException` Handled

When the index position is meant to be entered as a number but it is not:

```
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
2
Enter the index you want to retrieve 
two
Invalid input! Please enter a valid integer.
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
```

### `NullPointerException` Handled

When the user tries to retrieve the length of a string at an index that hasn't been populated yet:

```
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
3
Enter the index you check the length of 
4
No string exists at the specified index!
Press 1 to add String, 
2 to get String from a particular index, 
3 to get the length string in any index, 
4 to get all the strings in the array 
any other key to exit
```
