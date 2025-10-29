# 09-109: Building Edit Click Handler React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-edit-click-handler-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 3f056681ce9a25813528b5389f4e34f57e2596c5](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/3f056681ce9a25813528b5389f4e34f57e2596c5)

---

## 🎯 Objectives

**Implement complete edit functionality for CRUD operations**:

- **portfolioToEdit state** - add new state to manage portfolio item being edited
- **handleEditClick method** - function to update state when user clicks edit
- **Props passing** - pass edit handler function to sidebar component
- **Edit icon implementation** - add faEdit icon with proper naming conventions
- **CSS Grid for actions** - professional layout for edit and delete buttons side by side

**Technical result**:

- Edit click functionality completely working
- State management for tracking item being edited
- Professional UI with both edit and delete actions
- Foundation prepared for form population in next guide

---

## 🛠️ Implementation

### 1. Add portfolioToEdit State in Portfolio Manager

**File**: `src/components/pages/portfolio-manager.js`

**Update constructor with new state**:

```javascript
export default class PortfolioManager extends Component {
  constructor() {
    super();

    this.state = {
      portfolioItems: [],
      portfolioToEdit: {}
    };

    this.handleSuccessfulFormSubmission = this.handleSuccessfulFormSubmission.bind(this);
    this.handleFormSubmissionError = this.handleFormSubmissionError.bind(this);
    this.handleDeleteClick = this.handleDeleteClick.bind(this);
    this.handleEditClick = this.handleEditClick.bind(this);
  }

  // Rest of component...
}
```

### 2. Create handleEditClick Method

**Add method after handleDeleteClick**:

```javascript
handleEditClick(portfolioItem) {
  this.setState({
    portfolioToEdit: portfolioItem
  });
}
```

### 3. Pass handleEditClick Function to Sidebar

**Update render method**:

```javascript
  render() {
    return (
      <div className="portfolio-manager-wrapper">
        <div className="left-column">
          <PortfolioForm
            handleSuccessfulFormSubmission={this.handleSuccessfulFormSubmission}
            handleFormSubmissionError={this.handleFormSubmissionError}
          />
        </div>

        <div className="right-column">
          <PortfolioSidebarList
            handleDeleteClick={this.handleDeleteClick}
            data={this.state.portfolioItems}
            handleEditClick={this.handleEditClick}
          />
        </div>
      </div>
    );
  }
}
```

### 4. Add faEdit Icon to FontAwesome Library

**File**: `src/components/app.js`

**Update imports and library**:

```javascript
import { library } from "@fortawesome/fontawesome-svg-core";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash, faSignOutAlt, faEdit } from "@fortawesome/free-solid-svg-icons";

library.add(faTrash, faSignOutAlt, faEdit);
```

### 5. Implement Edit Icon in Sidebar Component

**File**: `src/components/portfolio/portfolio-sidebar-list.js`

**Add actions wrapper with edit and delete icons**:

```javascript
const PortfolioSidebarList = props => {

  const portfolioList = props.data.map(portfolioItem => {
    
    return (
      <div key={portfolioItem.id} className="portfolio-item-thumb">
        <div className="portfolio-thumb-img">
          <img src={portfolioItem.thumb_image_url} />
        </div>

        <div className="text-content">
          <div className="title">{portfolioItem.name}</div>

          <div className="actions">
            <a
              className="action-icon"
              onClick={() => props.handleEditClick(portfolioItem)}
            >
              <FontAwesomeIcon icon="edit" />
            </a>

            <a
              className="action-icon"
              onClick={() => props.handleDeleteClick(portfolioItem)}
            >
              <FontAwesomeIcon icon="trash" />
            </a>
          </div>
        </div>
      </div>
    );
  });

  return <div className="portfolio-sidebar-list-wrapper">{portfolioList}</div>;
};
```

### 6. Update CSS for Actions Layout

**File**: `src/style/portfolio-sidebar.scss`

**Implement CSS Grid for actions**:

```scss
.portfolio-sidebar-list-wrapper {
  .portfolio-item-thumb {
    padding: 21px;

    .portfolio-thumb-img img {
      width: 100%;
    }

    .text-content {
      display: flex;
      justify-content: space-between;
      align-items: center;

      .title {
        color: $offwhite;
        font-size: 1.5em;
      }

      .actions {
        display: grid;
        grid-template-columns: 1fr 1fr;
        grid-gap: 15px;

        .action-icon {
          cursor: pointer;
          color: $offwhite;
          font-size: 1.5em;
          transition: 0.5s ease-in-out;

          &:hover {
            color: $warning;
          }
        }
      }
    }
  }
}
```

---

## 📚 Concepts

### State Management for Edit Functionality

**portfolioToEdit state pattern**:

```javascript
// Initial state - empty object
portfolioToEdit: {}

// After edit click - complete object
portfolioToEdit: {
  id: 123,
  name: "Project Name",
  description: "...",
  // ... all portfolio item properties
}
```

**Why this approach**:

- **Single source of truth** - one place to track item being edited
- **Empty object default** - indicates no edit in progress
- **Complete object storage** - all information available for form population
- **Easy state checking** - can verify edit mode with `Object.keys(portfolioToEdit).length > 0`

### Parent-Child Communication Pattern

**Complete data flow**:

```
PortfolioManager (parent)
    ↓ props.handleEditClick
PortfolioSidebarList (child)
    ↓ onClick event
handleEditClick(portfolioItem)
    ↓ setState
portfolioToEdit state updated
```

**Advantages of this pattern**:

- **Centralised state management** - parent component controls all state
- **Reusable child components** - sidebar doesn't manage own state
- **Predictable data flow** - unidirectional data movement
- **Easy debugging** - state changes visible in parent component

### CSS Grid for Action Buttons

**Grid layout strategy**:

```scss
.actions {
  display: grid;
  grid-template-columns: 1fr 1fr;  // Two equal columns
  grid-gap: 15px;                  // Consistent spacing
}
```

**Why Grid over Flexbox**:

- **Equal column widths** - 1fr 1fr guarantees equal buttons
- **Consistent spacing** - grid-gap doesn't add spacing at edges
- **Predictable layout** - grid is more controllable for button layouts
- **Future extensibility** - easy to add more actions without layout issues

### FontAwesome Icon Management

**Global library approach benefits**:

```javascript
// Single import location
import { faTrash, faSignOutAlt, faEdit } from "@fortawesome/free-solid-svg-icons";

// Single library registration
library.add(faTrash, faSignOutAlt, faEdit);

// Usage anywhere in app
<FontAwesomeIcon icon="edit" />
```

**Centralised icon management**:

- **Bundle optimisation** - tree shaking eliminates unused icons
- **Consistent availability** - once added, available app-wide
- **Easy maintenance** - add/remove icons in one place
- **Type safety** - compile-time verification of icon names

### Action Icon Styling Strategy

**Shared className approach**:

```scss
.action-icon {
  cursor: pointer;
  color: $offwhite;
  font-size: 1.5em;
  transition: 0.5s ease-in-out;

  &:hover {
    color: $warning;
  }
}
```

**Benefits of shared styling**:

- **Consistency** - all action icons look identical
- **Maintainability** - one place for style changes
- **DRY principle** - no duplicated CSS rules
- **Visual harmony** - consistent hover effects and spacing

### Edit vs Delete UX Patterns

**Colour psychology applied**:

- **Default state** - neutral white colour for both actions
- **Hover state** - warning red for both (indicates system change)
- **Future enhancement** - could use different hover colours:
  - Edit: blue/teal (informational)
  - Delete: red (destructive)

---

## ✋ Verification

### State Management Testing

**React DevTools verification**:

1. **Open React DevTools**
2. **Navigate to PortfolioManager component**
3. **Verify initial state**:
   - `portfolioToEdit: {}`
4. **Click edit icon** on any portfolio item
5. **Verify state update**:
   - `portfolioToEdit: { id: 123, name: "...", ... }`

### Visual Layout Testing

**Expected UI behaviour**:

- **Two icons side by side** - edit (pencil) and delete (trash)
- **Equal spacing** - 15px gap between icons
- **Consistent sizing** - both icons same size (1.5em)
- **Hover effects** - smooth colour transition to red

### Functional Testing

**Edit click functionality**:

1. **Click edit icon** on different portfolio items
2. **Monitor state changes** in React DevTools
3. **Verify different objects** stored in portfolioToEdit
4. **Confirm complete data** - all portfolio item properties present

### CSS Grid Layout Verification

**Developer tools inspection**:

- **Grid container** - .actions has `display: grid`
- **Column distribution** - `grid-template-columns: 1fr 1fr`
- **Gap spacing** - `grid-gap: 15px` applied
- **Content alignment** - icons centred in grid cells

### Icon Availability Testing

**FontAwesome verification**:

1. **Verify edit icon displays** - pencil icon visible
2. **Check console** - no "could not find icon" errors
3. **Test hover states** - both icons respond to hover
4. **Confirm click handlers** - both edit and delete functional

### Cross-Item Testing

**Multiple portfolio items**:

1. **Test edit** on different items
2. **Verify different data** stored each time
3. **No state pollution** - previous edit data replaced
4. **Consistent behaviour** - same functionality across all items

---

