# 10-151: Retrieving HTML Content Draft.js Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/retrieving-html-content-draft-js-component)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 2f106f48d058e9ffa78eea2d6c11bc5d36e1d347](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/2f106f48d058e9ffa78eea2d6c11bc5d36e1d347)

---

## 🎯 Objectives

**Implement complete functionality in RichTextEditor to generate HTML content**:

- **onEditorStateChange function** - handle Draft.js editor state updates
- **setState async handling** - callback pattern to ensure state updated before props
- **Draft.js content conversion** - convert editor state to HTML string
- **Real-time HTML generation** - live conversion whilst user types
- **Toolbar functionality** - bold, italic, headings, etc. working completely
- **Parent component communication** - pass HTML content to BlogForm

**Technical concepts covered**: Draft.js EditorState complexity, asynchronous setState behaviour, content conversion pipeline, higher-order functions

---

## 🛠️ Implementation

### 1. Create onEditorStateChange Function

**File**: `src/components/forms/rich-text-editor.js`

**Add function binding in constructor**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    editorState: EditorState.createEmpty()
  };

  this.onEditorStateChange = this.onEditorStateChange.bind(this);
}
```

### 2. Implement onEditorStateChange with Conversion Pipeline

**Add function above render method**:

```javascript
onEditorStateChange(editorState) {
  this.setState(
    { editorState },
    () => {
      this.props.handleRichTextEditorChange(
        draftToHtml(convertToRaw(this.state.editorState.getCurrentContent()))
      );
    }
  );
}
```

### 3. Connect onEditorStateChange to Editor Component

**Update render method to pass onEditorStateChange prop**:

```javascript
render() {
  return (
    <div>
      <Editor
        editorState={this.state.editorState}
        wrapperClassName="demo-wrapper"
        editorClassName="demo-editor"
        onEditorStateChange={this.onEditorStateChange}
      />
    </div>
  );
}
```

---

## 📖 Concepts

### Draft.js EditorState Complexity

**Why EditorState is not a string**:

```javascript
// React DevTools shows EditorState as complex object with:
{
  _immutable: {
    currentContent: ContentState,
    decorator: null,
    directionMap: OrderedMap,
    forceSelection: false,
    inCompositionMode: false,
    // ... many more properties
  }
}
```

**EditorState contains**:

- **Content data** - actual text and formatting
- **Selection info** - cursor position, highlighted text
- **Undo stack** - history for undo/redo functionality
- **Decorator info** - entity decorations (links, etc.)
- **Composition state** - IME composition handling

### Content Conversion Pipeline

**Multi-step conversion process**:

```javascript
this.state.editorState.getCurrentContent()  // Step 1: Get content state
    ↓
convertToRaw(contentState)                   // Step 2: Convert to raw object
    ↓
draftToHtml(rawObject)                       // Step 3: Convert to HTML string
    ↓
"<p>Hello <strong>world</strong></p>"        // Final result: HTML string
```

**Each step's purpose**:

1. **getCurrentContent()** - extracts content from complex EditorState
2. **convertToRaw()** - transforms ContentState into serialisable object
3. **draftToHtml()** - converts raw object into HTML markup

### Asynchronous setState Pattern

**Problem with immediate access**:

```javascript
// ✗ WRONG - setState is asynchronous
this.setState({ editorState });
this.props.handleRichTextEditorChange(content); // May use OLD state
```

**Solution with callback**:

```javascript
// ✓ CORRECT - callback ensures state updated first
this.setState(
  { editorState },           // Update state
  () => {                    // Callback runs AFTER state updated
    this.props.handleRichTextEditorChange(content);
  }
);
```

**Why setState is asynchronous**:

- **Performance optimisation** - React batches state updates
- **Prevent unnecessary re-renders** - multiple setState calls batched together
- **Consistent behaviour** - predictable update timing
- **Race condition prevention** - ensures state integrity

### Modern JavaScript Shorthand

**Object property shorthand**:

```javascript
// Traditional syntax
this.setState({ editorState: editorState });

// Modern shorthand (identical functionality)
this.setState({ editorState });
```

**When shorthand applies**:

- Variable name matches object key exactly
- Very common pattern in React
- More concise and readable

### Editor Component Props Integration

**Draft.js Editor expects specific props**:

```javascript
<Editor
  editorState={this.state.editorState}           // Required: current state
  onEditorStateChange={this.onEditorStateChange} // Required: change handler
  wrapperClassName="demo-wrapper"                 // CSS class for wrapper
  editorClassName="demo-editor"                   // CSS class for editor
/>
```

**Naming requirements**:

- `onEditorStateChange` - specific prop name expected by Draft.js
- Function automatically receives new editorState as argument
- Not optional - required for editor functionality

### Real-time HTML Generation

**Live conversion demo behaviour**:

```javascript
// User types: "Hello world"
// Output: "<p>Hello world</p>"

// User selects "world" and clicks Bold
// Output: "<p>Hello <strong>world</strong></p>"

// User changes paragraph to H3
// Output: "<h3>Hello <strong>world</strong></h3>"
```

**HTML tags generated automatically**:

- **Paragraphs** - `<p>content</p>`
- **Bold text** - `<strong>content</strong>`
- **Italic text** - `<em>content</em>`
- **Underline** - `<u>content</u>`
- **Headings** - `<h1>`, `<h2>`, `<h3>`, etc.
- **Lists** - `<ul>`, `<ol>`, `<li>`

### Component Communication Flow

**Data flow from RichTextEditor to BlogForm**:

```
User types → onEditorStateChange → setState callback → handleRichTextEditorChange → BlogForm.state.content
```

**Each step's responsibility**:

1. **User input** - typing, formatting, toolbar clicks
2. **onEditorStateChange** - capture Draft.js state changes
3. **setState callback** - ensure local state updated first
4. **handleRichTextEditorChange** - communicate with parent
5. **BlogForm.state.content** - store HTML string for form submission

### Library Integration Strategy

**Draft.js ecosystem integration**:

```javascript
import { EditorState, convertToRaw } from "draft-js";        // Core library
import { Editor } from "react-draft-wysiwyg";               // React wrapper
import draftToHtml from "draftjs-to-html";                  // Conversion utility
```

**Each import's role**:

- **EditorState** - manage complex editor state
- **convertToRaw** - convert ContentState to serialisable format
- **Editor** - React component with professional UI
- **draftToHtml** - convert Draft.js content to HTML

---

## ✅ Verification

### 1. Real-time Content Conversion Testing

**React DevTools state monitoring**:

1. **Open modal** - click "Open Modal!" link
2. **Open React DevTools** → Components
3. **Navigate to BlogForm component**
4. **Monitor state.content** field
5. **Type in rich text editor** - watch content update live
6. **Expected format**: `"<p>typed content</p>"`

### 2. Formatting Functionality Testing

**Test various formatting options**:

1. **Type text**: "Hello world"
2. **Select "world"** - highlight text
3. **Click Bold button** - should add `<strong>` tags
4. **Result**: `"<p>Hello <strong>world</strong></p>"`
5. **Try other formatting**:
   - Italic → `<em>` tags
   - Underline → `<u>` tags
   - Different headings → `<h1>`, `<h2>`, `<h3>`

### 3. Toolbar Integration Verification

**All toolbar buttons should work**:

- **Text formatting** - bold, italic, underline
- **Heading levels** - H1 through H6
- **Text alignment** - left, centre, right
- **Lists** - ordered and unordered
- **Advanced features** - links, etc.

### 4. setState Async Behaviour Verification

**Add temporary debugging**:

```javascript
onEditorStateChange(editorState) {
  console.log("Before setState:", this.state.editorState);

  this.setState(
    { editorState },
    () => {
      console.log("After setState:", this.state.editorState);
      console.log("Converted content:", 
        draftToHtml(convertToRaw(this.state.editorState.getCurrentContent()))
      );
    }
  );
}
```

**Verify correct order**:

- "Before setState" shows old state
- "After setState" shows updated state
- Converted content uses NEW state

### 5. Form Submission Integration

**End-to-end workflow testing**:

1. **Fill rich text editor** with formatted content
2. **Add title and blog status**
3. **Submit form**
4. **Check BlogForm submission** - should include HTML content
5. **Verify API call** includes rich text data

### 6. HTML Output Quality Check

**Generated HTML should be clean**:

```html
<!-- Good output examples -->
<p>Simple paragraph</p>
<p>Text with <strong>bold</strong> and <em>italic</em></p>
<h3>Heading with <u>underlined</u> text</h3>
<ul>
  <li>List item one</li>
  <li>List item two</li>
</ul>
```

---

## 🎨 Professional Development Insights

### Library Integration Mastery

**Skills demonstrated**:

- **Complex state management** - handling Draft.js EditorState
- **Asynchronous programming** - setState callback pattern
- **Third-party integration** - working with external libraries
- **Data transformation** - multi-step conversion pipeline

### Modern React Patterns

**Best practices applied**:

- **Component isolation** - RichTextEditor handles complexity internally
- **Props interface** - clean string-based communication
- **State management** - proper async setState handling
- **Library abstraction** - hide Draft.js complexity from parent

### Content Management Evolution

**Historical perspective mentioned in guide**:

- **15 years ago** - this functionality would take weeks to build
- **Modern tools** - Draft.js provides professional rich text editing
- **React ecosystem** - seamless integration with existing components
- **Developer productivity** - complex features implemented quickly

### Real-world Applications

**This pattern applies to**:

- **CMS systems** - content management platforms
- **Blog platforms** - rich content creation
- **Documentation tools** - formatted text editing
- **Email composers** - rich text email creation
- **Social media** - formatted post creation

---
