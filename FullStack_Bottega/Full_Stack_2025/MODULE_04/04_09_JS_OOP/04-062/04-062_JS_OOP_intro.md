# MODULE 04-062:     JavaScript

## OOP programming (0)    Introduction

***

1. OOP Fundamentals
2. Classes as Blueprints
3. Instantiation Process
4. Practical Applications
5. Modern JavaScript OOP

***

## 1. OOP Fundamentals

Object-Oriented Programming (OOP) is a programming paradigm that organizes code into **objects** containing both:

* **Data** (properties/attributes)
* **Behavior** (methods/functions)

**Core Principles:**

* **Encapsulation:** Bundling data with methods
* **Abstraction:** Hiding complex implementation
* **Inheritance:** Sharing functionality between classes
* **Polymorphism:** Different classes implementing same methods differently

***

## 2. Classes as Blueprints

### The Blueprint Analogy

A class is like an architectural blueprint - it defines structure but isn't the actual building.

```js
// House class blueprint
class House {
  constructor(rooms, doors) {
    this.rooms = rooms;
    this.doors = doors;
  }

  describe() {
    return `A house with ${this.rooms} rooms and ${this.doors} doors`;
  }
}
```

**Key Characteristics:**

* Defines properties (data)
* Contains methods (behavior)
* Serves as template for creating objects

***

## 3. Instantiation Process

Instantiation creates concrete objects from the class blueprint.

### User Class Example

```js
class User {
  constructor(name, email) {
    this.name = name;
    this.email = email;
  }

  greet() {
    return `Hello, ${this.name}!`;
  }
}
```

### Creating Instances

```js
const user1 = new User('Alice', 'alice@example.com');
const user2 = new User('Bob', 'bob@example.com');

user1.greet(); // "Hello, Alice!"
user2.greet(); // "Hello, Bob!"
```

**Visual Representation:**

```js
Class: User
---------------------
| name: string      |
| email: string     |
|-------------------|
| greet(): string   |
---------------------
        ↑
        | new User()
        ↓
Instance: user1
---------------------
| name: "Alice"     |
| email: "alice@..."|
---------------------
```

***

## 4. Practical Applications

### Framework Usage

Modern JavaScript frameworks heavily utilize OOP:

| Framework | OOP Concept           |
| --------- | --------------------- |
| React     | Components as classes |
| Angular   | Services, Components  |
| Vue       | Options API           |

### Real-World Patterns

1. **User Management Systems**
2. **E-commerce Product Catalog**
3. **Game Development Entities**

***

## 5. Modern JavaScript OOP

### Evolution Timeline

1. **ES5:** Prototype-based inheritance
2. **ES6:** Class syntax introduced
3. **ESNext:** Private fields, static blocks

### Key Terminology

| Term        | Description                        |
| ----------- | ---------------------------------- |
| Class       | Template for creating objects      |
| Instance    | Concrete object created from class |
| Constructor | Special method for initialization  |
| Method      | Function defined in class          |
| Property    | Data attribute of class/instance   |

***

## Common Misconceptions

1. **"JavaScript isn't truly OOP"**
   * While prototype-based, modern JS supports classical OOP patterns
2. **"Classes are just syntactic sugar"**
   * While built on prototypes, classes provide clearer structure
3. **"OOP is only for large applications"**
   * Useful even in small projects for organization

***

## Best Practices

1. **Single Responsibility Principle**\
   Each class should have one clear purpose
2. **Consistent Naming Conventions**
   * Classes: `PascalCase` (`UserAccount`)
   * Methods: `camelCase` (`calculateTotal`)
3. **Favor Composition Over Inheritance**\
   Build functionality by combining simple objects

***

## Resources

* [Classes - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes)
* https://javascript.info/class
*

***

##

## Video lesson Speech

For years older versions of JavaScript did not have the Object Oriented\
Programming components of classes and instantiation and that was fine\
for a period of time. But more modern versions of JavaScript have\
implemented classes.

***

Now if you have never worked in an object-oriented programming language then some of those concepts may seem very abstract and so in this introduction, I want to walk through what object-oriented programming is and then in the section guides in the screencast we'll see how we can implement that inside of JavaScript.

Through the years as I've been teaching students object-oriented programming techniques. I've noticed that it seems to be one of the concepts that can be very intimidating. And so what I want to give to you is an understanding of the key components that make up object-oriented programming. Because what I've found is it's not really the concept that is confusing but it's the fact that it uses a ton of very confusing words and so I want to give a little bit of clarification on those words. And we're going to start off with a real-world example.

So if on the chalkboard here I decide to create a blueprint for the house or a house and I create a floor plan and I draw up some bedrooms and show where the door is and I have all of these different elements here I'm just drawing a blueprint for a house a very poor blueprint. But just imagine it's an amazing blueprint. Now, this technically is not a house. I don't think we're going to get any arguments on that.

A house has a foundation, it has wood, it has a roof, it has all of these different elements that make it a real-world house this is simply a blueprint. Now in object-oriented programming, we have, and let's start off with the concept of a class. A class is like our blueprint here. A class is simply a list of definitions that say exactly how the class should behave. It will list out attributes so it can describe what the class is supposed to do and the behavior it's going to have.

Let's imagine a User class, every time that a new user comes to the site and registers you're going to look and the program is going to look at your User class and it's going to see the blueprint. It's good to see how that user should behave and then we're going to take it to the next step and this is one of the words that I have seen gets students very confused and the word is instantiation. That's a big word. All it means is that we're taking that blueprint and we're creating a real-world object with it.

So going to our user example if we have a User class and it has a user name and it has some functions such as saying what we want the user to do after they've logged in such as what page we want to see and what kind of attributes we want to have available to the user such as grabbing their last name or anything like that, that their application needs.

What the program's going to do is it's going to look at the blueprint and then it's going to then create and instantiate an object with it and it's going to be the object they are actually going to work with. If you have Bob and Sally come to the site Bob logs in and the system looks at this user blueprint it looks at the class and then it instantiates a bob user object. It's no longer a blueprint. It is now something that your system can use.

Throughout this section, we're going to talk about those two topics classes and instantiation because those are two of the most critical types of things for you to understand and we're going to go into some other topics such as understanding static and instance methods and also seeing how we can use tools such as implements and using which are a couple of key keywords that allow us to take the functionality from one class and poured it over into our own.

This is going to be a pattern that you're going to see quite a bit in using tools such as react and view and angular. And so I want you to be able to see what's actually happening because if say that you simply took a react tutorial and you saw all of these different keywords such as class and implements and using and if you see these things and you don't actually know the fundamentals that are going on in just the pure vanilla javascript you might think that there are specific to that framework or you may not understand exactly what's going on behind the scenes and so that's what I want to do is I want you to be able to understand that this is just pure Javascript and we're leveraging object-oriented programming in order to build out our own systems.
