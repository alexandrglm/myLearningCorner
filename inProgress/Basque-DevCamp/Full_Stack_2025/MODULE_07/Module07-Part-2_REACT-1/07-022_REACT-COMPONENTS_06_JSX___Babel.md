# 07-022: React Components 06 - JSX and Babel

## Introduction

JSX (JavaScript XML) is a syntax extension for JavaScript that looks similar to HTML or XML. It is used extensively in React to describe UI structure in a declarative way.

---

## What is JSX?

- JSX is not a template language, nor HTML  
- It produces React elements that are interpreted by React to render UI  
- Under the hood, JSX is compiled by Babel to `React.createElement()` calls

---

## Using JSX

Example of JSX:

```jsx
const element = <h1>Hello, world!</h1>;
```

Babel compiles this to:

```js
const element = React.createElement(
  'h1',
  null,
  'Hello, world!'
);
```
---

## Why Use JSX?

- More readable UI code mixing logic and layout  
- Easier to write dynamic content in React  
- Encourages a component-based architecture

---

## JSX Syntax Rules

- Return a single root element (use div or fragments `<> </>`)  
- Use `className` instead of `class`  
- Use camelCase for event handlers and attributes (`onClick`, `tabIndex`)  
- Curly braces `{}` allow JavaScript expressions inside JSX

---

## Babel and JSX

- Babel is a JavaScript compiler used to transform JSX into valid JavaScript  
- Babel plugin `@babel/preset-react` handles JSX transformation  
- Babel also converts modern JavaScript syntax (ES6+) to backwards compatible JavaScript

---

## Using JSX in React Components

Example functional component with JSX:

```jsx
function Welcome(props) {
  return <h1>Hello, {props.name}</h1>;
}
```

Example class component with JSX in render:

```jsx
class Welcome extends React.Component {
  render() {
    return <h1>Hello, {this.props.name}</h1>;
  }
}
```

---

## JSX Expressions

- You can embed any JavaScript expression inside curly braces in JSX  
- Example: `{2 + 2}`, `{user.name}`, `{formatDate(date)}`

---

## JSX Prevents Injection Attacks

- JSX escapes values to protect against XSS attacks  
- You should trust React's escaping mechanism unless you deliberately use `dangerouslySetInnerHTML`

---

