# 08-072 - Introduction to Render Props in React

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-render-props-react

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/024b87efd329a3d41b7a1c620eedb35c08067eb5)

---

## 🎯 OBJECTIVES

### Application-Level Authentication System

**Critical functionality to implement**:

- Authentication state management in App component (top level)
- Conditional route rendering based on login state
- Render props for two-way parent ↔ child communication
- Protected routes that simply don't exist if user not authenticated
- Professional authentication patterns

### Advanced React Concepts

**Advanced skills you will master**:

- Render props pattern for passing functions to components
- State management in parent component for application-level control
- React Router render prop vs component prop
- Method binding patterns and prop passing
- Two-way communication between components

---

## 🛠️ IMPLEMENTATION

### 1. Configure Authentication State in App Component

**File**: `src/components/app.js`

**Add constructor with authentication state**:

```javascript
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import NavigationContainer from './navigation/navigation-container';
import Home from "./pages/home";
import About from "./pages/about";
import Contact from "./pages/contact";
import Blog from "./pages/blog";
import PortfolioDetail from "./portfolio/portfolio-detail";
import Auth from "./pages/auth";
import NoMatch from "./pages/no-match";

export default class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      loggedInStatus: "NOT_LOGGED_IN"
    };

    this.handleSuccessfulLogin = this.handleSuccessfulLogin.bind(this);
    this.handleUnsuccessfulLogin = this.handleUnsuccessfulLogin.bind(this);
  }

  handleSuccessfulLogin() {
    this.setState({
      loggedInStatus: "LOGGED_IN"
    });
  }

  handleUnsuccessfulLogin() {
    this.setState({
      loggedInStatus: "NOT_LOGGED_IN"
    });
  }

  render() {
    return (
      <div className="container">
        <Router>
          <div>
            <NavigationContainer />

            <Switch>
              <Route exact path="/" component={Home} />

              <Route 
                path="/auth" 
                render={props => (
                  <Auth 
                    {...props}
                    handleSuccessfulLogin={this.handleSuccessfulLogin}
                    handleUnsuccessfulLogin={this.handleUnsuccessfulLogin}
                  />
                )}
              />

              <Route path="/about-me" component={About} />
              <Route path="/contact" component={Contact} />
              <Route path="/blog" component={Blog} />
              <Route path="/portfolio/:slug" component={PortfolioDetail} />
              <Route component={NoMatch} />
            </Switch>
          </div>
        </Router>
      </div>
    );
  }
}
```

---

## 🔧 TECHNICAL CONCEPTS

### Render Props Pattern Explained

**Traditional component prop**:

```javascript
<Route path="/auth" component={Auth} />
```

**Approach with render prop**:

```javascript
<Route 
  path="/auth" 
  render={props => (
    <Auth 
      {...props}
      handleSuccessfulLogin={this.handleSuccessfulLogin}
      handleUnsuccessfulLogin={this.handleUnsuccessfulLogin}
    />
  )}
/>
```

### Why Render Props?

**Problem with component prop**:

- **No way to pass** additional props
- **Limited to** what React Router provides
- **Not possible** to add custom functionality

**Solution with render prop**:

- **Complete control** over render process
- **Pass custom props** alongside Router props
- **Enable communication** between parent and child
- **Override render** maintaining Router functionality

### Spread Operator (...props)

**What ...props provides**:

```javascript
// React Router automatically provides:
{
  history: {...},
  location: {...},
  match: {...}
}
```

**Why spread is necessary**:

- **Auth component needs** Router props for navigation
- **{...props}** preserves all Router functionality
- **Additional props** extend functionality without breaking Router

### String-Based State Management

**Why "NOT_LOGGED_IN" vs boolean false**:

```javascript
// ❌ Problematic approach
loggedInStatus: false

// ✅ Professional approach  
loggedInStatus: "NOT_LOGGED_IN"
```

**Benefits of string constants**:

- **Explicit values** - no confusion about empty strings/null
- **Clarity in debugging** - exactly what state represents
- **Less prone to bugs** - avoids JavaScript boolean coercion issues
- **Professional convention** - industry-standard pattern

---

## ✔️ VERIFICATION

### Testing Authentication State Configuration

**Manual verification steps**:

1. **Save files** - no compilation errors
2. **Navigate to** `/auth` route
3. **Auth component** should render normally
4. **Check console** - no errors about missing props
5. **React DevTools** - verify App component has state

### ✅ Implementation Checklist

- [x] **Constructor added** to App component
- [x] **loggedInStatus state** initialised to "NOT_LOGGED_IN"
- [x] **handleSuccessfulLogin** method created
- [x] **handleUnsuccessfulLogin** method created
- [x] **Method binding** completed in constructor
- [x] **Render prop** implemented for Auth route
- [x] **Spread operator** preserving Router props
- [x] **Custom props** passed to Auth component

### Expected Component Structure

**App component hierarchy**:

```
App (manages auth state)
├── NavigationContainer
└── Router
    └── Switch
        ├── Auth (receives auth handlers via render prop)
        ├── Other routes
        └── NoMatch
```

---

## 🎨 ADVANCED PATTERNS

### Why Application-Level State Management

**Benefits of application-level authentication**:

- **Single source of truth** - all components can access auth state
- **Route protection** - conditionally render routes based on auth
- **Navigation updates** - show/hide links based on login state
- **Consistent behaviour** - centralised authentication logic

### Two-Way Communication Pattern

**Parent → Child communication**:

```javascript
// App passes functions to Auth
handleSuccessfulLogin={this.handleSuccessfulLogin}
```

**Child → Parent communication**:

```javascript
// Auth calls function to update App state
this.props.handleSuccessfulLogin();
```

**Result**:

- **Auth component** can trigger state changes in App
- **App component** controls global authentication state
- **Two-way data flow** enables complex interactions

---

## 🎯 EXPECTED RESULTS

- ✅ **Advanced React patterns** - render props implementation
- ✅ **Application-level state management** - authentication control from top level
- ✅ **Professional architecture** - scalable authentication system
- ✅ **Two-way communication** - parent ↔ child data flow
- ✅ **Solid foundation** - ready for complete authentication features

**Why this approach matters**:

- **Enterprise applications** require application-level state management
- **Security considerations** - authentication must be controlled centrally
- **User experience** - consistent behaviour across all routes
- **Maintainability** - authentication logic in single location

**Advanced React concepts introduced**:

- **Render props** - powerful pattern for component composition
- **Higher-order patterns** - beyond basic component structure
- **State architecture** - design for complex applications
- **Professional patterns** - industry-standard approaches

---

## 🔍 DEBUGGING AND BEST PRACTICES

### Common Issues with Render Props

**Function not binding correctly**:

- Verify binding in constructor
- Verify method names match exactly
- Confirm that `this` context is preserved

**Props not passing correctly**:

- Ensure spread operator `{...props}` is used
- Verify no typos in prop names
- Check React DevTools for prop transmission

### Professional Development Tips

**Code organisation**:

- **Keep authentication logic** in App component
- **Single responsibility** - each component has clear purpose
- **Consistent naming** - handleSuccessfulLogin vs handleLogin
- **Method binding** - always in constructor, never in render

---
