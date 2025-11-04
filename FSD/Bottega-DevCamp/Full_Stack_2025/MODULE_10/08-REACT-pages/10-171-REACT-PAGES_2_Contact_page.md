# 10-171: Building Contact Page Styles - React Portfolio

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-contact-page-styles-react-portfolio)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 8965e7125fa851672e8edaebcde8291d89245db9](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/8965e7125fa851672e8edaebcde8291d89245db9)

---

## 🎯 Objectives

**Design goal**:

- **Layout identical to About page** - reuse established system
- **Different image** on left side for visual variety
- **Contact information** structured on right side
- **Icons + text integration** for professional contact information

**Learning reinforcement**:

- **CSS Grid 50/50 split** - same technique as About page
- **Content-page-wrapper** - reuse universal class
- **Flexbox centring** - apply learnt concepts
- **Inline styles** for dynamic image

---

## 🛠️ Implementation

### 1. Base HTML Structure of Contact Component

**File**: `src/components/pages/contact.js`

```javascript
import React from "react";
import contactPagePicture from "../../../static/assets/images/auth/login.jpg";

export default function() {
    return (
        <div className="content-page-wrapper">
            <div 
                className="left-column"
                style={{
                    background: "url(" + contactPagePicture + ") no-repeat",
                    backgroundSize: "cover",
                    backgroundPosition: "center"
                }}
            />
            <div className="right-column">
                <div className="contact-bullet-points">
                    <div className="bullet-point">
                        <div className="bullet-point-icon">
                            📧
                        </div>

                        <div className="bullet-point-text">
                            your-email@example.com
                        </div>
                    </div>

                    <div className="bullet-point">
                        <div className="bullet-point-icon">
                            📱
                        </div>

                        <div className="bullet-point-text">
                            555-555-5555
                        </div>
                    </div>

                    <div className="bullet-point">
                        <div className="bullet-point-icon">
                            📍
                        </div>

                        <div className="bullet-point-text">
                            Your City, Your Country
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
```

### 2. Styles for Contact Bullet Points

**Update**: `src/style/layouts.scss`

```scss
.content-page-wrapper {
    width: 100vw;
    display: grid;
    grid-template-columns: 1fr 1fr;
    height: calc(100vh - 84px);

    .right-column {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        padding: 100px;
    }

    .contact-bullet-points {
        .bullet-point {
            display: flex;
            align-items: center;
            margin: 20px 0;

            .bullet-point-icon {
                font-size: 2rem;
                margin-right: 20px;
            }

            .bullet-point-text {
                font-size: 1.2rem;
                font-weight: 300;
            }
        }
    }
}
```

---

## 📧 Technical Concepts

### Reuse of content-page-wrapper

**Why the same class works**:

- **CSS Grid 50/50** - split layout already defined
- **Height calculation** - correct height automatically 
- **Flexbox centring** - right-column already centred
- **Responsive behaviour** - inherits responsive behaviour

### Flexbox for Icons + Text Layout

**Bullet point structure**:

```scss
.bullet-point {
    display: flex;        // Horizontal layout
    align-items: center;  // Vertical centring of icon and text
    margin: 20px 0;      // Spacing between bullet points
}
```

**Advantages**:

- **Perfect alignment** - icon and text always aligned
- **Flexible width** - text can grow without breaking layout
- **Easy maintenance** - add/remove items easily

### Font-size Hierarchy

**Typography strategy**:

```scss
.bullet-point-icon {
    font-size: 2rem;      // Prominent icons
}

.bullet-point-text {
    font-size: 1.2rem;    // Readable but not overwhelming
    font-weight: 300;     // Light weight for elegance
}
```

### Background Image Consistency

**Same technique as About page**:

```javascript
style={{
    background: "url(" + contactPagePicture + ") no-repeat",
    backgroundSize: "cover", 
    backgroundPosition: "center"
}}
```

**Benefits of consistency**:

- **User experience** familiar
- **Code reusable**
- **Maintenance** easier

---

## 📋 Verification

### Visual Layout Testing

**Verification steps**:

1. **Navigate to Contact** - `/contact`
2. **Verify split** - image 50% left, contact 50% right
3. **Check image** - should be different from About page
4. **Verify bullet points** - icons aligned with text
5. **Test centring** - content centred in right column
6. **No scroll check** - full page visible without scroll

### Content Structure Verification

**Expected HTML structure**:

```html
<div class="content-page-wrapper">
    <div class="left-column" style="background: url(...)"></div>
    <div class="right-column">
        <div class="contact-bullet-points">
            <div class="bullet-point">
                <div class="bullet-point-icon">📧</div>
                <div class="bullet-point-text">email</div>
            </div>
            <!-- more bullet points... -->
        </div>
    </div>
</div>
```

### Cross-Page Consistency Check

**Compare with About page**:

- **Same layout structure** - grid split 50/50
- **Same height** - calc(100vh - 84px)
- **Same centring** - flexbox right-column
- **Different image** - visual variety
- **Different content** - appropriate for each page


---

## 🎨 **EXTENDED CONTENT**

### Alternative Icon Approaches

**Font Awesome icons**:

```javascript
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEnvelope, faPhone, faMapMarkerAlt } from '@fortawesome/free-solid-svg-icons';

<div className="bullet-point-icon">
    <FontAwesomeIcon icon={faEnvelope} />
</div>
```

**Custom SVG icons**:

```javascript
<div className="bullet-point-icon">
    <svg viewBox="0 0 24 24" width="32" height="32">
        <path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10 10-4.48 10-10S17.52 2 12 2zm-2 15l-5-5 1.41-1.41L10 14.17l7.59-7.59L19 8l-9 9z"/>
    </svg>
</div>
```

### Enhanced Contact Information

**Social media integration**:

```javascript
<div className="bullet-point">
    <div className="bullet-point-icon">💼</div>
    <div className="bullet-point-text">
        <a href="https://linkedin.com/in/your-profile" target="_blank">
            LinkedIn Profile
        </a>
    </div>
</div>
```

### Animation Enhancements

**Staggered fade-in animation**:

```scss
.bullet-point {
    opacity: 0;
    animation: fadeInUp 0.6s ease forwards;

    &:nth-child(1) { animation-delay: 0.1s; }
    &:nth-child(2) { animation-delay: 0.2s; }
    &:nth-child(3) { animation-delay: 0.3s; }
}

@keyframes fadeInUp {
    from {
        opacity: 0;
        transform: translateY(20px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
    }
}
```

### Responsive Enhancements

**Mobile-specific adjustments**:

```scss
@media (max-width: 768px) {
    .content-page-wrapper {
        grid-template-columns: 1fr;
        grid-template-rows: 40vh 1fr;

        .right-column {
            padding: 50px 20px;
        }

        .bullet-point-icon {
            font-size: 1.5rem;
        }
    }
}
```

---
