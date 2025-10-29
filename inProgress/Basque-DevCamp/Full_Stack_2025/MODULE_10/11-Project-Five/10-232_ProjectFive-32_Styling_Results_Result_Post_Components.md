# 10-232: Styling Results Result Post Components

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/styling-results-result-post-components)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-32.

---

## 🛠️ Implementation

### 1. Update results.scss

**File**: `src/style/results.scss`

```scss
.results {
    // @include default-page-layout();
    height: 100vh;
    width: 66vw;
    display: grid;
    margin-top: 52px;
    grid-row-gap: 44px;
}

.results-posts {
    .results-posts__wrapper {
        .results-posts__posts {
            display: grid;
            grid-row-gap: 21px;
            justify-content: stretch;
        }
    }
}

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

    }
}
```

### 2. Update post.js

**File**: `src/components/post.js`

```javascript
renderTopics() {
    let topics = this.props.post_topics.map((topic, index) => {
        return <span className="post-topic" key={index}>{topic}</span>
    })

    return topics;
}

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

            </div>
        </li>
    )
}
```

---

## 📧 Grid Layout Concepts

### Grid Row Gap Calculation

**Why 21px and not 64px**:
- Design shows 64px when expanded
- Grid-row-gap of 22px within each post
- Total: 21px + 22px ≈ 42px desired spacing

### Child Selectors

```scss
.result-post__topics > * {
    // Applies styles to all direct children
}
```

**Selects**: All `<span class="post-topic">` within topics.

---
