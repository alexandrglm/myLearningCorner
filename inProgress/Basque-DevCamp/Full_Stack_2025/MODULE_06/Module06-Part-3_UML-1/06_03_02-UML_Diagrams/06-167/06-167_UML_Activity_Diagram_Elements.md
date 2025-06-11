# MODULE 06 - 167    UML

## Activity Diagram Elements

---

---

## Video Lesson Speech

In this section of the course we're going to talk about UML activity 
diagrams. In this guide we're going to start with an overview, then 
we're going to dissect each element of an activity diagram to see how 
they are represented.

---

In the next guide, we're going to walk through a full project.

We have seven different elements. 

- Initial state or Start Point
- Activity or Action State
- Action Flow
- Decisions and Branching
- Guards
- Final State or End Point
- Swim Lanes

![large](./06-167_IMG1.png)

We have an initial state represented by that thick circle that has the white circle in the middle of it. in an activity diagram, this is how you represent how a user or system will begin. We have a teacher that is going to assign a test or a quiz, all of these examples for the activity diagram are going to be for a grading system. This is going to be the initial state or start point.

![large](./06-167_IMG2.png)

The next portion is the activity or the action state. This is a pretty significant portion of an activity diagram, each box is an activity or it is a state. Another syntax, depending on the UML tool that you're using, will have rounded edges for each of these states. 

For this example, generating an individual question set, confirming, and asking a question are various actions states that the system can utilize. The easiest way to think about this is, imagine you're the user and you're traversing down each stage of these elements, every time you get to the spot where the data changes or you're going to make an alteration, that could be a potential state. That is a pretty important thing to see when you see activity diagrams the majority of the diagram is filled up with these activities. 

![large](./06-167_IMG3.png)

The next item is the action flow. As you may have noticed we didn't actually change anything in the diagram, that's because the activity diagram action flows are all right here. Anytime you see a filled-in arrow tip, that is an action flow. It means that we took a piece of data and took it from one action state to another action state and this action flow is how they're connected. When you confirm and ask a question, that is an action flow. It's easy to remember, something is flowing from one state to another one. 

![medium](./06-167_IMG4.png)

The next item on the list is decisions (also called branching). You see in the example there is a 45-degree diamond square, which is called a branch point or a decision. That represents a stage in the application where a decision has to be made. In this case, it's asking the question "was it last?" If so, it's going to perform one action, if not it's going to perform a different action. That's how you can understand branching which leads perfectly into guards. 

![medium](./06-167_IMG5.png)

Guards are the "no" or "yes" options. This is straightforward for simple conditions, however, there may be times where it's going to be more complex and have several conditions.

If you get into a situation where you have many potential branches from one activity, you may want to think your design through. The more branches or guards that we have, the higher the level of complexity. That means if you go back to change something in that process, you're going to have to populate that change throughout the entire system

![medium](./06-167_IMG6.png)

Now the next point is our final state. Most of the time you're going to have a final state and the UML specification says that every activity diagram should have a final state. In this sense, it is simply going to store the result inside of the system database and that's it. 

The syntax for this is going to be an action flow from one activity to the final endpoint. It's going to have an arrow pointing to a large circle with a smaller black circle in the middle, which represents that you've come to the end of that activity. 

![large](./06-167_IMG7.png)

This is what is called the swim lane. In the example, we have a quiz that is the activity diagram, inside of that we have swim lanes. In this case, we have a teacher, system, and student. 

This represents a way of organizing each of the activities

- we know when a teacher should be for performing a task 
- when a system/server should be performing a task
- when a student should be performing a task

This is helpful the more complex a system gets, the more actors in the process, you want to organize the entire system this way. At a simple glance, anyone will be able to see what the teacher can do, what the system can do, and what roles and responsibilities the student is going to have. 

Now that we've covered each of the major elements of an activity diagram, we're going to put all of them together to build the entire system. 
