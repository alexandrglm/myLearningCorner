/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-003 'Array Creation and Accessing'
 * 
 * 02 - Initialise and create thje Array
 * 
 */

public class ArrayInitAccess {

    public static void main (String s[]) {

        /*
        int years[] = {2025,2026,2027,2028,2029,2030};

        System.out.println(years[0]);
        System.out.println(years[1]);
        System.out.println(years[2]);
        System.out.println(years[3]);
        System.out.println(years[4]);
        System.out.println(years[5]);
        */

        // 1 - Init the array, new object in memory, an array up to 6 int elements
        int years[] = new int[6];

        // 2 - Creating its elements.
        // Strongtyping not needed, array was strongtyped when creating
        years[1] = 2021;
        years[3] = 2023;

        // 3 - Invoking incomplete array will show "0" values on empty indices
        System.out.println(years[0]);
        System.out.println(years[1]);
        System.out.println(years[2]);
        System.out.println(years[3]);
        System.out.println(years[4]);
        System.out.println(years[5]);



    }    

}
