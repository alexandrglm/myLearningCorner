# MODULE 04 - 006: JavaScript, Variables (3)

## Hoisting

****

## Video lesson Speech

In this lesson we'll examine what JavaScript Hoisting is and how it affects when variables need to be declared and assigned.

****

We've talked about variables. How to define them, how into reassign values, we've talked about the differences between the `let` and `var`, and now we're going to talk about something that is pretty much specific to javascript. 

Very few programming languages work with this topic the way that javascript does. The topic is called `hoisting`. `Hoisting` is essentially a very specific way that the javascript interpreter actually reads variables. So we're going to go through some examples to see how this works. What this is going to essentially be related to, is where you should define your variables in your program. If you define them in the wrong order then you might run into some odd types of bugs. The way that `hoisting` works is, I'm not going to declare a variable I'm just going to assign a variable. If I have a variable like this `name = 'Kristine';` and type out `console.log(name);`

Notice I've not used `var` or `let` but with `Hoisting` what I can actually do is say `var name;` at the bottom. If I run this code it prints out Kristine. 

![large](./04-006_IMG1.png)

There is no issue with that whatsoever, the reason for this is something that may seem a little bit confusing if you're brand new to programming, or if you're coming from a different programming language and you've never used javascript before. Essentially what the interpreter does with `hoisting` is it goes and it tries to find every spot where a variable has been declared.

It looks for all of these kinds of things like `var name;` and it actually preloads this at the very top. Writing this code is really viewed more like this,

```javascript
var name;
name = 'Kristine';
console.log(name);
```

because of `hoisting` and that's the reason why it's called `hoisting` because these declarations get hoisted up to the top. That is the way it works. 

There is a little caveat to `hoisting` and that is it only works with declarations. It does not work with assignment. I'm going to try to do something kind of similar. I'm going to say `console.log(age);` and then below. I'm going to say `var age = 15;`

```javascript
console.log(age);
var age = 15
```

Now if I come here and run this. You can see it doesn't print out 15. It prints out undefined. If you've never worked with `hoisting` before, javascript, that may seem a little bit weird because it kind of looks like we declared the age variable but actually we declared it and assigned it to a value at the same time. Whenever you do that is viewed differently by the javascript interpreter compared with if you just defined it. Or if you just declared it these do not get `hoisted` up to the top. That is a very key difference to keep in mind. And it leads to one of the first best practices that we're going to talk about and that is to avoid `hoisting` issues. It's really considered the best practice to assign your variables and to declare them at the very top.

Doing something like that could lead to some weird bugs. It's always better to write your code more like this 

```javascript
var age = 15; 
console.log(age);
```

because if you do this and run it now you can see it prints out 15 exactly the way it should. 

`Hoisting` is something that is very important to know and it's important to know that that is the way that javascript views declarations but to make things easier to make your code easier to read and also easier to debug the best practice is to always list your variables right at the top of your programs.

```javascript
// Hoisted
name = 'Kristine';
console.log(name); // 'Kristine'
var name;

// Initializers not hoisted
console.log(age); // undefined
var age = 33;
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_b_07_hoisting.js)

****

## Coding Exercise

```js
/*
Coding Exercise

Create a variable called name and its value must be set to "Jordan".
*/
```
