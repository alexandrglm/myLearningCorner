# 10-216: Modifying SearchBar Component to Take onSubmit Function Props

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/modifying-search-bar-component-take-onsubmit-function-props)**
---

**Mock API**: SearchBar now flexible for different endpoints via props functions.

## 🎯 Objectives

**Make SearchBar reusable with custom submit logic**:
- **Extract navigation logic** - move from SearchBar to parent components
- **Props-based callbacks** - pass onSubmit function as prop
- **Component reusability** - same SearchBar, different behaviours
- **Scalable architecture** - future functionality flexibility

---

## 🛠️ Implementation

### 1. Update SearchBar Component

**File**: `src/components/searchBar.js`

```javascript
import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';
import { withRouter } from 'react-router-dom';

class SearchBar extends Component {
    handleFormSubmit({query}) {
        this.props.onSubmit(query);
    }

    renderInput(field) {
        return <input 
                type="text" 
                placeholder="Search DailySmarty" 
                {...field.input} 
               />;
    }

    render() {
        const { handleSubmit } = this.props;
        
        return (
            <form 
                className="search-bar" 
                onSubmit={handleSubmit(this.handleFormSubmit.bind(this))}
            >
                <Field name="query" component={this.renderInput}/>
            </form>
        );
    }
}

SearchBar = reduxForm({
    form: 'searchBar'
})(SearchBar);

SearchBar = withRouter(SearchBar);

export default SearchBar;
```

### 2. Update Home Component

**File**: `src/components/home.js`

```javascript
import React, { Component } from 'react';
import Logo from './logo';
import SearchBar from './searchBar';
import RecentPosts from './recentPosts';

export default class Home extends Component {
    handleSearchbarSubmit(query) {
        console.log('trying to handle submit for query', query);
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
```

### 3. Update Results Component

**File**: `src/components/results.js`

```javascript
import React, { Component } from 'react';
import Logo from './logo';
import SearchBar from './searchBar';

class Results extends Component {
    handleSearchbarSubmit(query) {
        console.log(query);
        // Future: API search functionality
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

export default Results;
```

---

## 📧 Technical Concepts

### Callback Props Pattern

**Function flow**:
1. **SearchBar calls** - `this.props.onSubmit(query)`
2. **Parent receives** - `(query) => this.handleSearchbarSubmit(query)`
3. **Parent processes** - custom logic per component

### Arrow Function vs Regular Function

**Arrow function** (used):
```javascript
onSubmit={(query) => this.handleSearchbarSubmit(query)}
```

**Regular function** (equivalent):
```javascript
onSubmit={function(query) { this.handleSearchbarSubmit(query) }}
```

### Component Reusability Benefits

- **Same SearchBar** - different submit behaviours
- **Scalable** - easy to add new search types
- **Maintainable** - logic separated by concern
- **Future-proof** - can search topics, users, etc.

---

## 📋 Function Chain Explanation

**Three functions involved**:

1. **SearchBar.handleFormSubmit** - receives {query} from Redux-Form
2. **Parent arrow function** - receives query parameter
3. **Parent.handleSearchbarSubmit** - processes query with custom logic

**Data flow**:
```
Redux-Form → SearchBar.handleFormSubmit({query}) → 
this.props.onSubmit(query) → 
Parent arrow function (query) → 
Parent.handleSearchbarSubmit(query)
```

---
