# 07-021: React Components 05 - Props

## Introduction to Props

Props (short for properties) are a mechanism for passing data from parent components to child components in React. They are read-only and allow components to be dynamic and reusable.

Props are a core concept in React for passing data from parents to children, making components dynamic and reusable without managing internal state.


---

## Why Use Props?

- Enable communication between components  
- Customize component appearance and behaviour externally  
- Promote component reusability by parameterizing them

---

## How to Use Props
---
### 1. Passing Props from Parent

In the parent component JSX:

```js
<ChildComponent title="My Title" description="Some description here" />
```
Here `title` and `description` are props passed to `ChildComponent`.

---

### 2. Receiving Props in Child

#### Functional Component:

```js
function ChildComponent(props) {
  return (
    <div>
      <h3>{props.title}</h3>
      <p>{props.description}</p>
    </div>
  );
}
```

Or using destructuring:

```js
function ChildComponent({ title, description }) {
  return (
    <div>
      <h3>{title}</h3>
      <p>{description}</p>
    </div>
  );
}
```

#### Class Component:

```js
class ChildComponent extends React.Component {

  render() {
    const { title, description } = this.props;
    return (
      <div>
        <h3>{title}</h3>
        <p>{description}</p>
      </div>
    );
  }
}
```

---

## Props Are I M M U T A B L E !!!!

Props should never be modified inside the child component. They are owned by the parent and passed down.

---

## Default Props and Prop Types

You can set default values and types for props:

```js
ChildComponent.defaultProps = {
  title: 'Default Title',
  description: 'Default description'
};

ChildComponent.propTypes = {
  title: PropTypes.string,
  description: PropTypes.string
};
```

Remember to import `PropTypes` from `prop-types` if used.

---

## Passing Functions as Props

Props can also be functions for callback or event handling.

Parent:
```jsx
<ChildComponent onClick={this.handleClick} />
```
Child:
```jsx
<button onClick={this.props.onClick}>Click Me</button>
```
---

## Training for a better understanding

- Create a parent component passing several props (strings, numbers) to a child component  
- Display the props in the child component  
- Pass a function as a prop and invoke it on a button click in the child  

---

