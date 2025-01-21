# MODULE 01 - 010:	🔍🌎 SCSS Variable Scope
Variable scoping in SCSS is relatively intuitive if you're familiar with how variable scope works in general purpose programming languages. Understanding variable scope is essential for efficient and scalable SCSS development.  
***
### 🤔 What is Variable Scope?

> **Variable scope** sets the access of variables by all components of a program.

- SCSS variable scope allows for flexibility in stylesheets.
- **🌐 Global** variables provide consistency, while **📌Local** variables give control over specific components.  


**Simple Example:**
If you declare a variable like `$master-site-color`, variable scope allows it to be accessed in other parts of the stylesheet, such as inside a paragraph tag.

---
## 📘 **Variable Scope example**

In the example below:

- `$master-site-color` is declared at the top of the stylesheet, making it globally accessible.
- As SCSS is **cascading**, **nested styles override the variable** when re-defined.



```scss
$master-site-color: #3AE39F;
$off-white: #f6f6f6;

body {
  background-color: $off-white;
  height: 100vh;
  height: 100vw;
}
.page-wrapper {
  $master-site-color: DodgerBlue;
  padding: 21px;

  .featured {
    color: $master-site-color;
  }

  .page-content {
    $master-site-color: LightCoral;
    background-color: $master-site-color;
    padding: 42px;
    color: #ffffff;
  }
}

.secondary-page-content {
  color: $master-site-color;
}
```
### ⚡ Observations
*  `.secondary-page-content` class uses the global `$master-site-color`.
* Nested classes (`.featured` and `.page-content`) use locally re-defined variables.

---
## 📘 **Variable Scope example WITH MIXIN**

#### 💡 `Mixin`s can **override variables within their scope.**

```scss
$master-site-color: #3AE39F;
$off-white: #f6f6f6;

@mixin featured-page-content() {
  $master-site-color: LightCoral;
  background-color: $master-site-color;
  padding: 42px;
  color: #ffffff;
}

body {
  background-color: $off-white;
  height: 100vh;
  height: 100vw;
}
.page-wrapper {
  $master-site-color: DodgerBlue;
  padding: 21px;

  .featured {
    $master-site-color: DodgerBlue;
    color: $master-site-color;
  }

  .page-content {
    @include featured-page-content;
  }
}

.secondary-page-content {
  color: $master-site-color;
}
```
### ⚡ Observations
* **Mixin `@include`**  
  When the *@include featured-page-content* is used in `.page-content`, it overrides `$master-site-color` to *LightCoral*.  
* **Global Variables Remain Intact**
  The `.secondary-page-content` class still uses the globally defined `$master-site-color`.
  
***
# Video Lesson Speech
[ENG]  
# MODULE 01 - 010:	SCSS Variable Scope
Variable scoping in SCSS is relatively intuitive if you're familiar with how variable scope works in general purpose programming languages.  
***
If the concept of variable scoping is a little 'blurry', a dead-simple explanation is:  

Variable scope sets the access of variables by all of the components of a program.  

For example, if you have a variable called $master-site-color, and you want to call that color from a different part of the stylesheet, such as a paragraph tag, the variable scope is the programming mechanism that allows for that paragraph tag to have access to the $master-site-color variable.  

# Basic Example of Variable Scope
In the example below, you can see that I've set the $master-site-color variable at the top of the stylesheet. That is the master color and the rest of the stylesheet has access to it. However, given the cascading nature of CSS, each time we re-define the variable, the nested styles that call the variable will use the variable value that is the most closely targeted.  

```scss
$master-site-color: #3AE39F;
$off-white: #f6f6f6;

body {
  background-color: $off-white;
  height: 100vh;
  height: 100vw;
}
.page-wrapper {
  $master-site-color: DodgerBlue;
  padding: 21px;

  .featured {
    color: $master-site-color;
  }

  .page-content {
    $master-site-color: LightCoral;
    background-color: $master-site-color;
    padding: 42px;
    color: #ffffff;
  }
}

.secondary-page-content {
  color: $master-site-color;
}
```

If you notice, the secondary-page-content class is the only page element that uses the variable value declared at the top of the stylesheet. This is because the other classes have more specific variable definitions.  

# Example of SCSS Variable Scope with Mixins

Variable scope is the most critical when it comes to using SCSS mixins. If you have a mixin that re-defines a variable, it will override any previous variable definitions, as shown in the example below:  

```scss
$master-site-color: #3AE39F;
$off-white: #f6f6f6;

@mixin featured-page-content() {
  $master-site-color: LightCoral;
  background-color: $master-site-color;
  padding: 42px;
  color: #ffffff;
}

body {
  background-color: $off-white;
  height: 100vh;
  height: 100vw;
}
.page-wrapper {
  $master-site-color: DodgerBlue;
  padding: 21px;

  .featured {
    $master-site-color: DodgerBlue;
    color: $master-site-color;
  }

  .page-content {
    @include featured-page-content;
  }
}

.secondary-page-content {
  color: $master-site-color;
}
```

---
[SPA]  
```text
El ámbito de las variables (Scope) en SCSS nos permite controlar la visibilidad y accesibilidad de las variables dentro de nuestro código.  
Usamos variables de alcance global (Global scope) para valores que se repiten en todo el sitio y variables de alcance local (Local scope) para estilos específicos de componentes.  
Dominar este concepto es fundamental para desarrollar un código limpio, eficiente y escalable. 
```

