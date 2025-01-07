package com.example;

/**
 * Create a function which recieves a price before tax rates and, then, shows the final price including tax rates (21%)
 * Also, add a method to round the prices: Rounding Mode
 * New data type will be used: BigDecimal
 * New passing values method will be used: .THEDATATYPEValue() .... To Double: .DoubleValue()
 * Rounding Mode syntax:
 * BigDecimal(val: theVariablewithBigDecimals).setScale(2, RoundingMode.HALF_UP);
 *
 * So, BigDecimal and RoundingMode have to be loaded (imported) at the first time.
 *
 * The most important part of this exercise is passing values as arguments in a function.
 * BigDecimals and RoundingMode methods are secondary for this.
 */

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FunctionExercise1 {

    public static void main(String[] args) {

        double thePrice = 100.99;

        BigDecimal theTaxes = new BigDecimal(thePrice * 0.21).setScale(2, RoundingMode.HALF_UP);

        BigDecimal finalPrice = new BigDecimal(thePrice).add(theTaxes).setScale(2, RoundingMode.HALF_UP);
        
        // This is the way letting a function "to exist"
        String printTheResults = getTheFinalPrice(thePrice, theTaxes, finalPrice);
        System.out.println(printTheResults);

    }

    static String getTheFinalPrice(double thePrice, BigDecimal theTaxes, BigDecimal finalPrice) {
        return "The article's price before tax rates is: " + thePrice + " euro." +  "\nFinal price is: " + finalPrice.doubleValue() + " euro." +  "\nThe tax rates for this operation is: " + theTaxes.doubleValue() + " euro.";

    }
}
