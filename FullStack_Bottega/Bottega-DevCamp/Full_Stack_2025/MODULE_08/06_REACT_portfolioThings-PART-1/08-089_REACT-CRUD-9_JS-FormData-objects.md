# 08-089 - Introduction to Building JavaScript FormData Objects

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-building-javascript-formdata-objects)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 27f39a4e77fe5daf4d72a7fd991bdac066dfe8f2](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/27f39a4e77fe5daf4d72a7fd991bdac066dfe8f2)

---

## 🎯 OBJECTIVES

**Understand and create FormData objects**:

- **Why FormData** vs regular objects
- **FormData constructor** and append method
- **API structure requirements** - portfolio_item[name] syntax
- **Debugging FormData** with for...of loop
- **Foundation for image uploads** next guide

**Key difference**:

- **Text values**: Regular object → JSON
- **Images + Text**: FormData object → multipart/form-data

---

## 🛠️ IMPLEMENTATION

### Create buildForm Method

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
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  buildForm() {
    let formData = new FormData();

    formData.append("portfolio_item[name]", this.state.name);
    formData.append("portfolio_item[description]", this.state.description);
    formData.append("portfolio_item[url]", this.state.url);
    formData.append("portfolio_item[category]", this.state.category);
    formData.append("portfolio_item[position]", this.state.position);

    return formData;
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handleSubmit(event) {
    event.preventDefault();
    this.buildForm();
  }

  render() {
    return (
      <div>
        <h1>PortfolioForm</h1>

        <form onSubmit={this.handleSubmit}>
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

### Why FormData vs Regular Objects

**Regular object approach** (works only for text):

```javascript
// Text values only - works with regular objects
const portfolioItem = {
  name: this.state.name,
  description: this.state.description,
  url: this.state.url
};
```

**FormData approach** (necessary for images):

```javascript
// Text + Images - requires FormData
let formData = new FormData();
formData.append("portfolio_item[name]", this.state.name);
formData.append("portfolio_item[image]", imageFile); // File object
```

**Why the difference**:

- **Images are binary data** - not JSON serialisable
- **APIs expect multipart/form-data** for file uploads
- **FormData handles encoding** automatically

### FormData Constructor and Methods

**Creating FormData object**:

```javascript
let formData = new FormData();  // Empty FormData object
```

**append() method**:

```javascript
formData.append(key, value);
// key: string - API expects this format
// value: string, number, File, Blob
```

**Other available methods**:

- `delete(key)` - remove key/value pair
- `get(key)` - retrieve value by key
- `getAll(key)` - get all values for key
- `has(key)` - check if key exists
- `set(key, value)` - set/overwrite value

### API Structure Requirements

**portfolio_item[name] syntax explained**:

```javascript
// API expects nested object structure:
{
  portfolio_item: {
    name: "Project Name",
    description: "Description",
    url: "https://example.com"
  }
}

// FormData bracket notation represents this nesting:
formData.append("portfolio_item[name]", "Project Name");
formData.append("portfolio_item[description]", "Description");
```

**Why bracket notation**:

- **Server-side parsing** - Rails/Laravel conventions
- **Nested object representation** in form data
- **Standard approach** for most modern APIs

### Debugging FormData Objects

**Special debugging required**:

```javascript
// ❌ This won't work - FormData is opaque
console.log(formData);

// ✅ Use for...of loop with .values()
for (let value of formData.values()) {
  console.log(value);
}

// ✅ Or iterate over entries for key-value pairs
for (let [key, value] of formData.entries()) {
  console.log(key, value);
}
```

**Why FormData is "opaque"**:

- **Performance optimisation** - binary data handling
- **Browser security** - prevent exposure of file contents
- **Standardised interface** - consistent across browsers

---

## ✔️ VERIFICATION

### Debugging FormData in Browser

**Using debugger statement**:

1. **Add debugger** in handleSubmit after buildForm call
2. **Fill form** with test data
3. **Click Save** - debugger pauses execution
4. **Open console** in DevTools
5. **Run debug loop**:
   
   ```javascript
   for (let value of formData.values()) {
     console.log(value);
   }
   ```

### Expected Console Output

**Form data values**:

```
Test Project Name
Test Description  
https://example.com
eCommerce
1
```

### Verification Steps

**Manual testing**:

1. **Fill form inputs** - name, description, url, category, position
2. **Open DevTools** → Console tab
3. **Add temporary debugger** in handleSubmit
4. **Click Save** button
5. **Execute debug loop** in console
6. **Verify values** appear correctly

### FormData Object Exploration

**In console during debugging**:

```javascript
// Explore FormData prototype
formData.__proto__

// Available methods
formData.append
formData.get
formData.delete
formData.entries
```

---
