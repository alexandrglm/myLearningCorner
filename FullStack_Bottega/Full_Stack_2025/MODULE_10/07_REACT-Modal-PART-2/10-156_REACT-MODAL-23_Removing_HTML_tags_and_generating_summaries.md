# 10-156: Removing HTML Tags Generating Summaries Blogs

---

**[Guide](https://devcamp.com/trails/dissecting-react-js/campsites/building-blog-react/guides/removing-html-tags-generating-summaries-blogs)**

[GitHub](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/fa3447bf75709003ff2bd7f41dfea372baf66660)

---

## 🎯 Objectives

**Implement content processing pipeline in BlogItem component**:

- **Import striptags and Truncate** - bring in content processing libraries
- **Implement Truncate component** - 5-line summaries with ellipsis prop
- **Create Read More links** - dynamic links to individual blog posts
- **Strip HTML tags** - remove all HTML formatting from content
- **Professional summaries** - clean text summaries that look like purpose-built content
- **Edge case handling** - Truncate handles content length variations automatically

**Transformation**: Convert raw HTML blog content into clean, uniform summaries with navigation links

**Security consideration**: Striptags prevents malicious script injection in user content

---

## 🛠️ Implementation

### 1. Import Required Libraries

**File**: `src/components/blog/blog-item.js`

**Add imports at top**:

```javascript
import React from "react";
import { Link } from "react-router-dom";
import striptags from "striptags";
import Truncate from "react-truncate";
```

### 2. Implement Truncate Component with Read More Links

**Replace content rendering with Truncate component**:

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

      <div>
        <Truncate 
          lines={5}
          ellipsis={
            <span>
              ...<Link to={`/b/${id}`}>Read more</Link>
            </span>
          }
        >
          {content}
        </Truncate>
      </div>
    </div>
  );
};
```

### 3. Add HTML Tag Stripping

**Wrap content with striptags function**:

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

      <div>
        <Truncate 
          lines={5}
          ellipsis={
            <span>
              ...<Link to={`/b/${id}`}>Read more</Link>
            </span>
          }
        >
          {striptags(content)}
        </Truncate>
      </div>
    </div>
  );
};

export default BlogItem;
```

---

## 📖 Concepts

### Content Processing Pipeline

**Two-step transformation process**:

```javascript
// Step 1: Original HTML content from API
const htmlContent = "<p>Lorem ipsum <strong>dolor sit amet</strong>, consectetur adipiscing elit.</p>";

// Step 2: Strip HTML tags
const plainText = striptags(htmlContent);
// Result: "Lorem ipsum dolor sit amet, consectetur adipiscing elit."

// Step 3: Truncate to summary
<Truncate lines={5}>{plainText}</Truncate>
// Result: "Lorem ipsum dolor sit amet, consectetur adipiscing elit..." (if longer than 5 lines)
```

### Truncate Component Props

**lines prop**:

```javascript
lines={5}  // Show maximum 5 lines of content
```

**How it works**:

- **Measures text height** - calculates how many lines content would span
- **Cuts at line boundary** - doesn't cut words in middle
- **Responsive** - adapts to container width changes
- **Automatic detection** - only shows ellipsis if content exceeds limit

**ellipsis prop**:

```javascript
ellipsis={
  <span>
    ...<Link to={`/b/${id}`}>Read more</Link>
  </span>
}
```

**Ellipsis capabilities**:

- **Custom content** - can include any React elements
- **Styling** - can apply CSS classes, inline styles
- **Interactive elements** - buttons, links, icons
- **Conditional rendering** - only shows when truncation occurs

### Striptags Function Usage

**Basic usage** (our implementation):

```javascript
striptags(content)  // Removes ALL HTML tags
```

**Advanced usage examples**:

```javascript
// Allow specific tags
striptags(content, ['strong', 'em'])  // Keep bold and italic only

// Remove specific tags only
striptags(content, [], ['script'])  // Remove script tags, keep everything else
```

**Security implications**:

```javascript
// Dangerous user input
const userContent = "<script>alert('XSS Attack!');</script><p>Safe content</p>";

// Safe output
const safe = striptags(userContent);
// Result: "Safe content" (script removed)
```

### Edge Case Handling

**Content length variations**:

- **Short content** (under 5 lines) - no truncation, no ellipsis
- **Exactly 5 lines** - no truncation, no ellipsis
- **Over 5 lines** - truncated with ellipsis and Read more link

**Automatic behaviour**:

```javascript
// Truncate component automatically:
// 1. Measures content height
// 2. Compares to line limit
// 3. Shows/hides ellipsis accordingly
// 4. Handles responsive width changes
```

### Link Component Benefits

**Why Link over anchor tags**:

```javascript
// ✗ Anchor tag (causes page refresh)
<a href={`/b/${id}`}>Read more</a>

// ✓ Link component (client-side navigation)
<Link to={`/b/${id}`}>Read more</Link>
```

**React Router benefits**:

- **No page refresh** - faster navigation
- **Preserves state** - React state maintained across navigation
- **History management** - back button works correctly
- **Preloading** - can preload resources for faster experience

### Template Literal URL Generation

**Dynamic URL construction**:

```javascript
to={`/b/${id}`}
```

**Example transformations**:

```javascript
// If id = 18
`/b/${id}` → "/b/18"

// If id = 127  
`/b/${id}` → "/b/127"
```

### User Experience Design Philosophy

**Why summaries instead of full content**:

- **Scannable content** - users can quickly review multiple posts
- **Consistent layout** - uniform appearance regardless of content length
- **Clear navigation** - obvious call-to-action with Read more links
- **Performance** - faster rendering with truncated content
- **Mobile-friendly** - shorter content better for small screens

### Professional Content Strategy

**Summary creation best practices**:

1. **Remove formatting** - strip HTML for clean text
2. **Consistent length** - use line-based truncation
3. **Smart truncation** - don't break words
4. **Clear navigation** - obvious Read more links
5. **Responsive design** - adapts to container width

---

## ✅ Verification

### 1. Visual Summary Quality Check

**Navigate to /blog page and verify**:

- ✓ **Clean text summaries** - no HTML tags visible
- ✓ **Consistent length** - approximately 5 lines each
- ✓ **Read more links** - appear on longer content
- ✓ **No Read more** - shorter content doesn't show ellipsis
- ✓ **Professional appearance** - looks like purpose-built summaries

### 2. Read More Link Functionality

**Test navigation behaviour**:

1. **Click Read more link** - should navigate to blog detail page
2. **URL format** - should be `/b/[id]` format
3. **Correct content** - detail page shows full blog post
4. **Back navigation** - browser back button returns to index
5. **No page refresh** - smooth client-side navigation

### 3. Content Processing Verification

**Before processing** (if you temporarily disable striptags):

```html
<!-- Raw content shows HTML tags -->
<p>Lorem ipsum <strong>dolor</strong> sit amet...</p>
```

**After processing**:

```
<!-- Clean text only -->
Lorem ipsum dolor sit amet, consectetur adipiscing elit...
```

### 4. Edge Case Testing

**Test different content lengths**:

- **Very short posts** - should show full content, no ellipsis
- **Exactly 5 lines** - should show full content, no ellipsis
- **Long posts** - should truncate with Read more link
- **Empty content** - should handle gracefully

### 5. Responsive Behaviour

**Test responsive truncation**:

1. **Resize browser window** - summaries should adjust
2. **Different screen sizes** - line count adapts to width
3. **Mobile viewport** - content still readable and navigable
4. **Container width changes** - truncation recalculates

### 6. HTML Stripping Verification

**Create test blog post with complex HTML**:

```html
<!-- Input content -->
<h2>Heading</h2>
<p>Paragraph with <strong>bold</strong> and <em>italic</em> text.</p>
<ul>
  <li>List item one</li>
  <li>List item two</li>
</ul>
```

**Expected output**:

```
Heading Paragraph with bold and italic text. List item one List item two...
```

---

## 🎨 Professional Development Insights

### Content Management Evolution

**From basic to sophisticated**:

1. **Raw content display** - showing everything as-is
2. **HTML parsing** - rendering formatted content (blog detail)
3. **Content processing** - creating summaries (blog index)
4. **Smart truncation** - line-based with responsive behaviour

### Library Integration Strategy

**Why use existing libraries**:

- **Edge case handling** - libraries handle complex scenarios
- **Cross-browser compatibility** - tested across different browsers
- **Performance optimisation** - libraries often more efficient
- **Maintenance-free** - updates and bug fixes handled by maintainers

### Security Considerations

**Striptags security benefits**:

```javascript
// Dangerous user input
const maliciousContent = `
  <script>
    // Malicious code that could steal user data
    document.cookie = 'stolen';
  </script>
  <p>Legitimate content</p>
`;

// Safe output
const safeContent = striptags(maliciousContent);
// Result: "Legitimate content" (script completely removed)
```

### Component Architecture Benefits

**BlogItem responsibility**:

- **Single purpose** - display blog summary with navigation
- **Reusable** - could be used in search results, related posts
- **Testable** - isolated component easy to unit test
- **Maintainable** - content processing logic contained

### Real-world Applications

**This pattern applies to**:

- **News sites** - article summaries with Read more
- **E-commerce** - product descriptions with View details
- **Documentation** - section summaries with Learn more
- **Social media** - post previews with See full post
- **Any content-heavy site** - improved scanning and navigation

---
