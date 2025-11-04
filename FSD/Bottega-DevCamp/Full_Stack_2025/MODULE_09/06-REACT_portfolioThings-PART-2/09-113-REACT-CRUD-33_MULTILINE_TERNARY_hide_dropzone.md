# 09-113: Multi-line Ternary Operators React - Showing/Hiding Dropzone Components

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/multi-line-ternary-operators-react-showing-hiding-dropzone-components)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 66112303c7b4e20963e468149e03ecb1734fd4b1](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/66112303c7b4e20963e468149e03ecb1734fd4b1)

---

## 🎯 Objectives

**Implement conditional rendering to show/hide Dropzone components in edit mode**:

- **Update componentDidUpdate** - add image URLs to setState
- **Multi-line ternary operator** - conditionally render image vs dropzone
- **Complex conditional logic** - check for both image existence AND editMode
- **Image display in edit mode** - show existing image when editing
- **Foundation for complete edit workflow** - preparation for styling and additional features

**Visual result**:

- Edit mode: show existing image, hide dropzone
- Create mode: show dropzone for file upload
- Conditional rendering based on state properties

---

## 🛠️ Implementation

### 1. Update componentDidUpdate to Include Image URLs

**File**: `src/components/portfolio/portfolio-form.js`

**Add image URLs to setState in componentDidUpdate**:

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
      thumb_image: thumb_image_url || "",
      banner_image: banner_image_url || "",
      logo: logo_url || ""
    });
  }
}
```

### 2. Implement Multi-line Ternary Operator for Thumbnail

**Replace first DropzoneComponent with ternary conditional**:

```javascript
render() {
  return (
    <div>
      <h1>PortfolioForm</h1>

      <form onSubmit={this.handleSubmit}>
        {/* ... existing form fields ... */}

        <div className="image-uploaders">
          {this.state.thumb_image && this.state.editMode ? (
            <img src={this.state.thumb_image} />
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

          {/* Banner and Logo dropzones remain unchanged for now */}
          <DropzoneComponent
            ref={this.bannerRef}
            config={this.componentConfig()}
            djsConfig={this.djsConfig()}
            eventHandlers={this.handleBannerDrop()}
          >
            <div className="dz-message">Banner</div>
          </DropzoneComponent>

          <DropzoneComponent
            ref={this.logoRef}
            config={this.componentConfig()}
            djsConfig={this.djsConfig()}
            eventHandlers={this.handleLogoDrop()}
          >
            <div className="dz-message">Logo</div>
          </DropzoneComponent>
        </div>

        <div>
          <button type="submit" className="btn">Save</button>
        </div>
      </form>
    </div>
  );
}
```

---

## 📚 Concepts

### Multi-line Ternary Operator Syntax

**Basic ternary structure**:

```javascript
// Single line ternary
{condition ? "do if true" : "do if false"}

// Multi-line ternary (what we're implementing)
{condition ? (
  <ComponentA />
) : (
  <ComponentB />
)}
```

**Complex condition with multiple checks**:

```javascript
{this.state.thumb_image && this.state.editMode ? (
  // TRUE: Both conditions met
  <img src={this.state.thumb_image} />
) : (
  // FALSE: Either no image OR not in edit mode
  <DropzoneComponent />
)}
```

### Logical AND Operator (&&) in Conditions

**Understanding the condition logic**:

```javascript
this.state.thumb_image && this.state.editMode
```

**Truth table**:

- `thumb_image: "url"` + `editMode: true` → **TRUE** (show image)
- `thumb_image: ""` + `editMode: true` → **FALSE** (show dropzone)
- `thumb_image: "url"` + `editMode: false` → **FALSE** (show dropzone)
- `thumb_image: ""` + `editMode: false` → **FALSE** (show dropzone)

**Why both conditions needed**:

- **Image existence** - no point showing img tag without src
- **Edit mode check** - only show existing images when editing
- **Create mode** - always show dropzone for new uploads

### State Management for Image URLs

**Different data types in different modes**:

**Create mode (initial state)**:

```javascript
{
  thumb_image: "",           // Empty string
  editMode: false
}
```

**Edit mode (after componentDidUpdate)**:

```javascript
{
  thumb_image: "https://aws.s3.../image.jpg",  // Full URL string
  editMode: true
}
```

**File upload mode (after dropzone)**:

```javascript
{
  thumb_image: File {...},   // File object
  editMode: false
}
```

### Conditional Rendering Patterns in React

**Three main approaches**:

**1. && Operator (show/hide)**:

```javascript
{condition && <Component />}
```

**2. Ternary operator (either/or)**:

```javascript
{condition ? <ComponentA /> : <ComponentB />}
```

**3. Function with if/else**:

```javascript
{this.renderContent()}
```

**When to use each approach**:

- **&& operator**: Simple show/hide based on one condition
- **Ternary**: Two different components based on condition
- **Function**: Complex logic with multiple conditions

### Component Lifecycle in Edit Flow

**Complete edit workflow sequence**:

1. **User clicks edit icon** → handleEditClick() called
2. **setState({ portfolioToEdit: item })** → parent state updated
3. **Props change triggers** → componentDidUpdate() in form
4. **Image URLs extracted** → setState with URLs and editMode: true
5. **Re-render triggered** → ternary evaluates to TRUE
6. **Conditional rendering** → img tag shows instead of dropzone

### Image URL vs File Object Handling

**Two different data types for same state field**:

**URL string (from API)**:

```javascript
// Used in edit mode
thumb_image: "https://devcamp-space.s3.amazonaws.com/.../image.jpg"

// Rendered as:
<img src={this.state.thumb_image} />
```

**File object (from dropzone)**:

```javascript
// Used in create mode
thumb_image: File {
  name: "image.jpg",
  size: 123456,
  type: "image/jpeg"
}

// Sent to API as:
formData.append("portfolio_item[thumb_image]", this.state.thumb_image)
```

### Prettier Code Formatting Impact

**Before Prettier**:

```javascript
// Manually formatted - potentially inconsistent
{this.state.thumb_image && this.state.editMode ? (<img src={this.state.thumb_image} />) : (<DropzoneComponent>...</DropzoneComponent>)}
```

**After Prettier**:

```javascript
// Auto-formatted - consistent and readable
{this.state.thumb_image && this.state.editMode ? (
  <img src={this.state.thumb_image} />
) : (
  <DropzoneComponent>
    <div className="dz-message">Thumbnail</div>
  </DropzoneComponent>
)}
```

---

## ✋ Verification

### Edit Mode Conditional Rendering Testing

**Test existing portfolio items with images**:

1. **Navigate to portfolio-manager**
2. **Identify item with thumbnail image** (check sidebar previews)
3. **Click edit icon** on item with image
4. **Verify behaviour**:
   - Dropzone disappears
   - Image appears in its place
   - Other dropzones remain visible (banner, logo)

### State Inspection via DevTools

**Monitor state changes during edit**:

1. **Open React DevTools**
2. **Select PortfolioForm** component
3. **Initial state verification**:
   - `thumb_image: ""`
   - `editMode: false`
4. **Click edit icon**
5. **State after componentDidUpdate**:
   - `thumb_image: "https://...image.jpg"`
   - `editMode: true`
6. **Visual verification** - image displays instead of dropzone

### Create Mode Verification

**Test that create mode still works**:

1. **Start with clean form** (refresh page)
2. **Verify all dropzones visible**
3. **Fill form fields**
4. **Upload image** via dropzone
5. **Submit form** successfully
6. **Form resets** - dropzones return

### Mixed State Testing

**Test items with partial images**:

1. **Find item with thumbnail but no banner/logo**
2. **Click edit**
3. **Expected behaviour**:
   - Thumbnail shows image
   - Banner shows dropzone
   - Logo shows dropzone

### Error Cases Testing

**Items without images**:

1. **Find item created without images**
2. **Click edit**
3. **Expected behaviour**:
   - All dropzones remain visible
   - No broken img tags
   - Form populates text fields only

### Image Loading Testing

**Verify images load correctly**:

1. **Network tab open** (DevTools)
2. **Click edit** on item with image
3. **Monitor network requests**:
   - Image URL should load successfully
   - No 404 errors
   - Image displays properly

---

