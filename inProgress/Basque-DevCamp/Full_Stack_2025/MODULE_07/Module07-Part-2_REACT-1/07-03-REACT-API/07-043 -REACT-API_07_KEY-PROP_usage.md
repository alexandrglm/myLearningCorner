# 07-043 - How and Why to Use the Key Prop in React

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-why-use-key-prop-react](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-why-use-key-prop-react)

**Source Code**: [https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/fc8df17410a6820de6fc41079a29aaf32f2da7c0](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/fc8df17410a6820de6fc41079a29aaf32f2da7c0)

---

## 🎯 FUNDAMENTAL CONCEPTS

### The React Warning

**Warning that appears**:

```
Warning: Each child in an array or iterator should have a unique key prop
```

**What does it mean?**:

* React needs to **track elements** that are generated dynamically
* **Automatically generated lists** require unique identifiers
* **Performance optimisation** – React can update only the elements that have changed
* **This is NOT an error** – it is a warning, but one that is important to fix

### DOM vs Virtual DOM

**Traditional DOM**:

* **Document Object Model** – the real HTML displayed in the browser
* **Full re-render** when something changes
* **Slow performance** in complex applications

**React Virtual DOM**:

* **In-memory representation** of the real DOM
* **Updates only** the elements that have changed
* **Much better performance** – specific updates instead of full reloads
* **Reconciliation process** – compares previous state vs new state

---

## 🚀 WHY REACT IS SO FAST

### The Optimisation Process

**Scenario without React** (traditional):

1. **Data changes** → entire page re-renders
2. **Everything updates** – even elements that did not change
3. **Slow performance** especially with large lists

**Scenario with React** (optimised):

1. **One item changes** → React identifies EXACTLY which item changed
2. **Only that specific element** is updated
3. **High performance** because updates are targeted

### Practical Example

**If you change "Test Portfolio Item"**:

* **Without keys** → React cannot determine which item changed → re-renders entire list
* **With keys** → React knows "item with ID 93 changed" → updates only that item

---

## 🔧 IMPLEMENTING THE KEY PROP

### The Issue in Our Current Code

**Current code** (produces a warning):

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        return (
            <PortfolioItem
                // ❌ NO key prop – causes warning
                title={item.name}
                url={item.url}
                slug={item.id}
            />
        );
    });
}
```

### The Solution

**Corrected code**:

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        return (
            <PortfolioItem
                key={item.id}        // ✅ Unique key added
                title={item.name}
                url={item.url}
                slug={item.id}
            />
        );
    });
}
```

---

## ⚠️ CRITICAL RULES FOR KEYS

### Rule #1: It Must Be UNIQUE

**❌ Bad choices for keys**:

```javascript
key={item.name}      // ❌ Names can repeat
key={item.category}  // ❌ Many items share the same category
key={item.url}       // ❌ URLs may not always be unique
```

**✅ Good choices for keys**:

```javascript
key={item.id}        // ✅ ID is always unique in the database
key={item.uuid}      // ✅ Use UUID if available
key={`${item.id}-${item.name}`} // ✅ Combined unique values
```

### Rule #2: Do Not Use Array Index

**❌ Avoid using the array index**:

```javascript
.map((item, index) => (
    <PortfolioItem key={index} />  // ❌ Problems with reordering
))
```

**Why this is problematic**:

* **Indexes change** when the array order changes
* **React becomes confused** about which element is which
* Leads to **performance issues** and visual bugs

### Rule #3: Key Does Not Appear in the HTML

**Key is internal to React**:

```javascript
// In JSX:
<PortfolioItem key={item.id} title="..." />

// In rendered HTML:
<div>
    <h3>Portfolio Item</h3>  // NO key appears
</div>
```

**Key is only for React**:

* **Internal tracking mechanism**
* It does **not** appear in `props`
* Used only during the **reconciliation process**

---

## 🛠️ PRACTICAL STEPS – FIXING THE WARNING

### 1. Confirm Current Warning

Open DevTools → Console:

```
Warning: Each child in an array or iterator should have a unique key prop
```

### 2. Update portfolioItems()

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        return (
            <PortfolioItem
                key={item.id}        // 🔧 ADD THIS LINE
                title={item.name}
                url={item.url}
                slug={item.id}
            />
        );
    });
}
```

### 3. Verify the Fix

1. Save the file
2. React auto-refreshes
3. Check the console again
4. Warning should now be gone

### 4. Inspect Rendered HTML (Optional)

In the Elements panel:

```html
<div>
    <h3>Portfolio Item Name</h3>
    <h4>https://example.com</h4>
    <a href="/portfolio/93">Link</a>
</div>
```

**Notice**:

* The **key does NOT appear** in the HTML
* The **ID appears only where intended**, such as route links

---

## 📋 ADVANCED CONCEPTS

### When to Use Key

**ALWAYS use key when**:

* Rendering components inside **map()**
* Rendering **dynamic lists**
* **Filtering** or **reordering** lists

**Example**:

```javascript
// ✅ Requires key
{items.map(item => <Component key={item.id} />)}

// ✅ Also requires key
{filteredData.map(item => <Item key={item.uuid} />)}

// ❌ Does NOT require key – only one element
<SingleComponent title="Hello" />
```

### Performance Benefits

**With correct keys**:

* **Faster re-renders**
* **Better memory efficiency**
* **Smoother animations**
* **Correct preservation of component state**

**With missing or incorrect keys**:

* **Slower updates**
* **Extra memory usage**
* **Visual glitches**
* **Incorrect or lost component state**

---

## ✅ VERIFICATION AND TESTING

### Validation Checklist

* [ ] **Key prop added** using `key={item.id}`
* [ ] **Warning eliminated** in console
* [ ] **Keys truly unique** (from database)
* [ ] **UI behaviour unchanged**
* [ ] **HTML output clean** – no key attribute present

### Performance Testing

To experience the benefits:

1. Add multiple portfolio items in DevCamp Space
2. Use filtering or sorting features
3. Observe how only the necessary items update
4. Compare behaviour in applications without keys
