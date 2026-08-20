# 07-032: React Components 16 - Nav Links with Router

## Introduction

This lesson covers creating navigation links using React Router NavLink component for declarative client-side routing. NavLink enhances navigation menus with active state styling, improving UX in React Router-based applications.

---

## NavLink vs Link

- Both provide clickable navigation without page reload  
- NavLink adds styling attributes when active (e.g., CSS class)  
- Useful for menus, tabs, highlighting active routes

---

## Basic Usage of NavLink

Import NavLink from react-router-dom:

```jsx
import { NavLink } from 'react-router-dom';
```

Use NavLink instead of Link:

```jsx
<NavLink to="/" activeClassName="active-link">
  Home
</NavLink>
```
---

## Active Styling

- `activeClassName` provides CSS class when route matches  
- `activeStyle` applies inline styles when active  
- Supports exact matching to avoid partial matches  

---

## Example Navigation Bar

```jsx
<nav>
  <NavLink to="/" exact activeClassName="active">Home</NavLink>
  <NavLink to="/about" activeClassName="active">About</NavLink>
  <NavLink to="/contact" activeClassName="active">Contact</NavLink>
</nav>
```
---

## Customising Active Logic

You can customise when a NavLink is active by using `isActive` prop function:

```jsx
<NavLink  
  to="/profile"  
  isActive={(match, location) => {  
    return location.pathname.startsWith('/profile');  
  }}  
  activeClassName="custom-active"  
>
  Profile
</NavLink>
```
---

## Styling Active Links

Common CSS example:

```scss
.active {
  font-weight: bold;
  color: blue;
  border-bottom: 2px solid blue;
}
```

---

## Programmatic Navigation

Use `useNavigate` hook to navigate imperatively from event handlers:

```jsx
const navigate = useNavigate();

<button onClick={() => navigate('/home')}>Go Home</button>
```



---

