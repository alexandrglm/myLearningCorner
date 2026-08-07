# 10-224: CSS Grid Explained for Daily Smarty UI

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/css-grid-explained-daily-smarty-ui)**
---

## 🎯 Objectives

**Introduce CSS Grid concepts and basic setup**:
- **Lato font setup** - Google Fonts integration
- **Home component structure** - CSS Grid container
- **Grid properties explanation** - align-content, justify-items
- **CodePen demonstration** - visual learning approach

---

## 🛠️ Implementation

### 1. Google Fonts Setup

**File**: `static/index.html`

```html
<link href="https://fonts.googleapis.com/css?family=Lato:400,700,900" rel="stylesheet">
```

**File**: `src/style/main.scss`

```scss
body {
    font-family: 'Lato', sans-serif;
}
```

### 2. Home Component Structure

**File**: `src/components/home.js`

```javascript
render() {
    return (
        <div className="home">
            <Logo />
            <SearchBar onSubmit={(query) => this.handleSearchbarSubmit(query)} />
            <RecentPosts />
        </div>
    );
}
```

### 3. Basic Grid Container

**File**: `src/style/main.scss`

```scss
.home {
    display: grid;
    height: 100vh;
    align-content: space-around;
    justify-items: center;
}
```

---

## 📧 CSS Grid Fundamental Concepts

### Grid Container Properties

**display: grid** - Activates grid layout
**height: 100vh** - Full viewport height required for vertical distribution
**align-content: space-around** - Distributes space around grid areas
**justify-items: center** - Centres items horizontally

### Axis Understanding

**align-* properties** - Column axis (vertical)
**justify-* properties** - Row axis (horizontal)

### Space Distribution Options

- **space-around** - Equal space around each item
- **space-between** - Space only between items
- **space-evenly** - Equal space everywhere
- **center** - Centres all content
- **stretch** - Stretches items to fill

---
