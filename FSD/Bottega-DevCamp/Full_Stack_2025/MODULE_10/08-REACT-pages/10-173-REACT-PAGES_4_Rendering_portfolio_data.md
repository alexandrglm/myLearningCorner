# 10-173: Rendering Portfolio Detail Data on Screen

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/rendering-portfolio-detail-data-screen)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at c9b64bdddbbfe8d44826d2fde8866121ddcbe00d](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/c9b64bdddbbfe8d44826d2fde8866121ddcbe00d)

---

## 🎯 Objectives

**Render API data in Portfolio Detail**:

- **State management** - store API response
- **Destructuring** - extract data for easy use
- **Dynamic rendering** - show content from API

---

## 🛠️ Implementation

### 1. Add State for Portfolio Item

```javascript
constructor(props) {
    super(props);

    this.state = {
        portfolioItem: {}
    };
}
```

### 2. Update API Call to Set State

```javascript
getPortfolioItem() {
    axios
        .get(`https://jordan.devcamp.space/portfolio/portfolio_items/${this.props.match.params.slug}`, 
             { withCredentials: true })
        .then(response => {
            this.setState({
                portfolioItem: response.data.portfolio_item
            });
        })
        .catch(error => {
            console.log("getPortfolioItem error", error);
        });
}
```

### 3. Destructuring for Render

```javascript
render() {
    const {
        banner_image_url,
        category,
        description,
        logo_url,
        name,
        thumb_image_url,
        url
    } = this.state.portfolioItem;

    return (
        <div>
            <h2>{name}</h2>
            <p>{description}</p>
        </div>
    );
}
```

---

## 📧 Concepts

### State Management Pattern

- **Empty object initially** - prevents errors
- **setState on API response** - updates UI automatically
- **Destructuring** - clean local variables

### API Data Path

```
response.data.portfolio_item.name
response.data.portfolio_item.description
// etc...
```

---

## 📋 Verification

**Testing**:

1. **Refresh page** → name and description appear
2. **Different portfolio items** → content changes dynamically
3. **No console errors** → state handling correct

---
