# MODULE 01 - 010:   🎨 **SCSS Variables (ii)**
Variable scoping in Scss is relatively intuitive if you're familiar with how variable scope works in general purpose programming languages.  
***

***
# Video Lesson Speech
[ENG]  
# MODULE 01 - 010:	SCSS Variable Scope
Variable scoping in Scss is relatively intuitive if you're familiar with how variable scope works in general purpose programming languages.  
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

# Example of Scss Variable Scope with Mixins

Variable scope is the most critical when it comes to using Scss mixins. If you have a mixin that re-defines a variable, it will override any previous variable definitions, as shown in the example below:  

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
