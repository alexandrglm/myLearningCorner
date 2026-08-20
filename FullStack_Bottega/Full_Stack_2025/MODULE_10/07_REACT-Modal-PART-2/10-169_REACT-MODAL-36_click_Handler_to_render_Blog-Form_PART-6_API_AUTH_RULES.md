# 10-169: Enabling Authorization Rules for Blog Detail Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/enabling-authorization-rules-blog-detail-component)**

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 593d4d1479d5837d2f338a4c567c4e7182ffb6c2](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/593d4d1479d5837d2f338a4c567c4e7182ffb6c2)

---

## 🎯 Objectives

**Implement security and authorisation to prevent unauthorised blog editing**:

- **Security issue** - unauthenticated users can trigger edit mode by clicking titles
- **API protection exists** - server validates credentials, but UX is poor
- **Render props for BlogDetail** - pass loggedInStatus from App component
- **Authorisation vs Authentication** - understand conceptual difference
- **Client-side authorisation** - prevent access to restricted functionality
- **State management security** - avoid discrepancies between state and permissions

**Security principle**: Do not allow unauthenticated users to access edit functionality, even if API rejects requests.

---

## 🛠️ Implementation

### 1. Add Render Prop for BlogDetail Route

**File**: `src/components/app.js`

**Convert BlogDetail route to use render prop pattern**:

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

  <Route 
    path="/b/:slug" 
    render={props => (
      <BlogDetail 
        {...props}
        loggedInStatus={this.state.loggedInStatus}
      />
    )}
  />

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

### 2. Add Authorization Check in handleEditClick

**File**: `src/components/blog/blog-detail.js`

**Wrap setState with authentication check**:

```javascript
handleEditClick() {
  if (this.props.loggedInStatus === "LOGGED_IN") {
    this.setState({
      editMode: true
    });
  }
}
```

**Remove any previous conditional rendering checks** - keep authorisation at state level, not render level to avoid state discrepancies.

---

## 📧 Concepts

### Authentication vs Authorisation

**Authentication** (Who are you?):

- **Process** - logging in and verifying identity
- **Server validates** - username/password combination
- **Result** - server confirms "yes, you are who you say you are"
- **Examples** - login forms, credential verification
- **Technical** - passing credentials to server, receiving session tokens

**Authorisation** (What can you do?):

- **Process** - setting up permissions and access control
- **Permission checking** - determining what authenticated users can access
- **Result** - "you are logged in AND you can perform this action"
- **Examples** - admin-only features, role-based access
- **Technical** - checking user permissions, conditional rendering

**This guide implements authorisation** - we're controlling what authenticated users can do.

### Client-Side Security Principles

**Defence in depth**:

```javascript
// Layer 1: Client-side authorisation (UX improvement)
if (this.props.loggedInStatus === "LOGGED_IN") {
  // Allow edit mode
}

// Layer 2: API-level authentication (real security)
axios({
  // ... request config
  withCredentials: true  // Server validates session
})
```

**Why both layers matter**:

- **Client-side** - improves user experience, prevents confusion
- **Server-side** - provides actual security, prevents data manipulation
- **Never rely solely on client-side** - real security happens on server
- **UX enhancement** - don't show features user can't actually use

### State Management Security

**Problem with conditional rendering only**:

```javascript
// ❌ BAD - creates state discrepancy
if (this.state.editMode && this.props.loggedInStatus === "LOGGED_IN") {
  return <BlogForm />;  // Component not rendered...
}
// But editMode could still be true internally!
```

**Solution with state-level authorisation**:

```javascript
// ✅ GOOD - prevents state discrepancy
handleEditClick() {
  if (this.props.loggedInStatus === "LOGGED_IN") {
    this.setState({ editMode: true });  // State only changes if authorised
  }
}
```

**Benefits of state-level approach**:

- **Consistent state** - editMode reflects actual permissions
- **Clear debugging** - state tells the truth about current mode
- **No ghost states** - won't have editMode=true whilst unauthorised
- **Predictable behaviour** - state matches what user can actually do

### Render Props Pattern Consistency

**Following established pattern**:

```javascript
// Blog route (existing)
<Route path="/blog" render={props => (
  <Blog {...props} loggedInStatus={this.state.loggedInStatus} />
)} />

// BlogDetail route (new) - same pattern
<Route path="/b/:slug" render={props => (
  <BlogDetail {...props} loggedInStatus={this.state.loggedInStatus} />
)} />
```

**Pattern benefits**:

- **Consistency** - same approach across routes
- **Maintainability** - established pattern is familiar
- **Extensibility** - easy to add more props if needed
- **Router integration** - preserves Router functionality via spread operator

### Security UX Best Practices

**Progressive disclosure**:

- **Show what's available** - only display features user can actually use
- **Hide restricted features** - don't tease functionality that's not accessible
- **Clear feedback** - if action requires authentication, make that clear
- **Graceful degradation** - app works for both authenticated and anonymous users

**What we prevent**:

- **Confusing interactions** - clicking title when not logged in
- **Error states** - API rejections that confuse users
- **Broken workflows** - starting processes user can't complete
- **Security theatre** - showing features that don't actually work

---

## 📋 Verification

### 1. Logged Out State Testing

**Security verification when not authenticated**:

1. **Clear browser cookies** - ensure not logged in
2. **Navigate to any blog detail** - `/b/[slug]`
3. **Click blog title** - should not enter edit mode
4. **Check React DevTools** - editMode should remain false
5. **Console check** - should see "handle edit clicked" but no state change
6. **No form appears** - BlogForm should never render

### 2. Logged In State Testing

**Functionality verification when authenticated**:

1. **Navigate to `/auth`** - go to login page
2. **Login with valid credentials** - authenticate
3. **Navigate to blog detail** - any blog post
4. **Click blog title** - should enter edit mode
5. **Check React DevTools** - editMode should become true
6. **Form appears** - BlogForm should render with pre-populated data

### 3. State Consistency Testing

**Verify no state discrepancies**:

1. **Start logged out** - verify editMode: false
2. **Click title multiple times** - editMode should remain false
3. **Login** - then try clicking title
4. **Should work immediately** - editMode becomes true
5. **Logout** (if implemented) - editMode should become false

### 4. Props Flow Verification

**React DevTools inspection**:

1. **Navigate to blog detail**
2. **Open React DevTools** → Components
3. **Select BlogDetail component**
4. **Check props**:
   - `loggedInStatus` should be present
   - Value should be "LOGGED_IN" or "NOT_LOGGED_IN"
   - Router props (match, location, history) should be present

### 5. Authorization Boundary Testing

**Edge case verification**:

1. **Login and enter edit mode**
2. **Simulate logout** (manually change app state via DevTools)
3. **Try interacting with form** - should not work at API level
4. **Refresh page** - should return to display mode

### 6. Multiple Users Testing

**Different authentication states**:

1. **Browser 1** - logged in user
2. **Browser 2** - not logged in (incognito)
3. **Same blog post** in both browsers
4. **Verify behaviour differs** - edit available only for authenticated

---

## 🚀 Security Considerations

### What This Protects Against

**User experience issues**:

- **Confusion** - users trying features they can't actually use
- **Error messages** - API rejection errors that shouldn't happen
- **Broken workflows** - starting edit process without ability to save
- **Security theatre** - showing features that don't work

### What This Doesn't Protect Against

**Real security threats** (handled by server):

- **API manipulation** - direct API calls bypass client-side checks
- **Authentication bypass** - server still validates every request
- **Data tampering** - server-side validation prevents malicious updates
- **Session hijacking** - server-side session management handles this

### Development Best Practices

**Client-side authorisation principles**:

- **UX enhancement** - primary goal is better user experience
- **Never rely solely on client-side** - server provides real security
- **Consistent state management** - avoid discrepancies between UI and permissions
- **Clear feedback** - make authentication requirements obvious

**This implementation follows security best practices by providing defence in depth - client-side authorisation for UX and server-side authentication for actual security.**

---

