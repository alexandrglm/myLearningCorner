# 10-219: Creating SET_RESULTS_POSTS Type and Reducer

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-set-results-posts-type-reducer)**
---

**Mock API**: Search results data now properly stored in Redux state via SET_RESULTS_POSTS.

## 🎯 Objectives

**Create reducer to handle search results**:
- **SET_RESULTS_POSTS type** - new action type for search results
- **Reducer case** - handle search results in postsReducer
- **Action dispatch** - update fetchPostsWithQuery to dispatch results
- **State separation** - recentPosts vs resultsPosts data

---

## 🛠️ Implementation

### 1. Add New Action Type

**File**: `src/actions/types.js`

```javascript
export const SET_RECENT_POSTS = 'SET_RECENT_POSTS';
export const SET_RESULTS_POSTS = 'SET_RESULTS_POSTS';
```

### 2. Import and Dispatch in Action

**File**: `src/actions/index.js`

```javascript
import axios from 'axios';
import { SET_RECENT_POSTS, SET_RESULTS_POSTS } from './types';

export function fetchPostsWithQuery(query) {
    return function(dispatch) {
        axios.get(`http://localhost:3001/posts?title_like=${query}`)
            .then(response => {
                console.log(response.data);
                dispatch({
                    type: SET_RESULTS_POSTS,
                    payload: response.data
                });
            });
    }
}
```

### 3. Update Posts Reducer

**File**: `src/reducers/postsReducer.js`

```javascript
import { SET_RECENT_POSTS, SET_RESULTS_POSTS } from '../actions/types';

const INIT_STATE = {
    resultsPosts: [],
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
        case SET_RESULTS_POSTS:
            const resultsPosts = action.payload;
            return {
                ...state,
                resultsPosts
            }
        default:
            return state;
    }
}
```

---

## 📧 Technical Concepts

### State Structure Separation

**Before**:
```javascript
{
    posts: [],      // Generic posts array
    recentPosts: []
}
```

**After**:
```javascript
{
    resultsPosts: [], // Search results
    recentPosts: []   // Home page posts
}
```

### Redux DevTools Verification

**Expected state structure**:
- **posts.recentPosts** - populated from home page
- **posts.resultsPosts** - populated from search queries
- **Independent data** - different content, separate updates

### Action Dispatching Logic

**fetchRecentPosts** → SET_RECENT_POSTS → recentPosts
**fetchPostsWithQuery** → SET_RESULTS_POSTS → resultsPosts

---

## 📋 Testing Results

**Search flow verification**:
1. **Search "rails"** - dispatches SET_RESULTS_POSTS
2. **Check Redux DevTools** - resultsPosts contains search results
3. **Visit home page** - recentPosts remains unchanged
4. **Search "python"** - resultsPosts updates with new results

**Data separation confirmed**:
- **Different quantities** - 7 search results vs 9 recent posts
- **Different content** - associated topics vary
- **Independent updates** - one doesn't affect the other

---
