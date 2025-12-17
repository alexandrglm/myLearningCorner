# 04-053\_JS\_Exercise\_Building\_HTML\_generator

## MODULE 04 - 053: JavaScript Exercise

## Build an HTML Heading Generator Function

***

***

### Video lesson Speech

In this javascript coding exercise we are going to build out an HTML\
heading generator function. Now, this is going to be a pretty basic type\
of exercise but it's good practice to be able to work with string\
interpolation.

***

What I want you to do is to be able to build a function where you can pass in two arguments. So I want you to be able to build a function that passes in some type of title for the heading and then I also want you to have an argument for the type of heading. What this will mean is you can build out some type of function and we can say heading generator and then pass in some title such as Hi there and then we can pass in a number so I want this to say 1 and what this should output. What this should generate is something like this, this should give us HTML of an H1 tag that says Hi there and then closes off that tag.

Now, this is something that may be a little basic if you have a lot of JavaScript development experience but if you're new to programming or new to JavaScript then this is definitely a good exercise. So I recommend that right now you pause the video and then you go and you build out this function.

Now the solution that I would use is I would start by creating a function and so I'm gonna say const heading generator and I'm going make this an arrow function. Like I mentioned I want to have a title argument and then type of heading argument then we'll pass in our arrow function and inside I'm simply going to want to return a string and I'm going to use ES6 syntax. I'm going to have back tics here and so I want to return a string and I'm going to start off with a greater than symbol because remember what our goal is and this may help to have a comment here of what our goal is.

I want to be able to have something like this where you say h1 and then my title and then they H1 here.

```js
// <h1>Title</h1>
```

Now, this H1 part has to be dynamic though so I can't just come up here and hard code H1 in because remember we need to be able to create an h1 tag and H2, 3, 4, or 5, whatever it is we need to be able to pass that in. So I'm going to say just H and then using the string literals I'm going to use a dollar sign curly brace and then inside if here I am just going to pass in the type of heading and then close that off. Then inside of our tag, I'm going to say title and then let's close it off so I'll say H and then the dollar with the curly brace and then type of heading end it and then we want to actually close off that tag and then that is all that we need to do.

```js
<h${typeOfHeading}>${title}</h${typeOfHeading}>
```

So I'm going to save this and once again I do this pretty much every single video that's my normal workflow but I want to actually show you with Quokka and so I'm just going to render it all in real-time so I'm gonna say heading generator. Now we're going to pass in our title so here let's make the title a string and just say greetings and then the second argument let's make it an h2 tag so I'm going to pass in h2 and now if I call this you can see that I get greetings inside of an h2 tag.

![large](../../../../../../.gitbook/assets/04-053_IMG1.png)

Now if I want to change that title I can say Hi there and change it to an H1 tag. Now you can see we're generating a full top-line heading with an H1 that says Hi there.

![large](../../../../../../.gitbook/assets/04-053_IMG2.png)

As you can see with just a pretty small amount of code we're able to leverage string literals and this is something specific and you need to be able to have a tool such as ES6 in order to use this type of syntax. If you are using older versions of JavaScript then what you would need to do is inside of that function you'd need to say something like return and than pass in strings so you'd pass in the H and then say plus typeOfHeading and then you just kind of keep on going like that with a bunch of plus signs connecting all of them.

But that's a reason why using the back tics has really become a very popular way of using string literals and string interpellation because it allows you to be a little bit more expressive and explicit with the type of strings that you're trying to generate. So I hope you had fun with that exercise you now know how to create an HTML Heading generator function in JavaScript.

### Resources

* [Exercise Source Code Solution](https://gist.github.com/jordanhudgens/f3c70c323c5ec86b814ee5d04a953be7)
