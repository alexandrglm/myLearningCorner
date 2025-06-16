# MODULE 06 - 162    UML Diagrams

## Behavioral Diagrams - Overview

---

## Table of Contents

1. Introduction to Behavioral Diagrams

2. Activity Diagrams
   2.1. Purpose and Non-Technical Accessibility  
   2.2. Core Elements  
   2.3. Coffee Ordering Service Example  
   2.4. User Experience Modeling  

3. Use Case Diagrams
   3.1. Authorization System Illustration  
   3.2. Core Components  
   3.3. Marketing Engine Example  
   3.4. Actor-Based Access Control  

4. State Machine Diagrams
   4.1. Data Lifecycle Visualization  
   4.2. Essential Elements  
   4.3. Lead Funnel Example  
   4.4. Comparison with Activity Diagrams  

5. Sequence Diagrams
   5.1. Message-Based System Design  
   5.2. Implementation-Focused Elements  
   5.3. Phone Parser Example  
   5.4. Input-Output System Thinking  

6. Best Practices and Implementation Guidelines

7. Tools and Diagram Selection Criteria

---

## 1.    Introduction to Behavioral Diagrams

Behavioral diagrams represent the dynamic aspects of UML modeling, illustrating **how systems should behave, act, and interact with internal components and external actors.** 

Unlike structural diagrams that show what exists in the system, behavioral diagrams **focus on what happens** when the system runs, giving clarity for understanding the system behavior, user interactions, and the dynamic relationships between system components.

The four primary behavioral diagrams covered are:

- **Activity Diagrams**: Workflow and process modeling
- **Use Case Diagrams**: User interaction and system functionality
- **State Machine Diagrams**: Object state transitions and lifecycle
- **Sequence Diagrams**: Message passing and system interactions


---

## 2.    Activity Diagrams

### Purpose and Non-Technical Accessibility

Activity diagrams are exceptionally powerful for visualizing system workflows and user processes. Their greatest strength lies in their accessibility to non-technical stakeholders. Executives and business users who may have no understanding of UML notation can easily comprehend activity diagrams, making them invaluable for stakeholder communication.

**Key Benefits:**

- **Business Communication**: Bridge between technical and non-technical teams
- **Process Documentation**: Clear visualization of business workflows
- **System Planning**: Foundation for building systems from scratch
- **User Journey Mapping**: Complete user lifecycle visualization

### Core Elements

Activity diagrams comprise six essential components:

1. **Initial State**: Starting point of the process (solid black circle)
2. **Activity/Action State**: Individual steps or processes (rounded rectangles)
3. **Action Flow**: Directional arrows showing process flow
4. **Decisions/Branching**: Diamond shapes representing choice points
5. **Guards**: Conditions that must be met for transitions
6. **Final State**: End point of the process (solid black circle with outer ring)

### Coffee Ordering Service Example

The coffee ordering service demonstrates how activity diagrams capture complex user interactions:

**Process Flow:**

1. User initiates order online
2. Decision point based on user selection
3. Multiple pathways depending on choices:
   - Product search and selection
   - Product viewing and details
   - Cart addition and management
   - Checkout and payment processing

This single diagram encapsulates the entire user experience, providing developers with a clear roadmap for application implementation.

### User Experience Modeling

Activity diagrams excel at high-level process modeling because they focus on activities rather than technical implementation details. They answer critical questions:

- What happens when users search for products?
- How do users navigate product selection?
- What decision points exist in the user journey?
- How do different user choices affect the workflow?

---

## 3.    Use Case Diagrams

### Authorization System Illustration

Use case diagrams provide high-level visualization of system functionality and user access rights. They're particularly valuable for designing authorization systems, clearly showing what different user types can access and accomplish within the system.

**Primary Applications:**

- **Authorization Design**: Defining user roles and permissions
- **System Scope Definition**: Boundary setting for system functionality
- **Stakeholder Communication**: Clear presentation of system capabilities
- **Feature Planning**: Comprehensive view of system features

### Core Components

Use case diagrams consist of four fundamental elements:

1. **Use Cases**: System functionality represented as ovals
2. **Actors**: Users or external systems (stick figures)
3. **Subsystems**: Grouped functionality within system boundaries
4. **Relationships**: Connections showing interactions and dependencies

### Marketing Engine Example

The marketing engine use case diagram illustrates dual-actor scenarios:

**Actor Roles:**

- **Marketing Specialist**: Administrative access and content creation
- **Customer**: End-user interaction and consumption

**Relationship Types:**

- **Association**: Direct actor-to-use case connections
- **Include**: Required functionality dependencies
- **Extend**: Optional functionality extensions

Different actors access the same use cases through different pathways, demonstrating how authorization systems control user behavior and access rights.

### Actor-Based Access Control

Use case diagrams effectively model complex authorization scenarios:

- **Employee vs. Admin**: Different access levels to timesheet systems
- **Customer vs. Specialist**: Varying capabilities within the same system
- **Role-Based Permissions**: Clear visualization of who can do what

---

## 4.    State Machine Diagrams

### Data Lifecycle Visualization

State machine diagrams represent one of computer science's fundamental concepts, visualizing how data and objects transition through different states during system lifecycle. They focus on the various stages of system components and the conditions that trigger state changes.

**Core Purpose:**

- **State Transition Modeling**: How objects change over time
- **Condition-Based Logic**: Rules governing state changes
- **System Behavior**: Dynamic aspects of system components
- **Lifecycle Management**: Complete object lifecycle visualization

### Essential Elements

State machine diagrams incorporate five key components:

1. **Entry Point**: Initial state (solid black circle)
2. **Choices**: Decision points determining transitions
3. **Constraints**: Conditions governing state changes
4. **States**: Stable conditions or situations (rectangles)
5. **Transitions**: State-to-state movements (arrows)

### Lead Funnel Example

The lead funnel state machine demonstrates customer progression:

**State Progression:**

- **Visitor**: Initial user state
- **Converted**: Post-form submission state
- **Lead**: Qualified prospect state
- **Customer**: Final conversion state

Each transition requires specific conditions, illustrating how business rules govern customer progression through the sales funnel.

### Comparison with Activity Diagrams

State machine diagrams share similarities with activity diagrams but focus on different aspects:

**State Machine Focus:**

- Object states and transitions
- Condition-based changes
- Data lifecycle management

**Activity Diagram Focus:**

- Process workflows
- User activities
- Sequential actions

The choice between diagrams depends on whether you're modeling object states or process workflows.

---

## 5.    Sequence Diagrams

### Message-Based System Design

Sequence diagrams represent sophisticated system interactions through message passing. Senior developers favor these diagrams because they model applications as systems of communicating components, both internal and external. They provide implementation-level detail that directly translates to code structure.

**Strategic Value:**

- **Implementation Guidance**: Direct translation to code
- **System Architecture**: Message-based system design
- **Integration Planning**: External system communication
- **Debugging Aid**: Understanding system message flow

### Implementation-Focused Elements

Sequence diagrams comprise four critical components:

1. **Class Roles/Participants**: System components involved in interactions
2. **Activation/Execution Occurrence**: Active processing periods (wide rectangles)
3. **Messages**: Communications between components (arrows)
4. **Lifelines**: Vertical lines representing component existence over time

### Phone Parser Example

The phone parser sequence diagram illustrates complex system interactions:

**Message Flow:**

1. **Input**: Data to parse enters the system
2. **Self-Message**: Parse engine processes internally ("delete all symbols except numbers")
3. **External Message**: Validation request to digit length validator
4. **Response Message**: Validation result (dotted arrow)
5. **Output**: Parsed phone number result

This diagram provides complete input-output understanding, showing both the goal and the implementation pathway.

### Input-Output System Thinking

Sequence diagrams promote systematic thinking about:

- **Method Inputs**: What data enters each component
- **Expected Outputs**: What results each component produces
- **Message Contracts**: Clear interface definitions
- **System Dependencies**: Component interaction requirements

Understanding systems through message passing creates clear implementation roadmaps and simplifies complex system architecture into manageable communication patterns.

---

## 6.    Best Practices and Implementation Guidelines

### Activity Diagram Guidelines

- Start with user entry points and identify all possible endpoints
- Use clear, descriptive labels for activities and decision points
- Keep diagrams focused on single processes or user journeys
- Include all significant decision points and alternative paths
- Validate workflows with business stakeholders

### Use Case Diagram Recommendations

- Clearly define system boundaries before identifying use cases
- Focus on user goals rather than system features
- Use consistent actor representations across diagrams
- Document relationships between related use cases
- Regularly review access rights and permissions with stakeholders

### State Machine Diagram Best Practices

- Identify all possible states before modeling transitions
- Define clear conditions for each state transition
- Include error states and exception handling
- Document state entry and exit actions
- Validate state logic with domain experts

### Sequence Diagram Guidelines

- Focus on significant message exchanges, avoid trivial interactions
- Use consistent naming conventions for participants
- Show both successful and error message flows
- Include return messages for complex interactions
- Align diagrams with actual implementation architecture

### General Behavioral Diagram Tips

- **Diagram Selection**: Choose diagrams based on specific modeling needs
- **Stakeholder Alignment**: Match diagram complexity to audience technical level
- **Iterative Refinement**: Continuously update diagrams as understanding evolves
- **Implementation Traceability**: Ensure diagrams can guide actual development
- **Cross-Diagram Consistency**: Maintain consistency across different diagram types

---

## 7.    Tools and Diagram Selection Criteria

### Diagram Selection Framework

Each behavioral diagram serves specific scenarios:

**Use Activity Diagrams When:**

- Modeling business processes
- Communicating with non-technical stakeholders
- Planning user experience workflows
- Documenting system processes

**Use Use Case Diagrams When:**

- Defining system scope and boundaries
- Designing authorization systems
- Planning system features
- Communicating with business analysts

**Use State Machine Diagrams When:**

- Modeling object lifecycles
- Designing state-dependent behavior
- Planning condition-based logic
- Understanding data transitions

**Use Sequence Diagrams When:**

- Designing system interactions
- Planning API integrations
- Understanding message flows
- Creating implementation blueprints

---

## References

- [Diagramas de Seq - IONOS](https://www.ionos.es/digitalguide/paginas-web/desarrollo-web/diagramas-de-secuencia/)
- [UML Activity Diagrams Tutorial](https://www.lucidchart.com/pages/uml-activity-diagram) - Comprehensive guide to activity diagram creation
- [What is Use Case Diagram?](https://www.visual-paradigm.com/guide/uml-unified-modeling-language/what-is-use-case-diagram/)
- [UML State Machine Diagrams - Overview of Graphical Notation](https://www.uml-diagrams.org/state-machine-diagrams.html)

---

## Video Lesson Speech

Remember I mentioned that UML is broken into two different types of diagrams.

---

## Behavioral Diagrams

- Structural
- Behavioral 

Behavioral diagrams illustrate how our system should behave, how it should act, how it should interact with the internal systems, how it interacts with outside actors/individuals/users that are going to be working with the system.

The diagrams we're going to walk through are the 

- Activity 
- Use Case 
- State machine
- Sequence. 

We're going to walk through a high-level overview of each of these later on in the course. 

## Activity Diagrams

This is the activity diagram and it is powerful. Activity diagrams are very easy for non-technical users to see and understand. 

When working with a non-technical executive, they may have no idea what UML is, what it stands for, or the components. An activity diagram allows them to look at a board and see what the system is supposed to do from start to finish. Activity diagrams have a nice syntax for both you as a developer along with people who maybe are not quite as technical. 

I leverage activity diagrams whenever I'm building a system from scratch. I want to put on a board exactly what is happening at each stage of a user's lifecycle or a systems type of workflow. The elements that are comprised inside of an activity diagram are

- Initial State or Starting Point
- Activity or Action State 
- Action Flow 
- Decisions or Branching 
- Guards 
- Final state or End Point 

For an example activity diagram, we have a coffee ordering service. 

- You can see that it starts with an order, someone is going online and ordering coffee. 
- It goes to a decision point based off on the user's decision.

![large](./06-162_IMG1.png)  

Hopefully, you can see how powerful an activity diagram can be, with one set of elements we've been able to create and render the entire experience that a user would have on a website. This is pretty complex behavior, however, if you handed this to me I would already have ideas on how to build this type of application. 

Activity diagrams are high-level because all we care about are activities. We're not getting into the attribute names, method or function names here. We want to see what the experience looks like for a user. 

We want to see what happens when the user

- searches for products
- finds a product
- they want to view the product
- What happens if they make a different decision
- They want to add it to the cart

This is a great way of showing all this inside of one diagram. 

## Use Case Diagram

The next diagram is the use case diagram, again they're a little bit more high level. They give you the ability to show everything that a user has access to. I like to use Use Case diagrams when I'm building out an application and I need to illustrate an authorization system. I want to show what users can do and what admin users can do.

 The elements that are used inside of this diagram are

- Use cases
- Actors 
- Subsystems
- Relationships. 

![large](./06-162_IMG2.png)

An example Use Case diagram here is for a marketing engine, you can see actors are displayed on both sides. We have a marketing specialist and we have a customer. Inside of the entire diagram we have use cases, you can see everything that both actors have access to. 

We also have connectors that are the actions that go in between each use case. For example, before the customer can get to the form use case, they have to fill something in that form. Whereas the marketing specialist can get to the form use case by generating it. There are different processes each of the actors have access to. 

Imagine a scenario where you have an admin user and they are managing a number of employees. An employee might submit a timesheet and that admin user is the one who approves it. Both of those actors go to a timesheet but they have a completely different set of behavior that they have access to. The employee can only submit where the admin can change it, prove it, deny it, or add comments. If you are building some type of authorization system in your application, this is a way of illustrating that. 

## State Machine Diagram

The state machine diagram is a very old concept in computer science. 

What is being visualized is what data looks like and actions at various stages of a software systems lifecycle. The elements are

- Entry point
- Choices
- Constraints
- States
- Transitions. 

The example below shows a state machine diagram. We have a lead funnel diagram, It starts with the user (entry point). Each rectangle represents different state. We have a user who's a visitor, based off of their decisions, if they submitted a form then they can change into a converted state. If they qualify for CRM conditions they get moved into a lead state and so on and so forth. 

![large](./06-162_IMG3.png)

The state machine diagram is a way of breaking down parts into small pieces and showing what users will have access to and show decisions that they have. 

You may notice this looks very similar to an activity diagram, that's a good observation. You'll notice the longer you go into UML is there is not one diagram that's perfect for every situation and diagrams have a lot of overlap. 

What diagrams you pick to use are going to be determined by the situation. You'll see that each has a scenario where one diagram is a little bit better than another diagram.

## Sequence Diagram

Sequence diagrams are a common diagram that many senior-level developers like to use. The reason is, the more advanced as a developer you get, the more you start to think of your application as a system that sends messages either internally or externally. Being able to visualize what those messages look like is incredibly important.

Sequence diagrams are some of the more complex diagrams. This is one of the most important diagrams that you'll learn, they speak directly to the implementation. They speak to how the code needs to operate. If done well, it will make the implementation of the project much easier to build. 

The elements that comprise a sequence diagram

- Class Roles or Participants
- Activation or Execution Occurrence
- Messages
- Lifelines. 

Looking at an example, we are coming back to our phone parser code library. What we have here is all of those different elements I just spoke about.

![large](./06-162_IMG4.png)

If you start at the beginning, from data to parse, each one of those lines with an arrow that is a message. Messages can be sent to a module itself, the first one where it says "delete all symbols except numbers" is a message from the parse engine to itself. From there it goes down that lifeline, it goes down the activation point (the wide rectangle) then it goes to the next one. It sends a message to the digit length validator to validate the number length. The response is the dotted arrow, this is the message that is sent back. 

If you think of a program at a very low level, all that matters is setting up the inputs and outputs. What is this method or class, what can be piped into it and what is the expected output? If your systems can think in those terms, what messages are being sent and what messages are being accepted, it is going to give  clear understanding of the behavior of the system.

This example goes from starting with the data parsing to the end where the response is an expectation to have a parsed phone number. 

If you showed me this diagram, and I didn't write this code, I'd be able to see the two most important parts of the system. I could see that I'm passing in data to parse and I'm expecting to get back a parsed phone number. I know the goal of the library, I could add comments if it helps clarify they expected inputs and outputs.
