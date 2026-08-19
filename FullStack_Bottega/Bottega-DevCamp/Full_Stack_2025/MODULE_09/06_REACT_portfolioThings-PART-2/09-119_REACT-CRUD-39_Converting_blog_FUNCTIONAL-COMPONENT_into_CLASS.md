# 09-119: Converting Functional Blog Component to Class Component

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/converting-functional-blog-component-class-component)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at b4f79f747f4d786ebc27d1df0014004574520153](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/b4f79f747f4d786ebc27d1df0014004574520153)

---

## 🎯 Objectives

**Convert functional Blog component to class component**:

- **Identify existing component** - locate blog.js in pages
- **Refactor syntax** - from function to class with extends Component
- **Add constructor** - prepare for future state management
- **Implement render method** - required in all class components
- **Update imports/exports** - include Component in imports
- **Prepare test data** - create blog posts in DevCamp Space for testing

**Reason for conversion**:

- Need state management for infinite scrolling
- Lifecycle methods for API calls
- Preparation for advanced functionality

---

## 🛠️ Implementation

### 1. Locate Existing Blog Component

**File**: `src/components/pages/blog.js`

**Initial state (Functional Component)**:

```javascript
import React from "react";
import { Link } from "react-router-dom";

const Blog = () => {
  return (
    <div>
      <h2>Blog</h2>
      <div>
        <Link to="/about-me">Read more about myself</Link>
      </div>
    </div>
  );
};

export default Blog;
```

### 2. Update React Import

**Add Component to React import**:

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
```

### 3. Convert Function to Class

**Replace function with class**:

```javascript
class Blog extends Component {
  constructor() {
    super();
  }

  render() {
    return (
      <div>
        <h2>Blog</h2>
        <div>
          <Link to="/about-me">Read more about myself</Link>
        </div>
      </div>
    );
  }
}
```

### 4. Update Export Statement

**Change export to use new class**:

```javascript
export default Blog;
```

### 5. Complete Final Code

**File**: `src/components/pages/blog.js`

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";

class Blog extends Component {
  constructor() {
    super();
  }

  render() {
    return (
      <div>
        <h2>Blog</h2>
        <div>
          <Link to="/about-me">Read more about myself</Link>
        </div>
      </div>
    );
  }
}

export default Blog;
```

---

## 📚 Concepts

### Differences between Default and Named Imports

**Default import**:

```javascript
import React from "react";
```

- **When to use**: When module has a default export
- **Syntax**: Without braces `{}`
- **Example**: React is the default export of react package

**Named imports**:

```javascript
import { Component } from "react";
```

- **When to use**: When importing specific elements from module
- **Syntax**: With braces `{}`
- **Example**: Component is a named export from react package

**Combined import**:

```javascript
import React, { Component } from "react";
```

- **First element**: Default import (React)
- **Elements in braces**: Named imports (Component)
- **Advantage**: Single line for multiple imports from same package

### Anatomy of a Class Component

**Required elements**:

```javascript
// 1. Import of Component
import React, { Component } from "react";

// 2. Class declaration that extends Component
class Blog extends Component {

  // 3. Constructor (optional but recommended)
  constructor() {
    super(); // Call to parent constructor
  }

  // 4. Render method (REQUIRED)
  render() {
    return (
      // JSX to render
    );
  }
}

// 5. Export of component
export default Blog;
```

### Why Convert to Class Component

**Functional components are limited for**:

- **State management** - cannot use this.state (without hooks)
- **Lifecycle methods** - componentDidMount, componentDidUpdate, etc.
- **Complex logic** - more advanced React patterns

**Class components provide**:

- **State management** - this.state and this.setState()
- **Lifecycle methods** - complete control of lifecycle
- **Context** - access to this for component reference
- **Error boundaries** - only available in class components

### Constructor and Super()

**Why we need constructor**:

```javascript
constructor() {
  super(); // REQUIRED - calls parent constructor (Component)
}
```

**Function of super()**:

- **Correct inheritance** - initialises parent class (Component)
- **Access to this** - without super(), this is unavailable
- **Preparation** - establishes context for class methods

### Render Method is Mandatory

**Why render() is required**:

- **Interface requirement** - Component class requires it
- **Return JSX** - must return what to render
- **Called by React** - React automatically calls when needs re-render

**Structure of render method**:

```javascript
render() {
  // Preparation logic (optional)
  const { props } = this.props;

  // MUST return JSX
  return (
    <div>
      {/* JSX content */}
    </div>
  );
}
```

---

## ✋ Verification

### Testing the Conversion

**Verify it works correctly**:

1. **Save file** - should be no compilation errors
2. **Navigate to /blog** - page should load without errors
3. **Verify content** - same H2 and Link visible
4. **Clean console** - should be no warnings or errors

### React DevTools Verification

**Inspect in DevTools**:

1. **Open React DevTools**
2. **Navigate to Blog page**
3. **Select Blog component** in component tree
4. **Verify component type** - should appear as class component
5. **Check props/state** - should show class structure

### Visual Comparison

**Before and after should be identical**:

- **Same H2 title** - "Blog"
- **Same link** - "Read more about myself"  
- **Same routing** - link navigates correctly
- **Same styling** - visual appearance identical

---

## 📊 Test Data Preparation

### DevCamp Space Blog Setup

**Navigate to DevCamp Space**:

1. **Login** to DevCamp Space
2. **Go to Portfolio** → **Blogs**
3. **Click "View Data"**
4. **Add test blog posts**

### Blog Post Structure

**Required fields**:

```
Title: [Any descriptive title]
Content: [Test content - paragraphs]
Status: Published (important so it appears)
Featured Image: [Optional - test image]
```

### Data Recommendations

**For infinite scrolling testing**:

- **Minimum 10-15 posts** - to effectively test infinite scroll
- **Varied titles** - "Blog Post 1", "Sample Article", etc.
- **Diverse content** - paragraphs of different lengths
- **Status "Published"** - Draft posts won't appear
- **Different dates** - for ordering testing

**Example test post**:

```
Title: "First Blog Post"
Content: "This is sample content for testing our React blog component. We need enough content to test the infinite scrolling functionality that we will implement in upcoming guides."
Status: Published
Featured Image: [any test image]
```

---
