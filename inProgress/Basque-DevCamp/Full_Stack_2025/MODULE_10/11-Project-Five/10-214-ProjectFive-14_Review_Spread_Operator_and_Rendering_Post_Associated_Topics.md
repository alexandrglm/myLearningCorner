# 10-214: Review Spread Operator and Rendering Post Associated Topics

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/review-spread-operator-rendering-post-associated-topics)**
---

**Mock API**: Associated topics from `http://localhost:3001/posts` array rendered as tags.

## 🎯 Objectives

**Complete Post component with associated topics**:
- **Spread operator review** - how props are passed
- **Associated topics rendering** - map over topics array
- **Component structure** - title + topics layout
- **Basic styling** - margin for visual separation

---

## 🛠️ Implementation

### 1. Update Post Component Structure

**File**: `src/components/post.js`

```javascript
import React, { Component } from 'react';

class Post extends Component {
    renderTopics() {
        let topics = this.props.associated_topics.map((topic, index) => {
            return <span className="post-topic" key={index}>{topic}</span>
        })
        return topics;
    }

    render() {
        return (
            <li className="recent-post">
                <div className="recent-post__title">
                    {this.props.title}
                </div>
                <div className="recent-post__topics">
                    {this.renderTopics()}
                </div>
            </li>
        )
    }
}

export default Post;
```

### 2. Add Basic Topic Styling

**File**: `src/style/main.scss`

```scss
.post-topic {
    margin: 0 4px;
}
```

---

## 📧 Spread Operator Review

### How Props are Passed

**In RecentPosts**:
```javascript
<Post key={index} {...post} />
```

**Equivalent to writing**:
```javascript
<Post 
    key={index}
    id={post.id}
    title={post.title}
    associated_topics={post.associated_topics}
    // ... all other post properties
/>
```

### Benefits of Spread Operator

- **Less code** - no need to write each prop manually
- **Future-proof** - new API properties automatically passed
- **Maintainability** - changes only needed in Post component
- **Cleaner syntax** - reduces RecentPosts component complexity

---

## 📧 Technical Concepts

### RenderTopics Function

**Purpose**: Separate rendering logic for better organisation
**Pattern**: Map over array, return JSX elements
**Key prop**: Required for React list rendering optimisation

### Component Structure

```javascript
<li className="recent-post">          // Container
  <div className="recent-post__title"> // Title section
  <div className="recent-post__topics"> // Topics section
```

**BEM naming**: Block__element pattern for CSS organisation

---
