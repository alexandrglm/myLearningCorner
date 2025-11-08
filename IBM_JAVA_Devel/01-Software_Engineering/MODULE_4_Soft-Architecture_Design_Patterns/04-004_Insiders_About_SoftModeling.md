# 04-004 Insiders' Viewpoints
## The Importance of Design and Software Architecture

---

#### Discuss the importance of design and software architecture in a software engineering project

---

> **Design and architecture are crucial.** If you don't know where you're going, how do you know what you need to do now? 
>
> You always need to know what you should, what your program needs to be prepared to handle, and the system that it's operating within. If you are running a series, if you're running a bunch of applications that are all co-hosted on the same server, you can make certain assumptions about the ways those services can interact with each other that do not hold.
>
> I also sometimes think of **architecture and orchestration**. So you can you can have like a beautiful, really nice sounding instrument. But if it's not in sync with the rest of the orchestra, **it's going to sound like a complete cacophonous mess in the end.** So you really need to think about the **bigger picture**. 
>
> *Sustainability*—whether you're building actually makes sense in the larger sort of ecosystem.

---

> And every time if you spend the time to write your code, and then you figure out **why it doesn't work, you've wasted a lot of time** writing that code. Maybe you've learned some things—it's not a total waste. But you've spent a lot of time that could have been spent moving forward.
>
> And so if you can **think about those things ahead of time on a project**, and then when you write your code, you're reasonably sure that the code you write is actually going to persist and get used, that's generally speaking a better place to be in. 
>
> **So architecture is very important.**
>
> There's a lot of talk about **scale** and **global availability**. Often something you build would work very well in a very hyper-local environment, but not work well when it's expected to be used across the globe. Or, you know, works well for one user, but doesn't work well for a million users.

---

> I'm building a service: **I need XYZ pieces of data to come into the function that I want to write.** 
>
> **Where are those things coming from?** How are they getting passed in? Once I have them, **what do I need to do with them?** **What else needs to access this data?** And **how am I going to get the data to those other parts also?**
>
> If you don't have those questions answered, **you end up writing a lot of churny code.** 
>
> If everything is on a separate server somewhere in the cloud, or separate physical servers that are just located somewhere different inside your data centre, then you have to incur a **network hop** to go over them. And that takes time—**your page might start timing out and your customers might get really upset at you for how long things take.** 
>
> And so, if you're building something in like a **microservice architecture**, the way that you load your data becomes **much more important** than if everything is hosted together on the same server.

---

> But maybe the question of **who is using my service?** **How do I know who you are?** That can become an interesting question, depending on where your servers—where your services are running—and what mechanisms are available to you to identify people.
>
> If you want your customers to log into a website: **How are you doing account management?** **How do you know who that person is and what they're allowed to do?** Or if you have multiple services talking to each other again, **how do you know what that service is?** **What it's allowed to do?** **How do you make the call between one and the other?** **How do you transmit data between different parts of your stack?**
>
> **So architecture is very important.** It doesn't always have to be super well defined, super strictly defined, but **you need to have some idea** of what things do you need, roughly where they're going to live, and what things what are they responsible for? 
>
> **Those would probably be the three big questions to ask: *what*, *where*, and *scope of them*?**

---

> So these sorts of concepts—**you have to think about those things when you're designing or architecting a system.** 
>
> **You're thinking like 5, 10 years ahead.** When you're thinking about architecture and design, **you're not thinking about just building something quickly and getting it up—you actually want to plan ahead.** 
>
> So I think a lot of architecture and design is thinking about: **how many steps, how many years, whatever in the future—what is it going to look like then?** **What do you need to do to keep growing the system and evolving it?** 
>
> Because you know, **you don't want to make gigantic architecture changes that often.** You know, when buildings are repaired, there's like tiny bits of things that get repaired. And then at some point, you tear the thing down and rebuild it. And I think that's a similar model applied to **sustainable system architecture**—**you don't want to re-architect and redesign every few years.** **You want it to last as long as you possibly can.**

---
