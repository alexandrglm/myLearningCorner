# 01-013:   Coding Cheat Sheet

This reading provides a reference list of code that you'll encounter as you work with object-oriented coding in Java. Understanding these concepts will help you write and debug object-oriented Java programs. Let's explore the following Java coding concepts:

- Working with classes and objects
- Working with access and non-access modifiers
- Using encapsulation
- Using constructors

Keep this summary reading available as a reference as you progress through your course, and refer to it when you begin coding object-oriented Java programming after this course!

---

## Working with classes and objects

### Creating a class

#### Create a Car class

**Description:** Create a `Car` class, which serves as a blueprint for creating `Car` objects.

```java
public class Car {
```

**Description:** Define attributes of the `Car` class. The variables `color`, `model`, and `year` store the car's color, model, and year, respectively.

```java
String color;
String model;
int year;
```

**Description:** Include the method `displayInfo()` to print car objects.

```java
void displayInfo() {
```

**Description:** Print the car details to the console using the `System.out.println()` function.

```java
System.out.println("Car Model: " + model);
System.out.println("Car Color: " + color);
System.out.println("Car Year: " + year);
```

**Description:** Close curly braces to end the `Car` class definition.

```java
    }
}
```

**Explanation:** This example creates a class named `Car` and defines three attributes for the `Car` class: `model`, `color`, and `year`. The `displayInfo()` method prints the car details.

### Creating an object

#### Creating a Car object in the Main class

**Description:** A Java class named `Main` with a `main` method. The `main` method is the entry point of the program.

```java
public class Main { 
```

**Description:** The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs.

```java
public static void main(String[] args) {
```

**Description:** Create an object of the `Car` class.

```java
Car myCar = new Car();
```

**Description:** Assign values to the object's attributes.

```java
myCar.color = "Red";
myCar.model = "Toyota";
myCar.year = 2020;
```

**Description:** Call the `displayInfo()` method to print the object details.

```java
myCar.displayInfo();
```

**Description:** Close curly braces to end the `main` method and class definition.

```java
    }
}
```

**Explanation:** This example declares a reference variable named `myCar` of type `Car`. `new Car()` creates a new object of the `Car` class and assigns values to the object's attributes: `color`, `model` and `year`. The `displayInfo()` method prints the car details.

---

## Working with access and non-access modifiers

### Public access modifier

**Description:** A Java statement used to define a class named `Car`, which acts as a blueprint for creating `Car` objects. The variable `model` is declared as `public`, meaning it can be accessed directly from outside the class.

```java
public class Car {
```

**Description:** A Java statement to declare a `String` variable named `model` to store the car's model name.

```java
    public String model;
```

**Description:** Close curly braces to end the class definition.

```java
}
```

### Private access modifier

**Description:** A Java statement used to define a class named `Car`, which acts as a blueprint for creating `Car` objects. The variable `model` is declared as `public`, meaning that it can be accessed directly from outside the class.

```java
public class Car {
```

**Description:** A Java statement to declare a `private String` variable named `color` to store the car's color. The `private` modifier ensures the `color` variable can be accessed and modified only within the `Car` class.

```java
    private String color;
```

**Description:** Call the `displayColor()` method with the `private` access modifier. This ensures the method can be called only within the `Car` class and not from other classes.

```java
    private void displayColor() {
```

**Description:** Print the car's color to the console using the `System.out.println()` function.

```java
	System.out.println("Car Color: " + color); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

### Protected access modifier

**Description:** A Java statement used to define a class named `Car`, which acts as a blueprint for creating `Car` objects. The variable `model` is declared as `public`, meaning that it can be accessed directly from outside the class.

```java
public class Car {
```

**Description:** A Java statement to declare a `protected int` variable named `year` to store the car's year. The `protected` modifier ensures the `year` variable is accessible within the same package (default package access) and by subclasses, even if they are in different packages.

```java
    private String year;
```

**Description:** Call the `displayYear()` method with the `protected` access modifier. This ensures the method can be called within the same package and by subclasses, even if they are in different packages.

```java
    private void displayYear() {
```

**Description:** Print the car's year to the console using the `System.out.println()` function.

```java
	System.out.println("Car Year: " + year); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

### Default access modifier

**Description:** A Java statement used to define a class named `Car`, which acts as a blueprint for creating `Car` objects.

```java
class Car {
```

**Description:** A Java statement to declare a `String` variable named `model` without any access modifier. If no access modifier is used, the variable is considered `default`. Default variables are accessible only within their own package.

```java
    String model;
```

**Description:** Call the `displayModel()` method without any access modifier.

```java
    void displayModel() {
```

**Description:** Print the car's model to the console using the `System.out.println()` function.

```java
	System.out.println("Car Model: " + model); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

### Static non-access modifier

**Description:** A Java statement used to define a class named `Car`, which acts as a blueprint for creating `Car` objects. The variable `model` is declared as `public`, meaning that it can be accessed directly from outside the class.

```java
public class Car {
```

**Description:** A Java statement to declare a `static int` variable named `numberOfCars` to keep track of the total number of `Car` objects created. Since it's `static`, its value is shared among all instances of `Car`.

```java
    static int numberOfCars = 0;
```

**Description:** A Java statement to declare a constructor. Every time a new `Car` object is created, this constructor runs.

```java
    public Car() {
```

**Description:** A Java statement to increment the `numberOfCars` variable that keeps track of how many cars have been instantiated.

```java
	numberOfCars++; 
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** Call the `displayCount()` method without creating an instance of the `Car` class. This method can only access `static` variables like `numberOfCars`, not instance variables.

```java
    private void displayCount() {
```

**Description:** Print the total number of cars to the console using the `System.out.println()` function.

```java
	System.out.println("Total Cars: " + numberOfCars); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

### Final non-access modifier

**Description:** A Java statement used to define a `final` class named `Vehicle`, which acts as a blueprint for creating `Car` objects. The `final` class cannot be extended (inherited) by any other class. This means no subclasses can be created from `Vehicle`.

```java
public final class Vehicle {
```

**Description:** A Java statement to declare a `final int` variable named `maxSpeed` with the value `120`. The `final` variable is a constant, meaning that its value cannot be changed once it is assigned. Trying to modify `maxSpeed` later in the code will cause a compilation error.

```java
    final int maxSpeed = 120;
```

**Description:** A Java statement to declare a `final` method named `displayMaxSpeed()`. The `final` method cannot be overridden by subclasses. This ensures the behavior of `displayMaxSpeed` remains the same in all instances.

```java
    final void displayMaxSpeed() {
```

**Description:** Print the maximum car speed to the console using the `System.out.println()` function.

```java
	System.out.println("Max Speed: " + maxSpeed); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

### Abstract non-access modifier

**Description:** A Java statement used to define an `abstract` class named `Shape`. This is an abstract class, meaning that it cannot be instantiated (you cannot create `Shape` objects directly). It works as a blueprint from which other classes can inherit.

```java
public abstract class Shape {
```

**Description:** A Java statement used to define a `final` class named `Vehicle`, which acts as a blueprint for creating `Car` objects. The `final` class cannot be extended (inherited) by any other class. This means no subclasses can be created from `Vehicle`.

```java
    abstract void draw(); 
```

**Description:** Close curly braces to end the class definition.

```java
}
```

**Description:** A Java statement to describe `Circle` that extends the `Shape` class and provides an implementation of the `draw()` method.

```java
public class Circle extends Shape {
```

**Description:** A Java annotation to tell the compiler the `draw()` method in `Circle` is an override of the abstract method in `Shape`.

```java
    @Override
```

**Description:** A Java statement saying the `draw` method is now fully implemented.

```java
    void draw()
```

**Description:** Print the string `Drawing Circle` to the console using the `System.out.println()` function.

```java
	System.out.println("Drawing Circle"); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
}
```

---

## Using encapsulation

### Creating an encapsulated class

**Description:** Create the `Person` class, which serves as a blueprint for creating `Person` objects.

```java
class Person { 
```

**Description:** Create `private` attributes `name` and `age` to store the person's name and age. The `name` and `age` attributes cannot be accessed directly from outside the class.

```java
    private String name;
    private int age; 
```

**Description:** Use the Java constructor to initialize the `name` and `age` variables when a `Person` object is created.

```java
    public Person(String name, int age) {
```

**Description:** The keyword `this` refers to the current object's instance variables. It differentiates instance variables from method parameters.

```java
	this.name = name;
	this.age = age; 
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** Use the Java `public` method (Getter) to obtain read access to `private` variables.

```java
    public String getName() {
```

**Description:** `getName()` returns the value of `name`.

```java
	return name; 
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** Use the Java `public` method (Setter) to obtain write access to `private` variables.

```java
    public void setName(String name) {
```

**Description:** `setName()` updates `name`.

```java
	this.name = name; 
```

**Description:** Use the Java `public` method (Getter) to obtain read access to `private` variables.

```java
    public int getAge() {
```

**Description:** `getAge()` returns the value of `age`.

```java
	return age; 
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** Use the Java `public` method (Setter) to obtain write access to `private` variables.

```java
    public void setAge(int age) {
```

**Description:** Use the Java `if` statement to ensure `age` is not negative before assigning.

```java
	if (age >= 0) { 
```

**Description:** Update the `age` variable.

```java
	    this.age = age; 
```

**Description:** Use the Java `else` statement to specify what to do when the `age` is negative.

```java
	} else { 
```

**Description:** Print the string `Age cannot be negative` to the console using the `System.out.println()` function.

```java
	    System.out.println("Age cannot be negative."); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Explanation:** This example creates a `Person` class in which the `name` and `age` attributes are declared as `private`, meaning they cannot be accessed directly from outside the `Person` class. The constructor `Person(String name, int age)` initializes the attributes when a new object of the class is created. `getName()` and `getAge()` are getter methods that allow other classes to read the values of `name` and `age`. `setName(String name)` and `setAge(int age)` are setter methods that allow other classes to modify the values of `name` and `age`. The setter for `age` includes validation to ensure `age` cannot be set to a negative number.

### Using an encapsulated class

**Description:** A Java class named `Main` with a `main` method. The `main` method is the entry point of the program.

```java
public class Main { 
```

**Description:** The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs.

```java
 public static void main(String[] args) {
```

**Description:** Create a new instance of the `Person` class. Assign the value `"Alice"` to the `name` attribute and the value `"30"` to the `age` attribute.

```java
    Person person = new Person("Alice", 30); 
```

**Description:** Use the `getName()` getter to obtain and print the value of the `name` attribute.

```java
    System.out.println("Name: " + person.getName()); 
```

**Description:** Use the `getAge()` getter to obtain and print the value of the `age` attribute.

```java
    System.out.println("Age: " + person.getAge()); 
```

**Description:** Use the `setName()` setter to assign the value of `name` attribute to `"Bob"` and `age` attribute to `"25"`.

```java
    person.setName("Bob");
    person.setAge(25); 
```

**Description:** Use the `getName()` getter to obtain and print the updated value of the `name` attribute.

```java
    System.out.println("Updated Name: " + person.getName()); 
```

**Description:** The `setAge(-5)` call attempts to set an invalid age. Since `setAge()` has validation logic, it will print `"Age cannot be negative."`.

```java
    System.out.println("Updated Age: " + person.getAge()); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Explanation:** This example creates an instance of the `Person` class with the name `"Alice"` and age `"30"`. We call the `getName()` and `getAge()` getter methods to print the values. We then update the `name` and `age` attributes using the `setName()` and `setAge()` setter methods. When we attempt to set a negative age with `setAge(-5)`, it prints an error message because of validation included in the setter method.

---

## Using constructors

### Creating a default constructor

**Description:** A Java statement used to define a class named `Dog`, which acts as a blueprint for creating `Dog` objects.

```java
class Dog {
```

**Description:** A Java statement to declare a `String` variable named `name` without any access modifier. If no access modifier is used, the variable is considered `default`. Default variables are accessible only within their own package.

```java
    String name;
```

**Description:** This is the default constructor. It takes no arguments.

```java
    Dog() {
```

**Description:** The default constructor initializes the `name` variable with the value `"Unknown"`. This ensures every new `Dog` object always has a name, even if the user doesn't provide one.

```java
	name = "Unknown"; 
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** Call the `display()` method without any access modifier.

```java
    void display() {
```

**Description:** Print the dog's name to the console using the `System.out.println()` function. Since `name` was initialized in the constructor, it always has a value.

```java
	System.out.println("Dog's name: " + name); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Description:** A Java class named `Main` with a `main` method. The `main` method is the entry point of the program.

```java
public class Main { 
```

**Description:** The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs.

```java
public static void main(String[] args) {
```

**Description:** Create an instance of the `Dog` class using the default constructor. The `name` variable is automatically set to `"Unknown"`.

```java
	Dog myDog = new Dog(); 
```

**Description:** Call the `display()` method to print the dog's name.

```java
	myDog.display(); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Explanation:** This example creates an instance of the `Dog` class with a default constructor that initializes the `name` attribute to `"Unknown"`. When we create the instance, the default constructor is invoked automatically.

### Creating a parameterized constructor

**Description:** A Java statement used to define a class named `Dog`, which acts as a blueprint for creating `Dog` objects.

```java
class Dog {
```

**Description:** A Java statement to declare a `String` variable named `name` without any access modifier. If no access modifier is used, the variable is considered `default`. Default variables are accessible only within their own package.

```java
    String name;
```

**Description:** This is the parameterized constructor that takes one argument `dogName`.

```java
    Dog(String dogName) { 
```

**Description:** When the `Dog` object is created, the provided `dogName` value is assigned to the `name` variable. Parameterized constructors let you assign a unique name to each `Dog` object when it is created.

```java
	name = dogName; 
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** Call the `display()` method without any access modifier.

```java
    void display() {
```

**Description:** Print the dog's name to the console using the `System.out.println()` function. Since `name` was initialized in the constructor, it always has a value.

```java
	System.out.println("Dog's name: " + name); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Description:** A Java class named `Main` with a `main` method. The `main` method is the entry point of the program.

```java
public class Main { 
```

**Description:** The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs.

```java
public static void main(String[] args) {
```

**Description:** Create an instance of the `Dog` class. `"Buddy"` is passed as an argument to the constructor, setting `name` to `"Buddy"`.

```java
	Dog myDog = new Dog("Buddy"); 
```

**Description:** Call the `display()` method to print the dog's name.

```java
	myDog.display(); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Explanation:** This example creates an instance of the `Dog` class with a parameterized constructor that takes a string parameter `dogName`. When we create a `Dog` instance with the name `"Buddy"`, the constructor initializes the `name` attribute with that value.

### Creating a no-arg constructor

**Description:** A Java statement used to define a class named `Car`, which acts as a blueprint for creating `Car` objects.

```java
class Car {
```

**Description:** A Java statement to declare a `String` variable named `model` and an `int` variable named `year` without any access modifier. If no access modifier is used, the variable is considered `default`. Default variables are accessible only within their own package.

```java
    String model;
    int year;
```

**Description:** This is a no-argument constructor that takes no parameters.

```java
    Car() { 
```

**Description:** When the `Car` object is created, it automatically assigns the value `"Default Model"` to `model` and `2020` to `year`.

```java
	model = "Default Model";
	year = 2020;  
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** Call the `display()` method without any access modifier.

```java
    void display() {
```

**Description:** Print the car's model and year to the console using the `System.out.println()` function.

```java
	System.out.println("Car Model: " + model + ", Year: " + year); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Description:** A Java class named `Main` with a `main` method. The `main` method is the entry point of the program.

```java
public class Main { 
```

**Description:** The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs.

```java
public static void main(String[] args) {
```

**Description:** Create an instance of the `Car` class. The no-argument constructor is called, setting `model = "Default Model"` and `year = 2020`.

```java
	Car myCar = new Car(); 
```

**Description:** Call the `display()` method to print the model and year of the car.

```java
	myCar.display(); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Explanation:** This example creates an instance of the `Car` class with two attributes `model` and `year`. The `Car()` constructor initializes the `model` to `"Default Model"` and `year` to `2020`. When we create an instance of the `Car` class with `new Car()`, the no-arg constructor is called automatically, and the default values are assigned to the attributes. The `display()` method prints the model and year of the car.

### Constructor overloading

**Description:** A Java statement used to define a class named `Dog`, which acts as a blueprint for creating `Dog` objects.

```java
class Dog {
```

**Description:** A Java statement to declare a `String` variable named `name` and an `int` variable named `age` without any access modifier. If no access modifier is used, the variable is considered `default`. Default variables are accessible only within their own package.

```java
    String name;
    int age;
```

**Description:** This is the default constructor. It takes no arguments.

```java
    Dog() {
```

**Description:** The default constructor initializes the `name` variable with the value `"Unknown"` and `age` variable with the value `0`. This ensures every new `Dog` object always has a name and age, even if the user doesn't provide one.

```java
	name = "Unknown";
	age = 0; 
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** This is the parameterized constructor that takes one argument `dogName`.

```java
    Dog(String dogName) { 
```

**Description:** When the `Dog` object is created, the provided `dogName` value is assigned to `name` while keeping the `age` as `0` by default. Parameterized constructors let you assign a unique name to each `Dog` object when it is created.

```java
	name = dogName;
	age = 0; 
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** This is the parameterized constructor that takes two arguments `dogName` and `dogAge`.

```java
    Dog(String dogName, int dogAge) { 
```

**Description:** When the `Dog` object is created, the constructor allows the user to specify both `name` and `age`.

```java
	name = dogName;
	age = dogAge; 
```

**Description:** Close curly braces to end the class definition.

```java
    }
```

**Description:** Call the `display()` method without any access modifier.

```java
    void display() {
```

**Description:** Print the dog's name and age to the console using the `System.out.println()` function. Since `name` and `age` were initialized in the constructor, they always have a value.

```java
	System.out.println("Dog's name: " + name + ", Age: " + age); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Description:** A Java class named `Main` with a `main` method. The `main` method is the entry point of the program.

```java
public class Main { 
```

**Description:** The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs.

```java
public static void main(String[] args) {
```

**Description:** Create the `dog1` object using the default constructor `Dog()`. So, `name = "Unknown"` and `age = 0`.

```java
	Dog dog1 = new Dog();  
```

**Description:** Create the `dog2` object using the one-parameter constructor `Dog("Charlie")`. So, `name = "Charlie"` and `age = 0` (default).

```java
	Dog dog2 = new Dog();  
```

**Description:** Create the `dog3` object using the two-parameter constructor `Dog("Max", 5)`. So, `name = "Max"` and `age = 5`.

```java
	Dog dog3 = new Dog();  
```

**Description:** Call the `display()` method on each object to print their details.

```java
	dog1.display();
	dog2.display();
	dog3.display(); 
```

**Description:** Close curly braces to end the class definition.

```java
    }
}
```

**Explanation:** This example has three constructors of the `Dog` class. Depending on the number of parameters provided when creating an object, the corresponding constructor is called.
