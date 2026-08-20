# 10-209: Redux Thunk - Connecting Recent Posts Component to Redux

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/redux-thunk-connecting-recent-posts-component-redux)**

[setup results component · bottega-code-school/DailySmartyUI@8aaf531 · GitHub](https://github.com/bottega-code-school/DailySmartyUI/commit/8aaf531f2dfb3cf7881e1ad97e7683f362f66bf4)

---

## 🎯 Objectives

**Setup Redux Thunk and connect RecentPosts**:

- **API analysis** - DailySmarty API structure
- **Redux Thunk installation** - async action middleware
- **Action creator** - fetchRecentPosts function
- **Component connection** - RecentPosts to Redux

---

## 🛠️ API Analysis

### DailySmarty API Endpoint

**URL**: `https://api.dailysmarty.com/posts`

**Response structure** (via Postman):

```json
{
    "id": 123,
    "title": "Post title",
    "content": "Post content...",
    "created_at": "date",
    "url_for_post": "link",
    "associated_topics": ["JavaScript", "React"],
    "post_links": [...]
}
```

**Data needed for UI**:

- **title** - post title for display
- **associated_topics** - tags for each post

---

## 🛠️ Redux Thunk Setup

### 1. Install Redux Thunk

```bash
npm install --save redux-thunk
```

### 2. Configure Middleware

**File**: `src/bootstrap.js`

```javascript
import React from 'react';
import ReactDOM from 'react-dom';
import { Provider } from 'react-redux';
import { createStore, applyMiddleware } from 'redux';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import thunk from 'redux-thunk';

import reducers from './reducers';

const createStoreWithMiddleware = applyMiddleware(thunk)(createStore);

// ... rest of imports

function main() {
    ReactDOM.render(
        <Provider store={createStoreWithMiddleware(reducers)}>
            <BrowserRouter>
                <Switch>
                    <Route path='/' exact component={Home}/>
                    <Route path='/results' component={Results}/>
                </Switch>
            </BrowserRouter>
        </Provider>
        , document.querySelector('.app-wrapper'));
}
```

---

## 🛠️ Action Creator

### Create fetchRecentPosts Action

**File**: `src/actions/index.js`

```javascript
export function fetchRecentPosts() {
    return function(dispatch) {
        console.log('hello');
        // API request will go here
    }
}
```

**Redux Thunk pattern**:

- **Returns function** - instead of plain object
- **Function receives dispatch** - for async operations
- **Dispatch actions** - when async operations complete

---

## 🛠️ Connect RecentPosts Component

### 1. Setup Redux Connection

**File**: `src/components/recentPosts.js`

```javascript
import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as actions from '../actions';

class RecentPosts extends Component {
    componentDidMount() {
        this.props.fetchRecentPosts();
    }

    render() {
        return (
            <div className="recent-posts">
                <div className="recent-posts__wrapper">
                    <div className="recent-posts__heading">Recent Posts</div>
                    <ul className="recent-posts__posts">
                        <li>recent post 0</li>
                        <li>recent post 1</li>
                        <li>recent post 2</li>
                    </ul>
                </div>
            </div>
        );
    }
}

export default connect(null, actions)(RecentPosts);
```

---

## 📧 Technical Concepts

### Redux Thunk Middleware

**What it enables**:

- **Async actions** - API calls in action creators
- **Function dispatch** - return functions instead of objects
- **Delayed dispatch** - dispatch after async operations complete

### Connect Parameters

```javascript
connect(mapStateToProps, mapDispatchToProps)(Component)
```

**Current implementation**:

- **mapStateToProps**: null - no state mapping yet
- **mapDispatchToProps**: actions - bind all actions to props

### componentDidMount Usage

**Why componentDidMount**:

- **Component mounted** - DOM ready, safe for API calls
- **One-time execution** - perfect for initial data fetch
- **Access to props** - Redux actions available via this.props

---

## 📧 Troubleshooting Issues

### Redux-Form Dependency Issue

**Problem encountered**:

- **Cannot resolve redux-form** - dependency missing
- **Solution**: reinstall redux-form

```bash
npm install --save redux-form
```

### Component Naming Bug

**Problem**: Component class named SearchBar instead of RecentPosts
**Solution**: 

```javascript
class RecentPosts extends Component {
    // ...
}
export default connect(null, actions)(RecentPosts);
```

---

## 📋 Verification

**Testing setup**:

1. **Page reload** - check console for "hello"
2. **Redux DevTools** - verify action dispatched
3. **No errors** - component renders correctly
4. **Action creator** - fetchRecentPosts accessible via props

**Expected console output**: "hello" appears when page loads

---
