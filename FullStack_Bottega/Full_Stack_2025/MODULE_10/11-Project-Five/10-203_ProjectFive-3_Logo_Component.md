# 10-203: Setting Up Logo Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/setting-up-logo-component)**

[setup logo component and corresponding styles · bottega-code-school/DailySmartyUI@500449c · GitHub](https://github.com/bottega-code-school/DailySmartyUI/commit/500449c1c4ed27498aedc066dba422580b61a547)

---

## 🎯 Objectives

**Create reusable Logo component**:

- **Component creation** - class-based React component
- **Image integration** - daily smarty logo asset
- **Styling setup** - SCSS for size control
- **App integration** - import and render in main app

---

## 🛠️ Logo Component Implementation

### 1. Create Logo Component

**File**: `src/components/logo.js`

```javascript
import React, { Component } from 'react';

class Logo extends Component {
    render() {
        return (
            <div className="logo-main">
                <img 
                    alt="daily smarty ui image logo big" 
                    src="/assets/ds_circle_logo.png"
                />
            </div>
        );
    }
}

export default Logo;
```

### 2. Add Logo Styles

**File**: `src/style/main.scss`

```scss
.logo-main {
    img {
        width: 105px;
        height: 105px;
    }
}
```

### 3. Import Logo in App

**File**: `src/components/app.js`

```javascript
import React, { Component } from 'react';
import Logo from './logo';

export default class App extends Component {
    render() {
        return (
            <div>
                <div>
                    <Logo />
                </div>
            </div>
        );
    }
}
```

### 4. Add Logo Asset

**Location**: `static/assets/ds_circle_logo.png`

- **Download from guide** - logo image provided
- **Place in assets folder** - referenced as `/assets/`

---

## 📧 Technical Concepts

### Reusable Component Design

**Why reusable**:

- **Multiple screens** - logo appears in search and results pages
- **Consistent branding** - same logo across application
- **Easy maintenance** - changes in one place

### Asset Management

**Static assets path**:

- **Root reference**: `/assets/` - no need to mention `static/`
- **Image naming**: exact match required - `ds_circle_logo.png`
- **Alt text**: accessibility and debugging when image doesn't load

### SCSS Nested Selectors

**Advantage of nested styling**:

```scss
.logo-main {
    img {  // Targets img inside .logo-main only
        width: 105px;
        height: 105px;
    }
}
```

**Benefits**:

- **Specificity control** - styles don't affect other images
- **Organisation** - related styles grouped together
- **Maintainability** - easy to find and modify

### Size Considerations

**Design matching process**:

- **Designer specs**: 100px x 100px from mockup
- **Adjustment factor**: 105px to compensate for visual difference
- **Real app vs design** - slight adjustments for better appearance

---

## 📋 Verification

**Expected results**:

1. **Logo displays** - owl image visible in browser
2. **Correct size** - 105px square, not oversized
3. **Alt text fallback** - if image fails to load
4. **No console errors** - clean component implementation

**Troubleshooting**:

- **Image not loading** - check filename match exactly
- **Size issues** - verify CSS applied correctly
- **Component not rendering** - confirm import in App.js

---
