# 10-213: Creating Post Component Daily Smarty UI

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-post-component-daily-smarty-ui)**
---

**Mock API**: Data from `http://localhost:3001/posts` passed as props to Post component.

## 🎯 Objectives

**Create reusable Post component**:
- **Separate component** - extract post rendering logic
- **Props-based rendering** - receive post data as props
- **Code organisation** - cleaner component structure
- **Spread operator** - pass all post attributes

---

## 🛠️ Implementation

### 1. Create Post Component

**File**: `src/components/post.js`

```javascript
import React, { Component } from 'react';

class Post extends Component {
    render() {
        return (
            <li>
                {this.props.title}
            </li>
        );
    }
}

export default Post;
```

### 2. Update RecentPosts Component

**File**: `src/components/recentPosts.js`

```javascript
import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as actions from '../actions';
import Post from './post';

class RecentPosts extends Component {
    componentDidMount() {
        this.props.fetchRecentPosts();
    }

    renderPosts = function() {
        const posts = this.props.recentPosts.map((post, index) => {
            if(index < 3) {
                return (
                    <Post key={index} {...post} />
                )
            }
        })
        return posts;
    }

    render() {
        return (
            <div className="recent-posts">
                <div className="recent-posts__wrapper">
                    <div className="recent-posts__heading">Recent Posts</div>
                    <ul className="recent-posts__posts">
                        {this.renderPosts()}
                    </ul>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        recentPosts: state.posts.recentPosts
    }
}

export default connect(mapStateToProps, actions)(RecentPosts);
```

---

## 📧 Concepts

### Props vs Direct Data Access
**Before**: `post.title` - direct object access
**After**: `this.props.title` - props-based access

### Spread Operator Usage
```javascript
<Post {...post} />
```
**Equivalent to**:
```javascript
<Post 
    id={post.id}
    title={post.title} 
    content={post.content}
    created_at={post.created_at}
    url_for_post={post.url_for_post}
    associated_topics={post.associated_topics}
    post_links={post.post_links}
/>
```

### Key Prop Placement
- **Key on component** - `<Post key={index} />`
- **Not on JSX element** - removed from `<li>` tag
- **React requirement** - for list rendering optimisation

---

## 📋 Component Benefits

**Code organisation**:
- **Separation of concerns** - Post logic separate from list logic
- **Reusability** - Post component can be used elsewhere
- **Maintainability** - easier to modify post rendering
- **Testing** - isolated component testing possible

---
