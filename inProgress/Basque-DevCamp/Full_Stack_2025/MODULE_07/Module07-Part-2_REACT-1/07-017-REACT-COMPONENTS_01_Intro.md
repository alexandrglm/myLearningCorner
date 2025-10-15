# 07-017: React Components 01 - Introduction to React Components

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-react-components

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/5f1a1ca2bf5d960c3495ef9236760b487e30c2ae)

---

## Fundamental Concepts

### What are React Components?

**Components** are the **basic building blocks** in React. They are reusable pieces of code that encapsulate:

- **Presentation logic** (how it looks)  
- **Behaviour** (how it works)  
- **Internal state** (changing data)  

### Components Paradigm vs Traditional HTML

**Traditional HTML method**:

- Multiple separate `.html` files  
- Code repetition (headers, footers, navigation)  
- Difficult maintenance

**React Components method**:

- Single HTML entry point  
- Reusable components (Header, Navigation, Footer)  
- Change once → applies across the whole app

---

## Types of Components

### 1. Functional Components

```js
const MyComponent = () => {
  return <div>Content</div>;
};
```


### 2. Class Components

```js
class MyComponent extends Component {
  render() {
    return <div>Content</div>;
  }
}
```

---


## Key Concepts

### JSX (JavaScript XML)

- Syntax mixing HTML with JavaScript  
- Compiled to plain JavaScript via Babel  
- Allows writing "HTML" inside JavaScript functions

### Component Hierarchy

- **Parent Component**: Contains other components  
- **Child Components**: Rendered inside parents  
- **Props**: Data passed from parent to child

---

## Project Directives

### What we must understand:

1. **Component mindset** - Everything is a reusable component  
2. **Single Page Application** - A single HTML page, dynamic content  
3. **Component hierarchy** - Parent-child structure

### Preparation:

- ✅ Project already set up with react-redux-router template  
- ✅ Base structure ready to create components  
- 🔄 **Next**: Create our first React components

---

*Foundation established to start component development in the React portfolio*

---

## Practice

### Steps

### 1. Create New Component

**File**: `src/components/portfolio-container.js`

```js
import React, { Component } from 'react';

export default class PortfolioContainer extends Component {

  render() {

    return (

      <div>
        <h2>Portfolio Items</h2>
      </div>
    );
  }
}
```


### 2. Modify App.js

**File**: `src/components/app.js`

- Import the new component: `import PortfolioContainer from './portfolio-container';`  
- Add inside render: `<PortfolioContainer />`

### 3. Verify Functionality

- Run `npm start`  
- Verify "Portfolio Items" appears on `localhost:3000`  
- Confirm auto-refresh on saving changes


---


### Expected Result:

- ✅ New functional component created  
- ✅ Component rendered in main app  
- ✅ Base portfolio structure established

---

