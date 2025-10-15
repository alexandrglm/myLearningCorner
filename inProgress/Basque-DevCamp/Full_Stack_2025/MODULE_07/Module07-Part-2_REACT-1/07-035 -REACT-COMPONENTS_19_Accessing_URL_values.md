# 07-035 - React Components 19: How to Access URL Values in React

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-access-url-values-react](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-access-url-values-react)

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/9ea084234a25d7f9d44378aa1a393f626984843b)

---

## CORE CONCEPTS

### Why Access URL Data?

**Common use case**: Portfolio detail page

* **Click on a portfolio item** → go to a page with specific details
* **Shareable links** – send a specific URL: `portfolio/quip`
* **Not just props** – URLs allow sharing and bookmarking
* **Very common** in real-world apps

### Props vs URLs Limitations

**Props only**:

* **Not shareable** – cannot send a link to someone
* **Temporary state** – lost on refresh
* **Not bookmarkable** – doesn’t work with browser history

**With dynamic URLs**:

* **Specific URLs** – `portfolio/quip`, `portfolio/eventbrite`
* **Shareable** – send a link to show a specific project
* **Persistent** – works with refresh and bookmarks
* **Professional** – like real websites

### Dynamic Routing with React Router

**Special syntax**:

* **`:slug`** – dynamic parameter in the route
* **Conventions**: `slug` or `permalink` are most common
* **Access**: via `props.match.params.slug`
* **Flexibility**: React allows multiple structures

---

## PRACTICAL STEPS – BASE EXERCISE CODE

### 1. Add Dynamic Route in App.js

**File**: `src/components/app.js`

Add a new route with a dynamic parameter:

```javascript
import PortfolioDetail from "./portfolio/portfolio-detail";

// Inside Switch:
<Switch>
  <Route exact path="/" component={Home} />
  <Route path="/about-me" component={About} />
  <Route path="/contact" component={Contact} />
  <Route path="/blog" component={Blog} />
  <Route path="/portfolio/:slug" component={PortfolioDetail} />
</Switch>
```

**Explanation of `:slug`**:

* **Colon** indicates a dynamic parameter
* **`slug`** – name of the parameter (common convention)
* **Alternatives**: `:permalink`, `:id` also valid

### 2. Create PortfolioDetail Component

**Decide location**: `pages/` or `portfolio/`?

* **Guide chooses** `portfolio/` for better structure
* **React is flexible** – both are valid

**File**: `src/components/portfolio/portfolio-detail.js`

```javascript
import React from "react";

const PortfolioDetail = (props) => {
  return (
    <div>
      <h2>Portfolio Detail for {props.match.params.slug}</h2>
    </div>
  );
};

export default PortfolioDetail;
```

### 3. Test Dynamic Route

**Manual testing**:

1. **Navigate to** `localhost:3000/portfolio/quip`
2. **Should display** "Portfolio Detail for quip"
3. **Change to** `localhost:3000/portfolio/eventbrite`
4. **Should display** "Portfolio Detail for eventbrite"

### 4. Add Slugs to Portfolio Data

**File**: `src/components/portfolio-container.js`

Update state with slugs:

```javascript
this.state = {
  pageTitle: "Welcome to my portfolio",
  isLoading: false,
  data: [
    { title: "Quip", category: "eCommerce", slug: "quip" },
    { title: "Eventbrite", category: "Scheduling", slug: "eventbrite" },
    { title: "Ministry Safe", category: "Enterprise", slug: "ministry-safe" },
    { title: "SwingAway", category: "eCommerce", slug: "swingaway" }
  ]
};
```

**Slug rules**:

* **No spaces** – use hyphens (`ministry-safe`)
* **No special characters** – avoid `/`, `?`, etc.
* **Lowercase** – standard convention
* **URL-friendly** – must work in browsers

### 5. Pass Slug as Prop

**In `portfolioItems()` function**:

```javascript
portfolioItems() {
  return this.state.data.map(item => {
    return (
      <PortfolioItem
        key={item.title}
        title={item.title}
        url={item.url}
        slug={item.slug}
      />
    );
  });
}
```

### 6. Create Dynamic Links in PortfolioItem

**File**: `src/components/portfolio-item.js`

```javascript
import React from 'react';
import { Link } from 'react-router-dom';

const PortfolioItem = (props) => {
  return (
    <div className="portfolio-item-wrapper">
      <h3>
        <Link to={`/portfolio/${props.slug}`}>
          {props.title}
        </Link>
      </h3>
      <p>
        <a href={props.url} target="_blank" rel="noopener noreferrer">
          {props.url}
        </a>
      </p>
    </div>
  );
};

export default PortfolioItem;
```

**Template literal explanation**:

* **Backticks** (`` ` ``) – instead of quotes
* **`${}`** – JavaScript interpolation
* **`/portfolio/${props.slug}`** – produces `/portfolio/quip`, etc.

---

## KEY CONCEPTS EXPLAINED

### props.match.params.slug

**Object path breakdown**:

```javascript
props.match.params.slug
```

1. **`props`** – component data object
2. **`match`** – route information (React Router)
3. **`params`** – extracted URL parameters
4. **`slug`** – specific parameter we defined

**Tip**: You don’t need to memorise this – check documentation or previous projects.

### Template Literals (Backticks)

**Modern JavaScript syntax**:

```javascript
// Old
"/" + "portfolio" + "/" + props.slug

// Modern
`/portfolio/${props.slug}`
```

**Backtick location**: Top-left of keyboard, under ESC, above TAB.

### Complete Data Flow

1. **User clicks** portfolio item link
2. **URL changes** to `/portfolio/quip`
3. **React Router** matches `/:slug` pattern
4. **PortfolioDetail** component renders
5. **`props.match.params.slug`** contains `"quip"`
6. **Component displays** the relevant content

### Code Organisation

**React offers flexibility**:

* **`pages/portfolio-detail.js`** – if treated as a main page
* **`portfolio/portfolio-detail.js`** – if domain-specific
* **Both valid** – depends on your project’s architecture

---

## CODE

### App.js (With Dynamic Route)

```javascript
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import NavigationContainer from './navigation/navigation-container';
import Home from "./pages/home";
import About from "./pages/about";
import Contact from "./pages/contact";
import Blog from "./pages/blog";
import PortfolioDetail from "./portfolio/portfolio-detail";

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
            </Switch>
          </div>
        </Router>
      </div>
    );
  }
}
```

### portfolio/portfolio-detail.js

```javascript
import React from "react";

const PortfolioDetail = (props) => {
  return (
    <div>
      <h2>Portfolio Detail for {props.match.params.slug}</h2>
    </div>
  );
};

export default PortfolioDetail;
```

### portfolio-item.js (With Links)

```javascript
import React from 'react';
import { Link } from 'react-router-dom';

const PortfolioItem = (props) => {
  return (
    <div className="portfolio-item-wrapper">
      <h3>
        <Link to={`/portfolio/${props.slug}`}>
          {props.title}
        </Link>
      </h3>
      <p>
        <a href={props.url} target="_blank" rel="noopener noreferrer">
          {props.url}
        </a>
      </p>
    </div>
  );
};

export default PortfolioItem;
```

### portfolio-container.js (With Slugs)

```javascript
// In constructor, add slugs to data:
this.state = {
  pageTitle: "Welcome to my portfolio",
  isLoading: false,
  data: [
    { title: "Quip", category: "eCommerce", slug: "quip" },
    { title: "Eventbrite", category: "Scheduling", slug: "eventbrite" },
    { title: "Ministry Safe", category: "Enterprise", slug: "ministry-safe" },
    { title: "SwingAway", category: "eCommerce", slug: "swingaway" }
  ]
};

// In portfolioItems(), pass slug:
portfolioItems() {
  return this.state.data.map(item => {
    return (
      <PortfolioItem
        key={item.title}
        title={item.title}
        url={item.url}
        slug={item.slug}
      />
    );
  });
}
```

---

## TESTING AND VERIFICATION

### Dynamic URL Testing

**Verify each item**:

1. **Click “Quip”** → `/portfolio/quip` → “Portfolio Detail for quip”
2. **Click “Eventbrite”** → `/portfolio/eventbrite` → “Portfolio Detail for eventbrite”
3. **Click “Ministry Safe”** → `/portfolio/ministry-safe` → “Portfolio Detail for ministry-safe”
4. **Click “SwingAway”** → `/portfolio/swingaway` → “Portfolio Detail for swingaway”

### URL Sharing Test

**Real-world scenario**:

1. **Copy the detail page URL**
2. **Open a new tab and paste it**
3. **It should load correctly**
4. **Simulates sending a link to someone else**

### Inspect Generated Links

**In DevTools**:

* **Inspect portfolio links**
* **See** `href="/portfolio/quip"`, etc.
* **Confirm** template literals working correctly

---
