# 09-095 - Populating Parent Component Data in React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/populating-parent-component-data-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 00baa1afee11275cf3b6f54a449b7f45d1b342f7](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/00baa1afee11275cf3b6f54a449b7f45d1b342f7)

---

## 🎯 OBJECTIVES

**Complete child-to-parent data flow communication**:

- **Call parent handler** from form submission response  
- **Update parent state** with new portfolio item
- **Array concatenation** correct for prepending new items
- **API ordering optimisation** with query parameters
- **Real-time sidebar update** without page refresh

**Critical skills**:

- Props functions calling from child components
- Immutable array updates in React state  
- API query parameters for ordering
- Local state vs persistent data behaviour

---

## 🛠️ IMPLEMENTATION

### 1. Call Parent Handler from Child

**File**: `src/components/portfolio/portfolio-form.js`

**In handleSubmit method, inside .then()**:

```javascript
handleSubmit(event) {
  event.preventDefault();

  axios.post(
    "https://apialexandr.devcamp.space/portfolio/portfolio_items", 
    this.buildForm(), 
    { withCredentials: true }
  ).then(response => {
    this.props.handleSuccessfulFormSubmission(response.data.portfolio_item);
    console.log("response", response);
  }).catch(error => {
    console.log("portfolio form handleSubmit error", error);
  });
}
```

### 2. Implement Parent Handler with State Update

**File**: `src/components/pages/portfolio-manager.js`

**Replace TODO with complete implementation**:

```javascript
handleSuccessfulFormSubmission(portfolioItem) {
  this.setState({
    portfolioItems: [portfolioItem].concat(this.state.portfolioItems)
  });
}
```

### 3. Optimise API Call for Ordering

**In same file, update getPortfolioItems()**:

```javascript
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
```

---

## 🔧 CONCEPTS

### Child-to-Parent Communication Pattern

**How data flow works**:

```javascript
// 1. Parent defines handler function
handleSuccessfulFormSubmission(portfolioItem) { 
  // Update parent state
}

// 2. Parent passes handler as prop
<PortfolioForm 
  handleSuccessfulFormSubmission={this.handleSuccessfulFormSubmission}
/>

// 3. Child calls parent handler when needed
this.props.handleSuccessfulFormSubmission(newItem);

// 4. Parent state updates → child components re-render
```

### Why NOT Use Array.push() in React?

**Incorrect approach**:

```javascript
// ❌ NEVER do this in React
handleSuccessfulFormSubmission(portfolioItem) {
  this.state.portfolioItems.push(portfolioItem);
  this.setState({
    portfolioItems: this.state.portfolioItems
  });
}
```

**Problems**:

- **Mutates state directly** - violates React principles
- **React doesn't detect change** - reference is the same
- **No re-rendering** - components don't update
- **Debugging issues** - React DevTools confused

### Correct Immutable Array Updates

**Correct pattern with concat()**:

```javascript
// ✅ Correct approach
this.setState({
  portfolioItems: [portfolioItem].concat(this.state.portfolioItems)
});
```

**Why it works?**:

- **Creates new array** - doesn't mutate existing state
- **React detects change** - different reference
- **Re-rendering triggers** - components update
- **Prepends item** - new item at start

**Breakdown of concat pattern**:

```javascript
[portfolioItem]  // Array with 1 element (new item)
.concat(this.state.portfolioItems)  // Concatenates with existing items
// Result: [newItem, item1, item2, item3...] ✅
```

### Alternative Modern Approaches

**With spread operator**:

```javascript
this.setState({
  portfolioItems: [portfolioItem, ...this.state.portfolioItems]
});
```

**With unshift() pattern (create new array)**:

```javascript
const updatedItems = [...this.state.portfolioItems];
updatedItems.unshift(portfolioItem);
this.setState({ portfolioItems: updatedItems });
```

### API Query Parameters Understanding

**URL structure explained**:

```javascript
"https://apialexandr.devcamp.space/portfolio/portfolio_items?order_by=created_at&direction=desc"
```

**Components of URL**:

- **Base URL**: `portfolio/portfolio_items`
- **Query start**: `?` (marks start of parameters)
- **Parameter 1**: `order_by=created_at` (sort by creation date)
- **Separator**: `&` (separates multiple parameters)
- **Parameter 2**: `direction=desc` (descending - most recent first)

**Why these parameters?**:

- **order_by=created_at** - orders by when created
- **direction=desc** - newest items first
- **Result**: List naturally shows newest items at top

### State vs Persistent Data

**Local state behaviour**:

- **Form submission** → new item appears immediately at top
- **Page refresh** → items reordered based on API response
- **Without query params** → refresh puts new item at bottom
- **With query params** → refresh keeps new items at top

**Professional pattern**:

- **Optimistic updates** on frontend (local state)
- **API consistency** with query parameters  
- **Best UX** - immediate feedback + persistent order

---

## ✔️ VERIFICATION

### Testing Form Submission to Parent Update

**End-to-end test**:

1. **Open portfolio-manager** page
2. **See sidebar** with existing items
3. **Fill form**:
   - Name: "testing update"
   - Category: any option
   - Other fields optional
4. **Click Save**
5. **Verify immediately**:
   - ✅ New item appears **at top** of sidebar
   - ✅ No page refresh needed
   - ✅ Form clears (if implemented)

### DevCamp Space Persistence Testing

**Backend verification**:

1. **After form submission locally**
2. **Open DevCamp Space** in new tab
3. **Refresh** DevCamp Space page
4. **Scroll down** to find "testing update"
5. **Verify** item exists in database

### Page Refresh Behaviour Testing

**Testing API ordering**:

1. **After form submission** (item at top locally)
2. **Hard refresh** portfolio-manager page
3. **Verify**: "testing update" should still be at top
4. **Without query params**: item would be at bottom
5. **With query params**: item stays at top ✅

### Console Debugging

**Expected console output**:

```javascript
// On form submission:
console.log("response", response);  // Full API response
console.log("handleSuccessfulFormSubmission", portfolioItem);  // New item data

// Verify response structure:
response.data.portfolio_item = {
  id: 123,
  name: "testing update", 
  category: "eCommerce",
  // ... other properties
}
```

### React DevTools State Inspection

**Parent state changes**:

1. **Before submission**: portfolioItems array original
2. **After submission**: new item at index [0]
3. **Array length**: increased by 1
4. **Item structure**: matches API response format

---
