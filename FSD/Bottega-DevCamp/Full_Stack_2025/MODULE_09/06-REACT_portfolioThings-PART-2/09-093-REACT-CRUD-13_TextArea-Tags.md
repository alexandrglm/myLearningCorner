# 09-093 - Guide for Textarea Tag in React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/guide-textarea-tag-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at e762f3f2cf3294f3f814cee7ca2dde46d37e1032](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/e762f3f2cf3294f3f814cee7ca2dde46d37e1032)

---

## 🎯 OBJECTIVES

**Implement textarea for description field**:

- **Replace text input** with textarea for description
- **React vs HTML differences** - specific JSX syntax
- **Maintain controlled component** pattern unchanged  
- **Self-closing syntax** available in JSX
- **Test functionality** with form submission

**Quick reference**:

- Direct syntax for future consultation
- Understanding React/HTML differences
- Pattern complete field types in form

---

## 🛠️ IMPLEMENTATION

### Convert Input to Textarea

**File**: `src/components/portfolio/portfolio-form.js`

**BEFORE**:

```javascript
<input
  type="text"
  name="description"
  placeholder="Description"
  value={this.state.description}
  onChange={this.handleChange}
/>
```

**AFTER**:

```javascript
<textarea
  name="description"
  placeholder="Description"  
  value={this.state.description}
  onChange={this.handleChange}
/>
```

### Elements Removed from Input

**Properties not applicable for textarea**:

- `type="text"` - not applicable for textarea
- All other props remain the same

**Props maintained**:

- `name` - for form field identification
- `placeholder` - user help text
- `value` - controlled component value
- `onChange` - event handler

---

## 🔧 CONCEPTS

### Differences React vs Traditional HTML

**Traditional HTML**:

```html
<textarea name="description">
  Initial content here
</textarea>
```

**React JSX**:

```javascript
<textarea 
  name="description"
  value={this.state.description}  // Controlled value
  onChange={this.handleChange}
/>
```

### Why React is Different?

**HTML approach**:

- **Content between tags** determines initial value
- **Mutable** - user can change, value not synchronised with code
- **Uncontrolled** - DOM handles state

**React approach**:

- **Value prop** controls content completely
- **Controlled component** - React handles all state
- **Single source of truth** - component state is authoritative
- **Self-closing syntax** possible thanks to JSX

### Self-Closing Syntax in JSX

**Advantage of JSX**:

```javascript
// Self-closing - cleaner
<textarea name="description" value={state} onChange={handler} />

// vs traditional closing (also valid)
<textarea name="description" value={state} onChange={handler}>
</textarea>
```

**Both are valid** in React, but self-closing is preferred when no children.

### Controlled Component Pattern Consistent

**Same pattern across all form elements**:

```javascript
// Input text
<input value={this.state.name} onChange={this.handleChange} />

// Select dropdown  
<select value={this.state.category} onChange={this.handleChange} />

// Textarea
<textarea value={this.state.description} onChange={this.handleChange} />
```

**Benefits of consistent pattern**:

- **Same handleChange** works for all
- **Uniform state** management
- **Reusable validation** logic
- **Easier debugging** - predictable behaviour

### Why Textarea for Description?

**UX considerations**:

- **More visual space** - long text more comfortable
- **Multiline support** - natural for descriptions
- **Resizable** - user can adjust size
- **Professional appearance** - standard user expectation

**Data considerations**:

- **Same data type** - string like input text
- **Same validation** - length, required, etc.
- **Same API handling** - no special backend processing

---

## ✔️ VERIFICATION

### Testing Textarea Functionality

**Browser testing**:

1. **Open application** in browser
2. **Navigate to form** portfolio
3. **See textarea** instead of input for description
4. **Click in textarea** - should allow multiline input
5. **Type content** with line breaks

### Form Submission Testing

**End-to-end test**:

1. **Fill complete form**:
   - Name: "With text area"
   - Category: any dropdown option
   - Description: multiline text with enters
   - Other fields optional
2. **Submit form** 
3. **Verify in DevCamp Space**:
   - Refresh page
   - Find "With text area" item
   - Confirm description correct with line breaks

### React DevTools Verification

**State inspection**:

1. **Open React DevTools**
2. **Select PortfolioForm** component  
3. **Type in textarea** - watch state.description update
4. **Confirm** multiline content in state
5. **Add line breaks** - verify preserved in state

### Expected Visual Differences

**Textarea vs Input visually**:

- ✅ **Larger height** - more vertical space
- ✅ **Resizable corner** - user can drag corner
- ✅ **Multiline capability** - enters create new lines
- ✅ **Scroll bars** if content exceeds size
- ✅ **Word wrapping** automatic

### Bug Observation - Select Default Value

**Issue mentioned in guide**:

- **Problem**: Select dropdown shows first option but doesn't update state
- **Result**: Null value sent if user doesn't change selection
- **Fix**: Next guide will explain React concepts and solution

**Why this happens**:

- **Visual display** ≠ **state value**
- **State starts empty** (`category: ""`)  
- **Select shows first option** as visual default
- **onChange doesn't fire** if user doesn't make selection
- **Result**: State remains empty string

---
