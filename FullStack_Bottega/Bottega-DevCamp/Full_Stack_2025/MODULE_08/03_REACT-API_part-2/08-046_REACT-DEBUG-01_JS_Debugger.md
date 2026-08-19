# 08-046 - Introduction to the JavaScript Debugger

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-javascript-debugger](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-javascript-debugger)

**Source Code**: [https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/7fde864bdf38039ce633615bda7739dd4e9a618b](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/7fde864bdf38039ce633615bda7739dd4e9a618b)

---

## 🎯 FUNDAMENTAL CONCEPTS

### Debugger vs Console.log

**JavaScript Debugger**:

* **Pauses execution** of the programme
* **Allows you to query** the data
* **Full control** – run scripts at the moment
* **Interactive inspection** – not merely displaying data

**Why it is better than console.log**:

* **Execution is frozen** – the programme stops
* **Run functions** directly in the browser
* **Build expressions** and test code
* **Interactive exploration** rather than passive logs

---

## 🛠️ IMPLEMENTING THE DEBUGGER

### 1. Replace Console.log with Debugger

**In `portfolio-container.js`**, inside the `portfolioItems()` function:

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        // console.log("portfolio item", item); // ❌ Remove
        debugger; // ✅ Add debugger

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

### 2. Testing the Debugger

**When the file is saved**:

* **Screen becomes greyed out**
* **Text appears**: "Paused in debugger"
* **Shows the exact line** where execution stopped
* **DevTools opens** automatically in the DEBUGGER tab (If DevTools is not open, it may not pause execution, at least in more recent versions of Firefox)

---

## 🔍 USING THE DEBUGGER

### Data Exploration

**In the console (whilst paused)**:

```javascript
// View the full object
item

// Specific properties
item.banner_image_url
item.name
item.description
```

**Each command displays**:

* **The current value** of that property
* **Clickable URLs** – images will open
* **Data of the current item** being iterated

### Navigating Between Items

**Blue "Resume" button**:

* **Continues execution** to the next debugger statement
* **Next item** in the map
* **New data** to inspect

**Process**:

1. **Debugger pauses** at the first item
2. **Explore data** for that item
3. **Click Resume** → pauses at the next item
4. **Explore data** for the next item
5. **Repeat** for all items

---

## ⚠️ LIMITATIONS OF THE DEBUGGER

### No Access to Component State

**This will NOT work**:

```javascript
this.state.pageTitle  // ❌ Error: cannot read property 'state' of undefined
this.state.data       // ❌ Error: cannot read property 'state' of undefined
```

**Why it fails**:

* **Debugger scope** – only local variables are available
* **No component context** – no access to `this`
* **Only data variables** – `item` is available

### What DOES Work

**Local variables**:

```javascript
item              // ✅ Variable from map
item.name         // ✅ All item properties
item.description  // ✅ All API data
```

---

## 🎯 COMPLETE CODE

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        debugger; // Pauses here for each item

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

## ✅ TESTING STEPS

### 1. Implement Debugger

* Replace console.log with `debugger;`
* Save the file

### 2. Verify Pause

* Grey overlay with "Paused in debugger"
* DevTools opens automatically

### 3. Explore Data

* Type `item` in the console
* Test `item.banner_image_url`
* Click Resume for next item

### 4. Remove Debugger

* **Important**: Remove `debugger;` when finished
* Only used for development, not production

---
