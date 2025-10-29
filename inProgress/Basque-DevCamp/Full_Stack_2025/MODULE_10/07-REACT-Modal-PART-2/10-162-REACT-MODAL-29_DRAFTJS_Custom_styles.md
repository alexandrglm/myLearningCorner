# 10-162: Positioning Draft.js Icons

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/positioning-draft-js-icons)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 38fd1b7db26d79ca6470c4f21a05332d61ec94fa](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/38fd1b7db26d79ca6470c4f21a05332d61ec94fa)

---

## 🎯 Objectives

**Resolve dropdown icons overflow in modal using CSS overrides**:

- **Modal overflow problem** - some dropdown icons cause horizontal scroll
- **Browser inspection workflow** - identify specific class names
- **Negative positioning strategy** - use left negative values for repositioning
- **CSS override pattern** - modify third-party library styles without touching original files
- **Professional UX** - all dropdowns should be visible within the modal
- **Final polish** - modal 100% fully functional

**Specific icons with problems**:

- **Image uploader dropdown** - causes horizontal overflow
- **Emoji dropdown** - extends beyond modal boundaries  
- **Embedded link dropdown** - also needs repositioning

---

## 🛠️ Implementation

### 1. Identify Problematic Dropdowns

**Test current modal behaviour**:

1. **Navigate to blog modal**
2. **Click image icon** → dropdown extends to right, causes horizontal scroll
3. **Click emoji icon** → same overflow problem
4. **Click embed link icon** → extends beyond modal boundary

**User experience problems**:

- **Horizontal scrolling** required to see full dropdown
- **Hidden options** - users can't see all available choices
- **Unprofessional appearance** - modal content overflows container

### 2. Browser Inspection Workflow

**For image dropdown**:

1. **Right-click on image dropdown**
2. **Select "Inspect"** 
3. **Identify class**: `rdw-image-modal`
4. **Test positioning** in element.style: `left: -215px`
5. **Fine-tune** using arrow keys for pixel-perfect adjustment

**For emoji dropdown**:

1. **Right-click on emoji dropdown**
2. **Identify class**: `rdw-emoji-modal` 
3. **Test positioning**: `left: -169px`

**For embedded link dropdown**:

1. **Right-click on embed dropdown**
2. **Identify class**: `rdw-embedded-modal`
3. **Test positioning**: `left: -124px`

### 3. Implement CSS Overrides

**File**: `src/style/rich-text-editor.scss`

**Add positioning overrides after existing DraftEditor-root rule**:

```scss
.DraftEditor-root {
  border: 1px solid #f1f1f1;
  padding: 20px;
  border-radius: 3px;
}

.rdw-image-modal {
  left: -215px;
}

.rdw-emoji-modal {
  left: -169px;
}

.rdw-embedded-modal {
  left: -124px;
}
```

### 4. Test All Dropdown Positioning

**Verification steps**:

1. **Refresh browser** - reload latest styles
2. **Open blog modal**
3. **Test image dropdown** - should be fully visible within modal
4. **Test emoji dropdown** - should not cause overflow
5. **Test embed link dropdown** - should be properly positioned
6. **Verify no regression** - other toolbar icons should still work normally

---

## 📖 Concepts

### CSS Override Strategy for Third-Party Libraries

**Why override instead of modifying source**:

```scss
// ✗ WRONG - modifying react-draft-wysiwyg.scss directly
// Problems:
// - Changes lost on library updates
// - Affects all projects using library
// - Hard to track custom modifications

// ✓ CORRECT - CSS cascade override pattern
.rdw-image-modal {
  left: -215px;  // Overrides library default
}
```

**CSS cascade advantages**:

- **Selective overrides** - only change what you need
- **Update-safe** - survives library version updates  
- **Project-specific** - doesn't affect other applications
- **Maintainable** - clear separation between library and custom styles

### Negative CSS Values - When They're Appropriate

**Common negative value anti-pattern**:

```scss
// ✗ WRONG - usually indicates poor CSS architecture
.my-element {
  margin-left: -50px;  // Often means you're forcing a layout
}
```

**Appropriate negative value use cases**:

```scss
// ✓ CORRECT - third-party component positioning overrides
.third-party-modal {
  left: -215px;  // Repositioning absolute-positioned element
}

// ✓ CORRECT - intentional overlapping effects
.badge {
  top: -10px;    // Badge overlaps parent element
  right: -10px;
}
```

**Why negative values work here**:

- **Absolute positioning context** - dropdowns use absolute positioning
- **Third-party constraint** - we don't control original component structure
- **Small, targeted override** - specific positioning adjustment only
- **Alternative approaches impractical** - restructuring entire component unrealistic

### Modal Constraint Considerations

**Why regular forms don't have this problem**:

```html
<!-- Regular form - has full page width -->
<form class="full-width-form">
  <div class="rich-text-editor">
    <!-- Dropdown can extend right without problems -->
  </div>
</form>

<!-- Modal form - constrained width -->
<div class="ReactModal__Content" style="width: 80%;">
  <form class="modal-form">
    <div class="rich-text-editor">
      <!-- Dropdown extends beyond modal boundary ✗ -->
    </div>
  </form>
</div>
```

**Modal constraints**:

- **Fixed width** - modal has defined boundaries
- **Overflow hidden** - content extending beyond modal gets cut off
- **Centred positioning** - modal centred on screen
- **Z-index layering** - dropdown must remain within modal layer

### Browser DevTools Workflow

**Professional development process demonstrated**:

1. **Visual identification** - spot UI problems immediately
2. **Element inspection** - identify specific DOM elements and classes
3. **Live testing** - experiment with styles in browser
4. **Iterative refinement** - adjust values until perfect
5. **Code implementation** - transfer working solution to codebase
6. **Verification testing** - confirm fix works as expected

**Why this workflow is effective**:

- **Immediate feedback** - see results instantly
- **No build cycles** - faster than edit-save-refresh cycle
- **Experimentation friendly** - try multiple approaches quickly
- **Precise control** - adjust one pixel at a time

### Class Name Strategy for Overrides

**How to identify stable class names**:

```html
<!-- Draft.js generates consistent class names -->
<div class="rdw-image-modal">        <!-- ✓ Library-provided, stable -->
<div class="rdw-emoji-modal">        <!-- ✓ Library-provided, stable -->  
<div class="rdw-embedded-modal">     <!-- ✓ Library-provided, stable -->

<!-- Avoid targeting these -->
<div class="css-1x2y3z">             <!-- ✗ CSS-in-JS generated, unstable -->
<div style="left: 100px;">           <!-- ✗ Inline styles, hard to override -->
```

**Characteristics of good override targets**:

- **Library-provided** - part of official component API
- **Semantic naming** - describes purpose, not appearance
- **Version stable** - unlikely to change between minor updates
- **Specific enough** - targets exact element without side effects

---

## ✅ Verification

### 1. Visual Positioning Check

**Before fix**:

- Image dropdown extends right, requires horizontal scrolling
- Emoji dropdown partially hidden outside modal
- Embed link dropdown cut off at modal edge

**After fix**:

- **All dropdowns fully visible** within modal boundaries
- **No horizontal scrolling** required
- **Professional appearance** - clean, contained interface

### 2. Functionality Preservation

**Verify no breaking changes**:

- **Dropdown content** still fully accessible
- **Click interactions** work correctly
- **Keyboard navigation** unaffected
- **Other toolbar icons** continue working normally
- **Rich text editing** functionality intact

### 3. Responsive Behaviour

**Test different modal sizes**:

- **Standard modal** (80% width) - dropdowns positioned correctly
- **Smaller screens** - dropdowns adapt appropriately
- **Larger screens** - positioning remains consistent

### 4. Cross-Browser Compatibility

**Test in different browsers**:

- **Chrome** - primary development browser
- **Firefox** - verify CSS compatibility
- **Safari** - test WebKit rendering
- **Edge** - confirm Microsoft browser support

### 5. Library Update Resilience

**Override sustainability check**:

- **Class names exist** - confirm target classes present
- **Positioning works** - negative values take effect
- **No console errors** - CSS applies without warnings
- **Visual verification** - final result matches expectations

---
