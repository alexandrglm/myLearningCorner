# 03-003 LAB 03 - Initialise and Create the Array

You must first initialise an array before assigning values to its various index positions. Let's learn how to do these tasks.

## Step 1: Open the File

Click the **Open ArrayAccess.java in IDE** button to open the file for editing if the IDE is not already open.

## Step 2: Add Program Content

Read each statement in the following program to understand how the program initialises the array and how each the program assigns each element later. Paste the following content in `ArrayAccess.java`:

```java
public class ArrayAccess {
    public static void main(String s[]) {
        int years[] = new int[6];
        years[1] = 2021;
        years[3] = 2023;
        System.out.println(years[0]);
        System.out.println(years[1]);
        System.out.println(years[2]);
        System.out.println(years[3]);
        System.out.println(years[4]);
        System.out.println(years[5]);
    }
}
```

### Code Explanation

- **`int years[] = new int[6];`** - An array named `years` of type `int` is declared. The array is initialised to hold six (6) elements. When an array initialises, depending on the type of array, the array has default values. An `int` array by default, has the value of zero (0).

- **`years[n]`** - Allocates an element at the specified index n. In this example at 1 and 3.

- **`System.out.println(years[n]);`** - Prints the element in nth position, where n starts from 0. In this example, as you are only assigning values to index 1 and 3, you will see what values are allocated to the rest of the elements when you compile and run the code.

## Step 3: Compile the Java Program

Compile the Java program, specifying the destination directory as the classes directory that you created:

```bash
javac -d classes src/ArrayAccess.java
```

## Step 4: Run the Java Program

Now run the Java program:

```bash
java ArrayAccess
```

### Expected Output

You will see the output as below:

```
0
2021
0
2023
0
0
```

You can see that the index positions that were not assigned values have the values of zero (0) by default as the array was initialised and then assigned.
