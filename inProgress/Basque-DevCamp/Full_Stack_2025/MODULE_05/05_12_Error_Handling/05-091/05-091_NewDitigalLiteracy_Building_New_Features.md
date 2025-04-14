# 05-091:    Tips and Tricks to Building New Features as a Developer

****

This guide will focus on answering the question of 'How to develop a strategy for approaching project/feature development'.

****

I have a special treat for you today. One of my favorite parts of this show is interacting with viewers. And this guide will focus on answering a viewer question regarding strategies for approaching project development.

The following is a letter I received from Christian, a developer from Germany.

> I’m an avid viewer of CronDose and already learned a ton watching your videos. Thanks for your efforts! Starting web development a year ago, I’m currently building my first own commercial product (a classified ads site) using Rails.

> I really would like to hear your advice on how you approach building features on apps, as I have the following problems:

> – I can’t really plan a feature from start to end because I always think I’m missing something important
> – Procrastination and being afraid to make errors that will be costly to correct in the future

> How do you approach building features when you don’t know the scope exactly?

> What's your process, how do you get unstuck?

> Best regards,

> Christian

## Strategies for Approaching Project Development

In reading this letter, each of the questions revolves around having a strategy for approaching project development. And in this guide, I’m going to walk through an answer for each question.

## Planning a Feature from Start to End

Question one asks:

> “How do you approach building features when you don’t know the scope exactly?”

This is a great question. As helpful as it would be to have a clearly defined scope from the beginning of the project it rarely if ever happens. And even if you were given a perfectly crafted project scope it would most likely change during some stage of development. Which would essentially render the scope pointless anyways.

In the email you said you are building out a classified ads site, so we’ll use that as an example case study throughout this guide.

### Move from Requirements to Stories

One of the statements made was that you don’t feel comfortable planning features from start to end because you think you’re missing something. This is a common issue when you approach an application build based on a set of requirements.

You probably tried putting together a list of requirements, such as:

- A user should be able to register.
- Records can only be edited by the user that created the posting.
- Etc.

If you take this approach it’s natural to feel like you’re missing a feature, especially if you’re new to development.

Instead of using requirements, I’d recommend creating user stories. I’ll give you one from a classified’s app I built last year.

> A user logs into the application. From there she sees buttons for creating new posts or editing ones that she has created before. She only sees posts that she personally created and she can’t access this page without logging into the app. In addition to seeing her posts, she can click on a post to review all of the responses from users to that post.

Notice how much more practical this is than simply listing off requirements? Your app should have dozens of users' stories that contain all of the initial functionality that you want to build.

### Start with a Base Case

Now that your app has a nice set of user stories, how detailed should they be? Honestly, I would recommend you keep the functionality as basic as possible. When I’m building applications I don’t even include all of the parameters that I know I’ll need later on.

When it comes to approaching project development I take a base case strategy. This means that I drill down a feature to its most basic component. Getting back to your classified ad app, let’s say it has a story such as:

> When a user is on the page to create a new listing she can add a title, a description, and up to 5 pictures. From there she can click save to create the post, which redirects her to the post show page.

If you try to build that entire feature it would be very intimidating. So my approach would be to first simply create a form page. From there I would only add in the ability to create a post with a title. The description can be added easily in the future. Therefore I don’t see any point in wasting time on it in the beginning. I would completely ignore the picture uploading functionality in the beginning since that will required using tools such as nested attributes.

So after a user has the ability to create a post with a title I can circle back and add each of the other components one at a time. Taking this approach makes the entire process less intimidating.

### Fear of the Unknown

In the email, you mention being afraid that you’re afraid of missing something important. This fear of the unknown is completely natural and let me say: you will be missing something important. Creating user stories should help to catch the critical items. However, I promise there will always be components that initially fall through the cracks. However, don’t let that scare you off, you can add new features in later on.

From my personal experience, I remember one time where I was building an enterprise application and completely forgot to give managers the ability to view posts they were supposed to approve! However, after I realized that I left out a key feature I was able to add it in and the client was happy.

So don’t let the fear of missing a key feature stop you from building. Remember the initial Facebook developer strategy:

> Move fast and break things.

After becoming a public company Facebook has moved away from approaching project development in this way slightly. However, when it comes to building applications it’s still a strategy that I embrace. And I’ve discovered that it leads to getting more done. Additionally moving fast and breaking things will also help remedy your second problem…

### Battling Procrastination

I greatly appreciate your candor (which was a huge reason why I decided to give you a 1,500-word response instead of pointing you to some other resources). In the email, you admit to struggling with procrastination. And I’m glad that you did because procrastination is something that every developer I’ve ever known, including myself, have to fight against.

One of the top tools I use to battle procrastination is thinking small. We, as developers, naturally tend to push challenging features away. Instead, we like to focus on working with components that we’re already comfortable with. That’s natural for everyone, however, it’s not good. And I have to remind myself of this fact daily.

![small](./05-091_IMG1.png)

In his book Deep Work, Cal Newport discusses how deep work (the type of work that takes someone from good to great) is not fun. In fact, when researching top performers, Newport found that 100% of the individuals did not enjoy working on challenging tasks. So when it comes to approaching project development, please understand that the scariest features might be your greatest catalyst for improving as a programmer.

### Small, Practical Steps

So my personal recommendation is to embrace the difficult features but take an incremental approach. For example, imagine that you’re intimidated to build in the ability to let users upload multiple images per listing in your classified app. This feature can intimidate even experienced developers. You’ll need to use nested attributes and incorporate a number of JavaScript elements to allow for dynamic behavior.

This is the type of feature that could lead you to procrastinate since it’s a bit on the scary side. However, I’d recommend that you tackle the feature right away. You can write down a strategy for how you’re going to build the component, such as:

1. Integrate nested attributes for posts.
2. Build a JavaScript script that can dynamically create new file upload elements.
3. Hard code some image URLs in a sample record in the database.
4. Finally connect the system to the storage engine.

And then guess what, you’re done! Notice how much less intimidating the feature seems when you break it down into smaller steps? This is key to fighting procrastination.

## Getting Unstuck

When it comes to development there are a number of ways developers can get stuck.

### Application Bugs

If you find yourself getting stuck on a bug I highly recommend isolating the feature that isn’t working. Too many times developers attempt to fix a component while still trying to keep the rest of the system functioning properly.

When it comes to debugging I throw best practices and form out the window. Everything is on the table when it comes to fixing a bug. For example, if data isn’t showing up properly on a page, put a database query in the view template. Gasp! Don’t worry, after you’ve discovered what the bug is you can then immediately refactor the code to conform to best practices.

Other techniques I find very helpful when it comes to getting unstuck is to use the Rails console to run scripts and working with debugging tools such as Pry. These tools allow you to isolate the issue and focus on the problem instead of letting the rest of the application get in the way.

### Messages Over Models

Lastly, a key differentiator I’ve discovered between good and great developers is in the way they look at application development. A good developer can look at a program or feature and start by listing out all of the models, their attributes and relationships. However great developers first focus on the messages that will be sent from class to class. This is a completely different way to think about development. Instead of looking at classes like static object blueprints, it forces you to think about the actual behavior of the classes.

This isn’t an idea I came up with. The esteemed developer Sandi Metz described this concept the best when she said:

> “You don’t send messages because you have objects, you have objects because you send messages.”

## Summary

I hope that this has been a helpful guide for approaching project development. And thank you for your questions Christian. And to everyone watching the show, please feel free to message me with any questions that you have and I’ll do my best to help out.
