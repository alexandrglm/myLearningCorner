# 10-165: How to Programmatically Add Content to Draft JS

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-programmatically-add-content-draft-js)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at e56a476232d52817556eb7c64c19944952661f6b](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/e56a476232d52817556eb7c64c19944952661f6b)

---

## 🎯 Objectives

**Implement pre-population of the RichTextEditor with existing HTML content for edit mode**:

- **HTML to Draft.js conversion** - convert blog.content (HTML) to EditorState
- **htmlToDraft library usage** - use htmlToDraft to parse existing HTML
- **ContentState creation** - create ContentState from HTML blocks
- **EditorState population** - initialise Draft.js with existing content
- **Props passing** - pass editMode and content from BlogForm to RichTextEditor
- **Conditional initialisation** - different EditorState depending on mode (create vs edit)

**Technical goal**: When user clicks "Edit", rich text editor must show the existing HTML content of the blog, maintaining formatting.

---

## 🛠️ Implementation

### 1. Pass Props from BlogForm to RichTextEditor

**File**: `src/components/blog/blog-form.js`

**Update RichTextEditor call to pass editMode and content**:

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
          editMode={this.props.editMode}
          contentToEdit={this.props.blog && this.props.blog.content}
        />
      </div>

      <button type="submit" className="btn">Save</button>
    </form>
  );
}
```

### 2. Add HTML Content Processing in RichTextEditor

**File**: `src/components/forms/rich-text-editor.js`

**Add componentWillMount lifecycle hook after the constructor**:

```javascript
componentWillMount() {
  if (this.props.editMode && this.props.contentToEdit) {
    const blocksFromHTML = htmlToDraft(this.props.contentToEdit);
    const { contentBlocks, entityMap } = blocksFromHTML;
    const contentState = ContentState.createFromBlockArray(contentBlocks, entityMap);
    const editorState = EditorState.createWithContent(contentState);
    this.setState({ editorState });
  }
}
```

### 3. Add Required Draft.js Imports

**Update imports at top of rich-text-editor.js**:

```javascript
import React, { Component } from "react";
import { EditorState, convertToRaw, ContentState } from "draft-js";
import { Editor } from "react-draft-wysiwyg";
import draftToHtml from "draftjs-to-html";
import htmlToDraft from "html-to-draftjs";
```

---

## 📧 Concepts

### HTML to Draft.js Conversion Pipeline

**Step-by-step conversion process**:

```javascript
// 1. Start with HTML string
const htmlContent = "<p>Hello <strong>world</strong></p>";

// 2. Parse HTML into Draft.js compatible format
const blocksFromHTML = htmlToDraft(htmlContent);
// Returns: { contentBlocks: [...], entityMap: {...} }

// 3. Create ContentState from parsed blocks
const contentState = ContentState.createFromBlockArray(
  blocksFromHTML.contentBlocks,
  blocksFromHTML.entityMap
);

// 4. Create EditorState with content
const editorState = EditorState.createWithContent(contentState);

// 5. Set as component state
this.setState({ editorState });
```

### htmlToDraft Library Function

**What htmlToDraft returns**:

```javascript
const result = htmlToDraft('<p>Hello <strong>world</strong></p>');

// result structure:
{
  contentBlocks: [
    {
      text: "Hello world",
      type: "unstyled",
      inlineStyleRanges: [
        { offset: 6, length: 5, style: "BOLD" }
      ]
    }
  ],
  entityMap: {}
}
```

**Key components**:

- **contentBlocks** - array of text blocks with formatting info
- **entityMap** - links, images, other entities (empty for basic text)
- **inlineStyleRanges** - formatting like bold, italic, underline
- **blockType** - paragraph, header, list item, etc.

### ContentState vs EditorState

**ContentState (data only)**:

```javascript
// Pure content representation
const contentState = ContentState.createFromBlockArray(contentBlocks, entityMap);
// Contains: text, formatting, entities - NO cursor position or selection
```

**EditorState (complete editor state)**:

```javascript
// Complete editor representation
const editorState = EditorState.createWithContent(contentState);
// Contains: content + cursor position + selection + undo history + more
```

**Why both are needed**:

- **ContentState** - holds the actual content and formatting
- **EditorState** - holds ContentState + editor interaction state
- **Draft.js Editor component** expects EditorState, not ContentState

### Create vs Edit Mode Differentiation

**Two initialisation patterns**:

```javascript
// Create mode (empty editor)
constructor() {
  this.state = {
    editorState: EditorState.createEmpty()  // Empty editor
  };
}

// Edit mode (populated editor)
componentWillMount() {
  if (this.props.editMode && this.props.contentToEdit) {
    // Convert HTML to EditorState and populate
    const editorState = EditorState.createWithContent(contentState);
    this.setState({ editorState });
  }
}
```

### Props Safety Pattern

**Safe content access**:

```javascript
// ❌ Dangerous - could cause error if blog is undefined
contentToEdit={this.props.blog.content}

// ✅ Safe - checks if blog exists first
contentToEdit={this.props.blog && this.props.blog.content}
```

**Why this pattern**:

- **Avoid errors** - prevents accessing properties of undefined
- **Conditional logic** - only passes content if blog data exists
- **Create mode safety** - works when no blog prop passed

### Component Lifecycle Timing

**Why componentWillMount**:

```javascript
// Lifecycle order:
1. constructor() - basic state initialisation
2. componentWillMount() - pre-population with props data
3. render() - display editor with populated content
4. componentDidMount() - component fully mounted
```

**Benefits of componentWillMount timing**:

- **Before render** - content populated before user sees editor
- **Props available** - parent props are accessible
- **Single execution** - only runs once when component mounts
- **No flash** - user doesn't see empty editor then content

**Note**: componentWillMount is deprecated in React 16.3+. Modern alternative: use constructor or componentDidMount.

### Conditional State Setting

**Edit mode logic**:

```javascript
componentWillMount() {
  if (this.props.editMode && this.props.contentToEdit) {
    // Only populate if both conditions true:
    // 1. editMode prop is true
    // 2. contentToEdit has actual content

    // Convert and set state
  }
  // If create mode OR no content, use default empty state
}
```

**Two conditions required**:

1. **editMode** - indicates this is edit, not create
2. **contentToEdit** - actual HTML content exists

### Data Flow Architecture

**Complete edit workflow**:

```javascript
// 1. BlogDetail has blog data
blogData = { id: 123, title: "...", content: "<p>HTML content</p>" };

// 2. BlogDetail passes to BlogForm
<BlogForm editMode={true} blog={blogData} />

// 3. BlogForm passes to RichTextEditor
<RichTextEditor editMode={true} contentToEdit={blogData.content} />

// 4. RichTextEditor converts and populates
componentWillMount() {
  // Convert HTML to EditorState
  // Set state with populated editor
}
```

---

## 📋 Verification

### 1. Props Passing Verification

**React DevTools inspection**:

1. **Enter edit mode** - click any blog title
2. **Open React DevTools** → Components
3. **Navigate to RichTextEditor component**
4. **Check props**:
   - `editMode: true`
   - `contentToEdit: "<p>Blog content HTML...</p>"`
   - `handleRichTextEditorChange: function`

### 2. HTML Content Pre-population

**Visual verification**:

1. **Navigate to blog with rich content** - find blog post with formatting
2. **Note existing content** - observe text, bold, headings, etc.
3. **Click blog title** - enter edit mode
4. **Verify rich text editor populated**:
   - Text content matches original
   - Formatting preserved (bold, italic, etc.)
   - HTML structure maintained

### 3. Different Content Types Testing

**Test various HTML structures**:

**Plain text blog**:

- Click edit → should show plain text in editor

**Formatted text blog**:

- Click edit → bold, italic, underline preserved

**Blog with headings**:

- Click edit → H1, H2, H3 formatting maintained

**Blog with lists**:

- Click edit → ordered/unordered lists preserved

### 4. Create vs Edit Mode Comparison

**Create mode (from modal)**:

1. **Open blog modal** - click floating action button
2. **Rich text editor empty** - starts with blank state
3. **No pre-population** - ready for new content

**Edit mode (from detail)**:

1. **Click blog title** - enter edit mode
2. **Rich text editor populated** - shows existing content
3. **Formatting preserved** - HTML converted correctly

### 5. componentWillMount Execution

**Lifecycle verification** (add temporary logging):

```javascript
componentWillMount() {
  console.log("componentWillMount called");
  console.log("editMode:", this.props.editMode);
  console.log("contentToEdit:", this.props.contentToEdit);

  if (this.props.editMode && this.props.contentToEdit) {
    console.log("Pre-populating rich text editor");
    // ... conversion code
  }
}
```

**Expected output for edit mode**:

```
componentWillMount called
editMode: true
contentToEdit: <p>Blog content with <strong>formatting</strong></p>
Pre-populating rich text editor
```

### 6. HTML Conversion Quality

**Test complex HTML structures**:

**Input HTML**:

```html
<h2>Blog Title</h2>
<p>Paragraph with <strong>bold</strong> and <em>italic</em> text.</p>
<ul>
  <li>List item one</li>
  <li>List item two</li>
</ul>
```

**Expected editor display**:

- Heading displays as H2
- Paragraph text with proper formatting
- List items in bulleted list
- All formatting interactive (can be modified)

---
