# 07-041 - Organising the Portfolio API Query in the PortfolioContainer Class

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/organizing-portfolio-api-query-portfolio-container-class](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/organizing-portfolio-api-query-portfolio-container-class)

**Source Code**: [https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/6cdd8d3c85f5b7d35bbe76d22cfd5b8046d6e011](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/6cdd8d3c85f5b7d35bbe76d22cfd5b8046d6e011)

---

## 🎯 FUNDAMENTAL CONCEPTS

### The Philosophy of Professional React Development

**Why we start in App.js**:

* **Professional process** — not just a portfolio tutorial
* **Transferable methodology** — applies to any React app
* **Testing strategy** — implement simply first

### Development Strategy: Simple → Complex

**Professional approach**:

1. **Test in the App component** — highest level, fewer variables
2. **Verify it works** — isolate library issues
3. **Move to the correct location** — after confirmation
4. **Organise architecture** — logical code structure

### The Problem of Multiple Sources of Debugging

**Problem scenario**:

* Placing Axios directly in a complex component
* Multiple failure points — Axios, component, routing, etc.
* Debugging becomes difficult

**Solution: start in App.js**:

* Single point of failure for testing
* Simpler debugging to confirm Axios works
* Confidence before moving code

---

## 🗂️ COMPONENT ARCHITECTURE

### Finding the Logical Location

**Component tree path**:

```
App.js
├── Router
    ├── Home.js
        └── PortfolioContainer.js  ← Ideal location
```

**Why PortfolioContainer is ideal**:

* Already manages portfolio data — clear responsibility
* Already has a constructor — existing infrastructure
* Already has state — established structure
* Already uses binding — known pattern

### Component-Driven Architecture Benefits

* Move code between components easily
* Encapsulated modules — independent behaviour
* Identical behaviour after move
* Logical placement keeps code where it belongs

---

## 🛠️ PRACTICAL STEPS — REFACTORING

### 1. Analyse Current State

**In App.js we have**:

```javascript
import axios from 'axios';

constructor() {
  super();
  this.getPortfolioItems = this.getPortfolioItems.bind(this);
}

getPortfolioItems() {
  axios.get('https://your-subdomain.devcamp.space/portfolio/portfolio_items')
    .then(response => {
      console.log("response data", response);
    });
}

render() {
  this.getPortfolioItems();
  // ...
}
```

### 2. Prepare PortfolioContainer

**File**: `src/components/portfolio-container.js`

**Current structure** (infrastructure present):

```javascript
import React, { Component } from 'react';

export default class PortfolioContainer extends Component {
  constructor(props) {
    super(props);

    this.state = {
      pageTitle: "Welcome to my portfolio",
      data: [ /* hardcoded data */ ]
    };

    this.handleFilter = this.handleFilter.bind(this);
  }
  // ...
}
```

### 3. Move Axios Import

**Remove from App.js**:

```javascript
// REMOVE this line from app.js
import axios from 'axios';
```

**Add to PortfolioContainer.js**:

```javascript
import React, { Component } from 'react';
import axios from 'axios'; // New location
```

### 4. Move getPortfolioItems Function

**Add to PortfolioContainer** (after constructor):

```javascript
getPortfolioItems() {
  axios.get('https://your-subdomain.devcamp.space/portfolio/portfolio_items')
    .then(response => {
      console.log("response data", response);
    })
    .catch(error => {
      console.log(error);
    });
}
```

### 5. Update Binding in Constructor

**Modify PortfolioContainer constructor**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    pageTitle: "Welcome to my portfolio",
    data: [
      { title: "Quip", category: "eCommerce" },
      { title: "Eventbrite", category: "Scheduling" },
      { title: "Ministry Safe", category: "Enterprise" },
      { title: "SwingAway", category: "eCommerce" }
    ]
  };

  this.handleFilter = this.handleFilter.bind(this);
  this.getPortfolioItems = this.getPortfolioItems.bind(this); // New line
}
```

### 6. Call Function in Render

**In PortfolioContainer's render method**:

```javascript
render() {
  if (this.state.isLoading) {
    return <div>Loading...</div>;
  }

  this.getPortfolioItems(); // Temporary for testing

  return (
    <div>
      <h2>{this.state.pageTitle}</h2>
      {/* rest of JSX */}
    </div>
  );
}
```

### 7. Clean App.js

**Remove from App.js**:

* Axios import
* Empty constructor (if present)
* getPortfolioItems function
* Call in render

**Simplified App.js**:

```javascript
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
// other imports...

export default class App extends Component {
  render() {
    return (
      <div className="app">
        <h1>Jordan Hudgens Portfolio Website</h1>
        <Router>
          {/* routing components */}
        </Router>
      </div>
    );
  }
}
```

---

## 📋 IMPORT CONVENTIONS

**Recommended pattern**:

```javascript
// 1. React and core libraries (top)
import React, { Component } from 'react';

// 2. node_modules libraries (middle)
import axios from 'axios';
import moment from 'moment';

// 3. Internal components (bottom)
import PortfolioItem from './portfolio-item';
import NavigationContainer from './navigation/navigation-container';
```

**Benefits**:

* Clarity — dependency type immediately visible
* Maintenance — easy to find and update imports
* Convention — standard used by teams
* Readability — consistent structure

**Visual separation** with blank lines aids scanning and team consistency.

---

## 🔍 VERIFYING THE REFACTOR

### Post-Refactor Testing

1. `npm start` — confirm server runs without errors
2. Browser → `localhost:3000`
3. Navigate to homepage — PortfolioContainer should load
4. DevTools → Console — check for "response data"
5. Expand response — confirm array of portfolio items

### Common Debugging

**If errors appear**:

* **"axios is not defined"** — check import in PortfolioContainer; remove import from App.js
* **"getPortfolioItems is not defined"** — check binding and function definition
* **No console logs** — ensure function is called and DevTools Console is open

**Expected console output**:

```
response data {data: Array(x), status: 200, ...}
```

`x` = number of portfolio items in DevCamp Space

---

## 🎯 FULL WORKING CODE

### PortfolioContainer.js (After Refactoring)

```javascript
import React, { Component } from 'react';
import axios from 'axios';

export default class PortfolioContainer extends Component {
  constructor(props) {
    super(props);

    this.state = {
      pageTitle: "Welcome to my portfolio",
      isLoading: false,
      data: [
        { title: "Quip", category: "eCommerce" },
        { title: "Eventbrite", category: "Scheduling" },
        { title: "Ministry Safe", category: "Enterprise" },
        { title: "SwingAway", category: "eCommerce" }
      ]
    };

    this.handleFilter = this.handleFilter.bind(this);
    this.getPortfolioItems = this.getPortfolioItems.bind(this);
  }

  handleFilter(filter) {
    this.setState({
      data: this.state.data.filter(item => {
        return item.category === filter;
      })
    });
  }

  getPortfolioItems() {
    axios.get('https://your-subdomain.devcamp.space/portfolio/portfolio_items')
      .then(response => {
        console.log("response data", response);
      })
      .catch(error => {
        console.log(error);
      });
  }

  portfolioItems() {
    return this.state.data.map(item => {
      return <div key={item.title}>{item.title}</div>;
    });
  }

  render() {
    if (this.state.isLoading) {
      return <div>Loading...</div>;
    }

    this.getPortfolioItems(); // Temporary for testing

    return (
      <div>
        <h2>{this.state.pageTitle}</h2>

        <button onClick={() => this.handleFilter('eCommerce')}>
          eCommerce
        </button>
        <button onClick={() => this.handleFilter('Scheduling')}>
          Scheduling
        </button>
        <button onClick={() => this.handleFilter('Enterprise')}>
          Enterprise
        </button>

        {this.portfolioItems()}
      </div>
    );
  }
}
```

---
