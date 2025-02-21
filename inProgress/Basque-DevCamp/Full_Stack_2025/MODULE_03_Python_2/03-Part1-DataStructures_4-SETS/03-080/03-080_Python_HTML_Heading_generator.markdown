## **Module 03 - 080: Python - HTML Heading Generator**

## **Overview**

In this Python exercise, we'll build an **HTML heading generator function** using string interpolation. The goal is to dynamically generate HTML heading tags (`<h1>`, `<h2>`, etc.) based on function parameters.

This task will reinforce the use of **formatted strings (`f-strings`)** and how to structure Python functions effectively. Additionally, this is a practical exercise, as dynamically generating HTML is common in web development.

---

## **Understanding the Problem**

We need a function that allows us to generate HTML heading elements dynamically. The function should take two parameters:

- `title` → The text inside the heading.
- `heading_type` → The level of the heading (e.g., `1` for `<h1>`, `2` for `<h2>`, etc.).

### **Example Expected Behavior**

```python
print(heading_generator("Greeting", 1))
# Output: <h1>Greeting</h1>

print(heading_generator("Hi there", 3))
# Output: <h3>Hi there</h3>
```

We should be able to call the function with any heading type and text, and it should return a correctly formatted HTML string.

---

## **Building the Function**

### **Step 1: Define the Function**

We create a function `heading_generator()` that takes two parameters:

- `title`: The content inside the heading.
- `heading_type`: The heading level (e.g., 1, 2, 3, etc.).

### **Step 2: Use f-strings for Interpolation**

We use **formatted strings (f-strings)** to construct the final HTML heading element dynamically.

### **Step 3: Return the Formatted HTML String**

```python
def heading_generator(title: str, heading_type: int) -> str:
    """
    Generates an HTML heading tag dynamically.

    :param title: The text inside the heading.
    :param heading_type: The level of the heading (1-6).
    :return: A formatted HTML heading string.
    """
    return f'<h{heading_type}>{title}</h{heading_type}>'
```

---

## **Testing the Function**

### **Basic Usage**

```python
print(heading_generator("Welcome", 1))  # <h1>Welcome</h1>
print(heading_generator("Subheading Example", 2))  # <h2>Subheading Example</h2>
print(heading_generator("Another Heading", 3))  # <h3>Another Heading</h3>
```

### **Handling Edge Cases**

We should validate the function to ensure it handles errors gracefully.

#### **1. Invalid `heading_type` Values**

HTML only supports headings from `<h1>` to `<h6>`. If the user passes a value outside this range, we should raise an error or provide a default.

```python
def heading_generator(title: str, heading_type: int) -> str:
    if not (1 <= heading_type <= 6):
        raise ValueError("heading_type must be between 1 and 6")
    return f'<h{heading_type}>{title}</h{heading_type}>'

# Example Usage
print(heading_generator("Valid Heading", 3))
# print(heading_generator("Invalid Heading", 10))  # Raises ValueError
```

#### **2. Handling Non-String Titles**

If someone accidentally passes a non-string value (like an integer), we can enforce type conversion or raise an error.

```python
def heading_generator(title, heading_type):
    if not isinstance(title, str):
        raise TypeError("title must be a string")
    if not isinstance(heading_type, int) or not (1 <= heading_type <= 6):
        raise ValueError("heading_type must be an integer between 1 and 6")
    return f'<h{heading_type}>{title}</h{heading_type}>'

# Example
print(heading_generator("Safe Title", 2))  # Works fine
# print(heading_generator(123, 1))  # Raises TypeError
```

---

## **Summary**

✔ **Key Concepts Covered:**

- **Formatted Strings (`f-strings`)** for dynamic string creation.
- **Function Definition** and parameter handling.
- **Error Handling** to ensure valid inputs.
- **Practical Application** for web development scenarios.

### **Best Practices**

✅ Use `f-strings` for clean, readable formatting.
✅ Always validate input parameters (`heading_type` should be between 1-6).
✅ Raise meaningful errors for incorrect input types.
✅ Keep the function **simple, readable, and efficient**.

---

## **Resources**

📌 **Python Official Documentation:**

- [Formatted Strings (f-strings)](https://docs.python.org/3/tutorial/inputoutput.html#formatted-string-literals)
- [Functions](https://docs.python.org/3/tutorial/controlflow.html#defining-functions)





****

## Video lesson Speech

In this Python programming exercise, we're going to walk through how we 
can build out an HTML heading generator in python and I'm going to be using Python 3.6 for this, just in case you're following along with a different version.   

Your syntax is going to have to be slightly different because the entire point of this exercise is working with string interpolation.

****

What I want is the ability to create a function and I'll do a comment here just so we can see exactly what we're going to need to create.   

So, what I want to do is be able to have some kind of function so I can say this is my heading generator and it should be able to take in a title attribute or title argument and then a heading type and so an example way of calling this would be to say I want to have my heading generator.   

I'm going to pass in title of greeting and then the heading type is going to be 1 and so right here what the result of this should be is this should return an HTML heading 
element and it should be an H1 that says greeting and then has an ending h1 tag.

So, if you are familiar with HTML and front-end development, then, you should see this is a pretty standard kind of way of building out an H1 element.   

But what I'm talking about is being able to dynamically create one with a function.  

 So, now, if I call heading generator again and I say hi there for this one and then I pass a 3 instead.  

Then, what I should get is I should get an H3 that says Hi there and then has a closing H3 element.   

This is what should get returned right here because we passed those elements differently.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Python+Coding+Exercises/Strings/Build+an+HTML+Heading+Generator+Function+in+Python+%23+1685/image11.png)

So, this is something that is very helpful because it's good to be able to learn how string interpolation works inside of Python.   

Also, this is something that if you are working with any kind of web application then a very common thing you're going to need to do is be able to auto-generate HTML code and so this is a very nice and helpful way of being able to do that.   So, let's actually build this out and, if you're following along and you're wanting to actually work through this right now would be a good time to pause the video and try to build this out.   

I will say out of all the coding exercises I do this one is meant to be one of the more straightforward ones.

I don't mean to say this if this sounds hard I don't want that to sound demeaning or anything like that.   

If you struggle with it that's perfectly fine if you understand string interpolation you can do this. 

So, that's kind of my main point is to simply say that if you're building this out.   

Don't overthink it, you can do this in literally two lines of code and one of those lines is the function definition so you don't have to worry about building out say some giant class or anything like that.   

The goal of this is simply to show that you know how to work with string interpolation.   

I recommend that you pause the video now and try to build it out and then watch what my personal solution would be after that.  

So, if you're back I hope that you had a good time building that out, but now watch how I would build this if I were asked to do that.   

So I'm going to create a function here and just like you saw in the comments. 

I'm going to call that heading generator and it's going to take in a title and a heading type just like we already talked about.   

Now, inside of here, all I wanna do is I simply want to return that value we talked 
about so I'm gonna say I want to return a formatted string and I'm going  to start off by just saying h because remember what we want to do right here is we need this number to be dynamic and then we need the value inside of the tag to be dynamic and then we need the ending closing tag to be dynamic.

So, what that means is that it's fine for these first two items to be hardcoded because those are always going to be the same but then we need to be able to have our string interpolation here so I'm going to say heading type and then close off the curly braces and then close off that tag.

```python
def heading_generator(title, heading_type):
 return f'<h{heading_type}>'
```

So, if you're following along and this looks weird but if we just ended everything right now the way this would work is it would return a string of h1 if we called in h1 because we're taking that heading type and we're just sliding ant right inside.   

So, now, inside of here, we're going to pass in the title and so whatever title gets passed in is what's going to be interpolated there and then let's close it off.   

I'm going to use that closing tag as you can see in the comments say h and then in curly braces pass in our heading_type once again end the curly braces and the bracket and then end the string.

```python
def heading_generator(title, heading_type):
 return f'<h{heading_type}>{title}</h{heading_type}>'
```

Now, let me save this and let me also shrink this just a little bit so it's a little easier for you to see and so I don't want you to think that I put this on an extra line that simply the text editor because I was zoomed in.   

So there you go you can put this all on one line just like that and this is all the code that you're going to need.   

In fact, we can just copy the comments right up here.   

And let's run these so we have our heading generator.  

 I'm going to delete that and we do need to print this out if we can actually see the value of it so I'm going to print here and then print on this one.   

And so if everything works and I don't have any typos then we should have two heading tags.  

 One is an h1 and one is an h3 with the values that we passed into it.  

 So let me switch over here and let's run this code.   

So this is python and I'm calling this file the html_heading_generator.py if I hit enter and you can see that that works perfectly. We get two tags that are returned.

![large](./03-080_IMG1.png)

The first one is that h1 tag with greeting inside of it and the next one is Hi there and Hi there is inside of an h3 tag.   

So that is how you can leverage formatted strings and string interpolation in order to 
build an HTML Heading generator in Python.

****

## Code

```python

```

****

## Resources

- [Source Code Exercise Solution](https://gist.github.com/jordanhudgens/e6f641ae9b273ff47daf1a67db3c2156)
