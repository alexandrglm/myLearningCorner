# 11-600    REDIS 01    How to Install REDIS on MAC (and LINUX)

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/how-to-install-redis-run-redis-cli-mac)

## Video Lesson Speech

When I was first learning about redis. I was a little bit confused on how I could structure my keys in a way that they could actually be useful. So if you're used to working with say a SQL database then it's pretty common that you will have an ID column some way of making that unique. And so when you want to reference the specific record you know what your path to that record is going to be. You have one item you know is going to be unique in that table. 

---
Well in no SQL  we don't have tables. We simply have, in `redis` specifically these references in memory of key_value pairs and so we have to develop a strategy based off of that. So extending our knowledge on `set`ting and `get`ting items. Let's talk about how we can create a strategy with how we build our keys. And this is going to look very different. I know it was much different than I ever expected when I was first working with `redis`. However, this is a common practice and so I wanted to introduce it to you right now so that we can use it throughout the rest of this course. And so you can start becoming familiar with it. 

I'm going to start by creating a seter. I'm going to say `set` and instead of just typing something. Say I want to count guide likes, this would be something like if you have a social network and you want the ability to quickly track how many times people have liked a guide then we can create a really nice little helper right here.

A nice little key that keeps track of all of that. Instead of just saying guide_like_count because how are we going to know which guide it's referring to? What we can do is actually at the very beginning here put some type of ID. So if you're layering `redis` on top of some other type of application and you're using `redis` only to have a very quick look upon something like a guide_like_count to see how many times people have favored a specific guide. You can start by giving some type of ID. 

Let's imagine ID in the database is 105 and you can say 105:guide_count. And now we can pass in this value. So I can just start it at 0 and now say get 105:guide_like_count and it's going to return 0 and it's to do it very quickly. 

This is one very popular strategy when you're working with `redis` in how to structure your keys so that they're unique. And now that you have this understanding we can continue on with the rest of the course because we're going to be using this type of structure quite a bit.



## Code

```
127.0.0.1:6379> SET 105:guide_like_count 0
OK
127.0.0.1:6379> GET 105:guide_like_count
"0"
```
