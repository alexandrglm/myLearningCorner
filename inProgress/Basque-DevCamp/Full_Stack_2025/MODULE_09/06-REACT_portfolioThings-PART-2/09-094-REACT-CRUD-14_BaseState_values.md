# 09-094 - Implementing Base State Value for React Select Tag

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/implementing-base-state-value-react-select-tag)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at fe60f1bd33658f5614455255025d0dffefe57e87](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/fe60f1bd33658f5614455255025d0dffefe57e87)

---

## 🎯 OBJECTIVES

**Fix select dropdown bug with default value**:

- **Understand React component lifecycle** - constructor → render → mount
- **Problem identified**: JSX defaults don't update state
- **Simple solution**: Default value in state initialisation  
- **Lifecycle concepts**: onChange only runs when user interacts
- **Complete testing**: Verify default and changed values work

**Understanding the issue**:

- Visual default ≠ State value
- onChange doesn't execute without user interaction
- State initialisation is the correct solution

---

## 🛠️ IMPLEMENTATION

### Identifying the Problem

**Current problematic behaviour**:

```javascript
// In constructor
this.state = {
  category: ""  // Empty string initial
};

// In JSX  
<select name="category" value={this.state.category}>
  <option value="eCommerce">eCommerce</option>  // Shown by default
  <option value="Scheduling">Scheduling</option>
  <option value="Enterprise">Enterprise</option>
</select>
```

**Problematic result**:

- **Visual**: Select shows "eCommerce" as first option
- **State**: `category: ""` (empty string)
- **Form submission**: Sends empty string to backend
- **User confusion**: Thinks eCommerce is selected

### Solution: Default Value in State

**File**: `src/components/portfolio/portfolio-form.js`

**BEFORE**:

```javascript
this.state = {
  name: "",
  description: "",
  category: "",        // ❌ Empty string - causes bug
  position: "",
  url: "",
  thumb_image: "",
  banner_image: "",
  logo: ""
};
```

**AFTER**:

```javascript
this.state = {
  name: "",
  description: "",
  category: "eCommerce",   // ✅ Default value matches first option
  position: "",
  url: "",
  thumb_image: "",
  banner_image: "",
  logo: ""
};
```

---

## 🔧 CONCEPTS

### React Component Lifecycle Explained

**Sequence of critical events**:

1. **Class instantiated** - `new PortfolioForm()`
2. **Constructor runs** - `this.state` initialised
3. **Render method runs** - JSX converted to elements
4. **Component mounts** - Inserted into DOM
5. **Lifecycle hooks** - componentDidMount, etc.

**What does NOT happen automatically**:

- **JSX defaults** don't modify state
- **First option display** is purely visual
- **onChange doesn't execute** without user interaction

### Why Does This Bug Happen?

**onChange behaviour**:

```javascript
// onChange only executes when:
// 1. User makes a selection
// 2. Selection is DIFFERENT from current value
// 3. Event triggers handleChange function

// If user never touches select:
// - State remains: category: ""
// - Visual shows: "eCommerce"  
// - Form submits: empty string ❌
```

**Visual vs State disconnect**:

- **Browser select behaviour**: Shows first option as visual default
- **React controlled component**: Value determined by state prop
- **Result**: Visual doesn't match actual value

### Different Possible Solutions

**Option 1: Default in state** (implemented):

```javascript
category: "eCommerce"  // Simple and direct
```

**Option 2: ComponentDidMount**:

```javascript
componentDidMount() {
  this.setState({ category: "eCommerce" });
}
```

**Option 3: Empty option**:

```javascript
<select>
  <option value="">Choose category...</option>
  <option value="eCommerce">eCommerce</option>
  // ...
</select>
```

**Why choose Option 1?**:

- **Simpler** - one line of code
- **Better performance** - no re-render after mount
- **Clear UX** - user sees what will be sent
- **Consistent** - state matches visual from start

### React State Initialisation Best Practices

**State should represent truth**:

```javascript
// ✅ Correct - state matches expected behaviour
this.state = {
  category: "eCommerce",    // Default meaningful value
  isLoading: false,         // Boolean with sensible default
  items: []                 // Array starts empty
};

// ❌ Incorrect - state doesn't match user expectation  
this.state = {
  category: "",             // Empty but user sees "eCommerce"
  isLoading: undefined,     // Ambiguous state
  items: null              // Null vs empty array confusion
};
```

---

## ✔️ VERIFICATION

### Testing Default Value Behaviour

**Test 1 - No user interaction**:

1. **Open form** in browser
2. **See select dropdown** - should show "eCommerce"
3. **Don't touch select** - leave default selection
4. **Fill other fields**:
   - Name: "with no change"
   - Other fields optional
5. **Submit form**
6. **Verify in DevCamp Space**:
   - Refresh page
   - Find "with no change" item
   - **Verify category = "eCommerce"** ✅

### Testing Changed Value Behaviour

**Test 2 - User makes selection**:

1. **Open form** again
2. **Change category** dropdown to "Enterprise"
3. **Fill other fields**:
   - Name: "With Change" 
   - Other fields optional
4. **Submit form**
5. **Verify in DevCamp Space**:
   - Refresh page
   - Find "With Change" item
   - **Verify category = "Enterprise"** ✅

### React DevTools Verification

**State inspection**:

1. **Open React DevTools**
2. **Select PortfolioForm** component
3. **View initial state** - `category: "eCommerce"`
4. **Change dropdown** - watch state update
5. **Confirm** state always matches selection

### Expected Behaviour Confirmed

**Both scenarios working**:

- ✅ **Default submission** - sends "eCommerce" 
- ✅ **Changed submission** - sends selected value
- ✅ **State consistency** - always matches visual
- ✅ **No user confusion** - WYSIWYG behaviour

### Console Testing

**Debug state during development**:

```javascript
handleSubmit(event) {
  event.preventDefault();
  console.log("Category state:", this.state.category);
  // Should never be empty string now
}
```

---
