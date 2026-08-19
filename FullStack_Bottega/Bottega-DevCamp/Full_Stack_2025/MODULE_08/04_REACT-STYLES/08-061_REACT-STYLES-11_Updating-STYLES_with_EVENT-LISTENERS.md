# 08-061 - Updating Styles with React Event Listeners

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/updating-styles-react-event-listeners

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/877da6919093dfc7909b56418f7e87db99816e88)

---

## 🎯 GUIDE OBJECTIVES

### Problem to Solve

**Missing effects**:

- Background darkening on hover (as in final design)
- Visual interactivity when hovering over portfolio items
- Smooth transitions between states

### Solution: Event Listeners + State Management

**Approach**:

- Convert functional component to class component
- Use state to handle CSS classes dynamically
- Implement onMouseEnter and onMouseLeave events
- CSS filter for darkening effect

---

## 🛠️ STEP-BY-STEP IMPLEMENTATION

### 1. Convert Functional to Class Component

**File**: `src/components/portfolio-item.js`

**Reason for change**: We need state management to control CSS classes dynamically.

**From functional component**:

```javascript
const PortfolioItem = (props) => { ... }
```

**To class component**:

```javascript
import React, { Component } from 'react';

export default class PortfolioItem extends Component {
    constructor(props) {
        super(props);

        this.state = {
            portfolioItemClass: ""
        };
    }

    render() {
        const { id, description, thumb_image_url, logo_url } = this.props.item;

        return (
            <div className="portfolio-item-wrapper">
                {/* JSX content */}
            </div>
        );
    }
}
```

### 2. Implement Event Handler Methods

**Methods for mouse events**:

```javascript
export default class PortfolioItem extends Component {
    constructor(props) {
        super(props);

        this.state = {
            portfolioItemClass: ""
        };
    }

    handleMouseEnter() {
        this.setState({
            portfolioItemClass: "image-blur"
        });
    }

    handleMouseLeave() {
        this.setState({
            portfolioItemClass: ""
        });
    }

    render() {
        // ... JSX
    }
}
```

### 3. Add Event Listeners to JSX

**On portfolio-item-wrapper div**:

```javascript
render() {
    const { id, description, thumb_image_url, logo_url } = this.props.item;

    return (
        <div 
            className="portfolio-item-wrapper"
            onMouseEnter={() => this.handleMouseEnter()}
            onMouseLeave={() => this.handleMouseLeave()}
        >
            <div 
                className={"portfolio-img-background " + this.state.portfolioItemClass}
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
```

### 4. Create CSS Class for Image Blur

**File**: `src/style/portfolio.scss`

**Add to end of file**:

```scss
.image-blur {
    transition: 1s;
    filter: brightness(10%);
}
```

### 5. Implement Dynamic className

**Concatenation technique**:

```javascript
className={"portfolio-img-background " + this.state.portfolioItemClass}
```

**How it works**:

- **Empty state**: `"portfolio-img-background "`
- **State with "image-blur"**: `"portfolio-img-background image-blur"`
- **Space important**: Prevents `portfolio-img-backgroundimage-blur`

---

## 🔧 TECHNICAL CONCEPTS

### Event Listeners in React

**Special syntax**:

```javascript
// ❌ This executes immediately
onMouseEnter={this.handleMouseEnter()}

// ✅ This waits for the event
onMouseEnter={() => this.handleMouseEnter()}
```

**Why arrow functions?**:

- **Prevents immediate execution** - they wait for the event
- **Maintains context** - `this` refers to the component
- **Event delegation** - React handles the event system

### State for CSS Classes

**Professional pattern**:

- State controls which classes are applied
- CSS defines appearance of each class
- JavaScript handles transitions between states
- **Separation of concerns** maintained

### CSS Filter Property

**Brightness filter**:

```scss
filter: brightness(10%); // 10% = very dark
filter: brightness(50%); // 50% = medium dark  
filter: brightness(100%); // 100% = normal
```

**Browser support**: Excellent in modern browsers.

---

## ✔️ RESULT VERIFICATION

### Testing Functionality

**Verification steps**:

1. **Hover over portfolio item** - image darkens smoothly
2. **Move mouse away** - image returns to normal
3. **Smooth transition** - 1 second duration
4. **Description fade** - maintains previous effect
5. **Multiple items** - all work independently

### Debugging with State Visualisation

**Temporary debugging technique**:

```javascript
// Add before img-text-wrapper
<h1>{this.state.portfolioItemClass}</h1>
```

**Expected result**:

- **Without hover**: empty space
- **With hover**: displays "image-blur"

### DevTools Inspection

**Expected HTML structure**:

```html
<div class="portfolio-item-wrapper">
    <div class="portfolio-img-background image-blur">
    </div>
    <!-- rest of content -->
</div>
```

---

## 🎨 DESIGN CONCEPTS

### Darkening Effect Purpose

**UX benefits**:

- **Focus attention** - text more legible over dark background
- **Visual feedback** - clear indication of hover state
- **Professional appearance** - sophisticated and modern effect

### Transition Timing

**1 second duration**:

- **Smooth enough** - no jarring changes
- **Fast enough** - responsive user experience
- **Matches subtitle** - consistent timing with fade-in

---

## 🚀 EXTENDED CONTENT

### Alternative CSS Filters

**Other possible effects**:

```scss
.image-blur {
    filter: blur(2px);           // Blur effect
    filter: grayscale(100%);     // Black and white
    filter: contrast(150%);      // High contrast
    filter: sepia(50%);          // Vintage look
}
```

### Advanced Event Handling

**Multiple state properties**:

```javascript
this.state = {
    portfolioItemClass: "",
    isHovered: false,
    transitionDuration: "1s"
};
```

### Performance Considerations

**Efficient re-renders**:

- Only background image div re-renders
- State change localised to specific component
- CSS transitions handled by browser, not JavaScript

---

## 📋 DEBUGGING WORKFLOW

### Common Issues and Solutions

**Event listeners not working**:

- Verify arrow function syntax
- Check that methods exist in class
- Confirm correct event names (`onMouseEnter`, not `onmouseenter`)

**CSS class not applied**:

- Inspect element to verify class names
- Check string concatenation (space included)
- Verify CSS class exists in SCSS file

**State not updating**:

- Use React DevTools to inspect state
- Confirm setState syntax correct
- Check that component is class, not functional

---
