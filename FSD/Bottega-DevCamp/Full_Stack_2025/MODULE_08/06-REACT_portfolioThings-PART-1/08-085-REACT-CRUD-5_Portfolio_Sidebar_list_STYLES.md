# 08-085 - Finalising Portfolio Manager Sidebar List Styles

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/finalizing-portfolio-manager-sidebar-list-styles)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at d3464508423f8c91ff30e3941a9a14f24d812474](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/d3464508423f8c91ff30e3941a9a14f24d812474)

---

## 🎯 OBJECTIVES

**Create professional styles for sidebar**:

- **Class names** appropriate for styling
- **Image control** - width 100% to fit
- **Appropriate padding** for spacing
- **Typography styling** for titles
- **Modular SCSS** dedicated file

**Visual result**:

- Clean and professional sidebar
- Images contained in space
- Readable text with good contrast

---

## 🛠️ IMPLEMENTATION

### Add Class Names to Component

**File**: `src/components/portfolio/portfolio-sidebar-list.js`

```javascript
import React from "react";

const PortfolioSidebarList = props => {
  const portfolioList = () => {
    return props.data.map(portfolioItem => {
      return (
        <div className="portfolio-item-thumb">
          <div className="portfolio-thumb-img">
            <img src={portfolioItem.thumb_image_url} />
          </div>
          <h1 className="title">{portfolioItem.name}</h1>
          <h2>{portfolioItem.id}</h2>
        </div>
      );
    });
  };

  return (
    <div className="portfolio-sidebar-list-wrapper">
      {portfolioList()}
    </div>
  );
};

export default PortfolioSidebarList;
```

### Create Dedicated SCSS File

**Create**: `src/style/portfolio-sidebar.scss`

```scss
.portfolio-sidebar-list-wrapper {
  .portfolio-item-thumb {
    padding: 21px;

    .portfolio-thumb-img {
      img {
        width: 100%;
      }
    }

    .title {
      color: $offwhite;
    }
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
@import "./portfolio-sidebar.scss";
```

---

## 🔧 CONCEPTS

### Class Naming Strategy

**Structure of names**:

```scss
.portfolio-sidebar-list-wrapper    // Main container
  .portfolio-item-thumb            // Each individual item
    .portfolio-thumb-img           // Image wrapper
    .title                         // Project title
```

**Why this naming**:

- **Descriptive** - clear purpose of each class
- **Hierarchical** - reflects DOM structure
- **Modular** - easy to maintain and modify
- **Specific** - avoids conflicts with other styles

### Image Control with CSS

**width: 100% strategy**:

```scss
.portfolio-thumb-img {
  img {
    width: 100%;
  }
}
```

**Why it works**:

- **Responsive behaviour** - adapts to container
- **Aspect ratio maintained** - no distortion
- **Container control** - parent padding controls spacing
- **Overflow prevention** - images don't escape sidebar

### Nested SCSS Architecture

**Nesting advantages**:

```scss
.portfolio-sidebar-list-wrapper {
  .portfolio-item-thumb {
    // Styles contained within parent scope
    .portfolio-thumb-img {
      // Clear and hierarchical nesting
    }
  }
}
```

**Compiles to CSS**:

```css
.portfolio-sidebar-list-wrapper .portfolio-item-thumb {
  padding: 21px;
}

.portfolio-sidebar-list-wrapper .portfolio-item-thumb .portfolio-thumb-img img {
  width: 100%;
}
```

### SCSS Variables in Action

**$offwhite variable usage**:

```scss
.title {
  color: $offwhite;
}
```

**Benefits**:

- **Consistency** - same colour across app
- **Maintainability** - change in one location
- **Readability** - descriptive name vs hex code

---

## ✔️ VERIFICATION

### Visual Results Expected

**Before styling**:

- Huge images breaking layout
- No spacing between elements
- Text with default colours

**After styling**:

- **Images contained** - width 100% of container
- **Uniform spacing** - consistent 21px padding
- **Readable text** - offwhite colour on charcoal background
- **Clean layout** - elements organised vertically

### Testing Responsive Behaviour

**Verify**:

1. **Resize browser window** - images adapt
2. **Check spacing** - padding maintains consistency
3. **Typography contrast** - text readable on background
4. **No overflow** - content within right-column

### DevTools Inspection

**Verify in DevTools**:

- **Class names applied** correctly
- **SCSS compilation** - CSS styles generated
- **Variables resolved** - $offwhite converted to hex
- **Nested selectors** - correct structure

### ID Element Note

**Why ID remains unstyled**:

- **Temporary reference** - only for development
- **Future removal** - will be used for edit features
- **Navigation purposes** - portfolio detail links
- **Not production element** - will be replaced

---
