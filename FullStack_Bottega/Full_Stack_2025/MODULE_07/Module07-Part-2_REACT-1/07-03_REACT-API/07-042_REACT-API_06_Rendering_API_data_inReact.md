# 07-042 - How to Render API Data in React

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-render-api-data-react](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-render-api-data-react)

**Source Code**: [https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/147f1023cf62cfe1d3bc217ec4e9536bfab35892](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/147f1023cf62cfe1d3bc217ec4e9536bfab35892)

---

## 🎯 FUNDAMENTAL CONCEPTS

### The Defining Moment: API → State → UI

**Objectives of this guide**:

* **Replace hardcoded data** with real API data
* **Update the component state** using the server response
* **Render the new data** dynamically in the UI
* **Complete the flow**: API → State → UI

### React Lifecycle Hook: componentDidMount

**Why componentDidMount?**

* It runs **once** after the initial render
* It is the **perfect timing** for making API requests
* It does **not interfere with the first UI render**
* It is the **standard and recommended pattern** for fetching data in class components

**Difference from render():**

* `render()` may run **multiple times**
* `componentDidMount()` runs **only once**
* Prevents **repeated API calls** and performance issues

---

## 🔧 UNDERSTANDING API RESPONSE STRUCTURE

### Axios Response Object Structure

When Axios receives data, the response has this shape:

```javascript
{
  data: [ /* portfolio items array */ ],
  status: 200,
  statusText: 'OK',
  headers: {...},
  config: {...}
}
```

### Navigating the Response

```javascript
response          // Entire Axios response
  .data           // Data payload from the server
    [0]           // First portfolio item from the array
      .name       // Name of the portfolio item
      .url        // URL of the project
      .category   // Category type
```

### Professional API Data Investigation Workflow

1. **Log the entire response** using `console.log(response)`
2. **Expand the object** in DevTools to inspect structure
3. **Identify the path** to the desired data
4. **Use that path** when updating component state

---

## 🛠️ PRACTICAL IMPLEMENTATION STEPS

### 1. Remove Hardcoded Data

Before (hardcoded placeholder data):

```javascript
this.state = {
  pageTitle: "Welcome to my portfolio",
  isLoading: false,
  data: [
    { title: "Quip", category: "eCommerce" },
    { title: "Eventbrite", category: "Scheduling" },
    { title: "Ministry Safe", category: "Enterprise" },
    { title: "SwingAway", category: "eCommerce" }
  ]
};
```

After (empty array to be filled by API):

```javascript
this.state = {
  pageTitle: "Welcome to my portfolio",
  isLoading: false,
  data: []
};
```

### 2. Remove Unnecessary Binding

Remove this line from the constructor if `handleFilter` is no longer required:

```javascript
// REMOVE this
this.handleFilter = this.handleFilter.bind(this);
```

Keep only the binding for the method that will be called:

```javascript
this.getPortfolioItems = this.getPortfolioItems.bind(this);
```

### 3. Add componentDidMount()

```javascript
componentDidMount() {
  this.getPortfolioItems();
}
```

**Important:** Ensure `getPortfolioItems()` is **not called inside render()** anymore.

### 4. Update getPortfolioItems to Use setState

```javascript
getPortfolioItems() {
  axios.get('https://api.devcamp.space/portfolio/portfolio_items')
    .then(response => {
      console.log("response data", response); // Temporary debugging

      this.setState({
        data: response.data.portfolio_items
      });
    })
    .catch(error => {
      console.log(error);
    });
}
```

---

## 🔍 DEBUGGING AND DATA EXPLORATION

### Console-Based Debugging Process

1. Print full response
2. Expand in DevTools
3. Identify correct data path
4. Verify that the type matches expectations (array in this case)

### Typical Portfolio API Item

```javascript
{
  id: 8,
  name: "Portfolio Item Name",
  description: "Some description text",
  url: "https://example.com",
  category: "enterprise",
  position: 1,
  portfolio_item_images: [...]
}
```

### 5. Update portfolioItems() to Use API Data

```javascript
portfolioItems() {
  return this.state.data.map(item => {
    console.log("item data", item); // Temporary

    return (
      <PortfolioItem
        key={item.id}      // Unique key
        title={item.name}  // API → component prop
        url={item.url}
        slug={item.id}
      />
    );
  });
}
```

### 6. Remove Console Logs Once Confirmed

```javascript
// Remove debugging logs once working
```

---

## 📊 EXPECTED USER INTERFACE BEHAVIOUR

### Data Flow

```
componentDidMount → API Call → Response → setState → Re-render → Dynamic UI
```

### What You Should See On Screen

* Real portfolio item names and links
* The number of items should match your DevCamp Space portfolio
* Changing items in DevCamp admin will update UI automatically

### Expected React Warning

```
Warning: Each child in a list should have a unique "key" prop
```

This is normal and will be addressed soon.

---

## 🎯 FULL WORKING CODE EXAMPLE

```javascript
import React, { Component } from 'react';
import axios from 'axios';
import PortfolioItem from './portfolio-item';

export default class PortfolioContainer extends Component {
  constructor(props) {
    super(props);

    this.state = {
      pageTitle: "Welcome to my portfolio",
      isLoading: false,
      data: []
    };

    this.getPortfolioItems = this.getPortfolioItems.bind(this);
  }

  componentDidMount() {
    this.getPortfolioItems();
  }

  getPortfolioItems() {
    axios.get('https://api.devcamp.space/portfolio/portfolio_items')
      .then(response => {
        this.setState({
          data: response.data.portfolio_items
        });
      })
      .catch(error => {
        console.log(error);
      });
  }

  portfolioItems() {
    return this.state.data.map(item => {
      return (
        <PortfolioItem
          key={item.id}
          title={item.name}
          url={item.url}
          slug={item.id}
        />
      );
    });
  }

  render() {
    if (this.state.isLoading) {
      return <div>Loading...</div>;
    }

    return (
      <div>
        <h2>{this.state.pageTitle}</h2>
        {this.portfolioItems()}
      </div>
    );
  }
}
```

---
