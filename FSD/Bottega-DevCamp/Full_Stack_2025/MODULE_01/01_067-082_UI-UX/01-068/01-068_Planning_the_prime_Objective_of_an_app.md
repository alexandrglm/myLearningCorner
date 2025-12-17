# 01-068\_Planning\_the\_prime\_Objective\_of\_an\_app

## MODULE 01 - 068: Planning the Prime Objective of an Application

***

## Video Lesson Speech

\[ENG]

**Jordan Hudgens:** This is going\
to be one of the very first things that you do when you're tasked with\
either building a new application from scratch or even just adding a\
small feature to an app. Getting this type of context is critical. It's\
something that Jesse and I have met with and worked on a number of\
projects with, so let's get into what the very first preliminary stage\
looks like.

**Jesse Cook:** _The first thing you're going to do_\
_with any of these projects is that you really need to find your feet_\
_inside of the project. You're going to deal with a lot of different_\
_ideas. Whether you're working inside of a company with a single product,_\
_or if you're taking client work, or even just throughout your career_\
_you're going to be confronted with lots of different ideas. That's one_\
_of the beautiful things that we love about software. However, you do_\
_need to identify what the prime objective of this application, or_\
_change, or whatever it is is, you need that 10,000-foot view to get your_\
_bearings because everything else is going to revolve around that._

_As a consultant, you should be able to step in and say, either,_\
_this feature is not building towards that objective, or I'm not_\
_understanding how this is all fitting together. To start, before you do_\
_anything, you need to know what's happening. I know it seems kind of_\
_obvious but it's a little bit more nuanced than that._

_One of the pitfalls that I think a lot of people have is also_\
_going the other direction where they really want to get into the weeds_\
_of the business. Sometimes I really have to hold back a lot of my_\
_clients, and tell them "I don't need to run your business for you."_

_I do have a background in business, so I'm inclined to talk about_\
_that, and, in some respects, I do talk about that a little bit,_ when it is applicable to the project. _By_\
_understanding the intentions of the product owner whether that's the_\
_client, or the manager who's bringing it to you. Knowing their_\
_intentions will help you make more clear decisions. As I said, it's just_\
_getting your feet under you. It's just understanding what environment_\
_you're working in and what the scope of this product is._

**JH:** I remember a time where I did a horrible job. I\
was working for a client whom I'd built out a number of applications for\
over the span of a couple of years, so I thought I was pretty familiar\
with their wants and needs.

They had e-mailed me this feature request and I just assumed I knew\
what they meant. I didn't get any contacts, and I didn't find the prime\
objective. What ended up happening is: I spent two full weeks of\
development time building out this massive new feature. I sent it to\
them and... they just sent a question mark back.

**JC:** _Haha!_

**JH:** Which is never a good thing. I felt I built it perfectly, I used test-driven development, and all this--

**JC:** _--is there any punctuation mark that would have been good? Just one?_

**JH:** Maybe? Like a smiley face? I would've been good with that.

So it turns out I did not understand what they really needed. They\
just needed a very simple way of exporting data, but the way they\
described it, it seemed like they needed this completely different\
billing system. If I would've been better about this stage, for that one\
feature, it would've saved a lot of time and heartache.

**JC:** _Right! I remember when you first came to me_\
_with DailySmarty. It was really critical for me to understand: who is_\
_going to be using this and what are their intentions when using it? Not_\
_necessarily what OUR intention was in building DailySmarty - that's_\
_important as well, and I need to understand that - but what is the_\
_purpose of this? Is it completely social? Is it to build a database? Is_\
_it to answer questions? Is it to build credibility? Those questions give_\
_me an idea of the type of audience that's going to start using this_\
_product and what their individual intentions are going to be in using_\
_it._

_If I know right from the beginning that this is going to be_\
_really heavy on social, then I need to be asking lots of questions about_\
_that: What features are in here that are going to engage that social_\
_aspect? If the intention is to be a database to store lots of things,_\
_then the interaction isn't as important. Then, we need to really_\
_optimize for showing the links that are being shared and directing_\
_someone who has no idea what this platform is. You're going to have a_\
_lot of people from outside the app coming into it, so they're going to_\
_experience it differently than someone who's using it every day, right?_\
_So I need to identify the users within users._

_Let's take Reddit, for example. You have this platform where_\
_people are interacting very heavily on a daily basis. They know the_\
_layout, and they know how to use the application because they're using_\
_it every day. If all of a sudden, you know that people are sharing_\
_links, or that the business objective is going to be sharing links, then_\
_you can have lots of inbound traffic of people who've never interacted_\
_with this app before. They're both the same type of user from a database_\
_perspective but they are two completely different people. One is just_\
_some casual person who saw a link on Facebook, clicked it, and is now_\
_reading an article. The other person is deep in it, building up their_\
_karma._

**JH:** Right.

**JC:** _And so these are two different users even_\
_though, on paper, they might be called the same user. I won't identify_\
_that unless I know how this app is going to be used and what the long_\
_term goal of it is._

**JH:** That's so critical. I've had so many projects\
where, as soon as I found out what that primary objective was, it also\
helped get me excited about the project, too. When I found out about\
something and I fell in love with the concept, it started to give me\
ideas on different features to add and how to improve the overall user\
experience. Whether the client is a freelance client or if it's your\
boss, they're going to have a certain feature set in mind, but they're\
still just one person. So when you find out what the full goals are, you\
can bring a ton of other features to the table as well. Just like when I\
originally took the idea for DailySmarty to you, the feature set grew\
quite a bit just from you and me talking. That wouldn't have happened if\
I hadn't told you what the goals for the system were.

**JC:** _Another example is this really cool app that_\
_we were able to work on. The client came in and he had an idea of what_\
_he wanted his app to be. He wanted to stream city council meetings. He_\
_was a lobbyist, he was always in city council meetings, and he came up_\
_with this idea. He's said "People have no idea what the city council is_\
_talking about. We need to have an app that makes it really easy to live_\
_stream." So that's what he came in with. Now, in that first initial_\
_conversation, I pointed out a big hole in his logic. He was assuming his_\
_potential users didn't go to city council meetings because it's hard to_\
_get there, but that's not the case. The reason why people don't go to_\
_city council meetings is that they don't care about 99.9% percent of_\
_what they're talking about. That's why people don't interact with their_\
_local governments: most of the things that they're talking about aren't_\
_interesting to them. So I told him, "You can build this up, but it's not_\
_going to reach your prime objective. Your prime objective is to_\
_increase the engagement of local communities with their local_\
_governments. This is not going to do that."_

_Instead, what you need is in-the-moment notifications when_\
_something IS important to you. So instead let's build a user profile._\
_When they sign up for an account, they indicate "I'm interested in_\
_zoning and hunting and that's it. That's all I care about." Then, when_\
_they're talking about those things in the city council meeting, users_\
_can get a push notification and they know_ **at that moment** _to tune into that stream._ **That** _is_\
_going to increase engagement. I wouldn't have been able to solve that_\
_problem for him if I didn't understand what he was trying to accomplish._

**JH:** That also brings up a very good point about the\
entire goal of UX. I think there's a lot of confusion around people who\
have never gotten into it much before. Just like people think the user\
interface is just picking out pretty colors and fonts, I think a lot of\
people think user experience is just saying "Oh, they clicked on this\
page, and then they went to this other page." That's not true at all.\
The user experience is part of the development process. It's really very\
closely aligned with the business side.

**JC:** _Yeah!_

**JH:** During this process is where you can actually\
create custom features. This is where you get some of the uniqueness\
that you're going to be building into these applications. I don't want\
you to think of user experience as just setting up what pages are going\
to be directed where. It's much larger than that. It comes down to the\
overall user experience like you're talking about with the live\
streaming application. You completely changed the way the process\
worked, because you made an interest-based system instead of just a live\
streaming app. None of that would have been possible without this first\
step.

**JC:** _Absolutely. And, at some point, a line gets_\
_drawn where it starts becoming "scope creep". My CTO has to hold me back_\
_from that all the time because I think of new things to add. We can_\
_discuss what goes into a good MVP and things like that, but it comes_\
_down to: this thing needs to be built_ strictly _to serve the objective and_ nothing _else,_\
_right? In those initial meetings, you can bring up these things that_\
_are going to better help them reach their objective, but unless you're_\
_going to get paid for it, you obviously don't want to build on top of_\
_that. It's about meeting those initial objectives. Once that line has_\
_been drawn in the sand on any level--the creative director, the CTO,_\
_team leads, or the developers themselves--at some point, it becomes_\
_detrimental to start creating more features._

**JH:** We all want to build all the cool stuff that we\
can think of, but that's where it gets into some of the project\
management and system design side of it.

**JC:** _Right, right._

**JH:** It is a very fun process and it is critical, but\
if this part isn't done right, then nothing else is really going to\
work, because what you're building might not be targeted at the goal\
that really needs to be achieved.

**JC:** _Right! And I wanted to touch on the passion_\
_that you were talking about because it's not a small thing. It makes_\
_your job into something more than just a job. All of the times that I_\
_have stayed late or pulled all-nighters, it wasn't because someone made_\
_me. It's because I was really excited about what I was doing. That's the_\
_same thing with my developers. I don't ever ask them to stay late, but_\
_when they are staying late, it's because they're doing something that_\
_they're really excited about. If you're two inches away from your code,_\
_you might not be excited about it, but if you know what it's doing and_\
_you see the bigger picture, then that can be a huge piece of what really_\
_drives you and gives you that passion to be a builder because that's_\
_what we are._

**JH:** Absolutely.

In this guide, we really wanted to focus on that prime objective and\
make sure that you have that as a firm foundation. In the next few\
guides, we're going to see what steps you're going to take once you have\
the prime objective in mind.

***

\[SPA]
