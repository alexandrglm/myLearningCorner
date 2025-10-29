# 10-172: Initial Portfolio Detail Component Build Out

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/initial-build-out-portfolio-detail-component)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 7d0160645402913861a4a07107b8bd00fcc2e52d](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/7d0160645402913861a4a07107b8bd00fcc2e52d)

---

## 🎯 Objectives

**Create navigation from portfolio items to detail pages**:

- **Clickable links** on portfolio items 
- **Dynamic route** `/portfolio/:slug`
- **Component path** - follow hierarchy from App to PortfolioItem
- **Functional → Class** conversion for API calls
- **API integration** basic setup

---

## 🛠️ Implementation

### 1. Create PortfolioDetail Component

**File**: `src/components/portfolio/portfolio-detail.js`

```javascript
import React from "react";

const PortfolioDetail = (props) => {
    return (
        <div>
            <h2>Portfolio Detail for {props.match.params.slug}</h2>
        </div>
    );
};

export default PortfolioDetail;
```

### 2. Add Dynamic Route in App.js

```javascript
import PortfolioDetail from './portfolio/portfolio-detail';

// In Switch:
<Route path="/portfolio/:slug" component={PortfolioDetail} />
```

### 3. Make Portfolio Items Clickable

**File**: `src/components/portfolio-item.js`

```javascript
import React from 'react';
import { Link } from 'react-router-dom';

const PortfolioItem = (props) => {
    const { id, description, thumb_image_url, logo_url } = props.item;

    return (
        <Link to={`/portfolio/${id}`}>
            <div className="portfolio-item-wrapper">
                <div 
                    className="portfolio-img-background"
                    style={{
                        backgroundImage: "url(" + thumb_image_url + ")"
                    }}
                />

                <div className="img-text-wrapper">
                    <div className="logo-wrapper">
                        <img src={logo_url} />
                    </div>

                    <div className="subtitle">
                        {description}
                    </div>
                </div>
            </div>
        </Link>
    );
}

export default PortfolioItem;
```

### 4. Convert to Class Component for API

**File**: `src/components/portfolio/portfolio-detail.js`

```javascript
import React, { Component } from "react";
import axios from 'axios';

export default class PortfolioDetail extends Component {
    constructor(props) {
        super(props);
    }

    getPortfolioItem() {
        axios
            .get(
                `https://jordan.devcamp.space/portfolio/portfolio_items/${this.props.match.params.slug}`,
                { withCredentials: true }
            )
            .then(response => {
                console.log("res", response);
            })
            .catch(error => {
                console.log("getPortfolioItem error", error);
            });
    }

    componentWillMount() {
        this.getPortfolioItem();
    }

    render() {
        return (
            <div>
                <h2>Portfolio Detail for {this.props.match.params.slug}</h2>
            </div>
        );
    }
}
```

---

## 📧 Concepts

### Component Path Navigation

**Follow component hierarchy**:

1. **App.js** → Router setup
2. **Home page** → contains PortfolioContainer  
3. **PortfolioContainer** → renders PortfolioItems
4. **PortfolioItem** → where to add Link

### Link Wrapping Technique

```javascript
<Link to={`/portfolio/${id}`}>
    <div className="portfolio-item-wrapper">
        {/* All content clickable */}
    </div>
</Link>
```

### Template Literals for URLs

```javascript
to={`/portfolio/${id}`}  // Dynamic URL generation
```

### Lifecycle Hook for API

```javascript
componentWillMount() {
    this.getPortfolioItem();  // Fires when component loads
}
```

---

## 📋 Verification

**Testing clicks**:

1. **Click portfolio item** → navigates to `/portfolio/[id]`
2. **Console log** → API response data visible
3. **Different items** → different IDs in URL
4. **Back navigation** → browser back works

---
