# 04-006    Module 4: Exception Handling Summary

---

## Module Learning Objectives

-   Explain the concept of exceptions and their importance in Java
-   Apply `try-catch` blocks to handle exceptions effectively
-   Differentiate between checked and runtime exceptions
-   Implement custom exceptions to manage specific error conditions
-   Use `finally` blocks to execute code regardless of exceptions

---

## Summary

*   An **exception** disrupts the normal flow of a program but allows errors to be handled gracefully without crashing.

*   **Errors** signal critical issues beyond the programmer's control and are generally not meant to be caught in application code.

*   Java has two types of exceptions:

    - **Checked exceptions**, which are checked at compile-time
    - **Unchecked exceptions**, that are not checked at compile-time

*   Custom exception classes can be created by extending:

    - `Exception` for checked exceptions
    - `RuntimeException` for unchecked exceptions

*   Java handles exceptions using `try`, `catch`, and `finally` blocks:

    - The `try` block contains code that might throw an exception
    - The `catch` block handles the exception if it occurs
    - The `finally` block executes regardless of whether an exception occurred

*   Multiple `catch` blocks allow handling different exceptions separately.

*   The `throws` keyword provides better error handling and separation of concerns.

---

## Best Practices

*   **For the `finally` block:**

    - Always execute cleanup code, such as releasing database connections
    - Avoid `return` statements and unhandled exceptions
