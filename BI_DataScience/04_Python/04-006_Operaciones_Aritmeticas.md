# ➗ 04-006 · Operaciones aritméticas

> **Idea clave:** Python soporta los operadores aritméticos habituales, más dos "extras" útiles: **división entera** (`//`) y **módulo** (`%`). El operador `+=` también funciona sobre listas, no solo sobre números.

---

## 🧮 Operadores básicos

```python
print(1 + 3)   # Suma            → 4
print(3 - 1)   # Resta           → 2
print(3 * 2)   # Multiplicación  → 6
print(4 / 2)   # División        → 2.0
```

| Operador | Nombre | Resultado con `4 / 2` |
|---|---|---|
| `+` | Suma | - |
| `-` | Resta | - |
| `*` | Multiplicación | - |
| `/` | División **real** (siempre `float`) | `2.0` |

> ⚠️ `/` **siempre devuelve `float`, aunque la división sea exacta** (`4 / 2` → `2.0`, no `2`).

---

## 🔢 División entera y módulo

```python
print(20 // 2)   # 10  ← división entera (descarta decimales)
print(15 % 4)    # 3   ← resto de la división
```

| Operador | Nombre | Uso típico |
|---|---|---|
| `//` | Floor division | Repartos exactos, cálculo de páginas, etc. |
| `%` | Módulo (resto) | Comprobar paridad (`n % 2 == 0`), ciclos, horas |

---

## 📋 Aritmética con listas: `+=`

Sobre listas, `+=` **no suma números** - **concatena** elementos:

```python
lista = [4, 6]
valor = [5]
lista += valor
print(lista)        # [4, 6, 5]

lista += ['cadena']
print(lista)         # [4, 6, 5, 'cadena']

lista += ['cadena2']
print(lista)          # [4, 6, 5, 'cadena', 'cadena2']
```

> 💡 `lista += [x]` equivale a `lista.append(x)` cuando añades un único elemento, pero `+=` requiere que el otro operando sea **iterable** (por eso `['cadena']` y no `'cadena'` suelto - aunque un string también es iterable, cuidado con el resultado).

---

## ✅ Resumen

| Necesito... | Uso |
|---|---|
| Resultado exacto con decimales | `/` |
| Solo la parte entera | `//` |
| Solo el resto | `%` |
| Añadir elementos a una lista | `lista += [elemento]` o `.append()` |

## ⚠️ Errores comunes

- Esperar que `/` devuelva `int` cuando la división es exacta.
- Confundir `lista += valor` (concatenación) con suma aritmética si `valor` no es una lista.