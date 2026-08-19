# 10-167: Deleting Featured Blog Images via API and Updating Parent Component State

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/deleting-featured-blog-images-api-updating-parent-component-state)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at bffe32751121166c8bed5405da2cd3b6c23cca3c](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/bffe32751121166c8bed5405da2cd3b6c23cca3c)

---

## 🎯 Objectives

**Implement complete functionality for deleting featured images with API integration and parent state updates**:

- **API DELETE call** - delete featured image from server using blog ID
- **Parent-child communication** - BlogForm updates BlogDetail state via props
- **Dynamic state management** - clear featured_image_url from parent component
- **onClick handler integration** - connect "Remove File" link with delete functionality  
- **Professional UX pattern** - image deletion → immediate UI update → dropzone reappears
- **Pattern replication** - follow same approach used in portfolio manager

**Expected workflow**: User clicks "Remove File" → API deletes image → parent state updates → UI switches to dropzone.

---

## 🛠️ Implementation

### 1. Add deleteImage Method to BlogForm

**File**: `src/components/blog/blog-form.js`

**Add method binding in constructor**:

```javascript
constructor(props) {
  super(props);

  // ... existing state and bindings

  this.componentConfig = this.componentConfig.bind(this);
  this.djsConfig = this.djsConfig.bind(this);
  this.handleFeaturedImageDrop = this.handleFeaturedImageDrop.bind(this);
  this.deleteImage = this.deleteImage.bind(this);

  this.featuredImageRef = React.createRef();
}
```

**Add deleteImage method before render**:

```javascript
deleteImage(imageType) {
  axios
    .delete(
      `https://api.devcamp.space/portfolio/delete-portfolio-blog-image/${this.props.blog.id}?image_type=${imageType}`,
      { withCredentials: true }
    )
    .then(response => {
      this.props.handleFeaturedImageDelete();
    })
    .catch(error => {
      console.log("deleteImage error", error);
    });
}
```

### 2. Add handleFeaturedImageDelete to BlogDetail

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
}
```

**Add method implementation**:

```javascript
handleFeaturedImageDelete() {
  this.setState({
    blogItem: {
      ...this.state.blogItem,
      featured_image_url: ""
    }
  });
}
```

### 3. Pass handleFeaturedImageDelete as Prop

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

### 4. Connect onClick Handler to Remove File Link

**Update conditional rendering in BlogForm**:

```javascript
<div className="image-uploaders">
  {this.props.editMode && this.props.blog.featured_image_url ? (
    <div className="portfolio-manager-image-wrapper">
      <img src={this.props.blog.featured_image_url} />
      <div className="image-removal-link">
        <a onClick={() => this.deleteImage("featured_image")}>
          Remove File
        </a>
      </div>
    </div>
  ) : (
    <DropzoneComponent 
      ref={this.featuredImageRef}
      config={this.componentConfig()}
      djsConfig={this.djsConfig()}
      eventHandlers={this.handleFeaturedImageDrop()}
    >
      <div className="dz-message">Featured Image</div>
    </DropzoneComponent>
  )}
</div>
```

---

## 📧 Concepts

### API Endpoint Structure

**Delete endpoint anatomy**:

```javascript
`https://api.devcamp.space/portfolio/delete-portfolio-blog-image/${this.props.blog.id}?image_type=${imageType}`
```

**URL components**:

- **Base endpoint**: `delete-portfolio-blog-image`
- **Blog ID**: `${this.props.blog.id}` - identifies which blog
- **Query parameter**: `?image_type=featured_image` - specifies image type

**Example generated URL**:

```
https://api.devcamp.space/portfolio/delete-portfolio-blog-image/123?image_type=featured_image
```

### Parent-Child State Communication Pattern

**Data flow architecture**:

```javascript
// Child (BlogForm) triggers action
this.deleteImage("featured_image")

// Child calls parent function via props  
this.props.handleFeaturedImageDelete()

// Parent (BlogDetail) updates its state
this.setState({
  blogItem: { ...this.state.blogItem, featured_image_url: "" }
})

// React re-renders, child receives updated props
// Conditional rendering switches to dropzone
```

### State Immutability with Object Spread

**Why use spread operator**:

```javascript
// ❌ Direct mutation (bad)
this.state.blogItem.featured_image_url = "";
this.setState({ blogItem: this.state.blogItem });

// ✅ Immutable update (correct)
this.setState({
  blogItem: {
    ...this.state.blogItem,
    featured_image_url: ""
  }
});
```

**Benefits of immutable updates**:

- **React optimisation** - proper change detection
- **Predictable behaviour** - no unexpected side effects
- **Debugging** - clear state history
- **Component re-renders** - triggered correctly

### onClick Handler with Parameters

**Arrow function pattern**:

```javascript
<a onClick={() => this.deleteImage("featured_image")}>
  Remove File
</a>
```

**Why arrow function is necessary**:

```javascript
// ❌ Immediate execution (wrong)
<a onClick={this.deleteImage("featured_image")}>

// ✅ Function reference with parameter (correct)  
<a onClick={() => this.deleteImage("featured_image")}>
```

**Parameter passing explanation**:

- **Arrow function** creates anonymous function
- **Parameter preserved** - "featured_image" passed to deleteImage
- **Correct timing** - only executes when clicked

### Professional UX Pattern: Reactive State Updates

**User experience flow**:

1. **User sees image** - current featured image displayed
2. **User clicks "Remove File"** - immediate action
3. **API call executes** - server deletes image
4. **State updates immediately** - UI changes without page reload
5. **Dropzone appears** - ready for new image upload

**Why immediate state update**:

- **Responsive feedback** - user sees immediate result
- **No page refresh** - smooth, modern UX
- **Optimistic update** - assumes API success (with error handling)
- **React's strength** - reactive UI updates

### Component Communication Best Practices

**Props passing strategy**:

```javascript
// BlogDetail passes function to BlogForm
<BlogForm handleFeaturedImageDelete={this.handleFeaturedImageDelete} />

// BlogForm calls function when needed
this.props.handleFeaturedImageDelete();
```

**Alternative approaches (not used here)**:

- **Event emitters** - more complex, unnecessary here
- **State management libraries** - Redux, Context (overkill for this)
- **Direct DOM manipulation** - anti-pattern in React

### Error Handling Strategy

**Current implementation**:

```javascript
.catch(error => {
  console.log("deleteImage error", error);
});
```

**Future enhancements could include**:

- User notification of deletion failure
- Reverting optimistic state updates
- Retry mechanisms
- Specific error message display

### Pattern Replication from Portfolio Manager

**Similar implementation patterns**:

```javascript
// Portfolio manager approach (reference)
deleteImage(imageType) {
  axios.delete(endpoint)
    .then(response => {
      this.setState({ [`${imageType}_url`]: "" });
    });
}

// Blog form approach (this implementation)
deleteImage(imageType) {
  axios.delete(endpoint)
    .then(response => {
      this.props.handleFeaturedImageDelete();
    });
}
```

**Key difference**: Portfolio updates own state, Blog updates parent state via props.

---

## 📋 Verification

### 1. Featured Image Delete Testing

**Complete workflow verification**:

1. **Navigate to blog with featured image**
2. **Click blog title** - enter edit mode
3. **Verify image displays** - current featured image visible
4. **Click "Remove File"** link
5. **Verify immediate UI change** - dropzone should appear
6. **Check console** - should show successful API response

### 2. API Call Verification

**Network tab inspection**:

1. **Open DevTools** → Network tab
2. **Click "Remove File"** link
3. **Verify DELETE request** appears in network tab
4. **Check request URL** - should include correct blog ID and image_type parameter
5. **Verify response** - should be successful (200/204 status)

### 3. State Management Testing

**React DevTools inspection**:

1. **Enter edit mode** - verify blogItem has featured_image_url
2. **Click "Remove File"** 
3. **Check BlogDetail state** - featured_image_url should become empty string
4. **Verify props update** - BlogForm should receive updated blog prop
5. **Conditional rendering** - should switch to dropzone view

### 4. Parent-Child Communication

**Props flow verification**:

1. **React DevTools** → Components
2. **Select BlogForm component**
3. **Check props**:
   - `handleFeaturedImageDelete: function` should be present
   - `blog.featured_image_url` should update after deletion
4. **Function execution** - verify parent method called correctly

### 5. Edge Cases Testing

**Error scenarios**:

1. **Network disconnected** - verify error handling
2. **Invalid blog ID** - API should return appropriate error
3. **Already deleted image** - should handle gracefully
4. **Multiple rapid clicks** - should prevent duplicate API calls

### 6. UI State Consistency

**Visual behaviour verification**:

1. **Before deletion** - image displayed, "Remove File" link visible
2. **During deletion** - immediate UI feedback
3. **After deletion** - dropzone component appears
4. **Upload new image** - dropzone should work normally
5. **Switch to display mode** - no image should be shown

### 7. Cross-Component Integration

**Full edit workflow**:

1. **Display mode** - blog shows with featured image
2. **Enter edit mode** - image appears in form
3. **Delete image** - switches to dropzone
4. **Upload new image** - new image appears
5. **Exit edit mode** - new image displays in blog detail

---
