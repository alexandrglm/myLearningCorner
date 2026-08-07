# 08-080 - Portfolio Manager Feature Overview

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/portfolio-manager-feature-overview)**

---

## 🎯 OBJECTIVES

**Build complete portfolio management system**:

- **Create portfolio items** directly from application
- **Upload images** with drag & drop using Dropzone
- **POST requests** to send complete data to API
- **Form management** with multiple data types
- **Automatic update** without page refresh

**Project evolution**:

- **Before**: Only consume data (GET requests)
- **Now**: Create and manage data (POST requests)
- **Goal**: Complete CRUD application

---

## 🛠️ IMPLEMENTATION

### Portfolio Manager Features

**Prototype to build**:

```javascript
// Portfolio Manager Component will have:
- Complete creation form
- Upload 3 types of images:
  * Thumbnail image
  * Banner image  
  * Logo image
- Category dropdown
- List of existing items
- Automatic update on create
```

### Expected Workflow

**Process demonstration**:

1. **Fill form**:
   
   - Name: "My Demo App"
   - URL: any URL
   - Position: 13
   - Category: dropdown selection
   - Description: free content

2. **Upload images** with drag & drop

3. **Send data** → POST request to API

4. **See result**:
   
   - Item appears automatically in list
   - No page refresh
   - Data verifiable in DevCamp Space

---

## 🔧 CONCEPTS

### New Technologies

**POST Requests with Forms**:

```javascript
// Key difference from previous sessions
// Before: POST only to create session
// Now: POST with complete form data + images
```

**Dropzone Library**:

- **Drag & drop** files
- **Automatic preview** of images
- **File management** (add/remove)
- **Validation** of file types

**Form Data Management**:

```javascript
// Combination of:
- Text inputs (name, URL, description)
- Number inputs (position)
- Select dropdowns (category)
- File uploads (multiple images)
- API integration (POST request)
```

### Component Architecture

**Portfolio Manager Structure**:

```
PortfolioManager/
├── Form Component
├── Image Upload Components (3x)
├── Portfolio List Component
└── API Integration Logic
```

### Why This Approach

**Real-world applications require**:

- **Complete data** management (not just reading)
- **File uploads** with good UX
- **Complex forms** with validation
- **Bidirectional communication** with APIs

**Professional skills**:

- **POST requests** with FormData
- **File handling** in React
- **State management** for forms
- **Error handling** in uploads
- **Modern UX patterns** (drag & drop)

---

## 📋 VERIFICATION

### System Testing

**Verify**:

1. **Create item** → appears in local list
2. **Refresh DevCamp Space** → data persisted
3. **Upload images** → previews work
4. **Drag & drop** → files detected
5. **Remove files** → files deleted

---
