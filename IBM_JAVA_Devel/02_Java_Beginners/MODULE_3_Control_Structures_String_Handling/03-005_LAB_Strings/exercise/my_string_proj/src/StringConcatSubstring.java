/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-005 'String Operations'
 * 
 * 04 - String Concatenation and Substring-ing
 * 
 */


public class StringConcatSubstring {

    public static void main(String s[]) {

        String s1 = "Washington";
        String s2 = "DC";
        System.out.println("s1 -> " + s1);
        System.out.println("s2 -> " + s2);

        // Join
        System.out.println("s1 join s2 on space delimited -> " + String.join(" ", s1, s2));

        // Concat
        String concatPrettyfied = new String(s1.concat(" ").concat(s2));
        s1 = s1.concat(s2);
        System.out.println("s1 concat s2 -> " + s1);
        System.out.println("s1 concat s2 prettyfied -> " + concatPrettyfied);

        // Substring
        s1 = s1.substring(0,10);
        System.out.println("s1 substring s2 -> " + s1);


        System.out.println("s1.substring(7,10) -> " + s1.substring(7,10));
        System.out.println("s1.substring(7) -> " + s1.substring(7));





    }


 }