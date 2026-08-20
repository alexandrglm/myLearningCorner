# 10-168: Communicating with Blog Update API Endpoint

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/communicating-blog-update-api-endpoint)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 0353d96a70d825e9f482c42c28a39578db875750](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/0353d96a70d825e9f482c42c28a39578db875750)

---

## 🎯 Objectives

**Implement complete system of dynamic API calls for CREATE and UPDATE operations in BlogForm**:

- **Dynamic state configuration** - apiAction and apiUrl properties that change depending on mode
- **Axios configuration object** - use axios() instead of axios.post() for flexibility
- **componentWillMount lifecycle** - configure API settings when component mounts in edit mode
- **Template literal URLs** - construct dynamic endpoints with blog ID for updates
- **HTTP method switching** - POST for create, PATCH for update operations
- **Complete edit workflow** - form submissions update existing blogs on server
- **State reset after success** - return to display mode after successful update

**Expected behaviour**: Same form handles both creating new blogs and updating existing ones with proper API endpoints and methods.

---

## 🛠️ Implementation

### 1. Add Dynamic API State to BlogForm

**File**: `src/components/blog/blog-form.js`

**Update state in constructor with API configuration**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    id: "",
    title: "",
    blog_status: "",
    content: "",
    featured_image: "",
    apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_blogs",
    apiAction: "post"
  };

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
  this.handleRichTextEditorChange = this.handleRichTextEditorChange.bind(this);

  this.componentConfig = this.componentConfig.bind(this);
  this.djsConfig = this.djsConfig.bind(this);
  this.handleFeaturedImageDrop = this.handleFeaturedImageDrop.bind(this);
  this.deleteImage = this.deleteImage.bind(this);

  this.featuredImageRef = React.createRef();
}
```

### 2. Update componentWillMount for Edit Mode Configuration

**Modify existing componentWillMount to include API configuration**:

```javascript
componentWillMount() {
  if (this.props.editMode) {
    this.setState({
      id: this.props.blog.id,
      title: this.props.blog.title,
      blog_status: this.props.blog.blog_status,
      apiUrl: `https://jordan.devcamp.space/portfolio/portfolio_blogs/${this.props.blog.id}`,
      apiAction: "patch"
    });

    if (this.props.blog.content) {
      const blocksFromHTML = htmlToDraft(this.props.blog.content);
      const { contentBlocks, entityMap } = blocksFromHTML;
      const contentState = ContentState.createFromBlockArray(contentBlocks, entityMap);
      const editorState = EditorState.createWithContent(contentState);
      this.setState({ editorState });
    }
  }
}
```

### 3. Convert handleSubmit to Use Axios Configuration Object

**Replace axios.post() with dynamic axios() configuration**:

```javascript
handleSubmit(event) {
  axios({
    method: this.state.apiAction,
    url: this.state.apiUrl,
    data: this.buildForm(),
    withCredentials: true
  })
  .then(response => {
    if (this.state.featured_image) {
      this.featuredImageRef.current.dropzone.removeAllFiles();
    }

    this.setState({
      id: "",
      title: "",
      blog_status: "",
      content: "",
      featured_image: "",
      apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_blogs",
      apiAction: "post"
    });

    if (this.props.editMode) {
      this.props.handleUpdateFormSubmission(response.data.portfolio_blog);
    } else {
      this.props.handleSuccessfulFormSubmission(response.data.portfolio_blog);
    }
  })
  .catch(error => {
    console.log("portfolio form handleSubmit error", error);
  });

  event.preventDefault();
}
```

### 4. Add handleUpdateFormSubmission to BlogDetail

**File**: `src/components/blog/blog-detail.js`

**Add method binding in constructor**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    currentId: this.props.match.params.slug,
    blogItem: {},
    editMode: false
  };

  this.getBlogItem = this.getBlogItem.bind(this);
  this.handleEditClick = this.handleEditClick.bind(this);
  this.handleFeaturedImageDelete = this.handleFeaturedImageDelete.bind(this);
  this.handleUpdateFormSubmission = this.handleUpdateFormSubmission.bind(this);
}
```

**Add method implementation**:

```javascript
handleUpdateFormSubmission(blog) {
  this.setState({
    blogItem: blog,
    editMode: false
  });
}
```

### 5. Pass handleUpdateFormSubmission as Prop

**Update BlogForm call in contentManager function**:

```javascript
render() {
  const contentManager = () => {
    if (this.state.editMode) {
      return (
        <BlogForm 
          editMode={this.state.editMode}
          blog={this.state.blogItem}
          handleFeaturedImageDelete={this.handleFeaturedImageDelete}
          handleUpdateFormSubmission={this.handleUpdateFormSubmission}
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

---

## 📧 Concepts

### Dynamic API Configuration Pattern

**State-driven API behaviour**:

```javascript
// Create mode (default)
{
  apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_blogs",
  apiAction: "post"
}

// Edit mode (configured in componentWillMount)
{
  apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_blogs/123", 
  apiAction: "patch"
}
```

**Benefits of this approach**:

- **Single form handler** - same handleSubmit for both operations
- **Clear state-driven logic** - easy to debug current mode
- **Predictable behaviour** - state determines API call type
- **Future extensible** - easy to add more operations (delete, etc.)

### Axios Configuration Object vs Helper Methods

**Helper method approach** (previous):

```javascript
// Separate calls for different operations
axios.post(url, data, config)     // Create
axios.patch(url, data, config)    // Update
```

**Configuration object approach** (current):

```javascript
// Single call with dynamic configuration
axios({
  method: this.state.apiAction,    // "post" or "patch"
  url: this.state.apiUrl,          // dynamic URL
  data: this.buildForm(),
  withCredentials: true
})
```

**Advantages**:

- **Flexibility** - same function handles multiple HTTP methods
- **Less code duplication** - single error handling, success handling
- **Dynamic method switching** - determined by component state
- **Consistent interface** - same parameters regardless of operation

### RESTful API Patterns

**Standard REST conventions followed**:

```javascript
// CREATE: POST to collection endpoint
POST /portfolio_blogs
{title: "New Blog", blog_status: "draft"}

// UPDATE: PATCH to specific resource endpoint  
PATCH /portfolio_blogs/123
{title: "Updated Blog", blog_status: "published"}
```

**URL construction**:

- **Collection endpoint** - `/portfolio_blogs` (no ID)
- **Resource endpoint** - `/portfolio_blogs/123` (with ID)
- **Template literals** - dynamic URL generation

### Component Lifecycle Integration

**componentWillMount timing**:

```javascript
// Lifecycle sequence for edit mode:
1. BlogDetail renders BlogForm with editMode=true
2. BlogForm constructor runs - sets default state
3. componentWillMount runs - configures edit mode state
4. render runs - displays populated form
```

**Why componentWillMount for configuration**:

- **Before initial render** - state configured before user sees form
- **Props available** - parent props accessible for configuration
- **Single execution** - only runs once when component mounts

### State Management for Mode Switching

**Edit mode configuration**:

```javascript
if (this.props.editMode) {
  this.setState({
    // Form data
    id: this.props.blog.id,
    title: this.props.blog.title,
    blog_status: this.props.blog.blog_status,

    // API configuration
    apiUrl: `https://jordan.devcamp.space/portfolio/portfolio_blogs/${this.props.blog.id}`,
    apiAction: "patch"
  });
}
```

**State reset after successful submission**:

```javascript
this.setState({
  id: "",
  title: "",
  blog_status: "",
  content: "",
  featured_image: "",
  apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_blogs",
  apiAction: "post"
});
```

### Parent-Child Success Communication

**Different success handlers for different modes**:

```javascript
if (this.props.editMode) {
  this.props.handleUpdateFormSubmission(response.data.portfolio_blog);
} else {
  this.props.handleSuccessfulFormSubmission(response.data.portfolio_blog);
}
```

**Why different handlers**:

- **Edit mode** - update BlogDetail state, return to display mode
- **Create mode** - close modal, update blog list (different parent behaviour)
- **Flexible communication** - parents can handle success differently

### HTTP Method Semantics

**POST vs PATCH behaviour**:

**POST (Create)**:

- **Creates new resource** - server generates new ID
- **Non-idempotent** - multiple calls create multiple resources
- **URL structure** - collection endpoint (no ID)
- **Response** - newly created resource with assigned ID

**PATCH (Update)**:

- **Modifies existing resource** - updates specific record
- **Idempotent** - multiple calls have same effect
- **URL structure** - resource endpoint (with ID)
- **Response** - updated resource with modifications

---

## 📋 Verification

### 1. Create Mode Testing

**Test new blog creation workflow**:

1. **Open blog modal** - floating action button
2. **Fill form fields** - title, status, content, image
3. **Submit form**
4. **Verify API call**:
   - Method: POST
   - URL: `.../portfolio_blogs` (no ID)
5. **Modal closes** - returns to blog list
6. **New blog appears** - in blog index

### 2. Edit Mode Testing

**Test blog update workflow**:

1. **Navigate to blog detail** - any existing blog
2. **Click blog title** - enter edit mode
3. **Form pre-populated** - existing data visible
4. **Modify some fields** - change title, content, etc.
5. **Submit form**
6. **Verify API call**:
   - Method: PATCH  
   - URL: `.../portfolio_blogs/123` (with ID)
7. **Return to display mode** - updated content visible
8. **No page refresh** - smooth transition

### 3. State Configuration Verification

**React DevTools inspection**:

1. **Create mode**:
   
   - `apiAction: "post"`
   - `apiUrl: "...portfolio_blogs"`
   - `editMode: false` (or undefined)

2. **Edit mode**:
   
   - `apiAction: "patch"`
   - `apiUrl: "...portfolio_blogs/123"`
   - Form fields populated with existing data

### 4. Network Tab Verification

**API call inspection**:

1. **Open DevTools** → Network tab
2. **Create new blog** → verify POST request
3. **Edit existing blog** → verify PATCH request  
4. **Check URLs** - correct endpoints (with/without ID)
5. **Inspect payloads** - FormData content
6. **Verify responses** - successful status codes

### 5. End-to-End Workflow Testing

**Complete edit cycle**:

1. **Display mode** - blog shows current content
2. **Enter edit mode** - click title, form appears
3. **Make changes** - modify title, content, featured image
4. **Submit changes** - form processes update
5. **Return to display** - updated content immediately visible
6. **Persistence check** - refresh page, changes remain

### 6. Error Handling Testing

**Test error scenarios**:

1. **Network disconnected** - verify error handling
2. **Invalid blog ID** - API returns appropriate error  
3. **Unauthorised updates** - authentication failures
4. **Server errors** - 500 status codes handled gracefully

---
