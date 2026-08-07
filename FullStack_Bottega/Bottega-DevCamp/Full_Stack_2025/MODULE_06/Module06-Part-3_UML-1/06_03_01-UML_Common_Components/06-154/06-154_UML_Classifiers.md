# Module 06 - 154:     UML Components

## CLASSIFIERS

***

1. What Classifiers are
2. Abstract Nature of Classifiers
3. Universal Application Across Diagrams
4. Key Characteristics and Functions
5. Common Usage Examples
6. Classifiers vs Classes - Key Distinction
7. Implementation Guidelines

***

## 1.    What Classifiers Are

Classifiers are fundamental UML components that serve as **identification mechanisms for various elements within UML diagrams**.

> We refer a class, an object, a component, or a deployment node as classifiers in UML since they define a common set of properties. We are able to design object diagrams by instantiating classifiers.

They provide **a standardised naming convention** that **enables clear communication** between designers, developers, and stakeholders throughout the software development life-cycle.

The primary purpose of classifiers is exactly what their name implies - they **classify items**.

This **high-level categorisation** system ensures consistency and clarity across all UML documentation and serves as a foundation for understanding the structure and relationships within a system.

***

## 2.    Abstract Nature of Classifiers

One of the most important concepts to understand about classifiers is their **abstract nature**.

This means:

* **You won't implement a classifier directly** in code
* Classifiers are more of a **category or template** for components
* They serve as a **conceptual framework** rather than concrete implementations
* This abstract characteristic often trips up newcomers to UML

***

## 3.    Universal Application Across Diagrams

Classifiers are utilised in virtually every type of UML diagram, making them one of the most pervasive elements in UML modeling.

They appear in:

* **Class Diagrams** - Naming classes and their relationships
* **Use Case Diagrams** - Identifying actors and use cases
* **Sequence Diagrams** - Labeling objects and lifelines
* **Activity Diagrams** - Naming activities and decision points
* **Component Diagrams** - Identifying system components
* **Deployment Diagrams** - Naming hardware and software nodes
* **State Machine Diagrams** - Labeling states and transitions
* **Communication Diagrams** - Identifying participating objects

This universal application makes classifiers an essential skill for anyone working with UML throughout their career.

***

## 4.    Key Characteristics and Functions

### _Standardisation_

Classifiers provide a **unified naming approach** across all UML elements, ensuring consistency in documentation and communication.

### _Identification_

They serve as **unique identifiers** for different components, making it easier to reference and discuss specific elements during development.

### _Communication_

Classifiers act as a **common language** between team members, facilitating better understanding and collaboration.

### _Documentation_

They provide **clear labeling** that makes UML diagrams self-documenting and easier to maintain over time.

***

## 5.    Common Usage Examples

### Class Diagrams

In a class diagram, the classifier appears as the **class name** at the top of each class box.

![large](../../../../../../../.gitbook/assets/06-154_IMG3.png)

For example, if you have a class representing a blog system, "Topic" would be the classifier for that particular class.

### Use Case Diagrams

When creating use case diagrams, classifiers identify:

* **Actor names** (e.g., "User", "Administrator")
* **Use case names** (e.g., "Login", "Create Post", "Manage Content")

### Object Diagrams

Classifiers in object diagrams represent the **type or class** that each object instance belongs to.

***

## 6.    Classifiers vs Classes - Key Distinction

A common source of confusion is the relationship between **classifiers** and **classes**:

### Classifier

* A **naming mechanism** used across all UML diagrams
* An **abstract concept** for identification
* **Not specific** to class diagrams only
* Used for **categorization purposes**

### Class

* A **specific element** in class diagrams
* Represents a **concrete blueprint** for objects
* Contains **attributes and methods**
* **Implementation-focused**

**Important Note**: A class in a class diagram **has** a classifier (its name), but the classifier itself is not the same as the class. The classifier is simply the identification label.

***

## 7.    Implementation Guidelines

### Naming Conventions

* Use **clear, descriptive names** that reflect the element's purpose
* Follow **consistent naming patterns** throughout your project
* Avoid **abbreviations** unless they are widely understood
* Use **meaningful terminology** relevant to the problem domain

### Consistency

* Maintain **uniform naming styles** across all diagrams
* Ensure **alignment** between different diagram types
* Use the **same classifier** for the same concept across different views

### Documentation

* **Document classifier meanings** when they might be ambiguous
* Provide **context** for domain-specific terminology
* Maintain a **glossary** of classifiers used in complex projects

***

## Best Practices and Tips

### Design Phase

* **Plan your classifier naming strategy** early in the project
* **Involve stakeholders** in defining meaningful names
* **Consider future maintenance** when choosing names

### Implementation

* **Review classifier consistency** regularly across diagrams
* **Refactor names** when requirements change
* **Validate understanding** with team members

### Documentation

* **Keep a master list** of all classifiers used
* **Update documentation** when classifiers change
* **Provide context** for technical or domain-specific terms

### Common Pitfalls to Avoid

* Don't confuse classifiers with the actual implementation elements
* Avoid using the same name for different concepts
* Don't change classifier names without updating all related diagrams
* Resist the temptation to use overly technical jargon

***

## References

* https://www.geeksforgeeks.org/system-design/unified-modeling-language-uml-class-diagrams/
* https://www.geeksforgeeks.org/system-design/unified-modeling-language-uml-object-diagrams/
* [UML Classifiers Overview - UML-diagrams.org](https://www.uml-diagrams.org/classifier.html)
* [Composite Structure Diagram - UML 2 Diagrams - UML Modeling Tool](https://www.visual-paradigm.com/VPGallery/diagrams/CompositeStructureDiagram.html)
* [Introduction to the Diagrams of UML 2.X](https://agilemodeling.com/essays/umldiagrams.htm)

***

## Video Lesson Speech

Next on our list of common UML components are classifiers. Classifiers\
allow us to identify components. One thing that can be a little bit\
tricky when you're starting to use UML is that classifiers are\
technically abstract.

***

## Classifiers

What that means is you won't actually implement a classifier directly. It's more of a category of components that you're going to see in practically every kind of diagram. That is the one part that can trip people up, whether it's on an exam or anything like that.

You are going to be using classifiers throughout the entire course and throughout your entire career as long as you're using UML. Essentially, what they do is exactly what the name implies, they classify items. It's high level, it allows you to have a standardized naming convention as you start building out your designs. Also as developers are reading your designs, they are going to be using classifiers as the application is built.

![large](../../../../../../../.gitbook/assets/06-154_IMG1.png)

So what are some different components and diagrams that use classifiers?

![large](../../../../../../../.gitbook/assets/06-154_IMG2.png)

I was not kidding when I said they're used by pretty much every diagram that you're going to implement. It means that this is the high-level name, make sure to not get it confused with a class diagram. I have seen a number of different forum posts and questions from students asking if a class is a class diagram is the same as a classifier and no it is not. A classifier is simply a way of titling your different UML components and diagrams, it allows you to have one kind of standardized approach.

An example is here in a class diagram where you see "Topic" on the right-hand side. That is the name of the class and that is the classifier for the class diagram. If you are doing this in a Use Case Diagram, like we'll get into later in the course, when you name that Use Case Diagram and you name the different elements that are associated whether it's a topic or a blog post or anything like that, those are the classifiers.

![large](../../../../../../../.gitbook/assets/06-154_IMG3.png)
