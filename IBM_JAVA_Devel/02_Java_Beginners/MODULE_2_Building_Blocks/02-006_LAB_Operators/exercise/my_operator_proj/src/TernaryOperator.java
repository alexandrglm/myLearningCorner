/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 2 > 02-006 'Operators'
 * 
 * 03 - Ternary Operator
 * 
*/

public class TernaryOperator {

    public static void main(String[] args){

        String hasArgs = args.length == 0 ? "No args were passed\n" : args[0];

        System.out.println(hasArgs);

    }

}