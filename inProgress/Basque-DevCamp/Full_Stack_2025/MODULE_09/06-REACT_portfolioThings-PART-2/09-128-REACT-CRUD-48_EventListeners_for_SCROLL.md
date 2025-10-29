# 09-128: Event Listener JavaScript for Scroll Events

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-javascript-event-listener-scroll-events)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at e8fd69c7f2af781592e24462a44889f4b79821d4](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/e8fd69c7f2af781592e24462a44889f4b79821d4)

---

## 🎯 Objectives

**Establish foundation for infinite scroll with vanilla JavaScript**:

- **Window object exploration** - understanding browser window properties
- **Scroll event listener** - capture user scroll behaviour using window.onscroll  
- **Anonymous function handler** - execute actions when scroll occurs
- **Integration with React** - call activateInfiniteScroll from constructor
- **Console.log verification** - confirm scroll detection working properly
- **Advanced React concepts** - bypass virtual DOM for direct browser interaction

**IMPORTANT**: Browser zoom must be at **100%** for this to work correctly

**Warning about difficulty**: This is advanced functionality - not typical beginner React content

---

## 🛠️ Implementation

### 1. Create activateInfiniteScroll Method

**File**: `src/components/pages/blog.js`

**Add method after constructor**:

```javascript
activateInfiniteScroll() {
  window.onscroll = () => {
    console.log("onscroll");
  };
}
```

### 2. Call Method from Constructor

**In constructor, after binding getBlogItems**:

```javascript
constructor() {
  super();

  this.state = {
    blogItems: []
  };

  this.getBlogItems = this.getBlogItems.bind(this);

  this.activateInfiniteScroll();
}
```

### 3. Complete Code So Far

**Updated file up to this point**:

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import BlogItem from "../blog/blog-item";

export default class Blog extends Component {
  constructor() {
    super();

    this.state = {
      blogItems: []
    };

    this.getBlogItems = this.getBlogItems.bind(this);

    this.activateInfiniteScroll();
  }

  activateInfiniteScroll() {
    window.onscroll = () => {
      console.log("onscroll");
    };
  }

  getBlogItems() {
    axios
      .get("https://jordan.devcamp.space/portfolio/portfolio_blogs", {
        withCredentials: true
      })
      .then(response => {
        this.setState({
          blogItems: response.data.portfolio_blogs
        });
      })
      .catch(error => {
        console.log("getBlogItems error", error);
      });
  }

  componentWillMount() {
    this.getBlogItems();
  }

  render() {
    const blogRecords = this.state.blogItems.map(blogItem => {
      return <BlogItem key={blogItem.id} blogItem={blogItem} />;
    });

    return (
      <div className="blog-container">
        <div className="content-container">
          {blogRecords}
        </div>
      </div>
    );
  }
}
```

---

## 📚 Concepts

### Window Object Exploration

**What is window in browser?**:

```javascript
// In browser console, type:
window
```

**Window object contains**:

- **Entire browser context** - entire application
- **Font Awesome config** - libraries loaded
- **System properties** - screen size, device info
- **Navigation methods** - scrolling, history
- **Event handling capabilities** - listen for user interactions
- **DOM access** - complete access to document structure

### Event Listener Concepts

**Traditional event listeners vs onscroll**:

```javascript
// Traditional approach (more complex)
window.addEventListener('scroll', function() {
  console.log('scroll event');
});

// Simplified approach (used in guide)
window.onscroll = () => {
  console.log('onscroll');
};
```

**Why onscroll approach?**:

- **Simpler syntax** - less boilerplate code
- **Direct assignment** - easier to understand
- **Same functionality** - captures scroll events effectively
- **Good for learning** - clearer concept demonstration

### Anonymous Arrow Functions

**Function syntax explanation**:

```javascript
window.onscroll = () => {
  // Anonymous arrow function
  // No arguments needed
  // Executes every time scroll occurs
};
```

**Why anonymous function?**:

- **No need for reuse** - only used in this context
- **Event-specific logic** - tailored for scroll detection
- **Cleaner code** - no extra function definitions needed
- **Modern JavaScript** - arrow function syntax

### Bypassing React Virtual DOM

**Direct browser interaction**:

```javascript
// React way (virtual DOM)
<div onScroll={this.handleScroll}>

// Direct browser way (this guide)
window.onscroll = () => {
  // Direct access to browser window
};
```

**Why bypass virtual DOM here?**:

- **Page-level scrolling** - not component-specific
- **Global event** - affects entire page, not just component
- **Performance reasons** - direct browser API more efficient for scroll
- **Browser window scope** - React components don't own window

### Browser Zoom Requirement

**Why 100% zoom required?**:

```
Browser zoom affects:
- Window dimensions calculation
- Scroll position measurements  
- Document height calculations
- ScrollTop values accuracy
```

**Zoom effect on scroll calculations**:

- **67% zoom** - measurements skewed, maths incorrect
- **100% zoom** - accurate pixel measurements
- **150% zoom** - calculations also off
- **Root cause** - browser scaling affects DOM measurements

### Constructor vs Other Lifecycle Methods

**Why call from constructor?**:

```javascript
constructor() {
  // Called once when component mounts
  this.activateInfiniteScroll(); // Set up once
}

// vs

componentDidMount() {
  // Also called once, but after render
  this.activateInfiniteScroll(); // Could work but constructor is fine
}
```

**Constructor benefits for scroll setup**:

- **Immediate setup** - before first render
- **One-time initialisation** - scroll listener needs to be set once
- **Simple approach** - no complexity of lifecycle timing

---

## ✋ Verification

### Console Testing

**Manual verification steps**:

1. **Navigate to /blog page** - should load normally
2. **Open DevTools** → Console tab
3. **Scroll down on page** - any amount of scrolling
4. **Verify console output**:
   
   ```
   onscroll
   onscroll  
   onscroll
   (multiple entries as you scroll)
   ```

### Scroll Event Frequency

**Expected behaviour**:

- **Multiple console logs** - one per scroll increment
- **Real-time detection** - logs appear as you scroll
- **Continuous monitoring** - works throughout page lifetime
- **No performance issues** - smooth scrolling maintained

### Browser Zoom Verification

**Critical requirement testing**:

1. **Check current zoom level** - should be 100%
2. **If not 100%**:
   - **Ctrl/Cmd + 0** - reset to 100%
   - **Manual zoom** - adjust in browser settings
3. **Verify scroll detection** - test again after zoom correction
4. **Future debugging** - remember this requirement if issues arise

### Event Handler Functionality

**Confirm proper setup**:

- **No binding needed** - function doesn't use `this`
- **Arrow function works** - captures scroll events
- **Console output clear** - easy to verify functionality
- **No React warnings** - proper integration with React lifecycle

### Page Scrollability

**Ensure page has enough content to scroll**:

- **Multiple blog posts** - should create scrollable content
- **Page height exceeds** - viewport height
- **Vertical scroll bar visible** - indicates scrollable content
- **Smooth scrolling** - no jerky movement

---

## 🎨 Advanced Concepts Preview

### Window Properties Available

**Properties we'll explore in next guides**:

```javascript
window.innerHeight    // Viewport height
window.scrollY        // Current scroll position  
document.body.offsetHeight  // Total document height
```

### Infinite Scroll Maths

**Basic calculation preview**:

```javascript
// When to load more content
if (window.scrollY + window.innerHeight >= document.body.offsetHeight) {
  // User reached bottom → load more posts
}
```

### Event Handler Evolution

**Current state (simple)**:

```javascript
window.onscroll = () => {
  console.log("onscroll");
};
```

**Future state (functional)**:

```javascript
window.onscroll = () => {
  // Complex calculations
  // API calls for more data
  // State updates
  // Loading indicators
};
```

### Performance Considerations

**Why scroll events are challenging**:

- **High frequency** - fired many times per scroll
- **Performance impact** - can cause lag if not optimised
- **Throttling needed** - limit function execution frequency
- **Cleanup required** - remove listeners when component unmounts

---

