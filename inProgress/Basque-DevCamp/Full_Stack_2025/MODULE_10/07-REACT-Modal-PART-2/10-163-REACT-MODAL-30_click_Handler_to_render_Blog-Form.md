# 10-163: Adding Click Handler to Render the BlogForm Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/adding-click-handler-render-blogform-component)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 97950dd83ddae5f154f83f3f2f3fa61e70acc139](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/97950dd83ddae5f154f83f3f2f3fa61e70acc139)

---

## 🎯 Objectives

**Implement click-to-edit functionality on blog detail page using conditional rendering**:

- **Edit mode state** - boolean state to toggle between display and edit views
- **Click handler** - function to switch to edit mode when admin clicks blog title
- **Conditional rendering** - show BlogForm when editMode is true, normal content when false
- **Dynamic component swapping** - same route, different content without routing changes
- **AdminCheck integration** - only admins can see and click edit functionality
- **Single Page Application pattern** - URL remains the same, only content changes

**Key concept**: Transform static blog detail page into editable form using client-side state management, NOT routing.

---

## 🛠️ Implementation

### 1. Import BlogForm Component

**File**: `src/components/pages/blog-detail.js`

**Add BlogForm import at top of file**:

```javascript
import React, { Component } from "react";
import axios from "axios";
import ReactHtmlParser from "react-html-parser";

import BlogForm from "../blog/blog-form";
```

### 2. Add editMode State

**Add to constructor after existing state**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    currentId: this.props.match.params.slug,
    blogItem: {},
    editMode: false
  };

  this.getBlogItem = this.getBlogItem.bind(this);
  this.handleEditClick = this.handleEditClick.bind(this);
}
```

### 3. Create handleEditClick Method

**Add method after getBlogItem**:

```javascript
handleEditClick() {
  this.setState({
    editMode: true
  });
}
```

### 4. Implement Conditional Rendering Logic

**Add contentManager function inside render method, before return**:

```javascript
render() {
  const contentManager = () => {
    if (this.state.editMode) {
      return <BlogForm />;
    } else {
      return (
        <div className="content-container">
          <h1 onClick={this.handleEditClick}>{this.state.blogItem.title}</h1>

          <BlogFeaturedImage img={this.state.blogItem.featured_image_url} />

          <div className="content">
            {ReactHtmlParser(this.state.blogItem.content)}
          </div>
        </div>
      );
    }
  };

  return (
    <div className="blog-detail-wrapper">
      {contentManager()}
    </div>
  );
}
```

**Important**: Move ALL existing JSX content inside the else block of contentManager

---

## 📖 Concepts

### Single Page Application (SPA) Routing Concept

**Traditional multi-page approach**:

```
/blog/post-1        → page1.html (full page reload)
/blog/post-1/edit   → edit-form.html (new page, full reload)
```

**React SPA approach**:

```
/blog/post-1        → BlogDetail component
/blog/post-1        → Same URL, BlogForm component (conditional render)
```

**Key insight**: React "mocks" routing - we have one index.html file, components swap in/out based on state.

### Conditional Rendering Pattern

**Pattern structure**:

```javascript
// Content manager pattern
const contentManager = () => {
  if (condition) {
    return <ComponentA />;
  } else {
    return <ComponentB />;
  }
};

return <div>{contentManager()}</div>;
```

**Why this pattern over inline conditionals**:

- **Complex logic** - easier to read than nested ternary operators
- **Multiple conditions** - can handle more than if/else
- **Maintainable** - logic separated from JSX structure
- **Reusable** - pattern works across different components

### State-Driven UI Changes

**State-centric approach**:

```javascript
// State change triggers re-render
this.setState({ editMode: true });

// UI automatically updates based on new state
// No manual DOM manipulation needed
// React handles the component swapping
```

**Benefits**:

- **Declarative** - describe what UI should look like for each state
- **Predictable** - same state always produces same UI
- **Debuggable** - can inspect state to understand UI behaviour
- **Testable** - can test different states independently

### Click Handler Integration

**Click-to-edit UX pattern**:

```javascript
// User clicks title
<h1 onClick={this.handleEditClick}>{this.state.blogItem.title}</h1>

// State changes
handleEditClick() {
  this.setState({ editMode: true });
}

// UI transforms
// Static title → editable form input
```

**User experience benefits**:

- **Intuitive interface** - click to edit is familiar pattern
- **No page transitions** - smooth, immediate feedback
- **Context preservation** - user stays on same "page"
- **Fast interaction** - no network requests to change view

### Component Reuse Strategy

**BlogForm flexibility**:

```javascript
// Used in modal for creating new blogs
<BlogModal>
  <BlogForm />
</BlogModal>

// Used inline for editing existing blogs
<BlogDetail>
  {editMode && <BlogForm />}
</BlogDetail>
```

**Design benefits**:

- **DRY principle** - same form logic for create and edit
- **Consistent UX** - same form appearance and behaviour
- **Maintainable** - changes to BlogForm apply everywhere
- **Efficient** - no duplicate form logic

### Route vs State Management

**When to use routing**:

```javascript
// Different pages, different URLs
/blog          → Blog list
/blog/123      → Blog detail
/portfolio     → Portfolio list
```

**When to use state**:

```javascript
// Same logical page, different modes
/blog/123 + editMode: false  → Display blog
/blog/123 + editMode: true   → Edit blog
```

**Decision criteria**:

- **Bookmarkable?** → Use routes
- **Shareable URL?** → Use routes  
- **Browser history?** → Use routes
- **Temporary mode?** → Use state
- **Same data context?** → Use state

### Admin-Only Functionality Preview

**Future implementation pattern**:

```javascript
// Will be wrapped with admin check
{this.state.loggedInStatus === "LOGGED_IN" && (
  <h1 onClick={this.handleEditClick}>{this.state.blogItem.title}</h1>
)}

// Non-admins see non-clickable title
{this.state.loggedInStatus !== "LOGGED_IN" && (
  <h1>{this.state.blogItem.title}</h1>
)}
```

---

## ✅ Verification

### 1. Basic Click-to-Edit Testing

**Initial state verification**:

1. **Navigate to any blog detail page** - `/b/[id]`
2. **Verify normal display** - title, featured image, content visible
3. **editMode should be false** - check React DevTools state
4. **BlogForm not rendered** - only normal blog content visible

### 2. Edit Mode Activation

**Click handler testing**:

1. **Click on blog title** - should trigger handleEditClick
2. **State should update** - editMode changes to true in React DevTools
3. **UI should transform** - BlogForm replaces normal content
4. **URL unchanged** - address bar still shows `/b/[id]`

### 3. Component Swapping Verification

**Content manager functionality**:

**Before click (editMode: false)**:

- Blog title displayed
- Featured image visible
- Blog content rendered
- BlogForm not in DOM

**After click (editMode: true)**:

- BlogForm component rendered
- Normal blog content gone
- Same URL maintained
- Same React component (BlogDetail) mounted

### 4. State Management Testing

**React DevTools verification**:

1. **Open React DevTools** → Components
2. **Navigate to BlogDetail component**
3. **Check initial state**:
   - `editMode: false`
   - `blogItem: {...}`
   - `currentId: [slug]`
4. **Click title, verify state change**:
   - `editMode: true`
   - Other state unchanged

### 5. Component Isolation Testing

**Verify no side effects**:

- **Other blog posts unaffected** - editMode is per-component
- **Navigation still works** - can navigate away and back
- **Component lifecycle intact** - no memory leaks or errors
- **Props/state preserved** - blogItem data still available

### 6. BlogForm Integration

**Form rendering verification**:

1. **Click title to enter edit mode**
2. **Verify BlogForm appears** - form inputs visible
3. **Check form structure** - same appearance as in modal
4. **No console errors** - clean component integration

---
