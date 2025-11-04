# 08-054 - Build Navigation Link Wrapper Styles

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-navigation-link-wrapper-styles

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/0f2e03fc606b8345ba5fee4af8e27d5e4bef5ed6)

---

## 🎯 STYLING INDIVIDUAL LINKS

### Final Design Analysis

**Target effects**:

- **Animated hover underline** (not traditional CSS underline)
- **Border sliding effect** with transition
- **Spacing** between links
- **Professional colour styling**

---

## 🛠️ STEP-BY-STEP IMPLEMENTATION

### 1. Add Wrapper Divs to Links

**File**: `src/components/navigation/navigation-container.js`

**Wrap each NavLink**:

```javascript
<div className="left-side">
    <div className="nav-link-wrapper">
        <NavLink exact to="/" activeClassName="nav-link-active">
            Home
        </NavLink>
    </div>

    <div className="nav-link-wrapper">
        <NavLink to="/about-me" activeClassName="nav-link-active">
            About
        </NavLink>
    </div>

    <div className="nav-link-wrapper">
        <NavLink to="/contact" activeClassName="nav-link-active">
            Contact
        </NavLink>
    </div>

    <div className="nav-link-wrapper">
        <NavLink to="/blog" activeClassName="nav-link-active">
            Blog
        </NavLink>
    </div>
</div>
```

### 2. Fix Layout with Flexbox

**Problem**: Divs stack vertically by default

**Solution** in `navigation.scss`:

```scss
.nav-wrapper {
    display: flex;
    justify-content: space-between;
    padding: 30px;

    .left-side {
        display: flex; // Keeps links horizontal
    }
}
```

### 3. Base Styles for nav-link-wrapper

**In `navigation.scss`**:

```scss
.nav-link-wrapper {
    height: 22px;
    border-bottom: 1px solid transparent; // Prevents jumping
    transition: 0.5s ease-in-out;         // Smooth animation

    a {
        color: black;
        text-decoration: none;
    }

    &:hover {
        border-bottom: 1px solid black;
    }
}
```

---

## 🔧 TECHNICAL CONCEPTS

### Why Wrapper Divs?

**Technical reasons**:

- **Border control** - not traditional CSS underline
- **Animation container** - for hover effects
- **Height control** - consistent spacing
- **Future flexibility** - more styling control

### Border vs Text-decoration

**Border approach** (used):

- **More control** over position and animation
- **Smooth transitions** possible
- **Customisable thickness**

**Text-decoration underline** (avoided):

- **Limited** customisation
- **Fixed position** under text
- **Animation limitations**

### Transparent Border Trick

**Problem without initial border**:

```scss
// Without transparent border - elements "jump"
.nav-link-wrapper:hover {
    border-bottom: 1px solid black; // Adds height suddenly
}
```

**Solution with transparent border**:

```scss
// Initial transparent border - no jumping
.nav-link-wrapper {
    border-bottom: 1px solid transparent; // Height already reserved
}
```

---

## 📋 VERIFICATION

### Effects Testing

**Verify**:

1. **Horizontal links** - not stacked vertically
2. **Hover effect** - border appears smoothly
3. **Smooth transition** - 0.5s ease-in-out visible
4. **No jumping** - elements don't change position

### DevTools Inspection

**Expected structure**:

```html
<div class="nav-wrapper">
  <div class="left-side">
    <div class="nav-link-wrapper">
      <a href="/">Home</a>
    </div>
    <!-- more nav-link-wrappers... -->
  </div>
</div>
```

---

## 🎨 EXTENDED CONTENT

### Transition Alternatives

**Different timing functions**:

```scss
transition: 0.3s ease;          // Faster
transition: 0.8s ease-in-out;   // Slower
transition: 0.5s cubic-bezier(0.4, 0, 0.2, 1); // Custom curve
```

### Advanced Hover Effects

**Multiple properties**:

```scss
&:hover {
    border-bottom: 1px solid black;
    color: #666;                     // Colour change
    transform: translateY(-2px);     // Subtle lift
}
```

---
