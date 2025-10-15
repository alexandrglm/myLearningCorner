# 07-025: React Components 09 - Deep Dive Props, State, this - Part 2

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/deep-dive-props-state-this-part-2

**Source Code**: [Here](https://github.com/jordanhudgens/ReactPropStateThisDeepDive)

---

## Fundamental Concepts

### Functional vs Class Components - Deep Dive

| Aspect             | Class Components                | Functional Components         |
|--------------------|---------------------------------|-------------------------------|
| Syntax             | `class + extends + render()`    | `const + arrow function`      |
| State              | `this.state` + `this.setState()`| `useState` hook (React 16.8+) |
| `this` keyword     | Component instance context      | No `this`                     |
| Lifecycle          | Specific lifecycle methods      | `useEffect` hook              |
| Performance        | More overhead                   | More efficient                |

---

### The `this` Keyword in React

**In Class Components**:

- `this` refers to the **component instance**
- `this.state` is component state
- `this.props` are inherited props
- `this.setState()` updates state

**In Functional Components**:

- **No `this`** - no class instances
- Props arrive as **function parameters**
- State is managed with **hooks**

---
### Component Organization Best Practices

**Fundamental Rule**: One component = One file

- **Separation of concerns** - specific responsibilities
- **Reusability** - modular imports/exports
- **Maintenance** - easy to locate and modify
- **Team collaboration** - distributed ownership

---

## Practical Steps

### Base Exercise Code

#### 1. Create Inline Functional Component (Demo)

**File**: `src/components/journal-list.js` (temporary modification)

```jsx
import React, { Component } from 'react';

// Functional component INLINE (demonstration only)
const JournalEntry = (props) => {
  console.log("JournalEntry props:", props);

  return (
    <div>
      <h4>{props.title}</h4>
      <p>{props.content}</p>
    </div>
  );
};

export default class JournalList extends Component {
  constructor(props) {
    super(props);

    this.state = {
      journalData: [
        {
          title: "Journal Entry One",
          content: "Content for journal entry one"
        },
        {
          title: "Journal Entry Two", 
          content: "Content for journal entry two"
        }
      ]
    };
  }

  render() {
    return (
      <div>
        <h1>Journal Entries</h1>

        {this.state.journalData.map(entry => {
          return (
            <JournalEntry
              key={entry.title}
              title={entry.title}
              content={entry.content}
            />
          );
        })}
      </div>
    );
  }
}
```

#### 2. Verify Functional vs Class Behavior

- Inspect `console.log` to see received props
- Use React DevTools to compare structures
- Observe functional component receives props as parameters


#### 3. Demonstrate `this` Context

Add in JournalList class component:

```jsx
// Inside the constructor
console.log("this context:", this);
console.log("this.props:", this.props);
console.log("this.state:", this.state);

// Inside render()
console.log("this in render:", this);
```

#### 4. Separate in Individual File (Refactor)

Create file: `src/components/journal-entry.js`

```jsx
import React from 'react';

const JournalEntry = (props) => {
  return (
    <div className="journal-entry-wrapper">
      <h4>{props.title}</h4>
      <p>{props.content}</p>
    </div>
  );
};

export default JournalEntry;
```

Then, modify: `src/components/journal-list.js`

```jsx
import React, { Component } from 'react';
import JournalEntry from './journal-entry';

export default class JournalList extends Component {
  constructor(props) {
    super(props);

    this.state = {
      journalData: [
        {
          title: "Journal Entry One",
          content: "Content for journal entry one"
        },
        {
          title: "Journal Entry Two", 
          content: "Content for journal entry two"
        }
      ]
    };
  }

  render() {
    return (
      <div>
        <h1>Journal Entries</h1>

        {this.state.journalData.map(entry => {
          return (
            <JournalEntry
              key={entry.title}
              title={entry.title}
              content={entry.content}
            />
          );
        })}
      </div>
    );
  }
}
```

---

###  Additional Explorations (Outside Exercise)

#### A. Extended Exercise 1

Direct Syntax Comparison

Create: `src/components/comparison-demo.js`

```jsx
import React, { Component, useState } from 'react';

// Class component version
class CounterClass extends Component {
  constructor(props) {
    super(props);
    this.state = { count: 0 };
  }

  increment = () => {
    this.setState({ count: this.state.count + 1 });
  }

  render() {
    return (
      <div>
        <p>Class Count: {this.state.count}</p>
        <button onClick={this.increment}>+</button>
      </div>
    );
  }
}
```

```jsx
// Functional component version (requires hooks knowledge)
const CounterFunction = () => {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>Function Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>+</button>
    </div>
  );
};

export { CounterClass, CounterFunction };
```

---

## **Key Lessons of the Exercise**

### 1. **State Management - Core of React**

- Class: `this.state` + `this.setState()`  
- Function: `useState` hook  
- Learning: Both manage changing data but with different syntax  

### 2. **React Ecosystem Evolution**

- Before 2019: Only class components had state  
- Now: Functional components + hooks are standard  
- Learning: Legacy code vs modern code  

### 3. **Architectural Decisions**

#### // When to use Class  
- Existing legacy code  
- Complex lifecycle methods  
- Teams accustomed to OOP  

#### // When to use Function  
- New projects (recommended)  
- Cleaner, concise code  
- Better performance  


### 4. **Performance and Re-rendering**

- Each `setState()` or `setCount()` causes component re-render  
- Critical: Understand when and why React updates UI  
- Optimization: Avoid unnecessary re-renders  

### 5. **Debugging with DevTools**

- View state changes in real-time  
- Trace data flow  
- Essential professional skill  

## **Real-world Application**

In real projects:

- Forms: Input states  
- Shopping cart: Item quantities  
- Modals: Opening/closing  
- API calls: Loading states  

---

#### B. Extended Exercise 2

#### `this` Binding Exploration

```jsx
// In JournalList - experiment with binding  

handleEntryClick = (title) => {
  console.log("Clicked:", title);
  console.log("this in handler:", this);
}
```

```jsx
// In render, pass handler as prop  
<JournalEntry
  title={entry.title}
  content={entry.content}
  onClick={() => this.handleEntryClick(entry.title)}
/>
```
---

### 5. Testing in React DevTools

- Component tree - view JournalList → JournalEntry hierarchy  
- Props flow

---
