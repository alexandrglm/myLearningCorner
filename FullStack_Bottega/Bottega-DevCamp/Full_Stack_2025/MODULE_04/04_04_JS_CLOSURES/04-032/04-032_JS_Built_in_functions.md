## MODULE 04 - 032: JavaScript

## Built-in Functions - DOM Manipulation and Beyond

---

1. DOM Access Methods  
2. Content Manipulation  
3. Browser Interaction  
4. Utility Functions  
5. Practical Applications  

****

JavaScript provides numerous **built-in functions** that enable interaction with web pages, browser features, and data manipulation.   

These functions are available globally or through specific objects like `document` and `window`, forming the foundation for dynamic web applications.

****

## 1. DOM Access Methods

### Selecting Elements

Core methods for accessing DOM elements:

```js
// Single element selectors

document.getElementById('header');
document.querySelector('.main-content');


// Multiple element selectors

document.getElementsByClassName('menu-item');
document.querySelectorAll('p.highlight');
```

**Differences:**

- `getElementById`: Fastest, returns single element  
- `querySelector`: Flexible CSS selector syntax  
- `getElementsBy*`: Live HTMLCollections  
- `querySelectorAll`: Static NodeLists  

### Traversal Methods

Navigating DOM relationships:

```js
const element = document.querySelector('.start');

element.parentNode;
element.children;
element.nextElementSibling;
element.previousElementSibling;
```

****

## 2. Content Manipulation

### Modifying Content

Essential content manipulation methods:

```js
// HTML content

element.innerHTML = '<strong>New</strong> content';
element.outerHTML = '<div class="updated"></div>';



// Text content (safer against XSS)

element.textContent = 'Plain text only';



// Attribute manipulation

element.setAttribute('data-id', '123');
element.getAttribute('data-id');
element.removeAttribute('disabled');
```

### Style Manipulation

Dynamic style changes:

```js
// Best practice: toggle classes instead

// 1st. Defined the styles
element.style.color = 'blue';
element.style.backgroundColor = '#f0f0f0';
element.style.marginTop = '20px';

// 2nd. Then, configured their appareance as needed
element.classList.add('active');
element.classList.remove('inactive');
element.classList.toggle('visible');
```

****

## 3. Browser Interaction

### Window Methods

Global browser functions:

```js
// Navigation
window.open('https://example.com');
window.location.href = '/new-page';

// Timing
setTimeout(() => console.log('Delayed'), 1000);
setInterval(updateClock, 60000);

// Dialogs
alert('Important message');

const confirmed = confirm('Proceed?');
const name = prompt('Your name?');
```

### Console Methods

Debugging utilities:

```js
console.log('Information');

console.warn('Warning');

console.error('Error');

console.table(dataArray);

console.groupCollapsed('Details');

console.time('Process');
```

****

## 4. Utility Functions

### String Manipulation

Common string methods:

```js
const str = 'Hello World';

str.toUpperCase();

str.toLowerCase();

str.includes('World');

str.replace('Hello', 'Hi');

str.split(' ');

str.substring(0, 5);
```

### Array Methods

Essential array operations:

```js
const arr = [1, 2, 3];

arr.push(4);

arr.pop();

arr.map(x => x * 2);

arr.filter(x => x > 1);

arr.reduce((sum, x) => sum + x, 0);

arr.find(x => x > 1);
```

### Math Utilities

Common math operations:

```js
Math.random(); // 0-1

Math.floor(3.7); // 3

Math.ceil(3.2); // 4

Math.round(3.5); // 4

Math.max(1, 3, 2); // 3

Math.min(1, 3, 2); // 1
```

****

## 5. Practical Applications

### Form Handling

Dynamic form interactions:

```js
const form = document.querySelector('form');

form.addEventListener('submit', (e) => {

    e.preventDefault();

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);
    
    console.log(data);
});
```

### Dynamic Content Loading

AJAX pattern with fetch:

```js
async function loadContent(url, targetElement) {

    try {
        const response = await fetch(url);
        const html = await response.text();
        document.querySelector(targetElement).innerHTML = html;
      
    } catch (error) {
            console.error('Failed to load:', error);
  }
}
```

### UI Component Management

Building reusable components:

```js
function createModal(content) {

    const modal = document.createElement('div');

    modal.className = 'modal';

    modal.innerHTML = `
    <div class="modal-content">
      <span class="close">×</span>
      ${content}
    </div>`;

  document.body.appendChild(modal);

    return modal;
}
```

## More Code Examples

DOM manipulation:

```js
// Change all paragraph colors

document.querySelectorAll('p').forEach(p => {
    
    p.style.color = 'blue';

});
```

Form validation:

```js
function validateEmail(email) {

    return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);

}
```

Dynamic element creation:

```js
function addListItem(text) {

    const ul = document.getElementById('list');

    const li = document.createElement('li');

    li.textContent = text;

    ul.appendChild(li);
}
```

## Resources

- [MDN: Document Object Model](https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model)  
- [JavaScript.info: Document](https://javascript.info/document)  
- [W3Schools: JavaScript HTML DOM](https://www.w3schools.com/js/js_htmldom.asp)  

****

****

## Video Lesson Speech

This guide walks through how to leverage built-in JavaScript functions to alter content on a website.

****

Since we're talking about Javascript functions I thought it would be fun to take a little bit of a break and talk about some of the built-in functions provided in the javascript language. And since javascript renders inside of the browser many of the functions that it provides also work with your browser itself. 

I have a page open on devcamp just where people can ask questions and if I come here and click on inspect this actually gives me the ability to come and check out all of the code on here. Now obviously this is only going to give access to the front end codes such as the `HTML` and `CSS` the server-side code is on the back end and you can see that. However, because javascript does allow us to have all of these cool functions we can actually play around with some things here. 

Now some of the things we're going to talk about here make sense more when you get into things like, building angular based apps or react based apps but hopefully can help give you a little bit of foundational knowledge and also help you understand how you can use javascript in the browser. This also comes in very handy when you're wanting to perform tasks such as rendering or dynamically rendering content on the page. And that's something that you'd get into more with things like `Jquery` and frameworks like that but it's still fun to learn what's happening behind the scenes. 

The first thing we're going to do is inside of elements here, I can click on body and it's going to show me all of the body inside of it so I can keep on traversing here. And as you notice it highlights different components on the page and it keeps on isolating it down more and more. Now if I click on inspect and actually click on something such as raise your hand right here what this is going to do is show me the exact set of code that I'm looking for. So what I'm looking to do is to write a little script that from the console from the javascript console will allow me to change the text on the page. Now this will not change it permanently. Only something that happens on the server-side can change it permanently. But this is something that you can do on the fly in your own applications and using the console is a great way for testing those kinds of scripts out.

So right here we can see a number of things we can see that this is in an `H2` tag and that has a class of `b1`. And that's something very important because we need to be able to tell our javascript script exactly what to look for. So I'm going to open up the console here and I'm going to start this out. I'm not going to go into great detail on some of the underlying technologies of the framework here. In other words, there is a whole concept of what's called the `document object model` which is pretty extensive and probably could have an entire course written just about that.

And that is how a page is able to be queried and how you're able to dissect certain portions of that page. So some of these things I will give more of a high-level overview on.

The first thing you say is document. Now if I just say that you can see that this gives an object that gives an object of document in this pulls all of the code in. So when we call document what we're telling javascript is I want to have access to all of the code everything that we just saw in elements I want access to that. So that's but we want more than that we want to filter down more than that. So the function that we're going to call, this is a built-in javascript function is called `getElements` we could grab it by ID but this specific element I'm looking for didn't have an ID, did have a class name though. So I'm going to call `getElementsByClassName` and here I want if you remember the class name was a `b1`. 

Now if I run this, you can see it pulls in the `h2, b1` which is exactly right here where it says Raise your hand. If I open this up you'll see this is an object. This gives us a number of attributes so it has a link, in other words, if there were multiple classes named `b1` then it would have pulled up all of those classes, and then we could have picked which one that we wanted to work with.

Now inside of this zero with, remember this starts counting at zero. So when it says 0 this essentially just means the only item found, if we would have had multiple `b1` classes all over the page. It would have said zero, one, two, three and it would have isolated that. If I click on that, now we can see all kinds of attributes and it's associated with a key-value pair kind of set up so we could call class name we could call a client top we could check to see if it's drag-able and all kinds of different things. We also have access here, this is important. This is our `innerHTML` this is what we're actually going to be using to change the content. So this is saying this is the text that is in the system and I want the ability in our case to change that. And there's definitely all kinds of other things you can check out and look into. But for right now the most important one is that in `innerHTML` by I definitely recommend for you to play around some of the other ones, so you can kind of see what's available. 

Now that we have that, we're going to use a notation called the `bracket notation` to grab that first one. I'm going to say bracket zero which is going to bring me just that very first one, which is the only one on this page. And as you can see that brought it right here. So now we have our class and b1 with Raise your hand.

Now we still have one other thing I want to do which is to actually change the text. So I can say .innerHTML and it all has to be capsulize for HTML. 

```javascript
document.getElementsByClassName('b1')[0].innerHTML = 'Hi there';
```

And now I'm going to change this to say hi there and now watch what happens to our h2 tag up here. If I hit return it got changed to hi there. So that's something that is pretty fun. It's very helpful when we're building programs that need to change their content on the fly. Imagine a scenario where you have a welcome screen and you want to put in the user's name or you want to put it in right after they've typed it in. You can have a script that takes the value that they typed in and then using tools like this where you find an ID or a class and then you can have it and set the HTML or set the text value of that to something else just dynamically on the fly. 

Another spot where this comes in very handy is building scripts for automating processes. I use that quite a bit, where I will build some type of script. For example, I had to build a script to invite about 700 students to a website called C9 one time. And with that, it would have taken a very long time to invite those users one by one. So instead what I did, is I took all of the users and stored them inside of a variable, and then I created a loop and that loop went over a script kind of like this but instead of just setting an H1 or something.

It filled in the username, the password, it filled in all those things, and it even pressed the button and then it waited for a few seconds for it to load again and then it went and did the same thing over and over and over again for all seven hundred and it made it much faster and much more efficient to invite users instead of doing it manually. So there are all kinds of things that these built-in functions allow. 

This is not a course on working with the document object model. We cover those kinds of topics in other courses. This is more on pure programming and Javascript. But I wanted to show you what's possible and show you some of the functions that are available inside javascript because there most likely will be a time when you will want to use those.

```javascript
document.getElementsByClassName('b1')[0].innerHTML = 'Hi there';
```

## Resources

- [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_d_97_built_in_functions.js)

****

## Coding Exercise

Grab the below paragraph tag by its class name and change the inner HTML of the tag to `Wizards don't jump they float`.

```html
<p class="grabThis">The five boxing wizards jump quickly</p>
```

```js
let paragraphElement = //Write your code here!
```
