# MODULE 04 - 048: JavaScript

# Modern JS (0), Intro

---

---

## Video lesson Speech

Welcome to the section where we're going to walk through the basics of 
modern Javascript. Now this is going to be a pretty exhaustive set of 
guides. And I want to take a little bit of time before we go into them 
to summarize each one of the key topics we're going to talk about.

****

I also want to give you some insight on how I 
designed this section of the course. I took a little bit different of an
 approach than I usually do when building out a course and the approach 
that I followed was as I was teaching myself some of the popular 
javascript frameworks and libraries such as React and Angular. I started
 taking notes on any kind of topic or any kind of code construct. That I
 didn't really understand and that I wanted more clarification on. I 
would take note and say OK I don't understand this concept and I want 
some more details around this other concept and this course is actually 
the culmination of all of those notes. So each one of those notes 
translated into a guide that I created specifically for this course and 
for this section and so hopefully that strategy is going to turn out to 
be something that is very helpful to you.

Because if you're wanting to leverage your javascript knowledge to 
work with these large frameworks and libraries you can be assured that 
every one of the guides that you're going through they're not just my 
idea on something I think you should know. But instead, it was a concept
 that I personally wanted more clarification on any time I saw a piece 
of code that looked a little bit weird or was something that didn't make
 sense. I decided to go and create a guide that explained that one 
specific element and hopefully you reap the benefit of that as you go 
through the guides.

The very first topic that we're going to dive into is the new in 
modern ways of using variable types in JavaScript for years and years. 
The one variable type we would use was called the var keyword every 
variable used var followed by the variable name followed by whatever 
value you were setting that and that was fine.

However, what developers discovered is that because var was so public
 it was simply a global variable that there were many issues that you'd 
run into. So you'd have issues where you'd accidentally change the value
 you would update it to be some other value and then another part of 
your program would expect that value to have not been changed and then 
it would cause some pretty weird bugs.

And so because of that, there are now three key variable types inside
 of javascript programs and if you're building code in react or in view 
or any of these frameworks you're going to see all three of these and so
 it's important to dive in and see the differences between them. And so 
we have var, we have let, and now we have the const variable type and 
it's actually become a best practice in javascript to use the const type
 as much as possible.

After discussing the variable types we're going to look into a more 
modern way of performing string interpolation. And if you don't remember
 what string interpolation is that's fine. It is a way of having a 
string and then changing values inside of that string. In older versions
 of JavaScript that was a little bit of a messy piece of business but 
now in modern javascript, we have the concept of string literals where 
it has an elegant syntax where you can simply slide in any kind of 
javascript function or variable or any type of expression directly 
inside of the string.

This is going to be a concept that you see all throughout the popular
 javascript frameworks react, angular, view. Each one of these 
frameworks takes advantage of the new string literals and so I want you 
to be able to understand exactly what's going on so that you can perform
 those on your own.

After string literals, we are going to dive into one of the more 
confusing topics in modern javascript which is the arrow function and if
 you've never seen an arrow function before and you have only seen 
standard function types the arrow is going to look like a very strange 
syntax but I want to start with the basics so you can see that it really
 is just another way to create a function and then we're going to walk 
all the way through the more advanced topics related to it especially in
 how it uses this differently and how you can add it into your programs.

This is something that is very important to understand and so we're 
going to spend quite a bit of time going through arrow functions because
 you are going see these in pretty much every modern javascript 
framework and application that you work on.

After arrow functions we're going to talk about deconstruction now 
deconstruction is a very cool new part of javascript that allows you to 
work with collections and to be able to slice elements out of them and 
store them in variables. This is going to be something that is used 
quite a bit in tools like React and Vue. And so I want you to have a 
good understanding of what deconstruction is and how it works because if
 you've never seen it before it's going to look a little bit odd. So I 
want you to be able to understand how we can work with that.

We're going to finish off this section by talking about the new 
spread and rest operators inside of JavaScript. These type of operator 
allows you to work with all kinds of different collections such as 
arrays and being able to very quickly pass them around between 
functions.

This is going to be once again a little bit of a different syntax if 
you've never seen it before but it is one of the most popular new 
features that is used in the popular web frameworks. So I want you to 
understand exactly what processes are occurring so that you can work on 
them yourself.

That was a long section introduction but this is going to be a pretty
 comprehensive section. So I wanted to give you a good preview of what 
we're going to go through and also why we're going through each one of 
those elements. So now with all that being said let's get into the code.
