# 08-066 - Creating Initial Login Component

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-initial-login-component

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/e3d124ac352b1299b85f09ff10779ce091c397de)

---

## 🎯 OBJECTIVES

### Base Login Component

**Initial functionality to implement**:

- Separate Login component within `auth/` directory
- Basic HTML form structure with title, inputs and button
- Integration with Auth component via props
- Layout foundation for advanced functionality next

### Concepts to Master

**Skills you will develop in upcoming guides**:

- Forms in React with state management
- Event handlers for input changes
- Passing functions as props between components
- API integration for real authentication
- Response handling and user feedback

---

## 🛠️ IMPLEMENTATION

### 1. Create Directory and Auth Structure

**Create directory**: `src/components/auth/`

**Planned structure**:

```
src/components/
  auth/
    login.js      ← This file
    register.js   ← Future
    auth-utils.js ← Future utilities
```

### 2. Create Base Login Component

**File**: `src/components/auth/login.js`

```javascript
import React, { Component } from "react";

export default class Login extends Component {
  render() {
    return (
      <div>
        <h1>Login to access your dashboard</h1>

        <form>
          <input type="text" placeholder="Email" />
          <input type="password" placeholder="Password" />

          <div>Login</div>
        </form>
      </div>
    );
  }
}
```

**Key elements**:

- **Class component** - we will need state for form handling
- **Descriptive title** - "Login to access your dashboard"
- **Form structure** - prepared for React functionality
- **Input placeholders** - user friendly
- **Button placeholder** - temporary div, will be real button

### 3. Integrate Login in Auth Component

**File**: `src/components/pages/auth.js`

**Add import**:

```javascript
import React, { Component } from "react";
import Login from "../auth/login";
import loginImg from "../../../static/assets/images/auth/login.jpg";

export default class Auth extends Component {
  render() {
    return (
      <div className="auth-page-wrapper">
        <div 
          className="left-column"
          style={{
            backgroundImage: `url(${loginImg})`
          }}
        />

        <div className="right-column">
          <Login />
        </div>
      </div>
    );
  }
}
```

**Changes made**:

- **Import Login** component
- **Replace placeholder** h1 with `<Login />`
- **Maintain layout** - columns and styles intact

---

## 🔧 TECHNICAL CONCEPTS

### Auth Directory Organisation

**Why `auth/` directory?**:

- **Feature-based organisation** - group related functionality
- **Scalability** - prepared for multiple auth components
- **Separation of concerns** - auth logic separate from pages logic
- **Professional structure** - common pattern in real applications

### Path Resolution for Imports

**From pages/auth.js to auth/login.js**:

```javascript
// Current location: src/components/pages/auth.js
// Target: src/components/auth/login.js

import Login from "../auth/login";
//                 ^
//                 └─ Go up one level from pages/ and enter auth/
```

**Debugging paths**:

- **Common error**: too many `../` navigations
- **Structure awareness** - understand directory tree
- **Relative imports** - from current file location

### Component Composition

**Pattern used**:

```javascript
// Parent component (Auth)
render() {
  return (
    <Layout>
      <ChildComponent />  // Login component
    </Layout>
  );
}
```

**Benefits**:

- **Modular design** - each component has specific responsibility
- **Reusable components** - Login could be used in other contexts
- **Easier testing** - isolated components are easier to test

### Class vs Functional Components

**Why Class component for Login?**:

- **State management** - we will need state for form inputs
- **Event handlers** - methods to handle form submission
- **Lifecycle methods** - possible componentDidMount for API calls
- **Method binding** - this.handleSubmit patterns

---

## ✔️ VERIFICATION

### Visual Testing

**Verification steps**:

1. **Save files** - login.js and auth.js
2. **Navigate to** `localhost:3000/auth`
3. **Verify layout** - two columns maintained
4. **Check form** - title, inputs and button placeholder
5. **Test inputs** - verify they allow typing

### Expected Visual Result

**Layout achieved**:

- **Coding image** on left side (unchanged)
- **Login form** centred on right side
- **Title** - "Login to access your dashboard"
- **Two inputs** - email and password working
- **Button placeholder** - will be styled in future guides

---

## Foundation Established

- ✅ **Component structure** - modular and organised
- ✅ **UI foundation** - layout and basic form
- ✅ **Integration working** - Auth + Login components
- ✅ **Development setup** - ready for functionality

---

## 🎨 DESIGN AND UX

### Form Design Philosophy

**Current approach (minimal)**:

- **Functionality first** - establish workflow
- **Styling later** - CSS in future guides
- **User feedback** - validation and error states next
- **Professional polish** - final touches at the end

---

## 🚀 EXTENDED CONTENT

### Alternative Component Organisations

**Feature-first approach** (actual):

```
components/
  auth/
    login.js
    register.js
    auth-utils.js
```

**Type-first approach**:

```
components/
  forms/
    login-form.js
  pages/
    auth.js
  utils/
    auth-helpers.js
```

### Class Component Justification

**Why not Functional with Hooks?**:

- **Learning progression** - class components first
- **Industry reality** - many legacy codebases use classes
- **State management clarity** - explicit this.state patterns
- **Method organisation** - clear separation of concerns

---

## 🎯 EXPECTED RESULTS

- ✅ **Professional component structure** and scalable
- ✅ **Form foundation** ready for React functionality
- ✅ **Integration pattern** established between components
- ✅ **Development momentum** - ready for advanced features
- ✅ **UI baseline** - visual structure functional

**Difference from basic HTML**:

- **Component composition** - reusable building blocks
- **Separation of concerns** - layout vs logic vs styling
- **Scalable architecture** - prepared for growth
- **React patterns** - composition over inheritance

---
