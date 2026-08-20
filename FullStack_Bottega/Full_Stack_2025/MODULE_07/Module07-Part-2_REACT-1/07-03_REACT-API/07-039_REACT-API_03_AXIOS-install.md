# 07-039 - Installing Axios and Basic Usage

##This lesson covers how to install the Axios HTTP client library in your React project, to perform API requests more efficiently than with the native fetch API.

---

## What is Axios?

- Promise-based HTTP client

- Works in browser and Node.js

- Supports request cancellation, interceptors, and automatic JSON transformations

- Simpler API than fetch, especially for POST requests with JSON payloads

---

## Installation

Run the following command in your project root:

```bash
npm install axios

# Or using yarn:
yarn add axios
```

---

## Importing Axios

In your React component or API utility file:

```jsx
import axios from 'axios';
```

---

## Basic GET Request with Axios

Example of fetching portfolio items:

```jsx
axios.get('https://api.devcamp.space/portfolio/portfolio_items')  
    .then(response => {  
        console.log(response.data);  
    })  
    .catch(error => {  
        console.error('API call error:', error);  
    });
```

---

## Setting State with Axios Data

Example in a React class component:

```jsx
constructor(props) {  
    super(props);  
    this.state = { portfolioItems: [] };  
}

componentDidMount() {  
    axios.get('https://api.devcamp.space/portfolio/portfolio_items')  
        .then(response => {  
            this.setState({ portfolioItems: response.data });  
        })  
        .catch(error => console.error(error));  
    }

---
```

---

## POST Request with Axios

Posting new portfolio item:

```jsx
const newItem = {  
    name: "My Project",  
    description: "Project description",  
    url: "(https://myproject.com",  
    category: "enterprise",  
    position: 1  
};

axios.post('https://api.devcamp.space/portfolio/portfolio_items', newItem)  
    .then(response => {  
        console.log('Created:', response.data);  
    })  
    .catch(error => {  
        console.error('Creation error:', error);  
    });
```

---

## Using Async/Await with Axios

Example:

```jsx
async componentDidMount() {  
    try {  
        const response = await axios.get('https://api.devcamp.space/portfolio/portfolio_items');  
        this.setState({ portfolioItems: response.data });  
    } catch (error) {  
        console.error(error);  
    }  
}
```

---

## Advantages of Axios

- Automatically transforms JSON

- Supports older browsers

- Intercepts requests and responses

- Easy cancellation of requests

---
