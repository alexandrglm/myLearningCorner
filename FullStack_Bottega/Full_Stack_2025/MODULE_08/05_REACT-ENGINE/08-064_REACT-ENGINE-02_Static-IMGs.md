# 08-064 - Importing Static Images in React

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-import-static-images-react

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/17930e1d6c8a2bc90e09caa7c5e9a18beb363dfe)

---

## 🎯 OBJECTIVES

### Functionality to Implement

**Static images system**:

- Correct directory structure `static/assets/images/`
- Import images as variables in React components
- Dynamic background images with JSX styling
- Two-column layout for authentication page

### Concepts You Will Master

**Knowledge you will gain**:

- Difference between static vs dynamic images from API
- Special syntax for asset imports in React
- Relative directory navigation (../../..)
- Inline styles with template literals and string interpolation

---

## 🛠️ IMPLEMENTATION

### 1. Create Directory Structure

**Create structure in `static/` directory**:

```
static/
  assets/
    images/
      auth/
        login.jpg
```

**Process**:

1. **Navigate to** `static/` directory (project root)
2. **Open** existing `assets/` directory
3. **Create** `images/` directory
4. **Create** `auth/` subdirectory within images
5. **Download image** from guide resources
6. **Place** `login.jpg` file in `static/assets/images/auth/`

### 2. Expand Auth Component

**File**: `src/components/pages/auth.js`

**Base HTML structure**:

```javascript
import React, { Component } from "react";

export default class Auth extends Component {
  render() {
    return (
      <div className="auth-page-wrapper">
        <div className="left-column">
          {/* Image will go here */}
        </div>

        <div className="right-column">
          <h1>Login component goes here...</h1>
        </div>
      </div>
    );
  }
}
```

### 3. Import Static Image

**At the top of auth.js file**:

```javascript
import React, { Component } from "react";
import loginImg from "../../../static/assets/images/auth/login.jpg";

export default class Auth extends Component {
  // ... rest of component
}
```

**Path explanation**:

- **`../../../`** - go up 3 directories (pages → components → src)
- **`static/assets/images/auth/login.jpg`** - path from root
- **`loginImg`** - variable name (can be anything)

### 4. Implement Background Image with Inline Styles

**File**: `src/components/pages/auth.js`

**Left column with background image**:

```javascript
<div 
  className="left-column"
  style={{
    backgroundImage: `url(${loginImg})`,
    height: "200px"  // Temporary for testing
  }}
/>
```

**Syntax explained**:

- **Double braces `{{}}`** - JSX object syntax for styles
- **Template literals** - backticks for string interpolation
- **`${loginImg}`** - variable inserted in URL
- **camelCase** - `backgroundImage` instead of `background-image`

---

## 🔧 TECHNICAL CONCEPTS

### Why Import Images?

**Advantages of import approach**:

- **Webpack optimisation** - images processed automatically
- **Path resolution** - correct paths in production
- **Error catching** - compilation errors if image doesn't exist
- **Performance** - automatic asset optimisation

### Difference: Static vs Dynamic

**Static images** (this guide):

- **Hardcoded** in the component
- **Part of build** - bundled with application
- **Import required** - must be imported as variables
- **Examples**: logos, icons, fixed backgrounds

**Dynamic images** (from API):

- **URLs from API** - change based on data
- **Runtime loading** - loaded from server
- **Direct URL usage** - no import needed
- **Examples**: portfolio items, user avatars

### Directory Navigation

**Path resolution explained**:

```javascript
// From: src/components/pages/auth.js
// To: static/assets/images/auth/login.jpg

"../../../static/assets/images/auth/login.jpg"
//  ^       ^        ^
//  |       |        └── From src/
//  |       └── From components/  
//  └── From pages/
```

**Debugging paths**:

- **Common error**: wrong number of `../`
- **Verify structure** of directories
- **Console errors** indicate incorrect path

### Inline Styles in JSX

**Syntax requirement**:

```javascript
// ❌ Incorrect - CSS syntax
style="background-image: url(image.jpg)"

// ✅ Correct - JSX object
style={{
  backgroundImage: `url(${imageVariable})`
}}
```

**Conversion rules**:

- **Hyphenated CSS** → **camelCase JSX**
- **String values** → **object properties**
- **Template literals** for dynamic content

---

## ✔️ VERIFICATION

### Visual Testing

**Verification steps**:

1. **Save files** - auth.js with changes
2. **Navigate to** `localhost:3000/auth`
3. **Verify image** appears as background
4. **Inspect element** - confirm URL generated correctly

### Debugging Common Issues

**Image doesn't appear**:

- **Check path** - verify import route
- **Image file exists** - confirm file in directory
- **Height specified** - div needs height for background image
- **Console errors** - check DevTools for errors

**Incorrect paths**:

```javascript
// ❌ Too few navigations
import img from "../static/assets/images/auth/login.jpg"

// ❌ Too many navigations  
import img from "../../../../static/assets/images/auth/login.jpg"

// ✅ Correct from pages/
import img from "../../../static/assets/images/auth/login.jpg"
```

---

## 🎨 DESIGN AND LAYOUT

### Two-Column Layout

**Planned structure**:

- **Left column** - coding/login image
- **Right column** - authentication form (next guide)
- **Auth page wrapper** - main container
- **Professional layout** - inspired by modern sites

**CSS to be added**:

- **CSS Grid** for responsive layout
- **Image positioning** - background-size, background-position
- **Column proportions** - 50/50 split or custom ratios
- **Mobile responsiveness** - stack vertically on mobile

---

## 🎯 EXPECTED RESULTS

- ✅ **Login image** visible as background
- ✅ **Base layout** for authentication page
- ✅ **Import system** working correctly
- ✅ **Solid foundation** for advanced styling
- ✅ **Complete understanding** of static assets in React

**Key difference from basic HTML**:

- **No direct image paths** - everything must be imported
- **Webpack processing** - automatic optimisation
- **Build-time resolution** - paths resolved at compilation
- **Professional asset management** - scalable for large projects

---
