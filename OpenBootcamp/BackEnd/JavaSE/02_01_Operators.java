package com.example;

public class Operators {

    public static void main(String[] args) {

        // Arithmetics
        int number1 = 10;
        int number2 = 20;

        System.out.println(number1 + number2);  // Done by console log

        int resultSum = number1 + number2;    // This is a best practice, to avoid duplicing code. E.g., resultSum can be used many times since here instead of using all the vars with its arithmetic operator
        System.out.println(resultSum);

        int resultSubstract = number1 - number2;
        System.out.println(resultSubstract);

        int IVA21 = ( resultSum * 100 ) / 21;
        System.out.println("El Iva de esta operación es de : ${IVA21}  ");

        /*
         Comparisions
         > greater
         > less
         >=
         <=
         ==
         */
        boolean resultComparOne = number1 > number2;  // return: a Boolean
        System.out.println(resultComparOne);

        boolean resultComparTwo = number1 < number2;
        System.out.println(resultComparTwo);

        /*
         LOGICS
         and && double amper-sand
         or || double pipes
         */
        boolean result3 = number1 > 5 && number1 < 30;

        int age = 17;
        boolean drivingPermitAllowed = age >=18 && age < 21;
        boolean drivingLicenseAllowed = age >= 21;

    }

}
