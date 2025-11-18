/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 4 > 04-004 'Exception Handling'
 * 
 * 05 - Exercise -> Create USER-DEFINED Invalid Name Exception handler
 *  - REGEX -> ^[a-zA-Z]' - ]+$
*/


public class InvalidNameException extends Exception {

    public InvalidNameException(String message) {

        super(message);
    }

}