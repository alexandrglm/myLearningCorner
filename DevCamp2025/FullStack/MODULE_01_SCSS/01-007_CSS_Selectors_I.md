# MODULE 01 - 001:      CSS Selectors 

A strong understanding of **CSS** is essential for building web applications. This guide focuses on **CSS selectors**, the key component that connects styles with page elements.  

---
## Recalling on CSS

### 🖌️ **What is CSS?**  
CSS (**Cascading Style Sheets**) defines the look and feel of your application. It contains the **rules** that style your HTML elements.
---

###  🎯 **What is a CSS Selector?**  
Think of a website as a machine:  
- **HTML**: The components.  
- **CSS**: The design rules.  

CSS selectors are the bridge that connects the two.  
They allow you to specify page elements (e.g., navbar, image, breadcrumbs) and apply styles to them.  
---

### 🧩 **CSS Selector Basics**  

CSS uses specific syntax to select elements:  

1. **Elements**: Use the tag name (e.g., `div`, `h1`).  
2. **Classes**: Use a `.` before the class name (e.g., `.my-class`).  
3. **IDs**: Use `#` before the ID name (e.g., `#my-id`).  

> **Example:**  
> - A `div` with no class or ID → background color: red.  
> - A `div` with the class `.my_cool_class` → background color: green.  
> - A `div` with the ID `#my_cool_id` → background color: blue.  

---

### ⚖️ **CSS Selector Prioritization**  
Even if multiple selectors target the same element:  
- **The most specific selector wins.**  
- IDs > Classes > Elements.  

---

### 🪆 **CSS Selector Nesting**  
Sometimes, elements are **nested** within others. CSS allows you to target these elements directly:  

> Example:  
> - A list (`ul`) has bullet points (`li`).  
> - Nesting syntax can apply styles to `li` inside a specific `ul`.  

---

### 🔢 **nth-child Selectors**  
Need to style a specific item in a group without a class or ID? Use `nth-child`:  
- **Syntax:** `nth-child(n)`  
- **Example:**  
  - To style the first bullet point → `nth-child(1)`.  

This selector belongs to **pseudo-classes**, a special group of selectors.

---

### Pseudo-classes
A pseudo-class is a selector that selects elements that are in a specific state, e.g. they are the first element of their type, or they are being hovered over by the mouse pointer.  
They tend to act as if you had applied a class to some part of your document, often helping you cut down on excess classes in your markup, and giving you more flexible, maintainable code.

Pseudo-classes are keywords that start with a colon. For example, `:hover`, is a pseudo-class.
***

## CSS Selectors Cheat Sheet 🖌️

| **Selector Type**       | **Description**                                                                 | **Syntax/Example**                                                                 |
|--------------------------|-------------------------------------------------------------------------------|-----------------------------------------------------------------------------------|
| **Universal Selector**   | Selects all elements.                                                        | `* { margin: 0; padding: 0; }`                                                   |
| **Type Selector**        | Selects all elements of a specific type.                                     | `p { font-size: 16px; }`                                                         |
| **Class Selector**       | Selects all elements with a specific class.                                  | `.my-class { color: blue; }`                                                     |
| **ID Selector**          | Selects a single element with a specific ID.                                 | `#my-id { font-weight: bold; }`                                                 |
| **Group Selector**       | Applies the same styles to multiple elements.                                | `h1, h2, h3 { font-family: Arial, sans-serif; }`                                 |
| **Descendant Selector**  | Selects elements inside another element.                                     | `div p { color: gray; }`                                                         |
| **Child Selector**       | Selects direct children of an element.                                       | `ul > li { list-style: none; }`                                                 |
| **Adjacent Sibling Selector** | Selects the next sibling of an element.                                   | `h1 + p { margin-top: 10px; }`                                                  |
| **General Sibling Selector**  | Selects all siblings of an element.                                       | `h1 ~ p { font-size: 14px; }`                                                   |
| **Attribute Selector**   | Selects elements with a specific attribute.                                  | `input[type="text"] { border: 1px solid black; }`                                |
| **Starts With Selector** | Matches elements whose attribute value starts with a specified value.         | `a[href^="https"] { color: green; }`                                            |
| **Ends With Selector**   | Matches elements whose attribute value ends with a specified value.           | `a[href$=".pdf"] { color: red; }`                                               |
| **Contains Selector**    | Matches elements whose attribute value contains a specified value.            | `img[alt*="cat"] { border: 2px solid blue; }`                                   |


## CSS Pseudo-classes list

| **Selector**            | **Description**                                                                   | **Syntax/Example**                                                                |
|--------------------------|-----------------------------------------------------------------------------------|-----------------------------------------------------------------------------------|
| `:hover`                | Selects an element when hovered over.                                             | `button:hover { background-color: yellow; }`                                     |
| `:focus`                | Selects an element when it gains focus.                                           | `input:focus { outline: 2px solid blue; }`                                       |
| `:active`               | Selects an element while being activated (clicked).                               | `a:active { color: red; }`                                                       |
| `:visited`              | Selects links that have been visited.                                             | `a:visited { color: purple; }`                                                   |
| `:checked`              | Selects checkboxes or radio buttons that are checked.                             | `input:checked { border: 2px solid green; }`                                     |
| `:disabled`             | Selects elements that are disabled.                                               | `button:disabled { opacity: 0.5; }`                                              |
| `:empty`                | Selects elements with no children.                                                | `div:empty { display: none; }`                                                   |
| `:root`                 | Selects the root element of the document (`<html>`).                              | `:root { --main-color: #333; }`                                                  |
| `:first-child`          | Selects the first child of a parent element.                                       | `p:first-child { font-weight: bold; }`                                           |
| `:last-child`           | Selects the last child of a parent element.                                        | `p:last-child { font-style: italic; }`                                           |
| `:only-child`           | Selects an element if it’s the only child of its parent.                          | `div:only-child { background: lightgray; }`                                      |
| `:nth-child(n)`         | Selects the nth child of a parent.                                                 | `li:nth-child(2) { color: red; }`                                                |
| `:nth-last-child(n)`    | Selects the nth child of a parent, counting from the end.                          | `li:nth-last-child(1) { color: green; }`                                         |
| `:first-of-type`        | Selects the first element of its type.                                             | `p:first-of-type { text-decoration: underline; }`                                |
| `:last-of-type`         | Selects the last element of its type.                                              | `p:last-of-type { color: blue; }`                                                |
| `:nth-of-type(n)`       | Selects the nth element of its type.                                               | `p:nth-of-type(2) { font-size: 18px; }`                                          |
| `:nth-last-of-type(n)`  | Selects the nth element of its type, counting from the end.                        | `p:nth-last-of-type(1) { font-weight: bold; }`                                   |
| `:not(selector)`        | Excludes elements from being selected.                                             | `:not(.excluded) { color: black; }`                                              |

---

### 📚 **Resources**  
- [Basic CSS Selectors - MDN Web Docs](https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Styling_basics/Basic_selectors)  


***
# Video Lesson Speech
[ENG]  
```
# Guide to CSS Selectors for Web Developers and Designers  

When it comes to building out web applications, a solid understanding of CSS will take you a long way.  
You can use this post as a guide to CSS selectors. Which are the key component for connecting styles with page elements.
***

## What is CSS?

CSS stands for Cascading Style Sheets. Your CSS files are where you can place the rules that will dictate the look and feel of your application.  

## What is a CSS Selector?

So if you imagine the components of a website being cogs in a machine, your HTML and CSS elements would be separate entities.  

IMG_BROKEN

Essentially your CSS files contain style rules for the website, but in order for the rules to go into effect, you need to connect the two components.  
And that’s where CSS selectors go.  

IMG_BROKEN

CSS selectors allow you to specify elements on the page and then apply the style rules to the elements that you list off.  

For example, you may want to select a navbar or a table so you can give the components their own styles.  

IMG_BROKEN

Taking a look at this page you can see a sampling of the page elements that you can select. Including:

    - Page title
    - Logo
    - Navigation bar
    - Image
    - Sharing Links
    - Breadcrumbs
    - Etc ...

## Guide to CSS Selectors

So how exactly can you select elements on a page? Much like the HTML markup language, there is a specific syntax to use for CSS styles. And that’s what we’ll walk through today.  

### Basic Syntax

Starting with the basics, there are two main ways to select items on a page. You can either select:

    - Elements – such as divs, h1 tags, etc. For these, the element name itself will select the item on the page.
    - Unique IDs – for selecting an ID you use the # symbol before the name of the ID.
    - Classes – classes are attributes that you can use multiple times. In order to select a class, you use the . selector syntax.



In this image, you can see each one of the selector options. The div element is selected and given the background color of red. The div with the class name of my_cool_class has been given the background color of green. And lastly, the id named my_cool_id has been given the background color of blue.  

## CSS Selector Prioritization

Notice how even though all three elements are divs, they can all be selected separately. This is accomplished through the concept of CSS selector prioritization. At a high level, it means that the most specific selector wins. This is why the background color red wasn’t rendered for the elements that had the class and id selectors since they are considered more specific.   

## CSS Selector Nesting

In addition to selecting basic elements, there are many times where you need to select nested elements on a page.

large

In this example, you can see that we have a set of bullet point elements nested inside of our class. By using this syntax we’re able to select the nested items inside of another element and define their own styles.

## nth-child Selectors

So what happens when you want to select an item that doesn’t have a class or id and simply belongs to a group of elements. For example, what happens if we need to give specific styles to only one bullet point?

That’s where the nth-child selector comes into play.  

large

Here you can see a selector that leverages the nth-child mechanism, which allows us to specify which element we want to style. In this case, I passed in 1 to pick out the first bullet point. nth-child selectors are a part of a special group of selectors called pseudo-classes.

## List of Pseudo Classes

The list of pseudo-classes is relatively extensive and I’ve placed a link to the full list, along with a link to the CSS selector documentation that you can use to further your knowledge.
## Summary

I hope that this has been a helpful guide to CSS selectors and that it can help you build custom styles into your next web application.
***
### Resources
1. 'Basic CSS selectors' - MDN Web Docs [Link](https://developer.mozilla.org/en-US/docs/Learn_web_development/Core/Styling_basics/Basic_selectors)
```
