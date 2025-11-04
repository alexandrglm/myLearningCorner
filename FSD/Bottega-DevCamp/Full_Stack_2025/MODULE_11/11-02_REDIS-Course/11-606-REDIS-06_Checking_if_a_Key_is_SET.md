# 11-606    REDIS 06    How to Check if a Key has been set

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-check-key-has-been-set-redis)

## Video Lesson Speech

In applications that utilize redis a very common task that needs to be performed is checking to see if a key exists or not. Now technically you could just use the get command and if it returns an element then it means that the key exists and if it returns nil then it means that key did not exist. 

---

That would technically work, however, it's considered poor practice and it goes back to what I've been talking about throughout this entire course which is you have to be very careful because nil can mean a few different things. 

It can mean that you deleted an item it could mean that you never set the key. There is a bunch of different times where nil could come up. And so what exists allows us to do in Redis is to have a little bit more explicit communication. And so if I do something like If I'm working with a blog and I say set title and set it equal to my post. Now it's been set. 

```redis
127.0.0.1:6379> SET title "My Post"
OK
```
Now what I can do is call the `EXISTS` command and then call title. And if it actually exists it's going to return a one. And so if I run this you can see that that works. 

```
127.0.0.1:6379> EXISTS title
(integer) 1
```
Now if I call exists on something that has never been created then you know so I could do something like a_key_that_has_not_been_created just like this. Then you'll see it returns zero. It doesn't return nil.

```
127.0.0.1:6379> EXISTS a_key_that_has_not_been_created
(integer) 0
```
If I ran this and ran get. You can see that it returns nil which leads us back to the part of Redis that can be a little bit confusing and can be a little bit buggy in production applications. However, if you utilize a tool like exists then you're able to get a much clearer picture on, if the key simply is a nil value or if that key actually exists. This something that you would do when you're performing some type of checks. So if you are, say using Redis for caching and you know the id of whatever you're looking for you can check to see is there a cached value on this.

If I'm saving some content in a Redis cache, I can say OK this post with this ID. Does it exist inside of the Redis database? If it does then it can retrieve the cache. If it does not exist, and if you get a 0 back. Then you might want to set and update the cache and so it's just kind of one practical way that I've personally used. And so using the exist command is a way that you can get a better idea of just what data does actually exist and reside inside of the database. 


## Code

```
127.0.0.1:6379> SET title "My Post"
OK
127.0.0.1:6379> EXISTS title
(integer) 1
127.0.0.1:6379> EXISTS a_key_that_has_not_been_created
(integer) 0
127.0.0.1:6379> GET a_key_that_has_not_been_created
(nil)
```
