# 08-076 - Show/Hide Links Based on Login Status

---

[**Guide**:](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-show-hide-links-logged-in)

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/2a6894524c249773eeadff55f7baac91f903f6f5)

---

## 🎯 OBJECTIVES

**Conditional functionality**:

- **Hide links** based on user `loggedInStatus`
- **Dynamic function** to generate links conditionally  
- **Ternary operator** for conditional JSX
- **Props passing** from App component to NavigationContainer

**Note**: This is **part 1 of 2** - we only hide visual links, NOT routes

---

## 🛠️ STEP-BY-STEP IMPLEMENTATION

### 1. Helper Function for Dynamic Links

**In `navigation-container.js`**:

```javascript
const NavigationComponent = props => {
    const dynamicLink = (route, linkText) => {
        return (
            <div className="nav-link-wrapper">
                <NavLink to={route} activeClassName="nav-link-active">
                    {linkText}
                </NavLink>
            </div>
        );
    };

    return (
        <div className="nav-wrapper">
            <div className="left-side">
                <div className="nav-link-wrapper">
                    <NavLink exact to="/" activeClassName="nav-link-active">
                        Home
                    </NavLink>
                </div>

                <div className="nav-link-wrapper">
                    <NavLink to="/about-me" activeClassName="nav-link-active">
                        About
                    </NavLink>
                </div>

                <div className="nav-link-wrapper">
                    <NavLink to="/contact" activeClassName="nav-link-active">
                        Contact
                    </NavLink>
                </div>

                {/* Conditional link */}
                {props.loggedInStatus === "LOGGED_IN" ? (
                    dynamicLink("/blog", "Blog")
                ) : null}
            </div>

            <div className="right-side">
                JORDAN HUDGENS
            </div>
        </div>
    );
};

export default NavigationComponent;
```

### 2. Pass Props from App Component

**In `app.js`**:

```javascript
// In the render method, inside return
<NavigationContainer loggedInStatus={this.state.loggedInStatus} />
```

### 3. Complete App.js Configuration

**Complete structure needed**:

```javascript
import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import NavigationContainer from "./navigation/navigation-container";
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
                        <NavigationContainer loggedInStatus={this.state.loggedInStatus} />

                        <Switch>
                            <Route exact path="/" component={Home} />
                            <Route path="/about-me" component={About} />
                            <Route path="/contact" component={Contact} />
                            <Route path="/blog" component={Blog} />
                            <Route
                                path="/portfolio/:slug"
                                component={PortfolioDetail}
                            />
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

### Ternary Operator in JSX

**Conditional syntax**:

```javascript
{condition ? (
    // JSX when true
) : null}
```

**Advantages**:

- **One line** - cleaner than if/else
- **Inline JSX** - directly in render
- **React-friendly** - correctly interpreted by JSX parser

### Function Definition in Functional Components

**Arrow function pattern**:

```javascript
const NavigationComponent = props => {
    const dynamicLink = (route, linkText) => {
        return JSX;
    };

    return mainJSX;
};
```

**Why this structure**:

- **Reusability** - same function for multiple links
- **Separation** - link logic separate from conditional logic
- **Maintainability** - easy to modify styling of all dynamic links

### Props Flow

**Data flow**:

```
App.state.loggedInStatus 
    ↓ (props)
NavigationContainer 
    ↓ (props.loggedInStatus)
Conditional rendering
```

**Immutability**: Props are **read-only** in child component

### Multi-line Ternary Operator

**Formatting with Prettier**:

```javascript
{props.loggedInStatus === "LOGGED_IN" ? (
    dynamicLink("/blog", "Blog")
) : null}
```

**Prettier wraps** automatically in parentheses for clarity

---

## ✔️ VERIFICATION

### Testing Conditional System

**States to test**:

1. **NOT_LOGGED_IN**:
   
   ```
   - Navigate to localhost:3000
   - Verify: "Blog" link does NOT appear
   - Verify: Home, About, Contact appear
   ```

2. **LOGGED_IN**:
   
   ```
   - Navigate to /auth
   - Perform successful login
   - Verify: "Blog" link DOES appear
   - Verify: Blog link works (/blog route)
   ```

### ⚠️ Current Limitation

**Incomplete security**:

- **Link hidden** ✅ - doesn't appear in navbar
- **Route accessible** ❌ - `/blog` URL still works directly

**In incognito browser** (NOT_LOGGED_IN):

- Navigate directly to `localhost:3000/blog`
- **Result**: Blog page loads normally
- **Problem**: Unauthorised user accesses restricted content

---
