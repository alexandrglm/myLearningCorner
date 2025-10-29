# 09-143: Building Full Blog Creation Workflow

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-full-blog-creation-workflow)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 85713bcd35e3c6536f927436407405dd8d36cd23](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/85713bcd35e3c6536f927436407405dd8d36cd23)

---

## 🎯 Objectives

**Implement complete blog creation workflow with multi-component communication**:

- **Three-component data flow** - BlogForm → BlogModal → Blog component
- **Form clearing** - reset form state after successful submission
- **Modal auto-close** - close modal after blog creation
- **Blog list update** - add new blog to top of list immediately
- **Parent-grandparent communication** - traverse component tree efficiently
- **Array concatenation patterns** - immutable state updates

**Advanced React pattern**: Maximum recommended component traversal depth (3 levels) before considering Redux.

---

## 🛠️ Implementation

### 1. Clear Form After Successful Submission

**File**: `src/components/blog/blog-form.js`

**Update handleSubmit .then() method**:

```javascript
handleSubmit(event) {
  axios
    .post(
      "https://jordan.devcamp.space/portfolio/portfolio_blogs",
      this.buildForm(),
      { withCredentials: true }
    )
    .then(response => {
      this.props.handleSuccessfulFormSubmission(response.data.portfolio_blog);

      this.setState({
        title: "",
        blog_status: ""
      });
    })
    .catch(error => {
      console.log("handleSubmit for blog error", error);
    });

  event.preventDefault();
}
```

### 2. Update BlogModal Data Passing

**File**: `src/components/modals/blog-modal.js`

**Update handleSuccessfulFormSubmission and add binding**:

```javascript
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

    this.handleSuccessfulFormSubmission = this.handleSuccessfulFormSubmission.bind(this);
  }

  handleSuccessfulFormSubmission(blog) {
    this.props.handleSuccessfulNewBlogSubmission(blog);
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
        <BlogForm 
          handleSuccessfulFormSubmission={this.handleSuccessfulFormSubmission}
        />
      </ReactModal>
    );
  }
}
```

### 3. Implement Blog Component Handler and Props Passing

**File**: `src/components/pages/blog.js`

**Add new method binding in constructor**:

```javascript
constructor() {
  super();

  this.state = {
    blogItems: [],
    totalCount: 0,
    currentPage: 0,
    isLoading: true,
    blogModalIsOpen: false
  };

  this.getBlogItems = this.getBlogItems.bind(this);
  this.onScroll = this.onScroll.bind(this);
  window.addEventListener("scroll", this.onScroll, false);
  this.handleNewBlogClick = this.handleNewBlogClick.bind(this);
  this.handleModalClose = this.handleModalClose.bind(this);
  this.handleSuccessfulNewBlogSubmission = this.handleSuccessfulNewBlogSubmission.bind(this);
}
```

**Add handler method**:

```javascript
handleSuccessfulNewBlogSubmission(blog) {
  this.setState({
    blogModalIsOpen: false,
    blogItems: [blog].concat(this.state.blogItems)
  });
}
```

**Pass handler as prop to BlogModal**:

```javascript
render() {
  const blogRecords = this.state.blogItems.map(blogItem => {
    return <BlogItem key={blogItem.id} blogItem={blogItem} />;
  });

  return (
    <div className="blog-container">
      <BlogModal 
        handleSuccessfulNewBlogSubmission={this.handleSuccessfulNewBlogSubmission}
        handleModalClose={this.handleModalClose}
        modalIsOpen={this.state.blogModalIsOpen} 
      />

      <div className="new-blog-link">
        <a onClick={this.handleNewBlogClick}>Open Modal!</a>
      </div>

      <div className="content-container">{blogRecords}</div>

      {this.state.isLoading ? (
        <div className="content-loader">
          <FontAwesomeIcon icon="spinner" spin />
        </div>
      ) : null}
    </div>
  );
}
```

---

## 📖 Concepts

### Three-Component Communication Pattern

**Component hierarchy and data flow**:

```javascript
// Component tree
Blog (grandparent)
├── BlogModal (parent)
    └── BlogForm (child)

// Data flow direction
BlogForm → BlogModal → Blog
```

**Communication chain**:

1. **BlogForm** creates blog post via API
2. **BlogForm** calls `this.props.handleSuccessfulFormSubmission(blog)`
3. **BlogModal** receives blog, immediately passes up
4. **BlogModal** calls `this.props.handleSuccessfulNewBlogSubmission(blog)`
5. **Blog** receives blog, updates state, closes modal

### Maximum Recommended Prop Drilling

**Why 3 levels is the limit**:

- **2 levels** (parent-child) - ideal, simple
- **3 levels** (grandparent-parent-child) - acceptable, manageable
- **4+ levels** - complex, bug-prone, consider Redux

**BlogModal as pure middleware**:

```javascript
// BlogModal does NOTHING with the data except pass it up
handleSuccessfulFormSubmission(blog) {
  this.props.handleSuccessfulNewBlogSubmission(blog);
}
```

### Form State Clearing Pattern

**Why clearing works automatically**:

```javascript
// Form inputs are controlled components
<input 
  value={this.state.title}  // ← Single source of truth
  onChange={this.handleChange}
/>

// setState clears the visual input
this.setState({
  title: "",      // ← Input automatically shows empty
  blog_status: "" // ← Input automatically shows empty
});
```

### Immutable Array Prepend Pattern

**Array concatenation explanation**:

```javascript
// Create single-item array, then concatenate existing
[blog].concat(this.state.blogItems)

// Example transformation:
// Before: [item1, item2, item3]
// New blog: newBlog
// After:  [newBlog, item1, item2, item3]
```

**JavaScript Console demonstration**:

```javascript
// Live example from guide
const items = ["one", "two", "three"];
const first = "zero";
const newList = [first].concat(items);
console.log(newList); // ["zero", "one", "two", "three"]
```

### Response.data vs Response.data.portfolio_blog

**Data structure understanding**:

```javascript
// API returns nested structure
response.data = {
  portfolio_blog: {
    id: 22,
    title: "Testing from modal", 
    blog_status: "draft",
    content: null,
    created_at: "...",
    updated_at: "..."
  }
}

// Extract the actual blog object
response.data.portfolio_blog // ← This is what we want to pass up
```

**Why extract the blog object**:

- **Clean data** - parent receives exactly what it needs
- **No parsing required** - BlogModal doesn't need to understand structure
- **Future-proof** - API structure changes don't affect parent

### State Update Strategy

**Dual state update in Blog component**:

```javascript
this.setState({
  blogModalIsOpen: false,           // Close modal
  blogItems: [blog].concat(...)     // Add new blog to list
});
```

**Why both updates together**:

- **Atomic operation** - both changes happen simultaneously
- **User experience** - modal closes AND new blog appears
- **State consistency** - no intermediate state where modal is open but blog is added

---

## ✅ Verification

### 1. Complete Workflow Testing

**End-to-end user experience**:

1. **Navigate to /blog**
2. **Click "Open Modal!" link** - modal opens
3. **Fill form fields**:
   - Title: "Full workflow test"
   - Blog Status: "published" (lowercase required)
4. **Click Save button**
5. **Expected results**:
   - ✓ **Modal closes automatically**
   - ✓ **Form clears** - inputs become empty
   - ✓ **New blog appears** at top of blog list
   - ✓ **No page refresh** - smooth UX

### 2. DevCamp Space Persistence Verification

**Database confirmation**:

1. **After local workflow test**
2. **Navigate to DevCamp Space** in browser
3. **Go to Portfolio → Blogs**
4. **Refresh page**
5. **Should see "Full workflow test"** at top of list
6. **Verify status** - "published"

### 3. Props Debugging

**Console verification during development**:

```javascript
// Temporary debugging in BlogModal
handleSuccessfulFormSubmission(blog) {
  console.log("Blog received in modal:", blog);
  this.props.handleSuccessfulNewBlogSubmission(blog);
}

// Temporary debugging in Blog
handleSuccessfulNewBlogSubmission(blog) {
  console.log("Blog received in parent:", blog);
  // ... rest of method
}
```

### 4. Error Case Testing

**Missing props function error**:

- **Error message**: `this.props.handleSuccessfulNewBlogSubmission is not a function`
- **Cause**: Forgot to pass prop from Blog to BlogModal
- **Solution**: Verify all props passed correctly

### 5. State Inspection with React DevTools

**Monitor state changes**:

1. **Open React DevTools** → Components
2. **Select Blog component**
3. **Watch state during workflow**:
   - Before: `blogModalIsOpen: false`, `blogItems: [...]`
   - After modal open: `blogModalIsOpen: true`
   - After submission: `blogModalIsOpen: false`, `blogItems: [newBlog, ...]`

---

## 🎨 Architecture Benefits and Limitations

### Benefits of This Pattern

**What works well**:

- ✓ **Clear separation of concerns** - each component has specific role
- ✓ **Reusable components** - BlogForm could be used elsewhere
- ✓ **Predictable data flow** - always flows upward
- ✓ **Easy to debug** - can trace data through each level

### Limitations Demonstrated

**Why this is maximum complexity**:

- ✗ **Prop drilling** - functions passed through multiple levels
- ✗ **Tight coupling** - components depend on specific prop names
- ✗ **Hard to maintain** - changes require updates in multiple files
- ✗ **Testing complexity** - must mock multiple component levels

### When to Consider Redux

**Indicators you need state management**:

- **4+ component levels** - prop drilling becomes unmanageable
- **Multiple siblings** need same data
- **Complex state logic** - multiple components updating same state
- **Global state** - authentication, user preferences, etc.

### Professional Development Pattern

**Incremental complexity approach**:

1. **Start simple** - single component with local state
2. **Add parent communication** - 2 levels max
3. **Extend to grandparent** - 3 levels (current guide)
4. **Consider state management** - Redux, Context API
5. **Refactor when needed** - don't over-engineer early

---
