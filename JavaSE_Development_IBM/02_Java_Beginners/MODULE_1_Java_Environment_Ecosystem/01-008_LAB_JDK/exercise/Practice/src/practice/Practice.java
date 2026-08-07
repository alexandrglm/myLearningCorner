package practice;

import java.util.Scanner;

public class Practice {

    public static void main(String[] args) {

        try(Scanner sc = new Scanner(System.in)) {

            System.out.print("Name -: ");

            String fullname = sc.nextLine();

            System.out.printf("Hello, " + fullname + " , welcome to this system!\n\n");

            System.out.printf("Hello again, %s, this is another type of printf interpolation-insertion mode\n", fullname);

    
        }
    }

}