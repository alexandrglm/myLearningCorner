# 08-060 - Overlaying Text and Images on Background Images in React

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/overlaying-text-images-background-image-react



[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/441d35c8cdeff0d532c2c7359a4c72ef72e6e3e1)

---

## 🎯 GUIDE OBJECTIVES

### Problem to Solve

**Current state**:

- Background images working correctly
- Need to overlay content on top of images
- Logo and description should appear over background

### Desired Final Effect

**Target design**:

- Logo centred over background image
- Description appears only on hover with fade-in
- Responsive layout maintained
- Absolute positioning for perfect overlay

---

## 🛠️ STEP-BY-STEP IMPLEMENTATION

### 1. Restructure Portfolio Item JSX

**File**: `src/components/portfolio-item.js`

**Clean and rebuild structure**:

```javascript
import React from 'react';

const PortfolioItem = (props) => {
    const { id, description, thumb_image_url, logo_url } = props.item;

    return (
        <div className="portfolio-item-wrapper">
            <div 
                className="portfolio-img-background"
                style={{
                    backgroundImage: "url(" + thumb_image_url + ")"
                }}
            />

            <div className="img-text-wrapper">
                <div className="logo-wrapper">
                    <img src={logo_url} />
                </div>

                <div className="subtitle">
                    {description}
                </div>
            </div>
        </div>
    );
}

export default PortfolioItem;
```

### 2. Debugging Logo URL Issue

**⚠️ Common error detected**:

- Variable `logo` vs `logo_url` 
- Use React DevTools for debugging

**Debugging process**:

1. **Open React DevTools**
2. **Navigate to portfolio-item component**
3. **Inspect props.item** 
4. **Verify correct name**: `logo_url` (not `logo`)

### 3. Implement Overlay Styles

**File**: `src/style/portfolio.scss`

**Main styles - img-text-wrapper**:

```scss
.portfolio-items-wrapper {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
}

.portfolio-item-wrapper {
    position: relative; // Required for absolute positioning

    .portfolio-img-background {
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
        height: 350px;
        width: 100%;
    }

    .img-text-wrapper {
        position: absolute;
        top: 0;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 100%;
        text-align: center;
        padding-left: 100px;
        padding-right: 100px;
    }
}
```

### 4. Styles for Subtitle with Transition

**Fade-in/out effect for description**:

```scss
.portfolio-item-wrapper {
    // ... previous styles

    .subtitle {
        transition: 1s ease-in-out;
        color: transparent; // Invisible by default
    }

    // Hover effect - separate selector for better maintenance
    .img-text-wrapper:hover .subtitle {
        color: $teal; // Uses SCSS variable
        font-weight: 400;
    }
}
```

### 5. Logo Styling and Spacing

**Control logo size and spacing**:

```scss
.portfolio-item-wrapper {
    // ... previous styles

    .logo-wrapper {
        img {
            width: 50%;
            margin-bottom: 20px;
        }
    }
}
```

---

## 🔧 TECHNICAL CONCEPTS

### Position Absolute vs Relative

**Why position: relative on parent?**:

- **Containment** - absolute child positions relative to parent
- **CSS rule** - absolute requires relative parent
- **Layout control** - prevents overlay from escaping container

**Position absolute on overlay**:

- **Removes from document flow** - does not affect other elements
- **Full control** - exact top, left, width, height
- **Layering** - appears over background image

### Flexbox on Overlay

**Perfect centring**:

```scss
display: flex;
flex-direction: column;  // Stack logo + text vertically
justify-content: center; // Centre vertically in container
align-items: center;     // Centre horizontally
```

### Transition Effects

**Smooth fade in/out**:

- **Initial state** - `color: transparent`
- **Hover state** - `color: $teal`
- **Transition** - `1s ease-in-out` for smooth animation

---

## ✔️ RESULT VERIFICATION

### Expected Visual Result

**Functionality achieved**:

- Logo centred over each background image
- Description invisible initially
- Hover reveals description with smooth fade-in
- Grid layout maintained correctly

### Testing Steps

1. **Hover over items** - description appears smoothly
2. **Logo visibility** - white logos can be difficult to see
3. **Grid maintenance** - three columns preserved
4. **Responsive behaviour** - side padding maintains readability

### Debugging Tips

**If logos don't appear**:

- Check DevTools for `<img>` tag
- Verify `src` attribute has valid URL
- White logos on light background = invisible

**If overlay doesn't work**:

- Verify `position: relative` on parent
- Check `position: absolute` on overlay
- Confirm height: 100% on overlay

---

## 🎨 DESIGN CONCEPTS

### Spacing and Padding Strategy

**Horizontal padding**:

- `padding-left: 100px` and `padding-right: 100px`
- **Prevents** text overflow on small screens
- **Maintains readability** across all sizes

**Vertical centring**:

- `justify-content: center` centres vertically
- **Flexible** - works with any content height
- **Responsive** automatically

### Colour Strategy

**Transparent initial state**:

- **UX benefit** - clean appearance without hover
- **Performance** - no content shift, only colour change
- **Accessibility** - clear visual feedback on interaction

---

## 🚀 EXTENDED CONTENT

### Alternative Overlay Patterns

**Background overlay with semi-transparency**:

```scss
.img-text-wrapper {
    background: rgba(0, 0, 0, 0.5); // Semi-transparent background
    color: white;
}
```

**Transform animations**:

```scss
.subtitle {
    transform: translateY(20px);
    transition: all 0.3s ease;
}

.img-text-wrapper:hover .subtitle {
    transform: translateY(0);
    opacity: 1;
}
```

### SCSS Nesting Best Practices

**Avoid deep nesting**:

```scss
// ❌ Too deep
.portfolio-item-wrapper {
    .img-text-wrapper {
        .logo-wrapper {
            img { ... } // 4 levels deep
        }
    }
}

// ✅ Separate selector
.img-text-wrapper:hover .subtitle {
    color: $teal; // Reset to upper level
}
```

---

## 📋 EXPLAINING DEBUGGING WORKFLOW

### React DevTools Process

**Step by step for debugging props**:

1. **F12** → React tab
2. **Select component** with inspector
3. **Navigate** up component tree to PortfolioItem
4. **Expand props.item** object
5. **Verify** exact property names

**Common error solved**:

- Assumed `logo` property name
- **Reality**: property is `logo_url`
- **Solution**: update destructuring and JSX

---
