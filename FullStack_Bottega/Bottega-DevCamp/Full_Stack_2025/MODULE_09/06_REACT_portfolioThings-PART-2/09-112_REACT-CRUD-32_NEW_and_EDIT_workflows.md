# 09-112: Working New and Edit Workflows React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/working-new-and-edit-workflows-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at c1df96a2b43b72a9d252c408b4b8baa1ae7bb091](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/c1df96a2b43b72a9d252c408b4b8baa1ae7bb091)

---

## 🎯 Objectives

**Separate CREATE vs EDIT workflows in the application**:

- **Rename method** - handleSuccessfulFormSubmission → handleNewFormSubmission
- **Create handleEditFormSubmission** - different behaviour for edit operations
- **Conditional workflow selection** - use editMode state to decide which handler to call
- **State reset after submission** - return to base state after successful submission
- **Refetch data strategy** - handleEditFormSubmission uses getPortfolioItems()

**Functional result**:

- Form submissions trigger correct workflow based on editMode
- NEW submissions add item to top of list
- EDIT submissions refresh entire list from API
- Form resets to CREATE mode after any submission

---

## 🛠️ Implementation

### 1. Rename handleSuccessfulFormSubmission Method

**File**: `src/components/pages/portfolio-manager.js`

**Change method name and all references**:

```javascript
export default class PortfolioManager extends Component {
  constructor() {
    super();

    this.state = {
      portfolioItems: [],
      portfolioToEdit: {}
    };

    this.handleNewFormSubmission = this.handleNewFormSubmission.bind(this);
    this.handleEditFormSubmission = this.handleEditFormSubmission.bind(this);
    this.handleFormSubmissionError = this.handleFormSubmissionError.bind(this);
    this.handleDeleteClick = this.handleDeleteClick.bind(this);
    this.handleEditClick = this.handleEditClick.bind(this);
    this.clearPortfolioToEdit = this.clearPortfolioToEdit.bind(this);
  }

  handleNewFormSubmission(portfolioItem) {
    this.setState({
      portfolioItems: [portfolioItem].concat(this.state.portfolioItems)
    });
  }

  // Rest of existing methods...
}
```

### 2. Create handleEditFormSubmission Method

**Add new method after handleNewFormSubmission**:

```javascript
handleEditFormSubmission() {
  this.getPortfolioItems();
}
```

### 3. Update Props in Render Method

**Pass both handlers to PortfolioForm**:

```javascript
render() {
  return (
    <div className="portfolio-manager-wrapper">
      <div className="left-column">
        <PortfolioForm 
          handleNewFormSubmission={this.handleNewFormSubmission}
          handleEditFormSubmission={this.handleEditFormSubmission}
          handleFormSubmissionError={this.handleFormSubmissionError}
          clearPortfolioToEdit={this.clearPortfolioToEdit}
          portfolioToEdit={this.state.portfolioToEdit}
        />
      </div>

      <div className="right-column">
        <PortfolioSidebarList 
          handleDeleteClick={this.handleDeleteClick}
          data={this.state.portfolioItems}
          handleEditClick={this.handleEditClick}
        />
      </div>
    </div>
  );
}
```

### 4. Implement Conditional Workflow Selection

**File**: `src/components/portfolio/portfolio-form.js`

**Update handleSubmit method with conditional logic**:

```javascript
handleSubmit(event) {
  axios({
    method: this.state.apiAction,
    url: this.state.apiUrl,
    data: this.buildForm(),
    withCredentials: true
  })
  .then(response => {
    if (this.state.editMode) {
      this.props.handleEditFormSubmission();
    } else {
      this.props.handleNewFormSubmission(response.data.portfolio_item);
    }

    this.setState({
      name: "",
      description: "",
      category: "eCommerce",
      position: "",
      url: "",
      thumb_image: "",
      banner_image: "",
      logo: "",
      editMode: false,
      apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items",
      apiAction: "post"
    });

    [this.thumbRef, this.bannerRef, this.logoRef].forEach(ref => {
      ref.current.dropzone.removeAllFiles();
    });
  })
  .catch(error => {
    console.log("portfolio form handleSubmit error", error);
  });

  event.preventDefault();
}
```

---

## 📚 Concepts

### Method Naming Convention

**Descriptive naming strategy**:

```javascript
// ❌ Generic naming
handleSuccessfulFormSubmission()   // Doesn't indicate workflow type

// ✅ Specific naming  
handleNewFormSubmission()          // Clear CREATE workflow
handleEditFormSubmission()         // Clear UPDATE workflow
```

**Why specific naming matters**:

- **Code readability** - intention immediately clear
- **Debugging ease** - stack traces more informative
- **Team communication** - developers understand purpose instantly
- **Maintenance** - easier to modify specific workflows

### Different Strategies for Different Workflows

**NEW submission strategy**:

```javascript
handleNewFormSubmission(portfolioItem) {
  this.setState({
    portfolioItems: [portfolioItem].concat(this.state.portfolioItems)
  });
}
```

**Benefits**:

- **Immediate UI update** - no API call needed
- **Optimistic update** - assume success
- **Performance** - single state update
- **User experience** - instant feedback

**EDIT submission strategy**:

```javascript
handleEditFormSubmission() {
  this.getPortfolioItems();
}
```

**Benefits**:

- **Data consistency** - always latest from server
- **Simple implementation** - reuse existing method
- **Reliable state** - no complex array manipulation
- **Future-proof** - handles complex data relationships

### Conditional Workflow Selection

**editMode as decision factor**:

```javascript
if (this.state.editMode) {
  this.props.handleEditFormSubmission();    // Refresh from API
} else {
  this.props.handleNewFormSubmission(response.data.portfolio_item);  // Add to array
}
```

**Decision logic**:

- **editMode: true** → user clicked edit icon → update existing item
- **editMode: false** → user creating new item → add to collection
- **Single point of decision** - no complex conditionals
- **Clear data flow** - easy to follow logic

### State Reset Strategy

**Complete state reset after submission**:

```javascript
this.setState({
  name: "",
  description: "",
  category: "eCommerce",
  position: "",
  url: "",
  thumb_image: "",
  banner_image: "",
  logo: "",
  editMode: false,                    // Back to CREATE mode
  apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items",
  apiAction: "post"
});
```

**Why complete reset needed**:

- **Clean slate** for next operation
- **Mode switching** - edit → create
- **User experience** - form appears fresh
- **Prevent bugs** - no lingering state from previous operation

### Data Refetch vs Optimistic Updates

**When to use each strategy**:

**Optimistic updates (NEW items)**:

- ✅ **Single user action** - no conflicts expected
- ✅ **Simple data** - no complex relationships
- ✅ **Immediate feedback** needed
- ✅ **API returns complete object**

**Data refetch (EDIT items)**:

- ✅ **Potential conflicts** - other users might modify data
- ✅ **Complex relationships** - item might affect other items
- ✅ **Data integrity critical** - must be 100% accurate
- ✅ **Simple implementation** - reuse existing logic

### Props Flow Architecture

**Parent-child communication pattern**:

```
PortfolioManager (parent)
    ↓ handleNewFormSubmission prop
    ↓ handleEditFormSubmission prop
PortfolioForm (child)
    ↓ conditional call based on editMode
Parent method execution
    ↓ state update
UI re-render with updated data
```

**Benefits of this pattern**:

- **Single source of truth** - parent manages all data
- **Reusable components** - form doesn't know about data storage
- **Predictable flow** - data always flows down, events bubble up
- **Easy testing** - can mock parent handlers

---

## ✋ Verification

### CREATE Workflow Testing

**Test new item creation**:

1. **Ensure form is empty** (refresh page if needed)
2. **Fill out form** with new portfolio data
3. **Submit form**
4. **Verify new item appears** at top of sidebar immediately
5. **Verify form resets** to empty state
6. **Check editMode** - should be false after submission

### EDIT Workflow Testing

**Test item editing**:

1. **Click edit icon** on existing portfolio item
2. **Verify form populates** with existing data
3. **Modify some fields**
4. **Submit form**
5. **Verify entire sidebar refreshes** (slight delay normal)
6. **Verify changes persisted** - modified data visible
7. **Verify form resets** to empty state

### State Management Verification

**React DevTools monitoring**:

1. **Open React DevTools**
2. **Select PortfolioManager** component
3. **Monitor portfolioItems state** during operations
4. **NEW submission**: immediate array update
5. **EDIT submission**: complete array replacement
6. **Select PortfolioForm** component
7. **Verify editMode** resets to false after submission

### Method Rename Verification

**Test after refactor**:

1. **Refresh application**
2. **Test CREATE workflow** - should work identically
3. **Verify no console errors** - all references updated correctly
4. **Check React DevTools** - props show new method names

### Database Persistence Testing

**Verify changes persist**:

1. **Create new item** → refresh browser → item should appear
2. **Edit existing item** → refresh browser → changes should persist
3. **Check DevCamp Space** → portfolio items → verify database updates

### Workflow Isolation Testing

**Verify workflows don't interfere**:

1. **Create item** → verify ADD workflow
2. **Edit different item** → verify EDIT workflow  
3. **Create another item** → verify ADD workflow still works
4. **Edit same item again** → verify EDIT workflow consistent

---

