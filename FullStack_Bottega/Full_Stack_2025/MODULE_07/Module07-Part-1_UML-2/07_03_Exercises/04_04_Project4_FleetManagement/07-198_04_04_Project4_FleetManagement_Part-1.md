# Project 4: Enterprise Fleet Management System, PART 1

## GOAL

Design a comprehensive fleet management system for tracking vehicles, maintenance, parts, and personnel. This project simulates real-world scenarios where requirements are vague and you must develop your own mental model for system design.

Unlike previous projects with clear specifications, this mirrors actual client interactions: "We want to track vehicles, service records, maintenance logs, parts orders..." Your job is to transform vague requirements into a complete, well-architected system.

The project requires **four diagrams**, progressing from high-level behaviour through to detailed implementation.

---

## REQUIREMENTS

### A. Activity Diagram (Behavioural)

**Purpose:** Model the complete maintenance process, which has numerous activities requiring visualisation.

**Process Focus:** Maintenance workflow (8-12 activities)

**Start Point:** Maintenance Inquiry **End Point:** Maintenance Complete

**Example Activities:**

- Technical diagnosis
- Assign service member
- Order parts
- Check parts availability
- Book technical specialist

**Critical Requirements:**

- Include decision points
- Add guards (conditions)
- Show dynamic behaviour
- Model what happens when things don't go right

**Context:** The fleet manager hasn't provided a detailed requirements list—just "track vehicles, service records, maintenance logs, parts orders." You must extrapolate the complete workflow.

---

### B. Package Diagram (Structural)

**Purpose:** Model high-level modules and their dependencies before defining any classes.

**Required Modules:**

1. Personnel
2. Vehicles
3. Parts
4. Maintenance
5. Partners

**Must Include:**

- Operations for each module
- Dependencies between modules
- Clear indication of access points

**Design Consideration:** Some modules (like Parts) will translate directly to database classes. Others (like Maintenance) will be mini-applications with their own workflows, classes, and helper methods.

---
