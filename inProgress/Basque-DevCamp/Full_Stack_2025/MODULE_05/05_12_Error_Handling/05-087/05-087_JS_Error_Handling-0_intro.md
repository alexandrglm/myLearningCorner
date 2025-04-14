# MODULE 05 - 087:   JS Error Handling

## Error Handling (0) - Intro

---

---

## Video Lesson Speech

This section of the course is going to be all about error management in 
JavaScript and we're going to take a very modern approach to being able 
to work with error

****

Now the very first thing if you're new to development especially that you may be thinking when it comes to error management is why we even have to worry about it? Can't we simply program our system so they won't have errors? And that is a fair question. 

However, errors do not simply mean there was a problem executing your code. You can technically build a program that is flawless and it can still run into errors. Now error management is very important in pretty much every major programming language. However, in JavaScript it is even more critical and it's part of the reason why I wanted to dedicate an entire module simply to analyzing how we can work with errors in the most efficient way possible. 

So why is learning how to work with errors so critical in JavaScript? Well, it comes down to the fact that most JavaScript applications are not standalone entities. So if you take another type of application such as a Ruby on Rails application that is a server-based system. So, in other words, there are many types of rails applications that do not have to really communicate with the outside world and so they can live on their own they're on the server. They can render in the browser and the only errors that should be occurring are errors within the application.

So managing those errors is important but it becomes even more critical with JavaScript applications and that comes right down to how the architecture is constructed for most JavaScript apps. 

Let's take an example so let's say that you build a react or angular application. That application is going to live on a server but it can be rendered in the browser. So you're going to have a server over here and this is where we'll just say with an R this is our react application. 

![large](./05-087_IMG1.png)

Now, this can be rendered right in the browser. So all of your content all your buttons forms everything like that, that's going to be rendered in the browser.

![large](./05-087_IMG2.png)

But now your react application typically is not going to live completely on its own. Usually, when you build a react or angular apps they need to have some type of back end. And so what that means is this is going to have to communicate with another server. So let's imagine that we create a python server over here and this python server has a database and it has an API server and this is doing all of the logic for the system. 

![large](./05-087_IMG3.png)

The react app is simply making calls to that system and it's getting data calls back. 

![large](./05-087_IMG4.png)

Now imagine a scenario where this python server runs into an error. So say that there was some issue and something occurred where this server either went down or it started getting very slow. Even if your react application this Javascript-based application even if it was coded perfectly. If it is connecting to a service or trying to connect to a service that throws an error back or that it can't reach you need to be able to accommodate for that.

So you need the ability to not just assume that every time that you communicate with the server that it's going to work. In fact, the best approach is to think of all the ways that that could fail. So check to see all of the ways because if your react app is communicating with multiple applications so another very common approach is you might have this javascript application here it's talking to a Python application to get its data back or rails API, that's how it manages its data. 

But then for managing logins you might have what's called an authentication server right here and if you can't reach the authentication server you can't do anything. 

![large](./05-087_IMG5.png)

And so you need to make sure that you are watching for any kinds of errors. Another common issue is you might be communicating with these servers and it may not be down it might just be slow. Your system will get an error back or it could get an error back and so you need to be able to constantly retry that type of communication. 

Now if a little bit of this is vague, do not worry if you've never worked with APIs or anything like that before that's perfectly fine. I simply am wanting to give you an idea on the importance of managing this kind of system properly and building in from the beginning the right types of error management. Imagine if you went to a site and you as a user typed in information and submitted it. Imagine that that was a react application that didn't have proper error handling the react app would let you type that information in and you'd hit submit and it would act like everything went through properly.

But in reality, if this API was down or if this API was down then your data would have just vanished and you wouldn't have even been told that there was an issue. Whereas if you can set up error management properly then when that user logs into the system they're going to immediately get a little error or a little warning message that says it looks like we're having some issues communicating with the server. Please try again later or something like that so that they are fully aware of exactly the status of the system so that they don't have any surprises.

So that is in a brief summary a way to understand why it's so important to integrate proper error management into all of our javascript applications.
