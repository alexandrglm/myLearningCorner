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