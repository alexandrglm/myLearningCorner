# Using Conditional Statements

## `if` Statement

The `if` statement checks a condition. If the condition is true, it executes the code inside the block. If the condition is false, the program skips the `if` block.

| Description | Example |
|-------------|---------|
| A Java class named `Main` with a `main` method. The `main` method is the entry point of the program. | `public class Main {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| A variable `number` of type `int` is declared and initialised with the value 10. | `int number = 10;` |
| The `if` statement checks if `number` is greater than 5. If true, it prints "The number is greater than 5." | `if (number > 5) {`<br/>`    System.out.println("The number is greater than 5.");`<br/>`}` |
| Closing curly braces to end the `main` method and class definition. | `    }`<br/>`}` |

**Explanation:** Since `number` is 10, which is greater than 5, the condition evaluates to true, and the program prints "The number is greater than 5."

---

## `if-else` Statement

The `if-else` statement gives an alternative if the condition is false.

| Description | Example |
|-------------|---------|
| A Java class named `Main` with a `main` method. The `main` method is the entry point of the program. | `public class Main {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| A variable `number` of type `int` is declared and initialised with the value 3. | `int number = 3;` |
| The `if` statement checks if `number` is greater than 5. If true, it prints "The number is greater than 5." | `if (number > 5) {`<br/>`    System.out.println("The number is greater than 5.");`<br/>`}` |
| The `else` block executes when the `if` condition is false, printing "The number is not greater than 5." | `else {`<br/>`    System.out.println("The number is not greater than 5.");`<br/>`}` |
| Closing curly braces to end the `main` method and class definition. | `    }`<br/>`}` |

---

## `else if` Statement

You can check multiple conditions using `else if`.

| Description | Example |
|-------------|---------|
| A Java class named `Main` with a `main` method. The `main` method is the entry point of the program. | `public class Main {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| A variable `number` of type `int` is declared and initialised with the value 5. | `int number = 5;` |
| The `if` statement checks if `number` is greater than 5. If true, it prints "The number is greater than 5." | `if (number > 5) {`<br/>`    System.out.println("The number is greater than 5.");`<br/>`}` |
| The `else if` statement checks if `number` is exactly 5. If true, it prints "The number is equal to 5." | `else if (number == 5) {`<br/>`    System.out.println("The number is equal to 5.");`<br/>`}` |
| The `else` block executes when none of the above conditions are met, printing "The number is less than 5." | `else {`<br/>`    System.out.println("The number is less than 5.");`<br/>`}` |
| Closing curly braces to end the `main` method and class definition. | `    }`<br/>`}` |

**Explanation:** Since `number` is exactly 5, the program prints "The number is equal to 5."

---

## `switch` Statement

A `switch` statement checks a single variable against multiple values.

| Description | Example |
|-------------|---------|
| A Java class named `Main` with a `main` method. The `main` method is the entry point of the program. | `public class Main {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| A variable `day` of type `int` is declared and initialised with the value 3. | `int day = 3;` |
| The `switch` statement checks the value of `day` and compares it against the case labels. If `day` is 3, it prints "Wednesday". | `switch (day) {`<br/>`    case 1:`<br/>`        System.out.println("Monday");`<br/>`        break;`<br/>`    case 2:`<br/>`        System.out.println("Tuesday");`<br/>`        break;`<br/>`    case 3:`<br/>`        System.out.println("Wednesday");`<br/>`        break;`<br/>`    case 4:`<br/>`        System.out.println("Thursday");`<br/>`        break;`<br/>`    case 5:`<br/>`        System.out.println("Friday");`<br/>`        break;`<br/>`    default:`<br/>`        System.out.println("Weekend");`<br/>`}` |
| Closing curly braces to end the `main` method and class definition. | `    }`<br/>`}` |

---

## `default` Case in a `switch` Statement

When using a `switch` statement, it's good practice to specify a `default` case. This case runs if none of the specified cases match, acting as a fallback option.

| Description | Example |
|-------------|---------|
| A `switch` statement checks the value of a variable `color`. | `switch (color) {` |
| A case checks if `color` is "red", printing "Colour is red." | `    case "red":`<br/>`        System.out.println("Colour is red.");`<br/>`        break;` |
| A case checks if `color` is "blue", printing "Colour is blue." | `    case "blue":`<br/>`        System.out.println("Colour is blue.");`<br/>`        break;` |
| The `default` case prints "Unknown colour." if `color` doesn't match "red" or "blue". | `    default:`<br/>`        System.out.println("Unknown colour.");`<br/>`}` |

---

## Nested Conditional Statements

You can place conditional statements within each other to create more complex decisions. The process of placing conditional statements within other conditional statements is called nesting.

| Description | Example |
|-------------|---------|
| A Java class named `Main` with a `main` method. The `main` method is the entry point of the program. | `public class Main {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| A variable `age` of type `int` is declared and initialised with the value 20. | `int age = 20;` |
| The `if` statement checks if `age` is greater than or equal to 18. If true, it prints "You are an adult." | `if (age >= 18) {`<br/>`    System.out.println("You are an adult.");`<br/>`}` |
| Another `if` statement checks if `age` is greater than or equal to 65, printing "You are a senior citizen." if true. | `if (age >= 65) {`<br/>`    System.out.println("You are a senior citizen.");`<br/>`}` |
| The `else` block executes if `age` is less than 18, printing "You are a minor." | `else {`<br/>`    System.out.println("You are a minor.");`<br/>`}` |
| Closing curly braces to end the `main` method and class definition. | `    }`<br/>`}` |
