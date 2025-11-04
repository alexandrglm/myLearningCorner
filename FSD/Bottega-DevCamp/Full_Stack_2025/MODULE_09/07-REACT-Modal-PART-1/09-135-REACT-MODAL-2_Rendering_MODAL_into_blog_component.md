# 09-135: Rendering React Modal into Blog Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/rendering-react-modal-blog-component)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 5b48e2c2ee2c1780128a3c5e970b1e7083a0f992](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/5b48e2c2ee2c1780128a3c5e970b1e7083a0f992)

---

## 🎯 Objectives

**Create and render dedicated blog modal component**:

- **Create BlogModal component** - class component to manage modal state
- **Implement ReactModal** - use react-modal library for modal functionality
- **Create modals directory** - organise modal components in dedicated folder
- **Import and render modal** - integrate modal within blog page component
- **Test modal rendering** - verify modal appears with hardcoded isOpen prop
- **Understand child component pattern** - ReactModal uses children, not self-closing tags

**Goal**: Foundation modal component that appears on screen, prepared for state management and user interactions.

---

## 🛠️ Implementation

### 1. Create Modals Directory Structure

**In src/components/**:

```bash
mkdir modals
```

**New file structure**:

```
src/components/
├── modals/
│   └── blog-modal.js  # New component
├── pages/
│   └── blog.js       # Will import modal
└── ...
```

### 2. Create BlogModal Class Component

**File**: `src/components/modals/blog-modal.js`

```javascript
import React, { Component } from "react";
import ReactModal from "react-modal";

export default class BlogModal extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <ReactModal isOpen={true}>
        <h1>I'm in a modal!</h1>
      </ReactModal>
    );
  }
}
```

### 3. Import BlogModal in Blog Component

**File**: `src/components/pages/blog.js`

**Add import statement after other imports**:

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import axios from "axios";

import BlogItem from "../blog/blog-item";
import BlogModal from "../modals/blog-modal";  // New import
```

### 4. Render BlogModal in Blog Component

**In render method of Blog component**:

```javascript
render() {
  const blogRecords = this.state.blogItems.map(blogItem => {
    return <BlogItem key={blogItem.id} blogItem={blogItem} />;
  });

  return (
    <div className="blog-container">
      <BlogModal />

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

---

## 📖 Concepts

### React Modal Library Architecture

**Component-based modal system**:

- **ReactModal component** - wrapper that manages overlay, focus, accessibility
- **Children pattern** - content goes between opening and closing tags
- **Props-based control** - isOpen, onRequestClose, etc. control behaviour
- **Portal rendering** - modal renders outside normal DOM hierarchy

### Class Component for Modal State

**Why class component?**:

- **Modal needs state** - open/closed status, form data, etc.
- **Lifecycle methods** - componentDidMount for setup, cleanup on unmount
- **Event handlers** - this binding for consistent context
- **Props management** - receive props from parent for control

### ReactModal Children Pattern

**NOT self-closing tag**:

```javascript
// ✗ Wrong - self-closing
<ReactModal isOpen={true} />

// ✓ Correct - children pattern  
<ReactModal isOpen={true}>
  <h1>Modal content goes here</h1>
</ReactModal>
```

**Why children pattern**:

- **Flexible content** - any JSX can go inside modal
- **Component composition** - forms, buttons, complex layouts
- **Dynamic content** - content changes based on props/state

### Modal State Management Pattern

**Current approach (hardcoded)**:

```javascript
<ReactModal isOpen={true}>  // Always open
```

**Future approach (state-controlled)**:

```javascript
<ReactModal isOpen={this.props.modalIsOpen}>  // Parent controls
```

**Benefits of props-based control**:

- **Parent component decides** when modal opens/closes
- **Reusable modal** - same modal for different triggers
- **Clean separation** - modal handles display, parent handles logic

### Directory Organisation Strategy

**Modals directory benefits**:

- **Separation of concerns** - modals separated from pages and other components
- **Scalability** - easy to add more modal types
- **Reusability** - modals can be imported by multiple components
- **Team development** - clear where modal components belong

### Lightweight Modal Library Philosophy

**ReactModal characteristics**:

- **No pre-built styling** - complete customisation freedom
- **No automatic behaviours** - you control when it opens/closes
- **Accessibility foundation** - provides ARIA attributes, focus management
- **Developer flexibility** - you decide behaviour, appearance, interactions

**Comparison with other libraries**:

- **Heavy libraries** - pre-styled, limited customisation options
- **ReactModal** - lightweight, infinite customisation possibilities
- **Professional preference** - flexibility over convenience

---

## ✅ Verification

### 1. Modal Appearance Test

**Navigate to /blog page**:

- **Modal should appear** - overlay covering page content
- **"I'm in a modal!" text** - visible in modal content area
- **Modal stays open** - doesn't close automatically
- **No styling** - basic browser default appearance

### 2. Modal Behaviour Verification

**Current limitations (expected)**:

- **Click outside** - modal doesn't close (we'll implement later)
- **ESC key** - modal doesn't close (we'll implement later)  
- **No close button** - no way to close (we'll implement later)
- **Always visible** - hardcoded isOpen={true}

### 3. Component Import Verification

**Check in React DevTools**:

1. **Open React DevTools**
2. **Navigate to Blog component**
3. **Should see BlogModal** as child component
4. **BlogModal rendered** - with ReactModal inside

### 4. File Structure Verification

**Project structure should include**:

```
src/components/
├── modals/
│   └── blog-modal.js  ✓
├── pages/
│   └── blog.js       ✓ (imports BlogModal)
└── ...
```

### 5. Console Check

**Expected console output**:

- **No import errors** - BlogModal imports successfully
- **No rendering errors** - modal displays without issues
- **No ReactModal warnings** - library loaded correctly

---

## 🎨 Understanding ReactModal Default Behaviour

### Current Modal State

**What we have now**:

- ✓ **Modal renders** - appears on screen
- ✓ **ReactModal integration** - using library correctly
- ✓ **Component architecture** - separated modal component
- ✗ **User interaction** - can't close or control modal

### What's Missing (Future Implementation)

**Features we'll add**:

- **State management** - parent component controls modal visibility
- **Event handlers** - open/close functionality
- **Click outside to close** - user-friendly behaviour
- **ESC key support** - keyboard accessibility
- **Custom styling** - professional appearance
- **Form integration** - actual blog creation functionality

### ReactModal Default Behaviour

**Current behaviour analysis**:

- **Always visible** - isOpen={true} means permanent display
- **No interaction** - clicking outside doesn't close
- **Basic styling** - browser default modal appearance
- **Focus trap** - focus stays within modal (good accessibility)

### Professional Development Pattern

**Incremental building approach**:

1. **Step 1** - Basic modal rendering (current guide)
2. **Step 2** - Add state control for open/close
3. **Step 3** - Add user interaction events  
4. **Step 4** - Add custom styling
5. **Step 5** - Add form functionality
6. **Step 6** - Add API integration

**Benefits of this approach**:

- **Test each piece** - verify functionality at each step
- **Easier debugging** - isolate issues to specific features
- **Understanding building** - learn why each piece needed
- **Professional habits** - how real applications are built

---
