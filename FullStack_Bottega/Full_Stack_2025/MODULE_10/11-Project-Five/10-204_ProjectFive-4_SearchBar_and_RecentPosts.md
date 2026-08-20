# 10-204: Creating SearchBar and Recent Posts Components

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-searchbar-recent-posts-components)**

[created recent posts and search bar components and used them in the h… · bottega-code-school/DailySmartyUI@203a1bd · GitHub](https://github.com/bottega-code-school/DailySmartyUI/commit/203a1bdc339f596abe924bea0f29d6a95d8cbf4b)

---

## 🎯 Objectives

**Build remaining home screen components**:

- **SearchBar component** - input field for search functionality
- **RecentPosts component** - list of recent articles
- **Redux-Form preparation** - install for future form handling
- **Basic structure** - before advanced styling and functionality

---

## 🛠️ Prerequisites

### Install Redux-Form

```bash
npm install --save redux-form
```

**Reason for Redux-Form**:

- **Form state management** - handle input changes
- **Integration with Redux** - connect form to app state
- **Advanced form features** - validation, submission handling

---

## 🛠️ SearchBar Component

### Create SearchBar Component

**File**: `src/components/searchBar.js`

```javascript
import React, { Component } from 'react';

class SearchBar extends Component {
    render() {
        return (
            <form>
                <input placeholder="Search DailySmarty"/>
            </form>
        );
    }
}

export default SearchBar;
```

**Component characteristics**:

- **Form wrapper** - prepared for Redux-Form integration
- **Placeholder text** - "Search DailySmarty" 
- **Basic structure** - functionality to be added later

---

## 🛠️ RecentPosts Component

### Create RecentPosts Component

**File**: `src/components/recentPosts.js`

```javascript
import React, { Component } from 'react';

class RecentPosts extends Component {
    render() {
        return (
            <div className="recent-posts">
                <div className="recent-posts__wrapper">
                    <div className="recent-posts__heading">
                        Recent Posts
                    </div>
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

export default RecentPosts;
```

**BEM naming convention**:

- **recent-posts** - block
- **recent-posts__wrapper** - element
- **recent-posts__heading** - element
- **recent-posts__posts** - element

**Array thinking approach**:

- **List items numbered 0, 1, 2** - matches array indexing
- **Prepares mindset** - for dynamic data rendering
- **Professional habit** - zero-based numbering

---

## 🛠️ App Integration

### Update App Component

**File**: `src/components/app.js`

```javascript
import React, { Component } from 'react';
import Logo from './logo';
import SearchBar from './searchBar';
import RecentPosts from './recentPosts';

export default class App extends Component {
    render() {
        return (
            <div>
                <div>
                    <Logo />
                    <SearchBar />
                    <RecentPosts />
                </div>
            </div>
        );
    }
}
```

**Component hierarchy**:

1. **Logo** - top section
2. **SearchBar** - middle section  
3. **RecentPosts** - bottom section

---

## 📧 Development Strategy Explained

### Why Basic Components First

**Approach reasoning**:

- **CSS Grid setup** - needs all components present
- **Structure before styling** - logical development flow
- **Component separation** - individual development focus
- **Testing integration** - ensure components work together

### Layout Progression

**Current state**: vanilla HTML-like layout
**Next steps**: 

1. **Redux-Form integration** - functional search
2. **CSS Grid styling** - proper layout positioning
3. **Component refinement** - individual styling and functionality

---

## 📋 Verification

**Expected browser output**:

1. **Logo image** - daily smarty owl logo
2. **Search input** - with "Search DailySmarty" placeholder
3. **Recent Posts heading** - section title
4. **Three list items** - "recent post 0", "recent post 1", "recent post 2"

**All components stacked vertically** - no styling applied yet

---
