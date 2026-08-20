# 09-108: Font Awesome Naming Requirements React Components

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/font-awesome-naming-requirements-react-components)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at b119e1e3b9b2506be1a6d37763a11d3e595de09a](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/b119e1e3b9b2506be1a6d37763a11d3e595de09a)

---

## 🎯 Objectives

**Understand the complete naming process in FontAwesome**:

- **Icon research** - how to find correct names on fontawesome.io
- **CamelCase for imports** - convention for adding to library (faSignOutAlt)
- **Kebab-case for props** - convention for icon prop (sign-out-alt)
- **Critical differences** between import name and component prop name
- **Practical implementation** - add sign-out icon to navigation

**Technical result**:

- Functional sign-out icon in navigation
- Complete understanding of FontAwesome naming pattern
- Professional styling with hover effects

---

## 🛠️ Implementation

### 1. Research Icon Name on FontAwesome.io

**Search process**:

1. **Go to fontawesome.io/icons**
2. **Search "sign out"** in the search
3. **Find "sign-out-alt"** icon
4. **Copy exact icon name** from the library

**Name found**: `sign-out-alt`

Currently is: `fa-right-from-bracket` !

### 2. Add Icon to Library in App.js

**File**: `src/components/app.js`

**Import specific icon**:

```javascript
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import axios from 'axios';

import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash, faSignOutAlt } from "@fortawesome/free-solid-svg-icons";

// Rest of imports...

// Add icons to the library
library.add(faTrash, faSignOutAlt);

export default class App extends Component {
  // Rest of component...
}
```

### 3. Implement Icon in NavigationContainer

**File**: `src/components/navigation/navigation-container.js`

**Import FontAwesome component**:

```javascript
import React, { Component } from 'react';
import axios from 'axios';
import { withRouter } from 'react-router';
import { NavLink } from 'react-router-dom';
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export default class NavigationContainer extends Component {
  // Existing constructor and methods...

  render() {
    return (
      <div className="nav-wrapper">
        <div className="left-side">
          {/* Existing links... */}
        </div>

        <div className="right-side">
          ALEXANDR REACT

          {props.loggedInStatus === "LOGGED_IN" ? (
            <a onClick={handleSignOut}>
              <FontAwesomeIcon icon="sign-out-alt" />
            </a>
          ) : null}
        </div>
      </div>
    );
  }
}
```

### 4. Add Styling for Sign-Out Icon

**File**: `src/style/navigation.scss`

**Styles for right-side**:

```scss
.nav-wrapper {
  .right-side {
    a {
      margin-left: 15px;
      cursor: pointer;
      colour: $teal;
      transition: 0.5s ease-in-out;

      &:hover {
        colour: $dark-teal;
      }
    }
  }
}
```

---

## 📚 Concepts

### FontAwesome Naming Convention Complete

**1. Icon Discovery Process**:

```
fontawesome.io/icons → Search "sign out" → Find "sign-out-alt"
```

**2. Import Name (CamelCase)**:

```javascript
// Pattern: fa + CamelCase
import { faSignOutAlt } from "@fortawesome/free-solid-svg-icons";
```

**3. Library Addition (CamelCase)**:

```javascript
// Use exact import name
library.add(faSignOutAlt);
```

**4. Component Prop (Kebab-Case)**:

```javascript
// Use hyphens, NOT camelCase
<FontAwesomeIcon icon="sign-out-alt" />
```

### Why Two Different Naming Conventions

**Import/Library naming (camelCase)**:

- **JavaScript convention** - variables cannot have hyphens
- **ES6 module system** requires valid JavaScript identifiers
- **TypeScript compatibility** - strong typing support

**Component prop naming (kebab-case)**:

- **CSS class convention** - traditionally uses hyphens
- **HTML attribute style** - consistent with web standards
- **FontAwesome CSS classes** - maintains consistency with CSS version

### Pattern Recognition for Multi-Word Icons

**Single word icons**:

```javascript
// faTrash → "trash"
import { faTrash } from "@fortawesome/free-solid-svg-icons";
<FontAwesomeIcon icon="trash" />
```

**Multi-word icons**:

```javascript
// faSignOutAlt → "sign-out-alt"
import { faSignOutAlt } from "@fortawesome/free-solid-svg-icons";
<FontAwesomeIcon icon="sign-out-alt" />
```

**Complex examples**:

```javascript
// faUserCircle → "user-circle"
// faShoppingCart → "shopping-cart"
// faChevronDown → "chevron-down"
```

### Library Management Strategy

**Global library approach**:

```javascript
// In app.js - once for entire app
library.add(faTrash, faSignOutAlt, faUserCircle);
```

**Advantages of this approach**:

- **Centralised management** - all icons in one place
- **No repeated imports** - import once, use anywhere
- **Bundle efficiency** - automatic tree shaking
- **Consistent availability** - icons available app-wide

### Error Prevention Strategies

**Common naming mistakes**:

```javascript
// ❌ NOPE! Incorrect - using camelCase in prop
<FontAwesomeIcon icon="signOutAlt" />

// ❌ NOPE! Incorrect - using import name in prop
<FontAwesomeIcon icon="faSignOutAlt" />

// ❌ NOPE! Incorrect - using kebab-case in import
import { fa-sign-out-alt } from "@fortawesome/free-solid-svg-icons";

// ✅ YEP! Correct - camelCase for import, kebab-case for prop
import { faSignOutAlt } from "@fortawesome/free-solid-svg-icons";
<FontAwesomeIcon icon="sign-out-alt" />
```

### Debugging FontAwesome Issues

**Error: "Could not find icon"**:

1. **Verify library.add()** - icon added correctly
2. **Check import name** - spelling and camelCase correct
3. **Verify prop name** - kebab-case format
4. **Confirm icon exists** - check on fontawesome.io

**Console debugging**:

```javascript
// Verify library contents
console.log(library.definitions);

// Verify specific icon
console.log(library.definitions.fas['sign-out-alt']);
```

---

## ✋ Verification

### Testing Icon Discovery Process

**Manual verification**:

1. **Visit fontawesome.io/icons**
2. **Search different terms** - "logout", "sign out", "exit"
3. **Compare icon names** - observe naming patterns
4. **Document findings** - create personal reference

### Functional Testing

**Sign-out icon functionality**:

1. **Visual verification** - icon appears in navigation
2. **Hover testing** - colour transition works
3. **Click testing** - sign-out functionality preserved
4. **Responsive testing** - icon adapts to different screens

### Code Pattern Verification

**Naming consistency check**:

```javascript
// ✅ Verify this pattern works
import { faIconName } from "@fortawesome/free-solid-svg-icons";
library.add(faIconName);
<FontAwesomeIcon icon="icon-name" />
```

### Styling Integration Testing

**CSS verification**:

1. **Margin spacing** - 15px left margin applied
2. **Colour variables** - $teal and $dark-teal functioning
3. **Transition smoothness** - 0.5s ease-in-out working
4. **Cursor pointer** - hover state indicates clickability

### Cross-Browser Testing

**Icon rendering verification**:

- **Chrome** - icon displays correctly
- **Firefox** - no font loading issues
- **Safari** - vector scaling works
- **Edge** - colour variables resolve properly

---

