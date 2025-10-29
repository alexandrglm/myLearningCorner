# 10-238: Making Home Screen Mobile Responsive CSS Media Queries

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/making-home-screen-mobile-responsive-css-media-queries)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-38.

---

## 🛠️ Implementation

### 1. Media Query for Recent Posts

**File**: `src/style/recentPosts.scss`

```scss
.recent-posts__posts {
    display: grid;
    grid-gap: 42px;
    
    @media screen and (min-width: 700px) {
        grid-template-columns: 1fr 1fr 1fr;
    }
}
```

### 2. Media Query for Search Bar

**File**: `src/style/searchBar.scss`

```scss
.search-bar__home {
    align-content: center;
    justify-items: center;

    input {
        height: 118px;
        font-size: 40px;
        
        @media screen and (max-width: 600px) {
            font-size: 23px;
            height: 59px;
        }
    }
}
```

---

## 🔧 Media Queries Concepts

### min-width vs max-width

**min-width**: Applies styles when screen ≥ value
```scss
@media screen and (min-width: 700px) {
    // Desktop: large screens
}
```

**max-width**: Applies styles when screen ≤ value
```scss
@media screen and (max-width: 600px) {
    // Mobile: small screens
}
```

### Fractional Units (fr)

**1fr 1fr 1fr** = 3 equal columns that occupy all available space.

---

---

## ✅ ProjectFive-X Completed

**Final features**:
- ✅ Complete responsive design
- ✅ Mobile-first approach
- ✅ Desktop and mobile layouts
- ✅ Media queries implemented
- ✅ App deployed on Heroku

---
