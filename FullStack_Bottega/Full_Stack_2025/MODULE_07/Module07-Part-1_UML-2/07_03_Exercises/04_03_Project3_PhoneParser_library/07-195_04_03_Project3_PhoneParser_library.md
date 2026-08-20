# Project 3: Phone Parser Library

## GOAL

Design a code library (Ruby gem) that validates and parses phone numbers. This project provides a blueprint for designing your own gems and code libraries in the future.

This is a **low-level system**—a library that other applications will use, not an application with a user interface. The focus is on clean module organisation and clear message-passing between internal components.

---

## REQUIREMENTS

### A. Package Diagram (Structural)

**Purpose:** Show how the code is organised at a very abstract, high-level view. This is about structure and dependencies, not implementation details.

**Required Modules:**

1. Phone parser (main module)
2. Country codes (validation module)

**Must Include:**

- Getters, setters, and methods for each module
- Dependencies between modules
- Clear indication of which module depends on which

**Key Principle:** Package diagrams are even more abstract than class diagrams. They give a sense of how code is organised and less about how to build it. Perfect for planning a system, building documentation, or showing how your system operates at a very abstract level.

---

### B. Sequence Diagram (Behavioural)

**Purpose:** Focus on the messages sent between systems—in this case, the messages sent internally within the code library itself.

**Required Participants:**

1. Parser (main entry point)
2. Digit length validator
3. Country code validator

**Flow Requirements:**

- **Start point:** Receives data (phone number string)
- **Endpoint:** Returns parsed phone number
- **Key messages:** Parsing and validations

**Must Show:**

- How data flows between participants
- What each participant is responsible for
- Request and response patterns
- Self-referential messages where appropriate

---

---
