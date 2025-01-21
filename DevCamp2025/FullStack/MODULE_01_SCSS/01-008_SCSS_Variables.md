# 🎨 **SCSS Variables (1)**

This guide examines why using variables is a powerful tool to simplify our css code, also the syntax for **declaring** and **calling variables** in SCSS files will be introduced.  

---

## 🔑 **Why Use Variables in SCSS?**

One of the most powerful aspects of using SCSS is the ability to make your code more **efficient**.  

If you're familiar with programming languages like **Ruby** or **Python**, the concept of variables is already second nature. A **variable** is simply a **container** that stores a value and can be called anywhere in your application.  

### **Benefits of Variables**:
SCSS variables empower you to manage styles more effectively by:
- **Centralizing changes** 🔄  
- **Removing redundancy** 🧹
- **Easier Maintenance**
- **Cleaner Code**
- **Scalability**

---

## 💡 **The Problem: Duplication in CSS**

Imagine a situation where you have a CSS file spanning **thousands of lines**. You might encounter repeated instances of the same styles—like a background color or font color.  

For example, consider a scenario where a client requests you to:
- Change all instances of **dark red** to **dark green**.  

Without variables, you would need to manually search and replace every instance. This process is:
- **Time-consuming** 🕒  
- Prone to **errors** ❌  

---

## 🛠️ **SCSS Variables: A DRY Solution**

In SCSS, you can follow the **“Do Not Repeat Yourself” (DRY)** principle by leveraging **variables**.  

### **How Variables Help**:
1. Define variables at the **top of your file**.  
2. Use those variables wherever you need the values.  
3. When updates are needed, change the variable’s value, and it updates across the entire file.  

---

## 📋 **Step-by-Step Process**

1. **Set Up SCSS**:  
   Ensure your SCSS is properly configured to compile and process styles.

3. **Identify Duplication**:  
   Look for repeated values like colors or fonts in your CSS.

4. **Define Variables**:  
   Place your variables at the **top** of your SCSS file for easy management.
   <img width="202" alt="IMG2" src="https://github.com/user-attachments/assets/57bd569d-35d9-4b70-8234-130c73a665f7" />


6. **Replace Values with Variables**:  
   Update your code by using variables instead of hardcoded values.
   <img width="404" alt="IMG3" src="https://github.com/user-attachments/assets/6fde972a-146a-41bc-864d-7769931f1ba7" />
---

## 🌈 **Practical Example**

Using variables can make managing a color scheme much simpler. For instance:  
- A client wants to update a background color across multiple components.  
- Instead of manually replacing the hex value everywhere, you simply update the variable.  

---

## ✅ **Benefits of Using SCSS Variables**



By leveraging variables, you can build **flexible**, **maintainable**, and **efficient** SCSS files.




# Examples
## CSS Before declaring variables
```css
body {
  background-image: radial-gradient(circle at top left, #353840, #141414);
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: stretch;
  margin: -0.5em 0 -0.5em 0;
  min-height: 100vh;
  /* min-width: 100vw; */
  box-sizing: border-box;
}

.mainBody {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin: -0.5em 0 -0.5em 0;
  padding: 20px;
  flex-grow: 1;
  max-width: 100%;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
}

.bodyPart1, .bodyPart2 {
  flex: 1;
  margin: -0.5em 0 -0.5em 0;
}

.bodyPart1 p {
  font-family: 'Lato';
  text-align: left;
  color: #cacaca;
  font-size: 1.9rem;
  margin-bottom: 30px;
}

.bodyPart1 > p > strong {
  color: #cacaca;
}
.bodyPart1 > p::before {
  content: "Text  ";
}

.bodyPart1B p {
  color: #cacaca;
  font-size: 1.8rem;
}

.bodyButtons {
  display: flex;
  gap: 30px;
}

.signUpBodyButton {
  font: bold 24px 'Lato';
  color: #cacaca;
  background-color: #4bce79;
  padding: 0.5em 1em;
  border-radius: 0.15em;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;
}
```

## SCSS after variables declared
```scss
$textColorAsVariable:    #cacaca;
$marginsAsVariable:  -0.5em 0 -0.5em 0;

body {
  background-image: radial-gradient(circle at top left, #353840, #141414);
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: stretch;
  margin: $marginsAsVariable;
  min-height: 100vh;
  /* min-width: 100vw; */
  box-sizing: border-box;
}

.mainBody {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  margin: $marginsAsVariable;
  padding: 20px;
  flex-grow: 1;
  max-width: 100%;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
}

.bodyPart1, .bodyPart2 {
  flex: 1;
  margin: $marginsAsVariable;
}

.bodyPart1 p {
  font-family: 'Lato';
  text-align: left;
  color: $textColorAsVariable;
  font-size: 1.9rem;
  margin-bottom: 30px;
}

.bodyPart1 > p > strong {
  color: $textColorAsVariable;
}
.bodyPart1 > p::before {
  content: "Text  ";
}

.bodyPart1B p {
  color: $textColorAsVariable;
  font-size: 1.8rem;
}

.bodyButtons {
  display: flex;
  gap: 30px;
}

.signUpBodyButton {
  font: bold 24px 'Lato';
  color: $textColorAsVariable;
  background-color: #4bce79;
  padding: 0.5em 1em;
  border-radius: 0.15em;
  cursor: pointer;
  transition: background-color 0.3s, transform 0.2s;
}
```

  
