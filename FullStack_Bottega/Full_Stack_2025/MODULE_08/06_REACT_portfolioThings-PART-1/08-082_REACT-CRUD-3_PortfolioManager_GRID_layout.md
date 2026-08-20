# 08-082 - Portfolio Manager Grid Layout Implementation

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/portfolio-manager-grid-layout-implementation)**

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/f7ac087daeac8c8f2b8c5007fcd29f2e061b1d06)

---

## 🎯 OBJECTIVES

**Create two-column layout for Portfolio Manager**:

- **Left column (3fr)**: Space for form and uploads
- **Right column (1fr)**: Sidebar for portfolio items
- **CSS Grid** with 3:1 proportions
- **Background colours** to distinguish visually
- **Base structure** for forms and sidebar

**Layout target**:

- Left column wider for form elements
- Right column narrower for items list
- Responsive distribution using fractional units

---

## 🛠️ IMPLEMENTATION

### Portfolio Manager JSX Structure

**File**: `src/components/pages/portfolio-manager.js`

```javascript
import React, { Component } from "react";

export default class PortfolioManager extends Component {
  render() {
    return (
      <div className="portfolio-manager-wrapper">
        <div className="left-column">
          <h1>Portfolio form....</h1>
        </div>

        <div className="right-column">
          <h1>Portfolio sidebar....</h1>
        </div>
      </div>
    );
  }
}
```

### Create Dedicated SCSS File

**Create**: `src/style/portfolio-manager.scss`

```scss
.portfolio-manager-wrapper {
  display: grid;
  grid-template-columns: 3fr 1fr;

  .left-column {
    background-color: $offwhite;
  }

  .right-column {
    background-color: $charcoal;
  }
}
```

### Import in Main SCSS

**File**: `src/style/main.scss`

```scss
@import "./variables.scss";
@import "./base.scss";
@import "./navigation.scss";
@import "./portfolio.scss";
@import "./portfolio-manager.scss";
```

---

## 🔧 CONCEPTS

### CSS Grid Fractional Units

**Grid template columns `3fr 1fr`**:

```scss
// 3fr = 3 parts of available space
// 1fr = 1 part of available space 
// Total: 4 parts
// Left column: 75% of space (3/4)
// Right column: 25% of space (1/4)
```

**Why fractional units**:

- **Automatic responsive** - adapts to any screen size
- **Proportional** - maintains ratio independent of width
- **Flexible** - easy to change proportions by changing numbers

### Nested SCSS Selectors

**Nested structure**:

```scss
.portfolio-manager-wrapper {
  display: grid;

  .left-column {
    // Inside .portfolio-manager-wrapper .left-column
  }

  .right-column {
    // Inside .portfolio-manager-wrapper .right-column  
  }
}
```

**Compiles to CSS**:

```css
.portfolio-manager-wrapper {
  display: grid;
}

.portfolio-manager-wrapper .left-column {
  background-color: #f6f6f6;
}

.portfolio-manager-wrapper .right-column {
  background-color: #42454a;
}
```

### Background Colours for Testing

**SCSS variables used**:

- `$offwhite`: Light colour for left column
- `$charcoal`: Dark colour for right column

**Temporary purpose**:

- **Visualise structure** - clearly see division
- **Debug layout** - confirm grid works
- **Will change later** based on final design

---

## ✔️ VERIFICATION

### Testing Grid Layout

**Verify in browser**:

1. **Navigate to** `/portfolio-manager`
2. **See two columns** clearly differentiated
3. **Left column** wider (3x)
4. **Right column** narrower (1x)
5. **Background colours** applied correctly

### Expected Visual Result

**Current layout**:

- Two horizontal columns
- **Not top-to-bottom** because only h1 tags
- Left column noticeably wider
- Background colours distinguishing sections

**Generated HTML structure**:

```html
<div class="portfolio-manager-wrapper">
  <div class="left-column">
    <h1>Portfolio form....</h1>
  </div>
  <div class="right-column">
    <h1>Portfolio sidebar....</h1>
  </div>
</div>
```

### DevTools Inspection

**Verify in DevTools**:

- **Grid applied** correctly
- **Grid template columns** showing 3fr 1fr
- **Background colours** from variables
- **Responsive behaviour** when resizing

---
