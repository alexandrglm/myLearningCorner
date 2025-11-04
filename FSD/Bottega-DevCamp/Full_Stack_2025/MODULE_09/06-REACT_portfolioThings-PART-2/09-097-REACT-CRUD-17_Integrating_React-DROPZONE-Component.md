# 09-097 - Integrating React Dropzone Component in Portfolio Form

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/integrating-react-dropzone-component-portfolio-form)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 6791712c19bc6685f5def0c29fa529010e25ec33](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/6791712c19bc6685f5def0c29fa529010e25ec33)

---

## 🎯 OBJECTIVES

**Configure basic Dropzone Component**:

- **Import DropzoneComponent** and required stylesheets
- **Configuration methods** - componentConfig and djsConfig
- **Mock URL setup** for preview functionality
- **File type restrictions** - JPG and PNG only
- **Base Dropzone rendering** with preview capability

**Foundation for upload system**:

- Establish base configuration without API connection
- Visual preview of selected files
- Prepare structure for multiple uploaders (3x)

---

## 🛠️ IMPLEMENTATION

### 1. Import DropzoneComponent and Stylesheets

**File**: `src/components/portfolio/portfolio-form.js`

**Imports at top of file**:

```javascript
import React, { Component } from "react";
import axios from "axios";
import DropzoneComponent from "react-dropzone-component";

import "../../../node_modules/react-dropzone-component/styles/filepicker.css";
import "../../../node_modules/dropzone/dist/min/dropzone.min.css";
```

### 2. Configuration Methods

**Add methods before render()**:

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
```

### 3. Binding Methods in Constructor

**Add to existing constructor**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    name: "",
    description: "",
    category: "eCommerce",
    position: "",
    url: "",
    thumb_image: "",
    banner_image: "",
    logo: ""
  };

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
  this.componentConfig = this.componentConfig.bind(this);
  this.djsConfig = this.djsConfig.bind(this);
}
```

### 4. Add Dropzone to JSX

**After textarea, add wrapper div**:

```javascript
render() {
  return (
    <div>
      <h1>PortfolioForm</h1>

      <form onSubmit={this.handleSubmit}>
        {/* ... existing form elements ... */}

        <div>
          <textarea
            name="description"
            placeholder="Description"  
            value={this.state.description}
            onChange={this.handleChange}
          />
        </div>

        <div className="image-uploaders">
          <DropzoneComponent 
            config={this.componentConfig()}
            djsConfig={this.djsConfig()}
          >
          </DropzoneComponent>
        </div>

        <div>
          <button type="submit">Save</button>
        </div>
      </form>
    </div>
  );
}
```

---

## 🔧 CONCEPTS

### Manual Stylesheet Imports

**Why manual imports?**:

```javascript
import "../../../node_modules/react-dropzone-component/styles/filepicker.css";
import "../../../node_modules/dropzone/dist/min/dropzone.min.css";
```

**Path breakdown**:

- `../../../` - Navigate up 3 levels from portfolio-form.js
- `node_modules/` - Enter node_modules directory  
- `react-dropzone-component/styles/` - Library-specific styles
- `dropzone/dist/min/` - Minified core Dropzone styles

**Why necessary?**:

- **Visual elements** - icons, previews, checkmarks
- **UX functionality** - drag zones, file previews
- **Component behaviour** - add/remove links, progress bars

### Configuration Objects Explained

**componentConfig() purpose**:

```javascript
{
  iconFiletypes: [".jpg", ".png"],    // File type restrictions
  showFiletypeIcon: true,             // Visual file type indicators  
  postUrl: "https://httpbin.org/post" // Mock URL for preview functionality
}
```

**djsConfig() purpose**:

```javascript
{
  addRemoveLinks: true,  // Show "Remove file" links
  maxFiles: 1           // Only one file per uploader
}
```

### Mock URL Strategy

**Why httpbin.org/post?**:

- **Testing service** - always returns success
- **No actual upload** - file stays in browser
- **Preview functionality** - triggers success animations
- **Development workflow** - work with files before API integration

**Professional pattern**:

- **Phase 1**: Mock URL for UI development
- **Phase 2**: Real API integration  
- **Phase 3**: Error handling and validation

### Method Binding Necessity

**Why bind methods?**:

```javascript
this.componentConfig = this.componentConfig.bind(this);
```

**Reason**:

- **Context preservation** - `this` refers to component instance
- **Callback functionality** - methods passed as props need correct context
- **React patterns** - standard approach for method passing

### Function Invocation vs Reference

**Common error spotted in guide**:

```javascript
// ❌ NOPE!!! Wrong - passes function reference
config={this.componentConfig}

// ✅ YEP! - Correct - invokes function immediately  
config={this.componentConfig()}
```

**Why difference matters**:

- **Reference**: DropzoneComponent would have to call function
- **Invocation**: Returns config object immediately
- **Dropzone expects**: Configuration object, not function

---

## ✔️ VERIFICATION

### Testing Basic Dropzone Functionality

**Visual verification**:

1. **Navigate to portfolio-manager** page
2. **Scroll down** to see dropzone area
3. **Visual elements check**:
   - Dropzone area visible
   - "Click to select files" functionality  
   - Drag zone responsive to hover

### File Upload Testing

**Functional testing**:

1. **Click dropzone area** - file picker opens
2. **Select JPG or PNG** image from system
3. **Expected behaviour**:
   - File preview appears
   - Success checkmark animation
   - "Remove file" link visible
   - File name displayed

### Error Testing

**Test restrictions**:

1. **Try non-image file** (txt, pdf, etc.)
2. **Should reject** - no upload occurs
3. **Try multiple files** - should accept only 1
4. **UI feedback** - appropriate error messages

### Integration Testing

**Form still functional**:

1. **Fill other form fields** normally
2. **Submit form** - should work as before
3. **Dropzone doesn't interfere** with existing functionality
4. **No console errors** - clean integration

### Styling Verification

**CSS applied correctly**:

1. **Inspect dropzone element** - styles loaded
2. **File icons visible** - filepicker.css working
3. **Animations smooth** - dropzone.min.css loaded
4. **Professional appearance** - not broken styling

---
