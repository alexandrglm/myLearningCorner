# 07-020: React Components 04 - Custom Functions and Using map() to Loop Over Data

**Guide**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/custom-functions-in-react-using-map-loop-over-data

**Source Code**: [Here](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/79352eb8d9c34cf16b67810fb01a8296f9a33e22)

---

## Fundamental Concepts

### Why Use Custom Functions?

Instead of writing all logic inside the `render()` method, we create **separate functions** for:

- **Organisation**: Cleaner and more readable code  
- **Reusability**: Same logic used in multiple places  
- **Maintenance**: Easier to debug and modify  
- **Separation of responsibilities**: `render()` only for JSX  

### The map() Method in React

**map()** is the standard method to iterate arrays in React because:

- **Returns a new array** (does not modify the original)  
- **Works perfectly with JSX**  
- **Automatic key props** for each element  
- **More functional** than traditional for loops  

### Pattern of Custom Functions

```js
// Custom function  
portfolioItems() {  
  return this.state.data.map(item => {  
    return <div key={item.title}>{item.title}</div>;  
  });  
}  

// Call in render  
render() {  
  return (  
    <div>  
      {this.portfolioItems()}  
    </div>  
  );  
}
```

### Advantages vs Inline Logic

#### NOPE! -> Logic in render():

```js
render() {  
  return (  
    <div>  
      {this.state.data.map(item => <div key={item.title}>{item.title}</div>)}  
    </div>  
  );  
}
```

#### YES! -> Custom function (better):

```js
portfolioItems() {  
  return this.state.data.map(item => {  
    return <div key={item.title}>{item.title}</div>;  
  });  
}  

render() {  
  return <div>{this.portfolioItems()}</div>;  
}
```

---

## Practical Steps

### 1. Refactor PortfolioContainer

File: `src/components/portfolio-container.js`

```js
import React, { Component } from 'react';

export default class PortfolioContainer extends Component {  
  constructor(props) {  
    super(props);  
  
    this.state = {  
      pageTitle: "Welcome to my portfolio",  
      data: [  
        { title: "Quip" },  
        { title: "Eventbrite" },   
        { title: "Ministry Safe" },  
        { title: "SwingAway" }  
      ]  
    };  
  }  
  
  portfolioItems() {  
    return this.state.data.map(item => {  
      return (  
        <div key={item.title}>  
          {item.title}  
        </div>  
      );  
    });  
  }  
  
  render() {  
    return (  
      <div>  
        <h2>{this.state.pageTitle}</h2>  
        {this.portfolioItems()}  
      </div>  
    );  
  }  
}
```

### 2. Verify Refactor

- Run `npm start`  
- Confirm visually no changes  
- Verify 4 items still render in DevTools  
- Identical functionality with better organisation  

### 3. Experiment with Function

Add temporary console.log to understand flow:

```js
portfolioItems() {  
  
  console.log("portfolioItems function called");  
  
  return this.state.data.map(item => {  
    console.log("Processing item:", item.title);  
    return <div key={item.title}>{item.title}</div>;  
  });  

}
```


### 4. Additional Testing

- Open DevTools → Console  
- Verify function runs once per render  
- See each item processed individually  


### 5. Clean and Commit

```js
// Remove console.logs  
portfolioItems() {  
  return this.state.data.map(item => {  
    return <div key={item.title}>{item.title}</div>;  
  });  
}
```


---
