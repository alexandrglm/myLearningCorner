# 09-102: Implement Custom Select and Textarea Styles

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-implement-custom-select-and-textarea-styles)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 5e906b66ac8e57b44c7fb258e22c2a5ba6b534fb](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/5e906b66ac8e57b44c7fb258e22c2a5ba6b534fb)

---

## 🎯 Objectives

**Complete styling of remaining form elements**:

- **Global forms stylesheet** - styles that apply app-wide
- **Textarea styling** - professional appearance with borders and padding
- **Select element styling** - custom dropdown appearance
- **Proper import order** - forms after base for override capability
- **Global element targeting** - styling HTML elements directly

**Why not mixins for these elements?**:

- **Limited reuse** - textarea and select appear less frequently
- **Global consistency** - all textareas should look the same
- **Simple maintenance** - direct styles easier to modify

---

## 🛠️ Implementation

### 1. Create Forms Stylesheet

**Create**: `src/style/forms.scss`

**Global textarea styling**:

```scss
textarea {
  border: 1px solid $teal;
  background-color: transparent;
  font-size: 1rem;
  height: 100px;
  outline: none;
  padding: 10px;
}

.select-element {
  border: 1px solid #ccc;
  font-size: 0.8rem;
  width: 100%;
  border-radius: 3px;
  overflow: hidden;
  background-color: transparent;
  outline: none;
}
```

### 2. Update Main SCSS Import Order

**File**: `src/style/main.scss`

**Add forms after base**:

```scss
@import "./variables.scss";
@import "./mixins.scss";
@import "./base.scss";
@import "./forms.scss";
@import "./button.scss";
@import "./navigation.scss";
@import "./portfolio.scss";
@import "./portfolio-manager.scss";
@import "./portfolio-form.scss";
@import "./portfolio-sidebar.scss";
@import "./auth.scss";
```

### 3. Add className to Select Element

**File**: `src/components/portfolio/portfolio-form.js`

**Update select with className**:

```javascript
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
```

---

## 📚 Concepts

### Global vs Component-Specific Styling

**Global element styling**:

```scss
// Targets ALL textarea elements in application
textarea {
  border: 1px solid $teal;
  // ... other styles
}
```

**Component-specific styling**:

```scss
// Only targets elements with this class
.select-element {
  border: 1px solid #ccc;
  // ... other styles
}
```

### When to Use Global Element Targeting

**✅ Appropriate for global targeting**:

- **Textarea** - limited usage, consistent design needed
- **Body, html** - foundational elements
- **Form elements** - when design system requires consistency

**❌ Avoid global targeting**:

- **Div, span** - too generic, used everywhere
- **Components** - use classes for component-specific elements
- **Layout elements** - might interfere with third-party libraries

### Import Order Strategy

**Strategic placement of forms.scss**:

```scss
@import "./base.scss";      // Foundation styles
@import "./forms.scss";     // Form elements (can override base)
@import "./navigation.scss"; // Components (can override forms if needed)
```

**Why this order matters**:

- **Base styles first** - foundational rules
- **Forms after base** - can establish form-specific defaults
- **Components last** - can override global form styles if needed

### Colour Strategy for Form Elements

**Textarea colour choice**:

```scss
border: 1px solid $teal;  // Consistent with brand colours
```

**Select colour choice**:

```scss
border: 1px solid #ccc;   // Neutral grey for less emphasis
```

**Why different colours**:

- **Textarea** - content creation element, more prominent
- **Select** - choice element, more subtle
- **Visual hierarchy** - different importance levels

### Typography and Sizing

**Textarea typography**:

```scss
font-size: 1rem;    // Standard readable size
height: 100px;      // Adequate space for descriptions
padding: 10px;      // Comfortable input area
```

**Select typography**:

```scss
font-size: 0.8rem;  // Slightly smaller for dropdown options
width: 100%;        // Full container width
border-radius: 3px; // Subtle rounded corners
```

### Background Transparency Benefits

**Why transparent backgrounds**:

```scss
background-color: transparent;
```

**Advantages**:

- **Adapts to any background** - form can be placed anywhere
- **Consistent appearance** - no white boxes that clash
- **Professional look** - cleaner, more modern design
- **Flexible theming** - background colour comes from container

---

## ✋ Verification

### Visual Improvements Testing

**Before styling**:

- **Default HTML appearance** - ugly browser defaults
- **Inconsistent sizing** - elements different heights
- **Poor focus states** - browser default outlines
- **No visual cohesion** - elements don't match design

**After styling**:

- ✅ **Professional textarea** - teal border, proper padding
- ✅ **Styled select dropdown** - rounded corners, proper sizing
- ✅ **Consistent outline removal** - no ugly focus outlines
- ✅ **Transparent backgrounds** - adapts to form background
- ✅ **Proper typography** - readable font sizes

### Form Element Testing

**Textarea verification**:

1. **Click on textarea** - should focus without ugly outline
2. **Type content** - comfortable padding and sizing
3. **Check border** - teal colour consistent with brand
4. **Verify height** - 100px adequate for content

**Select verification**:

1. **Click dropdown** - should open smoothly
2. **Check appearance** - rounded corners, proper border
3. **Verify options** - readable text size
4. **Test selection** - values update correctly

### Cross-Component Consistency

**Global textarea behaviour**:

- **Portfolio form** - styled consistently
- **Future blog forms** - will inherit same styling
- **Auth forms** - any textareas use same design
- **Consistency maintained** - no component-specific overrides needed

### Import Order Verification

**Debugging stylesheet order**:

1. **Inspect element** on textarea
2. **Check computed styles** - verify forms.scss styles applied
3. **Look for overrides** - ensure no conflicts with other stylesheets
4. **Test precedence** - later imports can override if needed

---
