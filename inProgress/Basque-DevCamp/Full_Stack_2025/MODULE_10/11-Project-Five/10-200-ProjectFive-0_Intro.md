# 10-200: React Project Five - Application Overview

---

**[Guide](https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/react-project-five-application-overview)**

---

## 🎯 New Project: DailySmarty Search App

**Frontend-focused application**:
- **External API integration** - DailySmarty API
- **Search functionality** - query articles
- **2-screen application** - search + results
- **Advanced component architecture** - heavy component reuse

---

## 🛠️ Application Features

### Screen 1: Search Interface
- **Search input** - query field
- **Logo component** - reusable across screens
- **Navigation** to results via React Router

### Screen 2: Results Display  
- **Fetched articles** - from DailySmarty API
- **Hover interactions** - show links on hover
- **External redirects** - click links to useful articles
- **Topics display** - categorised results

### API Integration
**DailySmarty API**:
- **Documentation**: `dailysmarty.docs.apiary.io`
- **Source app**: `dailysmarty.com` 
- **Returns**: Article data, topics, useful links
- **No images included** - may improvise design

---

## 📧 Technologies

### New Tech Stack Elements
- **Redux middleware** - redux-promise or redux-thunk
- **Advanced routing** - result screen navigation  
- **FontAwesome** - icon system (requires bolder fonts)
- **Component reusability** - same components across screens

### Carried Forward
- **React fundamentals** - components, state, props
- **API calls** - fetch data like previous project
- **Routing** - React Router navigation

---

## 📋 Learning Objectives

**Advanced React patterns**:
- **Component separation** - everything in own components
- **Component reuse** - same logo component in different files
- **Redux mastery** - better Redux usage patterns
- **Middleware implementation** - async action handling

**API integration**:
- **External API consumption** - vs internal CRUD APIs
- **Search functionality** - dynamic queries
- **Data transformation** - API response to UI components

---
