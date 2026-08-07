/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-005 'String Operations'
 * 
 * 03 - String Comparison
 * 
 */

 public class StringComparison {

    public static void main(String s[]) {

        String s1 = "Washington";
        String s2 = new String("Washington");
        String s3 = "WASHINGTON";

        // .equals() - .equalsIgnoreCase()
        System.out.println("Equality checks s1 and s2 -> " + s1.equals(s2));
        System.out.println("Equality checks s1 and s3 -> " + s1.equals(s3) );
        System.out.println("Equality checks s1 and s2 IGNORING case (.equalsIgnoreCase() ) -> " + s1.equalsIgnoreCase(s3));

        // Built-in > .toLowerCase() .... .toUpperCase() 
        System.out.println("s1 in lowercase -> " + s1.toLowerCase());
        System.out.println("s3 in lowercase -> " + s3.toLowerCase());
        System.out.println("s1 and s3 lowercase equality check -> " + s1.toLowerCase().equals((s3.toLowerCase())));

        System.out.println("s1 in UPPERCASE -> " + s1.toUpperCase());
        System.out.println("s3 in UPPERCASE -> " + s3.toUpperCase());
        // System.out.println("s1 and s3 UPPERCASE equality check ->" + s1.toUpperCase().equals((s3.toUpperCase())));

        String s4 = "50F1A";
        System.out.println("s3 in lowercase -> " + s4.toLowerCase());

        String regexStr = "^W.*";
        System.out.println("s1 matches REGEX ^W-* -> " + s1.matches(regexStr));
        System.out.println("s3 matches REGEX ^W-* -> " + s3.matches(regexStr));


        String s5 = "           Washington";
        System.out.println("s5 and s1 equality checks -> " + s1.equals(s5));
        // REMEMBER -> .strip() is a built-in methos SINCE Java 11
        System.out.println("s5 / s3 equals check after .strip() -> " + s3.equals(s5.strip()));
        System.out.println("s5 / s1 checks after .stripleading() -> " + s1.equals(s5.stripLeading()));
        System.out.println("s5 / s1 equals check after .trim()-> " + s1.equals(s5.trim()));

    }

 }