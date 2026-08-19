# 07-028: React Components 12 - Building a Data Filter

## Introduction

In this lesson, we build a dynamic filter feature in React to search and display data based on user input.   
Building a data filter enhances React apps with interactivity and dynamic data display, reinforcing core concepts of state, events, and rendering.

---

## Objectives

- Create a text input to accept user filter query  
- Filter the list of items dynamically as user types  
- Use React state to manage user input and filtered data  
- Learn how to handle arrays and events in React  

---

## Step 1: Initialize Component State

The component holds:

- `filterText`: current text from input  
- `data`: full list of items  
- `filteredData`: items matching the filter  

---

## Step 2: Create Filter Input

Create an input element with an `onChange` event handler updating `filterText` in state.

---

## Step 3: Filter Logic

Implement a function to filter `data` based on `filterText` (case insensitive).

Example:

```jsx
filterData() {
  
  return this.state.data.filter(item =>
    
    item.name.toLowerCase().includes(this.state.filterText.toLowerCase())
  );
}
```


---

## Step 4: Render Filtered Data

Use `filterData()` in render method to display matching items dynamically.

---

## Full Component Example

```jsx
class FilterContainer extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      filterText: '',
      data: [
        { name: 'Apple' },
        { name: 'Banana' },
        { name: 'Cherry' },
        { name: 'Date' },
        { name: 'Elderberry' }
      ]
    };
    this.handleFilterChange = this.handleFilterChange.bind(this);
  }

  handleFilterChange(e) {
    this.setState({ filterText: e.target.value });
  }

  filterData() {
    return this.state.data.filter(item =>
      item.name.toLowerCase().includes(this.state.filterText.toLowerCase())
    );
  }

  render() {
    const filteredList = this.filterData();
    return (
      <div>
        <h1>Fruits Filter</h1>
        <input
          type="text"
          placeholder="Filter fruits"
          value={this.state.filterText}
          onChange={this.handleFilterChange}
        />
        <ul>
          {filteredList.map(item => (
            <li key={item.name}>{item.name}</li>
          ))}
        </ul>
      </div>
    );
  }
}
```


---
