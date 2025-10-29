# 09-123: Creating Initial Blog Detail Component

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-initial-blog-detail-component)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 8879d2d4ae439527cfb29cc326ff6313a3672281](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/8879d2d4ae439527cfb29cc326ff6313a3672281)

---

## 🎯 Objectives

**Implement routing system for blog detail pages**:

- **Dynamic route definition** - create route `/b/:slug` for blog details
- **BlogDetail component creation** - empty class component as placeholder
- **Import setup in App.js** - configure routing structure
- **Custom URL pattern** - use `/b/` prefix for shorter URLs
- **BlogItem links** - convert titles into clickable links to detail pages
- **Template literal routing** - use backticks for dynamic URL generation
- **Route parameter access** - prepare to access slug parameter in next guide

**Design decision**:

- URL pattern: `/b/123` instead of `/blog/123` - more concise and easy to share
- Publicly available route - no authentication required for reading blogs

---

## 🛠️ Implementation

### 1. Import BlogDetail in App Component

**File**: `src/components/app.js`

**Add import at top of file**:

```javascript
import BlogDetail from "./pages/blog-detail";
```

### 2. Define Dynamic Route

**In same file, add route within Switch**:

```javascript
<Switch>
  <Route exact path="/" component={Home} />
  <Route path="/about-me" component={About} />
  <Route path="/contact" component={Contact} />
  <Route path="/blog" component={Blog} />
  <Route path="/b/:slug" component={BlogDetail} />
  <Route component={NoMatch} />
</Switch>
```

### 3. Create BlogDetail Component

**File**: `src/components/pages/blog-detail.js`

```javascript
import React, { Component } from "react";

export default class BlogDetail extends Component {
  render() {
    return (
      <div>
        <h1>Blog detail</h1>
      </div>
    );
  }
}
```

### 4. Import Link in BlogItem Component

**File**: `src/components/blog/blog-item.js`

**Add Link import**:

```javascript
import React from "react";
import { Link } from "react-router-dom";
```

### 5. Create Dynamic Links in BlogItem

**Convert H1 title into Link component**:

```javascript
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
      <Link to={`/b/${id}`}>
        <h1>{title}</h1>
      </Link>
      <div>{content}</div>
    </div>
  );
};

export default BlogItem;
```

### 6. Complete Final Code

**Full file: `src/components/blog/blog-item.js`**:

```javascript
import React from "react";
import { Link } from "react-router-dom";

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
      <Link to={`/b/${id}`}>
        <h1>{title}</h1>
      </Link>
      <div>{content}</div>
    </div>
  );
};

export default BlogItem;
```

---

## 📚 Concepts

### Custom URL Pattern Design

**Why `/b/:slug` instead of `/blog/:slug`?**:

```javascript
// Longer
"/blog/123" 

// Shorter and more concise
"/b/123"
```

**Advantages of `/b/` pattern**:

- **Shorter URLs** - easier to share and type
- **Custom branding** - shows you control your URL structure
- **Professional approach** - many sites use short prefixes
- **User experience** - easier to remember and type

### Template Literal Syntax

**Modern JavaScript string interpolation**:

```javascript
// Old approach - string concatenation
to={"/b/" + id}

// Modern approach - template literals
to={`/b/${id}`}
```

**Template literal advantages**:

- **Cleaner syntax** - more readable
- **Variable interpolation** - `${variable}` syntax
- **Multi-line support** - can span multiple lines
- **Expression evaluation** - can include JavaScript expressions

### Route Parameter Definition

**Dynamic routing syntax explanation**:

```javascript
<Route path="/b/:slug" component={BlogDetail} />
//              ↑
//              Dynamic parameter named 'slug'
```

**Parameter naming**:

- `:slug` - common convention for URL-friendly identifiers
- `:id` - also valid, more direct
- `:permalink` - another common alternative
- Any name works - will be accessible as `props.match.params.parameterName`

### Link vs Anchor Tags

**Why use Link component instead of `<a>` tags?**:

```javascript
// ❌ Regular anchor - causes full page reload
<a href={`/b/${id}`}>{title}</a>

// ✅ React Router Link - SPA navigation
<Link to={`/b/${id}`}>{title}</Link>
```

**Link component benefits**:

- **SPA behaviour** - no full page reload
- **Faster navigation** - React handles routing client-side
- **State preservation** - app state maintained during navigation
- **History API** - proper browser back/forward button support

### Public vs Protected Routes

**Placement in routing structure**:

```javascript
// Public routes - no authentication needed
<Route path="/blog" component={Blog} />
<Route path="/b/:slug" component={BlogDetail} />

// Protected routes (if any) - would be inside authorisedPages()
```

**Blog detail decision**:

- **Public access** - anyone can read blog posts
- **SEO friendly** - search engines can index content
- **Shareable** - easy to share blog post links
- **Standard pattern** - most blogs are publicly accessible

---

## ✋ Verification

### Testing Basic Route Setup

**Manual verification**:

1. **Navigate to blog page** - `/blog`
2. **Click any blog title** - should navigate to `/b/[id]`
3. **Verify URL changes** - address bar shows `/b/123` pattern
4. **Verify component loads** - "Blog detail" heading appears
5. **Test browser back** - should return to blog list

### URL Pattern Testing

**Test different blog IDs**:

```
/b/1  → Blog detail page
/b/2  → Blog detail page  
/b/99 → Blog detail page
```

**All should show same placeholder content** (for now)

### Link Generation Testing

**Inspect generated links**:

1. **Open DevTools** → Elements
2. **Inspect blog title links**
3. **Verify href attributes**:
   
   ```html
   <a href="/b/1">First Blog Post</a>
   <a href="/b/2">Second Blog Post</a>
   ```

### React DevTools Route Verification

**Check component mounting**:

1. **Open React DevTools**
2. **Navigate to blog detail** - click any title
3. **Verify BlogDetail component** appears in component tree
4. **Check component type** - should be class component
5. **Prepare for props inspection** - next guide will show `props.match.params`

### Error Case Testing

**Expected behaviours**:

- **Invalid URLs** like `/b/` (without ID) → should show NoMatch component
- **Non-existent IDs** like `/b/999` → shows BlogDetail but will need API error handling
- **Malformed URLs** → caught by catch-all route

---

## 🎯 Professional Routing Pattern

**Current pattern establishes**:

- **Clean URL structure** - short and memorable
- **Proper Link usage** - SPA navigation
- **Dynamic parameters** - scalable for any number of posts
- **Public accessibility** - good for SEO and sharing

---

