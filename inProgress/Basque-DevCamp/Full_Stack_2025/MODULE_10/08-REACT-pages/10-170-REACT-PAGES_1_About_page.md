# 10-170: Building About Page Styles - React Portfolio

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-about-page-styles-react-portfolio)**

[Building About Page Styles for React Portfolio](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-about-page-styles-react-portfolio)

---

## 🎯 Objectives

**Design goal**:

- **Large image** occupying 50% of width, 100% of height on left side
- **Centred bio** in white space on right side
- **Split screen layout** professional using CSS Grid
- **No vertical scroll** - everything visible on one screen

**Skills applied**:

- **CSS Grid** for 50/50 split layout
- **Background images** with advanced styling
- **Flexbox centring** for content
- **Viewport calculations** for exact height

---

## 🛠️ Implementation

### 1. Create Universal Layout File

**Create**: `src/style/layouts.scss`

**Add import in**: `src/style/main.scss`

```scss
@import "./base.scss";
@import "./navigation.scss";
@import "./layouts.scss";
```

### 2. Base Styles of Content Page Wrapper

**File**: `src/style/layouts.scss`

```scss
.content-page-wrapper {
    width: 100vw;
    display: grid;
    grid-template-columns: 1fr 1fr;
    height: 100vh; // Temporary - we'll intentionally create a problem
}
```

**Why height: 100vh doesn't work**:

- **100vh** = complete viewport height
- **Navigation bar** takes up an additional 84px 
- **Result**: page longer than screen, scroll appears

### 3. HTML Structure of About Component

**File**: `src/components/pages/about.js`

```javascript
import React from "react";

export default function() {
    return (
        <div className="content-page-wrapper">
            <div className="left-column"></div>
            <div className="right-column">
                Maecenas faucibus mollis interdum. Integer posuere erat a ante venenatis dapibus posuere velit aliquet. Sed posuere consectetur est at lobortis. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. Aenean lacinia bibendum nulla sed consectetur. Maecenas sed diam eget risus varius blandit sit amet non magna. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Donec id elit non mi porta gravida at eget metus. Donec sed odio dui. Cras mattis consectetur purus sit amet fermentum. Etiam porta sem malesuada magna mollis euismod. Nulla vitae elit libero, a pharetra augue. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent commodo cursus magna, vel scelerisque nisl consectetur et. Nullam quis risus eget urna mollis ornare vel eu leo. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Vestibulum id ligula porta felis euismod semper.
            </div>
        </div>
    );
}
```

### 4. Add Personal Image

**Location**: `static/assets/images/bio/headshot.jpg`

**Import in About component**:

```javascript
import React from "react";
import profilePicture from "../../../static/assets/images/bio/headshot.jpg";

export default function() {
    return (
        <div className="content-page-wrapper">
            <div 
                className="left-column"
                style={{
                    background: "url(" + profilePicture + ") no-repeat",
                    backgroundSize: "cover", 
                    backgroundPosition: "center"
                }}
            />
            <div className="right-column">
                {/* Lorem ipsum content... */}
            </div>
        </div>
    );
}
```

### 5. Centre Content of Right Column

**Update**: `src/style/layouts.scss`

```scss
.content-page-wrapper {
    width: 100vw;
    display: grid;
    grid-template-columns: 1fr 1fr;
    height: 100vh;

    .right-column {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        padding: 100px;
    }
}
```

### 6. Fix Height Problem with calc()

**Final solution**:

```scss
.content-page-wrapper {
    width: 100vw;
    display: grid;
    grid-template-columns: 1fr 1fr;
    height: calc(100vh - 84px); // Subtract navbar height

    .right-column {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        padding: 100px;
    }
}
```

---

## 📧 Technical Concepts

### CSS Grid vs Flexbox for Split Layout

**Why CSS Grid here?**:

- **Exact columns** - 1fr 1fr guarantees 50/50 split
- **Less code** - two columns in one line
- **More maintainable** - structural changes easier

### Background Image with String Concatenation

**React inline styles syntax**:

```javascript
style={{
    background: "url(" + profilePicture + ") no-repeat",
    backgroundSize: "cover", 
    backgroundPosition: "center"
}}
```

**Explanation**:

- **url()** CSS function needs concatenation
- **no-repeat** prevents image repetition
- **cover** scales image maintaining aspect ratio
- **center** positions image in centre

### Viewport Height Calculation

**Common problem with 100vh**:

- **100vh** = complete viewport height
- **Fixed navigation** consumes additional space
- **calc()** allows maths in CSS

**Solution**:

```scss
height: calc(100vh - 84px); // 84px = navbar height
```

### Flexbox Triple Centring

**Perfect centring**:

```scss
display: flex;
justify-content: center;  // Horizontal centring
align-items: center;      // Vertical centring
flex-direction: column;   // Stack paragraphs vertically
```

---

## 📋 Verification

### Visual Layout Testing

**Verification steps**:

1. **Navigate to About** - `/about-me`
2. **Verify split** - image 50% left, content 50% right
3. **Check image** - covers left column completely
4. **Verify centring** - text centred vertically and horizontally
5. **Test scroll** - should have no vertical scroll
6. **Responsive check** - layout maintains proportions

### Common Debugging

**If there's vertical scroll**:

- **Inspect navigation** - verify 84px height
- **Adjust calc()** - may need different height
- **Check padding** - can affect total height

**If image doesn't appear**:

- **Verify path** - correct path to image
- **Check import** - correct import syntax
- **Inspect styles** - background-image applied


---

## 🎨 **EXTENDED CONTENT**

### Best Practices for Profile Images

**Professional recommendations**:

- **High resolution** but optimised (< 1MB)
- **Aspect ratio** square or 4:3 for best results
- **Professional background** - avoid distractions
- **Proper lighting** - face well lit
- **Appropriate expression** - professional but approachable

### Alternative Layout Approaches

**Responsive breakpoints**:

```scss
.content-page-wrapper {
    display: grid;
    grid-template-columns: 1fr 1fr;

    @media (max-width: 768px) {
        grid-template-columns: 1fr;
        grid-template-rows: 40vh 1fr;
    }
}
```

### Advanced Background Styling

**Multiple background effects**:

```scss
.left-column {
    background: 
        linear-gradient(rgba(0,0,0,0.3), rgba(0,0,0,0.3)),
        url(profilePicture) no-repeat center/cover;
}
```

---

