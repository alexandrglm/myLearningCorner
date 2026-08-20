# 10-221: Modifying Posts Component to Render Different JSX Based on Prop

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/modifying-posts-component-render-different-jsx-based-prop)**
---

**Mock API**: Post component now renders different layouts based on type prop.

## 🎯 Objectives

**Make Post component flexible for different layouts**:
- **Type prop** - "recent" vs "result" rendering
- **Conditional JSX** - different structure per type
- **renderLinks function** - handle post_links array
- **Dynamic content** - adapt to API data structure

---

## 🛠️ Implementation

### 1. Add Type Props to Parent Components

**RecentPosts**:
```javascript
renderPosts = function() {
    const posts = this.props.recentPosts.map((post, index) => {
        if(index < 3) {
            return (
                <Post type="recent" {...post} key={index}/>
            )
        }
    })
    return posts;
}
```

**ResultsPosts**:
```javascript
renderPosts() {
    const posts = this.props.posts.map((post, index) => {
        return <Post type="result" key={index} {...post} />
    })
    return posts;
}
```

### 2. Update Post Component Conditional Rendering

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

    renderLinks() {
        let links = this.props.post_links.map((post_link, index) => {
            return (
                <div className="post-link" key={index}>
                    <div className="post-link__box"></div>
                    <div className="post-link__link">
                        <a href={post_link.link_url}>Useful Link #{index + 1}</a>
                    </div>
                </div>
            )
        })
        return links;
    }

    render() {
        if(this.props.type == 'recent') {
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
        } else if(this.props.type == 'result') {
            return (
                <li className="result-post">
                    <div className="result-post__topics">
                        {this.renderTopics()}
                    </div>
                    <div className="result-post__title">
                        {this.props.title}
                    </div>
                    <div className="result-post__links">
                        {this.renderLinks()}
                    </div>
                </li>
            )
        }
    }
}

export default Post;
```

---

## 📧 Technical Concepts

### Conditional Component Rendering

**Pattern used**:
```javascript
if(this.props.type == 'recent') {
    return <RecentLayout />
} else if(this.props.type == 'result') {
    return <ResultLayout />
}
```

### Data Structure Differences

**associated_topics**: Array of strings
```javascript
["JavaScript", "React", "CSS"]
```

**post_links**: Array of objects
```javascript
[
    { link_url: "https://example.com" },
    { link_url: "https://another.com" }
]
```

### Index + 1 Pattern

```javascript
<a>Useful Link #{index + 1}</a>
```

**Why add 1**: Arrays start at 0, but user-facing numbers should start at 1

---

## 📋 Layout Differences

### Recent Posts Layout
1. **Title** - post title
2. **Topics** - associated topics below

### Result Posts Layout  
1. **Topics** - associated topics on top
2. **Title** - post title in middle
3. **Links** - useful links at bottom

### Link Structure
- **post-link** - container div
- **post-link__box** - empty box (future image placeholder)
- **post-link__link** - link with href to external URL

---
