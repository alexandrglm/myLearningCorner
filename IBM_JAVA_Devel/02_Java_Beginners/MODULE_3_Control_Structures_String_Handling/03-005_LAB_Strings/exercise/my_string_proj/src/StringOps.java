/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-005 'String Operations'
 * 
 * 01 - Create String Objects - Calculate Length
 * 
 */

public class StringOps {
    
    public static void main(String s[]) {

        // 1. String Literal
        String s1 = "Hello World";
        System.out.printf("\ns1 -> %s\n", s1);

        // 2. String 'new' keyword
        String s2 = new String("Hello World using 'new' keyword");
        System.out.printf("\ns2 -> %s\n", s2);


        //3.
        String s3 = "Hello World";
        System.out.printf("\ns3 -> %s\n", s3);

        System.out.println("s1 and 2s comparison -> " + (s1 == s2));
        System.out.println("s2 and s3 comparison -> " + (s2 == s3));
        System.out.println("s1 and s3 comparison -> " + (s1 == s3));


    }

}
