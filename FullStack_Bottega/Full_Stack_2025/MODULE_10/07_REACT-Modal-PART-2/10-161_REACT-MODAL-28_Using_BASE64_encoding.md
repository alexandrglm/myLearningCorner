# 10-161: Converting Image Files Base64 Strings

---

**[Guide](https://devcamp.com/trails/dissecting-react-js/campsites/building-blog-react/guides/converting-image-files-base64-strings)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 31d7518fe1029bc1fdbe66bf0ab3e9f46b3ba1a8](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/31d7518fe1029bc1fdbe66bf0ab3e9f46b3ba1a8)

---

## 🎯 Objectives

**Implement image to Base64 string conversion using FileReader**:

- **FileReader API** - native JavaScript API for reading files
- **Base64 encoding** - convert images to string format for storage
- **Promise-based implementation** - handle asynchronous operations correctly
- **Callback functions** - pass functions as arguments for resolution
- **Upload workflow completion** - complete image upload functionality
- **Rich text integration** - images embedded in text content

**⚠️ Complexity warning**:

This guide involves **advanced Promises** and **callback functions**. If you're unfamiliar with these concepts, implement the code first and then review the Promises guides in the Modern JavaScript course.

---

## 🛠️ Implementation

### 1. Understand Base64 Images

**What is Base64?**

Base64 is an encoding method that converts binary files (such as images) into text strings that can be stored alongside normal HTML/text.

**Example of Base64 image string**:

```
data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEAYABgAAD/2wBDAA...
```

**Why we need Base64**:

- **Cannot** embed image files directly in text strings
- **Need** to convert the image to a format that can be stored as text
- **Base64** allows browsers to render the image from the string
- **Storage** - can be saved in database alongside other content

### 2. Create getBase64 Function

**Add in RichTextEditor class before render method**:

```javascript
getBase64(file, callback) {
  let reader = new FileReader();
  reader.readAsDataURL(file);
  reader.onload = () => callback(reader.result);
  reader.onerror = error => {};
}
```

**FileReader API explanation**:

- **new FileReader()** - create instance of native JavaScript FileReader
- **readAsDataURL(file)** - begin conversion process to Base64
- **reader.onload** - callback that executes when conversion is complete
- **reader.result** - contains the final Base64 string
- **reader.onerror** - handles errors during conversion

### 3. Bind Methods in Constructor

**Add bindings in constructor after onEditorStateChange**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    editorState: EditorState.createEmpty()
  };

  this.onEditorStateChange = this.onEditorStateChange.bind(this);
  this.getBase64 = this.getBase64.bind(this);
  this.uploadFile = this.uploadFile.bind(this);
}
```

**Why bind methods**:

- **this context** - ensure that `this` refers to component instance
- **Method access** - allow methods to access component state and other methods
- **Class method pattern** - standard pattern for class components

### 4. Implement uploadFile with Promise

**Replace the console.log in uploadFile method**:

```javascript
uploadFile(file) {
  return new Promise((resolve, reject) => {
    this.getBase64(file, data => resolve({ data: { link: data } }));
  });
}
```

**Promise structure explanation**:

- **new Promise** - create new Promise to handle asynchronous operation
- **resolve, reject** - two arguments that Promise receives
- **resolve** - function called when operation is successful
- **reject** - function called when there is error (not implemented here)
- **callback function** - `data => resolve({ data: { link: data } })`

---

## 📖 Concepts

### FileReader API Deep Dive

**Why is FileReader asynchronous?**

```javascript
// ✗ WRONG - doesn't work - not instantaneous
let result = reader.readAsDataURL(file);
console.log(result); // undefined

// ✓ CORRECT - uses callbacks for result
reader.onload = () => {
  console.log(reader.result); // Base64 string
};
```

**Reasons for asynchronicity**:

- **Large files** - can take time to process
- **Performance** - doesn't block UI during conversion
- **Memory management** - efficient handling of memory for large files
- **Error handling** - time to handle errors during processing

### Promise Pattern Explanation

**Real-life Promise analogy**:

```
When someone makes you a promise:
1. You don't expect it to be fulfilled instantly
2. The person has to go and do something
3. Then they return with the result (resolve) or excuse (reject)
```

**Promise in code**:

```javascript
// 1. Create promise
new Promise((resolve, reject) => {
  // 2. Do asynchronous work
  this.getBase64(file, data => {
    // 3. Resolve with result
    resolve({ data: { link: data } });
  });
});
```

### Callback Function Flow

**Step-by-step of callback flow**:

```javascript
// 1. uploadFile called with file
uploadFile(file) {

  // 2. Promise created
  return new Promise((resolve, reject) => {

    // 3. getBase64 called with file and callback function
    this.getBase64(file, data => resolve({ data: { link: data } }));

    // 4. FileReader processes file
    // 5. onload executes the callback
    // 6. callback executes resolve with formatted data
  });
}
```

### Data Structure Required by Draft.js

**Draft.js expects specific format**:

```javascript
// ✓ CORRECT format
resolve({ 
  data: { 
    link: "data:image/jpeg;base64,/9j/4AAQSkZJRg..." 
  } 
});

// ✗ WRONG format
resolve(data); // Draft.js won't understand this format
```

**Why this format**:

- **data** - key that Draft.js searches for image data
- **link** - specific key for image URL/Base64 string
- **Consistent API** - same format as external image URLs

### Error Handling Strategy

**Current implementation**:

```javascript
reader.onerror = error => {};
```

**Why empty function**:

- **Simplified implementation** - focus on main functionality
- **Draft.js fallback** - library has built-in error handling
- **User experience** - image simply doesn't appear if there's error
- **Future enhancement** - can be expanded for better user feedback

### Base64 String Structure

**Anatomy of Base64 image string**:

```
data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEAYABgAAD...
│    │     │   │    │
│    │     │   │    └── Actual Base64 encoded data
│    │     │   └── base64 indicator
│    │     └── Character set
│    └── MIME type
└── Data URL scheme
```

**Components**:

- **data:** - indicates this is a data URL
- **image/jpeg** - MIME type of the file
- **base64** - encoding method
- **,** - separator before the data
- **Long string** - actual encoded image data

---

## ✅ Verification

### 1. Testing Image Upload Process

**Steps to verify complete functionality**:

1. **Navigate to blog modal**
2. **Click image icon** in toolbar
3. **Choose "Upload Image"** option
4. **Select image file** from file system
5. **Verify preview appears** in editor
6. **Add alt text** (optional)
7. **Click "Add"** - image should embed in content
8. **Add additional text** around image
9. **Save blog post**
10. **View saved post** - image should display correctly

### 2. Console Verification

**Check that there are no errors**:

- **No console errors** during upload process
- **Image preview** appears immediately after selection
- **Base64 conversion** happens without visible delay
- **Draft.js integration** works seamlessly

### 3. Data Format Verification

**Temporary debugging (optional)**:

```javascript
// Add temporary logging in getBase64
reader.onload = () => {
  console.log("Base64 result:", reader.result.substring(0, 50) + "...");
  callback(reader.result);
};
```

**Expected output**:

```
Base64 result: data:image/jpeg;base64,/9j/4AAQSkZJRgABAQEAYABgAAD...
```

### 4. Rich Text Editor Integration

**Verify complete workflow**:

- **Image appears** in editor preview
- **Text formatting** works around image
- **Alt text field** appears and accepts input
- **Image sizing options** available
- **Final content** includes both text and embedded image

### 5. Blog Post Rendering

**Verify saved content displays correctly**:

- **Navigate to blog detail page**
- **Image renders** from Base64 string
- **Text content** surrounds image correctly
- **No broken image icons**
- **Responsive behaviour** works properly

---
