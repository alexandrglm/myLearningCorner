# 04-012 · Manejo de Archivos (*File Handling*)

>  La persistencia de datos permite guardar la información procesada en el disco para que no se pierda al finalizar la ejecución del programa. En Python, interactuamos con el sistema de archivos a través de la función integrada `open()`, gestionando flujos de datos en modo texto o binario.

---

## Apertura y Cierre de Archivos:   `open()`

Para interactuar con un archivo, primero debemos abrir un canal de comunicación (un objeto ejecutor de flujos de E/S o *file handle*).

### Sintaxis básica

```python
archivo = open('nombre_del_archivo.txt', 'modo')
```

### Modos de apertura más habituales

Los modos combinan una **acción** (`r`, `w`, `a`, `x`) con el **tipo de contenido** (`t` para texto, `b` para binario):

| **Modo**        | **Descripción**                   | **Comportamiento si el archivo NO existe**                   | **Comportamiento si el archivo YA existe**          |
| --------------- | --------------------------------- | ------------------------------------------------------------ | --------------------------------------------------- |
| `'rt'` / `'r'`  | **Lectura** (*Read Text*)         | Lanza excepción `FileNotFoundError`                          | Abre el archivo situando el puntero al inicio       |
| `'wt'` / `'w'`  | **Escritura** (*Write Text*)      | Crea un archivo nuevo                                        | **Sobrescribe y borra** todo el contenido previo    |
| `'at'` / `'a'`  | **Añadir** (*Append Text*)        | Crea un archivo nuevo                                        | Mantiene el contenido y sitúa el puntero al final   |
| `'wb'` / `'rb'` | **Binario** (*Write/Read Binary*) | Requerido para archivos no de texto (imágenes, pickle, etc.) | Mismo comportamiento de E/S pero en formato `bytes` |

---

## Escritura en Archivos de Texto

Para escribir datos en un fichero abierto en modo de escritura (`'w'`), empleamos el método `.write()`.

> ⚠️ **Importante:** `.write()` únicamente acepta cadenas de texto (`str`). 
>
> Para escribir números o estructuras, debes convertirlos previamente con `str()`. Además, `.write()` **no añade saltos de línea automáticos** (`\n`), por lo que debes incluirlos manualmente.

![](./img/04-009-png)

```python
# Creación y escritura inicial
archivo_salida = open('Salida.txt', 'wt')

# Guardamos la representación en texto del tipo de dato del buffer de archivo
archivo_salida.write(str(type(archivo_salida)))

# Escritura de líneas de texto (incluyendo saltos de línea explicitos)
archivo_salida.write("\nHola Archivo")
archivo_salida.write("\nAlgo de Texto")

texto = "\nAún más texto"
archivo_salida.write(texto)

# Cierre manual indispensable para liberar el recurso del sistema operativo
archivo_salida.close()
```

---

## Lectura y Navegación del Puntero (`read`, `seek`, `tell`)

Al abrir un archivo en modo lectura (`'r'`), Python mantiene la posición actual mediante un **puntero de archivo**.

### Métodos principales de lectura y posicionamiento

* **`read(n)`**: Lee hasta `n` caracteres (o bytes). Si se omite `n`, lee todo el contenido restante del archivo.
* **`tell()`**: Devuelve la posición actual del puntero (medida en bytes/caracteres desde el inicio).
* **`seek(offset)`**: Mueve el puntero a la posición exacta especificada por `offset`.

```python
# Apertura para lectura
archivo = open('Salida.txt', 'rt')

# 1. Mover el puntero a la posición 20
archivo.seek(20)
print(archivo.read())  # Lee desde el carácter 20 hasta el final

# 2. Reagrupar/Volver al inicio del archivo
archivo.seek(0)

# 3. Leer fragmentos delimitados
print(archivo.read(40))  # Lee los primeros 40 caracteres
print(archivo.read())    # Continúa leyendo desde el carácter 40 hasta el final

# 4. Consultar la posición actual del puntero
posicion = archivo.tell()
print("Posición final del puntero:", posicion)  # Devuelve la longitud total leída (p. ej. 70)

archivo.close()
```

---

## 🛡Control Contextual Seguro:     Declaración `with`

Cuando se opera con archivos mediante `open()` tradicional, olvidar invocar `.close()` o la ocurrencia de una excepción a mitad de ejecución puede dejar el archivo bloqueado o corrompido.

La forma **pythónica y segura** de manejar archivos es mediante el Administrador de Contexto (`Context Manager`) utilizando la palabra clave **`with`**. Al salir del bloque `with`, Python se encarga de cerrar automáticamente el archivo, incluso si ocurren errores inesperados.

```python
# Escritura tradicional
archivo = open('Archivo.txt', 'wt')
archivo.write("\nHola Archivo")
archivo.write("\nPrueba")
archivo.write("\nLínea 1")
archivo.write("\nLínea 2")
archivo.close()

# Lectura segura utilizando 'with'
with open('Archivo.txt', 'rt') as archivo:
    contenido = archivo.read()
    print(contenido)

# En este punto el archivo YA está cerrado automáticamente.
# Intentar llamar a archivo.close() extra no es necesario ni causará error si ya se cerró.
```

---

## Serialización de Objetos Complejos: Módulo `pickle`

El texto plano no permite almacenar directamente estructuras de datos de Python complejas (como listas, diccionarios o números complejos `2+3j`) manteniendo sus tipos nativos.

Para solucionar esto, Python incluye el módulo **`pickle`**, que permite la **serialización** (*pickling*) de objetos a un formato binario y su posterior **deserialización** (*unpickling*).

> ⚠️ **Requisito fundamental:** Los archivos manejados con `pickle` **deben abrirse en modo binario** (`'wb'` para escribir y `'rb'` para leer).

```python
import pickle

# Objeto con tipos heterogéneos (incluye un número complejo y enteros)
lista_datos = ['Casa', 'Coche', 'Manzana', 2+3j, 4]

# 1. SERIALIZACIÓN (Guardar objeto en binario)
with open('ArchivoPickle.txt', 'wb') as archivo:
    pickle.dump(lista_datos, archivo)

# 2. DESERIALIZACIÓN (Cargar objeto restaurando sus tipos nativos)
with open('ArchivoPickle.txt', 'rb') as archivo:
    cargar_lista = pickle.load(archivo)

print(cargar_lista)  # Mantiene la lista original con el tipo complejo intacto
print(type(cargar_lista[3]))  # <class 'complex'>
```

---

| **Método**               | **Propósito**                             | **Salida / Retorno**                              |
| ------------------------ | ----------------------------------------- | ------------------------------------------------- |
| `open(path, mode)`       | Abre o crea un canal hacia el archivo     | Objeto de tipo `TextIOWrapper` o `BufferedWriter` |
| `archivo.write(str)`     | Escribe una cadena de texto en el archivo | Número de caracteres escritos                     |
| `archivo.read(size)`     | Lee caracteres/bytes del archivo          | `str` o `bytes` según el modo de apertura         |
| `archivo.seek(offset)`   | Desplaza el puntero de lectura/escritura  | Posición nueva del puntero                        |
| `archivo.tell()`         | Consulta la posición del puntero          | Valor numérico entero (`int`)                     |
| `pickle.dump(obj, file)` | Convierte y escribe un objeto en binario  | `None`                                            |
| `pickle.load(file)`      | Lee y reconstruye un objeto desde binario | El objeto original con su tipo de dato nativo     |

---
