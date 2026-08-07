# Implementing Functions and Methods

## Function Structure

| Description | Example |
|-------------|---------|
| The structure of a function in Java. | `returnType functionName(parameter1Type parameter1, parameter2Type parameter2) {`<br/>`    // code to be executed`<br/>`    return value; // optional`<br/>`}` |

---

## Example of a Simple Function

Let's create a simple function that adds two numbers:

| Description | Example |
|-------------|---------|
| Create a function that adds two numbers. | `public static int add(int a, int b) {`<br/>`    return a + b;`<br/>`}` |
| Call the `add` function in the `main` method and print the result. | `int sum = add(5, 3);`<br/>`System.out.println("The sum is: " + sum);` |

---

## Example of a Simple Method

Let's create a method within a class:

| Description | Example |
|-------------|---------|
| Define a `multiply` method inside the `Calculator` class. | `public class Calculator {` |
| The `multiply` method takes two integers and returns their product. | `    public int multiply(int x, int y) {` |
| Close the `multiply` method. | `        return x * y;`<br/>`    }` |
| Define the `main` method, which is the program's entry point. | `    public static void main(String[] args) {` |
| Create an instance of the `Calculator` class in the `main` method. | `        Calculator calc = new Calculator();` |
| Call the `multiply` method with 4 and 5 and store the result. | `        int product = calc.multiply(4, 5);` |
| Print the result to the screen. | `        System.out.println("The product is: " + product);` |
| Close the `main` method and class. | `    }`<br/>`}` |

---

## Parameters and Arguments

Parameters are the inputs to functions or methods, whilst arguments are the values passed when calling these functions or methods.

| Description | Example |
|-------------|---------|
| Define a method with multiple parameters. | `public void greet(String name, int age) {`<br/>`    System.out.println("Hello " + name + ", you are " + age + " years old.");`<br/>`}` |
| Call the `greet` method with arguments in the `main` method. | `Greeting greeting = new Greeting();`<br/>`greeting.greet("Alice", 30);` |

---

## Return Values

Functions and methods can return values or perform actions without returning anything.

| Description | Example |
|-------------|---------|
| Define a method that returns a value. | `public double area(double length, double width) {`<br/>`    return length * width;`<br/>`}` |
| Call the `area` method and print the returned value. | `Rectangle rect = new Rectangle();`<br/>`double area = rect.area(4.5, 3.0);`<br/>`System.out.println("The area of the rectangle is: " + area);` |

---

## Overloading Methods

Java allows defining multiple methods with the same name but different parameters. This is known as method overloading.

| Description | Example |
|-------------|---------|
| Define the `Display` class. | `public class Display {` |
| Define an overloaded method that takes an `int`. | `    public void show(int number) {` |
| Print the number. | `        System.out.println("Number: " + number);` |
| Close the first method. | `    }` |
| Define an overloaded method that takes a `String`. | `    public void show(String text) {` |
| Print the text. | `        System.out.println("Text: " + text);` |
| Close the second method. | `    }` |
| Define the `main` method to call the overloaded methods. | `    public static void main(String[] args) {` |
| Create a `Display` object. | `        Display display = new Display();` |
| Call `show(int)` and `show(String)`. | `        display.show(10);`<br/>`        display.show("Hello World");` |
| Close the `main` method and class. | `    }`<br/>`}` |

---

## Scope of Identifiers

The scope of an identifier refers to the part of the program where the identifier can be accessed.

| Description | Example |
|-------------|---------|
| **Local Scope:** Identifiers are accessible only within the method or block. | `int x = 10; // x is local to this block` |
| **Instance Scope:** Variables are accessible by all methods in the class. | `private int x; // x is accessible by all methods` |
| **Static Scope:** Static variables belong to the class and are accessible throughout the class. | `private static int count;` |

---

## Void Methods

A `void` method does not return a value.

| Description | Example |
|-------------|---------|
| Define a `void` method that prints a message. | `public void printMessage() {`<br/>`    System.out.println("Hello, World!");`<br/>`}` |

---

## Empty Parameter Lists

An empty parameter list means the method does not take any parameters.

| Description | Example |
|-------------|---------|
| Define a method with an empty parameter list. | `public void show() {`<br/>`    System.out.println("No parameters here.");`<br/>`}` |
