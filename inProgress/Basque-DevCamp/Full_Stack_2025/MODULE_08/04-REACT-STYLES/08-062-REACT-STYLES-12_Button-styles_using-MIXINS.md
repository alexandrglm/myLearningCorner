# 08-062 - Using Mixins to Create Button Styles

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/using-mixins-create-button-styles

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/2b96e0acc028e30b3bf50f232f33e3f9ab812ff4)

---

## 🎯 GUIDE OBJECTIVES

### Finalise Portfolio Homepage

**Target state**:

- Reorganise filter buttons within the grid
- Remove "Welcome to my portfolio" title
- Create reusable button styling system with SCSS Mixins
- Buttons that automatically adapt to 3-column grid

### What are SCSS Mixins?

**Mixins** = Reusable style templates:

- **Define once** - use in multiple places
- **Parameterisable** - can accept variables
- **Override capability** - modify specific properties
- **Consistency** - same base styles across the app

---

## 🛠️ STEP-BY-STEP IMPLEMENTATION

### 1. Reorganise Portfolio Container Structure

**File**: `src/components/portfolio-container.js`

**Clean and consolidate JSX**:

```javascript
render() {
    if (this.state.isLoading) {
        return <div>Loading...</div>;
    }

    return (
        <div className="portfolio-items-wrapper">
            <button 
                className="btn"
                onClick={() => this.handleFilter('eCommerce')}
            >
                eCommerce
            </button>

            <button 
                className="btn"
                onClick={() => this.handleFilter('Scheduling')}
            >
                Scheduling
            </button>

            <button 
                className="btn"
                onClick={() => this.handleFilter('Enterprise')}
            >
                Enterprise
            </button>

            {this.portfolioItems()}
        </div>
    );
}
```

**Changes made**:

- **Remove** `<h2>{this.state.pageTitle}</h2>`
- **Move buttons** into `portfolio-items-wrapper`
- **Add className="btn"** to all buttons
- **Eliminate** extra div wrapper - return only one element

### 2. Create Mixins File

**Create**: `src/style/mixins.scss`

**Base mixin for buttons**:

```scss
@mixin base-btn {
    cursor: pointer;
    height: 42px;
    font-size: 1em;
    font-weight: 500;
    border: 1px solid transparent;
    transition: all 0.5s ease-in-out;
    background-color: $teal;
    color: white;

    &:active,
    &:focus {
        outline: none;
    }

    &:hover {
        background-color: $dark-teal;
    }
}
```

### 3. Create Button Styles File

**Create**: `src/style/button.scss`

**Implement mixin**:

```scss
.btn {
    @include base-btn();
}
```

### 4. Update Main SCSS with Imports

**File**: `src/style/main.scss`

**Critical import order**:

```scss
@import "./variables.scss";   // FIRST - variables available
@import "./mixins.scss";      // SECOND - mixins use variables  
@import "./base.scss";
@import "./navigation.scss";
@import "./portfolio.scss";
@import "./button.scss";      // LAST - uses mixins and variables
```

---

## 🔧 TECHNICAL CONCEPTS

### Why is Import Order Critical?

**CSS = Cascading Style Sheets**:

- **Variables** must be available before use
- **Mixins** can reference variables
- **Button styles** can use both variables and mixins

**Dependency hierarchy**:

```
Variables → Mixins → Components
```

### Anatomy of the Mixin

**Each property explained**:

```scss
@mixin base-btn {
    cursor: pointer;              // Hand cursor on hover
    height: 42px;                // Consistent height 
    font-size: 1em;             // Base font size
    font-weight: 500;            // Medium weight (not too bold)
    border: 1px solid transparent; // Placeholder border (no jumping)
    transition: all 0.5s ease-in-out; // Smooth animations
    background-color: $teal;     // Primary brand colour
    color: white;                // White text for contrast

    &:active,
    &:focus {
        outline: none;           // Remove ugly default focus outline
    }

    &:hover {
        background-color: $dark-teal; // Darker shade on hover
    }
}
```

### CSS Grid Auto-fitting

**Buttons automatically**:

- Position in the first 3 grid positions
- Portfolio items fill remaining positions
- Grid spans full width for each element
- **No additional CSS needed**

---

## ✔️ RESULT VERIFICATION

### Testing Layout

**Expected visual result**:

1. **Three buttons** in first grid row
2. **Portfolio items** in subsequent rows  
3. **Responsive buttons** - adapt to column width
4. **Hover effects** - smooth colour change
5. **Filtering functionality** maintained

### Testing Mixin System

**Verify reusability**:

```scss
// Future buttons can use same mixin
.secondary-btn {
    @include base-btn();
    background-color: $grey;     // Override only colour

    &:hover {
        background-color: $charcoal;
    }
}
```

### Known Issue - Filter Reset

**Issue identified**:

- Click "eCommerce" → shows only eCommerce items
- Click "Scheduling" → shows nothing (state already filtered)
- **Future solution**: Reset functionality or API re-fetch

**For now**: Refresh page for manual reset

---

## 🎨 DESIGN CONCEPTS

### Transparent Border Technique

**Why `border: 1px solid transparent`?**:

- **Prevents jumping** when hover adds border
- **Reserves space** for border before it appears
- **Smooth transitions** without layout shifts

### Variables in Mixins

**System flexibility**:

```scss
// Mixin can use variables
@mixin base-btn {
    background-color: $teal;  // Variable reference
}

// Variables can change globally
$teal: #26bfd4; // Entire system updates
```

---

## 🚀 EXTENDED CONTENT

### Advanced Mixin Patterns

**Parameterised mixins**:

```scss
@mixin button-variant($bg-color, $hover-color) {
    @include base-btn();
    background-color: $bg-color;

    &:hover {
        background-color: $hover-color;
    }
}

// Usage
.primary-btn {
    @include button-variant($teal, $dark-teal);
}

.danger-btn {
    @include button-variant($warning, darken($warning, 10%));
}
```

### Conditional Mixins

**Responsive mixins**:

```scss
@mixin base-btn($mobile: false) {
    @if $mobile {
        height: 36px;
        font-size: 0.9em;
    } @else {
        height: 42px;
        font-size: 1em;
    }
}
```

---

## 📋 DEBUGGING MIXINS

### Common Issues

**Mixin not applied**:

- Verify mixins.scss is imported
- Check that variables are available
- Confirm `@include` syntax correct

**Conflicting styles**:

- Inspect element to see which CSS rule wins
- Check selector specificity
- Verify import order in main.scss

### DevTools for Mixins

**Debugging workflow**:

1. **Inspect element** → see compiled CSS
2. **Check sources** → see which file contributes styles  
3. **Verify variables** → confirm correct values

---
