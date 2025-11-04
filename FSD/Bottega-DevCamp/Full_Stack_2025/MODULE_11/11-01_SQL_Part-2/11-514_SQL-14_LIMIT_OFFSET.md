# 11-514 SQL 14 - LIMIT y OFFSET

## ¿Por qué usar LIMIT?

- MySQL limita por defecto a 1000 registros
- Traer todos los registros puede ser muy lento en aplicaciones web
- Mejor experiencia de usuario mostrando datos paginados
- Permite implementar paginación

## LIMIT Simple

Limita el número de registros retornados:

```sql
SELECT * FROM users LIMIT 10;
```

Retorna solo los primeros 10 registros.

## LIMIT con OFFSET

### Sintaxis

```sql
SELECT * FROM users LIMIT 5, 10;
```

- **Primer número (5)**: OFFSET - cuántos registros saltar
- **Segundo número (10)**: LIMIT - cuántos registros retornar

### Cómo Funciona

```sql
LIMIT 10;        -- Registros 1-10
LIMIT 5, 10;     -- Registros 6-15 (salta los primeros 5)
LIMIT 15, 10;    -- Registros 16-25 (salta los primeros 15)
```

## Implementar Paginación

El OFFSET permite crear paginación:

- **Página 1**: `LIMIT 0, 10` → registros 1-10
- **Página 2**: `LIMIT 10, 10` → registros 11-20
- **Página 3**: `LIMIT 20, 10` → registros 21-30

### Fórmula para Paginación

```
OFFSET = (página - 1) × registros_por_página
```

## Ventajas

- SQL hace el trabajo de filtrado
- No necesitas traer todo el dataset y filtrarlo manualmente
- Mejor rendimiento
- Control preciso sobre qué registros mostrar

## Nota sobre IDs Faltantes

Si se han eliminado registros, los IDs pueden tener huecos (ej: 1, 2, 3, 5, 6...). LIMIT y OFFSET cuentan registros existentes, no IDs.
