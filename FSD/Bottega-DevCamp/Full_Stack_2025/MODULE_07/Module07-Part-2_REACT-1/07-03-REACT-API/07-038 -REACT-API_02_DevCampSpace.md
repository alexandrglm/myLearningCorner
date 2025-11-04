# 07-038 - Overview of DevCamp Space

**Guide**: [Overview of DevCamp Space](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/overview-of-devcamp-space)

DevCamp Space link: [Space](https://www.devcamp.space/)

---

## Introduction to the DevCamp Space Platform

**Guide goals**:

- **Familiarise yourself** with the DevCamp Space interface

- **Add test data** for experimentation

- **Understand API data structure**

- **Prepare integration** with React application

## The Main Dashboard

**Key dashboard elements**:

- **Project list** — Portfolio will be our focus

- **Navigation** — Bottega logo or database icon to return

- **Settings** — gear icon for additional configurations

## Configuration Features

**Gear icon provides access to**:

- **API key** — credentials for authentication

- **White list links** — for deployment (future section)

- **Additional project settings**

---

## UNDERSTANDING APIs - SIMPLIFIED VERSION

## The Simplest Definition of API

**API in basic terms**:

- **URL** you visit (like Google or any website)

- **Server** responds with data (instead of HTML)

- **Communication** — you send requests, receive data

**Practical example**:

Your app → calls URL → devcamp.space/api/portfolio_items  
Server → responds with → JSON data of portfolio items

## Difference from Normal Websites

**Normal website**:

- URL → HTML + CSS → visual page

**API**:

- URL → JSON data → data for your application

## Why It Can Seem Intimidating

**Initial challenges**:

- **External server** — you have no control

- **Specific format** — you must send correct data

- **Variable responses** — errors, success, different formats

---

## 🛠️ PRACTICAL STEPS - EXPLORING DEVCAMP SPACE

## 1. Navigating to the Portfolio Project

**From the main dashboard**:

1. **Click “Portfolio”** — our main project

2. **See structure** — database tables and API endpoints

## 2. Examine Available Endpoints

**You will find**:

- **Portfolio Items endpoint** — to fetch all items

- **Individual item endpoint** — to fetch specific item

- **Create endpoint** — to add new items

- **Other endpoints** — will be added during the course

```
API Endpoints

GET All items  
https://api.devcamp.space/portfolio/portfolio_items  

GET One item  
https://api.devcamp.space/portfolio/portfolio_items/:id  

POST Create an item  
https://api.devcamp.space/portfolio/portfolio_items  
```

## 3. Access Portfolio Items Data

**Process**:

1. **Click "Portfolio Items"** in the list

2. **Click "View Data"** — see data table

3. **Observe columns** — database structure

## 4. Database Structure

**Available columns**:

- **ID** — unique identifier

- **Name** — title of the portfolio item

- **Description** — project description

- **URL** — link to the project

- **Category** — category (e.g., eCommerce, Enterprise)

- **Position** — display order

- **Images** — image files

---

## 📝 ADD TEST DATA

## First Portfolio Item

**Example data**:

```json
Name: Test Portfolio Item  
Description: Any description  
URL: https://google.com  
Category: enterprise  
Position: 1  
Images: [upload a file from your computer]  
```

**Process**:

1. **Fill the form** with test data

2. **Upload image** (any file for testing)

3. **Click "+" icon** — send to server

4. **Verify creation** — should appear in table

## Second Portfolio Item

**For more examples**:

```
Name: Second Test Item  
Description: Another test description  
URL: https://example.com  
Category: [your choice]  
Position: 2  
Images: [optional — can be empty]  
```

---

## 🔍 UNDERSTANDING JSON FORMAT

## Access API Endpoint

**How to see data as API**:

1. **Click tab "Portfolio"** (above)

2. **Click on the endpoint URL** — opens API-formatted data

3. **Examine JSON structure**

## Anatomy of JSON Response

**Typical structure**:

```json
[
  {
    "id": 1,
    "name": "Test Portfolio Item",
    "description": "Any description",
    "url": "https://google.com",
    "category": "enterprise",
    "position": 1,
    "portfolio_item_images": [
      {
        "url": "https://...",
        "id": 123
      }
    ]
  },
  {
    "id": 2,
    "name": "Second Test Item",
    // ... more properties
  }
]
```

## What is JSON?

**JSON** (JavaScript Object Notation):

- **Standard data format** for APIs

- **Similar to JavaScript objects**

- Supports **arrays and objects** - familiar structure

- **Readable** by humans and machines

## Key Elements in the Response

- **Brackets `[]`** — indicate an **array** of items

- **Objects `{}`** — each individual portfolio item

- **Properties** — name, description, url, category, etc.

- **Nested objects** — portfolio_item_images inside each item

---

## 🎨 REACT INTEGRATION PREVIEW

## Integration Plan

**What we will do next**:

1. **Call same URL** as seen in DevCamp Space

2. **Iterate over array** of portfolio items (like hardcoded data)

3. **Extract properties** — name, description, url, category

4. **Render on screen** — using existing React components

## Similarities with Hardcoded Data

**Current data** (hardcoded):

```jsx
this.state = {
  data: [
    { title: "Quip", category: "eCommerce" },
    { title: "Eventbrite", category: "Scheduling" }
  ]
};
```

**API data** :

```jsx
// Response from devcamp.space
[
  {
    name: "Test Portfolio Item",
    category: "enterprise",
    description: "...",
    url: "..."
  }
]
```

## Advantages of the Transition

**From hardcoded to API**:

- **Dynamic data** — changes reflected immediately

- **Real images** — not just text

- **Central administration** — updates from DevCamp Space

- **Scalability** — multiple apps can use the same data

---

## 📚 CONCEPT: CLIENT-SERVER COMMUNICATION

## Full Flow

* React App (Client) -> HTTP Request -> DevCamp Space (Server) <- JSON Response 

#### **Detailed steps**:

1. **React initiates** HTTP request to specific URL

2. **DevCamp Space receives** the request

3. **Database** is queried

4. **Server responds** with JSON data

5. **React receives** data and updates state

6. **UI re-renders** with new information

---

## Differences From Local Data

**Local data** (current method):

- **Instant** — no network delay

- **Predictable** — always the same result

- **Limited** — only what is hardcoded

**API data** (new method):

- **Network delay** — response time varies

- **Dynamic** — data may change between requests

- **Unlimited** — all data available on the server

---

## Functionality Testing

**Verify it works**:

1. **Items appear** in DevCamp Space table

2. **API endpoint** shows data in JSON format

3. **Images** are accessible (links working)

4. **Structure** is consistent across items