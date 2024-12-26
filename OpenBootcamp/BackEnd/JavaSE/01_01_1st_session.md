🔸 1st session:

* Introduction and configuration of IDE
	- Java philosophy and characteristics
	- Objects, garbage collector and JVM
	- IntelliJ
	- Exercise: Hello World  

*	Java filetypes  
	-	Java file extensions
	-	Executing Java files
	-	About Documenting/Documentation
	-	Doc types
	-	Comment types
	
*	Syntax, Variables, Reserved words  
	-	Variables
	-	Variable types
	-	Primitive types
	-	Reserved words
***
	
🔸 ## 2: Java characteristics, statistics, TIOBE index.

- Java releases: Each 6 months, excepting Java LTS
- Java 8 brought high changes.

- SDK version used in the course: SDK 17.
- SDK vresion used for me: SDK 23.
Since OpenJDK v-24 is still in testing-notProduction mode and SDK 23 offers high backward compatibility and there's no functions deprecated nor high syntax structures changes, so the newer SDK the better in this case.

- IDE used: IntelliJ
- Servers used: Apache
- Frameworks used:
- 

High-level language. Multiparadigma. Permite programas flexibles.

🔸 # TIOBE index, 2024 December
https://www.tiobe.com/tiobe-index/

| Dec 2024 | Dec 2023 | Change | Language | Ratings | Change |
|---|---|---|---|---|---|
| 1 | 1 |  | Python | Python | 23.84% | +9.98% |
| 2 | 3 | change | C++ page | C++ | 10.82% | +0.81% |
| 3 | 4 | change | Java page | Java | 9.72% | +1.73% |

Java maintains the 3rd rank.


🔸 # Setting up the environment

## Requisites:
OpenJDK, IntelliJ IDE

## OpenJDK
### From deb sources:

### Building from source code:
[Source](https://openjdk.org/groups/build/doc/building.html)
[Git Source](https://github.com/openjdk/jdk23u/blob/master/doc/building.md#getting-the-source-code)

**Dependences**: `gcc (=>13.2.0), clang, autoconf, libfreetype6-dev, libfontconfig-dev, libcups2-dev, libx11-dev libxext-dev libxrender-dev libxrandr-dev libxtst-dev libxt-dev, libasound2-dev, libffi-dev, debootstrap, `  
**Dependences for cross-compiling:** `g++, gcc, with the specific targets for the desired platforms (more info: https://openjdk.org/groups/build/doc/building.html#Cross-Compiling_the_Easy_Way)`  

## IntelliJ IDE

Site: https://www.jetbrains.com/es-es/idea/download/download-thanks.html?platform=linux&code=IIC


## Configuring and using IntelliJ

## Creating new session
1. Creating new package  
Package itinerary tends to be named the same as the developer/creator/enterprise website has, but upside down.
E.g.:
My website:	example.com -- so, the itinerary will be --> com.example

2. Creating a class
- .class files always using CamelCase, but the first letter UPPERCASE
- .class content:

```java
package com.example;

public class HelloWorld {

}
```
```text
package + itinerary;
public keyword + class keyword + className + openkey{
	*here will be all the classes, all the code*
	*line by line*
}
```


- The code has to be started, always, using enabling the `main`method, by several ways.  

1. By using shortcuts.  
Typing main, this IDE will set the main method automatically.  

2.  By hand, setting it up manually, like this:

```java
public static void main(String[] args){

}
```

- Now, we can add a first code line to test all relations correctibility or not, for example, by typing a simple printing on screen a string.
```java

System.out.println("Hello world, testing init relations");

```

The initialise code will be like this:
```java
package com.example;

public class HelloWorld {

    public static void main(String[] args){

        System.out.println("Hello World");

    }


}
```
.println method is the most basic method to start testing the class environment. More (complex) methods will be detailed.

- Its time to get compiled and tested our code, by clicking on "RUN" icon or *right-click* > Run.  
![image1](https://github.com/user-attachments/assets/0075bced-8348-405a-af4d-d86705ade2c0)
The code will be bytecode compiled, ready to be interpreted by the JVM.  
We notice that IntelliJ IDE shows on the botton side the JVM console the compilining and execution flags.  
*...with exit code 0* means there were no erros at any time.

- Finally, proved that this initialise configuration is made in the proper way (it works), coding process can be started.

# SYNTAX (1)

## Shorcuts:

`main`		Initialises the project static void main method  

`sout`		System.out.println    
`soutm`		Prints the current class name and method  
`soutp`		Prints the method parameters and values  
`soutv`		Prints a value  

## Indentation  
Even not giving a indentation to our code, and dislike as in another languages as Python, the standard catches *ONE TAB equal to FOUR SPACES*.  
Also, giving one blank line each line is the commons.  

## Comments & Documentating code process  

Taking notes is so useful in any creating process, also including here, when developing. As many other languages, Java has its own routine of comments.  
```java
// This is the simpliest way to give a comment in one line

 		/*
        This is a multi-line comment, useful for planning step by step. E.g.:
        1- Step1. Create the function sum
        2. Create number variable
        3. Use sum function to get the sum of both numbers
         */
```
  
Also, a documentation process using JAVADoc may contain a deep technique information about the method is attached to. 
JAVADocs always goes at the same indentation level as the object is referencing. E.g.:  
```Java
    /**
     * Title: Entrypoint to java application
     * Description: Lets the application xecution.
     *
     * @param args - Entry arguments for the application
     *
     *
     */
    public static void main(String[] args) {
```


```Java
package com.example;


/**
 * Test class to create a simply Java application
 */
public class ByeWorld {


    /**
     * This is a JAVADoc. Entrypoint to java application
     * Lets the application xecution.
     **
     * @param args - Entry arguments for the application
     */
    public static void main(String[] args) {
    
        // This is a simple-line comment
        System.out.println("ByeWorld.main");

        /*
        This is a multi-line comment, useful for planning step by step:
        1- Step1. Create the function sum
        2. Create number variable
        3. Use sum function to get the sum of both numbers
         */


    }

}
```

## Data types  

1.	Number  
1.1	Integer  
1.2 Decimal  

2. Boolean  

3. String  


## Creating variables  

Due to the nature of strongness typing Java is, the variable data type needs to be declared. It's told at the start of the line.  

A common schema of creating a number variable is:  

> #### *Data Type + Variable Name + AssignOperator (=) + The value*;    

Numbers and also Strings data types are used by an incremental value size:  
| Data Type | Sizw   | Range/Precission |
|--------------|----------|---------------------------------------------------------------------------|
| `byte`       | 8 bits   | Range: -128 ~ +127                                                         |
| `short`      | 16 bits  | Range: -32,768 ~ +32,767                                                   |
| `int`        | 32 bits  | Range: -2,147,483,648 ~ +2,147,483,647                                     |
| `long`       | 64 bits  | Range: -9,223,372,036,854,775,808 ~ +9,223,372,036,854,775,807             |
| `float`      | 32 bits  | Precission: 6-7 decimals, a double-word of 16bit.                                                  |
| `double`     | 64 bits  | Precission: 15 decimals, a double-word of 32bit.                                                   |
| `char`       | 16 bits  | Range: 0 a 65,535 (a unique UniCode character possible)                  |
| `string`     | Variable | Depends of the string size. Every character uses 1 word (2 bytes, UTF-16).      |


```Java
      // 1.   Numbers
        
        // 1.1  Integers
        byte variableOne = 1;
        short variableTwo = 100;
        int variableThree = 100000;
        long variableFour = 10000000000;

        long phoneNumber = 666145474;
        
        // long price = null; // It deserves a further explanation.

        // 1.2  Decimals
        float variableFive = 5.5f;
        double variableSix = 10.5d;
        variableSix = 20.5d; // here, the variable has been value-changed.
        double productPrice = 49.99d;

        // 2.   Booleans
        boolean variable7 = true;
        boolean variable8 = false;

        // 3.   Strings
        char variableNine = 'a';
        String variableTen = "Lorem ipsum dolor sit anet ...";
        /**
		* String is used 'String' because is a method. Further explanations will come
		*/

```



## Syntax structures

## JAVA Best Practices
