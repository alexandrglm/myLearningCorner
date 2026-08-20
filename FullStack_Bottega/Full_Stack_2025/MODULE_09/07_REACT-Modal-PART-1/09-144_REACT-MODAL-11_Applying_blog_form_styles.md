# 09-144: Applying Styles to Blog Form

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/applying-blog-form-styles)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at c6f1e19c8bdc12e176f39ebce59a9392cfac55f8](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/c6f1e19c8bdc12e176f39ebce59a9392cfac55f8)

---

## 🎯 Objectives

**Create professional styling system for blog form using mixins and composition pattern**:

- **Improve form layout** - better structure than basic HTML inputs
- **Create dedicated stylesheet** - blog-specific form styles
- **Mixin composition** - reuse existing input and grid mixins
- **Component-specific customisation** - media queries and responsive behaviour prepared
- **Professional button styling** - consistent with portfolio form
- **Design break** - stepping back from technical complexity for visual improvements

**Design philosophy**: Create structured foundation before adding rich text editor and image uploaders to avoid messy layout.

---

## 🛠️ Implementation

### 1. Add Form Wrapper Class and Two-Column Layout

**File**: `src/components/blog/blog-form.js`

**Update form structure with CSS classes**:

```javascript
render() {
  return (
    <form onSubmit={this.handleSubmit} className="blog-form-wrapper">
      <div className="two-column">
        <input 
          type="text"
          onChange={this.handleChange}
          name="title"
          placeholder="Blog Title"
          value={this.state.title}
        />

        <input 
          type="text"
          onChange={this.handleChange}
          name="blog_status"
          placeholder="Blog status"
          value={this.state.blog_status}
        />
      </div>

      <button type="submit" className="btn">Save</button>
    </form>
  );
}
```

### 2. Create Blog Form Stylesheet

**Create file**: `src/style/blog-form.scss`

**Blog-specific form styling using mixins**:

```scss
.blog-form-wrapper {
  @include base-grid();
  grid-template-columns: 1fr;
  padding: 42px;

  @include input-element();

  input {
    margin-bottom: 0px;
  }
}
```

### 3. Import Blog Form Styles in Main SCSS

**File**: `src/style/main.scss`

**Add import at bottom of file**:

```scss
@import "./variables.scss";
@import "./mixins.scss";
@import "./base.scss";
@import "./forms.scss";
@import "./button.scss";
@import "./grid.scss";
@import "./navigation.scss";
@import "./portfolio.scss";
@import "./portfolio-manager.scss";
@import "./portfolio-form.scss";
@import "./portfolio-sidebar.scss";
@import "./auth.scss";
@import "./blog.scss";
@import "./loaders.scss";
@import "./blog-form.scss";
```

---

## 📖 Concepts

### Composition vs Inheritance Pattern

**Inheritance approach (traditional)**:

```scss
// Large base class with all features
.base-form {
  // 50+ lines of styles for every possible form need
  // Both portfolio AND blog forms inherit everything
}

.portfolio-form {
  @extend .base-form;  // Gets ALL base-form styles
}

.blog-form {
  @extend .base-form;  // Gets ALL base-form styles, many unused
}
```

**Composition approach (preferred)**:

```scss
// Small, focused mixins
@mixin base-grid() { ... }
@mixin input-element() { ... }

// Compose only what's needed
.blog-form-wrapper {
  @include base-grid();      // Only grid functionality
  @include input-element();  // Only input styling
  // Custom blog-specific styles
}

.portfolio-form-wrapper {
  @include base-grid();      // Same grid functionality
  @include input-element();  // Same input styling
  // Different custom portfolio-specific styles
}
```

### Benefits of Composition Pattern

**Flexibility**:

- **Mix and match** - only include what you need
- **Customisable** - add component-specific modifications
- **Maintainable** - changes to mixin affect all users
- **Testable** - each mixin can be tested independently

**Real-world application**:

- **React components** - compose functionality via props and composition
- **JavaScript modules** - import only needed functions
- **SCSS mixins** - combine style patterns flexibly

### Why Dedicated Stylesheet per Component

**Advantages of separate blog-form.scss**:

```scss
// Future: media queries specific to blog form
@media (max-width: 768px) {
  .blog-form-wrapper {
    padding: 20px;           // Different mobile padding than portfolio
    grid-template-columns: 1fr; // Different responsive behaviour
  }
}

// Future: blog-specific features
.blog-form-wrapper {
  .rich-text-editor {
    // Styles specific to blog rich text editing
  }

  .image-uploader {
    // Different image upload behaviour than portfolio
  }
}
```

### Mixin System Architecture

**Current mixin ecosystem**:

```scss
// From mixins.scss
@mixin base-grid() {
  display: grid;
  // Grid foundation
}

@mixin input-element() {
  input {
    // Professional input styling
    border-bottom: 1px solid $teal;
    // Focus states, transitions
  }
}

@mixin base-btn() {
  // Button styling
  background-color: $teal;
  // Hover effects, transitions
}
```

**Usage across components**:

- **Portfolio form** - uses all three mixins
- **Blog form** - uses all three mixins
- **Auth form** - could use input-element and base-btn
- **Consistent design** - same visual language

### CSS Grid Utility Classes

**Two-column layout**:

```scss
// From grid.scss
.two-column {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-gap: 21px;
}
```

**Benefits**:

- **Reusable layout** - any component can use two-column
- **Consistent spacing** - 21px gap across all grid layouts
- **Responsive ready** - easy to modify for mobile

---

## ✅ Verification

### 1. Visual Form Improvement

**Before styling**:

- ✗ **Basic HTML inputs** - default browser styling
- ✗ **No layout structure** - inputs stacked vertically
- ✗ **Ugly button** - default browser button styling
- ✗ **Poor spacing** - no consistent padding

**After styling**:

- ✓ **Professional inputs** - teal underlines, custom typography
- ✓ **Two-column layout** - title and status side-by-side
- ✓ **Styled button** - consistent with portfolio form
- ✓ **Proper spacing** - 42px padding, organised layout

### 2. Form Functionality Testing

**Complete workflow verification**:

1. **Open modal** - click "Open Modal!" link
2. **Visual improvements** - form should look professional
3. **Fill form**:
   - Title: "Test from styled modal"
   - Blog Status: "draft"
4. **Submit form** - should work identically to before
5. **Verify results**:
   - ✓ Modal closes
   - ✓ Form clears
   - ✓ New blog appears in list
   - ✓ Styling preserved

### 3. Responsive Layout Testing

**Two-column behaviour**:

- **Large screens** - title and status inputs side-by-side
- **Medium screens** - still side-by-side with appropriate spacing
- **Small screens** - may stack vertically (future media query enhancement)

### 4. Style Consistency Verification

**Cross-component consistency**:

1. **Navigate to portfolio-manager**
2. **Compare form styling** - inputs should look similar
3. **Button consistency** - Save buttons should match
4. **Layout patterns** - similar spacing and organisation

### 5. Mixin Integration Testing

**Verify mixin functionality**:

- **Input focus states** - teal to dark-teal transition
- **Button hover effects** - colour change on hover
- **Grid layout** - proper two-column arrangement
- **Typography** - Titillium Web font family

---

## 🎨 Design Philosophy Demonstration

### Breaking Up Technical Complexity

**Why design breaks are important**:

- **Mental refresh** - stepping back from complex logic
- **Visual progress** - tangible improvements visible immediately
- **Foundation building** - proper structure before adding complexity
- **User experience focus** - remember the end user experience

### Preparing for Future Features

**Structured foundation benefits**:

- **Rich text editor** - will fit cleanly in organised layout
- **Image uploaders** - won't create messy, scattered interface
- **Media queries** - responsive behaviour easier to implement
- **Component reuse** - clean patterns transferable to other forms

### Professional Development Workflow

**Pattern demonstrated**:

1. **Build functionality** - get features working
2. **Add structure** - organise and clean up code
3. **Apply styling** - make it look professional
4. **Add enhancements** - rich content, advanced features
5. **Optimise** - performance and responsive behaviour

### Composition Pattern in Practice

**Real-world transferable concept**:

- **React components** - compose features via props
- **JavaScript modules** - import specific functions
- **CSS frameworks** - utility classes (Tailwind, Bootstrap)
- **Software architecture** - microservices, modular design

---
