# Module 06 - 150:     UML

## UML Overview

---

# Objectives

- ==Understand when and why to use UML in== different development phases
- Identify appropriate UML diagram types for specific development stages
- Recognize the problem-solving benefits of UML modeling
- Apply UML as a planning and communication tool

---

1. What UML is

2. Historical Context and Creation

3. Benefits for Developers
   
   - Language Agnostic Communication
   - Non-Technical Stakeholder Communication
   - Abstraction Level Achievement

4. Fundamental Value Proposition

---

## 1.     What UML is

**UML** stands for **Unified Modeling Language**. The term "Unified" is crucial to understanding UML's purpose and origin - as it represents the standardization of previously fragmented visual modeling approaches in software development.

UML is a standardized visual language for modeling software systems, providing a common notation that developers, architects, and stakeholders can use to communicate system design and behavior regardless of their technical background or preferred programming language.

---

## 2.     Historical Context and Creation

### The Problem Before UML

Prior to UML's creation, software modeling was characterized by:

- **Fragmented Approaches**: Multiple incompatible visual modeling methods
- **Communication Barriers**: Developers used personal diagramming styles that others couldn't understand
- **Translation Difficulties**: Visual models couldn't be easily converted into actionable code
- **Industry Inefficiency**: Lack of standardized visual communication methods

### UML Creation Timeline

* **1994**: Three software engineers* began developing a unified approach to system modeling

* **1996**: The Unified Modeling Language was officially established

### The Three Founders*

- **Grady Booch**
- **Ivar Jacobson**
- **James Rumbaugh**

### Evolution and Stability

UML has undergone continuous updates since 1996, similar to programming languages, while maintaining its core conceptual foundation.  

 The fundamental principles established in 1996 remain relevant and widely used today.

---

## 3.     Benefits for Developers

### A)    Language Agnostic Communication

**Problem Scenario**

A Ruby developer needs to explain system architecture to Java or JavaScript developers who don't understand Ruby syntax.

**UML Solution**

 Visual models transcend programming language boundaries by focusing on:

- System interaction patterns
- Data organization structures
- Database design
- Inter-class messaging and behavior
- Overall system architecture

**Key Advantage**

==<u>Developers can communicate complex system concepts without being constrained by language-specific syntax or implementation details.</u>==

### 

### B)    Non-Technical Stakeholder Communication

**Challenge** 

Non-developers cannot understand code but need to verify that system behavior matches project requirements and expectations.

**UML Application**

- **User Behavior Modeling**: Visual representation of how users interact with the system
- **System Process Visualization**: Clear diagrams showing what the system does
- **Requirement Validation**: Stakeholders can verify that modeled behavior aligns with their expectations
- **Project Communication**: Bridge between technical implementation and business requirements

**Business Value**

 Enables effective collaboration between technical teams and business stakeholders, reducing miscommunication and ensuring alignment.

### C)    Abstraction Level Achievement

**Abstraction Concept**

 UML provides a level of abstraction that removes implementation details and focuses on high-level system behavior and structure.

**What UML Abstracts Away**

- Specific code syntax and implementation
- Language-specific details
- Low-level technical complexities
- Platform-specific considerations

**What UML Emphasizes**

- System behavior patterns
- Structural relationships
- Data flow and organization
- Component interactions
- Process workflows

**Developer Benefit**

<u> Enables focus on system design and architecture without getting lost i implementation specifics, facilitating better planning and design decisions.</u>

---

## 4.     Fundamental Value Proposition

UML serves as a **universal visual language** for software development that:

* **Standardizes Communication**: Provides consistent notation understood across the software industry

* **Bridges Technical Gaps**: Enables communication between developers using different programming languages

* **Facilitates Stakeholder Collaboration**: Allows technical and non-technical team members to participate in system design discussions

* **Enhances Design Process**: Enables high-level system thinking before diving into implementation details

* **Improves Documentation**: Creates visual documentation that remains relevant regardless of code changes

* **Planning Tool**: Serves as an effective planning mechanism for system architecture and design

The core strength of UML lies in its **ability to abstract away implementation complexity while preserving essential system design information**, making it an invaluable tool for both individual developers and collaborative teams working on complex software systems.

---

## Video Lesson Speech

Welcome to this first guide in the UML for developers course. In this 
video, we're going to discuss what UML is and also why it's important 
for you as a developer. As you may have guessed, UML is an acronym, it 
stands for Unified Modeling Language. The very first word, Unified, is a
 very important part of understanding how UML came into being.

****

Years ago, and I mean decades ago, there were all kinds of different ideas when it came to how you would model systems visually. You'd have people getting up on whiteboards drawing out all their sight components or software components and state that this piece is going to communicate with this other piece. It made sense to them, however, when they showed it to someone who had not seen their style of modeling, that person would have no idea what to do. If it was given to a developer, the developer many times would be very confused in how they could translate those diagrams into actionable code. 

This was a pretty significant problem in the software industry. In 1994 three gentlemen came up with a system to standardize the process of modeling. By 1996 the Unified Modeling Language was born. The three engineers who came up with the concept of UML were Grady Booch, Ivar Jacobson, and James Rumbaugh. Since being finalized in 1996, the language has gone through a number of updates, just like a regular programming language and it has continually evolved. One thing that's pretty impressive about UML is that the same core concepts that were published in 1996 are still being used today. These will be the same concepts we're going to cover with this course. 

Now we've walked through a brief history of UML and how it was created, let's talk about the rationale and why it's important for us to use as software developers and as software engineers. When someone asks me why it's important to learn UML, one of the very first things I point out is that it's "Language Agnostic." That means if I primarily work has a ruby developer building a system, and I want to talk to a Java or Javascript developer (or any other language), it's going to be pretty hard for me to show them code they personally don't work with or understand. What UML would allow me to do in this situation, is create visual models of how systems interact. UML would show how I organize data or build a database, all the way through how messages are sent from one class to another to produce the expected behavior. 

Another great reason to use UML is when you're working with non-technical stakeholders on a project. There have been many instances as a freelance consultant or when I worked for large companies and multiple people on the team were not software developers or software engineers, I can't show non-developers a line of code and expect them to understand what it does. Using UML, we can model these systems so non-developers can see what the user behavior is going to be and understand what the system does in order to verify the behavior matches their expectations and requirements of the project. 

This also speaks to one of the most important aspects about UML, it gives you a level of abstraction that is very difficult to achieve using any other tool. When I say level of abstraction, what I mean is that I take out the implementation details and remove the code. I focus on the high-level behavior or structure of a system.

In this guide, we've discussed what UML is a brief history of it and also why it's important to use.

In the next guide, we're going to talk about what stages of development UML can be used for and how we can structure our approach to it that way. 
