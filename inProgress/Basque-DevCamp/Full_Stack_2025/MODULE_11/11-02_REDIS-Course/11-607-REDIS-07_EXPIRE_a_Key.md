# 11-607    REDIS 07    How to EXPIRE a Key

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-expire-key-redis)

## Video Lesson Speech

In this guide, we're going to talk about the expire command inside of redis and I want to start off by showing you a real world example of when you would use expire.

---

So here we have the (dailysmarty)[dailysmarty.com] site and imagine a situation where I know that the main featured image for each post is not going to change on a regular basis. 

What I can do is store a reference to this image inside of Redis. This would make for a much faster way of retrieving it as opposed to say storing it in the database. And that's just one example of caching and it's a very high-level version of it. Caching is a pretty complex topic but it's one of the most common ways that developers use Redis, is to be able to build caching engines. With that in mind, that is the reason why the expire keyword is so powerful. 

Right here I'm going to say SET and we'll just say featured image. Obviously, in a real-world scenario, we'd probably follow that up with some type of post ID or something like that, so we know which featured image we're talking about. But I can just say featured image. And then inside of it just say some picture.png and so now that's been set. 

```
127.0.0.1:6379> SET featured_image "somepicture.png"
OK
```
But we don't want to just have this permanently inside of Redis because if we load Redis up so massively, even though it scales very well for a caching engine, we don't want to keep this reference permanently.

We want to only have this for a certain period of time whether it's a few minutes a few hours or a few days or even a few weeks or months. But we still do want it to expire at some point, so what I can do is I can set expire and then pass in the name of the key so I can save featured image and then how many seconds I want it to expire. So this is going to be 21 seconds which is going to be how long essentially that this key is alive for and then it will disappear. So if I hit return right here 

```
127.0.0.1:6379> EXPIRE featured_image 21
(integer) 1
```
I can use what's called the TTL command which stands for a time to live and I can call featured_image and you can see it's now at 11 seconds. 

```
127.0.0.1:6379> TTL featured_image
(integer) 11
```
If I say GET featured_image it's still there.

```
127.0.0.1:6379> GET featured_image
"somepicture.png"
```
If I run TTL again it's now three seconds. 

```
127.0.0.1:6379> TTL featured_image
(integer) 3
```
If I run it one more time now you can see it's at negative 2. 

```
127.0.0.1:6379> TTL featured_image
(integer) -2
```
And if I do this, again and again, 

```
127.0.0.1:6379> TTL featured_image
(integer) -2
127.0.0.1:6379> TTL featured_image
(integer) -2
127.0.0.1:6379> TTL featured_image
(integer) -2
```
It'll keep on saying negative two which means it expired and we can also test this out by running the command on featured_image again. 

```
127.0.0.1:6379> GET featured_image
(nil)
```
Remember that it did bring back our picture last time. Now if I hit return you'll see it returns nil. And so that is how you can utilize the expire command in order to control how long a key exists in your Redis database. 


## Code

```
127.0.0.1:6379> SET featured_image "somepicture.png"
OK
127.0.0.1:6379> EXPIRE featured_image 21
(integer) 1
127.0.0.1:6379> TTL featured_image
(integer) 11
127.0.0.1:6379> GET featured_image
"somepicture.png"
127.0.0.1:6379> TTL featured_image
(integer) 3
127.0.0.1:6379> TTL featured_image
(integer) -2
127.0.0.1:6379> TTL featured_image
(integer) -2
127.0.0.1:6379> TTL featured_image
(integer) -2
127.0.0.1:6379> TTL featured_image
(integer) -2
127.0.0.1:6379> GET featured_image
(nil)
```
