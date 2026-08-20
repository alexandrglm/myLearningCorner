# 08-091 - Creating Portfolio Items from React Form

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-portfolio-items-react-form)

https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/b22f77b9f730226c7af340bcb84c1273343d01ae

---

## 🎯 OBJECTIVES

**Implement complete POST request**:

- **Axios POST** to DevCamp Space endpoint
- **FormData submission** from buildForm()
- **withCredentials** for authentication
- **Response handling** with then/catch
- **Real portfolio item creation** in database

**Testing complete flow**:

- Form → API → Database → DevCamp Space → Homepage

---

## 🛠️ IMPLEMENTATION

### Get API Endpoint

**In DevCamp Space**:

1. Click on **Portfolio project**
2. View **API endpoints** 
3. **Copy POST URL**: `https://your-subdomain.devcamp.space/portfolio/portfolio_items`

### Implement Axios POST Request

**File**: `src/components/portfolio/portfolio-form.js`

```javascript
// CHANGE: Import Axios at top
import React, { Component } from "react";
import axios from "axios";

export default class PortfolioForm extends Component {
  /* ... constructor and other methods unchanged ... */

  handleSubmit(event) {
    // CHANGE: Replace console.log with Axios POST
    axios
      .post(
        "https://jordan.devcamp.space/portfolio/portfolio_items",
        this.buildForm(),
        { withCredentials: true }
      )
      .then(response => {
        console.log("response", response);
      })
      .catch(error => {
        console.log("portfolio form handleSubmit error", error);
      });

    event.preventDefault();
  }

  /* ... rest of component unchanged ... */
}
```

---

## 🔧 CONCEPTS

### Axios POST Request Structure

**Three required arguments**:

```javascript
axios.post(
  url,        // API endpoint
  data,       // FormData object from buildForm()
  options     // withCredentials for authentication
)
```

### Why buildForm() as Function Call

**buildForm() execution**:

```javascript
this.buildForm()  // Executes function, returns FormData object
```

**Process flow**:

1. **this.buildForm()** executes → creates FormData
2. **FormData.append()** adds all state values
3. **Returns complete FormData** object
4. **Axios sends** FormData to server

### withCredentials Authentication

**Why necessary**:

```javascript
{ withCredentials: true }
```

**Server security**:

- **Authentication required** to create portfolio items
- **Cookies sent** automatically with request
- **User identity verified** by server
- **Prevents unauthorised** portfolio creation

### Promise Chain Handling

**Response success**:

```javascript
.then(response => {
  console.log("response", response);
  // Future: Update parent component state
  // Future: Clear form inputs
  // Future: Show success message
})
```

**Error handling**:

```javascript
.catch(error => {
  console.log("portfolio form handleSubmit error", error);
  // Future: Display error message to user
  // Future: Handle specific error types
})
```

---

## ✔️ VERIFICATION

### Testing Complete Flow

**Manual testing steps**:

1. **Fill form** with test data:
   
   ```
   Name: Demo Portfolio Item
   URL: https://example.com
   Position: 1
   Category: eCommerce
   Description: Test description
   ```

2. **Open DevTools** → Console tab

3. **Click Save** button

4. **Check console response** - should see portfolio item object

### Verify in DevCamp Space

**Database verification**:

1. **Go to DevCamp Space** → Portfolio Items
2. **Scroll to bottom** of list
3. **Should see new item** - "Demo Portfolio Item"
4. **Note the ID** - generated automatically by database

### Verify on Homepage

**React app verification**:

1. **Navigate to homepage** (`localhost:3000`)
2. **New item should appear** (may be white/invisible without images)
3. **Item is there** but without styling/images
4. **Confirms full data flow** working

### Expected Response Structure

**Console response object**:

```javascript
{
  data: {
    portfolio_item: {
      id: 128,                    // An auto-generated value from API
      name: "Demo Portfolio Item",
      url: "https://example.com", 
      position: 1,
      category: "eCommerce",
      description: "Test description",
      /* ... other API fields ... */
    }
  }
}
```

### Current Limitations (Expected)

**What doesn't happen yet**:

- ❌ **Form doesn't clear** after submission
- ❌ **Sidebar doesn't update** automatically  
- ❌ **No success message** shown
- ❌ **No loading state** during submission

**These will be fixed in upcoming guides**

---

