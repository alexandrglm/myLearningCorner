# MODULE 01 - 079: Whitespaces

---

In this guide we're going to get into another element of design: 
whitespace. This is something that I know is very near and dear to your 
heart, Jesse, because when we've discussed this, you've said if there is
 one thing that developers do not get about UI, in general, it is 
whitespace.  

**Jordan Hudgens:** I'm probably 
guilty of this as much as anybody because usually when I think of 
whitespace I mainly just think of margin and padding, but it goes much 
deeper than that.  

**Jesse Cook:** If there's one thing that I usually have
 to correct in design QA, it's whitespace. It's that they did not put 
enough padding between objects. It's because--and this is my own 
anecdotal guess--but it's not as practical. 

They say "*I can still read all these and I can fit a lot more of them on a page," right?*  

**JH:** Right.  

**JC:** But... since we learned how to *scroll?*   
We don't necessarily have to be scared of scrolling. Now, that doesn't 
mean to throw caution to the wind and have all the whitespace in the 
world.   

You need to consider your constraints.   

Sometimes you're going to be X-axis constrained, and sometimes you're going to be Y-axis constrained.   

Whether that's because you're on a mobile device or you're like "*Hey, we have to be really really meticulous with how much space 
we're putting on that axis because maybe people are going to have really
 long usernames and we need to be aware of that*."   

Or, "*We have this table that needs to have five columns in it. How are we going to fit all
 those in?*" And so it's not just saying "*add all the whitespace*." 

 It's being aware of where you're adding it, cut it where you don't need it, 
but definitely add it where you do.

There's also times where you're going to be Y-axis constrained.   

For example, dashboards.  

 Clients, a lot of times, say "*I just want to open 
my phone or my desktop, and I want all my information right there*".  
 They might have a lot of information to show, so you have to be really 
meticulous about how big you make your fonts because you don't have a 
lot of space to work with.  

However, you don't want to just shove everything in as tight of a 
space as possible. 

It's just not enjoyable to use. Users don't like it.   
It gives me anxiety! When you open up an app and everything is so tight,
 I'd rather scroll more and not feel like I'm going to have a heart 
attack the entire time.

**JH:** Absolutely. And I've seen this even on some of the applications that we've worked on.   .

Take DailySmarty for example. 
When I was just going with my own design, the main body of each post took up probably about 80 percent of the screen from left to right.   

And I hated the way it looked. I didn't know *why* I hated it. I just knew I was not going to enjoy reading it.  

And then you sent the screens and brought in a lot of whitespace on 
the left and right sides. Going back to inspiration, it's very similar 
to how Medium does it, where a lot of whitespace is utilized on the left
 and right sides.    

You're completely focused as you're reading, and you just scroll down as you're going through that guide. Obviously it changes completely when you open up a guide on the phone.   

Then it has to  go from pretty much edge to edge because you want to get all of that 
content. And that's part of responsive design, but it's a very subtle thing that makes a huge difference.  

**JC:** You'll actually notice when you go to DailySmarty and look at the index view, they're in cards, right? 

So I've got like a background going and I've got a card and then I've got the 
objects inside of that card.   

That works. It just feels really good when you have lists like that to have a card to frame the content inside.

However, when you go to a post page, if I'm giving up whitespace outside of that card, and I definitely don't want to be pushing that text all the way to the edges of the card, so I put some padding there.   

Now, this text is really skinny and it's really going to have a lot of 
scrolling.  

**JH:** Right.  

**JC:** So a post page removes the card and makes the entire background white--again, similar to Medium, where it feels like the whole thing is just a piece of paper.   

And I liked that for a couple of reasons. One, I liked that you knew when you were on a post page.   

The  font--that's where you see that san-serif come in. These pages are optimized for nice viewing.  

 And it allowed me since I removed the card and just made the whole background white, it allowed me to put in some nice big fat whitespace on the left and right.   

And it just reads so well.

You actually need to be aware of how many words--there are theories on how many words across there should actually be because if you get too  long the human mind just doesn't enjoy reading it as much.  

And so between making the font size bigger, bringing the margins in--the 
articles on DailySmarty just read really nicely.  

**JH:** Yes. And, in addition to DailySmarty, another good example of this, and it's one we've talked about, is how you can go  to Apple's homepage or one of their product pages and you see that they just have very sparse content.   

They don't have an image on one side and then some text on another side. But then when I try to mimic that... it  just looks like I haven't finished the site.  

**JC:** Haha. Exactly.  

**JH:** And a lot of that comes into organizing the whitespace and making sure that those types of components are placed in the right spot.  

**JC:** And I know we come back to Apple a lot.  

 It's just a very good example because it's really easy to understand the reason why Apple does that so well.   

They're utilizing a couple of different techniques.   

If you have that much whitespace and you don't have nice colorful images?  

That's what really brings a lot of that, like, *energy* into it. It's what keeps it from being sterile.  

But then, also: fonts. They're making sure there's a lot of contrast between like a really dark thick font and the white.   

If you've got a bunch of grays on the whites and you don't have a lot of color going on,
 or you don't have people's profile images, a page can look really sterile.     

It's definitely a fine line. I think the misconception is just,  like, you know, minimalism is just not putting very much on the page.   

It's not quite that simple. It's more refining, right?   

So it's being able to take our rugged rock and chipping off the things that are 
unnecessary until you have something that's nice and smooth.   

But it definitely requires using everything in your toolkit, because that 
whitespace, while it's really nice and makes things look really clean, 
if you're not using big bold typefaces or nice pretty images, it can 
make the page just look really sterile and unfinished.  

**JH:** As your homework for this guide I want you to go  to the DailySmarty site and see the different types of ways that we implemented whitespace there.   

Then follow that up with going to places like [Dribbble](https://dribbble.com/ "Dribbble") and [Behance](https://www.behance.net/ "Behance") and see the way that other people have been building these types of user interfaces that utilize whitespace in all different kinds of ways.
