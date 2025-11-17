# 03-003 LAB 04 - For Loops to Traverse Through an Array

When you work with an array, you might not always know the length of the array, especially if you did not create it. In programming, arrays are either created or passed on from other sources. In this part of the lab, you will be using a `length` array variable and `for` loop to traverse through the array.

## Step 1: Open the File

Click the button below to open the file for editing if it is not already open.

## Step 2: Add Program Content

Read each statement in the following program and understand how the length of the array is determined and the loop is used to traverse through. Paste the following content in `ArrayAccess.java`:

```java
public class ArrayAccess {
    public static void main(String s[]) {
        int years[] = new int[6];
        years[0] = 2020;
        years[1] = 2021;
        years[2] = 2022;
        years[3] = 2023;
        years[4] = 2024;
        years[5] = 2025;
        int count_years = years.length;
        System.out.println("the length of the array is " + count_years);
        for (int i=0; i<count_years; i++) {
            System.out.println(years[i]);
        }
    }
}
```

### Code Explanation

- **`int count_years = years.length;`** - Creates a variable named `count_years` and stores the value of the length of the array in the variable.

- **`for (int i=0; i<count_years; i++)`** - Creates a `for` loop. The `for` loop has 3 parts: the initial value, the condition, and the incremental value. In this exercise, you are going to use variable `i` to traverse through the index positions of the array.

  - The code begins with the initial value of `i` equal to zero (0)
  - The code checks the condition to see if the value of `i` is less than the length of the array
  - Then it increments the value of `i` after one loop is executed
  - The code checks the condition every time the loop increments
  - The code block enclosed within the brackets after creation of the `for` loop continues to run until the condition is met

## Step 3: Compile the Java Program

Compile the Java program, specifying the destination directory using the classes directory that you previously created:

```bash
javac -d classes src/ArrayAccess.java
```

## Step 4: Run the Java Program

Now run the Java program:

```bash
java ArrayAccess
```

### Expected Output

You will see the following output:

```
the length of the array is 6
2020
2021
2022
2023
2024
2025
```

As you can see, the loop iterated through the array for as long as the array had an element remaining to print and then printed that element.
