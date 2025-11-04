# 11-608    REDIS 08    How to Override Values with GETSET

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/guide-overriding-keys-value-getset)

## Video Lesson Speech

So far throughout this course as we have analyzed the various redis commands we've typically been treating every key as if it was unique and there are going to be many times where that's the case such as using a key for a specific kind of, say a page or if you're using caching or some other type of key where you need to make sure that it's going to be unique to a certain instance. 

---

However, there are also many other times where you need to be able to override a key's value and there are a couple of ways of doing that. And I'm going to show you what the differences are here. 

Let's say that we have a scoreboard tracking system. And so we have something called a current batter in baseball and we're going to set this equal to Altuve, and it's been set. 

```
127.0.0.1:6379> SET current_batter 'Altuve'
OK
```
so far everything that we're doing here is everything we've done before. And so now I can call current batter just like normal. And it brings back Altuve.

```
127.0.0.1:6379> GET current_batter
"Altuve"
```
Now, however, this is going to be up on a big scoreboard. So I need the ability to change out batters on a pretty quick basis so I need to be able to say set current batter and then I can pass in someone else. 

```
127.0.0.1:6379> SET current_batter "Correa"
OK
```
And so now if I call and I say get current batter, you can see that it has been changed. 

```
127.0.0.1:6379> GET current_batter
"Correa"
```
And so it's perfectly fine to be able to override values. The Redis system does not complain about it. You don't get any errors or warnings and it's good. It's something you have to be definitely very cognizant of because you might accidentally be overwriting something that you really need. And so you need to make sure that that's where namespacing and some of the other tactics that we've discussed go into play. 

However, there's also another alternative to this specific situation. So say that you have some type of value and you want to be able to get it and to set it at the same time. We can see that we have Correa as the current hitter. Now let's imagine that we want to make our system a little bit more efficient. And so we don't want to have to override and then call get. And then we may also want to know who the previous batter was. And so here we can use the command GETSET current_batter and now if I pass in Bregman right here and hit return you'll notice something a little bit different. 

```
127.0.0.1:6379> GETSET current_batter "Bregman"
"Correa"
```
It ran GETSET, it overrode the Correa value but it returned Correa. This is a very common pattern that you're going to be seeing in Redis, where you want to quickly override one key's value but you want to know what it was prior to being overwritten. So our scoreboard example is definitely one time when you would do it. But you may not be creating a scoreboard as fun as that would be. You may also just be creating a caching engine and you want to be able to override a current value so something on the page that needs to be cached. But you also want to be able to know what that value was. So if it's a component on a page that's cache like some type of widget or a sidebar and you're wanting to bring those values in, you know that you're going to override the system for some type of update. But you still want to get whatever the current value is. That's where GETSET comes in very handy. 

Now, if I run GET current_batter you can see that now it's Bregman even though it returned to Correa when we ran GETSET. 

```
127.0.0.1:6379> GET current_batter
"Bregman"
```
That's one of the most important things to keep in mind is GETSET simply overrides a value. But it will return the previous value. That's something that can be very handy. But it can also lead to some very confusing bugs. If you're not aware of that return value. One of the biggest keys to understanding Redis is understanding which commands are mapped to which return values. 

Now another thing to keep in mind is if you use GETSET on some key that doesn't exist. I'm going to create a key right now and just say hi there. And now if I run this it returns nil. 

```
127.0.0.1:6379> GETSET asdfasdfasdf "Hi there"
(nil)
```
And that makes logical sense if you look at the behavior above because there was no previous type of value in this key because this key didn't exist. However now if I run just a regular Get on this key just like this you can see returns the value

```
127.0.0.1:6379> GET asdfasdfasdf
"Hi there"
```
and so it did save it even though it returned nil. So this is a very powerful tool. It's one that starts to get into a little bit more complexity when it comes to understanding how Redis works. But it's a way of combining multiple processes and also being able to get different types of return values, then typically you would get if you were just using GET and SET by themselves. 


## Code

```
127.0.0.1:6379> SET current_batter 'Altuve'
OK
127.0.0.1:6379> GET current_batter
"Altuve"
127.0.0.1:6379> SET current_batter "Correa"
OK
127.0.0.1:6379> GET current_batter
"Correa"
127.0.0.1:6379> GETSET current_batter "Bregman"
"Correa"
127.0.0.1:6379> GET current_batter
"Bregman"
127.0.0.1:6379> GETSET asdfasdfasdf "Hi there"
(nil)
127.0.0.1:6379> GET asdfasdfasdf
"Hi there"
```
