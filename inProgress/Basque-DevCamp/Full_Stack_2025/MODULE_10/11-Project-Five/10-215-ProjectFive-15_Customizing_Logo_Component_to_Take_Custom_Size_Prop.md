# 10-215: Customising Logo Component to Take Custom Size Prop

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/customizing-logo-component-take-custom-size-prop)**
---

## 🎯 Objectives

**Make Logo component flexible with custom sizing**:
- **Props-based sizing** - accept size prop
- **Default value** - 105px when no prop provided
- **Inline styles** - dynamic style application
- **Ternary operator** - conditional size logic

---

## 🛠️ Implementation

### 1. Update Logo Component

**File**: `src/components/logo.js`

```javascript
import React, { Component } from 'react';

class Logo extends Component {
    render() {
        const size = {
            height: this.props.size ? this.props.size : 105,
            width: this.props.size ? this.props.size : 105
        }

        return (
            <div className="logo-main">
                <img 
                    style={size}
                    alt="daily smarty ui image logo big" 
                    src="/assets/ds_circle_logo.png"
                />
            </div>
        );
    }
}

export default Logo;
```

### 2. Remove Static CSS

**File**: `src/style/main.scss`

```scss
// Remove .logo-main img styles
.post-topic {
    margin: 0 4px;
}
```

### 3. Use Different Sizes in Components

**Home component** (default size):
```javascript
<Logo />  // Uses 105px default
```

**Results component** (custom size):
```javascript
<Logo size={55} />  // Uses 55px
```

### 4. Update Results Component

**File**: `src/components/results.js`

```javascript
import React, { Component } from 'react';
import Logo from './logo';
import SearchBar from './searchBar';

class Results extends Component {
    render() {
        return (
            <div>
                <Logo size={55} />
                <SearchBar />
            </div>
        );
    }
}

export default Results;
```

---

## 📧 Technical Concepts

### Inline Styles with Constants

**Why use constant**:
- **Reusable object** - DRY principle
- **Cleaner JSX** - less cluttered render method
- **Single curly braces** - because constant already contains object

### Ternary Operator Pattern

```javascript
this.props.size ? this.props.size : 105
```

**Logic flow**:
1. **Check if prop exists** - this.props.size
2. **If true** - use prop value
3. **If false/undefined** - use default (105)

### Square Image Constraint

**Why same width/height**:
- **Design requirement** - logo should remain square
- **Aspect ratio** - prevents image distortion
- **Consistency** - uniform appearance across app

---

## 📋 Usage Patterns

**Default size** (Home page):
```javascript
<Logo />  // 105x105 pixels
```

**Custom size** (Results page):
```javascript
<Logo size={55} />  // 55x55 pixels
```

**Future usage**:
```javascript
<Logo size={80} />   // 80x80 pixels
<Logo size={200} />  // 200x200 pixels
```

---
