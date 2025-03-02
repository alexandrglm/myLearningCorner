## MODULE 03 - 112: Python - Importing a Module and Assigning Aliases

---

## 🎯 Introduction

When importing modules in Python, we typically call their functions by referencing the full module name. However, some module names can be long or repetitive, making code less readable. To improve clarity and efficiency, Python allows us to **assign aliases** to modules using the `as` keyword.

Aliasing is particularly useful when working with:

- **Modules with long names** (e.g., `import matplotlib.pyplot as plt`).
- **Frequently used modules** (e.g., `import numpy as np`).
- **Custom modules** where a shorter reference improves readability.

🔗 **Reference:** [Python Import System](https://docs.python.org/3/reference/import.html)

---

## 🔹 Standard Module Import

By default, when we import a module, we must reference it using its full name:

```
import helper
helper.greeting()
```

📌 **What Happens?**

- The `helper` module is fully imported.
- To use its functions, we must prefix them with `helper.`.

While this works, **it can become cumbersome** when working with long module names or frequently calling functions from the same module.

---

## 🔹 Using Aliases with `as`

To streamline our code, we can assign an **alias** to a module using the `as` keyword.

### ✅ Example: Assigning an Alias to a Custom Module

```
import helper as h
h.greeting("Tiffany", "Hudgens")
```

📌 **What Changes?**

- Instead of writing `helper.greeting()`, we now use `h.greeting()`.
- The alias `h` is a **shorter and more readable reference**.

🔗 **Reference:** [Python Modules](https://docs.python.org/3/tutorial/modules.html)

---

## 🔹 Aliasing Built-in Modules

Aliasing is not limited to custom modules; it is widely used with **built-in and third-party modules**.

### ✅ Example: Importing `math` as an Alias

```
import math as m
print(m.sqrt(4))
```

📌 **What Happens?**

- Instead of `math.sqrt(4)`, we can now use `m.sqrt(4)`.
- The alias `m` makes the code **shorter while maintaining clarity**.

🔗 **Reference:** [Python `math` Module](https://docs.python.org/3/library/math.html)

---

## 🔹 Best Practices for Aliases

✅ **Use common conventions** → Some libraries have well-established aliasing patterns:

- `import numpy as np`
- `import pandas as pd`
- `import matplotlib.pyplot as plt`

✅ **Keep aliases intuitive** → Avoid cryptic or misleading aliases (e.g., `import math as xyz`).

✅ **Ensure readability** → The alias should make the code **clearer, not more confusing**.

---

## 📌 Summary

- **Importing with aliases** makes function calls shorter and improves readability.
- The `as` keyword allows us to assign a **custom name** to a module.
- Aliasing is commonly used with **both built-in and third-party libraries**.
- Following aliasing conventions helps maintain **consistency across projects**.



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
