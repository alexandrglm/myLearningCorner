/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-003 'Array Creation and Accessing'
 * 
 * 04 - Array For Loop Cmd Args
 * 
 */

 public class ArrayCmdArgs {

    public static void main(String s[]) {


        int num_args = s.length;

        System.out.println("\nArray Length is -> " + num_args);

        for (int i = 0;
        i < num_args;
        i++) {

            System.out.println(s[i]);

        }

    }

 }