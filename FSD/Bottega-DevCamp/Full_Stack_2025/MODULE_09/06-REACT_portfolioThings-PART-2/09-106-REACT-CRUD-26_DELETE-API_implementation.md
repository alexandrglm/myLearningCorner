# 09-106: How to Delete API Data in React and Update State

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-delete-api-data-react-update-state)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at ec9b20ee0ff9928a936858a8a46d2c03a2691d86](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/ec9b20ee0ff9928a936858a8a46d2c03a2691d86)

---

## 🎯 Objectives

**Complete delete functionality with API integration**:

- **Axios DELETE request** - send DELETE to API endpoint  
- **Dynamic URL construction** - using template literals with portfolio item ID
- **API authentication** - withCredentials for security
- **State synchronisation** - update local state after API success
- **Filter array method** - remove deleted item from portfolioItems array

**⚠️ Data Warning**:

- **Permanent deletion** - records and images are permanently deleted
- **Test with sample data** - don't delete important portfolio items
- **No undo functionality** - deletion is irreversible

---

## 🛠️ Implementation

### 1. Implement Axios DELETE Request

**File**: `src/components/pages/portfolio-manager.js`

**Update handleDeleteClick method**:

```javascript
handleDeleteClick(portfolioItem) {
  axios
    .delete(
      `https://apialexandr.devcamp.space/portfolio/portfolio_items/${portfolioItem.id}`,
      { withCredentials: true }
    )
    .then(response => {
      console.log("response from delete", response);
    })
    .catch(error => {
      console.log("handleDeleteClick error", error);
    });
}
```

### 2. Implement State Update with Filter

**Update .then() to synchronise local state**:

```javascript
handleDeleteClick(portfolioItem) {
  axios
    .delete(
      `https://apialexandr.devcamp.space/portfolio/portfolio_items/${portfolioItem.id}`,
      { withCredentials: true }
    )
    .then(response => {
      this.setState({
        portfolioItems: this.state.portfolioItems.filter(item => {
          return item.id !== portfolioItem.id;
        })
      });

      return response.data;
    })
    .catch(error => {
      console.log("handleDeleteClick error", error);
    });
}
```

---

## 📚 Concepts

### Axios DELETE Request Structure

**HTTP DELETE method**:

```javascript
axios.delete(url, config)
```

**Components breakdown**:

- **Method**: `delete` - HTTP verb for deletion
- **URL**: Template literal with dynamic ID
- **Config**: Object with withCredentials for auth
- **Returns**: Promise (like GET/POST)

### Template Literal URL Construction

**Dynamic endpoint building**:

```javascript
// Template literal syntax
`https://apialexandr.devcamp.space/portfolio/portfolio_items/${portfolioItem.id}`

// Results in URLs like:
// https://apialexandr.devcamp.space/portfolio/portfolio_items/123
// https://apialexandr.devcamp.space/portfolio/portfolio_items/456
```

**Why dynamic URLs needed**:

- **Specific targeting** - API needs to know which record to delete
- **RESTful pattern** - standard API design uses resource ID in URL
- **Security** - server validates ownership before deletion

### API Authentication & Authorisation

**withCredentials importance**:

```javascript
{ withCredentials: true }
```

**Server-side validation process**:

1. **Cookie verification** - withCredentials sends cookies
2. **User identity** - server identifies logged-in user
3. **Ownership check** - verify portfolio item belongs to user
4. **Permission granted** - proceed with deletion
5. **403 Forbidden** - if user doesn't own the item

### Array Filter Method for State Updates

**Filter method explained**:

```javascript
this.state.portfolioItems.filter(item => {
  return item.id !== portfolioItem.id;
})
```

**How filter works**:

- **Iterates** over each item in portfolioItems array
- **Callback function** runs for each item
- **Returns true** - keep item in new array
- **Returns false** - exclude item from new array
- **Creates new array** - immutable update pattern

**Visual example**:

```javascript
// Original array
[
  {id: 1, name: "Project A"},
  {id: 2, name: "Project B"},  // ← This one gets deleted
  {id: 3, name: "Project C"}
]

// Filter where id !== 2
[
  {id: 1, name: "Project A"},  // id !== 2 → true → keep
  {id: 3, name: "Project C"}   // id !== 2 → true → keep
]
// Item with id: 2 → false → removed
```

### Promise Return Pattern

**Why return response.data**:

```javascript
.then(response => {
  this.setState({...});
  return response.data;  // ← For potential chaining
})
```

**Benefits**:

- **Function returns value** - good practice
- **Chainable promises** - if needed later
- **Consistent pattern** - matches other API calls

### Local State vs Server State Synchronisation

**Two-step process**:

1. **Server deletion** (axios.delete) - permanent removal
2. **Local state update** (setState) - UI synchronisation

**Why both needed**:

- **Server deletion** - actual data destruction
- **Local update** - immediate UI feedback
- **No page refresh** - smooth user experience
- **State consistency** - local matches server reality

---

## ✋ Verification

### Delete Functionality Testing

**Complete workflow test**:

1. **Open portfolio-manager** page
2. **Check current items** in sidebar
3. **Click "Delete"** on any item
4. **Expected immediate behaviour**:
   - ✅ Item disappears from sidebar instantly
   - ✅ No page refresh required
   - ✅ Other items remain unchanged

### API Integration Verification

**DevCamp Space confirmation**:

1. **After delete** operation
2. **Navigate to DevCamp Space** → Portfolio Items
3. **Refresh page** 
4. **Verify item deleted** - should not appear in list
5. **Confirm permanent deletion** - images also removed

### State Synchronisation Testing

**React DevTools verification**:

1. **Open React DevTools**
2. **Select PortfolioManager** component
3. **Note current portfolioItems array length**
4. **Delete an item**
5. **Verify array length decreases** by 1
6. **Confirm correct item removed** from state

### Error Case Testing

**Test authentication**:

1. **Log out of DevCamp Space** (if possible)
2. **Try to delete item**
3. **Should get 401 error** in console
4. **Item should NOT delete** 
5. **User gets appropriate feedback**

### Multiple Deletes Testing

**Rapid succession testing**:

1. **Delete multiple items** quickly
2. **Each should disappear** immediately
3. **No UI conflicts** or race conditions
4. **State remains consistent**

---
