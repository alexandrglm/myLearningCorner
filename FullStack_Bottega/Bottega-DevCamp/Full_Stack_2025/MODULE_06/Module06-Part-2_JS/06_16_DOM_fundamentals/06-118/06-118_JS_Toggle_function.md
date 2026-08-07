# Module 06 - 118:    DOM Fundamentals

## Toggle function

***

1. Core Concepts
2. Hierarchy of Class manipulation methods
3. Key methods and Properties
4. Practical Usage Scenarios
5. Advanced Techniques
6. Best Practices, Considerations

***

## 1.     Core Concepts

The `classList.toggle()` method provides an elegant way to switch between adding and removing a\
class name from an element. This is particularly useful for implementing\
show/hide functionality, theme switching, or any binary state changes\
in your UI.

* Automatically adds the class if not present
* Removes the class if already present
* Returns `true` if class is added, `false` if removed
* Can accept an optional second boolean parameter to force add/remove

***

## 2.     Hierarchy of Class Manipulation Methods

**Element.classList Methods:**

1. `add()` - Adds one or more class names
2. `remove()` - Removes one or more class names
3. `toggle()` - Toggles between adding/removing a class
4. `contains()` - Checks if class exists
5. `replace()` - Replaces one class with another

***

## 3.     Key Methods and Properties

### toggle() Method Parameters:

| Parameter   | Description                 | Required |
| ----------- | --------------------------- | -------- |
| `className` | The class to toggle         | Yes      |
| `force`     | Boolean to force add/remove | No       |

### Return Value

* `true` if class is now present
* `false` if class is now absent

***

## 4.     Practical Usage Scenarios

### Basic Toggle Example

```js
const button = document.getElementById('toggleBtn');
const element = document.getElementById('content');

button.addEventListener('click', () => {

    element.classList.toggle('active');

});
```

### Force Parameter Usage

```js
// Always add the class (won't remove if present)
element.classList.toggle('active', true);

// Always remove the class (won't add if absent)
element.classList.toggle('active', false);
```

### Multiple Class Toggle

```js
// Toggle multiple classes
function toggleTheme() {

    document.body.classList.toggle('dark-mode');
    document.body.classList.toggle('light-mode');

}
```

***

## 5.     Advanced Techniques

### Toggle with Custom Properties

```js
// Toggle with data attributes
button.addEventListener('click', () => {

    const isActive = element.classList.toggle('active');
    element.dataset.state = isActive ? 'active' : 'inactive';

});
```

### Animation Callbacks

```js
element.classList.toggle('animate');

element.addEventListener('transitionend', () => {

    console.log('Toggle animation complete');

});
```

### Toggle with Storage

```js
// Persist toggle state
button.addEventListener('click', () => {

    const isDark = document.body.classList.toggle('dark-mode');

    localStorage.setItem('darkMode', isDark);

});



// Initialize from storage
if (localStorage.getItem('darkMode') === 'true') {

      document.body.classList.add('dark-mode');

}
```

***

## Best Practices

1. **Semantic Class Names**: Use descriptive class names (e.g., 'hidden' vs 'x1')
2. **CSS-Only Alternatives**: Consider pure CSS solutions for simple cases
3. **Accessibility**: Ensure toggled states are accessible (ARIA attributes)
4. **State Management**: Track toggle state when needed for application logic
5. **Performance**: Debounce rapid toggle events when necessary

## Performance Considerations

1. **Batch Operations**: Toggle multiple classes in one operation when possible
2. **CSS Transitions**: Use with CSS transitions for smooth animations
3. **Event Delegation**: Use for multiple toggle buttons
4. **DOM Reads/Writes**: Minimize layout thrashing when toggling many elements

## Common Pitfalls

1. **Over-toggling**: Accidentally calling toggle multiple times in event chain
2. **Missing Classes**: Forgetting to define the CSS for toggled classes
3. **Specificity Issues**: CSS specificity overriding toggled styles
4. **Animation Conflicts**: Forgetting to handle interrupted transitions
5. **Memory Leaks**: Not cleaning up event listeners on dynamic elements

***

## References

* [Element: classList property - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/Element/classList)
* [DOMTokenList: toggle() method - Web APIs | MDN](https://developer.mozilla.org/en-US/docs/Web/API/DOMTokenList/toggle)
* [Using CSS transitions - CSS: Cascading Style Sheets | MDN](https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_transitions/Using_CSS_transitions)
* [ARIA - Accessibility | MDN](https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA)
* https://javascript.info/dom-attributes-and-properties#dom-tokenlist

***

## Video Lesson Speech

We've already worked through how to do this a number of times throughout this course where we have some things like this setup where we had a button and then a div. And then when we click on the button we had the divs visibility toggled and we simply did it by using a class just like this.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Use+JavaScript's+Toggle+Function+%23+1593/image11.png)

But so far in this course, we have done it manually so we've had the setup where we would go we would find that component on the page and then we would add a class and then remove a class and then we'd have a conditional where we check to see if the class was in the class name list and then we would swap it out.

And that's fine and there are certain circumstances when you need to do that such as when you have more than two types of behavior that you're wanting to check for. But in the basic example where you simply want to toggle between two classes such as showing and hiding elements that is such a common thing that you're going to be asked to do that JavaScript in the later versions have built that behavior directly into the language. So that's what we're going to walk through in this guide.

So if I switch to the browser you can see right here we have this Toggle Me button

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Use+JavaScript's+Toggle+Function+%23+1593/image12.png)

and what we're looking for is that whenever we click it we'll have the div show up and then when we click it again it will be hidden because it's going to be simply showing and hiding the elements based on the CSS class. So let's build our first element which is going to be our selector and for this one, I'm gonna use the element by ID because you can see we have that ID right there. So I'll say `const heading = document.getElementById` and let's pass in the ID of mainHeading.

```html
const heading = document.getElementById('mainHeading')
```

And so now that we have access to the heading let's also grab access to the button so I'm gonna say const and here I'll just say button(btn) and we'll do the same thing where we do `document.getElementById` and you can see we have a toggle button ID right there.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Use+JavaScript's+Toggle+Function+%23+1593/image13.png)

And so now that we have that now we can add our event listener which we've walked through this a number of times so feel free to go ahead and try to do this before you even watch me do it. And then you can come back when we start the toggle feature but the button is going to have an event listener called addEventListener and we're going listen for the click and then we also are going to pass the click the function.

So we're going to grab the event pass an arrow function and inside of it we are going to go and grab our heading because that's what we're wanting to change then `heading.classList.toggle` and you can see the toggle functions built directly into the language like that and then what toggle expects is it expects us to pass it whatever the class is that we want to toggle. So, in this case, it's hidden which is the name of our CSS class if you scroll up. So that is all we need to do we can save this file.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Use+JavaScript's+Toggle+Function+%23+1593/image14.png)

And now if I switch over to the browser and hit refresh and click on toggle me you can see that our toggle me function is working perfectly.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Use+JavaScript's+Toggle+Function+%23+1593/image15.png)

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Use+JavaScript's+Toggle+Function+%23+1593/image16.png)

Now before we end this guide let's look at the source code here. So let's see exactly what is happening and let me move this so that it's actually attached to the window. So what I want to look for is that class. So right here you can see that when toggle me has been selected if you come and look at mainHeading you can see there's no class there right here.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Use+JavaScript's+Toggle+Function+%23+1593/image17.png)

But if I click on toggle me you can see it adds hidden in.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/JavaScript+in+the+Browser/+JavaScript+and+the+DOM/How+to+Use+JavaScript's+Toggle+Function+%23+1593/image18.png)

And then if I click on it again it takes it away so that is how that behavior is being implemented. It's exactly what we did when we manually had the conditional built in where we performed our event listener then we checked to see is hidden inside of the class list if it is, then perform this behavior and if not do this.

So what the toggle function allows you to do is to automate that behavior. So any time that you simply have one class that you want to have or to add to the DOM or remove from the DOM then toggles a great way of doing that.

## Starter Code

```html
<!DOCTYPE html>
<html lang='en'>
<head>
  <meta charset='UTF-8'>
  <title></title>
</head>

<style>
  .hidden {
    display: none;
  }
</style>
<body>

  <button id="toggleBtn">Toggle Me</button>

  <div id="mainHeading" class="hidden">
    Hi there
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

<style>
  .hidden {
    display: none;
  }
</style>
<body>

  <button id="toggleBtn">Toggle Me</button>

  <div id="mainHeading" class="hidden">
    Hi there
  </div>

</body>

<script>
  const heading = document.getElementById('mainHeading');
  const btn = document.getElementById('toggleBtn');
  btn.addEventListener('click', (e) => {
    heading.classList.toggle('hidden');
  });
</script>
</html>
```
