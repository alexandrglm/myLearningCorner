# 09-055 - Integrate SCSS Variables to Manage App Style Guide

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/integrating-scss-variables-manage-app-style-guide

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/a36de347f79f5e7e8dfe5bacb6a883db7f1d169a)

---

## 🎯 SCSS VARIABLES FOR CONSISTENCY

### Hardcoded Values Problem

**Without variables**:

```scss
color: #8a8a8a; // What colour was this?
// In another file...
border: 1px solid #8a8a8a; // Does it match the previous one?
```

**With variables**:

```scss
color: $grey; // Clear and reusable
border: 1px solid $grey; // Consistent
```

### Advantages of SCSS Variables

- **Easy memorisation** - `$grey` vs `#8a8a8a`
- **Consistency** - same colour throughout app
- **Maintenance** - central change propagates
- **Centralised style guide**

---

## 🛠️ VARIABLES IMPLEMENTATION

### 1. Create Variables File

**Create**: `src/style/variables.scss`

**Colour palette**:

```scss
$teal: #26bfd4;
$dark-teal: #207b88;
$charcoal: #42454a;
$offwhite: #f6f6f6;
$blue: #008dff;
$warning: #922a2a;
$grey: #8a8a8a;
```

### 2. Import Variables in Main

**File**: `src/style/main.scss`

**Order matters** - variables first:

```scss
@import "./variables.scss";
@import "./base.scss";
@import "./navigation.scss";
```

### 3. Use Variables in Navigation

**File**: `src/style/navigation.scss`

**Implement colour variables**:

```scss
.nav-wrapper {
    display: flex;
    justify-content: space-between;
    padding: 30px;

    .left-side {
        display: flex;
    }
}

.nav-link-wrapper {
    height: 22px;
    border-bottom: 1px solid transparent;
    transition: 0.5s ease-in-out;

    a {
        color: $grey;              // Variable instead of #8a8a8a
        text-decoration: none;

        &:hover {
            color: black;
        }
    }

    &:hover {
        border-bottom: 1px solid black;
    }
}
```

---

## 🔧 TECHNICAL CONCEPTS

### When to Use Variables vs Built-in Colours

**Variables recommended**:

```scss
color: $grey;      // Specific design colour
color: $teal;      // Brand colour
```

**Appropriate built-in colours**:

```scss
color: black;      // Standard black
color: white;      // Standard white  
color: transparent; // Transparent
```

### Import Order

**⚠️ Critical - Variables FIRST**:

```scss
@import "./variables.scss";  // MUST go first
@import "./base.scss";       // Can use variables
@import "./navigation.scss"; // Can use variables
```

### Nested Hover States

**Hover effects structure**:

```scss
.nav-link-wrapper {
    a {
        color: $grey;

        &:hover {
            color: black; // Hover on link
        }
    }

    &:hover {
        border-bottom: 1px solid black; // Hover on wrapper
    }
}
```

---

## 📋 VERIFICATION

### Variables Testing

**Steps**:

1. **Save all** SCSS files
2. **Refresh browser** - see grey colour on links
3. **Hover test** - text and border change
4. **DevTools** - confirm colour applied

### Expected Result

**Visual behaviour**:

- **Grey links** by default ($grey colour)
- **Hover** - black text + black border
- **Smooth transition** - smooth animation

---

## 🎨 EXTENDED CONTENT

### Colour Palette Strategy

**Design system approach**:

```scss
// Primary colours
$primary: $teal;
$secondary: $charcoal;

// Utility colours  
$success: #28a745;
$danger: $warning;
$info: $blue;

// Neutral colours
$light: $offwhite;
$dark: $charcoal;
```

### Advanced Variable Usage

**Computed values**:

```scss
$base-font-size: 16px;
$small-font: $base-font-size * 0.875; // 14px
$large-font: $base-font-size * 1.25;  // 20px
```

---
