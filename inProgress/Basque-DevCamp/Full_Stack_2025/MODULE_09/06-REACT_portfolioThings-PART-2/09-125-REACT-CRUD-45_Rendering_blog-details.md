# 09-125: Rendering Blog Details on Screen

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/rendering-blog-details-screen)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 656685f7852687eaa5e2245398ac0e0a3fccaeb0](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/656685f7852687eaa5e2245398ac0e0a3fccaeb0)

---

## 🎯 Objectives

**Complete the API → State → UI flow for individual blog**:

- **setState with API response** - populate blogItem state with response.data.portfolio_blog
- **Destructuring in render method** - extract title, content, featured_image_url, blog_status
- **Dynamic content rendering** - display title, featured image and full content
- **Remove console.log** - clean debugging code after implementing rendering
- **React DevTools usage** - verify state population instead of console logs
- **Image display** - render featured image with natural sizing (styling in future guides)

**Applied skills**:

- Same API → State → UI pattern used in Portfolio container
- Destructuring pattern for clean variable access
- Image rendering with dynamic src attributes

---

## 🛠️ Implementation

### 1. Update API Response Handler to Populate State

**File**: `src/components/pages/blog-detail.js`

**Modify .then() in getBlogItem method**:

```javascript
getBlogItem() {
  axios
    .get(
      `https://jordan.devcamp.space/portfolio/portfolio_blogs/${this.state.currentId}`
    )
    .then(response => {
      this.setState({
        blogItem: response.data.portfolio_blog
      });
    })
    .catch(error => {
      console.log("getBlogItem error", error);
    });
}
```

### 2. Implement Destructuring in Render Method

**Add destructuring before return**:

```javascript
render() {
  const {
    title,
    content,
    featured_image_url,
    blog_status
  } = this.state.blogItem;

  return (
    <div>
      <h1>{title}</h1>
    </div>
  );
}
```

### 3. Add Featured Image Rendering

**Add image tag after H1**:

```javascript
render() {
  const {
    title,
    content,
    featured_image_url,
    blog_status
  } = this.state.blogItem;

  return (
    <div>
      <h1>{title}</h1>
      <img src={featured_image_url} />
      <div>{content}</div>
    </div>
  );
}
```

### 4. Complete Final Code

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
        this.setState({
          blogItem: response.data.portfolio_blog
        });
      })
      .catch(error => {
        console.log("getBlogItem error", error);
      });
  }

  componentDidMount() {
    this.getBlogItem();
  }

  render() {
    const {
      title,
      content,
      featured_image_url,
      blog_status
    } = this.state.blogItem;

    return (
      <div>
        <h1>{title}</h1>
        <img src={featured_image_url} />
        <div>{content}</div>
      </div>
    );
  }
}
```

---

## 📚 Concepts

### API Response Data Navigation

**Response structure understanding**:

```javascript
// Full axios response object
response = {
  data: {
    portfolio_blog: {          // ← Target object
      id: 18,
      title: "Blog Post Title",
      content: "<p>HTML content...</p>",
      blog_status: "published",
      featured_image_url: "https://...",
      created_at: "2024-01-01T00:00:00.000Z",
      updated_at: "2024-01-01T00:00:00.000Z"
    }
  },
  status: 200,
  statusText: "OK"
}

// Access path: response.data.portfolio_blog
```

### Destructuring Pattern Benefits

**Without destructuring (repetitive)**:

```javascript
return (
  <div>
    <h1>{this.state.blogItem.title}</h1>
    <img src={this.state.blogItem.featured_image_url} />
    <div>{this.state.blogItem.content}</div>
  </div>
);
```

**With destructuring (clean)**:

```javascript
const { title, content, featured_image_url, blog_status } = this.state.blogItem;

return (
  <div>
    <h1>{title}</h1>
    <img src={featured_image_url} />
    <div>{content}</div>
  </div>
);
```

**Advantages**:

- **Less repetition** - don't repeat `this.state.blogItem`
- **Cleaner JSX** - variables used directly
- **Better readability** - obvious which properties are used
- **Easier maintenance** - single place for property list

### React DevTools vs Console.log

**Professional debugging approach**:

```javascript
// ❌ Development phase - console debugging
console.log("response", response);

// ✅ Verification phase - React DevTools
// Remove console.log and use React DevTools for state inspection
```

**React DevTools benefits**:

- **Live state inspection** - see current component state
- **Props visualisation** - understand route props structure
- **Component hierarchy** - navigate component tree
- **Performance insights** - track re-renders and state changes
- **Professional debugging** - standard industry practice

### Image Rendering Considerations

**Natural image sizing**:

```javascript
<img src={featured_image_url} />
// Image displays at natural size - may be very large or very small
```

**Expected behaviour at this stage**:

- **No size control** - images render at original dimensions
- **Potential layout issues** - very large images may break layout
- **Styling comes later** - focus on functionality first
- **Content-first approach** - establish data flow before styling

### Blog Status Property Usage

**Available but not used yet**:

```javascript
const { title, content, featured_image_url, blog_status } = this.state.blogItem;
//                                            ↑
//                                            Available for future features
```

**Potential future uses**:

- **Draft indicator** - show "Draft" badge if blog_status !== "published"
- **Conditional rendering** - hide draft posts for non-admin users  
- **Status styling** - different styling based on status
- **Admin controls** - show edit options based on status

### HTML Content in Blog Posts

**Raw HTML in content field**:

- **Rich text editor output** - content contains HTML tags
- **JSX rendering** - React displays HTML content properly
- **No HTML stripping needed** - unless creating previews/summaries
- **Future enhancement** - might need HTML parsing for custom rendering

---

## ✋ Verification

### React DevTools State Verification

**Verify state population**:

1. **Navigate to any blog detail** - click blog title from /blog

2. **Open React DevTools** - select BlogDetail component

3. **Inspect state object**:
   
   ```javascript
   State:
     currentId: "18"
     blogItem: {
       id: 18,
       title: "Blog Post Title",
       content: "<p>Content...</p>",
       blog_status: "published",
       featured_image_url: "https://..."
     }
   ```

### Visual Content Verification

**Expected rendering output**:

1. **H1 with blog title** - dynamic title from API
2. **Featured image** - displayed at natural size
3. **Full blog content** - HTML content rendered properly
4. **Different posts** - click different blog titles, content changes

### Props Structure Understanding

**React DevTools props inspection**:

```javascript
Props:
  match: {
    params: {
      slug: "18"    // ← URL parameter value
    },
    path: "/b/:slug",
    url: "/b/18"
  }
  location: { ... }
  history: { ... }
```

### Multiple Blog Testing

**Test dynamic functionality**:

1. **Navigate to /blog**
2. **Click first blog title** - verify title, image, content
3. **Go back to /blog**  
4. **Click different blog title** - verify content changes
5. **Each blog shows different**:
   - Title in H1
   - Different featured image
   - Different content

### Content Types Verification

**Different content scenarios**:

- **Posts with images** - featured_image_url populated
- **Posts without images** - may show broken image or no image
- **HTML content** - paragraphs, formatting should display properly
- **Long content** - scrollable content area

---

## 🎯 Professional Data Flow Pattern

**Pattern established**:

```javascript
// 1. URL Parameter → State
currentId: this.props.match.params.slug

// 2. State → API Call  
axios.get(`/portfolio_blogs/${this.state.currentId}`)

// 3. API Response → State Update
this.setState({ blogItem: response.data.portfolio_blog })

// 4. State → UI Rendering
const { title, content } = this.state.blogItem
```

---

