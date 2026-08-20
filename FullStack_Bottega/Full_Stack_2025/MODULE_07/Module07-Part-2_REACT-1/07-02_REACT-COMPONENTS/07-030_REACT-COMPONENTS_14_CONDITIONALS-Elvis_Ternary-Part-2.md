# 07-030: React Components 14 - Conditionals Elvis and Ternary Part 2

## Introduction

This part continues exploring conditional rendering patterns in React, focusing on Elvis operator and nested ternaries. Mastering advanced conditionals improves the expressiveness and safety of React components’ rendering logic.

---

## Elvis Operator (Optional Chaining)

The Elvis operator `?.` safely accesses object properties, avoiding errors if the value before `?.` is null or undefined.

Example:

```jsx
const userName = user?.name;
```

If `user` is undefined, `userName` becomes undefined instead of raising an error.

---

## Nested Ternary Operators

For multiple conditions, you can nest ternary operators, but beware of readability:

```jsx
{condition1 ? (condition2 ? <A /> : <B />) : <C />}
```
Use judiciously and consider extracting logic or using if-else statements for clarity.

---

## Combining Conditionals and Logical Operators

```jsx
{isAdmin && <AdminPanel />}
{!isAdmin && <UserPanel />}
```

Use logical AND and negation to conditionally render components.

---

## Practical Examples

1. Conditional rendering with fallback:

```jsx
const Greeting = ({ isLoggedIn, user }) => (
  <div> {isLoggedIn ? <h1>Welcome, {user.name}!</h1> : <h1>Please sign in</h1>} </div> 
); 
```

2. Optional chaining for nested objects:
```jsx
const SecondaryEmail = ({ user }) => (
  <div>
    <p>{user?.contact?.secondaryEmail ?? 'No secondary email provided'}</p>
  </div>
);
```

---

## Best Practices

- Prefer clear if-else or separate functions over complex nested ternaries

- Use optional chaining to safely access deep properties

- Combine logical operators for concise conditional rendering
