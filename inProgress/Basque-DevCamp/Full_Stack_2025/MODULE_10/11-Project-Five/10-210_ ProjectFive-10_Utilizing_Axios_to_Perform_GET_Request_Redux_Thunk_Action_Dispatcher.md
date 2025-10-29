# 10-210: Utilising Axios to Perform GET Request Redux Thunk Action Dispatcher

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/utilizing-axios-perform-get-request-redux-thunk-action-dispatcher)**
---

**Mock API**: Using `http://localhost:3001/posts` instead of original DailySmarty API.

## 🎯 Objectives

**Implement GET request with Axios and Redux Thunk**:
- **Axios installation** and GET request
- **Action type creation** - SET_RECENT_POSTS
- **Reducer setup** - postsReducer to handle data
- **Dispatch action** - send data to Redux store

---

## 🛠️ Implementation

### 1. Install Axios

```bash
npm install --save axios
```

### 2. Create Action with Axios Request

**File**: `src/actions/index.js`

```javascript
import axios from 'axios';
import { SET_RECENT_POSTS } from './types';

export function fetchRecentPosts() {
    return function(dispatch) {
        axios.get('http://localhost:3001/posts')
            .then(response => {
                console.log(response.data);
                dispatch({
                    type: SET_RECENT_POSTS,
                    payload: response.data
                });
            });
    }
}
```

### 3. Create Action Types

**File**: `src/actions/types.js`

```javascript
export const SET_RECENT_POSTS = 'SET_RECENT_POSTS';
```

### 4. Create Posts Reducer

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
            return {
                ...state,
                recentPosts: action.payload
            }
        default:
            return state;
    }
}
```

### 5. Add Reducer to Store

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

---

## 📧 Concepts

### Axios vs Promises
- **Axios syntax** - cleaner than fetch
- **.then() chain** - handle async responses
- **response.data** - Axios wraps response

### Redux Flow Complete
1. **Component calls action** - this.props.fetchRecentPosts()
2. **Action makes request** - axios.get()
3. **Response dispatched** - dispatch({ type, payload })
4. **Reducer updates state** - return new state
5. **Component re-renders** - with updated data

### Data Structure
- **response.data** - full API response
- **Mock API returns** - array of posts directly
- **Original API had** - { posts: [...] } wrapper

---

## 📋 Verification

**Console should show**:
- **API response data** - posts array from mock API
- **No reducer errors** - SET_RECENT_POSTS action working
- **Component mounts** - fetchRecentPosts called on load

---
