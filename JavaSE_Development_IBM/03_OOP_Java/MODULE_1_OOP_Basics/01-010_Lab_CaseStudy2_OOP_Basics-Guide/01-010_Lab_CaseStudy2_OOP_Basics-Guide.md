# 01-010 Case Study 2: Object Oriented Programming Basics


## Develop an Employee Management System

**Estimated time needed:** 20 minutes

This optional self-guided lab provides exercises that align with skills you learned in this module. Follow the instructions to write code using your knowledge to create the described apps. After you complete the lab exercises, you can validate that your code is correct with the solution provided.

### Prerequisites (optional)

You must have completed all the labs in Module 1.

### Clone the challenges repo

- Run the following command to clone the repository with the challenges and solution.

```sh
git clone https://github.com/ibm-developer-skills-network/flgsb-oop-additional-practice.git
```

- Change to OOPs/Module 1 directory.

```sh
cd flgsb-oop-additional-practice/OOPs/Module\ 1
```

- Run the ls command to view the directories. Each directory has one challenge.

```sh
ls
```

---

## A) Employee Management System Challenge

### What is this challenge?

This is a Java coding challenge where you'll build a simple Employee Management System from scratch. You'll create a program that can store employee information, validate data, perform calculations like determining annual salary, and even make copies of employee records.

### What will you build

In this challenge, you'll complete the following coding tasks:

- Create a basic Employee class to store information like name, age, and salary
- Add different ways to create new employees (using different constructors)
- Make your code secure by hiding data and adding validation rules
- Implement useful features like calculating annual salary and giving raises
- Learn how to duplicate or clone employee records when needed
- Test the code to make sure it works properly

### Skills you will build

Through this hands-on exercise, you'll learn:

- Encapsulation: How to protect data by making the data private and only accessible through controlled methods
- Constructor overloading: How to create multiple ways to initialize objects
- Data validation: How to ensure information like age and salary follows business rules
- Object cloning: How to make copies of objects when needed
- Java fundamentals: Working with classes, methods, interfaces, and exception handling

---

## B) Solve the challenge

- In the terminal, change to Build your own constructor.

```sh
cd Build\ your\ own\ constructor
```

- Select the following button to open the Java coding challenge.

- Make changes in the file based on the specifications.

- Compile the Java file.

- Set the CLASSPATH.

- Select the button below to open the Java coding challenge.

- Make changes in the file based on the specifications.

- Compile the Java file.

- Run the class TestEncapsulation to ensure the class is created as per instructions.


---

## C) Java Student Class Challenge

### Introduction

Welcome to the Java Student Class Challenge! In this hands-on exercise, you'll create your first Java class from scratch and learn fundamental object-oriented programming concepts.

### What you will build

You'll develop a complete student record management system with two classes:

- A Student class to store and manage individual student information
- A StudentRegistry class to demonstrate how to use your Student class in a real application

### What you will learn

Through this challenge, you'll master essential Java programming skills:

- Class Design: Creating classes with appropriate attributes and methods
- Encapsulation: Using private variables with getter/setter methods
- Data Validation: Implementing simple validation in setter methods
- Method Creation: Building utility methods for displaying data and calculations
- Object Instantiation: Creating and working with multiple objects
- Object Comparison: Comparing properties between different instances

### How the Challenge Works

The provided skeleton file contains the structure with detailed comments guiding you through each step. You'll implement:

- Private instance variables for student data (ID, name, grade, active status)
- Accessor methods (getters and setters) with validation
- Utility methods like grade calculation and student comparison
- A main program that demonstrates your class in action

---

## D) Solve the challenge

- In the terminal, change to Create your own class.

```sh
cd Create\ your\ own\ class
```

- Select the button below to open the Java coding challenge.

- Make changes in the file based on the specifications.

- Compile the Java file.

- Set the CLASSPATH.

- Select the button below to open the Java coding challenge.

- Make changes in the file based on the specifications.

- Compile the Java file.

- Run the class StudentRegistry to ensure the class is created based on the instructions.


### Conclusion

After you have successfully completed these coding challenge labs, you should be comfortable with constructor and encapsulation object-oriented programming.

---

## PROPOSED SOLUTIONS:

### EMPLOYEE SOLUTIONS
```java
// Employee class to demonstrate encapsulation
public class Employee implements Cloneable {
    // Step 1: Declare private variables for name, age, and salary
    private String name;
    private int age;
    private double salary;
    
    // Step 2: Create constructors
    // 2.1: Default constructor
    public Employee() {
        this.name = "Unknown";
        this.age = 18;
        this.salary = 0.0;
    }
    
    // 2.2: Overloaded constructor that initializes all three variables
    public Employee(String name, int age, double salary) {
        // Use setters to ensure validation rules are applied
        setName(name);
        setAge(age);
        setSalary(salary);
    }
    
    // Step 3: Create public getter methods for each variable
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
    
    public double getSalary() {
        return this.salary;
    }
    
    // Step 4: Create public setter methods with validation
    public void setName(String name) {
        // Validation: name cannot be null or empty
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Error: Name cannot be null or empty. Setting to 'Unknown'");
            this.name = "Unknown";
        }
    }
    
    public void setAge(int age) {
        // Validation: age must be between 18 and 65 (inclusive)
        if (age >= 18 && age <= 65) {
            this.age = age;
        } else {
            System.out.println("Error: Age must be between 18 and 65. Setting to default (18)");
            this.age = 18;
        }
    }
    
    public void setSalary(double salary) {
        // Validation: salary must be non-negative
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Error: Salary cannot be negative. Setting to 0");
            this.salary = 0;
        }
    }
    
    // Step 5: Create a method to calculate annual salary
    public double calculateAnnualSalary() {
        return this.salary * 12;
    }
    
    // Step 6: Create a method to give a raise
    public void giveRaise(double percentage) {
        if (percentage > 0) {
            double raiseAmount = this.salary * (percentage / 100);
            this.salary += raiseAmount;
            System.out.println(this.name + " received a raise of " + percentage + "%");
        } else {
            System.out.println("Raise percentage must be positive");
        }
    }
    
    // Step 7: Create a method to display employee details
    public void displayDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
        System.out.println("Monthly Salary: $" + String.format("%.2f", this.salary));
        System.out.println("Annual Salary: $" + String.format("%.2f", calculateAnnualSalary()));
        System.out.println("---------------------------");
    }
    
    // Step 8: Override the clone method to make Employee objects cloneable
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Call the superclass clone method to create a shallow copy
        return super.clone();
    }
}
```
```java
public class TestEncapsulation {
    public static void main(String[] args) {
        // Step 1: Create two instances of the Employee class
        // First employee using the parameterized constructor
        System.out.println("Creating first employee using constructor...");
        Employee employee1 = new Employee("John Doe", 30, 5000.0);
        
        // Second employee using default constructor and setters
        System.out.println("\nCreating second employee using setters...");
        Employee employee2 = new Employee();
        employee2.setName("Jane Smith");
        employee2.setAge(25);
        employee2.setSalary(5500.0);
        
        // Step 2: Display details of both employees
        System.out.println("\nInitial Employee Details:");
        employee1.displayDetails();
        employee2.displayDetails();
        
        // Step 3: Try setting invalid values
        System.out.println("Testing validation with invalid values:");
        employee1.setName("");  // Invalid: empty name
        employee1.setAge(70);   // Invalid: age outside range
        employee2.setSalary(-100); // Invalid: negative salary
        
        System.out.println("\nEmployee Details After Invalid Values:");
        employee1.displayDetails();
        employee2.displayDetails();
        
        // Step 4: Give both employees a 10% raise
        System.out.println("Giving both employees a 10% raise:");
        employee1.giveRaise(10);
        employee2.giveRaise(10);
        
        System.out.println("\nEmployee Details After Raise:");
        employee1.displayDetails();
        employee2.displayDetails();
        
        // Step 5: Clone the first employee
        System.out.println("\nCloning the first employee...");
        try {
            Employee clonedEmployee = (Employee) employee1.clone();
            System.out.println("Cloned Employee Details:");
            clonedEmployee.displayDetails();
            
            // Step 14: Modify the original employee to show clones are separate objects
            System.out.println("Modifying the original employee's salary...");
            employee1.setSalary(6000.0);
            
            System.out.println("\nOriginal Employee After Modification:");
            employee1.displayDetails();
            
            System.out.println("Cloned Employee After Original was Modified:");
            clonedEmployee.displayDetails();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning not supported: " + e.getMessage());
        }
        
        // Step 6: Compare salaries
        String result = compareSalaries(employee1, employee2);
        System.out.println("Salary Comparison Result: " + result);
    }
    
    // Step 7: Create a method that compares the salaries of two employees
    // and returns the name of the employee with the higher salary
    // If salaries are equal, return "Equal salaries"// Method to compare salaries
    public static String compareSalaries(Employee emp1, Employee emp2) {
        if (emp1.getSalary() > emp2.getSalary()) {
            return emp1.getName() + " has a higher salary";
        } else if (emp2.getSalary() > emp1.getSalary()) {
            return emp2.getName() + " has a higher salary";
        } else {
            return "Equal salaries";
        }
    }
}
```

### STUDENT SOLUTIONS
```java
// Student class to store and manage student information
public class Student {
    // Step 1: Private variables for student data
    private String studentId;
    private String name;
    private double grade;
    private boolean isActive;
    
    // Step 2: Getter methods to access private variables
    public String getStudentId() {
        return this.studentId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getGrade() {
        return this.grade;
    }
    
    public boolean getIsActive() {
        return this.isActive;
    }
    
    // Step 3: Setter methods with simple validation
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setGrade(double grade) {
        // Validate grade is between 0 and 100
        if (grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Error: Grade must be between 0 and 100");
        }
    }
    
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    // Step 4: Method to stringify student details
    public String displayStudentDetails() {
        return "ID: " + this.studentId +
                "\nName: " + this.name + 
                " Grade: " + this.grade +
                "\nStatus: " + (this.isActive ? "Active" : "Inactive");
    }
    
    // Step 5: Method to calculate letter grade
    public String getLetterGrade() {
        if (this.grade >= 90) {
            return "A";
        } else if (this.grade >= 80) {
            return "B";
        } else if (this.grade >= 70) {
            return "C";
        } else if (this.grade >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    
    // Step 6: Method to check if student is passing
    public boolean isPassing() {
        return this.grade >= 60;
    }
}
```
```java
// StudentRegistry class to test the Student class
public class StudentRegistry {
    public static void main(String[] args) {
        // Step 1: Create two Student instances
        Student student1 = new Student();
        Student student2 = new Student();
        
        // Step 2: Set values for first student
        student1.setStudentId("S001");
        student1.setName("John Doe");
        student1.setGrade(85.5);
        student1.setIsActive(true);
        
        // Step 3: Set values for second student
        student2.setStudentId("S002");
        student2.setName("Jane Smith");
        student2.setGrade(92.0);
        student2.setIsActive(true);
        
        // Step 4: Display details of both students
        System.out.println("Displaying information for both students:");
        System.out.println(student1);
        System.out.println(student2);
        
        // Step 5: Compare grades and print who has the higher grade
        Student higherGradeStudent = compareGrades(student1, student2);
        System.out.println("\nComparing grades:");
        System.out.println(higherGradeStudent.getName() + " has the higher grade with " + 
                          higherGradeStudent.getGrade());
        
        // Step 6: Test letter grades
        System.out.println("\nLetter Grades:");
        System.out.println(student1.getName() + "'s letter grade: " + student1.getLetterGrade());
        System.out.println(student2.getName() + "'s letter grade: " + student2.getLetterGrade());
        
        // Step 7: Test passing status
        System.out.println("\nPassing Status:");
        System.out.println(student1.getName() + " is " + 
                          (student1.isPassing() ? "passing" : "not passing"));
        System.out.println(student2.getName() + " is " + 
                          (student2.isPassing() ? "passing" : "not passing"));
        
        // Step 8: Change one student to inactive
        System.out.println("\nChanging " + student1.getName() + "'s status to inactive");
        student1.setIsActive(false);
        System.out.println(student1);
        
        // Extra: Test invalid grade
        System.out.println("\nTesting grade validation:");
        student1.setGrade(105); // Should print error message
    }
    
    // Step 9: Static method to compare grades
    public static Student compareGrades(Student student1, Student student2) {
        if (student1.getGrade() > student2.getGrade()) {
            return student1;
        } else {
            return student2;
        }
    }
}
```
