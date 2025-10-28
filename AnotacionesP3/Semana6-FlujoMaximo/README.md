# 🌊 Problema del Flujo Máximo

## 1. Introducción

Este documento se centra en el **Problema del Flujo Máximo** en la Teoría de Grafos. El objetivo es determinar la máxima cantidad de material, información o recurso (flujo) que se puede transportar desde un nodo de origen a un nodo de destino a través de una red, respetando los límites de capacidad de cada conexión.

### Estructura de la Red de Flujo

El problema se define sobre una red que incluye los siguientes elementos:

1.  Un **grafo dirigido** ($G$) con nodos ($N$) y arcos ($A$).
2.  Dos nodos especiales: $s$ (origen o fuente) y $t$ (destino o sumidero).
3.  Una **función de capacidad** que asigna un valor positivo a cada arco, representando el máximo de flujo que puede soportar.

***

## 2. Resumen del Tema y Solución

### Definición del Flujo

El **Problema del Flujo Máximo** consiste en encontrar la asignación de flujos a cada arco que resulte en el **mayor valor total de flujo** desde $s$ hasta $t$.

Una asignación de flujo debe cumplir con dos condiciones fundamentales:

1.  **Restricción de Capacidad:** El flujo enviado por un arco nunca debe superar su capacidad definida.
2.  **Conservación del Flujo:** En todos los nodos intermedios (excluyendo $s$ y $t$), el flujo total que entra al nodo debe ser igual al flujo total que sale.

El **valor del flujo** es la cantidad total que sale del nodo origen ($s$).

### Teorema Fundamental

El resultado principal que relaciona el flujo y la estructura de la red es el **Teorema de Flujo Máximo - Corte Mínimo** (Max Flow-Min Cut):

> **El valor del flujo máximo que se puede enviar por la red es siempre igual a la capacidad del corte mínimo en esa red.**

* **Corte:** Una partición de los nodos que separa al origen ($s$) del destino ($t$).
* **Capacidad de un Corte:** La suma de las capacidades de las aristas que van desde el lado del origen al lado del destino en esa partición.

### Algoritmo de Ford y Fulkerson

El método más conocido para resolver este problema es el algoritmo de **Ford y Fulkerson**. Este se basa en la búsqueda iterativa de caminos de aumento:

* **Camino de Aumento:** Un camino desde $s$ hasta $t$ que tiene capacidad residual disponible para transportar flujo adicional.
* **Funcionamiento:** El algoritmo inicializa el flujo en cero y, en cada paso, encuentra un camino de aumento y lo utiliza para incrementar el flujo total de la red.
* **Criterio de Parada:** El flujo alcanzado es el máximo cuando **no se puede encontrar ningún camino de aumento** en la red residual.
