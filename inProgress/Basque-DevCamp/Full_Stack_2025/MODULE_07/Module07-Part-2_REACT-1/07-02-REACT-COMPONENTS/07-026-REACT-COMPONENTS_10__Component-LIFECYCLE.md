# 07-026: React Components 10 - The Component Lifecycle

## Introduction

Understanding component lifecycle methods is essential for managing your component’s behaviour at specific points in its existence.

---

## Lifecycle Categories

- Mounting: When a component is created and inserted into the DOM  
- Updating: When a component is re-rendered due to changes in props or state  
- Unmounting: When a component is removed from the DOM  
- Error Handling: Catch and handle errors in rendering  

---

## Mounting Methods

- constructor() - Initializes state and binds methods  
- static getDerivedStateFromProps(props, state) - Update state based on props  
- render() - Returns JSX to describe UI  
- componentDidMount() - Runs after component inserted into DOM  

---

## Updating Methods

- static getDerivedStateFromProps(props, state) - Called before every render  
- shouldComponentUpdate(nextProps, nextState) - Return false to prevent update  
- render() - Renders JSX  
- getSnapshotBeforeUpdate(prevProps, prevState) - Capture value before DOM update  
- componentDidUpdate(prevProps, prevState, snapshot) - Runs after update  

---

## Unmounting Method

- componentWillUnmount() - Cleanup before removal (e.g., timers, subscriptions)  

---

## Error Handling Methods

- static getDerivedStateFromError(error) - Update state on error  
- componentDidCatch(error, errorInfo) - Log error info, side effects  

---

## Lifecycle Flow Example

1. constructor()  
2. getDerivedStateFromProps()  
3. render()  
4. componentDidMount()  

On update:

1. getDerivedStateFromProps()  
2. shouldComponentUpdate()  
3. render()  
4. getSnapshotBeforeUpdate()  
5. componentDidUpdate()

On unmount:

- componentWillUnmount()

---

## Practical Use Cases

- Fetch data on componentDidMount  
- Optimize re-renders with shouldComponentUpdate or React.PureComponent  
- Cleanup event listeners or timers in componentWillUnmount  
- Error boundary components with componentDidCatch  

---

## Functional Components and Hooks

React has converged lifecycle management into hooks such as:

- useEffect() for mounting, updating, cleanup  
- useState() for state management  


---

