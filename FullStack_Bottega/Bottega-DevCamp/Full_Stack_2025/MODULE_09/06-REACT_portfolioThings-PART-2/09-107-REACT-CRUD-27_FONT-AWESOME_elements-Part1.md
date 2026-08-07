# 09-107: Styling Font Awesome Icons React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-style-font-awesome-icons-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 8423da6079410fde1aada84fefdb01cfaf23825a](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/8423da6079410fde1aada84fefdb01cfaf23825a)

---

## 🎯 Objectives

**Transform sidebar layout with professional styling**:

- **Reorganise content** - wrap title and trash icon in a div container
- **Flexbox layout** - space-between distribution for optimal positioning  
- **Reduce title size** - from h1 to div with controlled font-size
- **Style trash icon** - white colour, increased size, hover effects
- **User experience improvements** - cursor pointer and smooth transitions

**Visual result**:

- Compact title on left side
- Prominent trash icon on right side
- Red hover effect for destructive action feedback
- Smooth animations for professional feel

---

## 🛠️ Implementation

### 1. @fortawesome/font-awesome Setup

**File**: `src/components/app.js`

```js
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import axios from 'axios';

// From 09-107 IMPORTANT
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash, faSignOutAlt, faSign } from "@fortawesome/free-solid-svg-icons";

// ....... */

import NoMatch from './pages/no-match';

// From 09-107 IMPORTANT
library.add(faTrash, faSignOutAlt)

export default class App extends Component {
...
```

**Install dependencies**:

```bash
$ npm i @fortawesome/react-fontawesome @fortawesome/fontawesome-svg-core @fortawesome/free-solid-svg-icons
```

**File**: `src/components/portfolio/portfolio-sidebar-list.js`

```js
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome"
```
`
---

### 2. Remove ID and Reorganise HTML Structure

**File**: `src/components/portfolio/portfolio-sidebar-list.js`

**Wrap title and icon in text-content div**:

```javascript
const portfolioList = () => {
  return props.data.map(portfolioItem => {
    return (
      <div key={portfolioItem.id} className="portfolio-item-thumb">
        <div className="portfolio-thumb-img">
          <img src={portfolioItem.thumb_image_url} />
        </div>

        <div className="text-content">
          <div className="title">{portfolioItem.name}</div>
          <a className="delete-icon" onClick={() => props.handleDeleteClick(portfolioItem)}>
            <FontAwesomeIcon icon="trash" />
          </a>
        </div>
      </div>
    );
  });
};
```

### 3. Create Flexbox Layout for Text Content

**File**: `src/style/portfolio-sidebar.scss`

**Add styles for text-content wrapper**:

```scss
.portfolio-sidebar-list-wrapper {
  .portfolio-item-thumb {
    padding: 21px;

    .portfolio-thumb-img {
      img {
        width: 100%;
      }
    }

    .text-content {
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .title {
      color: $offwhite;
      font-size: 1.5em;
    }
  }
}
```

### 4. Implement Professional Styling for Delete Icon

**Add delete-icon styles**:

```scss
.delete-icon {
  cursor: pointer;
  color: $offwhite;
  font-size: 1.5em;
  transition: 0.5s ease-in-out;

  &:hover {
    color: $warning;
  }
}
```

---

## 📚 Concepts

### Flexbox for Icon-Text Layout

**Layout strategy with space-between**:

```scss
.text-content {
  display: flex;
  justify-content: space-between;  // Title left, icon right
  align-items: center;             // Vertical centring
}
```

**Why this approach**:

- **Automatic spacing** - no manual positioning needed
- **Flexible adaptation** - works with different title lengths
- **Vertical alignment** - icon and title perfectly centred
- **Responsive behaviour** - maintains layout on different screen sizes

### Typography Control for Better UX

**From h1 to controlled div**:

```scss
.title {
  color: $offwhite;
  font-size: 1.5em;  // Controlled size instead of h1 default
}
```

**Advantages of approach**:

- **Size consistency** - same size regardless of content length
- **Layout control** - fits better in single line
- **Flexbox compatibility** - h1 can have margin issues
- **Custom styling** - complete control over appearance

### Font Awesome Icons as Fonts

**Why icons are styleable as text**:

```scss
.delete-icon {
  color: $offwhite;      // Just like text colour
  font-size: 1.5em;      // Scales like fonts
  cursor: pointer;       // UX improvement
}
```

**Vector advantages**:

- **Scalable** - any size without quality loss
- **Colour customisable** - any colour via CSS
- **Performance** - lightweight compared to images
- **Consistent rendering** - same appearance across browsers

### Hover Effects for Destructive Actions

**UI/UX best practice for delete actions**:

```scss
&:hover {
  color: $warning;  // Red colour indicates danger
}
```

**Why this approach**:

- **Visual feedback** - user knows it's interactive
- **Colour psychology** - red = destructive action
- **Standard UI pattern** - users expect this behaviour
- **Accessibility** - clear indication of actionable element

### Smooth Transitions for Professional Feel

**Transition implementation**:

```scss
transition: 0.5s ease-in-out;
```

**Animation benefits**:

- **Professional appearance** - no jarring colour changes
- **Better UX** - smooth visual feedback
- **Brand consistency** - matches other app transitions
- **Performance** - CSS transitions are hardware accelerated

### Class Naming Strategy for Specificity

**Why delete-icon specific class**:

```scss
.delete-icon {  // Specific class
  // styles here
}

// Instead of:
a {  // Too generic, could affect other links
  // styles here
}
```

**Naming benefits**:

- **Specificity control** - won't affect other anchor tags
- **Future-proofing** - title could become clickable later
- **Maintainability** - clear purpose of styling
- **Modularity** - easy to modify without side effects

---

## ✋ Verification

### Visual Layout Testing

**Expected layout behaviour**:

- **Title positioned left** - takes available space
- **Icon positioned right** - consistent placement
- **Single line layout** - no wrapping or overflow
- **Vertical alignment** - title and icon perfectly centred

### Interactive Behaviour Testing

**Hover state verification**:

1. **Default state** - white icon colour
2. **Hover over icon** - smooth transition to red
3. **Move cursor away** - smooth transition back to white
4. **Cursor changes** - pointer cursor indicates clickability

### Functional Testing

**Delete functionality**:

1. **Click trash icon** - portfolio item should delete
2. **Verify API call** - item removed from backend
3. **UI update** - item disappears from sidebar immediately
4. **Page refresh** - deleted items don't reappear

### Flexbox Layout Verification

**Developer tools inspection**:

- **Flexbox properties applied** - display: flex on text-content
- **Space distribution** - justify-content: space-between working
- **Vertical alignment** - align-items: center effective
- **No layout breaks** - content fits in available space

### Typography Consistency

**Font size verification**:

- **Title size** - 1.5em consistent across all items
- **Icon size** - 1.5em matches proportionally with title
- **Colour consistency** - $offwhite applied correctly
- **Responsive scaling** - sizes adapt to different screen sizes

---
