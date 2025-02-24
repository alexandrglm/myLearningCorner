# MODULE 03 - 083: Python - Loop Through a String

### Understanding String Iteration

In Python, a string is essentially a collection of characters. This allows us to iterate over a string just like we do with lists, tuples, or other iterable collections.

### Example String

```python
text = "abcdef"
```

### Using a For Loop to Iterate Through the String

The `for` loop allows us to access each character one by one.

```python
for char in text:
    print(char)  # Output: Each character in 'text' printed on a new line.
```

#### How It Works:

- The loop assigns each character in the string to `char`.
- The `print` function prints each character on a separate line.

---

### Practical Use Cases

- Counting specific characters in a string
- Searching for vowels or consonants
- Transforming characters (e.g., converting to uppercase)

#### Example: Convert Each Character to Uppercase

```python
for char in text:
    print(char.upper())
```

#### Example: Counting the Number of 'a' in the String

```python
count_a = 0
for char in text:
    if char == 'a':
        count_a += 1
print(f"The letter 'a' appears {count_a} times.")
```

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

![large](./03-083_IMG1.png)

****

## Code

```python
alphabet = 'abcdef'

for letter in alphabet:
 print(letter)
```

****

## Code Exercise

Prompt: Create a variable called "name" and assign it your name as a string.   
Write a for in loop that iterates through the string and prints each character.  

```python
def loop_over_string():
    # Write your code here


    return name
```
