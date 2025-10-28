# 08-083 - Populating Portfolio Manager State with API Call Data

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/populating-portfolio-manager-state-api-call-data)**

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/53b6db71f3fa2364c2400581493d69e23feb9fd6)

---

## 🎯 OBJECTIVES

**Implement complete API call in Portfolio Manager**:

- **Constructor with initial state** for portfolioItems
- **getPortfolioItems()** method for API call
- **componentDidMount()** lifecycle hook
- **setState with spread operator** to update state
- **React DevTools verification** of populated state

**Review of already-seen concepts**:

- Reinforce API calls, state management, lifecycle hooks
- Same functionality as homepage but in new component

---

## 🛠️ IMPLEMENTATION

### Constructor with Initial State

**File**: `src/components/pages/portfolio-manager.js`

```javascript
import React, { Component } from "react";
import axios from "axios";

export default class PortfolioManager extends Component {
  constructor() {
    super();

    this.state = {
      portfolioItems: []
    };
  }

  render() {
    return (
      <div className="portfolio-manager-wrapper">
        <div className="left-column">
          <h1>Portfolio form....</h1>
        </div>

        <div className="right-column">
          <h1>Portfolio sidebar....</h1>
        </div>
      </div>
    );
  }
}
```

### getPortfolioItems Method

**Add after constructor**:

```javascript
getPortfolioItems() {
  axios.get("https://jordan.devcamp.space/portfolio/portfolio_items", {
    withCredentials: true
  }).then(response => {
    console.log("response from get portfolio items", response);
  }).catch(error => {
    console.log("error in getPortfolioItems", error);
  });
}
```

### componentDidMount Lifecycle Hook

**Add componentDidMount method**:

```javascript
componentDidMount() {
  this.getPortfolioItems();
}
```

### Update State with API Data

**Modify .then() to update state**:

```javascript
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
```

---

## 🔧 CONCEPTS

### Why Spread Operator

**Problem without spread operator**:

```javascript
// ❌ This would create nested array
portfolioItems: response.data.portfolio_items
// Result: [ [item1, item2, item3...] ] - array within array
```

**Solution with spread operator**:

```javascript
// ✅ This unpacks the array
portfolioItems: [...response.data.portfolio_items]
// Result: [item1, item2, item3...] - flat array
```

### componentDidMount vs render

**Why componentDidMount**:

- **Executes ONCE** after first render
- **Perfect timing** for API calls
- **Doesn't interfere** with initial render
- **Standard pattern** for data fetching

**Problem with render**:

- **Executes multiple times** (each setState)
- **Repeated API calls** unnecessary
- **Serious performance** issues

### withCredentials in Axios

**What it does**:

```javascript
{
  withCredentials: true
}
```

- **Includes cookies** in request
- **Authentication** with DevCamp Space
- **CORS handling** for cross-origin requests
- **Necessary** for APIs requiring auth

### Error Handling Pattern

**Why specific message in catch**:

```javascript
console.log("error in getPortfolioItems", error);
```

**Reason**:

- **Multiple catch statements** in application
- **Identify origin** of error quickly
- **More efficient debugging** with specific messages

---

## ✔️ VERIFICATION

### Testing API Call

**Verification steps**:

1. **Navigate to** `/portfolio-manager`
2. **Open DevTools** → Console
3. **Verify console.log** with response data
4. **Expand response.data.portfolio_items** 
5. **Confirm array** with portfolio items

### Verification with React DevTools

**State inspection**:

1. **Open React DevTools**
2. **Use selector** to click on portfolio form area
3. **Locate PortfolioManager** component
4. **View state** in right panel
5. **Confirm portfolioItems** array populated
6. **Expand items** to see complete structure

### Expected State Structure

**Should appear in React DevTools**:

```javascript
State:
  portfolioItems: Array(12)
    0: {id: 1, name: "Project 1", category: "eCommerce", ...}
    1: {id: 2, name: "Project 2", category: "Scheduling", ...}
    2: {id: 3, name: "Project 3", category: "Enterprise", ...}
    // ... up to 12 items (or however many in the API DevCamp Space)
```

### Data Available per Item

**Each portfolio item contains**:

- **id, name, description, url**
- **category, position** 
- **thumb_image_url, banner_image_url, logo_url**
- **created_at, updated_at**

---
