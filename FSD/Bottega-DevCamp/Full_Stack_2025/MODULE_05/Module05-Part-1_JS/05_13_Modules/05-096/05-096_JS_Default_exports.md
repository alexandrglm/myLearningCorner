# MODULE 05 - 096:   JS Modules

## Modules (5) - Default Exports

***

### Default Export Syntax

```js
// module.js
export default function() {

    return '<div>Logo</div>';

}

// bootstrap.js
import Navigation from './module';

console.log(Navigation());         // <div>Logo</div>
```

* **One per file**: Only one default export allowed per module
* **Flexible naming**: Import name can differ from original export
* **Clean imports**: No curly braces required

***

## Mixed Export Example

```js
// utils.js
export default function config() { /*...*/ }
export function log() { /*...*/ }
export const VERSION = '1.0';

// app.js
import appConfig, { log, VERSION } from './utils';
```

## When to Use Default Exports

1. **Main Component/Class**: When a module has a primary export
2. **Configuration Files**: Single configuration object
3. **Framework Single-File Components**: React/Vue single-file components

> **Best Practice**: **Use named exports for utilities and default exports for primary module functionality**.

***

## Video lesson speech

So far in this section we've walked through a number of ways that we can\
import and export code files in JavaScript with the ES6 syntax and\
we're going to talk now about one more option, and that is the default\
export and this is going to be something you see quite a bit with the\
popular frameworks out there.

***

I want you to become familiar with this syntax as well. Now as a review when we performed our export so far these are what are called named exports which means that we can have multiples of these inside of the same file. Now what I'm going to do is actually create a new file.

So let's imagine that we want to create some type of site component such as a navigation bar. I'm going to create a new file here I'm going to call it navigation.js. Now the naming typically in other things we do like when we create variables and different things like that and in those cases the naming can be whatever you want. It's important to have very explicit names so it's very clear on what your program is trying to do. But what we're going to do now is actually going to have a very direct effect on naming so the names we're going to use they don't have to be exactly what I type right here you can use whatever you want but you're going to have to follow the same pattern of having the names match.

And if that doesn't make sense we'll walk through the example and it should be clarified a little bit more. So I'm going to create this file called navigation.js and now I'm going to do an export. But instead of simply saying export and then function like we did in our helper I'm gonna say export default and now from here what I can do is I can say export default function and just pass in parentheses and I don't actually give a name.

**navigation.js**

```js
export default function () {

}
```

And this may look really weird if you've never seen it before but what javascript is going to do is it's actually going to take the name of the file. And that's a reason why you said that the naming is important here not that you have to name it navigation. You could call it anything you want but this name is actually going to be what we import. So our navigation name for our file is going to be what we import inside of our bootstrap.js file.

So here if I want to say return some kind of div element here that says a logo where we could place a logo in the navbar and I can return this when I call this is from my bootstrap file. Notice I have no name here so what I can do. I'm going to get rid of all of the code in the bootstrap.js just so there's no confusion and I'm going to say that I want to import and now I'm not going to do curly braces I'm not going to do the star. I'm simply going to say that I want to import navigation from and then I'm going to give our './navigation'

**bootstrap.js**

```js
import navigation from './navigation';
```

Hit save, and as you can see we don't have any errors so, so far so good.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/+JavaScript+Modules/How+to+Import+Multiple+Elements+from+a+JavaScript+File+%23+1467/image6.png)

And now if I want to simply console.log this out I can say `console.log(navigation());` and now this is a function so I have to call it like a function. And as you can see here on the right-hand side right here and let me clear everything out because I know there's a lot of code there with the hot reloading. If I refresh you can see now that we do have our div and this is all working perfectly.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/+JavaScript+Modules/How+to+Import+Multiple+Elements+from+a+JavaScript+File+%23+1467/image7.png)

So this is something that's pretty cool and this syntax is going to be seen throughout pretty much all of the major frameworks that you work with. So whenever you see an import followed by a name by itself where it's not in curly braces and it doesn't use the star character what that means is that whatever code is inside of this file has a default export with this name. So for example, if you're using react, react you will have an `import React from './react' statement`. And so what that import is saying is that in the core React code they are exporting in a module called react just like right here where I'm saying `import navigation from './navigation'` is simply looking in this file and it is saying because they didn't give any curly braces and they didn't pass a star there must be a default export inside of here and so that's exactly what we're doing.

Now I want to extend this just a little bit just because there is a syntax that I've seen before you will see in various projects you work on that looks a little bit odd. And so I want to have you see this just so it makes sense. I'm going to come into our helper file here and I'm going to copy all this code and I'm going to paste it inside of here. So a ruled that we have in JavaScript is you cannot have multiple default exports in a file and if you think about it that's just logical.

I'm just going to close out this helper file and it's logical because the default is going to be matched up to the name. So if you had multiple default exports that would mean that you had functions with the identical name and that simply is not going to work. But what you can do is you can have a default export and inside of that same file you can have it named exports just like this.

**navigation.js**

```js
export default function () {
  return '<div>Logo</div>';
}

export function multiply(numOne, numTwo) {
  return numOne * numTwo;
}

export const greeting = 'Hi there';
```

So now inside of bootstrap.js, I can say import navigation, and then I can give a comma, and then I can say greeting inside of curly braces and then reference navigation one more time and then multiply and so you can have syntax it looks exactly like this.

**bootstrap.js**

```js
import navigation, { greeting, multiply } from './navigation';

console.log(navigation());
```

Notice we don't have an error

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/+JavaScript+Modules/How+to+Import+Multiple+Elements+from+a+JavaScript+File+%23+1467/image8.png)

and that is where we have a default argument and then we have named arguments. And if I come over here than what I can do is just get rid of our little navigation because we know that this works. And now I could call greeting or I could call multiply and as you can see we have our greeting variable value right here printed out.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/+JavaScript+Modules/How+to+Import+Multiple+Elements+from+a+JavaScript+File+%23+1467/image9.png)

That is how you can combine all of the different elements that we've learned in this section from basic imports which are named imports which can be a variable or a function as well as default arguments or default functions like we have right here in our top navigation function and you can actually combine those and you can bring them in.

Now if you're wondering why the javascript developers decided to craft the language like this it really comes down to what they saw from other frameworks and other code libraries that are out there. So, for example, the Ruby on Rails framework as much as I absolutely love it. One thing that can be a little bit confusing is that rails does a task which is called eager loading. So whenever you want to startup your rails server it actually loads the entire code base all at one time and that's perfectly fine. I still build out rails applications on a daily basis and I absolutely love it but that is one way of doing it.

Javascript decided to take a very different approach where they said instead of loading all of the code in one swoop like rails does you are going to have to do what we're doing right here where you are bringing in and you're actually being explicit in saying. I want to have this function and I want to have this variable and I want to have these different elements brought in imported for this file and if you do it right it actually does make for very readable code.

Because if you open up a well written react view project you're going to be able to look in and see just based on the imports what that file is supposed to do. You're gonna be able to see all of the tasks it performs because of what it imports. You're going to see all of its capabilities right there and that can be a very helpful approach whenever you're building out javascript applications.

## Resources

* [Project Source Code](https://github.com/jordanhudgens/modern-javascript-module-section/tree/e3ffd2737079518554a77e65d73ac5c909af734f)
