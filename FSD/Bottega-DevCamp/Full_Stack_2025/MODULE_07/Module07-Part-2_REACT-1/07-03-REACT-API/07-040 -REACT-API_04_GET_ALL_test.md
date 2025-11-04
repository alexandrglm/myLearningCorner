# 07-040 - Making the Initial API GET Request in React

**Guide**: [https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/making-initial-api-get-request-react](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/making-initial-api-get-request-react)

**Source Code**: [https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/ccec44651066cc653517d2bb5f024b4f6819ebf2](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/ccec44651066cc653517d2bb5f024b4f6819ebf2)

---

## 🎯 FUNDAMENTAL CONCEPTS

### The Key Shift: Local → API

**Fundamental transition**:

* **Local application** → **Communication with external server**
* **Hardcoded data** → **Dynamic API data**
* **Functionality** like modern web/mobile apps

### Learning Methodology

**Educational approach**:

* **Use real documentation** from Axios
* **Do not memorise** tutorial code
* **Learn how to research** new libraries
* **Transferable process** to any technology

### Security and Endpoint Types

**Public endpoints** (like portfolio items):

* **No authentication required**
* **Safe for GET requests**
* **Ideal first example**

**Private endpoints** (create/edit/delete):

* **Require authentication**
* **Potential security risk**
* **Will be implemented later**

---

## 🔍 USING AXIOS DOCUMENTATION

### Accessing Official Documentation

**Research process**:

1. Go to Axios documentation
2. Search for **example** after installation
3. **Copy sample code**
4. **Adapt** to your project

### Base Code from Documentation

```javascript
axios.get('/user?ID=12345')
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
```

**Why this example works**:

* **GET request** (what we need)
* **Promise-based**
* **Handles errors**
* **Console logging** for debugging

---

## 🛠️ PRACTICAL IMPLEMENTATION STEPS

### 1. Import Axios in App.js

```javascript
import axios from 'axios';
```

### 2. Create getPortfolioItems Function

```javascript
getPortfolioItems() {
  axios.get('https://api.devcamp.space/portfolio/portfolio_items')
    .then(response => {
      console.log("response data", response);
    })
    .catch(error => {
      console.log(error);
    });
}
```

**Use arrow functions** to preserve `this`.

### 3. Get Your DevCamp Space URL

Pattern:

```
https://YOUR-SUBDOMAIN.devcamp.space/portfolio/portfolio_items
```

### 4. Add Constructor Binding

```javascript
constructor() {
  super();
  this.getPortfolioItems = this.getPortfolioItems.bind(this);
}
```

### 5. Call Function in Render (Temporary)

```javascript
render() {
  this.getPortfolioItems();

  return (
    <div className="app"></div>
  );
}
```

---

## 📊 VERIFYING DATA

### Browser Testing

1. Open developer console
2. Reload page
3. Check for logged response

Expected:

```javascript
{
  data: [ { id, name, description, ... } ],
  status: 200
}
```

---

## 🔧 IMPORTANT TECHNICAL CONCEPTS

### Arrow Functions vs Regular Functions

Arrow functions keep correct `this` context.

### Constructor Binding

Ensures custom methods can access `this.state` and `this.setState`.

### Temporary Render Call

Used only to verify request works.

---

