# MODULE 03 - 129: Python - Inheritance

****

## Video lesson Speech

One of the fundamental tenants of object-oriented programming in any 
language is the concept of inheritance. At a high level inheritance is 
the ability to create specialized versions of classes.

I think one of the best ways of understanding 
the way inheritance works if you've never used it before is with an 
example and so that's what we're going to walk through this guide. So 
I'm going to create a class of user and this is going to be a pretty 
standard user.

This is going to be an abstract user that simply has three 
attributes, so I'll say def double underscore init, pass in self, and 
then we're going to pass in an e-mail, first name, and then a last name.
 These are all standard attributes so you'd expect in a User class. From
 there you can create some instance attributes so we'll create one for 
email, one for first name, and then one for a last name and that's going
 to be all we really need to do for the attributes.

Now let's add some behavior and so we're going to go with a greeting 
so I'll say def greeting. It expects self as the only argument and then 
it's going to return a formatted string so format and say hi and pass in
 with string interpellation self.first_name and then self.last_name and 
that's all that we're going to need in this class.

def greeting(self):
    return f'Hi {self.first_name} {self.last_name}'

But imagine that you're building out a full web application and you 
need to have the concept of admin users so admin users are going to be a
 specific type of user. And whenever you're trying to decide if you want
 to use inheritance you can always ask yourself is this new element that
 I'm wanting to build into the program is it a type of one of the other 
classes that I have? And in this case, an admin user is definitely a 
type of user. Our user is our abstract high-level type of class, it's a 
blueprint that has elements such as email, first name, and last name, 
and then it has a function built into it. This function is something 
that should be globally available to all users.

But let's create an admin class, so I'm gonna say class admin user 
and the way that you declare that one type a class inherits from another
 is right here in the top line where you say class you give the name of 
the class and then you pass in using parentheses the element so whatever
 class you want it to inherit from. So I'm gonna say class admin user 
inherits from user.

class AdminUser(User):

And now I can create a custom function. So imagine that you want the 
admin users and admin users only to be able to know how many active 
users are on the site. I could say `def active_users` and it is going to just take in self and then for right now, we're just going to hard code a number in.

class AdminUser(User):
    def active_users(self):
        return '500'

so that is how you create a basic class and then how you create a 
class that inherits from that. So now let's test this out I'm going to 
create a few instances, one is going to be of an admin user the other 
one's going to be a regular user.

I'm gonna say Tiffany admin user and she's going to need to have the 
same elements and same attributes that are inside the User class so 
she's going to have to have [Tiffany@devcamp.com](mailto:Tiffany@devcamp.com) and then she's going to have to have a first name and then a last name 
just like how you'd expect. And then I'm going to create another user 
called Kristine who's just going to be a regular user. So this one will 
be [Kristine@devcamp.com](mailto:Kristine@devcamp.com) and she'll have a first name and a last name.

So now let's actually use these new instances. So if I want to call 
print and then Tiffany and I'm going to call the instance right here 
from here I can print out and have access to that active users method. 
So I'm going to hit save here and let's run this code you can see it 
prints out five hundred now.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Object+Oriented+Programming+(OOP)+in+Python/Introduction+to+Inheritance+in+Python+%23+1604/image11.png)

If I try to do the same thing with Kristine so if I have the user 
Kristine and I try to allow her to access that active users method I'm 
going to get an error. And it says AttributeError User object has no 
attribute active user.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Object+Oriented+Programming+(OOP)+in+Python/Introduction+to+Inheritance+in+Python+%23+1604/image12.png)

So this is it doing exactly what we want. We've created a specialized
 class that has all of the attributes and all the behavior of the parent
 class. So Tiffany when we created it, it needed an email, a first name,
 and a last name. Now also if I come down here and I call the greeting 
function. So if I say greeting here for Tiffany even though Tiffany is 
an admin user and there is no greeting function inside of this class. If
 I run this again you'll see that it prints out the full greeting.

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Advanced+Python+Programming/Object+Oriented+Programming+(OOP)+in+Python/Introduction+to+Inheritance+in+Python+%23+1604/image13.png)

So it says Hi Tiffany Hudgens, and the reason why this is possible is
 because of inheritance. Whenever we use inheritance the way it works is
 that the child classes like AdminUser these specialized classes have 
access to all of the same attributes and behavior as the parent class. 
And then you can simply add on any specialized attributes or behavior 
into that child class the way we did right here with the admin user.

So in review, that is the basic introduction to how to work with inheritance in Python.

****

## Code

```python
class User:
 def __init__(self, email, first_name, last_name):
 self.email = email
 self.first_name = first_name
 self.last_name = last_name
 def greeting(self):
 return f'Hi {self.first_name} {self.last_name}'

class AdminUser(User):
 def active_users(self):
 return '500'

tiffany = AdminUser('tiffany@devcamp.com', 'Tiffany', 'Hudgens')
kristine = User('kristine@devcamp.com', 'Kristine', 'Hudgens')
print(tiffany.active_users())
print(tiffany.greeting())
print(kristine.active_users())
```
