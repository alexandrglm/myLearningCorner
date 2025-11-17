# 03-003 LAB 02 - Array Creation and Elements Access

An array is a set of elements of a particular data type. In this section of the lab, you will create an array with the years from 2020 to 2025 stored in it.

## Step 1: Create a Project Directory

Run the following command:

```bash
mkdir my_array_proj
```

## Step 2: Create the Directory Structure

Run the following code to create the directory structure:

```bash
mkdir -p my_array_proj/src
mkdir -p my_array_proj/classes
mkdir -p my_array_proj/test
cd my_array_proj
```

## Step 3: Create ArrayAccess.java File

Create a file named `ArrayAccess.java` inside the src directory:

```bash
touch /home/project/my_array_proj/src/ArrayAccess.java
```

Click the **Open ArrayAccess.java in IDE** button to open the file for editing.

## Step 4: Add Program Content

Read each statement and the accompanying explanations in the following program to understand how to create the array and how to access each element in the array. Paste the following content in `ArrayAccess.java`:

```java
public class ArrayAccess {
    public static void main(String s[]) {
        int years[] = {2020,2021,2022,2023,2024,2025};
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

- **`int years[] = {2020,2021,2022,2023,2024,2025};`** - An array named `years` of type `int` is declared and it is initialised and assigned with some numbers.

- **`System.out.println(years[n]);`** - Prints the element in nth position, where n starts from 0. The first element of the array is accessed with index 0. If the length of the array is m, the index position of the last element of the array is m-1. In the case of the example used here, the length of the array is 6 and the index of the last element is 5.

## Step 5: Compile the Java Program

Compile the Java program, specifying the destination directory as the classes directory that you created:

```bash
javac -d classes src/ArrayAccess.java
```

## Step 6: Set the CLASSPATH Variable

Set the `CLASSPATH` variable:

```bash
export CLASSPATH=$CLASSPATH:/home/project/my_array_proj/classes
```

## Step 7: Run the Java Program

Now, when you run the Java program, the Java program will run seamlessly as expected:

```bash
java ArrayAccess
```

### Expected Output

You will see the following output:

```
2020
2021
2022
2023
2024
2025
```
