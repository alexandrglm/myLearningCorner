# 10-226: Styling Search Bar Component

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/styling-search-bar-component)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-X.

---

## 🎯 Objectives

**Style search bar component completely**:
- **SCSS styles** - dedicated file for search bar
- **Input styling** - padding, colours, shadows, borders
- **Placeholder styles** - differentiated color
- **Focus states** - hover and focus effects
- **Layout grid** - wrapper for alignment
- **Responsive text** - "Press return to search"

---

## 🛠️ Implementation

### 1. Logo Styling (Optional)

**File**: `src/style/main.scss`

```scss
// Alternative method to center logo
.logo-main {
    display: grid;
    justify-content: center;
    align-items: center;
}

// But we keep justify-items: center in .home (less code)
```

### 2. Create SearchBar SCSS

**File**: `src/style/searchBar.scss`

```scss
.search-bar {
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
            height: 118px;
            font-size: 40px;
            transition: all .2s ease;

            &::placeholder {
                color: $color-gray-two;
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
```

### 3. Colour Variables

**File**: `src/style/main.scss`

```scss
// Colour variables
$color-gray-one: #666666;
$color-gray-two: #B3B3B3;

// Import searchBar styles
@import './searchBar';
```

### 4. Update SearchBar Component

**File**: `src/components/searchBar.js`

```javascript
import React, { Component } from 'react';
import { Field, reduxForm } from 'redux-form';

class SearchBar extends Component {
    
    renderInput = ({ input }) => {
        return (
            <input 
                {...input}
                type="text"
                placeholder="Search Daily Smarty"
            />
        )
    }

    handleFormSubmit = ({ query }) => {
        // Fake API - in ProjectFive-X the APIs are faked
        console.log('Search query:', query);
        this.props.onSubmit(query);
    }

    render() {
        const { handleSubmit } = this.props;

        return (
            <form className="search-bar" onSubmit={handleSubmit(this.handleFormSubmit.bind(this))}>
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
}

export default reduxForm({
    form: 'searchBar'
})(SearchBar);
```

---

## 📧 Technical Details

### Box Shadow Effects

```scss
// Normal state - subtle
box-shadow: 2px 3px 28px 1px rgba(0, 0, 0, 0.1);

// Focus state - more prominent  
box-shadow: 2px 3px 20px 1px rgba(0, 0, 0, 0.3);
```

**Parameters**:
- **2px 3px** - horizontal and vertical offset
- **28px/20px** - blur radius 
- **1px** - spread radius
- **rgba(0,0,0,0.1/0.3)** - black color with alpha

### Transition Smooth

```scss
transition: all .2s ease;
```

**Effect**:
- **All properties** animated
- **0.2 seconds** duration
- **ease** - natural acceleration

### Grid Layout Structure

```scss
.search-bar__wrapper {
    display: grid;
    grid-row-gap: 23px;  // Space between input and text
    width: 100%;
}
```

### Placeholder vs Input Text

```scss
&::placeholder {
    color: $color-gray-two;  // #B3B3B3 - lighter
}

input {
    color: $color-gray-one;  // #666666 - darker
}
```

---

## 🎨 Visual Verification

### Input Styling

1. **Padding left 35px** - space for future icon
2. **Height 118px** - large input
3. **Font size 40px** - prominent text
4. **Border radius 5px** - rounded corners
5. **No border** - transparent border
6. **Box shadow** - subtle elevation effect

### Focus Effects

1. **Outline removed** - no browser default border
2. **Box shadow enhanced** - darker shadow
3. **Smooth transition** - 0.2s animation

### Text Alignment

1. **"Press return to search"** - aligned right
2. **Font size 14px** - small text
3. **Colour gray-two** - consistent with placeholder

---

## 🚀 Testing

**Verify**:

1. **Large input** - 118px height visible
2. **Placeholder text** - light grey color
3. **Focus effect** - darker shadow on click
4. **Smooth transition** - smooth animation
5. **Right aligned text** - "Press return to search" on right
6. **Spacing** - 23px gap between input and text
7. **Responsive** - works on results page too


---

## 📝 Implementation Notes

### SCSS Nesting

**Clear hierarchy**:

```scss
.search-bar {
    .search-bar__wrapper {    // Wrapper container
        input { }             // Specific input
        p { }                 // Specific text
    }
}
```

### Reusable Variables

**Consistent colours**:

- **$color-gray-one** - used in input text
- **$color-gray-two** - used in placeholder and helper text

### Font Awesome Preparation

**Guide note**:
- **Font Awesome styles** will be added later
- **35px padding-left** prepares space for search icon
- **Complete styling** of application will come after

---
