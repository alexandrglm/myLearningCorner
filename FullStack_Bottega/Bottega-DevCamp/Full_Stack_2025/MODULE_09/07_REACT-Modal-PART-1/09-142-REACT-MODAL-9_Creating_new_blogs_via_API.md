# 09-142: Creating Blog Posts via API

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-blog-posts-api)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 8ab9a58624282eefffd4a2a32df5ce2093496e3f](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/8ab9a58624282eefffd4a2a32df5ce2093496e3f)

---

## 🎯 Objectives

**Implement complete blog creation functionality with API integration**:

- **buildForm method** - FormData construction for API submission
- **Axios POST request** - create blog posts in DevCamp Space database
- **Authentication** - withCredentials for user verification
- **Response handling** - pass API response to parent component
- **Error handling** - catch and log API errors
- **Database verification** - confirm posts created in DevCamp Space

**Goal**: Functional blog creation workflow that creates real database records through API calls.

---

## 🛠️ Implementation

### 1. Import Axios

**File**: `src/components/blog/blog-form.js`

**Add axios import at top**:

```javascript
import React, { Component } from "react";
import axios from "axios";

export default class BlogForm extends Component {
  // ... rest of component
}
```

### 2. Create buildForm Method

**Add buildForm method before handleSubmit**:

```javascript
buildForm() {
  let formData = new FormData();

  formData.append("portfolio_blog[title]", this.state.title);
  formData.append("portfolio_blog[blog_status]", this.state.blog_status);

  return formData;
}
```

### 3. Update handleSubmit with Axios POST

**Replace existing handleSubmit with API integration**:

```javascript
handleSubmit(event) {
  axios
    .post(
      "https://jordan.devcamp.space/portfolio/portfolio_blogs",
      this.buildForm(),
      { withCredentials: true }
    )
    .then(response => {
      this.props.handleSuccessfulFormSubmission(response.data);
    })
    .catch(error => {
      console.log("handleSubmit for blog error", error);
    });

  event.preventDefault();
}
```

### 4. Update BlogModal Handler

**File**: `src/components/modals/blog-modal.js`

**Update console.log to reflect API response**:

```javascript
handleSuccessfulFormSubmission(blog) {
  console.log("blog from blog form", blog);
  // Future: close modal, update parent blog list
}
```

---

## 📖 Concepts

### FormData vs Regular Objects

**Why FormData for API calls**:

```javascript
// ✗ Regular object (doesn't work for file uploads)
const data = {
  title: this.state.title,
  blog_status: this.state.blog_status
};

// ✓ FormData (works for text + files)
let formData = new FormData();
formData.append("portfolio_blog[title]", this.state.title);
formData.append("portfolio_blog[blog_status]", this.state.blog_status);
```

**FormData benefits**:

- **Multipart/form-data encoding** - required for file uploads
- **Extensible** - can add images in future guides
- **Browser compatibility** - handles encoding automatically
- **API expectations** - DevCamp Space API expects FormData

### API Key Structure

**DevCamp Space API expects specific format**:

```javascript
// Required format: portfolio_blog[field_name]
formData.append("portfolio_blog[title]", this.state.title);
formData.append("portfolio_blog[blog_status]", this.state.blog_status);
```

**Why this structure**:

- **Rails convention** - server expects nested parameters
- **Database mapping** - maps to portfolio_blog database table
- **Consistent API** - same pattern for all DevCamp Space endpoints
- **Future extensibility** - supports additional fields

### Authentication with withCredentials

**Why authentication required**:

```javascript
{ withCredentials: true }
```

**Security reasoning**:

- **Create operations require auth** - prevent unauthorised blog creation
- **Read operations are public** - anyone can view blogs
- **Session cookies sent** - browser includes authentication cookies
- **User verification** - server validates user identity

### Axios POST Method Arguments

**Three argument pattern**:

```javascript
axios.post(
  "https://jordan.devcamp.space/portfolio/portfolio_blogs",  // URL
  this.buildForm(),                                         // Data
  { withCredentials: true }                                 // Config
)
```

**Argument details**:

1. **URL** - API endpoint for blog creation
2. **Data** - FormData object from buildForm()
3. **Config** - authentication and other options

### Response vs State Data Flow

**Before (state data)**:

```javascript
// Old approach - passed form state
this.props.handleSuccessfulFormSubmission(this.state);
```

**After (API response)**:

```javascript
// New approach - passed API response
this.props.handleSuccessfulFormSubmission(response.data);
```

**Why API response better**:

- **Server-generated data** - includes database ID, timestamps
- **Confirmation** - proves record actually created
- **Complete record** - server may add additional fields
- **Future features** - parent needs full record for updates

### Promise Chain Error Handling

**Comprehensive error handling**:

```javascript
.then(response => {
  // Success - API call completed successfully
  this.props.handleSuccessfulFormSubmission(response.data);
})
.catch(error => {
  // Error - network issue, server error, or authentication failure
  console.log("handleSubmit for blog error", error);
});
```

**Error scenarios handled**:

- **Network errors** - internet connection issues
- **Server errors** - 500 internal server error
- **Authentication errors** - 401 unauthorised
- **Validation errors** - 422 unprocessable entity

---

## ✅ Verification

### 1. Form Submission Testing

**Complete workflow test**:

1. **Navigate to /blog**
2. **Click "Open Modal!" link**
3. **Fill form fields**:
   - Title: "Testing from modal"
   - Blog Status: "draft" (must be lowercase)
4. **Click Save button**
5. **Check console output** - should see blog object with ID

### 2. DevCamp Space Verification

**Database confirmation**:

1. **Go to DevCamp Space** in browser
2. **Navigate to Portfolio → Blogs**
3. **Refresh page** if needed
4. **Should see new record** at top of list:
   - Title: "Testing from modal"
   - Status: "draft"
   - Auto-generated ID

### 3. API Response Structure

**Expected console output**:

```javascript
blog from blog form {
  portfolio_blog: {
    id: 22,                          // Auto-generated by database
    title: "Testing from modal",     // From form input
    blog_status: "draft",            // From form input
    content: null,                   // Not implemented yet
    featured_image_url: null,        // Not implemented yet
    created_at: "2025-01-15T...",   // Server timestamp
    updated_at: "2025-01-15T..."    // Server timestamp
  }
}
```

### 4. Error Testing

**Test authentication requirement**:

1. **Open incognito browser** - no authentication cookies
2. **Navigate to blog form**
3. **Try to submit** - should get authentication error
4. **Check console** - error message about authorisation

### 5. Blog Status Validation

**Test valid statuses**:

- ✓ **"draft"** - should work
- ✓ **"published"** - should work  
- ✗ **"anything else"** - may cause validation error

---

## 🎨 Development Workflow Established

### Complete Data Flow

**Form → API → Database → Verification**:

1. **User fills form** → state updates
2. **Form submission** → buildForm() creates FormData
3. **Axios POST** → sends data to API
4. **Server processing** → creates database record
5. **Response received** → contains new record data
6. **Parent notification** → BlogModal receives response
7. **Database verification** → visible in DevCamp Space

### Professional API Integration Pattern

**Pattern established**:

```javascript
// 1. Data preparation
buildForm() {
  // Transform state into API format
}

// 2. API call
axios.post(url, data, config)

// 3. Success handling
.then(response => {
  // Pass server response to parent
})

// 4. Error handling  
.catch(error => {
  // Log for debugging
})
```

### Authentication Pattern

**Session-based authentication established**:

- **Login creates session** - cookies stored in browser
- **Authenticated requests** - withCredentials: true
- **Create operations protected** - only authenticated users
- **Read operations public** - anyone can view blogs

---

