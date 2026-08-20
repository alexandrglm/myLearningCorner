# 09-098 - Uploading Thumbnail Images to API in React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/uploading-thumbnail-images-api-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 29c8055cc77fc99b8363487a913faa5ce6bb8447](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/29c8055cc77fc99b8363487a913faa5ce6bb8447)

---

## 🎯 OBJECTIVES

**Complete thumbnail image upload functionality**:

- **handleThumbDrop method** to capture dropped files
- **EventHandlers integration** with DropzoneComponent
- **State management** for thumb_image file object
- **buildForm conditional logic** to include images only when existing
- **End-to-end testing** - form submission with image to API

**End-to-end functionality**:

> Drag image → Preview → Submit → API → Database → Sidebar update

---

## 🛠️ IMPLEMENTATION

### 1. Create handleThumbDrop Method

**File**: `src/components/portfolio/portfolio-form.js`

**Add method before render()**:

```javascript
handleThumbDrop() {
  return {
    addedfile: file => this.setState({ thumb_image: file })
  };
}
```

### 2. Binding Method in Constructor

**Add to existing constructor**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    name: "",
    description: "",
    category: "eCommerce",
    position: "",
    url: "",
    thumb_image: "",
    banner_image: "",
    logo: ""
  };

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
  this.componentConfig = this.componentConfig.bind(this);
  this.djsConfig = this.djsConfig.bind(this);
  this.handleThumbDrop = this.handleThumbDrop.bind(this);
}
```

### 3. Add EventHandlers to Dropzone

**Update DropzoneComponent in JSX**:

```javascript
<div className="image-uploaders">
  <DropzoneComponent 
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleThumbDrop()}
  >
  </DropzoneComponent>
</div>
```

### 4. Update buildForm Method with Conditional Logic

**Modify existing buildForm method**:

```javascript
buildForm() {
  let formData = new FormData();

  formData.append("portfolio_item[name]", this.state.name);
  formData.append("portfolio_item[description]", this.state.description);
  formData.append("portfolio_item[url]", this.state.url);
  formData.append("portfolio_item[category]", this.state.category);
  formData.append("portfolio_item[position]", this.state.position);

  if (this.state.thumb_image) {
    formData.append("portfolio_item[thumb_image]", this.state.thumb_image);
  }

  return formData;
}
```

---

## 🔧 CONCEPTS

### Event Handler Pattern for Dropzone

**handleThumbDrop structure**:

```javascript
handleThumbDrop() {
  return {
    addedfile: file => this.setState({ thumb_image: file })
  };
}
```

**How it works**:

1. **Dropzone expects object** with event handler functions
2. **addedfile** - triggered when file dropped/selected
3. **Arrow function** receives file object as parameter
4. **setState immediately** updates component state with file

### Why Return Object?

**Dropzone API requirement**:

```javascript
// Dropzone looks for specific event handler names
{
  addedfile: function,    // When file added
  removedfile: function,  // When file removed  
  success: function,      // When upload succeeds
  error: function         // When upload fails
}
```

**Documentation-driven development**:

- **Names are fixed** - you can't invent names
- **Function signatures fixed** - file parameter expected
- **Return type matters** - must be object with handlers

### File Object vs String State

**Different data types in state**:

```javascript
// Text fields - strings
name: "Project Name"
description: "Project Description"

// File field - File object
thumb_image: File {
  name: "image.jpg",
  size: 123456,
  type: "image/jpeg",
  lastModified: 1634567890123
}
```

### Conditional FormData Appending

**Why conditional logic necessary?**:

```javascript
if (this.state.thumb_image) {
  formData.append("portfolio_item[thumb_image]", this.state.thumb_image);
}
```

**Reasoning**:

- **Text fields**: Empty string → null in database (OK)
- **Image fields**: Empty → server expects File object → Error
- **Server-side processing**: Image uploads trigger special encoding
- **API consistency**: Only send image data when actually exists

### Form Submission Flow

**Complete workflow**:

1. **User drops image** → handleThumbDrop → setState with File
2. **User fills text fields** → handleChange → setState with strings  
3. **User clicks Save** → handleSubmit → buildForm() → FormData object
4. **Conditional logic** → append image only if exists
5. **Axios POST** → API with multipart/form-data → Database storage

### File Object Properties

**What's available in File object**:

```javascript
// File properties accessible
file.name          // "image.jpg"
file.size          // 123456 (bytes)
file.type          // "image/jpeg"
file.lastModified  // timestamp
```

**Use cases**:

- **Validation**: Check file.type for allowed formats
- **UX**: Display file.name to user
- **Optimisation**: Check file.size for limits

---

## ✔️ VERIFICATION

### Testing Image Drop Functionality

**Visual testing**:

1. **Navigate to portfolio-manager** 
2. **Drop image file** in dropzone area
3. **Expected behaviour**:
   - Image preview appears
   - Success checkmark animation
   - File stored in component state

### State Verification with React DevTools

**State inspection**:

1. **Open React DevTools**
2. **Select PortfolioForm** component
3. **Drop image** in dropzone
4. **Verify state change**:
   - `thumb_image: File` object appears
   - Other state values remain unchanged

### End-to-End Form Submission

**Complete workflow test**:

1. **Fill text fields**:
   - Name: "with an image"
   - Category: select option
   - Other fields optional
2. **Drop image file** → preview appears
3. **Click Save** → should succeed without errors
4. **Check console** → verify success response

### API Integration Verification

**DevCamp Space confirmation**:

1. **After successful submission**
2. **Open DevCamp Space** → Portfolio Items
3. **Refresh page** 
4. **Scroll to bottom** → find "with an image"
5. **Verify thumbnail image** → should display uploaded image

### Sidebar Update Testing

**Live portfolio update**:

1. **After form submission** success
2. **Navigate to homepage** or check sidebar
3. **New item should appear** with thumbnail image
4. **Image should render** properly in thumbnail size

### Error Case Testing

**Test without image**:

1. **Fill only text fields** (no image drop)
2. **Submit form** → should work normally
3. **Conditional logic prevents** image upload attempt
4. **Text-only item** created successfully

---
