# MODULE 01 - 078: Color schemes strategies

---

As we continue on in this section on the elements of design for user 
interfaces in this guide we're going to talk about colors and how we can
 use colors how we can pick them out and we're also going to get into 
some very practical sides on when we've had a few examples where the 
color was more than just something that looked pretty color actually 
determined parts of the user experience and how we have.  

**Jordan Hudgens:** This is why I
 think this is a very important guide is there is still a little bit I 
think of a mindset in many developers and just people in general that 
think designers make things look pretty. And that's what they do. 

And that's really all that there is to UI. But for our case study, we're   
going to go through. You'll see that color determined the entire feeling  
 that people had as they started going through this application.   

So it affected the user experience the business and how it looked.  

**Jesse Cooke:** Yeah. I love color, I think it's so fun  
 to pick what colors I would use in an app. I really wanted to get a   
client who would let me design something completely purple. I haven't   
done something all purple.  

**JH:** You weren't hired by Yahoo?  

**JC:** I really love being able to plan out my whole   
color scheme for the app. When you're doing that you're going to be   
thinking of a few things.  

It's not necessarily just like oh well I like this color so I'm going to pick it.   

You have the branding of that company or that product or that specific project that you need to consider.  

You need to know how that color is going to behave in every aspect. A perfect example is on Devcamp, where we're using a green color and it's kind of a lighter color of green.   We were seeing that any time  that that color was a highlight color in text just text.   

It's really hard to see.   

It was really hard when it was on white it was just really hard to pick that that green off.   So we had to have another darker color green and a part of the style guide was hey any text when it goes green it needs to be this darker color or this darker shade than our branding  of green.  

So you're thinking of more than just oh this looks good. It's how is   
this going to be used? Sometimes I really like a lot of really subtle   
whites and grays. I don't like really deep contrasts like 1995 style   
like really like deep contrasts between the whites and the grays.   

However, I'm working on a really nice monitor maybe not everyone will be  

**JH:** Right.   

**JC:** Bad monitors are really bad at separating like an '#f7f7f7 - Gray' from just a pure white. And they see them both as white and you'll see that on projectors too.  

**JH:** Yeah.

**JC:** That's why I make sure when I'm showing clients I like showing them on my monitor, not a projector because it just looks like I just made an all white app.  

**JH:** Projectors make for some very bad types of demos for clients. 

**JC:** Yeah, exactly.  

You're thinking about a lot more than just necessarily what makes it 
look pretty. A really good tool for planning out your color scheme and 
we'll put the Web site in and of course materials.  

 But [Paletton](http://paletton.com/#uid=1000u0kllllaFw0g0qFqFg0w0aF) it's a great Website where you can go in.   

You can put in a hex value and it'll give you lighter and darker shades all inside of that same like color family.   

It also shows you different shades or different colors complimentary things like that that you can use.   

A very common mistake that I see a lot of developers make when they're coding a button  let's say they have a green button and then they have an on hover 
color.   

And that on hover green it's a different hue, a different shade 
is fine. But it's a more saturated green. So you've got this lime green 
going to a forest green and it just looks horrible. I go there every 
time. I never just arbitrarily pick a darker shade.  

I'd go to Paletton and I get all my lighter and darker shades so I'll  
 use a lighter shade for maybe an inactive button and then the main   
shade for when it's active and then a darker shade for when it's hovered  
 right so you really want to have this strategy throughout the app.   

These are the hovers these are the inactive states. These are the main   
colors. And here we're going to use mostly green but then occasionally   
we're going to bring in a red or blue in very specific instances or   
maybe you're an app that's going to be using both and at the same time.  

**JH:** One example kind of going back to making sure everything's pixel perfect.   

The one time with Devcamp I was building out a screen that you had sent over and it had a button and everything matched except when I started using it something just felt a little bit different.   

And you the one that caught it and it turned out that the border of the button was just slightly different. And that's what threw it off. We're talking literally about a 1-pixel border. And it wasn't even horrible it just threw it off and it made it feel not quite right.  

**JC:** it was fuzzy.

**JH:** Just another example of how detailed it is and how important that is.  

**JC:** Don't get mad at your designers if they're being really nitpicky over stuff like that because it makes a big difference.  

**JH:** It really does.  

Just so you understand the process that when I'm working on a project
 with the Jesse he'll send over the screens I will go implement them.   

Then as soon as I feel like they match from what I see I send it back to
 Jesse for a two-way process and he goes through and then sends notes.   

I never get upset when Jesse sends me notes back saying nope, nope, nope.
 These things have to be fixed because it does make a significant 
difference and on a first pass my eye may not pick those things up but 
you're the one that built that design so you realized right away where 
the issue was. And that makes a huge difference.  

**JC:** Oh yeah.  

A lot of times it's not even necessarily things that I picked up from  
 the beginning and then once I actually see it in use and I can hover   
over things and start to see how things actually work. All of a sudden   
it's like whoa, my strategy was wrong.  

I remember this one time I was actually at the gym and you called me   
and we had just implemented a screen that shows who you're following on   
daily smarty and all the buttons of who you were following.

 So we're looking at buttons and it's like I want to follow someone so on hover 
goes blue you click it. Well now, what does the button do? After you've clicked the follow where does the unfollow button come from what does 
that look like?  

 Originally we made the button red to unfollow it to differentiate it from the other follow buttons.   

But there was something really weird and we were looking at it and there's something both of us don't like about this screen

**JH:** Right.

**JC:** But we didn't know what it was and what we realized was that what it's doing, and this is it shows the power of color, what it was doing is that all the people you were following had this big red gross thing next to them and it just felt negative.  

**JH:** Right.  

**JC:** But these are the people you're following these are the people you like most on this platform and they have this big like angry red button right next to them and it just didn't feel right even though it was very functional that you're like *"Oh, I know where to
 go to click unfollow that person*." 

But it just didn't make you feel good about looking at the people that you were following. 

**JH:** Right.  

That's such an important thing with color, red for one example, is something that is usually only used to signal that something bad happened. It usually is that an error happened on the page, or the form you submitted didn't have the information that is needed and you need to  go fix it. So typically red has that negative connotation in people's minds.   

And what I really liked was for the dailysmarty example after we 
had that conversation Jesse recommended that we go and we start looking 
at how other people were doing it.   

So going back to one of our first guides when we talked about getting inspiration. 

--The inspiration doesn't just happen in the beginning it also goes along at each stage of that development lifecycle.--

We went and we looked at Instagram and we're like does Instagram turn  
 the button red? No, in fact when you press follow. It automatically   
changes it to white and then allows you to message the person so there's  
 not that negative kind of connotation when you're seeing your friends.   

Now old versions of Twitter used to have that same unfollow you'd click  
on follow it instantly turned the button red and then Twitter changed   
that eventually maybe for the same exact reasons why we changed it and   
that's a great example it's just a great case study for showing the   
importance of color in an application.    

**JC:** Right, and it shows how user interface kind of interplays with user experience.   Because you are thinking of a couple of  things at that point we have to ask ourselves the question.

 Well okay, so Instagram they don't like leaving a bunch of unfollow buttons because
 they don't want people gaming the system and they don't want people going and just unfollow, unfollow, unfollow.   

They want to bury the button. I always am worried about talking about specific interface things.   

It is that by the time people watch it because it might have changed but you have like to go to the person's profile and you have to unfollow.   

And so we have to ask ourselves do we want to purposely make it more difficult to unfollow people in mass no or maybe until we hit a certain critical mass.   

Let's just make it as easy to use as possible so once you click follow maybe it goes blue with solid and then it says unfollow.  

It just changes the words but it doesn't go red to connotate something bad.

**JH:** Absolutely, and that's really one of the main takeaways that I want you to get from this specific guide is that colors  are much more than just some kind of palette on the screen.   

They are something that can help dictate that user experience and change the way 
that your users interact with the system.  

So I definitely recommend for you to go and check out some popular applications and note some of the different types of color schemes and palettes that they use.   

See how they use similar colors for things like you mentioned like for buttons 
and button hover effects and see the way they create that kind of 
combination. And then we'll see you in the next guide.

## Resources

- [Color Scheme Generator](http://paletton.com/#uid=1000u0kllllaFw0g0qFqFg0w0aF)
