# 09-138: Applying Custom Styles to React Modal

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/applying-custom-styles-react-modal)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 4ada1dfdfb8e6354a2a434a474422f4b91307792](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/4ada1dfdfb8e6354a2a434a474422f4b91307792)

---

## 🎯 Objectives

**Implement professional custom styling for modal using inline styles**:

- **Inline styles approach** - ReactModal recommended pattern to override defaults
- **Centre modal** - proper positioning with CSS transform techniques
- **Size control** - appropriate width and height for modal content
- **Dark overlay effect** - professional backdrop with rgba transparency
- **CSS cascade priority** - inline styles override library defaults
- **React JSX styling syntax** - camelCase properties and object format

**Goal**: Transform basic modal appearance into professional-looking interface with proper sizing and visual hierarchy.

---

## 🛠️ Implementation

### 1. Create Custom Styles Object in Constructor

**File**: `src/components/modals/blog-modal.js`

**Add customStyles object in constructor**:

```javascript
import React, { Component } from "react";
import ReactModal from "react-modal";

export default class BlogModal extends Component {
  constructor(props) {
    super(props);

    this.customStyles = {
      content: {
        top: "50%",
        left: "50%", 
        right: "auto",
        marginRight: "-50%",
        transform: "translate(-50%, -50%)",
        width: "800px"
      },
      overlay: {
        backgroundColor: "rgba(1, 1, 1, 0.75)"
      }
    };
  }

  render() {
    return (
      <ReactModal 
        style={this.customStyles}
        onRequestClose={() => {
          this.props.handleModalClose();
        }}
        isOpen={this.props.modalIsOpen}
      >
        <h1>I'm in a modal!</h1>
      </ReactModal>
    );
  }
}
```

---

## 📖 Concepts

### Inline Styles vs Stylesheet Approach

**Why inline styles for ReactModal**:

- **CSS cascade priority** - inline styles always override external stylesheets
- **Component isolation** - styles contained within component
- **Dynamic styling** - easy to pass props or conditional styles
- **Library compatibility** - ReactModal designed for inline style overrides

**CSS specificity hierarchy**:

```
1. Inline styles (highest priority)
2. IDs 
3. Classes
4. Elements (lowest priority)
```

### ReactModal Class Structure

**Built-in classes that ReactModal provides**:

- **content** - main modal content area
- **overlay** - background area outside modal
- **Other classes** - available in documentation for additional customisation

**Style object structure**:

```javascript
this.customStyles = {
  content: {
    // Styles for modal content box
  },
  overlay: {
    // Styles for background overlay
  }
};
```

### CSS Centring Technique Explained

**Perfect centring formula**:

```javascript
top: "50%",           // Move down 50% of parent
left: "50%",          // Move right 50% of parent  
right: "auto",        // Don't set right positioning
marginRight: "-50%",  // Compensate for centring
transform: "translate(-50%, -50%)", // Adjust for own dimensions
```

**Why this technique works**:

- **`top: 50%, left: 50%`** - positions top-left corner at centre
- **`transform: translate(-50%, -50%)`** - moves element back by half its own width/height
- **Result** - true centre regardless of content size

### RGBA Colour Explanation

**RGBA breakdown**:

```javascript
backgroundColor: "rgba(1, 1, 1, 0.75)"
//                    ^  ^  ^   ^
//                    |  |  |   └── Alpha (opacity): 0.75 = 75% opacity
//                    |  |  └── Blue: 1 (very dark)
//                    |  └── Green: 1 (very dark) 
//                    └── Red: 1 (very dark)
```

**Colour result**: Nearly black (1,1,1) with 75% opacity = dark transparent overlay

**Alternative formats**:

```javascript
// Hexadecimal equivalent (no transparency)
backgroundColor: "#010101"

// Named colour (no transparency control)
backgroundColor: "black"

// HSL with transparency
backgroundColor: "hsla(0, 0%, 0%, 0.75)"
```

### JSX Styling Syntax Requirements

**JSX style object rules**:

```javascript
// ✓ Correct JSX syntax
style={{
  backgroundColor: "red",    // camelCase property names
  fontSize: "16px",         // string values
  marginTop: "10px"         // camelCase for hyphenated CSS
}}

// ✗ Wrong - CSS syntax in JSX
style={{
  "background-color": "red", // hyphenated names
  font-size: 16px           // invalid syntax
}}
```

### CSS Property Transformation Rules

**CSS → JSX conversion**:

```javascript
// CSS Properties → JSX Properties
background-color → backgroundColor
font-size → fontSize
margin-top → marginTop
border-radius → borderRadius
text-align → textAlign
```

### Professional Modal Dimensions

**Width considerations**:

- **800px width** - good for forms, content, readable text
- **Responsive consideration** - may need media queries for mobile
- **Content-based sizing** - adjust based on modal content requirements

**Alternative sizing approaches**:

```javascript
// Percentage-based
width: "80%",
maxWidth: "800px",

// Viewport-based  
width: "80vw",
height: "80vh",

// Content-based
minWidth: "500px",
maxWidth: "1200px",
```

---

## ✅ Verification

### 1. Modal Positioning Test

**Expected behaviour**:

1. **Open modal** - click "Open Modal!" link
2. **Verify centring** - modal appears in exact centre of viewport
3. **Resize browser** - modal remains centred
4. **Scroll page** - modal stays centred (fixed positioning)

### 2. Size Verification

**Visual checks**:

- **Width** - modal should be 800px wide (reasonable reading width)
- **Height** - adjusts automatically to content
- **Not full-screen** - clearly differentiated from page content
- **Professional appearance** - looks like real modal, not takeover

### 3. Overlay Effect Testing

**Background overlay**:

1. **Open modal** - click trigger link
2. **Check background** - should be darkened but still visible
3. **Colour verification** - dark overlay, not pure black
4. **Transparency working** - can still see page content behind

### 4. Responsive Behaviour

**Browser resize testing**:

- **Large screens** - modal remains centred and appropriately sized
- **Medium screens** - 800px width may need adjustment (future enhancement)
- **Scroll behaviour** - overlay covers entire viewport

### 5. Style Override Verification

**CSS cascade testing**:

- **Library defaults overridden** - no default ReactModal appearance
- **Custom styles applied** - centring and sizing working
- **Inline priority** - styles not being overridden by external CSS

---

## 🎨 Visual Design Analysis

### Before vs After Comparison

**Before (default ReactModal)**:

- ✗ **Takes up entire screen** - defeats purpose of modal
- ✗ **White background overlay** - looks unfinished
- ✗ **Poor positioning** - not visually centred
- ✗ **No size control** - content determines everything

**After (custom styles)**:

- ✓ **Appropriate size** - 800px width, reasonable for content
- ✓ **Perfect centring** - both horizontal and vertical
- ✓ **Professional overlay** - dark, transparent background
- ✓ **Clear modal distinction** - obviously separate from page content

### Professional Modal Standards

**Industry-standard modal characteristics**:

- ✓ **Centred positioning** - user focus directed to modal
- ✓ **Dark overlay** - reduces distraction from background
- ✓ **Appropriate sizing** - not too small, not overwhelming
- ✓ **Fixed positioning** - doesn't scroll with page content
- ✓ **Clear boundaries** - obvious separation from page

### ReactModal Flexibility Demonstrated

**Customisation possibilities shown**:

- **Complete style control** - override any visual aspect
- **Conditional styling** - could change styles based on props
- **Dynamic sizing** - could adjust based on content type
- **Theme integration** - could use app-wide colour variables

---
