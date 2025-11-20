/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Module 5 - Grading Exercise 1, Grocery Store
 * 
 * 01 - Main, Orchestator 
 *
*/
import java.util.Scanner;


public class Main {


    // Main - main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Task1 -2 
            Inventory inventory = new Inventory();

            // Task3
            GroceryShop shop = new GroceryShop(inventory, sc);
            Menu menu = new Menu(inventory, shop, sc);
            
            // Start App
            menu.mainMenu();


        } catch (Exception e) {

            System.out.println("\n[Exception] -> " + e.getMessage());

        }
    }
}
