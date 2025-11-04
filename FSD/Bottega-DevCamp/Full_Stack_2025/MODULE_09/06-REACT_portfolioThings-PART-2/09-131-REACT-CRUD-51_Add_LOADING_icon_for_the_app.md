# 09-131: Implementing Animated Loading Icon in React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/implementing-animated-data-loading-icon-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 3df19a409b52e01ce03bb22c0aca593bbf61bfdf](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/3df19a409b52e01ce03bb22c0aca593bbf61bfdf)

---

## 🎯 Objectives

**Create loading feedback system for infinite scroll feature**:

- **isLoading state** - track when data is being fetched from server
- **FontAwesome spinner icon** - animated loading indicator with spin prop
- **Icon discovery process** - find correct spinner icon on fontawesome.io
- **Conditional rendering** - show spinner only when actually loading
- **Dual purpose loader** - initial page load and infinite scroll loading
- **Professional styling** - size and colour customisation for better UX
- **Modular SCSS architecture** - loaders.scss for reusable loading components

**User experience benefit**: Clear feedback when more posts are being fetched

---

## 🛠️ Implementation

### 1. Add isLoading State Property

**File**: `src/components/pages/blog.js`

**Update constructor with isLoading state**:

```javascript
constructor() {
  super();

  this.state = {
    blogItems: [],
    totalCount: 0,
    currentPage: 0,
    isLoading: true
  };

  this.getBlogItems = this.getBlogItems.bind(this);

  this.activateInfiniteScroll();
}
```

### 2. Update isLoading State when Data Loads

**In getBlogItems method, within .then()**:

```javascript
getBlogItems() {
  this.setState({
    currentPage: this.state.currentPage + 1
  });

  axios
    .get("https://jordan.devcamp.space/portfolio/portfolio_blogs", {
      withCredentials: true
    })
    .then(response => {
      this.setState({
        blogItems: response.data.portfolio_blogs,
        totalCount: response.data.meta.total_records,
        isLoading: false
      });
    })
    .catch(error => {
      console.log("getBlogItems error", error);
    });
}
```

### 3. Add faSpinner Icon to App.js Library

**File**: `src/components/app.js`

**Import and add spinner icon**:

```javascript
import { faTrash, faSignOutAlt, faEdit, faSpinner } from "@fortawesome/free-solid-svg-icons";

library.add(faTrash, faSignOutAlt, faEdit, faSpinner);
```

### 4. Import FontAwesome Component in Blog

**File**: `src/components/pages/blog.js`

**Add FontAwesome import**:

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import BlogItem from "../blog/blog-item";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
```

### 5. Implement Loading Icon with Conditional Rendering

**In render method, add spinner with ternary operator**:

```javascript
render() {
  const blogRecords = this.state.blogItems.map(blogItem => {
    return <BlogItem key={blogItem.id} blogItem={blogItem} />;
  });

  return (
    <div className="blog-container">
      <div className="content-container">
        {blogRecords}
      </div>

      {this.state.isLoading ? (
        <div className="content-loader">
          <FontAwesomeIcon icon="spinner" spin />
        </div>
      ) : null}
    </div>
  );
}
```

### 6. Create Loaders SCSS File

**Create file**: `src/style/loaders.scss`

**Add loader styles**:

```scss
.content-loader {
  font-size: 2em;
  colour: $teal;
}
```

### 7. Import Loaders SCSS in Main File

**File**: `src/style/main.scss`

**Add import at bottom**:

```scss
@import "./variables.scss";
@import "./mixins.scss";
@import "./base.scss";
@import "./forms.scss";
@import "./button.scss";
@import "./grid.scss";
@import "./navigation.scss";
@import "./portfolio.scss";
@import "./portfolio-manager.scss";
@import "./portfolio-form.scss";
@import "./portfolio-sidebar.scss";
@import "./auth.scss";
@import "./blog.scss";
@import "./loaders.scss";
```

---

## 📚 Concepts

### State-Driven Loading Indicators

**Why isLoading state is critical?**:

```javascript
{
  isLoading: true   // → Show spinner
  isLoading: false  // → Hide spinner, show content
}
```

**Loading state lifecycle**:

1. **Component mounts** → `isLoading: true` (constructor)
2. **API call initiated** → spinner visible to user
3. **Response received** → `isLoading: false` (setState)
4. **Content rendered** → spinner disappears, blog posts appear

### FontAwesome Spin Property

**Automatic animation**:

```jsx
<FontAwesomeIcon icon="spinner" spin />
//                              ↑
//                              Built-in CSS animation
```

**How spin prop works?**:

- **CSS animation** - FontAwesome applies `animation: fa-spin 2s infinite linear`
- **Hardware accelerated** - smooth performance
- **No JavaScript** - pure CSS transforms
- **Responsive** - scales with font-size

### Dual Purpose Loader Strategy

**Two use cases with same component**:

```jsx
// 1. Initial page load
constructor() { 
  this.state = { isLoading: true }; // Shows spinner immediately
}

// 2. Infinite scroll (future implementation)
activateInfiniteScroll() {
  if (userReachesBottom) {
    this.setState({ isLoading: true });  // Show spinner at bottom
    loadMorePosts();
  }
}
```

### Positioning Strategy Explanation

**Why spinner below content?**:

```jsx
<div className="content-container">
  {blogRecords}              // Existing posts
</div>

{this.state.isLoading ? (
  <div className="content-loader">
    <FontAwesomeIcon icon="spinner" spin />  // Below existing content
  </div>
) : null}
```

**Benefits of this positioning**:

- **Initial load** - spinner appears where content will be
- **Infinite scroll** - spinner appears below existing posts
- **No layout shift** - consistent positioning
- **Intuitive UX** - user sees loading where new content appears

### Conditional Rendering Pattern

**Ternary operator breakdown**:

```jsx
{this.state.isLoading ? (
  // JSX to show when loading
  <div className="content-loader">
    <FontAwesomeIcon icon="spinner" spin />
  </div>
) : null}
//   ↑
//   Show nothing when not loading
```

**Alternative patterns**:

```jsx
// Short-circuit evaluation
{this.state.isLoading && <LoadingSpinner />}

// More complex conditional
{this.state.isLoading ? <LoadingSpinner /> : 
 this.state.hasError ? <ErrorMessage /> : null}
```

### SCSS Architecture for Reusability

**Modular loader styling**:

```scss
// loaders.scss - dedicated file for all loading components
.content-loader {
  font-size: 2em;    // Easy to customise size
  colour: $teal;     // Consistent with brand colours
}

// Future loaders could be added:
// .button-loader { ... }
// .modal-loader { ... }
```

**Scalable architecture benefits**:

- **Single file** - all loading styles centralised
- **Consistent branding** - same colours and sizing approach
- **Easy maintenance** - modify all loaders in one place
- **Team development** - clear where loading styles belong

---

## ✋ Verification

### Initial Page Load Testing

**Expected behaviour sequence**:

1. **Navigate to /blog** - page starts loading
2. **Spinner appears immediately** - below any existing content
3. **API call executes** - fetches blog posts
4. **Data loads** - blog posts populate
5. **Spinner disappears** - isLoading becomes false
6. **Final state** - only blog posts visible, no spinner

### State Inspection with React DevTools

**Verification steps**:

1. **Open React DevTools** → Components

2. **Select Blog component**  

3. **Watch State panel** during page load:
   
   ```javascript
   // Initial state
   isLoading: true
   
   // After API response
   isLoading: false
   ```

### Visual Design Verification

**Spinner appearance check**:

1. **Size verification** - should be 2em (double normal size)
2. **Colour verification** - should be teal colour
3. **Animation verification** - smooth spinning motion
4. **Positioning verification** - centred horizontally

### Performance Testing

**Loading speed assessment**:

- **Fast internet** - spinner might appear briefly
- **Slow internet** - spinner should be clearly visible
- **Network throttling** - use DevTools to simulate slow connection
- **Multiple page loads** - consistent behaviour every time

### Error Case Testing

**What if API fails**:

- Current implementation - spinner might stay forever
- Future enhancement - need error state handling
- Consider timeout scenarios - long API responses

---

## 🎨 UX Design Principles

### Loading Feedback Best Practices

**Why loading indicators matter**:

- **User confidence** - shows system is working
- **Perceived performance** - users wait more patiently
- **Professional appearance** - polished app experience
- **Accessibility** - clear system status communication

### Spinner vs Other Loading Patterns

**FontAwesome spinner advantages**:

- **Lightweight** - vector-based, small file size
- **Consistent** - matches other icons in app
- **Customisable** - colour, size easily modified
- **Professional** - industry-standard appearance

**Alternative loading patterns**:

- Progress bars - good for measurable progress
- Skeleton screens - good for known content layouts
- Dots animation - minimal, subtle loading
- Text indicators - "Loading..." simple approach

### Colour Psychology in Loading

**Teal colour choice**:

- **Brand consistency** - matches app colour scheme
- **Calm/professional** - not alarming to users
- **High contrast** - visible against backgrounds
- **Modern aesthetic** - fits contemporary design trends

---
