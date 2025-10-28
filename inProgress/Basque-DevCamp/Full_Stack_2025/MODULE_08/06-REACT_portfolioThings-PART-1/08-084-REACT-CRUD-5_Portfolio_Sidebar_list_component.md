# 08-084 - Building Portfolio Sidebar List Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-portfolio-sidebar-list-component)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at e4dadd501ecf2b84925c6d6def8dfbbd3c4c2de5](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/e4dadd501ecf2b84925c6d6def8dfbbd3c4c2de5)

---

## 🎯 OBJECTIVES

**Create functional component for sidebar**:

- **Functional component** to render portfolio list
- **Props data flow** from PortfolioManager to sidebar
- **Map method** to iterate over portfolio items
- **Render images** thumbnails with name and ID
- **Prepare structure** for styling in next guide

**Data architecture**:

- Parent (PortfolioManager) → Props → Child (PortfolioSidebarList)
- Transform array of objects into JSX components

---

## 🛠️ IMPLEMENTATION

### Create Portfolio Sidebar List Component

**File**: `src/components/portfolio/portfolio-sidebar-list.js`

```javascript
import React from "react";

const PortfolioSidebarList = props => {
  const portfolioList = () => {
    return props.data.map(portfolioItem => {
      return (
        <div>
          <img src={portfolioItem.thumb_image_url} />
          <h1>{portfolioItem.name}</h1>
          <h2>{portfolioItem.id}</h2>
        </div>
      );
    });
  };

  return <div>{portfolioList()}</div>;
};

export default PortfolioSidebarList;
```

### Import in Portfolio Manager

**File**: `src/components/pages/portfolio-manager.js`

```javascript
import React, { Component } from "react";
import axios from "axios";
import PortfolioSidebarList from "../portfolio/portfolio-sidebar-list";

export default class PortfolioManager extends Component {
  constructor() {
    super();

    this.state = {
      portfolioItems: []
    };
  }

  getPortfolioItems() {
    axios.get("https://jordan.devcamp.space/portfolio/portfolio_items", {
      withCredentials: true
    }).then(response => {
      this.setState({
        portfolioItems: [...response.data.portfolio_items]
      });
    }).catch(error => {
      console.log("error in getPortfolioItems", error);
    });
  }

  componentDidMount() {
    this.getPortfolioItems();
  }

  render() {
    return (
      <div className="portfolio-manager-wrapper">
        <div className="left-column">
          <h1>Portfolio form....</h1>
        </div>

        <div className="right-column">
          <PortfolioSidebarList data={this.state.portfolioItems} />
        </div>
      </div>
    );
  }
}
```

---

## 🔧 CONCEPTS

### Functional Component vs Class Component

**Why functional component for sidebar**:

```javascript
// Presentational component - only renders props
const PortfolioSidebarList = props => {
  // No state management
  // No lifecycle methods
  // Just transform props into JSX
  return <div>{/* JSX */}</div>;
};
```

**When to use functional**:

- **Presentational components** - UI only
- **No state management** - receives everything via props
- **Better performance** - less overhead
- **Simpler** - less boilerplate code

### Map Method for Rendering

**Data transformation**:

```javascript
// Input: Array of objects
portfolioItems = [
  {id: 1, name: "Project 1", thumb_image_url: "..."},
  {id: 2, name: "Project 2", thumb_image_url: "..."}
];

// Output: Array of JSX elements
portfolioList = [
  <div><img.../><h1>Project 1</h1>...</div>,
  <div><img.../><h1>Project 2</h1>...</div>
];
```

**Why map instead of forEach**:

- **map returns new array** - perfect for JSX
- **forEach returns undefined** - doesn't work for render
- **Immutable pattern** - doesn't modify original array

### Props Data Flow

**Parent → Child communication**:

```javascript
// Parent (PortfolioManager)
<PortfolioSidebarList data={this.state.portfolioItems} />

// Child (PortfolioSidebarList)
const PortfolioSidebarList = props => {
  return props.data.map(/* ... */);
};
```

**Unidirectional data flow**:

- **Data flows down** - parent to child via props
- **Events flow up** - child to parent via callbacks
- **Single source of truth** - state in parent component

### Accessing API Response Properties

**DevCamp Space portfolio item structure**:

```javascript
portfolioItem = {
  id: 1,
  name: "Project Name",
  description: "...",
  url: "https://...",
  category: "eCommerce",
  thumb_image_url: "https://...",
  banner_image_url: "https://...",
  logo_url: "https://..."
};
```

**Property access pattern**:

- `portfolioItem.name` - project title
- `portfolioItem.id` - unique identifier
- `portfolioItem.thumb_image_url` - thumbnail image

---

## ✔️ VERIFICATION

### Testing Sidebar Component

**Verify in browser**:

1. **Navigate to** `/portfolio-manager`
2. **See right column** with portfolio items
3. **Confirm images** load (very large)
4. **See names** of actual projects
5. **See numeric** IDs

### Expected DOM Structure

**Generated HTML**:

```html
<div class="right-column">
  <div>
    <div>
      <img src="https://...">
      <h1>Project Name 1</h1>
      <h2>1</h2>
    </div>
    <div>
      <img src="https://...">
      <h1>Project Name 2</h1>
      <h2>2</h2>
    </div>
    <!-- ... rest of items -->
  </div>
</div>
```

### React DevTools Verification

**Props inspection**:

1. **Open React DevTools**
2. **Select PortfolioSidebarList** component
3. **View props.data** populated array
4. **Expand items** to see structure
5. **Confirm data flow** parent → child

### Visual Problems Expected

**Current issues (fixed in next guide)**:

- **Huge images** - no size control
- **No styling** - basic layout
- **Overflow issues** - images escape container
- **No spacing** - elements cramped together

---
