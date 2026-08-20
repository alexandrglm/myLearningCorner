# 09-099 - Adding Banner and Logo Image Uploaders

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/adding-banner-logo-image-uploaders)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 93f1da3e936e78390259146df08f196e1ca7da1f](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/93f1da3e936e78390259146df08f196e1ca7da1f)

---

## 🎯 OBJECTIVES

**Complete multi-image upload system**:

- **Duplicate thumbnail functionality** for banner and logo
- **Separate handler methods** - handleBannerDrop and handleLogoDrop
- **State management** for banner_image and logo fields
- **Multiple DropzoneComponents** in JSX
- **buildForm conditional logic** for all image types

**Why separate handlers?**:

- **Dropzone library constraints** - each uploader needs its own handler
- **State specificity** - each image updates different state field
- **Timing issues** - shared handler would cause execution problems

---

## 🛠️ IMPLEMENTATION

### 1. Create Additional Handler Methods

**File**: `src/components/portfolio/portfolio-form.js`

**Add methods after handleThumbDrop()**:

```javascript
handleThumbDrop() {
  return {
    addedfile: file => this.setState({ thumb_image: file })
  };
}

handleBannerDrop() {
  return {
    addedfile: file => this.setState({ banner_image: file })
  };
}

handleLogoDrop() {
  return {
    addedfile: file => this.setState({ logo: file })
  };
}
```

### 2. Binding New Methods in Constructor

**Update existing constructor**:

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
  this.handleBannerDrop = this.handleBannerDrop.bind(this);
  this.handleLogoDrop = this.handleLogoDrop.bind(this);
}
```

### 3. Add Multiple DropzoneComponents to JSX

**Update render method with three uploaders**:

```javascript
render() {
  return (
    <div>
      <h1>PortfolioForm</h1>

      <form onSubmit={this.handleSubmit}>
        {/* ... existing form elements ... */}

        <div>
          <textarea
            name="description"
            placeholder="Description"  
            value={this.state.description}
            onChange={this.handleChange}
          />
        </div>

        <div className="image-uploaders">
          <DropzoneComponent 
            config={this.componentConfig()}
            djsConfig={this.djsConfig()}
            eventHandlers={this.handleThumbDrop()}
          >
          </DropzoneComponent>

          <DropzoneComponent 
            config={this.componentConfig()}
            djsConfig={this.djsConfig()}
            eventHandlers={this.handleBannerDrop()}
          >
          </DropzoneComponent>

          <DropzoneComponent 
            config={this.componentConfig()}
            djsConfig={this.djsConfig()}
            eventHandlers={this.handleLogoDrop()}
          >
          </DropzoneComponent>
        </div>

        <div>
          <button type="submit">Save</button>
        </div>
      </form>
    </div>
  );
}
```

### 4. Update buildForm Method with Conditional Logic

**Add conditional checks for banner and logo**:

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

  if (this.state.banner_image) {
    formData.append("portfolio_item[banner_image]", this.state.banner_image);
  }

  if (this.state.logo) {
    formData.append("portfolio_item[logo]", this.state.logo);
  }

  return formData;
}
```

---

## 🔧 CONCEPTS

### Why Separate Handlers?

**Problem with shared handler**:

```javascript
// ❌ This doesn't work correctly
handleImageDrop(imageType) {
  return {
    addedfile: file => this.setState({ [imageType]: file })
  };
}

// Dropzone timing issues:
// - Handler gets called at wrong time
// - setState doesn't execute properly
// - File references are lost
```

**Solution with dedicated handlers**:

```javascript
// ✅ Each handler is specific and reliable
handleThumbDrop() {
  return {
    addedfile: file => this.setState({ thumb_image: file })
  };
}
```

**Tradeoff analysis**:

- **Pro**: Functionality guaranteed working
- **Con**: Code duplication (but minimal)
- **Reality**: Dropzone library constraint, not React limitation

### API Field Name Mapping

**State field names vs API expectations**:

```javascript
// State fields
this.state = {
  thumb_image: File,    // Maps to portfolio_item[thumb_image]
  banner_image: File,   // Maps to portfolio_item[banner_image]  
  logo: File           // Maps to portfolio_item[logo]
}
```

**API documentation typically provides**:

- **Field names**: Exactly what to send
- **Data types**: File vs string requirements
- **Required fields**: Which are mandatory
- **Validation rules**: Size limits, file types

### File State Management

**Different state types in same component**:

```javascript
this.state = {
  // Text fields - strings
  name: "Project Name",
  description: "Description text",

  // File fields - File objects
  thumb_image: File { name: "thumb.jpg", size: 12345, ... },
  banner_image: File { name: "banner.jpg", size: 67890, ... },
  logo: File { name: "logo.png", size: 3456, ... }
}
```

**Implications**:

- **Different validation** needed per field type
- **Different rendering** in debugging
- **Conditional logic** required in buildForm
- **Different error handling** strategies

### Component Duplication Pattern

**When duplication is acceptable**:

```javascript
// Three similar components - acceptable duplication
<DropzoneComponent eventHandlers={this.handleThumbDrop()} />
<DropzoneComponent eventHandlers={this.handleBannerDrop()} />  
<DropzoneComponent eventHandlers={this.handleLogoDrop()} />
```

**Alternative approaches considered**:

- **Dynamic generation**: Map over array of handlers
- **Single parameterised handler**: Doesn't work with Dropzone
- **Custom wrapper component**: Overkill for 3 instances

---

## ✔️ VERIFICATION

### Testing Multiple Upload Functionality

**Three-step verification process**:

1. **Individual file drops**:
   - Drop file in first uploader → preview appears
   - Drop file in second uploader → preview appears  
   - Drop file in third uploader → preview appears

### React DevTools State Inspection

**State verification workflow**:

1. **Open React DevTools** → Components tab
2. **Select PortfolioForm** component
3. **Initial state check** - all image fields empty strings
4. **Upload first image** → thumb_image shows File object
5. **Upload second image** → banner_image shows File object
6. **Upload third image** → logo shows File object

### Form Submission Testing

**End-to-end workflow**:

1. **Fill text fields**:
   
   - Name: "Testing all three"
   - Category: any selection
   - Other fields optional

2. **Upload all three images**:
   
   - Different image per uploader
   - Verify preview appears for each
   - Check no console errors

3. **Submit form** → should succeed

4. **Check DevCamp Space** → verify all three images uploaded

### API Integration Verification

**DevCamp Space confirmation**:

1. **After successful submission**
2. **Navigate to DevCamp Space** → Portfolio Items
3. **Find "Testing all three"** item
4. **Verify all image types present**:
   - Thumbnail image ✅
   - Banner image ✅  
   - Logo image ✅

### Error Handling Testing

**Edge cases to verify**:

1. **Submit without images** → should work (text only)
2. **Submit with only some images** → should work partially
3. **Upload wrong file types** → should reject appropriately
4. **Large file uploads** → appropriate handling

### Console Error Monitoring

**Expected vs problematic errors**:

```javascript
// ✅ Expected (can ignore temporarily)
"Illegal invocation" // Will be fixed in future guides

// ❌ Problematic (needs attention)
"Cannot read property 'append' of undefined" // buildForm issue
"Network error" // API connection problem
```

---
