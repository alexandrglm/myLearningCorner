# 10-155: Installing Striptags Truncate Component React

---

**[Guide](https://devcamp.com/trails/dissecting-react-js/campsites/building-blog-react/guides/installing-striptags-truncate-component-react)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 0ce65d9e3f8a023f129ad8dbdcbb65db2f38149d](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/0ce65d9e3f8a023f129ad8dbdcbb65db2f38149d)

---

## 🎯 Objectives

**Install libraries for content processing and summary generation**:

- **Install striptags** - PHP-inspired library to remove HTML tags from strings
- **Install react-truncate** - React component for creating content summaries
- **Understand use case** - blog index needs summaries, not full HTML content
- **Library selection criteria** - well-maintained, popular, straightforward implementation
- **Prepare for implementation** - foundation for creating clean blog post summaries

**Problem to solve**: Blog index showing full HTML content with formatting tags instead of clean text summaries

**Strategy**: Strip HTML tags first, then truncate to create readable summaries

---

## 🛠️ Implementation

### 1. Install Both Libraries

**NPM installation command**:

```bash
npm i react-truncate striptags
```

**Two libraries installed**:

- **react-truncate** - React component for content truncation
- **striptags** - Utility for HTML tag removal

### 2. Verify Installation

**Check package.json**:

```json
{
  "dependencies": {
    "react-truncate": "^2.4.0",
    "striptags": "^3.2.0"
  }
}
```

**Verify node_modules**:

```bash
ls node_modules/ | grep -E "(react-truncate|striptags)"
```

---

## 📖 Concepts

### Problem Analysis: Blog Index vs Blog Detail

**Blog detail page approach** (previous guide):

```javascript
// Full HTML rendering with ReactHtmlParser
<div className="content">
  {ReactHtmlParser(content)}
</div>

// Result: Full formatted content with headings, paragraphs, bold text, etc.
```

**Blog index page requirement** (this approach):

```javascript
// Clean text summaries without HTML formatting
<div className="summary">
  {truncatedPlainText}
</div>

// Result: "Lorem ipsum dolor sit amet, consectetur adipiscing elit..."
```

### Why Different Approaches for Different Contexts

**Blog detail page**:

- **Single focus** - one blog post displayed
- **Full content** - user wants to read complete article
- **Rich formatting** - headings, bold, italic enhance readability
- **Professional presentation** - formatted content looks polished

**Blog index page**:

- **Multiple items** - list of blog posts
- **Navigation context** - users scanning for interesting posts
- **Clean summaries** - avoid visual clutter from HTML formatting
- **Consistent layout** - uniform text presentation

### Striptags Library Overview

**Purpose**: Remove HTML tags from strings

**NPM documentation example**:

```javascript
const striptags = require('striptags');

// Input with HTML tags
const html = '<p>Hello <strong>world</strong>!</p>';

// Output without tags
const plain = striptags(html);
// Result: "Hello world!"
```

**Advanced features**:

- **Whitelist specific tags** - keep certain tags, remove others
- **Blacklist specific tags** - remove certain tags, keep others
- **Flexible configuration** - customise behaviour per use case

**Real-world example**:

```javascript
// Keep only bold and italic tags
const filtered = striptags(html, ['strong', 'em']);
// Input: '<p>Hello <strong>world</strong> and <em>text</em>!</p>'
// Output: 'Hello <strong>world</strong> and <em>text</em>!'
```

### React-Truncate Component Overview

**Purpose**: Create content summaries with line-based truncation

**Component-based approach**:

```javascript
import Truncate from 'react-truncate';

<Truncate lines={3} ellipsis={<span>... <a href='/link/to/article'>Read more</a></span>}>
  {longContent}
</Truncate>
```

**Features**:

- **Line-based truncation** - specify number of lines to show
- **Custom ellipsis** - customise "..." replacement
- **Read more links** - integrated call-to-action
- **Responsive** - adapts to container width
- **React-native compatible** - works across React platforms

### Library Selection Decision Framework

**Criteria for good library choices**:

1. **Well-maintained** - regular updates, active development
2. **Popular and supported** - large user base, community support
3. **Security-conscious** - no known vulnerabilities
4. **Version compatibility** - works with current React versions
5. **Straightforward implementation** - clear, declarative API

**Examples mentioned in guide**:

**Good choices**:

- **React Router** - declarative, well-maintained, Facebook-backed
- **Draft.js** - complex but necessary, Facebook-backed, no alternative
- **Striptags** - simple utility, PHP heritage (battle-tested)
- **React-Truncate** - focused component, clear API

**Warning signs to avoid**:

- **Abandoned projects** - no recent updates
- **Security vulnerabilities** - known issues
- **Version incompatibility** - doesn't work with current React
- **Overly complex** for simple tasks

### Build vs Buy Decision Process

**When to build from scratch**:

- **Simple functionality** - easy to implement
- **Specific requirements** - existing libraries don't fit
- **Learning opportunity** - want to understand implementation
- **No dependencies** - avoid external library overhead

**When to use existing libraries**:

- **Complex functionality** - would take significant time to build
- **Well-established patterns** - standard solutions exist
- **Maintenance burden** - library team handles updates/security
- **Battle-tested** - proven in production environments

**Case study examples**:

```javascript
// Simple truncation (could build from scratch)
const truncate = (text, length) => text.length > length ? text.substring(0, length) + '...' : text;

// Complex rich text editor (use library)
// Building Draft.js equivalent would take months
```

### Content Processing Pipeline Preview

**Complete workflow we'll implement**:

```javascript
// Step 1: Get HTML content from API
const htmlContent = "<p>Hello <strong>world</strong>! This is a blog post.</p>";

// Step 2: Strip HTML tags
const plainText = striptags(htmlContent);
// Result: "Hello world! This is a blog post."

// Step 3: Truncate for summary
<Truncate lines={2}>
  {plainText}
</Truncate>
// Result: "Hello world! This is a blog post..." (truncated to 2 lines)
```

### Performance Considerations

**Library overhead analysis**:

- **Striptags** - lightweight utility, minimal bundle impact
- **React-Truncate** - small React component, reasonable overhead
- **Alternative approaches** - could implement manually but library provides cross-browser compatibility

**Benefits of libraries**:

- **Tested edge cases** - handle malformed HTML, various browsers
- **Performance optimised** - libraries often more efficient than custom code
- **Maintenance-free** - updates handled by library maintainers

---

## ✅ Verification

### 1. Package Installation Verification

**Check package.json dependencies**:

```json
{
  "dependencies": {
    "react-truncate": "^2.4.0",
    "striptags": "^3.2.0"
  }
}
```

### 2. Node Modules Verification

**Verify folders exist**:

```bash
# Check both libraries installed
ls node_modules/ | grep react-truncate
ls node_modules/ | grep striptags
```

### 3. Import Test (Optional)

**Quick import verification**:

```javascript
// Test imports in any component temporarily
import Truncate from 'react-truncate';
import striptags from 'striptags';

// Should not throw import errors
```

### 4. Library Documentation Access

**Verify you can access documentation**:

- **Striptags**: [https://www.npmjs.com/package/striptags](https://www.npmjs.com/package/striptags)
- **React-Truncate**: [https://www.npmjs.com/package/react-truncate](https://www.npmjs.com/package/react-truncate)

### 5. Installation Size Check

**Both libraries are lightweight**:

- Installation should complete quickly
- No complex dependency trees
- Minimal impact on bundle size

---

## 🎨 Content Strategy Preview

### Blog Index User Experience Goals

**What we want to achieve**:

- **Scannable content** - users can quickly review multiple posts
- **Clean presentation** - no distracting HTML formatting
- **Consistent summaries** - uniform length and appearance
- **Clear navigation** - easy to find and click interesting posts

### Content Processing Strategy

**Two-step approach**:

1. **Strip HTML tags** - remove all formatting to get plain text
2. **Truncate intelligently** - limit to reasonable summary length

**Why this order matters**:

```javascript
// ✗ Wrong order: truncate first, then strip
const truncated = htmlContent.substring(0, 100);
const clean = striptags(truncated);
// Problem: might cut off in middle of HTML tag

// ✓ Correct order: strip first, then truncate  
const clean = striptags(htmlContent);
const truncated = <Truncate lines={3}>{clean}</Truncate>;
// Result: clean text, properly truncated
```

### Alternative Approaches Considered

**Other possible solutions**:

1. **Manual truncation** - substring() with length limit
2. **CSS-only truncation** - text-overflow: ellipsis
3. **Server-side summaries** - API returns pre-generated summaries
4. **Rich text excerpts** - keep some formatting in summaries

**Why our approach is better**:

- **Client-side flexibility** - can adjust summary length easily
- **Cross-browser compatibility** - works regardless of CSS support
- **Rich content handling** - properly processes complex HTML
- **React integration** - component-based approach fits React architecture

---
