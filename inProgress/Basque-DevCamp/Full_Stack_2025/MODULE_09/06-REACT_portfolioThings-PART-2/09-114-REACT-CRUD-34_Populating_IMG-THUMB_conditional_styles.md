# 09-114: Populating Image Thumbnail Conditionals Styles

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/populating-image-thumbnail-conditionals-styles)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 85e6a84a59278fae9da28a90be6c2bde9ed1a1f7](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/85e6a84a59278fae9da28a90be6c2bde9ed1a1f7)

---

## 🎯 Objectives

**Complete the implementation of displaying existing images in edit mode**:

- **Wrap images in containers** - create portfolio-manager-image-wrapper for styling
- **Extend ternaries for banner and logo** - implement conditional rendering for all images
- **Add professional styles** - controlled sizing, rounded corners, object-fit
- **Prepare for deletion functionality** - wrapper prepared for future delete buttons

**Visual result**:

- Existing images display in styled boxes 120px height
- Dropzones hidden when images exist in edit mode
- Clean layout with rounded corners and controlled dimensions

---

## 🛠️ Implementation

### 1. Add Wrapper Div for Thumbnail Image

**File**: `src/components/portfolio/portfolio-form.js`

**Modify thumbnail ternary to include wrapper**:

```javascript
{this.state.thumb_image && this.state.editMode ? (
  <div className="portfolio-manager-image-wrapper">
    <img src={this.state.thumb_image} />
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

### 2. Implement Ternary Conditional for Banner Image

**Add conditional rendering for banner after thumbnail**:

```javascript
{this.state.banner_image && this.state.editMode ? (
  <div className="portfolio-manager-image-wrapper">
    <img src={this.state.banner_image} />
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

### 3. Implement Ternary Conditional for Logo Image

**Add conditional rendering for logo after banner**:

```javascript
{this.state.logo && this.state.editMode ? (
  <div className="portfolio-manager-image-wrapper">
    <img src={this.state.logo} />
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

### 4. Add Styles for Image Wrapper

**File**: `src/style/portfolio-form.scss`

**Add styles within .image-uploaders**:

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
}
```

---

## 📚 Concepts

### Wrapper Div Pattern for Styling

**Why we need the wrapper div**:

```javascript
// ❌ NOPE! - Without wrapper - hard to style
<img src={this.state.thumb_image} />

// ✅ YEP! - With wrapper - full styling control
<div className="portfolio-manager-image-wrapper">
  <img src={this.state.thumb_image} />
</div>
```

**Benefits of wrapper pattern**:

- **Dimension control** - wrapper defines total space
- **Preparation for additional content** - delete buttons, overlays, etc.
- **Independent styling** - image and container can have different styles
- **Future flexibility** - easy to add functionality without restructuring

### Object-fit Cover for Image Control

**How object-fit works**:

```scss
img {
  width: 100%;        // Takes full width of container
  height: 120px;      // Fixed height for consistency
  object-fit: cover;  // Scales to fill maintaining aspect
}
```

**Behaviour of object-fit: cover**:

- **Maintains proportion** - doesn't distort original image
- **Fills completely** - no empty spaces left
- **Crops if necessary** - automatically centres the crop
- **Visual consistency** - all images same size

### Conditional State for Multiple Images

**Different possible states for each image**:

```javascript
// State 1: Create mode - always shows dropzone
editMode: false  → shows DropzoneComponent

// State 2: Edit mode without image - shows dropzone
editMode: true + thumb_image: ""  → shows DropzoneComponent

// State 3: Edit mode with image - shows image
editMode: true + thumb_image: "url"  → shows image
```

**Why double condition necessary**:

- **Verify image exists** - avoids empty img tags
- **Verify edit mode** - only show images when editing
- **Fallback to dropzone** - any other case shows uploader

### CSS Border-radius for Professional Aesthetics

**Subtle rounded corners**:

```scss
border-radius: 5px;
```

**Visual impact**:

- **Modern appearance** - rounded corners more attractive
- **Brand consistency** - matches other rounded elements
- **Visual softness** - reduces harshness of square edges
- **Design standard** - common practice in modern interfaces

### Nested SCSS for Organisation

**Clear hierarchical structure**:

```scss
.image-uploaders {
  // Main container styles

  .portfolio-manager-image-wrapper {
    // Image wrapper specific styles

    img {
      // Image specific styles
    }
  }
}
```

**Benefits of nesting**:

- **Logical organisation** - styles grouped by relationship
- **Automatic specificity** - more specific CSS without extra classes
- **Easy maintenance** - changes localised to one section
- **Improved readability** - clear visual structure

### Preparation for Future Functionality

**Wrapper is prepared for**:

```scss
.portfolio-manager-image-wrapper {
  // Relative position for future absolute elements
  position: relative;

  img {
    // Current image styles
  }

  // Space ready for:
  // .delete-button { position: absolute; ... }
  // .image-overlay { position: absolute; ... }
  // .image-actions { display: flex; ... }
}
```

---

## ✋ Verification

### Testing Conditional Rendering

**Test different image scenarios**:

1. **Portfolio item with all 3 images**:
   
   - Click edit → 3 images appear, 0 dropzones

2. **Portfolio item with only thumbnail**:
   
   - Click edit → thumbnail shows image, banner/logo show dropzones

3. **Portfolio item without images**:
   
   - Click edit → all 3 show dropzones

4. **Create mode**:
   
   - Empty form → all 3 show dropzones

### Visual Inspection of Styles

**Verify style application**:

1. **Consistent sizing** - all images 120px height
2. **Rounded corners** - smooth corners on all images
3. **Object-fit working** - images not distorted
4. **Width 100%** - images fill containers completely

### State in React DevTools

**Monitor state changes during edit**:

1. **Select PortfolioForm** component in DevTools
2. **Initial state**: `editMode: false`, all images `""`
3. **After edit click**: `editMode: true`, images with URLs
4. **Conditional rendering** - verify components change

### Layout Grid Verification

**Verify grid remains intact**:

1. **Three columns** - 200px layout for each uploader
2. **Consistent spacing** - grid-gap maintains separation
3. **Alignment** - images and dropzones aligned correctly
4. **Responsive** - layout adapts when resizing window

### Error Handling Verification

**Edge cases to verify**:

1. **Broken image URLs** - shouldn't break layout
2. **Very small images** - object-fit should handle correctly
3. **Very large images** - should scale appropriately
4. **Quick switching** between edit/create - no state errors

### Browser Compatibility Testing

**Verify on different browsers**:

1. **Chrome** - object-fit and border-radius work
2. **Firefox** - conditional rendering correct
3. **Safari** - CSS styles applied correctly
4. **Edge** - grid layout maintains structure

---
