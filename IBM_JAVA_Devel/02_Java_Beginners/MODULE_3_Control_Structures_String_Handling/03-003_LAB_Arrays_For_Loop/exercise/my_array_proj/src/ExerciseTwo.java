/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-003 'Array Creation and Accessing'
 * 
 * Exercise O2 - 
 *  Create and initialize a string.
 *  Convert the string to a char array using the toCharArray() method.
 *  Print each element of the array using the 'for' loop.
 */

 public class ExerciseTwo {

    public static void main(String s[]){

        // 1. Creating a string
        String loQuePide = "Hello World";

        // 2. Translates to Character Array with .toCharArray() method
        /*
         * .toCharArray() syntax:
         *  
         * char[array] <name> = <variable>.toCharArray()
         */
        char[] loQuePideDos = loQuePide.toCharArray();

        // 3. Iterate - Print
        for (
            int i = 0;
            i < loQuePideDos.length;
            i++
        ) {

            System.out.println(loQuePideDos[i]);

        }

    }

 }