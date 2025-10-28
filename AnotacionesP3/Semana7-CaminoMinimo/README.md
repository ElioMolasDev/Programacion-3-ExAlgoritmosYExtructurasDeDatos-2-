# Problema de camino minimo
## 🧩 Introducción

El problema del camino mínimo es uno de los más importantes en la teoría de grafos y en la optimización de redes. Su objetivo es determinar la ruta más corta o de menor costo entre dos vértices dentro de un grafo ponderado, donde las aristas representan conexiones con un valor asociado (como distancia, tiempo o costo).

Este tipo de problema aparece constantemente en la vida real: desde la búsqueda de la ruta más corta entre dos ciudades en un mapa, hasta la transmisión eficiente de datos en redes de comunicación o la planificación de recursos logísticos. Por ello, el estudio de los algoritmos de caminos mínimos constituye una base esencial para disciplinas como la informática, la ingeniería y la investigación operativa.

Los principales algoritmos para resolverlo —como Dijkstra, Bellman-Ford y Floyd-Warshall— difieren en sus estrategias y en los tipos de grafos que pueden manejar, pero todos comparten el mismo propósito: minimizar la suma de los pesos de las aristas en el recorrido entre los vértices de interés.

## 🧠 Resumen

**Definición:**
El camino mínimo entre dos vértices u y v en un grafo ponderado es la secuencia de aristas que une ambos vértices con el menor peso total posible.

### Tipos de problemas de camino mínimo:

* Camino mínimo desde un vértice fuente a todos los demás (problema de fuente única).

* Camino mínimo entre todos los pares de vértices (problema de todos los pares).

* Camino mínimo entre un origen y un destino específico.

### Algoritmos principales:

* Dijkstra: Encuentra el camino mínimo desde una fuente a todos los vértices en grafos con pesos no negativos. Utiliza una cola de prioridad y tiene complejidad O(E log V).

* Bellman-Ford: Permite pesos negativos, detecta ciclos negativos y tiene complejidad O(V·E).

* Floyd-Warshall: Calcula caminos mínimos entre todos los pares de vértices, útil para grafos pequeños o densos.
Su complejidad es O(V³).

### Propiedades clave:

* Un camino mínimo no contiene ciclos positivos.

* Los subcaminos de un camino mínimo también son caminos mínimos (principio de optimalidad).

* Si los pesos son no negativos, Dijkstra garantiza optimalidad.

* Si hay pesos negativos, se usa Bellman-Ford o Floyd-Warshall.

### Aplicaciones:

* Navegadores GPS y sistemas de transporte.

* Enrutamiento en redes de datos (como el protocolo OSPF).

* Planificación de producción y logística.

* Optimización de recursos en sistemas distribuidos.
