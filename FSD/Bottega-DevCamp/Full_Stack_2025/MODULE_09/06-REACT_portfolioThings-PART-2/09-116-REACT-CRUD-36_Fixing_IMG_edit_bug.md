# 09-116: Fixing an Image Edit Bug

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/fixing-an-image-edit-bug)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at f6fd72598ac2981453c34e4f7242309bd3ef9c49](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/f6fd72598ac2981453c34e4f7242309bd3ef9c49)

---

## 🎯 Objectives

**Resolve naming conflict between existing images and newly uploaded ones**:

- **Identify the problem** - conflict when uploading new images in edit mode
- **Separate state** - use distinct names for server images vs locally uploaded ones
- **Update componentDidUpdate** - use specific names for server URLs
- **Update conditionals** - modify ternaries to use correct names
- **Maintain functionality** - ensure dropzones and images work correctly

**The specific problem**:

- In edit mode, when uploading new image via dropzone, incorrectly switches to show existing image
- Occurs because same state name used for both data types

---

## 🛠️ Implementation

### 1. Identify the Problem in componentDidUpdate

**File**: `src/components/portfolio/portfolio-form.js`

**Current problem** - naming conflict:

```javascript
// ❌ Problem: Same name for server URL and local file
this.setState({
  thumb_image: thumb_image_url || "",    // Server URL
  banner_image: banner_image_url || "",  // Server URL
  logo: logo_url || ""                   // Server URL
});

// But we also have:
// thumb_image: File (when user uploads file)
// banner_image: File (when user uploads file)
// logo: File (when user uploads file)
```

### 2. Fix componentDidUpdate with Specific Names

**Update setState to use unique names**:

```javascript
componentDidUpdate() {
  if (Object.keys(this.props.portfolioToEdit).length > 0) {
    const {
      id,
      name,
      description,
      category,
      position,
      url,
      thumb_image_url,
      banner_image_url,
      logo_url
    } = this.props.portfolioToEdit;

    this.props.clearPortfolioToEdit();

    this.setState({
      id: id,
      name: name || "",
      description: description || "",
      category: category || "eCommerce",
      position: position || "",
      url: url || "",
      editMode: true,
      apiUrl: `https://jordan.devcamp.space/portfolio/portfolio_items/${id}`,
      apiAction: "patch",
      thumb_image_url: thumb_image_url || "",
      banner_image_url: banner_image_url || "",
      logo_url: logo_url || ""
    });
  }
}
```

### 3. Update Constructor to Include New State Fields

**Add URL fields to initial state**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    name: "",
    description: "",
    category: "eCommerce",
    position: "",
    url: "",
    thumb_image_url: "",
    banner_image_url: "",
    logo_url: "",
    editMode: false,
    apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items",
    apiAction: "post"
  };

  // ... bindings remain the same
}
```

### 4. Update Conditionals to Use Specific Names

**Modify thumbnail ternary**:

```javascript
{this.state.thumb_image_url && this.state.editMode ? (
  <div className="portfolio-manager-image-wrapper">
    <img src={this.state.thumb_image_url} />
    <div className="image-removal-link">
      <a onClick={() => this.deleteImage("thumb_image")}>
        Remove file
      </a>
    </div>
  </div>
) : (
  <DropzoneComponent
    ref={this.thumbRef}
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleThumbDrop()}
  >
    <div className="dz-message">Thumbnail</div>
  </DropzoneComponent>
)}
```

**Modify banner ternary**:

```javascript
{this.state.banner_image_url && this.state.editMode ? (
  <div className="portfolio-manager-image-wrapper">
    <img src={this.state.banner_image_url} />
    <div className="image-removal-link">
      <a onClick={() => this.deleteImage("banner_image")}>
        Remove file
      </a>
    </div>
  </div>
) : (
  <DropzoneComponent
    ref={this.bannerRef}
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleBannerDrop()}
  >
    <div className="dz-message">Banner</div>
  </DropzoneComponent>
)}
```

**Modify logo ternary**:

```javascript
{this.state.logo_url && this.state.editMode ? (
  <div className="portfolio-manager-image-wrapper">
    <img src={this.state.logo_url} />
    <div className="image-removal-link">
      <a onClick={() => this.deleteImage("logo")}>
        Remove file
      </a>
    </div>
  </div>
) : (
  <DropzoneComponent
    ref={this.logoRef}
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleLogoDrop()}
  >
    <div className="dz-message">Logo</div>
  </DropzoneComponent>
)}
```

### 5. Update State Reset in handleSubmit

**Add URL fields to reset**:

```javascript
this.setState({
  name: "",
  description: "",
  category: "eCommerce",
  position: "",
  url: "",
  thumb_image_url: "",
  banner_image_url: "",
  logo_url: "",
  editMode: false,
  apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items",
  apiAction: "post"
});
```

---

## 📚 Concepts

### Separation of State Responsibilities

**Before fix - naming conflict**:

```javascript
this.state = {
  // ❌ NOPE!!! - Same field used for two different purposes
  thumb_image: "Server URL" || File object
}
```

**After fix - separated responsibilities**:

```javascript
this.state = {
  // ✅ YEP! - Separate fields with specific purposes
  thumb_image: File,         // Only for dropzone-uploaded files
  thumb_image_url: "URL"     // Only for server image URLs
}
```

### Why the Bug Occurred

**Problem sequence**:

1. **User enters edit mode** → `thumb_image` set with server URL
2. **User uploads new image** → `handleThumbDrop` sets `thumb_image` with File
3. **Ternary evaluates** → `this.state.thumb_image` exists (File object)
4. **Condition is true** → shows image, but `src` is File object, not URL
5. **Result** → broken image or unexpected behaviour

### Different Data Types in State

**Server URLs (strings)**:

```javascript
thumb_image_url: "https://devcamp-space.s3.amazonaws.com/.../image.jpg"
```

**Local files (File objects)**:

```javascript
thumb_image: File {
  name: "image.jpg",
  size: 123456,
  type: "image/jpeg"
}
```

### Improved Conditional Logic

**New conditional logic**:

```javascript
// ✅ Specific and clear
{this.state.thumb_image_url && this.state.editMode ? (
  // Show server image
) : (
  // Show dropzone for uploading new image
)}
```

**Benefits of approach**:

- **Semantic clarity** - each field has specific purpose
- **No conflicts** - data types don't mix
- **Easy debugging** - simple to identify field contents
- **Predictable functionality** - consistent behaviour

### Complete State After Fix

**State for create mode**:

```javascript
{
  thumb_image: "",         // Empty until user uploads file
  thumb_image_url: "",     // Empty because no server image
  editMode: false
}
```

**State for edit mode with existing image**:

```javascript
{
  thumb_image: "",         // Empty until user uploads new file
  thumb_image_url: "https://...", // URL of existing server image
  editMode: true
}
```

**State after uploading file in edit mode**:

```javascript
{
  thumb_image: File {...}, // New file uploaded by user
  thumb_image_url: "https://...", // URL of existing image (unchanged)
  editMode: true
}
```

---

## ✋ Verification

### Testing the Bug Fix

**Scenario 1 - Normal create mode**:

1. **Empty form** → all dropzones visible
2. **Upload image** → dropzone shows preview, doesn't switch to thumbnail
3. **Submit form** → works correctly

**Scenario 2 - Edit mode without images**:

1. **Click edit** on item without images → dropzones visible
2. **Upload image** → dropzone keeps preview, doesn't incorrectly switch
3. **Submit form** → new image saved correctly

**Scenario 3 - Edit mode with existing images**:

1. **Click edit** on item with images → thumbnails visible
2. **Original bug** → thumbnails continue displaying correctly
3. **Functionality preserved** → can make changes and save

### State Monitoring in React DevTools

**Verify state during transitions**:

1. **Select PortfolioForm** in DevTools
2. **Initial state**: all image fields empty
3. **After edit click**: only `_url` fields populated
4. **After uploading file**: only field without `_url` populated
5. **No conflicts** between the two field types

### Visual Verification

**Expected behaviour after fix**:

- **Edit mode + existing image** → shows thumbnail
- **Edit mode + upload new image** → keeps dropzone with preview
- **No unexpected switching** between thumbnail and dropzone
- **Save functionality** works in both cases

### Console Error Checking

**Verify no errors**:

1. **Clean console** during transitions
2. **No errors** about invalid `src` attribute
3. **No React warnings** about data types
4. **Smooth functionality** without interruptions

---
