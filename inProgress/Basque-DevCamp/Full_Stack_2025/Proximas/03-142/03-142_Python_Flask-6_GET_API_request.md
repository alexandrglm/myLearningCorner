# MODULE 03 - 142: Python - Flask (6)

## Implementing a Single Record GET Request in a Flask API

---

## Video lesson Speech

A few guides ago, I mentioned how the goal of this application was to 
create the full set of CRUD options for a very basic learning management
 system. So so far we've created the ability to save a guide to the 
database via API request. And then we also created an endpoint for 
seeing all of the guides on the system. Now I think the most natural 
next guide or next endpoint to create is what is called the show route 
or the show endpoint where you are querying for a single guide.

****

So in `app.py` let's start the endpoint like we have in the past.

**app.py**

```python
# Endpoint for querying a single guide
@app.route("/guide/<id>", methods=["GET"])
def get_guide(id):
    guide = Guide.query.get(id)
    return guide_schema.jsonify(guide)
```

So this is not going to bring us back a collection. It's going to bring back a single item. Now the route is going to look a little bit different because I have to specify the guide, but we'll set up the method to get the id for us. 

And let's talk about this for a second because this is very different than what we've done so far. We created a decorator but the magic that's going to make this happen is our route and method. So right where I am calling angle brackets ID, what that tells Flask is to have a lookout for anything and any route where it starts with guide then it has an angle bracket. 

So if it finds that endpoint, like when we call this with Postman, or imagine that you're building a React or Vue application and you're calling this, you would call the route `/guide/id`. Then from there because we have access to that decorator this is where in get guide we pass that ID in. So we're able to access that and this decorator is going to know what the ID is because it's getting past in here and then it's automatically going to send it to the guide function.

Now from there I'm simply creating a new variable called 'guide' and calling the Guide model by running a query `GET` and then it gets the ID, and then goes to look up in the database for whatever we paste in and then from there it's going to look up that schema. Then it's going to convert that to JSON, and then we're passing the guide. 

So let's save this and let's see if it's working. So run `python app.py` that looks so far so good. No typos or anything. And now if I open up Postman, and go up to the top, this is going to be a little bit different syntax it's going to be `localhost:5000/guide/1`, while still using a GET request. So now if I clicked send, you can see that return 'some content' and then 'my first guide.' 

![large](https://s3-us-west-2.amazonaws.com/images-devcamp/Python+API+Development+With+Flask/Hello+Flask/Implementing+a+Single+Record+GET+Request+in+a+Flask+API+%23+1837/image11.png)

So that's working. If I type in '2' that this is going to bring back the second guide which is perfect. Now if I ask for 200 then it's just going to bring me back an empty object. And this is very important to understand this does not bring in air. So if you're building an application and you don't get or you pass in an invalid ID you're not going to get an error you're simply going to get an empty object. 

That's the way that SQLalchemy works by default is if you ask for an ID that doesn't exist it just returns an empty object it does not give you an error or say that it does not exist so that something important to keep in mind. 

Let's review very quickly what we did. As you can see it's one of our shortest functions here but is doing something very different than the others so I definitely recommend that you become familiar with this because any time that you're going to have to have your system perform dynamic lookups then this is the type of syntax that you're going to want to get used to. 

So I want you to know that these angle brackets mean that Flask is going to look inside of these routes and it's going to look for these single brackets and then it's going to make that available to the function. So nice job if you went through that you now know how to perform a get request for a single record in Flask.  

## Source Code

- [Code at this stage](https://github.com/bottega-code-school/hello-flask/tree/c81019b8d330bc67040186cc2c888d307b052b21)
