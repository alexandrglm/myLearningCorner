# 10-212: Using Redux Map State to Props Function Recent Posts Component

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/using-redux-map-state-props-function-recent-posts-component)**
---

**Mock API**: Data from `http://localhost:3001/posts` mapped to component props.

## 🎯 Objectives

**MapStateToProps implementation**:
- **mapStateToProps function** - connect Redux state to props
- **Dynamic rendering** - map over posts data
- **Limit display** - show only 3 recent posts
- **Component data flow** - Redux store to UI

---

## 🛠️ Implementation

### 1. Create mapStateToProps Function

**File**: `src/components/recentPosts.js`

```javascript
function mapStateToProps(state) {
    return {
        recentPosts: state.posts.recentPosts
    }
}

export default connect(mapStateToProps, actions)(RecentPosts);
```

### 2. Render Posts Dynamically

```javascript
class RecentPosts extends Component {
    componentDidMount() {
        this.props.fetchRecentPosts();
    }

    renderPosts = function() {
        const posts = this.props.recentPosts.map((post, index) => {
            if(index < 3) {
                return (
                    <li key={index}>
                        {post.title}
                    </li>
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
```

---

## 📧 Concepts

### MapStateToProps Pattern
- **Function parameter**: state - entire Redux store
- **Return object**: props mapped to component
- **State path**: `state.posts.recentPosts` - specific data slice

### Array Index Logic
- **Index < 3**: displays items 0, 1, 2 (3 total items)
- **Zero-based indexing**: arrays start at 0
- **Real-world analogy**: child age starts at 0 years, not 1

### Connect Function Complete
```javascript
connect(mapStateToProps, mapDispatchToProps)(Component)
```
- **First parameter**: mapStateToProps - state to props
- **Second parameter**: actions - dispatch functions to props

---

## 📋 Verification

**Component should display**:
- **"Recent Posts" heading**
- **3 post titles** from mock API data
- **Dynamic content** - from Redux store
- **No hardcoded list items**

**Debug steps**:
- **Check Redux DevTools** - verify recentPosts data
- **Console undefined errors** - ensure mapStateToProps connected
- **Component re-render** - after API data loads

---
