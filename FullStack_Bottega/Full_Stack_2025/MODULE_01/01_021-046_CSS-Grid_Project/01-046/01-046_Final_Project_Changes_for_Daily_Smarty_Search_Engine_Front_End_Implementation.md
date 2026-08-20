# 01-046:   Final Project Changes for Daily Smarty Search Engine Front End Implementation

In this lesson, we're going to finish up the implementation for the second page. We're going to finish it off with updating this logo. Now I think the best approach here is to create a separate class because unlike what we have here with the **search bar** and some of the other elements like the **container** this is going to be slightly different.

So you definitely could build out your own `abstract class` the way we've done before and then added a custom one here. But this is really not a ton of code so I don't think it's a problem at all to create a custom class.

So instead of having this call the `homepage-logo` I'm going to have it call the `results-logo` (make sure you save the `results.html` file)

![large](./results_logo(41).png)

and at the very bottom, I'm going to add those styles. I"m going to say `.results-logo`. Let's add the base styles here. So going to use `grid-row: one;` `grid-column: two;`. Then this also going to use flexbox(`display: flex;`). It's going to be the first flexbox implementation we've used so far in this project. So you say `justify-content: center;` and then align-items. This is also going to be centered(`align-items: centered;`).

![large](./results_logo_css(120).png)

So now if I hit save here and come back, you can see we have our giant logo back again because we need to style that. That's not a problem, come down here. Remember, we need to grab the `image tag` inside of the `results logo image`. And here we are just going to use `pixels`. I'm going to say width of 50 pixels coming back and that is it.

![large](./results_logo_image_css(143).png)

So that's really the reason why I didn't have a problem creating a custom class for this one because it really was not a ton of code we had to write. There wasn't a ton of code that was going to be re-used, and so I can see this working well as a standalone class.

If you come right here you can see that our implementations are very very similar. You can make any changes like if you notice we don't actually have that `return results upon enter`. You can either keep that or get rid of it. It's completely up to you.

![large](./results_return_enter(219).png)

I'll remove it just so we can have that a little bit closer.

![large](./results_removed_return_enter(222).png)

And there you go. So that's the finished one And this is what we just built. If you want you can play with the margins, do anything else that you want to extend this. But I'm very happy with this implementation we have built out using `CSS grid` and a little bit of `flexbox` for this entire **home page**, for the **search engine**, and then also the **results page**. So great job if you went through that you now know how to build out the front end implementation for a search engine.

## Resources

- [Source Code](https://github.com/jordanhudgens/search-engine-front-end-implementation/tree/50b1280bc9b44a4b83ac891d97c20df98af2f76b)
