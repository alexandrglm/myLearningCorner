# 10-201: Generating Daily Smarty UI Application

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/generating-daily-smarty-ui-application)**

[Generated project · bottega-code-school/DailySmartyUI@a89b6f1 · GitHub](https://github.com/bottega-code-school/DailySmartyUI/commit/a89b6f177567f41e0dbf94ba86aff8248b91fd24)

---



## 🎯 Objectives

**Setup new DailySmartyUI project**:

- **Generate React-Redux-Router** template
- **Git repository** setup and version control
- **CSS Grid introduction** - new layout system
- **Project structure** preparation

---

## 🛠️ Project Generation

### 1. Create GitHub Repository

```bash
# Repository name: DailySmartyUI
# Description: Daily Smarty User Interface
# Public repository
```

### 2. Generate React Project

```bash
js-generate
# Select: react-redux-router
# Name: DailySmartyUI
cd DailySmartyUI
```

### 3. Setup Version Control

```bash
# Rename gitignore
mv .gitignore.example .gitignore

# Install dependencies
npm install

# Test application
npm start
# Should run on localhost:3000
```

### 4. Initial Configuration

**Update**: `static/index.html`

```html
<title>Daily Smarty</title>
```

**Update**: `src/components/app.js`

```javascript
render() {
    return (
        <div>
            logo
        </div>
    );
}
```

### 5. Git Setup

```bash
git init
git remote add origin [your-repo-url]
git add .
git commit -m "generated project"
git push origin master
```

---

## 📧 New Technologies

### CSS Grid Introduction

**Why CSS Grid**:

- **No frameworks needed** - vs Bootstrap/Reactstrap
- **Native CSS solution** - browser-supported
- **Powerful layout system** - 2D grid control
- **Easy to learn** - intuitive syntax

**Learning resource**: Jordan's CSS Grid course (recommended for spare time)

### Project Structure

**DailySmartyUI focus**:

- **UI-only application** - no backend development
- **Client-side focus** - consume external API
- **CSS Grid layouts** - modern layout techniques
- **Component architecture** - advanced React patterns

---

## 📋 Verification

**Testing setup**:

1. **npm start** - application runs on localhost:3000
2. **Browser displays** - "logo" text visible
3. **Git tracking** - repository connected and pushed
4. **Dependencies installed** - no errors in console

**File structure expected**:

```
DailySmartyUI/
├── src/
├── static/
├── .gitignore
├── package.json
└── node_modules/
```

---
