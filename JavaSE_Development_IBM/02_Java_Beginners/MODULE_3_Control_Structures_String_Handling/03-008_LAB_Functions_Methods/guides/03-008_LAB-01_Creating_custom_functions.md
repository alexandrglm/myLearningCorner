# 03-008 LAB 01 - Creating a Custom Function

When creating a custom function for a class, it is important to decide whether the function has to be `static` or not. A `static` method doesn't require an object of the class to be created. An example of a method which can be `static` is a method which returns the pi value. They're associated with the class itself, not with objects of the class.

## Step 1: Create a Project Directory

Run the following command:

```bash
mkdir my_custom_method_proj
```

## Step 2: Create the Directory Structure

Run the following code to create the directory structure:

```bash
mkdir -p my_custom_method_proj/src
mkdir -p my_custom_method_proj/classes
mkdir -p my_custom_method_proj/test
cd my_custom_method_proj
```

## Step 3: Create AreaCalculator.java File

Create a file named `AreaCalculator.java` inside the src directory:

```bash
touch /home/project/my_custom_method_proj/src/AreaCalculator.java
```

Click the following button to open the file for editing.

## Step 4: Create the Skeleton Structure

Create the skeleton structure for the `AreaCalculator` programme. Paste the following content in `AreaCalculator.java`:

```java
//import Scanner to read user input
import java.util.Scanner;

public class AreaCalculator {
    //Add the methods to calculate area here
    
    public static void main(String s[]) {
        System.out.println("Welcome to the area calculator!");
        while(true) {
            //Add the menu to get user input and invoke method here
        }
    }
}
```

## Step 5: Add the Methods

You will now add the methods that you want to include in an `AreaCalculator` to calculate the area of basic shapes such as circle, square, and rectangle.

- **Circle:** You will need the radius of the circle to calculate the area. The area can be calculated using the formula `(pi × r²)` where `r` is the radius that needs to be provided as a parameter to the function.

- **Square:** You will need the length or breadth of the square to calculate the area. The area can be calculated using the formula `(length × length)` or `(breadth × breadth)`. In the case of a square, both are the same and that needs to be provided as a parameter to the function.

- **Rectangle:** You will need the length and breadth of the rectangle to calculate the area. The area can be calculated using the formula `(length × breadth)`. Both length and breadth need to be provided as parameters to the function.

Paste the following content in `AreaCalculator.java` inside the class, before the `main` method:

```java
private static float pi = 3.142f;

private static float circle(float radius) {
    return (pi * radius * radius);
}

private static float square(float length) {
    return length * length;
}

private static float rectangle(float length, float breadth) {
    return length * breadth;
}
```

### Method Explanation

- The methods are **`private`**, meaning they can only be called within the class
- The methods are **`static`**, meaning you don't have to create an instance of the class to invoke them
- All methods **return a `float`**, meaning the return value can have decimal places

## Step 6: Add the Main Method Logic

Paste the following content in `AreaCalculator.java` inside the `main` method, replacing the comment:

```java
System.out.println("\nEnter 1 for circle\n" +
                  "Enter 2 for square\n" +
                  "Enter 3 for rectangle");
Scanner scanner = new Scanner(System.in);
int choice = Integer.parseInt(scanner.nextLine());

if (choice == 1) {
    System.out.println("Enter the radius of the circle");
    float radius = Float.parseFloat(scanner.nextLine());
    System.out.println("The area of circle of radius " + radius + " is " + circle(radius));
} else if (choice == 2) {
    System.out.println("Enter the length of the square");
    float length = Float.parseFloat(scanner.nextLine());
    System.out.println("The area of square of side length " + length + " is " + square(length));
} else if (choice == 3) {
    System.out.println("Enter the length of the rectangle");
    float length = Float.parseFloat(scanner.nextLine());
    System.out.println("Enter the breadth of the rectangle");
    float breadth = Float.parseFloat(scanner.nextLine());
    System.out.println("The area of rectangle of length " + length + 
                        " and breadth " + breadth + " is " + rectangle(length, breadth));
} else {
    System.out.println("Invalid choice");
    break;
}
```

### Code Explanation

- A `Scanner` object is used to read user input from the console
- The user's input is converted into an `int` using `Integer.parseInt()`
- If the user enters `1` for circle, they are asked to input the circle's radius. The radius (input as `String`) is converted into a `float` using `Float.parseFloat()`. The `circle()` method is called, and its result is displayed.
- If the user enters `2` for square, they are asked to input the square's side length. The `square()` method is called, and its result is displayed.
- If the user enters `3` for rectangle, they are asked to input the rectangle's length and breadth. The `rectangle()` method is called, and its result is displayed.

## Step 7: Complete Program

After you complete all the code, you will see the following programme:

```java
import java.util.Scanner;

public class AreaCalculator {
    private static float pi = 3.142f;
    
    private static float circle(float radius) {
        return (pi * radius * radius);
    }
    
    private static float square(float length) {
        return length * length;
    }
    
    private static float rectangle(float length, float breadth) {
        return length * breadth;
    }
    
    public static void main(String s[]) {
        System.out.println("Welcome to the area calculator!");
        while(true) {
            System.out.println("\nEnter 1 for circle\n" +
                              "Enter 2 for square\n" +
                              "Enter 3 for rectangle");
            Scanner scanner = new Scanner(System.in);
            int choice = Integer.parseInt(scanner.nextLine());
            
            if (choice == 1) {
                System.out.println("Enter the radius of the circle");
                float radius = Float.parseFloat(scanner.nextLine());
                System.out.println("The area of circle of radius " + radius + " is " + circle(radius));
            } else if (choice == 2) {
                System.out.println("Enter the length of the square");
                float length = Float.parseFloat(scanner.nextLine());
                System.out.println("The area of square of side length " + length + " is " + square(length));
            } else if (choice == 3) {
                System.out.println("Enter the length of the rectangle");
                float length = Float.parseFloat(scanner.nextLine());
                System.out.println("Enter the breadth of the rectangle");
                float breadth = Float.parseFloat(scanner.nextLine());
                System.out.println("The area of rectangle of length " + length + 
                                    " and breadth " + breadth + " is " + rectangle(length, breadth));
            } else {
                System.out.println("Invalid choice");
                break;
            }
        }
    }
}
```

## Step 8: Compile the Java Program

Compile the Java programme, specifying the destination directory as the classes directory that you created:

```bash
javac -d classes src/AreaCalculator.java
```

## Step 9: Set the CLASSPATH Variable

Set the `CLASSPATH` variable:

```bash
export CLASSPATH=$CLASSPATH:/home/project/my_custom_method_proj/classes
```

## Step 10: Run the Program

Run the programme and test with variable combinations:

```bash
java AreaCalculator
```

### Expected Output

You will see the following output:

```
Welcome to the area calculator!

Enter 1 for circle
Enter 2 for square
Enter 3 for rectangle
1
Enter the radius of the circle
8
The area of circle of radius 8.0 is 201.088

Enter 1 for circle
Enter 2 for square
Enter 3 for rectangle
```
