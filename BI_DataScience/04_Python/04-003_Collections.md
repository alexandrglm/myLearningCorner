# 📦 04-003 · Colecciones de tipos de datos

> **Idea clave:** Las colecciones agrupan varios valores en un solo objeto. Python ofrece dos secuencias básicas ( **tuplas** y **listas** ) que se diferencian sobre todo por su **mutabilidad**.

---

## 🆚 Tuplas vs. Listas

| Característica | `tuple` | `list` |
|---|---|---|
| Sintaxis | `(2, 'coche', '5', 2.3)` | `[2, 4, 'Hola', 46]` |
| Mutabilidad | ❌ Inmutable | ✅ Mutable |
| Rendimiento | Más rápida y ligera | Más flexible, algo más costosa |
| Uso típico | Datos que no deben cambiar (coordenadas, registros fijos) | Datos que crecen o se modifican dinámicamente |

```python
tupla = (2, 'coche', '5', 2.3)
print(tupla)          # (2, 'coche', '5', 2.3)

lista = [2, 4, 'Hola', 3 + 43]
print(lista)           # [2, 4, 'Hola', 46]
```

> 💡 Fíjate que `3 + 43` se evalúa **antes** de guardarse en la lista → se almacena `46`, no la expresión.

---

## 🪆 Anidamiento

Las colecciones pueden contener otras colecciones dentro:

```python
lista = [2, 4, 'Hola', tupla]
print(lista)
# [2, 4, 'Hola', (2, 'coche', '5', 2.3)]

print(len(lista))   # 4  ← la tupla anidada cuenta como UN solo elemento
```

---

## 🛠️ Métodos esenciales de `list`

| Método | Efecto | Ejemplo |
|---|---|---|
| `.append(x)` | Añade `x` al final | `lista.append('Nuevo')` |
| `.remove(x)` | Elimina la **primera** aparición de `x` | `lista.remove('Nuevo')` |
| `.insert(i, x)` | Inserta `x` en la posición `i` | `lista.insert(0, 'Primero')` |
| `.pop(i)` | Elimina y devuelve el elemento en `i` | `lista.pop()` |
| `.sort()` | Ordena la lista in-place | `lista.sort()` |
| `.reverse()` | Invierte el orden | `lista.reverse()` |

```python
lista.append('Nuevo')
print(lista)   # [2, 4, 'Hola', (2, 'coche', '5', 2.3), 'Nuevo']

lista.remove('Nuevo')
print(lista)   # [2, 4, 'Hola', (2, 'coche', '5', 2.3)]
```

---

## 🎯 Indexación y reemplazo

```python
print(lista[0])          # 2  ← primer elemento (índice 0)

lista[2] = 4 + 4j        # las listas SÍ permiten reasignar por índice
print(lista)              # [2, 4, (4+4j), (2, 'coche', '5', 2.3)]
```

> ⚠️ Esto **no funcionaría con una tupla** — `tupla[0] = 5` lanzaría `TypeError: 'tuple' object does not support item assignment`.

---

## ✅ Resumen

- **Lista** = colección mutable → usa corchetes `[]`.
- **Tupla** = colección inmutable → usa paréntesis `()`.
- `len()` cuenta elementos de primer nivel, sin "desempaquetar" colecciones anidadas.
- Para modificar listas: `append()`, `remove()`, `insert()`, `pop()`, o indexación directa `lista[i] = valor`.