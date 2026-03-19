# 03-007 Lab: HashMap Phonebook

**Estimated time needed:** 20 minutes

In this lab, you will learn how to handle `HashMap`s. You will learn to add items, search for items, and remove items.

---

## Learning Objectives

After completing this lab, you will be able to:

- Understand `HashMap` as a collection
- Add new keys and respective values to a `HashMap`
- Search for existing values using the key
- Delete entries from `HashMap`
- View the entries in a sorted order of values

---

## A) HashMap

### What is a HashMap?

A `HashMap` is like a dictionary or a lookup table. It stores data in pairs, where each pair consists of a key and a value. You can think of it as a real-life dictionary. The key is like the word you look up and the value is like the definition of that word.

In a `HashMap`, you use the key to quickly find the value associated with it. Each key must be unique (no duplicates), but values can be repeated.

### Phone Number Validation with Regex

To validate the phone numbers, there are many combinations of regex you will be able to find when you search. In this lab, you will use regex (Regular expression) pattern matching.

**Regex Pattern:**

```
\+?\d{1,4}?[-.\s]?\(?\d{1,3}?\)?[-.\s]?\d{1,4}[-.\s]?\d{1,9}
```

| Pattern                 | Description                                                                        |
| ----------------------- | ---------------------------------------------------------------------------------- |
| `\+?`                   | Optional plus sign (`+`) for international numbers                                 |
| `\d{1,4}?`              | Country code (1-4 digits)                                                          |
| `[-.\s]?`               | Optional separator (dash, dot, or whitespace)                                      |
| `\(?\d{1,3}?`           | Optional area code (1-3 digits) enclosed in parentheses                            |
| `[-.\s]?`               | Optional separator                                                                 |
| `\d{1,4}[-.\s]?\d{1,9}` | Local phone number (1-4 digits, followed by an optional separator, and 1-9 digits) |


**Note on Escape Characters:**

As the regex has `\` which is an escape character, you will need to precede it with another escape character.

```java
"\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}"
```

An **escape character** is a special character that is used to change the meaning of the character that follows it. It is called an "escape" character because it allows you to "escape" the normal interpretation of the next character.

### Creating the Project Structure

- Create a project directory by running the following command.

```bash
mkdir my_hashmap_proj
```

- Run the following code to create the directory structure.

```bash
mkdir -p my_hashmap_proj/src
mkdir -p my_hashmap_proj/classes
mkdir -p my_hashmap_proj/test
cd my_hashmap_proj
```

- Now create a file named `PhoneBookHashMap.java` inside the `src` directory.

```bash
touch /home/project/my_hashmap_proj/src/PhoneBookHashMap.java
```

- Click the following button to open the file for editing.

- Copy and paste the code in `PhoneBookHashMap.java`. Read the comments carefully to understand what the code does.

```java
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookHashMap {

    // Method to validate if the name contains only letters, spaces, hyphens, or apostrophes
    private static boolean isNameValid(String name) {
        if (name.matches("^[a-zA-Z' -]+$") == false) {
            System.out.println("Invalid name!");
            return false;
        }
        return true;
    }

    // Method to validate if the phone number matches a specific format
    private static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}") == false) {
            System.out.println("Invalid phone number!");
            return false;
        }
        return true;
    }

    public static void main(String s[]) {
        try {
            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);
            // Create a HashMap to store names (keys) and phone numbers (values)
            HashMap<String, String> phonebook = new HashMap<>();

            // Infinite loop to keep the program running until the user chooses to exit
            while (true) {
                // Display the menu options to the user
                System.out.println(
                    "Press 1 to add an entry in the phonebook," +
                    "\n2 to view all the entries" +
                    "\n3 to search for entries with name" +
                    "\n4 to delete an entry" +
                    "\nAny other key to exit");

                // Read the user's choice
                String userAction = scanner.nextLine();

                // Option 1: Add a name-number entry to the phonebook
                if (userAction.equals("1")) {
                    // Prompt the user to enter the name
                    System.out.println("Enter a name");
                    String name = scanner.nextLine();
                    // Validate the name format
                    if (!isNameValid(name)) {
                        continue; // Skip to the next iteration if the name is invalid
                    }
                    // Check if the name already exists in the phonebook
                    if (phonebook.containsKey(name)) {
                        System.out.println("This name already exists! Do you want to replace the number? y/n");
                        String repChoice = scanner.nextLine();
                        // If the user chooses not to replace, skip to the next iteration
                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }

                    // Prompt the user to enter the phone number
                    System.out.println("Enter the phone number");
                    String phoneNumber = scanner.nextLine();
                    // Validate the phone number format
                    if (!isPhoneNumberValid(phoneNumber)) {
                        continue; // Skip to the next iteration if the phone number is invalid
                    }
                    // Add the name and phone number to the HashMap
                    phonebook.put(name, phoneNumber);
                    System.out.println("The name and number have been added to the phonebook.");
                }
                // Option 2: View all the entries in the phonebook
                else if (userAction.equals("2")) {
                    // Iterate through the HashMap and print all key-value pairs
                    for (String name : phonebook.keySet()) {
                        System.out.println(name + ": " + phonebook.get(name));
                    }
                }
                // Option 3: Search for an entry by name
                else if (userAction.equals("3")) {
                    // Prompt the user to enter the name to search
                    System.out.println("Enter the name you want to search");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the phonebook
                    if (phonebook.containsKey(keyName)) {
                        // Display the phone number associated with the name
                        System.out.println("The phone number you are looking for is " +
                                    phonebook.get(keyName));
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                }
                // Option 4: Delete an entry by name
                else if (userAction.equals("4")) {
                    // Prompt the user to enter the name to delete
                    System.out.println("Enter the name you want to delete ");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the phonebook
                    if (phonebook.containsKey(keyName)) {
                        // Remove the entry from the HashMap
                        phonebook.remove(keyName);
                        System.out.println("The entry has been removed.");
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                }
                // Exit the program if the user enters any other key
                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            // Handle invalid number input (for example, non-integer input for priority or index)
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
```

### Program Description

The program is a phonebook management system implemented using a `HashMap`:

- `phoneBook` is `HashMap` that can hold entries, where key is the name of the person (unique) and value is the phone number.
- `isNameValid()` checks if the name contains only letters, spaces, hyphens, or apostrophes. It is used to handle invalid name input.
- `isPhoneNumberValid()` validates the phone number format using a regex pattern. It is used to handle invalid phone number input.

### Compiling and Running

- Compile the Java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/PhoneBookHashMap.java
```

- Set the CLASSPATH variable.

```bash
export CLASSPATH=$CLASSPATH:/home/project/my_hashmap_proj/classes
```

- Run the program and test with variable combinations.

```bash
java PhoneBookHashMap
```

### Sample Output

A sample output would look like:

```plaintext

 // PHONEBOOK TEST MENU //

   1 to ADD an entry in the phonebook,
   2 to LIST ALL the entries
   3 to SEARCH by name
   4 to REMOVE an entry
     Any other key to exit
1

 User NAME?: 
Pepe

 User PHONE NUMBER?: 
+1 555-123-7740

  New entry added succesfully! 

 // PHONEBOOK TEST MENU //

   1 to ADD an entry in the phonebook,
   2 to LIST ALL the entries
   3 to SEARCH by name
   4 to REMOVE an entry
     Any other key to exit
1

 User NAME?: 
INVALID NUMBER

 User PHONE NUMBER?: 
8965421.06543120.
Invalid Phone Number Format!

 // PHONEBOOK TEST MENU //

   1 to ADD an entry in the phonebook,
   2 to LIST ALL the entries
   3 to SEARCH by name
   4 to REMOVE an entry
     Any other key to exit
1

 User NAME?: 
Juan

 User PHONE NUMBER?: 
+34 (678) 910 123

  New entry added succesfully! 

 // PHONEBOOK TEST MENU //

   1 to ADD an entry in the phonebook,
   2 to LIST ALL the entries
   3 to SEARCH by name
   4 to REMOVE an entry
     Any other key to exit
2

 PHONEBOOK ALL ENTRIES:
Juan: +34 (678) 910 123
Pepe: +1 555-123-7740

 // PHONEBOOK TEST MENU //

   1 to ADD an entry in the phonebook,
   2 to LIST ALL the entries
   3 to SEARCH by name
   4 to REMOVE an entry
     Any other key to exit
3

 Please, provide a NAME to SEARCH: 
Pepe
The phone number for Pepe is: +1 555-123-7740

 // PHONEBOOK TEST MENU //

   1 to ADD an entry in the phonebook,
   2 to LIST ALL the entries
   3 to SEARCH by name
   4 to REMOVE an entry
     Any other key to exit
4

 Please, provide a NAME to be REMOVED: 
Juan

   Juanhas removed from phonebook succesfully! 

 // PHONEBOOK TEST MENU //

   1 to ADD an entry in the phonebook,
   2 to LIST ALL the entries
   3 to SEARCH by name
   4 to REMOVE an entry
     Any other key to exit
2

 PHONEBOOK ALL ENTRIES:
Pepe: +1 555-123-7740

 // PHONEBOOK TEST MENU //

   1 to ADD an entry in the phonebook,
   2 to LIST ALL the entries
   3 to SEARCH by name
   4 to REMOVE an entry
     Any other key to exit
q
```

---

## B) Sort and Store

Now that you have added, updated, and deleted entries, in this section, you will sort the `HashMap` by name and store the content to a file.

- Click the following button to open the file for editing, if it is not already open.

- Replace the existing code with the following code. This code has additional menu items to display names in sorted order using `TreeMap` and writing it onto a file using `java.io`.

Sorting can be implemented in more than one way. It can be done using `Comparator`, as you did in the `ArrayListExample`. But you will use `TreeMap`, a class in the `java.util` package, which is a navigable map implementation that sorts its entries based on the natural ordering of its keys.

```java
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PhoneBookHashMap {

    // Method to validate if the name contains only letters, spaces, hyphens, or apostrophes
    private static boolean isNameValid(String name) {
        if (name.matches("^[a-zA-Z' -]+$") == false) {
            System.out.println("Invalid name!");
            return false;
        }
        return true;
    }

    // Method to validate if the phone number matches a specific format
    private static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}") == false) {
            System.out.println("Invalid phone number!");
            return false;
        }
        return true;
    }

    public static void main(String s[]) {
        try {
            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);
            // Create a HashMap to store names (keys) and phone numbers (values)
            HashMap<String, String> phonebook = new HashMap<>();

            // Infinite loop to keep the program running until the user chooses to exit
            while (true) {
                // Display the menu options to the user
                System.out.println(
                    "Press 1 to add an entry in the phonebook," +
                    "\n2 to view all the entries" +
                    "\n3 to search for entries with name" +
                    "\n4 to delete an entry" +
                    "\n5 to sort the entries by name" +
                    "\n6 to write the entries onto a file" +
                    "\nAny other key to exit");

                // Read the user's choice
                String userAction = scanner.nextLine();

                // Option 1: Add a name-number entry to the phonebook
                if (userAction.equals("1")) {
                    // Prompt the user to enter the name
                    System.out.println("Enter a name");
                    String name = scanner.nextLine();
                    // Validate the name format
                    if (!isNameValid(name)) {
                        continue; // Skip to the next iteration if the name is invalid
                    }
                    // Check if the name already exists in the phonebook
                    if (phonebook.containsKey(name)) {
                        System.out.println("This name already exists! Do you want to replace the number? y/n");
                        String repChoice = scanner.nextLine();
                        // If the user chooses not to replace, skip to the next iteration
                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }

                    // Prompt the user to enter the phone number
                    System.out.println("Enter the phone number");
                    String phoneNumber = scanner.nextLine();
                    // Validate the phone number format
                    if (!isPhoneNumberValid(phoneNumber)) {
                        continue; // Skip to the next iteration if the phone number is invalid
                    }
                    // Add the name and phone number to the HashMap
                    phonebook.put(name, phoneNumber);
                    System.out.println("The name and number have been added to the phonebook.");
                }
                // Option 2: View all the entries in the phonebook
                else if (userAction.equals("2")) {
                    // Iterate through the phonebook and print all name-number pairs
                    for (String name : phonebook.keySet()) {
                        System.out.println(name + ": " + phonebook.get(name));
                    }
                }
                // Option 3: Search for an entry by name
                else if (userAction.equals("3")) {
                    // Prompt the user to enter the name to search
                    System.out.println("Enter the name you want to search");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the phonebook
                    if (phonebook.containsKey(keyName)) {
                        // Display the phone number associated with the name
                        System.out.println("The phone number you are looking for is " +
                                    phonebook.get(keyName));
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                }
                // Option 4: Delete an entry by name
                else if (userAction.equals("4")) {
                    // Prompt the user to enter the name to delete
                    System.out.println("Enter the name you want to delete ");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the phonebook
                    if (phonebook.containsKey(keyName)) {
                        // Remove the entry from the HashMap
                        phonebook.remove(keyName);
                        System.out.println("The entry has been removed.");
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                }
                // Option 5: Sort the entries by name
                else if (userAction.equals("5")) {
                    // Sort the phoneBook by keys using TreeMap
                    TreeMap phoneBookTreeMap = new TreeMap<String,String>(phonebook);
                    for (Object keyName : phoneBookTreeMap.keySet()) {
                        System.out.println(keyName + ": " + phoneBookTreeMap.get((String)keyName));
                    }
                }
                // Option 6: Write the entries to a text file
                else if (userAction.equals("6")) {
                    // Write the Phonebook entries to a file
                    try (PrintWriter writer = new PrintWriter(new FileWriter("phonebook.txt"))) {
                        for (String name : phonebook.keySet()) {
                            writer.println(name + ": " + phonebook.get(name));
                        }
                        System.out.println("The entries are written to a file");
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }
                }
                // Exit the program if the user enters any other key
                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            // Handle invalid number input (for example, non-integer input for priority or index)
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
```

### Additional Features

The enhanced version includes two new options:

- **Option 5: Sort by Name** - Uses `TreeMap` to sort the phonebook entries by name in alphabetical order
- **Option 6: Write to File** - Writes all phonebook entries to a file named `phonebook.txt` using `FileWriter` and `PrintWriter`

### Compiling and Running with Enhanced Features

- Compile the Java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/PhoneBookHashMap.java
```

- Run the program and test with variable combinations.

```bash
java PhoneBookHashMap
```

### File Output

The file will get written onto the same directory where you are running the code from. If you chose option 6 and wrote the phonebook onto a file, you should be able to see it when you click on the button below.

---

## C) Practice Exercise

- Create a `HashMap` which stores `TaskName` as key and the `Task` as value. The `Task` object should have the `name`, `description`, `priority` and `status`. You should be able to add, view, delete and update tasks.


RESULST:  
```
 Task Name: DOS
theia@theia-alexandrgome:/home/project/my_hashmap_proj$ java TodoList

  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
1

  Task NAME?: 
UNO ORIGINAL

  Task DESCRIPTION?: 
bla bla bla

  Task PRIORITY ( HIGH or MEDIUM or LOW ) ?: 
LOW

  Task STATUS ( PENDING or DONE ): 
PENDING

  New task ('UNO ORIGINAL') added successfully!

  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
2

 Todo List: 


 Task Name: UNO ORIGINAL
 Task Description: bla bla bla
 Task Priority: LOW
 Task Status: PENDING
  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
1

  Task NAME?: 
DOS ORIGINAL

  Task DESCRIPTION?: 
meh meh meh

  Task PRIORITY ( HIGH or MEDIUM or LOW ) ?: 
MEDIUM

  Task STATUS ( PENDING or DONE ): 
DONE

  New task ('DOS ORIGINAL') added successfully!

  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
2

 Todo List: 


 Task Name: DOS ORIGINAL
 Task Description: meh meh meh
 Task Priority: MEDIUM
 Task Status: DONE
 Task Name: UNO ORIGINAL
 Task Description: bla bla bla
 Task Priority: LOW
 Task Status: PENDING
  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
4

  Please enter the EXACT task NAME: 

    (Task NAME CANNOT BE RENAMED, so, if you need, DELETE IT)


adasd
The tasks does not exists, please type the exact name

  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
4

  Please enter the EXACT task NAME: 

    (Task NAME CANNOT BE RENAMED, so, if you need, DELETE IT)


DOS 
The tasks does not exists, please type the exact name

  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
4       

  Please enter the EXACT task NAME: 

    (Task NAME CANNOT BE RENAMED, so, if you need, DELETE IT)


DOS ORIGINAL

 WORKING WITH:  DOS ORIGINAL
   New Task DESCRIPTION (Actual: meh meh meh) ?: 
meh meh meh cambiado

   New Task PRIORITY (Actual: MEDIUM) ?: 
LOw

   New Task STATUS (Actual: DONE) ?: 
PENDING

  Task ('DOS ORIGINAL') UPDATED successfully!

  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
3

   Please, choose a task BY EXACT NAME to be removed: 
UNO ORIGINAL

  Taks ('UNO ORIGINAL') removed successfully!

  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
2

 Todo List: 


 Task Name: DOS ORIGINAL
 Task Description: meh meh meh cambiado
 Task Priority: LOw
 Task Status: PENDING
  ToDo List Demo Exercise: 

   1. ADD a task
   2. LIST ALL tasks
   3. REMOVE a task
   4. UPDATE task's data value
      Any other key to EXIT
^Ct
heia@theia-alexandrgome:/home/project/my_hashmap_proj$ 
```
