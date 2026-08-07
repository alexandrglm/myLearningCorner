# 07-037 - Introduction to the Section and DevCamp Space Registration

**Guide**: [Section Introduction and DevCamp Space Registration](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/section-introduction-devcamp-space-registration)

DevCamp Space link: [Space](https://www.devcamp.space/)

---

## 🎯 NEW SECTION: API COMMUNICATION AND DEVCAMP SPACE

## Fundamental Course Transition

**Current State**: Up to this point, the course has used **hardcoded data** directly in the application.

**New Goal**: Begin **communicating with external APIs** to fetch dynamic data.

## Why Is This Transition Critical?

**In real development**:

- **Small applications** — hardcoded data is acceptable at the beginning

- **Growing applications** — require external data

- **Standard process** — API communication becomes daily work

**Benefits of APIs**:

- **Dynamic data** — not limited to static information

- **Separation of concerns** — frontend and backend are independent

- **Scalability** — multiple applications can use the same API

- **Collaboration** — teams can work independently

---

## 🔗 FUNDAMENTAL CONCEPTS

## What is an API?

**API** (Application Programming Interface):

- A **direct communication channel** with an external application or server

- An **interface** defining how to interact with the external system

- A **protocol** to request and receive data

- A **bridge** between your React app and external services

## Objectives of This Section

**What we will learn**:

1. **Communicate with external APIs** — make HTTP requests

2. **Fetch portfolio items** from a real API

3. **Render dynamic data** on screen

4. **Create new items** using forms

5. **Handle forms** in React

## The Motivation of DevCamp Space

**Problem it solves**:

- **Real world environment** — simulates teamwork in development

- **API credentials** — practice with real authentication

- **Clean interface** — easy to see API data

- **Replicable process** — similar experience to professional work

---

## 🛠️ PRACTICAL STEPS - REGISTERING IN DEVCAMP SPACE

## 1. Access DevCamp Space

**URL**: [https://devcamp.space/](https://devcamp.space/)

## 2. Create a Free Account

**Information required**:

- **Email** — your email address

- **Subdomain** — important: use your name or unique identifier

- **Password** — secure password

- **Confirm Password** — confirmation

**⚠️ Subdomain considerations**:

- **No spaces** — use hyphens or underscores

- **Unique** — something personal like your name

- **Memorable** — will be used throughout the course

- **Example**: `juan-perez` or `my-portfolio`

## 3. Complete Registration

**Process**:

1. **Fill out the form** with required information

2. **Click “Register”** — create account

3. **Verify login** — confirm successful sign-in

## 4. First Exploration

**Next video will cover**:

- **Walkthrough of DevCamp Space system**

- **Main interface** — dashboard and features

- **Preparation** for React integration

---

## PURPOSE AND REAL CONTEXT

## Simulating a Work Environment

**Typical workplace scenario**:

1. **You are assigned a new React project**

2. **Your team gives you API credentials**

3. **You are told which endpoints are available**

4. **You integrate frontend with existing backend**

**DevCamp Space simulates**:

- Your own **API credentials**

- **Documented endpoints**

- **Real data** for working

- **Admin interface** to view data

## Difference with Hardcoded Data

**Hardcoded data** (previous method):

```jsx
this.state = {  
    data: [  
        { title: "Quip", category: "eCommerce" },  
        { title: "Eventbrite", category: "Scheduling" }  
    ]  
};
```



**API data** (new method):

```jsx
// A REAL API call
fetch('https://api.devcamp.space/portfolio_items')  
    .then(response => response.json())  
    .then(data => this.setState({ data }));
```

---

## 🎯 PREPARATIONS FOR THIS SECTION

## Tools We Will Use

**New technologies**:

- **Axios** — HTTP request library

- **DevCamp Space API** — backend for portfolio

- **Forms in React** — to create new items

- **Authentication** — user and permissions management

## Skills to Develop

**Technical skills**:

1. **HTTP Requests** — GET, POST, PUT, DELETE

2. **Async JavaScript** — Promises and async/await

3. **Error handling** — handling network errors

4. **Form management** — controlled components

5. **API integration** — connecting frontend and backend

## Section Roadmap

**Expected progression**:

1. **DevCamp Space registration and setup** ✓

2. **Platform overview** — next video

3. **Install Axios** — HTTP library

4. **First API call** — fetch portfolio items

5. **Organise code** — move API logic to components

6. **Render images** from API

7. **Forms to create new items**

8. **Authentication and permissions**