# 01-035:   Integrating Custom Sizing and Styles to an HTML Text Input

You can see how much different the default HTML search bar is from what we're looking to build out. Here is our design.

![large]./image11.png)

This is going to be quite a bit more code than all of the other elements that we have. But the nice thing is once we have this done we're going to be very close or at least much closer to our solution. So let's switch to Visual Studio Code. 

Open up `main.css` and the class that we'll be using is `homepage-search-bar`

**main.css**

```css
.homepage-search-bar {

}
```

Like we did with the home page logo, this is going to be the grid element.

**main.css**

```css
.homepage-search-bar {
    grid-column: 1/-1;
    grid-row: 2;
}
```

Now, because I want to just get this all working and get our layout updated, I'm going to do the same thing for our recent posts. 

**main.css**

```css
.recent-posts-wrapper {
    grid-column: 1/-1;
    grid-row: 3;
}
```

Let's save and look at that. 

![large]./image12.png)

We actually have the layout we are looking for, and that's pretty cool. We're getting way closer to what we're looking to do here. Because we implemented the CSS grid in the way we did, it's already responsive so we don't even need to add any media queries or anything like that. So that is pretty cool. 

After we implement our search bar, I'm going to have a guide just dedicated to explaining the syntax that we used in our grid layout, because I know that it can look really confusing, so I'll do more of a deep dive into that specifically. 

For right now, I just know that it deals with the value of the grid column for that element, and later on we'll go into those details. But now that we have that in place and we know our layouts working now let's actually build out the search bar. 

So I'm going to come down right below our grid styles, and I'm going to actually grab the input inside of our homepage search bar. 

**main.css**

```css
.homepage-search-bar input {
    width: 66vw;
    height: 11.8rem;
    padding-left: 0.75em;
}
```

If you're wondering where these styles are coming from, I'm not coming up with those off the cuff. I played around with these styles quite a bit in preparation for this course and so these ones were the size I was most happy with. 

Now if you do not know the difference between `em` and `rem`, they are ratio driven sizes. `em` styles respect inheritance from other styles, so for example, `em` padding will stack on top of other padding, while `rem` will go to the root of the element or page, *(the 'r' in rem stands for 'root')*, and will ignore the previous padding styles. 

So hopefully that makes it a little bit more clear, if it's still fuzzy don't worry. I know that both of them deal with changing sizes based on ratios and that's kind of the main key. So let's save it, and check it out. 

![large]./image13.png)

I'm definitely happier with how that's coming along. Obviously, this isn't done yet, but if you look at the finished product you can see that this is definitely cleaner and looking much better.

So now let's go and as you may have noticed that text inside of the input bar really didn't look too good. So let's now come and let's start working on that. Now we're not trying to select the whole input with this, we want to grab the text itself. Here is how you can do that.

**main.css**

```css
.homepage-search-bar input[type="text"] {
    font-size: 2em;
}
```

I'm not going to use the font family that I want to use yet because we haven't imported yet so I'll just add in a different one, and later on we're going to import font awesome. 

**main.css**

```css
.homepage-search-bar input[type="text"] {
    font-size: 2em;
    font-family: Arial, Helvetica, sans-serif;
    font-weight: 600;
    color: #585858;
    box-shadow: 2px 3px 20px 1px rgba(0,0,0,0.1);
    border: 0px solid transparent;
    border-radius: 0.5rem;
}
```

So let's see if we're getting a little bit closer. 

![large]./image14.png)

And yes we definitely are. So it's not perfect yet, but we're getting there. I'm definitely happy with how it's coming along. Notice that this is looking much more like what we have in our design. So I'm happy with that.  

There's still some sizing things and you may notice this is something that I don't like. Can you see how we have this blue border around our search bar? Well, that's just the active focus state that HTML gives you by default, but it is possible to override that. 

What I want to do is have it so that when you click into it, the border around it gets a little darker as opposed to giving that ugly blue border that we're getting right now. So let's come and implement that. I'm going to just grab everything we have here and I'm going to apply a pseudo selector to it. 

**main.css**

```css
.homepage-search-bar input[type="text"]:focus {
    outline: none;
    box-shadow: 2px 3px 20px 1px rgba(0,0,0,0.3);
}
```

So now if I click on this, we're getting the effect that we're looking for. 

![large]./image15.png)

So that is looking much better. We're still going to change the sizing because this is a little bit too tall for what I'm looking for but we're definitely getting closer and we're also going to add in this cool little icon. 

So in the next guide, that's what we're going to do. We're going to import font awesome, and then we're going to work on this placeholder text inside of it.  

## Resources

- [Source Code](https://github.com/jordanhudgens/search-engine-front-end-implementation/tree/5f8f632293f14a310a99ef142736ba788daed736)
