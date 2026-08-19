# 08-047 - Introduction to React Developer Tools

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-react-developer-tools](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-react-developer-tools)

---

## 🎯 FUNDAMENTAL CONCEPTS

### Difference from the JavaScript Debugger

**JavaScript Debugger** (previous guide):

* **Native JavaScript** – works in any JS application
* **Local variables** – only the current scope
* **No access** to React state/props

**React Developer Tools**:

* **React-specific** – designed for React applications
* **Component state** – full access
* **Props inspection** – view passed data
* **Component tree** – complete navigation

---

## 🛠️ PREPARATION

### 1. Remove the Debugger

**In `portfolio-container.js`**:

```javascript
portfolioItems() {
    return this.state.data.map(item => {
        // debugger; // ❌ REMOVE this line

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

### 2. Accessing the React Tab

**In DevTools**:

* The **"React"** tab should be visible (if the extension is installed)
* **If it is not visible** – click the arrow to reveal hidden tabs
* **Features**: Props, state, component tree, inspector tool

---

## 🔍 COMPONENT INSPECTION

### Method 1: Component Tree Navigation

**Manual navigation**:

* **Provider** → **BrowserRouter** → **Router** → **App** → etc.
* **Very slow** for large applications
* **Not recommended** for daily development

### Method 2: Inspector Tool (Recommended)

**Using the inspector**:

1. **Click the inspector icon** in the React tab
2. **Click an element** on the page (e.g., the PortfolioContainer div)
3. **The correct component** is selected automatically

---

## 📊 STATE INSPECTION

### Direct Access to Component State

**When selecting PortfolioContainer**, you will see:

```javascript
state: {
  pageTitle: "Welcome to my portfolio",
  isLoading: false,
  data: [Array of portfolio items]
}
```

### Interactive Manipulation

**Toggle isLoading**:

* **Click on isLoading** → change to `true`
* **The page displays** "Loading..."
* **Click again** → switches back to `false`
* **Data reappears** – change happens in real time

**Editing pageTitle**:

* **Click the value** of pageTitle
* **Edit directly** in React Tools
* **The change updates immediately** in the UI

### Data Array Exploration

**Expand the data array**:

* **Click the arrow** next to the data property
* **View individual items** – [0], [1], [2]
* **Select a specific item** – view all of its properties
* **Full API data** visible – images, category, description, etc.

---

## 👁️ PROPS INSPECTION

### PortfolioItem Props

**Selecting an individual PortfolioItem** shows:

```javascript
props: {
  key: "10",
  slug: 10,
  title: "Crondose",
  url: "https://crondose.com"
}
```

**Key property visible**:

* **React internal use** – for tracking
* **Unique identifier** – as established in the previous guide

---

## 🎯 KEY DIFFERENCE: INSPECTION SCOPE

### JavaScript Debugger Scope (Previous Guide)

```javascript
// In the map function – local scope
debugger;
item.name         // ✅ Local variable
item.description  // ✅ Item properties
this.state        // ❌ No access – outside scope
```

### React Developer Tools Scope (This Guide)

```javascript
// Component level – full scope
state.pageTitle   // ✅ Component state
state.data        // ✅ Full state
props.title       // ✅ Component props
```

**Different inspection levels**:

* **Debugger** – item-level / local scope
* **React Tools** – component-level / full state and props

---

## ✅ CAPABILITIES GAINED

### What You Can Do

**State inspection**:

* **View complete state** of any component
* **Modify values** in real time
* **Interactive testing** – toggle booleans, edit strings

**Props inspection**:

* **See props passed** to each component
* **Verify data flow** parent → child
* **Debug incorrect props** – validate values

**Component navigation**:

* **View the full component tree**
* **Understand parent/child relationships**
* **Quickly select** components with the inspector tool

---

## 🎓 ESTABLISHED PROFESSIONAL WORKFLOW

### Three Tools, Three Purposes

**1. Console.log** (Guide 08-045):

* **Quick overview** – view general data structure
* **Temporary development use** – fast exploration

**2. JavaScript Debugger** (Guide 08-046):

* **Interactive data testing** – execute scripts at runtime
* **Local variables** – inspect per-iteration values

**3. React Developer Tools** (This Guide):

* **React state/props debugging** – component-level
* **Real-time editing** – test dynamic behaviour
* **Component relationship insight** – structure validation

### When to Use Each

| Task                       | Tool                      |
| -------------------------- | ------------------------- |
| Explore API data structure | **Console.log**           |
| Test runtime logic         | **Debugger**              |
| Debug component behaviour  | **React Developer Tools** |

---

## 🔜 NEXT STEPS

* You now have full confidence in **data inspection** within React.
* The next guide will use this understanding to **render data** visually.

---

## ⚠️ 2025 UPDATE

### Current Interface vs Original Guide

**The original guide describes an interface that no longer exists.** The React Developer Tools layout has changed significantly.

### Current Interface (2025)

**Two primary tabs**:

* **⚛️ Components** – component inspection
* **⚛️ Profiler** – performance analysis

### Components Tab (Current)

**Modern layout**:

* **Left panel**: Expandable component tree
* **Right panel**: Information for the selected component

  * **Props** – data received
  * **State** – current state
  * **Rendered by** – parent component
  * **Source** – file/line reference

### Profiler Tab (Current)

Includes:

* **Flamegraph** – visualisation of render performance
* **Ranked** – sorted performance impact per component

### Functionality Maintained

* **Selecting components** → see props/state
* **Editing values** → real-time UI updates
* **Navigating hierarchy** → full structure clarity
* **Inspector tool** → quick component targeting

**The debugging methodology remains the same; only the UI layout has changed.**

---
