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


