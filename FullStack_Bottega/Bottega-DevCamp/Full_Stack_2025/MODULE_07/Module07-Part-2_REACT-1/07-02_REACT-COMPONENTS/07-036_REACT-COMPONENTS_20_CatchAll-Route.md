# 07-036 - React Components 20: Implementing a Catch-All Route with React Router

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/implementing-catch-all-route-react-router](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/implementing-catch-all-route-react-router)

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/837bd2c4bc937813811b0de07cbbe3cc0cb6a201)

---

## CORE CONCEPTS

### The Problem: Non-Existent Routes

**Current situation**: With both basic and dynamic routing implemented, **what happens when a user visits an invalid route?**

**MVC vs SPA Difference**:

* **MVC frameworks** (Rails, Django, Spring) – show a server error
* **Single Page Applications** – may show a blank or confusing page
* **We need** clear user feedback for non-existent routes

### Real-World Example

**Twitter approach**: `/nonexistent-user` would return _"Sorry, that page doesn't exist!"_

* **No server error** – friendly page with a message
* **Return link** – helps the user navigate back
* **Professional UX** – prevents user confusion

### React Router Catch-All

**Concept**: A route that captures **any URL** that doesn’t match existing routes

* **Similar to a 404**, but more user-friendly
* **Placed last** in the Switch statement
* **Very flexible** – React Router allows a route without a path

---

## PRACTICAL STEPS – BASE EXERCISE CODE

### 1. Create the NoMatch Component

**File**: `src/components/pages/no-match.js`

```jsx
import React from "react";
import { Link } from "react-router-dom";

export default function() {
  return (
    <div>
      <h2>We couldn't find that page</h2>
      <Link to="/">Return to homepage</Link>
    </div>
  );
}
```

**Key elements**:

* **Clear message** – “We couldn't find that page”
* **Return link** – goes back to the homepage
* **No props needed** – simple component
* **Imports Link** – for SPA navigation

### 2. Add Import in App.js

**File**: `src/components/app.js`

```jsx
import NoMatch from "./pages/no-match";
```

### 3. Implement the Catch-All Route

**In the Switch**, add it **at the end**:

```jsx
<Switch>
  <Route exact path="/" component={Home} />
  <Route path="/about-me" component={About} />
  <Route path="/contact" component={Contact} />
  <Route path="/blog" component={Blog} />
  <Route path="/portfolio/:slug" component={PortfolioDetail} />

  {/* Catch-all route - ALWAYS AT THE END */}
  <Route component={NoMatch} />
</Switch>
```

**Unique characteristics**:

* **No `path` prop** – doesn’t specify a route
* **Placed at the end** – last option
* **Like an `else`** – catches everything else

### 4. Test the Catch-All Route

**Basic testing**:

1. **Valid URL** (`/about-me`) → works normally
2. **Invalid URL** (`/gibberish123`) → shows “We couldn't find that page”
3. **Link works** – “Return to homepage” leads to `/`

---

## KEY CONCEPTS EXPLAINED

### How the Switch Statement Works

**Order of evaluation**:

1. **Is it `/`?** No → continue
2. **Is it `/about-me`?** No → continue
3. **Is it `/contact`?** No → continue
4. **Is it `/blog`?** No → continue
5. **Is it `/portfolio/:slug`?** No → continue
6. **Route without path** → MATCH! Render NoMatch

### Why Place It Last?

**❌ If placed first**:

```jsx
<Switch>
  <Route component={NoMatch} /> {/* WRONG - catches everything */}
  <Route path="/about-me" component={About} />
  {/* These routes would NEVER execute */}
</Switch>
```

**✅ Correct placement**:

* **Other routes** get a chance to match first
* **Only catches** URLs that match nothing else
* **Acts like `else`** in conditionals

### Important Caveat: Dynamic Routes

**Potential issue**:

* **`/portfolio/quip`** → works (valid slug)
* **`/portfolio/gibberish`** → shows PortfolioDetail (not catch-all)
* **Reason**: matches `/portfolio/:slug` pattern

**Responsibility** for invalid slugs lies in the **PortfolioDetail component**, not the catch-all.

### Multiple Slashes and `exact`

**Without `exact` in dynamic route**:

```jsx
<Route path="/portfolio/:slug" component={PortfolioDetail} />
```

* **`/portfolio/quip/extra/stuff`** → matches PortfolioDetail

**With `exact`**:

```jsx
<Route exact path="/portfolio/:slug" component={PortfolioDetail} />
```

* **`/portfolio/quip/extra/stuff`** → goes to catch-all (NoMatch)

---

## CODE

### App.js (With Catch-All)

```jsx
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import NavigationContainer from './navigation/navigation-container';
import Home from "./pages/home";
import About from "./pages/about";
import Contact from "./pages/contact";
import Blog from "./pages/blog";
import PortfolioDetail from "./portfolio/portfolio-detail";
import NoMatch from "./pages/no-match";

export default class App extends Component {
  render() {
    return (
      <div className="app">
        <h1>Jordan Hudgens Portfolio Website</h1>

        <Router>
          <div>
            <NavigationContainer />

            <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/about-me" component={About} />
              <Route path="/contact" component={Contact} />
              <Route path="/blog" component={Blog} />
              <Route path="/portfolio/:slug" component={PortfolioDetail} />

              {/* Catch-all route */}
              <Route component={NoMatch} />
            </Switch>
          </div>
        </Router>
      </div>
    );
  }
}
```

### pages/no-match.js

```jsx
import React from "react";
import { Link } from "react-router-dom";

export default function() {
  return (
    <div>
      <h2>We couldn't find that page</h2>
      <Link to="/">Return to homepage</Link>
    </div>
  );
}
```

---

## TESTING AND VERIFICATION

### Invalid URL Testing

**URLs that should show NoMatch**:

1. **`/randomstuff`** → “We couldn't find that page”
2. **`/about-me-typo`** → “We couldn't find that page”
3. **`/portfolio/quip/extra`** → depends on whether `exact` is used

### Valid URL Testing

**URLs that should NOT show NoMatch**:

1. **`/`** → Homepage
2. **`/about-me`** → About page
3. **`/portfolio/quip`** → PortfolioDetail

### Navigation Testing

**From NoMatch**:

1. **Click “Return to homepage”** → should go to `/`
2. **No reload** – SPA behaviour
3. **Navigation works** – can browse normally again

---
