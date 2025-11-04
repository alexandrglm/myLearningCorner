# 09-136: Triggering React Modal with Click on Link

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/triggering-react-modal-open-link-click)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 2082d1cf96c92e39c997dc1a0f799fe6ff346078](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/2082d1cf96c92e39c997dc1a0f799fe6ff346078)

---

## 🎯 Objectives

**Implement user-controlled modal opening with click event**:

- **Change hardcoded modal** - from isOpen={true} to props-controlled
- **Add state management** - blogModalIsOpen in parent component
- **Create click handler** - handleNewBlogClick function to open modal
- **Implement props passing** - parent state → child props pattern
- **Add trigger link** - clickable element to open modal
- **Test user interaction** - verify modal opens only when user clicks

**Goal**: Transform always-visible modal to user-controlled modal with proper React state management patterns.

---

## 🛠️ Implementation

### 1. Update BlogModal for Props-Based Control

**File**: `src/components/modals/blog-modal.js`

**Change hardcoded isOpen to props**:

```javascript
import React, { Component } from "react";
import ReactModal from "react-modal";

export default class BlogModal extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <ReactModal isOpen={this.props.modalIsOpen}>
        <h1>I'm in a modal!</h1>
      </ReactModal>
    );
  }
}
```

### 2. Add State Management in Blog Component

**File**: `src/components/pages/blog.js`

**Add blogModalIsOpen to state in constructor**:

```javascript
constructor() {
  super();

  this.state = {
    blogItems: [],
    totalCount: 0,
    currentPage: 0,
    isLoading: true,
    blogModalIsOpen: false  // New state attribute
  };

  this.getBlogItems = this.getBlogItems.bind(this);
  this.onScroll = this.onScroll.bind(this);
  this.handleNewBlogClick = this.handleNewBlogClick.bind(this);  // New binding
}
```

### 3. Create Click Handler Function

**Add handleNewBlogClick method in Blog component**:

```javascript
handleNewBlogClick() {
  this.setState({
    blogModalIsOpen: true
  });
}
```

### 4. Pass Props to BlogModal

**Update BlogModal call in render method**:

```javascript
render() {
  const blogRecords = this.state.blogItems.map(blogItem => {
    return <BlogItem key={blogItem.id} blogItem={blogItem} />;
  });

  return (
    <div className="blog-container">
      <BlogModal modalIsOpen={this.state.blogModalIsOpen} />

      <div className="new-blog-link">
        <a onClick={this.handleNewBlogClick}>Open Modal!</a>
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

---

## 📖 Concepts

### Parent-Child State Communication Pattern

**Data flow architecture**:

```javascript
// Parent (Blog) manages state
this.state = { blogModalIsOpen: false };

// Parent passes state to child as props
<BlogModal modalIsOpen={this.state.blogModalIsOpen} />

// Child receives and uses props
<ReactModal isOpen={this.props.modalIsOpen}>
```

**Benefits of this pattern**:

- **Single source of truth** - parent component controls modal state
- **Reusable child** - BlogModal can be used with different parents
- **Clear responsibility** - parent handles logic, child handles display
- **React best practices** - unidirectional data flow

### Event Handler Binding Pattern

**Why binding needed**:

```javascript
// Method definition
handleNewBlogClick() {
  this.setState({ ... });  // 'this' needs to reference component
}

// Binding in constructor
this.handleNewBlogClick = this.handleNewBlogClick.bind(this);
```

**Alternative patterns**:

```javascript
// Arrow function (auto-binding)
handleNewBlogClick = () => {
  this.setState({ ... });
}

// Inline arrow function (not recommended for performance)
onClick={() => this.handleNewBlogClick()}
```

### Modal State Management Logic

**Current flow**:

1. **Initial state**: `blogModalIsOpen: false` → modal hidden
2. **User clicks link**: triggers `handleNewBlogClick`
3. **setState called**: `blogModalIsOpen: true`
4. **React re-renders**: passes new props to BlogModal
5. **Modal opens**: `isOpen={true}` in ReactModal

**Missing piece (future implementation)**:

- **Close functionality** - how to set `blogModalIsOpen: false`
- **ESC key support** - ReactModal onRequestClose prop
- **Click outside** - automatic close behaviour

### Component Communication Patterns

**Props vs State decision**:

- **BlogModal** - receives `modalIsOpen` as **props** (doesn't own the state)
- **Blog component** - manages `blogModalIsOpen` as **state** (owns the logic)

**Why this separation**:

- **BlogModal** - pure presentation component, no business logic
- **Blog component** - orchestrates all blog-related state and behaviour
- **Scalability** - easy to add more modal controls (close, form submission, etc.)

### React Re-rendering Behaviour

**setState triggers re-render**:

1. **handleNewBlogClick** calls `setState`
2. **React schedules re-render** of Blog component
3. **render method executes** with new state
4. **BlogModal receives new props** → `modalIsOpen={true}`
5. **ReactModal re-renders** → modal becomes visible

### Click Event Handler Patterns

**Current implementation**:

```javascript
<a onClick={this.handleNewBlogClick}>Open Modal!</a>
```

**Professional alternatives**:

```javascript
// Button (more semantic)
<button onClick={this.handleNewBlogClick}>Open Modal!</button>

// Icon-based trigger
<FontAwesomeIcon icon="plus" onClick={this.handleNewBlogClick} />

// Styled div (if complex styling needed)
<div className="modal-trigger" onClick={this.handleNewBlogClick}>
```

---

## ✅ Verification

### 1. Initial State Testing

**Page load behaviour**:

1. **Navigate to /blog**
2. **Modal should NOT appear** - blogModalIsOpen defaults to false
3. **See "Open Modal!" link** - trigger element visible
4. **Normal blog content** - posts load normally

### 2. Click Interaction Testing

**Modal opening functionality**:

1. **Click "Open Modal!" link**
2. **Modal should appear** - overlay covers page
3. **Modal content visible** - "I'm in a modal!" text
4. **State change confirmed** - blogModalIsOpen now true

### 3. State Flow Verification with React DevTools

**Before clicking**:

1. **Open React DevTools**
2. **Select Blog component**
3. **Check State**: `blogModalIsOpen: false`

**After clicking**:

1. **Click "Open Modal!" link**
2. **State updates**: `blogModalIsOpen: true`
3. **BlogModal props**: `modalIsOpen: true`

### 4. Multiple Click Testing

**Repeated interaction**:

- **Click multiple times** - modal should stay open (already true)
- **No JavaScript errors** - clean console output
- **Consistent behaviour** - works every time

### 5. Props Passing Verification

**Component tree inspection**:

1. **Blog component** - has `blogModalIsOpen` in state
2. **BlogModal component** - receives `modalIsOpen` in props
3. **ReactModal component** - receives `isOpen` from parent

---

## 🎨 Current Limitations and Future Implementation

### What Works Now

- **Modal opens on click** - user-controlled modal visibility
- **Props-based control** - parent → child communication
- **State management** - proper React state patterns
- **Event handling** - click triggers state change

### What's Still Missing

**✗ Not implemented yet**:

- **Close functionality** - modal stays open permanently once opened
- **ESC key support** - no keyboard interaction
- **Click outside to close** - ReactModal feature not configured
- **Form integration** - actual blog creation functionality

---

### Professional Development Pattern Review

**Pattern established**:

```javascript
// 1. Parent manages state
this.state = { modalOpen: false };

// 2. Parent provides trigger
<button onClick={this.openModal}>Open</button>

// 3. Parent passes state to child
<Modal isOpen={this.state.modalOpen} />

// 4. Child uses props for display
<ReactModal isOpen={this.props.isOpen}>
```

**This pattern scales to**:

- Multiple modals (different state properties)
- Complex forms (form state management)
- API integration (loading states)
- Error handling (error state display)

---

