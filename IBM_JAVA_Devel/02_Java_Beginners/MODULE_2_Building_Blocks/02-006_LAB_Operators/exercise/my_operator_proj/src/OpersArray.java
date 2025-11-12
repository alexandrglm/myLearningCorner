/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 2 > 02-006 'Operators'
 * 
 * 04 - Operations using Array
 * 
*/

public class OpersArray {

    public static void main(String[] args){


        /*
         * Create and initialize an int array with 10 elements.
         * Apply the mathematical operator on each number pairs such as:
         * addition elements at index 0,1
         * subtraction elements at index 2,3
         * multiplication elements at index 4,5
         * division elements at index 6,7
         * modulus elements at index 8,9
         */
        int[] numbers = {11, 22, 14, 9, 1, 7, 2, 3, 44, 15};


        System.out.println(numbers[0] + numbers[1] );
        System.out.println(numbers[2] - numbers[3] );
        System.out.println(numbers[4] * numbers[5] );
        System.out.println(numbers[6] / numbers[7] );
        System.out.println(numbers[8] % numbers[9] );



        /*
         * Use a for loop to check if the next number
         * in the array is greater than, less than or equal 
         * to the current number. 
         * User ternary and relational operator.
         */
        for (int i = 0;

            i < numbers.length - 1;
            
            i++

        ) {
            String output = numbers[i] <= numbers[i+1] 
            ? (numbers[i] < numbers[i+1] ? " less than " : " equal to ") 
            : " more than ";

            System.out.println(numbers[i] + output + numbers[i+1]);
        }

    }

}