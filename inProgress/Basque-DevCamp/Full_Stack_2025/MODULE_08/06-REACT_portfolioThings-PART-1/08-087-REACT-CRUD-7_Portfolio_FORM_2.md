# 08-087 - Building Initial Portfolio Form Elements

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-initial-portfolio-form-elements)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 87dc6b45463d4fddef056de7fc8f42230126d5f4](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/87dc6b45463d4fddef056de7fc8f42230126d5f4)

---

## 🎯 OBJECTIVES

**Create complete form with state management**:

- **Constructor with state** for all form fields
- **Form elements** complete with placeholders
- **handleChange binding** prepared
- **Form layout** structured with wrapper divs
- **Placeholder handler** to avoid errors

**Form elements**:

- name, description, url, category, position
- Prepared for select dropdown and textarea
- Ready for image upload (next guide)

---

## 🛠️ IMPLEMENTATION

### Constructor with Complete State

**File**: `src/components/portfolio/portfolio-form.js`

```javascript
import React, { Component } from "react";

export default class PortfolioForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      name: "",
      description: "",
      category: "",
      position: "",
      url: "",
      thumb_image: "",
      banner_image: "",
      logo: ""
    };

    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event) {
    console.log("handle change", event);
  }

  render() {
    return (
      <div>
        <h1>PortfolioForm</h1>

        <form>
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

            <input
              type="text"
              name="category"
              placeholder="Category"
              value={this.state.category}
              onChange={this.handleChange}
            />
          </div>

          <div>
            <input
              type="text"
              name="description"
              placeholder="Description"
              value={this.state.description}
              onChange={this.handleChange}
            />
          </div>

          <div>
            <button type="submit">Save</button>
          </div>
        </form>
      </div>
    );
  }
}
```

---

## 🔧 CONCEPTS

### Controlled Components Pattern

**Each input is controlled component**:

```javascript
<input
  type="text"
  name="name"                    // Identifies field
  placeholder="Portfolio Item Name"  // UX guidance
  value={this.state.name}        // Single source of truth
  onChange={this.handleChange}   // Update mechanism
/>
```

**Why this pattern**:

- **Single source of truth** - state controls input value
- **Predictable behaviour** - React controls DOM
- **Validation ready** - easy access to current values
- **No DOM queries** - no need for querySelector

### State Structure Matching API

**State names identical to DevCamp Space API**:

```javascript
// These names MUST match API exactly
this.state = {
  name: "",        // → API field 'name'
  description: "", // → API field 'description'  
  category: "",    // → API field 'category'
  position: "",    // → API field 'position'
  url: "",         // → API field 'url'
  // Images for future guides
  thumb_image: "",
  banner_image: "",
  logo: ""
};
```

**Why exact matching important**:

- **handleChange function** will use name for lookup
- **API submission** direct mapping from state
- **No transformation needed** between form and API

### Form Layout Strategy

**Wrapper divs for future styling**:

```javascript
// Row 1: Name + URL (side by side)
<div>
  <input name="name" />
  <input name="url" />
</div>

// Row 2: Position + Category (side by side)  
<div>
  <input name="position" />
  <input name="category" />
</div>

// Row 3: Description (full width)
<div>
  <input name="description" />
</div>

// Row 4: Submit button
<div>
  <button type="submit">Save</button>
</div>
```

### Placeholder handleChange Function

**Why create before implementing**:

```javascript
handleChange(event) {
  console.log("handle change", event);
}
```

**Reasoning**:

- **Avoid errors** - onChange references existing function
- **Development efficiency** - setup form structure first
- **Testing ready** - can verify events firing
- **Next guide focus** - implement actual logic

### Name Attribute Critical

**Name attribute MUST match state keys**:

```javascript
// ✅ Correct - matches state key exactly
<input name="name" value={this.state.name} />

// ❌ Wrong - doesn't match state
<input name="project_name" value={this.state.name} />
```

**handleChange depends on this**:

```javascript
// Future implementation will use:
const { name, value } = event.target;
this.setState({ [name]: value });
```

---

## ✔️ VERIFICATION

### Visual Form Testing

**Verify in browser**:

1. **Navigate to** `/portfolio-manager`
2. **See left column** with complete form
3. **Inputs visible**: name, url, position, category, description
4. **Save button** present
5. **Basic layout** - form elements organised

### React DevTools State Inspection

**Verify initial state**:

1. **Open React DevTools**
2. **Select PortfolioForm** component
3. **View state** - all fields with empty strings
4. **Confirm structure** matches expected state

### Event Handler Testing

**Console verification**:

1. **Open DevTools** → Console
2. **Type in any input**
3. **See console.log** "handle change" with event object
4. **Confirm** event firing for each input

### Props Verification

**Verify props passed from parent**:

1. **React DevTools** → PortfolioForm props
2. **Confirm**: `handleSuccessfulFormSubmission`, `handleFormSubmissionError`
3. **Functions available** for next guide

### Expected Issues (Normal)

**Current limitations (will be fixed)**:

- **No typing response** - inputs don't update visually
- **Form not functional** - submit button does nothing
- **Basic styling** - no CSS applied yet
- **Select dropdown** - category is text input temporarily

---

