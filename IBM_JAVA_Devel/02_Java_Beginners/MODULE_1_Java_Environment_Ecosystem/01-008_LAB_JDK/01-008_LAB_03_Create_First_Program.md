# Lab 03 - Create the First Java Program

In this part of the lab, you will create, compile, and run your first Java program. The first time you are creating a Java program, you can create it in any location. You will now create a Java program in the current directory and run it. A good practice is to keep the source file and the compile class files separate. In the next part of the lab, you will create the same, adhering to the directory structure.

## Steps

### 1. Create a New Java File

At the command prompt, run the following command to create your first Java program:

```bash
touch MyFirstProgram.java
```

### 2. Open the File for Editing

Click on the button below to open the file that you just created so you can edit it.

### 3. Create a Test Program

Add the following code to your file:

```java
public class MyFirstProgram {
    public static void main(String s[]) {
        System.out.println("Hello World!");
    }
}
```

---

## Code Explanation

### 0 - Import Statement

```java
import java.util.Scanner;
```

- **`import`**: Keyword used to import classes from other packages into your Java program.

- **`java.util.Scanner`**: The fully qualified name of the Scanner class. `java.util` is the package name and `Scanner` is the class name. The Scanner class is used to read input from various sources, such as the keyboard (standard input).

### 0.1 - Try-With-Resources Block

```java
try (Scanner scanner = new Scanner(System.in)) {
    // code here
}
```

- **`try`**: Keyword that begins a try-with-resources block, which is used for automatic resource management. Any resource declared in the parentheses will be automatically closed after the block completes.

- **`Scanner scanner = new Scanner(System.in)`**: Creates a new Scanner object named `scanner` that reads from the standard input stream (`System.in`, which is the keyboard).

- **`System.in`**: Built-in Java object that represents the standard input stream, which is usually the keyboard.

### 0.2 - Variable Declaration with Scanner Input

```java
String fullname = scanner.nextLine();
```

- **`String fullname`**: Declares a variable named `fullname` of type `String` that will store the user's input.

- **`scanner.nextLine()`**: A method of the Scanner class that reads an entire line of text from the user (including spaces) until the user presses Enter, and returns it as a String.

- **`=`**: Assignment operator that assigns the value returned by `scanner.nextLine()` to the `fullname` variable.

### 1 - Class Declaration

```java
public class MyFirstProgram {
```

- **`public`**: Access modifier that defines the access level (scope) for the class. In this case, the class can be accessed from anywhere as it is public.

- **`class`**: Keyword to declare a new class.

- **`MyFirstProgram`**: Name of the class. You will notice that the class name is the same as the filename. This is **mandatory** in Java.

### 2 - Main Method Declaration

```java
public static void main(String s[]) {
```

- **`public`**: Access modifier that defines the scope-access level for the method. This doesn't have to be the same as the class. In this case, the main method within the class can be accessed from anywhere as it is public.

- **`static`**: Keyword indicating the method belongs to the class, but you don't have to create an object of the class to access it. As the word suggests, the method doesn't dynamically change for each instance of the class you create. It stays static or unchanged.

- **`void`**: Return type, indicating the method doesn't return any value.

- **`main`**: Name of the method. The `public static void main` method is the entry point for a Java program.

- **`(String s[])`**: Method parameter, an array of strings, which represents the command-line arguments.

### 3 - Print Statement `println`

```java
System.out.println("Hello World!");
```

- **`System.out`**: Built-in Java object that represents the standard output stream, which is usually the console.

- **`println`**: A method of the PrintStream class that prints its argument to the standard output stream, followed by a newline character.

- **`"Hello World!"`**: The string to be printed.

### 3.1 - Print Statement `printf`

```java
System.out.printf("Hello again, %s, this is another type of printf interpolation-insertion mode\n", fullname);
```

- **`System.out`**: Built-in Java object that represents the standard output stream, which is usually the console.

- **`printf`**: A method of the PrintStream class that prints formatted output to the standard output stream. Unlike `println`, it does not automatically add a newline character.

- **`"Hello again, %s, this is another type of printf interpolation-insertion mode\n"`**: A format string that contains the text to be printed and format specifiers. The `%s` is a format specifier that represents a string placeholder, and `\n` is an escape sequence that represents a newline character.

- **`fullname`**: The argument that replaces the `%s` format specifier in the format string.

**Note:** All statements in Java should be completed with a semi-colon at the end, except when you have brackets such as `{` or `}`.

### 4 - Closing Brackets

```java
    }
}
```

1. Closing bracket for the main method.
2. Closing bracket for the MyFirstProgram class.

**Maintaining indentation is a good coding practice as it improves the readability of the code.**
