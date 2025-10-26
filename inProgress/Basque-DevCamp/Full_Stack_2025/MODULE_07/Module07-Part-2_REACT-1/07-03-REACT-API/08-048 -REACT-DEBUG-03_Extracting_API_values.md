# 08-048 - Using Debugger to Extract API Key Names

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/using-debugger-extract-api-key-names](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/using-debugger-extract-api-key-names)

**Source Code**: [https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/9ec9fe7db2939bd99f80b4768146939d22340b61](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/9ec9fe7db2939bd99f80b4768146939d22340b61)

---

## 🎯 DESIGN-BASED PLANNING

### Identifying Required Data

**According to the finished application**:

* **Background image** – background visual
* **Logo** – project logo
* **Description** – hover description
* **ID** – for routing slug

---

## 🛠️ PRACTICAL IMPLEMENTATION

### 1. Add Planning Comments

**In the `portfolioItems()` function**:

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        // Data that we'll need:
        // - background image
        // - logo
        // - description
        // - id

        debugger; // To extract exact key names

        return (
            <PortfolioItem
                key={item.id}
                title={item.name}
                url={item.url}
                slug={item.id}
            />
        );
    });
}
```

### 2. Use Object.keys() to Extract Keys

**In the console (when the debugger pauses)**:

```javascript
Object.keys(item)
```

**Expected output**:

```
["id", "name", "description", "url", "category", "position", "thumb_image_url", "banner_image_url", "logo_url", ...]
```

### 3. Document the Keys Needed

**Update the comments**:

```javascript
// Data that we'll need:
// - id (for slug)
// - description
// - thumb_image_url (for background)
// - logo_url
// (position - maybe later for ordering)
```

### 4. Remove Debugger

**Clean the code**:

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        // Data mapped:
        // id -> slug
        // description -> description
        // thumb_image_url -> background
        // logo_url -> logo

        return (
            <PortfolioItem
                key={item.id}
                title={item.name}
                url={item.url}
                slug={item.id}
            />
        );
    });
}
```

---

## 📋 RESULT

**Keys identified for the next implementation**:

* ✅ `id` – already used as slug
* ✅ `description` – for hover display
* ✅ `thumb_image_url` – background image
* ✅ `logo_url` – project logo

**Keys for later**:

* `position` – for future ordering

---
