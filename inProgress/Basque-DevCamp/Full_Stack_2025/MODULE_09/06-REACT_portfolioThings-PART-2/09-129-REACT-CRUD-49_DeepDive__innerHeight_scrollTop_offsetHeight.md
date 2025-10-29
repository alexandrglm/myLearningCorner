# 09-129: Deep Dive in innerHeight, scrollTop, offsetHeight

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/deep-dive-innerheight-scrolltop-offsetheight)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 22939cb7511682810b8f294603312bbfdfafe5d2](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/22939cb7511682810b8f294603312bbfdfafe5d2)

[Window: innerHeight property - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/Window/innerHeight)

[Element: scrollTop property - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/Element/scrollTop)

[HTMLElement: offsetHeight property - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/offsetHeight)

---

## 🎯 Objectives

**Understand three key properties for infinite scroll mathematics**:

- **window.innerHeight** - height of browser viewport in pixels
- **document.documentElement.scrollTop** - current scroll position in pixels  
- **document.documentElement.offsetHeight** - total height of entire document
- **Bottom detection logic** - when user reaches bottom using mathematical comparison
- **Console logging for visualisation** - see values change in real-time during scroll
- **Vanilla JavaScript approach** - pure browser APIs, no React-specific code

**Key mathematical formula**: `innerHeight + scrollTop === offsetHeight` = user reached bottom

---

## 🛠️ Implementation

### 1. Console Testing of Properties (Browser Console)

**For understanding, test in browser console first**:

```javascript
// Test window height
window.innerHeight  // Returns viewport height in pixels

// Test scroll position  
document.documentElement.scrollTop  // Returns current scroll position

// Test document height
document.documentElement.offsetHeight  // Returns total document height
```

### 2. Add Console Logging for All Three Properties

**File**: `src/components/pages/blog.js`

**Update activateInfiniteScroll method**:

```javascript
activateInfiniteScroll() {
  window.onscroll = () => {
    console.log("window.innerHeight", window.innerHeight);
    console.log(
      "document.documentElement.scrollTop",
      document.documentElement.scrollTop
    );
    console.log(
      "document.documentElement.offsetHeight",
      document.documentElement.offsetHeight
    );
  };
}
```

### 3. Add Bottom Detection Logic

**Add conditional within onscroll handler**:

```javascript
activateInfiniteScroll() {
  window.onscroll = () => {
    if (
      window.innerHeight + document.documentElement.scrollTop ===
      document.documentElement.offsetHeight
    ) {
      console.log("get more posts");
    }
  };
}
```

---

## 📚 Concepts

### Window.innerHeight Explained

**Definition**: Height in pixels of browser window viewport including horizontal scrollbar if rendered

**In simple terms**: Height of browser window that user can see

**Characteristics**:

- **Dynamic value** - changes when user resizes browser window
- **User-specific** - depends on screen resolution, browser size
- **Static during session** - doesn't change unless user resizes window
- **Critical component** - represents visible area height

**Example values**:

```javascript
// Small browser window
window.innerHeight  // 400

// Larger browser window  
window.innerHeight  // 800
```

### Document.documentElement.scrollTop Explained

**Definition**: Number of pixels that element's content has been scrolled vertically

**In simple terms**: How many pixels user has scrolled down from top

**Characteristics**:

- **Dynamic value** - constantly changes as user scrolls
- **Read/write property** - can get current value or set scroll position programmatically
- **Starts at 0** - top of page
- **Increases as scroll down** - grows with downward scrolling
- **Useful for programmatic scrolling** - can set value to send user to specific position

**Example values during scroll**:

```javascript
// At top of page
document.documentElement.scrollTop  // 0

// Scrolled down middle
document.documentElement.scrollTop  // 533

// Near bottom
document.documentElement.scrollTop  // 1454
```

### Document.documentElement.offsetHeight Explained

**Definition**: Read-only property that returns height of element including vertical padding and borders

**In simple terms**: Total height of entire document from top to bottom

**Characteristics**:

- **Read-only property** - cannot be modified, only accessed
- **Total document height** - includes all content, padding, borders
- **Static value** - doesn't change unless content added/removed
- **Page-specific** - different values for different pages based on content
- **Critical for bottom detection** - represents maximum scroll position

**Example comparison**:

```javascript
// Blog page (shorter content)
document.documentElement.offsetHeight  // 1630

// Portfolio manager (longer content)  
document.documentElement.offsetHeight  // 3208
```

### The Mathematical Formula

**Bottom detection calculation**:

```javascript
window.innerHeight + document.documentElement.scrollTop === document.documentElement.offsetHeight
```

**Visual explanation**:

```
┌─────────────────────┐ ← Top of document (scrollTop = 0)
│                     │
│   Content       │ ← scrollTop increases as user scrolls down
│   Above         │
│   Viewport      │
├─────────────────────┤ ← Current viewport top (scrollTop value)
│███████████████████│ ← Visible viewport (innerHeight)
│███████████████████│
│███████████████████│
├─────────────────────┤ ← Viewport bottom (scrollTop + innerHeight)
│                     │
│   Content       │
│   Below         │
│   Viewport      │
└─────────────────────┘ ← Bottom of document (offsetHeight)

When scrollTop + innerHeight = offsetHeight → User reached bottom!
```

### Why Triple Equals (===) Important

**Exact equality needed**:

```javascript
// ✅ Correct - exact match
window.innerHeight + document.documentElement.scrollTop === document.documentElement.offsetHeight

// ❌ Wrong - could fire too early
window.innerHeight + document.documentElement.scrollTop >= document.documentElement.offsetHeight
```

**Reasoning**:

- **Precise detection** - only trigger exactly when bottom reached
- **Prevent multiple triggers** - avoid firing before actually at bottom
- **Mathematical accuracy** - scroll calculations need exact values

### Vanilla JavaScript Benefits

**Pure browser API approach**:

- **Universal compatibility** - works in any web application
- **Not React-specific** - transferable knowledge
- **Direct browser interaction** - no framework overhead
- **Performance benefits** - direct API calls
- **Learning fundamentals** - understanding core web technologies

---

## ✋ Verification

### Console Output Testing

**Manual verification process**:

1. **Navigate to /blog** page

2. **Open DevTools** → Console tab

3. **Start scrolling down** - observe console logs

4. **Expected output per scroll increment**:
   
   ```
   window.innerHeight 176
   document.documentElement.scrollTop 0
   document.documentElement.offsetHeight 1630
   
   window.innerHeight 176  
   document.documentElement.scrollTop 45
   document.documentElement.offsetHeight 1630
   
   // ... more entries as you scroll
   ```

### Property Value Analysis

**Understanding value changes**:

- **innerHeight**: Should remain constant (176 in example) - browser window size
- **scrollTop**: Should increase from 0 as you scroll down (0 → 45 → 100 → 533...)
- **offsetHeight**: Should remain constant (1630 in example) - total document size

### Bottom Detection Testing

**Testing the mathematical formula**:

1. **Scroll slowly towards bottom** of blog page
2. **Watch console values** getting closer
3. **When you reach exact bottom**:
   
   ```
   get more posts
   ```
4. **Test multiple times** - should trigger each time you hit exact bottom
5. **Verify precision** - only triggers at exact mathematical equality

### Manual Mathematical Verification

**Example calculation verification**:

```javascript
// When at bottom, these values should be equal:
innerHeight: 176
scrollTop: 1454  
offsetHeight: 1630

// Manual maths check:
176 + 1454 = 1630 ✅ (equals offsetHeight)
```

### Different Page Testing

**Verify properties work on different pages**:

1. **Navigate to /portfolio-manager**
2. **Test same console commands**
3. **Expected differences**:
   - **innerHeight**: Same (browser window unchanged)
   - **offsetHeight**: Different (more content = higher value)
   - **scrollTop**: Resets to 0 (new page load)

---

## 🎨 Advanced Understanding

### Browser Window Resize Effects

**Dynamic innerHeight behaviour**:

```javascript
// Test resizing browser window
console.log(window.innerHeight); // e.g., 400
// Resize window larger
console.log(window.innerHeight); // e.g., 600
// Resize window smaller  
console.log(window.innerHeight); // e.g., 300
```

### Scroll Position Manipulation

**Programmatic scrolling example**:

```javascript
// Set scroll position programmatically
document.documentElement.scrollTop = 500; // Jumps to 500px down

// Smooth scroll to top
document.documentElement.scrollTop = 0;

// Smooth scroll to bottom
document.documentElement.scrollTop = document.documentElement.offsetHeight;
```

### Cross-Page Comparison

**Document height varies by content**:

```javascript
// Blog page (less content)
document.documentElement.offsetHeight  // ~1630px

// Portfolio Manager (more content)
document.documentElement.offsetHeight  // ~3208px

// Home page (different content)
document.documentElement.offsetHeight  // Different value
```

### Event Frequency Understanding

**Scroll event firing frequency**:

- **High frequency events** - fires many times per scroll action
- **Performance considerations** - every pixel of scroll triggers event
- **Smooth scrolling** - multiple events during single scroll gesture
- **Optimisation needed** - future guides will address throttling

### Real-World Applications

**Other use cases for these properties**:

1. **Progress indicators** - show scroll percentage
2. **Sticky navigation** - show/hide based on scroll position
3. **Lazy loading** - load images when approaching viewport
4. **Reading progress** - estimate reading completion
5. **Infinite scroll** - our current implementation
6. **Return to top buttons** - show when scrolled down significantly

---

