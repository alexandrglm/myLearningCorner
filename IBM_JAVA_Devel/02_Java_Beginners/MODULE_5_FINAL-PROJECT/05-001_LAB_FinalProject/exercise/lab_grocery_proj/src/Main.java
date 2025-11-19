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

        Scanner sc new Scanner(System.in);

        try {
            
            Menu menu = new Menu();
            Inventory inventory = new Inventory();
            GroceryShop shop = new GroceryShop(sc);


            // Publics accesed 
            menu.mainMenu();
            // PRIVATES (won't be invoked here, but as for referenvce)
            // menu.inventoryMenu()
            



        // Must includes more case exceptions
        } catch (Exception e) {

            System.out.println("[ERROR] -> " +  e);

        } finally {

            sc.close();

        }



    }

}