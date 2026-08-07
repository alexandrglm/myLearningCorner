# 08-086 - Creating Portfolio Form and Calling from Parent Component

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-portfolio-form-calling-parent-component)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 7346747b54e53c42fbbb60e8e5aaf9c5d75e511a](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/7346747b54e53c42fbbb60e8e5aaf9c5d75e511a)

---

## 🎯 OBJECTIVES

**Configure base architecture for form**:

- **Portfolio Form component** as class component 
- **Handler functions** in parent for success/error
- **Props pattern** for parent-child communication
- **TODO structure** for incremental development
- **Traffic conductor pattern** - PortfolioManager coordinates

**Expected behaviour**:

- Form submission → update portfolioItems state
- New item automatically added to top of sidebar
- Error handling established

---

## 🛠️ IMPLEMENTATION

### Create Portfolio Form Component

**File**: `src/components/portfolio/portfolio-form.js`

```javascript
import React, { Component } from "react";

export default class PortfolioForm extends Component {
  render() {
    return (
      <div>
        <h1>PortfolioForm</h1>
        <h1>PortfolioForm</h1>
      </div>
    );
  }
}
```

### Create Handler Functions in Portfolio Manager

**File**: `src/components/pages/portfolio-manager.js`

```javascript
import React, { Component } from "react";
import axios from "axios";
import PortfolioSidebarList from "../portfolio/portfolio-sidebar-list";
import PortfolioForm from "../portfolio/portfolio-form";

export default class PortfolioManager extends Component {
  constructor() {
    super();

    this.state = {
      portfolioItems: []
    };

    this.handleSuccessfulFormSubmission = this.handleSuccessfulFormSubmission.bind(this);
    this.handleFormSubmissionError = this.handleFormSubmissionError.bind(this);
  }

  handleSuccessfulFormSubmission(portfolioItem) {
    // TODO: update the portfolioItems state
    // and add the portfolioItem to the list
  }

  handleFormSubmissionError(error) {
    console.log("handleFormSubmissionError error", error);
  }

  getPortfolioItems() {
    axios.get("https://jordan.devcamp.space/portfolio/portfolio_items", {
      withCredentials: true
    }).then(response => {
      this.setState({
        portfolioItems: [...response.data.portfolio_items]
      });
    }).catch(error => {
      console.log("error in getPortfolioItems", error);
    });
  }

  componentDidMount() {
    this.getPortfolioItems();
  }

  render() {
    return (
      <div className="portfolio-manager-wrapper">
        <div className="left-column">
          <PortfolioForm 
            handleSuccessfulFormSubmission={this.handleSuccessfulFormSubmission}
            handleFormSubmissionError={this.handleFormSubmissionError}
          />
        </div>

        <div className="right-column">
          <PortfolioSidebarList data={this.state.portfolioItems} />
        </div>
      </div>
    );
  }
}
```

---

## 🔧 CONCEPTS

### Traffic Conductor Pattern

**Portfolio Manager as coordinator**:

```javascript
// Doesn't do heavy work, coordinates other components
// PortfolioForm → handles form submission
// PortfolioSidebarList → renders list
// PortfolioManager → coordinates communication between them
```

**Separated responsibilities**:

- **PortfolioForm**: Handles form input, validation, submission
- **PortfolioSidebarList**: Renders list of items
- **PortfolioManager**: Coordinates state updates between components

### Function Props Pattern

**Parent → Child communication**:

```javascript
// Parent defines handlers
handleSuccessfulFormSubmission(portfolioItem) {
  // Update parent state
}

// Parent passes functions as props
<PortfolioForm 
  handleSuccessfulFormSubmission={this.handleSuccessfulFormSubmission}
/>

// Child uses functions when needed
this.props.handleSuccessfulFormSubmission(newItem);
```

### Why Class Component for Form

**Forms require state management**:

```javascript
// Form will need state for:
// - Input values (controlled components)
// - Validation errors
// - Loading states
// - Form data object
```

**Rule of thumb**:

- **Forms with state** → Class components
- **Presentational components** → Functional components

### TODO Development Pattern

**Incremental development strategy**:

```javascript
handleSuccessfulFormSubmission(portfolioItem) {
  // TODO: update the portfolioItems state
  // and add the portfolioItem to the list
}
```

**Benefits**:

- **Prevents procrastination** - small chunks
- **Prevents bugs** - don't do everything at once
- **Easy tracking** - search "TODO" in codebase
- **Planning tool** - notes for next steps

### Binding Functions in Constructor

**Why binding necessary**:

```javascript
// Without binding → this is undefined in event handlers
// With binding → this points to component instance

this.handleSuccessfulFormSubmission = this.handleSuccessfulFormSubmission.bind(this);
```

**Alternative with arrow functions**:

```javascript
// Arrow functions auto-bind this
handleSuccessfulFormSubmission = (portfolioItem) => {
  // this automatically available
}
```

---

## ✔️ VERIFICATION

### Testing Component Integration

**Verify in browser**:

1. **Navigate to** `/portfolio-manager`
2. **See left column** with "PortfolioForm" h1 tags
3. **See right column** with portfolio sidebar list
4. **Confirm** both components rendering

### React DevTools Inspection

**Verify props passing**:

1. **Open React DevTools**
2. **Select PortfolioForm** component
3. **View props**: `handleSuccessfulFormSubmission`, `handleFormSubmissionError`
4. **Confirm functions** passed correctly

### Expected Behaviour Setup

**Foundation established for**:

- **Form submission** → call parent handler
- **Success case** → update portfolioItems state → sidebar updates
- **Error case** → console log error details
- **State management** → single source of truth in parent

### Development Workflow Demonstrated

1. **Small chunks** - only create component and setup
2. **TODO planning** - placeholder logic with comments
3. **Function signatures** - define interfaces before implementation
4. **Incremental testing** - verify each step working

---

