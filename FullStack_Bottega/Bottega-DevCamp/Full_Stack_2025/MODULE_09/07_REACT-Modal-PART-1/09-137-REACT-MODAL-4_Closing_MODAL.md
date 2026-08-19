# 09-137: How to Close React Modal

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-close-react-modal)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 87a9986dc20329511b1eab01997c32d1980e734c](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/87a9986dc20329511b1eab01997c32d1980e734c)

---

## 🎯 Objectives

**Implement multiple ways to close the modal with standard user experience**:

- **Click outside modal** - close when user clicks outside the modal area
- **ESC key support** - close with keyboard ESC key
- **onRequestClose prop** - use ReactModal built-in functionality
- **Create close handler** - function in parent component for state control
- **Props passing pattern** - pass close function as prop to modal
- **Test user interactions** - verify standard modal closing behaviours

**Goal**: Fully functional modal with open and close capabilities, following UX patterns expected by users.

---

## 🛠️ Implementation

### 1. Add onRequestClose Prop to ReactModal

**File**: `src/components/modals/blog-modal.js`

**Add onRequestClose with test function**:

```javascript
import React, { Component } from "react";
import ReactModal from "react-modal";

export default class BlogModal extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <ReactModal 
        onRequestClose={() => {
          console.log("testing modal close");
        }}
        isOpen={this.props.modalIsOpen}
      >
        <h1>I'm in a modal!</h1>
      </ReactModal>
    );
  }
}
```

### 2. Test onRequestClose Functionality

**Testing steps**:

1. **Open modal** - click "Open Modal!" link
2. **Open browser console** - DevTools → Console
3. **Click outside modal** - should see "testing modal close" in console
4. **Press ESC key** - should see "testing modal close" in console

**Verification**: ReactModal automatically detects both interactions and fires onRequestClose function.

### 3. Replace Test Function with Props-Based Handler

**Update onRequestClose to use props**:

```javascript
render() {
  return (
    <ReactModal 
      onRequestClose={() => {
        this.props.handleModalClose();
      }}
      isOpen={this.props.modalIsOpen}
    >
      <h1>I'm in a modal!</h1>
    </ReactModal>
  );
}
```

### 4. Create handleModalClose in Blog Component

**File**: `src/components/pages/blog.js`

**Add method and binding in constructor**:

```javascript
constructor() {
  super();

  this.state = {
    blogItems: [],
    totalCount: 0,
    currentPage: 0,
    isLoading: true,
    blogModalIsOpen: false
  };

  this.getBlogItems = this.getBlogItems.bind(this);
  this.onScroll = this.onScroll.bind(this);
  window.addEventListener("scroll", this.onScroll, false);
  this.handleNewBlogClick = this.handleNewBlogClick.bind(this);
  this.handleModalClose = this.handleModalClose.bind(this);  // New binding
}

handleModalClose() {
  this.setState({
    blogModalIsOpen: false
  });
}

handleNewBlogClick() {
  this.setState({
    blogModalIsOpen: true
  });
}
```

### 5. Pass handleModalClose as Prop

**Update BlogModal call in render method**:

```javascript
render() {
  const blogRecords = this.state.blogItems.map(blogItem => {
    return <BlogItem key={blogItem.id} blogItem={blogItem} />;
  });

  return (
    <div className="blog-container">
      <BlogModal 
        handleModalClose={this.handleModalClose}
        modalIsOpen={this.state.blogModalIsOpen} 
      />

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

### onRequestClose Prop Functionality

**ReactModal built-in behaviours**:

- **Click outside detection** - automatically detects clicks outside modal content
- **ESC key detection** - automatically listens for ESC key presses
- **Callback execution** - runs provided function when any close trigger occurs
- **Customisable behaviour** - you control what happens when close requested

**Why this approach is powerful**:

- **Standard UX** - implements expected modal behaviours automatically
- **Accessibility** - keyboard navigation support built-in
- **Flexibility** - you decide actual close logic
- **Consistency** - same behaviour across all ReactModal instances

### Function vs Callback Prop Patterns

**Props expecting functions**:

```javascript
// onRequestClose expects a FUNCTION
onRequestClose={() => {
  this.props.handleModalClose();  // Call with parentheses
}}

// isOpen expects a VALUE  
isOpen={this.props.modalIsOpen}  // No parentheses
```

**Why parentheses matter**:

- **With parentheses** `()` - executes function immediately
- **Without parentheses** - passes function reference
- **Anonymous functions** - wrap execution for proper timing

### Anonymous Function Wrapper Pattern

**Why use anonymous function wrapper**:

```javascript
// ✓ Correct - anonymous function wrapper
onRequestClose={() => {
  this.props.handleModalClose();
}}

// ✗ WRONG - executes immediately during render
onRequestClose={this.props.handleModalClose()}

// ✓ Alternative - direct reference (if no parameters needed)
onRequestClose={this.props.handleModalClose}
```

**Benefits of wrapper**:

- **Controlled execution** - only runs when event occurs
- **Parameter passing** - easy to pass parameters if needed
- **Additional logic** - can add multiple statements

### Modal State Management Pattern

**Complete open/close cycle**:

```javascript
// Initial state
blogModalIsOpen: false  // Modal hidden

// User clicks "Open Modal!"
handleNewBlogClick() {
  this.setState({ blogModalIsOpen: true });  // Modal shows
}

// User clicks outside or presses ESC
handleModalClose() {
  this.setState({ blogModalIsOpen: false }); // Modal hides
}
```

### ReactModal Documentation Reference

**How to learn about props**:

1. **Visit [react-modal docs](https://www.npmjs.com/package/react-modal)**
2. **Read prop descriptions** - each prop documented with examples
3. **Check examples** - CodePen examples show real usage
4. **API reference** - complete list of available props

**Professional development habit**:

- **Always read docs** - don't guess prop names
- **Study examples** - learn common patterns
- **Understand options** - know what's possible before coding

### Parent-Child Communication Review

**Data flow pattern**:

```javascript
// Parent (Blog) owns state
this.state = { blogModalIsOpen: false };

// Parent creates handler function
handleModalClose() { setState... }

// Parent passes both to child
<BlogModal 
  modalIsOpen={this.state.blogModalIsOpen}
  handleModalClose={this.handleModalClose}
/>

// Child uses props for display and behaviour
<ReactModal 
  isOpen={this.props.modalIsOpen}
  onRequestClose={this.props.handleModalClose}
/>
```

---

## ✅ Verification

### 1. Click Outside Modal Testing

**Testing sequence**:

1. **Navigate to /blog**
2. **Click "Open Modal!"** - modal should open
3. **Click on dark overlay** (outside modal content) - modal should close
4. **Repeat test** - should work consistently

### 2. ESC Key Testing

**Keyboard interaction**:

1. **Open modal** again
2. **Press ESC key** - modal should close immediately
3. **Test from different focused elements** - should work regardless
4. **Verify no browser conflicts** - ESC should only close modal

### 3. State Flow Verification

**React DevTools inspection**:

**Before any interaction**:

- Blog component state: `blogModalIsOpen: false`

**After clicking "Open Modal!"**:

- Blog component state: `blogModalIsOpen: true`
- BlogModal props: `modalIsOpen: true`

**After closing modal (any method)**:

- Blog component state: `blogModalIsOpen: false`
- BlogModal props: `modalIsOpen: false`

### 4. Multiple Open/Close Cycles

**Stress testing**:

1. **Open modal** → **close with click outside**
2. **Open modal** → **close with ESC key**
3. **Open modal** → **close with click outside**
4. **Open modal** → **close with ESC key**

**Expected behaviour**: All cycles work smoothly without errors.

### 5. Console Verification

**No JavaScript errors**:

- ✅ **Clean console** - no error messages
- ✅ **No prop warnings** - React recognises all props
- ✅ **No binding errors** - this context correct
- ✅ **Smooth interactions** - responsive open/close

---

## 🎨 Modal User Experience Complete

### Standard Modal Behaviours Implemented

**✓ What we now have**:

- **User-controlled opening** - click link to open
- **Click outside to close** - standard expected behaviour
- **ESC key to close** - keyboard accessibility
- **Consistent state management** - React-controlled visibility
- **No forced interactions** - user always in control

### ReactModal Flexibility Demonstrated

**Customisable behaviours possible**:

```javascript
// Could prevent closing (if required form)
onRequestClose={() => {
  if (this.formIsComplete()) {
    this.props.handleModalClose();
  } else {
    alert("Please complete required fields");
  }
}}

// Could add logging or analytics
onRequestClose={() => {
  analytics.track('modal_closed');
  this.props.handleModalClose();
}}
```

### Professional Modal Standards Met

**Industry-standard modal behaviours**:

- ✓ **Overlay background** - darkens page content
- ✓ **Focus management** - traps focus inside modal
- ✓ **Click outside closes** - expected by users
- ✓ **ESC key closes** - accessibility requirement
- ✓ **Controlled visibility** - programmatically controlled

---
