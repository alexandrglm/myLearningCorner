# Project 4: Enterprise Fleet Management System, Part 2

## GOAL

Design a comprehensive fleet management system for tracking vehicles, maintenance, parts, and personnel. This project simulates real-world scenarios where requirements are vague and you must develop your own mental model for system design.

Unlike previous projects with clear specifications, this mirrors actual client interactions: "We want to track vehicles, service records, maintenance logs, parts orders..." Your job is to transform vague requirements into a complete, well-architected system.

The project requires **four diagrams**, progressing from high-level behaviour through to detailed implementation.

---

## REQUIREMENTS
---

### C. Deployment Diagram (Infrastructure)

**Purpose:** Design the overall system architecture for an enterprise application.

**Required Nodes:**

- Load balancer
- Application servers
- Database clusters
- Caching

**Research Required:** You'll need to investigate what these components do. When designing systems, you're constantly designing things you've never built before. Research is a huge component of the planning stage.

**Key Questions to Answer:**

- What does a load balancer do?
- How do application servers work together?
- Why separate caching from database?
- What's the purpose of database clusters?

---

### D. Class Diagram (Detailed Structure)

**Purpose:** Design the complete database structure with proper normalisation for enterprise efficiency.

**Required Classes:**

1. Vehicle
2. CarModel
3. CarBrand
4. ProductionFacility
5. Dealer
6. Technician
7. Role
8. Maintenance
9. MaintenanceType
10. ServiceCenter
11. Service
12. ServiceList
13. MaintenancePart
14. Part
15. Vendor
16. Assembly

**Key Focus:** Breaking tables into smaller, more efficient pieces. In enterprise applications, database efficiency is critical. Avoid classes containing information they don't need.

**Design Choice:** Decide whether to use inheritance or simply specify that some models are more generic whilst others are more specialised.

---


## KEY TAKEAWAYS

### Activity Diagram

**Model Failures:** Happy path is easy. Complexity is in error handling, loops, alternative flows.

**Branching Logic:** Each decision point requires validation code. Map out ALL possible paths.

**Universal Patterns:** This maintenance workflow template applies to countless business processes.

### Package Diagram

**Dependencies First:** The most critical aspect is showing what depends on what. This prevents breaking changes.

**First Draft is OK:** No one gets architecture perfect initially. Package diagrams are for brainstorming and organisation.

**Abstract ≠ Vague:** High-level doesn't mean unclear. It means focusing on structure over implementation.

### Deployment Diagram

**Redundancy Matters:** Load balancers and multiple servers prevent single points of failure.

**Cache Wisely:** Static assets: cache aggressively. Dynamic data: cache carefully or not at all.

**Separation of Concerns:** Cache cluster for performance. Database cluster for accuracy. Each has a specific role.

### Class Diagram

**Break Tables Apart:** Enterprise efficiency requires proper normalisation. More tables isn't bad—it's scalable.

**One-to-One is Valid:** Not everything is one-to-many. Simple relationships are powerful.

**Plan for Growth:** Separate now to avoid refactoring later. Assume your system will succeed and expand.

### The Project Workflow

**Order Matters:**

1. Activity Diagram → Understand behaviour
2. Package Diagram → Organise modules
3. Deployment Diagram → Design infrastructure
4. Class Diagram → Implement database

Each diagram informs the next. Behaviour → Structure → Infrastructure → Implementation.

### Real-World Application

This isn't just about fleet management. These patterns apply to:

- Asset management
- Equipment tracking
- Service businesses
- Maintenance companies
- Any system with inventory, personnel, and workflows

The fundamental skills are **transferable** across domains and technologies.
