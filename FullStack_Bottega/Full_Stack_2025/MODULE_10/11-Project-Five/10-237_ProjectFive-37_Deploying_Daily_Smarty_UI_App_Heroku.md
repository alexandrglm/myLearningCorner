# 10-237: Deploying Daily Smarty UI App Heroku

---
**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/deploying-daily-smarty-ui-app-heroku)**
---

🎯 **IMPORTANT**: This guide fakes the APIs at the indicated addresses for ProjectFive-37.

---

## 🛠️ Pre-Deploy Setup

### 1. Production Build

```bash
npm run heroku-postbuild
```

**In package.json exists**:
```json
{
  "scripts": {
    "heroku-postbuild": "npm run build"
  }
}
```

---

## 🚀 Deploy to Heroku

### 1. Install Heroku CLI

**Mac**:
```bash
brew install heroku/brew/heroku
```

**Windows/Linux**: Download installer from [heroku.com](https://www.heroku.com)

### 2. Login to Heroku

```bash
heroku login
```

### 3. Create App on Heroku

**Web Dashboard**:
1. Go to heroku.com
2. New → Create new app
3. App name: `your-app-name-unique`
4. Create app

### 4. Configure Git Remote

```bash
heroku git:remote -a your-app-name-unique
```

### 5. Verify Remotes

```bash
git remote
# output: origin, heroku

git remote get-url origin  # GitHub repo
git remote get-url heroku  # Heroku repo
```

### 6. Deploy

```bash
git push heroku master
```

---

## 🔧 Verification

### App URL
```
https://your-app-name.herokuapp.com
```

### Testing
1. **Homepage** - logo, search works
2. **Search results** - API calls work
3. **Mobile responsive** - results page responsive
4. **No post links** - message appears correctly

---

## ✅ App Completed

**Deployed features**:
- ✅ Search functionality
- ✅ Results display
- ✅ Link parsing
- ✅ Responsive design (results)
- ✅ API integration
- ✅ Professional styling

---
