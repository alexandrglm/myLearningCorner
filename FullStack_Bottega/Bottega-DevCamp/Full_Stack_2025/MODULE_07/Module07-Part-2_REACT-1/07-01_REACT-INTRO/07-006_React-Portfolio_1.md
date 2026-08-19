# Creating the React Portfolio Project

Step-by-step process:

- Use js-generate → select react-redux-router (important: not react-bootstrap)  
- Name the project: your-name-react-portfolio  
- npm install for dependencies  
- npm run start → server at localhost:3000  

⚠️ Important precautions:

- Specific template: Use react-redux-router, not others  
- Mandatory fix: Before npm install, run:
```bash
npm uninstall node-sass
npm install sass
```

- Auto-refresh: The server reloads automatically when saving changes  
- Thousands of dependencies: node_modules is created with many libraries  

⚠️ LAST MODIFICATION

To avoid errors with limited system watchers, we must make a small change in packages.json:

In the scripts key, modify start to add:

`CHOKIDAR_USEPOLLING=true` before the full webpack-dev-server command

```
"scripts": {
"preinstall": "npm set audit false",
"start": "CHOKIDAR_USEPOLLING=true webpack-dev-server --config webpack/dev.config.js --watch",

``` 


**Methodology**: Follow the same Trello process for all projects (wireframes → sitemap → user stories → UML → designs).

**Result**: Complete React+Redux+Router base ready for portfolio development.




