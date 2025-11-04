# 10-174: Portfolio Detail Page Styles

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/portfolio-detail-styles)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 2f44eddf8024dcc6bc562da11ffc975a5c414e87](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/2f44eddf8024dcc6bc562da11ffc975a5c414e87)

---

## 🎯 Objectives

**Create complete layout for portfolio detail**:

- **Banner section** - background image + logo centred
- **Description** - large centred text
- **Visit link** - button-style link to external site

---

## 🛠️ Implementation

### 1. Create portfolio-detail.scss

**File**: `src/style/portfolio-detail.scss`
**Import in**: `src/style/main.scss`

### 2. Complete JSX Structure

```javascript
render() {
    const {
        banner_image_url,
        category,
        description,
        logo_url,
        name,
        url
    } = this.state.portfolioItem;

    const bannerStyles = {
        backgroundImage: "url(" + banner_image_url + ")",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
        backgroundPosition: "center center"
    };

    const logoStyles = {
        width: "200px"
    };

    return (
        <div className="portfolio-detail-wrapper">
            <div className="banner" style={bannerStyles}>
                <img src={logo_url} style={logoStyles} />
            </div>

            <div className="portfolio-detail-description-wrapper">
                <div className="description">{description}</div>
            </div>

            <div className="bottom-content-wrapper">
                <a href={url} className="site-link" target="_blank">
                    Visit {name}
                </a>
            </div>
        </div>
    );
}
```

### 3. Portfolio Detail Styles

**File**: `src/style/portfolio-detail.scss`

```scss
.portfolio-detail-wrapper {
    width: 100vw;

    .banner {
        height: 300px;
        display: flex;
        justify-content: center;
        align-items: center;
        box-shadow: 0px 15px 20px rgba(0, 0, 0, 0.3);
    }

    .portfolio-detail-description-wrapper {
        text-align: center;
        margin-top: 42px;
        display: flex;
        justify-content: center;

        .description {
            width: 700px;
            font-size: 2em;
            margin-bottom: 50px;
        }
    }

    .bottom-content-wrapper {
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;

        .site-link {
            padding: 15px;
            background-color: $teal;
            border-radius: 3px;
            text-decoration: none;
            color: white;
            transition: 0.5s ease-in-out;
            font-size: 1.2em;

            &:hover {
                background-color: $dark-teal;
            }
        }
    }
}
```

---

## 📧 Concepts

### Inline Styles for Dynamic Content

```javascript
const bannerStyles = {
    backgroundImage: "url(" + banner_image_url + ")"
};
```

### Button-Style Links

```scss
.site-link {
    // Looks like button, functions like link
    background-color: $teal;
    &:hover { background-color: $dark-teal; }
}
```

### target="_blank"

```javascript
<a target="_blank">  // Opens in new tab
```

---

## 📋 Verification

**Testing**:

1. **Banner image** - different for each portfolio item
2. **Logo centred** - 200px width consistent
3. **Description** - large text centred
4. **Visit link** - opens new tab, hover effect

---
