# 07-024: React Components 08 - Deep Dive Part 1

## Introduction

This part focuses on a deep dive into React Components, covering advanced concepts and best practices. 
This deep dive covered key lifecycle methods, state management, event handling, and conditional rendering techniques in React.

---

## Component Lifecycle

Understand the different phases:

### MOUNTING - UPDATING - UNMOUNTING

- Mounting: Component is created and inserted into the DOM  
- Updating: Component is being re-rendered due to props or state changes  
- Unmounting: Component is removed from the DOM  

---

## Updating Lifecycle Methods

- componentDidUpdate(prevProps, prevState): Called immediately after updating occurs  
- getSnapshotBeforeUpdate(prevProps, prevState): Captures information before DOM changes  

---

## State and Props

- State is managed internally within components  
- Props are received from parent components, immutable within child  

---

## Conditional Rendering

Render different UI based on conditions:

```jsx
if (this.state.isLoggedIn) {  
  return <UserDashboard />  
} else {  
  return <Login />  
}
```

Or use ternary operator in JSX:

```jsx
{this.state.isLoggedIn ? <UserDashboard /> : <Login />}
```

---

## Handling Events

Events are handled via methods bound to component instance:

```jsx
<button onClick={this.handleClick}>Click me</button>
```

Always bind event handlers or use arrow functions to preserve `this` context.

---

## Forms in React

Use controlled components for form elements where React state holds the form data:

```jsx
<input type="text" value={this.state.inputValue} onChange={this.handleInputChange} />
```

This method enables instant state updates on user input.

---

## Practical Example: Toggle Visibility

```jsx
class ToggleVisibility extends React.Component {  
  
  constructor(props) {  
    super(props);  
    this.state = { isVisible: true };  
    this.toggle = this.toggle.bind(this);  
  }  
  
  toggle() {  
    this.setState(prevState => ({  
      isVisible: !prevState.isVisible  
    }));  
  }  
  
  render() {  
  
    return (  
    
      <div>  
        <button onClick={this.toggle}>Toggle</button>  
        {this.state.isVisible && <p>Now you see me!</p>}  
      </div>  
    );  
  }  
}
```
---

