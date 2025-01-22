# MODULE 1 - 014:  @mixin ARGUMENTS

***
# Video lesson Speech  
# Introduction to Mixin Arguments in SCSS
In this guide you'll learn how to pass standard and default arguments to SCSS Mixins to generate dynamic behavior.  
***

After I finished the last section I realize that I may have jumped the gun a little bit in what we were planning to do next. Some of the topics that I was about to introduce for our more complicated feature with mixins might be a little bit challenging to understand if you've never seen them before. So we are going to break it down and go with a few more straightforward topics that lead up to that and we'll get to that in a couple of sections.  

There are times where you may simply want to have access to a set of styles and to be able to call this mix and from anywhere and that's perfectly fine. However, there are many times where you want to change that behavior just a little bit. You may want to have some type of dynamic behavior and that's what we can leverage arguments that we can pass right into our mixins. I'm going to start off with a basic example and this is going to lead directly into how we can implement conditionals. We are going to declare a variable and with this variable, I'm just going to call this link color.  

<img width="465" alt="01-014_IMG1" src="https://github.com/user-attachments/assets/0f044015-5ab7-4706-867a-071b42e790d9" />  


The goal of this is is that it should be able to replace the color on both of the links and it should be dynamic. So if we want one color for one link but a completely different color for the other then we can still call featured and have that different behavior. So the way that we're going to do it is we can copy link color and instead of having the hardcoded light blue steel I'm going to paste it in here.  

<img width="421" alt="01-014_IMG2" src="https://github.com/user-attachments/assets/be63f29a-3d78-40ae-8f46-7b57125e82de" />  


So now that we have this link color you may notice if you're following along using code pen that we now have an error. And if we click on this error, what it's going to show us that the mixin featured is missing the argument link color. That's a nice helpful way of seeing what's going wrong. So what this means is that when we pass in or when we call featured right here we need to pass in that argument. So here I'm going to pass in. Let's just say black.   

<img width="339" alt="01-014_IMG3" src="https://github.com/user-attachments/assets/b585d71b-7e9c-4062-99b7-6692b28c6f74" />  


And now what is going to happen is after I fix the other one it's going to change it for this featured. I'm going to copy this come down here and the same issue. Now they're both black. Now if I want to change this one so save for this one I want to change this to something like Mint cream.

<img width="506" alt="01-014_IMG4" src="https://github.com/user-attachments/assets/dd37fc58-d54c-4d5e-9f20-b0437d97da08" />  


Now you can see that this heading link is still black but this one now has been changed to mint cream. And so even though we're using the exact same mix and we can now make this completely dynamic. Now the other thing and we're going to get into is we also have the ability to have default arguments and so say that we for 99 percent of the time we want to have black for this featured mixin. But there are a few times like when we have a dark background where we may want to throw in a different color. So the way that you can do this is we can pull out the color black out of featured first. It's going to throw an error right now because we haven't implemented this fix yet. Up in our mixin, we can add out default argument like this:  

<img width="398" alt="01-014_IMG5" src="https://github.com/user-attachments/assets/f8dddab7-f2e6-4c8d-b071-c4f81178257b" />  


So even though we're not passing in an argument with featured it's still working. If you come down here mint cream is still overwriting this link color. Now, this starts to get a little bit more complicated when you go into having multiple arguments. In our more advanced section when we talk about how we're going to implement flex-box here then I'm going to show you how you can actually use named arguments to make it very clear what values you're setting.  

## SCSS Code for Mixin Arguments with Default Values
```scss
$off-white: #f6f6f6;
$featured-color: DarkRed;

@mixin featured($link-color: Black) {
  color: Tomato;
  .subheading a {
    color: $link-color;
    text-decoration: none;
    &:hover {
      color: $link-color;
      text-decoration: underline;
    }
  }
}

body {
  background-color: $off-white;
  height: 100vh;
  height: 100vw;
}

.container {
  font-family: Verdana;
  font-size: 0.8rem;
}

.page-wrapper { 
  padding: 21px;
  $featured-color: RoyalBlue;

  .featured {
    @include featured;
  }

  .page-content {
    background-color: $featured-color;
    padding: 42px;
    color: $off-white;

    .container {
      height: 60px !important;
      font-family: courier;

      .description {
        float: left;
        width: 75%;
      }

      .sidebar {
        font-family: Verdana;
        text-align: right;
        float: right;
        width: 25%;
        @include featured(MintCream);
      }
    }
  }
}
```
