# 09-130: Getting Total Count of Records from Server and Update Component State

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/getting-count-total-records-server-updating-component-state)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at ff6dabd6433b57c8e51892c48998ce7a81613210](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/ff6dabd6433b57c8e51892c48998ce7a81613210)

---

## 🎯 Objectives

**Implement knowledge of total records for smart infinite scroll decisions**:

- **Add state properties** - totalCount and currentPage to track pagination data
- **Increment currentPage** - in each getBlogItems call for proper page tracking  
- **Debugger exploration** - use JavaScript debugger to explore API response structure
- **Extract metadata** - access response.data.meta.total_records for server record count
- **Update state with metadata** - store totalCount in component state
- **Methodical approach** - building infinite scroll piece by piece with complete understanding

**Key insight**: Only trigger infinite scroll when more records available on server

---

## 🛠️ Implementation

### 1. Add New State Properties

**File**: `src/components/pages/blog.js`

**Update constructor with additional state**:

```javascript
constructor() {
  super();

  this.state = {
    blogItems: [],
    totalCount: 0,
    currentPage: 0
  };

  this.getBlogItems = this.getBlogItems.bind(this);

  this.activateInfiniteScroll();
}
```

### 2. Increment currentPage in getBlogItems

**Add setState at beginning of getBlogItems method**:

```javascript
getBlogItems() {
  this.setState({
    currentPage: this.state.currentPage + 1
  });

  axios
    .get("https://jordan.devcamp.space/portfolio/portfolio_blogs", {
      withCredentials: true
    })
    .then(response => {
      this.setState({
        blogItems: response.data.portfolio_blogs
      });
    })
    .catch(error => {
      console.log("getBlogItems error", error);
    });
}
```

### 3. Add Debugger to Explore API Response Structure

**Temporary debugger addition in .then()**:

```javascript
.then(response => {
  debugger;

  this.setState({
    blogItems: response.data.portfolio_blogs
  });
})
```

### 4. Extract totalCount from API Response Metadata

**Update setState to include totalCount**:

```javascript
.then(response => {
  this.setState({
    blogItems: response.data.portfolio_blogs,
    totalCount: response.data.meta.total_records
  });
})
```

### 5. Complete Final Code

**Updated file**: `src/components/pages/blog.js`

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import BlogItem from "../blog/blog-item";

export default class Blog extends Component {
  constructor() {
    super();

    this.state = {
      blogItems: [],
      totalCount: 0,
      currentPage: 0
    };

    this.getBlogItems = this.getBlogItems.bind(this);

    this.activateInfiniteScroll();
  }

  activateInfiniteScroll() {
    window.onscroll = () => {
      if (
        window.innerHeight + document.documentElement.scrollTop ===
        document.documentElement.offsetHeight
      ) {
        console.log("get more posts");
      }
    };
  }

  getBlogItems() {
    this.setState({
      currentPage: this.state.currentPage + 1
    });

    axios
      .get("https://jordan.devcamp.space/portfolio/portfolio_blogs", {
        withCredentials: true
      })
      .then(response => {
        this.setState({
          blogItems: response.data.portfolio_blogs,
          totalCount: response.data.meta.total_records
        });
      })
      .catch(error => {
        console.log("getBlogItems error", error);
      });
  }

  componentWillMount() {
    this.getBlogItems();
  }

  render() {
    const blogRecords = this.state.blogItems.map(blogItem => {
      return <BlogItem key={blogItem.id} blogItem={blogItem} />;
    });

    return (
      <div className="blog-container">
        <div className="content-container">
          {blogRecords}
        </div>
      </div>
    );
  }
}
```

---

## 📚 Concepts

### State Design for Pagination Tracking

**Why these specific state properties?**:

```javascript
{
  blogItems: [],      // Current loaded blog posts
  totalCount: 0,      // Total records available on server  
  currentPage: 0      // Current page number for pagination
}
```

**State property purposes**:

- **blogItems** - actual content to display
- **totalCount** - enables smart decisions about more content
- **currentPage** - tracks which page we're requesting next

### CurrentPage Logic Explanation

**Why start at 0 and increment first?**:

```javascript
// Constructor
currentPage: 0

// getBlogItems (first call)
this.setState({ currentPage: this.state.currentPage + 1 }); // Now 1
```

**Pagination logic reasoning**:

- **Constructor** - default state before any API calls
- **First API call** - increments to 1 (first page)
- **Subsequent calls** - increment to 2, 3, 4, etc.
- **Standard pagination** - pages typically start at 1, not 0

### Debugger vs Console.log

**When to use debugger?**:

```javascript
.then(response => {
  debugger;  // Stops execution, allows manual inspection
  // vs
  console.log(response);  // Shows output but keeps executing
})
```

**Debugger advantages**:

- **Stops execution** - time to explore without rushing
- **Interactive exploration** - can type commands in console
- **Deep inspection** - expand objects at own pace
- **No scrolling away** - output stays visible

### API Response Structure Understanding

**Typical API response structure**:

```javascript
response = {
  data: {
    portfolio_blogs: [    // Actual blog post array
      { id: 1, title: "Post 1", content: "..." },
      { id: 2, title: "Post 2", content: "..." }
      // ... 8 more items (10 total per page)
    ],
    meta: {               // Pagination metadata
      total_records: 18,  // Total available on server
      total_pages: 2,     // How many pages available
      current_page: 1     // Which page this response represents
    }
  }
}
```

### Meta Pagination Data Importance

**Why metadata is crucial for infinite scroll?**:

```javascript
// Without metadata - bad approach
if (userReachesBottom) {
  loadMorePosts(); // Don't know if more exist!
}

// With metadata - smart approach  
if (userReachesBottom && this.state.blogItems.length < this.state.totalCount) {
  loadMorePosts(); // Only load if more exist
}
```

**Benefits of using totalCount**:

- **Prevents unnecessary API calls** - don't call if no more data
- **Better user experience** - no loading spinners when done
- **Server efficiency** - reduces pointless requests
- **Accurate UI state** - can show "no more posts" messages

### API Variations Acknowledgement

**Different API implementations**:

```javascript
// This course (meta in data)
response.data.meta.total_records

// Alternative 1 (headers)
response.headers['x-total-count']

// Alternative 2 (direct in data)
response.data.total_records

// Alternative 3 (different naming)
response.data.pagination.total
```

**Why mention variations**:

- **Real-world preparation** - APIs differ between projects
- **Adaptability** - understand concept, not just specific syntax
- **Problem-solving** - know how to find this info in any API
- **Professional development** - APIs aren't standardised

---

## ✋ Verification

### React DevTools State Inspection

**Verification steps**:

1. **Navigate to /blog** page
2. **Open React DevTools** → Components tab
3. **Select Blog component** (not BlogItem)
4. **View State panel**:
   
   ```javascript
   State:
     blogItems: Array(10)    // 10 blog posts loaded
     totalCount: 18          // 18 total available on server  
     currentPage: 1          // First page loaded
   ```

### Console Browser Testing (Optional)

**Manual API exploration in browser console**:

```javascript
// Test metadata structure
response.data.meta
// Should show: { total_records: 18, total_pages: 2, current_page: 1 }

// Test specific value
response.data.meta.total_records
// Should show: 18 (or whatever your actual count is)
```

### State Update Verification

**Confirm state updates correctly**:

- **Initial state**: `currentPage: 0, totalCount: 0`  
- **After componentWillMount**: `currentPage: 1, totalCount: 18`
- **blogItems populated**: Array with 10 blog posts
- **All values realistic**: Numbers make sense for your data

### Debugger Usage (If Used)

**Debugger workflow**:

1. **Page loads** → debugger stops execution
2. **Console commands** → explore response structure manually
3. **Type `response.data.meta`** → see pagination metadata
4. **Continue execution** → click continue button in DevTools
5. **Remove debugger** → delete debugger line when done exploring

### Different Total Count Testing

**Your totalCount will be different**:

- **Example shows 18** - instructor's data count
- **Your count varies** - based on blog posts you've created in DevCamp Space
- **Minimum for testing** - recommend at least 12-15 posts for proper infinite scroll testing
- **Verify accuracy** - count should match actual posts in DevCamp Space

---

## 🎨 Methodical Approach Benefits

### Breaking Down Complex Feature

**Why build piece by piece**:

- **Manageable chunks** - each guide adds one concept
- **Understanding each piece** - no "magic" or unexplained code
- **Debugging easier** - problems isolated to specific functionality
- **Learning retention** - understand why each piece needed

### Professional Development Approach

**Real-world transferable skills**:

- **API exploration techniques** - debugger, console, DevTools
- **Pagination patterns** - currentPage, totalCount concepts
- **State management** - organising complex data
- **Methodical debugging** - step-by-step problem solving

---

