# MODULE 05 - 092:   JS Modules

## Modules (1) - Introduction

---

---

## Video Lesson Speech

So far in this course, any time that we've been building out or 
javascript programs we've been placing all of the logic for the program 
in a single file.

****

In order to learn concepts that can be helpful because you can see all of your code in one spot. However, that would be a really bad approach in a real production application. 

Typically you're going to have dozens if not hundreds of files in an application whether you use React, or Vue, or Angular. And so what we're going to do in this section is talk about the concept of modules. Modules in modern javascript is one of the easiest ways to allow different parts of an application to pick and choose what kind of functionality that it wants. Let's walk through a basic example of this. 

Let's imagine that you have some type of javascript application, and on a page, you might have a set of blog posts so your blog posts might be right here, right here, and right here. 

![large](./05-092_IMG1.png)

So the way that you would organize this is you'd have one main component. This would be something like app or home. 

![large](./05-092_IMG2.png)

You could name it however you wish. 

Now inside of this app component in this javascript file you don't want to place all of the logic in all of the code for your blogs inside of there. Instead what you do is you create another file so you'd create this file over here and this would be something like blog.JS and so this is going to be your blog file and then inside of your app JS file you would simply import blog. So here I would just say import and then you can just make a reference and type out blog and we're going to go through the syntax on how that looks. 

After you've done that all of the different functions and the entire module that blog module can be pulled into this app JS and so you can use it however you want. Such as rendering all of those elements on a screen. One of the very cool features about this type of workflow is imagine that you have a very large application you might have one part of the app that wants to bring in blog posts but then you have another part of the application that gives a full content management system so this is going to allow admins to manage different parts of the site. 

If you don't need access to this blog's module inside of the content manager you don't have to bring it in. And this is a huge reason why people have fallen in love with using different javascript frameworks like angular and react is because whenever you can simply call and list out the items that you want and only import what you need then it makes the code much more efficient. 

There are other frameworks out there such as rails. That is a fantastic framework but what it does is when you start up the server it takes all of your components it takes all the classes all the modules and it loads all of them all at one time it's called eager loading. 

In JavaScript it works a little bit different than that in your files you don't have access to every module in the entire application you need to explicitly say I want to have module A B and C I don't care about the rest of them and so that is something that is pretty nice and it's very cool because when you go to one of these files and you see what the imports are it's going to instantly tell you what that components job is because you can see what the dependencies are. 

Now the import syntax that we're going to be going through is exactly what you're going to be doing. If you are also going and building react application so you're going to see something that looks very different if you are new to the modern versions of JavaScript so you're going to see a lot of curly braces you're going to see what appears to be a weird type setup. 

However that's all a part of the modern versions of JavaScript and it's part of the reason why these new popular frameworks have taken off so fast. 
