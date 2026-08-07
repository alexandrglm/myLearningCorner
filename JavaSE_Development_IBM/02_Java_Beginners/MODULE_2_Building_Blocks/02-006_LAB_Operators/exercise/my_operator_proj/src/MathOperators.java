/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 2 > 02-006 'Operators'
 * 
 * 01 - Math Operators
 * 
 */

public class MathOperators {
    public static void main(String[] args) {

        int num1 = 20;
        int num2 = 10;


        System.out.println("Math Operators with nums " + num1 + "and" + num2 + "\n" );


        // Addition
        System.out.println(" - Addition '+' operator -> " + (num1 + num2));

        // Substraction 
        System.out.println(" - Substraction '-' operator -> " + (num1 - num2));

        // Multiplication
        System.out.println(" - Multiplication '*' operator -> " + (num1 * num2));

        // Division
        System.out.println(" - Division '/' operator ->  " + (num1 / num2));

        // Modulus (rest, remainder)
        System.out.println(" - Modulus '%' operator -> " + (num1 + num2));


        // Doubles, for more precise division
        double num3 = (double)num1;
        double num4 = (double)num2;

        System.out.println(" - Precise division -> " + (num3 / num4));

    }

}