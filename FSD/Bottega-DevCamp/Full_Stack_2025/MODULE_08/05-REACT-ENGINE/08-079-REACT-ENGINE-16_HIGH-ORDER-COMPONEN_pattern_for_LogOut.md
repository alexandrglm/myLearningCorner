# 08-079 - Finalising Logout Functionality - Higher Order Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/finalizing-logout-functionality-higher-order-component)**

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/3237366f0af8a31a11a0df001b57955216674d25)

---

## 🎯 OBJECTIVES

**Complete logout implementation**:

- **handleSignOut()** function for logout with axios.delete
- **withRouter HOC** - access to props.history in component without dedicated route  
- **Conditional Sign Out link** - button visible only when logged in
- **Complete flow** - API call → redirect → state update

**Advanced concept**: Introduction to Higher Order Components (HOCs) in React

---

## 🛠️ STEP-BY-STEP IMPLEMENTATION

### 1. Import Axios

**In `navigation-container.js`**:

```javascript
import React from "react";
import axios from "axios";
import { NavLink } from "react-router-dom";

/* Rest of existing imports... */
```

### 2. Create handleSignOut Function

**Inside NavigationComponent, AFTER dynamicLink:**

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

    const handleSignOut = () => {
        axios.delete("https://api.devcamp.space/logout", { withCredentials: true })
            .then(response => {
                if (response.status === 200) {
                    props.history.push("/");
                    props.handleSuccessfulLogout();
                }
                return response.data;
            })
            .catch(error => {
                console.log("Error signing out", error);
            });
    };

    return (
        /* Component JSX... */
    );
};
```

### 3. Add Conditional Sign Out Link

**In the right-side section of JSX:**

```javascript
return (
    <div className="nav-wrapper">
        <div className="left-side">
            {/* Existing links... */}

            {props.loggedInStatus === "LOGGED_IN" ? (
                dynamicLink("/blog", "Blog")
            ) : null}
        </div>

        <div className="right-side">
            JORDAN HUDGENS
            {props.loggedInStatus === "LOGGED_IN" ? (
                <a onClick={handleSignOut}>Sign Out</a>
            ) : null}
        </div>
    </div>
);
```

### 4. Test the Error (Before HOC)

**Expected error when clicking Sign Out:**

```
TypeError: Cannot read property 'push' of undefined
```

**Reason**: NavigationComponent doesn't have dedicated route, so no access to `props.history`

### 5. Implement withRouter HOC

**Import withRouter:**

```javascript
import { withRouter } from "react-router";
```

**⚠️ Important**: It's `"react-router"`, NOT `"react-router-dom"`

**Export with Higher Order Component:**

```javascript
// At end of file
export default withRouter(NavigationComponent);
```

---

## 🔧 TECHNICAL CONCEPTS

### The Problem: props.history Undefined

**Components with dedicated route** (like Auth):

- Automatically have access to `props.history`
- Can use `history.push()` for redirection

**Components without dedicated route** (like NavigationContainer):

- DO NOT have access to `props.history`
- `props.history.push()` causes "undefined" error

### Higher Order Components (HOCs)

**Official definition**:

> "A higher-order component is an advanced technique in React for reusing component logic. HOCs are not part of the React API, per se. They are a pattern that emerges from React's compositional nature."

**Basic pattern**:

```javascript
const EnhancedComponent = higherOrderComponent(WrappedComponent);
```

### withRouter HOC Explained

**What withRouter does**:

- **Wraps** the original component
- **Injects** routing props (history, location, match)
- **Returns** "enhanced" component with router access

**Result**:

```javascript
// Without withRouter
const NavigationComponent = props => {
    // props.history is undefined ❌
};

// With withRouter  
export default withRouter(NavigationComponent);
// Now props.history is available ✅
```

### React's Compositional Nature

**Composition as concept**:

- Like orchestral composer: violin + piano + guitar = music
- HOC: functionality A + functionality B = enhanced component
- **Preferred over inheritance** in React

### axios.delete() Method

**DELETE HTTP verb**:

- **GET** - fetch data (queries)
- **POST** - create resources
- **DELETE** - remove resources (in this case, session)

**API Response**:

- **Status 200** - logout successful (standard for DELETE)
- **Server-side** - session cookie invalidated automatically

---

## ✔️ VERIFICATION

### Testing Complete Logout Flow

**1. Initial state: NOT_LOGGED_IN**

- Sign Out link NOT visible

**2. Successful login:**

- Navigate to `/auth` → login
- Verify: Sign Out link IS visible

**3. Testing the error (before withRouter):**

- Click Sign Out
- **Expected error**: "Cannot read property 'push' of undefined"

**4. After implementing withRouter:**

- Click Sign Out
- **Result**: Successful redirect to Home (`/`)
- **State**: loggedInStatus = NOT_LOGGED_IN
- **UI**: Blog link and Sign Out link disappear

### DevTools Console

**Error debugging**:

- Click error link to see exact line: `props.history.push`
- Understand that `history` is `undefined`
- Solution: withRouter to inject history props

### Testing from Different Pages

**Testing redirect from any page**:

- Login → navigate to `/blog`
- Click Sign Out
- Verify: redirect to `/` from any page

---

## 🎨 HOC CONVENTIONS AND PATTERNS

### Naming Conventions

**HOCs start with lowercase**:

- `withRouter` - HOC (function)
- `NavLink` - Component (actual component)

**Reason**: Visually distinguish HOCs from actual components

### HOC Pattern Structure

**Typical HOC structure**:

```javascript
const withSomeFeature = (WrappedComponent) => {
    return (props) => {
        // Additional logic here
        return <WrappedComponent {...props} extraProp={value} />;
    };
};
```

---

## 🚀 EXTENDED CONTENT

### Alternative Modern Approaches

**React Hooks approach** (React 16.8+):

```javascript
import { useHistory } from "react-router-dom";

const NavigationComponent = () => {
    const history = useHistory();

    const handleSignOut = () => {
        /* axios call */
        history.push("/");
    };
};
```

### Multiple HOCs Composition

**Composing multiple HOCs**:

```javascript
export default withRouter(
    withAuth(
        withLoading(NavigationComponent)
    )
);
```

### HOC Documentation Link

**Official React docs**: [Legacy Docs -> Higher-Order Components](https://legacy.reactjs.org/docs/higher-order-components.html)

---

## 🔐 AUTHENTICATION SYSTEM COMPLETE

### Complete Authentication Architecture

**Layer 1: Visual Conditional Rendering**

- ✅ Links appear/disappear based on `loggedInStatus`

**Layer 2: Route Protection**  

- ✅ Protected routes don't exist for unauthorised users

**Layer 3: Session Management**

- ✅ Login establishes session with cookies
- ✅ Logout invalidates session server-side  
- ✅ State management synchronised with real session

**Layer 4: Complete UX Flow**

- ✅ Redirect after logout
- ✅ State cascade updates automatically
- ✅ No memory leaks or broken navigation

---
