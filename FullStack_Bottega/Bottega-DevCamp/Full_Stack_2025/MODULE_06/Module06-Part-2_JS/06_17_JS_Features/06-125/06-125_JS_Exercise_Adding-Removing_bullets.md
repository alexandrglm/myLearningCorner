# Module 06 - 125:    JS Applied Exercises

## Adding / Removing bullets

---

****

## Video Lesson Speech

For the section's project we have something pretty fun. So what we have here and this is some starter code that you can grab, it's just basic vanilla HTML. It contains as you can see on the right hand side a couple headings and then has a `<ul>` tag and a number of list items inside of the pending to-do's. Then below that you have this completed to do section and you can see that what we have here is a `<h2>` heading that says completed to-do's. Then right below that we have a `<ul>` tag called, completed to-do wrapper and then inside of it we have completed footer. 

So for this project to what you are tasked to do is to build out using just vanilla javascript, the ability to on these completed to-do views, come here and click on each one of these items or any that you want and have that item deleted. So have it removed completely from the DOM. So don't just hide it the visibility or anything like that. Have it completely removed from the DOM and then create it. 

Down here in the completed to do section. So what you should end up with if you clicked on each one of these five items here is pending you should be completely empty and if you look at it's `<ul>` tag it should have no `<li>` items and then completed to-do should have 5 `<li>` items that were all added. 

So good luck as you go through that and I will see you in the solution!

## Starter Code

```html
<!DOCTYPE html>
<html lang='en'>

<head>
  <meta charset='UTF-8'>
  <title></title>

  <style>
    .todoItem:hover {
      cursor: pointer;
    }
  </style>
</head>

<body>
  <div class="todos">
    <h2>Pending Todos</h2>
    <ul>
      <li class="todoItem">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Culpa, animi.</li>
      <li class="todoItem">Numquam dolor quo alias nam vel voluptates magni magnam quisquam.</li>
      <li class="todoItem">Recusandae eaque quisquam facere ab reprehenderit cupiditate magni placeat quis?</li>
      <li class="todoItem">Expedita asperiores nam saepe voluptatem, nostrum aliquid debitis quam recusandae.</li>
      <li class="todoItem">Quaerat velit deserunt reprehenderit, vel placeat impedit accusamus non, deleniti!</li>
    </ul>
  </div>

  <h2>Completed Todos</h2>
  <ul class="completedTodoWrapper">
    <div class="completed"></div>
  </ul>
</body>

<script>
</script>

</html>
```
