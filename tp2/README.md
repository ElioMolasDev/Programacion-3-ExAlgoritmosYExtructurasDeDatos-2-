# 🎵 Sistema de Afinidad Musical

**Profesores:** Bagnes Patricia, Bertaccini Daniel 

El **Sistema de Afinidad Musical** es un proyecto desarrollado en **Java** que permite **agrupar usuarios según sus intereses musicales**, analizando sus afinidades para formar grupos con gustos similares.  

---

## 🎯 Objetivo

Diseñar e implementar un programa que, mediante los **gustos musicales de distintos usuarios**, determine **dos grupos de personas con afinidades musicales similares**.  
El sistema utiliza conceptos de **grafos**, **árbol generador mínimo** y **recorridos BFS**, aplicando principios de **Programación Orientada a Objetos** y **separación de capas**, **encapsulamiento**, **cohesión**, **bajo acoplamiento**. 

---

## ⚙️ Tecnologías Utilizadas

| Herramienta | Descripción |
|--------------|-------------|
| 🟦 **Java 8+** | Lenguaje principal de desarrollo |
| 🧪 **JUnit 4** | Framework de testing |
| 💻 **Eclipse** | Entorno de desarrollo |

---

## 🧠 Arquitectura del Sistema

El sistema está estructurado en tres capas principales siguiendo la Arquitectura MVP:

### 🧩 Lógica
Contiene las clases que representan la estructura y comportamiento interno del programa:
- `Usuario`: representa una persona con intereses musicales definidos.
- `Grafo`: representa las relaciones entre usuarios mediante una matriz de adyacencia, donde cada arista representa la similaridad entre dos personas.
- `BFS`: Implementa un recorrido por el grafo para obtener los vértices alcanzables desde un usuario determinado y verificar si el grafo es conexo.
- `ArbolGeneradorMinimo`: implementa un árbol generador mínimo con el algoritmo de Kruskal sobre Union-Find.
- `AdministradorDeUsuarios`: Clase principal de la lógica la cual implementa las demás clases para agrupar los 2 grupos de usuarios según los intereses musicales.

---

### 💻 Visual

Contiene las interfaces gráficas del sistema:

- `VistaPrincipal`: ventana donde el usuario ingresa su nombre y los niveles de interés en los géneros musicales.  
- `VistaGrupos`: interfaz que muestra los **dos grupos resultantes**, listando los usuarios que los conforman junto con el **promedio de similaridad** correspondiente.  

---

### 🧭 Inicialización y Presentación

- `AfinidadMusical`: clase principal que **inicia la ejecución** del programa.  
- `Presentador`: coordina la comunicación entre la interfaz visual y la lógica, siguiendo el patrón de diseño **Separated Presentation** (separación de vista y lógica).

---

## 🧪 Pruebas Unitarias

Cada clase de la capa lógica cuenta con su propio conjunto de **tests en JUnit4**, que verifican el correcto comportamiento de:

- Construcción y manipulación del grafo.  
- Cálculo del árbol generador mínimo.  
- Generación y división de grupos.  
- Validaciones de datos de usuario.  

---

## 🔍 Principales Funcionalidades

- Registro de usuarios con intereses musicales.  
- Validación de entradas (por ejemplo, intereses dentro del rango permitido).  
- Generación de grupos según afinidad entre usuarios.  
- Consulta de grupos generados.  
- Ejecución de pruebas unitarias para verificar la consistencia del sistema.

---

## 🧠 Ejemplo de Lógica de Agrupamiento

El sistema compara los niveles de interés de los usuarios en los distintos géneros musicales y genera grupos donde la **diferencia promedio de intereses sea mínima**.  
Esto permite formar conjuntos equilibrados con usuarios de gustos similares.

