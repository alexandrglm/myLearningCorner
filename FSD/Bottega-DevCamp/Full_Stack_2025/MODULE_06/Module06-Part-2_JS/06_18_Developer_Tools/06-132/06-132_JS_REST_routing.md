# Module 06 - 132: Dev Tools

## REST routing

---

# Understanding RESTful Routing: A Practical Guide

1. The Philosophy Behind REST

2. Core HTTP Methods and Their Meaning

3. REST in Action: Twitter Example

4. Benefits of RESTful Design

5. Implementing REST in Frameworks

---

## 1.    The Philosophy Behind REST

REST (Representational State Transfer) follows **Occam's Razor** - the simplest solution is often the best. 

Key principles:

- **Statelessness**: Each request contains all necessary information (no server-side session storage).

- **Uniform Interface**: Standardized HTTP methods (GET, POST, etc.) for predictable interactions.

- **Resource-Based**: Everything is a resource (users, tweets, products) accessible via URLs.

---

## 2.    Core HTTP Methods and Their Meaning

| HTTP Method | Action              | Real-World Analog             |
| ----------- | ------------------- | ----------------------------- |
| `GET`       | Retrieve data       | Loading a Twitter feed        |
| `POST`      | Create new data     | Composing a new tweet         |
| `PUT`       | Replace entire data | Editing a tweet's content     |
| `PATCH`     | Modify partial data | Updating a tweet's like count |
| `DELETE`    | Remove data         | Deleting a tweet              |

---

## 3.    REST in Action: Twitter Example

### Endpoint Structure

```rest
GET /tweets          # List all tweets  
POST /tweets         # Create a new tweet  
GET /tweets/:id      # Show a specific tweet  
PUT /tweets/:id      # Replace a tweet  
PATCH /tweets/:id    # Update part of a tweet  
DELETE /tweets/:id   # Remove a tweet
```

### Why This Matters

- **Consistency**: Every developer understands `/tweets` handles tweet operations.

- **Predictability**: No guessing if `deleteTweet` or `remove_post` is the correct endpoint.

---

## 4.    Benefits of RESTful Design

1. **Standardization**
   
   - Pre-REST: Every app had unique routes like `/getUsers.php` or `/update_post_ajax.cgi`.
   
   - Post-REST: Uniform `/users` and `/posts` across applications.
   
   

2. **Framework Integration**  
   Major frameworks (Rails, Django, Express) build REST conventions directly into their routing systems.



3. **API-Friendly**
   
   - Perfect for web/mobile apps consuming JSON/XML.
   
   - Clear separation between frontend and backend.

---

## 5.    Implementing REST in Frameworks

### Ruby on Rails Example:

```ruby
# routes.rb

resources :projects # Auto-generates all RESTful routes

# projects_controller.rb

def index
 @projects = Project.all # GET /projects
end

def create
 Project.create!(project_params) # POST /projects
end
```



### JavaScript (Express.js):

```js
// Express routes
router.get('/tasks', (req, res) => { /* GET logic */ }); 
router.post('/tasks', (req, res) => { /* POST logic */ });
```



---

## Tips - Best Practices

- **Idempotency**: `PUT` should be repeatable without side effects (e.g., updating a tweet twice doesn't change it further).

- **Nesting**: For related resources, use routes like `/users/:userId/tweets`.

- **Versioning**: Prefix APIs with `/v1/` for future compatibility.

## Common Pitfalls

- **Over-POSTing**: Using `POST` for actions that should be `PUT`/`DELETE`.

- **Ignoring Status Codes**: Return proper HTTP codes (200 OK, 404 Not Found).

----

## References

- https://ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm

- 



---

## Video Lesson Speech

In scientific research, there is principle called Occam’s razor. The 
term states that the simplest solution is usually the best one. This 
concept is especially true when it comes to application routing. In this
 guide we’ll go through a RESTful routing tutorial, including a walk 
through of a real world application.

****

## What is RESTful Routing?

The goal of this guide is to give a dead simple explanation for what REST is. And more importantly, how you can use it as a developer.

![large](https://www.crondose.com/wp-content/uploads/2016/07/rest-1.jpg)

So what exactly is RESTful routing? REST stands for Representational State Transfer. The concept of REST was originally created by the computer scientist Roy Fielding for his dissertation at UC Irvine.

If that doesn’t make any sense, don’t worry. You don’t have to understand the intricacies of REST in order to use it.

## HTTP Protocol

Let’s begin with talking about the communication system that REST uses: the HTTP protocol. HTTP is what you use when you:

- Navigate on the Internet
- Submit forms
- Or even look at Yelp restaurant reviews on your phone

One of the issues with HTTP is that it is stateless. Which means that when you navigate from one page to another page, HTTP doesn’t retain any of the information between pages.

This means that developers need to implement code to let applications know how to act like they know what’s going on.

## Dead Simple REST Examples

Remember when I mentioned Occam’s razor at the beginning of the guide? That principle came to mind when I was researching this post because at its core RESTful routing is the definition of simplicity.

Essentially REST is a naming structure that encompasses every action that users and applications need to make.

## REST Terms

So what are the terms? Let’s go through them one by one and give a real-world example of how they’re used. After going through it you’ll see that everything you do on the web can be boiled down to five tasks. I’m going to use the example of using Twitter to illustrate what each term does.

```
Formal Term                          Action                     Practical Example
POST                                  Create                     Creating a new Tweet
GET                                          Read                             Seeing a single or multiple Tweets
PUT                                          Update/Replace     Replacing a Tweet
PATCH                                  Update/Modify     Editing a Tweet
DELETE                                  Delete                     Deleting a Tweet
```

If you think about each of those behaviors, you can derive every action that you or an API takes on the web.

## Why is REST Important?

So why exactly is REST important? It seems so straightforward that many developers forget what it was like before RESTful routing became popular. Years ago application routes were dictated by the developer. This may not seem like a big deal. Except that it meant that every application had a different naming structure for routes.

Having unique names for routes was not a scalable solution. Thankfully REST was created to bring a level of standardization to development. By leveraging RESTful routes you can immediately be familiar with how data will flow through an application.

The concept of REST was so helpful to the developer community that it was embraced by the most popular frameworks in the space. When it comes to modern application or API development you’ll discover that the REST architecture is the primary routing system utilized.

## RESTful Routing Tutorial

Let’s walk through what this looks like in a real-world application. Here is a basic Ruby on Rails application that has a single feature: managing tasks. This project is taken from my Learn Ruby on Rails from Scratch Course if you want to check it out.

![large](https://www.crondose.com/wp-content/uploads/2016/07/rest-2.png)

If you look at the routes you’ll see that the Rails framework provides for each of the RESTful routes we discussed.

![large](https://www.crondose.com/wp-content/uploads/2016/07/rest-3.png)

In the red box I designate all of the routes for the app’s Project feature. In the yellow box, I highlighted each of the RESTful verbs. Lastly, in blue, I show where each of the HTTP actions are mapped to.

For example, notice how the features that revolve around showing pages, such as index, new, edit, and show are all GET requests? This is because the server is looking up information in the application or database and GETTING resources to show the user.

This is different from the action such as POST that actually creates a new item in the database.

## Summary

I hope that this has been a helpful RESTful routing tutorial. And that you now feel more confident in understanding how you can use REST to build your own applications.
