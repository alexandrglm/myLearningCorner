# 08-075 - How to Convert Class Component to Functional Component in React

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-convert-class-component-functional-component-react

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/a7f54a2ed63714b553c0647793e116ac7ad27c1f)

---

## 🎯 OBJECTIVES

### React Component Modernisation

**Technical transformation to perform**:

- Convert class component to functional component using React Hooks
- Migrate from `this.state` and `this.setState()` to `useState` hook
- Update event handlers to use modern syntax
- Maintain exactly the same functionality with cleaner code

### Modern React Concepts

**Modern patterns you will master**:

- React Hooks (`useState`) for state management
- Functional components as current industry standard
- More concise and readable syntax
- Better performance and less boilerplate code

---

## 🛠️ IMPLEMENTATION

### 1. Identify Component to Convert

**File to modify**: `src/components/navigation/navigation-container.js`

**Current state (Class Component)**:

```javascript
import React, { Component } from 'react';

export default class NavigationContainer extends Component {
  constructor() {
    super();

    this.state = {
      menuTitle: "Navigation Wrapper"
    };
  }

  render() {
    return (
      <div className="nav-wrapper">
        <div className="left-side">
          <div className="nav-link-wrapper">
            <a href="/">Home</a>
          </div>
          <div className="nav-link-wrapper">
            <a href="/about">About</a>
          </div>
          <div className="nav-link-wrapper">
            <a href="/contact">Contact</a>
          </div>
          <div className="nav-link-wrapper">
            <a href="/blog">Blog</a>
          </div>
        </div>

        <div className="right-side">
          Your Name
        </div>
      </div>
    );
  }
}
```

### 2. Convert to Functional Component

**File**: `src/components/navigation/navigation-container.js`

**New implementation (Functional Component with Hooks)**:

```javascript
import React, { useState } from 'react';

const NavigationContainer = () => {
  const [menuTitle, setMenuTitle] = useState("Navigation Wrapper");

  return (
    <div className="nav-wrapper">
      <div className="left-side">
        <div className="nav-link-wrapper">
          <a href="/">Home</a>
        </div>
        <div className="nav-link-wrapper">
          <a href="/about">About</a>
        </div>
        <div className="nav-link-wrapper">
          <a href="/contact">Contact</a>
        </div>
        <div className="nav-link-wrapper">
          <a href="/blog">Blog</a>
        </div>
      </div>

      <div className="right-side">
        Your Name
      </div>
    </div>
  );
};

export default NavigationContainer;
```

---

## 🔧 TECHNICAL CONCEPTS

### State Migration

**Before (Class Component)**:

```javascript
constructor() {
  super();
  this.state = {
    menuTitle: "Navigation Wrapper"
  };
}
```

**After (Functional Component)**:

```javascript
const [menuTitle, setMenuTitle] = useState("Navigation Wrapper");
```

### Pattern Comparison

**Class Component characteristics**:

- **Constructor** needed to initialise state
- **`this.state`** to access state
- **`this.setState()`** to update state
- **`render()` method** mandatory
- **More verbose** but familiar to OOP developers

**Functional Component characteristics**:

- **`useState` hook** for state management
- **Direct destructuring** of state
- **Specific setter function** for each state variable
- **Direct return** of JSX
- **More concise** and easier to read

### Why Use Functional Components?

**Advantages of modern approach**:

- **Less code** - eliminates class boilerplate
- **Better performance** - React can optimise better
- **More readable** - logic more direct and clear
- **Current standard** - recommended by React team
- **Easier testing** - pure functions more testable

### useState Hook Explained

**useState syntax**:

```javascript
const [stateName, setStateName] = useState(initialValue);
```

**Hook components**:

- **`stateName`** - variable containing current value
- **`setStateName`** - function to update state
- **`initialValue`** - initial state value

**Usage examples**:

```javascript
const [count, setCount] = useState(0);
const [name, setName] = useState("John");
const [isVisible, setIsVisible] = useState(true);
```

---

## ✔️ VERIFICATION

### Testing the Conversion

**Verification steps**:

1. **Save file** - verify no compilation errors
2. **Refresh browser** - confirm navigation looks the same
3. **React DevTools** - verify component shows as functional
4. **Identical behaviour** - all functionality preserved

### Expected Visual Result

**Identical behaviour**:

- **Navigation looks the same** - no visual changes
- **Links work the same** - same functionality
- **Styling intact** - CSS classes preserved
- **Improved performance** - less overhead

---

## 🎨 CODE MODERNISATION

### Before vs After

**Lines of code reduced**:

- **Before**: ~25 lines with class syntax
- **After**: ~22 lines with functional syntax
- **Reduction**: ~12% less code

**Reduced complexity**:

- **No constructor** - more direct initialisation
- **No binding** - no methods to bind
- **No this keyword** - less conceptual confusion

### Preparation for Future Functionality

**With useState configured**:

```javascript
// Easy to add more state when needed
const [isMenuOpen, setIsMenuOpen] = useState(false);
const [activeLink, setActiveLink] = useState('home');

// Simple event handlers
const toggleMenu = () => setIsMenuOpen(!isMenuOpen);
const handleLinkClick = (link) => setActiveLink(link);
```

---

### Other Components to Convert

**Candidates for migration**:

- **Portfolio items** - if using class components
- **Form components** - especially beneficial for forms
- **Modal components** - simple state ideal for hooks

### Functionality Enabled

**With functional components ready**:

- **useEffect hook** - for lifecycle methods
- **Custom hooks** - reusable logic
- **Context hooks** - for global state
- **Performance hooks** - useMemo, useCallback

### When NOT to Convert

**Keep class components if**:

- **Error boundaries** - only available in class components
- **Complex legacy lifecycle methods**
- **Team preferences** - if team prefers classes
- **Large refactor risk** - if conversion too complex

---

## 🎯 EXPECTED RESULTS

- ✅ **Modernised component** using React Hooks
- ✅ **Cleaner code** easier to maintain
- ✅ **Better performance** with functional components
- ✅ **Modern standard** following React best practices
- ✅ **Foundation prepared** for advanced functionality

**Why this migration matters**:

- **Industry standard** - functional components are new standard
- **Future-proofing** - React evolves towards hooks
- **Team efficiency** - code easier to read and maintain
- **Performance benefits** - React optimises functional components better

**When to do the migration**:

- **Natural refactoring** - when already modifying component
- **New features** - when adding new functionality
- **Code review** - as part of code improvements
- **Team training** - to modernise team skills

---

## 🔍 ADVANCED PATTERNS

### Multiple State Variables

**Instead of large state object**:

```javascript
// ❌ Less optimal
const [state, setState] = useState({
  menuTitle: "Navigation",
  isOpen: false,
  activeItem: null
});

// ✅ More optimal - separate concerns
const [menuTitle, setMenuTitle] = useState("Navigation");
const [isOpen, setIsOpen] = useState(false);
const [activeItem, setActiveItem] = useState(null);
```

### Custom Hooks Preparation

**Foundation for future custom hooks**:

```javascript
// Future: extract logic to custom hook
const useNavigation = () => {
  const [menuTitle, setMenuTitle] = useState("Navigation");
  const [isOpen, setIsOpen] = useState(false);

  return { menuTitle, setMenuTitle, isOpen, setIsOpen };
};
```

---
