# 09-120: Blog API Call and State Management

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/calling-blog-api-storing-data-state)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 6ffbc58c252d44bdeb3d8956081d711312e09ee5](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/6ffbc58c252d44bdeb3d8956081d711312e09ee5)

---

## 🎯 Objectives

**Implement complete API communication for Blog component**:

- **Axios import** for HTTP requests
- **Constructor with initial state** for blogItems array
- **getBlogItems() method** with specific API endpoint
- **componentWillMount lifecycle hook** for auto-loading
- **setState with API response** to populate component state
- **Error handling pattern** with catch blocks
- **React DevTools verification** of populated state

**Applied skills**:

- Same API pattern used in Portfolio but adapted for blogs
- State management with arrays
- Lifecycle hooks timing
- API endpoint configuration with DevCamp Space

---

## 🛠️ Implementation

### 1. Import Axios in Blog Component

**File**: `src/components/pages/blog.js`

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

export default class Blog extends Component {
```

### 2. Constructor with Initial State

**Add constructor after class declaration**:

```javascript
export default class Blog extends Component {
  constructor() {
    super();

    this.state = {
      blogItems: []
    };

    this.getBlogItems = this.getBlogItems.bind(this);
  }
```

### 3. getBlogItems Method for API Call

**Create function after constructor**:

```javascript
getBlogItems() {
  axios
    .get("https://jordan.devcamp.space/portfolio/portfolio_blogs", {
      withCredentials: true
    })
    .then(response => {
      console.log("response", response);
    })
    .catch(error => {
      console.log("getBlogItems error", error);
    });
}
```

### 4. ComponentWillMount Lifecycle Hook

**Add before render method**:

```javascript
componentWillMount() {
  this.getBlogItems();
}
```

### 5. Update State with API Response

**Modify .then() in getBlogItems**:

```javascript
getBlogItems() {
  axios
    .get("https://jordan.devcamp.space/portfolio/portfolio_blogs", {
      withCredentials: true
    })
    .then(response => {
      this.setState({
        blogItems: response.data.portfolio_blogs
      });
    })
    .catch(error => {
      console.log("getBlogItems error", error);
    });
}
```

### 6. Complete Final Code

**Full file: `src/components/pages/blog.js`**:

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

export default class Blog extends Component {
  constructor() {
    super();

    this.state = {
      blogItems: []
    };

    this.getBlogItems = this.getBlogItems.bind(this);
  }

  getBlogItems() {
    axios
      .get("https://jordan.devcamp.space/portfolio/portfolio_blogs", {
        withCredentials: true
      })
      .then(response => {
        this.setState({
          blogItems: response.data.portfolio_blogs
        });
      })
      .catch(error => {
        console.log("getBlogItems error", error);
      });
  }

  componentWillMount() {
    this.getBlogItems();
  }

  render() {
    return (
      <div>
        <h2>Blog</h2>
        <div>
          <Link to="/about-me">Read more about myself</Link>
        </div>
      </div>
    );
  }
}
```

---

## 📚 Concepts

### API Endpoint for Blogs

**Difference with Portfolio API**:

```javascript
// Portfolio items
"https://subdomain.devcamp.space/portfolio/portfolio_items"

// Blog posts  
"https://subdomain.devcamp.space/portfolio/portfolio_blogs"
```

**Same subdomain, different resource path**

### ComponentWillMount vs ComponentDidMount

**Why componentWillMount in this guide?**:

- **Timing preference** - loads data before initial render
- **Pattern used** in DevCamp course specifically
- **Legacy approach** - works but componentDidMount is more recommended

**Modern best practice is componentDidMount**

### WithCredentials for Authentication

**Required configuration**:

```javascript
{
  withCredentials: true
}
```

**Reasons to include**:

- **DevCamp Space authentication** - verifies if user is logged in
- **Extra permissions** if you're authorised
- **Public access** - endpoint is public but gives additional options
- **Cross-origin requests** - correct CORS handling

### Error Naming Convention

**Specific pattern for debugging**:

```javascript
console.log("getBlogItems error", error);
```

**Advantages**:

- **Specific function identified** - know exactly where error occurred
- **Multiple catch blocks** - when you have several API calls
- **Faster debugging** - don't have to search which API failed

### API Response Structure

**Expected response.data format**:

```javascript
{
  portfolio_blogs: [
    {
      id: 1,
      title: "Blog Title",
      content: "Content here...",
      blog_status: "published",
      featured_image_url: "https://...",
      // more properties
    }
  ]
}
```

**That's why we use**: `response.data.portfolio_blogs`

### Binding in Constructor

**Why do we need bind?**:

```javascript
this.getBlogItems = this.getBlogItems.bind(this);
```

**Problem without binding**:

- **Context loss** - `this` doesn't point to component
- **Cannot read property 'setState'** - common error
- **Function calls fail** - method can't access component state

**Solution with binding**:

- **Preserves context** - `this` always points to component
- **setState works** - correct access to component instance
- **Lifecycle hooks work** - can call bound methods correctly

---

## ✋ Verification

### Testing with Console Logs

**Verification steps**:

1. **Save file** - auto-refresh from dev server
2. **Navigate to /blog** page
3. **Open DevTools** → Console tab
4. **Verify console output** with response data
5. **Expand response.data.portfolio_blogs** to see structure

### React DevTools State Inspection

**Verify populated state**:

1. **Open React DevTools**
2. **Navigate to Blog page**
3. **Click on Blog component** in component tree
4. **View State panel** in right sidebar
5. **Confirm blogItems array** is populated
6. **Expand individual blog items** to see properties

### Expected State Structure

**In React DevTools you should see**:

```javascript
State:
  blogItems: Array(10)
    0: {id: 1, title: "Blog Post 1", content: "...", blog_status: "published"}
    1: {id: 2, title: "Blog Post 2", content: "...", blog_status: "published"}  
    2: {id: 3, title: "Blog Post 3", content: "...", blog_status: "published"}
    // ... up to 10 items (API pagination limit)
```

### API Response Verification

**In Console log you should see**:

```javascript
response: {
  data: {
    portfolio_blogs: Array(10),
    // other metadata fields
  },
  status: 200,
  statusText: "OK",
  // axios response properties
}
```

### Error Cases Testing

**If you don't have blog data in DevCamp Space**:

1. **Go to DevCamp Space** → Portfolio → Blogs
2. **Add test blog posts** with status "published"
3. **Refresh React app** to re-trigger API call
4. **Verify new data** appears in state

---

## 🎨 API Pagination Understanding

### Why Only 10 Items?

**API behaviour explanation**:

- **Default limit** - APIs never return all data at once
- **Performance reasons** - avoid long loading times
- **Pagination pattern** - standard in real applications
- **Infinite scrolling prep** - foundation for loading more data

### Real-World API Pattern

**Typical API response patterns**:

```javascript
// Small datasets - all items
{
  items: [...], // all records
  total: 25
}

// Large datasets - pagination required  
{
  items: [...], // first 10-20 items
  total: 500,
  page: 1,
  per_page: 10,
  has_more: true
}
```
---
