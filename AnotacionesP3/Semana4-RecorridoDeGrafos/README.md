# Recorridos de Grafos

## Introducción

Los **recorridos de grafos** son algoritmos fundamentales en la teoría de grafos y la programación que permiten explorar y analizar la estructura de un grafo de manera sistemática. Estos algoritmos son esenciales para resolver problemas comunes como determinar si un grafo es conexo, encontrar caminos entre vértices, o explorar todas las componentes conectadas de una red.

Este documento presenta los conceptos clave de los recorridos de grafos, sus implementaciones y análisis de complejidad computacional.

---

## ¿Qué es un Recorrido de Grafo?

Un recorrido de grafo es un proceso que **visita todos los vértices alcanzables** a partir de un vértice inicial dado. La idea principal es:

1. Partir de un vértice arbitrario `s ∈ V`
2. Explorar sistemáticamente todos los vértices conectados a `s`
3. Marcar los vértices visitados para evitar procesarlos múltiples veces

### Algoritmo Genérico
```text
1. L := {s}
2. Mientras L ≠ ∅:
3.   Seleccionar i ∈ L y marcarlo
4.   Agregar a L todos los vecinos no marcados de i
5.   L := L \ {i}
6. Fin
7. Los vértices marcados son los alcanzables desde s
```

## Tipos de Recorridos

### BFS (Breadth-First Search)

Cuando la lista `L` se implementa como una **cola**, el algoritmo se denomina **BFS** o búsqueda en amplitud. Características:

- Recorre los vértices en **orden de distancia creciente** desde `s`
- Explora primero todos los vecinos cercanos antes de avanzar a vértices más lejanos
- Útil para encontrar caminos más cortos

### DFS (Depth-First Search)

Cuando la lista `L` se implementa como una **pila**, el algoritmo se denomina **DFS** o búsqueda en profundidad. Características:

- **Encuentra primero el vértice más lejano** a `s`
- Explora profundamente cada rama antes de retroceder
- Útil para detectar ciclos y componentes fuertemente conectadas

---

## Aplicación: Determinar Conectividad

Un grafo es **conexo** si todos sus vértices son alcanzables desde cualquier vértice inicial. Para verificar esto:

1. Ejecutar el algoritmo de recorrido desde un vértice arbitrario
2. Si los vértices marcados incluyen **todos los vértices del grafo**, entonces el grafo es conexo
3. En caso contrario, el grafo tiene múltiples componentes desconectadas

---

## Análisis de Complejidad Computacional

La complejidad del algoritmo depende de **cómo se implemente el grafo**:

### Con Matriz de Adyacencia

- Obtener los vecinos de un vértice: **O(n)** (debe revisarse toda la fila)
- El ciclo exterior realiza **n iteraciones** en el peor caso
- **Complejidad total: O(n²)**

### Con Listas de Vecinos

- Obtener los vecinos de un vértice: **O(1)**
- Recorrer la lista de vecinos de vértice `i`: **O(d(i))** (donde `d(i)` es el grado del vértice)
- **Complejidad total: Σ O(d(i))** para todo `i ∈ V`

#### Handshaking Lemma

La suma de los grados de todos los vértices es igual al doble del número de aristas:

Σ d(i) = 2m (donde m = |E|)


Por lo tanto, con listas de vecinos: **Complejidad = O(m)**

---

## Comparativa de Implementaciones

| Aspecto | Matriz de Adyacencia | Listas de Vecinos |
|--------|----------------------|-------------------|
| **Complejidad BFS** | O(n²) | O(m) |
| **Mejor para** | Grafos densos | Grafos poco densos |
| **Densidad óptima** | m = O(n²) | m = O(n) |

### Recomendaciones

- **Grafos densos** (m ≈ n²): Usar matriz de adyacencia
- **Grafos poco densos** (m ≈ n): Usar listas de vecinos para mejor rendimiento

---

## Conclusión

Los recorridos de grafos son herramientas poderosas para explorar estructuras de red. La elección entre BFS y DFS, así como la representación del grafo, depende del problema específico y las características de los datos. 
Comprender la complejidad computacional es crucial para optimizar algoritmos en aplicaciones reales.
BFS explora por niveles y encuentra caminos más cortos.

DFS explora profundamente, ideal para descubrir estructuras internas o detectar ciclos.

Ambos algoritmos tienen una complejidad lineal respecto al número de aristas y vértices (O(n + m)), si se implementan correctamente sobre listas de adyacenci
