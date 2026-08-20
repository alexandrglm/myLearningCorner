# 10-205: Setting Up Redux Form in SearchBar Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/setting-up-redux-form-searchbar-component)**

[setup redux form in searchbar.js · bottega-code-school/DailySmartyUI@83f0575 · GitHub](https://github.com/bottega-code-school/DailySmartyUI/commit/83f0575d73fdadd1e157ab1013723872a8a5db99)

---

## 🎯 Objectives

**Redux-Form integration in SearchBar**:

- **Field component** - replace regular input with Redux-Form Field
- **Form reducer** - add to Redux store
- **HandleSubmit functionality** - capture form data
- **Form submission** - console log query for testing

---

## 🛠️ Redux-Form Setup

### 1. Import Redux-Form Components

**File**: `src/components/searchBar.js`

```javascript
import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';
```

### 2. Create renderInput Function

```javascript
class SearchBar extends Component {
    renderInput(field) {
        return <input 
                type="text" 
                placeholder="Search DailySmarty" 
                {...field.input} 
               />;
    }
}
```

**Spread operator explanation**:

- **{...field.input}** - spreads all input properties
- **Maps Redux-Form props** - to regular input element
- **Handles onChange, onBlur, etc** - automatically

### 3. Implement Form Submission

```javascript
class SearchBar extends Component {
    handleFormSubmit({query}) {
        console.log('trying to handle submit for query', query);
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
```

### 4. Connect with reduxForm

```javascript
SearchBar = reduxForm({
    form: 'searchBar'
})(SearchBar);

export default SearchBar;
```

**Configuration explanation**:

- **form: 'searchBar'** - unique form identifier
- **Similar to connect()** - but with configuration options
- **Wraps component** - provides form props

---

## 🛠️ Redux Store Configuration

### Update Reducers

**File**: `src/reducers/index.js`

```javascript
import { combineReducers } from 'redux';
import { reducer as form } from 'redux-form';

const rootReducer = combineReducers({
    form
});

export default rootReducer;
```

**Reducer naming**:

- **import as form** - rename generic 'reducer' 
- **ES6 aliasing** - more descriptive name
- **Required for Redux-Form** - must be named 'form' in store

---

## 📧 Technical Concepts

### Redux-Form Field Component

**Comparison**:

```javascript
// Regular input
<input placeholder="Search DailySmarty"/>

// Redux-Form Field  
<Field name="query" component={this.renderInput}/>
```

**Field benefits**:

- **Automatic state management** - input values in Redux store
- **Form validation** - built-in validation support
- **Submission handling** - integrated with handleSubmit

### HandleSubmit Flow

**Process**:

1. **User types** - Redux-Form tracks changes
2. **Form submission** - handleSubmit triggered  
3. **Data extraction** - {query} destructured from form values
4. **Custom handler** - handleFormSubmit called with data

### URL Query Parameters

**Current behaviour**:

- **Form submission** - shows query in URL: `?query=rails`
- **Next step** - navigation to results page
- **React Router integration** - programmatic navigation

---

## 📋 Verification

**Testing steps**:

1. **Type in search box** - should accept input
2. **Press Enter** - console should log message
3. **Check URL** - should show query parameter
4. **Different searches** - test various terms

**Expected console output**:

```
trying to handle submit for query rails
trying to handle submit for query javascript  
```

**Common issue fixed**:

- **SearchBar not defined** - capital 'S' in reduxForm connection
- **Can't type** - form reducer not added to store

---
