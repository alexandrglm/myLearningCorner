# 03-003 Lab: Creating a simple to-do list using ArrayLists

**Estimated time needed:** 20 minutes

In this lab, you will learn how to handle `ArrayList`s by creating a To-do `ArrayList` and providing it features to prioritize tasks and sort them by priority.

---

## Learning Objectives

After completing this lab, you will be able to:

- Understand how to work with `ArrayList`s
- Add entries to the `ArrayList`
- Manipulate the entries in an `ArrayList`
- Sort the entries in an `ArrayList`
- Filter the entries in an `ArrayList`

---

## A) ArrayList

An **Array** is a fixed-size, ordered collection of elements of the same type. For example, `int[] iArr = new int[5]` is an `int` array of size 5. An **`ArrayList`** is a class that helps to create a collection that is resizable and orderable and is part of the Java Collections Framework. In this lab, you will create a `Task` class and add objects of that to the `ArrayList`.

### Creating the Project Structure

- Create a project directory by running the following command.

```bash
mkdir my_arraylist_proj
```

- Run the following code to create the directory structure.

```bash
mkdir -p my_arraylist_proj/src
mkdir -p my_arraylist_proj/classes
mkdir -p my_arraylist_proj/test
cd my_arraylist_proj
```

- Now create a file named `Task.java` inside the `src` directory.

```bash
touch /home/project/my_arraylist_proj/src/Task.java
```

- Click the following button to open the file for editing.

- Copy and paste the code in `Task.java`.

```java
public class Task {
	public static int HIGH = 3;
	public static int MEDIUM = 2;
	public static int LOW = 1;

	public static String COMPLETED = "Completed";
	public static String IN_PROGRESS = "In Progress";
	public static String NEW = "New";

	private String taskName;
	private int priority = LOW;
	private String status = NEW;

	public Task(String taskName) {
		this.taskName = taskName;
	}

	public Task(String taskName, int priority) {
		this.taskName = taskName;
		this.priority = priority;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return this.status;
	}

	public int getPriority() {
		return this.priority;
	}

	public String toString() {
		return taskName.concat(" ").concat((priority+"")).concat(" ").concat(status);
	}
}
```

- Compile the Java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/Task.java
```

- Set the CLASSPATH variable.

```bash
export CLASSPATH=$CLASSPATH:/home/project/my_arraylist_proj/classes
```

### Creating the ArrayList Example

- Now create a file named `ArrayListExample.java` inside the `src` directory.

```bash
touch /home/project/my_arraylist_proj/src/ArrayListExample.java
```

- Click the following button to open the file for editing.

- Read each statement in the following code carefully. Copy and paste it into `ArrayListExample.java`.

```java
import java.util.Scanner;
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String s[]) {
        try {
            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);
            // Create an ArrayList to store Task objects (to-do list)
            ArrayList<Task> todoList = new ArrayList<Task>();

            // Infinite loop to keep the program running until the user chooses to exit
            while (true) {
                // Display the menu options to the user
                System.out.println(
                    "Press 1 to add a task, " +
                    "\n2 to view all the tasks " +
                    "\n3 to change status of tasks " +
                    "\n4 to delete a task " +
                    "\nAny other key to exit");

                // Read the user's choice
                String userAction = scanner.nextLine();

                // Option 1: Add a task to the to-do list
                if (userAction.equals("1")) {
                    // Prompt the user to enter a task description
                    System.out.println("Enter the task ");
                    String taskStr = scanner.nextLine();

                    // Prompt the user to enter the priority of the task
                    System.out.println("Enter Priority - 1 Low, 2 Medium, 3 High ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    // Validate the priority input (default to 1 if invalid)
                    priority = priority > 3 ? 1 : priority;

                    // Create a new Task object and add it to the to-do list
                    todoList.add(new Task(taskStr, priority));
					System.out.println("The task has been added to the list");

                }
                // Option 2: View all tasks in the to-do list
                else if (userAction.equals("2")) {
                    // Use forEach to print each task in the to-do list
                    todoList.forEach(task -> System.out.println(task));
                }
                // Option 3: Change the status of a task
                else if (userAction.equals("3")) {
                    // Prompt the user to enter the index of the task to update
                    System.out.println("Enter the index of the status you want to change ");
                    int chgIdx = Integer.parseInt(scanner.nextLine());

                    // Check if the index is valid
                    if (chgIdx > (todoList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        // Prompt the user to enter the new status for the task
                        System.out.println("Enter the new status for the task P for 'In Progress' or C for 'Completed'");
                        String updatedStatus = scanner.nextLine();

                        // Update the task status based on user input
                        if (updatedStatus.equalsIgnoreCase("P")) {
                            todoList.get(chgIdx).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            todoList.get(chgIdx).setStatus(Task.COMPLETED);
                        }
                    }
					System.out.println("The task has been changed in the list");
                }
                // Option 4: Delete a task
                else if (userAction.equals("4")) {
                    // Prompt the user to enter the index of the task to delete
                    System.out.println("Enter the index of the status you want to delete ");
                    int rmvIdx = Integer.parseInt(scanner.nextLine());

                    // Check if the index is valid
                    if (rmvIdx > (todoList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
						todoList.remove(rmvIdx);
						System.out.println("The task has been removed from the list");
                    }
                }
                // Exit the program if the user enters any other key
                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            // Handle invalid number input (e.g., non-integer input for priority or index)
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
```

### Program Features

The program displays a menu with options to:

- **Add a task** - The user is prompted to enter a task description and priority. The priority is validated to ensure it is within the range (1, 2, or 3). A new `Task` object is created and added to the `todoList`.
- **View all tasks** - The `forEach` method is used to iterate over the `todoList` and print each task.
- **Change the status of a task** - The user is prompted to enter the index of the task they want to update. The program checks if the index is valid. The user is prompted to enter the new status (`P` for "In Progress" or `C` for "Completed"). The status of the selected task is updated.
- **Delete a task** - The user is prompted to enter the index of the task they want to delete. The program checks if the index is valid. The task is deleted.
- **Exit the program**.

### Compiling and Running

- Compile the Java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/ArrayListExample.java
```

- Run the program and test with variable combinations.

```bash
java ArrayListExample
```

### Sample Output

A sample output would look like:

```plaintext
/home/project/my_arraylist_proj$ java ArrayListExample

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
     Any other key to exit
1

 Enter the task 
UNO

 Enter Priority:
   - 1 Low
   - 2 Medium
   - 3 High 
1

   The task has been added to the list succesfully!

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
     Any other key to exit
1

 Enter the task 
DOS

 Enter Priority:
   - 1 Low
   - 2 Medium
   - 3 High 
2

   The task has been added to the list succesfully!

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
     Any other key to exit
1

 Enter the task 
TRES

 Enter Priority:
   - 1 Low
   - 2 Medium
   - 3 High 
3

   The task has been added to the list succesfully!

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
     Any other key to exit
2
1 -  - Task Name: 'UNO' | Priority: 1 | Status: New
2 -  - Task Name: 'DOS' | Priority: 2 | Status: New
3 -  - Task Name: 'TRES' | Priority: 3 | Status: New

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
     Any other key to exit
4

 Enter the index of the status you want to delete... 
2

   The task has been removed from the list successfully!

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
     Any other key to exit
2
1 -  - Task Name: 'UNO' | Priority: 1 | Status: New
2 -  - Task Name: 'TRES' | Priority: 3 | Status: New

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
     Any other key to exit
```

---

## B) Sort and Filter

The `Collection` class provides a `sort` method which takes a `Comparator` and compares two objects. In this case, you will compare the priority of tasks and sort the tasks from High to Low.

- Click the following button to open the file for editing, if it is not already open.

- Replace the existing code with the following code.

```java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ArrayListExample {
    public static void main(String s[]) {
        try {
            // Create a Scanner object to read user input
            Scanner scanner = new Scanner(System.in);
            // Create an ArrayList to store Task objects (to-do list)
            ArrayList<Task> todoList = new ArrayList<Task>();

            // Infinite loop to keep the program running until the user chooses to exit
            while (true) {
                // Display the menu options to the user
                System.out.println(
                    "Press 1 to add a task, " +
                    "\n2 to view all the tasks " +
                    "\n3 to change status of tasks " +
                    "\n4 to delete a task " +
                    "\n5 to sort the list based on priority " +
                    "\nAny other key to exit");

                // Read the user's choice
                String userAction = scanner.nextLine();

                // Option 1: Add a task to the to-do list
                if (userAction.equals("1")) {
                    // Prompt the user to enter a task description
                    System.out.println("Enter the task ");
                    String taskStr = scanner.nextLine();

                    // Prompt the user to enter the priority of the task
                    System.out.println("Enter Priority - 1 Low, 2 Medium, 3 High ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    // Validate the priority input (default to 1 if invalid)
                    priority = priority > 3 ? 1 : priority;

                    // Create a new Task object and add it to the to-do list
                    todoList.add(new Task(taskStr, priority));
					System.out.println("The task has been added to the list");

                }
                // Option 2: View all tasks in the to-do list
                else if (userAction.equals("2")) {
                    // Use forEach to print each task in the to-do list
                    todoList.forEach(task -> System.out.println(task));
                }
                // Option 3: Change the status of a task
                else if (userAction.equals("3")) {
                    // Prompt the user to enter the index of the task to update
                    System.out.println("Enter the index of the status you want to change ");
                    int chgIdx = Integer.parseInt(scanner.nextLine());

                    // Check if the index is valid
                    if (chgIdx > (todoList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
                        // Prompt the user to enter the new status for the task
                        System.out.println("Enter the new status for the task P for 'In Progress' or C for 'Completed'");
                        String updatedStatus = scanner.nextLine();

                        // Update the task status based on user input
                        if (updatedStatus.equalsIgnoreCase("P")) {
                            todoList.get(chgIdx).setStatus(Task.IN_PROGRESS);
                        } else if (updatedStatus.equalsIgnoreCase("C")) {
                            todoList.get(chgIdx).setStatus(Task.COMPLETED);
                        }
                    }
					System.out.println("The task has been changed in the list");
                }
                // Option 4: Delete a task
                else if (userAction.equals("4")) {
                    // Prompt the user to enter the index of the task to delete
                    System.out.println("Enter the index of the status you want to delete ");
                    int rmvIdx = Integer.parseInt(scanner.nextLine());

                    // Check if the index is valid
                    if (rmvIdx > (todoList.size() - 1)) {
                        System.out.println("There is no such index position in the list");
                    } else {
						todoList.remove(rmvIdx);
						System.out.println("The task has been removed from the list");
                    }
                }
				// Option 5: Sort tasks by priority
                else if (userAction.equals("5")) {
					// Sort the ArrayList by age using a Comparator
        			Collections.sort(todoList, new Comparator<Task>() {
	            		@Override
	            		public int compare(Task t1, Task t2) {
	            			return Integer.compare(t2.getPriority(), t1.getPriority());
	            		}
        			});
                    System.out.println("Tasks sorted by priority (High to Low):");
                    todoList.forEach(task -> System.out.println(task));
                }
                // Exit the program if the user enters any other key
                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            // Handle invalid number input (e.g., non-integer input for priority or index)
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}
```

### Compiling and Running with Sort Feature

- Compile the Java program, specifying the destination directory as the classes directory that you created.

```bash
javac -d classes src/ArrayListExample.java
```

- Run the program and test with variable combinations.

```bash
java ArrayListExample
```

### Sample Output with Sort Feature

Sample output would be as below:

```plaintext
/home/project/my_arraylist_proj$ javac -d classes src/*.java
theia@theia-alexandrgome:/home/project/my_arraylist_proj$ java ArrayListExample

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
   5 to SORT and FILTER list based on Priority
     Any other key to exit
1

 Enter the task 
UNO

 Enter Priority:
   - 1 Low
   - 2 Medium
   - 3 High 
1

   The task has been added to the list succesfully!

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
   5 to SORT and FILTER list based on Priority
     Any other key to exit
1  

 Enter the task 
DOS

 Enter Priority:
   - 1 Low
   - 2 Medium
   - 3 High 
2

   The task has been added to the list succesfully!

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
   5 to SORT and FILTER list based on Priority
     Any other key to exit
1

 Enter the task 
TRES

 Enter Priority:
   - 1 Low
   - 2 Medium
   - 3 High 
3

   The task has been added to the list succesfully!

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
   5 to SORT and FILTER list based on Priority
     Any other key to exit
1

 Enter the task 
CUATRO

 Enter Priority:
   - 1 Low
   - 2 Medium
   - 3 High 
2

   The task has been added to the list succesfully!

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
   5 to SORT and FILTER list based on Priority
     Any other key to exit
5

 Tasks sorted by Priority (HIGH to LOW):

 Task Index: 1 -  - Task Name: 'TRES' | Priority: 3 | Status: New

 Task Index: 2 -  - Task Name: 'DOS' | Priority: 2 | Status: New

 Task Index: 3 -  - Task Name: 'CUATRO' | Priority: 2 | Status: New

 Task Index: 4 -  - Task Name: 'UNO' | Priority: 1 | Status: New

   1 to ADD a task 
   2 to PRINT ALL the tasks 
   3 to GET and SETTER a new status of tasks 
   4 to REMOVE a task 
   5 to SORT and FILTER list based on Priority
     Any other key to exit
```

---

## C) Practice Exercise

- Create a class `Student` with attributes such as `name`, `age` and `major`. Create a console menu to add, update, delete items in the list and sort the students by age.

RESULTS:
```:/home/project/my_arraylist_proj$ java Student

 // STUDENTS MENU //

   1 to ADD an user 
   2 to UPDATE an user data 
   3 to DELETE an user 
   4 to SORT students by AGE
     Any other key to exit
1

  Student name?:
Pepito One 

  Student age?:
22

  Student Major?:
MAths

   The Student has been added to the list succesfully!

 // STUDENTS MENU //

   1 to ADD an user 
   2 to UPDATE an user data 
   3 to DELETE an user 
   4 to SORT students by AGE
     Any other key to exit
1

  Student name?:
Juanito TWO

  Student age?:
33

  Student Major?:
English

   The Student has been added to the list succesfully!

 // STUDENTS MENU //

   1 to ADD an user 
   2 to UPDATE an user data 
   3 to DELETE an user 
   4 to SORT students by AGE
     Any other key to exit
1

  Student name?:
Menganito Juarez

  Student age?:
18

  Student Major?:
Economy

   The Student has been added to the list succesfully!

 // STUDENTS MENU //

   1 to ADD an user 
   2 to UPDATE an user data 
   3 to DELETE an user 
   4 to SORT students by AGE
     Any other key to exit
4

 Student Lists order by (ascending) AGE:

 Student Index: 1 | Student Name: Menganito Juarez | Age: 18 | Major: Economy

 Student Index: 2 | Student Name: Pepito One | Age: 22 | Major: MAths

 Student Index: 3 | Student Name: Juanito TWO | Age: 33 | Major: English

 // STUDENTS MENU //

   1 to ADD an user 
   2 to UPDATE an user data 
   3 to DELETE an user 
   4 to SORT students by AGE
     Any other key to exit
2

 SELECT the user by its index to edit update data:

 Student Index: 1 | Student Name: Menganito Juarez | Age: 18 | Major: Economy

 Student Index: 2 | Student Name: Pepito One | Age: 22 | Major: MAths

 Student Index: 3 | Student Name: Juanito TWO | Age: 33 | Major: English
1

  Student name? (Original value: Menganito Juarez):
Menganito Juarez but Edited

  Student age? (Original value: 18):
55

  Student Major? (Original value: Economy):
Physics 

   The student data has been updated succesfully!

 // STUDENTS MENU //

   1 to ADD an user 
   2 to UPDATE an user data 
   3 to DELETE an user 
   4 to SORT students by AGE
     Any other key to exit
4

 Student Lists order by (ascending) AGE:

 Student Index: 1 | Student Name: Pepito One | Age: 22 | Major: MAths

 Student Index: 2 | Student Name: Juanito TWO | Age: 33 | Major: English

 Student Index: 3 | Student Name: Menganito Juarez but Edited | Age: 55 | Major: Physics

 // STUDENTS MENU //

   1 to ADD an user 
   2 to UPDATE an user data 
   3 to DELETE an user 
   4 to SORT students by AGE
     Any other key to exit
```
