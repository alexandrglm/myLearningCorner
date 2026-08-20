# 08-049 - Refactor PortfolioItem Component Using Destructuring

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/refactoring-portfolioitem-component-use-destructuring](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/refactoring-portfolioitem-component-use-destructuring)

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/1fa0ecea23ccd1d5914f0152c957c37b045656a0)

---

## 🎯 REFACTORING OBJECTIVES

**Improve code for**:

* **React best practices**
* **Enhanced maintainability**
* **Extensibility** for new features
* **Destructuring** – professional JavaScript pattern

---

## 🛠️ STEP-BY-STEP REFACTORING

### 1. Simplify Props in PortfolioContainer

**Before** (multiple individual props):

```javascript
<PortfolioItem
    key={item.id}
    title={item.name}
    url={item.url}
    slug={item.id}
/>
```

**After** (full object):

```javascript
<PortfolioItem
    key={item.id}
    item={item}
/>
```

### 2. Implement Destructuring in PortfolioItem

**File**: `src/components/portfolio-item.js`

```javascript
import React from "react";
import { Link } from "react-router-dom";

export default function(props) {
    // Data that we'll need:
    // - id
    // - description  
    // - thumb_image_url (background image)
    // - logo_url

    const { id, description, thumb_image_url, logo_url } = props.item;

    return (
        <div>
            <h3>
                <Link to={`/portfolio/${id}`}>
                    {props.item.name}
                </Link>
            </h3>
            <div>{description}</div>
        </div>
    );
}
```

### 3. Update References

**JSX Changes**:

* `props.slug` → `id` (directly)
* `props.title` → `props.item.name` (keep some props)
* Add `{description}` for testing

---

## 📋 CONCEPTS: DESTRUCTURING

### What is Destructuring?

**Extracting properties** from objects into variables:

```javascript
// Without destructuring
const id = props.item.id;
const description = props.item.description;

// With destructuring  
const { id, description } = props.item;
```

### Advantages of Destructuring

**Cleaner code**:

* **One line** vs multiple assignments
* **Less repetition** of `props.item`
* **Standard pattern** in professional React
* **Easily add** new properties

---

## ✅ VERIFICATION

### Functionality Testing

**Check that it works**:

1. **Links work** – routing to portfolio detail
2. **Descriptions appear** – API data visible
3. **No console errors**
4. **Same behaviour** as before

---
