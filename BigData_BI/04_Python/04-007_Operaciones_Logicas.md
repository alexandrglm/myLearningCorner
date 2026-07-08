# 🧠 04-007 · Operaciones lógicas

> **Idea clave:** Python distingue entre **igualdad de valor** (`==`) e **identidad de objeto** (`is`). Confundirlos es una de las fuentes de bugs más comunes para quien viene de otros lenguajes.

---

## 🆔 `is` vs `==`: identidad vs. igualdad

```python
alpha = [1, 2, 3]
beta = [1, 2, 3]

print(alpha is beta)   # False → mismos VALORES, pero objetos distintos en memoria
print(alpha == beta)   # True  → mismo contenido
```

| Operador | Pregunta | Compara |
|---|---|---|
| `==` | ¿Tienen el mismo **valor**? | Contenido |
| `is` | ¿Son el **mismo objeto** en memoria? | Identidad (`id()`) |

```python
print(alpha is None)       # False → alpha SÍ apunta a un objeto
print(alpha is not None)   # True
```

---

## 🕳️ `None` y la identidad

```python
alpha = None
print(alpha is None)   # True

print(id(alpha))        # ej: 4395468904
```

> 💡 `None` representa "ausencia de valor", pero sigue siendo **un objeto real** con su propio `id()`. Por convención, siempre se compara con `is None` (nunca `== None`), precisamente porque es una comprobación de identidad.

---

## ⚖️ Operadores de comparación

```python
Q, W, E = 10, 20, 10

print(Q == W)   # False
print(Q == E)   # True
print(Q != W)   # True   → Q es distinto de W
print(Q > W)    # False  → Q NO es mayor que W
print(Q < E)    # False  → Q NO es menor que E (son iguales)
print(Q > 1)    # True
print(Q >= 10)  # True
```

| Operador | Significado |
|---|---|
| `==` | Igual a |
| `!=` | Distinto de |
| `>` `<` | Mayor / menor que |
| `>=` `<=` | Mayor o igual / menor o igual |

---

## 🔗 Comparaciones encadenadas

Exclusivo de Python - puedes encadenar comparaciones como en matemáticas:

```python
print(1 < Q < 2)      # False → Q=10 no está entre 1 y 2
print(0 < W < 100)    # True  → W=20 sí está entre 0 y 100
```

Equivale a `1 < Q and Q < 2`, pero más legible.

---

## ✅ Resumen

- `==` compara **valores**; `is` compara **identidad de objeto**.
- Usa siempre `is None` / `is not None`, nunca `== None`.
- Python permite comparaciones encadenadas: `a < b < c`.

## ⚠️ Errores comunes

- Usar `is` para comparar contenido de listas/dicts (casi siempre da `False` aunque el contenido sea igual).
- Comparar con `== None` en vez de `is None`.