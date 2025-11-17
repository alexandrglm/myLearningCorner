
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
