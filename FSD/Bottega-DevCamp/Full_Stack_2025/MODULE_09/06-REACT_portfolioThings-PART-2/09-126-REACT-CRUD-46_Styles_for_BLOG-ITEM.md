# 09-126: Applying Styles to Blog Detail Component

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/applying-styles-blog-detail-component)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 17328ab44aefd3cb61e56effdad707b9ba1e1aa2](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/17328ab44aefd3cb61e56effdad707b9ba1e1aa2)

---

## 🎯 Objectives

**Create centred and professional layout for blog detail page**:

- **Nested container structure** - blog-container and content-container for layout control
- **Centred column layout** - 800px width centred on page
- **Featured image styling** - responsive image with rounded corners and consistent sizing
- **Flexbox architecture** - vertical stacking with proper alignment
- **Reusable CSS classes** - styles to also be used in blog index page
- **Professional blog post presentation** - title, image, content properly organised

**Design vision**:

- Title at top, centred
- Featured image spanning full width of content area
- Content flowing below image in readable column format

---

## 🛠️ Implementation

### 1. Add CSS Class Names to JSX

**File**: `src/components/pages/blog-detail.js`

**Add nested container structure**:

```javascript
render() {
  const {
    title,
    content,
    featured_image_url,
    blog_status
  } = this.state.blogItem;

  return (
    <div className="blog-container">
      <div className="content-container">
        <h1>{title}</h1>

        <div className="featured-image-wrapper">
          <img src={featured_image_url} />
        </div>

        <div className="content">
          {content}
        </div>
      </div>
    </div>
  );
}
```

### 2. Create Blog SCSS File

**Create file**: `src/style/blog.scss`

### 3. Import in Main SCSS

**File**: `src/style/main.scss`

**Add import at bottom**:

```scss
// ... existing imports
@import "./blog.scss";
```

### 4. Implement Blog Container Styles

**File**: `src/style/blog.scss`

```scss
.blog-container {
  display: flex;
  flex-direction: column;
  align-items: center;

  .content-container {
    display: flex;
    flex-direction: column;
    width: 800px;

    .featured-image-wrapper {
      img {
        margin: 15px 0px;
        width: 100%;
        height: 350px;
        border-radius: 5px;
        object-fit: cover;
      }
    }
  }
}
```

---

## 📚 Concepts

### Nested Container Architecture

**Why two containers?**:

```scss
.blog-container {
  // Page-level layout control
  display: flex;
  align-items: center;  // Centres content-container horizontally

  .content-container {
    // Content-specific width and organisation
    width: 800px;       // Fixed content width
  }
}
```

**Separation of concerns**:

- **blog-container** - handles page layout and centring
- **content-container** - handles content width and internal organisation
- **Reusability** - blog-container can be used on blog index page

### Flexbox Direction Strategy

**Column direction for vertical stacking**:

```scss
flex-direction: column;
```

**Why column instead of default row?**:

- **Default flexbox** - elements sit side by side horizontally
- **Column direction** - elements stack vertically
- **Blog post layout** - title → image → content vertically
- **Natural reading flow** - top to bottom content progression

### Featured Image Control

**Complete image control with CSS properties**:

```scss
img {
  margin: 15px 0px;    // Vertical spacing only
  width: 100%;         // Full width of content container
  height: 350px;       // Fixed height for consistency
  border-radius: 5px;  // Rounded corners
  object-fit: cover;   // Proper image scaling
}
```

### Object-fit: cover Explained

**Image scaling behaviour**:

```scss
object-fit: cover;
```

**What this accomplishes**:

- **Maintains aspect ratio** - no image distortion
- **Fills container completely** - no empty spaces
- **Centres image content** - crops from edges if needed
- **Universal appearance** - all images look consistent regardless of original dimensions
- **Professional presentation** - tall, wide, or square images all display uniformly

### Reusable CSS Architecture

**Planning for future use**:

```scss
.blog-container {
  // These styles will work for:
  // - Blog detail page (current)
  // - Blog index page (next guide)
  // - Any other blog-related pages
}
```

**Design system approach**:

- **Consistent spacing** - same margins and padding
- **Unified layout** - same centring logic
- **Maintainable code** - changes in one place affect all blog pages

### Width Control Strategy

**800px content width reasoning**:

```scss
width: 800px;
```

**Why this specific width**:

- **Readable line length** - optimal for text readability
- **Professional blog standard** - common width on many blog platforms
- **Not too narrow** - allows for good image presentation
- **Not too wide** - prevents text from being hard to follow
- **Responsive consideration** - good base width for desktop

---

## ✋ Verification

### Visual Layout Testing

**Expected result after styling**:

1. **Centred content** - blog post centred on page
2. **Proper title display** - H1 at top of content area
3. **Styled featured image**:
   - Full width of content container
   - 350px height consistently
   - Rounded corners (5px border-radius)
   - Proper scaling with object-fit: cover
4. **Content below image** - text content flowing after image

### Browser Testing Steps

**Manual verification**:

1. **Navigate to any blog detail** - click blog title from /blog page
2. **Verify centred layout** - content should be centred horizontally
3. **Check image scaling** - image should fill container width properly
4. **Test different blog posts** - all should have consistent image sizing
5. **Verify responsiveness** - layout maintains centre alignment

### DevTools CSS Verification

**Inspect applied styles**:

1. **Right-click blog content** → Inspect

2. **Verify class structure**:
   
   ```html
   <div class="blog-container">
     <div class="content-container">
       <h1>Blog Title</h1>
       <div class="featured-image-wrapper">
         <img src="...">
       </div>
       <div class="content">Content...</div>
     </div>
   </div>
   ```

3. **Check computed styles** - flexbox properties applied correctly

4. **Verify image styles** - all image properties applied

### Content Width Measurement

**Verify 800px container width**:

- **DevTools ruler** - measure content-container width
- **Should show 800px** in DevTools computed styles
- **Content properly contained** within this width

---

## 🎨 Content Display Considerations

### HTML Content in Blog Posts

**Current content display issue**:

```html
<!-- Content field contains raw HTML -->
<div class="content">
  <p>This is content with <strong>HTML tags</strong></p>
  <img src="embedded-image.jpg" alt="Example">
</div>
```

**Expected behaviour at this stage**:

- **Raw HTML tags visible** - will show `<p>`, `<strong>`, etc. as text
- **No HTML rendering** - tags displayed literally
- **Horizontal scrolling** - long HTML strings may cause overflow
- **Future enhancement needed** - rich text editor integration will fix this

### Performance Considerations

**Image loading behaviour**:

- **Natural image sizes** - images load at original resolution then scale
- **object-fit: cover** - may crop images but maintains performance
- **No lazy loading** - images load immediately (could be optimised later)
- **Consistent sizing** - prevents layout shift as images load

---

