/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 4 > 04-004 'Exception Handling'
 * 
 * 02 - Exceptions in java, refactoring to add try-catch-finally's
 *
*/
import java.util.Scanner;

public class ExceptionTrial {


    public static void main(String s[]) {

        // 1. init vars
        Scanner sc = new Scanner(System.in);

        // 1.2 Init array up to 5 strs
        String strArray[] = new String[5];

        // Index++ init
        int strIdx = 0;     // Pending understanding why not -1

        // while once
        while (true) {

            // menu statement
            System.out.println(
                "\n === MAIN MENU ===" + 
                "\n   1) Add String" +
                "\n   2) Get a String from a particular index" + 
                "\n   3) Get length string in any index" +
                "\n   4) Get all strings in the array" +
                "\n\n(Press any other key to exit)"
            );

            // SC reading input
            String userChoice = sc.nextLine();

            // If else if cases
            // option1 - NO NEED OF TRY-CATCH as direct comparison is enough
            if (userChoice.equals("1")){

                // 1. Check if the array is full
                if (strIdx == 5) {

                    System.out.println("[WARN] Sorry, the array is full.");
                
                } else {

                // 2. Prompt user to enter a str
                    System.out.println("\n?> Enter the String: ");

                    String choiceOne = sc.nextLine();
                // 3. Add str to array
                    strArray[strIdx++] = choiceOne;
                }
            

            // Option 2 - Print specific string
            /* Needs a try - catch , to avoid

                - NumberFormatException
                - ArrayIndexOutOfBoundsException
            */
            } else if (userChoice.equals("2")) {

                try {

                    // 1 prompt user to enter the idx
                    System.out.println("\n?> Enter the Index: ");

                    String choiceTwo = sc.nextLine();
                    int parsedTwo = Integer.parseInt(choiceTwo);
                    // 2. get and print the desired string
                    String extractedTwo = strArray[parsedTwo];
                    System.out.println("\n OUTPUT:    " + extractedTwo);

                } catch (NumberFormatException e) {

                    System.out.println("[ERROR!] Please, you must enter a numeric option!");
                    continue;

                } catch (ArrayIndexOutOfBoundsException e) {

                    System.out.println("[ERROR!] This Index does not exist!");
                    continue;

                }

            // Option 3 - Print specific string's length
            /* Needs a try - catch , to avoid

                - 1.     NumberFormatException
                - 3.    ArrayIndexOutOfBoundsException
                - 2.    NullPointer
            */
            } else if (userChoice.equals("3")) {

                try {

                // 1. prompt user to enter idx
                System.out.println("\n?> Enter the Index: ");

                String choiceThree = sc.nextLine();
                int parsedThree = Integer.parseInt(choiceThree);

                // 2. get and print desired idx's length
                String extractedThree = strArray[parsedThree];
                System.out.println("\n OUTPUT:    " + extractedThree.length() + "(" + String.valueOf(extractedThree.length()) + ")");


                } catch (NumberFormatException e) {

                    System.out.println("[NumberFormat Handled] - Please, you must enter a numeric option!");
                    continue;

                } catch (NullPointerException e) {

                    System.out.println("[NullPointer Handled] - There is no data at selected index!");

                } catch (ArrayIndexOutOfBoundsException e) {

                    System.out.println("[OutOfBounds Handled] -  This Index does not exist!");
                    continue;

                }

            // Option 4: Get all
            // May need "Empty Array" "exception"
            } else if (userChoice.equals("4")) {

                // 1. Get and print all strings from array 
                System.out.println("\n OUTPUT (All stored strings) : ");
                for (int i = 0; i < 5; i++) {
                    System.out.println("  - " + (i+1) + ":  " + strArray[i]);
                }
                

            } else  {

                sc.close();
                break;


            }

            

        }

    }

}