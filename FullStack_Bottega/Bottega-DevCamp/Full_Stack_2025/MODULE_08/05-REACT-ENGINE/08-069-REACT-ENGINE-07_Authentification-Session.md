# 08-069 - Creating Authentication Session in React

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/creating-authentication-session-react

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/557d7e914a18d683ac8d88fb652ad99add7928ea)

---

## 🎯 OBJECTIVES

### Real Authentication System

**Critical functionality to implement**:

- Integration with authentication API using Axios
- POST request to create user sessions
- Automatic cookie handling for authentication state
- withCredentials for HTTP credential management
- Foundation for authentication state management

### Session Management Concepts

**Advanced skills you will master**:

- Session creation via API endpoints
- HTTP cookies and credential management
- Professional authentication flow
- Error handling for failed authentication
- Real-world authentication patterns

---

## 🛠️ IMPLEMENTATION

### 1. Import Axios in Login Component

**File**: `src/components/auth/login.js`

**Add Axios import**:

```javascript
import React, { Component } from "react";
import axios from "axios";

export default class Login extends Component {
  constructor(props) {
    super(props);

    this.state = {
      email: "",
      password: ""
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  // ... rest of component
}
```

### 2. Implement API Call in handleSubmit

**Replace console.log with Axios POST request**:

```javascript
handleSubmit(event) {
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
      console.log("response", response);
    });

  event.preventDefault();
}
```

**API call structure explained**:

- **URL**: `https://api.devcamp.space/sessions`
- **Data object**: `client` wrapper with email and password
- **Options**: `withCredentials: true` for cookie management

---

## 🔧 TECHNICAL CONCEPTS

### API Session Creation

**What happens on the server?**:

- **Validates credentials** against database
- **Creates session record** if credentials valid
- **Sends session cookie** back to browser
- **Cookie stored automatically** by browser
- **Future requests** include cookie automatically

### withCredentials: true

**Why is it critical?**:

```javascript
{ withCredentials: true }
```

**Functionality**:

- **Sends cookies** with request (if they exist)
- **Allows server** to set cookies in response
- **Enables session persistence** across requests
- **Required for authentication** workflows

### Client Object Structure

**API expects specific format**:

```javascript
{
  client: {
    email: "user@example.com",
    password: "userpassword"
  }
}
```

**Why client wrapper?**:

- **API design decision** - server expects this structure
- **Not React specific** - any client must use same format
- **Consistent with** DevCamp Space API architecture

### Axios POST Method Signature

**Three arguments pattern**:

```javascript
axios.post(url, data, config)
//        ^    ^     ^
//        |    |     └─ Options (withCredentials, headers, etc.)
//        |    └─ Request body data
//        └─ API endpoint URL
```

---

## ✔️ VERIFICATION

### Testing Authentication Success

**Testing steps**:

1. **Open incognito browser** - fresh session without existing cookies
2. **Navigate to** `localhost:3000/auth`
3. **Enter valid DevCamp Space credentials** - your real email/password
4. **Open DevTools** - console tab
5. **Click Login** button
6. **Verify response** - should see `status: "created"`

### ✅ Expected Success Response

**Console output should show**:

```javascript
{
  data: {
    status: "created",
    user: {
      email: "your-email@example.com",
      // ... other user data
    }
  },
  status: 200,
  // ... other Axios response properties
}
```

---

## 🔐 SECURITY AND BEST PRACTICES

### Cookie-Based Authentication

**How it works**:

1. **Successful login** → server creates session
2. **Session cookie** sent back to browser
3. **Browser stores cookie** automatically
4. **Future requests** include cookie in headers
5. **Server validates** cookie for authentication

### Why Incognito Mode for Testing

**Clear session state**:

- **No existing cookies** from previous sessions
- **Fresh authentication** test each time
- **Prevents cached** authentication state
- **True representation** of user experience

### Production Security Considerations

**In development**:

```javascript
console.log("response", response); // ✅ OK for debugging
```

**In production**:

```javascript
// ❌ Never log sensitive authentication data
// Remove all console.logs before deployment
```

---

## 🎯 EXPECTED RESULTS

- ✅ **Real authentication** working with external API
- ✅ **Session creation** functional with cookie management
- ✅ **Professional auth flow** following industry standards
- ✅ **Foundation established** for complete auth system
- ✅ **HTTP credentials** properly configured

**Authentication complexity levels**:

1. **Basic form submission** ← Completed
2. **Session management** ← Current stage
3. **State persistence** ← Next guide
4. **Route protection** ← Upcoming
5. **User authorisation** ← Advanced topic

**This guide represents the step from**:

- **Static forms** → **Dynamic API integration**
- **Local state** → **Server-side sessions**
- **Mock authentication** → **Real security**

---

## 🎨 UX AND FEEDBACK

### Current User Experience

**What user sees**:

- **Form submission** works
- **No visual feedback** yet (console only)
- **No redirect** after success
- **No error display** if credentials wrong

### Improvements Coming

**Future UX enhancements**:

- **Loading spinner** during API call
- **Success message** after login
- **Error display** for invalid credentials
- **Automatic redirect** to protected area

---
