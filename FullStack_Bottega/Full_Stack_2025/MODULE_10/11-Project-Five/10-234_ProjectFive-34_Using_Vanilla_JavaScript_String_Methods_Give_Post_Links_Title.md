# 10-234: Using Vanilla JavaScript String Methods Give Post Links Title

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/using-vanilla-javascript-string-methods-give-post-links-title)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-34.

---

## 🛠️ Problem Analysis

### Current links show full URL
Instead of showing "Useful Link", we need to extract descriptive titles from the URLs.

**Example URL**:
```
https://example.com/blog/ruby-on-rails-code-audits-8-steps-to-review-your-app
```

**Desired title**:
```
ruby-on-rails-code-audits-8-steps-to-review-your-app
```

---

## 🔧 JavaScript String Methods

### 1. substring()

```javascript
// Extract part of a string
var str = "Hello World";
str.substring(1, 4);  // "ell"
str.substring(0, str.length);  // Entire string
```

### 2. lastIndexOf()

```javascript
// Find last occurrence of a character
var str = "https://example.com/blog/ruby-on-rails-code-audits";
var n = str.lastIndexOf('/');  // Position of last /
```

### 3. Combining methods

```javascript
var str = "https://example.com/blog/ruby-on-rails-code-audits";
var n = str.lastIndexOf('/');
var title = str.substring(n + 1, str.length);
// Result: "ruby-on-rails-code-audits"
```

---

## 🧪 Test on W3Schools (Change URL to your mock)

**Testing playground**:
```javascript
var str = "https://dailysmarty.com/posts/entries/ruby-on-rails-code-audits-8-steps-to-review-your-app";
var n = str.lastIndexOf('/');
var result = str.substring(n + 1, str.length);
// result: "ruby-on-rails-code-audits-8-steps-to-review-your-app"
```

---
