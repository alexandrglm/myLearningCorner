# 04-007    Glossary Module 4
## Robust Exception Handling

| Term | Definition |
|------|-----------|
| `AbstractMethodError` | An error that occurs when an application attempts to call an abstract method directly. |
| `AccessControlException` | A security-related exception that occurs when an operation is not allowed due to insufficient permissions. |
| `ArithmeticException` | An unchecked exception that occurs when an exceptional arithmetic condition arises, such as division by zero. |
| `ArrayIndexOutOfBoundsException` | An unchecked exception that is thrown when attempting to access an array` with an invalid index. |
| `AssertionError` | An error that occurs when an `assert` statement fails, typically used for debugging. |
| `break` statement | A statement that exits a loop or `switch` statement when executed. |
| `catch` block | A block of code used to handle an exception if it occurs within the preceding `try` block. |
| Checked exception | An exception that must be handled at compile-time using a `try-catch` block or declared in a method signature. |
| `ClassCastException` | An unchecked exception that occurs when an object is cast to an incompatible class. |
| `ClassNotFoundException` | A checked exception that occurs when an application tries to load a class by name but cannot find it. |
| `CloneNotSupportedException` | A checked exception that occurs when an object does not implement the `Cloneable` interface but is being cloned. |
| `ConcurrentModificationException` | An unchecked exception that occurs when a collection is modified whilst being iterated. |
| `continue` statement | A statement that skips the current iteration of a loop and proceeds to the next iteration. |
| Custom Exception | A user-defined exception class that **extends** `Exception` or `RuntimeException`. |
| Deadlock | A condition where two or more threads are blocked indefinitely, each waiting for the other to release resources. |
| Default exception handler | The Java runtime's built-in mechanism for handling uncaught exceptions by printing the stack trace. |
| `do-while` loop | A control flow statement that executes a block of code at least once before checking the loop condition. |
| `EOFException` | A checked exception that occurs when an end-of-file condition is unexpectedly reached during input. |
| `Error` | A subclass of `Throwable` that represents serious problems that an application should not attempt to catch. |
| `Exception` | A subclass of `Throwable` that represents an abnormal condition that an application might want to handle. |
| Exception chaining | A mechanism where one exception is caused by another, maintaining the cause of an exception. |
| Exception hierarchy | The structured classification of exceptions in Java, where all exceptions derive from `Throwable`. |
| `finally` block | A block of code that executes after a `try` block, regardless of whether an exception was thrown. |
| `for` loop | A control flow statement that executes a block of code a fixed number of times. |
| `IllegalArgumentException` | An unchecked exception that occurs when an illegal or inappropriate argument is passed to a method. |
| `IllegalStateException` | An unchecked exception that occurs when a method is invoked at an inappropriate time. |
| `IllegalThreadStateException` | An unchecked exception that occurs when a thread is in an inappropriate state for the requested operation. |
| `IndexOutOfBoundsException` | A superclass of exceptions that occur when accessing an index outside the valid range for an array or list. |
| Infinite loop | A loop that runs indefinitely due to a missing or incorrect termination condition. |
| `InputMismatchException` | An unchecked exception that occurs when input does not match the expected data type. |
| `InterruptedException` | A checked exception that occurs when a thread is interrupted whilst waiting or sleeping. |
| Logical error | An error in a programme that causes incorrect results but does not throw an exception. |
| Multi-`catch` block | A `catch` block that handles multiple exception types using a single `catch` block. |
| `NegativeArraySizeException` | An unchecked exception that occurs when an attempt is made to create an array with a negative size. |
| Nested `try` block | A `try` block inside another `try` block, allowing for more specific exception handling. |
| `NullPointerException` | An unchecked exception that occurs when trying to access a method or field of a `null` object. |
| `NumberFormatException` | An unchecked exception that occurs when attempting to convert a `String` to a number, but the `String` is invalid. |
| `OutOfMemoryError` | An error that occurs when the Java Virtual Machine (JVM) runs out of heap memory. |
| Recursion | A programming technique where a method calls itself to solve a problem. |
| `StackOverflowError` | An error that occurs when the call stack exceeds its limit due to deep or infinite recursion. |
| `StringIndexOutOfBoundsException` | An unchecked exception that occurs when accessing an invalid index in a `String`. |
| Synchronised block | A block of code that allows only one thread at a time to execute it, ensuring thread safety. |
| `throw` keyword | A keyword used to explicitly throw an exception. |
| `throws` keyword | A keyword used in method declarations to indicate that a method may throw one or more exceptions. |
| `try` block | A block of code that attempts to execute statements that may throw exceptions. |
| Unchecked Exception | An exception that is not checked at compile-time and usually results from programming errors. |
