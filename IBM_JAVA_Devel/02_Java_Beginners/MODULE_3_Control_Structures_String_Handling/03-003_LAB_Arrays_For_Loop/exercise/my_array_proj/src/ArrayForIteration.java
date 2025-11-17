/*
 * IBM Java Certification > Course 2 'Java Beginners'
 * Lab Exercise -> Module 3 > 03-003 'Array Creation and Accessing'
 * 
 * 03 - Array iteration with For loop
 */

 public class ArrayForIteration {

    public static void main(String s[]) {

        int years[] = new int[6];

        years[0] = 2020;
        years[1] = 2021;
        years[2] = 2022;
        years[3] = 2023;
        years[4] = 2024;
        years[5] = 2025;

        int count_years = years.length;
        System.out.println("Array length -> " + count_years);

        /*
        for (int i = 0; i < count_years; i++) {

            System.out.println(years[i]);

        }
        */

        for (
            
            int i = 0;
            
            i < count_years;
            
            i++

        ) {
            System.out.println(years[i]);
        }


    }


 }