# 11-611    REDIS 11    Common HASH commands

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/introduction-hashes-redis-hset-command)

## Video Lesson Speech

This is going to be a little bit of a longer guide than most of the other ones in this course. It's because as we're working with hashes I think it makes the most sense to see multiple common commands, and see them at the same time side by side, and see how they can work together.

---

Because whenever I'm working with hashes or the hash data structure in Redis it's pretty rare that I'm only running one single command. I'm usually running multiple ones in order to build out an entire system. The other reason is that you already went through a number of these commands in the regular just plain key-value type of setup with Redis and what you're going to discover is that redis has almost a cloned version of each one of those commands for hashes. 

The first thing that I want to walk through is recreating what we built in the last section or in the last guide where we created that user. Except now instead of HSET, I'm going to use HMSET and the M stands for multiple. If you noticed it was kind of annoying that I had to create a different field and value for each one of those fields I wanted to add to the key. With HMSET. What we can do is we can actually create one key and then as many fields and values at the same time and this is something that you're most likely going to be using more often than just HSET.

I wanted to show you that one because it was a most introductory version of working with hashes but in a real-life application typically are going to be using HMSET because you don't want to run multiple commands over and over again. 

I'm going to say HMSET and we'll say user and this time we'll just say user:42 and that is going to be our key and now we can do names again. So here we can say, Darth, and then we can add an email and this will be darth@vader.com and we could also keep going on and on. But for this for the sake of this example, we're just going to do it this way. 

```
127.0.0.1:6379> HMSET user:42 name 'Darth' email 'darth@vader.com'
OK
```
Everything there worked, and so now if I type in HGET I can type user:42 name

```
127.0.0.1:6379> HGET user:42 name
"Darth"
```
you can see we have access to it just like before. So HMSET gives us a nice shortcut for being able to create a hash and then add all the fields and values in a single command. Now in addition to HMSET, we also have HMGET. So here I can say HMGET as you can see it looks for a key. So it looks for the name of that hash and then we can pass in as many of the fields as we want. And if I return you can see how it returns this neat little list here. 

```
127.0.0.1:6379> HMGET user:42 name email
1) "Darth"
2) "darth@vader.com"
```
So it returns not just each one of the elements but actually puts him in a list form. Now if you're working inside of an application this is going to be returned to you as an array. That's something that is very important to keep in mind because what an array means whenever you get an array returned to you in an application that means that you're going to have to iterate through it in some form or another. Now if you like the ability where we can call HMGET and then get all of those values you're really going to like this. This is a command I really enjoyed the first time I saw it and what it is is `HGETALL`, you just pass it in the key and then from there, it'll return a list. 

```
127.0.0.1:6379> HGETALL user:42
1) "name"
2) "Darth"
3) "email"
4) "darth@vader.com"
```
Now this might be a little bit confusing if you've never seen it before because it's returning a list of four elements and the name or I should say the field is the first element followed by its respective value and then followed by the next field followed by its value and if we had 10 items inside of this hash it would show all 10 of those. This is a way you can call and say I want to have all of the Keys all the fields all the values inside of a specific hash. You just pass HGETALL, and then whatever the key is. The name of the hash and it'll return all of those to you. That is another command that can be very helpful when you simply want to see all of the different elements that are inside of a Hash, not just the values but also be able to get access to those keys. 

Next on the list is the ability to just get the keys by themselves. That is something that I personally found very helpful in a number of different applications because I'll be building it out, and I don't have a clear picture of every single element that's inside Redis. If I want to be able to see what keys are available for me to work with. And you're going to see this when we get into the project portion of the course. When you do this you can run a command called `HKEYS`. I can say HKEYS followed by user:42 and you can see it returns a list. It doesn't return the values at all, it's just whatever the names of those keys are and this is something that I've found very helpful in a number of different applications where I've implemented Redis and I had to run various queries. 

The next command might look a little bit familiar to you, it is called `HEXISTS` and what it's looking for is the same thing as the exists that we already went through. We can pass in 42 followed by e-mail and ill will return a one if it is there but if we do say altemail it's going to return 0.

```
127.0.0.1:6379> HEXISTS user:42 email
(integer) 1
127.0.0.1:6379> HEXISTS user:42 altemail
(integer) 0
```
This is a way where we can check to see if a specific hash that we're working with has a value there or if it has a key and a value inside of a hash. 

Now, this next command we're going to work through is also going to look pretty familiar and I'm going to start off by setting a new key inside of our user:42, to add a new element into a hash you can just use HSET or HMSET.  I can say user:42 id and then we'll start off with an id of 1. And so this is just a regular 1 and so now if I type in HGETALL and user:42. 

```
127.0.0.1:6379> HGETALL user:42
1) "name"
2) "Darth"
3) "email"
4) "darth@vader.com"
5) "id"
6) "1"
```
You can see that now we have an id and it has a value of 1. 

What if we wanted to increment that and you may not want to increment id's this is just for this example. You could also do something like post likes or friend counts or anything like that. But we can use the same increment(INCR), decrement(DECR), increment by(INCRBY), and decerment by(DECRBY) and so redis has all of those options available in a Hash format. 

If I wanted to increment that value I can just say HINCRBY now we have our key which is going to be user:42 followed by the field. And then in this case, because I used increment by I can tell by any number that I want. And so now if I runHGETALL user:42 you can see that now that id has a value of 124 instead of just one. 

```
127.0.0.1:6379> HINCRBY user:42 id 123
(integer) 124
```
That's a way where you can perform the same type of task you could with a normal type of key value set and you're able to do it inside of a hash. 

Next on the list of commands is going to be the delete command, here we can say HDEL just like our normal delete command, pass in user which is our key followed by the field, let's say that we want to get rid of that id, we can just say that and it got returned. 

```
127.0.0.1:6379> HDEL user:42 id
(integer) 1
```
Now if I run HGETALL you can see that user:42 no longer has an id or that value of 124.

That is how you can delete an element inside of a hash. 

Now the last command we're going to talk about is called HLEN. If I do H L E N and then type user:42 you'll see that it brings back 2. 

```
127.0.0.1:6379> HLEN user:42
(integer) 2
```
What that represents is if I do HGETALL again, it means that we have two keys inside of this user:42. 

```
127.0.0.1:6379> HGETALL user:42
1) "name"
2) "Darth"
3) "email"
4) "darth@vader.com"
```
It's a way where you can run this command and see all of the different elements that are inside of there. 

Now, notice it does not call length on the entire set of items. It's not going to say 4 because it counts the name and Darth as one element. Then the email and then darth@vader.com as a second element. That's a reason why it returns 2.

In review, we've gone through `HMSET`, `HDEL`, `HEXISTS`,  `HGETALL`, `HINCRBY`, `HKEYS`, `HLEN`, and `HMGET`. 

It's a number of commands, if some of these are still a little bit fuzzy I recommend for you to jump inside of the redis cli, experiment with your own examples until it becomes familiar because when we're going through the project and when you're working on this just by yourself you're going to find that you're going to be working with hashes quite a bit. 


## Code

```
127.0.0.1:6379> HMSET user:42 name 'Darth' email 'darth@vader.com'
OK
127.0.0.1:6379> HGET user:42 name
"Darth"
127.0.0.1:6379> HMGET user:42 name email
1) "Darth"
2) "darth@vader.com"
127.0.0.1:6379> HGETALL user:42
1) "name"
2) "Darth"
3) "email"
4) "darth@vader.com"
127.0.0.1:6379> HKEYS user:42
1) "name"
2) "email"
127.0.0.1:6379> HEXISTS user:42 email
(integer) 1
127.0.0.1:6379> HEXISTS user:42 altemail
(integer) 0
127.0.0.1:6379> HSET user:42 id 1
(integer) 1
127.0.0.1:6379> HGETALL
(error) ERR wrong number of arguments for 'hgetall' command
127.0.0.1:6379> HGETALL user:42
1) "name"
2) "Darth"
3) "email"
4) "darth@vader.com"
5) "id"
6) "1"
127.0.0.1:6379> HINCRBY user:42 id 123
(integer) 124
127.0.0.1:6379> HGETALL user:42
1) "name"
2) "Darth"
3) "email"
4) "darth@vader.com"
5) "id"
6) "124"
127.0.0.1:6379> HDEL user:42 id
(integer) 1
127.0.0.1:6379> HGETALL user:42
1) "name"
2) "Darth"
3) "email"
4) "darth@vader.com"
127.0.0.1:6379> 
127.0.0.1:6379> HLEN user:42
(integer) 2
127.0.0.1:6379> HGETALL user:42
1) "name"
2) "Darth"
3) "email"
4) "darth@vader.com"
127.0.0.1:6379> 
```
