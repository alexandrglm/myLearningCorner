# MODULE 03 - 082: Python - Loop through a String



****

## Video lesson Speech

This is going to be a quick guide where we walk through how we can extend our knowledge of looping in python and we see that the for in loop can also be used with strings.

****

So if I have a string that contains a portion of the alphabet. I could say alphabet and inside of that put abcdef.

```python
alphabet = 'abcdef'
```

If I want to loop through each one of those items a 4 in the loop allows me to access them just like they were in a collection because if you think about it a string is really just a collection of characters so it's almost like you can think about a string is a list in a sense. 


When it comes to iterating over it so I could think of the first element being the character a, the second one being the Character b and so on and so forth and so with that in mind it means that we can do something like:

```python
for letter in alphabet:

```

Then, I can simply print this out so I can say print letter just like this.

```python
print(letter)
```

Finally, if I run this you can see that it prints out each one of the elements exactly like how we walk through with the data collections.

![large](./03-081_IMG1.png)



****

## Code

```python
alphabet = 'abcdef'

for letter in alphabet:
 print(letter)
```
