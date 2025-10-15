# 07-014: **package.json in React Applications**

**⚠️ Mandatory Changes**:

* **name**: `"your-name-react-portfolio"`
* **description**: `"Personal portfolio app built in React"`
* **author**: Your name

**Important Scripts**:

* `start`: Development server (webpack-dev-server)
* `build`: Production build
* `heroku-postbuild`: Automatic deployment on Heroku

**Port Configuration**: The `env.js` / `env.example.js` files allow you to change the port (default 3000) to avoid conflicts between apps.

**Dependencies vs DevDependencies**:

* **dependencies**: Libraries required in production
* **devDependencies**: Only for local development

**JSON Concepts**:

* Always use **double quotes**
* **No trailing commas** at the end of lists
* **Strict syntax** – errors will break the app

**Metadata**: repository, keywords, bugs, homepage – for SEO and GitHub.

**Directive**: Update personal metadata but maintain the script structure.
