# 10-211: How to Utilise Redux DevTools and Fix Set Recent Posts Reducer

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-utilize-redux-dev-tools-fix-set-recent-posts-reducer)**
---

**Mock API**: Using `http://localhost:3001/posts` - data structure verified via Redux DevTools.

## 🎯 Objectives

**Setup Redux DevTools and fix reducer**:
- **Redux DevTools extension** - browser debugging tool
- **Bootstrap.js configuration** - add compose function
- **Reducer debugging** - fix data structure issue
- **State verification** - confirm posts data in store

---

## 🛠️ Implementation

### 1. Install Redux DevTools Extension

**Chrome Web Store**: "Redux DevTools" by remotedev.io

### 2. Configure Bootstrap.js

**File**: `src/bootstrap.js`

```javascript
import { createStore, applyMiddleware, compose } from 'redux';

const createStoreWithMiddleware = applyMiddleware(thunk)(
    compose(
        (window.devToolsExtension ? window.devToolsExtension() : f => f)(createStore)
    )
);
```

### 3. Add Posts Reducer to Store

**File**: `src/reducers/index.js`

```javascript
import { combineReducers } from 'redux';
import { reducer as form } from 'redux-form';
import posts from './postsReducer';

const rootReducer = combineReducers({
    form,
    posts
});

export default rootReducer;
```

### 4. Fix Posts Reducer

**File**: `src/reducers/postsReducer.js`

```javascript
import { SET_RECENT_POSTS } from '../actions/types';

const INIT_STATE = {
    posts: [],
    recentPosts: []
}

export default function(state = INIT_STATE, action) {
    switch(action.type) {
        case SET_RECENT_POSTS:
            const recentPosts = action.payload;
            return {
                ...state,
                recentPosts
            }
        default:
            return state;
    }
}
```

---

## 📧 Concepts

### Redux DevTools Usage
- **Right-click → Inspect** - access DevTools
- **Redux tab** - view actions and state
- **Action tab** - see dispatched actions
- **State tab** - current Redux state structure

### Compose Function
- **Redux utility** - combine multiple store enhancers
- **DevTools integration** - adds debugging capability
- **Conditional check** - window.devToolsExtension exists

### Reducer Data Structure
- **Return object** - not array
- **Spread state** - maintain other state properties
- **action.payload** - contains API response data

---

## 📋 DevTools Verification

**State structure should show**:
```
state: {
    form: { ... },  // Redux-Form data
    posts: {
        posts: [],
        recentPosts: [...]  // API data here
    }
}
```

**Actions should show**:
- **SET_RECENT_POSTS** - with payload containing mock API data

---
