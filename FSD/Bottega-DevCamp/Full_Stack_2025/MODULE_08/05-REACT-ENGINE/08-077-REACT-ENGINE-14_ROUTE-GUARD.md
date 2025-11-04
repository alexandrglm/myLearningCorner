# 08-077 - Building Route Guard React

Guide: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/building-route-guard-react

[SOURCE](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/2bbc44f43299fb12f13857c1a0f468582ebb8aba)

---

## 🎯 OBJECTIVES

**Complete route protection**:

- **Route guard** - routes don't exist if user not logged in
- **authorizedPages()** method - array of protected routes
- **Conditional route rendering** - ternary operator in Switch component
- **Real security** - not just hiding links but removing routes from DOM

**Complement**: Part 2 of 2 - complete protection started in previous guide

---

## 🛠️ STEP-BY-STEP IMPLEMENTATION

### 1. Create authorizedPages() Method

**In `app.js`**:

```javascript
export default class App extends Component {
    constructor(props) {
        super(props);

        /* State and bindings... */
    }

    /* componentDidMount and other methods... */

    authorizedPages() {
        return [
            <Route key="blog" path="/blog" component={Blog} />
        ];
    }

    /* Rest of methods... */

    render() {
        /* Rest of render... */
    }
}
```

### 2. Implement Route Guard in Switch

**Modify the Switch component**:

```javascript
render() {
    return (
        <div className="container">
            <Router>
                <div>
                    <NavigationContainer loggedInStatus={this.state.loggedInStatus} />

                    <Switch>
                        <Route exact path="/" component={Home} />
                        <Route path="/about-me" component={About} />
                        <Route path="/contact" component={Contact} />

                        {/* Route guard implementation */}
                        {this.state.loggedInStatus === "LOGGED_IN" ? (
                            this.authorizedPages()
                        ) : null}

                        <Route
                            path="/portfolio/:slug"
                            component={PortfolioDetail}
                        />
                        <Route
                            path="/auth"
                            render={props => (
                                <Auth
                                    {...props}
                                    /* Auth props... */
                                />
                            )}
                        />
                        <Route component={NoMatch} />
                    </Switch>
                </div>
            </Router>
        </div>
    );
}
```

### 3. Add Key Props (Best Practice)

**Avoid React warnings**:

```javascript
authorizedPages() {
    return [
        <Route key="blog" path="/blog" component={Blog} />,
        // Future protected routes:
        // <Route key="portfolio-manager" path="/portfolio-manager" component={PortfolioManager} />,
        // <Route key="blog-manager" path="/blog-manager" component={BlogManager} />
    ];
}
```

---

## 🔧 TECHNICAL CONCEPTS

### Route Guard Pattern

**Fundamental concept**:

- **Conditional routing** - routes exist or not based on state
- **Runtime generation** - Switch component receives dynamic array
- **Security by absence** - route doesn't exist in DOM if unauthorised

### Array Spreading in JSX

**How array return works**:

```javascript
// authorizedPages() returns:
[<Route .../>, <Route .../>, <Route .../>]

// JSX interprets as:
<Route .../>
<Route .../>
<Route .../>
```

**React automatically** "unpacks" the array within Switch

### Method vs Function Component Pattern

**Why class method**:

- **Access to this.state** - needed to verify loggedInStatus
- **Reusability** - easy to add more protected routes
- **Consistency** - same pattern as other component methods

### Conditional Rendering vs Route Guards

**Conceptual differences**:

**Conditional rendering** (previous guide):

- **UI layer** - hides visual elements
- **Link still accessible** - direct URL still works
- **Client-side only** - doesn't prevent direct access

**Route guards** (this guide):

- **Router layer** - removes route definition
- **Complete protection** - direct URL returns NoMatch (404)
- **True security** - route doesn't exist in application

---

## ✔️ VERIFICATION

### Testing Route Guard

**Scenario 1: User NOT logged in**:

1. **Open incognito browser** (NOT_LOGGED_IN state)
2. **Navigate to** `localhost:3000/blog`
3. **Expected result**: NoMatch page (404)
4. **Verify**: "Couldn't find that page" appears

**Scenario 2: User logged in**:

1. **Navigate to** `/auth`
2. **Perform successful** login
3. **Navigate to** `/blog`
4. **Expected result**: Blog page loads normally

### ⚠️ Complete Security Verification

**Before this guide**:

- ❌ Link hidden, but `/blog` URL accessible directly

**After this guide**:

- ✅ Link hidden AND `/blog` URL returns 404
- ✅ Route doesn't exist in DOM for unauthorised users
- ✅ Impossible to "hack" access via direct URL

### DevTools Network Tab

**Technical verification**:

1. **Open DevTools** → Network tab
2. **NOT_LOGGED_IN**: Navigate to `/blog`
3. **Verify**: No requests to Blog component
4. **Confirm**: NoMatch component renders

---

## 🚀 EXTENDED CONTENT

### Advanced Route Guard Patterns

**Role-based routing**:

```javascript
adminPages() {
    return [
        <Route key="admin-dashboard" path="/admin" component={AdminDashboard} />,
        <Route key="user-management" path="/users" component={UserManagement} />
    ];
}

moderatorPages() {
    return [
        <Route key="content-moderation" path="/moderate" component={ContentModeration} />
    ];
}

render() {
    return (
        <Switch>
            {/* Public routes */}

            {this.state.loggedInStatus === "LOGGED_IN" && this.authorizedPages()}
            {this.state.userRole === "ADMIN" && this.adminPages()}
            {this.state.userRole === "MODERATOR" && this.moderatorPages()}

            <Route component={NoMatch} />
        </Switch>
    );
}
```

### Error Boundaries for Route Guards

**Robust error handling**:

```javascript
authorizedPages() {
    try {
        return [
            <Route key="blog" path="/blog" component={Blog} />
        ];
    } catch (error) {
        console.error("Error rendering authorised pages:", error);
        return [];
    }
}
```

---

## 🔐 SECURITY ARCHITECTURE

### Implemented Protection Layers

**Layer 1: Visual** (previous guide)

- ✅ Links hidden based on `loggedInStatus`
- ✅ Consistent UX with user permissions

**Layer 2: Router** (this guide)  

- ✅ Routes don't exist if user unauthorised
- ✅ Direct URLs return 404 for protected content

**Layer 3: API** (future guides)

- 🔄 Protected endpoints with authentication tokens
- 🔄 Server-side permission validation

### Security Best Practices

**Defence-in-depth principle**:

- **Never trust client** - always validate on server
- **Multiple layers** - UI + Router + API protection
- **Fail secure** - default to "no access" when uncertain

---
