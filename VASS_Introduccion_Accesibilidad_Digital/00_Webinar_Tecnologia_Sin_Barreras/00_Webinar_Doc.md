# Resumen: VASS Webinar Accesibilidad Web

**Acceso**: [Aquí](https://www.youtube.com/watch?v=udgNQxPbhY0)
**Título:** Accesibilidad Web: Tecnología sin barreras

**Ponentes:** Sonia Martínez (Líder de desarrollo de interfaz de usuario) y Fernando Contoneo (Especialista en diseño de sistemas y producto).

**Objetivo:** Proporcionar una visión completa y práctica sobre la accesibilidad web, abarcando desde la normativa vigente hasta recomendaciones técnicas para diseño y desarrollo.

## Índice

1. Introducción y Contexto Normativo
   - ¿De qué hablamos cuando hablamos de accesibilidad web?
   - La Directiva Europea de Accesibilidad: Un hito inminente (21 de junio de 2025).
   - La base técnica: Las Pautas de Accesibilidad para el Contenido Web (WCAG).

2. El Valor de la Accesibilidad: Un Beneficio Universal
   - Más allá de la obligación legal: Responsabilidad social y oportunidad de negocio.
   - La accesibilidad como mejora de la experiencia de usuario (UX) para todos.

3. Usuarios y sus Necesidades: La Diversidad Funcional
   - Espectro de usuarios: Discapacidad visual, auditiva, cognitiva y motora.
   - La importancia de la empatía y el diseño centrado en el usuario.

4. Conceptos Fundamentales: Inclusividad, Usabilidad y Accesibilidad
   - Las tres capas de un entorno digital inclusivo.
   - Los cuatro principios rectores de la accesibilidad (POUR): Perceptible, Operable, Comprensible y Robusto.

5. Metodología de Trabajo: La Clave del Éxito
   - El modelo tradicional vs. el modelo colaborativo entre diseño y desarrollo.
   - El enfoque atómico: Sistemas de diseño y Design Tokens como base para la accesibilidad.
   - Caso de éxito: Proyecto "Pan" (banca digital).

6. Guía Práctica: Principales Errores y Cómo Solucionarlos
   - Top 6 errores más comunes en accesibilidad web (datos y soluciones).

7. Herramientas y Recursos para el Día a Día
   - Para perfiles de diseño (Figma y Plugins).
   - Para perfiles de desarrollo (Validación y testing).

8. Conclusiones Finales

## 1. Introducción y Contexto Normativo

### ¿De qué hablamos cuando hablamos de accesibilidad web?

La accesibilidad web no es una característica opcional ni un lujo, sino la práctica de garantizar que todas las personas, independientemente de sus capacidades o de las condiciones en las que accedan, puedan percibir, entender, navegar e interactuar con la web. Se trata de eliminar barreras en el entorno digital.

### La Directiva Europea de Accesibilidad: Un hito inminente

Existe un marco legal que está marcando un antes y un después: la Directiva Europea de Accesibilidad. Su fecha clave es el 21 de junio de 2025. A partir de este momento, todos los nuevos productos y servicios digitales (webs y aplicaciones) que salgan al mercado deberán cumplir con los requisitos de accesibilidad.

- **Origen:** La directiva europea se publicó en 2019, dando un margen a los países miembros para adaptarla a su legislación nacional (proceso de transposición).

- **Alcance:** Inicialmente se aplica a nuevos desarrollos, pero en el futuro se extenderá a productos existentes y otros ámbitos como llamadas de emergencia o terminales de autoservicio.

### La base técnica: Las Pautas de Accesibilidad para el Contenido Web (WCAG)

Para cumplir con la ley, los equipos técnicos se basan en un estándar internacional: las WCAG (Web Content Accessibility Guidelines) , publicadas por el W3C (World Wide Web Consortium).

- **Versión actual:** WCAG 2.1 es la referencia normativa actual. Ya existe la versión 2.2, que previsiblemente se convertirá en el estándar de cara a 2025.

- **Niveles de conformidad:**
  - A: El nivel más básico.
  - AA: El nivel exigido por la directiva europea para la mayoría de los casos. Es el objetivo a cumplir.
  - AAA: El nivel más alto y exigente, que busca la máxima accesibilidad posible.

## 2. El Valor de la Accesibilidad: Un Beneficio Universal

La accesibilidad no es solo una obligación, sino una oportunidad y una responsabilidad.

- **Responsabilidad social:** Se estima que alrededor del 16% de la población mundial vive con algún tipo de discapacidad. Excluirles es una barrera social.

- **Oportunidad de negocio:** Atender a este segmento, así como a las personas con discapacidades situacionales o temporales, supone un mercado global valorado en 13 billones de dólares.

- **Beneficio para todos (Win-Win):** Diseñar pensando en la accesibilidad mejora la experiencia de cualquier usuario. Por ejemplo, los subtítulos ayudan a personas sordas, pero también a quien ve un vídeo en un entorno ruidoso. El modo oscuro (Dark Mode) ayuda a personas con sensibilidad a la luz, pero también a quien navega de noche para no forzar la vista.

## 3. Usuarios y sus Necesidades: La Diversidad Funcional

Para diseñar bien, hay que conocer a los usuarios. El webinar identifica cuatro grandes grupos:

- **Discapacidad visual:** Es un espectro muy amplio.
  - Baja visión: Necesitan alto contraste, posibilidad de hacer zoom y tipografías claras.
  - Ceguera: Dependen de lectores de pantalla (como María en el ejemplo). Necesitan que el código sea semántico y que las imágenes tengan texto alternativo.
  - Problemas de percepción del color (daltonismo): La información no puede transmitirse solo a través del color.

- **Discapacidad auditiva:**
  - Personas con sordera parcial o total (como Juan). Dependen de subtítulos y transcripciones en contenido multimedia.

- **Discapacidad cognitiva:**
  - Incluye a personas con dificultades de aprendizaje, memoria o atención, así como a personas mayores que pueden sentirse abrumadas por la tecnología. Las interfaces deben ser simples, intuitivas, claras y predecibles.

- **Discapacidad motora:**
  - Dificultades para usar el ratón o realizar movimientos precisos debido a condiciones como parálisis, temblores o lesiones temporales (ej. un brazo escayolado). Necesitan poder navegar solo con el teclado o con dispositivos adaptados (punteros, soplidos, seguimiento ocular).

## 4. Conceptos Fundamentales: Inclusividad, Usabilidad y Accesibilidad

Para entender la accesibilidad, hay que diferenciarla de conceptos relacionados, como si de las capas de una cebolla se tratara:

- **Inclusividad (Capa externa):** El diseño debe ser equitativo, diverso, representativo y empático con todos los grupos de usuarios, sin crear barreras.

- **Usabilidad (Capa intermedia):** Busca que la interacción sea eficiente, efectiva y satisfactoria. Una web usable es fácil de aprender y de usar.

- **Accesibilidad (Capa interna y fundamental):** Se basa en los cuatro principios POUR de las WCAG, que deben aplicarse tanto en diseño como en código:
  - Perceptible: La información y los componentes de la interfaz deben poder ser percibidos por todos los usuarios, ya sea visualmente o a través de herramientas de apoyo (lectores de pantalla).
  - Operable: Los componentes de la interfaz y la navegación deben poder ser utilizados por todos, independientemente del dispositivo de entrada (ratón, teclado, voz, etc.).
  - Comprensible: La información y el manejo de la interfaz deben ser fáciles de entender. Se busca la simplicidad y la intuición.
  - Robusto: El contenido debe ser lo suficientemente robusto como para ser interpretado de forma fiable por una amplia variedad de agentes de usuario, incluyendo tecnologías de asistencia y navegadores antiguos. Esto se logra usando código estándar.

## 5. Metodología de Trabajo: La Clave del Éxito

La ponencia insiste en que la accesibilidad no es una tarea final, sino una filosofía que debe impregnar todo el ciclo de vida del producto.

- **El error tradicional (Handoff):** El equipo de diseño crea unas pantallas y se las "lanza" al equipo de desarrollo. Esto genera malentendidos, retrabajos y productos de baja calidad, incluyendo la accesibilidad.

- **El modelo colaborativo (Átomo a átomo):** Diseño y desarrollo trabajan de la mano desde el minuto cero. La mejor manera de hacerlo es a través de un Sistema de Diseño.
  - Design Tokens: Son los "átomos" del diseño (colores, tipografías, espaciados). Definiéndolos de forma accesible desde el principio (ej. cumpliendo ratios de contraste), se garantiza que todos los componentes que se construyan a partir de ellos también lo sean.
  - Librerías Front-end sincronizadas: Los tokens se plasman en código, creando librerías de componentes que los desarrolladores pueden reutilizar, asegurando la coherencia y la accesibilidad en todas las aplicaciones de una misma marca o proyecto.

### Caso de éxito: Proyecto "Pan" (Banca digital).

En este proyecto, tras un desarrollo inicial, se implementó un sistema de diseño con Design Tokens en Figma. Esto permitió:

- Crear modos claro y oscuro (Light/Dark Mode) con contrastes que cumplían el nivel AAA.

- Definir una jerarquía tipográfica y tamaños de iconografía que permitían hacer zoom hasta 4x sin romper el diseño.

- Aplicar estos principios a todos los componentes (botones, formularios) de forma coherente en diferentes países y aplicaciones.

## 6. Guía Práctica: Principales Errores y Cómo Solucionarlos

El webinar identifica los errores más comunes que, una vez corregidos, mejoran exponencialmente la accesibilidad de un sitio web.

- **Contraste de color insuficiente (83% de los casos):**
  - Solución: Asegurar que el texto y los elementos interactivos tienen un ratio de contraste suficiente con el fondo (mínimo 4.5:1 para texto normal, según WCAG AA).

- **Falta de texto alternativo en imágenes:**
  - Solución: Incluir el atributo alt en todas las imágenes (<img>). Este texto debe describir la función o el contenido de la imagen para que los lectores de pantalla puedan transmitir la información a personas ciegas.

- **Enlaces vacíos o con texto genérico:**
  - Solución: Los enlaces y botones deben tener un texto descriptivo ("Leer más sobre..." en lugar de un simple "Click aquí"). Si usan iconos, estos deben tener una etiqueta textual asociada para los lectores de pantalla.

- **Formularios mal etiquetados (54%):**
  - Solución: Cada campo de formulario debe tener una etiqueta (<label>) asociada semánticamente mediante el atributo for que coincida con el id del campo. Esto es crucial para que los lectores de pantalla sepan qué información deben introducir.

- **Falta de foco visible y navegación por teclado:**
  - Solución: Todos los elementos interactivos deben tener un estado de foco visible (un borde, un cambio de color). Además, hay que asegurar que se puede navegar por toda la página y completar todas las acciones usando solo la tecla Tabulador.

- **Idioma del documento no definido (28%):**
  - Solución: Declarar el idioma principal de la página en la etiqueta <html> (ej. <html lang="es">). Esto es vital para que los lectores de pantalla apliquen la pronunciación correcta y los traductores automáticos funcionen bien.

## 7. Herramientas y Recursos para el Día a Día

### Para Diseñadores (en Figma):

- **Stark:** Plugin muy completo que calcula el contraste de color, simula diferentes tipos de visión (daltonismo, baja visión), comprueba el orden de enfoque y sugiere textos alternativos.

- **A11y - Color Contrast Checker:** Plugin especializado en verificar y ajustar los ratios de contraste.

- **A11y - Focus Order:** Plugin para visualizar y definir el orden lógico de navegación por tabulación.

- **A11y - Annotation Kit:** Permite añadir anotaciones de accesibilidad directamente en los diseños para comunicar requisitos al equipo de desarrollo.

### Para Desarrolladores:

- **Base: HTML5 Semántico:** Usar la etiqueta correcta para cada propósito (<header>, <nav>, <main>, <article>, <button>, etc.) ya resuelve el 80% de los problemas de accesibilidad. El HTML bien hecho es accesible por naturaleza.

- **WAI-ARIA:** Es una especificación del W3C para añadir semántica adicional cuando el HTML nativo no es suficiente (especialmente en aplicaciones dinámicas con JavaScript). Precaución: Un mal uso de ARIA puede ser peor que no usarlo, ya que anula el comportamiento nativo del HTML.

- **Validador del W3C:** Herramienta fundamental para verificar que el código HTML es correcto y no tiene errores de sintaxis o estructura.

- **Lighthouse (extensión de Chrome):** Herramienta de Google que audita automáticamente la página y ofrece informes detallados sobre rendimiento, buenas prácticas y accesibilidad, señalando errores concretos y cómo solucionarlos.

- **Magenta (recurso web):** Página web que detalla los requisitos de accesibilidad para cada componente HTML y ofrece tutoriales sobre cómo testear.

- **Testeo manual:** Imprescindible. Probar la web solo con el teclado y usar un lector de pantalla (como NVDA o VoiceOver) son las pruebas más fiables.

## 8. Conclusiones Finales

- La accesibilidad nos beneficia a todos. Es una herramienta que mejora la vida de las personas con discapacidad y la experiencia de cualquier usuario en situaciones cotidianas.

- Es responsabilidad de todos los perfiles. Desde la definición del proyecto hasta el desarrollo y el testing, todos los implicados deben tenerla en cuenta. No es una tarea exclusiva de los desarrolladores.

- El diseño es el punto de partida. La accesibilidad debe planificarse desde el primer boceto, no esperar a que "el desarrollo la arregle".

- Los estándares son tu mejor guía. Apoyarse en las WCAG, en un HTML semántico correcto y en las herramientas de validación es el camino más corto y seguro hacia una web accesible.

- Testear con usuarios reales es fundamental. Ninguna herramienta automática puede sustituir la experiencia y el feedback de una persona que utiliza tecnologías de apoyo a diario.
