# 09-096 - Installing React Dropzone Component and Performing Security Audit

---

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/installing-react-dropzone-component-performing-security-audit-fix)

[GitHub - jordanhudgens/jordan-hudgens-react-portfolio at 2f67cabc131bf819221b5b378bea1ed7d12c9ab2](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/2f67cabc131bf819221b5b378bea1ed7d12c9ab2)

---

## 🎯 OBJECTIVES

**Prepare image upload system**:

- **Install React Dropzone Component** for drag & drop functionality
- **Differentiate between libraries** - Dropzone vs React Dropzone vs React Dropzone Component
- **Security audit workflow** - identify and resolve vulnerabilities
- **NPM security best practices** - proactive dependency auditing
- **Post-installation testing** - verify application still works

**Professional development skills**:

- Correct selection of third-party libraries
- Management of security vulnerabilities in dependencies
- Testing workflow after updates

---

## 🛠️ IMPLEMENTATION

### 1. Understanding Dropzone Ecosystem

**Available options**:

- **Dropzone.js**: Vanilla JavaScript library (not React-specific)
- **React Dropzone**: Popular React component
- **React Dropzone Component**: Wrapper component-based (our choice)

**Why React Dropzone Component?**:

- **Component-based approach** - easier integration
- **Better abstractions** - less manual configuration
- **Author preference** - tested in multiple projects
- **Good community support** on NPM

### 2. Install React Dropzone Component

**Installation command**:

```bash
npm i react-dropzone-component
```

**Verify installation in package.json**:

```json
{
  "dependencies": {
    "react-dropzone-component": "^3.x.x",
    // ... other dependencies
  }
}
```

### 3. NPM Security Audit Process

**Watch for warnings during installation**:

```bash
# Typical output after install
added X packages from Y contributors and audited Z packages in Ns
found 1 high severity vulnerability
  run `npm audit` for details
```

**Run audit for details**:

```bash
npm audit
```

**Expected output**:

```bash
# High severity vulnerability found in:
webpack-dev-server
Path: webpack-dev-server
More info: https://npmjs.com/advisories/xyz
```

### 4. Resolve Security Vulnerabilities

**Run audit fix**:

```bash
npm audit fix
```

**Process that occurs**:

1. **NPM identifies** vulnerable packages
2. **Searches for patches** in registry
3. **Updates to secure** compatible versions
4. **Maintains compatibility** with existing code
5. **Updates package-lock.json** with new versions

---

## 🔧 CONCEPTS

### What is a Security Vulnerability?

**Example: webpack-dev-server missing origin validation**:

- **Problem**: Server doesn't validate request origin
- **Risk**: Potential for malicious requests
- **Impact**: Mainly development, no production impact
- **Severity**: High (but context matters)

**Why not critical in our case?**:

- **Development only**: webpack-dev-server runs locally only
- **No production usage**: build process uses different tools  
- **Local environment**: no external access by default

### NPM Audit System

**How auditing works**:

```bash
npm audit          # Shows found vulnerabilities
npm audit --json   # Outputs in JSON format
npm audit fix      # Automatically updates vulnerable packages
npm audit fix --force  # Forces updates (breaking changes possible, BE CAREFUL)
```

**Severity levels**:

- **Critical** - Immediate action required
- **High** - Action required soon
- **Moderate** - Consider fixing
- **Low** - Monitor but not urgent

### Security Best Practices

**When to do audit fix?**:

- **Immediately after** npm install
- **Before important** commits
- **Regularly** (weekly/monthly)
- **Before deployment** to production

**Why fix proactively?**:

- **Security protection** - obvious but important
- **Avoid dependency hell** - more time = more conflicts
- **Easier updates** - incremental vs massive changes
- **Team consistency** - everyone with same secure versions

### Differences between Dropzone Libraries

**Dropzone.js (vanilla)**:

```javascript
// Requires manual DOM manipulation
var myDropzone = new Dropzone("#my-awesome-dropzone", { 
  url: "/file/post" 
});
```

**React Dropzone**:

```javascript
// Hook-based approach
import {useDropzone} from 'react-dropzone'
const {getRootProps, getInputProps} = useDropzone()
```

**React Dropzone Component**:

```javascript
// Component-based (our choice)
import DropzoneComponent from 'react-dropzone-component'
<DropzoneComponent config={componentConfig} />
```

---

## ✔️ VERIFICATION

### Post-Installation Testing

**Critical testing workflow**:

1. **Stop development** server (Ctrl+C)
2. **Restart server**:
   
   ```bash
   npm run start
   ```
3. **Verify compilation** successful
4. **Test key functionality**:
   - Navigate to portfolio-manager
   - Verify form still works  
   - Check sidebar rendering
   - Submit test form

### Expected Behaviour

**✅ Everything should continue working**:

- Server starts without errors
- React app compiles successfully  
- Form submission works
- Sidebar updates correctly
- No console errors in browser

**❌ Red flags if something breaks**:

- Compilation errors
- Runtime errors in browser
- Form functionality broken
- Missing dependencies errors

### Verify Security Fix

**Confirm vulnerability resolved**:

```bash
npm audit
```

**Expected output**:

```bash
found 0 vulnerabilities
```

**If issues remain**:

```bash
npm audit fix --force  # Only if necessary!
```

### Package.json Updates

**Verify changes**:

1. **react-dropzone-component** added to dependencies
2. **Version numbers** updated by audit fix
3. **package-lock.json** modified (contains exact versions)

### Testing Development Workflow

**Verify development experience**:

1. **File watching** - changes auto-reload
2. **Hot reloading** works correctly
3. **Console logging** without new warnings
4. **Performance** - startup time reasonable

---
