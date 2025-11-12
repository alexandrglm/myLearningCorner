/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 2 > 02-003 'Data Types'
 * 
 * 02 - Double to Int (decilams dissapear; NEVER rounded)
 * 
 */

 public class DataDoubleToInt {

    public static void main(String s[]){

        double area_circle = 78.53981634d;

        System.out.println(" - (1 - Double) Area of 5cm cirlce radius is :  " + area_circle);
        System.out.println(" - (2 - Double to int) Area of 5cm circle radius is :  " + (int)area_circle);

    }

 }