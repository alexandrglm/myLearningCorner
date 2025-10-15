# 07-034 - React Components 18: Overview of the Link Component in React

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/overview-link-component-react](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/overview-link-component-react)

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/13e08e429ee7a4fa75deda84bf303d9a0017ea24)

---

## CORE CONCEPTS

### Extending Routing Knowledge
---
### Link vs NavLink

**Main differences**:

* **Link**: Basic link with React behaviour
* **NavLink**: Link + automatic active state functionality
* **When to use each** depends on the context

### Component Reorganisation

**Current issue**:

* **PortfolioContainer** is in App.js – appears on all pages
* **Should only be** on the homepage
* **React modularity** makes reorganisation easy

---

## PRACTICAL STEPS – BASE CODE FOR THE EXERCISE

### 1. Import the Link Component

**File**: `src/components/pages/blog.js`

Add import:

```javascript
import React from "react";
import { Link } from 'react-router-dom';
```

### 2. Add Content and Link to the Blog

**Modify blog.js** to simulate a blog with a sidebar:

```javascript
import React from "react";
import { Link } from 'react-router-dom';

export default function() {
  return (
    <div>
      <div>
        <h2>Blog</h2>

        <div>
          <Link to="/about-me">
            Read more about myself
          </Link>
        </div>
      </div>
    </div>
  );
}
```

**Structure explanation**:

* **Div wrapper** – for the whole blog
* **h2** – clear blog title
* **Div sidebar** – where the link will go (future sidebar)
* **Link** – navigation to About Me

### 3. Testing the Link Component

**Verify functionality**:

1. **Go to /blog** – see new content
2. **Click “Read more about myself”** – should go to /about-me
3. **No reload** – maintains SPA behaviour
4. **No active class** – difference from NavLink

### 4. Move PortfolioContainer to Homepage

**Current problem**: PortfolioContainer appears on all pages

**Step 1**: Remove it from App.js

**File**: `src/components/app.js`

```javascript
export default class App extends Component {
  render() {
    return (
      <div className="app">
        <h1>Portfolio Website</h1>

        <Router>
          <div>
            <NavigationContainer />

            <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/about-me" component={About} />
              <Route path="/contact" component={Contact} />
              <Route path="/blog" component={Blog} />
            </Switch>
          </div>
        </Router>

        {/* PortfolioContainer removed from here */}
      </div>
    );
  }
}
```

**Step 2**: Add it to the Home component

**File**: `src/components/pages/home.js`

```javascript
import React from 'react';
import PortfolioContainer from '../portfolio-container';

const Home = () => {
  return (
    <div>
      <h2>Homepage</h2>
      <PortfolioContainer />
    </div>
  );
};

export default Home;
```

### 5. Resolve Import Path

**Issue**: Home is in `pages/` – needs to navigate back

**Correct path**:

* **From**: `pages/home.js`
* **To**: `portfolio-container.js`
* **Solution**: `../portfolio-container`

**Path explanation**:

```
pages/home.js -> needs to go to components/portfolio-container.js
../             = go up one directory (from pages to components)
portfolio-container = destination file
```

### 6. Reorganisation Testing

**Verify results**:

1. **Homepage (/)** – shows PortfolioContainer
2. **About (/about-me)** – does NOT show PortfolioContainer
3. **Contact (/contact)** – does NOT show PortfolioContainer
4. **Blog (/blog)** – does NOT show PortfolioContainer + has link

---

## KEY CONCEPTS EXPLAINED

### Link vs NavLink – When to Use Each

**Use Link when**:

* **Contextual links** – inside content
* **Reference links** – “read more”, “learn about”
* **No need** for an active class
* **Simple navigation** without active state

**Use NavLink when**:

* **Main navigation** – navbar, menus
* **Need to** indicate current page
* **Active class** important for UX
* **Structured navigation** systems

### Link Component Syntax

**Basic**:

```javascript
<Link to="/about-me">
  Read more about myself
</Link>
```

**Main props**:

* **`to`** – destination route (same as NavLink)
* **Content** – text/JSX of the link
* **Does not have** `exact` (not required)
* **Does not have** `activeClassName` (not applicable)

### React Modularity

**Demonstrated benefit**:

* **One line of code** – `<PortfolioContainer />`
* **Easily moved** between components
* **No duplication** – unlike vanilla HTML
* **Simple maintenance** – change in one place only

### Relative Imports

**Directory navigation**:

```javascript
// Same directory
import Component from './component'

// Parent directory  
import Component from '../component'

// Specific directory
import Component from '../portfolio/portfolio-container'
```

---

## CODE

### App.js (Clean)

```javascript
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import NavigationContainer from './navigation/navigation-container';
import Home from "./pages/home";
import About from "./pages/about";
import Contact from "./pages/contact";
import Blog from "./pages/blog";

export default class App extends Component {
  render() {
    return (
      <div className="app">
        <h1>Portfolio Website</h1>

        <Router>
          <div>
            <NavigationContainer />

            <Switch>
              <Route exact path="/" component={Home} />
              <Route path="/about-me" component={About} />
              <Route path="/contact" component={Contact} />
              <Route path="/blog" component={Blog} />
            </Switch>
          </div>
        </Router>
      </div>
    );
  }
}
```

### pages/home.js (With Portfolio)

```javascript
import React from 'react';
import PortfolioContainer from '../portfolio-container';

const Home = () => {
  return (
    <div>
      <h2>Homepage</h2>
      <PortfolioContainer />
    </div>
  );
};

export default Home;
```

### pages/blog.js (With Link)

```javascript
import React from "react";
import { Link } from 'react-router-dom';

export default function() {
  return (
    <div>
      <div>
        <h2>Blog</h2>

        <div>
          <Link to="/about-me">
            Read more about myself
          </Link>
        </div>
      </div>
    </div>
  );
}
```

---

## TESTING AND VERIFICATION

### Link Component Testing

**Verify behaviour**:

1. **Click the link** – navigation works
2. **No reload** – SPA behaviour maintained
3. **No active class** – difference from NavLink
4. **Normal styling** – appears as a regular link

### Reorganisation Testing

**Verify pages**:

* **Homepage**: Portfolio visible
* **Other pages**: Portfolio NOT visible
* **Modularity**: Easy to change component location

### Link vs NavLink Comparison

**In DevTools**:

* **Link**: `<a href="/about-me">` with no special classes
* **NavLink**: `<a href="/about-me" class="nav-link-active">` with active class

---

