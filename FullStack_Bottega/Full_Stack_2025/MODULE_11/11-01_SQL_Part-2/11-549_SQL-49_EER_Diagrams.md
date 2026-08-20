# 11-549 SQL 49 - Diagramas EER (Modelado Visual)

## ¿Qué es un Diagrama EER?

**EER** (Enhanced Entity-Relationship) es una representación visual de la estructura de tu base de datos.

- **EER**: Visualización de estructura de BD
- **Command + R**: Generar diagrama
- **Muestra**: Tablas, relaciones, índices, tipos
- **No modifica**: Solo visualiza
- **Útil**: Para BDs grandes y complejas
- **Alternativa**: Crear/editar tablas visualmente
- **Preferencia**: Elige tu herramienta favorita


## Crear EER Diagram en MySQL Workbench

### Método 1: Atajo
**Command + R** (Mac) o **Ctrl + R** (Windows)

### Método 2: Menú
Database → Reverse Engineer

### Pasos
1. Seleccionar conexión (ej: dev_camp_course)
2. Continue
3. Seleccionar database específico
4. Continue
5. Execute
6. Close

## Qué Muestra

El diagrama muestra:
- Todas las tablas del schema
- Columnas y tipos de datos
- Primary keys
- Foreign keys
- Índices
- **Relaciones entre tablas** (con flechas)

## No es Magia

**Importante**: El diagrama es solo otra **vista** de tus datos. No crea nada nuevo, solo visualiza lo existente.

## Utilidad

### Con Pocas Tablas (3-4)
No es crítico - fácil ver relaciones directamente.

### Con Muchas Tablas
**Muy útil** - difícil ver conexiones sin visualización.

## Leer el Diagrama

### Flechas/Conectores
```
addresses ──→ users
```
La flecha apunta de tabla secundaria (addresses) a tabla principal (users).

### Foreign Keys
Se ven visualmente las conexiones:
- `addresses_users_id` → `users_id`
- `guides_users_id` → `users_id`

### Índices
Click en el ícono muestra todos los índices de la tabla (ej: postal_code).

## Relaciones

### One-to-Many (1:N)
```
users ──┬→ addresses
        └→ guides
```

Triángulo/flecha indica: un usuario tiene muchas direcciones/guías.

### Tablas Sin Relaciones
`ugly_table` aparece sin conexiones porque no tiene foreign keys.

## Ventajas de Visualización

- **Ver conexiones**: Cómo se relacionan las tablas
- **Entender schema**: Rápido overview de estructura
- **Documentación**: Visual para nuevos desarrolladores
- **Detectar problemas**: Tablas huérfanas, relaciones faltantes

## Crear Tablas Desde el Diagrama

Puedes construir todo el database desde el EER:
- Crear tablas
- Definir columnas
- Establecer relaciones
- Configurar foreign keys

**Nota**: El instructor prefiere hacerlo en la interfaz estándar, pero es preferencia personal.

## Similar a UML

Si conoces **UML** (Unified Modeling Language), EER es similar pero específico para bases de datos.

## Panel Izquierdo

Muestra detalles de relaciones:
- Tipo de relación (1:1, 1:N, N:M)
- Cardinalidad
- Constraints

## Uso Recomendado

- **Entender BDs existentes**: Especialmente las grandes
- **Documentar**: Guardar imagen del diagrama
- **Planear**: Antes de implementar
- **Presentar**: A equipos o stakeholders

## Preferencia Personal

Algunas personas prefieren:
- ✅ Visual (EER diagrams)
- ✅ Código (CREATE TABLE scripts)
- ✅ GUI (MySQL Workbench interface)

**Todos son válidos** - usa el que te funcione mejor.


