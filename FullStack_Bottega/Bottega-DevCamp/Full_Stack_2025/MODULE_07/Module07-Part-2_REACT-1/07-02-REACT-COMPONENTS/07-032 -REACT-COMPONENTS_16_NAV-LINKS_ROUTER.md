# 07-032 - React Components 16: Overview of React Router NavLinks

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/overview-react-router-navlinks](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/overview-react-router-navlinks)

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/54974161584719a8c3918efbf3225678157bfd60)

---

## CORE CONCEPTS

### Objective: Implement Functional Links

**Goal of this guide**:

* **Implement links** for user navigation
* **React-specific links** – different from vanilla HTML
* **Connect navigation** to the routing system
* **Explain why** React-specific links are necessary

### NavLinks vs Traditional HTML Links

**NavLinks** (React Router):

* **Specific component** from React Router DOM
* **Maintains state** of the SPA
* **No page reload** – instant navigation
* **Generates `<a>` tags** with additional JavaScript

**Traditional HTML Links** (`<a href>`):

* **Reload the full page** – breaks SPA
* **Performance issues** – resets the app
* **Loss of state** – React restarts
* **Only use** for external links

### Why React-Specific Links?

**Problem with normal `<a>` tags**:

* **Conflict with React** – breaks single-page behaviour
* **Reloads the entire app** on every click
* **Performance issues** and bugs
* **Redirects to routes** that may not exist

**Solution with NavLinks**:

* **Maintain SPA** functionality
* **JavaScript observes click events**
* **Dynamic navigation** without reloads
* **High performance** behaviour

---

## PRACTICAL STEPS – BASE EXERCISE CODE

### 1. Import NavLink in NavigationContainer

**File**: `src/components/navigation/navigation-container.js`

Add import:

```javascript
import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';

export default class NavigationComponent extends Component {
  constructor() {
    super();
  }

  render() {
    return (
      <div>
        {/* We'll replace buttons with NavLinks */}
      </div>
    );
  }
}
```

### 2. Replace Buttons with NavLinks

**Modify render()** to use NavLinks:

```javascript
render() {
  return (
    <div>
      <NavLink exact to="/">
        Home
      </NavLink>

      <NavLink to="/about-me">
        About
      </NavLink>

      <button>Contact</button>
      <button>Blog</button>

      {false ? <button>Add Blog</button> : null}
    </div>
  );
}
```

### 3. Explanation of NavLink Props

**Important props**:

* **`to`** – route to navigate to (similar to `href`)
* **`exact`** – exact match (required for `/`)
* **Content** – link text between tags

**Why `exact` on home**:

* **Same reason** as in Route definition
* **`/` is included** in `/about-me`
* **Without exact** – home would always appear active

### 4. NavLinks Testing

**Verify navigation**:

1. **Click “Home”** → goes to homepage
2. **Click “About”** → goes to about page
3. **No page reload** – SPA remains active

### 5. Demonstrate the Problem with HTML Links

**Temporarily add** an HTML link for comparison:

```javascript
render() {
  return (
    <div>
      <NavLink exact to="/">
        Home
      </NavLink>

      <NavLink to="/about-me">
        About
      </NavLink>

      {/* TEMPORARY - to demonstrate problem */}
      <a href="/">Wrong Home</a>

      <button>Contact</button>
      <button>Blog</button>

      {false ? <button>Add Blog</button> : null}
    </div>
  );
}
```

### 6. Testing the Difference

**Observe behaviour**:

1. **Click NavLinks** – favicon does not change (no reload)
2. **Click “Wrong Home”** – favicon flickers (page reloads)
3. **Notice** the difference in performance and behaviour

### 7. Inspect Generated HTML

**In DevTools**:

* **Right-click** a NavLink → Inspect
* **See the `<a>` tag** generated automatically
* **Notice** extra metadata and classes
* **JavaScript listens** to click events

---

## KEY CONCEPTS EXPLAINED

### How NavLink Works Internally

**Process**:

1. **NavLink renders** a normal `<a>` tag
2. **Additional JavaScript** observes click events
3. **Intercepts navigation** before page reload
4. **Updates the URL** without reloading
5. **React Router** renders the correct component

### When to Use `<a>` vs NavLink

**Use `<a>` tags when**:

* **External links** – other websites
* **Downloads** – files, PDFs
* **Email/phone** – mailto:, tel:

**Use NavLink when**:

* **Internal navigation** – within the app
* **React routes** – components/pages
* **Maintain state** – prevent data loss

### Automatic Metadata and Classes

**NavLink automatically adds**:

* **`class="active"`** – when link is active
* **Additional metadata** – for accessibility
* **Event handlers** – for SPA behaviour

---

## FULL FUNCTIONAL CODE

### navigation-container.js

```javascript
import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';

export default class NavigationComponent extends Component {
  constructor() {
    super();
  }

  render() {
    return (
      <div>
        <NavLink exact to="/">
          Home
        </NavLink>

        <NavLink to="/about-me">
          About
        </NavLink>

        <button>Contact</button>
        <button>Blog</button>

        {false ? <button>Add Blog</button> : null}
      </div>
    );
  }
}
```

---

## TESTING AND VERIFICATION

### Navigation Testing

**Verify SPA behaviour**:

1. **Navigation works** – links lead to correct pages
2. **No reloads** – favicon doesn’t flicker
3. **URL updates** – changes correctly
4. **State persists** – no data loss

### Performance Comparison

**NavLink vs `<a>` tag**:

* **NavLink**: Instant, no flicker
* **`<a>` tag**: Slow, full reload visible

### HTML Inspection

**In DevTools**:

* NavLink → generates `<a href="/about-me">About</a>`
* Automatic classes added
* JavaScript event listeners active

---
