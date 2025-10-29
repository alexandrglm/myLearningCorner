# 09-133: Refactoring Infinite Scroll Feature to Fix Memory Leak

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/refactoring-infinite-scroll-feature-fix-memory-leak)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at c0c88728f603738622f5a280e5727ac80cced795](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/c0c88728f603738622f5a280e5727ac80cced795)

[EventTarget: removeEventListener() method - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/EventTarget/removeEventListener)

---

## 🎯 Objectives

**Fix critical memory leak in infinite scroll implementation**:

- **Detect memory leak** - event listeners that persist after component unmount
- **Understand the problem** - window event listeners are not cleaned up automatically
- **Refactor event listener** - move from function to constructor for better control
- **Implement cleanup** - use componentWillUnmount to remove listeners
- **Use addEventListener/removeEventListener** - modern API instead of onscroll
- **Component lifecycle encapsulation** - each component manages its own listeners

**Current problem**: Event listener remains active when user navigates away, causing incorrect API calls on other pages.

---

## 🛠️ Implementation

### 1. Demonstrate the Memory Leak

**Testing steps to see the bug**:

1. **Go to blog page** → hit refresh → see "getting" console output
2. **DO NOT scroll to bottom** → the bug is subtle, doesn't appear if you see all records
3. **Navigate to homepage** or portfolio manager
4. **Scroll down on that page** → WARNING + incorrect API calls

**Expected console error**:

```
Warning: Can't perform a React state update on an unmounted component
getting [API response data]
```

**Why it happens**: `window.onscroll` listener remains active when component unmounts.

### 2. Refactor: Extract Listener from Function

**File**: `src/components/pages/blog.js`

**Rename function and simplify**:

```javascript
// BEFORE (with listener embedded)
activateInfiniteScroll() {
  window.onscroll = () => {
    if (
      this.state.isLoading ||
      this.state.blogItems.length === this.state.totalCount
    ) {
      return;
    }

    if (
      window.innerHeight + document.documentElement.scrollTop ===
      document.documentElement.offsetHeight
    ) {
      this.getBlogItems();
    }
  };
}

// AFTER (clean function without listener)
onScroll() {
  if (
    this.state.isLoading ||
    this.state.blogItems.length === this.state.totalCount
  ) {
    return;
  }

  if (
    window.innerHeight + document.documentElement.scrollTop ===
    document.documentElement.offsetHeight
  ) {
    this.getBlogItems();
  }
}
```

### 3. Move Event Listener to Constructor

**In constructor, after binding**:

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
  this.onScroll = this.onScroll.bind(this);

  // Add event listener in constructor
  window.addEventListener("scroll", this.onScroll, false);
}
```

### 4. Remove Call to activateInfiniteScroll

**In componentWillMount, delete**:

```javascript
componentWillMount() {
  this.getBlogItems();
  // DELETE this line
  // this.activateInfiniteScroll();
}
```

### 5. Implement Cleanup in componentWillUnmount

**Add lifecycle hook for cleanup**:

```javascript
componentWillUnmount() {
  window.removeEventListener("scroll", this.onScroll, false);
}
```

---

## 📖 Concepts

### Memory Leaks in React

**What is a memory leak**:

- **Event listener persists** after component unmount
- **Unreleased references** in memory
- **Performance degradation** - unnecessary listeners running
- **Incorrect behaviour** - functions executing in wrong context

### addEventListener vs onscroll

**window.onscroll (old approach)**:

```javascript
window.onscroll = () => {
  // Handler code
};
```

**window.addEventListener (better approach)**:

```javascript
window.addEventListener("scroll", this.onScroll, false);
```

**Advantages of addEventListener**:

- **Multiple listeners** - can have multiple listeners for same event
- **Options parameter** - third parameter for advanced configuration
- **Paired removal** - removeEventListener for perfect cleanup
- **Modern API** - recommended standard

### Event Listener Options Parameter

**addEventListener syntax**:

```javascript
target.addEventListener(type, listener, options);
```

**Parameters**:

- **type**: `"scroll"` - type of event
- **listener**: `this.onScroll` - function to execute
- **options**: `false` - boolean for useCapture or options object

**Common options**:

```javascript
// Simple boolean
window.addEventListener("scroll", handler, false);

// Options object
window.addEventListener("scroll", handler, {
  passive: true,    // Does not call preventDefault()
  once: true,       // Remove after first trigger
  capture: false    // Use capturing phase
});
```

### Component Lifecycle Encapsulation

**Fundamental principle**:

- **Each component** manages its own resources
- **Constructor** - initialise resources
- **componentWillUnmount** - cleanup resources
- **No side effects** - components should not affect other components

**Pattern applied**:

```javascript
class MyComponent {
  constructor() {
    // Setup resources
    this.timer = setInterval(...);
    window.addEventListener(...);
  }

  componentWillUnmount() {
    // Cleanup resources
    clearInterval(this.timer);
    window.removeEventListener(...);
  }
}
```

### Debugging Memory Leaks

**Symptoms of memory leaks**:

- **Console warnings** - React warnings about unmounted components
- **Incorrect behaviour** - functions executing on wrong pages
- **Performance issues** - slow app responsiveness
- **Multiple API calls** - unnecessary network requests

**Tools for detection**:

- **Browser DevTools** - Memory tab
- **React DevTools** - Component profiler
- **Console warnings** - React built-in warnings
- **Network tab** - unexpected API calls

### Event Listener Best Practices

**Do's**:

- **Add in constructor** or componentDidMount
- **Remove in componentWillUnmount**
- **Use addEventListener/removeEventListener**
- **Store listener reference** for proper removal

**Don'ts**:

- **Don't embed** listeners inside other functions
- **Don't forget cleanup** - always remove listeners
- **Don't use onscroll** - prefer addEventListener
- **Don't ignore warnings** - React warnings are serious

---

## ✅ Verification

### 1. Test Memory Leak Fix

**Steps to verify fix**:

1. **Refresh blog page** → see initial "getting" console output
2. **DO NOT scroll to bottom** → keep partial content loaded
3. **Navigate to homepage** → wait for page load
4. **Scroll down on homepage** → NO warning, NO API calls
5. **Check console** → should be clean, no errors

### 2. Test Infinite Scroll Still Works

**On blog page**:

1. **Clear console** → fresh start
2. **Refresh page** → see initial API call
3. **Scroll to bottom** → should trigger getBlogItems()
4. **See new posts** → concatenated to existing
5. **Verify loading state** → spinner shows during load

### 3. Test Multiple Page Navigation

**Cross-page testing**:

1. **Blog page** → scroll partially
2. **Homepage** → scroll down → no blog API calls
3. **Portfolio manager** → scroll down → no blog API calls
4. **Back to blog** → infinite scroll still works
5. **Console clean** → no warnings or errors

---
