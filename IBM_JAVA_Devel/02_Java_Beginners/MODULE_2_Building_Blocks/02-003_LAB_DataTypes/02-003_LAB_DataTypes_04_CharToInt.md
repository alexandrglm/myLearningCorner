# 02-003 LAB - Practice Exercise: Char to Int

## Exercise Tasks

Complete the following tasks:

1. Create a file in the src folder that will declare a char with value 'a'.
2. Print the value of the char as is.
3. Try to cast it to an (int).
4. Print the value of the converted int.
5. Compile and run it.

**Note:** The number output you get is the ASCII value of the char.

## Solution Code

```java
/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 2 > 02-003 'Data Types'
 * 
 * 03 - Trying to convert CHAR to INT. Will it fail?
 * 
 */

public class CharToIntErrorOrNot {

    public static void main(String s[]){

        char myChar = 'a';

        System.out.println("1. Print the value of char as is:  " + myChar);

        System.out.printf("2. Try datacasting to int. Will it fail? : %s\n", (int)myChar);
        System.out.println("Char to int datacasting will show ASCII value of the character!!!! :D\n");
        
    }

}
```
