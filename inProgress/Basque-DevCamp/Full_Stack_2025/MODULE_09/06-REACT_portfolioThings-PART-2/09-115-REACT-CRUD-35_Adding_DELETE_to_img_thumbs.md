# 09-115: Adding Delete Image Links Image Thumbnails

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/adding-delete-image-links-image-thumbnails)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at fd95c661a5aea0e35676df812465124d792a7ac7](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/fd95c661a5aea0e35676df812465124d792a7ac7)

---

## 🎯 Objectives

**Add deletion links for images in edit mode**:

- **Create deleteImage function** - method to handle individual image deletion
- **Add "Remove file" links** - deletion buttons below each image
- **Pass image type** - identify which image to delete (thumb_image, banner_image, logo)
- **Style deletion links** - red colour, bold font weight, centred
- **Prepare for real functionality** - structure ready for API implementation

**Visual result**:

- "Remove file" links appear below each image in edit mode
- Prominent red styling to indicate destructive action
- Console logging to verify correct functioning

---

## 🛠️ Implementation

### 1. Create deleteImage Method and Binding

**File**: `src/components/portfolio/portfolio-form.js`

**Add method and binding in constructor**:

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
    logo: "",
    editMode: false,
    apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items",
    apiAction: "post"
  };

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
  this.componentConfig = this.componentConfig.bind(this);
  this.djsConfig = this.djsConfig.bind(this);
  this.handleThumbDrop = this.handleThumbDrop.bind(this);
  this.handleBannerDrop = this.handleBannerDrop.bind(this);
  this.handleLogoDrop = this.handleLogoDrop.bind(this);
  this.deleteImage = this.deleteImage.bind(this);
}

deleteImage(imageType) {
  console.log("deleteImage", imageType);
}
```

### 2. Add Deletion Link for Thumbnail

**Modify thumbnail ternary to include deletion link**:

```javascript
{this.state.thumb_image && this.state.editMode ? (
  <div className="portfolio-manager-image-wrapper">
    <img src={this.state.thumb_image} />
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

### 3. Add Deletion Link for Banner

**Modify banner ternary to include deletion link**:

```javascript
{this.state.banner_image && this.state.editMode ? (
  <div className="portfolio-manager-image-wrapper">
    <img src={this.state.banner_image} />
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

### 4. Add Deletion Link for Logo

**Modify logo ternary to include deletion link**:

```javascript
{this.state.logo && this.state.editMode ? (
  <div className="portfolio-manager-image-wrapper">
    <img src={this.state.logo} />
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

### 5. Add Styles for Deletion Links

**File**: `src/style/portfolio-form.scss`

**Add styles for image-removal-link**:

```scss
.image-uploaders {
  @include base-grid();
  grid-template-columns: 200px 200px 200px;

  .portfolio-manager-image-wrapper {
    img {
      width: 100%;
      height: 120px;
      object-fit: cover;
      border-radius: 5px;
    }
  }

  .image-removal-link {
    display: flex;
    justify-content: center;

    a {
      font-weight: 900;
      colour: $warning;
      cursor: pointer;
    }
  }
}
```

---

## 📚 Concepts

### Anonymous Function onClick with Parameters

**Why we need anonymous function**:

```javascript
// ❌ NOPE! - Incorrect - executes immediately on render
<a onClick={this.deleteImage("thumb_image")}>

// ✅ YEP! - Correct - executes only when clicked
<a onClick={() => this.deleteImage("thumb_image")}>
```

**Technical explanation**:

- **Without arrow function** - JavaScript executes function during render
- **With arrow function** - creates function that waits for user click
- **Parameter passing** - allows identifying which image to delete

### Image Type Naming Convention

**Why use underscores instead of camelCase**:

```javascript
// ✅ Used in implementation
"thumb_image"
"banner_image"
"logo"

// ❌ Don't use camelCase
"thumbImage"
"bannerImage"
```

**Reason for convention**:

- **API consistency** - server expects these exact names
- **Database field names** - database fields use underscores
- **Future API calls** - when implementing real deletion, names must match

### Data Flow Structure for Image Deletion

**Complete flow that will be implemented**:

```
1. User clicks "Remove file"
2. deleteImage("thumb_image") called
3. API call to delete image from server
4. setState to clear image URL from state
5. Re-render shows dropzone instead of image
```

**Current state (console logging only)**:

- Function defined and bound correctly
- Parameters passing correctly
- Prepared for real API implementation

### Flexbox for Centring Links

**Why use display: flex**:

```scss
.image-removal-link {
  display: flex;          // Activates flexbox
  justify-content: center; // Centres horizontally
}
```

**Benefits of flexbox approach**:

- **Perfect centring** - text centred regardless of width
- **Responsive** - remains centred at different sizes
- **Simple** - one CSS line instead of multiple properties
- **Modern** - current standard for alignment

### Colour Psychology for Destructive Actions

**Why use warning colour**:

```scss
a {
  colour: $warning;  // Red colour to indicate danger
  font-weight: 900;  // Bold font weight for prominence
}
```

**Applied UX principles**:

- **Red colour** - universally associated with deletion/danger
- **High font weight** - makes action more visible
- **Cursor pointer** - clearly indicates clickable
- **Visual contrast** - stands out from other content

### Preparation for Future Implementation

**What current structure facilitates**:

```javascript
deleteImage(imageType) {
  // Future: API call to delete from server
  // axios.delete(`/api/images/${this.state.id}/${imageType}`)

  // Future: Clear local state
  // this.setState({ [imageType]: "" })

  // Current: Logging to verify functioning
  console.log("deleteImage", imageType);
}
```

---

## ✋ Verification

### Testing Console Logging

**Verify links functioning**:

1. **Navigate to portfolio-manager**
2. **Click edit** on item with images
3. **Open browser console** (F12)
4. **Click "Remove file"** below thumbnail
5. **Verify console output**: `deleteImage thumb_image`
6. **Click "Remove file"** below banner
7. **Verify console output**: `deleteImage banner_image`
8. **Click "Remove file"** below logo
9. **Verify console output**: `deleteImage logo`

### Visual Styling Verification

**Check appearance of links**:

1. **Links visible** - "Remove file" text appears below each image
2. **Red colour** - $warning variable applied correctly
3. **Bold font weight** - text appears prominent
4. **Centred** - links centred horizontally
5. **Cursor pointer** - cursor changes on hover

### Layout Integrity Testing

**Verify layout remains intact**:

1. **Grid structure** - images maintain 200px arrangement
2. **Image sizing** - images still 120px height
3. **Wrapper functionality** - container accommodates image + link
4. **Spacing consistency** - uniform spacing between elements

### Different Image States Testing

**Test different image combinations**:

1. **Item with all 3 images** - should show 3 "Remove file" links
2. **Item with only thumbnail** - only 1 link appears below thumbnail
3. **Item without images** - no links appear, only dropzones
4. **Switching between items** - links appear/disappear correctly

### Parameter Passing Verification

**Confirm correct parameters passed**:

1. **Thumbnail click** → console shows "thumb_image"
2. **Banner click** → console shows "banner_image"  
3. **Logo click** → console shows "logo"
4. **No confusion** between image types

### React DevTools State Monitoring

**Verify state during editing**:

1. **Select PortfolioForm** component in DevTools
2. **Confirm editMode: true** when links show
3. **Confirm image URLs** populated in state
4. **No state changes** when clicking (for now - logging only)

---
