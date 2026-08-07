# 10-206: Setting Up Daily Smarty UI Routes

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/setting-up-daily-smarty-ui-routes-using-react-router-dom)**

[setup app routes · bottega-code-school/DailySmartyUI@3579719 · GitHub](https://github.com/bottega-code-school/DailySmartyUI/commit/3579719d3fbff0233823c7a2b1c7c8b2a7e2dcd5)

---

## 🎯 Objectives

**React Router setup for navigation**:

- **Rename App → Home** - semantic component naming
- **Route configuration** - home and results routes
- **Bootstrap.js update** - router integration
- **Navigation preparation** - for form submission routing

---

## 🛠️ Component Restructuring

### 1. Rename App Component

**Rename**: `src/components/app.js` → `src/components/home.js`

**Update component**:

```javascript
// home.js
import React, { Component } from 'react';
import Logo from './logo';
import SearchBar from './searchBar';
import RecentPosts from './recentPosts';

export default class Home extends Component {
    render() {
        return (
            <div>
                <div>
                    <Logo />
                    <SearchBar />
                    <RecentPosts />
                </div>
            </div>
        );
    }
}
```

### 2. Update Bootstrap.js

**File**: `src/bootstrap.js`

```javascript
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

import reducers from './reducers';

const createStoreWithMiddleware = applyMiddleware()(createStore);

import 'bootstrap/dist/css/bootstrap.css';
import './style/main.scss';

import Home from './components/home';

function main() {
    ReactDOM.render(
        <Provider store={createStoreWithMiddleware(reducers)}>
            <BrowserRouter>
                <Switch>
                    <Route exact path='/' component={Home} />
                    <Route path='/results' component={Home} />
                </Switch>
            </BrowserRouter>
        </Provider>
        , document.querySelector('.app-wrapper'));
}

document.addEventListener('DOMContentLoaded', main);
```

---

## 📧 Router Configuration

### Route Definitions

**Home route**:

- **Path**: `/` (root)
- **Exact**: true - prevents matching sub-routes
- **Component**: Home

**Results route**:

- **Path**: `/results`
- **Component**: Home (temporary - will be Results component)
- **Purpose**: search results page destination

### React Router Imports

**Required imports**:

```javascript
import { BrowserRouter, Switch, Route } from 'react-router-dom';
```

**Component roles**:

- **BrowserRouter** - enables routing functionality
- **Switch** - renders only first matching route
- **Route** - defines individual route mappings

---

## 📧 Technical Concepts

### Exact Prop Necessity

**Without exact**:

```javascript
<Route path='/' component={Home} />        // Matches /, /results, /anything
<Route path='/results' component={Home} /> // Never reached
```

**With exact**:

```javascript
<Route exact path='/' component={Home} />  // Matches only /
<Route path='/results' component={Home} /> // Matches /results
```

### Component Semantic Naming

**Why rename App → Home**:

- **App too generic** - doesn't describe functionality
- **Home specific** - represents homepage content
- **Router clarity** - clear route → component mapping
- **Scalability** - easier to add Results, About, etc.

### Bootstrap.js as Router Root

**Centralised routing**:

- **Single source** - all routes defined in one place
- **Redux integration** - Provider wraps router
- **Middleware setup** - store creation with router

---

## 📋 Current Status

**Working functionality**:

- **`/` route** - displays Home component (logo, search, recent posts)
- **`/results` route** - displays Home component (temporary)
- **Form submission** - still logs to console, no navigation yet

**Next needed**:

- **Results component** - dedicated results page
- **Programmatic navigation** - form submit → route change
- **Results route update** - point to Results component

---
