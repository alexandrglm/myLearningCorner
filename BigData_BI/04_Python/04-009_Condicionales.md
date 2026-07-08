# 🔀 04-009 · Condicionales y bucles

> **Idea clave:** Python no usa llaves `{}` para delimitar bloques - usa **indentación**. Un error de sangría no es un detalle estético: es un `IndentationError` o, peor, un bug silencioso.

---

## 🧭 El condicional `if` / `elif` / `else`

```python
Dato1 = input('Introduzca el dato 1: ')
Dato2 = input('Introduzca el dato 2: ')
Dato3 = input('Introduzca el dato 3: ')

# Condición AND: se cumplen AMBAS a la vez
if Dato1 < Dato2 and Dato1 < Dato3:
    print('Dato1 es menor que Dato2 y Dato3')
else:
    print('Dato1 NO es menor que Dato2 y Dato3 al mismo tiempo')

# Condición OR: se cumple AL MENOS UNA
if Dato1 < Dato2 or Dato1 < Dato3:
    print('Dato1 es menor que Dato2 o Dato3')
else:
    print('Dato1 NO es ni menor que Dato2 ni menor que Dato3')
```

**Salida** (con `Dato1=4`, `Dato2=1`, `Dato3=7`):
```
Dato1 NO es menor que Dato2 y Dato3 al mismo tiempo
Dato1 es menor que Dato2 o Dato3
```

> ⚠️ **Trampa clásica:** `input()` devuelve `str`. `'4' < '1'` compara **lexicográficamente** (por código de carácter), no numéricamente. Para comparar números reales hay que convertir: `int(Dato1) < int(Dato2)`.

| Operador lógico | Se cumple cuando |
|---|---|
| `and` | **Todas** las condiciones son verdaderas |
| `or` | **Al menos una** condición es verdadera |
| `not` | Invierte el valor de verdad |

---

## 🔁 Bucle `for` - iterar sobre una colección

```python
tupla = (0, 2+1j, 2+3j, '2+3j', 'alpha')

for x in tupla:
    print(x)
```

**Salida:**
```
0
(2+1j)
(2+3j)
2+3j
alpha
```

> 💡 `for` en Python siempre recorre un **iterable** (lista, tupla, cadena, dict, `range()`...), no un contador clásico `for(i=0; i<n; i++)`.

---

## 🧪 `for` + `if/elif` - clasificar caracteres

Ejemplo completo: clasificar cada carácter de una cadena según su tipo.

```python
cadena = 'adf0d889234!"-o$%&()hjhk879u482&/hih()j678H/&4g'

numeros = []
simbolos = []
vocales = []
consonantes = []

for c in cadena:
    if c in '0123456789':
        numeros.append(c)
    elif c in 'qzwsxdcrfvtgbyhnjmklpñ':
        consonantes.append(c)
    elif c in 'aeiou':
        vocales.append(c)
    else:
        simbolos.append(c)

print('Los números son: ', numeros)
print('Los símbolos son: ', simbolos)
print('Las consonantes son: ', consonantes)
print('Las vocales son: ', vocales)
```

> ⚠️ Fíjate en la **indentación consistente**: `for`, `if`, `elif`, `else` cada uno abre un nuevo nivel de sangría (normalmente 4 espacios). Mezclar tabs y espacios rompe el script.

---

## 🔂 Bucle `while` - repetir mientras se cumpla una condición

```python
a = 0

while a < 10:
    print(a)
    a += 1   # equivale a: a = a + 1
```

**Salida:** `0 1 2 3 4 5 6 7 8 9`

> ⚠️ **Cuidado con los bucles infinitos:** si olvidas `a += 1`, la condición `a < 10` nunca deja de cumplirse.

---

## ✅ Resumen

| Estructura | Se usa cuando... |
|---|---|
| `if/elif/else` | Necesitas ramificar según una condición |
| `for` | Sabes de antemano sobre qué colección iterar |
| `while` | Repites hasta que se cumpla (o deje de cumplirse) una condición, sin saber cuántas vueltas serán |

## ⚠️ Errores comunes

- Comparar strings numéricos (`'4' < '10'` → `False`, porque compara carácter a carácter).
- Indentación inconsistente entre bloques.
- Olvidar actualizar la variable de control en un `while` → bucle infinito.