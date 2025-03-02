## Module 03 - 111: Python - Importing a Single Function from a Module

****

## Video lesson Speech

So far in this section, whenever we've imported a module, we've had to explicitly define that module and call it whenever we wanted access to the functions.

****

For example, here we imported the `helper` module, and when we wanted access to the `greeting` function inside of that module, we had to call `helper.greeting`.

![large](./03-111_IMG1.png)

If I open up the REPL right here and go back to our `math` example just to review, if I say `import math` and then I want the square root, I have to say `math.sqrt` and then pass in the value. That's how I can have access to the functions inside of that module.

However, what happens if you already know the function name that you want access to, and you only want to access that one function? You don't care about the rest of the library. Well, we can use a slightly different syntax with our import to make that work, and it makes our code even cleaner and more explicit. So, I can say `from math import sqrt`.

In review, what we have here is instead of just saying `import math`, which imports the entire `math` library, we're saying **from the `math` library, I only want you to import the `sqrt` function**. Now, if I hit return, we have imported only the `sqrt` function, and what we can do is actually just call `sqrt` by itself. I don't have to say `math.sqrt`.

Now, it works, and it has a much cleaner syntax. If I close this down and go back to our example where we have our `libs` directory that has our `helper` module inside of it, I'm going to use the same syntax here. So, at the very beginning of this line, instead of saying `import helper`, I'm going to say `from helper import greeting`.

```python
from helper import greeting
```

So, it's only going to bring in that one `greeting` function.

Now, I can get rid of the `helper` call, save the file, and if I run `python main.py`, you can see that we have identical behavior, but now our file is much easier to read.

We don't have that ugly `helper.greeting` type of syntax. So, whenever you are bringing in some type of module 
and you know that you only want a single function from it, you can use 
this syntax, and it is a little bit easier to work with.

****

## Code

```python
from math import sqrt

sqrt(4)

import sys
sys.path.insert(0, './libs')
from helper import greeting

def render():
 print(greeting('Tiffany', 'Hudgens'))
render()
```
