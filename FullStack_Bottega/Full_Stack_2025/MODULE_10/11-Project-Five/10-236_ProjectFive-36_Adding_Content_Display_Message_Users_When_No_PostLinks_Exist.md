# 10-236: Adding Content Display Message Users When No PostLinks Exist

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/adding-content-display-message-users-when-no-postlinks-exist)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-36.

---

## 🛠️ Implementation

### 1. Add "No Post Links" message

**File**: `src/components/post.js`

```javascript
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

    if(links == 0) {
        return <div className="no-content">No Post Links</div>
    }

    return links;
}
```

### 2. Styles for no-content

**File**: `src/style/main.scss`

```scss
.no-content {
    color: $color-gray-one;
    font-size: 14px;
    line-height: 17px;
}
```

### 3. Fix for multiple links with Flexbox

**File**: `src/style/results.scss`

```scss
.result-post__links {
    display: flex;
}

.post-link {
    min-height: 70px;
    display: flex;
    flex-basis: 205px;
    margin-right: 37px;

    .post-link__box {
        min-width: 70px;
        background-color: $color-gray-three;
        margin-right: 16px;
    }

    .post-link__link a {
        color: $color-gray-one;
        font-size: 14px;
        line-height: 17px;
    }
}
```

---

## 🔧 Flexbox Concepts

### flex-basis
```scss
flex-basis: 205px;  // Base width for each link
```

### margin-right
```scss
margin-right: 37px;  // Space between links
```

---
