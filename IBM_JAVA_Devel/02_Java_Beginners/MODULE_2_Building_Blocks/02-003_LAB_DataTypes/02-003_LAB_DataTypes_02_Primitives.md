# 02-003 LAB - Primitive Data Types

## Primitive Data Types

Java supports the following primitive data types:

- byte
- short
- int
- long
- char
- boolean
- float
- double

The ones that are used most in programs are int, char, boolean, float and double. You will notice that there are no data types to handle words with more than one character. This is called String and Java handles String as an array of characters. You will explore each of these in this lab.

## Steps

### 1. Create a Project Directory

Run the following command:

```bash
mkdir my_datatypes_proj
```

### 2. Create the Directory Structure

Run the following code to create the directory structure:

```bash
mkdir -p my_datatypes_proj/src
mkdir -p my_datatypes_proj/classes
mkdir -p my_datatypes_proj/test
cd my_datatypes_proj
```

### 3. Create the DataTypes.java File

Create a file named `DataTypes.java` inside the src directory:

```bash
touch /home/project/my_datatypes_proj/src/DataTypes.java
```

Click on the button below to open the file for editing.

### 4. Add the Program Content

Read each statement in the following program and understand what each of the data types represent. Paste the following content in `DataTypes.java`:

```java
public class DataTypes {
    public static void main(String s[]) {
        //byte ranges from -128 to 127 
        //use for handling file data in binary format
        byte b = 125;
        System.out.println("Byte value " + b);
        
        //short ranges from -32,768 to 32,767
        //Suitable for memory-constrained environments where integers are too large
        // Used for Game scores, sensor readings etc.,
        short points = 3000;
        System.out.println("Points scored as 'short' value " + points);
        
        //int ranges from -2^31 to (2^31)-1
        //Suitable for all general purpose use of numbers
        // Suits values that are whole numbers
        int population = 4358000;
        System.out.println("Population as 'int' value " + population);
        
        //long ranges from -2^63 to (2^63)-1
        //Used for large numeric values, timestamps in milliseconds
        // It has to end with an l indicating it is a long integer
        long age_in_milliseconds = 788923800000l;
        System.out.println("Age of 25 years in milliseconds as 'long' value " + age_in_milliseconds);
        
        //char is used to store one character
        // Suitable for capturing keyboard input one key at a time
        // Used mostly as a group called arrays for words
        char keyboard_input = 'a';
        System.out.println("Key board input is "+keyboard_input);
        
        //boolean is used to true or false
        // Suitable for anything where the values can only be true or false
        boolean isLabCompleted = false;
        System.out.println("The lab is completed "+isLabCompleted);
        
        //float is used for numbers with decimals, with precision up to 7 decimal digits
        // Suitable for representing money, measurement of area, volume, etc.,
        // It has to end with an f
        float house_value = 4000000.58f;
        System.out.println("The value of the house is $"+house_value);
        
        //double is used for numbers with decimal, with precision up to 15 decimal digits
        // Suitable for representing statistical, astronomical measurements
        double pi = 3.14159265359;
        System.out.println("The value of pi is "+pi);
    }
}
```

### 5. Compile the Java Program

Compile the Java program, explicitly specifying the destination directory as the classes directory that you created:

```bash
javac -d classes src/DataTypes.java
```

### 6. Set the CLASSPATH Variable

Set the CLASSPATH variable:

```bash
export CLASSPATH=$CLASSPATH:/home/project/my_datatypes_proj/classes
```

### 7. Run the Java Program

Now when you run the Java program, it will run seamlessly as expected:

```bash
java DataTypes
```

### Expected Output

You will see the output as below:

```
Byte value 125
Points scored as 'short' value 3000
Population as 'int' value 4358000
Age of 25 years in milliseconds as 'long' value 788923800000
Key board input is a
The lab is completed false
The value of the house is $4000000.5
The value of pi is 3.14159265359
```
