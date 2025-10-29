# 10-147: Building Dedicated Icon Helper File React

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-dedicated-icon-helper-file-react)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at b14ac2722431b92aaa646588b5353493f7353b1e](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/b14ac2722431b92aaa646588b5353493f7353b1e)

---

## 🎯 Objectives

**Create dedicated helper function for icon management**:

- **Helper directory structure** - organise JavaScript functions unrelated to React
- **Icons helper module** - dedicated file for FontAwesome icons management
- **Code organisation cleanup** - remove icon logic from main App component
- **JavaScript module pattern** - create exportable function for use in multiple components
- **Library import centralisation** - handle all icon imports in one place

**Why this refactoring**:

- App component is critical for entire application
- Adding new icons requires modifying central component
- Better separation of concerns
- Create our own mini-library for icons

---

## 🛠️ Implementation

### 1. Create Helpers Directory Structure

**Create new directory**: `src/helpers/`

```
src/
  helpers/          ← New directory
    icons.js        ← New file
```

**Convention**: lowercase naming for helper files

### 2. Move Icon Imports to Helper File

**File**: `src/helpers/icons.js`

**Copy imports from App component**:

```javascript
import { faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle } from "@fortawesome/free-solid-svg-icons";
import { library } from "@fortawesome/fontawesome-svg-core";
```

### 3. Create Icons Function

**Add function in `src/helpers/icons.js`**:

```javascript
const Icons = () => {
  return library.add(faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle);
};

export default Icons;
```

### 4. Update App Component

**File**: `src/components/app.js`

**Remove FontAwesome imports**:

```javascript
// REMOVE these lines:
// import { faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle } from "@fortawesome/free-solid-svg-icons";
// import { library } from "@fortawesome/fontawesome-svg-core";
```

**Add helper import**:

```javascript
import Icons from "../helpers/icons";
```

### 5. Call Icons Function in Constructor

**In the App component constructor**:

```javascript
constructor(props) {
  super(props);

  Icons(); // Call helper function

  /* Rest of constructor code... */
}
```

### 6. Clean Up Original Library Call

**Remove from constructor**:

```javascript
// REMOVE this line:
// library.add(faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle);
```

---

## 📖 Concepts

### Helper Modules Pattern

**What is a helper module**:

- **Pure JavaScript file** - not specifically React-related
- **Utility function** - performs specific task and returns result
- **Exportable** - can be imported and used in multiple components
- **Reusable** - centralised logic for reuse

**Typical structure**:

```javascript
// Necessary imports
import { library } from "@fortawesome/fontawesome-svg-core";
import { faIcon1, faIcon2 } from "@fortawesome/free-solid-svg-icons";

// Main function
const HelperFunction = () => {
  // Function logic
  return library.add(faIcon1, faIcon2);
};

// Export for use in other files
export default HelperFunction;
```

### Code Organisation Benefits

**Before** (everything in App component):

```javascript
// App.js - critical component overloaded
import { faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle } from "@fortawesome/free-solid-svg-icons";
import { library } from "@fortawesome/fontawesome-svg-core";

constructor() {
  library.add(faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle);
  // Rest of critical app logic...
}
```

**After** (separation of concerns):

```javascript
// App.js - clean component
import Icons from "../helpers/icons";

constructor() {
  Icons(); // Simple function call
  // Only critical app logic...
}

// helpers/icons.js - specific responsibility
const Icons = () => {
  return library.add(faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle);
};
```

### Pattern Advantages

**To add new icon**:

```javascript
// Before: modify critical App component
// After: only modify dedicated helper

// helpers/icons.js
import { faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle, faNewIcon } from "@fortawesome/free-solid-svg-icons";

const Icons = () => {
  return library.add(faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle, faNewIcon);
};
```

**Benefits**:

- **App component protection** - don't touch critical file
- **Single responsibility** - helper handles only icons
- **Centralised management** - all icons in one place
- **Easy maintenance** - changes isolated to helper file

### JavaScript Module System

**How import/export works**:

```javascript
// helpers/icons.js (exporting)
export default Icons;

// app.js (importing)
import Icons from "../helpers/icons";
//     ^         ^
//     |         └── Relative path navigation
//     └── Local name (can be any name)
```

**Relative path navigation**:

```
src/components/app.js importing from src/helpers/icons.js

"../helpers/icons"
 ^   ^       ^
 |   |       └── Filename (without .js extension)
 |   └── Directory name
 └── Go up one level (from components to src)
```

### Function Call vs Function Reference

**Function call** (what we do):

```javascript
Icons(); // Parentheses execute the function immediately
```

**Function reference** (NOT what we want here):

```javascript
Icons; // No parentheses, only reference - doesn't execute
```

**Why function call**:

- We need `library.add()` to execute immediately
- Icon setup must occur during initialisation
- FontAwesome needs icons registered before use in components

---

## ✅ Verification

### 1. Testing Icon Functionality

**Step-by-step verification**:

1. **Refresh browser** - ensure no console errors
2. **Portfolio page** - verify trash/edit icons appear
3. **Login functionality** - verify spinner icon during loading
4. **All existing icons** - confirm they work identically to before

### 2. Code Organisation Check

**Confirm clean separation**:

```javascript
// App.js should only have:
import Icons from "../helpers/icons";
// And in constructor:
Icons();

// helpers/icons.js should have:
// - FontAwesome imports
// - Library import  
// - Icons function
// - Export default
```

### 3. Helper Module Testing

**Verify correct functionality**:

- **No console errors** related to missing icons
- **Icons render properly** in all components that use them
- **Function executes once** during app initialisation
- **Library properly populated** with all necessary icons

### 4. Future Scalability Test

**Add new icon as proof of concept**:

```javascript
// helpers/icons.js
import { faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle, faHeart } from "@fortawesome/free-solid-svg-icons";

const Icons = () => {
  return library.add(faTrash, faSignOutAlt, faEdit, faSpinner, faPlusCircle, faHeart);
};
```

**Use new icon in any component**:

```javascript
<FontAwesomeIcon icon="heart" />
```

**Verify that**:

- Only modified the helper file
- Didn't touch App component
- New icon works correctly

---
