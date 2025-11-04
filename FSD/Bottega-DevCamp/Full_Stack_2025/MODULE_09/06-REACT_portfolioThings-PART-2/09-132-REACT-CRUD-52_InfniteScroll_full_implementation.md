# 09-132: Building Full Infinite Scroll Functionality in React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-full-infinite-scroll-functionality-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 2cf981f156597e33a97eb869bd7ba538f74924b0](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/2cf981f156597e33a97eb869bd7ba538f74924b0)

---

## 🎯 Objectives

**Connect all the pieces for complete infinite scroll functionality**:

- **API pagination implementation** - use currentPage parameter to fetch different pages
- **Dynamic URL construction** - template literals with page parameter in API calls
- **Array concatenation pattern** - append new posts to existing array instead of replacing
- **Guard conditions** - prevent unnecessary API calls when all records loaded
- **Loading state protection** - prevent multiple concurrent requests
- **Professional edge case handling** - handle quick scrolling and slow internet scenarios

**End result**: Seamless infinite scroll experience like Facebook, Instagram, Twitter

---

## 🛠️ Implementation

### 1. Replace Hardcoded URL with Dynamic Template Literal

**File**: `src/components/pages/blog.js`

**In getBlogItems method, update axios.get URL**:

```javascript
getBlogItems() {
  this.setState({
    currentPage: this.state.currentPage + 1
  });

  axios
    .get(
      `https://jordan.devcamp.space/portfolio/portfolio_blogs?page=${this.state.currentPage}`,
      { withCredentials: true }
    )
    .then(response => {
      console.log("getting", response.data);

      this.setState({
        blogItems: response.data.portfolio_blogs,
        totalCount: response.data.meta.total_records,
        isLoading: false
      });
    })
    .catch(error => {
      console.log("getBlogItems error", error);
    });
}
```

### 2. Implement Array Concatenation Pattern

**Update setState to concatenate instead of replace**:

```javascript
.then(response => {
  console.log("getting", response.data);

  this.setState({
    blogItems: this.state.blogItems.concat(response.data.portfolio_blogs),
    totalCount: response.data.meta.total_records,
    isLoading: false
  });
})
```

### 3. Call getBlogItems in Infinite Scroll Trigger

**In activateInfiniteScroll method, update onscroll handler**:

```javascript
activateInfiniteScroll() {
  window.onscroll = () => {
    if (
      window.innerHeight + document.documentElement.scrollTop ===
      document.documentElement.offsetHeight
    ) {
      this.getBlogItems();
    }
  };
}
```

### 4. Add Guard Conditions to Prevent Unnecessary API Calls

**Implement dual guard conditions in onscroll handler**:

```javascript
activateInfiniteScroll() {
  window.onscroll = () => {
    if (
      this.state.isLoading ||
      this.state.blogItems.length === this.state.totalCount
    ) {
      return;
    }

    if (
      window.innerHeight + document.documentElement.scrollTop ===
      document.documentElement.offsetHeight
    ) {
      this.getBlogItems();
    }
  };
}
```

### 5. Complete Final Code

**Full updated file**: `src/components/pages/blog.js`

```javascript
import React, { Component } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import BlogItem from "../blog/blog-item";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export default class Blog extends Component {
  constructor() {
    super();

    this.state = {
      blogItems: [],
      totalCount: 0,
      currentPage: 0,
      isLoading: true
    };

    this.getBlogItems = this.getBlogItems.bind(this);

    this.activateInfiniteScroll();
  }

  activateInfiniteScroll() {
    window.onscroll = () => {
      if (
        this.state.isLoading ||
        this.state.blogItems.length === this.state.totalCount
      ) {
        return;
      }

      if (
        window.innerHeight + document.documentElement.scrollTop ===
        document.documentElement.offsetHeight
      ) {
        this.getBlogItems();
      }
    };
  }

  getBlogItems() {
    this.setState({
      currentPage: this.state.currentPage + 1
    });

    axios
      .get(
        `https://jordan.devcamp.space/portfolio/portfolio_blogs?page=${this.state.currentPage}`,
        { withCredentials: true }
      )
      .then(response => {
        this.setState({
          blogItems: this.state.blogItems.concat(response.data.portfolio_blogs),
          totalCount: response.data.meta.total_records,
          isLoading: false
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

        {this.state.isLoading ? (
          <div className="content-loader">
            <FontAwesomeIcon icon="spinner" spin />
          </div>
        ) : null}
      </div>
    );
  }
}
```

---

## 📚 Concepts

### API Pagination URL Parameters

**Dynamic URL construction with currentPage**:

```javascript
// Page 1
`https://jordan.devcamp.space/portfolio/portfolio_blogs?page=1`

// Page 2  
`https://jordan.devcamp.space/portfolio/portfolio_blogs?page=2`

// Page 3
`https://jordan.devcamp.space/portfolio/portfolio_blogs?page=3`
```

**How pagination works?**:

- **page=1** → returns first 10 blog posts
- **page=2** → returns next 10 blog posts (posts 11-20)
- **page=3** → returns next 10 blog posts (posts 21-30)
- **No page param** → defaults to page 1

### Array Concatenation vs Replacement

**❌ Wrong approach (replacement)**:

```javascript
this.setState({
  blogItems: response.data.portfolio_blogs  // Replaces entire array
});
```

**✅ Correct approach (concatenation)**:

```javascript
this.setState({
  blogItems: this.state.blogItems.concat(response.data.portfolio_blogs)
});
```

**Visual example**:

```javascript
// Initial state
blogItems: [post1, post2, post3, post4, post5]  // Page 1

// After infinite scroll (WRONG)
blogItems: [post6, post7, post8]  // Only page 2 → previous posts lost

// After infinite scroll (CORRECT)  
blogItems: [post1, post2, post3, post4, post5, post6, post7, post8]  // All posts
```

### Guard Conditions Explanation

**Dual protection system**:

```javascript
if (
  this.state.isLoading ||                           // Condition 1
  this.state.blogItems.length === this.state.totalCount  // Condition 2
) {
  return; // Exit function early
}
```

**Condition 1 - Loading protection**:

- **Prevents concurrent requests** - don't call API while already loading
- **Handles quick scrolling** - user scrolls fast before previous request completes
- **Slow internet protection** - prevents multiple requests during slow connections

**Condition 2 - Total count protection**:

- **Prevents unnecessary calls** - don't request more if all records loaded
- **Mathematical check** - current loaded equals total available
- **Example**: `blogItems.length: 18` === `totalCount: 18` → all records loaded

### Early Return Pattern

**JavaScript early return**:

```javascript
function example() {
  if (condition) {
    return; // Stops function execution immediately
  }

  // This code only runs if condition is false
  doSomething();
}
```

**Benefits**:

- **Clean code** - avoid nested if/else blocks
- **Performance** - exit early when conditions not met
- **Bug prevention** - prevent execution when shouldn't happen

### Professional Feature Building Approach

**Methodical development process demonstrated**:

1. **Plan the feature** - understand desired behaviour
2. **Identify components** - break down into pieces
3. **Build incrementally** - scroll detection → API calls → concatenation → guards
4. **Test each piece** - verify functionality step by step
5. **Handle edge cases** - loading states, quick scrolling, end of data
6. **Professional polish** - smooth user experience

---

## ✋ Verification

### Complete Infinite Scroll Testing

**Full workflow verification**:

1. **Navigate to /blog** page
2. **Initial load** - first 10 blog posts appear, spinner disappears
3. **Scroll to bottom** slowly - observe loading spinner appears
4. **New posts load** - additional posts appear below existing ones
5. **Continue scrolling** - process repeats until all posts loaded
6. **End state** - no more spinner appears when all posts loaded

### Console Verification

**API call verification**:

```javascript
// First load
getting { portfolio_blogs: [10 items], meta: { total_records: 18 } }

// After first infinite scroll  
getting { portfolio_blogs: [8 items], meta: { total_records: 18 } }

// After reaching end (no more calls should appear)
```

### State Progression Testing

**React DevTools state inspection**:

```javascript
// Initial state
blogItems: []
currentPage: 0
totalCount: 0
isLoading: true

// After first load
blogItems: [10 items]
currentPage: 1  
totalCount: 18
isLoading: false

// After infinite scroll
blogItems: [18 items]  // All items concatenated
currentPage: 2
totalCount: 18
isLoading: false
```

### Edge Case Testing

**Quick scrolling behaviour**:

1. **Scroll quickly to bottom** multiple times
2. **Should not trigger** multiple simultaneous API calls
3. **Loading state** should prevent concurrent requests
4. **Final result** should be correct number of posts

### Guard Condition Testing

**Total count protection**:

1. **Scroll to load all posts** - reach totalCount
2. **Continue scrolling** - should not trigger more API calls
3. **Console should be quiet** - no additional "getting" logs
4. **Spinner should not appear** - loading state protection working

---

## 🎨 User Experience Achievement

### Seamless Social Media Experience

**What we've built matches**:

- **Facebook newsfeed** - smooth infinite scroll
- **Instagram feed** - automatic content loading
- **Twitter timeline** - no pagination buttons needed

### Professional UX Features

**Loading indicators**:

- **Initial load** - spinner shows during first API call
- **Infinite scroll** - spinner appears at bottom when loading more
- **No jarring transitions** - smooth content appearance

**Performance optimisations**:

- **No unnecessary API calls** - guard conditions prevent waste
- **Smooth scrolling** - no blocking operations
- **Responsive loading** - works on fast and slow connections

### Real-World Application

**This pattern works for**:

- **Blog posts** (current implementation)
- **E-commerce products** - infinite product listings
- **Social feeds** - user posts, comments
- **Search results** - paginated search without page buttons
- **Image galleries** - photo browsing experiences

---
