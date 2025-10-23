# 07-016: Procfile, README.md, and server.js

**README.md**:

- Documentation in Markdown (# = H1, * = italic)  
- Change title to: "Your Name React Portfolio Application"  
- Remove placeholder content  

Up to this point, we know well what a README is.

---

**Procfile**:

- One line: `web: node server.js`  
- Function: Declares server type for **deployment on Heroku**  
- DO NOT touch - already configured  

---

**server.js** (most important):

- Express server for production  
- Dynamic port for live server  
- Serves from `/dist` (compiled/minified code, not `/src`)  
- Critical routing fix: Redirects ALL routes → `index.html`  

⚠️ Problem solved by server.js:  
Without this fix, URLs like `/portfolio` or `/blog` would give **404 in production** (work locally but not on the server).

**Process**:

1. `npm run build` → compiles `/src` → `/dist`  
2. Babel converts + minifies code  
3. server.js serves from `/dist`  
4. All routes → `index.html` (SPA behaviour)  

**Result**: Automatic deployment working on Heroku without additional configuration.
