# 10-146: Revisiting Render Props - Passing Logged In Status to Child Components

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/revisiting-render-props-passing-logged-in-status-child-components)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 39db9c53670364f48d3eafe494706facffbdc182](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/39db9c53670364f48d3eafe494706facffbdc182)

---

## 🎯 Objectives

**Implement conditional rendering of floating action button based on authentication status**:

- **Security problem** - floating action button visible to all users
- **Render props extension** - pass loggedInStatus state from App component
- **Authentication guard** - only show blog creation button when logged in
- **JavaScript function syntax** - explicit vs implicit returns with arrow functions
- **Route configuration** - migrate from component prop to render prop
- **Conditional UI rendering** - ternary operator for authentication-based display

**Security goal**: Only authenticated users should see blog creation functionality.

---

## 🛠️ Implementation

### 1. Migrate Blog Route to Render Prop Pattern

**File**: `src/components/app.js`

**Update blog route with render prop**:

```javascript
<Switch>
  <Route exact path="/" component={Home} />
  <Route path="/about-me" component={About} />
  <Route path="/contact" component={Contact} />

  <Route 
    path="/blog" 
    render={props => (
      <Blog 
        {...props}
        loggedInStatus={this.state.loggedInStatus}
      />
    )}
  />

  <Route path="/b/:slug" component={BlogDetail} />
  <Route 
    path="/auth" 
    render={props => (
      <Auth 
        {...props}
        handleSuccessfulLogin={this.handleSuccessfulLogin}
        handleUnsuccessfulLogin={this.handleUnsuccessfulLogin}
      />
    )}
  />
  <Route component={NoMatch} />
</Switch>
```

### 2. Add Conditional Rendering in Blog Component

**File**: `src/components/pages/blog.js`

**Wrap floating action button with authentication check**:

```javascript
render() {
  const blogRecords = this.state.blogItems.map(blogItem => {
    return <BlogItem key={blogItem.id} blogItem={blogItem} />;
  });

  return (
    <div className="blog-container">
      <BlogModal 
        handleSuccessfulNewBlogSubmission={this.handleSuccessfulNewBlogSubmission}
        handleModalClose={this.handleModalClose}
        modalIsOpen={this.state.blogModalIsOpen} 
      />

      {this.props.loggedInStatus === "LOGGED_IN" ? (
        <div className="new-blog-link">
          <a onClick={this.handleNewBlogClick}>
            <FontAwesomeIcon icon="plus-circle" />
          </a>
        </div>
      ) : null}

      <div className="content-container">{blogRecords}</div>

      {this.state.isLoading ? (
        <div className="content-loader">
          <FontAwesomeIcon icon="spinner" spin />
        </div>
      ) : null}
    </div>
  );
}
```

---

## 📖 Concepts

### Arrow Function Return Syntax Deep Dive

**Explicit vs Implicit Returns explanation**:

**Explicit return (curly braces)**:

```javascript
// Requires explicit return statement
const a = () => {
  return 'a';  // MUST have return keyword
};

const b = () => {
  'b';  // ✗ Returns undefined - no return statement
};
```

**Implicit return (parentheses)**:

```javascript
// Automatic return without return keyword
const c = () => 'c';  // ✓ Returns 'c' automatically

// JSX version (multiline)
const renderComponent = props => (
  <div>
    <Component {...props} />
  </div>
);
```

### Why Render Props Need Implicit Returns

**Common mistake in render props**:

```javascript
// ✗ Wrong - returns undefined
render={props => {
  <Blog {...props} loggedInStatus={this.state.loggedInStatus} />
}}

// ✓ Correct - implicit return
render={props => (
  <Blog {...props} loggedInStatus={this.state.loggedInStatus} />
)}
```

**Why this happens**:

- **JSX must be returned** - render expects JSX element
- **Curly braces require explicit return** - JavaScript rule
- **Parentheses provide implicit return** - automatic JSX return
- **Common debugging nightmare** - difficult to spot visually

### Render Props vs Component Props

**Component prop approach**:

```javascript
// Simple, static component rendering
<Route path="/blog" component={Blog} />
```

**Render prop approach**:

```javascript
// Dynamic component rendering with props
<Route 
  path="/blog" 
  render={props => (
    <Blog {...props} customProp={this.state.someValue} />
  )}
/>
```

**When to use each**:

- **Component prop** - when no custom props needed
- **Render prop** - when passing state, functions, or conditional props

### Props Spreading Pattern

**Spread operator usage**:

```javascript
<Blog 
  {...props}                           // Spreads all React Router props
  loggedInStatus={this.state.loggedInStatus}  // Adds custom prop
/>
```

**What `{...props}` provides**:

- **history** - navigation methods (push, replace, etc.)
- **location** - current route information
- **match** - route parameters and path info

**Why spread first**:

- **Preserves Router functionality** - component can navigate, access params
- **Custom props override** - our props take precedence if naming conflicts
- **Best practice** - ensures component receives expected Router props

### Conditional Rendering Patterns

**Ternary operator approach**:

```javascript
{this.props.loggedInStatus === "LOGGED_IN" ? (
  <ComponentToShow />
) : null}
```

**Alternative approaches**:

```javascript
// Short-circuit evaluation
{this.props.loggedInStatus === "LOGGED_IN" && <ComponentToShow />}

// Function-based conditional
{this.renderIfLoggedIn()}
```

**Why ternary chosen**:

- **Explicit null return** - clear intention when not showing component
- **Readable** - clear condition and outcomes
- **Consistent** - matches other conditional rendering in app

### Authentication-Based UI Patterns

**Progressive disclosure**:

- **Public content** - visible to all users
- **Action controls** - visible only to authenticated users
- **Admin features** - visible only to specific roles

**Security considerations**:

- **UI hiding** - improves UX but doesn't provide security
- **Server validation** - real security happens on backend
- **Graceful degradation** - app works without auth features

---

## ✅ Verification

### 1. Logged Out State Testing

**User not authenticated**:

1. **Clear browser cookies** - logout or incognito mode
2. **Navigate to /blog**
3. **Verify floating action button NOT visible**
4. **Blog posts still readable** - public content accessible
5. **No modal functionality** - no way to create blogs

### 2. Logged In State Testing

**User authenticated**:

1. **Navigate to /auth**
2. **Login with valid credentials**
3. **Navigate to /blog**
4. **Verify floating action button IS visible**
5. **Test modal functionality** - can create blogs
6. **Button positioned correctly** - bottom-right corner

### 3. State Transition Testing

**Login/logout workflow**:

1. **Start logged out** - verify no button
2. **Login** - button should appear
3. **Logout** - button should disappear
4. **No page refresh needed** - state changes immediately

### 4. Props Flow Verification

**React DevTools inspection**:

1. **Open React DevTools**
2. **Select Blog component**
3. **Check props panel**:
   - `loggedInStatus` should be present
   - Value should be "LOGGED_IN" or "NOT_LOGGED_IN"
   - Router props (history, location, match) should be present

### 5. Render Prop Syntax Verification

**No rendering errors**:

- ✓ **Blog component renders** - no undefined returns
- ✓ **Props passed correctly** - authentication state available
- ✓ **Router functionality preserved** - navigation still works
- ✓ **Custom props accessible** - loggedInStatus prop available

---

## 🎨 JavaScript Syntax Learning Moment

### Arrow Function Gotchas

**Console demonstration (from guide)**:

```javascript
// Explicit return required
const a = () => {
  return 'a';
};
console.log(a()); // 'a'

// No return statement
const b = () => {
  'b';
};
console.log(b()); // undefined

// Implicit return
const c = () => 'c';
console.log(c()); // 'c'
```

### JSX Multiline Syntax

**Why parentheses work in JSX**:

```javascript
// JSX compiler understands this as single expression
render={props => (
  <div>
    <Component {...props} />
  </div>
)}

// Console would give syntax error, but JSX handles it
```

### Common Debugging Scenario

**When render prop returns undefined**:

1. **Symptom** - component doesn't render, no visible errors
2. **Cause** - used curly braces without return statement
3. **Debug method** - check render prop function syntax
4. **Solution** - change `{}` to `()` or add explicit return

### Professional Development Tip

**Avoiding the common mistake**:

- **Muscle memory** - developers used to `{}` syntax
- **JSX context** - different rules than regular JavaScript
- **Linting help** - ESLint can catch some cases
- **Code review** - common issue to watch for

---
