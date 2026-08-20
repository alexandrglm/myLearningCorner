# 10-218: Setting Up Results Posts Component

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/setting-up-results-posts-component)**
---

**Mock API**: ResultsPosts component prepared for displaying search results data.

## 🎯 Objectives

**Create ResultsPosts component for search results**:
- **Component structure** - similar to RecentPosts layout
- **Redux connection** - mapStateToProps setup
- **Results integration** - import into Results page
- **Placeholder content** - ready for dynamic data

---

## 🛠️ Implementation

### 1. Create ResultsPosts Component

**File**: `src/components/resultsPosts.js`

```javascript
import React, { Component } from 'react';
import { connect } from 'react-redux';

class ResultsPosts extends Component {
    render() {
        return (
            <div className="results-posts">
                <div className="results-posts__wrapper">
                    <ul className="results-posts__posts">
                        RESULTS GO HERE
                    </ul>
                </div>
            </div>
        );
    }
}

function mapStateToProps(state) {
    return state;
}

export default connect(mapStateToProps)(ResultsPosts);
```

### 2. Import into Results Component

**File**: `src/components/results.js`

```javascript
import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as actions from '../actions';

import Logo from './logo';
import SearchBar from './searchBar';
import ResultsPosts from './resultsPosts';

class Results extends Component {
    handleSearchbarSubmit(query) {
        this.props.fetchPostsWithQuery(query);
    }

    render() {
        return (
            <div>
                <Logo size={55} />
                <SearchBar onSubmit={(query) => this.handleSearchbarSubmit(query)} />
                <ResultsPosts />
            </div>
        );
    }
}

export default connect(null, actions)(Results);
```

---

## 📧 Technical Concepts

### Component Structure Pattern

**Similar to RecentPosts**:
- **Wrapper div** - main container
- **Inner wrapper** - layout control
- **List element** - posts container
- **BEM naming** - results-posts__wrapper pattern

### MapStateToProps Temporary Setup

```javascript
function mapStateToProps(state) {
    return state;  // Temporary - full state access
}
```

**Why temporary**:
- **Reducer not ready** - posts data not properly structured
- **Debug purposes** - can inspect full state
- **Will be refined** - to specific data slice

### Differences from RecentPosts

**RecentPosts**:
- **componentDidMount** - fetches on load
- **Actions imported** - dispatches fetchRecentPosts

**ResultsPosts**:
- **No actions** - data fetched from parent components
- **No lifecycle hooks** - purely display component
- **mapStateToProps only** - receives data via Redux

---

## 📋 Current Status

**Working functionality**:
- **Component renders** - "RESULTS GO HERE" displays
- **Redux connected** - can access state
- **Integrated in Results** - appears on results page

**Missing functionality**:
- **Reducer action** - no SET_RESULTS_POSTS handling
- **Dynamic content** - placeholder text only
- **Data mapping** - posts not properly structured in state

**Redux DevTools shows**:
- **posts.recentPosts** - populated on home page
- **posts.posts** - empty (needs reducer update)

---
