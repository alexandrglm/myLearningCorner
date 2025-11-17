/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-005 'String Operations'
 * 
 * 06 - Exercise Two
 *      1. Create a new String object "Maple Tree".
 *      2. Use substring to separate out "Maple" and "Tree" into two different objects.
 *      You MUST use Scanner and Integer.parseInt to get the index number
*/
import java.util.Scanner;

public class ExerciseTwoB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1.  Type a TWO-WORD sentence -> " );
        String sentence = sc.nextLine();
        System.out.println("2. Type the (NON-ZERO based) index where space is allocated  -> ");
        String spaceIndex = sc.nextLine();

        int spaceIndexInt = Integer.parseInt(spaceIndex);

        String newOne = sentence.substring(0, spaceIndexInt);
        String newTwo = sentence.substring(spaceIndexInt);

        System.out.println("The 1st word is -> " + newOne);
        System.out.println("The 2nd word is -> " + newTwo);

        sc.close();

    }

}