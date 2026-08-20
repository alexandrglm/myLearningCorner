# 10-158: Adding Ability Upload Featured Images Blogs

---

**[Guide](https://devcamp.com/trails/dissecting-react-js/campsites/building-blog-react/guides/adding-ability-upload-featured-images-blogs)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at ae6dea380cc6594ae2a3badbc9ec2c40d38f6756](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/ae6dea380cc6594ae2a3badbc9ec2c40d38f6756)

---

## 🎯 Objectives

**Complete featured image upload functionality with form clearing**:

- **Update buildForm method** - conditional FormData append for featured_image
- **Add React ref** - createRef for accessing DropzoneComponent directly
- **Implement form clearing** - reset both React state and Dropzone component state
- **End-to-end testing** - complete blog creation with image upload
- **Professional UX** - automatic form reset after successful submission

**Pattern replication**: Using same approach as portfolio manager but simplified for single image

**Data flow**: User uploads image → state stores File object → FormData sends to API → form clears automatically

---

## 🛠️ Implementation

### 1. Update buildForm Method with Conditional Logic

**File**: `src/components/blog/blog-form.js`

**Add conditional check before return**:

```javascript
buildForm() {
  let formData = new FormData();

  formData.append("portfolio_blog[title]", this.state.title);
  formData.append("portfolio_blog[blog_status]", this.state.blog_status);
  formData.append("portfolio_blog[content]", this.state.content);

  if (this.state.featured_image) {
    formData.append("portfolio_blog[featured_image]", this.state.featured_image);
  }

  return formData;
}
```

### 2. Add React Ref to Constructor

**Add featuredImageRef creation**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    title: "",
    blog_status: "",
    content: "",
    featured_image: ""
  };

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
  this.handleRichTextEditorChange = this.handleRichTextEditorChange.bind(this);

  this.componentConfig = this.componentConfig.bind(this);
  this.djsConfig = this.djsConfig.bind(this);
  this.handleFeaturedImageDrop = this.handleFeaturedImageDrop.bind(this);

  // Create ref for Dropzone component
  this.featuredImageRef = React.createRef();
}
```

### 3. Attach Ref to DropzoneComponent

**Add ref prop to DropzoneComponent**:

```javascript
<div className="image-uploaders">
  <DropzoneComponent 
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleFeaturedImageDrop()}
    ref={this.featuredImageRef}
  >
    <div className="dz-message">Featured Image</div>
  </DropzoneComponent>
</div>
```

### 4. Implement Form Clearing in handleSubmit

**Update handleSubmit with clearing logic**:

```javascript
handleSubmit(event) {
  // Clear Dropzone if image exists (before setState)
  if (this.state.featured_image) {
    this.featuredImageRef.current.dropzone.removeAllFiles();
  }

  axios({
    method: this.state.apiAction,
    url: this.state.apiUrl,
    data: this.buildForm(),
    withCredentials: true
  })
  .then(response => {
    this.setState({
      title: "",
      blog_status: "",
      content: "",
      featured_image: ""
    });

    this.props.handleSuccessfulFormSubmission(response.data.portfolio_blog);
  })
  .catch(error => {
    console.log("portfolio form handleSubmit error", error);
  });

  event.preventDefault();
}
```

---

## 📖 Concepts

### Conditional FormData Appending

**Why conditional logic is necessary**:

```javascript
// ✗ Always appending (causes API errors)
formData.append("portfolio_blog[featured_image]", this.state.featured_image);
// Problem: sends empty string when no image, API rejects

// ✓ Conditional appending (safe approach)
if (this.state.featured_image) {
  formData.append("portfolio_blog[featured_image]", this.state.featured_image);
}
// Solution: only sends image data when File object exists
```

**API behaviour understanding**:

- **Empty string** - API treats as invalid file upload attempt
- **File object** - API processes as legitimate file upload
- **Omitted field** - API treats as "no image provided" (acceptable)

### React Refs for Third-Party Library Control

**Why refs are necessary here**:

```javascript
// React state (component memory)
this.state.featured_image = File  // React knows about this

// Dropzone state (DOM/library memory)  
// Preview images, drag zones, file lists
// React doesn't automatically manage this
```

**ref.current.dropzone pattern**:

```javascript
this.featuredImageRef.current.dropzone.removeAllFiles();
//                    ↓        ↓        ↓
//                    |        |        └── Dropzone.js method
//                    |        └── Dropzone instance
//                    └── DOM element/component instance
```

### Form Clearing Execution Order

**Critical timing sequence**:

```javascript
// ✓ Correct order
// 1. Clear Dropzone BEFORE setState (file still exists in state)
if (this.state.featured_image) {
  this.featuredImageRef.current.dropzone.removeAllFiles();
}

// 2. API call happens
axios.post(...)

// 3. Clear React state AFTER successful response
.then(response => {
  this.setState({
    featured_image: ""  // Clear state after Dropzone cleared
  });
})
```

**Why order matters**:

- **Check before clear** - need to check if file exists before clearing
- **Clear DOM first** - remove visual previews whilst state still available
- **Clear state last** - reset React state after DOM successfully cleared

### File Object vs String State Management

**State evolution during form lifecycle**:

```javascript
// Initial state
featured_image: ""  // Empty string

// After file upload
featured_image: File {
  name: "image.jpg",
  size: 123456,
  type: "image/jpeg"
}

// During form clearing check
if (this.state.featured_image) {  // File object is truthy
  // Clear Dropzone preview
}

// After successful submission
featured_image: ""  // Back to empty string
```

### API Field Naming Convention

**Nested field structure**:

```javascript
"portfolio_blog[featured_image]"
//      ↓              ↓
//      |              └── Field name
//      └── Model/namespace name
```

**Why this structure**:

- **API expects nested data** - portfolio_blog model with featured_image field
- **Database mapping** - corresponds to portfolio_blog table structure
- **Consistent with other fields** - title, blog_status, content follow same pattern

### Professional UX Pattern

**Expected form behaviour**:

1. **User fills form** - text inputs and file upload
2. **User submits** - form processes
3. **Success response** - server confirms creation
4. **Automatic reset** - form clears completely
5. **Ready for next entry** - clean state for new blog post

**Why automatic clearing matters**:

- **Prevents accidental resubmission** - user can't submit same data twice
- **Clear visual feedback** - user knows submission succeeded
- **Professional experience** - matches user expectations from other applications

---

## ✅ Verification

### 1. Featured Image Upload Testing

**Complete workflow verification**:

1. **Open blog modal** - click "Open Modal!" link
2. **Fill form fields**:
   - Title: "Testing with image"
   - Blog Status: "published"  
   - Content: Add some rich text content
3. **Upload featured image** - drag image to dropzone
4. **Verify preview** - image preview appears
5. **Submit form** - click Save button

### 2. API Integration Verification

**Check successful upload**:

1. **Form should clear** - all fields empty, image preview gone
2. **Modal should close** - returns to blog index
3. **New blog appears** - "Testing with image" visible in list
4. **Click blog title** - navigate to detail page
5. **Verify featured image** - image displays in blog detail

### 3. Form Clearing Verification

**Test automatic reset behaviour**:

1. **Before submission** - form populated with data
2. **After submission** - verify complete clearing:
   - ✓ **Title field empty**
   - ✓ **Blog status field empty**
   - ✓ **Rich text editor empty**
   - ✓ **Image dropzone reset** - no preview visible
   - ✓ **State cleared** - React DevTools shows empty state

### 4. Conditional Logic Testing

**Test with and without images**:

**With image**:

- Upload image → submit → should include image in FormData

**Without image**:

- Don't upload image → submit → should work without featured_image field

### 5. Error Handling Testing

**Edge case verification**:

1. **Invalid file types** - should be rejected by dropzone
2. **Network errors** - form should handle API failures gracefully
3. **Large files** - test with large images for performance

### 6. React DevTools State Inspection

**Monitor state changes**:

1. **Initial state** - all fields empty strings
2. **After typing** - title, blog_status populated
3. **After image upload** - featured_image shows File object
4. **After submission** - all fields reset to empty strings

---

## 🎨 Professional Development Insights

### Pattern Replication Strategy

**Portfolio manager vs Blog form patterns**:

```javascript
// Same core concepts, different context:
// - Conditional FormData appending
// - React refs for third-party libraries  
// - Form clearing after submission
// - File object state management
```

**Benefits of pattern consistency**:

- **Faster development** - leverage proven solutions
- **Reduced bugs** - tested patterns less error-prone  
- **Team knowledge** - consistent approaches across codebase
- **Maintenance ease** - similar problems, similar solutions

### Third-Party Library Integration Mastery

**Skills demonstrated**:

- **Library documentation** - understanding Dropzone.js API
- **React integration** - bridging React and non-React libraries
- **State management** - coordinating React state with library state
- **Lifecycle management** - proper cleanup and reset patterns

### Professional Form UX

**User experience principles applied**:

- **Clear feedback** - visual confirmation of actions
- **Automatic reset** - prevents user confusion
- **Error prevention** - conditional logic prevents API errors
- **Professional behaviour** - matches user expectations

### API Integration Best Practices

**Demonstrated patterns**:

- **Conditional data sending** - only send data when appropriate
- **Proper error handling** - catch and log errors appropriately  
- **Authentication** - withCredentials for session-based auth
- **FormData usage** - correct approach for file uploads

---
