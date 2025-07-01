# Module 06 - 119:    JS Applied Exercises

## Character Countdown

****

## 1. Original Exercise

This exercise focuses on creating a real-time character counter similar to Twitter's input limit functionality.   

We'll explore DOM manipulation, event handling, and state management in a practical implementation.

## 2.    Objectives

- Implement real-time input tracking

- Understand `keyup` vs `keydown` events

- Manage element states based on conditions

- Handle `this` binding in event handlers

- Create user feedback systems

## 3.    Original Implementation

#### Starter Code

```html
<!DOCTYPE html>
<html lang='en'>
<head>
<meta charset='UTF-8'>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>17_01 Character Countdown</title>
</head>
<style>
    .container {
        display: grid;
        max-width: 80vw;
        height: auto;
    }

    .container p {
        background: #bbff00;
        border: 2px solid black;
    }

    .container input {

        height: 50vh;
        width: 80vw;
    }
</style>
<body>
    <div class="container">
        <p>Character Container Demo</p>
        <input text="text" class="msgInput">

        <div>
            Characters Left -> <span class="msgCounter">144</span>
        </div>

    </div>
    <script>

        // Code will be here
    </script>
</body>
</html>
```

### Code

#### What we need

```js
// 1. Variables from INPUT, COUNTER TEXT and MAX CHAR VALUE

// 2. A method to ensure if input length trespass the max value. or not

// 3. A methos to alert trespassing values, disabling input, etc
```

```js
const msgInput = document.querySelector('.msgInput');  
const msgCounter = document.querySelector('.msgCounter');
const maxValue = 144;


// ensure character counting
/*
*
* func:    ensure that the message content has (or hasn't) a max lenght characters
* params:  
*          content -> The message from input
*          maxValue -> The max lenght set @ maxValue const
* 
* Return:    True or False
*/ 
const getCurrentContentLength = (content, maxValue) => {

    const maxLength = maxValue;

    if (content.length > maxLength) {
        return false;

    } else {
        return true;

    }
}


// event listeners watch for keyUp -> Pressing key, when finished typing
/*
* .onkeyup() event listener
*
* Func:
*        msgCounter.innerHTML = maxValue MINUS the predefined maxValue as length
* 
* 
* Scope: this needs its own scope so arrow functions it's not elegible
*/ 
msgInput.onkeyup = function () {

    console.log(this.value)

    msgCounter.innerHTML = maxValue -this.value.length

    /*
        * 
        *  Then, if ensure content length cannot be ensured ,
        *  text input will be disabled.
        */

    if ( !ensureContentLength( (this.maxValue), (maxLength -1) )) {

        msgInput.disabled = true;

    }
}
```

****

## 4.    Exercise Explained

### A. Event Selection: `keyup` vs `keydown`

- **keyup**: Triggers when key is released (better for final input)

- **keydown**: Triggers when key is pressed (may catch intermediate states)

### B. `this` Binding in Event Handlers

- Regular functions maintain their calling context (`this` = element)

- Arrow functions inherit `this` from parent scope (often `window`)

### C. State Management

- Track remaining characters in real-time

- Toggle input state based on business rules

- Provide visual feedback when limits are reached

### D. Validation Approach

- Separate validation logic from display updates

- Use helper functions for reusable checks

- Consider edge cases (like off-by-one errors)

****

## 5.    More Derivated Exercises

### 1. Multiple Counters

```js
document.querySelectorAll('.char-counter').forEach(counter => {

    const input = counter.previousElementSibling;
    const max = parseInt(counter.dataset.max) || 144;

  input.addEventListener('input', function() {

    const remaining = max - this.value.length;
    counter.textContent = remaining;

    if (remaining <= 0) {

        counter.classList.add('limit-reached');

    } else {

        counter.classList.remove('limit-reached');

    }
  });
});
```

### 2. Visual Feedback States

By Adding new CSS elements for debugging, for catched errors, to improve the UX

```js
.error {

    color: red;

}

.validLength {

    color: green;
    font-weight: bold;

}
```

### 3. Debouncing for Performance

```js
let timeout;

msgInput.addEventListener('input', function() {

    clearTimeout(timeout);
    timeout = setTimeout(() => {

        // Update logic here
    }, 300);
});
```

****

## Best Practices

1. **Separation of Concerns**: Keep validation logic separate from display

2. **Progressive Enhancement**: Work without JavaScript when possible

3. **Performance**: Debounce rapid input for smoother performance

4. **Accessibility**: Use ARIA live regions for screen readers

5. **Testing**: Verify with different input methods (typing, pasting, etc.)

## Common Pitfalls

1. **Off-by-one Errors**: Always test edge cases around limits

2. **Input vs Change Events**: `input` catches all changes, `change` only final

3. **Mobile Keyboard Issues**: Test on touch devices for unexpected behavior

4. **Paste Handling**: Remember users might paste content

5. **Accessibility**: Ensure color contrast and ARIA attributes

****

## References

[HTMLInputElement - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/HTMLInputElement)

[KeyboardEvent - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/KeyboardEvent)

[ARIA live regions - ARIA | MDN](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/Guides/Live_regions)

https://javascript.info/events-change-input

[this - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Operators/this)

****

## Video Lesson Speech

What we're going to build out is a character countdown.   

So if you've ever seen tools such as Twitter and you saw how you were typing something into a form input and it was counting down on the screen.   

That is what we're going to build out and in the next guide, we're going to extend it and see how we can build out the ability to have multiple character countdowns on the same page and to follow best practices while doing it. 

So all of the HTML we're going to need is already on the page here. 

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Build+a+Character+Countdown+Function+in+JavaScript+%23+1594/image11.png)

I have an input that has a class of message input and then we have this div that has our countdown and I wrapped up our message calendar inside of a span. So with all of that in place, we can start writing our code. The first thing I do is I'm going to set our variables so I'm gonna say const message input and so I'm going to use a query selector so I'll say `document.querySelector` and we just want a regular query selector, not all here, and then we'll pass in the value that we're looking for which in this case is the message input. And with that in place, we can also come in grab our message counter because we're going to need this in order to set its values so I'll go message counter and then counter just like this.

Now the last variable we're going to need is a max value. So this is going to be the max character count so for this case it's going to be 144. So say const max and by default, we'll just have it set to 144 at the beginning. 

```js
const msgInput = document.querySelector('.msgInput');
const msgCounter = document.querySelector('.msgCounter');
const max = 144;
```

So everything there is all the data that we're going to need. 

Now when we have something that is a little bit more on the non-trivial side so we're not just trying to add a class or do anything like that we actually have to maintain a level of state here because we're not just looking to toggle something we're looking to keep track of something. So whenever we're going to do that I think it definitely pays off to think our way through the process that we're going to want to follow. 

A couple of things that I think we are going to need is you need a way of ensuring that we have not hit the max value. So ensure character count. So we're going to create a function just for that and then I'm going to need an event listener that will watch for the keyUp. So if you think about events in Javascript what happens when the user is typing you have a few different events whenever you're working with an input field. So one of them is keyDown that's where someone presses the key and it goes down. But what we actually want is we want to know when the key is up because that's when they have finished typing. So if I type s here the key up event will trigger as soon as my finger comes off of the keyboard.

So that is all we're looking for here and we need to keep track of it. And so we're going to have an event listener that's going to do that and then we're going to as the user is typing. We're going to ensure that they have not gone past the character count. So let's create this character count function first. So I'm going to say const and then let's call this ensureContentLength you can call it where ever you like I think that is a good name for that. 

And this is going to take in two arguments it's going to take in the content and it's going to take in whatever the max value is and I'll use an arrow function here. And so inside of this, I'm just going to have a basic conditional so I'll say if content.length is greater than our max. Then I want to return False and else I want to return true. 

```js
const ensureContentLength = (content, max) => {
    if (content.lenth > max) {
        return false;
    } else {
        return true;
    }
}
```

So that part is pretty basic all we're doing is we're saying I need a content and a max. And if the content length is greater than max then I want you to return false which means that we're no longer ensuring this character count so that is our validator. 

So now with that in place let's come down here and add out event listener. Now we're going to take a different approach than we've taken before and it's because we need to actually keep track of the length. If I were to do something like this where it's a msgInput.addEventListener and then I listened for on key up this actually would not work in this example. 

Because we need to keep track of the total length we don't just want to know about the event that's where this is very different than say a click. We actually want to know and keep track of everything. So I'm gonna say message input dot on keyUp and then set this equal to a function declaration. Now do not use an arrow function here and I'll show you why in a minute so just use a regular function declaration. 

And now what we're going to do is we're going to grab that counter which is actually message counter, so message counter and then we'll say `msgCounter.innerHTML` because we're wanting to set this value right here. So say innerHTML equals our max and then minus this dot value dot link. 

```js
msgCounter.innerHTML = max -this.value.length
```

So let's save this and see if this is working, so come over here hit refresh. And now if I type in one character it counted down perfect type another one and this is working perfectly. 

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Build+a+Character+Countdown+Function+in+JavaScript+%23+1594/image12.png)

Now if you're wondering why you needed to use function right here. Let's take a look at that before we finish this exercise. So if I tried to go with an arrow expression and said something like that. Watch what happens if I try to console.log this so if I say console.log and this dot value and hit save if I come back and hit refresh let's see what this actually is. So it is undefined and we have an error it says uncaught type error cannot read property length of undefined. 

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Build+a+Character+Countdown+Function+in+JavaScript+%23+1594/image13.png)

So what this means is because we used an arrow function this changed the scoping of what `this` represents and so remember that the arrow function is not just a shorter way of writing a function it specifically is going to change how `this` is scoped and so, in this case, we actually want to go with the traditional just function declaration in order to have the proper scope of this defined. 

And so if I change that back hit refresh now this is working perfectly and you can see it keeps track of the value it doesn't just give us the event. 

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Build+a+Character+Countdown+Function+in+JavaScript+%23+1594/image14.png)

And so this is why I didn't just want the event value I wanted to use this full expression just because I think it makes sense to structure it this way and you have access to all the data that you are looking for. 

Now let me clear this console log out because we have one more feature that I think would be pretty cool to add in and that is I want to keep track because you may notice we haven't actually even used this function yet and it's because I want to keep track of the character counts and then I want to disable this if it goes over the limit. So if this goes up to 144 I want to disable the field so the user can even type anything else in. So I'm going to come back into our event listener here and say if and then I'm gonna start off with the with a bang and then say ensure content length and remember this takes in two arguments so this is going to take in this.value and then it's going to take in the max minus one.

```js
if (!ensureContentLenth(this.value, (max -1)))
```

The reason for that is because if you don't do Max minus 1 remember that the values and everything you're going to end up in a situation where you have an off by one error. So I'm going to subtract one from it and then inside of here say msgInput.disabled equals true 

```js
msgInput.disabled = true;
```

So if all of this works let's change our max down here to something like 20. And so if all this is working as soon as I hit 20 characters then it should go and it should disable this field. So I hit refresh and don't let the 144 scary away that's simply hardcoded and it'll change as soon as I start typing so I type in one character. It's 19 and now 18 and so if I keep going as soon as we hit 0, look at that the field is now disabled and I can't type anything else in. 

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Build+a+Character+Countdown+Function+in+JavaScript+%23+1594/image15.png)

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Build+a+Character+Countdown+Function+in+JavaScript+%23+1594/image16.png)

That is because this cool little ensure content length function here was checking for the value it was watching it at each key up event. And then as soon as we hit that max it simply said Okay it's time to disable this entire field. 

So this is a really fun introduction to learning how to work with text input, how to have some more insight into the differences between arrow functions and traditional function declarations, and how we could build a cool character countdown feature. 

## Starter Code

```html
<!DOCTYPE html>
<html lang='en'>
<head>
  <meta charset='UTF-8'>
  <title></title>
</head>
<body>
  <input type="text" class="msgInput">

  <div>
    Characters left <span class="msgCounter">144</span>
  </div>
</body>

<script>

</script>
</html>
```

## Code

```html
<!DOCTYPE html>
<html lang='en'>
<head>
  <meta charset='UTF-8'>
  <title></title>
</head>
<body>
  <input type="text" class="msgInput">

  <div>
    Characters left <span class="msgCounter"></span>
  </div>
</body>

<script>
  const getCurrentContentLength = (content, max) => {
    const maxLength = max;
    if (content.length > maxLength) {
      return false;
    } else {
      return true;
    }
  }
  const msgInput = document.querySelector('.msgInput');
  const counter = document.querySelector('.msgCounter');
  const max = 20;
  // Nope
  // msgInput.addEventListener('keyup', (e) => {
  //   console.log(e);
  // });
  msgInput.onkeyup = function() {
    counter.innerHTML = max - this.value.length;
    if(!getCurrentContentLength(this.value, (max - 1))) {
      msgInput.disabled = true;
    }
  }
</script>
</html>
```

****

## Coding Exercise

Using what you've learned so far, insert the quote "*Innovation distinguishes between a leader and a follower*" into the first div.  

 Then insert the name of the author ("Steve Jobs") into the second div.

```html
<div id="quote"></div>
<div id="author"></div>
```

```js
// Write your code here
```
