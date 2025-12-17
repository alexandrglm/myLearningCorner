# Module 04-012: JavaScript - Strings (1)

## Working with String Functions - Part 1

***

1. String Length Property
2. Character Access Methods
3. String Concatenation
4. Search Methods
5. Prefix/Suffix Checks

***

## String Length Property

The `.length` property returns the number of characters in a string:

```js
// Lenght
// Remember, ENGTH DOESN'T USE PARENTHESIS 

let str = 'The Quick Fox Jumped Over The Lazy Dog'

str.length  // '44', including spaces
```

* **Not a function**(no parentheses needed)
* Counts all whitespace characters
* Useful for validation (e.g., tweet length limits)

***

## Character Access Methods - `.charAt(index)`

Returns the character at a specific position (zero-indexed):

```js
// Character Access Methods 
// .charAt( index )  - Index is ZeroBased

let str = 'The Quick Fox Jumped Over The Lazy Dog'

str.charAt(2)       // 'e'
str.charAt(12)      // 'x'
str.charAt(200)     // ' ' (Empty, out of bound)
```

Important Behaviors:

* Returns empty string for invalid indexes (no error)
* First character index is 0 (not 1)
* Spaces are counted as valid characters

***

## String Concatenation- `.concat()`

Combines strings without modifying the original:

```js
// String Concatenation
// .concat()

let str = 'The Quick Fox Jumped Over The Lazy Dog'

str,concat(' again')     // ' again' is appended

str;    // 'The Quick Fox Jumped Over The Lazy Dog again'

let newString = str.concat(' and again.')

newString;  // 'The Quick Fox Jumped Over The Lazy Dog again and again.'
```

***

## Search Methods - `.includes()`

Checks for substring existence:

```js
// Search methods
// .includes()

let str = 'Hello World';

str.includes('Hello');  // True
str.includes('Orange'); // False
```

### startsWith() / endsWith()

Position-specific checks:

```js
str.startsWith('The'); // true (case-sensitive)

str.endsWith('dog'); // true 

str.endsWith('g'); // true (single character)

str.startsWith('quick'); // false (not at start)
```

***

## Practical Applications

1. **Input Validation**

```js
function validateUsername(name) {

    return name.length >= 3 && name.length <= 20;
}
```

2. **Searchs and Filtering**

```js
function filterMessages(messages, term) {
    return messages.filter(msg => 
        msg.includes(term));
}
```

3. **File Processing**

```js
function isImageFile(filename) {

    return filename.endsWith('.jpg') || filename.endsWith('.jpeg');

}
```

***

## Remember

1. **Immutability**: String methods return new values rather than modifying originals
2. **Case Sensitivity**: All searches are case-sensitive (`'the' !== 'The'`)
3. **Whitespace Matters**: Spaces are valid characters in all operations
4. **Zero Indexing**: First character is at position 0

***

## Resources

* [String - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String)
* https://javascript.info/string
* [JavaScript String Methods](https://www.w3schools.com/js/js_string_methods.asp)

***

## Video lesson Speech

This part 1 guide walks through how to call functions on strings in\
order to perform tasks such as searching for values, finding a\
character's index, and much more.

***

This is going to be a little bit of a longer guide. It's because we're going to go through a number of functions related to the string data type inside a javascript. Before we go into those let me give kind of a high-level overview of what a function is because if you've never done any programming before it may be a little bit of a new concept.

Essentially a function allows you to encapsulate behavior. In this case, we're not the ones actually creating the functions, these are provided in the core javascript library, so we can simply call them. Later on, we're going to go through how we can create our own functions. But this should give you a nice little introduction because, essentially, what we're going to be able to do is to have an object and then be able to either change it or make certain kinds of value queries on it-all kinds of things.

That would take a lot of code to do if we had to write it all by hand. And the other nice thing that functions allow us to do is to perform a task again and again without having to repeat any code. That's a high-level view of what functions are. Now we're going to get into how we can use them on the string class. We'll start off by creating a variable called `str`. I'm going to set it equal to a string. We are going to say "The quick brown fox jumped over the lazy dog."

```javascript
var str = 'The quick brown fox jumped over the lazy dog';
```

If you've ever heard that sentence before, there's a reason why it's a pretty popular one. That's because it contains every letter in the alphabet, at least one time. So it's a popular one to use for programs and also for things like font libraries this is a popular sentence you'll see. That's a little bit of a side note, just in case you've ever wondered where that kind of sentence comes from.

The first thing I'm going to do is not actually going to be a function. The first thing I'm going to do is to call what is going to be an attribute of the string. This is going to be string length. If you just add a semicolon at the end you'll see that this has forty-four characters.

```javascript
str.length;   //44
```

Now the reason why I know this is an attribute and not a function is because if I tried to put parentheses at the end, which is what you would do if this was a function, call and hit return you will get an error. It even tells you that `.length` is not a function. That's not something that is critically important to know right now, but all of the rest of the functions I'm going to go through all have the parenthesis at the very end. I wanted to clarify why the length didn't. Running `str.length` is something you'll be doing quite a bit. It's something where you're able to check to see exactly how long a string you're working with is.

Imagine a scenario where you were rebuilding a site like Twitter. You want it to check to make sure that a certain string doesn't go over a character limit, just the same way that Twitter does it. Using string length is a quick and efficient way of doing that.

The rest are all going to be functions. It's going to follow the pattern of having parens at the very end. Sometimes we will also pass an argument to it.

The first one we're going to go with is called a `charAt` which is short for character. If I do `string.charAt` and pass in `2`, then hit return. This brings `"e"`.

```javascript
str.charAt(2);       //"e"
```

This is going to require a little bit of explanation. If you have never worked with an index before. What we essentially did here, with this string calling `charAt` and passing this `2` in, means that we want whatever letter is there, whatever element is there, we want whatever one is at the index of two.

That seems pretty straightforward until you go up to our sentence, and you count. One is t, h is two, and e is three. But we asked for two and it returned the E. While there is a good explanation for that and that is that in computer science most of the time all of your indexes start with what's called a `zero-index` which means that the very first element is not going to be an index of one. It's an index of 0. So the next one's going to be one and the one after that is going to be two.

That's the reason why we received `"e"` back when we said character at 2 because technically this has an index of 2. It may not be the second element but from a computer science perspective that is the index of two. Now that is something that is very important to remember because not only is that going to be important when you're grabbing a character like this but this is exactly the way that when we get to work with the array data structure arrays start with a zero index as well.

If you go and you are off by one value, then this is quite possibly the reason why. You have to make sure you're always starting at zero. So that is character at, and I'm not going to spend that long with every single one of these items, it's because that was a very important topic because it relates to pretty much all kinds of counting algorithms and things like that in computer science.

The next one is still going to be `charAt` but let's see what happens if I pass in an index that is way past any existing index. I sometimes like including these because many times it's important to know because you want to have some confidence. If you call an index it doesn't exist, are you going to get an error? Or what's going to happen? Well, if I hit return you can see this simply returns an empty string. So this is good but it can also be confusing at times as well.

Sometimes I almost kind of wish that it returned null or threw some type of an error, the thing that can be confusing about this, is let's say that I did

```javascript
str.charAt(3);     //" "
```

You can see that this may not be an empty string, it's technically a space, but it's pretty close to when we passed something that had nothing at all in there. That is something just to keep in mind if you're ever having to implement some type of coding exercise, or some program, where you may end up in a situation that you're calling an index that may not exist you will be getting an empty string back in that case. It's important to understand that it doesn't mean that it found something it just means that nothing was returned at that index value.

The next one is called `concat`. And this is short for concatenate. If I do

```javascript
str.concat(' again and again');
```

Now you can see that it has combined what we passed as the argument to concat into and appended it to the end of our string where it's now the quick brown fox jumped over the lazy dog again and again. Now a great question to ask right now would be: have we permanently changed the value of the string? There's a pretty quick way to find that out. Just type in `str;` and you can see that it is back to the same value of when we assigned it. That's a very important thing to know right there because if you run concat thinking that you're changing the string, you really aren't, you're simply changing the value that got returned from running that `concat` function on it.

If you wanted to permanently connect those two then you would want to do something like

```javascript
var newStr = str.concat(' again and again');
```

And that puts that in a new string, your new string now contains those values. But the preexisting string doesn't, so that is a very important thing and that is the case for every one of these string functions that we're going to cover. That was Concat.

Now let's go into some matches. This is going to give us the ability to see if any values are included in the string. This is something that's very common to do. Say you're working with a string and you want to see if it contains this other value I'm looking for.

If I run `str.includes();` and pass in quick. This is going to simply return true.

```javascript
str.includes('quick');   // true
```

It goes through our string, and it found quick right there, and it said, yes, it does include that. Now if I were to run `str.includes();` again and pass in foo, which does not exist, it returns false. So includes is a very nice and straight forward type of function where you pass in whatever you're looking for. If it includes that value, it returns true. If not, it returns false.

![large](../../../../../../.gitbook/assets/04-012_IMG1.png)

Now there are some more customized ways of doing this. We have included, but we also have a function called `startsWith`. `startsWith` is very similar except instead of looking through the whole string. It just looks at the very front. If I pass in "the" it returns true because it starts with that. If I pass in quick it returns false because even though that's in the string it doesn't start the string out.

![large](../../../../../../.gitbook/assets/04-012_IMG2.png)

Now, this has kind of a contrapositive here which is `endsWith`. We have `startsWith` and `endsWith`. When it's quick, it's going to be false. If it is dog it's going to be true, which you probably already figured out. But what if it's just "g" that's also true. It doesn't check for words it checks just character by character. If I were to say `str.endsWith('lazy dog');` it is also true.

That's an important thing, because if you're just looking at it, you're looking at all these words, you may think "Oh, it's looking for the last word and I need to have the last word to put it in there". But you may just be looking through some raw data files and you want to find out which ones end in a semi-colon, or anything like that. This is a nice quick way of doing that. I recommend you to go through these again. Play with them, see how you can change them to manipulate the text.

```javascript
var str = 'The quick brown fox jumped over the lazy dog';

str.length(); // VM2349:1 Uncaught TypeError: str.length is not a function

str.length; // 44

str.charAt(2); // "e"

str.charAt(200); // ""

str.concat(' again and again'); // "The quick brown fox jumped over the lazy dog again and again"

str; // "The quick brown fox jumped over the lazy dog"

str.includes('quick'); // true

str.endsWith('dog'); // true

str.startsWith('Foo'); // false
```

## Resources

* [Source code](https://github.com/rails-camp/javascript-programming/blob/master/section_b_13_string_functions.js)

***

## Coding Exercise

Call these two functions on the provided string and have them return true. The two functions are endsWith and startsWith.

```js
string = "Hello, what happened to all the pie?";
```
