# 08-053 - Build Flexbox Container for Navigation Component

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-flexbox-container-navigation-component

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/adb63dcdd6ca88a89c737b3100423fd2bb4b0ccc)

---

## 🎯 NAVIGATION ARCHITECTURE

### Analyse the Final Design

**Target layout**:

- **Links on left** - Home, About, Contact, Blog
- **Name on right** - Your name
- **Space between** - automatic distribution

### Structural Approach

**Architecture first, details later**:

- **Flexbox container** for main layout
- **Left/right sections** clearly defined
- **Responsive spacing** automatic

---

## 🛠️ STEP-BY-STEP IMPLEMENTATION

### 1. Create Navigation Styles File

**Create**: `src/style/navigation.scss`

**Add import in**: `src/style/main.scss`

```scss
@import "./base.scss";
@import "./navigation.scss";
```

### 2. Structure HTML in Navigation Component

**File**: `src/components/navigation/navigation-container.js`

```javascript
import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';

export default class NavigationComponent extends Component {
    constructor() {
        super();
    }

    render() {
        return (
            <div className="nav-wrapper">
                <div className="left-side">
                    <NavLink exact to="/" activeClassName="nav-link-active">
                        Home
                    </NavLink>

                    <NavLink to="/about-me" activeClassName="nav-link-active">
                        About
                    </NavLink>

                    <NavLink to="/contact" activeClassName="nav-link-active">
                        Contact
                    </NavLink>

                    <NavLink to="/blog" activeClassName="nav-link-active">
                        Blog
                    </NavLink>

                    {false ? <button>Add Blog</button> : null}
                </div>

                <div className="right-side">
                    YOUR NAME
                </div>
            </div>
        );
    }
}
```

### 3. Implement Flexbox Layout

**File**: `src/style/navigation.scss`

```scss
.nav-wrapper {
    display: flex;
    justify-content: space-between;
    padding: 30px;
}
```

---

## 🔧 TECHNICAL CONCEPTS

### className vs class

**⚠️ Important difference in React**:

```javascript
// ❌ Traditional HTML
<div class="nav-wrapper">

// ✅ React JSX
<div className="nav-wrapper">
```

**Reason**: `class` is a reserved word in JavaScript.

### Flexbox Properties Used

**display: flex**:

- Converts container into flex container
- Child elements become flex items

**justify-content: space-between**:

- First item at start
- Last item at end  
- Remaining space distributed between them

**padding: 30px**:

- Internal space on all sides
- Separates content from browser edges

---

## 📋 VERIFICATION

### Browser Testing

**DevTools inspection**:

1. **Right-click** on navigation → Inspect

2. **Verify structure**:
   
   ```html
   <div class="nav-wrapper">
     <div class="left-side">...</div>
     <div class="right-side">...</div>
   </div>
   ```

### Expected Visual Result

**Layout achieved**:

- **Links grouped** on left side
- **Name** on right side
- **Automatic space** between sections
- **Uniform padding** around

---

## 🎨 EXTENDED CONTENT

### Alternative Flexbox Approaches

**Other justify-content options**:

```scss
// Centred
justify-content: center;

// Start
justify-content: flex-start;

// Uniform distribution
justify-content: space-around;
justify-content: space-evenly;
```

### Responsive Considerations

**For mobile**:

```scss
.nav-wrapper {
    @media (max-width: 768px) {
        flex-direction: column;
        text-align: center;
    }
}
```

---
