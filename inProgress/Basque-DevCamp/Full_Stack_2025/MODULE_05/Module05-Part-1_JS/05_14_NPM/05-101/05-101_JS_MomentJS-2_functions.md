# Module 05 - 101:    NPM

## MomentJS (2) - Popular functions

---

---

## Video Lesson Speech

Now that we have the momentjs library installed on our system, we can start using it.

****

And so the very first thing that we're going to do is start up the server I'm gonna say npm start. And then let's close out our node modules directory just so it doesn't confuse us at all. Go to SRC then bootstrap.js and now we can add our code inside of here. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image1.png)

Now first before we actually build out any of the popular functions let's first test it out to make sure that our import is working because the syntax for importing a file or a code library from a node module is very different than when we were writing our files manually. 

So if you pull down something like we did in a momentjs we are going to be able to call it with a little bit different syntax so here I can say import moment and then just say from moment and that is going to allow us to pull in the momentjs library. 

**bootstrap.js**

```js
import moment from 'moment';
```

Now you may notice this is slightly different syntax than when we talk through our modules section before and we did some things such as import navigation from and then we had to give a path to our file. So we did something like this.

```js
import navigation from './navigation'
```

Now the reason for this is because moment is actually inside of our node modules directory and it can be found through our package.json file if you have added a dependency to your application then you can import it exactly the way we did here on line 1. When you create your own code snippets and you create your own components then you need to provide a path so that JavaScript knows exactly where to go find that specific module. So with moment we can simply call it exactly like how we did and let's test it out in the console to see if this is working. So I should be able to say console.log and then just say moment.now and what this is going to do is this is going to give me the ability to call and get the epoch timestamp. 

It looks like we have a little bug. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image2.png)

So let's see what that is. So right here it says module Build failed syntax error Unexpected token. So where is our bug? I am saying `console.log(moment.now());` everything here appears like it should work with me, oh and there you go! I accidentally typed a colon instead of a semicolon. So here let's test it out. Open up the javascript console after we go to a local host 3000 and see if this is working. So as you can see right here we get a very weird looking number. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image3.png)

So what exactly does that this number represent? Well, when you call moment.now what this does is it actually goes and creates what's called an epoch timestamp. And so if we run this again I'm going to copy this number right here and just place it here as a comment.

So that is the number as it stands now. But now if we run it again you may notice that this number is now changed so we can look at the side by side and you'll see that these numbers are slightly different. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image4.png)

So what is the difference here? Well, an epoch timestamp is the number of seconds that have elapsed since January 1st, 1970. Now that may seem like the weirdest most arbitrary concept of you've never heard of that before but it's an important concept to know because you're going to run into epoch timestamps quite often no matter what programming language you decide to work with. And the reason for this number is because that was also when Unix which is the technology that our terminals in Mac and Linux utilize and that is when Unix created their time stamp and so they created essentially this rolling clock of seconds and milliseconds that have elapsed since 1970 and that is a way that you can perform a very fast form of calculation and that's what moment now does. 

But that's really just a test and also a way to show you where epoch timestamps are. So that is the first one and because we call this. This means that the moment library is successfully installed in our project so that is fantastic. 

So now let's go and let's see how we can perform some more practical kinds of implementations of momentjs and this is not a section on timestamps or time zones. It is not a course on momentjs but this is a very powerful library and I thought that this would be a great way to learn about packages by actually using one and seeing all of the different kinds of features that you can have access to in your application when you bring down an outside code package. And this is one of the most popular ones that you're going to be using in your applications. 

The next one is I'm going to show you how you can create a date. So I'm going to say const and I'll just say rightNow equals moment. 

```js
const rightNow = moment();
```

And I'm just going to call it like a function. And now if I `console.log(rightNow);` let's see what this brings us. And as you can see here moment gives us when you call it like a function. It gives us a date. And so you can see that right now at the time of this filming is Friday, February the 2nd at about 1:00 a.m. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image5.png)

I'm filming it at midnight right now. But this is the timestamp it's pulling up, and it has all kinds of cool little features here below the timestamp. Now, this might be a little bit hard to kind of parse through if you've never used it before. So what I'm going to do in the rest of this guide is go through some of my favorite functions that I personally have used in applications throughout the years. 

So that is our rightNow function this gives us a date object for the current time. Now you also can create your own date object so you can put in any kind of date you want. So if you want to put in a hardcoded date you can simply type it out. If you want to have a database query that slides a date in for say when an order was created or a customer signed up or anything like that you can slide it directly into a moment function and then you can have access to all of the cool date tools that it provides. So I'm going to create a birthday so I'm gonna say `const birthday` and now I'm going to call moment. 

But instead of leaving it empty like we did before. Now I'm going to pass in a date so I'm going to pass in my birthday so 1983-07-31. 

Now, this is a string and as great as moment is at parsing dates it also is a really good idea to give a moment an idea on exactly the format for your set of dates. So in this case what I want to do is I want to say that the format that this date is in has four year characters a dash followed by two month characters followed by a dash followed by two date characters.

```js
const birhtday = moment('1983-07-31', 'YYYY-MM-DD');
```

And the reason for this is because if you see any kind of date formatting on an international level. So if you look at how dates are formatted in Asia versus how they're formatted in Europe and then the U.S. and South America you are going to notice something very odd and that is that dates are formatted very differently wherever you go. And so because of that moment had to take all that into consideration. So it allows you to pass in your dates and also define explicitly what the format is going to be just like we did right here. So now if you want to make sure that this is working and I can say console log birthday save and now this is going to give us a date object but it's not for right now. It's a date object for my birthday. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image6.png)

It is for this exact date right here. And so now that we have this we can actually work with it. So let's see how we could decide what day of the week I was born and you don't have to plug my date in. When you are doing this you can use your own and see what day of the week that you were born. And I think this is pretty cool because this is a feature that I've had to build out manually in other programming languages and it is not a fun one to implement. And as you're going to see with one single line of code we are going to be able to build this feature so say console.log birthday dot format and the format function can you can pass anything you want to it. What we're going to do is we're simply going to pass four d's in a row right here so you can simply type dddd. 

```js
console.log(birthday.format('dddd'));
```

And I know this looks really weird and you may be thinking that is one of those things that you just would have to memorize and you do not. I'm going to show you after this exactly where you can find the documentation and find all of the what these symbols actually represent because I typically even though I use moment quite a bit in my own projects it is rare that I will have all of the things memorized and all of the different characters that I need so I leverage a cheat sheet that I will share with you as well. 

But first, let's actually go through it and see how it works. So now if I hit save you can see that I was born on Sunday. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image7.png)

So if you plugged in your own birthday right up here it should be giving you the exact date that you were born in. This is the named date. So that is a very cool tool. It is something that in many other languages is very hard to pull out. If you were to try to do this in say C or C++ that would be a pretty challenging task to do. So now that you can work with these named dates let's also look at a few of the other cool features. 

So instead of just format, I'm going to just comment this out for right now because we're going to save this and I'm going to show you a few more formatting features later on. But now let's see how we can create a counter.

So if I say console log and I call my birthday again. But now I say fromNow and that is a function. If I save this is going to give me a pretty cool little set of answers so this is going to say that this date was 35 years ago.

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image8.png)

So with the from now flag, this is one that I use constantly I've used this in so many different applications I've built out. And it's mainly because this type of behavior would be very difficult to build from scratch and I have had to do some things like this before and it's definitely not fun. So fromNow allows you to have this kind of counter. 

Now I'm going to change the date up just a little bit just so you can see a cool little feature here. So I'm going to say instead of my birthday I say two thousand seventeen. And let's say 01-12. 

```js
const birthday = moment('2018-01-12', 'YYYY-MM-DD');
```

So this is going to be January 12th of 2000. And actually, let me go with 2018 because that's just a few weeks ago. So if I hit save now you're going to see it doesn't just give me a -- it's not limited by years, so it doesn't give me a count of years. Right here you can see that it says this was 21 days ago. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image9.png)

That is fantastic. So it is dynamic and it can actually check to see if it is a value that is over a year then it is going to break it down it's going to say OK this was a year ago or this was 35 years ago. But if it's a shorter time period like right here it's going to say they probably don't want me to give a return value of this was zero years ago, that wouldn't be very helpful. So it narrows it down it filters the process so it gives you a much more specific returned set. So right here it says the number of days that occurred and I'm going to in the show notes give you access to each one of these popular functions so you can play with them yourself. 

And so I'm going to remove this just console.log so you don't have any confusion. And we're going to come back to the format right here. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image9.png)

So earlier I showed how you could use these four days in a row to get a named day of when you were born or any date that you're working with.

But you can also pass a number of other flags inside of here. So if I want to get the named month that I was born I can pass in three M's and then I can pass in a capital D a lowercase o. And then four Y's 

```js
console.log(birthday.format('MMM Do YYYY'));
```

and what this is going to do is it is actually to give me a pretty version of my date. So if I hit save. You can see right here that I was born on July 31st notice how it added this st to the end. That is the Do part right here and 1983. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image92.png)

Now as cool as this is this is still a little bit on the black magic side of things and so I do not like a world where things do not make sense. And so I'm going to show you how I use this. And so I'm bringing in from another window a cheat sheet that I use pretty much every time that I work with momentjs. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image93.png)

And so this cheat sheet is going to give hopefully a little bit of clarification on those various symbols and characters that I was passing in because if you saw that and you were intimidated and thought there's no way I'm going to intuitively know what those characters are. Well, then you're in good company because I do not either I don't work with the library quite near enough to have all of those kinds of characters memorized. 

But as you can see right here does this look familiar? 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image94.png)

This is the same format flag. And if you come down you'll see you have a cheat sheet that will give you all kinds of different formatting tools. So right here you can see that 3 d's in a row will give an abbreviated named weekday 4 d's is going to give the full one and that's what we use. So if you need a full print it out weekday and a named one then you can see that this is how you would do it if you need to do exactly what we did in that last formatting guide where we have a few months we have this Do and four Y's that Do is what prints out either st or th depending on the day of the month that is. 

And so this is an invaluable tool. I will put this in the show notes provided by [devhints.io](https://devhints.io/moment) and it is very helpful whenever you're working with momentjs because there are so many tools inside of the library that it is very difficult to memorize them all. And so that's where cheat sheets like this come in very handily. 

We're only going to perform one more task and that is I'm going to show you how we can perform calculations. So I'm going to get rid of all of our birthday fun right here and now let's build out a few types of calculations. 

The first one is going to be two weeks from now and I'm going to call the moment function and say add and then inside of this it expects two arguments. So I'm going to say two weeks from now and there's a couple of ways I can write this I can say 14 because it's 14 days comma and then pass in a string of days. And now if I want to console a log this out two weeks from now and then if I try to run this, this is going to look a little odd but I want to prepare you for that.

So looks like we have a little error. Let's see where that is though. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image95.png)

Two weeks from now. And I misspelled consul. So Miss fix that. OK. Now hit save.

And right here you can see that that worked. And even though we don't have an error now you may think this isn't very helpful because it didn't really give us a date. It gave us a moment object. And so if I click this arrow nothing here is really that helpful. Now if I go to this _d you can see that this does give us the full date 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image96.png)

because at the time of this recording February 16th is two weeks from now. So that is accurate but this isn't really everything that we want it seems like you just want a date. And the reason why you get this object back is because moment is so powerful and there are so many different functions that you may want to call that it's not going to simply return a date to you unless you explicitly ask for it expects it.

You want an object because an object one of these moment objects allows you to perform all of those other tasks such as calling for map or fromNow or any of those kinds of tools. That is something that is only available if you're working with a moment object. So what can we do? Well at the end of two weeks from now I can simply say toString and now if I save this you can see that it prints out the full string. So now we can see that this is accurate it prints out Friday, February 16th which is two weeks from now. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image97.png)

So that's one way of doing it but it is more flexible so I can also say I want moment to add two weeks from now.

And now if I say this you'll see that we get the exact same behavior because two weeks and 14 days are the same thing. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image98.png)

But I just wanted to show you both options so that you could see you're not limited simply to days or weeks you can also do months and years as well. So now that we have that, let me also show that we're not limited by adding we can also subtract.

So I'm going to say const six months or six months ago. If I can spell it correctly and say moment. So we're calling a moment function again and I'm going to call subtract and you may notice if you're using visual studio code that the IntelliSense with moment is very good. It keeps on giving me a really nice set of recommendations and in fact if I go back and just hit dot. You can see all of these functions. These are functions that are available inside of the moment. J.S. library 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image99.png)

I definitely recommend when this guide is over, play with this, get familiar with it because you'll see that we have only touched the very tip of all of the capabilities at the moment library provides to us.

Now I'm going to say moment subtract. And I'm going to say six, comma, and then pass in months. So if this works this should give us a date that is six months ago and if I say console log six months ago to string since we actually do want to see it and string is a function. If I hit save this is going to give us August the 2nd 2017 which is exactly six months ago so this is working perfectly. 

![large](https://s3-us-west-2.amazonaws.com/devcamp-pictures/Modern+JavaScript/Package+Management/Popular+MomentJS+Functions+%23+1471/image991.png)

I hope you enjoyed that!

I wanted to give you a practical walkthrough of how packages worked but not just at a high-level not just in showing you the npm registry and showing you how you could pull down packages and things like that. 

I wanted to show you how to incorporate it in an actual project and then call it from the project and then walk through some of the powerful tools it offers. Because I think that's one of the best ways of understanding why it is important to learn how to work with packages is by seeing all of the features that it can bring to your application.

## Resources

- [Project Source Code](https://github.com/jordanhudgens/modern-js-package-section/tree/e11009c92ca7d1e9a6ad1846bfe47b4dad2e85f2)
- [MomentJS Cheat Sheet](https://devhints.io/moment)
* [strftime format cheatsheet](https://devhints.io/strftime)
