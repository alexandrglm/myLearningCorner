# 02-012:   The Case Against Code Comments

In this guide, I want to take a practical look at when code comments can be beneficial along with when comments cause issues.


## Should I Comment My Code?

### When code comments go bad

I remember back when I learned how to code. A common theme I heard was that all of my code should be commented. This seemed like a good idea at first. And in a perfect world comments would be beneficial. However, we do not live in a perfect world.

Let’s jump into a time machine and look back at how I might have commented a method years ago.

![large](https://www.crondose.com/wp-content/uploads/2016/10/Snip20160930_18-1024x776.png)

If you run this code you’ll see that it all works properly.

![large](https://www.crondose.com/wp-content/uploads/2016/10/Snip20160930_19-1024x776.png)


### So what’s the problem?

Since the one constant rule of software development is that requirements change, let’s imagine that our program needs to be updated to also print out the player’s position.

![large](https://www.crondose.com/wp-content/uploads/2016/10/Snip20160930_20-1024x776.png)

In this code, I’ve updated the method so that it takes in a key/value hash and prints out the player, lineup number, and position. This works properly when I pass in a hash argument.

![large](https://www.crondose.com/wp-content/uploads/2016/10/Snip20160930_22-1024x776.png)

But did you notice something? I didn’t update my comments and the instructions still are calling for an array. If I need to work with the method in the future and I reference my comments and pass in an array, the program no longer works properly.

![large](https://www.crondose.com/wp-content/uploads/2016/10/Snip20160930_23-1024x776.png)

So what’s the main problem with code comments? The issue comes down to the fact that they are fragile and can’t be trusted. Comments, by their nature, are static. This means that you could completely change the behavior of a method, and if you don’t update the comments they will be rendered useless.

When I take on a legacy application and look at the comments it’s rare that they’re still applicable to the current system.


### Code that Explains Itself

Through the years I’ve slowly stopped commenting my behavior based code, such as classes or methods. Instead, I’ve focused on improving the names that I give parts of my programs. I’ve discovered that if I name a code component properly, comments are no longer needed.

David Heinemeier Hansson, the creator of the Rails framework, had this to say about the importance of naming:

> “One of the real delights of programming is picking great variable, method, and class names. But an even greater treat is when you can name pairs, or even whole narratives, that fit just right.”

In this guide, he gives a great narrative on a specific time he was intentional in regard to naming a method.


## When Code Comments are Beneficial

With all of the bashing that I’ve done in regard to code comments, you may be wondering: is there ever a time when commenting is beneficial? The answer is: yes.

I don’t like add comments to code in order to explain functionality, because behavior constantly changes. However, I have found two ways to incorporate comments that have proven to be helpful.


### Code Organization

First and foremost, I will utilize code comments for code organization. I have discovered that comments can be helpful for large code files such as CSS style files. I’ll add comments such as: /* Nav header styles */. These types of comments let me quickly know where a specific set of styles can be found. And because these types of comments don’t give instructions or describe behavior, they’re far less likely to get outdated.


### Automated Comments

Next I’ve discovered that automated comments can be helpful for reference purposes. For example, the Annotate Ruby gem will automatically create and update comments in code files that supply database information. When I work on a Rails application I’m constantly referencing the database schema file to ensure I’m selecting the correct column names. The Annotate gem automates this process by commenting model files with the table information.

When it comes to working with code comments, automated tools that will also update the comments can be beneficial to a developer’s workflow.


## Summary

In summary, code comments can lead to a number of negative issues for programs. Comments are fragile, can be misleading, and perform a poor job of explaining application behavior. A better choice is to improve at method naming so that your code explains itself.

After publishing this guide, developer Kiss György pointed out a great quote from Robert ‘Uncle Bob’ Martin who said:

> “Every comment you write is a failure to express yourself well in code.”
