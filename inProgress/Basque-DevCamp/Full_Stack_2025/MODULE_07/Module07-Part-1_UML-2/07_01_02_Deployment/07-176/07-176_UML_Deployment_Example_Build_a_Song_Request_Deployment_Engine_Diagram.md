# MODULE 07-176:    UML

## Deployment Diagram Example Build a Song Request Deployment Engine Diagram

---

1. A Real-World Example: Music Request Service
   
   1. System Architecture Overview
   
   2. Frontend Node Analysis
   
   3. Authentication System Node
   
   4. Backend API Node
   
   5. Dependency Analysis

2. Understanding Dependencies in Software Systems
   
   1. Unidirectional vs Bidirectional Dependencies
   
   2. System Independence Principles
   
   3. Common Patterns in Modern Applications

   

3. Best Practices -Tips

4. Practical Applications

---



## ***1.    A Real-World Example: Song Request Service***

---

Let's analyze a practical music request service that allows users to log in and build playlists. This system demonstrates typical modern web application architecture.

### System Architecture Overview

The system consists of three main nodes:

1. **Web Service Node** (Frontend)
2. **Authentication System Node**
3. **Rails API Node** (Backend)

Each node runs on Linux operating systems and serves specific purposes in the overall application architecture.

### Frontend Node Analysis

**Node Configuration:**

- **Artifact**: Web Service Device
- **Operating System**: Linux
- **Component**: Angular Application

**Dependencies:**

- Rails API (for data management and business logic)
- Authentication System (for user login and session management)

The Angular frontend cannot function without these dependencies because:

- Without the API, it would have no data to display
- Without authentication, users couldn't access protected features

### Authentication System Node

**Node Configuration:**

- **Artifact**: Authentication Service
- **Operating System**: Linux
- **Protocol**: JWT (JSON Web Tokens)

**Dependencies**: None

This system is intentionally independent because:

- It only receives requests and provides responses
- Frontend technology can be swapped (Angular to React) without affecting authentication
- Its sole purpose is validating credentials and managing sessions

### Backend API Node

**Node Configuration:**

- **Artifact**: Rails API Service
- **Operating System**: Linux
- **Protocols**: JSON, RESTful API

**Dependencies:**

- Authentication System (for request validation)

The API depends on authentication because it must verify that incoming requests are from authenticated users before processing them.

## Understanding Dependencies in Software Systems

### Unidirectional vs Bidirectional Dependencies

Most well-designed systems have **unidirectional dependencies** that flow in one direction:

- Frontend depends on Backend
- Backend depends on Authentication
- Authentication depends on nothing (in this example)

This creates a clear hierarchy and prevents circular dependencies that can complicate system maintenance and updates.

### System Independence Principles

**Authentication System Independence:**
The authentication system demonstrates perfect independence:

- It doesn't care about the frontend technology
- It doesn't need to know about business logic
- It serves a single, well-defined purpose

**API System Partial Independence:**
The Rails API is independent of the frontend but depends on authentication:

- Frontend technology can change without API modifications
- Authentication dependency is necessary for security validation

### Common Patterns in Modern Applications

The example demonstrates a typical **three-tier architecture**:

1. **Presentation Layer**: Angular frontend
2. **Business Logic Layer**: Rails API
3. **Security Layer**: Authentication system

This pattern is prevalent because it:

- Separates concerns effectively
- Allows independent scaling of components
- Enables technology stack flexibility
- Simplifies maintenance and updates

## Best Practices and Tips

### Design Principles

- **Minimize Dependencies**: Each system should depend on as few others as possible
- **Clear Separation**: Each node should have a well-defined, single responsibility
- **Protocol Documentation**: Always specify communication protocols between nodes
- **Environment Details**: Include OS and runtime information for deployment clarity

### Documentation Standards

- Use consistent notation for similar components
- Include protocol specifications (JWT, REST, JSON)
- Add notes for complex communication patterns
- Specify deployment requirements for each node

### Dependency Management

- Avoid circular dependencies at all costs
- Design systems to be as independent as possible
- Document why each dependency exists
- Consider fallback mechanisms for critical dependencies

## Practical Applications

### Development Team Communication

Deployment diagrams serve as blueprints for development teams:

- Backend developers understand system boundaries
- Frontend developers know API endpoints and authentication requirements
- DevOps teams understand deployment and infrastructure needs

### System Planning and Architecture

Before implementation, deployment diagrams help:

- Identify potential bottlenecks
- Plan scalability requirements
- Understand security boundaries
- Estimate infrastructure costs

### Technology Decision Making

The visual representation helps evaluate:

- Technology stack compatibility
- Communication protocol efficiency
- Scalability requirements
- Maintenance complexity



---

## Video Lesson Speech

Now that you know all of the elements that comprise a UML deployment diagram. Let's take a look at a real life use case scenario. 

---

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/UML+images/Screen+Shot+2017-10-16+at+4.18.05+PM.png)

Here we have a music request service, this service is going to allow users to log in and then build playlists based on different songs that they want to pick out. This is a real-world application that I'm currently building now as we speak, I thought this would be a nice time to be able to see the deployment diagram that I built. This would be a challenging system to write by hand, with a simple type of diagram we can easily see how everything fits together. 

Let's start off with the very top left node, we have a regular web service, this is going to be the user interface for the entire system. We can see that it needs to be on some type of device, that's the artifact. I added some additional details so we have an operating system of Linux and then we have a component inside that's going to leverage angular. 

This has a few dependencies. It has a dependency on the API itself, which is going to be the backend that manages all of the data and the majority of the business logic, then it also has a dependency on the authentication system. 

So it's going to connect to two different systems

- One manages the process of logging in, checking if a user is registered and if they're allowed to be on the system
- One manages the backend and I placed a couple of other artifacts that are protocols (JSON and restful API)

If you were to show this to me, I could see that you had an angular front end communicating with a Rails API and an authentication system. I'd then have some clues on how to build the system. 

Talking about dependencies, this is a great example to analyze how dependencies work in software. We have Angular front end (we've covered its dependencies) but the authentication system technically has no set of dependencies. The reason for that is because of the way dependencies work in general. Dependency really means the system would not be able to function properly without whatever it's depending on.

The Angular front end needs dependencies, imagine if you went to it and it had no data, you couldn't log in. The authentication system, on the other hand, does not care about the angular front end, you could swap it out with a re-act front end and it would not care in the least. It simply takes in requests and gives responses, it does not depend on those other systems. 

A system between node is the rails API. Technically it doesn't care or depend on the front end either. It simply is an API that takes in requests and then gives responses. However, it does have a dependency on the authentication system, the reason is that sometimes the responses are coming in and it is going to communicate with that auth system to ensure that it was a valid request.

That is a very common pattern you'll see where you'll have a javascript front end with a rails back end, many times between the two there will be some type of authentication system. 

Each of these nodes is very similar in regards to its structure. It has a set of artifacts and components inside. You can use notes and comments to give more description for the developers, I noted that this is going to use JWT tokens for auth communication. 

If I hand this to a Rails developer, this will give them a set of instructions on what to build. 
