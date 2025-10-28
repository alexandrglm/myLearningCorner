# 08-065 - Finalising Auth Component Styles

**Guide**: https://basque.devcamp.com/pt-full-stack-development-javascript-python-react/guide/finalizing-auth-component-styles

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/091bd1feb1ab9e42139cdd43d0a40eb208e9af7e)

---

## 🎯 OBJECTIVES

### Professional Authentication Layout

**Visual system to implement**:

- CSS Grid for 50/50 two-column split
- Background image covering entire left column
- Right column centred vertically and horizontally
- Height calculated dynamically (viewport - navbar)
- Professional off-white background for contrast

### Modular SCSS Organisation

**Concepts you will master**:

- Dedicated file for authentication styles
- Organised import system in main.scss
- SCSS variables for consistent colours
- CSS Grid + Flexbox hybrid approach

---

## 🛠️ IMPLEMENTATION

### 1. Create Dedicated SCSS File

**Create**: `src/style/auth.scss`

**Base style structure**:

```scss
.auth-page-wrapper {
    display: grid;
    grid-template-columns: 1fr 1fr;
    height: calc(100vh - 84px);
}

.left-column {
    background-size: cover;
}

.right-column {
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: $offwhite;
}
```

### 2. Update Main SCSS with Import

**File**: `src/style/main.scss`

**Add import of new file**:

```scss
@import "./variables.scss";
@import "./base.scss";
@import "./navigation.scss";
@import "./portfolio.scss";
@import "./button.scss";
@import "./auth.scss";  // New import
```

### 3. Verify Available SCSS Variables

**In**: `src/style/variables.scss`

**Confirm off-white variable**:

```scss
$teal: #26bfd4;
$dark-teal: #207b88;
$charcoal: #42454a;
$offwhite: #f6f6f6;  // Variable needed for background
$blue: #008dff;
$warning: #922a2a;
$grey: #8a8a8a;
```

---

## 🔧 TECHNICAL CONCEPTS

### CSS Grid for Main Layout

**Exact two-column grid**:

```scss
grid-template-columns: 1fr 1fr;
```

**Why CSS Grid?**:

- **Perfect split** - two columns exactly equal
- **Responsive automatic** - adapts to viewport
- **Simple and direct** - no flexbox complications for this layout
- **Browser support** - broad modern support

### Dynamic Height with calc()

**Smart calculation**:

```scss
height: calc(100vh - 84px);
```

**Calculation breakdown**:

- **100vh** - full viewport height
- **84px** - exact navbar height (including padding)
- **calc()** - CSS function that performs maths at runtime
- **Result** - perfect height without scroll or overlap

### Background Image Cover

**Behaviour of `background-size: cover`**:

- **Covers completely** the container
- **Maintains aspect ratio** - doesn't distort image
- **Smart cropping** - clips edges if necessary
- **Always fills** - never leaves white space

### Flexbox for Perfect Centring

**Right column centred**:

```scss
display: flex;
justify-content: center;  // Horizontal centring
align-items: center;      // Vertical centring
```

**Why Flexbox here?**:

- **Perfect centring** - both horizontal and vertical
- **One line of code** - simpler than CSS Grid for this case
- **Flexible content** - adapts to form size

---

## ✔️ VERIFICATION

### Visual Layout Testing

**Verification steps**:

1. **Save files** - auth.scss and main.scss
2. **Navigate to** `localhost:3000/auth`
3. **Verify split** - two equal columns
4. **Check image** - covers entire left column
5. **Verify centring** - placeholder centred in right column

### Expected Visual Result

**Layout achieved**:

- **Coding image** filling entire left side completely
- **Two columns** exactly equal
- **Placeholder text** perfectly centred
- **Off-white background** in right column
- **No vertical scroll** - height calculated correctly

---

## 🎨 DESIGN AND UX

### Colour Psychology

**Off-white background**:

- **Subtle contrast** with vibrant image
- **Professional feel** - not pure white which can be harsh
- **Form readability** - neutral background for text
- **Consistent branding** - same off-white as navbar

### Visual Hierarchy

**Layout balance**:

- **Impactful image** draws attention but doesn't dominate
- **Clean space** for form (next guide)
- **50/50 split** - perfect visual balance
- **Seamless integration** - cohesive with rest of app

---

## 🚀 EXTENDED CONTENT

### Alternative Layout Approaches

**Responsive breakpoints**:

```scss
.auth-page-wrapper {
    display: grid;
    grid-template-columns: 1fr 1fr;

    @media (max-width: 768px) {
        grid-template-columns: 1fr;
        grid-template-rows: 40vh 1fr;
    }
}
```

### Advanced Grid Layouts

**Asymmetric splits**:

```scss
// 60/40 split
grid-template-columns: 3fr 2fr;

// Golden ratio split
grid-template-columns: 1.618fr 1fr;

// Fixed + flexible
grid-template-columns: 400px 1fr;
```

---

## 🎯 EXPECTED RESULTS

- ✅ **Perfect split layout** - balanced two columns
- ✅ **Professional styling** - ready for real form
- ✅ **Scalable SCSS** - architecture for growth
- ✅ **Visual consistency** - integrated with design system
- ✅ **Optimised performance** - efficient CSS without overhead

**Key difference from basic layouts**:

- **Calculated heights** - no guess-work for dimensions
- **Semantic organisation** - styles where they belong
- **Design system integration** - shared variables
- **Professional UX** - layout that users expect on auth pages

---
