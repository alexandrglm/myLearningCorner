# 10-220: Mapping State to Props in Results Posts Component

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/mapping-state-props-results-posts-component)**
---

**Mock API**: Search results now displaying dynamic content via mapStateToProps.

## 🎯 Objectives

**Connect ResultsPosts to Redux state and enable navigation**:
- **mapStateToProps** - connect to resultsPosts data
- **Dynamic rendering** - map over search results
- **Post component reuse** - same component, different data
- **Logo navigation** - clickable logo returns to home

---

## 🛠️ Implementation

### 1. Update ResultsPosts mapStateToProps

**File**: `src/components/resultsPosts.js`

```javascript
import React, { Component } from 'react';
import { connect } from 'react-redux';
import Post from './post';

class ResultsPosts extends Component {
    renderPosts() {
        const posts = this.props.posts.map((post, index) => {
            return <Post key={index} {...post} />
        })
        return posts;
    }

    render() {
        return (
            <div className="results-posts">
                <div className="results-posts__wrapper">
                    <ul className="results-posts__posts">
                        {this.renderPosts()}
                    </ul>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return {
        posts: state.posts.resultsPosts
    }
}

export default connect(mapStateToProps)(ResultsPosts);
```

### 2. Add Navigation to Logo Component

**File**: `src/components/logo.js`

```javascript
import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Logo extends Component {
    render() {
        const size = {
            height: this.props.size ? this.props.size : 105,
            width: this.props.size ? this.props.size : 105
        }

        return (
            <div className="logo-main">
                <Link to="/">
                    <img 
                        style={size}
                        alt="daily smarty ui image logo big" 
                        src="/assets/ds_circle_logo.png"
                    />
                </Link>
            </div>
        );
    }
}

export default Logo;
```

---

## 📧 Technical Concepts

### Component Reusability Demonstrated

**Same Post component used for**:
- **RecentPosts** - home page recent posts
- **ResultsPosts** - search results posts
- **Identical rendering** - title + associated topics
- **Different data sources** - state.posts.recentPosts vs state.posts.resultsPosts

### MapStateToProps Targeting

```javascript
// Specific path to search results
posts: state.posts.resultsPosts
```

**State structure access**:
- **state.posts** - posts reducer
- **resultsPosts** - search results array
- **Mapped to props.posts** - available as this.props.posts

### Navigation Enhancement

**Logo Link benefits**:
- **User experience** - intuitive navigation
- **State preservation** - doesn't reload app
- **Consistent behaviour** - works from any page

---
