# 09-101: Create Form Input Mixin

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-form-input-mixin)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 2728819eeebe621fafec71b74c12829fd892465e](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/2728819eeebe621fafec71b74c12829fd892465e)

---

## 🎯 Objectives

**Create reusable input styling system**:

- **SCSS Mixin for inputs** - reusable template for form fields
- **Portfolio form styling** - improve appearance of form elements
- **Cross-component usage** - same styling in auth forms and portfolio forms
- **Professional input design** - bottom border, focus states, transitions
- **Grid layout for form** - organise inputs with CSS Grid

**Development philosophy**:

- Mixing design tasks with feature development for productivity
- Break complex tasks with easier styling improvements
- Reusable patterns that scale across application

---

## 🛠️ Implementation

### 1. Restructure Portfolio Form JSX

**File**: `src/components/portfolio/portfolio-form.js`

**Simplify form wrapper (remove extra div)**:

```javascript
render() {
  return (
    <form className="portfolio-form-wrapper" onSubmit={this.handleSubmit}>
      <div>
        <input
          type="text"
          name="name"
          placeholder="Portfolio Item Name"
          value={this.state.name}
          onChange={this.handleChange}
        />

        <input
          type="text"
          name="url"
          placeholder="URL"
          value={this.state.url}
          onChange={this.handleChange}
        />
      </div>

      <div>
        <input
          type="text"
          name="position"
          placeholder="Position"
          value={this.state.position}
          onChange={this.handleChange}
        />

        <select 
          name="category"
          value={this.state.category}
          onChange={this.handleChange}
        >
          <option value="eCommerce">eCommerce</option>
          <option value="Scheduling">Scheduling</option>
          <option value="Enterprise">Enterprise</option>
        </select>
      </div>

      <div>
        <textarea
          name="description"
          placeholder="Description"  
          value={this.state.description}
          onChange={this.handleChange}
        />
      </div>

      <div className="image-uploaders">
        {/* ... existing dropzone components ... */}
      </div>

      <div>
        <button type="submit">Save</button>
      </div>
    </form>
  );
}
```

### 2. Create Portfolio Form SCSS File

**Create**: `src/style/portfolio-form.scss`

**Base grid layout**:

```scss
.portfolio-form-wrapper {
  display: grid;
  grid-template-columns: 1fr;
  padding: 42px;
}
```

### 3. Update Main SCSS Imports

**File**: `src/style/main.scss`

**Add new import**:

```scss
@import "./variables.scss";
@import "./mixins.scss";
@import "./base.scss";
@import "./navigation.scss";
@import "./portfolio.scss";
@import "./portfolio-manager.scss";
@import "./portfolio-form.scss";
@import "./button.scss";
```

### 4. Create Input Element Mixin

**File**: `src/style/mixins.scss`

**Add new mixin after button mixin**:

```scss
@mixin input-element {
  input {
    font-family: "Titillium Web", sans-serif;
    color: $charcoal;
    padding: 5px 0px;
    width: 100%;
    border-top: 0px;
    border-right: 0px;
    border-left: 0px;
    border-bottom: 1px solid $teal;
    background-color: transparent;
    transition: 0.5s all ease-in-out;
    font-size: 1.1em;
    margin-bottom: 21px;

    &:focus {
      outline: none;
      border-bottom: 1px solid $dark-teal;
    }
  }
}
```

### 5. Apply Mixin in Portfolio Form

**File**: `src/style/portfolio-form.scss`

**Implement mixin**:

```scss
.portfolio-form-wrapper {
  display: grid;
  grid-template-columns: 1fr;
  padding: 42px;

  @include input-element();
}
```

---

## 📚 Concepts

### SCSS Mixin Architecture

**Mixin definition pattern**:

```scss
@mixin mixin-name {
  selector {
    property: value;
    property: value;
  }
}
```

**Mixin usage pattern**:

```scss
.component-wrapper {
  @include mixin-name();
}
```

### Input Styling Strategy

**Professional input design elements**:

```scss
input {
  border-top: 0px;     // Remove top border
  border-right: 0px;   // Remove right border  
  border-left: 0px;    // Remove left border
  border-bottom: 1px solid $teal;  // Only bottom border (underline effect)
  background-color: transparent;   // No background (adapts to any bg)
}
```

**Focus state enhancement**:

```scss
&:focus {
  outline: none;                        // Remove ugly default outline
  border-bottom: 1px solid $dark-teal;  // Darker underline on focus
}
```

### Font and Typography

**Typography improvements**:

```scss
font-family: "Titillium Web", sans-serif;  // Custom font from index.html
color: $charcoal;                          // Consistent text colour
font-size: 1.1em;                          // Slightly larger than default
```

**Spacing and layout**:

```scss
padding: 5px 0px;      // Vertical padding only (no horizontal)
width: 100%;           // Full width of container
margin-bottom: 21px;   // Consistent spacing between inputs
```

### Transition Effects

**Smooth interactions**:

```scss
transition: 0.5s all ease-in-out;
```

**What this achieves**:

- **Smooth colour change** on focus state
- **Professional feel** - no jarring state changes
- **Subtle animation** - enhanced user experience

### Grid Layout for Forms

**Why CSS Grid for forms**:

```scss
.portfolio-form-wrapper {
  display: grid;
  grid-template-columns: 1fr;  // Single column initially
  padding: 42px;               // Comfortable spacing
}
```

**Future extensibility**:

- **Easy to modify** - change to multi-column layout
- **Responsive ready** - can add breakpoints
- **Consistent spacing** - grid handles alignment

### Mixin vs Component Styles

**When to use mixins**:

✅ **Styles repeated across multiple components**
✅ **Form inputs appear in various forms** (auth, portfolio, blog)
✅ **Design system consistency** needed

**When to use component-specific styles**:

✅ **Unique styling** for one component only
✅ **Layout-specific** arrangements
✅ **Component behaviour** styling

---

## ✋ Verification

### Visual Design Improvements

**Before styling**:

- **Default HTML inputs** - ugly browser styling
- **White backgrounds** - no custom design
- **Standard borders** - thick, dark borders around inputs
- **Poor focus states** - ugly default browser outline

**After styling**:

- ✅ **Clean underlines** - teal bottom border only
- ✅ **Transparent backgrounds** - adapts to any background colour
- ✅ **Professional focus state** - dark teal underline, no outline
- ✅ **Custom typography** - Titillium Web font, larger size
- ✅ **Smooth transitions** - elegant colour changes

### Form Layout Testing

**Grid verification**:

1. **Navigate to portfolio-manager** page
2. **Inspect form** - should have padding and grid layout
3. **Verify spacing** - consistent spacing between inputs
4. **Check alignment** - inputs full width of container

### Input Behaviour Testing

**Interactive verification**:

1. **Click input field** - focus state triggers
2. **Verify colour change** - teal to dark-teal transition
3. **Check outline removal** - no ugly browser outline
4. **Test smooth transition** - colour changes smoothly (0.5s)

### Cross-Browser Compatibility

**Browser testing checklist**:

- ✅ **Chrome** - transitions work smoothly
- ✅ **Firefox** - outline removal effective
- ✅ **Safari** - font family loads correctly
- ✅ **Edge** - transparent background renders properly

### Responsive Behaviour

**Layout adaptation**:

1. **Resize browser window** - inputs adapt to container width
2. **Mobile viewport** - form remains usable
3. **Padding consistency** - 42px padding maintained
4. **Typography scales** - readable at all sizes

---
