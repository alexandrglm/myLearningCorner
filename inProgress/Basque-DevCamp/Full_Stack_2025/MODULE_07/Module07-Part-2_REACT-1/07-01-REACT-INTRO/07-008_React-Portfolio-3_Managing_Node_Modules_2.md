# 07-008: Alternative Method to Install Dependencies

**Automatic method** (preferred):

```bash
npm i <module name>
```


**Advantages compared to manual method**:

- Installs the latest version automatically  
- Updates `package.json` automatically   
- Sorts dependencies alphabetically  
- Faster  

**Exercise**: Remove moment from `package.json` → `npm install` → Reinstall with `npm i moment`

**Conclusion**: `npm i [package]` is the standard method for daily development.

## NOTE. Don't do it, unless you want it to install the latest moment available in 2025!!!
Use `npm install <module name>:x.x # With --save or --save-dev` instead.
