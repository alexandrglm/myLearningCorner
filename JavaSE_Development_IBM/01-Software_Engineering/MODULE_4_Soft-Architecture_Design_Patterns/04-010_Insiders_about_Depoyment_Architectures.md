# 04-010 Insiders about...

## Viewpoints: Deployment Architecture

### What are some important aspects of software deployment?
---

> I think often you need to think about **scale**, like this sort of just in general: **how many users your system has?** **How much data do you expect to flow through it?** **How much data do you expect to produce and store?**
>
> **How real-time do you need the data access to be?** **What is your logging story like?** **Do you have privacy concerns?** **Do you need to ensure that data is anonymised?**
>
> So you kind of, I think, thinking about the **scale**, the **regionality**—**is it global? Is it local?** **What is your logging?** **What are your logging needs, both for internal and external data analysis?** **Mapping out the data flows?**
>
> So these are sort of the things I think we start with is with **design principles**.

---

> And in terms of choosing infrastructure, **like whether you want to go serverless, whether you want to use a hosted back end, or you're hosting your own**—**these are all design and architectural decisions**, that will probably, for your first few jobs, already be taken for you.
>
> **What's your system SLOs, your availability look like?** **Service level objectives, right?** So, you need to think about those sorts of things. 
>
> I think **ensuring you have—what does a healthy system mean to you?** **What does a well-running system mean to you?** **You need to define those metrics upfront.** And sort of **have those monitored**, and, you know, **watch those as your system lives on** and **make sure that you're meeting those objectives and goals** and **have a plan to mitigate them if they fall below where you'd like them to be**.

---

> These days, I think **microservices**, and **keeping code as modular-ised as possible** to avoid, you know, **giant, sort of bloated behemoth code bases** is really important so that **people can move fast and deploy fast.**
>
> But what I would say is a **critical part of the deployment option is**—**when you look at deployment and integrating your code, testing is fundamental.**
>
> **So I would strongly urge all of you to really, really pay attention to testing** and to use **test driven development, TDD**—**test driven development, as a development habit that you inculcate in your life** as developers and engineers. **It'll stand you in very good stead.** **I think that's the single most important part.** You won't always do it, but **you should try and do it as much as you can.**

---

> You need to think about **whether you want to canary**—there's a canary in a coal mine analogy. 
>
> **So there's a process called canarying** where **you try to roll out new code and test whether it's going to blow things up or break things** and you want to think about, you know, **you need to think about how quickly you need to release or not.** **How quickly you may need to roll back your code or not.**

---
