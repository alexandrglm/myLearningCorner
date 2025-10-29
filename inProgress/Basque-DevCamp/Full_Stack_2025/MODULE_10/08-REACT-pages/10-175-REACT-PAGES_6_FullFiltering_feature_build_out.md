# 10-175: Full Filtering Feature Build Out

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/full-filtering-feature-build-out-react)**
https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/310f50b656053c9a0cf6dc5b0be530e3007fbb1e
---

## 🎯 Objectives

**Fix filtering bug and improve UX**:
- **"All" button** - reset filters to show all
- **Dynamic API calls** - filter from API instead of state
- **Better layout** - wrapper for filter buttons

---

## 🛠️ Implementation

### 1. Restructure JSX with Wrappers

```javascript
render() {
    return (
        <div className="homepage-wrapper">
            <div className="filter-links">
                <button className="btn" onClick={() => this.handleFilter('eCommerce')}>
                    eCommerce
                </button>
                <button className="btn" onClick={() => this.handleFilter('Scheduling')}>
                    Scheduling
                </button>
                <button className="btn" onClick={() => this.handleFilter('Enterprise')}>
                    Enterprise
                </button>
                <button className="btn" onClick={() => this.handleFilter('CLEAR_FILTERS')}>
                    All
                </button>
            </div>

            <div className="portfolio-items-wrapper">
                {this.portfolioItems()}
            </div>
        </div>
    );
}
```

### 2. Create home.scss

**File**: `src/style/home.scss`
**Import in**: `src/style/main.scss`

```scss
.homepage-wrapper {
    display: grid;
    grid-template-columns: 1fr;

    .filter-links {
        display: flex;
        justify-content: center;

        button {
            width: 100%;
        }
    }
}
```

### 3. Update handleFilter

```javascript
handleFilter(filter) {
    if (filter === 'CLEAR_FILTERS') {
        this.getPortfolioItems();
    } else {
        this.getPortfolioItems(filter);
    }
}
```

### 4. Make getPortfolioItems Dynamic

```javascript
getPortfolioItems(filter = null) {
    axios.get('https://jordan.devcamp.space/portfolio/portfolio_items')
        .then(response => {
            if (filter) {
                this.setState({
                    data: response.data.portfolio_items.filter(item => {
                        return item.category === filter;
                    })
                });
            } else {
                this.setState({
                    data: response.data.portfolio_items
                });
            }
        })
        .catch(error => {
            console.log(error);
        });
}
```

---

## 📧 Concepts

### Optional Parameters
```javascript
function(filter = null) {
    // filter is optional
}
```

### API-Level Filtering
- **Before**: filter in state (cumulative bug)  
- **Now**: fresh API call with filter

### Conditional setState
```javascript
if (filter) {
    // setState with filtered data
} else {
    // setState with all data
}
```

---

## 📋 Verification

**Testing**:
1. **Click filters** - each one shows its category
2. **Click "All"** - shows all items
3. **No cumulative bug** - eCommerce → Scheduling works
4. **Improved layout** - buttons centred

---
