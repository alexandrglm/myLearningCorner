# 10-208: Implementing withRouter HOC for Navigation

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/implementing-hoc-called-router)**

[added exact route for home route and implemented withRouter HOC into … · bottega-code-school/DailySmartyUI@22c10da · GitHub](https://github.com/bottega-code-school/DailySmartyUI/commit/22c10da4bb7e0d57a1387efc27c4148bfcbf5cda)

---

## 🎯 Objectives

**Programmatic navigation with withRouter HOC**:

- **withRouter import** - access router props in SearchBar
- **History.push implementation** - navigate to /results
- **Form submission navigation** - complete search flow
- **HOC pattern understanding** - higher order component usage

---

## 🛠️ withRouter HOC Implementation

### 1. Import withRouter

**File**: `src/components/searchBar.js`

```javascript
import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';
import { withRouter } from 'react-router-dom';
```

### 2. Add Navigation to handleFormSubmit

```javascript
class SearchBar extends Component {
    handleFormSubmit({query}) {
        console.log('trying to handle submit for query', query);
        this.props.history.push('/results');
    }

    // ... rest of component
}
```

### 3. Wrap Component with withRouter

```javascript
SearchBar = reduxForm({
    form: 'searchBar'
})(SearchBar);

SearchBar = withRouter(SearchBar);

export default SearchBar;
```

---

## 📧 Higher Order Component (HOC) Concept

### What is withRouter?

**Higher Order Component pattern**:

- **Function that takes component** - returns enhanced component
- **Provides router props** - history, location, match
- **Non-route components** - access to routing functionality
- **React Router built-in** - ready-to-use HOC

### HOC Composition Chain

**Multiple HOCs applied**:

```javascript
// Step 1: Redux-Form HOC
SearchBar = reduxForm({ form: 'searchBar' })(SearchBar);

// Step 2: Router HOC  
SearchBar = withRouter(SearchBar);
```

**Result**: Component enhanced with both form and routing capabilities

### Exploring HOC Source Code

**Learning technique demonstrated**:

- **Command+Click** - into withRouter function
- **Read source code** - understand implementation
- **Interface files** - see function signatures
- **Professional habit** - understanding third-party code

---

## 📧 History.push Method

### Router Props Provided

**withRouter provides**:

- **history** - navigation methods
- **location** - current URL information  
- **match** - route matching details

### Navigation Implementation

```javascript
this.props.history.push('/results');
```

**Method explanation**:

- **history.push()** - programmatic navigation
- **Adds to browser history** - back button works
- **Immediate navigation** - route change happens instantly

---

## 📋 Complete Search Flow

### User Journey Now Working

1. **User types query** - in home page search box
2. **Hits enter** - form submission triggered
3. **Console logs query** - debugging confirmation
4. **Navigation occurs** - programmatically to /results
5. **Results page loads** - showing logo and "Results" heading

### Testing Navigation

**Expected behaviour**:

- **Type search term** - e.g., "rails"
- **Press Enter** - should navigate to /results route
- **Browser URL changes** - from / to /results
- **Back button works** - returns to home page

---

## 📧 Future Improvements Mentioned

### Callback Implementation

**Current limitation**:

- **Navigation immediate** - doesn't wait for data
- **Future enhancement** - navigate after API response
- **Callback pattern** - wait for results before routing

### Data Flow Enhancement

**Next development phases**:

- **API integration** - fetch actual search results
- **Query parameters** - pass search terms to results page
- **Loading states** - handle async operations
- **Error handling** - manage API failures

---

## 📋 Verification

**Testing complete search flow**:

1. **Visit home page** - localhost:3000/
2. **Type search query** - any term
3. **Press Enter** - should navigate
4. **Verify URL** - shows /results
5. **Check console** - confirms query logged
6. **Test back button** - returns to home

---

