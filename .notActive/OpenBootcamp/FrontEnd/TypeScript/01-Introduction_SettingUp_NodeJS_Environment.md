# 01-Introduction\_SettingUp\_NodeJS\_Environment

## TypeScript 01: Introduction / Setting up the IDE

***

### 🔹 Introduction to TypeScript

[TypeScript](https://www.typescriptlang.org/) is a strongly typed superset of JavaScript developed by Microsoft. It enhances JavaScript by adding static types, improving code maintainability, reducing runtime errors, and enabling better development tooling.

TypeScript code is **transpiled** into standard JavaScript using the TypeScript Compiler (`tsc`). This allows TypeScript to work in any JavaScript runtime, including **Node.js**.

***

### Setting Up a TypeScript Environment with Node.js

### ⚡ Prerequisites

Before setting up TypeScript, ensure you have the following installed:

* [**Node.js**](https://nodejs.org/en/download/) (which includes `npm`)
* **A Code Editor** (such as [VS Code](https://code.visualstudio.com/) or [VSCodium](https://vscodium.com/))

To verify your installation:

```bash
$ node -v  # Check Node.js version
$ npm -v   # Check npm version
```

If Node.js is not installed, you can install it from the [NodeSource repository](https://github.com/nodesource/distributions#installation-instructions).

***

### 1️⃣ Initializing a Node.js Project

To start a new project, initialize `npm` to create a `package.json` file:

```bash
$ npm init -y
```

This command generates a default `package.json`, which looks like this:

```json
{
  "name": "typescript-project",
  "version": "1.0.0",
  "description": "Example project using TypeScript",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC"
}
```

***

### 2️⃣ Installing TypeScript and Development Dependencies

Install TypeScript and essential tools as **dev dependencies**:

```bash
$ npm install --save-dev typescript ts-node nodemon @types/node rimraf
```

#### 📌 What These Packages Do:

* **`typescript`** → The TypeScript compiler.
* **`ts-node`** → Enables running TypeScript files directly in Node.js (useful for development & debugging).
* **`nodemon`** → Automatically restarts the app when file changes are detected.
* **`@types/node`** → TypeScript definitions for Node.js, providing autocompletion & type safety.
* **`rimraf`** → A cross-platform tool to delete directories/files (similar to `rm -rf`).

After installation, a `node_modules` directory is created, and `package-lock.json` is updated.

***

### 3️⃣ Initializing TypeScript Configuration

Run the following command to generate a `tsconfig.json` file:

```bash
$ npx tsc --init
```

This file configures TypeScript's behavior. You can customize it, but a typical setup might look like:

```json
{
  "compilerOptions": {
    "target": "ES6",
    "module": "CommonJS",
    "rootDir": "src",
    "outDir": "build",
    "strict": true,
    "esModuleInterop": true,
    "skipLibCheck": true,
    "forceConsistentCasingInFileNames": true
  }
}
```

#### Key Compiler Options:

* **`target`** → Specifies ECMAScript version (`ES6`, `ES2016`, `ESNext`, etc.).
* **`module`** → Defines module system (`CommonJS` for Node.js, `ESNext` for ESM, etc.).
* **`rootDir`** → Defines the source directory for TypeScript files.
* **`outDir`** → Specifies where compiled JavaScript files will be outputted.
* **`strict`** → Enables strict type-checking.
* **`esModuleInterop`** → Improves compatibility with CommonJS and ES modules.

***

### 4️⃣ Setting Up the Project Structure

Create the source directory for your TypeScript files:

```bash
$ mkdir src
$ touch src/index.ts
```

The `src/index.ts` file will be our entry point.

***

### 5️⃣ Running TypeScript Code

To execute TypeScript files without transpiling:

```bash
$ npx ts-node src/index.ts
```

Alternatively, modify `package.json` to include:

```json
  "scripts": {
    "start": "nodemon",
    "dev": "ts-node src/index.ts"
  }
```

Run the script:

```bash
$ npm run dev
```

***

### 6️⃣ Configuring `nodemon` for Auto-reloading

Create a `nodemon.json` file for automatic reloading:

```json
{
  "watch": ["src"],
  "ext": "ts",
  "ignore": [],
  "exec": "ts-node ./src/index.ts"
}
```

Now, start the project with:

```bash
$ npm run start
```

Every time you save a `.ts` file, `nodemon` will restart the project automatically.

***

### 7️⃣ Transpiling TypeScript to JavaScript

To compile TypeScript into JavaScript:

```bash
$ npx tsc
```

This generates JavaScript files in the `build` directory.

To automate transpilation, add a script in `package.json`:

```json
  "scripts": {
    "build": "tsc"
  }
```

Run it with:

```bash
$ npm run build
```

***

### 8️⃣ Automating Production Builds with `rimraf`

To clean old builds before generating a new one:

```json
  "scripts": {
    "clean": "rimraf ./build",
    "build:prod": "npm run clean && tsc",
    "start:prod": "npm run build:prod && node build/index.js"
  }
```

Now, to generate and run a production-ready build:

```bash
$ npm run start:prod
```

***

### 🎯 Summary

✔ **Initialize a project with `npm init`** ✔ **Install TypeScript and necessary tools** ✔ **Configure TypeScript with `tsconfig.json`** ✔ **Run TypeScript with `ts-node` for development** ✔ **Use `nodemon` for automatic restarts** ✔ **Transpile TypeScript using `tsc`** ✔ **Automate builds with `rimraf` and npm scripts**

#### 📌 Official Documentation Links:

* [TypeScript Docs](https://www.typescriptlang.org/docs/)
* [Node.js Docs](https://nodejs.org/en/docs/)
* [npm Docs](https://docs.npmjs.com/)

***

Original Guide:

## 🔸 Definitions

* **TypeScript**:\
  As a superset helping language to JavaScript created by Microsoft, simpifies coding and debugging process, by working like _"from TypeScrypt code ... to JavaScipt standarides code"_.

#### ⚡ Requisites:

* Node, npm, VScodium.[Node source](https://github.com/nodesource/distributions?tab=readme-ov-file#installation-instructions)

### 1️⃣ Creating npm container will ask for some data in order to create the .json config:

```bash
$ npm init
```

```
package name: (typescript) 
version: (1.0.0) 
description: Example project using TS
entry point: (index.js) 
test command: 
git repository: 
keywords:
author:
license:
```

The resulting \~/package.json will be like this:

```json
{
  "name": "typescript",
  "version": "1.0.0",
  "description": "Example project using TS",
  "main": "index.js",
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1"
  },
  "author": "",
  "license": "ISC"
}
```

### 2️⃣ Installing nmp dev tools & TS compiler initialisation

*
  1.  ```bash
      $ npm i --save-dev @types/node nodemon ts-node typescript rimraf
      ```

      ```
      **OPTIONS**
      i: install
      ```

**ARGUMENTS**\
\--save-dev: Dependencies needed IN THE DEVELOPING PROCESS, not in the release build.

**PACKAGES**\
@types/node: A specific library for TS using node.\
nodemon: Monitorizes and refresh changes.\
ts-node: Node bridge for TS without creating a full bundle, for testing/debugging the code.\
typescript: TS language core.

rimraf: Generates bundles in a easy way

````
A *node_modules* will be created with all the dependences locally, also with its .json (*package-lock-json*).  
- 2.  TS compiler init:
`$ npx tsc --init` 


## 3️⃣ Executing TS
A *tsconfig.json* needs to be created.

```bash
$ npx tsc --init --rootDir build --esModuleInterop --resolveJsonModule --lib es6 --module commonjs --allowjs true --noImplicitAny true
````

```
**BIN**
npx:

**OPTIONS**
tsc:   The TS compiler/transpilation tool.

**ARGUMENTS**
--init:  Initializes the environment options.
--rootDir:  On which dir will be generate the builds.
--esModuleInterop:  
--resolveJsonModule:
--lib:  Which libraries we're going to use.
--module:
--allowjs:
--noImplicitAny: When true, *any* variable type won't be allowed.
```

It will return:

```
Created a new tsconfig.json with: TS                                              

  target: es2016
  module: commonjs
  lib: es6
  rootDir: build
  strict: true
  esModuleInterop: true
  skipLibCheck: true
  forceConsistentCasingInFileNames: true
```

### 4️⃣ Locating the source code path.

`bash $ mkdir src`

### 5️⃣ Executing our code

1.  By adding aliased "scripts" in _packages.json_:

    ```json
    "scripts": {
     "test": "echo \"Error: no test specified\" && exit 1",
     "tsNode": "cd src && ts-node index.ts",
     "start": "nodemon"
    ```
2. By creating our own **nodemon.json**\
   The _nodemon_ package previously installed continuosly monitorizes any saved changes, and returns them by using the console, so that its JSON needs to be created.

_nodemon.json_ example:

```json
{
    "watch": ["src"],
    "ext": ".ts",
    "ignore": [],
    "exec": "ts-node ./src/index.ts"
}
```

Then, our code can be tested by running our aliased script onto npm like this;

```bash
$ npm run start
```

### 6️⃣ Creating a build (transpiling the code).

1.  By adding a new aliased script, lets alias it as "transpilation" calling to the compiler in _package.json_

    ```json
     "scripts": {
       "test": "echo \"Error: no test specified\" && exit 1",
       "tsNode": "cd src && ts-node index.ts",
       "start": "nodemon",
       "transpilation": "tsc"
    ```

    ```bash
    $ npm run transpilation"
    > typescript@1.0.0 transpilation
    > tsc
    ```

    No messages means a good compilations with no erros.

### 7️⃣ Using _rimraf_ to create a build/a bundle:

1.  Adding new aliased script to _packages.json_:

    ```json
    "scripts": {
     ...
     "build:prod": "rimraf ./build && tsc",
     "start:prod": "npm run build:prod && node build/index.js"
    ```

### Source:

[OpenBootCamp - TypeScript course](https://www.youtube.com/watch?v=RI7j5bicTEw\&list=PLkVpKYNT_U9egW5padLMHmnTPb6xm4hLf\&index=2)
