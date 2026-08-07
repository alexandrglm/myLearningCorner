/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Module 5 - Grading Exercise 1, Grocery Store
 * 
 * 03 - Inventory
*/

// import java.lang.reflect.Array;
import java.util.ArrayList;

public class Inventory {

    // ArrayLists { {itemName},{itemPrice},{itemQuantity} }
    private ArrayList<Items> items = new ArrayList<>();

    // Create at least one empty item
    public Inventory() {

        // inits items, empty
        items.add(new Items("Rice", "1.65", "27"));
        items.add(new Items("Bread", "0.90", "212"));
        items.add(new Items("Baked Beans", "2.50", "8"));
        items.add(new Items("Ham", "3.25", "24"));
        items.add(new Items("Milk", "1.25", "2"));
        items.add(new Items("Eggs", "2.10", "45"));
        items.add(new Items("Cheese", "4.30", "12"));
        items.add(new Items("Butter", "1.90", "33"));
        items.add(new Items("Pasta", "1.20", "80"));
        items.add(new Items("Tomatoes", "0.75", "60"));
        items.add(new Items("Sugar", "1.10", "50"));
        items.add(new Items("Salt", "0.40", "100"));
        items.add(new Items("Coffee", "3.80", "20"));
        items.add(new Items("Tea", "2.15", "30"));
        items.add(new Items("Chicken", "5.60", "15"));

    }

    // Methods

    // get()
    /*
    
    Importante: Preveía los zerobased frente a un UI que usa non-zero-based,
    es MEJOR retocar, hacer hardcoded, los +1/-1 en los lugares concretos,
    que tocar aquí el idx +1 
    

    */
    public Items get(int idx) {
        
        return items.get(idx); 
    }
    
    // getItems()
    public ArrayList<Items> getItems(){

        return items;

    }
    
    // createItem()
    public void createItem(String itemName, String itemPrice, String itemQuantity) {

        items.add(new Items(itemName, itemPrice, itemQuantity));

    }
    
    // readAllInventory()
    public void readAllInventory(){

        System.out.println("\n\n---> INVENTORY <--- ");
        // PENDING FIX LOOP INCREMENTING
        // .length but on arraylists. -> directly .size()
        for (
            int i = 0;
            i < items.size();
            i++
        ) {

            Items item = items.get(i);

            System.out.println(
                "  " + (i + 1) + ") " +
                item.getItemName() + " " +
                "| Price : " + item.getItemPrice() + " €" +
                "| Available Stock : " + item.getItemQuantity() + " units |"
            );

        }

    }
    
    // findByName()
    public int findByName(String choiceName) {

        for (
            int i = 0;
            i < items.size();
            i++
        ) {
            if( items.get(i).getItemName().toUpperCase().contains(choiceName) || items.get(i).getItemName().contains(choiceName) || items.get(i).getItemName().equalsIgnoreCase(choiceName)) {

                return i;
            }
        }

        return -1;
    }

    // findByIndex()
    // PENDING FIX
    public int findByIndex(int choiceIndex) {

        int zeroBasedIdx = (choiceIndex - 1);

        if(zeroBasedIdx >= 0 && zeroBasedIdx < items.size()) {
            
            return zeroBasedIdx; 

        }

        return -1;
    }

    // deteteItem()
    public void deleteItem(int choiceIndex) {

        if ( choiceIndex >= 0 && choiceIndex < items.size() ) {

            items.remove(choiceIndex);
            System.out.println("   [OK] Succesfully deleted!  ");

        } else {

            System.out.println("  [!] Product does not exist (check products - indices) ");

        }


    }



    // averagePrice() PENDING
    public float averagePrice() {

        if (items.isEmpty()) {

            return 0.0f;

        }

        float summed = 0.0f;

        for(Items item : items) {

            summed += item.priceParser();

        }

        float average = summed / items.size();

        // PENDING FIX rendondeo() funcs!
        return average;

    }
    

    
    // filterByPrice()
    public void filterByPrice(float maxPrice) {

        boolean maxPriceDone = false;
        
        System.out.println( "\n\n --- AVAILABLE PRODUCTS UNDER " + maxPrice +" ---");

        for (int i = 0; i < items.size(); i++) {

            Items item = items.get(i);

            if(item.priceParser() <= maxPrice) {
                System.out.println("   \n\n -> " + (i + 1) + ") " + 
                item.getItemName() + " | " 
                + item.getItemPrice() + " €");

                maxPriceDone = true;
            }

        }

        if(!maxPriceDone) {

            System.out.println("  [!] No products were found under " + maxPrice + " €!");

        }

    }


    // INVENTORY METHODS

    // has stock?
    public boolean hasStock(int idx, int requestStock) {

        // idx +0 and equal (or minor) to max quantity size
        if (idx >= 0 && idx < items.size()) {

            Items item = items.get(idx);

            return item.quantityParser() >= requestStock;

        }
        return false;

    }

    // removal units from stock when purchased -> pending invoke from Grocery
    public boolean reduceStock(int idx, int reduceQuantity) {

        if (idx >= 0 && idx < items.size()) {

            Items item = items.get(idx);
            int currentStock = item.quantityParser();

            if (currentStock >= reduceQuantity ){

                int updatedQuantity = currentStock - reduceQuantity;

                // with Direct Str parser
                item.setItemQuantity(String.valueOf(updatedQuantity));

                return true;

            }
        }

        return false;
    }

    // Update stock when edited, purchased, etc
    public boolean updateStock(int idx, int updateQuantity ) {

        if (idx >= 0 && idx < items.size()) {

            Items item = items.get(idx);
            // Items item = items.get(idx);
            item.setItemQuantity(String.valueOf(updateQuantity));

            return true;

        }

        return false;

    }




    
}

