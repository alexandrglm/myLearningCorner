# 10-233: Finishing Result Post Component Styles

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/finishing-result-post-component-styles)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-33.

---

## 🛠️ Implementation

### 1. Move hover events to li

**File**: `src/components/post.js`

```javascript
render() {
    if(this.state.bgColor == 'red') {
        return <a href={this.props.url_for_post}>Link to {this.props.title}</a>
    }

    return (
        <li className="recent-post result-post"
            onMouseEnter={() => this.setColor('red')}
            onMouseLeave={() => this.setColor('white')}
        >
            <div className="recent-post__title result-post__title">
                <a href={this.props.url_for_post}>
                    {this.props.title}
                </a>
            </div>

            <div className="recent-post__topics result-post__topics">
                {this.renderTopics()}
            </div>

            <div className="result-post__links">
                {this.renderLinks()}
            </div>
        </li>
    )
}
```

### 2. Add styles for links

**File**: `src/style/results.scss`

```scss
.result-post {
    display: grid;
    align-content: space-around;
    grid-row-gap: 22px;

    .result-post__topics > * {
        color: $color-blue-one;
        font-size: 14px;
        line-height: 17px;
        font-weight: normal;
    }

    .result-post__title a {
        color: $color-gray-one;
        font-size: 18px;
        line-height: 22px;
    }

    .result-post__links {
        display: flex;
    }
}

.post-link {
    min-height: 70px;
    display: flex;

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

### 3. Add new color variable

**File**: `src/style/main.scss`

```scss
$color-gray-three: #D8D8D8;
```

---

## 📧 Concepts Flexbox + Grid

### Combining Grid and Flexbox

**Grid for main layout**:
```scss
.result-post {
    display: grid;  // Vertical layout of components
}
```

**Flexbox for horizontal alignment**:
```scss
.result-post__links {
    display: flex;  // Links horizontally
}
```

### Flexbox Default Direction

**Default `flex-direction: row`**:
- Items align horizontally
- `column` would stack them vertically

---
