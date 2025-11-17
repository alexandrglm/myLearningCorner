/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-007 'Custom Funcs-Methods'
 * 
 * 01 - Create a custom method
 * 02 - Add Methods to calculate volume of sphere, cube and cubpid
*/


import java.util.Scanner;

public class AreaCalculator {

    // A- Methods for calculating area here
    private static float pi = (float)Math.PI;

    private static float fourThirds = 4f / 3f;

    private static float circle(float radius) {

        return pi * radius * radius;

    }

    private static float square(float length) {

        return length * length;

    }

    private static float rectangle(float width, float lenght) {

        return width * lenght;

    }

    // 2. Exercise Part 2 Methods
    private static float sphere(float radius) {

        return ( fourThirds * pi * (float)Math.pow(radius, 3));

    }

    private static float cube(float length) {

        return (float)Math.pow(length, 3);

    }

    private static float cuboid(float length, float width, float height) {

        return length * width * height;
    }




    // B. Main
    public static void main(String s[]) {

        System.out.println("Welcome to Calculator Exercise!");

        Scanner sc = new Scanner(System.in);

        while(true){

            // C - menu to get user input and invoke methods here
            System.out.println(
                "\n== MAIN MENU ==\n" +
                "1 - Circle area\n" +
                "2 - Square area\n" + 
                "3 - Rectangle area\n" + 
                "4 - Sphere volume\n" + 
                "5 - Cube volume\n" + 
                "6 - Cuboid volume\n" +
                "0 - Exit" + 
                "\nOPTION? : "
            );

            
            String line = sc.nextLine();
            int choice = Integer.parseInt(line);


            if (choice  == 1 ) {

                System.out.println("   - Enter the circle radius: ");
                float radius = Float.parseFloat(sc.nextLine());

                System.out.println("\n   == The area of a " + radius + " cm. circle is : " + circle(radius) + " cm² ==");


            } else if (choice == 2) {

                System.out.println("   - Enter the length of the square: ");
                float length = Float.parseFloat(sc.nextLine());
                System.out.println("\n   == The area of a " + length + " cm. square is : " + square(length) + " cm² ==");

            } else if (choice == 3 ) {

                System.out.println("   - (Part 1) Enter the length of the rectangle: ");
                float length = Float.parseFloat(sc.nextLine());
                System.out.println("   - (Part 2) Enter the width of the rectangle: ");
                float width = Float.parseFloat(sc.nextLine());
                System.out.println("\n   == The area of a " + length + " width & " + width + " width rectangle is : " + rectangle(width, length) + " cm² ==");


            } else if (choice == 4) {


                System.out.println("   - Type the Sphere radius : ");
                float radius = Float.parseFloat(sc.nextLine());
                
                System.out.println("\n   == The volume of a " + radius + " cm. radius sphere is : " + sphere(radius) + " cm³ ==");


            } else if (choice == 5)  {

                System.out.println("   - Type the Cube side length : ");
                float length = Float.parseFloat(sc.nextLine());

                System.out.println("\n   == The volume of a " + length + " cm. length cube is : " + cube(length) + " cm³");

            } else if (choice == 6)  {

                System.out.println("   -(Part1) Type the cuboid length : ");
                float length = Float.parseFloat(sc.nextLine());
                
                System.out.println("   -(Part2) Type the cuboid width : ");
                float width = Float.parseFloat(sc.nextLine());
                
                System.out.println("   -(Part4) Type the cuboid height : ");
                float height = Float.parseFloat(sc.nextLine());

                System.out.println("\n   == The volume of a " + length + " cm., " + width + " cm width and " + height + "cm height is : " + cuboid(length, width, height) + " cm³ ==");
            
            } else if (choice == 0) {

                System.out.println("Bye!");
                break;

            } else {

                System.out.println("\n   ERROR! You must choose a valid option!");
                continue;
            }


        }

        sc.close();


    }
    
}
