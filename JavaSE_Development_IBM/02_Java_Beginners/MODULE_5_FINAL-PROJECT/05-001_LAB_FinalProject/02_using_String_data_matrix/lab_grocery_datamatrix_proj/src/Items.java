/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Module 5 - Grading Exercise 1, Grocery Store
 * 
 * 04 - Items
*/


public class Items{

    // inits
    /*
    Why not Float - decimals? -> A matrix will be used
    
    1. ArrayList[][] inventoryData = {

        {"Peras", "Manzanas"},
        {"1.27", "0.95"},
        {"1212", "741"}

    }

    2. Methods for price parseFloat() + redondeo() / quantity parseInt() 

    3. redondeo() .... Math.round() implicit parseInt()
    

    */
    private String itemName;
    private String itemPrice;
    private String itemQuantity;



    // constructor
    public Items(String itemName, String itemPrice, String itemQuantity) {

        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;

    }

    // methods
    // priceParser String to float
    public float priceParser() {

        return Float.parseFloat(this.itemPrice);

    }

    // Quantity Parser
    public int quantityParser() {

        return Integer.parseInt(this.itemQuantity);

    }

    // Redondeo

    public static float redondeo(float itemPrice) {

        return Math.round(itemPrice * 100f) / 100f;

    } 

}