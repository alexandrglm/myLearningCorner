/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-005 'String Operations'
 * 
 * 06 - Exercise Two
 *      1. Create a new String object "Maple Tree".
 *      2. Use substring to separate out "Maple" and "Tree" into two different objects.
 *      You MUST use Scanner to get the index number
*/
import java.util.Scanner;

public class ExerciseTwo {

    public static void main(String[] args) {

        // WITHOUT .parseINT

        Scanner sc = new Scanner(System.in);

        System.out.println("Type a TWO-WORD string space-separated -> ");
        String input = sc.nextLine();

       
        int checkSpaceIndex = -1;
        

        // For -nesting- for -> Each Char, if a Char is SPACE, then
        for (int i = 0; i < input.length(); i++) {
            
            if (input.charAt(i) == ' ') {
            
                checkSpaceIndex = i;

                break;
            
            }
        }

        // En cuanto checkSpaceIndex deja de ser -1, 
        if (checkSpaceIndex != -1 ) {

            String s4 = input.substring(0, checkSpaceIndex);
            String s5 = input.substring(checkSpaceIndex + 1);

            System.out.println(" First Word -> " + s4);
            System.out.print(" Seconf Word -> " + s5);

        }

        sc.close();


    }

}