# 10-223: Utilising React Animate Height NPM Package to Add Hover Animations

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/utilizing-react-animate-height-npm-package-add-hover-animations)**
---

## 🎯 Objectives

**Add hover animations to result posts**:
- **React Animate Height** - NPM package for smooth height transitions
- **Mouse event handlers** - onMouseEnter/onMouseLeave
- **State-driven animations** - height controlled via component state
- **Title links** - clickable titles with url_for_post

---

## 🛠️ Implementation

### 1. Install React Animate Height

```bash
npm install --save react-animate-height
```

### 2. Update Post Component with Animation

**File**: `src/components/post.js`

```javascript
import React, { Component } from 'react';
import AnimateHeight from 'react-animate-height';

class Post extends Component {
    constructor(props) {
        super(props);

        this.state = {
            height: 0
        }
    }

    renderTopics() {
        let topics = this.props.associated_topics.map((topic, index) => {
            return <span className="post-topic" key={index}>{topic}</span>
        })
        return topics;
    }

    renderLinks() {
        let links = this.props.post_links.map((post_link, index) => {
            return (
                <div className="post-link" key={index}>
                    <div className="post-link__box"></div>
                    <div className="post-link__link">
                        <a href={post_link.link_url}>Useful Link #{index + 1}</a>
                    </div>
                </div>
            )
        })
        return links;
    }

    render() {
        if(this.props.type == 'recent') {
            return (
                <li className="recent-post">
                    <div className="recent-post__title">
                        {this.props.title}
                    </div>
                    <div className="recent-post__topics">
                        {this.renderTopics()}
                    </div>
                </li>
            )
        } else if(this.props.type == 'result') {
            return (
                <li className="result-post">
                    <div className="result-post__topics">
                        {this.renderTopics()}
                    </div>
                    <div className="result-post__title">
                        <a href={this.props.url_for_post}
                           onMouseEnter={() => this.setState({ height: 70 })}
                           onMouseLeave={() => this.setState({ height: 0 })}
                        >
                            {this.props.title}
                        </a>
                    </div>
                    <AnimateHeight 
                        duration={500} 
                        height={this.state.height}
                    >
                        <div className="result-post__links">
                            {this.renderLinks()}
                        </div>
                    </AnimateHeight>
                </li>
            )
        }
    }
}

export default Post;
```

---

## 📧 Technical Concepts

### React Animate Height Usage

```javascript
<AnimateHeight 
    duration={500}      // Animation duration in ms
    height={this.state.height}  // Dynamic height from state
>
    <Content />
</AnimateHeight>
```

### Mouse Event Handlers

**onMouseEnter**: Triggered when cursor enters element
**onMouseLeave**: Triggered when cursor exits element

```javascript
onMouseEnter={() => this.setState({ height: 70 })}
onMouseLeave={() => this.setState({ height: 0 })}
```

### State-Driven Animation

- **Initial state**: height: 0 (collapsed)
- **Hover state**: height: 70 (expanded) 
- **Animation**: Smooth transition between states

### Title Links

```javascript
<a href={this.props.url_for_post}>
    {this.props.title}
</a>
```

**Benefits**:
- **Clickable titles** - navigate to original post
- **External links** - open in same tab
- **Hover trigger** - activates animation

---

## 📋 Animation Behaviour

**User interaction flow**:
1. **Default state** - links hidden (height: 0)
2. **Mouse enters title** - links expand smoothly
3. **Mouse leaves title** - links collapse smoothly
4. **Click title** - navigate to external post

**Animation properties**:
- **Duration**: 500ms transition
- **Smooth easing** - handled by react-animate-height
- **Height-based** - from 0 to 70px

---
