# 07-019: React Components 03 - Understanding the Constructor

## Introduction

The constructor is a special function in React class components that initializes the component's state and binds event handlers.

---

## Purpose of Constructor

- Initialize local state  
- Bind methods to `this` context if necessary  
- Execute setup code during component creation

---

## Syntax

A constructor method in a React class component looks like this:

```js
class MyComponent extends React.Component {
  constructor(props) {
    super(props); // Must be called before using this in constructor
    this.state = { count: 0 };
    this.handleClick = this.handleClick.bind(this);
  }
  
  handleClick() {
    this.setState({ count: this.state.count + 1 });
  }

  render() {
    return (
      <div>
        <p>Count: {this.state.count}</p>
        <button onClick={this.handleClick}>Increment</button>
      </div>
    );
  }
}

export default MyComponent;
```
---

## Important Notes

- Always call `super(props)` before using `this` in the constructor  
- Bind event handler methods to `this` in the constructor if needed  
- State can be initialized directly in the constructor or using class fields syntax

---

## Modern Alternative

With modern React, functional components and hooks (like `useState` and `useEffect`) are preferred, eliminating the need for constructors in many cases.

---

