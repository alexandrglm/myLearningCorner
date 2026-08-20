# 10-164: Passing the Blog Title and Status to the Form to Edit

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/passing-blog-title-status-form-edit)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at b860d433143b8aa139310d2ab31d0db34b856744](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/b860d433143b8aa139310d2ab31d0db34b856744)

---

## 🎯 Objectives

**Implement data pre-population for BlogForm when in edit mode**:

- **Props passing** - pass editMode and blog data from BlogDetail to BlogForm  
- **Component lifecycle** - use componentWillMount to pre-populate state
- **Edit vs Create differentiation** - BlogForm behaves differently based on props
- **State pre-population** - fill title, blog_status, and id fields with existing data
- **ID storage** - add id field for tracking blog being edited
- **Conditional state setting** - only populate when editMode is true

**Goal**: When user clicks blog title, form pre-populates with existing blog data, allowing edit functionality.

---

## 🛠️ Implementation

### 1. Pass Props from BlogDetail to BlogForm

**File**: `src/components/blog/blog-detail.js`

**Update BlogForm call in contentManager function**:

```javascript
render() {
  const contentManager = () => {
    if (this.state.editMode) {
      return (
        <BlogForm 
          editMode={this.state.editMode}
          blog={this.state.blogItem}
        />
      );
    } else {
      return (
        <div className="content-container">
          <h1 onClick={this.handleEditClick}>{this.state.blogItem.title}</h1>

          <BlogFeaturedImage img={this.state.blogItem.featured_image_url} />

          <div className="content">
            {ReactHtmlParser(this.state.blogItem.content)}
          </div>
        </div>
      );
    }
  };

  return (
    <div className="blog-detail-wrapper">
      {contentManager()}
    </div>
  );
}
```

### 2. Add ID Field to BlogForm State

**File**: `src/components/blog/blog-form.js`

**Update constructor with id field**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    id: "",
    title: "",
    blog_status: ""
  };

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
}
```

### 3. Add componentWillMount Lifecycle Hook

**Add after constructor, before handleChange**:

```javascript
componentWillMount() {
  if (this.props.editMode) {
    this.setState({
      id: this.props.blog.id,
      title: this.props.blog.title,
      blog_status: this.props.blog.blog_status
    });
  }
}
```

---

## 📧 Concepts

### Component Lifecycle: componentWillMount

**When componentWillMount runs**:

```javascript
// Lifecycle sequence for BlogForm
1. constructor() - initialise state
2. componentWillMount() - pre-populate state if editing
3. render() - display form with populated data
4. componentDidMount() - component fully mounted
```

**Why componentWillMount for this use case**:

- **Runs before initial render** - state populated before form displays
- **Single execution** - only runs once when component first mounts
- **State available immediately** - no flash of empty form
- **Perfect timing** - props available, component not yet rendered

**Note**: componentWillMount is deprecated in React 16.3+, but still functional. Modern alternative: constructor or componentDidMount.

### Props-Based Conditional Logic

**Edit mode detection pattern**:

```javascript
// BlogDetail passes different props based on mode
if (editMode) {
  <BlogForm editMode={true} blog={blogItemData} />
} else {
  // Display normal blog content
}

// BlogForm responds to props
componentWillMount() {
  if (this.props.editMode) {
    // Pre-populate with existing data
  }
  // Otherwise, start with empty form (create mode)
}
```

### State Pre-population Strategy

**Why pre-populate in componentWillMount**:

```javascript
// ❌ Bad: Setting state in render
render() {
  if (this.props.editMode && !this.state.title) {
    this.setState({ title: this.props.blog.title }); // Causes infinite loop
  }
}

// ✅ Good: Setting state in lifecycle hook
componentWillMount() {
  if (this.props.editMode) {
    this.setState({
      id: this.props.blog.id,
      title: this.props.blog.title,
      blog_status: this.props.blog.blog_status
    });
  }
}
```

### Data Flow Architecture

**Complete edit workflow**:

```javascript
// 1. User clicks blog title in BlogDetail
handleEditClick() → editMode: true

// 2. BlogDetail re-renders with BlogForm
<BlogForm editMode={true} blog={blogData} />

// 3. BlogForm mounts and pre-populates
componentWillMount() → setState(blogData)

// 4. Form displays with existing data
render() → inputs show current blog title/status
```

### ID Field Management

**Why add id to state**:

```javascript
this.state = {
  id: "",           // ← New field for edit operations
  title: "",
  blog_status: ""
};
```

**Usage scenarios**:

- **Create mode**: id remains empty string
- **Edit mode**: id populated with existing blog's ID
- **API calls**: id used to determine POST (create) vs PUT (update)
- **Future functionality**: id needed for update API endpoint

### Props Interface Design

**BlogForm props interface**:

```javascript
// Create mode (from modal)
<BlogForm 
  handleSuccessfulFormSubmission={function}
/>

// Edit mode (from detail page)
<BlogForm 
  editMode={true}
  blog={{id: 123, title: "...", blog_status: "..."}}
  handleSuccessfulFormSubmission={function} // Future implementation
/>
```

**Benefits of this design**:

- **Flexible component** - handles both create and edit
- **Clear interface** - editMode prop clearly indicates mode
- **Complete data** - blog prop contains all necessary data
- **Future ready** - structure supports additional edit functionality

---

## 📋 Verification

### 1. Props Passing Verification

**React DevTools inspection**:

1. **Navigate to blog detail page** - `/b/[id]`
2. **Click blog title** - enter edit mode
3. **Open React DevTools** → Components
4. **Navigate to BlogForm component**
5. **Check props**:
   - `editMode: true`
   - `blog: {id: 123, title: "...", blog_status: "..."}`

### 2. State Pre-population Testing

**State inspection after mount**:

1. **Enter edit mode** - click blog title
2. **Check BlogForm state** in React DevTools:
   - `id: "123"` (or whatever the blog ID is)
   - `title: "Current Blog Title"`
   - `blog_status: "published"` (or current status)

### 3. Visual Form Pre-population

**UI verification**:

1. **Navigate to blog detail** - any blog post
2. **Note current title and status** - remember values
3. **Click title** - enter edit mode
4. **Verify form fields populated**:
   - Title input shows current blog title
   - Blog status input shows current status
   - Form ready for editing

### 4. Create vs Edit Mode Testing

**Different modes behaviour**:

**Create mode (from modal)**:

1. **Open blog modal** - click floating action button
2. **Check form** - all fields empty
3. **No editMode prop** - component in create mode

**Edit mode (from detail)**:

1. **Click blog title** - enter edit mode
2. **Check form** - fields pre-populated
3. **editMode prop true** - component in edit mode

### 5. componentWillMount Execution

**Lifecycle verification**:

```javascript
// Add temporary logging for testing
componentWillMount() {
  console.log("componentWillMount called");
  console.log("editMode:", this.props.editMode);
  console.log("blog data:", this.props.blog);

  if (this.props.editMode) {
    console.log("Pre-populating form data");
    this.setState({
      id: this.props.blog.id,
      title: this.props.blog.title,
      blog_status: this.props.blog.blog_status
    });
  }
}
```

**Expected console output when entering edit mode**:

```
componentWillMount called
editMode: true
blog data: {id: 123, title: "My Blog Post", blog_status: "published", ...}
Pre-populating form data
```

### 6. Multiple Blog Testing

**Cross-blog verification**:

1. **Test with different blogs** - navigate to different blog details
2. **Click different titles** - enter edit mode for different blogs
3. **Verify correct data** - each form shows correct blog's data
4. **No data leakage** - previous blog's data doesn't persist

---
