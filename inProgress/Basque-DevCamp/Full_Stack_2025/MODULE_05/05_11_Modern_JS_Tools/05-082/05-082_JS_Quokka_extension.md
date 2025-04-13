# MODULE 05 - 082:   ModernJS Tools (5)

## Quokka.js extension

---

---

## Video Lesson Speech

The last few guides we've walked through have been pretty challenging, 
especially if you've never used some of the tools and the concepts that 
we've walked through. So in this guide we're going to have some fun and 
we're going to change gears a little bit and look at a tool that I used 
quite a bit and I'm going to be using quite a bit throughout the rest of
 this course called Quokka.

****

It's called [Quokka.js](https://quokkajs.com/) and it is free to use they also have a paid version that I have. And so you're going to be seeing me using this quite a bit because it allows you to actually render javascript output inside of the code editor itself. And the free version is slightly different than the pro version and I'll explain the differences but you don't have to use it at all. Or you can use it or you can use a pro version is completely up to you. 

But I will show you what it does so that you can kind of make up your own mind. They have a nice little visual here and we'll walk through a full demo of it. It will work with either  [Visual Studio Code](https://code.visualstudio.com/), [JetBrains](https://www.jetbrains.com/), or [Atom](https://atom.io/). And as you can see what it does is it allows you to output and actually view dynamically the output of your programs right in the code editor.

So if I open up Visual Studio code here where it's installed and if you want to install it you can go to your extensions and just simply start typing in Quokka and you can see it's right there

![large](./05-081_IMG1.png) 

I already have it installed but you can install yours and then you'll have access to it and so let me start it up I'll hit command shift P and a couple of ways you can do is you can start in a new JavaScript file or if you have one open then you can say start on current file. I'll start a new JavaScript file and it gives you an output panel here and I'm going to keep it open but it's optional and I personally prefer to see it all in line. 

But let's create a function, say function sum and it takes in numOne and numTwo choose a very basic function that is simply going to add two numbers together something, say add numOne and numTwo. So far there we've seen all of that but now so far in this course whenever we're using code pen or when we're working with lodash or anything like that we have had to write our code right here and then check in the browser or check in the javascript console to see the output. 

What a tool like Quokka allows you to do is I can say sum and then simply pass in numbers I can say 2 and 5

```
sum(2, 5);//?
```

and then what it does is it'll actually output the total. You see how it shows 7 right here. 

![large](./05-081_IMG2.png)

It also shows it in the output down here but I love that it puts the output dynamically right on the same line which means I don't have to go back and check in the browser when I'm building the scripts out.

Now I told you I was going to tell you the difference between the pro and the free version and the key difference is in the paid version I have that cool little syntax where I can do slash, slash, question mark, and that will allow the output to be shown. If you have the free version then you can just type console logs so I can say console log and then it will automatically show that on the right-hand side.

![large](./05-081_IMG3.png)

If you don't feel like spending any money on it that's fine. I personally I use it so much that it was worth it for me but for you, if you are just used to placing console log statements in your code you can do that and now you don't even have to go and check in the browser if all you were using it for was to print something out. 

That is very helpful and it's something that I personally love doing and so I wanted to show it to you because I thought it was something cool you might enjoy. But then I'm also as we are starting to get into more advanced topics. I'm going to be moving away from showing all of the examples in code pen and now I'm going to start doing it here in a visual studio code and you're going to see me using this quite a bit. 

And I didn't want you to be confused on exactly how that was happening and so I wanted you to see it's just a tool just an extension and if you use one of those 3 code editors then you can integrate it as well. So that is just a very brief introduction to the Quokka.js. extension. 

## Resources

- [Quokka.js](https://quokkajs.com/)
