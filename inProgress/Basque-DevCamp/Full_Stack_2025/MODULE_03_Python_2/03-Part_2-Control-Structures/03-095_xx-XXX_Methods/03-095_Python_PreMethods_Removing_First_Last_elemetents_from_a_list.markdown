# Module 03 - 095: Python - Exercise: Removing First and Last elements from a list



In this Python programming exercise, we are going to see how we can remove the first and the last elements from the list.

****

Now, what I want to see happen with this is I'm going to type out some comments so we can see exactly how this should work.  

 So, I want to build out a function and we'll call it `remove_first_and_last` you can call yours whatever you'd like.   

Then, it's also going to have a list to clean past into it.   

And so inside of here or I'm not going to build it out yet, that's all in the solution.   


But what I want to have happen is when you pass in some kind of a list so say that I have some HTML elements and so I'll have some strings inside of here one could be an h1 and then after that would be some content followed by a closing h1 tag and that would be a list.

Let me shrink this just to make it easier to see on one line.   

So, this would be an example of the list.   

If I were to call remove first and last pass in the HTML the output that I would be looking for here would be simply some content.   

So I just would want to have some content and that's all I would want returned because I want to have this first element and this last element removed.

![large](./03-095_IMG1.png)

Now, that by itself is not that hard because you could essentially just build something that went and grabbed the second element in the array, but let's imagine that we extend this a little bit.   

So, if I come down here and now we have we'll call it html_2 and so we have html_2.   


Now we have some content but we also have more content here.   

What I would want if I called html_2 is someone content and then more and just to make it very clear what should get returned here is a list.   

So let me just do that just so it's not confusing.   

You're not returning a string, **the goal of this should be to return some type of list and that should be what gets returned whether it's one item, two items, or a thousand items.**

So, if someone were to pass a thousand and a few items into your function then it should have the exact same behavior where it drops offthe first and the last element.   

And, if you're curious on how this could be beneficial, this is something that I have to build out quite a bit or at least some variation of this whenever I'm performing any kind of task such as building out a web scraper or anything like that any time where I know beyond a shadow of a doubt that I'm going to be getting at least 3 elements back or 3 elements are going to be inside of a list and the first and the last elements are just kind of throwaway elements.  

 Then, this is something that can be quite helpful so I recommend if you're going through this that you pause the video right now, and you try to build this out on your own and then come back and watch my own solution to it.

![large](./03-095_IMG2.png)

****

## Attempt 1

```python
# ATTEMPT 1

# a simple solution, case "<xx>" then remove
# This removes tags if specified manually into while

html_2 = ['<h1>', 'Some Content', 'more content', '</h1>']

tags = ['<h1>', '</h1', '<h2>', '</h2>', '<h3>', '</h3>', '<h4>', '</h4>', '<h5>', '</h5>', '<h6>', '</h6>']

def cleaning(html_2):

    iter = 0
     
    while '<h1>' in html_2 and '</h1>'  in html_2:
        html_2.remove('<h1>')
        html_2.remove('</h1>')
    for each in html_2:
        iter += 1
        print(f'Scrapped Content #{iter} : {each}')    

cleaning(html_2)
```

## Attempt 2

```python
# ATTEMTP 2
# This

html_3 = ['<h1>', 'Some Content', 'more content', '</h1>', '<h3>', 'Another subheading', '</h3>']

tags = ['<h1>', '</h1>', '<h2>', '</h2>', '<h3>', '</h3>', '<h4>', '</h4>', '<h5>', '</h5>', '<h6>', '</h6>']

def maxi_cleaner(html_scrapped):
    counter = 0

    html_scrapped = [ element for element in html_scrapped if element not in tags ]
    
    for each in html_scrapped:
        counter +=1
        print(f'Extracted Content #{counter} :', each )


maxi_cleaner(html_3)
```

## Attempt 3

```python
# ATTEMPT 3, improving the RegExps

html_4 = [
    '<h1>', 'Some Content', 'more content', '</h1>', 
    '<h3>', 'Another subheading', '</h3>',
    '<h4>', 'More content', '</h4>',
    '<h6>', 'And much more', 'Even much more', '</h4>'
    ]

def maxi_cleaner_regexp(html_scrapped_2):
   
    counter = 0

    tags = [f'<h{heading}>' for heading in range(1,7)] + [f'</h{heading}>' for heading in range(1,7)]

    html_scrapped_2 = [ element for element in html_scrapped_2 if element not in tags ]
    
    for each in html_scrapped_2:
        counter +=1
        print(f'Attempt # content extracted:  #{counter} :', each )


maxi_cleaner_regexp(html_4)
```

****

## Resolving the exercise



If you did that great job and now I'm going to walk you through what 
my own solution for this would be. I'm gonna copy this line because this
 is exactly the start of the definition that I want to use. So I'm gonna
 say def remove first and last.

```python
def remove_first_and_last(list_to_clean):
```



Now inside of here there really is not a lot of work we have to do in order to make this possible.

If you follow along and you follow my **JavaScript** or **Ruby** programming exercises, then what you may have seen, because I've built this out in those languages as well, is that there were a few other kinds of syntax options in those languages.  

But I really like the way that **Python** does this and, in fact, Python has probably the **best way of doing this**, because you have the ability to **glob** the elements in the list.  

---

## What is "globbing"?

If you do not know what **globbing** is, what it allows you to do, I'll come down here and write it in a comment.  

Imagine that you have some kind of list, for example:

```python
list = [1, 2, 3]
```

You have the ability, because you can perform tasks such as **destructuring**, to grab these elements like this:

```python
one, two, three = [1, 2, 3]
```

What you would get is:

- `one = 1`
- `two = 2`
- `three = 3`

But now, **if you had more than these elements**, let's say:

```python
[1, 2, 3, 4, 5]
```

What you can do is **use an asterisk (`*`) in front of the second variable**, and what's going to happen is **it is going to glob everything in the middle**.  

So, in this case:

```python
one, *two, three = [1, 2, 3, 4, 5]
```

- `one` is still going to grab the very first element (`1`).
- `three` is going to grab the very last element (`5`).
- `two` is going to **store everything in between as a list** (`[2, 3, 4]`).

We can test this out in the **REPL** just in case you don't believe me.

Let's say **Python**, and I'm going to do exactly what we just did. So say:

```python
one, two, three = [1, 2, 3]
```

Now:

- `one` is equal to `1`
- `two` is equal to `2`
- `three` is equal to `3`

Now if we want to extend this a little bit, we can say:

```python
one, *two, three = [1, 2, 3, 45, 6]
```

- `one` is still equal to `1`
- `three` should be equal to `6`
- `two` is now equal to `[2, 3, 45]`

So because of that, we can build our solution with this code.

![IMG](./03-095_IMG3.png)

---

Now I'm going to **clear the terminal** and switch back to the code, and we can keep this up here in the comments just so you can have them for the show notes.  

Now I'm going to use **destructuring**. A common convention inside Python whenever you're assigning a variable that you are **not going to use**, is to assign it to an **underscore (`_`)**.  

So I'm not going to use the **first** or the **last** elements, so I'm going to say:

```python
_, *content, _ = list_to_clean
return content
```

Notice that when I am returning `content`, I'm **not putting an asterisk there**. That is only necessary when you are performing the **destructuring** and **globbing** that.

Now that we have that, let's test this out with some of our **test cases** up here. So I'm going to grab this **HTML list** and the remove statement, and let's also **print it out**:

```python
print(first_and_last)
```

Save this and now let's run it:

```sh
python remove_first_and_last.py
```

And that worked! You can see that we have **some content** right there, which is exactly what we're looking for. So this **successfully removed the first and last elements**.

****

# ATTEMPT 4 once read the guide:

```python
# ATTEMPT 4: using globs

html_content = ['<h1>', 'Content', 'More Content', '</h1>']

def remove_first_and_last(html_content):
    _, *content, _ = html_content
    counter = 0
    for each in content:
        print(f'\nExtracted content #{counter} : ', each)
        counter += 1

remove_first_and_last(html_content)
```

---

![IMG](./03-095_IMG4.png)

Now we can also test it out with our **second test case** right here. If I come down and get rid of our first one and now let's just **print this out**. If I run it again, you can see it returned `'Some content'` and then `'more'`, so it is **globbing up all of the elements inside the list** besides the first one and the last one, which get dropped.

![IMG](./03-095_IMG5.png)



So out of all the languages that I've built out this specific code exercise for, **Python really has one of the cleanest syntaxes for it**, because of **destructuring** and because you're able to **glob up these elements**. It's a really nice and easy way to read how this works.  

And also, within **one line**, you can see how quickly you're able to grab those elements and then you can use that **content** however you want.  

Now, **if you're looking for a way to have even a little bit more of a challenge**, I would suggest implementing a **conditional** inside this function that **checks** to make sure that the list you pass in **contains at least three or more elements**.

Imagine a scenario where you try to perform this type of **structuring** and you had **only one element** or **nothing at all**. What should you do? You should **raise some type of error**.

You should say that you need to put in at least **three different elements** inside of whatever list you're passing in, or else you get an error.  

If you're building out some type of **Python module** that had this kind of behavior in it, it would be very helpful to **provide clear error messages** whenever someone is using it improperly.  

So, if you're looking for a way to **extend this exercise** and **learn a little bit more about it**, then I think that would be a nice way of adding to it.  

****

## SOlution

```python
# SOLUTION

def remove_first_and_last(list_to_clean):
  _, *content, _ = list_to_clean
  return content


html = ['<h1>', 'My content', '</h1>']

print('\nSolution: ', remove_first_and_last(html))

other_content_to_clean = ['', 'My content', 'Something else', '/']

print('\nSolution: ', remove_first_and_last(other_content_to_clean))

more_content = ['garbage', 'a','b','c','d','e', 'garbage']
print(remove_first_and_last(more_content))

```

## Resources

- [Exercise Code](https://github.com/jordanhudgens/python-exercises/blob/master/data-structures/remove_first_and_last.py)
