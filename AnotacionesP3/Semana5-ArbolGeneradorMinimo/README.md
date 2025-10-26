# 🌳 Problema del Árbol Generador Mínimo (AGM)

## 1. Introducción

Este documento aborda el estudio de los grafos con un enfoque en el concepto fundamental del **Árbol Generador Mínimo (AGM)** y los algoritmos diseñados para encontrarlo. Este problema es esencial en la optimización de costos y el diseño eficiente de redes.

### Conceptos Fundamentales

* **Árbol:** Un grafo conexo que **no contiene circuitos**. Se caracteriza porque el número de aristas es $|V|-1$ y existe un único camino simple entre cualquier par de vértices.
* **Árbol Generador:** Un subgrafo que es un árbol e incluye a **todos los vértices** ($V$) del grafo original.

***

## 2. Resumen del Tema y Solución Algorítmica

### Definición del Problema (AGM)

El **Problema del Árbol Generador Mínimo (AGM)** se define en un grafo conexo y ponderado (donde cada arista $e$ tiene un peso o longitud, $l(e)$).

El objetivo es encontrar un **Árbol Generador** $T$ cuya suma de los pesos de sus aristas (su longitud total, $l(T)$) sea la **mínima posible** en comparación con cualquier otro árbol generador del grafo.

> **Aplicación Típica:** Optimizar la conexión de una red (por ejemplo, redes eléctricas o de telecomunicaciones) garantizando que todos los puntos estén conectados con el menor costo o longitud total.

### Algoritmos de Solución Glotones (Greedy)

La solución al problema del AGM se logra mediante algoritmos glotones, siendo los más comunes:

#### 🟢 Algoritmo de Prim

Este algoritmo construye el AGM **incrementalmente** seleccionando aristas para expandir el árbol, garantizando siempre que se añada la arista de menor peso que conecte un vértice **dentro** del árbol con uno **fuera** de él.

1.  Comienza con un vértice inicial arbitrario en el árbol $T$.
2.  En cada paso, añade la arista de **peso mínimo** que conecte un vértice ya incluido en $T$ con uno que aún no lo está.
3.  El proceso finaliza cuando todos los vértices han sido incluidos en $T$.

#### 🔴 Algoritmo de Kruskal

Este algoritmo construye el AGM seleccionando aristas en orden de peso, siempre que no formen un ciclo (circuito):

1.  Se ordenan todas las aristas del grafo en orden **creciente de su peso**.
2.  Se añade la siguiente arista de menor peso, siempre y cuando **no forme un ciclo** con las aristas ya seleccionadas.
3.  Este proceso se repite hasta que se han seleccionado $n-1$ aristas, formando el AGM.

> **Implementación Eficiente:** Para verificar rápidamente la formación de ciclos, este algoritmo se implementa eficientemente utilizando la estructura de datos **Union-Find**.
