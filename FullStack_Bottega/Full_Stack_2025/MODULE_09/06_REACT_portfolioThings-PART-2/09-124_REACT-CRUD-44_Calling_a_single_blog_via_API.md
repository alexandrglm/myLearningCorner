# 09-124: Calling API for Individual Blog Item

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/calling-single-blog-item-api-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 20ab98213f24c72d721a1b9b3af32f065a58b8b2](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/20ab98213f24c72d721a1b9b3af32f065a58b8b2)

---

## 🎯 Objectives

**Implement API call for individual blog using URL parameters**:

- **Constructor with props** - receive route props for URL parameter access
- **State initialisation** - currentId from route params and blogItem as empty object
- **URL parameter extraction** - using props.match.params.slug pattern
- **Dynamic API endpoint** - template literals with currentId for specific blog
- **Axios integration** - GET request for single blog item
- **ComponentDidMount lifecycle** - trigger API call when component loads
- **Console.log verification** - verify API response structure before rendering
- **Public API endpoint** - no withCredentials required for blog reading

**Critical concept**: URL parameters are accessible via props that React Router passes automatically

---

## 🛠️ Implementation

### 1. Create Constructor with Props and State

**File**: `src/components/pages/blog-detail.js`

**Add constructor after class declaration**:

```javascript
import React, { Component } from "react";
import axios from "axios";

export default class BlogDetail extends Component {
  constructor(props) {
    super(props);

    this.state = {
      currentId: this.props.match.params.slug,
      blogItem: {}
    };
  }
```

### 2. Create getBlogItem Method

**Add method after constructor**:

```javascript
getBlogItem() {
  axios
    .get(
      `https://jordan.devcamp.space/portfolio/portfolio_blogs/${this.state.currentId}`
    )
    .then(response => {
      console.log("response", response);
    })
    .catch(error => {
      console.log("getBlogItem error", error);
    });
}
```

### 3. Add ComponentDidMount Lifecycle Hook

**Add before render method**:

```javascript
componentDidMount() {
  this.getBlogItem();
}
```

### 4. Update Render Method for Testing

**Modify render method to display currentId**:

```javascript
render() {
  console.log("currentId", this.state.currentId);

  return (
    <div>
      <h1>Blog detail</h1>
    </div>
  );
}
```

### 5. Complete Final Code

**Full file: `src/components/pages/blog-detail.js`**:

```javascript
import React, { Component } from "react";
import axios from "axios";

export default class BlogDetail extends Component {
  constructor(props) {
    super(props);

    this.state = {
      currentId: this.props.match.params.slug,
      blogItem: {}
    };
  }

  getBlogItem() {
    axios
      .get(
        `https://jordan.devcamp.space/portfolio/portfolio_blogs/${this.state.currentId}`
      )
      .then(response => {
        console.log("response", response);
      })
      .catch(error => {
        console.log("getBlogItem error", error);
      });
  }

  componentDidMount() {
    this.getBlogItem();
  }

  render() {
    console.log("currentId", this.state.currentId);

    return (
      <div>
        <h1>Blog detail</h1>
      </div>
    );
  }
}
```

---

## 📚 Concepts

### React Router Props Injection

**How does BlogDetail receive props without passing them explicitly?**:

```javascript
// In App.js we have:
<Route path="/b/:slug" component={BlogDetail} />

// React Router automatically passes props that include:
// - match: information about URL matching
// - location: current location object  
// - history: history object for navigation
```

**Why props are needed in constructor**:

```javascript
constructor(props) {  // ← Required to access route props
  super(props);       // ← Pass props to parent class

  // Now we can access route information
  this.state = {
    currentId: this.props.match.params.slug  // ← Route parameter
  };
}
```

### URL Parameter Access Pattern

**Deep object path explanation**:

```javascript
this.props.match.params.slug
//    ↑      ↑      ↑      ↑
//    |      |      |      └─ Parameter name defined in route
//    |      |      └─ Object containing all route parameters  
//    |      └─ Route matching information
//    └─ Props injected by React Router
```

**No need to memorise**: As mentioned in guide, developers constantly look this up - totally normal

### Template Literal API Endpoint

**Dynamic API URL construction**:

```javascript
// Static URL (doesn't work for specific items)
"https://jordan.devcamp.space/portfolio/portfolio_blogs"

// Dynamic URL (gets specific blog by ID)
`https://jordan.devcamp.space/portfolio/portfolio_blogs/${this.state.currentId}`

// Examples of generated URLs:
// ID 18 → "...portfolio_blogs/18"
// ID 20 → "...portfolio_blogs/20"
```

### Public API Endpoint vs Authenticated

**No withCredentials needed for blog reading**:

```javascript
// For public content (blogs, portfolio items)
axios.get(url)

// For authenticated actions (create, edit, delete)
axios.post(url, data, { withCredentials: true })
```

**Why public access makes sense**:

- **Blog content** designed to be shared and read by anyone
- **SEO benefits** - search engines can crawl content
- **Social sharing** - links work for users without accounts
- **Standard pattern** - most blogs are publicly readable

### ComponentDidMount vs ComponentWillMount

**Modern React lifecycle pattern**:

```javascript
// Current guide uses componentDidMount (recommended)
componentDidMount() {
  this.getBlogItem();
}

// Previous guide used componentWillMount (legacy)
componentWillMount() {
  this.getBlogItems();
}
```

**ComponentDidMount advantages**:

- **After first render** - component is mounted in DOM
- **Modern pattern** - React team recommendation
- **Better for side effects** - API calls, subscriptions
- **Server-side rendering compatible**

### State Structure for Blog Detail

**Initial state design**:

```javascript
{
  currentId: "18",        // ← From URL parameter  
  blogItem: {}           // ← Will populate from API response
}
```

**Why separate currentId**:

- **URL source of truth** - preserve parameter value
- **Debug visibility** - can console.log currentId independently  
- **State clarity** - clear separation between route data and API data
- **Future flexibility** - might need currentId for other operations

---

## ✋ Verification

### Console Output Testing

**Expected console logs on page load**:

1. **currentId printed first** - render method executes
2. **API response printed** - getBlogItem completion

**Example output**:

```
currentId 18
response {data: {portfolio_blog: {…}}, status: 200, …}
```

### URL Parameter Testing

**Test different blog IDs**:

1. **Navigate to /b/18** - should show currentId 18
2. **Navigate to /b/20** - should show currentId 20  
3. **Navigate to /b/1** - should show currentId 1
4. **Each URL** triggers new API call with different ID

### API Response Structure Verification

**Expand response object in console**:

```javascript
response.data.portfolio_blog = {
  id: 18,
  title: "Blog Post Title",
  content: "Full HTML content...",
  blog_status: "published", // or "draft"
  featured_image_url: "https://...",
  created_at: "2024-01-01T00:00:00.000Z",
  updated_at: "2024-01-01T00:00:00.000Z"
}
```

### Network Tab Verification

**Verify API calls in DevTools**:

1. **Open DevTools** → Network tab
2. **Navigate to blog detail** - click any blog title
3. **Look for API request** - should see GET request to portfolio_blogs/[id]
4. **Check response** - 200 status with blog data
5. **Verify URL** - matches template literal generation

### Component Lifecycle Verification

**Testing order of operations**:

1. **Constructor runs** - currentId set from URL
2. **First render** - logs currentId
3. **componentDidMount** - triggers API call
4. **API response** - logs response data
5. **Multiple renders** - may see currentId logged multiple times (normal)

### Error Case Testing

**Test invalid blog IDs**:

- **Non-existent ID** like `/b/999` - should log error in catch block
- **Invalid characters** like `/b/abc` - API might return error
- **Empty slug** like `/b/` - should match different route or 404

---

## 🎨 API Response Preview

### Blog Data Structure

**What's available in response.data.portfolio_blog**:

```javascript
{
  id: 18,
  title: "Testing from modal",           // ← For H1 rendering
  content: "<p>Content with HTML...</p>", // ← For content display
  blog_status: "published",              // ← For status checking
  featured_image_url: "https://...",     // ← For image display
  created_at: "2024-01-01...",          // ← For date display
  updated_at: "2024-01-01..."           // ← For last modified
}
```

### Content with HTML Tags

**As mentioned in guide**:

- **Content field** may contain HTML tags
- **Will show raw HTML** in console: `<p>Content</p>`
- **HTML stripping** will be covered in future guides
- **Rich text editor** will generate this HTML format

---

