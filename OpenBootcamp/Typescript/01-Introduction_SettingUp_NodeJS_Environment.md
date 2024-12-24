# 🔸 Definitions  
- **TypeScript**:   
As a superset helping language to JavaScript created by Microsoft, simpifies coding and debugging process, by working like *"from TypeScrypt code ... to JavaScipt standarides code"*.
  
### ⚡ Requisites:  
- Node, npm, VScodium.
[Node source](https://github.com/nodesource/distributions?tab=readme-ov-file#installation-instructions)

## 1️⃣ Creating npm container will ask for some data in order to create the .json config:
```bash
$ npm init
```

```text
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

The resulting ~/package.json will be like this:
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

## 2️⃣ Installing nmp dev tools.
```bash
$ npm i --save-dev @types/node nodemon ts-node typescript
```
```text
**OPTIONS**
i: install

**ARGUMENTS**
--save-dev: Dependencies needed IN THE DEVELOPING PROCESS, not in the release build.

**PACKAGES**
@types/node: A specific library for TS using node.
nodemon: Monitorizes and refresh changes.
ts-node: Node bridge for TS without creating a full bundle, for testing/debugging the code.
typescript: TS language core.

rimraf: Generates bundles in a easy way
```

A *node_modules* will be created with all the dependences locally, also with its .json (*package-lock-json*).

## 3️⃣ Executing TS
A *tsconfig.json* needs to be created.

```bash
$ npx tsc --init --rootDir build --esModuleInterop --resolveJsonModule --lib es6 --module commonjs --allowjs true --noImplicitAny true
```
```text
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
```text
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

## 4️⃣ Locating the source code path.
`bash $ mkdir src`

## 5️⃣ Executing our code

1. By adding aliased "scripts" in *packages.json*:
```json
  "scripts": {
    "test": "echo \"Error: no test specified\" && exit 1",
    "tsNode": "cd src && ts-node index.ts",
    "start": "nodemon"
```

2. By creating our own **nodemon.json**
The *nodemon* package previously installed continuosly monitorizes any saved changes, and returns them by using the console, so that its JSON needs to be created.

*nodemon.json* example:
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

## 6️⃣ Creating a build (transpiling the code).
1. By adding a new aliased script, lets alias it as "transpilation" calling to the compiler in *package.json*
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

## 7️⃣ Using *rimraf* to create a build/a bundle:

1. Adding new aliased script to *packages.json*:
```json
  "scripts": {
    ...
    "build:prod": "rimraf ./build && tsc",
    "start:prod": "npm run build:prod && node build/index.js"
```


## Source:
[OpenBootCamp - TypeScript course](https://www.youtube.com/watch?v=RI7j5bicTEw&list=PLkVpKYNT_U9egW5padLMHmnTPb6xm4hLf&index=2)
