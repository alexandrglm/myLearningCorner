# 08-074 - Automatic Authentication Status Verification in React

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/automatically-checking-if-a-user-is-logged-in-in-react

[SOURCE](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/ecc8da2f337ff398b73564c35480ded53a483628)

---

## 🎯 OBJECTIVES

### Resolve the Refresh Bug

**Critical problem to solve**:

- On page refresh, state reverts to "NOT_LOGGED_IN" even though session exists
- Cookies remain in browser but application doesn't verify them
- Need to check authentication status on application load
- Maintain login state across browser sessions

### Automatic Session Verification

**Functionality to implement**:

- `/logged_in` endpoint to verify current authentication state
- Automatic verification in `componentDidMount` 
- Conditional logic to synchronise application state with server state
- Handle all possible authentication scenarios

---

## 🛠️ IMPLEMENTATION

### 1. Import Axios in App Component

**File**: `src/components/app.js`

**Add axios import**:

```javascript
import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import axios from 'axios';
import NavigationContainer from './navigation/navigation-container';
// ... rest of imports
```

### 2. Create Status Verification Method

**Add `checkLoginStatus` method in App component**:

```javascript
checkLoginStatus() {
  return axios.get("https://api.devcamp.space/logged_in", {
    withCredentials: true
  })
  .then(response => {
    console.log("logged_in return", response);

    const loggedIn = response.data.logged_in;
    const loggedInStatus = this.state.loggedInStatus;

    // If we're logged in AND state is already LOGGED_IN
    if (loggedIn && loggedInStatus === "LOGGED_IN") {
      return loggedIn;
    } 
    // If we're logged in BUT state is NOT_LOGGED_IN
    else if (loggedIn && loggedInStatus === "NOT_LOGGED_IN") {
      this.setState({
        loggedInStatus: "LOGGED_IN"
      });
    }
    // If we're NOT logged in BUT state is LOGGED_IN
    else if (!loggedIn && loggedInStatus === "LOGGED_IN") {
      this.setState({
        loggedInStatus: "NOT_LOGGED_IN"
      });
    }
  })
  .catch(error => {
    console.log("Error", error);
  });
}
```

### 3. Call Verification in componentDidMount

**Add lifecycle method in App component**:

```javascript
componentDidMount() {
  this.checkLoginStatus();
}
```

---

## 🔧 TECHNICAL CONCEPTS

### `/logged_in` Endpoint

**Purpose of endpoint**:

- **Verify** current authentication state without requiring credentials
- **Use existing cookies** to determine if session is valid
- **Return user information** if authenticated
- **Requires no data** in request body

### Endpoint Response

**Authenticated user**:

```javascript
{
  logged_in: true,
  user: {
    id: 123,
    email: "user@example.com",
    subdomain: "usersubdomain",
    // ... more user data
  }
}
```

**Unauthenticated user**:

```javascript
{
  logged_in: false
}
```

### Complete Conditional Logic

**Three possible scenarios**:

**1. Coherence (no action needed)**:

```javascript
if (loggedIn && loggedInStatus === "LOGGED_IN")
```

- **Server says**: you're authenticated
- **App says**: you're authenticated
- **Action**: none, everything is synchronised

**2. Server authenticated, App not**:

```javascript
else if (loggedIn && loggedInStatus === "NOT_LOGGED_IN")
```

- **Server says**: you're authenticated (valid cookie)
- **App says**: you're not authenticated
- **Action**: update app to "LOGGED_IN"

**3. Server not authenticated, App yes**:

```javascript
else if (!loggedIn && loggedInStatus === "LOGGED_IN")
```

- **Server says**: you're not authenticated (session expired)
- **App says**: you're authenticated
- **Action**: update app to "NOT_LOGGED_IN"

### withCredentials: true

**Critical for functionality**:

- **Sends cookies** automatically with request
- **Allows server** to identify existing session
- **Without this parameter** server cannot verify authentication
- **Same behaviour** as login requests

---

## ✔️ VERIFICATION

### Testing the Behaviour

**Scenario 1: New user**:

1. **Open incognito browser**
2. **Go to** `localhost:3000`
3. **Verify state**: "NOT_LOGGED_IN"
4. **Console shows**: `logged_in: false`

**Scenario 2: Normal login**:

1. **Go to** `/auth` and login
2. **Verify redirection** to homepage
3. **State displays**: "LOGGED_IN"

**Scenario 3: Refresh after login**:

1. **Login** as in scenario 2
2. **Refresh page** (F5 or Cmd+R)
3. **Briefly displays** "NOT_LOGGED_IN"
4. **Then updates** automatically to "LOGGED_IN"
5. **Console shows**: `logged_in: true`

### Expected Behaviour

**Session persistence achieved**:

- **Login persists** across page refreshes
- **Automatic synchronisation** between server and app
- **Smooth experience** for user
- **Consistent state** at all times

---

## 🎨 USER EXPERIENCE

### Significant Improvement

**Before (with bug)**:

- User logs in → Everything works
- User refreshes page → Loses login, must authenticate again
- **Frustrating experience** and non-standard

**After (with fix)**:

- User logs in → Everything works  
- User refreshes page → Maintains login automatically
- **Professional experience** like modern websites

### Visual Loading State

**Behaviour during verification**:

- **Brief moment** where state shows initial value
- **Then automatic update** based on server response
- **Normal in applications** with asynchronous verification
- **Improvable** with loading indicators (future implementation)

---

## Issues Resolved

- ✅ **Refresh bug solved** - authentication state persists
- ✅ **Automatic verification** working correctly
- ✅ **State synchronisation** between server and client

### Architecture Established

- ✅ **Complete login flow** and functional
- ✅ **Session persistence** across refreshes
- ✅ **Automatic verification** on app load
- ✅ **Server-client synchronisation** working
- ✅ **Professional UX** without session loss

---

## 🎯 EXPECTED RESULTS

- ✅ **Refresh bug resolved** - authentication persists
- ✅ **Automatic verification** working correctly
- ✅ **Robust conditional logic** for all scenarios
- ✅ **Professional experience** comparable to modern sites
- ✅ **Authentication system** practically complete

**Importance of session persistence**:

- **Industry standard** - users expect this behaviour
- **Reduces friction** - don't force re-authentication constantly
- **Better conversion** - users don't abandon due to re-logins
- **Smart security** - verify session without exposing credentials

**Authentication verification patterns**:

- **Verification on load** - componentDidMount is right place
- **State synchronisation** - maintain coherence between server and client
- **Error handling** - graceful degradation if verification fails
- **Performance consideration** - single verification per app load

---

## 🔍 DEBUGGING AND TROUBLESHOOTING

### Common Issues

**Verification not working**:

- Verify that `withCredentials: true` is included
- Confirm cookies exist in DevTools → Application → Cookies
- Verify correct endpoint URL

**State not updating**:

- Review conditional logic in console.log
- Verify that `this.setState` is called correctly
- Confirm binding if necessary

### Debugging Tools

**DevTools Network tab**:

- Verify request to `/logged_in` is made
- Confirm cookies are sent in request headers
- Review response to see data structure

**React DevTools**:

- Monitor state changes in real time
- Verify componentDidMount executes
- Observe state updates after verification

---
