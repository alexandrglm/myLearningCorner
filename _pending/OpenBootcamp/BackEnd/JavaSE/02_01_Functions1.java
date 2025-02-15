package com.example;

public class Functions {

    public static void main(String[] args) {

        // 1:   "No Params - No return" function type
        showMenu();

        // 2:   "No params - with return" function type
        System.out.println(getMenu());

        String menu = getMenu();
        System.out.println(menu);

        double price = getPrice();
        System.out.println(price);


        // 3:   "Params - NO return" function
        imprimirSaludo("OpenBootcamp");


        // 4: "Params + Return" function
        String name = "Alexandr";
        String surname = "Gomez" ;
        String greeting = getTheGreeting(name, surname);
        System.out.println(greeting);


    }

    static double getPrice() {
        return 100.99;
    }

    /**
     * // 1:   "No Params - No return" function type
     * static needed
     * void: no return
     */
    static void showMenu() {
        System.out.println("Welcome to this e-commerce menu:");
        System.out.println("1 - Look the catalog");
        System.out.println("2 - Buy");
        System.out.println("3 - Exit");


    }

    // 2:   "No params - With return" function type
    static String getMenu() {
        System.out.println("invoking by returning the function");
        return "Welcome to this e-commerce menu:\n 1 - Look the catalog\n 2 - Buy\n 3 - Exit";
    }

    // 3:   "Params - NO return" function
    static void imprimirSaludo(String greetingName) {
        System.out.println("Hello, " + greetingName + "!");

    }

    // 4: "Params + Return" function
    static String getTheGreeting(String name, String surname) {
        return "Hello, " + name + " " + surname +  "!";
    }



}
