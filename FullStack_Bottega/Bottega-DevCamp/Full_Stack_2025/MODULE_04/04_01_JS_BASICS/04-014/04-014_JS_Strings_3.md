# 04-014\_JS\_Strings\_3

## Module 04-013: JavaScript - Strings (3)

### Working with String Functions - Part 3

***

## Module 04-013: JavaScript Strings (Part 3)

### Contents

1. String Slicing
2. Trimming Whitespace
3. Case Conversion
4. Method Chaining
5. Practical Applications

***

### String Slicing

#### - `.slice()`

Extracts portions of strings with flexible indexing:

```js
// Slicing content - .slice()

let text = 'The quick brown fox';

text.slice(4, 9);       // 'quick'
text.slice(10);         // 'brown fox' (10th to the end)

// Backward slice
text.slice(-8);         // 'own fox' (The latest 8 chars)
text.slice(-8, -4);     // 'own'
```

* **Non Zero-Based**
* Negative indexes count from end
* End index is exclusive
* Returns new string (original unchanged)

***

### Whitespace Management - `.trim()`

Removes whitespace from both ends:

```js
// Whitespaces - .trim()

let str2 = ' Hello World   ';

str2.trim();        // 'Hello World' with no whitespaces
str2.trimStart();   // 'Hello World   ' Trimmed at the beginning
str2.trimEnd();   // '  Hello World' Trimmed at the end
```

Related Methods:

* `trimStart()` - Only beginning whitespace
* `trimEnd()` - Only trailing whitespace
* Handles spaces, tabs, newlines

***

### Case Conversion - `.toUpperCase()` / `.toLowerCase()`

Uniform case formatting:

```js
// Case Conversions - .toUpperCase() / .toLowerCase()

let words = 'hEllO WoRld'

words.toUpperCase()     // 'HELLO WORLD'

words.toULowerCase()     // 'hello world'
```

Use Cases:

* Case-insensitive comparisons
* Normalizing user input
* Formatting display text

***

### Method Chaining

Combine multiple string operations:

```js
// Methods Chaining

let phrase = '   The QUICK bRoWn FOX';

phrase.trimStart().toLowerCase().slice(4,15)        // 'quick brown
```

Best Practices:

* Limit to 2-3 chained methods
* Add comments for complex chains
* Consider intermediate variables for clarity

***

### Practical Applications

1. **Data Cleaning Pipeline**

```js
function cleanInput(input) {

return input.trim().toLowerCase().replace(/\s+/g, ' ');
}
```

2. **Username Generation**

```js
function generateUsername(fullName) {

    return fullName
        .trim()
        .toLowerCase()
        .replace(/\s/g, '.');
}
```

3. **Excerpt Generation**

```js
function createExcerpt(text, maxLength) {

    return text
        .trim()
        .slice(0, maxLength)
        .concat('...');
}
```

***

### Remember

1. **Slice Flexibility**
   * Use negative indexes for end-relative positions
   * Omitting end index slices to end of string
2. **Immutability Principle**
   * All methods return new strings
   * Original remains unchanged
3. **Performance Considerations**
   * Chain operations left-to-right efficiently
   * Trim early in processing pipelines
4. **Internationalization**
   *   For locale-aware case conversion, use:

       ```js
       'ß'.toLocaleUpperCase('de-DE');         // "SS"
       ```

***

### Resources

* [MDN: String. **See Statics/Prototypes/ Methods**](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String)
* [Slice, Trim, Usage examples](https://es.javascript.info/string#obteniendo-un-substring)
* [Unicode Technical Standard #21 (Case Mapping)](https://www.unicode.org/L2/L1999/99190.htm)

***

### Video lesson speech

This is the final guide in the String function module. In this lesson\
we'll walk through the slice, case, and trim functions. We'll also\
examine how we can chain functions together.

***

Welcome back to this third and final video on how to work with string functions in javascript. This one should also be a little bit shorter we just have a few items that I wanted to cover.

The first one is the `slice` function so I'm going to type string or str because that's the name of my variable dot slice. Now we have a few different options. So we have three ways that we can use slice, the very first way is to just pass an index value and what it will do is it will return all of the items to the right of that.

```javascript
str.slice(10);
"brown fox jumped over the lazy dog"
```

So let's just do

```javascript
str.charAt(10);
"b"
```

to see where that's at. That is the b, so it grabs the b all the way to the end. That is a nice and easy way if you know that you have some values that you want to skip over and you don't care about them and you just want from that point all the way the end. `Slice` with just one value will give you that. And it's that index value.

Now the other way we could do this is we could actually go backwards. So say that we have a giant string and we don't want to count all the way from left to right. And also another time where that comes in very handy is say we have a set of strings. So it could be a social security number or something like that. And we know that we're always going to get say the last four or five digits. Those are always going to be exactly the same. And we only want those.

Well, we can work from right to left by using negatives. So here I'm going to say negative 8 and run this.

```javascript
str.slice(-8);
"lazy dog"
```

You can see that returns the lazy dog. So far those are two different options one of them gives you all of the items and you're counting from left to right. If you use negatives you're counting backwards. But at the end of the day, you're essentially still finding an index and it's returning everything from that index all the way to the right. Even if you're counting from left to right or right to left.

The last option is to actually grab a slice inside of the string. So let's say that I only wanted the word quick here and I knew that this was an index 4 through 10. The way that I could do this is actually passing two arguments. So I could do `str.slice` and if I want quick I can do four because counting from left to right this is 0 1 2 3 4. And then if I want 10 let's count 0 1 2 3 4 5 6 7 8 9 10. So if I run this you can see it returns quick and it has the little space after it.

```javascript
str.slice(4, 10);
"quick "
```

Now we can refine that a little bit and we can say four to nine, run that. And it's quick just by itself.

```javascript
str.slice(4, 9);
"quick"
```

Now, this also brings up something that is a little bit handy.

The next function I want to talk about is the `trim` method. So say that I have a new variable I'm going to call it messy string and this has a bunch of empty space in between. It has this foo value and then to the left has all these spaces and then to the right, it has all these spaces.

```javascript
var messyString = '    foo     ';
undefined
```

If I call messyString you can see that it keeps all those spaces.

```javascript
messyString;
"    foo    "
```

But if I call messyString and then call `trim` on it, this `trim` function is going to return `"foo"`. So trim is a very helpful function. You will find it is incredibly beneficial when you're wanting to clean up user data because there are all kinds of times where I'll be given a database or a raw file and it has strings left and right and trim makes it very nice and easy to clean those. So that's helpful.

Now let's see how we can actually combine some of these functions. Now remember with string when I called slice on it and past 4 thru 10 remember how that brings, quick with the extra space at the end? Well, I can actually chain these together so if I say trim and run this.

```javascript
str.slice(4, 10).trim();
"quick"
```

Notice how this has now cleaned it up even though we're still passing four and ten.

One of the most important things I wanted to show you right there, is that these functions can be chained together. And as you go further on your javascript development journey you are going to discover that you're going to be changing methods left and right now you have to be very careful about that. There are many times where people kind of get out of hand with this and it becomes very confusing and very difficult to debug.

There are some recommended principles that say you don't really want to ever have more than two to three different items that are chained together. Anything above that it can lead to some very challenging bugs to get fixed and it's also very hard to refactor that code and clean it up. But there are going to be times where you want to do things just like this, where we `slice` something and then we called `trim` to make sure that we had some nice clean values afterwards. So that is the `slice` and then the `trim` function.

We just have two more that we're going to cover.

The first is going to be `toUpperCase` so when you call this it's going to do exactly what you thought. It's going to convert all of the values to uppercase.

```javascript
str.toUpperCase();
"THE QUICK BROWN FOX JUMPED OVER THE LAZY DOG"
```

Now we also have an option of doing `toLowerCase` running that you can see it's all lower case.

```javascript
str.toLowerCase();
"the quick brown fox jumped over the lazy dog"
```

Originally if you reference the very top line we only had one item that was uppercase and so that one got taken down to the lower case and all the other ones simply remain the same.

In the last three videos, we've covered all of the main functions related to the string data types. Very nice job going through that. I'm also going to include in this guide a link to the documentation that shows all of the remaining functions.

Now I didn't include every single one because that would have taken even longer and we spent quite a bit of time and I want to start moving on to other things like the number data type but also some of the ones I left out were related to things such as converting to a specific international locale to do things like that. And I know that doesn't apply to everybody. So you feel free to reference the documentation. And as always I will put a link to the source code and then also the actual code that we just went through in the written guide.

```javascript
str.slice(4, 10); // "quick "

str.slice(-8); // "lazy dog"

str.slice(10); // "brown fox jumped over the lazy dog"

str.toUpperCase(); // "THE QUICK BROWN FOX JUMPED OVER THE LAZY DOG"

str.toLowerCase(); // "the quick brown fox jumped over the lazy dog"

var messyString = '    Hi there    ';

messyString.trim(); // "Hi there"
```

### Resources

* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_b_13_string_functions.js)
* [Full list of String functions](https://www.w3schools.com/jsref/jsref_obj_string.asp)

***

### Coding Exercise

Fill in the return statement below with some of the string function syntax you just learned!

```js
//We have given you the sentences already, please fill in the return statement to satisfy the requirement
// EXAMPLE "return (str.toUpperCase());"

function strings() {

    // Use slice to return a substring starting from the "w" through the end of the sentence
    var str = "The five boxing wizards jump quickly";
    return (  <--Delete-this-and-write-your-string-function-->  );

}

strings();
```
