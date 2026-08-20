# 10-157: Configuring Dropzone Blog Featured Image

---

**[Guide](https://devcamp.com/trails/dissecting-react-js/campsites/building-blog-react/guides/configuring-dropzone-blog-featured-image)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at dfeeb204c43223eab56a61792ed6faef8b42c995](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/dfeeb204c43223eab56a61792ed6faef8b42c995)

---

## 🎯 Objectives

**Implement DropzoneComponent in BlogForm for featured image upload**:

- **Import DropzoneComponent** - bring in react-dropzone-component library
- **Configuration methods** - componentConfig, djsConfig, handleFeaturedImageDrop
- **Method binding** - bind all three configuration functions in constructor
- **State management** - add featured_image field to BlogForm state
- **Component integration** - render DropzoneComponent with proper props
- **Child component pattern** - custom label using dz-message div

**Reinforcement learning**: Replicating portfolio manager upload patterns but simplified for single image

**Function invocation vs reference**: Understanding when to use parentheses with function props

---

## 🛠️ Implementation

### 1. Import DropzoneComponent

**File**: `src/components/blog/blog-form.js`

**Add DropzoneComponent import**:

```javascript
import React, { Component } from "react";
import axios from "axios";
import DropzoneComponent from "react-dropzone-component";
import RichTextEditor from "../forms/rich-text-editor";
```

### 2. Add Method Bindings in Constructor

**Bind three configuration functions**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    title: "",
    blog_status: "",
    content: "",
    featured_image: ""  // ← New field for image
  };

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
  this.handleRichTextEditorChange = this.handleRichTextEditorChange.bind(this);

  // Dropzone configuration methods
  this.componentConfig = this.componentConfig.bind(this);
  this.djsConfig = this.djsConfig.bind(this);
  this.handleFeaturedImageDrop = this.handleFeaturedImageDrop.bind(this);
}
```

### 3. Implement Configuration Methods

**Add three configuration methods before render**:

```javascript
componentConfig() {
  return {
    iconFiletypes: [".jpg", ".png"],
    showFiletypeIcon: true,
    postUrl: "https://httpbin.org/post"
  };
}

djsConfig() {
  return {
    addRemoveLinks: true,
    maxFiles: 1
  };
}

handleFeaturedImageDrop() {
  return {
    addedfile: file => this.setState({ featured_image: file })
  };
}
```

### 4. Add DropzoneComponent to JSX

**Add after RichTextEditor but before Save button**:

```javascript
render() {
  return (
    <form onSubmit={this.handleSubmit} className="blog-form-wrapper">
      <div className="two-column">
        <input 
          type="text"
          onChange={this.handleChange}
          name="title"
          placeholder="Blog Title"
          value={this.state.title}
        />

        <input 
          type="text"
          onChange={this.handleChange}
          name="blog_status"
          placeholder="Blog status"
          value={this.state.blog_status}
        />
      </div>

      <div className="one-column">
        <RichTextEditor 
          handleRichTextEditorChange={this.handleRichTextEditorChange}
        />
      </div>

      <div className="image-uploaders">
        <DropzoneComponent 
          config={this.componentConfig()}
          djsConfig={this.djsConfig()}
          eventHandlers={this.handleFeaturedImageDrop()}
        >
          <div className="dz-message">Featured Image</div>
        </DropzoneComponent>
      </div>

      <button type="submit" className="btn">Save</button>
    </form>
  );
}
```

---

## 📖 Concepts

### Configuration Method Pattern

**Why three separate configuration methods**:

```javascript
// Component configuration - UI behaviour
componentConfig() {
  return {
    iconFiletypes: [".jpg", ".png"],     // File type restrictions
    showFiletypeIcon: true,              // Show file type icons
    postUrl: "https://httpbin.org/post"  // Mock URL for preview
  };
}

// Dropzone.js configuration - dropzone behaviour  
djsConfig() {
  return {
    addRemoveLinks: true,  // Show remove links
    maxFiles: 1           // Only one file allowed
  };
}

// Event handling - what happens when file dropped
handleFeaturedImageDrop() {
  return {
    addedfile: file => this.setState({ featured_image: file })
  };
}
```

### Function Invocation vs Reference Pattern

**Critical concept explained in guide**:

```javascript
// ✓ Function invocation (our case) - immediate execution
config={this.componentConfig()}
//                            ↑
//                            Parentheses = call function now

// ✗ Function reference - passing function to be called later
onClick={this.handleClick}
//                        ↑
//                        No parentheses = pass function reference
```

**When to use each**:

- **Immediate execution** - configuration that component needs right away
- **Function reference** - event handlers that should be called later

**Examples from React ecosystem**:

```javascript
// Configuration (immediate)
<DropzoneComponent config={this.componentConfig()} />

// Event handlers (reference)  
<button onClick={this.handleClick}>Click me</button>
<form onSubmit={this.handleSubmit}>
```

### Mock URL Strategy

**Why httpbin.org/post**:

- **Testing service** - always returns 200 OK response
- **No actual storage** - file doesn't get uploaded anywhere
- **Preview functionality** - triggers Dropzone success animations
- **Development workflow** - test UI without backend setup

**Development progression**:

1. **Mock URL** (this stage) - test component integration
2. **Real API endpoint** (next guides) - actual file upload
3. **Error handling** (future) - handle upload failures

### State Management for Files

**File object storage**:

```javascript
// When user drops file, Dropzone provides File object
file = {
  name: "image.jpg",
  size: 123456,
  type: "image/jpeg",
  lastModified: 1640995200000
  // ... other File API properties
}

// Store in component state
this.setState({ featured_image: file });
```

**Future FormData usage**:

```javascript
// File will be appended to FormData for API submission
const formData = new FormData();
formData.append("portfolio_blog[featured_image]", this.state.featured_image);
```

### Child Component Pattern

**Custom dropzone message**:

```javascript
<DropzoneComponent>
  <div className="dz-message">Featured Image</div>
</DropzoneComponent>
```

**Library behaviour**:

- **Without children** - shows default "Drop files here to upload"
- **With children** - replaces default content with custom element
- **CSS class requirement** - `dz-message` class expected by Dropzone styling

### Single Image vs Multiple Images

**Blog form simplification**:

- **Portfolio form** - 3 images (thumbnail, banner, logo)
- **Blog form** - 1 image (featured image only)
- **Simpler configuration** - less complexity, easier to understand
- **Consistent patterns** - same implementation approach

### Component-Based Architecture Benefits

**Why this approach works**:

```javascript
// Reusable configuration
const config = this.componentConfig();  // Same config for any dropzone

// Isolated functionality  
<DropzoneComponent />  // Self-contained upload behaviour

// Clean integration
{/* Easy to add anywhere in form */}
<DropzoneComponent config={config} />
```

---

## ✅ Verification

### 1. Visual Integration Testing

**Navigate to blog modal and verify**:

1. **Open modal** - click "Open Modal!" link
2. **Locate dropzone** - should appear below rich text editor
3. **Visual elements**:
   - Dropzone area visible
   - "Featured Image" label displayed
   - Drag zone responsive to hover

### 2. File Upload Functionality Testing

**Test dropzone behaviour**:

1. **Click dropzone area** - file picker should open
2. **Select image file** (JPG or PNG)
3. **Expected behaviour**:
   - File preview appears
   - Success checkmark animation
   - Remove link appears
   - File name displayed

### 3. File Type Restriction Testing

**Test validation**:

1. **Try uploading non-image file** (TXT, PDF, etc.)
2. **Should reject** - no upload occurs
3. **Try multiple files** - should accept only 1
4. **UI feedback** - appropriate error/success indicators

### 4. State Management Verification

**React DevTools inspection**:

1. **Open React DevTools** → Components
2. **Select BlogForm component**
3. **Initial state**: `featured_image: ""`
4. **Upload file** → `featured_image: File { ... }`
5. **State updates correctly** when file dropped

### 5. Integration with Existing Form

**Verify form still functional**:

1. **Fill title and blog status** fields
2. **Add content** in rich text editor
3. **Upload featured image**
4. **Submit form** - should work (though file not yet processed)
5. **No console errors** - clean integration

### 6. Method Binding Verification

**Check function calls work**:

- **componentConfig()** returns configuration object
- **djsConfig()** returns dropzone configuration
- **handleFeaturedImageDrop()** returns event handler object
- **All methods bound properly** - no `this` context errors

---

## 🎨 Professional Development Insights

### Reinforcement Learning Strategy

**Why repeat similar implementation**:

- **Pattern recognition** - see same patterns across different contexts
- **Muscle memory** - configuration becomes automatic
- **Confidence building** - success in multiple contexts
- **Understanding depth** - know why each piece is necessary

### Component Reusability Demonstration

**Portfolio manager vs Blog form**:

```js
// Same patterns, different context
// Portfolio: 3 images, complex form
// Blog: 1 image, simpler form
// Implementation: nearly identical
```

**Professional benefits**:

- **Faster development** - leverage previous implementations
- **Consistent UX** - same behaviour across app
- **Maintainable code** - developers know pattern
- **Reduced bugs** - proven implementation

### Library Integration Mastery

- **Configuration object patterns** - structured library setup
- **Event handling** - library-specific event patterns
- **State management** - integrating external components with React state
- **Documentation reading** - translating docs to implementation


---
