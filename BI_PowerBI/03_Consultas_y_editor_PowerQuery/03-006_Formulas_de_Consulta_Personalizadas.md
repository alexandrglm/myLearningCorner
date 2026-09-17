# 03-006:	Fórmulas de Consulta personalizadas

## Uso de funciones personalizadas

> [!IMPORTANT]
> Cuando debemos repetir **el mismo proceso** de transformación en diferentes columnas, cuando **sí se puede ejecutar en lotes**, o **cuando un proceso de transformación puede ser complejo y se prefiere tener un control exacto**, el uso de Formulas de consulta personalizadas es la mejor opción.

![](./img/03-033.png)

1. 	Una función personalizada en Power Query es una **asignación de un conjunto de valores de entrada a un único valor de salida** y se crea a partir de funciones y operadores M nativos.

2.	Aunque podemos crear manualmente nuestra propia función personalizada con Power Query, **mediante código** como se muestra en Descripción de Power Query funciones M, la interfaz de usuario de Power Query **ofrece características específicas para acelerar, simplificar y mejorar el proceso** de creación y administración de la función personalizada.

3.	**Las funciones personalizadas en Power Query funcionan de forma similar a Excel**, ya que hablamos de un dato de entrada que nos dará un resultado de salida, pero en este caso, una función personalizada nos permite crear un cálculo por cada fila en una columna o columnas, y crear una nueva columna a partir de esos resultados.  

4.**Al igual que en Excel**, aplica el **principio de que una función nos pedirá un dato de entrada para darnos una salida**.  
- El dato de entrada, por ejemplo, puede ser un rango, un número o un pedazo de texto. 
- El dato de salida puede variar. 
- Por ejemplo, en casos como la función SUMA obtenemos un número, mientras que IZQUIERDA nos dará una secuencia.

---

### Agregar una columna personalizada en Power BI Desktop

Cuando se crea una columna personalizada en el Editor de Power Query, Power BI Desktop la agrega como un Paso aplicado en la Configuración de la consulta de la consulta. Esto se puede cambiar, migrar o modificar en cualquier momento.  

Para agregar una columna personalizada:

1. Botón **Agregar columna** en la barra de herramientas de Query.

![](./img/03-034.png)

---

### Crear fórmulas para la columna personalizada en Power BI Desktop

Para crear una fórmula personalizada en la nueva columna, por ejemplo para *calcular las ventas totales*:

1. Seleccionamos la columna **Unit sold** en la lista **Columnas disponibles** situada a la derecha.

2. Seleccionamos el botón **Insertar** debajo de la lista para agregarla a la fórmula de la columna personalizada.

3. **A medida que escribamos la fórmula y creemos la columna, podemos tener en cuenta el indicador en la parte inferior de la ventana Columna personalizada.**

4. **Si no hay ningún error, veremos una marca de verificación verde y el mensaje No se han detectado errores de sintaxis.**

![](./img/03-035.png)


5. La fórmula personalizada se creará en la ventana a medida que vamos incorporando sus elementos.

![](./img/03-036.png)

6. Una vez completada la fórmula personalizada que queremos aplicar a la columna creada, **haremos clic en aceptar y veremos que se crea la nueva columna personalizada con los datos resultado de aplicar la fórmula creada.**

![](./img/03-037.png)

---

### Editor Avanzado

> [!IMPORTANT]
> El Editor Avanzado de PowerQuery es **la mejor herramienta para mantener todo el proceso de ETL bien limpio y depurado.

**Después de crear la consulta**, también podemos usar el Editor avanzado para modificar cualquier paso de la consulta. Para ello:

1.	En la ventana **Editor de Power Query** >
2. 	La pestaña **Vista** de la barra de herramientas >
3. 	Seleccionaremos **Editor avanzado**. 

![](./img/03-038.png)

4. 	Aparece la ventana Editor avanzado, que proporciona un control total sobre la consulta.

