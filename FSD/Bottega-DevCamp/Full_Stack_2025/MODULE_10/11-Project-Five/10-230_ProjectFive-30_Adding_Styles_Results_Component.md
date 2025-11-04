# 10-230: Adding Styles Results Component

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/adding-styles-results-component)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-30.

---

## 🛠️ Implementation

### 1. Create results.scss and home.scss

**File**: `src/style/results.scss`

```scss
.results {
    @include default-page-layout;
}
```

**File**: `src/style/home.scss`

```scss
.home {
    @include default-page-layout;
}
```

### 2. Create default-page-layout mixin

**File**: `src/style/mixins.scss`

```scss
@mixin default-page-layout {
    height: 100vh;
    width: 66vw;
    display: grid;
    align-content: space-around;
}
```

### 3. Update main.scss

**File**: `src/style/main.scss`

```scss
@import './mixins';
@import './searchBar';
@import './recentPosts';
@import './post';
@import './home';
@import './results';
```

### 4. Update results.js

**File**: `src/components/results.js`

```javascript
import React, { Component } from 'react';

import Logo from './logo';
import SearchBar from './searchBar';
import ResultsPosts from './resultsPosts';

class Results extends Component {
    render() {
        return (
            <div className="results">
                <Logo size={55}/>
                <SearchBar onSubmit={(query) => this.props.fetchPostsWithQuery(query)}/>
                <ResultsPosts {...this.props}/>
            </div>
        )
    }
}

export default Results;
```

---
