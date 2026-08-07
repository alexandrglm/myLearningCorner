# 11-610    REDIS 10    HSET command, Introduction to Hashes

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-hashes-redis-hset-command)

## Video Lesson Speech

This is going to be a fun section of the redis course, in this section we're going to get into one of the most common ways that you're going to use redis, which is with the hash data structure

---

Now if you're not familiar with what a hash is it is essentially a key-value type data structure. Now technically just about everything in Redis is a key-value data structure. But what a hash allows you to do is to actually store a collection of items. And so hopefully the examples we're going to go with throughout this entire section will give you an idea of when a hash is a good idea to use. 

I'm going to start off with the command for this which is going to be HSET which is short for hash set, it's going to expect a key, a field, and then a value. Remember with the regular SET we simply passed in a key and a value. With a hash, we're going to have one key that represents all of the different fields that are going to be inside of the hash. 

Let's imagine that we have a user and they have an ID of one to three. So we're going to have user 1 2 3. That is going to be the key. Now the actual field inside of that is going to be name. And then we can pass in a value. So that is going to be the name for user 1 2 3.

```
127.0.0.1:6379> HSET user:123 name 'Kristine'
(integer) 1
```
Now we can also add other items so here I can say User 1 2 3 again with an email and I can say Kristine@devcamp.com And now that's been set. 

```
127.0.0.1:6379> HSET user:123 email 'kristine@devcamp.com'
(integer) 1
```
Notice that when you use HSET just like with regular set if it works you get a new integer returned as a value with a value of 1. That means that it worked. 

Now how can we get this data? We have already passed it in. But the normal get will not pull in these values. Instead what we need to use is the command HGET. Then pass in whatever the first key is, so user 1 2 3. Then if you just do this by itself you'll get an error because it's expecting two arguments. What it needs is whatever you're looking for. So if I say a name it brings back Kristine

```
127.0.0.1:6379> HGET user:123 name
"Kristine"
```
If I call for the e-mail then it brings back that e-mail.

```
127.0.0.1:6379> HGET user:123 email
"kristine@devcamp.com"
```
Notice how this is much different than what we had when we were just using the regular set and get when we were just using those two commands we didn't have this kind of nesting. But the cool thing about this is now we have one key that has as many values as we want it to have. 

We have this key of user 1 2 3. And now this specific cache can store a name, an email, it could store passwords, any kinds of those types of elements. You now have access to and all you have to do is remember one hash key name and then that is going to the inside of it store all of the other elements that belong in this case to the user.



## Code

```
127.0.0.1:6379> HSET user name 'Kristine'
(integer) 1
127.0.0.1:6379> HSET user email 'kristine@devcamp.com'
(integer) 1
127.0.0.1:6379> HGET user name
"Kristine"
127.0.0.1:6379> HGET user email
"kristine@devcamp.com"
```
