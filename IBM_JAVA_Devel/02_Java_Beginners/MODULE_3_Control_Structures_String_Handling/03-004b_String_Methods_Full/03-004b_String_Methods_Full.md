# 03-006b   Java String Methods 

---

## 1. `.length()`

**Description:** Returns the number of characters in the string.

**Syntax:**

```java
int length = str.length();
```

**Example:**

```java
String str = "Hello World";
System.out.println(str.length()); // 11
```

---

## 2. `.charAt()`

**Description:** Returns the character at a specific index.

**Syntax:**

```java
char c = str.charAt(index);
```

**Example:**

```java
System.out.println(str.charAt(6)); // 'W'
```

---

## 3. `.equals()` / `.equalsIgnoreCase()`

**Description:** Compares two strings for equality.

**Syntax:**

```java
boolean eq = str1.equals(str2);
boolean eqIgnore = str1.equalsIgnoreCase(str2);
```

**Example:**

```java
System.out.println("Hello".equals("hello")); // false
System.out.println("Hello".equalsIgnoreCase("hello")); // true
```

---

## 4. Search methods

* `.contains(substring)` – checks if substring exists.
* `.startsWith(prefix)` – checks if string starts with prefix.
* `.endsWith(suffix)` – checks if string ends with suffix.
* `.indexOf(substring)` – returns first occurrence.
* `.lastIndexOf(substring)` – returns last occurrence.

**Example:**

```java
String str = "The Quick Fox";
System.out.println(str.contains("Quick")); // true
System.out.println(str.startsWith("The")); // true
System.out.println(str.endsWith("Fox")); // true
System.out.println(str.indexOf("Fox")); // 10
System.out.println(str.lastIndexOf("The")); // 0
```

---

## 5. Replace methods

* `.replace(oldChar/String, newChar/String)` – replaces all occurrences.
* `.replaceAll(regex, replacement)` – regex-based replacement.
* `.replaceFirst(regex, replacement)` – replaces only first match.

**Example:**

```java
String str = "The Dog jumped";
System.out.println(str.replace("Dog", "Cat")); // "The Cat jumped"
System.out.println(str.replaceAll("[aeiou]", "*")); // "Th* D*g j*mp*d"
System.out.println(str.replaceFirst("[aeiou]", "#")); // "Th# Dog jumped"
```

---

## 6. `.substring()`

**Description:** Extracts a portion of the string.

**Syntax:**

```java
String sub = str.substring(startIndex, endIndex);
```

**Example:**

```java
String str = "The Quick Fox";
System.out.println(str.substring(4, 9)); // "Quick"
```

---

## 7. Case conversion

* `.toUpperCase()` – converts string to upper case.
* `.toLowerCase()` – converts string to lower case.

**Example:**

```java
System.out.println(str.toUpperCase()); // "THE QUICK FOX"
System.out.println(str.toLowerCase()); // "the quick fox"
```

---

## 8. Trimming & stripping

* `.trim()` – removes leading/trailing spaces.
* `.strip()` – Java 11+, removes all whitespace.
* `.stripLeading()` – Java 11+, removes leading spaces.
* `.stripTrailing()` – Java 11+, removes trailing spaces.

**Example:**

```java
String str = "   Hello World   ";
System.out.println("'" + str.trim() + "'"); // 'Hello World'
System.out.println("'" + str.strip() + "'"); // 'Hello World'
```

---

## 9. `.isEmpty()` / `.isBlank()`

**Description:** Checks if string is empty or blank (blank includes only whitespace).

**Example:**

```java
String str = " ";
System.out.println(str.isEmpty()); // false
System.out.println(str.isBlank()); // true (Java 11+)
```

---

## 10. `.split()`

**Description:** Splits string into array by a delimiter.

**Example:**

```java
String str = "The Quick Fox";
String[] words = str.split(" ");
for(String w : words) { System.out.println(w); }
```

---

## 11. `.join()`

**Description:** Joins array of strings using a delimiter (Java 8+).

**Example:**

```java
String joined = String.join("-", words);
System.out.println(joined); // "The-Quick-Fox"
```

---

## 12. `.matches()`

**Description:** Checks if string matches a regular expression.

**Example:**

```java
String str = "Hello123";
System.out.println(str.matches("\\w+")); // true
```

---

## 13. `.repeat()`

**Description:** Repeats string multiple times (Java 11+).

**Example:**

```java
System.out.println("Hi! ".repeat(3)); // "Hi! Hi! Hi! "
```

---

## 14. `.indent()`

**Description:** Adds indentation to each line (Java 12+).

**Example:**

```java
String str = "Hello\nWorld";
System.out.println(str.indent(4));
```

---

## 15. `.transform()`

**Description:** Applies a function to the string and returns the result (Java 12+).

**Example:**

```java
System.out.println(str.transform(s -> s.toUpperCase()));
```

---

## 16. Code point methods

* `.codePointAt(index)` – Unicode code point at index.
* `.codePointBefore(index)` – code point before index.
* `.codePointCount(begin, end)` – counts code points in range.

**Example:**

```java
System.out.println(str.codePointAt(5));
System.out.println(str.codePointBefore(5));
System.out.println(str.codePointCount(0,10));
```

---

## 17. `.offsetByCodePoints()`

**Description:** Returns index offset by code points from start.

**Example:**

```java
System.out.println(str.offsetByCodePoints(0,5));
```

---

## 18. `.compareTo()` / `.compareToIgnoreCase()`

**Description:** Lexicographical comparison.

**Example:**

```java
System.out.println(str.compareTo("Other"));
System.out.println(str.compareToIgnoreCase("other"));
```

---

## 19. `String.valueOf()`

**Description:** Converts various types to string.

**Example:**

```java
int n = 42;
System.out.println(String.valueOf(n)); // "42"
```

---

## 20. `String.format()`

**Description:** Returns formatted string using specifiers.

**Example:**

```java
System.out.println(String.format("Hello %s! You have %d messages.", "Alice", 5));
```

---


