# 2nd Session - *JAVA Functions*:

### What's a function?
A piece of code logic, reusable.  
Java (coding, in general) needs variables to work. When variables are declared, then, they need to get worked by functions.  
  


## Passing params.: By Value / By Reference  // Returning a function  
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

#### CASE 3:  "Params - NO return" function type  
```java
        // 3:   "Params - NO return" function
        imprimirSaludo("OpenBootcamp");

    }

    // 3:   "Params - NO return" function
    static void imprimirSaludo(String greetingName) {
        System.out.println("Hello, " + greetingName + "!");

    }
```

#### CASE 4:  "Params and return" function type 
```java

        // 4: "Params + Return" function
        String name = "Alexandr";
        String surname = "Gomez" ;
        String greeting = getTheGreeting(name, surname);
        System.out.println(greeting);


    }

    // 4: "Params + Return" function
    static String getTheGreeting(String name, String surname) {
        return "Hello, " + name + " " + surname +  "!";
    }


```
***
### Anon. functions
Structure:  
```java
() -> {
  // here, its logic
}
```
More detailed explanations will be done.

***
### Function Overloading
Function Overloading lets a method being duplicated as long as having different number/kind of params.
```java
package com.example;
public class FunctionOverloading {

    public static void main(String[] args) {
    }

    static int sum(int number1, int number2) {
        return number1 + number2;

    }

// The function can be reutilised, BUT using different params 
    static int sum(int number1, int number2, int number3) {
        return number1 + number2 + number3;

    }

}
```


## Best Practices  

- Avoid duplicated code. (Concisse code).  
- Code refactoring, done easy:  
  [Image 02-CodeRefactoring Easy]
- Method? Or function? Method is related to an object (Object.method) whereas a function isn't.
***
## Notes
A simple exercise is claimed by demonstrating how to pass values to arguments, but here new methods (as Rounding Decimals method) may be used.  

#### What's a Big Decimal?
It is **not a primitive JAVA data type**, but a class introduced on `java.math`.  
Unlike `double` or `float`, which can introduce rounding errors due to their internal representation, `BigDecimal` can represent numbers accurately with an arbitrary number of decimal places.  

#### Methods used in BigDecimal

- `add()` , `subtract()` , `multiply()` , `divide()` : These methods are used **to perform arithmetic operations with BigDecimal objects**.  
- `setScale(int newScale, RoundingMode roundingMode)` : This method is used **to set the scale (number of decimal places) and its rounding mode**:

| Rounding Mode     | Description                                                                 | Example 1               | Example 2               |
|-------------------|-----------------------------------------------------------------------------|--------------------------------------|--------------------------------------|
| `.HALF_UP`        | Rounds up when exactly halfway between two numbers.                         | 2.5 → 3                              | 3.5 → 4                              |
| `.HALF_DOWN`      | Rounds down when exactly halfway between two numbers.                       | 2.5 → 2                              | 3.5 → 3                              |
| `.HALF_EVEN`      | Rounds to the nearest even number when exactly halfway between two numbers. | 2.5 → 2                              | 3.5 → 4                              |
| `.UP`             | Always rounds away from zero (up).                                          | 2.1 → 3                              | -2.1 → -2                            |
| `.DOWN`           | Always rounds towards zero (down).                                          | 2.5 → 2                              | -2.5 → -2                            |
| `.CEILING`        | Rounds towards positive infinity (up for positive numbers, towards zero for negative). | 2.5 → 3                              | -2.5 → -2                            |
| `.FLOOR`          | Rounds towards negative infinity (down for positive numbers, away from zero for negative). | 2.5 → 2                              | -2.5 → -3                            |
| `.UNNECESSARY`    | No rounding allowed; throws an exception if rounding is needed.             | Throws exception if rounding required | Throws exception if rounding required |

- `doubleValue()` : Converts the BigDecimal to a double as long as the original value was a double and, also, doubles need to be used.  
- `toString()` : Returns the string representation of the BigDecimal.  
