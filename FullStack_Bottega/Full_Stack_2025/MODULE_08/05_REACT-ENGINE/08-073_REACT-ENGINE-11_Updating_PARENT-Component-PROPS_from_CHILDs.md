# 08-073 - Updating Parent Component State from Child Component

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/updating-parent-component-state-react-child-component

[Source](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/05336bc5ea48dfda23dce0fc1fdc98130f59194c)

---

## 🎯 OBJECTIVES

### Complete Two-Way Communication

**Critical functionality to implement**:

- Child → parent communication to update authentication state
- Automatic redirection after successful login using React Router history
- Complete authentication flow handling: Login → State → Redirection
- Visual debugging of application-level authentication state
- Complete props chain: App → Auth → Login

### React Data Flow Concepts

**Advanced patterns you will master**:

- Passing props (functions) through multiple component levels
- Using `this.props.history.push()` for programmatic navigation
- Method binding in intermediary components
- Updating parent state from grandchild components
- Handling success and error in authentication flow

---

## 🛠️ IMPLEMENTATION

### 1. Add Visual Debugging in App Component

**File**: `src/components/app.js`

**Add visual indicator of login state**:

```javascript
render() {
  return (
    <div className="container">
      <Router>
        <div>
          <NavigationContainer />

          {/* Visual debugging of auth state */}
          <h2>{this.state.loggedInStatus}</h2>

          <Switch>
            {/* ... rest of routes */}
          </Switch>
        </div>
      </Router>
    </div>
  );
}
```

### 2. Configure Auth Component as Intermediary

**File**: `src/components/pages/auth.js`

**Create constructor and intermediary methods**:

```javascript
import React, { Component } from "react";
import Login from "../auth/login";
import loginImg from "../../../static/assets/images/auth/login.jpg";

export default class Auth extends Component {
  constructor(props) {
    super(props);

    this.handleSuccessfulAuth = this.handleSuccessfulAuth.bind(this);
    this.handleUnsuccessfulAuth = this.handleUnsuccessfulAuth.bind(this);
  }

  handleSuccessfulAuth() {
    this.props.handleSuccessfulLogin();
    this.props.history.push("/");
  }

  handleUnsuccessfulAuth() {
    this.props.handleUnsuccessfulLogin();
  }

  render() {
    return (
      <div className="auth-page-wrapper">
        <div 
          className="left-column"
          style={{
            backgroundImage: `url(${loginImg})`
          }}
        />

        <div className="right-column">
          <Login 
            handleSuccessfulAuth={this.handleSuccessfulAuth}
            handleUnsuccessfulAuth={this.handleUnsuccessfulAuth}
          />
        </div>
      </div>
    );
  }
}
```

### 3. Connect Login Component with Props

**File**: `src/components/auth/login.js`

**Update handleSubmit to use passed props**:

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
        this.props.handleSuccessfulAuth();
      } else {
        this.setState({
          errorText: "Wrong email or password"
        });
        this.props.handleUnsuccessfulAuth();
      }
    })
    .catch(error => {
      this.setState({
        errorText: "An error occurred"
      });
      this.props.handleUnsuccessfulAuth();
    });
}
```

---

## 🔧 TECHNICAL CONCEPTS

### Complete Data Flow

**Communication chain**:

```
App Component (loggedInStatus state)
    ↓ (render props)
Auth Component (intermediate handlers)
    ↓ (props)
Login Component (API call)
    ↑ (prop functions)
Auth Component (history navigation)
    ↑ (prop functions)
App Component (state update)
```

### React Router History API

**Programmatic navigation**:

```javascript
this.props.history.push("/");
```

**Where does history come from?**:

- **React Router** automatically provides `history` object
- **Render props** preserves history via `{...props}`
- **Navigation control** - redirect users after actions
- **SPA behaviour** - change routes without page refresh

### Intermediary Methods

**Why does Auth component need its own methods?**:

```javascript
// Instead of passing directly:
<Login handleSuccessfulAuth={this.props.handleSuccessfulLogin} />

// We use intermediary:
<Login handleSuccessfulAuth={this.handleSuccessfulAuth} />
```

**Benefits of intermediary approach**:

- **Additional control** - we can add extra logic (redirection)
- **Separation of concerns** - each component has clear responsibilities
- **Flexibility** - easy to add more functionality in future

### Naming Conventions

**Differentiation in method names**:

- **App**: `handleSuccessfulLogin` / `handleUnsuccessfulLogin`
- **Auth**: `handleSuccessfulAuth` / `handleUnsuccessfulAuth`

**Why different names?**:

- **Avoid confusion** - clear which method belongs to which component
- **Debugging clarity** - clearer stack traces
- **Code maintenance** - easier to track function calls

---

## ✔️ VERIFICATION

### Testing Complete Flow

**Verification steps**:

**1. Initial state**:

- Navigate to application
- Verify it displays "NOT_LOGGED_IN"
- Confirm on home page

**2. Login process**:

- Go to `/auth`
- Enter valid DevCamp Space credentials
- Click "Login"

**3. Expected result**:

- State changes to "LOGGED_IN"
- Automatic redirection to homepage (`/`)
- No page refresh - SPA navigation

**4. Error testing**:

- Enter invalid credentials
- Verify state remains "NOT_LOGGED_IN"
- Confirm no redirection

### Expected User Experience

**Successful login**:

1. User enters correct credentials
2. Visual state changes to "LOGGED_IN"
3. Immediate redirection to homepage
4. User sees authenticated main content

**Failed login**:

1. User enters incorrect credentials
2. Error message displayed
3. State remains "NOT_LOGGED_IN"
4. User remains on login page

---

## 🎨 ADVANCED DATA FLOW

### Three-Level Component Communication

**Level 1: App Component**:

- **Owns** authentication state
- **Provides** handler functions via render props
- **Controls** app-wide authentication behaviour

**Level 2: Auth Component**:

- **Receives** handler functions from App
- **Adds** navigation logic (redirect)
- **Passes** combined functionality to Login

**Level 3: Login Component**:

- **Handles** user input and API calls
- **Calls** provided functions based on API response
- **Triggers** state changes in App component

### Why This Architecture Works

**Separation of concerns**:

- **Login**: Focus on form handling and API communication
- **Auth**: Focus on navigation and flow control
- **App**: Focus on global state management

**Maintainability**:

- **Each component** has clear, single responsibility
- **Easy to modify** any part without affecting others
- **Testable** - each component can be tested independently

---

## 🔍 Outstanding Issues

**Identified problems that need attention**:

**1. Refresh bug**:

- **Problem**: On page refresh, state reverts to "NOT_LOGGED_IN"
- **Cause**: We don't verify existing cookies on app load
- **Solution**: Implement session verification in componentDidMount

**2. Logout functionality**:

- **Missing**: No way to logout
- **Needed**: Destroy session and reset state
- **Implementation**: Logout endpoint + state reset

**3. Complete error handling**:

- **Current**: Basic error handling
- **Improve**: More specific and user-friendly feedback
- **Add**: Loading states during API calls

**Next implementations**:

1. **Session persistence** - maintain login after refresh
2. **Logout functionality** - destroy active sessions
3. **Protected routes** - conditional rendering based on auth status
4. **Navigation updates** - show/hide links based on authentication
5. **Role-based access** - different permission levels

---

## 🎯 EXPECTED RESULTS

- ✅ **Complete communication** App ↔ Auth ↔ Login
- ✅ **Automatic redirection** after successful login
- ✅ **State management** working at application level
- ✅ **Professional patterns** for component communication
- ✅ **Solid foundation** for advanced auth features

**Why this approach is valuable**:

- **Scalable architecture** - easy to add more auth components
- **Professional patterns** - used in enterprise applications
- **Clear data flow** - easy to debug and maintain
- **User experience** - seamless login with automatic redirection

**Well-managed complexity**:

- **Three-level communication** kept organised
- **Each component** has specific and clear purpose
- **Props passing** used effectively for flow control
- **State management** centralised in appropriate component

---
