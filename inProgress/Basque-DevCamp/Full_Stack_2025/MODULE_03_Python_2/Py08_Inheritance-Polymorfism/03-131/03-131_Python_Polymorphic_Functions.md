# MODULE 03 - 131: Python - Polymorphic Functions

---

## Video lesson Speech

In the last guide, we walk through how we could leverage polymorphism in
 a python program to generate HTML. And that is going to be a common way
 that you implement inheritance and polymorphism.

****

But Python also gives us another option, so 
right here we were able to create an abstract class and then have a few 
classes that inherited from it. But if you do not want to follow this 
type of pattern we also have another way of doing this and we're going 
to leverage functions in order to make it possible.

So I'm going to start off by just rearranging things a little bit. 
I'm going to get rid of this abstract class at the top and then I'm 
going to instead copy this init function into both of our classes. We're
 going to have a heading class and a div class and these are going to be
 standalone classes. So, in this case, we are not going to have them 
inherit from anything and they're simply going to be their own classes.

And then we're going to get rid of all this boilerplate for the 
abstract class. So here we have a heading, it takes in content and then 
we have a div that takes in content and I'm also going to keep the 
render functions here the same.

Now the next step is instead of creating this set of tags instead 
what I'm going to do is I'm just going to show you a little bit of a 
different approach. We could keep this but I want to show you that it's 
possible to do it in a different way. Now what I'm going to do is I'm 
going to store these each in their own variables. So let me move these 
over to the left and here I'll say div_one and then here I'll say 
heading and then here I'll say div_two.

Now what I'm going to do is I'm going to create a function and this 
is going to be where the polymorphism occurs. So I'm going to create a 
function here called html_render. And it is going to take a tag object 
and so this tag object is going to be a div it's going to be a heading 
or another div it's going to be anything that has a render function 
that's going to be the only requirement.

And so now what I can do is I can say print and I also could return 
but for right now to make it easier I'm just going to say 
print(tag_object.render()). So I'm calling the render function and that 
is it. So now all I have to do to get this behavior is I can say 
html_render(div_one) and then we can also do this with div_two and the 
heading. So I'll say div_two and the heading. And now if I come and I 
run this code it looks like I've got a little bit of an error.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Object+Oriented+Programming+(OOP)+in+Python/Building+Polymorphic+Functions+in+Python+%23+1606/image11.png)

It says tuple object has no attribute of render. 0h and it's because 
if you notice the little error message where it says tuple you may have 
noticed we didn't create a tuple but if you're member that if you place a
 comma at the end of anything like this python is going to assume you're
 creating a tuple out of it, so that was the reason why it gave that 
error.

Let me save this and let's run it one more time. And there you go, it is working perfectly.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Object+Oriented+Programming+(OOP)+in+Python/Building+Polymorphic+Functions+in+Python+%23+1606/image12.png)

So we were able to create the exact same behavior that we had before 
but instead of having an abstract class we were able to create this HTML
 render function and so this is very different from an implementation 
side even though the behavior is identical.

And so the very first question that you may be asking yourself is 
when to use one over the other? And what my rule of thumb would be is if
 you have quite a bit of shared behavior so if your HTML class had say a
 half dozen functions inside of it, that each one of the inherited 
classes like a div or heading would need then that would be one time 
where you'd want to use inheritance.

If on the other hand you don't really have a lot of shared behavior 
but you simply want to be able to call the same function just like we 
have right here where you want to make sure that each one of these 
classes has a render function that you can call it then being able to 
use polymorphism with a function-based approach is a great way of doing 
it. As you see we were actually able to cut out a decent amount of 
boilerplate code and were still able to replicate the exact same 
behavior.

And so this is something that you will see quite a bit and it's 
whenever you want the ability to treat objects in a very similar manner.
 Notice how our html_render function didn't have to know what kind of a 
class that it was dealing with. It didn't care if it was working with a 
div or a heading or anything like that. If we had 20 other kinds of 
classes that each had a render function that is all that mattered. We 
could have called this htmo_render function on any of those and all it 
needed to know was that it was going to be passed an object and that 
object was going to be able to have render called on it.

****

## Code

```python
class Heading:
 def __init__(self, content):
 self.content = content
 def render(self):
 return f'<h1>{self.content}</h1>'

class Div:
 def __init__(self, content):
 self.content = content
 def render(self):
 return f'<div>{self.content}</div>'

div_one = Div('Some content')
heading = Heading('My Amazing Heading')
div_two = Div('Another div')

def html_render(tag_object):
 print(tag_object.render())
html_render(div_one)
html_render(div_two)
html_render(heading)
```
