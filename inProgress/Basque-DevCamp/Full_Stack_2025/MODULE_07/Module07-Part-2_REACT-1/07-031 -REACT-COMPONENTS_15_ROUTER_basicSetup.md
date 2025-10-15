# 07-031: React Components 15 - Router Basic Setup

## Introduction

This lesson covers the basics of setting up routing in a React application using React Router.  
React Router integrates routing into React apps, enabling seamless navigation and route-based rendering.

---

## What is React Router?

React Router is a library that enables navigation among views in a React app, changing the browser URL and keeping UI in sync.

---

## Installation

Install React Router DOM:

```bash
npm install react-router-dom --save
```
---

## Core Concepts

- BrowserRouter: Wraps the app and enables routing  
- Route: Defines a route with a path and component  
- Link: Declarative navigation without page reloads  
- Switch/Routes: Renders the first matching route (v5 vs v6)  

---

## Basic Setup

Wrap your app component with BrowserRouter:

```jsx
<BrowserRouter>
  <App />
</BrowserRouter>
```

---

## Defining Routes

Inside your main App component:
```jsx
<Routes>
  <Route path="/" element={<Home />} />
  <Route path="/about" element={<About />} />
  <Route path="/contact" element={<Contact />} />
</Routes>
```
---

## Using Link Components

Replace anchor tags (`<a>`) with `<Link>` for client-side navigation:

```jsx
<Link to="/about">About Us</Link>
```
---

## Dynamic Routing

Use path parameters:

```jsx
<Route path="/profile/:userId" element={<Profile />} />
``` 

Access params in component via `useParams()` hook.

---

## Redirects and Not Found

- Redirect with `<Navigate to="/" />` (v6) or `<Redirect />` (v5)  
- Handle 404 with a catch-all route:
```jsx
<Route path="*" element={<NotFound />} />
```
---

## Example Structure

- `index.js`: Wraps App in BrowserRouter  
- `App.js`: Contains Routes definitions  
- Components for each page, e.g., Home, About, Contact  



---
