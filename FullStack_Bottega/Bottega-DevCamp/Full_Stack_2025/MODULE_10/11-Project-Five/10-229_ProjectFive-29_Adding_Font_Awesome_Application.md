# 10-229: Adding Font Awesome Application

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/adding-font-awesome-application)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-29.

---

## 🛠️ Implementation

### 1. Add Font Awesome CDN

**File**: `static/index.html`

```html
<!-- Add after fonts -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
```

### 2. Update searchBar.scss

**File**: `src/style/searchBar.scss`

```scss
&::placeholder {
    color: $color-gray-two;
    font-family: 'Font Awesome\ 5 Free', 'Lato', Arial, Helvetica, sans-serif;
    font-weight: 600;
}
```

### 3. Update searchBar.js

**File**: `src/components/searchBar.js`

```javascript
renderInput(field) {
    return <input 
        type="text" 
        placeholder=" Search DailySmarty" 
        {...field.input} 
    />
}
```

---

## 🔧 Technical Note

Font Awesome requires `font-weight: 600` to display icons correctly in placeholders.

---
