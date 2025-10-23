# 07-023: React Components 07 - State

## Introduction

State is a crucial concept in React that allows components to manage their internal data and respond to user events or other changes.

State enables React components to remember information and respond to user interaction dynamically, which is essential for creating rich interactive web apps.

---

## What is State?

- State is a JavaScript object managed within a component  
- Holds dynamic data that affects the component’s rendering  
- Changes to state trigger re-render of the component  

---

## Initializing State

In a class component, state is usually initialized in the constructor:

```jsx
class MyComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0,
      name: "Visitor"
    };
  }
  // ...
}
```

---

## Updating State

You update state using the `setState()` method:

```jsx
this.setState({ count: this.state.count + 1 });
```

This merges the new state with the existing state and triggers a re-render.

---

## State is A S Y N C H R O N O U S !!!

- Updates to state may be batched and are asynchronous  
- Use functional form when new state depends on previous state:

```jsx
this.setState((prevState) => ({
  count: prevState.count + 1
}));
```

---

## Using State in Functional Components (Hooks)

Using the `useState` hook:

```jsx
import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
}
```
---

## Best Practices for State

- Keep state minimal and focused  
- Avoid manipulating state directly, always use `setState`  
- Lift state up to a common ancestor if shared between components  
- Use functional components and hooks where possible  

---

## Example: Toggle Button with state

```jsx
class Toggle extends React.Component {
  constructor(props) {
    super(props);
    this.state = { isToggleOn: true };
    this.handleClick = this.handleClick.bind(this);
  }
  
  handleClick() {
    this.setState(prevState => ({
      isToggleOn: !prevState.isToggleOn
    }));
  }
  
  render() {
    return (
      <button onClick={this.handleClick}>
        {this.state.isToggleOn ? 'ON' : 'OFF'}
      </button>
    );
  }
}
```

---

