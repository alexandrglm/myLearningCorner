# 08-050 - How to Render Images in React from API

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-render-images-react-api

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/b525e7b9175f842b7a8d18ecde026a3cdd24742f)

---

## 🎯 COMPLETE API INTEGRATION

### Finalise APIs Section

**Final objectives**:

https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/b525e7b9175f842b7a8d18ecde026a3cdd24742f

- **Render images** from API
- **Logo display** from URL
- **Complete data flow** API → React
- **Prepare for styling** in next section

---

## 🛠️ IMAGES IMPLEMENTATION

### Add Image Tags

**File**: `src/components/portfolio-item.js`

```javascript
import React from "react";
import { Link } from "react-router-dom";

export default function(props) {
    const { id, description, thumb_image_url, logo_url } = props.item;

    return (
        <div>
            <img src={thumb_image_url} />
            <img src={logo_url} />

            <h3>
                <Link to={`/portfolio/${id}`}>
                    {props.item.name}
                </Link>
            </h3>
            <div>{description}</div>
        </div>
    );
}
```

### ⚠️ Important: Self-Closing Tags

**JSX requires closing**:

```javascript
<img src={thumb_image_url} />  // ✅ Correct
<img src={thumb_image_url}>    // ❌ Error in JSX
```

---

## 📋 VERIFICATION

### Images Testing

**Expected results**:

- **Thumbnail images** appear (large, without styling)
- **Logo images** appear (possibly invisible if they are white)
- **No errors** in console
- **URLs work** - can be inspected in DevTools

### White Logos Debugging

**If you don't see logos**:

1. **Right-click → Inspect** in logo area
2. **Verify** that `<img>` tag exists
3. **Check src URL** - must have valid URL
4. **White logo** on white background = invisible but present

---
