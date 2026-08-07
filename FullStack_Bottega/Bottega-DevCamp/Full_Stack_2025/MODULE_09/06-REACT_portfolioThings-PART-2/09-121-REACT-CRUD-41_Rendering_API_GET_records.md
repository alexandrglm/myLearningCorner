# 09-121: Rendering Blog Records on Screen

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/rendering-blog-records-screen)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at fadce5c928c7b68204f653b0ae6352c4c18936c5](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/fadce5c928c7b68204f653b0ae6352c4c18936c5)

---

## 🎯 Objectives

**Implement basic rendering of blog records**:

- **Local variable blogRecords** in render method
- **Map iteration** over this.state.blogItems
- **Basic H1 rendering** for each blog title
- **Local variable scoping** pattern in render function
- **Replace placeholder JSX** with dynamic content
- **Foundation setup** for next refactoring to separate components

**Applied skills**:

- Array.map() method to transform data into JSX
- Local variables in render method
- Accessing state properties in iterations
- JSX interpolation with curly braces

---

## 🛠️ Implementation

### Create blogRecords Variable with Map Iterator

**File**: `src/components/pages/blog.js`

**Add within render method, before return**:

```javascript
render() {
  const blogRecords = this.state.blogItems.map(blogItem => {
    return <h1>{blogItem.title}</h1>;
  });

  return (
    <div>
      {blogRecords}
    </div>
  );
}
```

### Complete Final Code

**Full updated file**:

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
    const blogRecords = this.state.blogItems.map(blogItem => {
      return <h1>{blogItem.title}</h1>;
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

### Local Variable Scoping in Render Method

**Why it works without `this.blogRecords`?**:

```javascript
render() {
  const blogRecords = // Local variable created in function

  return (
    <div>
      {blogRecords} // Accessible because in same scope
    </div>
  );
}
```

**Function scoping explanation**:

- **Local variables** - created inside render function
- **Function scope** - accessible anywhere in same function
- **No this. required** - not properties of component instance
- **Temporary variables** - exist only during render execution

### Map Method for JSX Transformation

**Data transformation pattern**:

```javascript
// Input: Array of blog objects
blogItems = [
  {title: "Blog Post 1", content: "..."},
  {title: "Blog Post 2", content: "..."}
]

// Process: Map transforms to JSX elements
blogRecords = blogItems.map(blogItem => <h1>{blogItem.title}</h1>)

// Output: Array of JSX elements  
blogRecords = [
  <h1>Blog Post 1</h1>,
  <h1>Blog Post 2</h1>
]
```

### Why Map Instead of ForEach?

**Map characteristics**:

- **Returns new array** - perfect for JSX arrays
- **Immutable pattern** - doesn't modify original array
- **Functional approach** - each element transformed to JSX
- **React-friendly** - standard pattern in React applications

**ForEach problems**:

- **Returns undefined** - no value for render
- **Side effects** - no return value for JSX
- **Not functional** - doesn't follow React patterns

### Accessing API Response Properties

**Blog item structure from DevCamp Space**:

```javascript
blogItem = {
  id: 1,
  title: "Blog Post Title",        // ← Used in H1
  content: "Full blog content...",
  blog_status: "published",
  featured_image_url: "https://...",
  created_at: "2024-01-01",
  updated_at: "2024-01-01"
}
```

**Property access pattern**:

- `blogItem.title` - main blog post title
- `blogItem.id` - unique identifier (useful for keys)
- `blogItem.content` - full content (future use)

### JSX Array Rendering Behaviour

**How React renders arrays**:

```javascript
// JSX array
[<h1>Title 1</h1>, <h1>Title 2</h1>, <h1>Title 3</h1>]

// Renders as
<h1>Title 1</h1>
<h1>Title 2</h1>  
<h1>Title 3</h1>
```

**React automatically spreads JSX arrays** into DOM

---

## ✋ Verification

### Visual Testing in Browser

**Expected output on /blog page**:

1. **Multiple H1 elements** - one per blog post
2. **Real blog titles** - no placeholder text
3. **Vertical stack** - each title on new line
4. **No errors** - clean rendering without warnings

### Console Verification

**No console errors expected**:

- ✅ **No key prop warnings** - simple H1s don't need keys yet
- ✅ **No API errors** - data loading successfully
- ✅ **No rendering errors** - JSX syntax correct

### React DevTools State Check

**Verify data flow**:

1. **Open React DevTools**
2. **Select Blog component**
3. **Check State tab**:
   - `blogItems: Array(10)` - populated with API data
4. **Confirm state → render** - state data appears on screen

### Expected DOM Structure

**HTML output in browser**:

```html
<div>
  <h1>First Blog Post Title</h1>
  <h1>Second Blog Post Title</h1>
  <h1>Third Blog Post Title</h1>
  <!-- ... more H1s based on API data -->
</div>
```

### Troubleshooting Common Issues

**If titles don't appear**:

1. **Check API call** - verify getBlogItems executed
2. **Check DevCamp Space** - confirm blog posts exist with titles
3. **Check state** - blogItems should be populated array
4. **Check subdomain** - verify correct subdomain in API URL

**If error appears**:

- **Check console** - probably API endpoint issue
- **Verify withCredentials** - API authentication
- **Check network tab** - verify successful API response

---

## 🎨 Preview of Refactoring

### Why Is This Basic Approach?

**Current limitations**:

- **Single H1** - no complex layout structure
- **No styling** - basic HTML output
- **Growing complexity** - render method becomes long
- **Hard to maintain** - all JSX in one function

### Professional Pattern Recognition

**Current pattern** (acceptable for prototyping):

```javascript
render() {
  const items = data.map(item => <h1>{item.title}</h1>);
  return <div>{items}</div>;
}
```

**Next pattern** (professional refactoring):

```javascript
render() {
  const items = data.map(item => <BlogItem key={item.id} data={item} />);
  return <div>{items}</div>;
}
```

---

