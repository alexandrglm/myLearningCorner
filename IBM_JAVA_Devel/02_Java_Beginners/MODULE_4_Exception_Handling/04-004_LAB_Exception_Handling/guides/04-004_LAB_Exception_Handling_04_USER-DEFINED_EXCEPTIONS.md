# 04-004 LAB 04 - User-Defined Exceptions

You can create your own checked exceptions to handle situations like validation.  
Let's assume you want to check that the student age is never less than 18.

---

## Step 1: Create StudentUnderAgeException.java File

Create a new file named `StudentUnderAgeException.java`:

```bash
touch src/StudentUnderAgeException.java
```

Click the following button to open the file for editing, if it is not already open.

## Step 2: Add Custom Exception Code

Read each statement in the following code and paste it in `StudentUnderAgeException.java`:

```java
// Custom exception class for underage students
public class StudentUnderAgeException extends Exception {
    public StudentUnderAgeException(String message) {
        super(message);
    }
}
```

## Step 3: Compile the Custom Exception

Compile the code:

```bash
javac -d classes src/StudentUnderAgeException.java
```

## Step 4: Edit StudentManagement.java

Edit `StudentManagement.java` to handle the age validation. If age is not a number it should handle `NumberFormatException`. If age is a number but is less than 18, it should handle the `StudentUnderAgeException`:

```java
import java.util.Scanner;

// Student class implementing Cloneable interface
class Student implements Cloneable {
    // Fields
    private String name;
    private int age;
    private String major;
    
    // Constructor
    public Student(String name, int age, String major) throws StudentUnderAgeException {
        this.name = name;
        // Check if the provided age is less than 18
        if (age < 18) {
            // If the age is less than 18, throw a StudentUnderAgeException
            // with a custom error message
            throw new StudentUnderAgeException("Student age has to be 18 or more");
        }
        // If the age is valid (18 or older), set the age field to the provided value
        this.age = age;
        this.major = major;
    }
    
    // Getter and Setter methods
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getMajor() {
        return major;
    }
    
    // Override toString() method to provide a string representation of the object
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", major=" + major + "]";
    }
    
    // Override clone() method to support cloning
    @Override
    public Student clone() throws CloneNotSupportedException {
        // Call the clone() method of the Object class
        return (Student) super.clone();
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter student name");
            String name = scanner.nextLine();
            System.out.println("Enter student age");
            int age = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter student major");
            String major = scanner.nextLine();
            // Create a Student object
            Student student1 = new Student(name, age, major);
            Student student2 = student1.clone();
            System.out.println("Student: " + student1+ " successfully created!");
            System.out.println("Student: " + student2+ " successfully cloned!");
        } catch(CloneNotSupportedException cnse) {
            System.out.println("You can't clone this object!");
        } catch (NumberFormatException nfe) {
            System.out.println("Age has to be a number");
        } catch(StudentUnderAgeException suae) {
            System.out.println(suae.getMessage());
        }
    }
}
```

## Step 5: Compile the Updated Code

Compile the code:

```bash
javac -d classes src/StudentManagement.java
```

## Step 6: Run the Program

Run the code:

```bash
java StudentManagement
```

---

## Sample Output

### `NumberFormatException` Handled

```
Enter student name
Lav
Enter student age
forty
Age has to be a number
```

### `StudentUnderAgeException` Handled

```
Enter student name
Lav
Enter student age
17
Enter student major
Data Science
Student age has to be 18 or more
```
