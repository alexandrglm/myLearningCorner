# 09-141: Building Event Handlers for Blog Form

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-blog-form-event-handlers)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 7f240fed1246674b0b7a4b8a2fc2c59837453983](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/7f240fed1246674b0b7a4b8a2fc2c59837453983)

---

## 🎯 Objectives

**Implement complete form functionality with state management and parent communication**:

- **State management** - controlled components for form inputs
- **Event handlers** - handleChange and handleSubmit functionality
- **Parent-child communication** - pass form data up to BlogModal
- **Props function passing** - BlogModal provides callback to BlogForm
- **Form validation foundation** - structure ready for future enhancements
- **Real-time state updates** - dynamic input handling with single handler

**Goal**: Functional form with proper React patterns that passes data to parent component, preparing for API integration.

---

## 🛠️ Implementation

### 1. Add Success Handler in BlogModal

**File**: `src/components/modals/blog-modal.js`

**Add props function for BlogForm communication**:

```javascript
import React, { Component } from "react";
import ReactModal from "react-modal";
import BlogForm from "../blog/blog-form";

ReactModal.setAppElement(".app-wrapper");

export default class BlogModal extends Component {
  constructor(props) {
    super(props);

    this.customStyles = {
      content: {
        top: "50%",
        left: "50%", 
        right: "auto",
        marginRight: "-50%",
        transform: "translate(-50%, -50%)",
        width: "800px"
      },
      overlay: {
        backgroundColor: "rgba(1, 1, 1, 0.75)"
      }
    };

    this.handleSuccessfulFormSubmission = this.handleSuccessfulFormSubmission.bind(this);
  }

  handleSuccessfulFormSubmission(blog) {
    console.log("blog from blog form", blog);
  }

  render() {
    return (
      <ReactModal 
        style={this.customStyles}
        onRequestClose={() => {
          this.props.handleModalClose();
        }}
        isOpen={this.props.modalIsOpen}
      >
        <BlogForm 
          handleSuccessfulFormSubmission={this.handleSuccessfulFormSubmission}
        />
      </ReactModal>
    );
  }
}
```

### 2. Implement BlogForm State and Event Handlers

**File**: `src/components/blog/blog-form.js`

**Complete form functionality**:

```javascript
import React, { Component } from "react";

export default class BlogForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      title: "",
      blog_status: ""
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
    this.props.handleSuccessfulFormSubmission(this.state);
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit}>
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

        <button type="submit">Save</button>
      </form>
    );
  }
}
```

---

## 📖 Concepts

### Component Communication Pattern

**Data flow architecture**:

```javascript
// BlogForm (child) → BlogModal (middleware) → Blog (parent)

// Step 1: BlogForm collects form data
this.state = { title: "My Blog", blog_status: "draft" };

// Step 2: BlogForm calls props function
this.props.handleSuccessfulFormSubmission(this.state);

// Step 3: BlogModal receives data, logs it
handleSuccessfulFormSubmission(blog) {
  console.log("blog from blog form", blog);
  // Future: pass to parent Blog component
}
```

**Why this pattern**:

- **Separation of concerns** - each component has specific responsibility
- **Reusable components** - BlogForm could be used in different contexts
- **Scalable architecture** - easy to add validation, API calls, etc.
- **Clear data flow** - unidirectional data flow pattern

### Dynamic State Updates with Single Handler

**handleChange implementation**:

```javascript
handleChange(event) {
  this.setState({
    [event.target.name]: event.target.value
  });
}
```

**How it works**:

- **event.target.name** - input's name attribute ("title" or "blog_status")
- **Square brackets** - JavaScript computed property syntax
- **Dynamic key assignment** - one handler updates any form field
- **Scalable approach** - adding new fields only requires input element

**Example flow**:

```javascript
// User types "My Blog" in title input
// event.target.name = "title"
// event.target.value = "My Blog"
// setState({ [title]: "My Blog" }) → setState({ title: "My Blog" })
```

### Controlled Components Pattern

**Complete controlled component setup**:

```javascript
<input 
  type="text"
  onChange={this.handleChange}  // Updates state when typing
  name="title"                  // Identifies which state field
  placeholder="Blog Title"      // User guidance
  value={this.state.title}      // Single source of truth
/>
```

**Benefits**:

- **React owns data** - state is authoritative source
- **Predictable behaviour** - value always reflects state
- **Real-time validation** - can validate on every keystroke
- **Easy testing** - can set state directly for testing

### Form Submission Pattern

**preventDefault and callback**:

```javascript
handleSubmit(event) {
  this.props.handleSuccessfulFormSubmission(this.state);
  event.preventDefault();
}
```

**Key aspects**:

1. **Call parent callback** - pass current state up
2. **Prevent default** - stop browser form submission
3. **Pass complete state** - all form data available to parent
4. **Future extensibility** - can add validation, API calls here

### Props Function Pattern

**Passing functions as props**:

```javascript
// Parent defines function
handleSuccessfulFormSubmission(blog) {
  console.log("blog from blog form", blog);
}

// Parent passes to child
<BlogForm 
  handleSuccessfulFormSubmission={this.handleSuccessfulFormSubmission}
/>

// Child calls function
this.props.handleSuccessfulFormSubmission(this.state);
```

**Why this pattern**:

- **Inversion of control** - child doesn't know what happens to data
- **Flexibility** - parent can decide what to do with form data
- **Testability** - can pass mock functions for testing
- **Reusability** - same form, different parent behaviours

### State Structure Design

**Blog-specific state fields**:

```javascript
this.state = {
  title: "",        // Blog post title
  blog_status: ""   // "draft", "published", etc.
};
```

**Future expansion ready**:

```javascript
// Coming in future guides
this.state = {
  title: "",
  blog_status: "",
  content: "",           // Rich text editor content
  featured_image: ""     // Image upload
};
```

---

## ✅ Verification

### 1. Props Communication Testing

**Verify parent-child communication**:

1. **Open modal** - click "Open Modal!" link
2. **Open browser console** - DevTools → Console
3. **Fill form fields**:
   - Title: "Test Blog Post"
   - Status: "draft"
4. **Click Save button**
5. **Check console output**: 
   
   ```
   blog from blog form {title: "Test Blog Post", blog_status: "draft"}
   ```

### 2. State Management Verification

**React DevTools state inspection**:

1. **Open React DevTools** → Components
2. **Navigate to BlogForm component**
3. **Check initial state**:
   - `title: ""`
   - `blog_status: ""`
4. **Type in inputs** - watch state update real-time
5. **State should reflect** input values exactly

### 3. Form Behaviour Testing

**Controlled components verification**:

1. **Type in title field** - text should appear
2. **Type in status field** - text should appear  
3. **Clear inputs manually** - should remain empty (controlled)
4. **Submit form** - should not refresh page
5. **Form data logged** - console shows current state

### 4. Event Handler Testing

**Individual handler verification**:

**handleChange testing**:

- Type in any input → state updates immediately
- Multiple inputs → each updates correct state field
- Real-time updates → no delay between typing and state

**handleSubmit testing**:

- Click save → function executes
- Props function called → parent receives data
- No page refresh → preventDefault working

### 5. Integration Testing

**Full component chain**:

1. **Blog component** manages modal visibility
2. **BlogModal** renders form and handles communication
3. **BlogForm** collects data and calls parent function
4. **Data flows upward** - BlogForm → BlogModal → (future: Blog)

---

## 🎨 Development Patterns Demonstrated

### Incremental Development

**Building complexity gradually**:

1. **Basic structure** (previous guide) - form renders
2. **State management** (this guide) - controlled inputs
3. **Parent communication** (this guide) - data flow
4. **Future: API integration** - real blog creation
5. **Future: Validation** - error handling
6. **Future: Rich text** - advanced content editing

### React Best Practices

**Patterns demonstrated**:

- ✓ **Controlled components** - React manages form state
- ✓ **Single responsibility** - each component has clear purpose
- ✓ **Unidirectional data flow** - child → parent communication
- ✓ **Function props** - flexible parent-child interaction
- ✓ **Dynamic state updates** - scalable form handling

### Component Architecture

**Clean separation of concerns**:

```
BlogForm:
- Form state management
- User input handling
- Data collection

BlogModal: 
- Presentation layer
- Props passing
- Communication bridge

Blog:
- Modal visibility
- Future: Blog list management
- Future: API orchestration
```

---
