# 02-003 LAB - Data Type Conversion: Double to Int

In this part of the lab, you will see how to convert a double to an int. This is useful when you want to discard the decimal part. This process of converting is called **casting**.

## Steps

### 1. Create the File

Create a file named `DataDoubleToInt.java` inside the src directory:

```bash
touch /home/project/my_datatypes_proj/src/DataDoubleToInt.java
```

Click on the button below to open the file for editing.

### 2. Add the Program Content

Read each statement in the following program and understand what each of the data types represent. Paste the following content in `DataDoubleToInt.java`:

```java
public class DataDoubleToInt {
    public static void main(String s[]) {
        double area_circle = 78.53981634d;
        System.out.println("Area of circle of 5cm radius is  " + area_circle);
        System.out.println("Area of circle of 5cm radius is  " + (int)area_circle);
    }
}
```

### 3. Compile the Java Program

Compile the Java program, explicitly specifying the destination directory as the classes directory that you created:

```bash
javac -d classes src/DataDoubleToInt.java
```

### 4. Run the Java Program

Now run the Java program:

```bash
java DataDoubleToInt
```

### Expected Output

You will see the output as below:

```
Area of circle of 5cm radius is  78.53981634
Area of circle of 5cm radius is  78
```
