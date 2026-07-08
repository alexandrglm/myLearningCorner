# 🧩 04-010 · Funciones

> **Idea clave:** Una función encapsula un bloque de código reutilizable. En Python se declara con `def`, y **es en sí misma un objeto**, que puede asignarse a variables, pasarse como argumento, etc.

---

## 🈳 Función sin argumentos

```python
def suma():
    a = input('Introduzca un dato: ')
    b = input('Introduzca el segundo dato: ')
    print(int(a) + int(b))   # convertimos ANTES de sumar

suma()
```

**Salida:**
```
Introduzca un dato: 1
Introduzca el segundo dato: 3
4
```

---

## 📥 Función con argumentos

```python
def resta(a, b):
    print(int(a) - int(b))

u = input('Introduzca un dato: ')
v = input('Introduzca el segundo dato: ')
resta(u, v)
```

**Salida:**
```
Introduzca un dato: 6
Introduzca el segundo dato: 1
5
```

---

## 📤 `print()` dentro de la función vs. `return`

Ambos ejemplos usan `print()` **dentro** de la función - el resultado se muestra, pero **no se puede reutilizar** fuera de ella.

```python
def resta_v2(a, b):
    return int(a) - int(b)   # devuelve el valor, no lo imprime

resultado = resta_v2(6, 1)
print(resultado * 2)   # ahora SÍ puedes operar con el resultado → 10
```

| Enfoque | Ventaja | Limitación |
|---|---|---|
| `print()` dentro de la función | Rápido de escribir | El valor se "pierde": no se puede reutilizar |
| `return valor` | El resultado queda disponible para seguir operando | Hay que imprimirlo explícitamente si quieres verlo |

> 💡 **Buena práctica:** las funciones deberían `return` sus resultados. Deja que quien llama a la función decida si imprime, guarda o sigue operando con el valor.

---

## 🧾 Anatomía de una función

```python
def nombre_funcion(param1, param2='valor_por_defecto'):
    """Docstring: describe qué hace la función."""
    # cuerpo de la función
    resultado = param1 + param2
    return resultado
```

| Elemento | Rol |
|---|---|
| `def` | Palabra clave que inicia la declaración |
| `nombre_funcion` | Identificador con el que se invoca |
| `(param1, param2=...)` | Parámetros; pueden tener valores por defecto |
| `return` | Devuelve un valor al punto donde se llamó la función |

---

## ✅ Resumen

- `def` declara una función; se ejecuta solo al **invocarla** con `()`.
- Los parámetros que llegan por `input()` son `str` - conviértelos con `int()`/`float()` antes de operar.
- Preferir `return` sobre `print()` dentro de la función hace el código más flexible y reutilizable.