# 08-052 - How to Use Custom Fonts in React

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-use-custom-fonts-react

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/cabb1db456a7c0dbc48903a55274b82550c6f8ab)

---

## 🎯 ADD CUSTOM TYPOGRAPHY

### Importance of Typography

**For your portfolio**:

- **Unique personality** - differentiate yourself
- **Professionalism** - better than system fonts
- **Visual coherence** - same font throughout the app

---

## 🛠️ STEP-BY-STEP PROCESS

### 1. Select Font on Google Fonts

**Go to**: [https://fonts.google.com/](https://fonts.google.com/)

**Process**:

1. **Search for desired font** (e.g. "Titillium Web")
2. **Click on "+"** to select
3. **Open panel** "Family Selected"
4. **Copy provided HTML link**

### 2. Add Font Link to HTML

**File**: `static/index.html`

**In `<head>`, add**:

```html
<link href="https://fonts.googleapis.com/css?family=Titillium+Web:400,600,700" rel="stylesheet">
```

**Remove template fonts**:

```html
<!-- REMOVE any previous font from template -->
<!-- <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet"> -->
```

### 3. Apply Font in CSS

**File**: `src/style/base.scss`

**Use font-family from Google Fonts**:

```scss
body {
  margin: 0px;
  font-family: 'Titillium Web', sans-serif;
}
```

---

## 📋 VERIFICATION

### Font Testing

**Steps**:

1. **Save files** - index.html and base.scss
2. **Refresh browser** - may require hard refresh
3. **Verify visual change** in typography
4. **Compare** with previous font

### Expected Result

**Visual change**:

- **Font updated** throughout application
- **More professional** than system font
- **Consistent** across all text

---

## 🔧 EXTENDED CONTENT

### Implementation Alternatives

**Method 1: Link in HTML** (used in guide):

```html
<link href="https://fonts.googleapis.com/css?family=Titillium+Web" rel="stylesheet">
```

**Method 2: CSS Import**:

```scss
@import url('https://fonts.googleapis.com/css?family=Titillium+Web');
```

**Method 3: Local font files**:

- Download .woff2/.woff files
- Add to `static/assets/fonts/`
- Use `@font-face` in CSS

### Performance Optimisation

**Best practices**:

- **font-display: swap** - avoid invisible text flash
- **Preload critical fonts**
- **Subset fonts** - only necessary characters

---

## 🎨 CUSTOMISATION

### Font Weight Variants

**Modify URL** for more weights:

```html
<!-- Only regular -->
family=Titillium+Web

<!-- Multiple weights -->
family=Titillium+Web:400,600,700
```

**Use in CSS**:

```scss
.title {
  font-weight: 700; // Bold
}

.subtitle {
  font-weight: 600; // Semi-bold
}
```

---

## 💡 RECOMMENDATIONS

### Font Selection

**For professional portfolio**:

- **Legibility** > decoration
- **Web-safe** - well supported
- **Loading speed** - not too heavy
- **Personality** that reflects your style

### Popular Fonts for Portfolios

**Modern sans-serif**:

- Titillium Web, Lato, Open Sans, Roboto

**Elegant serif**:

- Playfair Display, Lora, Crimson Text

**Monospace for code**:

- Fira Code, Source Code Pro

---
