# MODULE 07-189:    UML Project 1
## Project 1:   Twitter
---

---
## Video Lesson Speech

# Twitter Project Instructions - Systems Analysis and Design

## Project Overview

Hi, and welcome to Project One, where we are going to build and design Twitter.

Now, I wanna make a very quick point 'cause you will hear me say design quite a bit throughout this course. Especially because it's a systems analysis and design course.

But when I say design, I do not mean building the user interface that is a completely different course, that is when you are building the way that the users are gonna interact with that at a very high level and a user interface, kind of perspective.

When I say design I'm talking about how the system is architected and as a developer, when you're working in an office and someone comes up and they say they want you to design this system. Most likely they're gonna be talking about what were doing.

## Project Approach

So what we are going to be doing in Project One, with designing and building Twitter, is we are gonna take a two pronged approach to it.

If you remember back to the UML course remember that UML diagrams are broken into two categories, they are structural and behavioral.

### Part 1: Structural Design - Class Diagram

Now for the structural class or the diagram we are gonna be doing is the class diagram and remember the class diagrams are the go to diagram for structural designs. They are the types of diagrams that can pretty much be taken and translated directly into code.

They are how you can configure your system to set up your database associations it list out all your attributes it lists out all your method names, everything like that.

So that's gonna be the first one, we're going to build the entire class diagram for Twitter now that's gonna be pretty comprehensive in order to complete this project.

#### Required Classes

You will need to build:
- a user class
- a tweet class
- a retweet class
- a preference class
- a security class
- a message class
- a hashtag class
- a reply class
- a like class
- a location class
- a image class
- and then you're also gonna have to create a class for users to follow other users

#### Class Requirements

And so the part that you need to do with this is when you build this diagram, each one of those classes is going to represent its own database table and it's gonna be its own entity.

You have to list inside of there, each one of the attributes inside of that class. I am not gonna tell you which ones to use, you can go back and look at Twitter to see what they used. They do not have to be identical, you simply have to go and build it in the way that you personally think is best.

As far as operations go, those are those type of actions, remember those are method names so it might be a posted tweet or show a tweet or get all tweets. There's all kind of different method names that you could use.

#### Grading Philosophy

Now I am not going to, and your instructor is not gonna grade you on how everyone's solutions's gonna look like mine or the instructors. That is not the point of this project and it's not the point of any of these projects, each one of these is going to be flexible, you do have to build classes and go with the full list that I just gave you, but there is flexibility inside of those in regards to the attribute names, and the method names and how all of those work.

#### Design Mindset

What I want you to do is to put yourself in the mindset, like you are back in time, and you were the developer that they tasked with building Twitter. And I want you to design the entire system that way.

So I want you to pick out all of those class names and add the attributes that you think make the most sense, and then most importantly, I want you to set up those relationships, so a user can have many tweets.

Remember that implementing multiplicity, you need to be able to show how that association works. Each one of these classes is gonna be connected in some way or another, to another class. Not one of these is a stand alone entity, so that's a very important concept to keep in mind, so that's the first one. That's the structural diagram.

### Part 2: Behavioral Design - Use Case Diagram

The next one is gonna be the behavioral. And for that, I want you to build a use case diagram, remember that use cases are very high level, and they're a great way of visualizing the types of authorizations that users have.

#### Actors and Requirements

Now for Twitter the different requirements I want you build the use case diagram are gonna be for a user and a follower. Those are gonna be the two actors that are gonna be integrated for this diagram.

#### Actions

We gonna have as far as actions go, we gonna have the ability to post tweets, retweets, likes, and messages and then feel free to put any other kinds of optional types of features in there, like the ability to post a message, or see a message or the ability to post an image.

I wanna leave that up to your own creativity, and also with the way that you personally think that it should be built out.

## Conclusion

So now that you know the requirements, good luck on the project.
