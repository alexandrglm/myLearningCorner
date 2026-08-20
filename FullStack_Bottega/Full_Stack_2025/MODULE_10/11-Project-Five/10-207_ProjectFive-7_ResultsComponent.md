# 10-207: Setting Up Results Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/setting-up-results-component-daily-smarty-ui)**

[setup results component · bottega-code-school/DailySmartyUI@8aaf531 · GitHub](https://github.com/bottega-code-school/DailySmartyUI/commit/8aaf531f2dfb3cf7881e1ad97e7683f362f66bf4)

---

## 🎯 Objectives

**Create Results component for search results page**:

- **Results component** - dedicated search results page
- **Logo reuse** - shared component across pages
- **Route connection** - link /results to Results component
- **Exact prop fix** - prevent route conflicts

---

## 🛠️ Results Component Creation

### 1. Create Results Component

**File**: `src/components/results.js`

```javascript
import React, { Component } from 'react';
import Logo from './logo';

class Results extends Component {
    render() {
        return (
            <div>
                <h1>Results</h1>
                <Logo />
            </div>
        );
    }
}

export default Results;
```

**Component features**:

- **Basic structure** - placeholder for future functionality
- **Logo integration** - reuses existing Logo component
- **Temporary H1** - visual confirmation of component rendering

### 2. Update Bootstrap.js Routes

**File**: `src/bootstrap.js`

```javascript
import Results from './components/results';

function main() {
    ReactDOM.render(
        <Provider store={createStoreWithMiddleware(reducers)}>
            <BrowserRouter>
                <Switch>
                    <Route exact path='/' component={Home} />
                    <Route path='/results' component={Results} />
                </Switch>
            </BrowserRouter>
        </Provider>
        , document.querySelector('.app-wrapper'));
}
```

---

## 📧 Route Behaviour Analysis

### Problem: Route Conflicts

**Without exact prop**:

```javascript
<Route path='/' component={Home} />        // Matches /, /results
<Route path='/results' component={Results} /> // Both render
```

**Visual result**: Home + Results components both render on `/results`

### Solution: Exact Prop

**With exact prop**:

```javascript
<Route exact path='/' component={Home} />  // Only matches /
<Route path='/results' component={Results} /> // Only Results renders
```

**Testing routes**:

- **`localhost:3000/`** → Home component only
- **`localhost:3000/results`** → Results component only

---

## 📧 Component Reusability Demonstration

### Logo Component Sharing

**Same Logo component used in**:

- **Home page** - part of search interface
- **Results page** - navigation and branding consistency

**Benefits**:

- **Code reuse** - single Logo component, multiple uses  
- **Consistency** - same styling across pages
- **Maintainability** - update once, reflects everywhere
- **Component architecture** - proper React patterns

---

## 📋 Current Functionality Status

### Working Features

**Manual navigation**:

- **`/`** → Home page with logo, search, recent posts
- **`/results`** → Results page with logo and "Results" heading

### Not Yet Working

**Form submission navigation**:

- **Search form submit** → still only console logs
- **No programmatic routing** → form doesn't navigate to /results
- **Next guide focus** → implement navigation on form submit

---

## 📧 Technical Concepts

### React Router Path Matching

**Path hierarchy understanding**:

- **`/`** matches everything starting with /
- **`/results`** more specific, should match first
- **Switch component** - renders first match only
- **exact prop** - prevents greedy matching

### Component Import/Export Pattern

**Consistent pattern**:

```javascript
// Import at top
import Logo from './logo';

// Use in JSX  
<Logo />

// Export at bottom
export default Results;
```

---
