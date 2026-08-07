
/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-005 'String Operations'
 * 
 * 07 - Exercise Three - String Methods (II)
*/

public class StrFullMethods {

    public static void main(String[] args) {

        System.out.println("= Full String Methods =\n");

        String strOne = "   The Quick Fox Jumped Over The Lazy Dog   ";
        String strTwo = "the quick fox jumped over the lazy dog";
        String strThree = "HelloWorld123";
        String strBlank = "";

        // 1. .length()
        System.out.println("\n=== 1. LENGTH ===");
        System.out.println(" \n   - .length() -> " + strOne.length() + "\n");

        // 2. .charAt()
        System.out.println("\n=== 2. ACCESSING A CHARACTER ===");
        System.out.println(" \n   - .charAt() position '6' -> " + strOne.charAt(6) + "\n");

        // 3. .equals() - .equalsIgnoreCase() - 
        System.out.println("\n=== 3. COMPARISON ===");
        System.out.println("   - Is equals strOne/strTwo -> " + strOne.equals(strTwo));
        System.out.println("   - Equals strOne/strTwo ignoring case? -> " + strOne.equalsIgnoreCase(strTwo));

        // 4. .contains() - startsWith() - .endsWith() - .indexOf() - .lastIndexOf()
        System.out.println("\n=== 4. SEARCH / CONTAINS ===");
        System.out.println("   - Contains 'Fox' ? -> " + strOne.contains("Fox"));
        System.out.println("   - Contains 'asdasdasd' ? -> " + strOne.contains("asdasdasd"));
        System.out.println("   - Starts with 'The' ? -> " + strOne.startsWith("The"));
        System.out.println("   - Starts with 'asdasdasd' ? -> " + strOne.startsWith("asdasdasd"));
        System.out.println("   - Ens with 'Dog' ? -> " + strOne.endsWith("Dog"));
        System.out.println("   - Ens with 'asdasdasd' ? -> " + strOne.endsWith("asdasdasd"));
        System.out.println("   - Index of 'Jumped' ? -> " + strOne.indexOf("Jumped"));
        System.out.println("   - Last Index of 'The' ? ->" + strOne.lastIndexOf("The"));
     

        // 5.   .replace() - .replaceAll() - .replaceFirst()
        System.out.println("\n=== 5. REPLACE ===");
        System.out.println("   - Replace 'Dog' with 'Cat' -> " + strOne.replace("Dog", "Cat"));
        System.out.println("   - Replace All 'The' with 'No' -> " + strOne.replaceAll("The", "No"));
        System.out.println("   - Replace the FIRST 'The' with 'No' -> " + strOne.replaceFirst("The", "No"));
        System.out.println("   - Replace ALL vowels with [...] -> " + strOne.replaceAll("[AIUEOaiueo]", "e"));

        // 6. .substring()
        System.out.println("\n=== 6. SUBSTRINGS ===");
        System.out.println("   - Substring from i 4~9 -> " + strOne.substring(4,9));


        // 7. .toLowerCase() - .toUpperCase()
        System.out.println("\n=== 7. CASE CONVERSION ===");
        System.out.println("   - To UPPERCASE -> " + strOne.toUpperCase());
        System.out.println("   - To lowercase() -> " + strOne.toLowerCase());


        // 8. .trim() - .strip() - .stripLeading() - .stripTrailing()
        System.out.println("\n=== 8. TRIMMING / STRIPING ===");
        System.out.println("- Original String : " + "(realStart)" + strOne + "(realEnd)");
        System.out.println("   - Trim -> " + "(realStart)" + strOne.trim() + "(realEnd)");
        System.out.println("(Since Java 11+, Strip methods are included)");
        System.out.println("   - Strip All -> " + "(realStart)" + strOne.strip() + "(realEnd)" );
        System.out.println("   - Leading Strip -> " + "(realStart)" + strOne.stripLeading() + "(realEnd)" );
        System.out.println("   - Trailing Strip -> " + "(realStart)" + strOne.stripTrailing() + "(realEnd)" );

        // 9. isEmpty() - .isBlank()
        System.out.println("\n=== 9. EMPTY/BLANK ===");
        System.out.println("   - Is strOne EMPTY? -> " + strOne.isEmpty());
        System.out.println("   - Is strBlank EMPTY? -> " + strBlank.isEmpty());
        System.out.println("(Since Java 11+, isBlank() is included)");
        System.out.println("   - Is strOne BLANK? -> " + strOne.isBlank());
        System.out.println("   - Is strBlank BLANK? -> " + strBlank.isBlank());


        // 10   .split()
        System.out.println("\n=== 10.SPLIT ===");
        String[] wordsFromStr1 = strOne.trim().split(" ");
        
        System.out.println("- Split words from 'strOne' after trimming: ");
        for(String w : wordsFromStr1) {
        
            System.out.println("   " + "- " + w);
        
        } 


        // 11.  .join()
        System.out.println("\n=== 11. JOIN (since Java8) ===");
        
        String joinedWords = String.join("-", wordsFromStr1);
        System.out.println("   - Joined words, by '-', from '10. Split' -> " + joinedWords);        

        // 12. .matches(regex)
        System.out.println("\n=== 12. MATCHING (USING REGEX) ===");
        
        String regexOne = "\\w+";
        System.out.println("   - Matches with '\\+ w' -> " + strThree.matches(regexOne));
       

        // 13.  .repeat()
        System.out.println("\n=== 13. REPEAT (Since Java11) ===");

        String repeat = "Hello! ";
        System.out.printf("   - Repeat '%s' three times -> ", repeat.repeat(3));

        // 14.  .indent()
        System.out.println("\n=== 14. INDENT (Since Java12)===");

        System.out.println("   - 'strTwo' indent by 4 spaces -> " + strTwo);
        System.out.println("   - 'strTwo' indent by 4 spaces -> " + strTwo.indent(4) + "'");


        // 15.  .transform()
        System.out.println("\n=== 15. TRANSFORM (Since Java12)===");

        System.out.println("- Transform allows to apply methods from args :");
        System.out.println("   SYNTAX: <var>.transform( function -> function.args)\n");

        System.out.println("    - strOne.transform().toUpperCase() -> " + strOne.transform( s -> s.toUpperCase()));



        // 16.  .codePointAt() - .codePointBefore() - .codePointCount()
        System.out.println("\n=== 16. DESCRIBE CODEPOINTS ===");
        System.out.println(".codePointAt(index) -> returns Unicode code point at given index\n");
        System.out.println("   - codePointAt(5) -> " + strOne.codePointAt(5));
        System.out.println("\n.codePointBefore(index) -> returns code point before given index");
        System.out.println("   - codePointBefore(5) -> " + strOne.codePointBefore(5));
        System.out.println("\n.codePointCount(begin, end) -> number of code points in range");
        System.out.println("   - codePointCount(0,10) -> " + strOne.codePointCount(0,10));


        // 17.  .offsetByCodePoints()
        System.out.println("\n=== 17. REPEAT (ADVANCED) ===");
        System.out.println("Returns index offset by given code points from start index");
        System.out.println("- SYNTAX: <var>.offsetByCodePoints(startIndex, codePointOffset)\n");
        System.out.println("   - offsetByCodePoints(0,5) -> " + strOne.offsetByCodePoints(0,5));
        System.out.println("   - Char at that index: " + strOne.charAt(strOne.offsetByCodePoints(0,5)));


        // 18.  .compareTo() - .compareToIgnoreCase()
        System.out.println("\n=== 18. COMPARETO / COMPARETOIGNORECASE ===");
        System.out.println("Lexicographical comparison of strings");
        System.out.println("SYNTAX: <var>.compareTo(otherString) / <var>.compareToIgnoreCase(otherString)\n");
        System.out.println("   - strOne.compareTo(strTwo) -> " + strOne.compareTo(strTwo));
        System.out.println("   - strOne.compareToIgnoreCase(strTwo) -> " + strOne.compareToIgnoreCase(strTwo));
        System.out.println("   ( Explanation: negative -> strOne < strTwo, zero -> equal, positive -> strOne > strTwo )");


        // 19.  .valueOf()
        System.out.println("\n=== 19. CONVERSION -> VALUEOF ===");
        System.out.println("Converts different types to String");
        System.out.println("SYNTAX: String.valueOf(variable)");
        
        int number = 42;
        double pi = 3.14159;
        boolean flag = true;
        
        System.out.println("   - String.valueOf(number) -> " + String.valueOf(number));
        System.out.println("   - String.valueOf(pi) -> " + String.valueOf(pi));
        System.out.println("   - String.valueOf(flag) -> " + String.valueOf(flag));


        // 20.  .format()
        System.out.println("\n=== 20. FORMAT ===");
        System.out.println("Returns a formatted string using specifiers");
        System.out.println("SYNTAX: String.format(formatString, args...)");
        System.out.println("   - String.format(\"Hello %s! You have %d messages.\", \"Alice\", 5) -> " 
                           + String.format("Hello %s! You have %d messages.", "Alice", 5));
        System.out.println("   (Explanation: %s -> string, %d -> integer, %f -> float, etc.)");


    }

}