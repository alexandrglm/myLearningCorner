# 04-005 Activity: Architectural Patterns


### Peer-to-Peer (P2P)

**Peer-to-Peer** architecture distributes application logic equally across all participating nodes, eliminating the need for a central server. Each participant acts as both client and server, capable of initiating requests and responding to them. Data and processing responsibilities are shared across the network.

**Characteristics:** Decentralised control, scalability through distribution, reduced dependency on centralised infrastructure.

**Use cases:** File sharing systems, distributed databases, blockchain applications, collaborative tools.

**Advantages:** High availability, fault tolerance, scalability.  

**Disadvantages:** Complexity in synchronisation, security challenges, difficulty in data consistency.

---

### Microservices

**Microservices** architecture decomposes an application into small, independently deployable services, each responsible for a specific business capability. Services communicate via well-defined APIs, typically over HTTP or message brokers, and can be developed, deployed, and scaled independently.

**Characteristics:** Loose coupling, independent scalability, technology diversity per service, domain-driven design.

**Use cases:** Large-scale applications, systems requiring independent feature deployment, organisations with multiple development teams.

**Advantages:** Flexibility, independent scaling, easier maintenance and updates.  

**Disadvantages:** Increased complexity, network latency, distributed data management challenges.

---

### Event-Driven

**Event-Driven** architecture structures the application around the production and consumption of events. Components communicate asynchronously by publishing events when state changes occur, and other components subscribe to react to those events. This decouples producers from consumers.

**Characteristics:** Asynchronous communication, loose coupling, event brokers or channels, reactive components.

**Use cases:** Real-time systems, monitoring and alerting systems, user interaction tracking, stream processing.

**Advantages:** Responsiveness, scalability, decoupling of components.  
**Disadvantages:** Complexity in event flow tracking, eventual consistency, difficulty in error handling.

---

### Two-Tier / Client-Server

**Two-Tier** architecture, also known as client-server, separates the application into two layers: the presentation layer (client) running on user machines and the business logic layer (server) running on a centralised server. The client handles user interface and the server manages data and processing.

**Characteristics:** Centralised server, thin or thick clients, direct communication between client and server.

**Use cases:** Small to medium-sized applications, internal business applications, desktop software with backend services.  

**Advantages:** Simple to develop and maintain, centralised control.  
**Disadvantages:** Limited scalability, single point of failure, network dependency.

---

### Three-Tier / Presentation-Logic-Data

**Three-Tier** architecture extends the two-tier model by introducing an additional layer: presentation, business logic, and data layers. The presentation tier handles user interface, the business logic tier processes requests and enforces rules, and the data tier manages persistent storage and database operations.

**Characteristics:** Layered separation of concerns, independent layer scaling, clear responsibilities per tier.

**Use cases:** Enterprise applications, web applications, systems requiring scalability and maintainability.

**Advantages:** Scalability, maintainability, clear separation of concerns, easier testing.  

**Disadvantages:** Increased complexity, potential performance overhead, more infrastructure required.

---

### MVC - Model-View-Controller

**Model-View-Controller (MVC)** separates an application into three interconnected components: the **Model** (data and business logic), the **View** (user interface and presentation), and the **Controller** (handles user input and orchestrates Model and View).  

This separation enables parallel development and makes testing easier.

**Characteristics:** Separation of concerns, reusable models, multiple view representations, request-response flow.

**Use cases:** Web applications, desktop applications, frameworks like Django, Rails, Spring MVC.

**Advantages:** Modularity, testability, reusability of components.  

**Disadvantages:** Learning curve, potential complexity for simple applications, tight coupling between View and Controller.

---

### Blackboard

**Blackboard** architecture (also called the blackboard model) consists of three main components: the **Blackboard** (shared knowledge repository), **Knowledge Sources** (independent specialists), and the **Control Component** (coordinates knowledge sources).  

Knowledge sources examine and modify the blackboard, incrementally solving problems towards a solution.

**Characteristics:** Shared state management, independent knowledge sources, iterative problem-solving, opportunistic reasoning.

**Use cases:** Artificial intelligence systems, speech recognition, diagnosis systems, complex problem-solving applications.

**Advantages:** Flexible problem-solving approach, independent knowledge source development.   

**Disadvantages:** Difficult to understand control flow, synchronisation complexity, debugging challenges.

---

### Message-Broker

**Message-Broker** architecture routes messages between distributed components through a central intermediary (message broker).   

Components send messages to the broker, which manages routing, transformation, and delivery to appropriate recipients.  
Producers and consumers remain decoupled through asynchronous messaging.

**Characteristics:** Centralised message routing, asynchronous communication, message queuing, decoupled services.

**Use cases:** Enterprise integration, event notification systems, workflow automation, microservices communication.

**Advantages:** Decoupling of services, asynchronous processing, scalability.  

**Disadvantages:** Single point of failure (broker), potential message ordering issues, complexity in broker management.

---

### Pipe-Filter

**Pipe-Filter** architecture organises data processing as a series of filters connected by pipes.   

Each filter performs a specific transformation on input data and passes the result to the next filter through a pipe.   

Data flows through the chain of filters sequentially.

**Characteristics:** Sequential data processing, modular filters, stream-oriented, pluggable components.

**Use cases:** Data transformation pipelines, image processing, log analysis, ETL (Extract, Transform, Load) systems.

**Advantages:** Modularity, reusability, clear data flow, easy to understand.  

**Disadvantages:** Limited parallelisation opportunities, performance overhead from data passing, latency in long pipelines.

---

### Controller-Responder

**Controller-Responder** architecture separates request handling into two distinct roles: the **Controller** receives and interprets incoming requests, determining the appropriate action, whilst the **Responder** executes the action and generates the response.  

This separation allows controllers to remain stateless and allows responders to focus on processing logic.

**Characteristics:** Request-response separation, stateless controllers, dedicated processing components, asynchronous request handling.

**Use cases:** Web services, API gateways, request-driven systems, RESTful applications.

**Advantages:** Scalability through stateless controllers, clear responsibility division, easier load balancing.   

**Disadvantages:** Potential latency in request-response cycles, complexity in coordinating controllers and responders.
