# 09-105: Build Delete Click Handler in React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-delete-click-handler-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 4d2e1a474fa540b108b6c55b3c34cf098d0c4801](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/4d2e1a474fa540b108b6c55b3c34cf098d0c4801)

---

## 🎯 Objectives

**Begin implementation of complete CRUD functionality**:

- **CRUD overview** - Create, Read, Update, Delete functionality
- **Delete click handler** - add delete links in sidebar
- **Parent-child communication** - passing functions as props
- **Portfolio item identification** - using ID for specific targeting
- **Foundation for API integration** - prepare structure for DELETE requests

**CRUD status so far**:

- ✅ **Create** - portfolio form creates new items
- ✅ **Read** - displaying portfolio items from API
- 🔄 **Update** - coming next (after delete)
- 🔄 **Delete** - implementing now (click handler first)

---

## 🛠️ Implementation

### 1. Add Delete Link to Sidebar Component

**File**: `src/components/portfolio/portfolio-sidebar-list.js`

**Add link after existing content**:

```javascript
import React from "react";

const PortfolioSidebarList = props => {
  const portfolioList = () => {
    return props.data.map(portfolioItem => {
      return (
        <div key={portfolioItem.id} className="portfolio-item-thumb">
          <div className="portfolio-thumb-img">
            <img src={portfolioItem.thumb_image_url} />
          </div>
          <div className="text-content">
            <div className="title">{portfolioItem.name}</div>
            <div className="id">{portfolioItem.id}</div>

            <a onClick={() => props.handleDeleteClick(portfolioItem)}>
              Delete
            </a>
          </div>
        </div>
      );
    });
  };

  return (
    <div className="portfolio-sidebar-list-wrapper">
      {portfolioList()}
    </div>
  );
};

export default PortfolioSidebarList;
```

### 2. Create handleDeleteClick Method in Portfolio Manager

**File**: `src/components/pages/portfolio-manager.js`

**Add method and binding**:

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
    this.handleDeleteClick = this.handleDeleteClick.bind(this);
  }

  handleDeleteClick(portfolioItem) {
    console.log("handleDeleteClick", portfolioItem);
  }

  handleSuccessfulFormSubmission(portfolioItem) {
    this.setState({
      portfolioItems: [portfolioItem].concat(this.state.portfolioItems)
    });
  }

  handleFormSubmissionError(error) {
    console.log("handleFormSubmissionError error", error);
  }

  getPortfolioItems() {
    axios.get(
      "https://apialexandr.devcamp.space/portfolio/portfolio_items?order_by=created_at&direction=desc", 
      { withCredentials: true }
    ).then(response => {
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
          <PortfolioSidebarList 
            handleDeleteClick={this.handleDeleteClick}
            data={this.state.portfolioItems} 
          />
        </div>
      </div>
    );
  }
}
```

---

## 📚 Concepts

### CRUD Functionality Overview

**Complete application requirements**:

```javascript
// CRUD Operations
Create  → POST   /portfolio_items      // ✅ Implemented
Read    → GET    /portfolio_items      // ✅ Implemented
Update  → PUT    /portfolio_items/:id  // 🔄 Next section
Delete  → DELETE /portfolio_items/:id  // 🔄 Implementing now
```

**Why CRUD is fundamental**:

- **Industry standard** - all applications need these operations
- **Database interactions** - mirrors SQL operations (INSERT, SELECT, UPDATE, DELETE)
- **RESTful APIs** - standard HTTP methods for each operation
- **User expectations** - complete data management functionality

### Parent-Child Function Passing Pattern

**Data flow architecture**:

```javascript
// Parent (PortfolioManager)
handleDeleteClick(portfolioItem) {
  // Handle delete logic here
}

// Pass function to child
<PortfolioSidebarList 
  handleDeleteClick={this.handleDeleteClick}
  data={this.state.portfolioItems} 
/>

// Child (PortfolioSidebarList) 
<a onClick={() => props.handleDeleteClick(portfolioItem)}>
  Delete
</a>
```

**Why this pattern works**:

- **Separation of concerns** - child handles UI, parent handles logic
- **State management** - only parent can update portfolio items state
- **Reusability** - child component doesn't know about specific business logic
- **Debugging** - easy to trace function calls up the component tree

### Arrow Function vs Regular Function in onClick

**Current approach (arrow function)**:

```javascript
<a onClick={() => props.handleDeleteClick(portfolioItem)}>
  Delete
</a>
```

**Why arrow function needed**:

- **Immediate execution prevention** - without arrow function, function runs on render
- **Parameter passing** - allows us to pass portfolioItem argument
- **Scope preservation** - maintains access to portfolioItem from map iteration

**Alternative approaches**:

```javascript
// ❌ NOPE!!!!! - Wrong - calls function immediately on render
<a onClick={props.handleDeleteClick(portfolioItem)}>

// ❌ Wrong - NOPE!!!!! - doesn't pass portfolioItem
<a onClick={props.handleDeleteClick}>

// ✅ YEP! - Correct - calls function only on click with parameter
<a onClick={() => props.handleDeleteClick(portfolioItem)}>
```

### Portfolio Item Object Structure

**Complete object available in handleDeleteClick**:

```javascript
portfolioItem = {
  id: 123,                    // ← Critical for API delete call
  name: "Project Name",
  description: "...",
  url: "https://...",
  category: "eCommerce",
  position: 1,
  thumb_image_url: "...",
  banner_image_url: "...",
  logo_url: "...",
  created_at: "...",
  updated_at: "..."
}
```

**Why pass entire object**:

- **ID access** - needed for API DELETE request
- **Future flexibility** - might need other properties for UI updates
- **Debugging** - complete object visibility in console
- **User confirmation** - could show project name in confirmation dialogue

### Function Binding Necessity

**Why binding required**:

```javascript
// In constructor
this.handleDeleteClick = this.handleDeleteClick.bind(this);

// Without binding
handleDeleteClick(portfolioItem) {
  console.log(this.state); // ❌ Error: this is undefined
}

// With binding
handleDeleteClick(portfolioItem) {
  console.log(this.state); // ✅ Works: this refers to component instance
}
```

---

## ✋ Verification

### Click Handler Testing

**Manual verification**:

1. **Navigate to portfolio-manager** page
2. **Open browser console** (F12)
3. **Click any "Delete" link** in sidebar
4. **Verify console output**:
   
   ```
   handleDeleteClick {id: 123, name: "Project Name", ...}
   ```
5. **Test multiple items** - each should log different object

### Props Passing Verification

**React DevTools inspection**:

1. **Open React DevTools**
2. **Select PortfolioSidebarList** component
3. **Check props**:
   - ✅ `data` array populated
   - ✅ `handleDeleteClick` function present
4. **Verify function availability** - should show as function in props

### Portfolio Item Object Inspection

**Console object verification**:

```javascript
// Expected console output structure
handleDeleteClick {
  id: 123,                    // Number
  name: "Project Name",       // String
  description: "...",         // String
  category: "eCommerce",      // String
  thumb_image_url: "https://..." // String with image URL
  // ... other properties
}
```

### Error Cases to Check

**Potential issues**:

- **Clicking without console open** - no visible feedback yet (normal)
- **Multiple rapid clicks** - should log multiple times
- **Different items** - should show different IDs and names
- **No JavaScript errors** - clean console except for our logs

### UI Appearance Verification

**Current visual state**:

- ✅ **"Delete" links visible** - text links after each item
- ✅ **Clickable** - cursor changes on hover
- ✅ **No styling** - basic link appearance (improved later)
- ✅ **Positioned correctly** - after portfolio item content

---

