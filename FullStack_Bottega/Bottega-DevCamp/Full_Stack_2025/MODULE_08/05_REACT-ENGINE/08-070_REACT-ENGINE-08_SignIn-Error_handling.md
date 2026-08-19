# 08-070 - Handling Authentication Errors in React

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/handling-sign-in-error-react

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/b561cb72e6d928d39244e9232bbadd59729a910b)

---

## 🎯 OBJECTIVES

### Complete Error Handling System

**Critical functionality to implement**:

- Display of authentication errors in UI
- Differentiation between error types (401 vs 500/404)
- Clear error messages for user feedback
- Auto-clear errors when user retries
- Professional error handling patterns

### Types of Errors to Handle

**Two main categories**:

1. **Authentication errors** (401) - Wrong credentials
2. **Network/Server errors** (404, 500) - API down, wrong endpoint
3. **Dynamic and contextual** user feedback

---

## 🛠️ IMPLEMENTATION

### 1. Add Error State

**File**: `src/components/auth/login.js`

**Expand state to include error tracking**:

```javascript
export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      password: "",
      errorText: ""  // New state for error messages
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  // ... rest of component
}
```

### 2. Add Error Display in JSX

**Update render method to show errors**:

```javascript
render() {
  return (
    <div>
      <h1>Login to access your dashboard</h1>

      <div>{this.state.errorText}</div>

      <form onSubmit={this.handleSubmit}>
        <input 
          type="email"
          name="email"
          placeholder="Your email"
          value={this.state.email}
          onChange={this.handleChange}
        />

        <input 
          type="password"
          name="password"
          placeholder="Your password"
          value={this.state.password}
          onChange={this.handleChange}
        />

        <button type="submit">Login</button>
      </form>
    </div>
  );
}
```

### 3. Implement Comprehensive Error Handling

**Update handleSubmit with complete error handling**:

```javascript
handleSubmit(event) {
  event.preventDefault();

  axios
    .post(
      "https://api.devcamp.space/sessions",
      {
        client: {
          email: this.state.email,
          password: this.state.password
        }
      },
      { withCredentials: true }
    )
    .then(response => {
      if (response.data.status === "created") {
        console.log("You can come in...");
      } else {
        this.setState({
          errorText: "Wrong email or password"
        });
      }
    })
    .catch(error => {
      this.setState({
        errorText: "An error occurred"
      });
    });
}
```

### 4. Auto-Clear Errors in handleChange

**Modify handleChange to clear errors when user types**:

```javascript
handleChange(event) {
  this.setState({
    [event.target.name]: event.target.value,
    errorText: ""  // Clear errors when user starts typing again
  });
}
```

---

## 🔧 TECHNICAL CONCEPTS

### HTTP Status Code Differentiation

**401 Unauthorised**:

- **Meaning**: Authentication failed
- **Cause**: Wrong email/password
- **User action**: Re-enter credentials
- **Message**: "Wrong email or password"

**404 Not Found**:

- **Meaning**: API endpoint doesn't exist
- **Cause**: Wrong URL, typo in endpoint
- **Dev action**: Fix API URL
- **Message**: "An error occurred"

**500 Server Error**:

- **Meaning**: Server-side problem
- **Cause**: API server down, internal error
- **User action**: Try again later
- **Message**: "An error occurred"

### Two-Tier Error Handling Strategy

**Promise chain structure**:

```javascript
.then(response => {
  // Handle HTTP 200 responses
  if (response.data.status === "created") {
    // Success path
  } else {
    // Authentication failure (401 wrapped in 200 response)
  }
})
.catch(error => {
  // Handle network errors, 404, 500, etc.
});
```

### State Management for UX

**Error lifecycle**:

1. **Initial state**: `errorText: ""`
2. **Error occurs**: Set specific error message
3. **User types**: Auto-clear via handleChange
4. **New attempt**: Fresh start without old errors

---

## ✔️ VERIFICATION

### Testing Error Scenarios

**Scenario 1: Wrong credentials**

1. **Enter invalid** email/password
2. **Click Login**
3. **Expected**: "Wrong email or password" display
4. **Start typing** - error should clear

**Scenario 2: Network error**

1. **Change API URL** to `sessions123` (invalid)
2. **Click Login**
3. **Expected**: "An error occurred" display
4. **Check console** - should see 404 error

**Scenario 3: Successful login**

1. **Enter valid** DevCamp Space credentials
2. **Click Login**
3. **Expected**: Console shows "You can come in..."
4. **No error text** displayed

---

## 🎨 UX AND USABILITY

### User Experience Improvements

**Clear feedback**:

- **Immediate error display** when something goes wrong
- **Specific messages** - user knows exactly what happened
- **Auto-clear behaviour** - fresh start when user retries
- **No page refresh** - smooth SPA experience

### Error Message Strategy

**User-friendly language**:

- **"Wrong email or password"** - clear, actionable
- **"An error occurred"** - generic for technical issues
- **Avoid technical jargon** - no HTTP status codes to users
- **Consistent tone** - helpful, not blame-focused

---

## 🎯 EXPECTED RESULTS

- ✅ **Complete error handling** for authentication flow
- ✅ **User-friendly feedback** in all scenarios
- ✅ **Professional UX patterns** - clear, auto-clearing errors
- ✅ **Robust form behaviour** - handles all edge cases
- ✅ **Solid foundation** for complete authentication system

### 💡 Professional Insight

**Error handling maturity levels**:

1. **No error handling** ← Beginner mistake
2. **Console.log errors** ← Development phase
3. **Generic error display** ← Basic production
4. **Contextual error messages** ← Current level
5. **Comprehensive error recovery** ← Advanced patterns

**This guide establishes**:

- **Professional standards** for user feedback
- **Defensive programming** - handle all failure modes
- **User-centric design** - errors help, don't confuse

---

## 🔍 DEBUGGING AND TESTING

### Manual Testing Protocol

**For each error type**:

1. **Trigger error** condition
2. **Verify message** displays correctly
3. **Test auto-clear** behaviour
4. **Check console** for additional debugging info
5. **Verify recovery** path works

### Common Issues and Solutions

**Error not displaying**:

- Check state updates in React DevTools
- Verify errorText is in JSX
- Confirm setState syntax correct

**Error not clearing**:

- Verify handleChange includes errorText reset
- Check that inputs have onChange handlers
- Test typing in both email and password fields

---
