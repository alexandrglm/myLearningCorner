/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Module 5 - Grading Exercise 1, Grocery Store
 * 
 * 03 - GroceryShop
 *
*/

import java.util.ArrayList;
import java.util.Scanner;


// PENDING REFACTORIZAR 
public class GroceryShop {

    // inits
    private Inventory inventory;
    private Scanner sc;


    // cosntr
    public GroceryShop(Inventory inventory, Scanner sc) {

        this.inventory = inventory;
        this.sc = sc;
    }
    

    // REFACTORIZADO todo a métodos [][] para eliminar getter/Setters

    // methods

    // buyMenu()
    public void buyMenu() throws RegexValidationException {

        float totalBill = 0.0f;
        ArrayList<String> cartList = new ArrayList<>();
        
        // Task 5 - Inner Infinite loop for purchases
        while(true) {
        
            inventory.readAllInventory();
            
            System.out.println("\n  - Enter Item name / Type 'Complete' to finish cart / Type 'Exit' to cancel: ");
            String itemChoice = sc.nextLine().strip();

            Menu.regexValidation(itemChoice);
            
            // Task - Exit Condition
            if(itemChoice.toUpperCase().contains("EXIT")) {
        
                Menu.prettyExit();
                return; 
            }
            
            // Taks - Complete Condition to finishCart
            if(itemChoice.toUpperCase().contains("COMPLETE")) {
                
                finishCart(cartList, totalBill);
                return; 
            
            }
            

            // Task 6 - 10, Get user input /Search for item
            int itemChoiceIdx = inventory.findByName(itemChoice);
            
            if (itemChoiceIdx == -1) {
                
                System.out.println("\n   [!] Product Not Found! Try Again");
                continue;
            
            }
            
            // Task7 -> Get Item by idx
            String name = inventory.getName(itemChoiceIdx);
            float price = Float.parseFloat(inventory.getPrice(itemChoiceIdx));
            int quantity = Integer.parseInt(inventory.getQuantity(itemChoiceIdx));
            

            // Probably not needed to add price/qty
            if (name  == null || price == 0 || quantity == 0) {
                
                System.out.println("\n   [!] Error accessing inventory!");
                continue;   
            
            }
            
            
            // Task 8 - Get chosen item qty
            System.out.println("\n - Enter '" + name + "' units: ");
            
            int parsedQuantity;
            
            try {

                parsedQuantity = Integer.parseInt(sc.nextLine().strip());
                
                // Numeric > 0 validation
                if (parsedQuantity <= 0) {
            
                    System.out.println("\n   [!] You cannot choose ZERO/NEGATIVE products!");
                    continue;
            
                }
                

                // Task 14 - STOCK VERIFICATIOPN
                if(!inventory.hasStock(itemChoiceIdx, parsedQuantity)) {
            
                    System.out.println("\n   [!] Not enough stock! Available: " + name  + " units");
                    continue;
            
                }
                
            
            } catch (NumberFormatException nfe) {
            
                System.out.println("\n   [!] Invalid Quantity, must be NUMERIC!");
                continue;
                
            
            } catch (Exception e) {
            
                System.out.println("\n   [!] Unexpected Error: " + e.getMessage());
                continue;
            }
            

            // Task 14, Redece Stock (Before confirmation) Part 1
            System.out.println("\nAdd " + parsedQuantity + "x " + name + " to cart? (Yes/No): ");
            String confirmation = sc.nextLine().strip();

            Menu.regexValidation(confirmation);
            
            if (!confirmation.toUpperCase().contains("Y")) {
                
                System.out.println("\n   [!] Item NOT added to cart.");
                continue;

            }
            
            // Task 8  - Total Item Amount
            float itemTotal = price * parsedQuantity;
            
            totalBill += itemTotal;
            

            cartList.add(parsedQuantity + " x " + name + 
                        " x " + price + " € = " + redondeo(itemTotal) + "€");
            
             // Task 14, Redece Stock (Before confirmation) Part 1
            inventory.reduceStock(itemChoiceIdx, parsedQuantity);
            
            System.out.println("\n[+] Added to cart: " + parsedQuantity + "x " + name);
            System.out.println("    Current total: " + redondeo(totalBill) + "€");
        }
    }


    //  finishCart)=
    private void finishCart(ArrayList<String> cartList, float totalBill) {

        if(cartList.isEmpty() || totalBill <= 0) {

            System.out.println("\n====================\nEmpty Cart! \n====================");
            return;

        }

        System.out.println("\n\n==== CHECKOUT RECEIPT ====");

        System.out.println(" - Products Lists:");
        for(String productReceipt : cartList) {

            System.out.println("    * " + productReceipt);
        
        }

        System.out.println("\n====================\n- SUBTOTAL: " + redondeo(totalBill) + " €\n====================");



        // Task 13 DISOCUNTS
        float discounts = 0.0f;
        String discountType = "";


        // +50eur -> 20%
        if (totalBill > 50) {

            discountType = "*** +50€ = 20%Off! ***";
            discounts = totalBill * 0.20f;
        
        // +10eur -> 15%
        } else if(totalBill > 10) {

            discountType = "*** +10€ = 15%OFF! ***";
            discounts = totalBill  * 0.15f;
        }



        if (discounts > 0) {

            System.out.println("\n====================\n- APPLIED DISCOUNT: " + redondeo(discounts) + " €\n====================");

        }

        System.out.println("\n====================\nTOTAL AMOUNT: " + redondeo(totalBill - discounts) + " €\n====================");
        System.out.print("\n\n Thanks for buying in GroceryShop Java App!!!\n");
        
        // main.mainMenu();




    }

    // Redondeo Aqui
    public static float redondeo(float price) {

        return Math.round(price * 100.0f) / 100.0f;
    }

    
}