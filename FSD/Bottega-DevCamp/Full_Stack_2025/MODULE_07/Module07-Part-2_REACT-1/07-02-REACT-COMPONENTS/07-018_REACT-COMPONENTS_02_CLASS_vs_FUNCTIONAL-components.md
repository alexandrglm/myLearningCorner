# 07-018: React Components 02 - Class vs Functional Components

## Overview

React provides two main types of components: **Class Components** and **Functional Components**. Both are used to build UI pieces, but there are some differences in syntax, capabilities, and usage.

---

## Class Components

- Are ES6 classes extending `React.Component`
- Have lifecycle methods like `componentDidMount`, `componentDidUpdate`
- Hold and manage state internally via `this.state`
- Use `this.props` to access props
- Require a `render()` method that returns JSX
- Tend to be more verbose

Example:

```js
import React, { Component } from 'react';

class Greeting extends Component {

  constructor(props) {

    super(props);
      this.state = { name: 'World' };
    }

    componentDidMount() {
      console.log('Component mounted'); 
    }

    render() {
      return <h1>Hello, {this.state.name}!</h1>;
    }
}

export default Greeting;
```


---

## Functional Components (Updated to React 18, Hooks/lifecycles)

- Are JavaScript functions that return JSX
- Before React 16.8, were stateless; with hooks, they can have state and lifecycle-like features
- Use `useState`, `useEffect` and other hooks for managing state and side-effects
- Simpler and more concise syntax
- Encouraged for new codebases

Example:

```js
import React, { useState, useEffect } from 'react';

function Greeting() {
  
  const [name, setName] = useState('World');

  useEffect(() => {
    console.log('Component mounted');
  }, []);

  return <h1>Hello, {name}!</h1>;
}

export default Greeting;

```

---


---

## Key Differences

| Feature               | Class Components                | Functional Components           |
|-----------------------|--------------------------------|-------------------------------|
| Syntax                | ES6 class                      | JavaScript function            |
| State management      | `this.state`                   | Hooks (`useState`)             |
| Lifecycle methods     | Present (`componentDidMount`)  | Hooks (`useEffect`)            |
| `this` keyword        | Required                      | No                            |
| Boilerplate code      | More verbose                  | More concise                  |
| React version support | Supported since early React   | Hooks available since React 16.8 |

---

## When to Use What?

- New projects should favour **functional components** due to simplicity and hooks
- Existing codebases with class components don't need immediate refactoring
- Use class components only if required by legacy code or certain third-party libraries


Functional components with hooks offer a powerful and cleaner way to write React apps, improving readability and maintainability compared to class components.

Try creatibng both component types, compare their behaviours, state management, and lifecycle handling to understand their paradigms and usage.

