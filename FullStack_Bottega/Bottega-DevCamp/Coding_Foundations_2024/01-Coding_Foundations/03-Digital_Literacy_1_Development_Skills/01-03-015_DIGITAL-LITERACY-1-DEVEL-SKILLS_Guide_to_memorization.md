# 3.15 Guide to Memorization

This lesson introduces a guide to memorization, with a focus on how to create a system for memorizing code when first learning a new programming language.

During a recent bootcamp teaching session where I was walking through a number of front-end development techniques, a student asked a great question. Referencing the CSS styles, she asked:

**“What is the best way to remember all of the specific style names and properties?”**

This is a **vital question** to answer, especially for new students. For example, if you look at the CSS documentation, you’ll find **thousands of potential style options**. If you’re learning these styles for the first time, that list can be pretty intimidating. And that doesn’t even bring in the idea of learning how the styles work together with applications as a whole!

Obviously, this issue does not only apply to CSS styles. When it comes to learning development, whether it’s a programming language or framework, you will be greeted with a **large amount of information** that you’ll need to memorize, or at least know where to reference it.

---

## Guide to Memorization

At first glance, this may seem like a **daunting task**. And many aspiring developers have given up on their learning journey because it seems like an **insurmountable challenge**. However, I’m here to tell you that it’s completely realistic for you to learn how to work with a large number of complex concepts. And if you follow the system I outline in this guide, you’ll be amazed at how quickly you pick up on memorizing more information than you ever thought possible.

---

### Repetition

Before I go into the memorization system I have used through the years, it’s important to say that **repetition is the key** to memorizing large amounts of information. None of the techniques I will give you are going to help if you don’t take the time to work through them **consistently**.

---

### Smarter, Not Harder

With that being said, it’s important to know that, by itself, repetition is a **slow and naive memory training technique**. As a development student, imagine that I hand you a list of a few hundred method names and tell you to memorize them. If you were to simply stare at the sheet of paper and try to memorize the names, how do you think you’d do? If you’re like me and the majority of the world, **probably not good**.

The reason why dry repetition isn’t a great way to memorize names is because it doesn’t give you a **frame of reference** for the names.

---

### Visual Mental Mapping

In the first memory technique, we’re going to walk through **visual mental mapping**.

Our minds are incredible at memorization. However, at the same time, our minds are also **picky** with how they store information. Let’s run a quick test. If I show you **15 random digits**, such as:

```python
234
348532
984
234523
34534
35234
234
25345
234
985
553
37434
740
423
9812
```

And I give you **5 seconds** to look at each number. How many of the numbers will you repeat back to me? Unless your name is **Dustin Hoffman** (Rainmaker movie reference… might be dating myself a bit on that one), then you probably won’t be able to name very many off.

However, what if I showed you the pictures of **15 celebrities**? Now, if I give you the same test as with the numbers, do you think you’d do a better job remembering the list of celebrities or the random numbers? Assuming you know who the celebrities are, you’d be able to repeat back a **significantly larger number** of celebrities than the numbers.

The reason for this difference is because you have a **frame of reference** for the celebrities, and in this exercise, you had a **visual reference**. By combining these two things, your brain was fully prepared to recite back a larger number of items from the second list.

With this knowledge in mind, we can apply the same principles for memorizing anything.

---

### Short Term vs Long Term Memory

Because our brains are **efficient machines**, they naturally sort information based on priority. You are most likely aware that you have **short-term** and **long-term memory**. This concept is the reason why you can instantly remember your second-grade teacher’s name decades later but may forget a new acquaintance’s name **30 seconds** after hearing it.

Typically, the brain doesn’t log knowledge into our **long-term memory bank** unless it thinks we’re going to need it in the future. This is kind of like how a computer works. If you add text to a document and save the file on the hard drive, that’s like storing information in the mind’s long-term memory. However, if you run a calculation in the terminal, the computer processes the information in memory and then discards it, which is like how our short-term memory system works.

---

### Implementing Visual Mental Mapping

So, when it comes to implementing the **Visual Mental Mapping** technique, we’re essentially **tricking our brains** into thinking that it needs to move a piece of information into long-term memory. In this process, we associate a **visual image** with the term that we want to memorize. A key prerequisite for this to work is that the visualization needs to be **relevant** to the term (or the behavior of the term).

Getting back to the developer’s initial question, let’s see how we can use visual mental mapping to memorize a CSS style. I’m going to use the **text-decoration** property as a case study. In the world of CSS, the **text-decoration** element allows you to add or remove an underline style to a piece of text.

With this in mind, I would create an image in my mind that would look something like this:

- **Decoration** to underlined text
- A **familiar image** to something abstract

By creating this visual image, I’ve mapped:

- **Decoration** to underlined text
- A **familiar image** to something abstract

And with this mental image in place, I don’t have to think about the term **text-decoration**. Instead, I will think of a **decorated fireplace** with underlined text sitting on the mantle. This visual is much easier for my brain to accept into long-term memory because it has a **direct frame of reference**. The **text-decoration** word is no longer a foreign element trying to invade my memory. Instead, it’s catching a ride on an image that already has a home in my long-term memory.

---

### Taking a Real-World Example

Sticking with our celebrity theme, imagine that you wanted to go to a private, VIP party in Hollywood. If you just try to show up, the bouncer at the door most likely **won’t let you in**. However, if you’re friends with **Brad Pitt** and you walk in together, you won’t have any issues attending the party.

**Visual mental mapping** follows the same principle. Our brains guard our long-term memory to ensure that our mind doesn’t get cluttered with useless information. For example, what if you logged every piece of information into your long-term memory that you come across each day? As you drive down the street to work, your brain captures millions of data points such as: street signs, people walking, etc. If your brain didn’t guard against useless information entering your long-term memory bank, all of this information would be treated with the same priority as your parent’s names. Obviously, this wouldn’t be a good idea!

So, our brains are like the **guard in the VIP Hollywood party**. And when we attach a new piece of information to something already logged in long-term memory, it’s like we’re having **Brad Pitt escort us into the party**.

---

### Finding Patterns

So, **Visual Mental Mapping** seems like a great idea. However, the idea of creating thousands of visualizations isn’t very practical. Which is why, when I’m learning a new programming language, I also focus on **picking up on patterns**. Returning to our case study of memorizing CSS elements, let’s take a look at the **border attributes** available in CSS3.

```sass
    border

    border-bottom

    border-bottom-color

    border-bottom-style

    border-bottom-width

    border-color

    border-left

    border-left-color

    border-left-style

    border-left-width

    border-radius

    border-right

    border-right-color

    border-right-style

    border-right-width

    border-style

    border-top

    border-top-color

    border-top-style

    border-top-width

    border-width
```

As you can see, there are **21 available attributes**. And that’s just for managing border styles on a webpage! As you can imagine, it would be pretty intimidating to memorize this list, especially when you realize that it’s only a very small percentage of the available CSS styles needed for development.

However, if you start to analyze the list, you’ll notice a number of **trends**. For example, there are a number of styles that simply reference: **top, bottom, left, and right**. These styles are simply ways for giving a border style to a specific side of an element. Additionally, you may also notice that each side also has a set of options for **color, style, and width**.

So, practically, if you know that these elements are all available to the **border set of elements**, this list can be shrunk down to **5 items**:

```sass
    border

    border-color

    border-radius

    border-style

    border-width
```

Which is **more manageable**.

---

### Copy/Paste is the Enemy

In addition to creating **Visual Mental Maps** and using patterns, I’m going to finish off the list of memorization techniques with the recommendation to **not copy and paste** new concepts that you’re trying to learn.

I first heard this advice from **Zed A. Shaw**, the author of the **Learn Hard programming book series**. He instructs his readers to not even look at the book at the same time that they’re implementing the code. He postulates that by **forcing yourself to type in the code** without referencing the documentation while typing, it forces the mind to actually **think through each keystroke**.

In my personal experience as a developer and with teaching, I’ve discovered a **significant difference** between the students that copied and pasted code or simply followed along with a tutorial, compared with the students that attempted (even unsuccessfully) to implement the code by themselves.

---

### Not Everything Has to Be Memorized

On a final note, I want to dispel a common fallacy. As a developer, **you don’t have to memorize every class and method** in order to build a project. Even professional programmers constantly **lookup documentation** on a regular basis. Instead of feeling like you have to memorize everything, focus on memorizing the terms that you use the most. This will make the memorization process more **practical and natural**.
