# 10-235: Handling Few Cases Pretty Post Link Names

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/handling-few-cases-pretty-post-link-names)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-35.

---

## 🛠️ Implementation

### 1. Create getNameForPostLink function

**File**: `src/components/post.js`

```javascript
getNameForPostLink(str) {
    var n = str.lastIndexOf('/');
    var link = str.substring(n + 1, str.length);
    
    if((n+1) == str.length) {
        link = str.slice(0, n);
        n = link.lastIndexOf('/');
        link = str.substring(n + 1, str.length - 1);
    }
    
    if(link.includes('.html')) {
        link = link.substring(0, link.length - 5);
    }
    
    if(link.includes('.htm')) {
        link = link.substring(0, link.length - 4);
    }
    
    return link;
}

renderLinks() {
    let links = this.props.post_links.map((post_link, index) => {
        return (
            <div className="post-link" key={index}>
                <div className="post-link__box"></div>
                <div className="post-link__link">
                    <a href={post_link.link_url}>
                        {this.getNameForPostLink(post_link.link_url)}
                    </a>
                </div>
            </div>
        )
    })

    return links;
}
```

---

## 📧 Edge Cases Handled

### 1. URLs ending in /

**Problem**:
```
https://example.com/blog/
```

**Solution**:
```javascript
if((n+1) == str.length) {
    link = str.slice(0, n);
    n = link.lastIndexOf('/');
    link = str.substring(n + 1, str.length - 1);
}
```

### 2. URLs with .html/.htm extensions

**Problem**:
```
routing.html -> we want: routing
```

**Solution**:
```javascript
if(link.includes('.html')) {
    link = link.substring(0, link.length - 5);
}

if(link.includes('.htm')) {
    link = link.substring(0, link.length - 4);
}
```

---

## 🧪 Test Cases

**Input**: `https://example.com/blog/mongo-shell/`
**Output**: `mongo-shell`

**Input**: `https://example.com/routing.html`  
**Output**: `routing`

**Input**: `https://example.com/guide.htm`
**Output**: `guide`

---
