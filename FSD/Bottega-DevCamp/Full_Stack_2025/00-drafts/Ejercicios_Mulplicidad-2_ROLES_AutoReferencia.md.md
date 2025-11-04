
## Ejercicios de Auto-Asociación - Clases que se Referencian a Sí Mismas
---

### Ejercicio 1: Jerarquía Empresarial

**Escenario**: En una empresa, cada empleado puede tener un jefe (que también es empleado), y cada jefe puede supervisar a varios empleados subordinados.

**¿Cómo sería la auto-asociación de la clase Empleado?**

Aquí, además del concepto de Multiplicidad, debemos especificar el de ROL.
La propiedad ROL, intrínseca también a Asociación como lo es multiplicidad y navegabilidad, permite tener "diferentes estados/propiedades" de una misma clase sin tener que realizar dos clases distintas.

Las auto-referencias (auto-asociación) son posibles con este concepto:

Empleado [ `1... n` - Rol: supervisor ] <-- `<<supervisa>>` -> [`1` - Rol: subordinado ] Empleado 



---

### Ejercicio 2: Red Social - Seguimiento

**Escenario**: En Twitter, un usuario puede seguir a muchos otros usuarios, y puede ser seguido por muchos usuarios diferentes.

**¿Cómo sería la auto-asociación de la clase Usuario con el rol "follower"?**

Usuario [n - Rol: Es Seguidor de]  <--- `<< acción: seguir >>` ----> [n - Rol: Es Seguido Por] Usuario



---

### Ejercicio 3: Sistema de Categorías

**Escenario**: En un e-commerce, las categorías pueden tener subcategorías, pero cada subcategoría pertenece a máximo una categoría padre.

**¿Cómo sería la auto-asociación de la clase Categoría?**

* Si una categoria puede tener **de una a N** subcategorias, y cada subcategoria debe pertenecer **solo a una padre**:

Categoria [`1...n` - Rol: Cateogia Padre  ] <------->  [`1` - Rol: Subcategoria ] Categoria


* Si padre tiene 1 a N y hija tiene mínimo 1 a N tambien:

Categoría [`1...n` - Rol: Padre ] <--> [`1...n` Rol: Hija] Categoría


* Si pensamos más flexiblemente entendiendo que en el mundo real una Categoria Padre no tiene por qué tener subcategorías, y, a la vez, una subcategoría, sólo por lógica semántica del propio rol, puede pertenecer a UNA o VARIAS categorías padre:
  
Categoría [`0... n` - Rol: Categoría Padre] <--> [`1...n` - Rol: Subcategoria] 

---

### Ejercicio 4: Amistad en Red Social

**Escenario**: En Facebook, la amistad es bidireccional - si A es amigo de B, entonces B es amigo de A automáticamente.

**¿Cómo sería la auto-asociación de la clase Usuario con el rol "es amigo de"?**

* La primera respuesta sería:   
Usuario [`1`- Es amigo de] <--> [`1` - Es amigo de] Usuario    

* **PERO, un Usuario puede ser amigo de MUCHOS (o ningún) usuario a la vez, entonces** :

Usuario [`n`- Es amigo de] <--> [`n` - Es amigo de] Usuario  

Multiplicidad `N:N` 