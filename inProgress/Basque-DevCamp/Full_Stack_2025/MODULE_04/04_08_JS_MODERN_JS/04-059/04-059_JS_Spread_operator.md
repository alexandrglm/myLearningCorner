# MODULE 04 - 059: JavaScript

# Modern JS (11):     Spread operator

---

---

## Video lesson Speech

This javascript guide is going to focus on the spread operator. Now if 
you are relatively new to javascript or you're at least new to the most 
updated versions the spread operator might look a little bit weird to 
you and so I want to go through a number of examples of how it can be 
used and hopefully by the end of it you'll see how powerful it is.

****

Part of the reason why I wanted to dedicate an entire guide to this is that you're going to see the spread operator used in many of the popular javascript frameworks so it's important to understand exactly what it does and the situations when you're going to want to use it. 

The syntax for it is going to be three dots followed by some type of word`(...word)` and that is the syntax you're going to see. 

Now we're going to go through a number of examples. The very first example of what the spread operator can be used for is in combining arrays. So let's go through an example of a shopping cart because this is something that you might build in a real-world application. So I'm going to create a variable called shopping cart and inside of this variable, we'll just say it has a number of product IDs. So if you're building out and I will make them each unique. If you're building out some type of application let's say a React or Angular application then you might have a type of feature where a user can click on an add to cart button and then you're going to load it up in some type of collection like this.

```js
//combining Arrays

let shoppingCart = [345, 375, 765, 123];
```

So let's imagine that your shopping cart is full of these four product IDs and then say the user says they want to continue shopping. And so they have a new variable called new items and I'm going to set a sequel to just a few more product IDs just like this. 

```js
let newItems = [98, 123];
```

Now if they say they want to add all of these new items to the cart, how can you do that? Well if I used some of the older ways of doing it. So if I did something like `shoppingCart.push(newItems);` you're going to see what happens here. So let me go. And let me console log this out shoppingCart.

And now if I save and run this you're going to see that we have our first set of product IDs here in the shopping cart but then instead of just adding two, it added an array. 

```js
shoppingCart.push(newItems);
console.log(shoppingCart); // [ 345, 375, 765, 123, [ 93, 123 ] ]
```

What push does is it adds a new element to an array. But remember with javascript arrays you can have multiple data types. So it's possible to have an array that is something like this with even nested arrays and objects and all kinds of different elements. So javascript doesn't understand when you say that you want to push a new array. It doesn't realize that you simply want to add a few more elements. And so that's where the spread operator can come in and allow you to do that.

So if I say shopping cart push but instead of just new items I say ... and make this a spread operator. If I hit clear save and run then you'll see that now our array right here has exactly the type of data that we want it to have. 

```js
shoppingCart.push(...newItems);
console.log(shoppingCart);  //[345, 375, 765, 123, 98, 123]
```

So it doesn't it doesn't just have an array here now it has taken these elements and this is where it gets the word. It spreads them out so it expands them. So instead of being inside of this array it simply goes and it finds the elements in the array and it adds those.

That is the first example which is combining arrays. 

Now the next item is for copying arrays so copying arrays and I'll leave all this in the show notes and also comment the rest of the combining arrays out just so we don't have any extra output. 

So a very common process that you're going to see inside of programs that are React or Angular base is that you are not supposed to make changes to a data structure. So in other words, if you have a structure once again like shoppingCart. If I say const shoppingCart and I'm just going to come to grab my product IDs from the first shoppingCart. 

```js
const shoppingCart = [345, 375, 765, 123];
```

The common convention is that you wouldn't actually even make changes to shoppingCart. Now we did up here this was just an example showing you how you can perform a process like that. And that's part of the reason why I use let variables instead of a const variable. 

But in a program such as one that you'd build with React or Angular the common convention is that you would not change shoppingCart but instead, you would create a new shoppingCart so you would copy this, and then you would add the new elements to that. And part of the reason is that you want your program to have as few side effects as possible. And if you make a change to an existing data structure then if some other part of the program calls that data structure and doesn't realize you've made changes to it then you might run into some pretty nasty errors. 

Take for example if you added some type of string or something like that to the shoppingCart and then some other part of the program thought that the shoppingCart only had integers and then it ran a process over it that only works with integers then it would run into an error.

If you want to use a data structure and then make changes to it what you want to do is make a copy of it. But let's see what happens. I'm going to show you the two ways that you can do this right now and one is not going to work. And the second will work but it's a little bit messy. And then I'm going to show you a way that you can leverage the spread operator in order to implement this in the cleanest way possible. 

I'm going to say const and then updatedCart because this makes logical sense right. If I say updatedCart and then say shoppingCart then what you would probably think is that we are making a copy of shoppingCart and now it's simply going to be stored in updatedCart that makes logical sense and that's the way it works in certain programming languages as well. So if I say updatedCart and I want to say push ID 5 on here and then I'll hit console log updatedCart lets see exactly what our output is. It should be as expected we should have these four IDs. And then it should have the number five. So if I run. That's exactly what we get. 

```js
const shoppingCart = [345, 375, 765, 123];
const updatedCart = [...shoppingCart];
updatedCart.push(5);
console.log(updatedCart);    // [345, 375, 765, 123, 5]
```

But now watch what happens if I do this if I do shoppingCart save and run. Look at that. Our shoppingCart was changed and that's because of the way javascript passes around their variables. It isn't making a copy when you set shoppingCart equal to updatedCart.

It is simply passing a reference to this source shoppingCart so that means if you make a change to the updatedCart it also makes a change here. So that is still changing the source array which is not what we want to do. 

So let's see the way that you would properly implement this and it's still not the ideal one it's not the modern way but I want to show you all of the different variations of this so you can appreciate how much the splat operator can help you out. So now instead of saying shoppingCart and placing it in. What you would use is say `shoppingCart.slice` and then inside of slight What slice is going to do is it's going to create a copy and it's not my favorite name I don't think it's very descriptive but it's going to create a copy and it's going to store it in an updatedCart and then when we make these console log changes you'll see that we have actually only changed the updatedCart.

I'm going to do that hit clear save and now if I run this you'll see we're getting the behavior we want. We only change the value of updatedCart and we have kept shoppingCart exactly the same. So up until some of the more modern versions of javascript, this was a way that you would create a copy of a collection or of a variable and then made changes to a new copy of it. 

Now, this is perfectly fine but what we can do is we can actually leverage the spread operator to accomplish the exact same behavior. So if I get rid of my slice right here and put brackets around shoppingCart and then give it the three dots hit clear save and run and you'll see where you get the exact same behavior. 

```js
const shoppingCart = [345, 375, 765, 123];
const updatedCart = [...shoppingCart];
updatedCart.push(5);
console.log(updatedCart);     // [345, 375, 765, 123, 5]
console.log(shoppingCart);    // [345, 375, 765, 123]
```

This is exactly what we're looking to do. And you may see both versions of this out in real-world applications. Many javascript developers have been doing this for years and years and so they are very used to using tools like slice in order to make copies of data. But the more Javascript code that I've been looking at in more up-to-date applications, especially ones that are based in, react angular or view I am seeing the spread operator used to accomplish this so it's important to understand both that there is not one that is really better than another. There are two ways of accomplishing the same goal. So it's very good to keep in mind what those are and how you can use them. 

In a quick review so far we've seen how the spread operator can help us combine arrays and copy arrays. Now let's see how it can be used with function arguments and this is a very common pattern that you're going to see in applications and we're going to use the math library as an example. So I'm going to say math and this is just available in all of javascript. I'm going to say `Math.max();` and the way that the max argument works is you pass a list of arguments. So I can say 1, 5, 1, 10, 2, and 3. And what this is going to do is it is going to output whatever the top value is. So I can say console log and then wrap this all up and then it's going to print out in this case 10. So hit save and run and you can see 10 is the output. 

```js
console.log(Math.max(1, 5, 1, 10, 2, 3));   //10
```

Now if you had a large collection of values so say you had a number of revenue items or something like that and you wanted to see which one was the highest then you may think that you could do something like this and I'm going to put this right up at the top. I'll say const orderTotals and I'll put this exact same collection right inside of and so we have an array of these orderTotals

```js
const orderTotals = [1, 5, 1, 10, 2, 3]
```

and we want to see which one was the largest.

You may think that I could simply pass this right into Math.max and if I save and run this we get not a number(NaN). 

```js
const orderTotals = [1, 5, 1, 10, 2, 3];
console.log(Math.max(orderTotals));  //NaN
```

The reason for that is even though we may think we're passing a list in the same way we've passed in before. Before the way it was working is we were passing in a set of function arguments. And so the way javascript looked at it was that we were sending in one, two, three, four, five, and six arguments into Math.max. But what we are doing now with order totals is we're only passing one argument. We're only passing in one argument and it's not even a number it is an array. And so Math.max doesn't know what to do with it. And that's a reason why it's not a number. 

Now to fix this if I just give it the spread operator what this is going to do is it's going to take this array and it's going to spread it out. It's going to take each element in the array and it's then going to convert that into a set of function arguments. So if I hit save and run you'll see that now we're back to getting the right value

```js
const orderTotals = [1, 5, 1, 10,2, 3];
console.log(Math.max(...orderTotals));
```

and just understand exactly what's happening here. Let's look at the process. So we start off with this array [1, 5, 1, 10,2, 3]. So this is the array that we have stored in orderTotals. By adding the spread operator to this array. So by passing that right in front of orderTotals what javascript does now is it takes everything inside of the collection and it spreads it out and it makes them their own set of elements so no longer are we passing a single function argument into our max method. But now we're passing in six integers just like we did in the very beginning. So that's how you can use the spread operator in order to work with function arguments and you'll see that that's a very popular way of doing that in many of the modern frameworks. 

The last example that we're going to look at is going to be how we can use the spread operator in being able to work with object deconstruction. So I'm going to create an object here and so I'm going to say const and then inside of the object is going to be a baseball lineup so I'm going to say starter is Verlander and then our closer is going to be Giles and then we have to list off a variable number of relief pitchers. So we're going to have relief pitcher one is going to be Morton and then relief pitcher two is going to be Gregerson

```js
const {} = {
  starter: 'Verlander',
  closer: 'Giles',
  relief_1: 'Morton',
  relief_2: 'Gregerson'
}
```

and there is the possibility that we could have any number of relief pitchers if you're building this for a program that would be, say a scoreboard keeping application or something like that. Then you're not going to know how many relief pitchers that you have on a given team it changes on pretty much a daily basis. So you can't hardcode this in you know you're going to have a starter you know you're going to have a closer and you have a few hard and fast rules. But then there are a number of items that are going to be variable they're going to change each time. And so that is where the spread operator can help us perform deconstruction. So if I come up to const here and I add curly braces in front and this is how we can perform object deconstruction we've talked about variable and array construction. This is specifically how we can work with object deconstruction. 

If I say starter and then closer then let me come down and add some console log statements say starter and then closer I hit save and run this is going to give me Verlander and Giles because of the way deconstruction works. 

```js
const {} = {
  starter: 'Verlander',
  closer: 'Giles',
  relief_1: 'Morton',
  relief_2: 'Gregerson'
}

console.log(starter);
console.log(closer);
// "Verlander"
// "Giles"
```

If I pass in a value like this such as starter it's going to be a map to the keys and the same thing with closer and so how can we get this set of relievers when we don't know the full set of names or anything like that? Well, we can use our spread operator. I can add a comma ... and then relievers 

```js
const { starter, closer, ...relievers } = {
```

and what javascript is going to do is it is going to use a spread operator and realize that we mean any number of relievers and so it's going to go and find everything else that's left and then it's going to put that inside of another object. So if I hit console.log and now I say relievers if I hit save and clear we're now going to get an object of relievers along with our starter and closer. So if I run we get Verlander, Giles, and the third one we get relief_1 Morton and relief_2 Gregersen. 

```js
const { starter, closer, ...relievers } = {
  starter: 'Verlander',
  closer: 'Giles',
  relief_1: 'Morton',
  relief_2: 'Gregerson'
}

console.log(starter);
console.log(closer);
console.log(relievers);

//"Verlander"
//"Giles"
//Object {
//  relief_1: "Morton",
//  relief_2: "Gregerson"
//}
```

This is one of the most common ways of performing deconstruction with objects and you're going to see this a lot in applications that utilize react because this is one of the most common ways that you use function arguments when you don't know how many you are going to be dealing with. And you need to be able to extract them and store them inside of a variable so that you can use those later on. 

Great job if you went through that! You should now be more familiar with how to use the spread operator in javascript.

## Code

```js
// Combining Arrays
let shoppingCart = [345, 375, 765, 123];
let newItems = [98, 123];

shoppingCart.push(...newItems);
console.log(shoppingCart); // [345, 375, 765, 123, 98, 123]

// Copying Arrays
const shoppingCart = [345, 375, 765, 123];
const updatedCart = [...shoppingCart];
updatedCart.push(5);
console.log(updatedCart);
console.log(shoppingCart);

const orderTotals = [1, 5, 1, 10, 2, 3];
console.log(Math.max(...orderTotals));

// [1, 5, 1, 10, 2, 3]
// ...[1, 5, 1, 10, 2, 3]
// 1, 5, 1, 10, 2, 3

const { starter, closer, ...relievers } = {
  starter: 'Verlander',
  closer: 'Giles',
  relief_1: 'Morton',
  relief_2: 'Gregerson'
}

console.log(starter);
console.log(closer);
console.log(relievers);
```

****

## Coding Exercise

In the `return` below, use Math and spread operators to find the highest number of the `highscore` array.

```js
function yourTest() {
  const highscore = [237.0198, 256.1, 234.846, 237.21, 256.654];

  return ();
}

yourTest();
```
