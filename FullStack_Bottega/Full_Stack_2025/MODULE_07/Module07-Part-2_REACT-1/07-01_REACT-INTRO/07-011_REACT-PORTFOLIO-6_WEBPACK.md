# 07-011: Webpack Directory and Its Role in React

**Key concepts**:

1. Webpack = Bundler: Not React-specific, also used in Vue/Angular.

2. webpack/ structure:

- `common.config.js`: Rules for all environments  
- `dev.config.js`: Local development only  
- `prod.config.js`: Production/server only  
- `postcss.config.js`: CSS processing  

3. Main functions:

- Entry point: Defines `/src/bootstrap.js` as app start  
- File loaders: Handles JS (babel), images, videos, SCSS  
- Performance: Splits app into chunks - loads only what's needed  
- Dependencies: Points to node_modules  

4. static/assets/: For static images (logos, not uploads)

⚠️ Directives:

- DO NOT touch webpack files during the course  
- Just know WHAT it does, not HOW it works  
- Configuration already optimised in the template  

**Result**: System that converts modern code → browser-compatible + automatic optimisation.
