# 07-044 - Populating Portfolio Item Data

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/populating-portfolio-item-data](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/populating-portfolio-item-data)

**ASSETS**: [https://github.com/jordanhudgens/react-portfolio-assets](https://github.com/jordanhudgens/react-portfolio-assets)

---

## 🎯 FUNDAMENTAL CONCEPTS

### Objective of the Guide

**Preparation for advanced functionality**:

* **Realistic data** – not merely placeholders
* **Actual images** – thumbnail, banner, logo
* **Functional links** – real external URLs
* **Foundation for upcoming features** – image rendering

### The Importance of Real Data

**Why real data matters**:

* **Complete testing** – verify full behaviour
* **Realistic UI** – understand how it will work in practice
* **Effective debugging** – real issues instead of placeholder issues
* **Professional portfolio** – ready for actual presentation

---

## 📁 IMAGE RESOURCES

### Instructor’s Asset Repository

**GitHub Repository**: [https://github.com/jordanhudgens/react-portfolio-assets](https://github.com/jordanhudgens/react-portfolio-assets)

**Available content**:

* **backgrounds/** – images for `thumb_image`
* **banners/** – images for `banner_image`
* **logos/** – project logos

**How to use**:

1. **Click "Clone or Download"** → Download ZIP
2. **Extract the files** on your computer
3. **Use the images** to populate DevCamp Space

### Asset Structure

```
react-portfolio-assets/
├── backgrounds/
│   ├── crondose.jpg
│   ├── dailysmarty.jpg
│   └── [other projects]
├── banners/
│   ├── crondose.jpg
│   ├── dailysmarty.jpg
│   └── [other projects]
└── logos/
    ├── crondose.png
    ├── dailysmarty.png
    └── [other projects]
```

---

## 🛠️ PRACTICAL STEPS – POPULATING DATA

### 1. Clear Test Data

**In DevCamp Space**:

1. Go to **Portfolio → Portfolio Items**
2. Click **"View Data"**
3. **Delete test items** – click ✖️ on each temporary item
4. **Confirm removal** – leave the table empty

### 2. Add First Portfolio Item

**Example: Crondose Blog**

**Basic data**:

```
Name: Crondose
Description: Technology blog featuring daily insights and tutorials on web development, programming languages, and emerging tech trends
URL: https://crondose.com
Category: Technology
Position: 1
```

**Images** (from `react-portfolio-assets`):

* **thumb_image**: `backgrounds/crondose.jpg`
* **banner_image**: `banners/crondose.jpg`
* **logo**: `logos/crondose.png`

### 3. Add Second Portfolio Item

**Example: DailySmarty**

**Basic data**:

```
Name: DailySmarty
Description: Social media platform for developers to track and share daily learning progress with integrated coding challenges
URL: https://dailysmarty.com
Category: Social Media
Position: 2
```

**Images**:

* **thumb_image**: `backgrounds/dailysmarty.jpg`
* **banner_image**: `banners/dailysmarty.jpg`
* **logo**: `logos/dailysmarty.png`

### 4. Upload Process

**Steps for each image**:

1. **Click image field** (`thumb_image`, `banner_image`, `logo`)
2. **Select file** from `react-portfolio-assets/`
3. **Verify the preview** – the image should appear
4. **Click ➕** – submit the completed portfolio item

**⚠️ Note about white logos**:

* Logos may appear invisible (white on white background)
* **This is normal** – the logo has transparency
* It **will display correctly** where intended in the application

---

## 🔍 DATA VERIFICATION

### Testing in DevCamp Space

**Verify API endpoint**:

1. Go to **Portfolio tab** → **All Items link**
2. **Check JSON response** for real data
3. **Expand `portfolio_item_images`** – confirm correct image URLs
4. **Open image URLs** to verify accessibility

**Expected structure**:

```json
[
  {
    "id": 10,
    "name": "Crondose",
    "description": "Technology blog featuring...",
    "url": "https://crondose.com",
    "category": "Technology",
    "position": 1,
    "portfolio_item_images": [
      {
        "url": "https://example.com/...",
        "id": 15
      }
    ]
  }
]
```

### Testing in the React Application

**Verify in `localhost:3000`**:

1. **Refresh the page** – new data should appear
2. **Real titles** should be visible – "Crondose", "DailySmarty"
3. **Click URLs** – should open external websites
4. **Verify structure** – headings and links

**Expected output**:

```html
<div>
  <h3>Crondose</h3>
  <h4>https://crondose.com</h4>
  <a href="/portfolio/10">Link</a>
</div>
```

---

## 📋 DATA TEMPLATES

### Portfolio Item Template

```
Name: [Project Name]
Description: [Detailed description – 2–3 lines explaining main functionality]
URL: [External project link or GitHub repository]
Category: [eCommerce | Technology | Social Media | Enterprise]
Position: [Sequential number: 1, 2, 3...]
```

### Suggested Categories

* **Technology** – blogs, tools, utilities
* **eCommerce** – shops, marketplaces, payment systems
* **Social Media** – communication platforms
* **Enterprise** – corporate software, CRM, management systems
* **Education** – learning platforms, courses

### Recommended URLs

* **Live demos** – production sites
* **GitHub repositories** – source code
* **Portfolio showcases** – case studies
* **Landing pages** – project overview pages

---

## 🎨 IMAGE MANAGEMENT

### Image Types and Their Uses

**thumb_image**:

* **Use**: Lists, grids, previews
* **Recommended size**: ~400x300px
* **Format**: JPG for photos, PNG for graphics

**banner_image**:

* **Use**: Headers, detail pages
* **Recommended size**: ~1200x600px
* **Format**: High quality JPG

**logo**:

* **Use**: Branding and icons
* **Recommended size**: ~200x200px
* **Format**: PNG with transparency

### Image Best Practices

**Descriptive filenames**:

```
✅ project-background.jpg
✅ crondose-banner.jpg
✅ dailysmarty-logo.png

❌ img1.jpg
❌ screenshot.png
❌ untitled.jpg
```

**Optimisation**:

* **Compression** – quality balanced with size
* **Responsive sizes** – match usage
* **Alt text** – improve accessibility

---
