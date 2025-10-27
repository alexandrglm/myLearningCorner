# 08-058 - Build Style Structure for Homepage Portfolio Items

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-style-structure-homepage-portfolio-items

[SOURCE](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/16d1b55f1dc407aa3583b30169ede894dd66751c)

---

## 🎯 STYLES ARCHITECTURE

### Guide Objective

**Set up base architecture**:

- Decide layout system (CSS Grid vs Flexbox)
- Establish class structure
- Prepare containers for future styling
- **NO major visual changes** (giant images will hide them)

### Layout Decision

**CSS Grid chosen for**:

- Portfolio items in three columns
- Automatic responsive layout
- Clear and maintainable structure

---

## 🛠️ PRACTICAL STEPS

### 1. Create Universal Base Container

**File**: `src/style/base.scss`

**Add universal container class**:

```scss
.container {
    display: grid;
    grid-template-columns: 1fr;
}
```

**Purpose**: Reusable abstract class for CSS Grid throughout application.

### 2. Apply Container in App Component

**File**: `src/components/app.js`

**Change className**:

```javascript
export default class App extends Component {
    render() {
        return (
            <div className="container"> {/* Change: app → container */}
                <Router>
                    <div>
                        <NavigationContainer />
                        <Switch>
                            <Route exact path="/" component={Home} />
                            <Route path="/about-me" component={About} />
                            <Route path="/contact" component={Contact} />
                            <Route path="/blog" component={Blog} />
                        </Switch>
                    </div>
                </Router>
            </div>
        );
    }
}
```

### 3. Clean Up Home Component

**File**: `src/components/pages/home.js`

**Remove unnecessary text**:

```javascript
import React from 'react';
import PortfolioContainer from '../portfolio-container';

const Home = () => {
    return (
        <div>
            {/* Removed: <h2>Homepage</h2> */}
            <PortfolioContainer />
        </div>
    );
};

export default Home;
```

### 4. Add Wrapper in PortfolioContainer

**File**: `src/components/portfolio-container.js`

**Wrap portfolio items**:

```javascript
render() {
    if (this.state.isLoading) {
        return <div>Loading...</div>;
    }

    return (
        <div>
            <h2>{this.state.pageTitle}</h2>

            <button onClick={() => this.handleFilter('eCommerce')}>
                eCommerce
            </button>
            <button onClick={() => this.handleFilter('Scheduling')}>
                Scheduling  
            </button>
            <button onClick={() => this.handleFilter('Enterprise')}>
                Enterprise
            </button>

            <div className="portfolio-items-wrapper">
                {this.portfolioItems()}
            </div>
        </div>
    );
}
```

### 5. Add Individual Wrapper in PortfolioItem

**File**: `src/components/portfolio-item.js`

**Wrap content**:

```javascript
import React from 'react';

const PortfolioItem = (props) => {
    return (
        <div className="portfolio-item-wrapper">
            <h3>{props.title}</h3>
            <h4>{props.url}</h4>
            <img src={props.thumb_image_url} />
        </div>
    );
}

export default PortfolioItem;
```

### 6. Create and Import Portfolio SCSS File

**Create**: `src/style/portfolio.scss`

**File**: `src/style/main.scss`

**Add import**:

```scss
@import "./base.scss";
@import "./navigation.scss";
@import "./portfolio.scss";
```

### 7. Implement CSS Grid for Three Columns

**File**: `src/style/portfolio.scss`

```scss
.portfolio-items-wrapper {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
}

.portfolio-item-wrapper {
    position: relative; // For future effects
}
```

---

## 📋 STRUCTURE VERIFICATION

### Testing the Grid Layout

**Without images (to see structure)**:

1. **Temporarily comment** `<img>` in portfolio-item.js
2. **Refresh browser**
3. **Verify three columns** - titles aligned horizontally
4. **Uncomment images** - return to original state

### Expected Result

**With images**:

- Giant images that temporarily "break" the layout
- **But for a moment** the three-column grid is visible before they load

**Without images (test)**:

- Three clear columns with titles and URLs
- Working responsive grid
- Confirmed structural base

---

## 🔧 TECHNICAL CONCEPTS

### CSS Grid vs Flexbox

**CSS Grid chosen because**:

- **Bidimensional layout** - rows and columns
- **Automatic wrapping** - items accommodate automatically
- **Equal column widths** - `1fr 1fr 1fr`

**Flexbox would be for**:

- Unidimensional layout (only horizontal or vertical)
- Navigation bars, button groups

### Position Relative

**In `.portfolio-item-wrapper`**:

- **Preparation** for future effects
- **Containment** for absolute positioned elements
- **Hover effects** and overlays will need this

### Grid Template Columns

**`1fr 1fr 1fr` means**:

- **Three columns** of equal width
- **fr** = fraction unit (fraction of available space)
- **Responsive** automatically

---

## 🎨 EXTENDED CONTENT

### Alternative Grid Patterns

**Different layouts**:

```scss
// Two columns
grid-template-columns: 1fr 1fr;

// Fixed size columns
grid-template-columns: 300px 300px 300px;

// Mix of fixed and flexible
grid-template-columns: 200px 1fr 200px;

// Automatic responsive
grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
```

### Universal Container Benefits

**Reusability**:

- Any component can use `.container`
- Consistency throughout application
- Easy maintenance of grid system

---

## 🔍 TESTING AND DEBUGGING

### Verify with DevTools

**Inspection process**:

1. **Right-click** on portfolio area → Inspect

2. **Verify structure**:
   
   ```html
   <div class="portfolio-items-wrapper">
     <div class="portfolio-item-wrapper">...</div>
     <div class="portfolio-item-wrapper">...</div>
     <div class="portfolio-item-wrapper">...</div>
   </div>
   ```

3. **Check CSS Grid** - display: grid applied

4. **Grid columns** - three columns visible in DevTools

### Temporary Image Removal Test

**To confirm structure**:

```javascript
// Temporary in portfolio-item.js
const PortfolioItem = (props) => {
    return (
        <div className="portfolio-item-wrapper">
            <h3>{props.title}</h3>
            <h4>{props.url}</h4>
            {/* <img src={props.thumb_image_url} /> */}
        </div>
    );
}
```

---
