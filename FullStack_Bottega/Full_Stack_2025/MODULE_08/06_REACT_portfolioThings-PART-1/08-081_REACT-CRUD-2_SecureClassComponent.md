# 08-081 - Building Secure Portfolio Manager Page with Class Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-secure-class-component-portfolio-manager-page)**

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/424abab6ab7112d269c962d3c1c5e65db4bb2d53)

---

## 🎯 OBJECTIVES

**Create protected Portfolio Manager component**:

- **Class component** for complex state management
- **Protected route** for authenticated users only
- **Dynamic navigation** that appears/disappears based on login
- **Page structure** prepared for form and grid
- **Route guards** working correctly

**Security architecture**:

- **Authorised pages** - logged-in users only
- **Dynamic navbar** - contextual links
- **Route protection** - 404 if not authenticated

---

## 🛠️ IMPLEMENTATION

### Create Portfolio Manager Component

**File**: `src/components/pages/portfolio-manager.js`

```javascript
import React, { Component } from "react";

export default class PortfolioManager extends Component {
  render() {
    return (
      <div>
        <h1>PortfolioManager</h1>
        <h1>PortfolioManager</h1>
      </div>
    );
  }
}
```

### Add Import in App.js

**File**: `src/components/app.js`

```javascript
import PortfolioManager from "./pages/portfolio-manager";
```

### Configure Protected Route

**In App.js**, move from public routes to `authorisedPages()`:

```javascript
// Remove blog from authorisedPages (should be public)
  // From 08-077 ROUTE GUARDS
  authorisedPages() {
    return [
      <Route key="portfolio-manager" path="/portfolio-manager" component={PortfolioManager} />
    ]
  }

// Add blog to public routes
<Route path="/blog" component={Blog} />
```

### Update Dynamic Navigation

**File**: `src/components/navigation-container.js`

```javascript
// Make dynamic link truly reusable
const dynamicLink = (route, linkText) => {
  return (
    <div className="nav-link-wrapper">
      <NavLink to={route} activeClassName="nav-link-active">
        {linkText}
      </NavLink>
    </div>
  );
};

// In JSX, add dynamic links
{dynamicLink("/blog", "Blog")}
{loggedInStatus === "LOGGED_IN" ? dynamicLink("/portfolio-manager", "Portfolio Manager") : null}
```

---

## 🔧 CONCEPTS

### Why Class Component

**Technical decision for Portfolio Manager**:

```javascript
// Class component needed for:
// - Complex state management
// - Lifecycle methods for API calls
// - Form handling with multiple fields
// - File upload management
```

### Directory Architecture

**Logical organisation**:

```
src/components/
├── pages/           // Full pages that users visit
│   ├── portfolio-manager.js
│   ├── about.js
│   └── contact.js
├── portfolio/       // Partials/reusable components
│   ├── portfolio-container.js
│   └── portfolio-item.js
```

**Criterion**: **Pages** vs **Partials** - pages are navigation destinations, partials are reusable components.

### Route Guards and Security

**Multi-layer protection system**:

1. **Route level**: Route doesn't exist if not authenticated
2. **UI level**: Link doesn't appear if not authenticated  
3. **Navigation level**: Automatic redirect on logout

```javascript
// Triple protection:
// 1. authorisedPages() - only creates route if logged in
// 2. dynamicLink conditional - only shows link if logged in
// 3. handleSignout() - redirect on logout
```

### Dynamic Link Pattern

**Why refactor**:

```javascript
// Before: hardcoded, single link
const dynamicLink = () => (
  <NavLink to="/blog">Blog</NavLink>
);

// After: reusable, multiple links
const dynamicLink = (route, linkText) => (
  <NavLink to={route}>{linkText}</NavLink>
);
```

---

## ✔️ VERIFICATION

### Testing Protected Route

**Verify security behaviour**:

1. **Without login**: 
   
   - `/portfolio-manager` → 404/NoMatch
   - Navbar doesn't show "Portfolio Manager"

2. **With login**:
   
   - `/portfolio-manager` → component visible
   - Navbar shows "Portfolio Manager"

3. **After logout**:
   
   - Automatic redirect to homepage
   - Link disappears from navbar

### Testing Dynamic Navigation

**Verify dynamic links**:

- **Blog**: Always visible (public)
- **Portfolio Manager**: Only visible if logged in
- **Links work** correctly
- **Active states** applying

### Cleanup Verification

**Confirm cleanup**:

- ✅ `loggedInStatus` text removed from JSX
- ✅ Blog moved from authorised to public routes
- ✅ Portfolio Manager only in authorised routes
- ✅ Dynamic links working with parameters

---
