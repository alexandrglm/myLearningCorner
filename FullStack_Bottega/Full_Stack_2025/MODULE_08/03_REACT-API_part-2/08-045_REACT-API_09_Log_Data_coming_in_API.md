# 08-045 - How to Log Data Coming from an API in React

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-log-data-coming-api-react](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-log-data-coming-api-react)

**Source Code**: [https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/0eb48b59d185bc4d6939c4a54666a7e7253c2a79](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/0eb48b59d185bc4d6939c4a54666a7e7253c2a79)

---

## 🎯 FUNDAMENTAL CONCEPTS

### The Importance of Data Management

**Why this section is crucial**:

* **Often overlooked skill** – many tutorials skip it
* **Daily necessity** – you will work with APIs constantly
* **Professional approach** – real-world development methods
* **Foundational skill** – core for debugging and feature development

### The Real Development Problem

**Common scenarios**:

* **APIs without clear documentation**
* **New endpoints** with no examples
* **Complex data structure**
* **Unknown props** – you don’t know what’s available

**The professional solution**:

* **Strategic console.log** – see all data
* **Data exploration** – understand structure
* **Systematic approach** – transferable methodology

---

## 🔍 DIFFERENCE: TUTORIAL VS REAL WORLD

### Ideal Conditions (Tutorial)

**DevCamp Space provides**:

* **Visual interface** to view data
* **Clickable API endpoints**
* **Formatted JSON preview**
* **Implicit documentation**

### Real Conditions (Work)

**In real-world projects you’ll find**:

* **APIs without visual interface**
* **Limited or outdated documentation**
* **Non-obvious data structure**
* **Need for manual exploration**

### Transferable Skill

**You will learn**:

* **Data exploration methods**
* **Systematic console debugging**
* **Unknown API navigation**
* **Professional workflow** for any API

---

## 🛠️ PRACTICAL STEPS – CONSOLE.LOG EXPLORATION

### 1. Implement Console.log in the Map Function

**File**: `src/components/portfolio-container.js`

**In the `portfolioItems()` function**:

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        console.log("portfolio item", item); // 🔍 ADD THIS LINE

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

### 2. Open Developer Tools

**Process**:

1. **Save file** – React auto-refresh
2. **Open DevTools** – `Cmd+Option+J` (Mac) / `F12` (Windows)
3. **Switch to Console tab**
4. **Refresh page** if needed

### 3. Explore Console Output

**You will see**:

```
portfolio item {id: 10, name: "Crondose", description: "Technology blog...", ...}
portfolio item {id: 11, name: "DailySmarty", description: "Social media...", ...}
```

### 4. Expand Objects to See Full Structure

**Click triangle to expand each object**:

```javascript
{
  id: 10,
  name: "Crondose",
  description: "Technology blog featuring daily insights...",
  url: "https://crondose.com",
  category: "Technology",
  position: 1,
  banner_image_url: "https://...",
  logo_url: "https://...",
  thumb_image_url: "https://...",
  column_names_merged_with_images: [...] // metadata – ignore
}
```

---

## 📊 DATA STRUCTURE ANALYSIS

### Discovered Available Properties

**Basic data** (already known):

* `id`
* `name`
* `description`
* `url`
* `category`
* `position`

**Newly identified** (images):

* `banner_image_url`
* `logo_url`
* `thumb_image_url`

**Metadata** (ignore):

* `column_names_merged_with_images`

### Development Implications

Now you can use:

```javascript
item.name        // ✅ Already used
item.url         // ✅ Already used
item.id          // ✅ Already used

item.description       // 🆕 For descriptions
item.category         // 🆕 For improved filtering
item.banner_image_url // 🆕 Large images
item.logo_url         // 🆕 Logos
item.thumb_image_url  // 🆕 Thumbnails
```

---

## 🔧 PROFESSIONAL METHODOLOGY

### Standard Process

1. **Console.log the entire object**
2. **Expand and examine** in DevTools
3. **Document discovered properties**
4. **Plan implementation** of new features
5. **Implement step-by-step**

### Why This Approach Is Valuable

**In real work**:

* **APIs change** – new properties added
* **Documentation may be outdated** – console.log is always up to date
* **Data structures may be complex** – understand real structure
* **Debugging** – confirm what data actually arrives

---

## 📋 EXTENDING PORTFOLIO ITEM PROPS

### Current Props

```javascript
<PortfolioItem
    key={item.id}
    title={item.name}
    url={item.url}
    slug={item.id}
/>
```

### Extended Props

```javascript
<PortfolioItem
    key={item.id}
    title={item.name}
    url={item.url}
    slug={item.id}
    description={item.description}
    category={item.category}
    bannerImage={item.banner_image_url}
    thumbImage={item.thumb_image_url}
    logo={item.logo_url}
/>
```

---

## ✅ COMPLETE FUNCTIONAL CODE

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        console.log("portfolio item", item); // 🔍 DATA EXPLORATION

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

## 🎯 EXPECTED OUTPUT

### In Console You Should See

```
portfolio item Object {
  id: 10,
  name: "Crondose",
  description: "Technology blog featuring daily insights and tutorials...",
  url: "https://crondose.com",
  category: "Technology",
  position: 1,
  banner_image_url: "https://...",
  logo_url: "https://...",
  thumb_image_url: "https://...",
  column_names_merged_with_images: [...]
}
```

---

## 📚 PROFESSIONAL DEBUGGING PATTERNS

### Console.log Best Practices

```javascript
console.log("portfolio item", item); // ✅ Clear context
console.log(item); // ❌ No context
```

---

## ✅ VERIFICATION CHECKLIST

* [ ] Console.log added
* [ ] Console output visible
* [ ] Objects expandable
* [ ] Image URLs identified
* [ ] Full data structure understood

---
