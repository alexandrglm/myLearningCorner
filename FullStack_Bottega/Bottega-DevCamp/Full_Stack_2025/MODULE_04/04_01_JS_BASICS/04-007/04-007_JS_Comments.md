# MODULE 04-007: JavaScript

## Comments

---

## 1. Understanding Comments in JavaScript

## 2. Single-Line Comments

## 3. Multi-Line Comments

## 4. Best Practices for Using Comments

---

Comments in JavaScript are a way to add notes within your code that do not affect its execution. They help in documenting the code, making it more readable and understandable for other developers (or even for yourself in the future). JavaScript supports two types of comments: **single-line** and **multi-line**.

While comments can be helpful, it is essential to use them intentionally and keep them updated as the code evolves. Overusing comments or failing to maintain them can lead to confusion, especially if the comment no longer accurately describes the functionality of the code.

---

## 1. Understanding Comments in any language

Every programming language provides a way to include comments in the code.   

Comments help developers understand the purpose of certain pieces of code and are ignored by the JavaScript engine when executing the script.

### Why Use Comments?

- **Documentation:** Helps describe the purpose of specific parts of the code.
- **Debugging:** Allows temporarily disabling parts of the code without deleting them.
- **Collaboration:** Makes it easier for other developers to understand the logic.

---

## 2. Single-Line Comments

Single-line comments start with `//` and everything after it on that line is ignored by JavaScript.

```javascript
// This is a single-line comment
console.log("Hello, World!"); // This is another comment
```

In the example above, the first line is a comment, and the second line contains code followed by a comment explaining the statement.

---

## 3. Multi-Line Comments

Multi-line comments allow commenting on multiple lines at once. They start with `/*` and end with `*/`.

# 

```javascript
/*
   This is a multi-line comment.
   You can add multiple lines of text here.
   Everything within these symbols is ignored by JavaScript.
*/
console.log("Hello, World!");
```

Multi-line comments are useful for explaining complex code, providing documentation, or temporarily disabling sections of code for debugging.

---

## 4. Best Practices for Using Comments

1. **Keep comments up to date:** Outdated comments can mislead developers and cause confusion.
2. **Use comments only when necessary:** Over-commenting can make code harder to read. Strive for clear and self-explanatory code.
3. **Use meaningful variable and function names:** This reduces the need for excessive commenting.
4. **Avoid obvious comments:** Do not comment on trivial statements (e.g., `// Declare a variable` when it's evident from the code).
5. **Use comments to explain why, not how:** The code itself should describe *how* it works, but comments should provide insights into *why* certain decisions were made.

---

## References

- [MDN Web Docs - Comments](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Guide/Grammar_and_types#Comments)
- [W3Schools - JavaScript Comments](https://www.w3schools.com/js/js_comments.asp)

---

### Example Code:

```javascript
// #04-007: Commentaries in JS

console.log('This guide has no executable code xD')

// This is a single-line comment

/*
While this is ...
... a multi-line ...
    comment!

Here, you can write as you need
    with
        no
            indentation
                        nor
                            multi-line
                                    problems
*/

// Use comments in a proper and wise way
```

This guide covers the proper use of comments in JavaScript, their syntax, and best practices to ensure they remain useful in your codebase.

---

## Video lesson Speech

This guide explains both syntax options for adding comments to JavaScript files.

****

In this guide, we're going to talk about comments in javascript. Every programming language I've ever worked with has a concept of comments and what comments are is they allow you to put text in your code without actually having it run. And so what will happen is you can type anything you want in these comments and then when the javascript interpreter scans through the code it recognizes what a comment is and then it completely ignores it. 

Anything you put inside of it is not going to run. Before I show you the syntax for this I want to make one statement about code comments and this is something that I've seen through the years. And so I want to introduce it now. And that is that you need to be very intentional about your code comments. Because I have seen many developers especially new developers that load up their programs with all kinds of comments and what I've seen also happen is as that program develops and as they change functionality in their programs they don't always go back and update the comment.

In other words, if they say that the comment is, that a function is going to do x y z type functionality and it requires these arguments and they put that in the comment, then if they make a change and the behavior of the function changes but they don't update that then when someone else goes or even when they go back and they look at the comment later on it's going to be confusing because they're going to try to follow those instructions and they're not going to fit the updated version of the code.

So be very careful when you're typing them in. I actually rarely put comments into any code that I write and I follow the philosophy that my classes my modules my functions should be self-describing and you'll see that as we start to get into more advanced topics. I like to use very descriptive words for variables and for functions so that I don't need comments. I can actually read what I've named something and then that describes what it does. That's a little kind of a best practice when we're talking about how we organize code and how we name things that may not seem like a big deal. But the more advanced a project gets the more important naming gets. And you don't want to rely on comments because those could say anything and they can be very confusing and lead to some bugs if they're not updated. 

With all that being said now let me show you actually how to use comments. There are two different ways you can do it, the first way is a single line comment. With that you just do two slashes `//` and then you can put anything you want after that for example.

`//this line of code is commented out`

As you can see the syntax highlighter shows that this is grayed out which represents that nothing is going to happen if I run this. Nothing comes out in the console literally no code gets changed whatsoever. Now that is when you have just one line of comments. Now the cool thing about this as well is you can actually put them on the same line as code as long as you put it after the code.

If I do `console.log('Hi there'); // Here is another comment`

You'll see this as you go through documentation and as you get further along on your javascript journey you'll see this happen quite a bit where a developer will have a single line of code and then they want to describe something that is just on that line. And so this is a good way of doing it. Now another way if you want to have multi-line comments is to use this syntax, a slash followed by an Asterix

```javascript
/*
put anything you 
    want here on 
        multiple lines 
*/
```

and then you close it off with an Asterix and other slash and then everything inside of there is going to be contained in that comment and nothing is going to happen. If you run this entire program right here you can see the only thing that gets run is the one `console.log` line of code. Everything else is considered a comment. That is the syntax for both types of comments that you can use in javascript.

```javascript
// You can put anything you want here

console.log('Hi there'); // Here is another comment

/*
Anything
you want
here
*/
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_b_08_comments.js)
