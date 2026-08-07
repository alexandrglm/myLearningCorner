# 🗂️ 04-004 · Diccionarios

> **Idea clave:** Un `dict` es una colección de pares **clave: valor**. A diferencia de listas/tuplas, no se accede por posición numérica, sino **por clave** , ideal para representar objetos del mundo real (usuarios, configuraciones, registros).

---

## 🏗️ Creación y estructura

```python
Diccionario = {'Username': 'pedro8978', 'mail': 'mail@mail.com'}
print(Diccionario)
# {'Username': 'pedro8978', 'mail': 'mail@mail.com'}
```

| Elemento | Rol |
|---|---|
| `'Username'` | Clave (key) - debe ser única e inmutable (`str`, `int`, `tuple`...) |
| `'pedro8978'` | Valor (value) - puede ser de cualquier tipo |

---

## 🔑 Acceder a claves y valores

```python
print(Diccionario.keys())
# dict_keys(['Username', 'mail'])

print(Diccionario.values())
# dict_values(['pedro8978', 'mail@mail.com'])

print(Diccionario['Username'])
# pedro8978
```

| Método | Devuelve |
|---|---|
| `.keys()` | Vista con todas las claves |
| `.values()` | Vista con todos los valores |
| `.items()` | Vista con pares `(clave, valor)` |
| `.get(k, default)` | Valor de `k`, o `default` si no existe (sin lanzar error) |

---

## ➕ Añadir, modificar y eliminar

```python
Diccionario['edad'] = 25          # añade una nueva clave
Diccionario['Username'] = 'pedro9000'  # modifica el valor existente
del Diccionario['mail']            # elimina la clave 'mail'
```

> 💡 `Diccionario['clave_inexistente']` lanza `KeyError`. Usa `.get('clave', None)` si no estás seguro de que la clave existe.

---

## 🔁 Recorrer un diccionario

```python
for clave, valor in Diccionario.items():
    print(f'{clave}: {valor}')
```

---

## ✅ Resumen

- `dict` = pares `clave: valor`, acceso rápido por clave (no por índice numérico).
- Las claves deben ser **únicas** e **inmutables**.
- `.keys()`, `.values()`, `.items()` son las tres formas de "mirar dentro" de un diccionario.
- Usa `.get()` en vez de `[]` cuando no estés seguro de que la clave existe - evita `KeyError`.