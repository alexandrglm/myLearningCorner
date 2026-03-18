# 02-010 Summary: Advanced Object Oriented Programming Concepts

---

## Inheritance

- Inheritance enables subclasses to inherit properties and methods from superclasses.

- The different types of inheritance are `single`, `multilevel`, `hierarchical`, and `multiple` inheritance.

- Inheritance has various applications, such as facilitating code reuse, hierarchical classification, and method overriding. It is also widely used in game development, UI components, and data models.

---

## Polymorphism

- Polymorphism allows objects to share the same interface while exhibiting different behaviors.

- The two types of polymorphism are:
  - **Compile-time polymorphism**, or **method overloading**, which occurs when multiple methods that belong to the same class have the same name but differ in the number or type of parameters.
  - **Runtime polymorphism**, or **method overriding**, which occurs when a subclass provides its specific implementation of a method defined in its superclass.

- Polymorphism is widely used in software development for code reuse, decoupling, dynamic method resolution, framework development, and code maintenance.

---

## Abstraction

- Abstraction simplifies complex systems by hiding unnecessary details, allowing for easier understanding and use.

- Interfaces define contracts that implementing classes must follow, specifying the methods they must implement.

- Abstract classes provide a common base for related classes, offering abstract and concrete methods to share behavior and enforce necessary implementations.

- The advantages of abstraction include simplifying systems, promoting code reusability, enhancing flexibility, and supporting polymorphism.

---

## Inner Classes

- An inner class is a class defined within another class in Java, enabling direct access to the members of the outer class.

- To use an inner class, you have to create an instance of the outer class and then an instance of the inner class.

- Java has several types of inner classes:
  - **Non-static inner class**: Can access both static and non-static members of the outer class.
  - **Static nested class**: Cannot access non-static members of the outer class directly.
  - **Method-local inner class**: Can only be accessed within that method.
  - **Anonymous inner class**: Used to instantiate a class that may not be reused elsewhere.

- Inner classes are useful for encapsulation, logical grouping, accessing outer class members, event handling, and data structure implementation.
