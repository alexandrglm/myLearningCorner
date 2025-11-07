/* *****************************************************************************
 *  Name:              Alexander Gomez
 *  Coursera User ID:  749357c739894c3fed50b8c38d1578c7
 *  Last modified:     November 7, 2025
 **************************************************************************** */

// package src;

public class HelloGoodbye {
    public static void main(String[] args) {

        String nameOne = args[0];
        String nameTwo = args[1];

        // 1. Name 1 + Name 2
        // Using println simple method by jkoining parts
        System.out.println("Hello " + nameOne + " and " + nameTwo + ".");

        // 2. Replacing order
        //  Using printf (as str interpolation)
        System.out.printf("Goodbye %s and %s.%n", nameTwo, nameOne);
    }
}
