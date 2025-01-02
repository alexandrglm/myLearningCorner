# 2nd Session - *JAVA Functions*:

### What's a function?
A piece of code logic, reusable.  
Java (coding, in general) needs variables to work. When variables are declared, then, they need to get worked by functions.  
  



### How to declare (and to use) a function?
Typicall function structure:
```java
package com.example;

public class Functions {

    public static void main(String[] args) {

        System.out.println("Welcome to this e-commerce menu:");
        System.out.println("1 - Look the catalog");
        System.out.println("2 - Buy");
        System.out.println("3 - Exit");

    }

    /*
    Function callbakc starts with the same
    datatype used when the functions was initialised.
    Example given here, a void.
    */
    void showMenu();
```

### Function callbacks  

#### CASE 1: "No Params - No return" function type  
```java
         // 1:   "No Params - No return" function type
        showMenu();
     }
     /**
     * // 1:   "No Params - No return" function type
     * static needed
     * void: no return
     */
    static void showMenu() {
        System.out.println("Welcome to this e-commerce menu:");
        System.out.println("1 - Look the catalog");
        System.out.println("2 - Buy");
        System.out.println("3 - Exit");
    }
 ```
#### CASE 2:  "No params - W/return" function type  
```java
        // 2:   "No params - W/return" function type
        System.out.println(getMenu());

        String menu = getMenu();
        System.out.println(menu);

        double price = getPrice();
        System.out.println(price);


    }
    
    // 2:   "No params - W/return" function type
        
        
    static double getPrice() {
        return 100.99;
    }
        
    static String getMenu() {
        System.out.println("invoking by returning the function");
        return "Welcome to this e-commerce menu:\n 1 - Look the catalog\n 2 - Buy\n 3 - Exit";
    }
```





- Parameters  
  
- Passing params.: By Value / By Reference  
  
- Returning a function  
  
- Anon. functions  
  
- Function Overloading  
  


#### Debug the code  

#### Best Practices  

- Avoid duplicated code. (Concisse code).  
- Code refactoring, done easy:  
  [Image 02-CodeRefactoring Easy]
- Method? Or function? Method is related to an object (Object.method) whereas a function isn't.  
