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
