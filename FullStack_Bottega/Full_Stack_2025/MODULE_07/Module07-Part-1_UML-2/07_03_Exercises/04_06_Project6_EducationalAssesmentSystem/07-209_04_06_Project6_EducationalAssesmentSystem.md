# Project 6: Education Assessment System

## GOAL

Design an online quiz/exam system with multiple participants. Focus on polymorphic associations, state machines for UI validation, and CI/CD deployment pipelines.

This project emphasises starting with high-level diagrams before detailed implementation—a UML specification requirement that's also practical best practice.

---

## REQUIREMENTS

### A. Activity Diagram (Behavioural)

**Process:** Quiz taking workflow (6-10 activities)

**Roles (Swim Lanes):**

- Teacher
- System
- Student

**Key Activities:**

- Asking a question
- Generating a question set
- Approving results

**Critical:** Use swim lanes to clearly show which participant performs each activity.

---

### B. Class Diagram (Structural)

**Required Classes:**

- Student, Teacher, User
- Klass (not "Class"—reserved word in most languages)
- Grade, Result
- Quiz, Question, Essay, Multiple Choice
- Answer, Project, Practice

**Focus:** Implement polymorphic associations. Research how Ruby on Rails handles polymorphism—excellent documentation even if you're not using Rails.

**Key Challenge:** Two question types (Essay, Multiple Choice) both need to associate with Answer. Don't create two Answer classes—use polymorphic association.

---

### C. State Machine Diagram (Behavioural)

**Feature:** Question answering state management

**States:**

- Waiting for answer
- Answer chosen
- Answer confirmed
- Submit status

**Purpose:** Define that users must select an answer before submitting. Models a small feature but provides clear workflow understanding.

---

### D. Deployment Diagram (Infrastructure)

**Focus:** Continuous Integration (CI) deployment pipeline.

**Research Required:** Investigate Travis CI or Codeship.

**Nodes:**

- CI server
- Staging environment
- Pre-production environment
- Production environment

**Workflow:** Code doesn't go directly to production. It passes through CI server, which runs tests, migrations, and checks before deployment.

---

## A. ACTIVITY DIAGRAM

### Swim Lane Organisation

**Teacher Lane:**

- Assign test and quiz (initiates process)
- Approve results (final step)

**System Lane:**

- Generate individual question set
- Ask questions (loop)
- Generate results
- Store results

**Student Lane:**

- Confirm ready
- Answer questions (loop)

### Flow Details

```
Teacher: Assign test
  ↓
System: Generate question set
  ↓
Student: Confirm ready
  ↓
[Branch for organisation]
  ↓
LOOP:
  System: Ask question
  Student: Answer question
  REPEAT until last question
  ↓
System: Generate results
  ↓
Teacher: Approve results
  ↓
System: Store results
```

### Key Concepts

**Swim Lanes:** Essential for visualising roles. Makes it immediately clear who's responsible for what.

**Loop Mechanism:** Questions repeat until all answered. Visual frame with "loop" label indicates this.

**Common Pattern:** Admin initiates → System processes → User interacts → Loop → Admin approves. Applies to many workflow systems (expense approval, document review, etc.).

---

## B. CLASS DIAGRAM

### The Polymorphic Challenge

**The Problem:**

Two question types:

- Multiple Choice (has options)
- Essay (has text area)

Both need to associate with Answer. How?

**Wrong Approach:**

```
MultipleChoice ──→ MultipleChoiceAnswer
Essay ──→ EssayAnswer
```

Duplicates Answer logic. Not scalable.

**Correct Approach: Polymorphic Association**

```
         Question (parent)
            /    \
           /      \
  MultipleChoice  Essay
           \      /
            \    /
            Answer
```

Answer associates with Question polymorphically. Doesn't care if it's MultipleChoice or Essay—treats both identically.

### Implementation

**Answer class stores:**

- `id`
- `content`
- `question_id`
- `question_type` (polymorphic identifier)

Rails syntax: `belongs_to :question, polymorphic: true`

### Why This Matters

**Scalability:** Add TrueFalse, FillBlank, Matching questions later. Answer class doesn't change.

**Maintainability:** One Answer class, one set of logic, one place to debug.

**DRY Principle:** Don't repeat yourself. Polymorphism prevents code duplication.

### Other Associations

**User Hierarchy:**

```
     User
    /    \
   /      \
Student  Teacher
```

Standard inheritance. Student and Teacher are types of User.

**Composition (diamond):**

```
Klass ◆──── Grade
Klass ◆──── Project
```

Grade cannot exist without Klass. Whole-part relationship.

### Visibility Levels

- `+` Public: Accessible everywhere
- `-` Private: Only within class
- `#` Protected: Class + subclasses

Example: `#weight` in Tag class—protected, accessible by Tag and its children.

---

## C. STATE MACHINE DIAGRAM

### The Simple Flow

```
[START]
  ↓
Submit button DISABLED
(Waiting for answer)
  ↓
Checkbox SET
  ↓
Submit button ENABLED
(Answer chosen)
  ↓ ↑
  | |
  └─┘ Checkbox UNSET (bidirectional)
  ↓
Submit clicked
  ↓
Answer CONFIRMED
  ↓
[END]
```

### Critical Feature: Bidirectional Transitions

User can change their mind:

- Checkbox SET → Enabled
- Checkbox UNSET → Disabled (back to start)

**Never assume perfect flow.** Users undo, change answers, navigate back. Model these possibilities.

### Validation Logic

**Disabled State:**

- Button greyed out
- onClick does nothing
- User cannot proceed

**Enabled State:**

- At least one answer selected
- Button clickable
- Form can submit

### Real-World Application

Any form with required fields uses this pattern:

- Registration forms (all fields filled?)
- Payment forms (card details entered?)
- Survey forms (minimum questions answered?)

State machines model these validation requirements clearly.

---

## D. DEPLOYMENT DIAGRAM

### The CI/CD Pipeline

```
Developer pushes code
  ↓
CI Server (Codeship/Travis)
  - Run tests (RSpec, etc.)
  - Run migrations
  - Build application
  - Check dependencies
  ↓
Tests PASS?
  ├─ NO → Notify developer, STOP
  └─ YES → Deploy to Staging
           ↓
      Manual check/QA
           ↓
      Deploy to Pre-Production (optional)
           ↓
      Extended QA testing
           ↓
      Deploy to Production
```

### CI Server: First Line of Defence

**Purpose:** Catch errors BEFORE users see them.

**What It Does:**

- Automated testing
- Database migrations
- Dependency checks
- Code quality analysis

**Why It Matters:**

Example: You change a gem version. Breaks the app. Without CI, you'd push to production and users would see errors. With CI, tests fail, deployment stops, you fix it first.

### Environment Breakdown

**Staging:**

- First deployment target
- Manual verification
- Check that features work visually
- Catch issues CI missed

**Pre-Production (optional):**

- Mirror of production
- Dedicated QA team
- Exhaustive testing
- Large applications only

**Production:**

- Live users
- Real data
- Only deployed after all tests pass

### Deployment Speed Differences

**With CI/CD:**

- Developer pushes code
- Everything automated
- Minutes to staging
- Hours/days to production (after QA)

**Without CI/CD:**

- Manual deployment
- Manual testing
- High error risk
- Slow, error-prone process

### Why Separate Environments

**Cannot test in production.** Users shouldn't be guinea pigs. Multiple environments provide safety nets.

Each environment catches different types of issues:

- CI: Code errors, test failures
- Staging: Integration issues, UX problems
- Pre-prod: Performance issues, edge cases
- Production: Real-world load, actual user behaviour

---

## KEY TAKEAWAYS

### Activity Diagram

**Swim Lanes Essential:** Multiple participants require clear visual separation of responsibilities.

**Loop Frames:** Use frames to indicate repeated activities (questions in quiz).

**Common Pattern:** Admin → System → User → Loop → Admin approval. Universally applicable.

### Class Diagram

**Polymorphic Association:** One class relates to multiple types, treating them identically. Critical for scalability.

**Inheritance vs Composition:** User → Student/Teacher (inheritance). Klass → Grade (composition).

**Visibility Matters:** Public, private, protected have real implications in code.

### State Machine

**Bidirectional Transitions:** Users change their minds. Model backward paths, not just forward.

**Validation States:** Disabled/enabled button is simple but powerful UX pattern.

**Small Feature, Big Impact:** One button's behaviour requires careful state modelling.

### Deployment Diagram

**CI as Safety Net:** Automated testing prevents broken deployments.

**Multiple Environments:** Each catches different issue types. Redundancy is intentional.

**Never Direct to Production:** Always pass through CI and staging minimum.

### Universal Principles

**High-Level First:** UML specification requires starting with behaviour diagrams before implementation details. Also practical—understand system before building pieces.

**Polymorphism is Power:** Design patterns like polymorphic associations enable scalability and maintainability.

**Automation Reduces Errors:** CI/CD pipelines eliminate manual deployment mistakes.

**State Machines Clarify UX:** Complex interactions become clear when modelled as state transitions.
