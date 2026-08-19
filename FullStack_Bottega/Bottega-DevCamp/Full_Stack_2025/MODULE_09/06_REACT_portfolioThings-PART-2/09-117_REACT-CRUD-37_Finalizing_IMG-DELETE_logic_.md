# 09-117: Finalizing Image Delete Functionality

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/finalizing-image-delete-functionality)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 9c77b523d1e9d7eafd7d60b016192e19e81b7c7c](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/9c77b523d1e9d7eafd7d60b016192e19e81b7c7c)

---

## 🎯 Objectives

**Complete real image deletion functionality**:

- **Replace console.log with API call** - implement axios.delete to remove images from server
- **Dynamic URL construction** - use template literals with portfolio ID and image type
- **Query parameters** - send image_type as optional parameter in URL
- **Dynamic state update** - use setState with dynamically calculated field names
- **Automatic UI change** - deleted image automatically converts to dropzone

**Functional result**:

- Click "Remove file" → API call → image deleted from server → state updated → dropzone appears automatically
- Complete CRUD functionality for image management

---

## 🛠️ Implementation

### 1. Implement Real API Call

**File**: `src/components/portfolio/portfolio-form.js`

**Replace console.log in deleteImage method**:

```javascript
deleteImage(imageType) {
  axios
    .delete(
      `https://api.devcamp.space/portfolio/delete-portfolio-image/${this.state.id}?image_type=${imageType}`,
      { withCredentials: true }
    )
    .then(response => {
      console.log("deleteImage", response);
    })
    .catch(error => {
      console.log("deleteImage error", error);
    });
}
```

### 2. Implement Dynamic State Update

**Replace console.log with dynamic setState**:

```javascript
deleteImage(imageType) {
  axios
    .delete(
      `https://api.devcamp.space/portfolio/delete-portfolio-image/${this.state.id}?image_type=${imageType}`,
      { withCredentials: true }
    )
    .then(response => {
      this.setState({
        [`${imageType}_url`]: ""
      });
    })
    .catch(error => {
      console.log("deleteImage error", error);
    });
}
```

---

## 📚 Concepts

### URL Construction with Template Literals

**Complete URL structure**:

```javascript
`https://api.devcamp.space/portfolio/delete-portfolio-image/${this.state.id}?image_type=${imageType}`
```

**URL components**:

- **Base endpoint**: `https://api.devcamp.space/portfolio/delete-portfolio-image`
- **Portfolio ID**: `${this.state.id}` - identifies which portfolio item
- **Query parameter**: `?image_type=${imageType}` - specifies which image to delete

**Generated URL examples**:

```
https://api.devcamp.space/portfolio/delete-portfolio-image/123?image_type=thumb_image
https://api.devcamp.space/portfolio/delete-portfolio-image/456?image_type=banner_image
https://api.devcamp.space/portfolio/delete-portfolio-image/789?image_type=logo
```

### Query Parameters in APIs

**Why use query parameters**:

```javascript
// ✅ Using query parameter
?image_type=thumb_image

// ❌ Alternative in route (not supported by this API)
/delete-portfolio-image/123/thumb_image
```

**Advantages of query parameters**:

- **Flexibility** - easy to add more optional parameters
- **Web standard** - widely accepted convention
- **Automatic parsing** - servers handle automatically
- **Readability** - clear separation between ID and type

### Dynamic setState with Calculated Field Names

**Syntax for dynamic setState**:

```javascript
this.setState({
  [`${imageType}_url`]: ""
});
```

**How the syntax works**:

- **Brackets `[]`** - indicate dynamic key
- **Template literal**: `${imageType}_url` - constructs field name
- **Final result**: state field set dynamically

**Transformation example**:

```javascript
// If imageType = "thumb_image"
[`${imageType}_url`] → [`thumb_image_url`] → thumb_image_url: ""

// If imageType = "banner_image"  
[`${imageType}_url`] → [`banner_image_url`] → banner_image_url: ""

// If imageType = "logo"
[`${imageType}_url`] → [`logo_url`] → logo_url: ""
```

### Complete Image Deletion Flow

**Step-by-step sequence**:

1. **User clicks** "Remove file" 
2. **onClick triggers** `deleteImage("thumb_image")`
3. **Axios DELETE** sends request to server
4. **Server deletes** image and responds with success
5. **setState executes** `thumb_image_url: ""`
6. **Re-render triggered** by state change
7. **Ternary evaluates** `this.state.thumb_image_url && this.state.editMode`
8. **Condition is false** (field is empty)
9. **Dropzone displays** instead of image

### Authentication and Authorisation

**withCredentials for security**:

```javascript
{ withCredentials: true }
```

**Server validation process**:

- **Session cookies** sent automatically
- **User verification** - server identifies logged-in user
- **Ownership check** - confirms portfolio item belongs to user
- **Authorisation** - allows deletion only if owner

### Handling Server Responses

**204 status code**:

```javascript
// Typical successful response
{
  status: 204,  // "No Content" - successful deletion
  data: "",     // Empty for successful deletes
  // ... other response properties
}
```

**Why 204 status code**:

- **HTTP standard** - 204 indicates "successful deletion with no response content"
- **No data needed** - deletion doesn't need to return data
- **Sufficient confirmation** - response indicates success

### Component State Machine

**Possible component states**:

**State 1 - Create mode**:

```javascript
{
  editMode: false,
  thumb_image_url: "",
  // Result: Shows dropzone
}
```

**State 2 - Edit mode with image**:

```javascript
{
  editMode: true,
  thumb_image_url: "https://...",
  // Result: Shows image with delete button
}
```

**State 3 - After deletion**:

```javascript
{
  editMode: true,
  thumb_image_url: "",
  // Result: Shows dropzone (image deleted)
}
```

---

## ✋ Verification

### Testing Real Deletion

**Complete testing workflow**:

1. **Navigate to portfolio-manager**
2. **Click edit** on item with images
3. **Open browser console** for monitoring
4. **Click "Remove file"** below any image
5. **Verify console log**: 204 response from server
6. **Verify UI**: image disappears, dropzone appears
7. **Refresh page** → confirm deletion persists

### Persistence Verification

**Confirm deletion on server**:

1. **After deleting image**
2. **Full page refresh** (Ctrl+R)
3. **Click edit** on same item
4. **Verify**: dropzone appears where image was
5. **Confirm**: image doesn't restore on reload

### Testing Different Image Types

**Test deletion of each type**:

1. **Thumbnail**: Click "Remove file" → image disappears
2. **Banner**: Click "Remove file" → image disappears  
3. **Logo**: Click "Remove file" → image disappears
4. **Each type** should behave identically

### State in React DevTools

**Monitor state changes**:

1. **Open React DevTools**
2. **Select PortfolioForm** component
3. **State before deletion**: `thumb_image_url: "https://..."`
4. **Click "Remove file"**
5. **State after**: `thumb_image_url: ""`
6. **Verify**: only specific field cleared

### Testing Upload After Deletion

**Verify dropzone works after deletion**:

1. **Delete existing image** → dropzone appears
2. **Upload new image** via dropzone → preview appears
3. **Submit form** → new image saved
4. **Verify complete cycle** works correctly

### Error Handling Verification

**Test edge cases**:

1. **Delete when not logged in** → 401 error in console
2. **Delete non-existent item** → 404 error in console
3. **Network issues** → error in console, UI remains stable
4. **Verify**: errors don't break functionality

### Cross-Browser Testing

**Verify compatibility**:

1. **Chrome** - template literals and dynamic setState work
2. **Firefox** - axios delete and query parameters work
3. **Safari** - authentication with cookies works
4. **Edge** - complete functionality without issues

---
