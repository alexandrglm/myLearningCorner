# 10-178: Heroku Deployment for React Applications

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/heroku-deployment-react-js-applications)**
https://github.com/jordanhudgens/jordan-hudgens-react-portfolio
https://devcenter.heroku.com/articles/heroku-cli

---

## 🎯 Objectives

**Deploy React app to production**:
- **Heroku setup** - create app and deployment
- **DevCamp Space whitelist** - add production URL
- **Production build** - webpack compilation process

---

## 🛠️ Prerequisites

### Required Accounts & Tools
1. **GitHub account** - code in repository
2. **Heroku account** - hosting platform  
3. **Heroku CLI** - command line tool installed
4. **Git commits** - all code committed and pushed

### Version Fix (If there are errors)
```json
{
    "@fortawesome/fontawesome-svg-core": "6.1.1",
    "@fortawesome/free-solid-svg-icons": "6.1.1", 
    "babel-core": "6.26.3"
}
```

---

## 🛠️ Deployment Steps

### 1. Create Heroku Application

```bash
heroku create your-unique-app-name
```

**Naming tips**:
- **Must be globally unique** - use initials prefix
- **Example**: `jdh-bottega-react-portfolio`

### 2. Whitelist Production URL

**DevCamp Space Dashboard**:
1. **Copy Heroku app URL** - `https://your-app.herokuapp.com`
2. **Add to whitelist** - paste without trailing slash
3. **Click add (+)** - authorise domain

### 3. Deploy to Heroku

```bash
git push heroku master
```

**Production build process**:
- **Babel compilation** - JSX → JavaScript
- **Webpack bundling** - minification and optimisation  
- **Dist directory** - browser-ready files
- **Automatic scripts** - postinstall, build, heroku-postbuild

---

## 📧 Concepts

### Development vs Production

**Development**:
- **Live compilation** - webpack-dev-server
- **Source maps** - debugging friendly
- **Hot reloading** - instant updates

**Production**:  
- **Static files** - pre-compiled bundle
- **Minified code** - optimised size
- **No live compilation** - served as static assets

### Cookie-Based Auth

**Automatic login**:
- **DevCamp Space cookie** - shared domain authentication
- **Logged into DevCamp** → **Auto-logged into portfolio**
- **Incognito mode** → **No automatic login**

---

## 📋 Verification

**Testing deployment**:
1. **Visit Heroku URL** - app loads correctly
2. **Navigation works** - all routes functional
3. **API calls work** - portfolio items display
4. **Authentication** - login functionality
5. **All features** - filtering, detail pages, etc.

---

---

## 🎉 React Course 1, Complete!
