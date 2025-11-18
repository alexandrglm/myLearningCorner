# 04-004    LAB 03 - Checked Exceptions

**A checked exception is a type of exception that is checked at compile-time.**   

The compiler ensures that these exceptions are either handled using a `try-catch` block, or declared in the method signature using the `throws` keyword.   

If a checked exception is not handled or declared, the program will fail to compile.

---

## Step 1: Create StudentManagement.java File

Create a new file named `StudentManagement.java`:

```bash
touch src/StudentManagement.java
```

Click the following button to open the file for editing, if it is not already open.

## Step 2: Add Initial Code

Read each statement in the following program and focus on how the `clone` method throws `CloneNotSupportedException` and paste it in `StudentManagement.java`:

```java
// Student class implementing Cloneable interface
class Student implements Cloneable {
    // Fields
    private String name;
    private int age;
    private String major;
    
    // Constructor
    public Student(String name, int age, String major) {
        this.name = name;
        this.age = age;
        this.major = major;
    }
    
    // Getter and Setter methods
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getMajor() {
        return major;
    }
    
    public void setMajor(String major) {
        this.major = major;
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
        // Create a Student object
        Student student1 = new Student("John Doe", 20, "Computer Science");
        // Clone the Student object
        Student student2 = student1.clone();
        // Print the original and cloned objects
        System.out.println("Original Student: " + student1);
        System.out.println("Cloned Student: " + student2);
        // Modify the cloned object
        student2.setName("Jane Doe");
        student2.setAge(21);
        student2.setMajor("Mathematics");
        // Print the original and cloned objects after modification
        System.out.println("\nAfter modifying the cloned object:");
        System.out.println("Original Student: " + student1);
        System.out.println("Cloned Student: " + student2);
    }
}
```

## Step 3: Attempt Initial Compilation

Compile the Java program, specifying the destination directory as the classes directory that you created:

```bash
javac -d classes src/StudentManagement.java
```

### Expected Compilation Error

This compilation will fail as you have not handled the checked exception. You will see the compilation error as below:

```
StudentManagement.java:60: error: unreported exception CloneNotSupportedException; must be caught or declared to be thrown
        Student student2 = student1.clone();
                                       ^
1 error
```

## Step 4: Add Exception Handling

Replace the code with the code below:

```java
// Student class implementing Cloneable interface
class Student implements Cloneable {
    // Fields
    private String name;
    private int age;
    private String major;
    
    // Constructor
    public Student(String name, int age, String major) {
        this.name = name;
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
        try {
            // Create a Student object
            Student student1 = new Student("John Doe", 20, "Computer Science");
            // Clone the Student object
            Student student2 = student1.clone();
            // Print the original and cloned objects
            System.out.println("Original Student: " + student1);
            System.out.println("Cloned Student: " + student2);
            // Modify the cloned object
            student2.setName("Jane Doe");
            student2.setAge(21);
            student2.setMajor("Mathematics");
            // Print the original and cloned objects after modification
            System.out.println("\nAfter modifying the cloned object:");
            System.out.println("Original Student: " + student1);
            System.out.println("Cloned Student: " + student2);
        } catch(CloneNotSupportedException cnse) {
            System.out.println("You can't clone this object!");
        }
    }
}
```

In this case you are handling the exception.

## Step 5: Compile Again

Compile the Java program, specifying the destination directory as the classes directory that you created:

```bash
javac -d classes src/StudentManagement.java
```

**This compilation will be successful.**

## Step 6: Run the Program

Run the class and see the program run smoothly:

```bash
java StudentManagement
```
