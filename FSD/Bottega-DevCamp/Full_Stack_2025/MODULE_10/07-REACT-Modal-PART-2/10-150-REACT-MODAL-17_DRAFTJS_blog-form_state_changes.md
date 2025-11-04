# 10-150: Updating Blog Form Handle Rich Text Editor State Changes

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/updating-blog-form-handle-rich-text-editor-state-changes)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 16763f1af7dc434b84f06048c96e352b20d48b94](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/16763f1af7dc434b84f06048c96e352b20d48b94)

---

## 🎯 Objectives

**Prepare BlogForm to handle rich text editor state changes**:

- **Add content state field** - new field for rich text content
- **Create handleRichTextEditorChange** - dedicated function for rich text updates
- **Modern JavaScript setState syntax** - shorthand property syntax  
- **Pass function as prop** - connect BlogForm with RichTextEditor
- **buildForm integration** - include content in form data submission
- **Component isolation strategy** - keep rich text logic separated

**Focus of this guide**: Prepare BlogForm side of communication - RichTextEditor functionality comes in next guide

**Why separation**: Isolate concerns to keep components interchangeable and maintainable

---

## 🛠️ Implementation

### 1. Add Content Field to BlogForm State

**File**: `src/components/blog/blog-form.js`

**Expand state to include rich text content**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    title: "",
    blog_status: "",
    content: ""          // ← New field for rich text editor
  };

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
  this.handleRichTextEditorChange = this.handleRichTextEditorChange.bind(this);
}
```

### 2. Create handleRichTextEditorChange Function

**Add dedicated function for rich text state management**:

```javascript
handleRichTextEditorChange(content) {
  this.setState({ content });
}
```

**Modern JavaScript shorthand explained**:

```javascript
// Traditional verbose syntax
this.setState({ content: content });

// Modern shorthand (identical functionality)
this.setState({ content });
```

### 3. Update buildForm Method

**Include content in form data submission**:

```javascript
buildForm() {
  let formData = new FormData();

  formData.append("portfolio_blog[title]", this.state.title);
  formData.append("portfolio_blog[blog_status]", this.state.blog_status);
  formData.append("portfolio_blog[content]", this.state.content);

  return formData;
}
```

### 4. Pass handleRichTextEditorChange As Prop

**Connect BlogForm to RichTextEditor via props**:

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

      <button type="submit" className="btn">Save</button>
    </form>
  );
}
```

---

## 📖 Concepts

### Component Isolation Architecture

**Why handleRichTextEditorChange receives string**:

```javascript
// BlogForm expects simple string input
handleRichTextEditorChange(content) {
  this.setState({ content });  // content must be string
}
```

**Benefits of this approach**:

- **Library agnostic** - BlogForm doesn't depend on Draft.js specifically
- **Interchangeable components** - could swap Draft.js for different editor
- **Clear contract** - RichTextEditor must provide string output
- **Single responsibility** - BlogForm handles state, RichTextEditor handles rich text complexity

### Modern JavaScript Shorthand Properties

**Property shorthand syntax**:

```javascript
// When variable name matches object key
const content = "Hello World";

// Traditional syntax
this.setState({ content: content });

// Modern shorthand (identical)
this.setState({ content });
```

**Common pattern in React**:

```javascript
const { title, content, blog_status } = this.state;

// Both syntax forms are equivalent
return { title: title, content: content, blog_status: blog_status };
return { title, content, blog_status };
```

### Function Binding Pattern

**Why binding is necessary**:

```javascript
// In constructor - bind context
this.handleRichTextEditorChange = this.handleRichTextEditorChange.bind(this);

// Function definition - needs 'this' context
handleRichTextEditorChange(content) {
  this.setState({ content });  // 'this' refers to component instance
}
```

**Alternative arrow function approach**:

```javascript
// Arrow functions automatically bind 'this'
handleRichTextEditorChange = (content) => {
  this.setState({ content });
};
```

### Props Communication Strategy

**Data flow architecture being established**:

```
RichTextEditor → handleRichTextEditorChange → BlogForm.state.content → buildForm → API
```

**Component responsibilities**:

- **RichTextEditor**: Handle Draft.js complexity, convert to string
- **BlogForm**: Manage form state, coordinate with API
- **Clear interface**: String in, string stored, string submitted

### Form Data Integration

**buildForm method expansion**:

```javascript
// Before (basic fields)
formData.append("portfolio_blog[title]", this.state.title);
formData.append("portfolio_blog[blog_status]", this.state.blog_status);

// After (with rich content)
formData.append("portfolio_blog[content]", this.state.content);
```

**API expects**: Rich text content as HTML string

### Future-Proofing Strategy

**Why not tie Draft.js logic to BlogForm**:

```javascript
// ✗ BAD - tightly coupled to Draft.js
handleRichTextEditorChange(editorState) {
  const content = draftToHtml(convertToRaw(editorState.getCurrentContent()));
  this.setState({ content });
}

// ✓ GOOD - library agnostic
handleRichTextEditorChange(content) {
  this.setState({ content });  // RichTextEditor handles conversion
}
```

**Benefits**:

- **Easy library switching** - replace Draft.js without changing BlogForm
- **Cleaner separation** - each component has specific responsibility
- **Easier testing** - can test BlogForm independently of rich text complexity
- **Maintainable code** - changes to rich text logic don't affect form logic

### State Management Preparation

**Current state structure**:

```javascript
this.state = {
  title: "",           // Plain text input
  blog_status: "",     // Plain text input  
  content: ""          // Rich text content (as HTML string)
};
```

**Future considerations**:

- **content will contain HTML** - tags, formatting, etc.
- **Form submission ready** - buildForm handles content field
- **API compatible** - backend expects content as HTML string

---

## ✅ Verification

### 1. State Structure Verification

**React DevTools state inspection**:

1. **Open React DevTools** → Components
2. **Navigate to BlogForm component**
3. **Check state structure**:
   - `title: ""`
   - `blog_status: ""`
   - `content: ""` ← New field present

### 2. Props Passing Verification

**Check RichTextEditor receives props**:

1. **Open React DevTools** → Components
2. **Navigate to RichTextEditor component**
3. **Check props**:
   - `handleRichTextEditorChange: function` should be present

### 3. Function Binding Test

**Verify function binding works**:

```javascript
// Add temporary console.log for testing
handleRichTextEditorChange(content) {
  console.log("BlogForm received content:", content);
  this.setState({ content });
}
```

### 4. buildForm Method Testing

**Verify content included in form data**:

```javascript
// Add temporary console.log in handleSubmit
handleSubmit(event) {
  console.log("Form data includes:", this.state);
  // Should show title, blog_status, AND content
  this.props.handleSuccessfulFormSubmission(this.state);
  event.preventDefault();
}
```

### 5. Component Integration Check

**Visual verification**:

1. **Open modal** - click "Open Modal!" link
2. **Should see**:
   - Title and blog_status inputs (unchanged)
   - RichTextEditor component (still non-functional)
   - Save button (unchanged)
3. **No errors** - console should be clean

---

## 🎨 Development Patterns Demonstrated

### Progressive Enhancement Strategy

**Building functionality step by step**:

1. **Basic form** (previous guides) - simple inputs
2. **State preparation** (this guide) - ready for rich content
3. **Rich text functionality** (next guide) - editor becomes interactive
4. **Full integration** (future) - complete workflow

### Separation of Concerns

**Clear component boundaries**:

- **BlogForm**: Form state management, API integration
- **RichTextEditor**: Rich text editing, Draft.js complexity
- **Clean interface**: String-based communication

### Modern JavaScript Practices

**Syntax improvements demonstrated**:

- **Shorthand properties** - cleaner setState calls
- **Computed property names** - dynamic object keys
- **Function binding** - proper React patterns

### API-First Development

**Designing for backend integration**:

- **FormData structure** - matches API expectations
- **Content field** - prepared for HTML content
- **Submission ready** - form can handle rich content

---
