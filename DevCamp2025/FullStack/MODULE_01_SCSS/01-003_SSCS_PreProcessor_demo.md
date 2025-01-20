# MODULE 1: 003 - SCSS PreProcessor Demo 🎨

## 🌟 **Introduction**  
Now that you have a general overview of **SCSS**, let’s dive into its functionality. We’ll explore:  
- **What SCSS actually does.**  
- **How it builds advanced features.**  

⚠️ *There’s nothing magical about SCSS.* It’s simply a markup language that gets converted into something more powerful.  


---

## 📚 **Understanding the Concept**  

- Using SCSS simplifies front-end development and demonstrates its importance in organizing and optimizing your code.

- SCSS is similar to libraries like **jQuery** or **Angular**:  
  - They sit on top of another language.  
  - They transform into something more functional and complex.  

> While everything could technically be done with CSS, **SCSS** allows us to:  
> - 🔧 **Streamline processes.**  
> - 🗂️ **Organize our code better.**

## 💡 **Pro Tips for Learning SCSS**  
- Switch between **SCSS** and **compiled CSS** often:  
  - This helps you understand what’s happening behind the scenes.  
  - Especially useful for advanced topics like:  
    - **Nesting.**  
    - **Nested pseudo-selectors.**  

---

## 🚀 **Demo in CodePen**  
### 🖼️ **Initial Setup:**  
- **Left side:** HTML.  
- **Right side:** SCSS file.  

![img1](https://github.com/user-attachments/assets/d574d8c0-ba0b-4941-8702-883e6eeb5957)  

> If we placed SCSS directly in a CSS file, the browser would:  
> - ❌ Not recognize a `mixin`.  
> - ❌ Not understand `variables` or `include` statements.  
> - ❌ Throw errors instead of rendering desired functionality.  

All these elements are **unique to SCSS** and get converted into **pure CSS**, which browsers can render.

---

## 🔍 **Viewing Compiled CSS**  

![img2](https://github.com/user-attachments/assets/e963a2aa-efab-4308-82e7-d6ae45e0c637)


- Click the dropdown on the right side to view the compiled CSS.  
- Example:  
  - Two styles: `error` and `success`.  
  - Both share identical properties like:  
    - Width, height, text alignment, font size, etc.  
  - **Only differences:** colors.  

### 🚩 **Problems with Pure CSS:**  
- 🚨 Repetition!  
  - If changes are needed, every instance must be updated manually.  

### ✅ **Advantages of SCSS:**  
- Eliminates duplication.  
- Example:  
  - **SCSS uses a `mixin` to group shared styles.**  
  - The browser processes SCSS and outputs clean CSS.  

---

## ✨ **Adding New Styles Easily**  
- Want to add a new class, e.g., `warning`?  
  - Just define the class in SCSS with changes like:  
    - Background color.  
    - Font color.  
    - Border.  

> View the compiled CSS, and you’ll see the new `warning` class added seamlessly!
![img3](https://github.com/user-attachments/assets/519935e3-c91d-4234-94da-ca731ea68926)  
---


# Video Speech
[ENG]  
```text
Now that you have a little bit of an overview on what SCSS is, we're going to walk through the process. We're going to see exactly what it does and how it's able to build out all of the different features that we have talked about.
***
We are going to take a high-level view of what SCSS is actually doing so that we can see there really is nothing magical about it. It simply is one type of markup language that can be converted into something much more complex.

If you have worked with other types of libraries like JQuery or Angular which are JavaScript libraries and frameworks, then those are very similar to SCSS in the sense that they sit on top of another language, and then they are converted into something that is much more complex.

That's essentially what SCSS does every time we use it, regardless of how complex it may be. Technically all of this could be performed with CSS. In regards to the output, we use SCSS so that we can streamline our processes and so we can better organize our code.

So right here we have a Code Pen. We are going to be using Code Pen throughout this entire course.
```
IMG1
```text
On the left we have HTML, and on the right is the SCSS file. If I just put this into a normal CSS file, the browser would not interpret it and it wouldn't give us the desired functionality.

It would throw an error because CSS doesn't know what a mixin is, it doesn't know what a variable is and it doesn't know what to do with the included statement. All of these are elements of SCSS. All of these things are going to be converted into pure CSS because that's what browsers are able to render.

Now to see what this looks like in CSS you can click the right-hand side dropdown and view compiled CSS.
```
IMG2
```text
Here we can see a completely different set of styles. One is called error and the other is a success. Notice there's a lot of duplication. We have an identical width, height, text alignment, font size, font border, border-radius, and margin. The only big differences we see are the colors.

If we decided to write this in pure CSS we would have quite a bit of duplication. This would be a messy way to write it due to the fact that if we wanted to make a change we would have to change every instance.

If we go back and look at what we created you can see that we don't have any of that duplication inside of our SCSS file. We simply have this mixin. At this point, don't worry about the syntax, right now we are just looking at what occurs and just walk through the fact that SCSS and the browsers by alone would not be able to know what we're doing. You wouldn't be able to define two different classes like this.

The other thing that you may notice is that the entire concept of a mixin was skipped over. When the process starts, it ignores the mixin. It simply takes all of that code and it adds it into a master CSS preprocessed file, then sends it to the browser. So now the browser doesn't care about duplication.

If we wanted to add a new type of style, we have success and error, but I want to have a warning. We can simply create this new class and change the background color, the font color and then the border if we want it to be different.
```
IMG 3
```text
If we go back and view the compiled CSS, you can see now we have our warning class and it has all of those elements.

As you start going through the course, one thing that I'll definitely recommend for you to do is to play around with switching between viewing the SCSS file and what it compiles to. This will allow you to learn a lot more about what is going on behind the scenes with CSS, especially when we get into more complicated topics such as nesting and nested pseudo selectors. Those are things that if you're brand new to front end development it may be a little bit intimidating. Using SCSS and seeing the CSS version will drive home the importance and functionality that SCSS provide us.
```
***
[SPA]

```text
Ahora que tiene una pequeña descripción general de qué es SCSS, vamos a recorrer el proceso. Veremos exactamente qué hace y cómo puede crear todas las diferentes funciones de las que hemos hablado.

Vamos a tener una visión general de lo que SCSS está haciendo realmente para que podamos ver que realmente no hay nada mágico en ello. Simplemente es un tipo de lenguaje de marcado que se puede convertir en algo mucho más complejo.

Si ha trabajado con otros tipos de bibliotecas como JQuery o Angular, que son bibliotecas y marcos de JavaScript, entonces son muy similares a SCSS en el sentido de que se sientan encima de otro idioma y luego se convierten en algo que es mucho más complejo.

Eso es esencialmente lo que hace SCSS cada vez que lo usamos, independientemente de cuán complejo pueda ser. Técnicamente, todo esto podría realizarse con CSS. Con respecto a la salida, usamos SCSS para poder optimizar nuestros procesos y así poder organizar mejor nuestro código.

Así que aquí tenemos un Code Pen. Vamos a usar Code Pen durante todo este curso.



A la izquierda tenemos HTML y a la derecha el archivo SCSS. Si simplemente pongo esto en un archivo CSS normal, el navegador no lo interpretaría y no nos daría la funcionalidad deseada.

Daría un error porque CSS no sabe qué es un mixin, no sabe qué es una variable y no sabe qué hacer con la instrucción incluida. Todos estos son elementos de SCSS. Todas estas cosas se convertirán en CSS puro porque eso es lo que los navegadores pueden renderizar.

Ahora, para ver cómo se ve esto en CSS, puede hacer clic en el menú desplegable del lado derecho y ver el CSS compilado.



Aquí podemos ver un conjunto completamente diferente de estilos. Uno se llama error y el otro es un éxito. Observe que hay mucha duplicación. Tenemos un ancho, alto, alineación de texto, tamaño de fuente, borde de fuente, radio de borde y margen idénticos. Las únicas grandes diferencias que vemos son los colores.

Si decidiéramos escribir esto en CSS puro, tendríamos bastante duplicación. Esta sería una forma desordenada de escribirlo debido al hecho de que si quisiéramos hacer un cambio, tendríamos que cambiar cada instancia.

Si volvemos a mirar lo que creamos, puede ver que no tenemos ninguna de esas duplicaciones dentro de nuestro archivo SCSS. Simplemente tenemos este mixin. En este punto, no se preocupe por la sintaxis, ahora solo estamos viendo lo que ocurre y simplemente recorriendo el hecho de que SCSS y los navegadores por sí solos no podrían saber lo que estamos haciendo. No podrías definir dos clases diferentes como esta.

La otra cosa que puede notar es que se omitió todo el concepto de un mixin. Cuando comienza el proceso, ignora el mixin. Simplemente toma todo ese código y lo agrega a un archivo preprocesado maestro de CSS, luego lo envía al navegador. Entonces ahora el navegador no se preocupa por la duplicación.

Si quisiéramos agregar un nuevo tipo de estilo, tenemos éxito y error, pero quiero tener una advertencia. Simplemente podemos crear esta nueva clase y cambiar el color de fondo, el color de fuente y luego el borde si queremos que sea diferente.



Si volvemos y vemos el CSS compilado, ahora puede ver que tenemos nuestra clase de advertencia y tiene todos esos elementos.

A medida que avance en el curso, una cosa que definitivamente le recomendaré es que juegue alternando entre ver el archivo SCSS y lo que compila. Esto le permitirá aprender mucho más sobre lo que está sucediendo detrás de escena con CSS, especialmente cuando nos adentramos en temas más complicados como anidación y selectores pseudo-anidados. Esas son cosas que si eres nuevo en el desarrollo de front-end pueden ser un poco intimidantes. Usar SCSS y ver la versión CSS resaltará la importancia y la funcionalidad que SCSS nos brinda.
```
