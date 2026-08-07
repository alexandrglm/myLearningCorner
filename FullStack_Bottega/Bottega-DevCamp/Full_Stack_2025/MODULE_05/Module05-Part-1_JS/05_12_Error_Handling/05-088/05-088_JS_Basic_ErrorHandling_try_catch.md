# MODULE 05 - 087:   JS Error Handling

## Error Handling (1) - Basic Syntax - `try`- `catch`

***

1. `try/catch` Syntax Explained
2. Error Object Properties
3. Use Cases

***

Error handling is **critical** for building resilient JavaScript applications. When code fails, proper error handling:

* Prevents complete application crashes
* Provides meaningful feedback to users
* Helps developers debug issues
* Maintains data integrity

The `try/catch` statement is JavaScript's primary mechanism for handling synchronous errors.

***

## 2. `try/catch` Syntax Explained

### Basic Structure

```js
try {

    // Code that might throw an error
    executeRiskyOperation();

} catch (error) {

    // Handle the error
    console.error('Operation failed:', error);

}
```

* **`try` block**: Contains code that might throw exceptions
* **`catch` block**: Executes when errors occur in `try`
* **`error` parameter**: Contains error details (name, message, stack trace)

***

#### Data Flow

* **`try` block**: Contains code that might throw exceptions
* **`catch` block**: Executes when errors occur in `try`
* **`error` parameter**: Contains error details (name, message, stack trace)

***

## 3. Error Object Properties

The error object in `catch` provides valuable debugging information:

| Property  | Description                | Example                           |
| --------- | -------------------------- | --------------------------------- |
| `name`    | Error type                 | `TypeError`                       |
| `message` | Human-readable description | `func is not a function`          |
| `stack`   | Call stack trace           | `at sideComponent (script.js:20)` |

**Example Usage**:

```js
catch (error) {

    console.error(`[${error.name}] ${error.message}`);
    console.debug('Stack trace:', error.stack);

}
```

***

## 3. Practical Use Cases

### Case 1:         Validating Function Arguments

```js
function processData(data) {

    try {

        if (!data) throw new Error('No data provided');
        // Process data...

    } catch (error) {

        showUserAlert(error.message);
    }
}
```

### Case 2:         JSON Parsing

```js
function parseJSON(jsonString) {
    try {
        return JSON.parse(jsonString);

    } catch (error) {

        console.error('Invalid JSON:', error);
        return null;
    }
}
```

### Case 3:         External Library Errors

```js
try {

    thirdPartyLibrary.dangerousOperation();

} catch (error) {

    logToMonitoringService(error);
    fallbackOperation();
}
```

***

## Best Practices

1. **Be Specific**: Catch only expected error types
2. Combine `try/catch` with custom error classes for more robust error handling in large applications.
3. **Don't Swallow Errors**: Always log or handle errors
4. **User-Friendly Messages**: Translate technical errors for users
5.  **Clean Up Resources**: Use `finally` particle when needed

    ```js
    let resource;

    try {

        resource = acquireResource();
        // Use resource...

    } catch (error) {

        handleError(error);

    } finally {

        if (resource) resource.cleanup();

    }
    ```

## Common Pitfalls

1.  **Overly Broad Catches**

    ```js
    // NOPE! Avoid so-generic error logging

    catch (error) {

        console.log('Something went wrong');

    }
    ```
2.  **Nested Try/Catch Hell**

    ```js
    // NOPE! Avoid nesting try - catch snippets
    try {
        try {
            // ...
        } catch (innerError) {
            // ...
        }

    } catch (outerError) {

      // ...

    }
    ```
3.  **Nested Try/Catch Hell**

    ```js
    // NOPE!

    try {

        fetchData().then(data => {
            throw new Error('Fail!');
        });

    } catch (error) {
        // Never reached
    }
    ```

***

## Resources

* [try...catch - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Statements/try...catch)
* [Error - JavaScript | MDN](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Error)
* [Node.js Error Handling Best Practices: Ship With Confidence - Stackify](https://stackify.com/node-js-error-handling/)

***

## Video Lesson Speech

Now that you have a high-level overview of what error management is in\
JavaScript and also why it is important for you to implement in order to\
ensure that your users get the best experience possible.

***

Now let's dive into the code and now I'm going to take a very intentional approach when we're learning about error management which means I'm going to start off with the most basic example I can think possible and so that's what we're going to do in this guide and in later guides we're going to walk through more advanced examples.

Even getting to where we are connecting to outside API's and then seeing what happens when we have a bad connection with an API and how we can use error management in order to make sure that our users are informed of when that happens.

So what I have right here is I have visual studio code on the left-hand side and then I have the browser on the right-hand side with the javascript console open.

![large](../../../../../../../.gitbook/assets/05-088-IMG1.png)

{1:04}I created an index each DML file and I opened it up over here. Just as a little review in case you didn't watch some of the previous guides where I did that now with this example right here we just have a basic HD Amelle layout and we don't have any code so all of our code is going to go inside of this script tag. And let's walk through our first example. And so what I'm going to do is I'm going to create a function some say function and call this function the site component.

Now the site component is a component that I want to take a function as an argument which means that whenever the site component is called it should be passed a function. So if we pass anything else an error should be thrown. And as a spoiler alert that's exactly what we are setting up so, later on, we're going to see how we can call it incorrectly and then how we can catch an error and then output that to the user. Now what this is going to do is it's simply going to return the function and it's going to call it. So remember whenever we are passing a function around as an argument we can pass it into some other function and then if we want to call it we simply have to add these Berends to the end of it. So this is an incredibly basic function. All it is doing is essentially calling itself. So I wanted to keep that part as basic as possible. There's nothing too crazy going on with that. Now let's make sure that this actually works before we implement our error management system. So I'm going to create a widget. And so I'm using naming here that is very closely aligned if you are using some type of front end framework such as a view or reactor angular where I'm building out site components and in this example imagine a scenario where here on the page you want to pass in a widget so that it appears to the user and this widget may perform different tasks so a good example would be this widget may go and call Instagram and pull in the pictures from someone Instagram feed that would be a common use case for some type of widget.

Now our widget is simply going to return a string that says Hi there in a div and so it's going to be pretty basic and I'm going to use the arrow syntax here some Yenisei Wiggo equals Perens and then Arrow and then inside of the curly braces. I simply say return and then I'll put in a div here that says Hi there. Close that div tag and at the end add a semicolon. Now in order to make sure that this works we can just console log some say console log and then I'm going to call our site component function and then I'm going to pass in our widget. So the way that this works right here is we have two functions. We have a site component function and then we have a widget function the widget is getting passed directly into this argument here. So this is going to represent this func argument and then it's going to be called. So that is all that is happening and then we want to console log. Whatever gets printed out which in our case should be the div. Hi there. So if you hit save and come over to the browser and hit refresh you can see that that works it says Hi there. So everything is working properly. Now let's see what happens when this is not called properly. So I'm going to come here and instead of calling widget, I'm going to just pass in a string.

Now, remember that our site component is expecting a function and it's going to attempt to call that function so if we slide in this string and pass it in what's going to happen is essentially this as just some pseudo code you can see it's going to be like we're saying oops switches a string and then we're trying to add Perrin's on it which means we're trying to treat this string like a function which is not going to work out very well. So the vial saved I am going to come over here and see what happens. So we call it now you can see that we get this very nasty little error message here where it says uncaught type bear func is not a function and so this is giving us some details but not probably everything that we need. And as you can see it simply is erroring out it's not giving us any kind of output or anything like that. And so what we can do in JavaScript is use what are called. Try and catch blocks and what that means is it fits very well with the definitions of the names. You can try some process and if that process does not work so if your attempt does not work then you can catch the error and that fits in with the syntax of it so I'm going to come here above the console log statement and I'm going to say try and then give some curly braces and this whole statement. I'm actually going to put inside of the console logs statement an indent it just to make it clear that this is the process that we are trying. So after I type in try what I'm going to pass in is catch and catch expects at least one argument so I'm going to pass in the letter E. This is short for "error".

So what I'm saying is I want to try to catch whatever is going to happen if this if our process does not work so I'm going to place that in and add some curly braces. Now inside of our catch block what we can do is we can console log out the actual error so I can say console log and say.

An error occurred with the site component and then give a second argument. I'm just going to pass in E which represents the error and all add a semicolon at the end. Save the file and now let's come and see exactly what happened so I'm going to clear the console now and hit refresh and now you can see we don't have that ugly red error message anymore. So now what it says is as you can see it caught that error so it worked and it said an error occurred in the site component. Just like you can see right there now ie get swapped out for the actual error so you as you can see here it says type bear. Func is not a function at sight component so this gives us all kinds of details that we are going to need in order to know how to fix this error. And so if this were a real-world program we could come up to it and we could say oh we passed a string in instead of passing in a function and so let me just replace this with our actual function. And so now if we fix our error come back save the file and hit refresh. You'll see that everything is back to normal. So the only way that this catch block comes in and is actually activated is if an error occurs. And that is a very basic introduction to error management inside a javascript.

## Code

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" >
    <!-- For Firefox <meta http-equiv="Content-Security-Policy" content="script-src 'self' 'unsafe-inline' "> -->
    <title>12_01 -> Basic Error Handling Syntax</title>
</head>
<body>


    <script>

        console.log('Testing Dev-Browser Scripts execution OK')

        // A Fantastic way to execute snippets as side components functions
        // Commonly used on React, Vue, Angular, ....
        function sideComponent (func) {

            return func();

        }

        debugComponent = () => {
            return 'sideComponent and func working properly!'
        }

        widget = () => {

            return '<div>Hellllo</div>'

        }

        anyTexts = () => {
            return 'Example text'
        }

        // Let's invoke
        console.log(sideComponent(debugComponent));
        console.log(sideComponent(widget));


        // Let's add some errors
        // console.log(sideComponent('a string not a funcion'))
        /*
        CONSOLE ERROR LOG:

        Uncaught TypeError: func is not a function
        sideComponent http://localhost:42599/12_01-Basic_Error_Handling_Syntax/12_01:20
        <anonymous> http://localhost:42599/12_01-Basic_Error_Handling_Syntax/12_01:40
        */


        // Adding TRY - CATCH
        try {

            console.log(sideComponent('Not a Function to try and catch'));

        } catch (e) {

            console.error('DEBUG: Error with sideComponent', e);
        }


        //
        try {

            console.log(sideComponent(anyTexts));

        } catch (e) {

            console.error('DEBUG: Error with sideComponent', e);
        }

    </script>
</body>
</html>
```

***

## Coding Exercise

There are 2 syntax errors in the below code. Find and fix them to make the test pass.

```js
```
