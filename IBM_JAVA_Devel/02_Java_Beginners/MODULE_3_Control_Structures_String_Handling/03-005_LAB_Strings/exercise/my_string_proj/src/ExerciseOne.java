/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-005 'String Operations'
 * 
 * 05 - Exercise
 *      1. Create a two String literals "Maple Tree" and "Maple Tree". Check their equality using ==.
 *      2. Create a new String object "Maple Tree". Check their equality with the String literal using == and then check using .equals method.
 *      3. Use substring to separate out "Maple" and "Tree" into two different objects.
 *      4  Use concat to string the object back together as "Maple Tree".
 *      5. Use toLowerCase to convert all the characters to lowercase.
 *      6. Use toUpperCase to convert all the characters to uppercase.
*/

public class ExerciseOne    {

    public static void main(String s[]){

        // 1
        String s1 = "Mapple Tree";
        String s2 = "Mapple Tree";
        System.out.println(s1.equals(s2));

        // 2
        String s3 = new String("Maple Tree");
        System.out.println(s3 == s1);
        System.out.println(s3 == s2);
        System.out.println(s3.equals(s1));
        System.out.println(s3.equals(s2));

        // 3
        String s3ObjOne = s3.substring(0,5);
        String s3ObjTwo = s3.substring(6);
        System.out.println(s3ObjOne);
        System.out.println(s3ObjTwo);

        // 4
        String s3ObjConcat = new String().concat(s3ObjOne).concat(" ").concat(s3ObjTwo);
        System.out.println(s3ObjConcat);

        // 5
        System.out.println(s3ObjConcat.toLowerCase());

        // 6
        System.out.println(s3ObjConcat.toUpperCase());




    }


}