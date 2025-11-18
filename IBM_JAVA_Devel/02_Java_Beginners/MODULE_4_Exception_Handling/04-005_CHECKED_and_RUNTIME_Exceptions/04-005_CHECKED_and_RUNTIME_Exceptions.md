# 04-006    Checked / Runtime Exceptions

![](./04-006_IMG12.png)

---

Java exceptions are classified into two main categories:

-   **Checked Exceptions**

-   **Runtime exceptions**

![](./04-006_IMG6.png)
![](./04-006_IMG7.png)



## Comparison: Checked vs Runtime Exceptions

| Aspect | Checked Exceptions | Runtime Exceptions |
|--------|-------------------|-------------------|
| **Compile-Time Check** | Yes, discovered and reviewed at compile time | No,  occur as the program runs |
| **Mandatory Handling** | Yes, must be caught or declared with `throws` | No,  optional handling |
| **Purpose** | Handle recovery from external events (file not found, network issues) | Indicate programming errors that need to be fixed |
| **Examples** | `IOException`, `FileNotFoundException`, `ClassNotFoundException` | `NullPointerException`, `ArithmeticException`, `ArrayIndexOutOfBoundsException` |
| **Recovery** | Often help applications recover from errors | Typically indicate bugs to be fixed |


---

## Checked Exceptions

![](./04-006_IMG1.png)


Checked exceptions are exceptions that are **checked at compile time**.  

The Java compiler ensures that your **code handles these exceptions before it can be successfully compiled**.  

If your code does not handle a checked exception, it results in a compilation error.

### Characteristics

![](./04-006_IMG2.png)

-   The exception is typically caught using a `try-catch` block or declared in the method signature using the `throws` keyword

-   The exception represents recoverable conditions such as file not found or network issues

- The compiler mandates explicit handling or declaration


### Common Use Cases

Checked exceptions are used during:

![](./04-006_IMG3.png)

-   **File operations** (Reading from or writing to a file)
-   **Database connections**  (Connecting to a database)
-   **Network communications** (Making network calls)


### Example: File Handling

```java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileExample {

    public static void main(String[] args) {
    
        try {
        
            File file = new File("nonexistentfile.txt");
            Scanner scanner = new Scanner(file);
            
        } catch (FileNotFoundException e) {
        
            System.out.println("Error: File not found.");
            
        }
    }
}
```

1.  In this example, we create a `File` object pointing to `nonexistentfile.txt`.  

2.  Then, we initialise a `Scanner` object to read the file.  

3.  Since the file may not exist, we wrap our code in a `try-catch` block to handle the `FileNotFoundException`.


### Common Checked Exceptions

| Exception | Purpose |
|-----------|---------|
| `IOException` | Handling file operations and network communications |
| `FileNotFoundException` | Handling missing file issues |
| `ClassNotFoundException` | When attempting to load classes dynamically at runtime |

### Benefits of Checked Exceptions

![](./04-006_IMG8.png)
![](./04-006_IMG9.png)

####    **Compile-Time Safety**
-   Requires developers to handle potential error scenarios at compile time  

-   Reduces the chances of unhandled exceptions occurring during execution   

-   Leads to more stable applications  


#### **Recoverable Errors**  

Checked exceptions typically represent conditions that a program can anticipate and recover from, such as file not found or invalid user input.  

> This encourages developers to **implement error-handling mechanisms** to manage these situations gracefully.

#### **Clear API Contracts**
By declaring checked exceptions in method signatures, APIs communicate the possible issues that may arise when using them.   

This helps users of the API understand what exceptions they need to handle, leading to better code practices.  

#### **Promotes Defensive Programming**
Using checked exceptions **encourages developers to think proactively about error handling**, leading to **more robust and resilient software**.

---

## Runtime Exceptions

Runtime exceptions are **not checked at compile time**.   

These exceptions occur **during the execution of the program and can often be avoided by fixing the code** . 

The Java compiler does not require you to handle or declare runtime exceptions.

### Characteristics

![](./04-006_IMG4.png)

-   The exceptions do not need to be explicitly caught or declared
-   The exceptions indicate programming errors such as **logic errors** or improper use of APIs
-   They typically signal bugs in the code that should be fixed rather than handled

### Common Use Cases

Runtime exceptions are used to display:

![](./04-006_IMG5.png)

-   **Arithmetic errors** (such as division by zero or overflow errors)  

-   **Null pointer access errors** (when you try to access an object that has not been initialised)  

-   **Array index out-of-bounds errors** (when you access invalid indices in arrays or collections)

### Example: Arithmetic Exception

```java
public class ArithmeticExample {

    public static void main(String[] args) {
    
        try {
        
            int result = 10 / 0;
            
        } catch (ArithmeticException e) {
        
            System.out.println("Error: Cannot divide by zero.");
            
        }
    }
}
```

1.  In this example, we attempt a division operation to divide 10 by 0. 
2.  Since dividing by 0 triggers an `ArithmeticException`, we catch this exception in a `try-catch` block. 
3.  The Java program catches the exception and prints an appropriate message.

### Common Runtime Exceptions

| Exception | Purpose |
|-----------|---------|
| `NullPointerException` | When the code tries to use a null reference |
| `ArithmeticException` | When invalid mathematical operations occur |
| `ArrayIndexOutOfBoundsException` | When accessing array elements outside valid indices |

### Benefits of Runtime Exceptions

![](./04-006_IMG10.png)
![](./04-006_IMG11.png)

#### **Simplicity**
Runtime exceptions **do not require explicit handling**, which simplifies the code.   

Developers can focus on the main logic without being burdened by mandatory error handling for every potential issue.

#### **Indication of Programming Errors**
Runtime exceptions usually **indicate bugs or logical errors in the code**, such as null pointer access or array index out of bounds.   

Using runtime exceptions allows developers to catch and fix these issues during development rather than at runtime.

#### **Performance**
Since runtime exceptions do not require checked handling, they can lead to **cleaner and more efficient code, especially in performance-critical sections** of an application.

#### **Control Flow**
Runtime exceptions can be used to signal problems that should not occur if the program logic is correct.  

This allows developers to implement custom logic for handling unexpected conditions without cluttering the code with error-handling structures.



---

## Lesson Speech

**Welcome** to this video about Checked and Runtime Exceptions in Java. After watching this video, you will be able to **explain** checked and runtime exceptions, **compare** checked and runtime exceptions, and **describe** the reasons for using checked and runtime exceptions.

**Checked exceptions** are exceptions checked at compile time. This means that the Java compiler **ensures** that your code handles these exceptions before it can be successfully compiled. If your code does not handle a checked exception, it results in a **compilation error**. Checked exceptions have the following characteristics. The exception is typically caught using a `try-catch` block or declared in the method signature using the `throws` keyword. The exception represents **recoverable conditions** such as file not found or network issues.

Let's look at a simple checked exception example involving file handling. Here, we create a new `File` object pointing to `nonexistentfile.txt`. Then, we initialise a `Scanner` object to read the `File` object. Since the file may not exist, we wrap our code in a `try-catch` block to handle the `FileNotFoundException` error which is a **checked exception**. When the program is run, it prints an error message because `nonexistentfile.txt` cannot be found.

Checked exceptions are used during the following: **File operations** such as reading from or writing to a file, **database connections** such as connecting to a database, and **network communications** such as making network calls.

**Runtime exceptions** are not checked at compile time. These exceptions occur during the execution of the program and can often be **avoided by fixing the code**. The Java compiler does not require you to handle or declare runtime exceptions. Runtime exceptions have the following characteristics. The exceptions do not need to be explicitly caught or declared. The exceptions indicate **programming errors** such as logic errors or improper use of APIs.

Let's consider a simple runtime exception example involving division. Here, we attempt a division operation to divide 10 by 0. Since dividing by 0 will trigger an `ArithmeticException`, we catch this exception in a `try-catch` block. Our Java program catches the exception and prints an appropriate message.

Runtime exceptions are used to display **arithmetic errors** such as division by 0 or overflow errors, **null pointer access errors** when you try to access an object that has not been initialised, and **array index out-of-bounds errors** when you access invalid indices in arrays or collections.

Let's **compare** checked exceptions with runtime exceptions. First, let's examine when they are used. Checked exceptions are discovered and reviewed at compile time whilst runtime exceptions occur as the program runs.

So, why identify exceptions? You would identify **checked exceptions** to handle exception recovery from external events such as files not found, network issues, and other issues outside of the code. However, you would identify **runtime exceptions** to handle programming errors that need to be fixed such as log errors, null references, and other problematic issues. Checked exceptions often help applications **recover from errors**.

Checked and runtime exceptions have **different handling requirements**. Java requires that checked exceptions are caught using the `try-catch` method or declared using `throws` before you can compile the code. In contrast, Java does not have mandatory handling requirements for runtime exceptions and you might be able to ignore them.

`IOException`, `FileNotFoundException`, and `ClassNotFoundException` are examples of **checked exceptions** in Java that must be explicitly handled. `IOException` is commonly used for handling file operations and network communications, `FileNotFoundException` for missing file issues, and `ClassNotFoundException` when attempting to load classes dynamically at runtime.

In contrast, you can use **runtime exceptions** such as `NullPointerException` to identify when the code is trying to use a null reference, `ArithmeticException` to identify invalid mathematical operations, and `ArrayIndexOutOfBoundsException` to notify you when the code is accessing array elements outside valid indices.

**Checked exceptions provide** the following benefits. **Compile-Time Safety** — Checked exceptions require developers to handle potential error scenarios at compile time. This reduces the chances of unhandled exceptions occurring during execution, leading to more stable applications. **Recoverable Errors** — Checked exceptions typically represent conditions that a program can anticipate and recover from, such as file not found or invalid user input. This encourages developers to implement error-handling mechanisms to manage these situations gracefully. **Clear API Contracts** — By declaring checked exceptions in method signatures, APIs communicate the possible issues that may arise when using them. This helps users of the API understand what exceptions they need to handle, leading to better code practices. **Promotes Defensive Programming** — Using checked exceptions encourages developers to think proactively about error handling, leading to more robust and resilient software.

**Runtime exceptions provide** the following benefits. **Simplicity** — Runtime exceptions do not require explicit handling, which simplifies the code. Developers can focus on the main logic without being burdened by mandatory error handling for every potential issue. **Indication of Programming Errors** — Runtime exceptions usually indicate bugs or logical errors in the code, such as null pointer access or array index out of bounds. Using runtime exceptions allows developers to catch and fix these issues during development rather than at runtime. **Performance** — Since runtime exceptions do not require checked handling, they can lead to cleaner and more efficient code, especially in performance-critical sections of an application. **Control Flow** — Runtime exceptions can be used to signal problems that should not occur if the program logic is correct. This allows developers to implement custom logic for handling unexpected conditions without cluttering the code with error-handling structures.

In this video, you learned that **checked exceptions** are exceptions checked at compile time. The Java compiler checks exceptions to ensure your program can be successfully compiled before execution. Checked exceptions are caught using a `try-catch` block or declared in the method signature using the `throws` keyword. Checked exceptions are used during file operations, database connection, and network communication. **Runtime exceptions** are not checked at compile time. They occur during the execution of the program and can often be **avoided by fixing the code**. Runtime exceptions display arithmetic errors, null pointer access errors, and array index out of bounds errors. Checked exceptions provide benefits such as compile-time safety, recoverable errors, clear API contracts, and defensive programming. Runtime exceptions provide benefits such as simplicity, indication of programming errors, performance, and control flow.
