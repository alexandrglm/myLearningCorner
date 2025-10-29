# 09-104: Dropzone Labels, Child Components and Finalise Form

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/dropzone-labels-child-components-finalize-form)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 0340f89817f1da628c90a22a974182aeffe0a442](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/0340f89817f1da628c90a22a974182aeffe0a442)

---

## 🎯 Objectives

**Finalise portfolio form with professional touches**:

- **Custom image uploader sizing** - fixed width instead of full responsive
- **Base grid mixin refactor** - eliminate duplicated code
- **Button styling** - apply existing button mixin
- **Child components** - custom labels for dropzones
- **Final testing** - verify complete end-to-end functionality

**Advanced React skills**:

- **Child components pattern** - passing content into library components
- **Dropzone customisation** - overriding default messages
- **Code refactoring** - mixin consolidation
- **Professional form UX** - clear labelling and visual hierarchy

---

## 🛠️ Implementation

### 1. Customise Image Uploader Sizing

**File**: `src/style/portfolio-form.scss`

**Add custom image-uploaders styling**:

```scss
.portfolio-form-wrapper {
  display: grid;
  grid-template-columns: 1fr;
  padding: 42px;
  grid-gap: 21px;

  @include input-element();

  input {
    margin-bottom: 0px;
  }

  .image-uploaders {
    display: grid;
    grid-template-columns: 200px 200px 200px;
    grid-gap: 21px;
  }
}
```

### 2. Create Base Grid Mixin

**File**: `src/style/mixins.scss`

**Add base-grid mixin after existing mixins**:

```scss
@mixin base-grid() {
  display: grid;
  grid-gap: 21px;
}
```

### 3. Refactor Grid Utilities with Mixin

**File**: `src/style/grid.scss`

**Update all grid classes**:

```scss
.one-column {
  @include base-grid();
  grid-template-columns: 1fr;
}

.two-column {
  @include base-grid();
  grid-template-columns: 1fr 1fr;
}
```

### 4. Refactor Portfolio Form with Mixin

**File**: `src/style/portfolio-form.scss`

**Update wrapper with mixin**:

```scss
.portfolio-form-wrapper {
  @include base-grid();
  grid-template-columns: 1fr;
  padding: 42px;

  @include input-element();

  input {
    margin-bottom: 0px;
  }

  .image-uploaders {
    @include base-grid();
    grid-template-columns: 200px 200px 200px;
  }
}
```

### 5. Apply Button Styling

**File**: `src/components/portfolio/portfolio-form.js`

**Add className to submit button**:

```javascript
<div>
  <button type="submit" className="btn">Save</button>
</div>
```

### 6. Implement Child Components for Dropzone Labels

**Update all DropzoneComponents with child elements**:

```javascript
<div className="image-uploaders">
  <DropzoneComponent 
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleThumbDrop()}
    ref={this.thumbRef}
  >
    <div className="dz-message">Thumbnail</div>
  </DropzoneComponent>

  <DropzoneComponent 
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleBannerDrop()}
    ref={this.bannerRef}
  >
    <div className="dz-message">Banner</div>
  </DropzoneComponent>

  <DropzoneComponent 
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleLogoDrop()}
    ref={this.logoRef}
  >
    <div className="dz-message">Logo</div>
  </DropzoneComponent>
</div>
```

---

## 📚 Concepts

### Child Components Pattern in React

**What are child components?**:

```javascript
// Parent component wraps child content
<ParentComponent>
  <ChildContent />  // This is a child component
</ParentComponent>

// Library components that accept children
<DropzoneComponent>
  <CustomMessage />  // Override default content
</DropzoneComponent>
```

**React component hierarchy visualisation**:

```
App
├── BrowserRouter
│   ├── Routes
│   │   ├── PortfolioManager
│   │   │   ├── PortfolioForm
│   │   │   │   ├── DropzoneComponent
│   │   │   │   │   └── div.dz-message (child)
```

### Dropzone Child Component Override

**How Dropzone library handles children**:

```javascript
// Default behaviour (without children)
<DropzoneComponent />
// Renders: <span className="dz-default dz-message">Drop files here to upload</span>

// With child component
<DropzoneComponent>
  <div className="dz-message">Thumbnail</div>
</DropzoneComponent>
// Renders: <div className="dz-message">Thumbnail</div>
```

**Library requirement**:

- **Library must support children** - not all do
- **Documentation shows** what children are accepted
- **Overrides default content** - replaces library defaults

### Professional Interview Knowledge

**Common React interview question**:

> **"What's a common use case for passing child components into a parent?"**

**Great answer using this example**:

> *"When working with third-party libraries like Dropzone, you often need to customise their default content. For example, I needed to override the default 'Drop files here' message in a Dropzone component. I opened up the component tags and passed in a custom div with a specific className that the library recognised, allowing me to provide custom labels like 'Thumbnail', 'Banner', and 'Logo' for different upload areas."*

### Mixin Refactoring Benefits

**Before refactoring**:

```scss
// Repeated code across multiple files
.one-column {
  display: grid;
  grid-gap: 21px;
  grid-template-columns: 1fr;
}

.portfolio-form-wrapper {
  display: grid;
  grid-gap: 21px;
  grid-template-columns: 1fr;
}
```

**After refactoring**:

```scss
// DRY principle applied
@mixin base-grid() {
  display: grid;
  grid-gap: 21px;
}

.one-column {
  @include base-grid();
  grid-template-columns: 1fr;
}
```

### Fixed vs Responsive Image Uploaders

**Decision analysis**:

**Option 1: Responsive (three-column class)**:

```scss
.three-column {
  grid-template-columns: 1fr 1fr 1fr;  // Expands to fill width
}
```

**Option 2: Fixed width (custom)**:

```scss
.image-uploaders {
  grid-template-columns: 200px 200px 200px;  // Fixed 200px each
}
```

**Why choose fixed width**:

- **Consistent sizing** - uploaders don't get too large
- **Better UX** - smaller, more manageable upload areas
- **Visual balance** - doesn't dominate the form
- **Professional appearance** - more controlled layout

---

## ✋ Verification

### Visual Design Improvements

**Before finalisation**:

- **Generic dropzone messages** - "Drop files here to upload"
- **Unclear purpose** - couldn't distinguish thumbnail vs banner vs logo
- **Large upload areas** - took up excessive space
- **Inconsistent button** - basic HTML styling
- **Repetitive CSS** - duplicated grid code

**After finalisation**:

- ✅ **Clear labels** - "Thumbnail", "Banner", "Logo"
- ✅ **Appropriate sizing** - 200px width each uploader
- ✅ **Professional button** - teal styling with hover effects
- ✅ **Clean code** - DRY principle with mixins
- ✅ **Consistent spacing** - 21px grid-gap everywhere

### Child Component Testing

**Inspect element verification**:

1. **Right-click on dropzone** area
2. **Check HTML structure**:
   
   ```html
   <div class="dz-message">Thumbnail</div>
   <!-- NOT: <span class="dz-default dz-message">Drop files here to upload</span> -->
   ```
3. **Verify custom content** overwrote default

### React DevTools Child Verification

**Component tree inspection**:

1. **Open React DevTools**
2. **Navigate to DropzoneComponent**
3. **Expand component tree**
4. **Verify "children" prop** contains custom content

### End-to-End Functionality Testing

**Complete workflow test**:

1. **Fill all form fields**:
   
   - Name: "final test"
   - URL: any URL
   - Position: any number
   - Category: any selection
   - Description: any content

2. **Upload all three image types**:
   
   - Drop image on "Thumbnail" area
   - Drop image on "Banner" area  
   - Drop image on "Logo" area

3. **Submit form**:
   
   - Click "Save" button
   - Should succeed without errors
   - Form should clear automatically
   - Item should appear in sidebar

4. **Verify persistence**:
   
   - Check DevCamp Space for new item
   - Confirm all three images uploaded
   - Verify text data saved correctly

---

