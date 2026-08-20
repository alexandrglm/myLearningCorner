# 07-010: React Portfolio 5 - STATIC Directory

**1. Single Page Application**: React uses **a SINGLE HTML file** as entry point - everything is dynamically injected into the `.app-wrapper` div.

**2. static/ structure**:

- **assets/**: Static images (logos, not user uploads)  
- **favicon.ico**: Browser icon (tab)  
- **index.html**: **Critical entry point** of the entire app  

⚠️ Important directives:

- **Modify `<title>`** in index.html with your portfolio name  
- **Do NOT confuse** page content (components) with metadata (index.html)  
- **Assets**: Only for permanent static resources, not dynamic content  

Crucial difference:

- Title in `index.html` = metadata/browser tab  
- Content in `App.js` = what the user sees on screen  

**Result**: A single HTML page that React "dynamically fills" versus multiple traditional HTML pages.
