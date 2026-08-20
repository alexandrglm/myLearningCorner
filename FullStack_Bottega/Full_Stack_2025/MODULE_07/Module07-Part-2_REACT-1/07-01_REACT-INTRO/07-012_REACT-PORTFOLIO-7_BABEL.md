# 07-012: What is Babel?

**Core concept**: Babel is a **JavaScript compiler** that converts modern code → compatible code for all browsers.

**Conversion examples**:

- Arrow functions `=>` → `function()`  
- `const` → `var`  
- Destructuring (4 lines) → complex function (13+ lines)  

**`.babelrc` file**:

- Hidden configuration file (dot file + rc = config)  
- Defines **presets**: `env` (modern JavaScript) + `react` (JSX syntax)  

⚠️ Important concepts:

- Without Babel: You would have to write verbose compatible code manually  
- With Babel: You write modern code, it gets converted automatically  
- Presets: Define which modern syntax you can use  

**Result**: You can use modern React syntax without worrying about browser compatibility.

**Directive**: Understand WHAT Babel does; you do not need to modify the configuration.
