# 09-100 - Overview of React Refs to Clear Form Data

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/overview-react-refs-clear-form-image-uploaders)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at c0dfff71ee4684a18b3aa17515da66d8207c14b9](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/c0dfff71ee4684a18b3aa17515da66d8207c14b9)

https://reactjs.org/docs/refs-and-the-dom.html

---

## 🎯 OBJECTIVES

**Implement automatic form clearing using React Refs**:

- **Understanding React Refs** - direct DOM interaction when necessary
- **Virtual DOM vs Real DOM** - when to use each approach
- **createRef() pattern** - create references to DOM elements
- **Third-party integration** - access Dropzone methods directly
- **Form reset workflow** - clear state AND clear DOM elements

**UX improvement**:

- Automatic form clearing after successful submission
- Reset both React state and Dropzone preview images
- Professional form behaviour that users expect

---

## 🛠️ IMPLEMENTATION

### 1. Create Refs in Constructor

**File**: `src/components/portfolio/portfolio-form.js`

**Add refs to existing constructor**:

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

  this.thumbRef = React.createRef();
  this.bannerRef = React.createRef();
  this.logoRef = React.createRef();
}
```

### 2. Assign Refs to DropzoneComponents

**Update JSX with ref props**:

```javascript
<div className="image-uploaders">
  <DropzoneComponent 
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleThumbDrop()}
    ref={this.thumbRef}
  >
  </DropzoneComponent>

  <DropzoneComponent 
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleBannerDrop()}
    ref={this.bannerRef}
  >
  </DropzoneComponent>

  <DropzoneComponent 
    config={this.componentConfig()}
    djsConfig={this.djsConfig()}
    eventHandlers={this.handleLogoDrop()}
    ref={this.logoRef}
  >
  </DropzoneComponent>
</div>
```

### 3. Implement Form Clearing in handleSubmit

**Update handleSubmit method**:

```javascript
handleSubmit(event) {
  axios.post(
    "https://apialexandr.devcamp.space/portfolio/portfolio_items", 
    this.buildForm(), 
    { withCredentials: true }
  ).then(response => {
    this.props.handleSuccessfulFormSubmission(response.data.portfolio_item);

    // Clear Dropzone components
    [this.thumbRef, this.bannerRef, this.logoRef].forEach(ref => {
      ref.current.dropzone.removeAllFiles();
    });

    // Reset form state
    this.setState({
      name: "",
      description: "",
      category: "eCommerce",
      position: "",
      url: "",
      thumb_image: "",
      banner_image: "",
      logo: ""
    });

  }).catch(error => {
    console.log("portfolio form handleSubmit error", error);
  });

  event.preventDefault();
}
```

---

## 🔧 CONCEPTS

### React Virtual DOM vs Real DOM

**Virtual DOM (React's abstraction)**:

```javascript
// React's abstraction layer
<DropzoneComponent config={config} />

// React handles:
// - Creating actual DOM elements
// - Event handling
// - State synchronisation
// - Performance optimisations
```

**Real DOM (browser elements)**:

```javascript
// Direct DOM manipulation (what refs allow)
ref.current.dropzone.removeAllFiles();

// Direct access to:
// - Browser APIs
// - Third-party library methods  
// - DOM properties React doesn't expose
```

### When to Use Refs

**React documentation guidance**:

✅ **Appropriate use cases**:

- **Managing focus**, text selection, media playback
- **Triggering imperative animations** 
- **Integrating with third-party DOM libraries** (our case)

❌ **Don't overuse refs**:

- **Most things** can be done through React patterns
- **Overuse hurts performance** and creates bugs
- **Goes against React philosophy** of declarative programming

### React.createRef() Pattern

**Three-step process**:

```javascript
// 1. Create ref in constructor
this.thumbRef = React.createRef();

// 2. Attach to JSX element
<DropzoneComponent ref={this.thumbRef} />

// 3. Use ref.current to access DOM element
this.thumbRef.current.dropzone.removeAllFiles();
```

### ref.current Explanation

**Why ref.current needed**:

```javascript
// React ref object structure:
{
  current: <DOM Element or Component Instance>
}

// ref.current gives access to actual element
this.thumbRef.current           // The DropzoneComponent instance
this.thumbRef.current.dropzone  // Dropzone library instance
this.thumbRef.current.dropzone.removeAllFiles()  // Dropzone method
```

### State vs DOM Distinction

**Critical understanding**:

```javascript
// React State (component memory)
this.state.thumb_image = File  // React knows about this

// DOM State (browser memory) 
// Dropzone preview images, drag zones, file lists
// React DOESN'T automatically manage this
```

**Why both clearing needed**:

- **React state clearing**: Prevents re-submission of old data
- **DOM clearing**: Removes visual previews and resets UI components
- **Without both**: User sees stale previews but form submits empty

### Third-Party Library Integration

**Dropzone.js method documentation**:

```javascript
// Available Dropzone methods (from documentation):
dropzone.removeAllFiles()     // Remove all files
dropzone.removeFile(file)     // Remove specific file
dropzone.disable()            // Disable dropzone
dropzone.enable()             // Enable dropzone
dropzone.destroy()            // Completely remove
```

**How we discovered removeAllFiles()**:

1. **Consulted Dropzone.js docs** - official API reference
2. **Identified method name** - removeAllFiles()
3. **Tested integration** - ref.current.dropzone.removeAllFiles()

---

## ✔️ VERIFICATION

### Testing Form Clear Functionality

**Complete workflow test**:

1. **Fill all text fields**:
   
   - Name: "testing with refs"
   - Category: any selection
   - Description: any content
   - Other fields optional

2. **Upload all three image types**:
   
   - Drop image in each dropzone
   - Verify preview appears
   - Confirm file objects in React state

3. **Submit form**:
   
   - Click Save button
   - Should succeed without errors
   - Watch automatic clearing

### Post-Submission Verification

**Expected behaviour**:

✅ **All text fields cleared** - empty strings
✅ **Category reset** - back to "eCommerce" default  
✅ **Image previews removed** - no visible files
✅ **Dropzones reset** - back to initial state
✅ **New item appears** in sidebar
✅ **Form ready** for next entry

### React DevTools State Inspection

**State verification**:

1. **Before submission** - state populated with form data
2. **During submission** - API call processing
3. **After submission** - state reset to initial values
4. **Verify state matches** constructor initial state

### DOM vs State Clearing

**Visual confirmation**:

1. **State clearing**: React DevTools shows empty state
2. **DOM clearing**: Visual previews disappeared  
3. **Both needed**: Complete reset achieved
4. **User experience**: Professional form behaviour

### Error Scenario Testing

**What if clearing fails**:

```javascript
// If refs not working properly:
// - Form state clears ✅
// - Images still visible ❌ 
// - User confusion about form state
```

**Debug approach**:

- **Console.log refs**: `console.log(this.thumbRef.current)`
- **Check ref attachment**: Verify ref props on components
- **Dropzone availability**: Confirm third-party library loaded

---

