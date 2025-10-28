# 08-063 - Basic Setup of Authentication

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/overview-authentication-behavior

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/d0e0f42959a4c103104edfc61a8d072da8836a69)

---

## 🎯 OBJECTIVES

### Understanding Authentication

**Concepts you will master**:

- Definition of authentication and its purpose
- Difference between authenticated vs unauthenticated user
- Protection of sensitive routes in React applications
- Step-by-step implementation of complete auth system

### Functionality to Implement

**The complete system will include**:

- Login component at `/auth` route (hidden from users)
- Navbar with conditional links based on authentication state
- Protection of administrative routes (Portfolio Manager)
- Automatic redirection on unauthorised routes
- Clear states: "logged in" vs "logged out"

---

## 🛠️ IMPLEMENTATION

### 1. Create Base Auth Component

**File**: `src/components/pages/auth.js`

```javascript
import React, { Component } from "react";

export default class Auth extends Component {
  render() {
    return <div>Auth...</div>;
  }
}
```

**Component characteristics**:

- **Class component** - we will need state and event handlers
- **Temporary placeholder** - we will expand functionality
- **Solid base** for complete implementation

### 2. Configure Authentication Route

**File**: `src/components/app.js`

**Add import**:

```javascript
import Auth from "./pages/auth";
```

**Add route in Switch**:

```javascript
<Switch>
  <Route exact path="/" component={Home} />
  <Route path="/auth" component={Auth} />
  <Route path="/about-me" component={About} />
  <Route path="/contact" component={Contact} />
  <Route path="/blog" component={Blog} />
  <Route path="/portfolio/:slug" component={PortfolioDetail} />
  <Route component={NoMatch} />
</Switch>
```

### 3. Testing Auth Route

**Basic verification**:

1. **Navigate to** `localhost:3000/auth`
2. **Should display** "Auth..." on screen
3. **Confirm** that component loads correctly

---

## 🔧 TECHNICAL CONCEPTS

### What is Authentication?

**Practical definition**:

- **Process of identification** - "who are you in the application"
- **Authorisation of actions** - "what you can do"
- **Everyday example** - login to Facebook, Twitter, Gmail
- **Familiar functionality** - we have all used it

### Design Philosophy for Portfolio

**Key difference from social applications**:

- **No public link** to login - should not be visible to visitors
- **Only owner** should know the `/auth` route
- **Personal portfolio** - not a social network or multi-user application
- **Secret URL** - only you know how to access

### Authentication States

**Unauthenticated user**:

- **Limited navbar** - only public links (Home, About, Contact, Blog)
- **No access** to Portfolio Manager or other administrative areas
- **Automatic redirection** if attempting to access protected routes

**Authenticated user**:

- **Complete navbar** - all links + "Sign Out"
- **Full access** to administrative areas
- **Expanded functionality** based on permissions

### Route Security

**Problem to solve**:

- Unauthenticated user can **copy URL** of Portfolio Manager
- Without protection, they could **access directly** via URL
- **Solution**: redirect to 404/NoMatch if not authenticated

**Professional implementation**:

- **Route guards** - verify auth before rendering
- **Automatic redirects** - send to login or 404
- **Clear experience** - user always knows their state

---

## ✔️ VERIFICATION

### ✅ Implementation Checklist

- [x] **Auth component** created with class structure
- [x] **`/auth` route** configured in App.js
- [x] **Correct import** without syntax errors
- [x] **Manual testing** - route loads correctly
- [x] **Functional placeholder** - ready for next step

### Route Testing

**Verification steps**:

1. **Server running** - `npm start` without errors
2. **Manual navigation** - `localhost:3000/auth`
3. **Correct rendering** - "Auth..." visible
4. **No errors** in browser console

---

## 🎨 DESIGN AND UX

### Hidden Authentication Philosophy

**Why `/auth` without public links?**

- **Personal portfolio** - only the owner needs admin access
- **Security through obscurity** - do not advertise administration panel
- **Clean UX** - visitors don't see irrelevant options
- **Professional** - like corporate websites

### Clear Visual States

**Important user feedback**:

- **Visual indicator** in navbar - "logged in" vs "logged out"
- **Available actions** - buttons/links based on permissions
- **Smooth transitions** - clear state changes
- **Error handling** - messages when something fails

---
