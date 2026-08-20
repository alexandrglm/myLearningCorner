# 10-222: Modifying Fetch Posts with Query Action Creator to Take Optional Callback

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/modifying-fetch-posts-process-with-query-action-creator-take-optional-callback)**
---

**Mock API**: Navigation delayed until mock API response completes.

## 🎯 Objectives

**Improve UX with callback-based navigation**:
- **Optional callback parameter** - delay navigation until data loads
- **Better user experience** - no data flashing on results page
- **Conditional callback** - handle components without callbacks
- **Async flow control** - coordinate API calls with navigation

---

## 🛠️ Implementation

### 1. Update Action Creator with Optional Callback

**File**: `src/actions/index.js`

```javascript
export function fetchPostsWithQuery(query, callback) {
    return function(dispatch) {
        axios.get(`http://localhost:3001/posts?title_like=${query}`)
            .then(response => {
                dispatch({
                    type: SET_RESULTS_POSTS,
                    payload: response.data
                });
                
                if(callback) {
                    callback();
                }
            });
    }
}
```

### 2. Update Home Component with Callback

**File**: `src/components/home.js`

```javascript
class Home extends Component {
    handleSearchbarSubmit(query) {
        this.props.fetchPostsWithQuery(query, () => {
            this.props.history.push('/results');
        });
    }

    // ... rest of component
}
```

### 3. Results Component Unchanged

**File**: `src/components/results.js`

```javascript
class Results extends Component {
    handleSearchbarSubmit(query) {
        this.props.fetchPostsWithQuery(query); // No callback needed
    }

    // ... rest of component
}
```

---

## 📧 Technical Concepts

### Callback Function Pattern

**Function as parameter**:
```javascript
fetchPostsWithQuery(query, () => {
    this.props.history.push('/results');
});
```

**Execution flow**:
1. **API call starts** - axios.get()
2. **Response received** - .then()
3. **Data dispatched** - Redux store updated
4. **Callback executed** - navigation happens

### Conditional Callback Execution

```javascript
if(callback) {
    callback();
}
```

**Why needed**: Results component doesn't pass callback, prevents "callback is not a function" error

### UX Improvement

**Before**: 
- **Navigation immediate** → empty results page → data loads → content appears
- **Poor experience** - visible data loading/flashing

**After**:
- **Data loads first** → navigation after data ready → populated results page
- **Better experience** - no visible loading states

---

## 📋 User Experience Comparison

### Old Flow
1. User searches "rails"
2. **Navigation immediate** - /results loads
3. **Empty results** - placeholder content visible
4. **Data loads** - content flashes/changes
5. **Final state** - search results displayed

### New Flow
1. User searches "rails" 
2. **Loading period** - slight delay whilst API responds
3. **Data loaded** - Redux store populated
4. **Navigation** - /results loads with data ready
5. **Immediate display** - search results already available

---
