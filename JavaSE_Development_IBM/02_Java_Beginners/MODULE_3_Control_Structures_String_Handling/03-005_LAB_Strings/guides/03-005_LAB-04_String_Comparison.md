# **Lab 01   Working with Strings**

### **Estimated time:** 30 minutes

In this lab, you will learn how to work with Strings in Java. You are using a cloud-based Integrated Development Environment (Cloud IDE) with JDK 21 pre-installed.

---

## **Learning Objectives**

After completing this lab, you will be able to:

- Create a String object in more than one way
- Calculate the length of a String
- Access each character of a String
- Concatenate Strings
- Compare Strings
- Use other methods in the String class as required

---

# **Lab 02   Create String Objects and Calculate Length**

String is simply an array of characters. In Java, String is one of the most basic and important objects and is part of the `java.lang` package.

All classes in Java implicitly inherit a `toString()` method from the Object class.

---

## **Create a project**

```bash
mkdir my_string_proj
```

```bash
mkdir -p my_string_proj/src
mkdir -p my_string_proj/classes
mkdir -p my_string_proj/test
cd my_string_proj
```

---

## **Create the file**

```bash
touch /home/project/my_string_proj/src/StringOps.java
```

Paste this into **StringOps.java**:

```java
public class StringOps {
    public static void main(String s[]) {
        String s1 = "Hello World";
        System.out.println(s1);
        String s2 = new String("Hello World");
        System.out.println(s2);
    }
}
```

### **Explanation**

- `String s1 = "Hello World";`   creates a String literal
- `String s2 = new String("Hello World");`   creates a String object

---

## **Compile**

```bash
javac -d classes src/StringOps.java
```

Set the CLASSPATH:

```bash
export CLASSPATH=$CLASSPATH:/home/project/my_string_proj/classes
```

Run again:

```bash
javac -d classes src/StringOps.java
```

---

## **Run**

```bash
java StringOps
```

Output:

```
Hello World
Hello World
```

---

## **Literal vs Object**

Replace code with:

```java
public class StringOps {
    public static void main(String s[]) {
        String s1 = "Hello World";
        System.out.println(s1);
        String s2 = new String("Hello World");
        System.out.println(s2);
        String s3 = "Hello World";
        System.out.println("s1 and s2 comparison "+ (s1 == s2));
        System.out.println("s2 and s3 comparison "+ (s2 == s3));
        System.out.println("s1 and s3 comparison "+ (s1 == s3));
    }
}
```

Compile:

```bash
javac -d classes src/StringOps.java
```

Run:

```bash
java StringOps
```

Output:

```
Hello World
Hello World
s1 and s2 comparison false
s2 and s3 comparison false
s1 and s3 comparison true
```

---

# **Lab 03   Find Length of the String and Access Characters**

String is an array of characters. The length of the string matches the length of its underlying character array. The String class provides a method to get this length.

Replace existing code with:

```java
public class StringOps {
    public static void main(String s[]) {
        String s1 = "The quick brown fox jumped over the lazy dog";
        System.out.println(s1.length());
        char[] strAsArr = s1.toCharArray();
        System.out.println(strAsArr.length);
        System.out.println(strAsArr);
        System.out.println("The first char of the string is " + strAsArr[0]);
        System.out.println("The last char of the string is " + strAsArr[strAsArr.length-1]);
        System.out.println("The index of T is " + s1.indexOf('T'));
        System.out.println("The index of g is " + s1.indexOf('g'));
    }
}
```

Compile:

```bash
javac -d classes src/StringOps.java
```

Run:

```bash
java StringOps
```

Expected output:

```
44
44
The quick brown fox jumped over the lazy dog
The first char of the string is T
The last char of the string is g
The index of T is 0
The index of g is 43


---

# **Lab   String Comparison**

Comparing two Strings with `==` checks if they refer to the same object, not if their contents are equal. This lab explores proper ways to compare Strings.

---

## **Code**

```java
public class StringOps {
    public static void main(String s[]) {
        String s1 = "Washington";
        String s2 = new String("Washington");
        String s3 = "WASHINGTON";
        System.out.println("Equality check s1 and s2 - "+s1.equals(s2));
        System.out.println("Equality check s1 and s3 - "+s1.equals(s3));
        System.out.println("Equality check s1 and s3 ignoring case - "+s1.equalsIgnoreCase(s3));
        System.out.println("s1 in lowercase - "+s1.toLowerCase());
        System.out.println("s3 in lowercase - "+s3.toLowerCase());
        System.out.println("s1 and s3 lowercase equality check - " +
                            s1.toLowerCase().equals((s3.toLowerCase())));
        System.out.println("s1 in uppercase - "+s1.toUpperCase());
        System.out.println("s3 in uppercase - "+s3.toUpperCase());
        String s4 = "50F1A";
        System.out.println("s4 in lowercase - "+s4.toLowerCase());
        String regexStr = "^W.*";
        System.out.println("s1 matches regex ^W.* - "+s1.matches(regexStr));
        System.out.println("s3 matches regex ^W.* - "+s3.matches(regexStr));
        String s5 = "     WASHINGTON          ";
        System.out.println("Equality check s3 and s5 - "+s3.equals(s5));
        s5 = s5.strip();
        System.out.println("Equality check after stripping s3 and s5 - "+s3.equals(s5));
    }
}
```

---

## **Method summary**

- **`.equals`**   true only if both Strings have identical content, including spaces.
- **`.equalsIgnoreCase`**   true if characters are identical ignoring case, but no extra spaces allowed.
- **`.toLowerCase()`**   returns a new String with all characters converted to lowercase.
- **`.toUpperCase()`**   returns a new String with all characters converted to uppercase.
- **`.strip()`**   removes leading and trailing whitespace.
- **`.matches()`**   checks if the String matches a regular expression. `^W.*` matches any String starting with capital `W`.

---

## **Compile**

```bash
javac -d classes src/StringOps.java
```

## **Run**

```bash
java StringOps
```

### **Expected output**

```
Equality check s1 and s2 - true
Equality check s1 and s3 - false
Equality check s1 and s3 ignoring case - true
s1 in lowercase - washington
s3 in lowercase - washington
s1 and s3 lowercase equality check - true
s1 in uppercase - WASHINGTON
s3 in uppercase - WASHINGTON
s4 in lowercase - 50f1a
s1 matches regex ^W.* - true
s3 matches regex ^W.* - true
Equality check s3 and s5 - false
Equality check after stripping s3 and s5 - true
```

---
