# 09-122: Creating Dedicated BlogItem Component

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-dedicated-blog-item-component)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at a0f9584363c5ff77883980180af71ac4dc972d92](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/a0f9584363c5ff77883980180af71ac4dc972d92)

---

## 🎯 Objectives

**Refactor rendering logic into separate component**:

- **Blog folder structure** - create specific directory for blog components
- **BlogItem functional component** - dedicated component for each blog post
- **Arrow function syntax** - const + arrow function pattern
- **Destructuring pattern** - extract specific properties from props
- **Props passing** - send complete blogItem object as prop
- **Import/export setup** - configure correct relative imports
- **Key prop implementation** - add unique keys for map iterations

**Reason for refactoring**:

- Prepare for complex functionality (HTML stripping, truncation, summaries)
- Keep render method clean and readable
- Separation of concerns - each component with specific responsibility

---

## 🛠️ Implementation

### 1. Create Blog Directory Structure

**Create new folder**: `src/components/blog/`

```
src/
  components/
    blog/           ← New directory
      blog-item.js  ← New file
```

### 2. Create BlogItem Functional Component

**File**: `src/components/blog/blog-item.js`

```javascript
import React from "react";

const BlogItem = props => {
  const {
    id,
    blog_status,
    content,
    title,
    featured_image_url
  } = props.blogItem;

  return (
    <div>
      <h1>{title}</h1>
      <div>{content}</div>
    </div>
  );
};

export default BlogItem;
```

### 3. Import BlogItem in Blog Component

**File**: `src/components/pages/blog.js`

**Add import at top**:

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import BlogItem from "../blog/blog-item";
```

### 4. Update blogRecords Map Function

**Replace simple H1 with BlogItem component**:

```javascript
render() {
  const blogRecords = this.state.blogItems.map(blogItem => {
    return (
      <BlogItem key={blogItem.id} blogItem={blogItem} />
    );
  });

  return (
    <div>
      {blogRecords}
    </div>
  );
}
```

### 5. Complete Final Code

**Full file: `src/components/pages/blog.js`**:

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import BlogItem from "../blog/blog-item";

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
    const blogRecords = this.state.blogItems.map(blogItem => {
      return <BlogItem key={blogItem.id} blogItem={blogItem} />;
    });

    return (
      <div>
        {blogRecords}
      </div>
    );
  }
}
```

---

## 📚 Concepts

### Arrow Function Syntax for Functional Components

**Pattern comparison**:

```javascript
// Option 1: Arrow function (used in guide)
const BlogItem = props => {
  return (
    <div>Content</div>
  );
};

// Option 2: Traditional function
export default function BlogItem(props) {
  return (
    <div>Content</div>
  );
}
```

**Why arrow function?**:

- **Concise syntax** - less code
- **Modern JavaScript** - ES6 standard
- **Consistent pattern** - same style throughout app
- **Popular choice** - common in React community

### Destructuring Pattern Explained

**Problem without destructuring**:

```javascript
// Repetitive and verbose
return (
  <div>
    <h1>{props.blogItem.title}</h1>
    <div>{props.blogItem.content}</div>
    <span>{props.blogItem.id}</span>
  </div>
);
```

**Solution with destructuring**:

```javascript
// Single line extracts all variables
const { id, blog_status, content, title, featured_image_url } = props.blogItem;

// Variables used directly
return (
  <div>
    <h1>{title}</h1>
    <div>{content}</div>
    <span>{id}</span>
  </div>
);
```

**Advantages of destructuring**:

- **Less repetition** - don't repeat props.blogItem
- **Cleaner JSX** - variables direct access
- **Easier to read** - obvious which properties used
- **Preparation** - easy to add new properties

### Props Object Structure

**blogItem object contains**:

```javascript
blogItem = {
  id: 1,                           // ← Used for key prop
  title: "Blog Post Title",        // ← Rendered in H1
  content: "Full content...",      // ← Rendered in div
  blog_status: "published",        // ← Future use (filtering)
  featured_image_url: "https://...", // ← Future use (images)
  created_at: "2024-01-01",       // ← Available but not used yet
  updated_at: "2024-01-01"        // ← Available but not used yet
}
```

### Relative Import Path Logic

**Path calculation from blog.js to blog-item.js**:

```javascript
// Current file: src/components/pages/blog.js
// Target file:  src/components/blog/blog-item.js

// Step 1: Go up one directory from pages/
// Step 2: Go into blog/ directory  
// Step 3: Import blog-item file

import BlogItem from "../blog/blog-item";
//                   ↑     ↑      ↑
//                   |     |      └─ filename
//                   |     └─ blog directory
//                   └─ up one level (..)
```

### Key Prop Necessity

**Why do we need key prop?**:

```javascript
// React tracking requirement for arrays
return <BlogItem key={blogItem.id} blogItem={blogItem} />;
```

**Technical reasons**:

- **Virtual DOM reconciliation** - React tracks elements efficiently
- **Performance optimisation** - only re-render changed elements
- **Warning prevention** - React shows warning without unique keys
- **Future features** - drag/drop, reordering require proper keys

### Component Separation Benefits

**Before refactoring**:

- Everything in render method - gets complex quickly
- Hard to test - logic mixed with rendering
- Not reusable - can't use BlogItem elsewhere

**After refactoring**:

- **Clean separation** - each component with single responsibility  
- **Testable** - BlogItem can be tested independently
- **Reusable** - BlogItem could be used on other pages
- **Maintainable** - complex logic isolated in BlogItem

---

## ✋ Verification

### Visual Testing

**Expected output on /blog page**:

1. **Same H1 titles** - no visual difference from previous version
2. **Same content** - full blog content displayed
3. **Same layout** - vertical stacking of blog items
4. **Clean rendering** - no console errors

### React DevTools Component Structure

**Component hierarchy verification**:

```
App
└── Blog (class component)
    └── div
        └── BlogItem (functional component) [multiple instances]
            └── div
                ├── h1 (title)
                └── div (content)
```

### Props Flow Verification

**In React DevTools**:

1. **Select Blog component** - verify blogItems in state
2. **Select BlogItem instances** - verify props.blogItem object
3. **Check prop structure**:
   - `blogItem.id` - number
   - `blogItem.title` - string  
   - `blogItem.content` - string (possibly with HTML)
   - `blogItem.blog_status` - "published"

### HTML Content Preview

**If you have HTML content in blog posts**:

- Content might show HTML tags literally: `<p>Content</p>`
- This is expected behaviour at this stage
- HTML stripping will be implemented in future guides
- Rich text editor features coming later

### File Structure Verification

**Verify proper file organisation**:

```
src/
  components/
    blog/
      blog-item.js  ✅ Created
    pages/  
      blog.js       ✅ Updated with import
```

---
