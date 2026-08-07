# 10-225: Applying CSS Grid Styles to Home Component

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/applying-css-grid-styles-home-component)**
---

## 🎯 Objectives

**Apply CSS Grid styles to Home component**:
- **Width calculation** - responsive design based on viewport
- **Grid properties** - align-content, justify-items
- **App-wrapper centring** - center entire home container
- **Grid template exploration** - grid-template-rows experimentation

---

## 🛠️ Implementation

### 1. Home Component Grid Styles

**File**: `src/style/main.scss`

```scss
.home {
    height: 100vh;
    width: 66vw;
    display: grid;
    align-content: space-around;
    justify-items: center;
}
```

### 2. App Wrapper Centring

```scss
.app-wrapper {
    display: grid;
    justify-content: center;
}
```

---

## 📧 Width Calculation Process

### Design-Based Responsive Width

**Calculation method**:
- **Design search bar width**: 942px
- **Design document width**: 1440px  
- **Percentage**: 942 ÷ 1440 = 0.654 ≈ 66%
- **Result**: `width: 66vw`

### Viewport Units Benefits

**66vw advantages**:
- **Responsive** - adapts to screen size
- **Design accuracy** - matches mockup proportions
- **Scalable** - works across devices

---

## 📧 CSS Grid Properties Applied

### Align-Content Options

**space-around** (chosen):
- **Even spacing** around each item
- **Visual balance** - space top/middle/bottom

**Alternatives tested**:
- **space-evenly** - too much spacing
- **space-between** - no top/bottom space

### Justify-Items: center

**Effect**: Centres grid items horizontally within their grid areas
**Works with**: Logo, SearchBar, RecentPosts components

---

## 📋 Grid Template Rows Exploration

### Template Rows Concept

```scss
grid-template-rows: 1fr 2fr 1fr;
```

#### *fr unit* explanation

- **Fractional unit** - divides available space
- **1fr 2fr 1fr** = 1/4, 2/4, 1/4 distribution
- **Flexible sizing** - adapts to container height

**Decision**: Removed for now, may implement later for precise spacing control

---
