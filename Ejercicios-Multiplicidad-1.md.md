### Ejercicio 1: Sistema Universitario

**Escenario**: En una universidad, los profesores pueden impartir varias asignaturas, pero cada asignatura debe ser impartida por exactamente un profesor titular.

**¿Cómo sería la multiplicidad entre Profesor y Asignatura?**


Profesor [1... asterisco] <--------> Asignatura [1]  

Relación 1...n : 1  



---

### Ejercicio 2: Red Social

**Escenario**: En una red social, los usuarios pueden seguir a muchos otros usuarios, y también pueden ser seguidos por muchos usuarios.

**¿Cómo sería la multiplicidad para la relación "Usuario sigue a Usuario"?**

La Clase Usuarios se autoreferencia a si misma con multiplicidad * asterisco, o n a muchos, n a n.  


Si definimos usuarios individuales, como OBJETOS, diría entonces que   

usuarioUNO [asterisco] --------> Usuarios (Clase) [1]  


O  entre dos objetos directamente:  

usuarioUNO[1]<------- `<<sigue>>` ------> usuarioDOS[1]  


#### CORRECCION:
### Ejercicio 2 - Red Social ⚠️

**ERROR**: Objetos vs clases 

**Respuesta correcta**: `Usuario [*] ←→ [*] Usuario` (auto-asociación) 

**Explicación**: Es una relación muchos-a-muchos de la misma clase consigo misma. Un usuario puede seguir a muchos, y ser seguido por muchos.

---

### Ejercicio 3: Biblioteca Digital

**Escenario**: En una biblioteca digital, cada libro puede tener múltiples autores, y cada autor puede haber escrito múltiples libros.

**¿Cómo sería la multiplicidad entre Autor y Libro?**

Libro [*] <------> Autores [*]  
Relación muchos a muchos, `n:n `  

---

### Ejercicio 4: Sistema de Vehículos

**Escenario**: En un sistema de registro de vehículos, cada vehículo tiene exactamente una matrícula única, y cada matrícula pertenece a exactamente un vehículo.

**¿Cómo sería la multiplicidad entre Vehículo y Matrícula?**

Coche [1] <------> Matricula [1]

Multiplicidad:  
Coche refleja la capacidad de tener cuantas amtriculas? UNA  
Matricula refleja a cuantos coches puede pertenecer? Solo a UNO  

Multiplicidad `1:1`

