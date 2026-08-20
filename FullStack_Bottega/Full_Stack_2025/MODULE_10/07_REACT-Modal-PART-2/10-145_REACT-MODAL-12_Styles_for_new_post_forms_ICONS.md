# 10-145: Construyendo Estilos para New Blog Icon con Fixed Position

---

**[Guía](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-styles-new-blog-icon-fixed-position-page)**

[Building the Styles for the New Blog Icon with a Fixed Position on the Page](https://basque.devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-styles-new-blog-icon-fixed-position-page)[Building the Styles for the New Blog Icon with a Fixed Position on the Page](https://basque.devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-styles-new-blog-icon-fixed-position-page)

---

## 🎯 Objetivos

**Transformar text link en professional floating action button con icon**:

- **FontAwesome plus icon** - replace "Open Modal!" text con plus-circle icon
- **Fixed positioning** - create floating action button que stays en same position
- **Two positioning options** - absolute vs fixed positioning comparison
- **Professional styling** - large icon con hover effects y smooth transitions
- **User experience enhancement** - intuitive blog creation trigger
- **Icon import workflow** - proper FontAwesome integration process

**Visual result**: Professional floating action button similar to those found en help/chat systems on modern websites.

---

## 🛠️ Implementación

### 1. Import Plus Circle Icon en App.js

**Archivo**: `src/components/app.js`

**Add faPlusCircle to FontAwesome imports**:

```javascript
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import axios from 'axios';

import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { 
  faTrash, 
  faSignOutAlt, 
  faEdit, 
  faSpinner,
  faPlusCircle
} from "@fortawesome/free-solid-svg-icons";

// Import other components...

library.add(faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle);

export default class App extends Component {
  // ... rest of component
}
```

### 2. Replace Text Link con FontAwesome Icon

**Archivo**: `src/components/pages/blog.js`

**Update new-blog-link con icon**:

```javascript
render() {
  const blogRecords = this.state.blogItems.map(blogItem => {
    return <BlogItem key={blogItem.id} blogItem={blogItem} />;
  });

  return (
    <div className="blog-container">
      <BlogModal 
        handleSuccessfulNewBlogSubmission={this.handleSuccessfulNewBlogSubmission}
        handleModalClose={this.handleModalClose}
        modalIsOpen={this.state.blogModalIsOpen} 
      />

      <div className="new-blog-link">
        <a onClick={this.handleNewBlogClick}>
          <FontAwesomeIcon icon="plus-circle" />
        </a>
      </div>

      <div className="content-container">{blogRecords}</div>

      {this.state.isLoading ? (
        <div className="content-loader">
          <FontAwesomeIcon icon="spinner" spin />
        </div>
      ) : null}
    </div>
  );
}
```

### 3. Add Relative Positioning to Blog Container

**Archivo**: `src/style/blog.scss`

**Prepare parent para absolute positioned children**:

```scss
.blog-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  position: relative;  // Required for absolute positioned children
}
```

### 4. Create Floating Action Button Styles

**En el mismo archivo, add new-blog-link styles**:

```scss
.new-blog-link {
  position: fixed;    // Stay in place while scrolling
  right: 0;
  bottom: 0;

  a {
    font-size: 3em;
    cursor: pointer;
    color: $teal;
    margin-right: 15px;
    margin-bottom: 15px;
    transition: 0.5s ease-in-out;

    &:hover {
      color: $dark-teal;
    }
  }
}
```

---

## 🔧 Conceptos

### Position: Absolute vs Position: Fixed

**Position: Absolute**:

```scss
.new-blog-link {
  position: absolute;
  right: 0;
  top: 0;  // Positioned relative to parent container
}
```

**Characteristics**:

- **Positioned relative** to nearest positioned parent
- **Scrolls with content** - disappears when user scrolls
- **Parent must have** `position: relative`
- **Good for** elements that should move con page content

**Position: Fixed**:

```scss
.new-blog-link {
  position: fixed;
  right: 0;
  bottom: 0;  // Positioned relative to viewport
}
```

**Characteristics**:

- **Positioned relative** to browser viewport
- **Stays in place** during scrolling
- **Always visible** regardless of page scroll position
- **Good for** persistent UI elements (chat buttons, help icons)

### FontAwesome Icon Discovery Process

**Step-by-step workflow**:

1. **Visit FontAwesome.com** → Icons section
2. **Search for concept** - "plus", "add", "create"
3. **Find appropriate icon** - "plus-circle" for rounded button style
4. **Note exact name** - case-sensitive string for icon prop
5. **Import camelCase version** - `faPlusCircle` para library
6. **Use kebab-case en JSX** - `icon="plus-circle"`

### Icon as Font Benefits

**Why FontAwesome icons are superior to images**:

```scss
a {
  font-size: 3em;  // Scales like text - perfect for responsive design
  color: $teal;    // Color customizable via CSS variables
  transition: 0.5s ease-in-out;  // Smooth animations
}
```

**Advantages**:

- **Vector-based** - infinite scalability without quality loss
- **CSS controllable** - color, size, effects via stylesheets
- **Performance** - smaller file sizes than equivalent images
- **Consistency** - same rendering across all browsers

### Floating Action Button (FAB) Pattern

**Modern UI pattern**:

- **Primary action** - most important action easily accessible
- **Fixed position** - always available regardless of page scroll
- **Large touch target** - 3em size easy to click/tap
- **Visual prominence** - stands out from page content

**Common implementations**:

- **Material Design** - Google's FAB specification
- **Chat systems** - customer support widgets
- **Help systems** - contextual assistance
- **Content creation** - add new items (our use case)

### CSS Transitions for Professional Feel

**Smooth interaction feedback**:

```scss
transition: 0.5s ease-in-out;

&:hover {
  color: $dark-teal;  // Darker shade provides feedback
}
```

**User experience benefits**:

- **Visual feedback** - user knows element is interactive
- **Professional appearance** - smooth, polished interactions
- **Brand consistency** - matches other app transitions
- **Accessibility** - clear indication of hover state

### Margin-Based Positioning

**Why margins instead of padding**:

```scss
margin-right: 15px;   // Space from right edge of viewport
margin-bottom: 15px;  // Space from bottom edge of viewport
```

**Benefits**:

- **Click area precision** - margins don't affect clickable area
- **Visual spacing** - creates comfortable distance from edges
- **Responsive friendly** - works well across different screen sizes
- **Touch-friendly** - prevents accidental edge activation

---

## 📋 Verificación

### 1. Icon Import Verification

**FontAwesome integration check**:

1. **Check console** - no FontAwesome import errors
2. **Icon appears** - plus-circle icon visible en page
3. **Icon scales** - 3em size applied correctly
4. **Color correct** - teal color from variables

### 2. Positioning Behavior Testing

**Fixed position verification**:

1. **Navigate to /blog**
2. **Scroll down** - icon should stay en bottom-right corner
3. **Scroll up** - icon position unchanged
4. **Resize browser** - icon maintains position relative to viewport

### 3. Interactive Behavior Testing

**User interaction verification**:

1. **Hover over icon** - color should change to dark-teal
2. **Smooth transition** - color change should be gradual (0.5s)
3. **Cursor change** - pointer cursor indicates clickability
4. **Click functionality** - should open modal como before

### 4. Cross-Device Testing

**Responsive behavior**:

- **Desktop** - comfortable size y positioning
- **Tablet** - still accessible y appropriately sized
- **Mobile** - touch-friendly size (3em provides good target)
- **Different screen sizes** - margins provide consistent edge spacing

### 5. Visual Design Verification

**Professional appearance check**:

- **Size appropriate** - large enough to be prominent but not overwhelming
- **Color consistency** - matches app's teal theme
- **Positioning logical** - bottom-right corner (standard FAB location)
- **Margins sufficient** - comfortable distance from viewport edges

---

## 🎨 Design Pattern Analysis

### Floating Action Button Best Practices

**Standard FAB characteristics**:

- ✅ **Primary action** - most important function prominently placed
- ✅ **Fixed positioning** - always accessible regardless of scroll
- ✅ **Bottom-right placement** - conventional location for FABs
- ✅ **Large touch target** - 3em provides accessible click area
- ✅ **Color significance** - teal indicates primary brand action

### Modern Web UI Patterns

**Similar implementations found on**:

- **Help systems** - "?" icon for contextual assistance
- **Chat widgets** - customer support access
- **E-commerce** - "Add to cart" quick actions
- **Content management** - "Create new" functionality

### Position Strategy Comparison

**When to use each positioning**:

**Absolute positioning**:

- ✅ **Modal close buttons** - relative to modal container
- ✅ **Tooltip positioning** - relative to trigger element
- ✅ **Card action buttons** - relative to card container

**Fixed positioning**:

- ✅ **Navigation bars** - stay visible during scroll
- ✅ **Floating action buttons** - persistent primary actions
- ✅ **Chat widgets** - always accessible support
- ✅ **Cookie notices** - persistent legal notifications

### Performance Considerations

**CSS transition optimization**:

```scss
transition: 0.5s ease-in-out;  // GPU-accelerated color transitions
```

**Benefits**:

- **Hardware acceleration** - smooth animations on mobile devices
- **Battery efficiency** - CSS transitions more efficient than JavaScript
- **Consistent timing** - same transition duration across interactions

---
