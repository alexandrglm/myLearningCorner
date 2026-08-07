# 10-149: Rendering Draft.js Form Component Building Rich Text Editor Styles

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/rendering-draft-js-form-component-building-rich-text-editor-styles)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at cb9c59fcd7f845e1cd4c5ae38933a3e41b795b0a](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/cb9c59fcd7f845e1cd4c5ae38933a3e41b795b0a)

[react-draft-wysiwyg.scss](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/blob/master/src/style/react-draft-wysiwyg.scss)

---

## 🎯 Objectives

**Create and render RichTextEditor component with Draft.js**:

- **Forms directory structure** - reusable components not specific to blog
- **RichTextEditor class component** - state management for Draft.js EditorState
- **Draft.js imports** - core libraries and conversion utilities
- **Modal height adjustment** - increase space for rich text editor
- **Editor styling** - include react-draft-wysiwyg CSS for complete UI
- **Basic editor rendering** - visible but not functional (next guide)

**Component reusability strategy**:

- Build for use in blog form AND potentially portfolio form
- Separation of concerns - rich text editing separated from form logic
- Professional development patterns

---

## 🛠️ Implementation

### 1. Create Forms Directory Structure

**Create directory**: `src/components/forms/`

```
src/components/
  forms/                    ← New directory
    rich-text-editor.js     ← New component
```

**Reason for abstraction**: Component can be used in blog form, portfolio form, or any other feature

### 2. Create RichTextEditor Class Component

**File**: `src/components/forms/rich-text-editor.js`

**Necessary imports**:

```javascript
import React, { Component } from "react";
import { EditorState, convertToRaw } from "draft-js";
import { Editor } from "react-draft-wysiwyg";
import draftToHtml from "draftjs-to-html";
import htmlToDraft from "html-to-draftjs";
```

**Constructor with EditorState**:

```javascript
export default class RichTextEditor extends Component {
  constructor(props) {
    super(props);

    this.state = {
      editorState: EditorState.createEmpty()
    };
  }

  render() {
    return (
      <div>
        <Editor
          editorState={this.state.editorState}
          wrapperClassName="demo-wrapper"
          editorClassName="demo-editor"
        />
      </div>
    );
  }
}
```

### 3. Integrate RichTextEditor in BlogForm

**File**: `src/components/blog/blog-form.js`

**Import component**:

```javascript
import RichTextEditor from "../forms/rich-text-editor";
```

**Render in one-column layout**:

```javascript
render() {
  return (
    <form onSubmit={this.handleSubmit}>
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
        <RichTextEditor />
      </div>

      <button>Save</button>
    </form>
  );
}
```

### 4. Adjust Modal Height

**Create file**: `src/style/modals.scss`

**Increase modal height to accommodate editor**:

```scss
.ReactModal__Content,
.ReactModal__Content--after-open {
  height: 80%;
}
```

**Import in main.scss**:

```scss
@import "./modals.scss";
```

### 5. Include React-Draft-WYSIWYG Styles

**Create file**: `src/style/react-draft-wysiwyg.scss`

**Copy complete stylesheet from library** (1000+ lines of CSS):

```scss
/* Complete react-draft-wysiwyg CSS from library */
/* This includes all toolbar styling, button icons, and editor appearance */
/* Paste complete contents from library documentation */
```

**Import in main.scss**:

```scss
@import "./react-draft-wysiwyg.scss";
```

### 6. Restart Development Server

**Fix import error**:

```bash
# Stop current server (Ctrl+C)
npm start
```

**Why restart needed**: SCSS imports require server restart when file doesn't exist initially

---

## 📖 Concepts

### Draft.js EditorState Management

**Why not simple string state**:

```javascript
// ✗ This doesn't work with Draft.js
this.state = {
  editorState: ""  // Will cause errors
}

// ✓ Correct Draft.js state initialisation
this.state = {
  editorState: EditorState.createEmpty()  // Proper editor state object
}
```

**EditorState complexity**:

- **Rich state object** - contains formatting, cursor position, content
- **Immutable updates** - requires specific methods for modifications
- **Built-in methods** - createEmpty(), createWithContent(), etc.
- **Advanced features** - undo/redo, selection management, styling info

### Component Architecture Pattern

**Forms directory strategy**:

```
src/components/
├── blog/
│   └── blog-form.js      # Blog-specific logic
├── portfolio/
│   └── portfolio-form.js # Portfolio-specific logic
└── forms/
    └── rich-text-editor.js # Reusable rich text functionality
```

**Benefits**:

- **Reusability** - same editor can be used across features
- **Separation of concerns** - rich text logic isolated
- **Easier testing** - component can be tested independently
- **Future flexibility** - easy to enhance or replace editor

### CSS Integration Strategy

**Why include complete library styles**:

```scss
// Option 1: Import from node_modules (can break with updates)
@import "~react-draft-wysiwyg/dist/react-draft-wysiwyg.css";

// Option 2: Copy styles locally (our approach)
@import "./react-draft-wysiwyg.scss";  // Local copy, customisable
```

**Advantages of local copy**:

- **Customisation** - can modify styles as needed
- **Version control** - styles tracked in project repository  
- **Build stability** - no dependency on external CSS file paths
- **Custom overrides** - easier to add project-specific modifications

### Modal Height Considerations

**Modal sizing strategy**:

```scss
.ReactModal__Content {
  height: 80%;  // Provides adequate space for rich text editor
}
```

**Why 80%**:

- **Adequate space** - rich text editor needs substantial height
- **Breathing room** - space for toolbar and content area
- **Responsive friendly** - adapts to different screen sizes
- **User experience** - comfortable editing space

### Styling Class Names

**Library-provided class names**:

```javascript
<Editor
  wrapperClassName="demo-wrapper"  // Library expects this name
  editorClassName="demo-editor"    // Library expects this name
/>
```

**Important**: Class names correspond to CSS in react-draft-wysiwyg.scss

### Development Server Import Errors

**Common SCSS import error**:

```
ModuleNotFoundError: Can't resolve './react-draft-wysiwyg.scss'
```

**Solution**: Create file BEFORE importing, or restart server after creating file

**Why this happens**:

- **Build system caching** - webpack doesn't immediately recognise new files
- **Import resolution** - server tries to resolve import before file exists
- **Hot reload limitations** - some changes require full restart

---

## ✅ Verification

### 1. Component Integration Testing

**Visual verification**:

1. **Navigate to /blog**
2. **Click "Open Modal!" link**
3. **Modal should open** with increased height (80% of screen)
4. **Should see**:
   - Title and blog status inputs in two-column layout
   - Rich text editor with toolbar in one-column layout
   - Save button

### 2. Rich Text Editor Appearance

**Expected editor features**:

- **Toolbar with icons** - bold, italic, underline, lists, etc.
- **Text input area** - bordered content area (may lack border initially)
- **Professional appearance** - styled buttons and icons
- **Formatted layout** - organised toolbar and content sections

### 3. Non-Functional State Verification

**Editor limitations at this stage**:

- **Typing doesn't work** - no onChange handler implemented yet
- **Toolbar buttons inactive** - no state management connected
- **Visual only** - demonstrates UI but no functionality
- **Expected behaviour** - next guide will add functionality

### 4. CSS Integration Check

**Verify styles loaded**:

1. **Inspect toolbar buttons** - should have styled icons (not placeholders)
2. **Check editor layout** - organised appearance
3. **Verify modal height** - should take 80% of screen height
4. **No console errors** - CSS should load without issues

### 5. Component Tree Structure

**React DevTools verification**:

```
Blog
└── BlogModal
    └── BlogForm
        ├── input (title)
        ├── input (blog_status)
        ├── RichTextEditor
        │   └── Editor (from react-draft-wysiwyg)
        └── button (Save)
```

### 6. File Structure Verification

**Directory structure should include**:

```
src/
├── components/
│   ├── forms/
│   │   └── rich-text-editor.js
│   └── blog/
│       └── blog-form.js
└── style/
    ├── main.scss
    ├── modals.scss
    └── react-draft-wysiwyg.scss
```

---

## 🎨 Development Patterns Demonstrated

### Progressive Enhancement

**Building complexity incrementally**:

1. **Structure** (this guide) - visual editor appears
2. **State management** (next guide) - typing and toolbar functionality
3. **Form integration** (future) - editor content connected to form submission
4. **API integration** (future) - rich content saved to backend

### Library Integration Strategy

**Step-by-step library adoption**:

1. **Install dependencies** (previous guide)
2. **Basic implementation** (this guide) - visual integration
3. **Functionality** (next guide) - interactive features
4. **Advanced features** (future) - custom toolbar, image upload

### Component Isolation

**Separation benefits demonstrated**:

- **RichTextEditor** - handles Draft.js complexity
- **BlogForm** - handles form logic and layout
- **BlogModal** - handles modal presentation
- **Clear boundaries** - each component has specific responsibility

### CSS Architecture

**Modular styling approach**:

- **modals.scss** - modal-specific overrides
- **react-draft-wysiwyg.scss** - third-party library styles
- **main.scss** - orchestrates import order
- **Maintainable structure** - easy to locate and modify styles

---
