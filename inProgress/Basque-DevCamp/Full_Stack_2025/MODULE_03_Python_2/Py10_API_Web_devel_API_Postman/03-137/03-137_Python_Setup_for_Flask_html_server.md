# Module 03 - 137: Python - Flask (1)

## Environment Setup for Hello World Flask Application

---

## Video lesson Speech

Welcome to this course on API development in Flask, where we're going to
 learn how we can leverage the Python programming language in order to 
create server-side APIs

****

So this is going to be very fun and also, 
hopefully, it's going to give you a good idea on the architecture that 
you're going to use whenever you're building out API clients, and if you
 are coming at this from a front-end perspective.

So if you spend quite a bit of your time building out applications 
such as React apps, or Angular, or Vue applications, then typically 
you're going to be working with some type of backend API and so 
throughout these few sections we're going to build out multiple projects
 and you're going to see exactly how the back end side of that works.

Now, this very first project is going to be very basic and the whole 
goal of this is to give you a base case scenario and get you familiar 
with some of the commands and the basic flow of building out an API 
application.

One thing I will say is that if you are a fan of the Python 
programming language I think you're really going to like working with 
Flask because Flask is very close to writing pure Python, it simply 
gives you some additional tools layered on top of Python so that you can
 have APIs.

So that's where we're going to walk through in this first section. 
And in this guide specifically, we're just going to see how we can build
 out our basic environment. So this is going to be pretty common across 
all of the projects. This is a good reference point for you.

Now a couple of requirements that I want you to have before going through this is make sure that you have `pipenv` installed on in your environment. So the Pip environment tool that we 
walked through before and then make sure that you also have the Postman 
client.

Postman is going to allow us to test out our APIs. And then lastly 
make sure that you have some type of text editor. Now I personally am 
going to be using VIM throughout all of these guides but you can use 
Visual Studio code you can use Sublime Text, or Atom. It's completely up
 to you. That will not change how everything works.

So let's get started. The very first thing that I do is I'm going to create a directory for our project so I'm going to call it `hello-flask` and then I'm going to change into it. Now I want to create a development environment inside of it so I'm going to say `pipenv --three` so this is going to create a pip file and it's going to allow us to start adding our own dependencies.

We're going to start off just by adding Flask, so now by type `ls` you can see that we have a pip file there and if you're working with a 
text editor such as visual studio code or sublime text right now would 
be a good time to open up that project.

Now, I'm going to go through it using VIM throughout the rest of the 
course. So now that we have that let's install Flask. So I'm going to 
say `pipenv install flask` and this is going to go into our 
Pip file it's going to add Flask as a dependency and then it's going to 
go up to the PI shop and it's going to go and bring it down into our 
system.

We can test this out by now looking at the pip file and you can see now around line 14 you should now have Flask

![large](./03-137_IMG1.png)

You can also see that we're working with Python 3.6. That's the basic
 setup that you're going to want to use. And now we're going to create 
an app file so if you're following along in some other text editor 
simply right click on the left-hand side and create a file called `app.py` and now let's add just a few lines of code.

```python
# app.py

from flask import flask
app = Flask(__name__)
```

Now we're going to create our first route so a route, as you may be 
familiar with, is simply an endpoint that we can go into our application
 with, and the way that routes are created in Flask is they use a tool 
that is called a decorator and so a decorator in computer science terms 
is code that you can wrap around methods or classes.

So in this case, the way that Python uses decorators is it starts with an `@` symbol and so let's build this out.

```python
# app.py

from flask import Flask
app = Flask(__name__)
@app.route('/')
def hello():
 return "Hey Flask"
if __name__ == '__main__':
 app.run(debug=True)
```

And that is it. Let's save this file and then we're going to walk 
through it in a second after we confirm that it is all working. So let's
 start up a shell session. `pipenv shell` So this is going to get Python going with the version of 3.6 that we need it to be.

And now to test out our application, simply run `python app.py`.
 So notice that this is exactly the same process is if you had built out
 a basic terminal type of program in Python. And as long as you don't 
get any error messages, it means everything should be working.

![large](./03-137_IMG2.png)

And now we can test this out. So if you notice if you look at this 
debug log it says that it's running on this URL. Now, this URL `http://127.0.0.1:5000/` This is the same as saying localhost so I can say `localhost:5000` and that is going to take us where we want to be.

So I can go to a localhost:5000 and you can see that it says 'Hey Flask'.

![large](./03-137_IMG3.png)

So if you have gone through all of that and you're seeing 'Hey Flask'
 that means that you have built your first Flask API application. So 
great job if you did that we still are going to be adding quite a bit 
too, so don't worry it's going to get much more complex even for our 
basic example but just know if you are at this point right now that 
means everything's working you haven't run into any errors and you have a
 basic Flask setup.

So this is the server and so the server's running. In order to end it
 you can see that you have the code to end it, so if you press `CTRL+C` that will end the server session.

That ended it and if I go back to the browser now and I try to run 
localhost 5000 now we simply get an error which is what we'd expect 
because a server is no longer running.

So great job if you went through that you now have built out your 
very first Flask application and as we go through this particular 
project we're going to start building out a full-scale type of JSON 
based API.

## Source Code

- [Code at this stage](https://github.com/bottega-code-school/hello-flask/tree/008b0fc18a7d41c3be946a51d3c5d215cb72f11b)

`https://docs.pipenv.org/ Guide on installing pipenv`
