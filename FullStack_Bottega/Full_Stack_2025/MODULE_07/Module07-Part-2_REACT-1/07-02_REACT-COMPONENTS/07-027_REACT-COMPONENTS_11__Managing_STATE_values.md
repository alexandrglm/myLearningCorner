# 07-027: React Components 11 - Changing State Values

## Introduction

Managing and changing state appropriately is essential for creating interactive React applications that update in response to user input.  
Correct state management is vital for React apps to behave predictably and performantly. Use setState correctly, avoid direct mutations, and prefer functional updates when depending on previous state.


---

## Changing State in Class Components

State is updated with `this.setState()` method:

```jsx
this.setState({ key: newValue });
```

Key notes:

- React merges the state updates  
- State updates are asynchronous  
- Use functional form of setState if new state depends on previous state:
```jsx
this.setState(prevState => ({ count: prevState.count + 1 }));
```

---

## Avoid Direct State Mutation

Do NOT update state directly, e.g., do not do:

```jsx
this.state.count = 10;
```

This will not trigger re-rendering and cause bugs.

---

## State Updates with Objects vs Functions

Example with object:

```jsx
this.setState({ count: 10 });
```

Example with function for dependent state:

```jsx
this.setState((prevState, props) => ({
  count: prevState.count + 1
}));
```

---

## Changing State in Functional Components Using Hooks

Use the `useState` hook:

```
const [count, setCount] = useState(0);
```

Update with:

```jsx
setCount(count + 1);
```

---

## Batch Updates and Events

React batches multiple setState calls into one update for performance.

In synthetic event handlers, multiple `setState` calls can be combined.

---

## State Update Examples

Increment counter:

```jsx
incrementCount = () => {
  this.setState((prevState) => ({ count: prevState.count + 1 }));
};
```

---

## Handling Complex State

Use immutability helpers or spread operator to update nested objects or arrays.

Example:

```jsx
this.setState(prevState => ({
  items: [...prevState.items, newItem]
}));
```


---

