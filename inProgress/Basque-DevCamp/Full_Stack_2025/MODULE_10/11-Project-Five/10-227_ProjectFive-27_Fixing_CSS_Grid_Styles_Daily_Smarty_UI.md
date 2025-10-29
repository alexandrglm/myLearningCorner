# 10-227: Fixing CSS Grid Styles Daily Smarty UI

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/fixing-css-grid-styles-daily-smarty-ui)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-27.

---

## 🛠️ Implementation

### 1. Change justify-items to stretch

**File**: `src/style/main.scss`

```scss
.home {
    height: 100vh;
    width: 66vw;
    display: grid;
    align-content: space-around;
    justify-items: stretch;  // Changed from center to stretch
    // grid-template-rows: 1fr 2fr 1fr;
}
```

### 2. Centre logo and recent posts

**File**: `src/style/main.scss`

```scss
.logo-main,
.recent-posts {
    display: grid;
    justify-items: center;
}
```

---
