
## Ejercicio 1: Sistema de Blog
---

#### CASO 1 - BIDIRECCIONAL

```
Autor ←→ Artículo  (bidireccional)
```

**Navegabilidad**:

- **Desde Autor**: `autor.getArticulos()` ✅
- **Desde Artículo**: `articulo.getAutor()` ✅

---
#### CASO 2: UNIDIRECCIONAL
```
Autor → Artículo (unidireccional)
```

#### **Navegabilidad**:

- **Desde Autor**: `autor.getArticulos()` ✅
- **Desde Artículo**: `articulo.getAutor()` ❌ (NO permitido)


### PREGUNTA 1: 
#### ¿En cuál de los dos casos puedes, desde un artículo, saber quién lo escribió?


En el caso 1, Bidireccional `<---->`. Permitiría algo como `article.getAuthor()`


---

## Ejercicios de Navegabilidad - Construcción Práctica

Te daré diferentes escenarios del mundo real y tú decides **qué tipo de navegabilidad** usar y **por qué**.

---

### Ejercicio 1: Sistema de Contraseñas

**Escenario**: Una empresa quiere que los empleados puedan consultar sus datos, pero por seguridad, desde los datos personales NO se debe poder acceder a la contraseña.

**Clases**: `Empleado` y `Contraseña`

**Tu tarea**: ¿Cómo harías la asociación y navegabilidad? ¿Bidireccional o unidireccional? ¿En qué dirección?

---

* Si contraseña es una clase propia, y no un objeto, establecemos UNIDIRECCIONAL la conexión, de la siguiente forma:

`Empleado <--- Contraseña`

Contraseña si puede acceder a Empleado, Empleado NO puede acceder a contraseña.

* Mejoremos el ejemplo. Los datos personales son una clase propia, empleado lo tomamos como Actor, sin tener en cuenta su propia clase. Entonces:

`DatosPersonales <--- Contraseña`

DatosPersonales no puede acceder a Contraseña. Pero los métodos de contraeña, si quisieran, sí podrían acceder a DatosPersonales.

* Si quisieramos tener en cuenta todas las clases, Empleado, DatosPersonales y Contraseña:

`Empleado <----> DatosPersonales <---- Contraseña <---> Empleado`

Es decir, `Empleado` puede acceder a sus datos personales, y a Contraseña. `Contraseña` puede acceder a `DatosPersonales` (No parece muy realista, pero, por ejemplo, contraseña podría tener un método dentro que incluya verificar el username del Empleado, contenido en DatosPersonales), pero `DatosPersonales` jamás podría acceder a `Contraseña` 


#### CORRECCION:

* Pensándolo bien, la Clase Contraeña ... Por qué tendría que acceder a Empleado?.


* Esto sería más correcto:
* `Empleado <--> DatosPersonales`
* `Empleado --> Contraseña`


* Y si Contraseña tuviera algún método para con respecto `DatosPersonales`debería ser así.:
* `Contraseña --> DatosPersonales`



---

### Ejercicio 2: Sistema de Historiales Médicos

**Escenario**: Los doctores necesitan acceder al historial de sus pacientes. Los pacientes también deben poder ver su propio historial.

**Clases**: `Doctor` y `HistorialMedico`

**Tu tarea**: Diseña la asociación y navegabilidad. Justifica tu decisión.

---
Nos inventamos una clase más para hacer más entendible la respuesta (y la Navegabilidad en si misma):

* `Doctor -----> HistoriaMedico`
* `Paciente ---> HistorialMedico`
* `Doctor <----> Paciente` (si propiciasemos que ambas clases debieran trabajar juntas y tener acceso entre ambas)

---

### Ejercicio 3: Sistema de Logs de Sistema

**Escenario**: Cuando ocurre un error en el sistema, se genera automáticamente un log. Los administradores deben poder consultar qué errores generó cada módulo, pero desde un log específico no necesitan saber qué módulo lo generó.

**Clases**: `Modulo` y `LogError`

**Tu tarea**: ¿Cómo diseñarías esta navegabilidad?

---


Añadimos Clase Admin y Log. Entonces:

* `Admin ----> Modulo `
* `Admin ---> Log`
* `Admin ---> LogError`

* **`Modulo ----> Log`**
*  **`Log <----> LogError`**

* Entendemos que admin tiene unidireccional acceso a todas (esto no es relevante).
* **Entendemos que un Modulo puede acceder a Log Error a través de Log, pero NO hay una conexión desde Log (Ni, en consecuencia LogError) a Modulo.**
* La única conexión bidireccional relevante sería entre LOG y LOGERROR.