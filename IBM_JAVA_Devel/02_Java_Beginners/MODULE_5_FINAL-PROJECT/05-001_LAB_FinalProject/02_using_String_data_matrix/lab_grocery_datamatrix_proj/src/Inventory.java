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
    /*
    refactorize inventory datatype:
    Array[] to String[][]
    
    */
    private String[][] items;
    private int itemCount;

    // Create at least one empty item
    public Inventory() {

        // inits items, empty
        // TASK 1 - Create Array, min 10 items, max 25 allowed
        items = new String[25][3];


        createItem("Rice", "1.65", "27");
        createItem("Bread", "0.90", "212");
        createItem("Baked Beans", "2.50", "8");
        createItem("Ham", "3.25", "24");
        createItem("Milk", "1.25", "2");
        createItem("Eggs", "2.10", "45");
        createItem("Cheese", "4.30", "12");
        createItem("Butter", "1.90", "33");
        createItem("Pasta", "1.20", "80");
        createItem("Tomatoes", "0.75", "60");
        createItem("Sugar", "1.10", "50");
        createItem("Salt", "0.40", "100");
        createItem("Coffee", "3.80", "20");
        createItem("Tea", "2.15", "30");
        createItem("Chicken", "5.60", "15");

    }

    // Methods

        public Items get(int i) {
        
        if (i >= 0 && i < itemCount) {

            return new Items(items[i][0], items[i][1], items[i][2] );
        }

        return null;
    }
    
    // getItems()
    public ArrayList<Items> getItems() {

        ArrayList<Items> itemList = new ArrayList<>();

        for (int i = 0; i < itemCount; i++) {

            itemList.add(new Items(items[i][0], items[i][1], items[i][2]));

        }

        return itemList;
    }
    
    // createItem()
    public void createItem(String itemName, String itemPrice, String itemQuantity) {

        if (itemCount < items.length ) {

            items[itemCount][0] = itemName;
            items[itemCount][1] = itemPrice;
            items[itemCount][2] = itemQuantity;

            itemCount++;

        }
        
    }
    
    // readAllInventory()
    public void readAllInventory(){

        System.out.println("\n---> INVENTORY <--- ");
        for (
            int i = 0;
            i < itemCount;
            i++
        ) {

            System.out.println(
                "  " + (i + 1) + ") " +
                items[i][0] + " " +
                "| Price : " + items[i][1] + " €" +
                "| Available Stock : " + items[i][2] + " units |"
            );

        }

    }
    
    public int findByName(String choiceName) {

        String search = choiceName.strip().toUpperCase();

        for (int i = 0; i < itemCount; i++) {

            String itemName = items[i][0].toUpperCase();

            if (itemName.contains(search)) {
                return i;
            }
        }

        return -1;
    }


    // findByIndex()
    public int findByIndex(int choiceIndex) {

        int zeroBasedIdx = (choiceIndex - 1);

        if(zeroBasedIdx >= 0 && zeroBasedIdx < itemCount ) {
            
            return zeroBasedIdx; 

        }

        return -1;
    }

    // deteteItem()
    public void deleteItem(int choiceIndex) {

        if ( choiceIndex >= 0 && choiceIndex < itemCount ) {

            for(int i = choiceIndex; i < itemCount; i++) {

                items[i][0] = items[i + 1][0];
                items[i][1] = items[i + 1][1];
                items[i][2] = items[i + 1][2];
            }

            itemCount--;

            System.out.println("   [OK] Succesfully deleted!  ");

        } else {

            System.out.println("  [!] Product does not exist (check products - indices) ");

        }
    }



    // averagePrice() PENDING
    public float averagePrice() {

        if (itemCount == 0) {

            return 0.0f;

        }

        float summed = 0.0f;

        for(int i = 0; i < itemCount; i++){

            summed += Float.parseFloat(items[i][1]);

        }


        float average = summed / itemCount;

        return Items.redondeo(average);

    }
    

    
    // filterByPrice()
    public void filterByPrice(float maxPrice) {

        boolean maxPriceDone = false;
        
        System.out.println( "\n\n --- AVAILABLE PRODUCTS UNDER " + maxPrice +" ---");

        for (int i = 0; i < itemCount; i++) {

            float price = Float.parseFloat(items[i][1]);

            
            if(price <= maxPrice) {
                System.out.println("   -> " + (i + 1) + ") " + 
                items[1][0] + " | " 
                + items[1][0] + " €");

                maxPriceDone = true;
            }

        }

        if(!maxPriceDone) {

            System.out.println("  [!] No products were found under " + maxPrice + " €!");

        }

    }


    // INVENTORY METHODS (REPLACES Getters/Setters from  main, due to ArrayList -> Matrix String[][])

    // getName
    public String getName(int i) {

        if(i >= 0 && i < itemCount) {

            return items[i][0];

        }
        return "";

    }
    // getPrice
    public String getPrice(int i) {

        if(i >= 0 && i < itemCount) {

            return items[i][1];
        }

        return "";
    }
    // getQuantity
    public String getQuantity(int i) {

        if(i >= 0 && i < itemCount) {

            return items[i][2];
        }

        return "";
    }

    // updateName
    public void updateName(int i, String newName){
        items[i][0] = newName;
    }

    // updatPrice
    public void updatePrice(int i, String newPrice){
        items[i][1] = newPrice;
    }
    // updateQuantity
    public void updateQuantity(int i, String newQuantity){
        items[i][2] = newQuantity;
    }
    public int getItemCount() {

        return itemCount;
    }




    // has stock?
    public boolean hasStock(int i, int requestStock) {

        // idx +0 and equal (or minor) to max quantity size
        if (i >= 0 && i < itemCount) {

           int currentStock = Integer.parseInt(items[i][2]);

            return currentStock >= requestStock;

        }
        return false;

    }


    // removal units from stock when purchased -> pending invoke from Grocery
    public boolean reduceStock(int i, int reduceQuantity) {

        if (i >= 0 && i < itemCount) {

            int currentStock = Integer.parseInt(items[i][2]);

            if (currentStock >= reduceQuantity ){

                int updatedQuantity = currentStock - reduceQuantity;

                // with Direct Str parser
               items[i][2] = String.valueOf(updatedQuantity);

                return true;

            }
        }

        return false;
    }



    // Update stock when edited, purchased, etc
    public boolean updateStock(int i, int updateQuantity ) {

        if (i >= 0 && i < itemCount) {


            items[i][2] = String.valueOf(updateQuantity);

            return true;

        }

        return false;

    }

}

