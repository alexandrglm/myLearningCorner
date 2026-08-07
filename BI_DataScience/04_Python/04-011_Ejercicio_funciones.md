# 🧪 04-011 · Ejercicio: funciones en módulos externos

> **Idea clave:** En Python, cada archivo `.py` es un **módulo**. Puedes declarar funciones en un archivo e importarlas en otro ( la base de cómo se organiza cualquier proyecto real ).

---

## 🎯 Objetivo del ejercicio

Crear dos archivos en la **misma carpeta**:

| Archivo | Rol |
|---|---|
| 📄 `FuncionesExternas.py` | Módulo - declara las funciones |
| 📄 `EjecucionDeFunciones.py` | Script principal - las importa y ejecuta |

---

## 1️⃣ `FuncionesExternas.py` - declaración de funciones

```python
# FuncionesExternas.py
# Declaración de funciones

def funcion1():
    print('Has llamado a la función 1')

def funcion2(a, b):
    c = int(a) + int(b)
    return c   # Devuelve el valor de la suma
```

---

## 2️⃣ Importar con `from ... import *`

```python
# EjecucionDeFunciones.py
from FuncionesExternas import *

funcion1()

Q = input('Introduzca un dato: ')
W = input('Introduzca otro dato: ')
print(funcion2(Q, W))
```

> ⚠️ `import *` importa **todo** lo público del módulo directamente al espacio de nombres actual. Es cómodo, pero puede provocar **colisiones de nombres** si dos módulos definen funciones iguales. Solo recomendable en scripts pequeños o de aprendizaje.

---

## 3️⃣ Alternativa recomendada: `import ... as`

```python
# EjecucionDeFunciones.py
import FuncionesExternas as F

F.funcion1()

Q = input('Introduzca un dato: ')
W = input('Introduzca otro dato: ')
print(F.funcion2(Q, W))
```

| Forma de importar | Ventaja | Cuándo usarla |
|---|---|---|
| `from modulo import *` | Menos código al llamar (`funcion1()`) | Scripts pequeños, prototipos |
| `import modulo as alias` | Evita colisiones, deja claro el origen (`F.funcion1()`) | ✅ Proyectos reales, buena práctica general |

---

## 📂 Importar módulos que NO están en la misma carpeta

Si `FuncionesExternas.py` vive en otra ubicación, hay que añadir esa ruta a `sys.path` **antes** de importar:

```python
import sys
sys.path.append('C:/Ruta/hacia/la/carpeta/de/los/scripts')

import FuncionesExternas as F
```

> 💡 `sys.path` es la lista de carpetas donde Python busca módulos al hacer `import`. Añadir una ruta con `.append()` la incluye solo para esa ejecución del script.

---

## ✅ Resumen

- Cada `.py` es un módulo importable desde otro archivo.
- `import modulo as alias` es más seguro y legible que `from modulo import *`.
- Para importar desde otra carpeta, usa `sys.path.append(ruta)` antes del `import`.

## ⚠️ Errores comunes

- Olvidar convertir con `int()` los datos que llegan por `input()` antes de sumarlos dentro de `funcion2`.
- Nombrar el script principal igual que el módulo (o igual que una librería estándar) → provoca *shadowing* y errores de importación confusos.