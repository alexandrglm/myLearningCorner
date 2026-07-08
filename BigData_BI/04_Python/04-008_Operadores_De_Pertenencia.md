# 🔎 04-008 · Operadores de pertenencia

> **Idea clave:** `in` y `not in` comprueban si un elemento existe dentro de una colección (tupla, lista, set, dict) o dentro de una cadena, **sin necesidad de bucles**.

---

## 📌 `in` - ¿está contenido?

```python
tupla = (1, '2', 'Hola', 2 + 3j)

print(2 + 3j in tupla)   # True → el complejo (2+3j) SÍ está en la tupla
```

## 🚫 `not in` - ¿NO está contenido?

```python
print('alpha' not in tupla)   # True → 'alpha' NO está en la tupla
```

## 🔤 `in` sobre cadenas - búsqueda de subcadenas

```python
print('Diego' in 'Diego es un crack en Python')   # True
```

> 💡 Sobre un `str`, `in` no busca un carácter suelto: busca la **subcadena completa**, en cualquier posición.

---

## 📋 Tabla resumen

| Expresión | Aplica a | Devuelve |
|---|---|---|
| `x in coleccion` | list, tuple, set, dict (busca en claves), str | `True` si `x` está presente |
| `x not in coleccion` | igual que arriba | `True` si `x` **no** está presente |

```python
# En un dict, 'in' comprueba las CLAVES, no los valores
d = {'a': 1, 'b': 2}
print('a' in d)     # True
print(1 in d)         # False ← 1 es un valor, no una clave
```

---

## ✅ Resumen

- `in` / `not in` evitan escribir bucles manuales para comprobar existencia.
- Funcionan sobre listas, tuplas, sets, cadenas... y sobre las **claves** de un diccionario.
- Es la forma "pythónica" de preguntar "¿está esto dentro de aquello?".