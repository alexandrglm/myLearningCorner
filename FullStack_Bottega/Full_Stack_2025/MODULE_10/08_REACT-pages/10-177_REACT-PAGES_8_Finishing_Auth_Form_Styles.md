# 10-177: Finalising Auth Form Styles

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/finalizing-auth-form-styles)**
https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/f4b7821812718ce5cc4bb76f9c008649e6ee01bf
---

## 🎯 Objectives

**Professional auth form styling**:
- **Icons + inputs** - envelope and lock icons
- **Form groups** - flexbox layout for icon + input
- **Mixins reuse** - input-element and base-grid

---

## 🛠️ Implementation

### 1. JSX Structure with Form Groups

```javascript
render() {
    return (
        <div className="auth-page-wrapper">
            <div className="left-column" style={backgroundStyle} />
            
            <div className="right-column">
                <form onSubmit={this.handleSubmit} className="auth-form-wrapper">
                    <div className="form-group">
                        <FontAwesomeIcon icon="envelope" />
                        <input
                            type="email"
                            name="email"
                            placeholder="Your email"
                            value={this.state.email}
                            onChange={this.handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <FontAwesomeIcon icon="lock" />
                        <input
                            type="password"
                            name="password"
                            placeholder="Your password"
                            value={this.state.password}
                            onChange={this.handleChange}
                        />
                    </div>

                    <button className="btn" type="submit">
                        Login
                    </button>
                </form>
            </div>
        </div>
    );
}
```

### 2. Add Lock Icon

**File**: `src/components/helpers/icons.js`

```javascript
import { faLock } from "@fortawesome/free-solid-svg-icons";

const Icons = () => {
    return library.add(
        faTrash,
        faSignOutAlt,
        faEdit,
        faSpinner,
        faPlusCircle,
        faPhone,
        faEnvelope,
        faMapMarkedAlt,
        faLock  // Add lock icon
    );
};
```

### 3. Auth Form Styles

**File**: `src/style/auth.scss`

```scss
.auth-page-wrapper {
    .right-column {
        display: flex;
        justify-content: center;
        align-items: center;
        background-color: $offwhite;

        .auth-form-wrapper {
            @include input-element();
            @include base-grid();
            grid-gap: 21px;
            padding: 42px;

            .form-group {
                display: flex;

                svg {
                    font-size: 2em;
                    color: $teal;
                    margin-right: 15px;
                }
            }
        }
    }
}
```

---

## 📧 Concepts

### Form Group Pattern
```scss
.form-group {
    display: flex;  // Icon + input horizontal
}
```

### SVG Icon Styling
```scss
svg {
    font-size: 2em;     // Large icons
    color: $teal;       // Brand colour
    margin-right: 15px; // Spacing from input
}
```

### Mixin Reuse
```scss
@include input-element();  // Styled inputs
@include base-grid();      // Grid layout
```

---

## 📋 Verification

**Testing**:
1. **Icons visible** - envelope and lock
2. **Flexbox alignment** - icons next to inputs
3. **Button styling** - teal button stretches full width
4. **Form functionality** - login still works

---
