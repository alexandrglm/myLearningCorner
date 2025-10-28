# 08-078 - Implementing Logout Handler App Component

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/implementing-logout-handler-app-component)**

[SOURCE](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/5a03a871572c623bdbecce68dbb1d9345bb004e8)

---

**Preparatory logout handler**:

- **handleSuccessfulLogout()** - method to change state to NOT_LOGGED_IN
- **Props passing** - send handler to NavigationContainer
- **Correct binding** - ensure 'this' context in method
- **Preparation** for High Order Component pattern (next guide)

**Scope**: Only prepare handler in App component - full implementation comes later

---

## 🛠️ STEP-BY-STEP IMPLEMENTATION

### 1. Create Handler Method

**In `app.js`**:

```javascript
export default class App extends Component {
    constructor(props) {
        super(props);

        this.state = {
            loggedInStatus: "NOT_LOGGED_IN"
        };

        this.handleSuccessfulLogin = this.handleSuccessfulLogin.bind(this);
        this.handleUnsuccessfulLogin = this.handleUnsuccessfulLogin.bind(this);
        this.handleSuccessfulLogout = this.handleSuccessfulLogout.bind(this);
    }

    /* componentDidMount and other methods... */

    handleSuccessfulLogin() {
        this.setState({
            loggedInStatus: "LOGGED_IN"
        });
    }

    handleUnsuccessfulLogin() {
        this.setState({
            loggedInStatus: "NOT_LOGGED_IN"
        });
    }

    handleSuccessfulLogout() {
        this.setState({
            loggedInStatus: "NOT_LOGGED_IN"
        });
    }

    /* authorizedPages() and other methods... */
}
```

### 2. Pass Handler as Prop

**Modify NavigationContainer props**:

```javascript
render() {
    return (
        <div className="container">
            <Router>
                <div>
                    <NavigationContainer 
                        loggedInStatus={this.state.loggedInStatus}
                        handleSuccessfulLogout={this.handleSuccessfulLogout}
                    />

                    <Switch>
                        {/* Rest of routes... */}
                    </Switch>
                </div>
            </Router>
        </div>
    );
}
```

### 3. Verify Complete Binding

**Constructor with all bindings**:

```javascript
constructor(props) {
    super(props);

    this.state = {
        loggedInStatus: "NOT_LOGGED_IN"
    };

    // All necessary bindings
    this.handleSuccessfulLogin = this.handleSuccessfulLogin.bind(this);
    this.handleUnsuccessfulLogin = this.handleUnsuccessfulLogin.bind(this);
    this.handleSuccessfulLogout = this.handleSuccessfulLogout.bind(this);
}
```

---

## 🔧 TECHNICAL CONCEPTS

### Method Binding in React Class Components

**Why binding is necessary**:

```javascript
// Without binding - 'this' is undefined
this.handleSuccessfulLogout = this.handleSuccessfulLogout;

// With binding - 'this' points to component instance
this.handleSuccessfulLogout = this.handleSuccessfulLogout.bind(this);
```

**Context lost**: In JavaScript, when you pass a method as callback, it loses reference to the original object

### Function as Props Pattern

**Communication flow**:

```
App Component (handleSuccessfulLogout)
    ↓ (props)
NavigationContainer 
    ↓ (props.handleSuccessfulLogout)
Logout button onClick
    ↓ (function call)
App state updated (NOT_LOGGED_IN)
```

**Pattern advantages**:

- **Separation of concerns** - state logic in App, UI in Navigation
- **Reusability** - handler can be used by multiple components
- **Single source of truth** - loggedInStatus only exists in App

### State Management Flow

**Logout lifecycle**:

1. **User clicks** logout button (next guide)
2. **API call** executes to invalidate session
3. **Success callback** calls `props.handleSuccessfulLogout()`
4. **State update** changes `loggedInStatus` to "NOT_LOGGED_IN"
5. **Re-render cascade** - all components depending on loggedInStatus update

### Symmetry in Handler Design

**Consistent pattern**:

```javascript
// Login success
handleSuccessfulLogin() {
    this.setState({ loggedInStatus: "LOGGED_IN" });
}

// Login failure  
handleUnsuccessfulLogin() {
    this.setState({ loggedInStatus: "NOT_LOGGED_IN" });
}

// Logout success
handleSuccessfulLogout() {
    this.setState({ loggedInStatus: "NOT_LOGGED_IN" });
}
```

**Consistency benefits**: Same structure, easy to understand and maintain

---

## ✔️ VERIFICATION

### Testing Props Passing

**Verify in NavigationContainer**:

```javascript
// In navigation-container.js - add temporarily for testing
const NavigationComponent = props => {
    console.log("Props received:", props);
    // Should show: loggedInStatus and handleSuccessfulLogout

    /* rest of component... */
};
```

### DevTools Props Inspection

**React Developer Tools**:

1. **Install** React DevTools browser extension
2. **Open** DevTools → Components tab
3. **Select** NavigationContainer component
4. **Verify** props: `loggedInStatus` and `handleSuccessfulLogout` present

### Function Reference Testing

**Verify correct binding**:

```javascript
// In NavigationContainer - temporary testing
const NavigationComponent = props => {
    const testLogout = () => {
        console.log("Logout function:", typeof props.handleSuccessfulLogout);
        // Should print: "function"
    };

    /* rest of component... */
};
```

---

## 🚀 EXTENDED CONTENT

### High Order Component Pattern

- **HOC concept** - components that take other components as arguments
- **withAuth HOC** - wrapper for logout functionality
- **Advanced React patterns** - composition vs inheritance
- **Logout button implementation** - UI + API call + handler connection

### Complete Logout Roadmap

**Full flow we will implement**:

1. ✅ **Handler ready** - App component prepared (this guide)
2. 🔄 **HOC pattern** - High Order Component for logout
3. 🔄 **API integration** - axios call to logout endpoint
4. 🔄 **UI implementation** - logout button in navigation
5. 🔄 **UX polish** - visual feedback during logout process

---

### Alternative Implementation Patterns

**Hook-based approach** (React 16.8+):

```javascript
// In functional component with hooks
const useAuth = () => {
    const [loggedInStatus, setLoggedInStatus] = useState("NOT_LOGGED_IN");

    const handleSuccessfulLogout = useCallback(() => {
        setLoggedInStatus("NOT_LOGGED_IN");
    }, []);

    return { loggedInStatus, handleSuccessfulLogout };
};
```

### Context API Pattern

**Global state management**:

```javascript
// AuthContext.js
const AuthContext = createContext();

export const AuthProvider = ({ children }) => {
    const [loggedInStatus, setLoggedInStatus] = useState("NOT_LOGGED_IN");

    const handleSuccessfulLogout = () => {
        setLoggedInStatus("NOT_LOGGED_IN");
    };

    return (
        <AuthContext.Provider value={{ loggedInStatus, handleSuccessfulLogout }}>
            {children}
        </AuthContext.Provider>
    );
};
```

---

## 🔄 ARCHITECTURE REVIEW

### State Flow Architecture

**Current implementation**:  

```
App (state owner)
  ├── NavigationContainer (props consumer)
  ├── Auth (props consumer) 
  └── Protected Routes (state dependent)
```

**Benefits**:  

- **Centralised state** - single source of truth
- **Props drilling** - explicit dependencies
- **Predictable updates** - clear data flow

### Why This Foundation Matters

- **HOC compatibility** - handlers ready for wrapping
- **Testing ready** - isolated, pure functions
- **Scalable** - easy to add more auth-related handlers

**React fundamentals reinforced**:

- ✅ **Method binding** - context preservation
- ✅ **Props passing** - parent-child communication
- ✅ **State management** - controlled updates
- ✅ **Function composition** - building for reusability

---
