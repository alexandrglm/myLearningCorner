# Module 03 - 112: Python - Importing a Module and Assigning Aliases

****

## Video Lesson Speech

In this lesson, we're going to walk through how we can alias our import statements in Python. 

****

I switched back to our `main` file right here to import `helper` just by itself, so it's going to bring in the entire `helper` module. As you remember, whenever we want to call one of the functions inside of `helper`, we need to call the full name of the module. So, we need to call `helper.` and then the function name.

If I switch down here and run this code, you can see that this works.

![large](./03-112_IMG1.png)

Now, I'm going to switch back up to the file, and the way that you can use an alias is you can use the exact same syntax. So, you say `import`, then the name of the module, and then say `as`. After that, you can use anything that you want, assuming it's not a reserved word. So, you can't use something like `for`, `class`, `def`, or anything like that. But if you want to say `import helper as h`, then you can come down here and instead of saying `helper.greeting`, you can just say `h.greeting`. If I save this file and come back down here to run it, you can see that it still works properly.

![large](./03-112_IMG2.png)

Now, I can run the exact same process with any of the other code libraries. If I open up the REPL, I can import the `math` library as `m`. Then, if I want to pull in the square root function, I can say:

```python
m.sqrt(4)
```

Run it, and you can see it works exactly the same way as when we used to have to spell out `math` entirely.

![large](./03-112_IMG3.png)

This is going to be a pattern that you'll see in a number of Python programs, especially ones that have very large module names.   

This is a way where you can streamline it and still make it clear on exactly what 
you are trying to call when you call those functions.

****

## Code

```python
import sys
sys.path.insert(0, './libs')
import helper as h

def render():
    print(h.greeting('Tiffany', 'Hudgens'))


render()


import math as m

m.sqrt(4)
```
