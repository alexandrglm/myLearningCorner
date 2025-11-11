# 01-008 Exercise Abstract

---

## Import Statements

### `import java.util.Scanner;`

The `import` keyword loads classes from other packages into your Java program.   
The `Scanner` class from the `java.util` package is used to read input from various sources, such as the keyboard (standard input).

---

## Try-With-Resources Block

### `try (Scanner scanner = new Scanner(System.in)) { ... }`

The try-with-resources statement automatically manages resource closure.  
Any resource declared in the parentheses will be automatically closed after the block completes, ensuring proper cleanup without requiring manual `close()` calls.

---

## Scanner Class Methods

### `scanner.nextLine()`

Reads an entire line of text from the user input (including spaces) until the Enter key is pressed. Returns the input as a `String` value. This method is useful for reading complete lines of user input.

---

## Output Methods

### `System.out.println(String text)`

Prints the provided text to the standard output stream (console) followed by a newline character. Each `println()` call automatically moves the cursor to the next line.

**Example:**
```java
System.out.println("Hello World!");
```

### `System.out.printf(String format, Object... args)`

Prints formatted output to the standard output stream (console). Uses format specifiers like `%s` (for strings) to insert variable values into the output string. Unlike `println()`, it does not automatically add a newline character unless explicitly included with `\n`.

**Example:**
```java
System.out.printf("Hello again, %s, this is another type of printf interpolation-insertion mode\n", fullname);
```

**Common Format Specifiers:**
- `%s`: String
- `%d`: Integer
- `%f`: Floating-point number
- `%n`: Newline (platform-independent alternative to `\n`)

---

## Variable Declaration and Assignment

### `String variableName = value;`

Declares a variable of type `String` and assigns a value to it. The variable stores and is used later
.

**Example:**
```java
String fullname = scanner.nextLine();
```
