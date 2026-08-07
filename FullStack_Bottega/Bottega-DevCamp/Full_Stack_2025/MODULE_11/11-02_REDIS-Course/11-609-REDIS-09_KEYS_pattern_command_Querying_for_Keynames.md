# 11-609    REDIS 09    KEYS pattern command, How to Query for Keynames

[Guide](https://devcamp.com/trails/redis-course/campsites/redis-commands/guides/how-to-query-key-names-keys-pattern-command-redis)

## Video Lesson Speech

So far in this course, we've talked quite a bit about how we can work with keys inside of redis. However one thing we haven't really talked about is how we can search for keys. 

---

That's something that as you go through and start building out applications that utilize Redis you're probably at some point or another going to need to run some type of query on key's and so that's what we can do with the KEYS command and we have three main options that we can use. So the first one is called Keys star(*). If I run keys star what it's going to do, is it's going to bring out all of the various keys that I've built now and that I've added in the database in this course and also just when I've been testing a few things out.

```
127.0.0.1:6379> KEYS *
 1) "user:123"
 2) "post_like_count:42"
 3) "105:guide_like_count"
 4) "post_id"
 5) "105:post_like_count"
 6) "title"
 7) "asdfasdfasdf"
 8) "page_name"
 9) "current_batter"
10) "user:42"
11) "middle_name"
```
You can see each one of the 11 keys here and it brings them in a list format. It doesn't bring the value but once we have one of these now we can then go and query it. So the main reason I would ever use a Key's Star Command is mainly in the type of debugging session that I'd have if I have some type of weird situation where I thought I had a key but then find out that for some reason or another it wasn't there. So keys star will just bring all of them there and I can go through them. 

Now that's one way of doing it. However, if you're building out a giant application you might very well have thousands, tens of thousands, or millions of keys and so keys star is not going to be the best option. However, if you're familiar and you know part of the name, so that is something that is a more realistic kind of query so you can see that we have a few spots where we say user, we have somewhere we say name, we have some that say post. So what we could do is say that I want to bring all of the keys that just mentioned post. What I can run is a query where we say keys star and then I just write post followed by another star and if I run this now it has narrowed it down. 

```
127.0.0.1:6379> KEYS *post*
1) "post_like_count:42"
2) "post_id"
3) "105:post_like_count"
```
What the pattern in the middle of those items are, is it's a regular expression where I can pass these values in and then it will go and you'll say I want to find any spot, it posts might start in the beginning, might be in the middle, might be at the end. And I want you to bring back any keys that have the word post in it. If I did the same thing for a user then I'd bring back all of the keys that have the word user in it. 

```
127.0.0.1:6379> KEYS *user*
1) "user:123"
2) "user:42"
```
So that's something that can be very handy. Now that is when you know quite a bit of the word that you're searching for and that you're trying to query for. 

Now there are other times where maybe you don't really know the entire setup or maybe you know that it's going to for sure start with a certain set of letters. If I created a key here and said set myusername and just type Jordan like this and then run this key user then it's going to bring this back.

```
127.0.0.1:6379> SET myusername 'jordan'
OK
127.0.0.1:6379> KEYS *user*
1) "user:123"
2) "myusername"
3) "user:42"
```
However, let's imagine that we're building out a query where we only want to match the pattern where users start at the beginning, not in the middle, or the end, or at any other spot. What we can do there is I can say Keys and then I can say a user. And then I can do either a star if I'm wanting to search for just the ones where it's beginning or if I had some type of pattern where I knew that I wanted to bring back all of the relevant items that had four characters after user I could

```
127.0.0.1:6379> KEYS user????
1) "user:123"
```
And then that would bring back only that one element. 

So there are some very powerful kinds of queries and techniques and commands that are available inside of red as these are some of the most common ones, these are ones that I use relatively often. The one that I probably use the very most is going to be either this one where I have the star on one side or where I have the star on both sides because this is probably the closest thing to what you would assume would be a traditional type of query where you can just pass in some type of pattern and then it'll bring it back whether it's at the beginning the middle or the end. But that is how you can use the keys command inside of Redis to query for various keywords.



## Code

```
127.0.0.1:6379> KEYS *
 1) "user:123"
 2) "post_like_count:42"
 3) "105:guide_like_count"
 4) "post_id"
 5) "105:post_like_count"
 6) "title"
 7) "asdfasdfasdf"
 8) "page_name"
 9) "current_batter"
10) "user:42"
11) "middle_name"
127.0.0.1:6379> KEYS *post*
1) "post_like_count:42"
2) "post_id"
3) "105:post_like_count"
127.0.0.1:6379> KEYS *user*
1) "user:123"
2) "user:42"
127.0.0.1:6379> SET myusername 'jordan'
OK
127.0.0.1:6379> KEYS *user*
1) "user:123"
2) "myusername"
3) "user:42"
127.0.0.1:6379> KEYS user*
1) "user:123"
2) "user:42"
127.0.0.1:6379> KEYS user????
1) "user:123"
```
