/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 4 > 04-004 'Exception Handling'
 * 
 * 04 - USER-DEFINED Exceptions
 *  - StudentUnderAgeException extends Exception for main StudentManagement > Student class
 *  
*/

public class StudentUnderAgeException extends Exception {

    public StudentUnderAgeException(String message) {

        super(message);

    }

}