# 08-051 - Main SCSS File and Import/Organise Styles in React

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/main-scss-file-import-organize-styles-react

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/4d29cfe3731edba8f1d96b8b5cc1d778088f14fc)

---

## 🎯 NEW SECTION: STYLES IN REACT

### Multiple Approaches for CSS

**React is flexible** - many ways to add styles:

- **Traditional CSS**
- **SCSS/SASS** 
- **CSS-in-JS**
- **Styled Components**
- **CSS Modules**

**There is no "best way"** - depends on the project and team preferences.

### Approach of This Section

**Straightforward approach**:

- **Organised SCSS** by files
- **Centralised import system**
- **Organisation by features** 
- **Scalable and maintainable**

---

## 🛠️ STYLES SYSTEM CONFIGURATION

### Proposed Architecture

**main.scss as organiser**:

- **Only imports** - no direct styles
- **Entry point** for all styles
- **Easy to follow** - one place to see entire structure

### 1. Create Base File

**Create**: `src/style/base.scss`

**Move existing styles** from `main.scss` to `base.scss`:

```scss
body {
  margin: 0px;
  font-family: "Lato", sans-serif;
  color: #333;
}

.app {
  display: grid;
  grid-template-columns: 1fr;
}
```

### 2. Convert main.scss into Organiser

**File**: `src/style/main.scss`

**Clean and convert to imports**:

```scss
@import "./base.scss";
```

## NOTE! This function will soon be retired

```
Deprecation Warning [import]: Sass @import rules are deprecated and will be removed in Dart Sass 3.0.0.

More info and automated migrator: https://sass-lang.com/d/import

  ╷
7 │  @import './base.scss'
```

```
### 3. Simplify Base Styles

**In `base.scss`**, keep only the essentials:

```scss
body {
  margin: 0px;
}
```

---

## 📋 CONFIGURATION TESTING

### Verify Import System

**Testing steps**:

1. **Save files** - main.scss and base.scss
2. **Refresh browser** - styles must be applied
3. **Modify base.scss** - changes must be reflected
4. **Confirm** that import system works

### Expected Result

**Visually**:

- **Margin reset** applied (no spaces at edges)
- **Custom font** removed (back to system font)
- **Functionality intact** - only visual changes

---

## 🗂️ FUTURE STRUCTURE

### Planned Organisation

**main.scss as hub**:

```scss
@import "./base.scss";
@import "./variables.scss";       // Next
@import "./portfolio-items.scss"; // Next  
@import "./navigation.scss";      // Next
// More imports according to features...
```

### Organisation Philosophy

**By features, not by type**:

- **portfolio-items.scss** - everything related to portfolio
- **navigation.scss** - navigation styles
- **variables.scss** - colours, fonts, spacing

**Advantages**:

- **Easy to locate** specific styles
- **Modular** - isolated changes by feature
- **Scalable** - add new features easily

---
