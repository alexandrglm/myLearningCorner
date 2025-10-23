# 07-040 - Hacer el Request GET Inicial de API en React

**Guía**: https://devcamp.com/pt-full-stack-development-javascript-python-react/guide/making-initial-api-get-request-react

**Source Code**: [Aqui](https://github.com/jordanhudgens/jordan-hudgens-react-portfolio/tree/ccec44651066cc653517d2bb5f024b4f6819ebf2)

---

## 🎯 CONCEPTOS FUNDAMENTALES

### El Momento Decisivo: Local → API

**Transición fundamental**:

- **Aplicación local** → **Comunicación con servidor externo**
- **Datos hardcoded** → **Datos dinámicos de API**
- **Funcionamiento** como aplicaciones web/mobile modernas

### Metodología de Aprendizaje

**Enfoque pedagógico**:

- **Usar documentación** real de Axios
- **No memorizar** código de tutoriales
- **Aprender a investigar** nuevas librerías
- **Proceso transferible** a cualquier tecnología

### Seguridad y Tipos de Endpoints

**Endpoints públicos** (como portfolio items):

- **No requieren autenticación** - abiertos al público
- **Safe para GET requests** - solo lectura
- **Perfect primer ejemplo** - sin complejidad de seguridad

**Endpoints privados** (crear/editar/eliminar):

- **Requieren autenticación** - protección necesaria
- **Security breach potential** - solo usuarios autorizados
- **Implementación futura** - después de aprender basics

---

## 🔍 USANDO DOCUMENTACIÓN DE AXIOS

### Acceder a Documentación Oficial

**Proceso de investigación**:

1. **Ir a Axios documentation page**
2. **Buscar "example"** después de installation
3. **Copiar código de ejemplo** - real-life implementation
4. **Adaptar a necesidades** específicas del proyecto

### Código Base de Documentación

**Ejemplo oficial de Axios**:

```javascript
axios.get('/user?ID=12345')
  .then(function (response) {
    console.log(response);
  })
  .catch(function (error) {
    console.log(error);
  });
```

**Por qué este ejemplo es perfecto**:

- **GET request** - exactamente lo que necesitamos
- **Promise-based** - manejo moderno de async
- **Error handling** - catch para problemas
- **Console logging** - para debugging inicial

---

## 🛠️ PASOS PRÁCTICOS - IMPLEMENTACIÓN

### 1. Importar Axios en App.js

**Archivo**: `src/components/app.js`

Después de imports existentes:

```javascript
import React, { Component } from 'react';
import moment from 'moment';
import axios from 'axios'; // Nueva importación

// resto de imports...
```

### 2. Crear Función getPortfolioItems

**Dentro de la clase App**, arriba del método render:

```javascript
getPortfolioItems() {
  axios.get('https://tu-subdomain.devcamp.space/portfolio/portfolio_items')
    .then(response => {
      console.log("response data", response);
    })
    .catch(error => {
      console.log(error);
    });
}
```

**⚠️ CRÍTICO - Usar Arrow Functions**:

- **Cambiar** `function (response)` → `response =>`
- **Razón**: `this` keyword scoping en React
- **Sin arrow functions** → bugs al actualizar state futuro

### 3. Obtener URL de DevCamp Space

**Proceso**:

1. **Ir a DevCamp Space** dashboard
2. **Click Portfolio project**
3. **Copiar URL** de "All Items" endpoint
4. **Reemplazar en código** con tu subdomain específico

**URL pattern**:

```
https://TU-SUBDOMAIN.devcamp.space/portfolio/portfolio_items
```

### 4. Configurar Constructor y Binding

**Al inicio de la clase App**:

```javascript
export default class App extends Component {
  constructor() {
    super();

    // Binding para método custom
    this.getPortfolioItems = this.getPortfolioItems.bind(this);
  }

  getPortfolioItems() {
    // ... código axios
  }

  render() {
    // ... resto del código
  }
}
```

### 5. Llamar la Función en Render

**Dentro del método render**, antes del return:

```javascript
render() {
  this.getPortfolioItems(); // Llamada temporal para testing

  return (
    <div className="app">
      {/* resto del JSX */}
    </div>
  );
}
```

**⚠️ NOTA**: Esta es implementación temporal - en producción usaremos lifecycle methods.

---

## 📊 VERIFICACIÓN DE DATOS

### Preparar Datos de Prueba

**En DevCamp Space**:

1. **Verificar portfolio items** - debe tener al menos algunos
2. **Agregar más si necesario** - usar formulario web
3. **Confirmar en API endpoint** - verificar JSON response

### Testing en Browser

**Proceso de verificación**:

1. **Abrir localhost:3000**
2. **Abrir DevTools** → Console tab
3. **Hacer refresh** de página
4. **Buscar console logs** con response data

### Interpretando el Response

**Estructura esperada**:

```javascript
// Console output
"response data" 
{
  data: [
    {
      id: 1,
      name: "Portfolio Item 1",
      description: "...",
      url: "...",
      category: "...",
      // más propiedades
    },
    // más items...
  ],
  status: 200,
  statusText: 'OK',
  // más metadata
}
```

**Elementos clave**:

- **response.data** - array con portfolio items
- **status: 200** - request exitoso
- **Número de items** debe coincidir con DevCamp Space

---

## 🔧 CONCEPTOS TÉCNICOS IMPORTANTES

### Arrow Functions vs Regular Functions

**Regular function** (problemático en React):

```javascript
.then(function (response) {
  // 'this' no apunta a component
  console.log(response);
})
```

**Arrow function** (correcto para React):

```javascript
.then(response => {
  // 'this' mantiene scope del component
  console.log(response);
})
```

**Por qué es crítico**:

- **Próximamente usaremos** `this.setState()`
- **Arrow functions preservan** `this` context
- **Regular functions cambian** `this` context
- **Bug común** en React development

### Binding en Constructor

**Por qué necesitamos bind**:

```javascript
this.getPortfolioItems = this.getPortfolioItems.bind(this);
```

**Explicación**:

- **Custom methods** pierden context automáticamente
- **Binding** conecta method con component instance
- **Permite acceso** a `this.state`, `this.setState`, etc.
- **Pattern estándar** en React class components

### Ubicación Temporal en Render

**Por qué llamamos función en render**:

- **Solo para testing** - verificar que API funciona
- **Debugging purpose** - ver data en console
- **NO es best practice** para producción
- **Próximamente moveremos** a lifecycle method apropiado

---

## 📱 COMPORTAMIENTO ESPERADO

### Flujo de Datos Completo

**Secuencia de eventos**:

1. **React app carga** → render() ejecuta
2. **getPortfolioItems()** llamada → axios.get() inicia
3. **HTTP request** enviado → DevCamp Space server
4. **Server responde** → JSON data regresa
5. **Promise resolves** → .then() ejecuta
6. **Console.log** muestra → data visible en DevTools

### Verificación de Éxito

**Indicadores de funcionamiento correcto**:

- ✅ **No errors** en console
- ✅ **"response data"** aparece en console
- ✅ **Array de portfolio items** visible al expandir
- ✅ **Número de items** coincide con DevCamp Space
- ✅ **Status 200** en response object

### Troubleshooting Común

**Si no aparecen datos**:

1. **Verificar URL** - debe incluir tu subdomain
2. **Check DevCamp Space** - confirmar que tienes portfolio items
3. **Network tab** - ver si request se está haciendo
4. **CORS issues** - DevCamp Space debería estar configurado correctamente

---

## 🔄 COMPARACIÓN: ANTES VS DESPUÉS

### Datos Hardcoded (Antes)

```javascript
this.state = {
  data: [
    { title: "Quip", category: "eCommerce" },
    { title: "Eventbrite", category: "Scheduling" }
  ]
};
```

### Datos de API (Ahora)

```javascript
// Response from DevCamp Space
{
  data: [
    {
      id: 8,
      name: "Test Portfolio Item",
      description: "Real description from API",
      url: "https://google.com",
      category: "enterprise",
      portfolio_item_images: [...]
    }
    // Real, dynamic data
  ]
}
```

**Diferencias clave**:

- **Dynamic vs static** - datos pueden cambiar
- **More properties** - id, images, descriptions completas
- **Real URLs** - links funcionales
- **Server-managed** - actualizaciones centralizadas

---

## ✅ VERIFICACIÓN Y PRÓXIMOS PASOS

### Checklist de Verificación

- [ ] **Axios importado** correctamente en app.js
- [ ] **getPortfolioItems function** creada con arrow functions
- [ ] **Constructor y binding** implementados
- [ ] **URL correcta** con tu subdomain de DevCamp Space
- [ ] **Función llamada** en render method
- [ ] **Console logs** muestran response data
- [ ] **Array de portfolio items** visible en console

### Testing Manual

**Pasos de verificación**:

1. **npm start** - servidor corriendo
2. **Browser → localhost:3000**
3. **DevTools → Console**
4. **Refresh page**
5. **Ver "response data"** en console
6. **Expandir object** - verificar array de items


