# 09-111: Making Dynamic Axios API Queries React

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/making-dynamic-axios-api-queries-react)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 659c28c4e3c6cea74d23dc5233ccfe6b7ebd4c5a](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/659c28c4e3c6cea74d23dc5233ccfe6b7ebd4c5a)

[GitHub - axios/axios: Promise based HTTP client for the browser and node.js](https://github.com/axios/axios)

---

## 🎯 Objectives

**Implement dynamic Axios system that works for CREATE and UPDATE**:

- **Axios configuration object** - use object syntax instead of helper methods
- **Dynamic state properties** - editMode, apiUrl, and apiAction in base state
- **Conditional state updates** - different values when in edit mode
- **Template literal URLs** - construct dynamic endpoints with portfolio item ID
- **HTTP method switching** - POST for create, PATCH for update
- **Single form handler** - one handleSubmit function for both operations

**Technical result**:

- Form works for creating AND editing portfolio items
- Correct API calls (POST vs PATCH) based on context
- Dynamic URLs that include ID when necessary
- Foundation for proper edit mode handling

---

## 🛠️ Implementation

### 1. Add Base State for Dynamic API Configuration

**File**: `src/components/portfolio/portfolio-form.js`

**Update state in constructor with new properties**:

```javascript
constructor(props) {
  super(props);

  this.state = {
    name: "",
    description: "",
    category: "eCommerce",
    position: "",
    url: "",
    thumb_image: "",
    banner_image: "",
    logo: "",
    editMode: false,
    apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items",
    apiAction: "post"
  };

  this.handleChange = this.handleChange.bind(this);
  this.handleSubmit = this.handleSubmit.bind(this);
  this.componentConfig = this.componentConfig.bind(this);
  this.djsConfig = this.djsConfig.bind(this);
}
```

### 2. Update componentDidUpdate for Edit Mode

**Modify componentDidUpdate method to include edit configuration**:

```javascript
componentDidUpdate() {
  if (Object.keys(this.props.portfolioToEdit).length > 0) {
    const {
      id,
      name,
      description,
      category,
      position,
      url,
      thumb_image_url,
      banner_image_url,
      logo_url
    } = this.props.portfolioToEdit;

    this.props.clearPortfolioToEdit();

    this.setState({
      id: id,
      name: name || "",
      description: description || "",
      category: category || "eCommerce",
      position: position || "",
      url: url || "",
      editMode: true,
      apiUrl: `https://jordan.devcamp.space/portfolio/portfolio_items/${id}`,
      apiAction: "patch"
    });
  }
}
```

### 3. Refactor handleSubmit to Use Axios Configuration Object

**Replace axios.post() with axios() configuration object**:

```javascript
handleSubmit(event) {
  axios({
    method: this.state.apiAction,
    url: this.state.apiUrl,
    data: this.buildForm(),
    withCredentials: true
  })
  .then(response => {
    this.props.handleSuccessfulFormSubmission(response.data.portfolio_item);

    this.setState({
      name: "",
      description: "",
      category: "eCommerce",
      position: "",
      url: "",
      thumb_image: "",
      banner_image: "",
      logo: "",
      editMode: false,
      apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items",
      apiAction: "post"
    });

    [this.thumbRef, this.bannerRef, this.logoRef].forEach(ref => {
      ref.current.dropzone.removeAllFiles();
    });
  })
  .catch(error => {
    console.log("portfolio form handleSubmit error", error);
  });

  event.preventDefault();
}
```

---

## 📚 Concepts

### Axios Configuration Object vs Helper Methods

**Traditional helper method approach**:

```javascript
// Separate calls for different HTTP methods
axios.post(url, data, config)    // For CREATE
axios.patch(url, data, config)   // For UPDATE
```

**Configuration object approach**:

```javascript
// Single call with dynamic method
axios({
  method: this.state.apiAction,  // "post" or "patch"
  url: this.state.apiUrl,        // dynamic URL
  data: this.buildForm(),
  withCredentials: true
})
```

**Advantages of configuration object**:

- **Single function** handles multiple HTTP methods
- **Dynamic method switching** based on state
- **Less code duplication** - same logic for CREATE/UPDATE
- **Easier maintenance** - changes in one place
- **More flexible** - easy to add headers, timeout, etc.

### Dynamic State Management Pattern

**Base state (CREATE mode)**:

```javascript
{
  editMode: false,
  apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items",
  apiAction: "post"
}
```

**Edit state (UPDATE mode)**:

```javascript
{
  editMode: true,
  apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items/123",
  apiAction: "patch"
}
```

**Why this pattern works**:

- **Single source of truth** - state determines API behaviour
- **Predictable switching** - clear transition between modes
- **Easy debugging** - inspect state to understand current mode
- **Scalable** - easy to add more modes (delete, etc.)

### Template Literal URL Construction

**Dynamic URL building for edit mode**:

```javascript
apiUrl: `https://jordan.devcamp.space/portfolio/portfolio_items/${id}`
```

**Resulting URLs**:

- **Create**: `https://jordan.devcamp.space/portfolio/portfolio_items`
- **Update**: `https://jordan.devcamp.space/portfolio/portfolio_items/123`

**RESTful API pattern**:

- **POST /portfolio_items** - create new resource
- **PATCH /portfolio_items/123** - update specific resource by ID
- **Standard convention** - used by most web APIs
- **Clear intent** - URL structure indicates operation type

### HTTP Method Semantics

**POST vs PATCH differences**:

**POST (CREATE)**:

- **Creates new resource** on server
- **No ID required** in URL (server generates)
- **Idempotent: NO** - multiple calls create multiple resources
- **Response** contains newly created resource with new ID

**PATCH (UPDATE)**:

- **Modifies existing resource** on server
- **ID required** in URL to identify resource
- **Idempotent: YES** - multiple calls have same effect
- **Response** contains updated resource data

### State Reset Strategy

**Why reset state after successful submission**:

```javascript
this.setState({
  name: "",
  description: "",
  // ... clear all form fields
  editMode: false,
  apiUrl: "https://jordan.devcamp.space/portfolio/portfolio_items",
  apiAction: "post"
});
```

**Benefits of reset**:

- **Clean slate** for next operation
- **Return to CREATE mode** by default
- **Clear form visual** - good UX
- **Prevent accidental edits** - no lingering edit state

### Error Handling Consistency

**Same error handling for both operations**:

```javascript
.catch(error => {
  console.log("portfolio form handleSubmit error", error);
});
```

**Why consistent handling**:

- **Single error path** - easier debugging
- **User experience** - consistent error response
- **Code maintenance** - one place for error logic
- **Future enhancement** - easy to add better error UI

---

## ✋ Verification

### Create Mode Testing

**Test new portfolio item creation**:

1. **Navigate to portfolio-manager**
2. **Fill out form** with new project data
3. **Submit form**
4. **Verify API call**:
   - Method: POST
   - URL: `.../portfolio_items` (no ID)
5. **Check sidebar** - new item appears
6. **Form resets** to empty state

### Edit Mode Testing

**Test portfolio item editing**:

1. **Click edit icon** on existing portfolio item
2. **Verify form population** with existing data
3. **Modify some fields**
4. **Submit form**
5. **Verify API call**:
   - Method: PATCH
   - URL: `.../portfolio_items/123` (with ID)
6. **Check sidebar** - item updates in place
7. **Form resets** to create mode

### State Inspection via DevTools

**Monitor state changes**:

1. **Open React DevTools**
2. **Select PortfolioForm** component
3. **Initial state verification**:
   - `editMode: false`
   - `apiAction: "post"`
   - `apiUrl: "...portfolio_items"`
4. **Click edit icon**
5. **Edit state verification**:
   - `editMode: true`
   - `apiAction: "patch"`
   - `apiUrl: "...portfolio_items/123"`
6. **Submit form**
7. **Reset state verification** - back to initial values

### Network Tab Verification

**API call inspection**:

1. **Open DevTools** → Network tab
2. **Create new item** → verify POST request
3. **Edit existing item** → verify PATCH request
4. **Check request URLs** - correct endpoints
5. **Verify request methods** - POST vs PATCH
6. **Inspect request payload** - FormData content

### Database Persistence Testing

**Verify changes persist**:

1. **Create new portfolio item**
2. **Refresh browser** 
3. **Verify item appears** in sidebar (persisted)
4. **Edit existing item**
5. **Refresh browser**
6. **Verify changes saved** - updated data displays

---

