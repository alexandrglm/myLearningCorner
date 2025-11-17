
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
```

---
