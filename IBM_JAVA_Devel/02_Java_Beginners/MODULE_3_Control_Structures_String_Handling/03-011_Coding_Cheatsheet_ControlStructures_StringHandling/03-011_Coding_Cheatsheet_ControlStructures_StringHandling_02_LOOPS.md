# Introduction to Loops in Java

## `for` Loop

The `for` loop is used when the number of iterations is known beforehand. It consists of three parts:

- **Initialisation:** This sets a counter variable.
- **Condition:** This checks if the loop should continue executing.
- **Increment/Decrement:** This updates the counter variable after each iteration.

| Description | Example |
|-------------|---------|
| A Java class named `ForLoopExample` with a `main` method. The `main` method is the entry point of the program. | `public class ForLoopExample {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| A `for` loop is initialised with `int i = 1`, which starts the counter at 1. The counter variable `i` is incremented by `i++` after each iteration. | `for (int i = 1; i <= 5; i++) {` |
| The loop checks if `i <= 5`, and if true, it prints the value of `i`. | `    System.out.println(i);` |
| Close the `for` loop. | `}` |
| Close the `main` method. | `}` |
| Close the `ForLoopExample` class. | `}` |

---

## `while` Loop

The `while` loop is used when the number of iterations is not known in advance. It continues executing as long as the specified condition remains true.

| Description | Example |
|-------------|---------|
| A Java class named `WhileLoopExample` with a `main` method. The `main` method is the entry point of the program. | `public class WhileLoopExample {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| A variable `i` is initialised to 1. | `int i = 1;` |
| The `while` loop continues as long as `i <= 5`. | `while (i <= 5) {` |
| Inside the loop, the value of `i` is printed, then incremented by `i++`. | `    System.out.println(i);`<br/>`    i++;`<br/>`}` |
| The `main` method and class are closed with curly braces. | `}`<br/>`}` |

---

## `do-while` Loop

The `do-while` loop is similar to the `while` loop but guarantees that the code block executes at least once before checking the condition.

| Description | Example |
|-------------|---------|
| A Java class named `DoWhileLoopExample` with a `main` method. The `main` method is the entry point of the program. | `public class DoWhileLoopExample {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| A variable `i` is initialised to 1. | `int i = 1;` |
| The `do-while` loop starts and executes at least once before checking if `i <= 5`. | `do {` |
| Inside the loop, the value of `i` is printed, then incremented by `i++`. | `    System.out.println(i);`<br/>`    i++;` |
| The condition `i <= 5` is checked after each iteration. | `} while (i <= 5);` |
| The `main` method and class are closed with curly braces. | `}`<br/>`}` |

---

## Nested Loops

You can also use loops inside other loops, known as nested loops. This is useful for working with multi-dimensional data structures, like arrays or matrices.

| Description | Example |
|-------------|---------|
| A Java class named `NestedLoopsExample` with a `main` method. The `main` method is the entry point of the program. | `public class NestedLoopsExample {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| The outer loop controls the rows, running 10 times. | `for (int i = 1; i <= 10; i++) {` |
| The inner loop controls the columns, also running 10 times for each row. | `    for (int j = 1; j <= 10; j++) {` |
| The product of `i * j` is printed for each combination of rows and columns. | `        System.out.print(i * j + "\t");` |
| Close the inner loop. | `    }` |
| After the inner loop, a newline is printed to separate the rows. | `    System.out.println();` |
| Close the outer loop. | `}` |
| The `main` method and class are closed with curly braces. | `}`<br/>`}` |

---

## `break` Statement

The `break` statement is used to terminate a loop immediately, regardless of the loop's condition. This can be useful when you want to exit a loop based on a specific condition that may occur during its execution.

| Description | Example |
|-------------|---------|
| A Java class named `BreakExample` with a `main` method. The `main` method is the entry point of the program. | `public class BreakExample {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| An array `numbers` is declared and initialised. | `int[] numbers = {1, 3, 5, 7, 9, 2, 4};` |
| The loop iterates through the array, checking if any number is greater than 5. | `for (int num : numbers) {` |
| When a number greater than 5 is found, it is printed and the loop exits with the `break` statement. | `    if (num > 5) {`<br/>`        System.out.println(num);`<br/>`        break;`<br/>`    }`<br/>`}` |
| The `main` method and class are closed with curly braces. | `}`<br/>`}` |

---

## `continue` Statement

The `continue` statement is used to skip the current iteration of a loop and move to the next iteration. It's useful when you want to skip certain conditions but continue executing the rest of the loop.

| Description | Example |
|-------------|---------|
| A Java class named `ContinueExample` with a `main` method. The `main` method is the entry point of the program. | `public class ContinueExample {` |
| The `main` method is declared using `public static void main(String[] args)`. This method is required for execution in Java programs. | `public static void main(String[] args) {` |
| The loop iterates through the numbers from 1 to 10. | `for (int i = 1; i <= 10; i++) {` |
| When `i == 5`, the `continue` statement is executed, skipping the `System.out.println(i);` statement for that iteration. | `    if (i == 5) {`<br/>`        continue;`<br/>`    }` |
| The value of `i` is printed for all numbers except 5. | `    System.out.println(i);` |
| Close the `for` loop. | `}` |
| The `main` method and class are closed with curly braces. | `}`<br/>`}` |
