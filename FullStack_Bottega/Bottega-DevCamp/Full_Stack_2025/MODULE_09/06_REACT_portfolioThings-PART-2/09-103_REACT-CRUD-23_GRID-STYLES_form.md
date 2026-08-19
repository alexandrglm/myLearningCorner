# 09-103: Build CSS Grid Styles for Portfolio Form

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-css-grid-styles-portfolio-form)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 0aa5cfeb07167a4f9642f4f5f0d9f367daecbb6d](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/0aa5cfeb07167a4f9642f4f5f0d9f367daecbb6d)

---

## 🎯 Objectives

**Create reusable CSS Grid system for layouts**:

- **Grid utility classes** - one-column, two-column, three-column
- **Reusable grid system** - applicable across multiple components
- **Portfolio form layout** - organise inputs in grid structure
- **Grid gap consistency** - uniform spacing between elements
- **Override mixin styles** - adjust margins when necessary

**Layout target for portfolio form**:

- Name + URL → two-column layout
- Position + Category → two-column layout  
- Description → one-column layout (full width)
- Image uploaders → three-column layout

---

## 🛠️ Implementation

### 1. Create Grid Utility Stylesheet

**Create**: `src/style/grid.scss`

**Grid utility classes**:

```scss
.one-column {
  display: grid;
  grid-template-columns: 1fr;
  grid-gap: 21px;
}

.two-column {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-gap: 21px;
}

.three-column {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-gap: 21px;
}
```

### 2. Add Grid Import to Main SCSS

**File**: `src/style/main.scss`

**Update import order**:

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
```

### 3. Apply Grid Classes to Portfolio Form JSX

**File**: `src/components/portfolio/portfolio-form.js`

**Add grid classes to div wrappers**:

```javascript
render() {
  return (
    <form className="portfolio-form-wrapper" onSubmit={this.handleSubmit}>
      <div className="two-column">
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

      <div className="two-column">
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
          className="select-element"
        >
          <option value="eCommerce">eCommerce</option>
          <option value="Scheduling">Scheduling</option>
          <option value="Enterprise">Enterprise</option>
        </select>
      </div>

      <div className="one-column">
        <textarea
          name="description"
          placeholder="Description"  
          value={this.state.description}
          onChange={this.handleChange}
        />
      </div>

      <div className="image-uploaders three-column">
        <DropzoneComponent 
          config={this.componentConfig()}
          djsConfig={this.djsConfig()}
          eventHandlers={this.handleThumbDrop()}
          ref={this.thumbRef}
        >
        </DropzoneComponent>

        <DropzoneComponent 
          config={this.componentConfig()}
          djsConfig={this.djsConfig()}
          eventHandlers={this.handleBannerDrop()}
          ref={this.bannerRef}
        >
        </DropzoneComponent>

        <DropzoneComponent 
          config={this.componentConfig()}
          djsConfig={this.djsConfig()}
          eventHandlers={this.handleLogoDrop()}
          ref={this.logoRef}
        >
        </DropzoneComponent>
      </div>

      <div>
        <button type="submit">Save</button>
      </div>
    </form>
  );
}
```

### 4. Add Grid Gap to Portfolio Form Wrapper

**File**: `src/style/portfolio-form.scss`

**Update wrapper with grid gap**:

```scss
.portfolio-form-wrapper {
  display: grid;
  grid-template-columns: 1fr;
  padding: 42px;
  grid-gap: 21px;

  @include input-element();

  input {
    margin-bottom: 0px;
  }
}
```

---

## 📚 Concepts

### Utility Class System

**Grid utility pattern**:

```scss
// Reusable classes for any component
.one-column   { grid-template-columns: 1fr; }
.two-column   { grid-template-columns: 1fr 1fr; }
.three-column { grid-template-columns: 1fr 1fr 1fr; }
```

**Benefits of utility classes**:

- **Reusability** - same classes across different components
- **Consistency** - same spacing (grid-gap) everywhere
- **Maintenance** - change once, applies everywhere
- **Scalability** - easy to add four-column, five-column, etc.

### Grid Gap Consistency

**21px grid gap standard**:

```scss
grid-gap: 21px;  // Consistent spacing across all grid layouts
```

**Why 21px**:

- **Divisible by 3 and 7** - works well for various layouts
- **Visually comfortable** - not too tight, not too loose
- **Matches other spacing** - consistent with existing padding/margins

### CSS Class Chaining

**Multiple classes on single element**:

```javascript
<div className="image-uploaders three-column">
```

**How it works**:

- **image-uploaders** - component-specific styling
- **three-column** - utility grid layout
- **Combined effect** - both sets of styles applied

### Mixin Override Pattern

**Problem identified**:

```scss
// Mixin adds margin-bottom to all inputs
@mixin input-element {
  input {
    margin-bottom: 21px;  // Too much space in grid layout
  }
}
```

**Override solution**:

```scss
.portfolio-form-wrapper {
  @include input-element();

  input {
    margin-bottom: 0px;  // Override mixin value
  }
}
```

**Why this works**:

- **CSS cascade** - later rules override earlier ones
- **Specificity** - same specificity, so order matters
- **Selective override** - only affects this component

### Grid Layout Strategy

**Form organisation logic**:

```
Name + URL        → two-column (related fields)
Position + Category → two-column (metadata fields)  
Description       → one-column (needs full width)
Image uploaders   → three-column (equal importance)
Submit button     → one-column (full width call-to-action)
```

---

## ✋ Verification

### Layout Structure Testing

**Visual verification**:

1. **Navigate to portfolio-manager** page
2. **Inspect form layout**:
   - ✅ **Name + URL** side by side
   - ✅ **Position + Category** side by side
   - ✅ **Description** full width
   - ✅ **Three image uploaders** equal columns

### Grid Gap Consistency

**Spacing verification**:

1. **Check vertical spacing** between form sections
2. **Check horizontal spacing** within two-column layouts
3. **Verify 21px consistency** across all gaps
4. **No irregular spacing** - clean, professional appearance

### Form Element Sizing

**Element behaviour**:

1. **Input widths** - should fill their grid columns completely
2. **Select dropdown** - should match input width
3. **Textarea** - should span full form width
4. **Image uploaders** - should be equal width

### Responsive Behaviour

**Grid adaptation**:

1. **Resize browser window** - elements adapt to container
2. **Grid maintains proportions** - 1fr 1fr stays equal
3. **No horizontal overflow** - content fits within viewport
4. **Clean wrapping** - professional appearance at all sizes

### Override Verification

**Margin bottom override**:

1. **Inspect input elements** in DevTools
2. **Check computed styles** - margin-bottom should be 0px
3. **Visual confirmation** - no extra space below inputs in grid
4. **Select field alignment** - should match input height

---

