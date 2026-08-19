# 09-092 - Guide for Select Dropdowns in React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/guide-select-dropdowns-react)

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/5a0ccd92c7f5258d674d7f2c8d5034ae706b79dc)

---

## 🎯 OBJECTIVES

**Improve form UX with select dropdown**:

- **Replace text input** with select dropdown for category
- **Predefined options** matching database
- **Same functionality** handleChange without modifications
- **Consistent values** between frontend and backend
- **Improved UX** - user cannot enter incorrect values

**Comparison of field types**:

- **Text fields**: name, URL, position ✅
- **Select dropdown**: category (implement now)
- **Textarea**: description (next guide)

---

## 🛠️ IMPLEMENTATION

### Convert Input to Select

**File**: `src/components/portfolio/portfolio-form.js`

**BEFORE**:

```javascript
<input
  type="text"
  name="category"
  placeholder="Category"
  value={this.state.category}
  onChange={this.handleChange}
/>
```

**AFTER**:

```javascript
<select 
  name="category"
  value={this.state.category}
  onChange={this.handleChange}
>
  <option value="eCommerce">eCommerce</option>
  <option value="Scheduling">Scheduling</option>
  <option value="Enterprise">Enterprise</option>
</select>
```

### Complete Select Structure

**Select tag with options**:

```javascript
<select 
  name="category"
  value={this.state.category}
  onChange={this.handleChange}
>
  <option value="eCommerce">eCommerce</option>
  <option value="Scheduling">Scheduling</option>
  <option value="Enterprise">Enterprise</option>
</select>
```

**Elements removed from original input**:

- `type="text"` - not applicable for select
- `placeholder` - not used in select tags
- Self-closing slash `/` - select needs closing tag

---

## 🔧 CONCEPTS

### Anatomy of Select Tag in React

**Select element properties**:

```javascript
<select 
  name="category"           // Form field name
  value={this.state.category}  // Controlled component value
  onChange={this.handleChange}  // Event handler
>
  // Options go inside
</select>
```

**Option elements structure**:

```javascript
<option value="eCommerce">eCommerce</option>
//      ↓ stored value    ↓ displayed text
```

### Difference: Value vs Display Text

**Value attribute**:

- **Stored in state** when user selects
- **Sent to database** in API requests  
- **Must be exact** - case sensitive
- **Backend consistency** - same format API expects

**Display text (between tags)**:

- **Visible to user** in dropdown
- **Can differ** from value
- **UX purposes** - more descriptive if needed
- **Formatting flexible** - spaces, capitalisation, etc.

### Why Use Select Instead of Input?

**UX benefits**:

- **Prevents typos** - user cannot enter incorrectly
- **Clear options** - shows all available categories  
- **Consistent data** - guarantees valid values
- **Professional look** - polished interface

**Backend benefits**:

- **Data integrity** - only predefined values
- **Query efficiency** - database can index categories
- **Simpler validation** - fewer edge cases

### Controlled Components Pattern

**Select follows same pattern as inputs**:

```javascript
// State holds current value
this.state.category = "eCommerce"

// Value prop binds to state  
value={this.state.category}

// onChange updates state
onChange={this.handleChange}
```

**HandleChange functionality**:

- **Same handler** works for select and input
- **event.target.value** contains selected option value
- **No changes needed** in handleChange method

---

## ✔️ VERIFICATION

### Testing Select Dropdown

**Browser testing**:

1. **Open application** in browser
2. **Navigate to form** where category field is  
3. **See dropdown** instead of text input
4. **Click dropdown** - should show 3 options
5. **Select option** - displayed value should change

### Form Submission Testing

**End-to-end test**:

1. **Fill form**:
   - Name: "With select"
   - Category: select "Enterprise" 
   - Other fields optional
2. **Submit form** (save button)
3. **Verify in DevCamp Space**:
   - Refresh page
   - Find "With select" item
   - Confirm category = "Enterprise"

### React DevTools Verification

**State inspection**:

1. **Open React DevTools**
2. **Select PortfolioForm** component
3. **Change category** dropdown
4. **Watch state update** - category value changes
5. **Confirm** value matches selected option

### Expected Behaviour

**Correct functionality**:

- ✅ **Dropdown appears** instead of text input
- ✅ **Options display** eCommerce, Scheduling, Enterprise  
- ✅ **Selection works** - value changes on select
- ✅ **Form submission** includes selected category
- ✅ **Database persistence** - DevCamp Space shows correct value

**Common issues to watch**:

- ❌ **Options not showing** - check closing tags
- ❌ **Selection not working** - verify name and onChange
- ❌ **Wrong value stored** - check option value attributes
- ❌ **Styling issues** - normal, will fix with CSS later

---
