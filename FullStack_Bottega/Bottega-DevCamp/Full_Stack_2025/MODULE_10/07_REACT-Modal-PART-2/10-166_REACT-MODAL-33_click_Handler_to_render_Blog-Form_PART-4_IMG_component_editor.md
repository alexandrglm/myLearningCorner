# 10-166: Enabling Dynamic Rendering of the Featured Image in the Blog Form

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/enabling-dynamic-rendering-featured-image-blog-form)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 9aea87f067090b6e1938f5bf2e144c0d14e98a80](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/9aea87f067090b6e1938f5bf2e144c0d14e98a80)

---

## 🎯 Objectives

**Implement conditional rendering to show existing featured image in edit mode**:

- **Pattern replication** - follow same patterns from portfolio manager for image display
- **Conditional logic** - ternary operator to show image vs dropzone
- **Props validation** - check editMode AND featured_image_url existence
- **CSS class reuse** - utilise existing portfolio CSS classes
- **Professional UX** - show current image when editing, dropzone when creating
- **Code efficiency** - quick implementation replicating established patterns

**Expected behaviour**: Click blog title → edit mode → featured image displays instead of dropzone (if image exists).

---

## 🛠️ Implementation

### 1. Implement Conditional Rendering Logic

**File**: `src/components/blog/blog-form.js`

**Replace DropzoneComponent with conditional rendering**:

```javascript
<div className="image-uploaders">
  {this.props.editMode && this.props.blog.featured_image_url ? (
    <div className="portfolio-manager-image-wrapper">
      <img src={this.props.blog.featured_image_url} />
      <div className="image-removal-link">
        <a>Remove File</a>
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

### 2. Verify Props Are Being Passed

**Ensure BlogDetail passes necessary props to BlogForm**:

**From previous guide** - BlogDetail should already be passing:

```javascript
// In BlogDetail contentManager function
if (this.state.editMode) {
  return (
    <BlogForm 
      editMode={this.state.editMode}
      blog={this.state.blogItem}
    />
  );
}
```

**BlogForm should receive**:

- `editMode={true}` 
- `blog={blogItemObject}` which contains `featured_image_url`

---

## 📧 Concepts

### Conditional Rendering Pattern

**Ternary operator structure**:

```javascript
{condition ? (
  // Render when condition is TRUE
  <ComponentA />
) : (
  // Render when condition is FALSE  
  <ComponentB />
)}
```

**Applied to our use case**:

```javascript
{this.props.editMode && this.props.blog.featured_image_url ? (
  // Show existing image when editing AND image exists
  <ImageDisplay />
) : (
  // Show dropzone for upload when creating OR no image exists
  <DropzoneComponent />
)}
```

### Compound Condition Logic

**Why both conditions are necessary**:

```javascript
this.props.editMode && this.props.blog.featured_image_url
//      ↑                           ↑
//      |                           └──── Image must exist
//      └──── Must be in edit mode
```

**Different scenarios**:

1. **Create mode** - `editMode: false` → Always show dropzone
2. **Edit mode, no image** - `editMode: true, featured_image_url: null` → Show dropzone
3. **Edit mode, with image** - `editMode: true, featured_image_url: "url"` → Show image

### CSS Class Reuse Strategy

**Portfolio manager classes applied to blog context**:

```javascript
// Originally designed for portfolio manager
<div className="portfolio-manager-image-wrapper">
  <img src={imageUrl} />
  <div className="image-removal-link">
    <a>Remove File</a>
  </div>
</div>
```

**Why reuse is appropriate**:

- **Same functionality** - display image with remove option
- **Same layout needs** - wrapper, image, removal link
- **Already styled** - no additional CSS needed
- **Consistent UX** - uniform appearance across app

**Future refactoring opportunity**:

```scss
// Could be renamed to more generic classes
.image-display-wrapper { /* instead of portfolio-manager-image-wrapper */ }
.image-removal-link { /* this one is already generic */ }
```

### Props Safety and Validation

**Safe property access pattern**:

```javascript
// ❌ Unsafe - could throw error
this.props.blog.featured_image_url

// ✅ Safe - checks blog exists first  
this.props.blog && this.props.blog.featured_image_url
```

**Why props might not exist**:

- **Create mode** - no blog prop passed
- **Loading states** - blog data not yet loaded
- **Error states** - blog failed to load

**Applied safety in our condition**:

```javascript
// The && operator provides implicit safety
this.props.editMode && this.props.blog.featured_image_url
// If editMode is false, second condition never evaluates
// If blog is undefined, featured_image_url access never happens
```

### Pattern Replication Benefits

**Why replicating portfolio patterns works**:

1. **Proven functionality** - already tested and working
2. **Familiar code structure** - easier to maintain
3. **Consistent UX** - users get familiar interactions
4. **Development speed** - no need to reinvent wheel
5. **CSS reuse** - styling already exists

**Learning reinforcement mentioned in guide**:

- **First time** - portfolio manager took several guides to implement
- **Second time** - blog form implemented in minutes
- **Pattern recognition** - developer skill improvement over time

### Component Abstraction Opportunity

**Guide mentions potential refactor**:

```javascript
// Future improvement - generic ImageUploader component
<ImageUploader 
  currentImage={this.props.blog?.featured_image_url}
  onImageUpload={this.handleImageUpload}
  onImageRemove={this.handleImageRemove}
  editMode={this.props.editMode}
/>
```

**Benefits of abstraction**:

- **Reusable component** - use in blog, portfolio, any form
- **Single source of truth** - one component to maintain
- **Consistent behaviour** - same logic across features
- **Easier testing** - test once, works everywhere

### Remove File Link (Preview)

**Current implementation**:

```javascript
<div className="image-removal-link">
  <a>Remove File</a>  {/* No onClick handler yet */}
</div>
```

**Upcoming functionality** (next guide):

- Click handler to delete image from server
- Update parent component state
- Switch back to dropzone view
- API call to remove featured image

### User Experience Design

**Expected workflow for users**:

1. **View blog post** - see featured image in normal view
2. **Click title** - enter edit mode
3. **See current image** - visual confirmation of existing image
4. **Option to remove** - "Remove File" link visible
5. **Option to replace** - removing will show dropzone for new upload

**UX benefits**:

- **Visual continuity** - see what image is currently set
- **Clear feedback** - different views for different modes
- **Intuitive interaction** - edit mode shows editable elements

---

## 📋 Verification

### 1. Create Mode Testing

**Verify dropzone shows when creating new blog**:

1. **Open blog modal** - click floating action button
2. **Should see dropzone** - "Featured Image" upload area
3. **No image display** - only dropzone component visible
4. **Upload functionality** - dropzone should accept files

### 2. Edit Mode Without Image Testing

**Test blogs that don't have featured images**:

1. **Find blog without featured image** - any text-only blog post
2. **Click blog title** - enter edit mode
3. **Should see dropzone** - not image display
4. **Condition logic working** - editMode true BUT no featured_image_url

### 3. Edit Mode With Image Testing

**Test blogs that have featured images**:

1. **Find blog with featured image** - look for blog with image
2. **Click blog title** - enter edit mode  
3. **Should see image** - current featured image displayed
4. **Should see "Remove File"** - link available
5. **No dropzone visible** - dropzone hidden when image exists

### 4. Props Verification

**React DevTools inspection**:

1. **Enter edit mode** - click blog title
2. **Open React DevTools** → Components
3. **Select BlogForm component**
4. **Check props**:
   - `editMode: true`
   - `blog: { featured_image_url: "..." }` (if image exists)
   - Props correctly passed from BlogDetail

### 5. Visual Layout Verification

**CSS styling check**:

1. **Image displays properly** - correct size and positioning
2. **Remove link positioned correctly** - below image
3. **Matches portfolio styling** - consistent with portfolio manager
4. **Responsive behaviour** - works on different screen sizes

### 6. Conditional Logic Edge Cases

**Test various scenarios**:

**Scenario 1**: Create mode

- `editMode: undefined/false` → Show dropzone ✓

**Scenario 2**: Edit mode, no image

- `editMode: true, featured_image_url: null` → Show dropzone ✓

**Scenario 3**: Edit mode, with image  

- `editMode: true, featured_image_url: "url"` → Show image ✓

### 7. Network Image Loading

**Test image URL accessibility**:

1. **Check image loads** - featured image should display
2. **Handle broken URLs** - broken image icon if URL invalid
3. **Loading states** - image should load smoothly
4. **Different image formats** - JPG, PNG, etc.

---
