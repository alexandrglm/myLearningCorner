/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Module 5 - Grading Exercise 1, Grocery Store
 * 
 * 05 - Menus
 *
*/

import java.rmi.UnexpectedException;
import java.util.Scanner;

public class Menu {

    // inits
    private Scanner sc;
    private Inventory inventory;
    private GroceryShop shop;

    //constr
    public Menu(Inventory inventory, GroceryShop shop, Scanner sc) {

        this.inventory = inventory;
        this.shop = shop;
        this.sc = sc;

    }

    // methods

    // mainMenu() - public, accessed by Main
    public void mainMenu() throws NotExpectedException {

        /*
        1. Administrar inventarios
        2. Comprar

        3. Buscar
        4. Filtrar por precio
        5. Precio medio del inventario

        6. Salir
        
        */
        
        while(true) {  // AÑADIDO: Bucle while para poder usar break
            
            System.out.println("\n -_- GROCERY STORE -_-");
            System.out.println("  1 - INVENTORY");
            System.out.println("  2 - BUY");
            System.out.println("  3 - SEARCH ITEMS FROM INVENTORY");
            System.out.println("  4 - FILTER ITEMS BY PRICE");
            System.out.println("  5 - AVERAGE PRICE FROM INVENTORY TODAY");
            System.out.println("  6 - EXIT");

            // Scanner String choice - if "1" || menuChoice.equalsIgnoringCase("blablabla") , or contains()
            String menuChoice = sc.nextLine();


            try {

                // IF ELSE IF
                if (menuChoice.equals("1") || menuChoice.toUpperCase().contains("INVENTORY")) {
                   
                    inventoryMenu();
        
                } else if (menuChoice.equals("2") || menuChoice.toUpperCase().contains("BUY")) {
                    
                    shop.buyMenu();
        
                } else if (menuChoice.equals("3") || menuChoice.toUpperCase().contains("SEARCH")) {
                    
                    searchItem();
                
                } else if (menuChoice.equals("4") || menuChoice.toUpperCase().contains("FILTER"))  {
                    
                    filterItem();
                
                } else if (menuChoice.equals("5") || menuChoice.toUpperCase().contains("AVERAGE")) {
                    
                   float average = inventory.averagePrice();
                   
                   
                   System.out.println(
                    "\n\n====================\n  Average Price for all Products : " + Items.redondeo(average) +
                    "\n===================");
                
                } else if (menuChoice.equals("6") || menuChoice.toUpperCase().contains("EXIT")) {

                    System.out.println("\nThanks for your visit! Bye!");
                    break; 
                    
                } else {

                    throw new UnexpectedException("\n\n   [!]  Please, enter a valid (numeric) option!");

                }


            } catch (Exception e) {
            
                System.out.println("\n\n    [EXCEPTION!] An error ocurred: " + e.getMessage());
            
            }
        
        } // FIN while
    
    }


    // inventoryMenu(), private, accessed by others (Menu, Inventory) but through this Menu class (1 to many)
    // TASK 4  - while
    private void inventoryMenu() throws NotExpectedException {

        /*
            1. Create item
            2. Read Item
            3. Read Full Inventory
            4. Update Item
            5. Delete Item
            6. Exit
        
        
        */
        while(true) {


            System.out.println("\n\n-_-_- INVENTORY MENU -_-_-");
            System.out.println("  1 - Create Item");
            System.out.println("  2 - Read (find) ONE Item");
            System.out.println("  3 - Read (find) ALL Items");
            System.out.println("  4 - Update an Item");
            System.out.println("  5 - Delete an Item");
            System.out.println("  6 - Exit");
            


            String menuChoice = sc.nextLine();

            try {
                
                // IF ELSE IF
                if (menuChoice.equals("1")) {

                    createItem();
                    break;

                } else if (menuChoice.equals("2")) {

                    readItem();
                    break;
                    
                } else if (menuChoice.equals("3")) {

                    readItems();
                    break;
                    
                } else if (menuChoice.equals("4")) {

                    updateItem();
                    break;
                    
                } else if (menuChoice.equals("5")) {

                    deleteItem();
                    break;
                    
                } else if (menuChoice.equals("6") || menuChoice.toUpperCase().contains("EXIT")) {

                    prettyExit();
                    return; 

                } else {

                    throw new UnexpectedException("\n\n   [!]  Please, enter a valid (numeric) option!");
                }

            } catch (Exception e) {

                System.out.println("\n\n    [EXCEPTION!] An error ocurred: " + e.getMessage());
        
            }
            
        } // FIN while

    }


    // METHODS like CRUD
    
    // createItem()
    public void createItem() throws NotExpectedException, RegexValidationException{

        System.out.println("\n\n INVENTORY TOOLS:   Add new product");
        
        System.out.println("\n   -> Product Name? : ");
        
        String choiceName = sc.nextLine();

        regexValidation(choiceName);
        
        if(choiceName.toUpperCase().strip().contains("EXIT")){
        
            prettyExit();
            return;
        
        }

        System.out.println("\n   -> Product Price (includes .00 decimals) ? : ");
        String choicePrice = sc.nextLine();
        regexValidation(choicePrice);

        System.out.println("\n   -> How many single products will be added to stock  ? : ");
        String choiceQuantity = sc.nextLine();
        regexValidation(choiceQuantity);

        // confirmation to write data
        System.out.println("\n\n[WRITE DATA CONFIRMATION]\n");
        System.out.println("        Name: " + choiceName);
        System.out.println("        Price: " + choicePrice + " €");
        System.out.println("        Stock: " + choiceQuantity + " units");
        System.out.println("\n Is correct? (yes/no) : ");
        
        String choiceConfirmation = sc.nextLine();
        if(!choiceConfirmation.toUpperCase().contains("Y")) {
        
            prettyExit();
            inventoryMenu();
        
        } else {

            inventory.createItem(choiceName, choicePrice, choiceQuantity);
            System.out.println("\n Data saved!\n");
            inventoryMenu();
        
        }
    

    }

    // readItem()
    public void readItem() throws NotExpectedException, RegexValidationException {
        
        System.out.println("\n\n INVENTORY TOOLS:   Find ONE Item");
        System.out.println("\n   -> Type the product name: ");
        String choiceName = sc.nextLine();

        regexValidation(choiceName);

        if(choiceName.toUpperCase().strip().contains("EXIT")){
        
            prettyExit();
            return;
        
        }
        
        int indexFound = inventory.findByName(choiceName);
        
        if (indexFound != -1) {

            Items item = inventory.get(indexFound);

            System.out.println("\n[+] Item found:");
            System.out.println("  Name: " + item.getItemName());
            System.out.println("  Price: " + item.getItemPrice() + " €");
            System.out.println("  Stock: " + item.getItemQuantity() + " units");
            System.out.println();

            inventoryMenu();
        
        } else {

            System.out.println("\n[!] Item not found.");
            inventoryMenu();
        
        }
        
    }
    
    // readItems()
    public void readItems() throws NotExpectedException {

        System.out.println("\n\n INVENTORY TOOLS:   Show Full Inventory");
        inventory.readAllInventory();
        
        System.out.println();
        inventoryMenu();

    }

    // updateItems()
    public void updateItem() throws NotExpectedException, RegexValidationException {

        System.out.println("\n\n INVENTORY TOOLS:   Update an Item");
        inventory.readAllInventory();
        System.out.println("\n   -> Type the item number to update: ");
        
        String choiceUpdate = sc.nextLine();
        regexValidation(choiceUpdate);
        
        if(choiceUpdate.toUpperCase().strip().contains("EXIT")){
        
            prettyExit();
            return;
        
        }
        int itemNumber = Integer.parseInt(choiceUpdate);
        
        int indexUpdate = inventory.findByIndex(itemNumber);
        
        if (indexUpdate == -1) {
            
            System.out.println("\n  [!] Invalid item number.");
            return;
        
        }
        
        Items item = inventory.get(indexUpdate);
        
        System.out.println("\nUpdating: " + item.getItemName());
        System.out.println("Leave blank to keep current values.");
        
        System.out.print("New name [" + item.getItemName() + "]: ");
        String choiceNewName = sc.nextLine().strip();

        regexValidation(choiceNewName);

        if (!choiceNewName.isEmpty()) {

            item.setItemName(choiceNewName);

        }
        
        System.out.print("New price [" + item.getItemPrice() + " €]: ");
        String newPrice = sc.nextLine().strip();
        regexValidation(newPrice);
        
        if (!newPrice.isEmpty()) {
        
            item.setItemPrice(newPrice);
        
        }
        
        System.out.print("New quantity [" + item.getItemQuantity() + " units]: ");
        String newQuantity = sc.nextLine().strip();
        regexValidation(newQuantity);

        if (!newQuantity.isEmpty()) {
        
            item.setItemQuantity(newQuantity);
        
        }
        
        System.out.println("\n[+] Item updated successfully!");
        inventoryMenu();

    }

    // deleteItem()
    public void deleteItem() throws NotExpectedException, RegexValidationException {

        System.out.println("\n\n INVENTORY TOOLS:   Delete a product");
        inventory.readAllInventory();
        System.out.println("====================================");
        System.out.println("\n Type the item number to be deleted: ");

        String choiceDelete = sc.nextLine();

        regexValidation(choiceDelete);

        if(choiceDelete.toUpperCase().strip().contains("EXIT")){
        
            prettyExit();
            return;
        
        }
        int itemNumber = Integer.parseInt(choiceDelete);
        int indexDelete = inventory.findByIndex(itemNumber);
        
        if (indexDelete == -1) {
            
            System.out.println("\n[!] Invalid item number.");
            return;
        
        }

        System.out.println("\n\n[DELETE DATA CONFIRMATION]");
        System.out.println("\n Are you sure to delete this product from inventory? (yes/no) : ");
    
        String choiceConfirmation = sc.nextLine();
        
        if(!choiceConfirmation.toUpperCase().contains("Y")) {
        
            prettyExit();
            return;
        
        } else {

            inventory.deleteItem(indexDelete);
            System.out.println("\nProduct Deleted!");

            System.out.println();
            inventoryMenu();
        }

    }


    // searchItem()
    public void searchItem() throws RegexValidationException {

        System.out.println("\n\n INVENTORY TOOLS:   Search Items\n");
        System.out.println("\n   -> Type search term: ");
        String searchTerm = sc.nextLine();

        regexValidation(searchTerm);

        if(searchTerm.toUpperCase().strip().contains("EXIT")) {

            prettyExit();
            return;
        }
        
        int indexFound = inventory.findByName(searchTerm);
        
        try{

            if (indexFound != -1) {

                Items item = inventory.get(indexFound -1);
                
                System.out.println("\n[+] Item found:");
                System.out.println(
                    "  " + (indexFound + 1) + ") " + item.getItemName() + 
                    " | Price: " + item.getItemPrice() + " €" + 
                    " | Stock: " + item.getItemQuantity());
            
            } else {
            
                System.out.println("\n[!] No items found matching '" + searchTerm + "'");
            
            }
        
        } catch (IndexOutOfBoundsException ioobe) {

            System.out.println("Please, type a product name, blank values not allowed!");
            searchItem();

        }

    }
   
    // filterItem()
    public void filterItem(){

        System.out.println("\n\n INVENTORY TOOLS:   Filter Items by maxPrice\n");
        System.out.println("\n Type the maximum price: ");
        String choiceMaxPrice = sc.nextLine();

        float maxPrice = Float.parseFloat(choiceMaxPrice);

        inventory.filterByPrice(maxPrice);

    }

    // Regex Validation
    public static boolean regexValidation(String input) throws RegexValidationException {

        String regexValidation = "^[a-zA-Z 0-9.]+$";
        
        if(!input.matches(regexValidation)) {

            throw new RegexValidationException("\n[!] Please, use alhpanumeric values (a~Z, 0-9) ");
    
        }
        
        return true;

    }

    // ExitMenusPretty func
    public static void prettyExit() {

        System.out.println("\n   ~ Operation Cancelled ~\n");

    }

}