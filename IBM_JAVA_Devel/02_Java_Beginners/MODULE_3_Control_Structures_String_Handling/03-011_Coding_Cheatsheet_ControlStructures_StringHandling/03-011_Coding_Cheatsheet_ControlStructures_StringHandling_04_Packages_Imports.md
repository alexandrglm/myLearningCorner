# Using Packages and Imports

## Creating a Package

To create a package, you simply declare it at the top of your Java source file using the `package` keyword followed by the package name. For example:

| Description | Example |
|-------------|---------|
| Declare a package at the top of the file. | `package com.example.myapp;` |

In this example, `com.example.myapp` is the name of the package. It's common practice to use a reverse domain name as the package name to ensure uniqueness.

| Description | Example |
|-------------|---------|
| Define a class inside the package. | `public class MyClass {`<br/>`    // Class code here`<br/>`}` |

---

## Creating and Using a Package

| Description | Example |
|-------------|---------|
| Define a class inside the shapes package. | `package shapes;` |
| Create the `Circle` class with a constructor and a method. | `public class Circle {`<br/>`    private double radius;`<br/><br/>`    public Circle(double radius) {`<br/>`        this.radius = radius;`<br/>`    }`<br/><br/>`    public double area() {`<br/>`        return Math.PI * radius * radius;`<br/>`    }`<br/>`}` |

To use this class in another Java file, you need to import it.

---

## Importing Classes

To import a specific class from a package, use the following syntax:

| Description | Example |
|-------------|---------|
| Import a specific class from a package. | `import package_name.ClassName;` |

---

## Importing All Classes from a Package

You can also import all classes from a package using an asterisk (`*`).

| Description | Example |
|-------------|---------|
| Import all classes from the shapes package. | `import shapes.*;` |

This imports all classes in the shapes package, allowing you to use any class without needing to import them individually.
