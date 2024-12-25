# SESSION #3  FUNCTIONS  

Abstract:

* Functions
* Variable Scooping
* JSDoc. Documening the code in a proper way.
* Parsing objects as arguments, different ways
* Types. Creating object types.


# 🔸 TS Best Practices (2) ✅✅✅

### ✅ Code is easy to be understood:
- By giving self-explicative names to vars, functions, ...  
- By using **JSDoc** method:  
```ts
/**
 * 
 * @param ${var_name} Here goes the explanation
 */
```
  
### ✅ Code is extremely explicit even the redundance:  
- *Any* data type is not explicitly nor implicitly used.  

✅ CORRECT:
```ts
let correctWay: string = `It has to be a string. Another data type will cause errors`;
```

❌ WRONG:
```ts
let wrongWay = `This lets implicetely ANY type and will bring a lot of errors, warnings, breakpoints... Avoid it`
```

### ✅ Var, values, params., functions,... anything follows a clear way to be named.
```text
This is **camelCase** typing ✅  
And this is **snake_Case** typing ✅ 

But this is **aproblematicwayoftypingtobeavoided** ❌
```
	

