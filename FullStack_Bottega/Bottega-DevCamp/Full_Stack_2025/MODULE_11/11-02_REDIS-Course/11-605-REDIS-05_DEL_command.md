# 11-605    REDIS 05    DEL command

[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/guide-deleting-redis-del-command)

## Video Lesson Speech

In this guide, we're going to walk through how to delete items inside of redis. Now this is going to be one of the most standard ways of being able to delete records. 

---
We're going to first start off with setting some things, so I'm going to say first name and pass in Jordan that has set it now so that's working. And then I'll set my last name and then I'll also set a middle name just so we have three items to be able to work with.

```redis
127.0.0.1:6379> SET first_name "Jordan"
OK
127.0.0.1:6379> SET last_name "Hudgens"
OK
127.0.0.1:6379> SET middle_name "David"
OK
```
So now with each one of those now we can delete any of them. One of the nice things about the delete command is we can actually delete multiple items at the same time. This makes it nice and efficient when you need to do something such as perform a batch delete. 

You can tell this by right here in the `cli` where it says key and then is followed with this set of brackets with key and then dot dot dot. What that means is you can pass as many keys as you want. And that's the reason why it created a number of them. So here I can say delete first name space last name and then you can see it returns the number 2, which means it deleted two items. 

```redis
127.0.0.1:6379> DEL first_name last_name
(integer) 2
```
And now if I try to get one of those if I try to get the first name it'll return nil. Please note once again it doesn't return an error. It doesn't say it doesn't exist. It simply says nil.

The reason why I keep on mentioning that is because in your development when you're working with redis there may be times where you set some type of key and then you go to retrieve it and it returns a nil value. That can mean two things in an application. It can mean either that you didn't actually set the key properly. In other words, you thought that you set it but it turns out that it actually never saved to the database. That's one way of getting a nil value when you call it back or it got deleted. This is something that definitely can be a challenging part when you are working with different databases like redis where they are so fast and they're not going to give you that same access to be able to have that error checking. And some of the things that you maybe were used to if you're using a traditional sequel database. If you call a sequel database and ask for a column that doesn't exist it is going to give you an error and tell you that it doesn't exist, and then you would know what the bug was. Here you are going to get a nil, no matter what. It's nice because it's not going to throw a bunch of nasty errors at you. But it can be confusing because sometimes when you ask for some type of different key that you thought you had set and you get a nil value you have to make sure that it was saved in the first place just kind of a quick reminder.

I will take these kind of step asides throughout the course and throughout all the courses I teach when there has been something that I personally have struggled with in my own development projects just so you can kind of be prepared for that. And so that is a little bit of a side from just being able to delete an item the syntax for that is pretty straightforward just like this. The key to remember is that you can pass multiple items to the delete command and then it returns the number of elements that were deleted.



## Code

```
127.0.0.1:6379> SET first_name "Jordan"
OK
127.0.0.1:6379> SET last_name "Hudgens"
OK
127.0.0.1:6379> SET middle_name "David"
OK
127.0.0.1:6379> DEL first_name last_name
(integer) 2
127.0.0.1:6379> GET first_name
(nil)
127.0.0.1:6379> GET last_name
(nil)
127.0.0.1:6379> GET middle_name
"David"
127.0.0.1:6379> DEL middle_name
(integer) 1
```
