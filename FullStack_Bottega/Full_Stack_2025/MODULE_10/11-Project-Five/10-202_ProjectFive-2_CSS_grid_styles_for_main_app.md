# 10-202: CSS Grid Basic Setup for Daily Smarty UI

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/css-grid-basic-setup-daily-smarty-ui)**

---

## 🎯 Objectives

**Understand CSS Grid fundamentals**:

- **Layout analysis** - 3 main areas of the design
- **CSS Grid properties** - align-content, justify-items
- **Practice in CodePen** - before implementing in React
- **Visual debugging** - understand grid lines and behaviour

---

## 🛠️ Analysis of Final Layout

### Structure of 3 Main Areas

**In the completed application you can see**:

1. **Logo area** - top part, centred
2. **Search area** - search field with input
3. **Recent posts area** - list of recent posts

**Inspection in DevTools**:

- **Main div**: class `home`
- **3 child divs**: logo, search, recents
- **Dotted lines visible** - CSS Grid indicators
- **Each area has its own grid** - individual alignment

### Behaviour Without Grid

**When CSS Grid is disabled**:

- **Logo moves to the left** - loses centring
- **Search and Recent posts** - also lose alignment
- **Layout breaks completely** - returns to normal HTML flow
- **Clear demonstration** - importance of grid system

---

## 🛠️ Implementation in CodePen

### HTML Structure Base

```html
<div class="logo">
    logo goes here
</div>

<div class="search">
    <input placeholder="daily smarty">
</div>

<div class="recent">
    <ul>
        <li>post</li>
        <li>post</li>
        <li>post</li>
    </ul>
</div>
```

### CSS Grid Container Setup

**Initial problem**:

- **No height defined** - grid container only as tall as content
- **Limited visual effect** - no space for vertical distribution

**Solution - Base container**:

```css
.container {
    display: grid;
    height: 350px;           /* Define container height */
    background-color: skyblue; /* For visualisation */
}
```

### Align-Content: Vertical Distribution

**CSS-Tricks reference**:

- **CSS-Tricks Complete Guide to Grid** - main learning resource
- **Learning approach**: experiment + consult documentation as needed
- **Don't read everything** - use as practical reference

**align-content explained**:

> "Sometimes the total size of your grid might be less than the size of its grid container. This property aligns the grid along the block (column) axis"

```css
.container {
    align-content: space-around; /* Equal spacing top and bottom */
    /* vs space-between - no spacing at extremes */
}
```

**Visual effect**:

- **space-around**: equal spacing at top, middle, bottom
- **space-between**: spacing only between elements, not at extremes
- **Matches design** - balanced spacing as in mockup

### Justify-Items: Horizontal Alignment

**Purpose**:

> "Aligns grid items along the inline (row) axis. This value applies to all grid items inside the container"

**Key differences**:

- **align-items** → column axis (vertical)
- **justify-items** → row axis (horizontal)

```css
.container {
    justify-items: center; /* Centre items horizontally */
    /* vs stretch - stretch items to full width */
}
```

**Observed behaviour**:

- **center**: all elements centred in their grid area
- **stretch**: elements occupy full available width
- **Input field maintains** default width, but parent div stretches

---

## 📧 Deep Technical Concepts

### Grid Container vs Grid Items

**Container (parent)**:

- **display: grid** - activates grid layout
- **height: defined** - needed for effective vertical distribution
- **align-content** - controls distribution of grid areas
- **justify-items** - controls alignment of content within areas

**Items (children)**:

- **Automatically become** grid items
- **Respond to** justify-items of container
- **Each one can have** its own internal grid if needed

### Visual Debugging Approach

**Demonstrated technique**:

1. **Background color** - to see container boundaries
2. **Comment/uncomment** properties - see individual effects
3. **Element inspection** - dotted lines in DevTools
4. **Active experimentation** - change values to understand behaviour

### Recommended Learning Strategy

**Don't read complete documentation**:

- **Experiment first** - touch properties and see what happens
- **Consult as needed** - search for specific properties
- **Test variations** - center vs stretch vs space-between
- **"Mess around with different items"** - active exploration

**Benefits of approach**:

- **Practical understanding** vs theoretical
- **Better retention** - learning by doing
- **Confidence built** - through experimentation
- **Real preparation** - for complex layout problems

---

## 📋 Learning Verification

### Visual Checkpoints

**In CodePen you should see**:

1. **Logo centred** - horizontally in its area
2. **Search input centred** - in its section
3. **Recent posts list** - centred vertically
4. **Uniform spacing** - between the 3 main sections
5. **Background color visible** - to confirm container height

### Property Testing

**Experiment with**:

```css
/* Test different align-content values */
align-content: space-around;  /* Current */
align-content: space-between; /* Compare */
align-content: center;        /* Alternative */

/* Test different justify-items values */
justify-items: center;        /* Current */
justify-items: stretch;       /* See difference */
justify-items: start;         /* Left alignment */
```

---


## 🎨 **EXTENDED CONTENT**

### Advanced Grid Concepts Teased

**Multi-column exploration** (briefly tested in guide):

```css
.container {
    grid-template-columns: 1fr 1fr; /* Two columns */
}
```

**Potential future applications**:

- **Responsive layouts** - different grid structures by screen size
- **Complex component layouts** - within individual areas
- **Advanced alignment** - combine align and justify properties

### CSS-Tricks Resource Utilisation

**Effective documentation usage**:

- **Command+F search** - for specific properties
- **Visual examples focus** - pictures over text
- **Property-specific lookup** - not complete readthrough
- **Real-time application** - test immediately after reading


---
