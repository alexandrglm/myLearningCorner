# Working with Strings in Java

## Creating Strings

You can create a string in Java in two main ways:

### Using String Literals

This means writing the string directly inside double quotes.

| Description | Example |
|-------------|---------|
| Create a string using string literal. | `String greeting = "Hello, World!";` |

In this example, we created a string called `greeting` that contains `"Hello, World!"`.

### Using the `new` Keyword

This method involves using the `new` keyword to create a string object.

| Description | Example |
|-------------|---------|
| Create a string using the `new` keyword. | `String message = new String("Hello, World!");` |

Although this works, it's more common to use string literals because it's simpler.

---

## String Length

To find out how many characters are in a string, you can use the `length()` method. This method tells you the total number of characters in the string.

| Description | Example |
|-------------|---------|
| Create a string and use `length()` to get the number of characters. | `String text = "Java Programming";` |
| Use the `length()` method to find the string length. | `int length = text.length();` |
| Print the length of the string. | `System.out.println("Length of the string: " + length); // Output: 16` |

Here, we created a string called `text` and then checked its length. The output tells us that there are 16 characters in "Java Programming".

---

## Accessing Characters

If you want to look at individual characters in a string, you can use the `charAt()` method. This method allows you to get a character at a specific position in the string.

| Description | Example |
|-------------|---------|
| Create a string and access a character using `charAt()`. | `String word = "Java";` |
| Access the first character of the string. | `char firstChar = word.charAt(0);` |
| Print the first character of the string. | `System.out.println("First character: " + firstChar); // Output: J` |

In this example, we accessed the first character of the string "Java". Remember that counting starts at 0, so `charAt(0)` gives us 'J'.

---

## Concatenating Strings

Sometimes you might want to combine two or more strings together. You can do this easily using the `+` operator or the `concat()` method.

| Description | Example |
|-------------|---------|
| Combine two strings using the `+` operator. | `String firstName = "John";` |
| Combine two strings using the `+` operator. | `String lastName = "Doe";` |
| Concatenate first and last names using the `+` operator. | `String fullName = firstName + " " + lastName;` |
| Print the full name. | `System.out.println("Full Name: " + fullName); // Output: John Doe` |

Here, we combined `firstName` and `lastName` using the `+` operator and added a space between them.

You can also use the `concat()` method:

| Description | Example |
|-------------|---------|
| Combine strings using the `concat()` method. | `String anotherFullName = firstName.concat(" ").concat(lastName);` |
| Print the concatenated string. | `System.out.println("Another Full Name: " + anotherFullName); // Output: John Doe` |

---

## String Comparison

When you want to check if two strings are the same, use the `equals()` method. This checks if both strings have identical content.

| Description | Example |
|-------------|---------|
| Create three strings to compare. | `String str1 = "Hello";` |
| Create another string to compare. | `String str2 = "Hello";` |
| Create a third string to compare. | `String str3 = "World";` |
| Check if `str1` is equal to `str2`. | `boolean isEqual = str1.equals(str2);` |
| Print comparison result. | `System.out.println("str1 equals str2: " + isEqual); // Output: true` |
| Check if `str1` is equal to `str3`. | `boolean isNotEqual = str1.equals(str3);` |
| Print comparison result. | `System.out.println("str1 equals str3: " + isNotEqual); // Output: false` |

In this example, `isEqual` returns `true` because both strings are "Hello". However, `isNotEqual` returns `false` since "Hello" and "World" are different.

---

## String Immutability

One important thing to know about strings in Java is that they are immutable. This means that once a string is created, it cannot be changed. If you try to change it, you will actually create a new string instead.

| Description | Example |
|-------------|---------|
| Create an original string. | `String original = "Hello";` |
| Add to the string (creates a new string). | `original = original + " World";` |
| Print the new string. | `System.out.println(original); // Output: Hello World` |

In this case, we added "World" to `original`, but instead of changing the original string, we created a new string that combines both parts.

---

## Finding Substrings

You may want to get a smaller part of a string. You can do this using the `substring()` method, which allows you to specify where to start and where to stop.

| Description | Example |
|-------------|---------|
| Create a string and extract a substring. | `String phrase = "Java Programming";` |
| Extract a substring from the string. | `String sub = phrase.substring(5, 16);` |
| Print the extracted substring. | `System.out.println("Substring: " + sub); // Output: Programming` |

In this example, we started at index 5 and went up to (but did not include) index 16 to extract "Programming".

---

## String Methods

Java has many built-in methods for strings that help you manipulate and process them. Here are some useful ones:

### `toUpperCase()`

This method converts all letters in a string to uppercase.

| Description | Example |
|-------------|---------|
| Create a string. | `String text = "hello";` |
| Convert the string to uppercase. | `System.out.println(text.toUpperCase()); // Output: HELLO` |

### `toLowerCase()`

This converts all letters in a string to lowercase.

| Description | Example |
|-------------|---------|
| Create a string. | `String text = "WORLD";` |
| Convert the string to lowercase. | `System.out.println(text.toLowerCase()); // Output: world` |

### `trim()`

This method removes any extra spaces at the beginning or end of a string.

| Description | Example |
|-------------|---------|
| Create a string with extra spaces and trim it. | `String textWithSpaces = "   Hello   ";` |
| Remove spaces from the string. | `System.out.println(textWithSpaces.trim()); // Output: Hello` |

### `replace()`

If you want to change all instances of one character or substring to another, use this method.

| Description | Example |
|-------------|---------|
| Create a sentence and replace a word. | `String sentence = "I like cats.";` |
| Replace a word in the sentence. | `String newSentence = sentence.replace("cats", "dogs");` |
| Print the new sentence. | `System.out.println(newSentence); // Output: I like dogs.` |

---

## Splitting Strings

You can break a string into smaller pieces using the `split()` method. This is useful when you have data separated by commas or spaces.

| Description | Example |
|-------------|---------|
| Create a CSV string and split it. | `String csv = "apple,banana,cherry";` |
| Split the string at each comma. | `String[] fruits = csv.split(",");` |
| Print each fruit in the array. | `for (String fruit : fruits) {`<br/>`    System.out.println(fruit);`<br/>`}` |

**Output:**
```
apple
banana
cherry
```

---

## Joining Strings

If you have an array of strings and want to combine them back into one single string, you can use the `String.join()` method.

| Description | Example |
|-------------|---------|
| Create an array of strings. | `String[] colours = {"Red", "Green", "Blue"};` |
| Join the strings with a separator. | `String joinedColours = String.join(", ", colours);` |
| Print the joined string. | `System.out.println(joinedColours); // Output: Red, Green, Blue` |
