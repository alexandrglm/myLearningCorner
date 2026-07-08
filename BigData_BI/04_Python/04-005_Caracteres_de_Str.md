# 🔤 04-005 · Caracteres de una cadena (`str`)

> **Idea clave:** Una cadena en Python es una **secuencia indexada e inmutable** de caracteres. Se accede a sus elementos igual que en una lista: con corchetes `[]`.

---

## 📍 Indexación positiva y negativa

```python
variable = 'Python es el mejor'

print(variable[0])    # 'P'   ← primer carácter (índice 0)
print(variable[-1])   # 'r'   ← último carácter (índice -1)
```

| Índice | Dirección | Ejemplo |
|---|---|---|
| `0, 1, 2, ...` | De izquierda a derecha | `variable[0]` → primer carácter |
| `-1, -2, -3, ...` | De derecha a izquierda | `variable[-1]` → último carácter |

```
 P   y   t   h   o   n   ...   j   o   r
 0   1   2   3   4   5        -3  -2  -1
```

---

## 💥 `IndexError`: fuera de rango

```python
print(variable[-45])
# IndexError: string index out of range
```

`'Python es el mejor'` tiene 19 caracteres, así que los índices válidos van de `-19` a `18`. Pedir `-45` excede ese rango por ambos lados.

---

## ✂️ Bonus: slicing (troceado)

Aunque no estaba en el ejercicio original, es la extensión natural de la indexación:

```python
print(variable[0:6])    # 'Python'
print(variable[7:])      # 'es el mejor'
print(variable[::-1])    # cadena invertida
```

---

## ✅ Resumen

- `str[i]` accede a un carácter por índice, positivo o negativo.
- Las cadenas son **inmutables**: no puedes hacer `variable[0] = 'X'`.
- Un índice fuera del rango `[-len(s), len(s)-1]` lanza `IndexError`.