# 10-160: Customising Draft.js Toolbar

---

**[Guide](https://devcamp.com/trails/dissecting-react-js/campsites/building-blog-react/guides/customizing-draft-js-toolbar)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 24443aed9261cbc775defff4a02035681bc7c052](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/24443aed9261cbc775defff4a02035681bc7c052)

---

## 🎯 Objectives

**Customise Draft.js toolbar to reduce options and add image functionality**:

- **Toolbar customisation** - select only necessary icons using props
- **Dropdown organisation** - group tools in dropdowns for cleaner UI
- **Image upload setup** - configure callback for image upload (first part)
- **File type validation** - define accepted file types for images
- **Upload callback function** - create function to handle files (console.log for now)
- **Preview functionality** - enable image preview in editor

**Two-part implementation**:

- **Part 1** (this guide) - toolbar customisation and basic image setup
- **Part 2** (next guide) - encoding images to strings for storage

---

## 🛠️ Implementation

### 1. Configure Toolbar Prop in Editor Component

**File**: `rich-text-editor.js`

**Locate Editor component and add toolbar prop**:

```javascript
<Editor
  editorState={this.state.editorState}
  wrapperClassName="demo-wrapper"
  editorClassName="demo-editor"
  toolbar={{
    inline: { inDropdown: true },
    list: { inDropdown: true },
    textAlign: { inDropdown: true },
    link: { inDropdown: true },
    history: { inDropdown: true },
    image: {
      uploadCallback: this.uploadFile,
      alt: { present: true, mandatory: false },
      previewImage: true,
      inputAccept: "image/gif,image/jpeg,image/jpg,image/png,image/svg"
    }
  }}
/>
```

**Important syntax notes**:

- **Double curly braces** `{{}}` - passing object as prop
- **Single brackets** `{}` - for single values or functions
- **Object nesting** - toolbar prop contains nested configuration objects

### 2. Create uploadFile Callback Method

**Add method in RichTextEditor class**:

```javascript
uploadFile = (file) => {
  console.log("upload file", file);
}
```

**Method location**: Inside RichTextEditor class, before render() method

**Temporary implementation**: Console.log to verify that callback works

---

## 📖 Concepts

### Toolbar Customisation Strategy

**Why reduce toolbar options**:

- **User experience** - less clutter, more focused
- **Performance** - fewer features loaded
- **Customisation** - complete control over available tools
- **Consistency** - match project design requirements

### Dropdown Organisation Benefits

**inDropdown: true for each section**:

```javascript
inline: { inDropdown: true }     // Bold, italic, underline in dropdown
list: { inDropdown: true }       // Ordered, unordered lists in dropdown
textAlign: { inDropdown: true }  // Left, centre, right, justify in dropdown
link: { inDropdown: true }       // Link creation/editing in dropdown
history: { inDropdown: true }    // Undo, redo in dropdown
```

**UI improvement**:

- **Compact toolbar** - more space for content
- **Organised tools** - related functions grouped together
- **Cleaner interface** - less visual noise
- **Professional appearance** - similar to Google Docs, Word

### Image Upload Configuration Breakdown

**uploadCallback explanation**:

```javascript
uploadCallback: this.uploadFile
```

- **Purpose** - function that runs when image is dropped or selected
- **Receives** - file object containing metadata
- **Custom naming** - this.uploadFile can be any function name
- **Required key** - uploadCallback must be exact name

**Alt text configuration**:

```javascript
alt: { present: true, mandatory: false }
```

- **present: true** - alt text field appears in UI
- **mandatory: false** - user is not required to fill alt text
- **SEO benefit** - when mandatory: true, improves accessibility

**Preview functionality**:

```javascript
previewImage: true
```

- **Live preview** - image appears in editor immediately after upload
- **User feedback** - visual confirmation of successful upload
- **Editor experience** - WYSIWYG behaviour for images

**File type validation**:

```javascript
inputAccept: "image/gif,image/jpeg,image/jpg,image/png,image/svg"
```

- **Security** - limits file types that can be uploaded
- **Performance** - prevents large/inappropriate files
- **Exact syntax** - comma-separated, no spaces, exact MIME types

### File Object Structure

**What uploadFile receives**:

```javascript
// Console.log output shows:
{
  name: "example.jpg",
  size: 125456,
  type: "image/jpeg", 
  lastModified: 1634567890123,
  webkitRelativePath: "",
  // Plus other file metadata
}
```

**Available metadata**:

- **name** - original filename
- **size** - file size in bytes
- **type** - MIME type (image/jpeg, etc.)
- **lastModified** - timestamp of last modification
- **Additional properties** - browser-specific metadata

### Draft.js Documentation Reference

**Where to find toolbar options**:

- **Official docs** - [draftjs.org](https://draftjs.org/)
- **react-draft-wysiwyg docs** - comprehensive toolbar configuration options
- **Examples section** - real implementation examples
- **Customisation guide** - detailed prop explanations

**Common toolbar categories**:

- **inline** - bold, italic, underline, strikethrough
- **blockType** - headers (H1-H6), blockquote, code
- **fontSize** - text size controls
- **fontFamily** - font selection
- **list** - ordered, unordered lists
- **textAlign** - alignment options
- **colourPicker** - text colour, background colour
- **link** - URL insertion/editing
- **embedded** - video, iframe embedding
- **emoji** - emoji picker
- **image** - image upload/insertion
- **remove** - formatting removal
- **history** - undo, redo

---

## ✅ Verification

### 1. Visual Toolbar Changes

**Before customisation**:

- Full toolbar with all available icons
- Crowded interface with many options
- Individual buttons for each tool

**After customisation**:

- **Reduced icon count** - only selected categories visible
- **Dropdown organisation** - cleaner, more organised
- **Image upload icon** - should be visible and functional

### 2. Image Upload UI Testing

**Steps to verify functionality**:

1. **Click image icon** in toolbar
2. **Should see two options**:
   - URL input field for external images
   - File upload button for local images
3. **Click file upload** - should open file picker
4. **Select image file** - should trigger upload process

### 3. Console Log Verification

**Test file upload callback**:

1. **Open browser console** (F12)
2. **Drag image file** onto editor
3. **Should see**: "upload file" message in console
4. **Expand log object** - examine file metadata
5. **Verify properties**: name, size, type, lastModified

**Expected console output**:

```
upload file File {name: "test.jpg", size: 45678, type: "image/jpeg", ...}
```

### 4. Error Handling Observation

**Current expected behaviour**:

- **File uploads** but throws error after console.log
- **"Loading" state** appears temporarily
- **Error messages** in console (normal for now)
- **Next guide** will resolve these errors with proper encoding

**What this confirms**:

- ✓ **Callback function** executing correctly
- ✓ **File object** being passed successfully
- ✓ **Upload process** initiating properly
- 🔄 **Encoding implementation** needed (next guide)

---
 
