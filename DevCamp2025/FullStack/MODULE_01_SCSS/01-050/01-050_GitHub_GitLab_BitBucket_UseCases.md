#   MODULE 01 - 050:  GitHub vs GitLab vs BitBucket

***

# Video lesson Speech
[ENG]  
In this guide, we're going to walk through a comparison between three of the popular git repository hosting providers out there.  
***
Specifically, we're going to be looking at [GitHub](www.GitHub.com), we're going to be looking at [GitLab](https://about.GitLab.com/), and we're going to be looking at [BitBucket](https://BitBucket.org/product/).  

## GitHub
Starting off with **GitHub**.  
Part of the reason why I typically will use GitHub and why it's what we're going to use for this entire course and I use it for pretty much every project that I personally work on.  
It's one of the better general purpose providers out there.  
It works very well in team situations it has a good issue tracker and it's very easy to be able to have one spot I can go to with all of my centralized repositories, from a pricing perspective, it's not bad either.

## GitLab
Now another option is **GitLab**.  
GitLab is a great option if you are working in an enterprise environment.   
So if you have a number of requirements such as working with LDAP which is how you can connect a Windows Active Directory set of authentication protocols directly into your code repositories and then GitLab is a great option.     
It also has the ability to have what's called a hosted option and what that means is you can take the GitLab source code and install it on your own server.    

  So it's like you can have your own version of GitHub except GitLab is directly on your server.  

And that way you don't have to worry about any kinds of issues:  

- You don't have to worry about any security vulnerabilities that you would have to work with if you were using GitHub or the next one we're going to be talking about BitBucket.

- And in fact, GitLab in 2017 had an issue where one of the developers accidentally wiped out an entire production database and all of the users that were using the standard GitLab interface that was not using the hosted version lost quite a bit of data and it took a while to get that back.   (lol)  

At the time I was working as part of a team that was using GitLab that they were using the hosted version of it and so that table deletion did not affect us whatsoever.  

Now because GitLab is really built for working in enterprise types of environments.  
You'll see that it has a much different pricing structure than GitHub.   
![01-050_IMG1](https://GitHub.com/user-attachments/assets/036281a5-f7cb-43c0-a238-88d8079e6b02)  

  So they do have a free trial and it is supported in a few different ways.   
But as you move down the line and you see the starter, the premium, and the Ultimate options you'll see that they have a number of features many of which are related to working in an enterprise environment.  

They also are great at connecting with outside tools for project management for issue tracking and also for continuous integration.  
And if you do not know what any of those things are and your just new development then you don't have to worry about it because those are things that you don't have to implement right now you'll learn about them later.   

Just know that GitLab is a great option when you want to have more control over your data.   
You don't want to just pass all of your code repositories up to a third party service with GitLab you can manage that with a lot more oversight.  

## BitBucket
Now the third one I'm going to show you is **BitBucket**.  
On a side note, I have used all three of these in various projects throughout the years.  
I may use GitHub the most but depending on the client that I've worked with or the requirements for whoever I was building the system for I have used BitBucket and GitLab a number of times as well.   

So BitBucket is owned by Atlassian, and Atlassian also owns the large project management service Jira and so BitBucket has many different integrations and is a very nice layer if you're using Jira for managing your projects.  

This means it also **works pretty well for an enterprise environment**.   

  I would not say it's as good as GitLab for that it just isn't quite as feature rich and I'm not as much of a fan of this interface.  

  That's a personal preference on my side, you may sign up for an account with them and absolutely love it and that's perfect. The one key thing to keep in mind with all three of these options is these are simply wrappers they are visual wrappers and hosting providers for git and what that means is you're going to be able to use every single thing that we do in this course.

You're going to be able to do it with all three of these providers.   
So that is a very good idea to keep in mind with whichever one you pick out will work for everything that we go through in this course and most likely each one of these providers will work for around 95 percent of the requirements of your project, so keep that in mind.  

The reason why I included BitBucket here is not as much because of any special features that I'm really in love with but mainly because if you go to the pricing tab right here you'll be able to see that out of the three **BitBucket is the only one that provides unlimited private repos inside of their free tier**.  
![01-050_IMG2](https://GitHub.com/user-attachments/assets/91ffe800-4780-4bd1-9d39-5a699ec41ea7)  

So if you are a very budget conscious or you're working with a client or company that is, then BitBucket may be a great option for you.    
  
  And when I have worked on teams that use BitBucket every single time it was because they did not want to spend any money to have private repos where with GitHub and GitLab that is a feature that does not come free. So if you want to keep all of your code private and you do not want to pay for it then the BitBucket service may be a good fit for you.  
***
So, in summary, those are the three main hosting providers GitHub which is really the leader in the industry and in my opinion they are the best general purpose providers, GitLab which works fantastic for teams and for any time that you have enterprise types of requirements, and then BitBucket which allows you to have a great set of tools at a much lower price than the other providers.
