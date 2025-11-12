/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 2 > 02-003 'Data Types'
 * 
 * 01 - PRIMITIVES
 * 
 */

 public class DataTypes {

    public static void main (String s[]) {

        // PRIMITIVES
        System.out.println("= PRIMITIVES =\n");

        // Byte ranges, 8bit, -128 ~ 127
        // Handling file data in binary
        byte b = 125;
        System.out.println(" - BYTE Value -> " + b);

        // Short ranges, 16bit, -32.678 ~ 32.767
        // Sensors readings, game scores, etc
        short points = 30285;
        System.out.println(" -SHORT Value -> " + points + " points");

        // Int(eger), 32bit, -2^31 ~ (2^31)-1 (-2,147,483,648 to 2,147,483,647)
        // All general numeric( WHOLES ) purposes
        int population = 261000;
        System.out.println(" - INT Value -> " + population + " inhabitants");

        // Long, 64-bit, -2^63	to (2^63)-1
        // Large whole numbers, timestamps in miliseconds
        // MUST END WITH A "L" indicating it'a a long integer

        long age_in_milliseconds = 788923800000L;
        System.out.println(" - LONG Value -> " + age_in_milliseconds + " ms.");


        // Float, 32bit, decimals,~±3.4×10³⁸ ( precision ≈7 decimal digits)
        // Money, area measurements, volume,
        // MUST END with a "F"
        float car_value = 28000.99F;
        System.out.println(" - FLOAT Value -> " + car_value + " euros");

        // Double, 64bit, long decimals, ~±1.8×10³⁰⁸ (precision up to ≈15 decimal digits)
        double pi_constant = 3.1415926539;
        System.out.println(" - DOUBLE Value -> " + pi_constant + " is the PI constant");
        System.out.println("      And...  " + pi_constant * 2 + " is the TAU constant");

        // CHAR, 16bit, 0 ~ 65.535 (Unicode)
        // Capturing keyboard inputs one key at time,
        // Mostly used as an array for words
        char keyboard_input = 'a';
        System.out.println(" - CHAR value -> Press '" + keyboard_input + "' key ");

        
        // Booleans, 1bit (logical), true or false
        boolean isLoggedIn = true;
        System.out.println(" - BOOLEAN value -> Is this a Java program?: " + isLoggedIn);




    }
 }