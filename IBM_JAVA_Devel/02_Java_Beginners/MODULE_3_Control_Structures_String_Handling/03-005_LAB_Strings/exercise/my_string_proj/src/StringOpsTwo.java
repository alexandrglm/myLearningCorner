/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-005 'String Operations'
 * 
 * 02 - Find Length / Access Chars
 * 
 */

 public class StringOpsTwo {

    public static void main(String s[]) {

        String s1 = "The quick brown fox jumped over the lazy dog";
        System.out.println("s1 length -> " + s1.length());

        char[] strAsArray = s1.toCharArray();
        for (char c : strAsArray) {

            System.out.println();
            System.out.print(c);
        }
        System.out.println();


        System.out.println("\nThe First char of the string s1 is -> " + strAsArray[0]);
        System.out.println("\nThe Last char of the string s1 is -> " + strAsArray[strAsArray.length-1]   );

        System.out.println("\nThe Index of 'T' is -> " + s1.indexOf('T'));
        System.out.println("\nThe Index of 'g' is -> " + s1.indexOf('g'));


    }


 }