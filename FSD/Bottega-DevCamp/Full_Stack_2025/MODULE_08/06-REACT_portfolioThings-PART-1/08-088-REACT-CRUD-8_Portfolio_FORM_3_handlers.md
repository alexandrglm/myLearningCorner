# 08-088 - Implementing Handlers for Portfolio Form

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/implementing-portfolio-form-handlers)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 9ca0d3ffcb0d1223e7b12cf29f6841b17d388ea9](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/9ca0d3ffcb0d1223e7b12cf29f6841b17d388ea9)

---

## 🎯 OBJECTIVES

**Complete form functionality**:

- **handleChange** implementation with dynamic keys
- **handleSubmit** with preventDefault
- **Form submission** complete control
- **State updates** in real-time
- **Synthetic Event** understanding

**Two-step process**:

1. handleChange - for typing in inputs
2. handleSubmit - for form submission

---

## 🛠️ IMPLEMENTATION

### Implement handleChange Method

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

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handleSubmit(event) {
    console.log("event", event);
    event.preventDefault();
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

### Dynamic Object Keys with Event Target

**Syntax `[event.target.name]: event.target.value`**:

```javascript
handleChange(event) {
  this.setState({
    [event.target.name]: event.target.value
  });
}
```

**Why it works**:

- **event.target.name** returns string: "name", "url", "category", etc.
- **Square brackets** convert string to object key
- **Dynamic assignment** - one function handles all inputs
- **Scalable solution** - adding fields requires only new input

### Form Submission and preventDefault

**HTML default behaviour**:

```javascript
// Without preventDefault:
// - Complete page refresh
// - Form data in URL as query params  
// - Bad UX for SPAs
// - Loses React state
```

**React controlled behaviour**:

```javascript
handleSubmit(event) {
  event.preventDefault();  // Prevents page refresh
  // Custom form handling here
}
```

### Synthetic Events Explanation

**Why "Synthetic"**:

- **Virtual DOM** vs Real DOM
- **Performance optimisation** from React
- **Cross-browser compatibility** automatic
- **Same API** as native events but optimised

**Virtual DOM benefits**:

- **Faster re-renders** - only necessary updates
- **Memory efficient** - event object reuse
- **Predictable behaviour** - no browser quirks

### Method Binding Requirements

**Both handlers need binding**:

```javascript
constructor(props) {
  super(props);
  // ... state

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
}
```

**Why binding necessary**:

- **Event handlers** lose `this` context
- **Need access** to `this.setState` and `this.state`
- **Binding preserves** component instance reference

### Event Object Structure

**Debugging event properties**:

```javascript
handleChange(event) {
  console.log("Target:", event.target);        // Input element
  console.log("Name:", event.target.name);     // "name", "url", etc.
  console.log("Value:", event.target.value);   // User typed value
}
```

---

## ✔️ VERIFICATION

### Testing HandleChange

**Manual verification**:

1. **Type in any input** - characters should appear
2. **Open React DevTools** → PortfolioForm component
3. **Watch state updates** - real-time state changes
4. **Multiple inputs** - all working

### Testing HandleSubmit

**Form submission verification**:

1. **Open browser console**
2. **Click Save button** - without typing anything
3. **Verify console.log** - synthetic event object
4. **Check URL** - no query parameters added
5. **No page refresh** - stay on portfolio-manager route

### Expected vs Wrong Behaviour

**✅ Correct behaviour**:

- Type in input → characters appear
- Submit form → console log, no refresh
- URL stays clean → `/portfolio-manager`

**❌ Wrong behaviour (if missing onSubmit)**:

- Submit → URL gets query params: `?name=&url=&position=...`
- Page refresh → lose React state
- Poor UX → not SPA behaviour

### React DevTools State Inspection

**Verify real-time updates**:

1. **Select PortfolioForm** component
2. **Type "Test Project"** in name input
3. **Watch state.name** update to "Test Project"
4. **Type different inputs** - each updates corresponding state
5. **State persistence** - values maintained

---
