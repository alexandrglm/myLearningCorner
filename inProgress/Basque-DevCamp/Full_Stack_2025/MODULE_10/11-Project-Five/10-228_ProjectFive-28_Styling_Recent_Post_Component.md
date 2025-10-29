# 10-228: Styling Recent Post Component

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/styling-recent-post-component)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-28.

---

## 🛠️ Implementation

### 1. Create recentPosts.scss

**File**: `src/style/recentPosts.scss`

```scss
.recent-posts {
    display: grid;
    align-content: center;
    justify-items: center;

    .recent-posts__wrapper {
        display: grid;
        grid-row-gap: 21px;
        width: 100%;

        .recent-posts__heading {
            color: $color-blue-one;
            font-size: 14px;
        }

        .recent-posts__posts {
            display: grid;
            justify-content: space-evenly;
            grid-template-columns: 1fr 1fr 1fr;
            grid-gap: 42px;
        }
    }
}
```

### 2. Import in main.scss

**File**: `src/style/main.scss`

```scss
@import './recentPosts';

// Remove dots from all lists
ul {
    margin: 0;
    padding: 0;
    list-style-type: none;
}

// Colour variable
$color-blue-one: #1976D2;
```
---
