# 08-056 - Finalise Navigation Links Styles

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/finalizing-navigation-link-styles

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/c83b5c2db0b51a27f92b015f079243ece1bdfedf)

---

## 🎯 COMPLETE PROFESSIONAL NAVIGATION

### Final Objectives

**Features to implement**:

- **Spacing** between links
- **Typography** - uppercase and font-size
- **Active states** - current page highlighted
- **Debug process** - resolve CSS conflicts

---

## 🛠️ FINAL IMPLEMENTATION

### 1. Add Spacing and Typography

**File**: `src/style/navigation.scss`

**Additional styles**:

```scss
.nav-link-wrapper {
    height: 22px;
    border-bottom: 1px solid transparent;
    transition: 0.5s ease-in-out;
    margin-right: 20px;        // Spacing between links
    text-transform: uppercase; // All in uppercase
    font-size: 0.9rem;        // 90% of base size

    a {
        color: $grey;
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

### 2. Implement Active States

**Active className in React Router**:

```javascript
// Already configured in navigation-container.js
<NavLink exact to="/" activeClassName="nav-link-active">
    Home
</NavLink>
```

**Styles for active state**:

```scss
.nav-link-wrapper {
    // ... existing styles

    .nav-link-active {
        border-bottom: 1px solid black;
        color: black;
        padding-bottom: 5px; // Fix for double border
    }
}
```

---

## 🐛 DEBUGGING PROCESS DEMONSTRATED

### Problem: Active State Not Working

**Symptoms**:

- Border appears but text colour doesn't change
- DevTools shows `nav-link-active` applied

### Debug Step-by-Step

**1. Inspect HTML structure**:

```html
<div class="nav-link-wrapper">
    <a class="nav-link-active" href="/about">About</a>
</div>
```

**2. Identify selector problem**:

```scss
// ❌ Problem: incorrect selector
.nav-link-wrapper {
    .nav-link-active {
        a { color: black; } // No 'a' inside .nav-link-active
    }
}
```

**3. Solution - simplify selector**:

```scss
// ✅ Solution: direct selector
.nav-link-wrapper {
    .nav-link-active {
        color: black;        // Direct, without nested 'a'
        border-bottom: 1px solid black;
    }
}
```

### Double Border Fix

**Problem**: Hover + Active = 2 overlapped borders

**Solution**: Add padding to separate:

```scss
.nav-link-active {
    padding-bottom: 5px; // Separates borders
}
```

---

## 📋 VERIFICATION

### Complete Testing

**Functionalities to verify**:

1. **Spacing** - 20px between links
2. **Uppercase** - all links in uppercase  
3. **Font size** - 0.9rem applied
4. **Hover effects** - colour + black border
5. **Active states** - current page highlighted
6. **No double borders** - padding fix works

### Visual Result

**Professional navigation**:

- Uniformly spaced links
- Consistent typography  
- Smooth hover effects
- Current page clearly identified

---

## 🔧 COMPLETE FUNCTIONAL CODE

### Final navigation.scss

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
    margin-right: 20px;
    text-transform: uppercase;
    font-size: 0.9rem;

    a {
        color: $grey;
        text-decoration: none;

        &:hover {
            color: black;
        }
    }

    &:hover {
        border-bottom: 1px solid black;
    }

    .nav-link-active {
        border-bottom: 1px solid black;
        color: black;
        padding-bottom: 5px;
    }
}
```

---

## 🎓 DEBUGGING LESSONS

### Professional Debugging Approach

**Systematic process**:

1. **Identify specific symptoms**
2. **Inspect actual HTML** structure
3. **Verify CSS selectors** - do they match HTML?
4. **Test solutions** incrementally
5. **Validate complete fix**

### Common CSS Issues

**Selector specificity conflicts**:

- Nested selectors vs direct selectors
- Order of CSS rules matters
- Active states overridden by other rules

---
