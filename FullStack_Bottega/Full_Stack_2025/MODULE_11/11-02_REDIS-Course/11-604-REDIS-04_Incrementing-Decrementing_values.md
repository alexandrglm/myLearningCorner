# 11-604    REDIS 04    Incrementing - Decrementing values

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/incrementing-decrementing-values-redis)

## Video Lesson Speech

So far in the section on redis commands, we've talked about `set` and `get`. And we've also talked about developing a strategy for how we can name our keys.

---

One thing to keep in mind, if that whole naming strategy looks weird to you in the majority of cases you're not going to be doing that manually. Whatever system that you're using whether it's `ruby` or `C#` or whatever it is that you're using and you're connecting to `redis` too. It will be the mechanism that is going to save that, so don't worry about how that kind of how that process is going to occur. 

Later on, when we get to our project we're going to see how that can all be automated. 

What we're going to talk about now is how we can increment and decrement values and how we can do it automatically using `redis` commands. We're going to start off by creating a post_like_count key and I'm also going to show you this other structure so I can say post_like_count and then we're going to use the :42.

```redis
SET post_like_count:42
```
This is exactly what we did before, except this is a spot where we're placing the key name first followed by a colon followed by the ID. So this once again could be the ID in your database and remember that we can use `redis` types of databases and `redis` instances side by side with SQL and that's a very common pattern in the majority of applications I build. I have some type of feature that using `redis`.

Then I have the majority of the data is actually being stored in a sequel database and by leveraging this type of structure I can have a one system call the other one because I know if I have a post with an idea of 42 then I know I can pass it into a query using `redis` like this. And I know what it's going to be listed at. 

If I do set post_like_count:42 and I can just set this equal to zero. 

```redis
SET post_like_count:42 0
OK
```
Now what I can do if I want to increment this. So every time someone goes to the site and they press they like this specific post then what I can do is I can use an increment command. And so in `redis`, this is just `INCR` and then I can just pass in post_like_count right here with whatever the value is. Now I don't want you to think of these as two different entities as far as `redis` is concerned, this is just one key. It doesn't care about the colon's it doesn't care about the number or anything like that. 

Here I'm saying increment post-flight count 42. And if I hit return it returns the new updated value is.

```redis
INCR post_like_count:42
(integer)1
```
This is very critical when it comes to working with as `redis` is all about speed and right here it's really nice because you don't have to worry about incrementing a value and then going and querying the system to see what the updated value is. What happens when you do this in `redis` is it returns the updated value right away. And so it's a very nice kind of process because it automates it combines two steps into one.

So if you're calling this from a web application, say that you want to increment this post count it returns whatever that new value is. 

If I run this again you can see it's 2. 

Just to verify that this is actually working. I'm going to say post_like_count:42 and you can see it returns the updated value of 2. 

```redis
INCR post_like_count:42
(integer)2
```
Now that is incrementing. 

Now you may have guessed if we have the ability to increment we also have the ability to decrement. And so that is going to be `DECR` short for decerment and I can say post_like_count:42 and then it's going to return the integer of 1. 

```redis
DECR post_like_count:42
(integer)1
```
It performs the exact same task. 

It simply goes into the value and it just slices one off of it and returns what the new value is. Now those are both really nice and they're very powerful when you're building automated systems where you just want to quickly increment and decrement values. 

Now there are also times, say you're doing a batch process and you don't want to only increment by 1. You may want to increment by 100 what you can do is say increment by(`INCRBY`) and then it's looking for two items. It's looking for the key, so I can say post_like_count:42, and then whatever you want to increment it by, let's say 100. If I hit return the value is now 101 and if I hit get you can see that it has been updated to 101 just like we had increment and match that with decerment.

```redis
INCRBY post_like_count:42
(integer)101
```

We also have increment by which is has its contrapositive of decrement by so I can simply say `DECRBY` and post_like_count:42 and let's say that we want to decrease it by 21. It's going to return the value of 80 which is where we will end up. 

```redis
DECRBY post_like_count:42 21
(integer) 80
```

So that is how you can use increment decrement increment by and decrement by in order to automatically change values inside of Redis. 

## Code

```
127.0.0.1:6379> SET post_like_count:42 0
OK
127.0.0.1:6379> INCR post_like_count:42
(integer) 1
127.0.0.1:6379> INCR post_like_count:42
(integer) 2
127.0.0.1:6379> GET post_like_count:42
"2"
127.0.0.1:6379> DECR post_like_count:42
(integer) 1
127.0.0.1:6379> INCRBY post_like_count:42 100
(integer) 101
127.0.0.1:6379> GET post_like_count:42
"101"
127.0.0.1:6379> DECRBY post_like_count:42 21
(integer) 80
```
