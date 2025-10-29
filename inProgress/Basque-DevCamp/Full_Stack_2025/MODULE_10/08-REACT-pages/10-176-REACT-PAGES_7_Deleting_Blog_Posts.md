# 10-176: Enabling Delete Blog Posts Feature

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/enabling-ability-delete-blog-posts)**
https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/b03d6635aa9bcb0fe3ac47c77ee199aa07912d23
---

## 🎯 Objectives

**Delete functionality for blog posts**:
- **Conditional rendering** - trash icon only if logged in
- **API delete call** - remove from server
- **State update** - filter deleted item locally

---

## 🛠️ Implementation

### 1. Conditional Rendering in Blog Component

```javascript
render() {
    const blogRecords = this.state.blogItems.map(blogItem => {
        if (this.props.loggedInStatus === "LOGGED_IN") {
            return (
                <div key={blogItem.id} className="admin-blog-wrapper">
                    <BlogItem blogItem={blogItem} />
                    <a onClick={() => this.handleDeleteClick(blogItem)}>
                        <FontAwesomeIcon icon="trash" />
                    </a>
                </div>
            );
        } else {
            return <BlogItem key={blogItem.id} blogItem={blogItem} />;
        }
    });

    return (
        <div className="blog-container">
            <div className="content-container">
                {blogRecords}
            </div>
        </div>
    );
}
```

### 2. Bind and Create handleDeleteClick

```javascript
constructor() {
    super();
    // ... other bindings
    this.handleDeleteClick = this.handleDeleteClick.bind(this);
}

handleDeleteClick(blog) {
    axios
        .delete(`https://api.devcamp.space/portfolio/portfolio_blogs/${blog.id}`, 
                { withCredentials: true })
        .then(response => {
            this.setState({
                blogItems: this.state.blogItems.filter(blogItem => {
                    return blog.id !== blogItem.id;
                })
            });
            return response.data;
        })
        .catch(error => {
            console.log("delete blog error", error);
        });
}
```

### 3. Styling for Admin Wrapper

**File**: `src/style/blog.scss`

```scss
.blog-container {
    .admin-blog-wrapper {
        display: flex;
        justify-content: space-between;
        align-items: center;

        a {
            margin-left: 15px;
            cursor: pointer;
        }
    }
}
```

---

## 📧 Concepts

### Key Prop in Wrapper
```javascript
// Key must be on outermost element
<div key={blogItem.id} className="admin-blog-wrapper">
```

### Anonymous Function for onClick
```javascript
onClick={() => this.handleDeleteClick(blogItem)}
// Prevents auto-execution at render
```

### Array.filter() for State Update
```javascript
blogItems: this.state.blogItems.filter(blogItem => {
    return blog.id !== blogItem.id; // Keep all except deleted
})
```

---

## 📋 Verification

**Testing**:
1. **Logged in** - trash icons visible
2. **Logged out** - no trash icons
3. **Click trash** - removes from server + state
4. **Layout** - trash icons aligned right

---
