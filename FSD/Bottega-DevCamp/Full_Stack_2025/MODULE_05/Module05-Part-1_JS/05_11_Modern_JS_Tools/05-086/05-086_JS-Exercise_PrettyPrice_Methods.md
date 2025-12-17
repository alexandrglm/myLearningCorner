# MODULE 05 - 086:   Exercise

## PrettyPrice Method

***

***

## Video Lesson Speech

In this javascript coding exercise we're going to build out a pretty price function

***

What I'm talking about when I say pretty price is I want the ability to create a function like this where we can call it and say prettyPrice and then pass in some numbers. So this number could be something like three dollars and fifty cents and then we should be able to pass in an extension on it. So I could pass something like this.

```javascript
prettyPrice(3.50, 0.95)
```

And then what this would return would be 3.95 cents. So if you're building out an e-commerce application and part of the how I got the idea to create this exercise was because I needed to build out a filter just like this I needed to build out a function that took in any kind of number and then it normalized the return value. The reason was because the data was coming from an auto-generated kind of calculation. So in one instance, I might have 3.50, another one might be 3.32, another one might have been flat a 100 dollars, and in each case what I needed to do was to make sure that it said whatever this value was and then .95 cents.

So if you've ever seen that in an e-commerce application if the number was not hardcoded in or in the database and it was automatically generated like it was in that app I was building out then you're going to have to perform some kind of calculation like this. So I would recommend that right now would be a good time for you to pause the video and then build out this full solution yourself.

Now before you do that I want to add one little twist on the exercise, and that is that I want the ability to not only be able to accept different numbers like this, like 0.95 cents, I also want if you put in something like 95 cents then I want to have the exact same behavior. So what the system needs to be able to do is to be pretty flexible where it can take in either a float value like 0.95 or it can take in a whole number and then it will automatically know that if a whole number gets passed in that we're going to update the extension.

So 95 gets treated the same whether it's 95 cents or just the number 95. So now that you know the instructions and the requirements pause the video right now go and build it out and then come back and then we'll walk through my own personal solution.

Welcome back, I'm going to clear all of this out so we have some room to work with and I'm going to create a function so I'm gonna say const prettyPrice and this is going to take in two arguments. The first is going to be whatever that gross sale price is and the next one is going to be the extension and this is going to be an arrow function, I need to make sure that I add that in.

```javascript
const prettyPrice = (grossPrice, extension) => {

}
```

OK, now let's talk about the base case scenario. So before we get into having to worry about working with the number 95 and when I'm saying that I'm just saying as an example it might be 99 it might be 0 it's whatever you want to pass in. But before we even get into being able to take both decimals and regular whole numbers let's talk about the easiest way to get the system working.

So if I have a value, so let's say that I make gross price here is something like 3.50. If my goal is to get rid of this 50 cents there are a few ways of doing it. But I think the easiest way here is to just call a function on it so I'm going to say Math.floor and then pass in that value and now you can see that the number 3 gets returned.

![large](../../../../../../../.gitbook/assets/05-086_IMG1.png)

And so if we duplicate this and let's say here we passed in 10.83 then ten gets returned and if we put a million different numbers in there each time it would take that decimal and then it would simply strip off whatever decimal value is on there and it's going to return that whole number.

![large](../../../../../../../.gitbook/assets/05-086_IMG2.png)

And the nice thing about this is if we pass in just 10 then it still works because whenever you call Math.floor on an integer, it just returns the exact same integer. So that is all that we need to do it for the first part of this. So if I say return and then Math.floor and pass in the gross price then when I can do is say gross price plus extension and that's going to get us our base case perfectly taken care of.

So now we can call this function, so let's say pretty price and pass in 3.42 and then pass in 0.95 and let's end the expression and see what that gives us, and that's it 3.95.

![large](../../../../../../../.gitbook/assets/05-086_IMG3.png)

Now if we wanted it to be 3.99 pass that in and it works beautifully.

![large](../../../../../../../.gitbook/assets/05-086_IMG4.png)

So I'm really happy with this first part of the solution but it's not perfect yet because watch what happens if we try to pass in a whole number. Now it's doing what you'd expect, it is taking 3.42 down to 3 and then it's adding 99 to it.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+Coding+Exercises/Mathematical+Computation/Build+a+Pretty+Price+Method+in+JavaScript+%23+1701/image15.png)

But what we want to do is to check and see if a regular decimal is passed in then we can add the identical behavior to what we have right here. But if a whole number is passed in we need to add a conditional to our function to check for that and if it is a whole number like this then what we need to do is convert it into a decimal. And in fact we need to also multiply it by 0.01 in order to get the value we're looking for. So let's add that conditional I'll say `if (Number.isInteger)`. So this is a function provided by JavaScript and what I can do is say if number is integer pass in that extension. So if the number extension is a whole number then inside of this code block I simply want to reassign extension and I want to say extension is equal to extension times zero point zero one.

```javascript
const prettyPrice = (grossPrice, extension) => {
    if (Number.isInteger(extension)) {
        extension = extension * 0.01;
    }
    return Math.floor(grossPrice) + extension;
}
```

Okay, so now if you come down you can see our output has already updated. So now on line 9 here even when we pass in 99 the correct value is still being output so our filter is working perfectly.

![large](../../../../../../../.gitbook/assets/05-086_IMG6.png)

We could pass in a decimal, we could pass in a whole number. And then the system is going to be able to check for what got placed in and then it's going to go through and run through the entire system generate that pretty price. And now we can use it on a web application, a mobile application, or whatever type of JavaScript app that you're working on.

## Resources

* [Exercise Code](https://github.com/bottega-code-school/javascript-code-exercises/blob/master/mathematical_computation/pretty_price.js)
