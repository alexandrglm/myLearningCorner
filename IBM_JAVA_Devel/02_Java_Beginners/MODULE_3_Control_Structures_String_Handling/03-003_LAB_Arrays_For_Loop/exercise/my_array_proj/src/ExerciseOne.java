/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-003 'Array Creation and Accessing'
 * 
 * Exercise O1 - 
 *  Create and initialize an int array with 10 elements.
 *  Print each element of the array without using the 'for' loop.
 *  Print each element of the array using the 'for' loop.
 */

 public class ExerciseOne {

    public static void main(String s[]){

        // 1 Array direct creation
        int loQuePide[] = {1,2,3,4,5,6,7,8,9,10};

        //. 2. Print each element without loop
        System.out.println(loQuePide[0]);
        System.out.println(loQuePide[1]);
        System.out.println(loQuePide[2]);
        System.out.println(loQuePide[3]);
        System.out.println(loQuePide[4]);
        System.out.println(loQuePide[5]);
        System.out.println(loQuePide[6]);
        System.out.println(loQuePide[7]);
        System.out.println(loQuePide[8]);
        System.out.println(loQuePide[9]);


        // 3. Using for
        // int cadaElementoDelArray = loQuePide.length;

        for (

            int i = 0;
            i < loQuePide.length;
            i++

        ) {

            System.out.println(loQuePide[i]);

        }

    }

 }