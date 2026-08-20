# 10-231: Styling Results Component Search Bar

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/styling-results-component-search-bar)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-31.

---

## 🛠️ Implementation

### 1. Update searchBar.js

**File**: `src/components/searchBar.js`

```javascript
render() {
    const { handleSubmit } = this.props;

    return (
        <form className={`search-bar search-bar__${this.props.page}`} onSubmit={handleSubmit(this.handleFormSubmit.bind(this))}>
            <div className="search-bar__wrapper">
                <Field 
                    name="query" 
                    component={this.renderInput}
                />
                <p>Press return to search</p>
            </div>
        </form>
    );
}
```

### 2. Update results.js

**File**: `src/components/results.js`

```javascript
<SearchBar page="results" onSubmit={(query) => this.handleSearchBarSubmit(query)}/>
```

### 3. Update home.js

**File**: `src/components/home.js`

```javascript
<SearchBar page="home" onSubmit={(query) => this.handleSearchBarSubmit(query)}/>
```

### 4. Update searchBar.scss

**File**: `src/style/searchBar.scss`

```scss
.search-bar {
    display: grid;

    .search-bar__wrapper {
        display: grid;
        grid-row-gap: 23px;
        width: 100%;

        input {
            padding-left: 35px;
            color: $color-gray-one;
            box-shadow: 2px 3px 28px 1px rgba(0, 0, 0, 0.1);
            border: 0px solid transparent;
            border-radius: 5px;
            transition: all .2s ease;

            &::placeholder {
                color: $color-gray-two;
                font-family: 'Font Awesome\ 5 Free', 'Lato', Arial, Helvetica, sans-serif;
                font-weight: 600;
            }

            &:focus {
                outline: none;
                box-shadow: 2px 3px 20px 1px rgba(0, 0, 0, 0.3);
            }
        }

        p {
            text-align: right;
            font-size: 14px;
            color: $color-gray-two;
        }
    }
}

.search-bar__home {
    align-content: center;
    justify-items: center;

    input {
        height: 118px;
        font-size: 40px;
    }
}

.search-bar__results {
    align-content: start;
    justify-items: center;

    input {
        font-size: 22px;
        height: 36px;
    }
}
```

---
