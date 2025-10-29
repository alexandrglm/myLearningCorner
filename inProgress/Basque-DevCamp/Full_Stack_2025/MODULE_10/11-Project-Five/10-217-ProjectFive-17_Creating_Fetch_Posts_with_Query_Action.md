# 10-217: Creating Fetch Posts with Query Action

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-fetch-posts-query-action)**
---

**Mock API**: Using `http://localhost:3001/posts?title_like=query` for search functionality.

## 🎯 Objectives

**Create search action for query-based posts**:
- **fetchPostsWithQuery action** - search posts by query parameter
- **Connect Home component** - to Redux for action dispatch
- **Connect Results component** - same search functionality
- **Template literal URL** - dynamic query parameter

---

## 🛠️ Implementation

### 1. Create fetchPostsWithQuery Action

**File**: `src/actions/index.js`

```javascript
import axios from 'axios';
import { SET_RECENT_POSTS } from './types';

export function fetchRecentPosts() {
    return function(dispatch) {
        axios.get('http://localhost:3001/posts')
            .then(response => {
                dispatch({
                    type: SET_RECENT_POSTS,
                    payload: response.data
                });
            });
    }
}

export function fetchPostsWithQuery(query) {
    return function(dispatch) {
        axios.get(`http://localhost:3001/posts?title_like=${query}`)
            .then(response => {
                console.log(response.data);
                // dispatch will be added later
            });
    }
}
```

### 2. Connect Home Component to Redux

**File**: `src/components/home.js`

```javascript
import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as actions from '../actions';

import Logo from './logo';
import SearchBar from './searchBar';
import RecentPosts from './recentPosts';

class Home extends Component {
    handleSearchbarSubmit(query) {
        this.props.fetchPostsWithQuery(query);
        this.props.history.push('/results');
    }

    render() {
        return (
            <div>
                <div>
                    <Logo />
                    <SearchBar onSubmit={(query) => this.handleSearchbarSubmit(query)} />
                    <RecentPosts />
                </div>
            </div>
        );
    }
}

export default connect(null, actions)(Home);
```

### 3. Connect Results Component to Redux

**File**: `src/components/results.js`

```javascript
import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as actions from '../actions';

import Logo from './logo';
import SearchBar from './searchBar';

class Results extends Component {
    handleSearchbarSubmit(query) {
        this.props.fetchPostsWithQuery(query);
    }

    render() {
        return (
            <div>
                <Logo size={55} />
                <SearchBar onSubmit={(query) => this.handleSearchbarSubmit(query)} />
            </div>
        );
    }
}

export default connect(null, actions)(Results);
```

---

## 📧 Technical Concepts

### Template Literal URL Construction

```javascript
axios.get(`http://localhost:3001/posts?title_like=${query}`)
```

**Benefits**:
- **Dynamic query** - interpolates search term
- **Clean syntax** - easier than string concatenation
- **URL encoding** - browser handles special characters

### Connect Pattern for Actions Only

```javascript
export default connect(null, actions)(Component);
```

**Parameters**:
- **First**: null - no state mapping needed
- **Second**: actions - all action creators as props

### Async Navigation Issue

**Current problem**:
1. **User searches** - "rails"
2. **Navigation immediate** - push('/results')
3. **API call started** - but not complete
4. **Results page loads** - before data available

---

## 📋 Mock API Search Queries

**Available search patterns**:
```
http://localhost:3001/posts?title_like=react
http://localhost:3001/posts?title_like=javascript
http://localhost:3001/posts?associated_topics_like=CSS
```

**Response structure**: Same as fetchRecentPosts - array of post objects

---
