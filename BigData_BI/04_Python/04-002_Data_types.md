# 🐍 04-002 · Tipos de datos en Python

> **Idea clave:** Python es de **tipado dinámico**:   no declaras el tipo, el intérprete lo infiere en tiempo de ejecución.
> Pero eso no significa que no exista tipado: cada valor **es un objeto** con una clase (`type`) bien definida, y las reglas de compatibilidad entre tipos se respetan estrictamente.

---

## 📋 Tabla de tipos disponibles

| Tipo | Categoría | Mutable | Descripción | Ejemplo |
|---|---|:---:|---|---|
| `str` | Texto | ❌ | Cadena de caracteres | `"Cadena"` |
| `list` | Secuencia | ✅ | Colección ordenada, admite tipos mixtos | `[4.0, 'Cadena', True]` |
| `tuple` | Secuencia | ❌ | Como `list`, pero inmutable | `(4.0, 'Cadena', True)` |
| `set` | Conjunto | ✅ | Sin orden, sin duplicados | `{4.0, 'Cadena', True}` |
| `frozenset` | Conjunto | ❌ | Versión inmutable de `set` | `frozenset([4.0, 'Cadena', True])` |
| `dict` | Mapping | ✅ | Pares `clave: valor` | `{'key1': 1.0, 'key2': False}` |
| `int` | Numérico | ❌ | Entero, precisión arbitraria en Python 3 | `42` |
| `float` | Numérico | ❌ | Coma flotante de doble precisión | `3.1415927` |
| `complex` | Numérico | ❌ | Número complejo (`a + bj`) | `1 + 4j` |
| `bool` | Lógico | ❌ | `True` / `False` (subtipo de `int`) | `True` |

> ⚠️ **Nota histórica:** `long` y `unicode` existían en **Python 2**. En Python 3, `int` ya soporta precisión arbitraria y `str` ya es Unicode por defecto — no necesitas esos tipos.

---

## 🚫 Tipado dinámico ≠ tipado débil

Python infiere el tipo automáticamente, pero **no convierte tipos incompatibles de forma implícita**:

```python
>>> 1 + 'Hola'
Traceback (most recent call last):
  File "<stdin>", line 1, in <module>
TypeError: unsupported operand type(s) for +: 'int' and 'str'
```

```python
>>> variable = '46'
>>> variable + 1
TypeError: can only concatenate str (not "int") to str
```

👉 Hay que **convertir explícitamente** con funciones de casting:

```python
>>> int(variable) + 1
47
```

---

## 🔍 `type()` -  consultar el tipo de un objeto

```python
>>> variable = 1 + 4j
>>> type(variable)
<class 'complex'>
```

Como todo en Python es un objeto, `type()` funciona con cualquier valor:

```python
>>> type(42)        # <class 'int'>
>>> type([1, 2])     # <class 'list'>
>>> type(suma_func)  # <class 'function'>
```

---

## 🔁 Funciones de conversión (casting)

| Función | Convierte a |
|---|---|
| `int(x)` | Entero |
| `float(x)` | Decimal |
| `str(x)` | Cadena |
| `bool(x)` | Booleano |
| `list(x)` | Lista |
| `tuple(x)` | Tupla |

---

## ✅ Resumen

- Todo valor en Python **es un objeto** con un tipo asociado.
- El tipo se infiere automáticamente, pero las operaciones entre tipos incompatibles **lanzan `TypeError`**.
- `type()` te dice exactamente con qué clase estás trabajando — útil para depurar.
- Convierte explícitamente con `int()`, `float()`, `str()`, etc. antes de operar entre tipos distintos.

## ⚠️ Errores comunes

- Sumar un `int` con un `str` sin convertir (`1 + '2'` ❌).
- Olvidar que `input()` **siempre** devuelve `str`, aunque el usuario escriba un número.
