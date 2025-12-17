# 03-142\_Python\_Flask-6\_GET\_API\_SINGLE-Record\_request

## MODULE 03 - 142: Python - Flask (6)

### Implementing a Single Record GET Request in a Flask API

***

## Notice:

As we are using VSCode instead of Repl, and ultimately, we are breaking down the original "hello-flask" project into the Python 14 - API section, many modifications have to be donde.

Therefore, it’s essential to complete each app.py according to the corresponding Python-Course NumFolder.

This GET a single data guide will use: ' app\_112.py' .

#### ALSO, QUERY() method HAS BEEN DEPRECATED FROM NEWER SQLAlchemy Versions, so, there is a Code Update:

To replace Repl with VSCode, you can run the following commands in the terminal:   &#x20;

```bash
(pipenv) $: python
>>> from app_112 import db, app

>>> with app.app_context():
    db.create_all()
```

Alternatively, you can create a runner script, such as `run.py`:

```
# runner

from app_112 import db, app

with app.app_context():
    db.create_all()
```

Then, you can load it by pressing **F5** to start debugging in VSCode.

So, the setup steps will be:

1. Run `run.py`.
2. Run `app.py`.
3. Perform actions in the Postman app.

#### ALSO, QUERY() method HAS BEEN DEPRECATED FROM NEWER SQLAlchemy Versions, so, there is a Code Update:

```python
# QUERY METHOD HAS BEEN DEPRECATED
# @app.route("/guide/<id>", methods=["GET"])
# def get_guide(id):
    # guide = Guide.query.get(id)
    # return guide_schema.jsonify(guide)

# # from app_111
# ## GET endpoint
@app.route('/guide/<id>', methods=['GET'])
def get_guide(id):

    session = Session(db.engine)
    guide = session.get(Guide, id)
    return guide_schema.jsonify(guide)
```

### Video lesson Speech

A few guides ago, I mentioned how the goal of this application was to\
create the full set of CRUD options for a very basic learning management\
system. So so far we've created the ability to save a guide to the\
database via API request. And then we also created an endpoint for\
seeing all of the guides on the system. Now I think the most natural\
next guide or next endpoint to create is what is called the show route\
or the show endpoint where you are querying for a single guide.

***

So in `app.py` let's start the endpoint like we have in the past.

**app.py**

```python
# QUERY METHOD HAS BEEN DEPRECATED
# @app.route("/guide/<id>", methods=["GET"])
# def get_guide(id):
    # guide = Guide.query.get(id)
    # return guide_schema.jsonify(guide)

# # from app_111
# ## GET endpoint
@app.route('/guide/<id>', methods=['GET'])
def get_guide(id):

    session = Session(db.engine)
    guide = session.get(Guide, id)
    return guide_schema.jsonify(guide)
```

So this is not going to bring us back a collection. It's going to bring back a single item. Now the route is going to look a little bit different because I have to specify the guide, but we'll set up the method to get the id for us.

And let's talk about this for a second because this is very different than what we've done so far. We created a decorator but the magic that's going to make this happen is our route and method. So right where I am calling angle brackets ID, what that tells Flask is to have a lookout for anything and any route where it starts with guide then it has an angle bracket.

So if it finds that endpoint, like when we call this with Postman, or imagine that you're building a React or Vue application and you're calling this, you would call the route `/guide/id`. Then from there because we have access to that decorator this is where in get guide we pass that ID in. So we're able to access that and this decorator is going to know what the ID is because it's getting past in here and then it's automatically going to send it to the guide function.

Now from there I'm simply creating a new variable called 'guide' and calling the Guide model by running a query `GET` and then it gets the ID, and then goes to look up in the database for whatever we paste in and then from there it's going to look up that schema. Then it's going to convert that to JSON, and then we're passing the guide.

So let's save this and let's see if it's working. So run `python app.py` that looks so far so good. No typos or anything. And now if I open up Postman, and go up to the top, this is going to be a little bit different syntax it's going to be `localhost:5000/guide/1`, while still using a GET request. So now if I clicked send, you can see that return 'some content' and then 'my first guide.'

![large](../../../../../../../.gitbook/assets/03-142_IMG2.png)

So that's working. If I type in '2' that this is going to bring back the second guide which is perfect. Now if I ask for 200 then it's just going to bring me back an empty object. And this is very important to understand this does not bring in air. So if you're building an application and you don't get or you pass in an invalid ID you're not going to get an error you're simply going to get an empty object.

That's the way that SQLalchemy works by default is if you ask for an ID that doesn't exist it just returns an empty object it does not give you an error or say that it does not exist so that something important to keep in mind.

Let's review very quickly what we did. As you can see it's one of our shortest functions here but is doing something very different than the others so I definitely recommend that you become familiar with this because any time that you're going to have to have your system perform dynamic lookups then this is the type of syntax that you're going to want to get used to.

So I want you to know that these angle brackets mean that Flask is going to look inside of these routes and it's going to look for these single brackets and then it's going to make that available to the function. So nice job if you went through that you now know how to perform a get request for a single record in Flask.

### Source Code

* [Code at this stage](https://github.com/bottega-code-school/hello-flask/tree/c81019b8d330bc67040186cc2c888d307b052b21)
