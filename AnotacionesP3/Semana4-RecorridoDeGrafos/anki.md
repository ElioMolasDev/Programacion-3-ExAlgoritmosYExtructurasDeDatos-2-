# 🧩 Preguntas y Respuestas – Recorridos y Algoritmos sobre Grafos

## 🧩 Conceptos Generales
<details> <summary><b>¿Qué significa recorrer un grafo?</b></summary> 
Recorrer un grafo significa visitar todos los vértices a los que se puede acceder desde un vértice inicial, siguiendo las aristas que los conectan. 
</details>

<details> <summary><b>¿Para qué sirve realizar un recorrido en un grafo?</b></summary> 
Sirve para determinar qué vértices son alcanzables desde un vértice dado y, en particular, para comprobar si el grafo es conexo, es decir, si existe un camino entre todos los pares de vértices. 
</details>

<details> <summary><b>¿Cuáles son los principales algoritmos de recorrido en grafos?</b></summary> 
Los dos algoritmos clásicos son: 
- BFS (Breadth-First Search búsqueda en anchura. 
- DFS (Depth-First Search búsqueda en profundidad. 
</details>

<details> <summary><b>¿Qué estructura de datos se usa en BFS y DFS?</b></summary> 
- BFS utiliza una cola (FIFO)
- DFS utiliza una pila (LIFO) o puede implementarse de forma recursiva 
</details>

<details> <summary><b>¿Qué diferencia principal hay entre BFS y DFS?</b></summary> 
- BFS explora el grafo por niveles, visitando primero los vértices más cercanos al origen. 
- DFS explora en profundidad, avanzando lo más lejos posible antes de retroceder. 
</details>

<details> <summary><b>¿Qué utilidad práctica tiene BFS?</b></summary> 
Permite encontrar la distancia mínima (en número de aristas) desde un vértice inicial hasta los demás, y se usa para hallar caminos más cortos en grafos sin pesos. 
</details>

<details> <summary><b>¿Qué utilidad práctica tiene DFS?</b></summary> 
Se usa para encontrar componentes conexas, detectar ciclos, calcular ordenamientos topológicos y descubrir puntos de articulación en un grafo. 
</details>

---

## ⚙️ Complejidad de los Recorridos

<details> <summary><b>¿Cuál es la complejidad de recorrer un grafo representado con una matriz de adyacencia?</b></summary> 
La obtención de vecinos cuesta `O(n)` por vértice, por lo que la complejidad total del recorrido es `O(n²)`. 
</details>

<details> <summary><b>¿Cuál es la complejidad de recorrer un grafo representado con una lista de adyacencia?</b></summary> 
Depende del grado de cada vértice: \[ \sum_{i \in V} O(d(i)) = O(m) \] donde `m` es la cantidad de aristas. Por lo tanto, la complejidad total es O(n + m). 
</details>

<details> <summary><b>¿Qué establece el Handshaking Lemma?</b></summary> 
Establece que la suma de los grados de todos los vértices es el doble de la cantidad de aristas: \[ \sum_{i \in V} d(i) = 2m \] 
</details>

---

## 🧭 Conectividad de Grafos
<details> <summary><b>¿Qué condición debe cumplirse para que un grafo sea conexo?</b></summary> 
Debe existir al menos un camino entre cada par de vértices del grafo. 
</details>

<details> <summary><b>¿Cómo se puede determinar si un grafo es conexo?</b></summary> 
Se elige un vértice inicial `s` y se realiza un recorrido (BFS o DFS). Si al finalizar todos los vértices están marcados como visitados, el grafo es conexo. 
</details>

<details> <summary><b>¿Qué diferencia hay entre “grafo conexo” y “componente conexa”?</b></summary> 
Un grafo conexo tiene una sola componente, mientras que un grafo no conexo está formado por varias componentes
conexas (subgrafos en los que todos los vértices están conectados entre sí). 
</details>

---

## 🧮 Ejercicios sobre Grafos

<details> <summary><b>¿Qué es un triángulo en un grafo?</b></summary> 
Un triángulo es un conjunto de tres vértices distintos que son vecinos dos a dos. Equivale a una clique de tres vértices. 
</details>

<details> <summary><b>¿Cómo se puede determinar la cantidad de triángulos que contiene un grafo?</b></summary> 
Para cada trío de vértices distintos `(i, j, k)`, verificar si todas las aristas `(ij)`, `(ik)` y `(jk)` existen. Cada triángulo se cuenta una vez. 
</details>

<details> <summary><b>¿Cuál es la complejidad de un algoritmo que cuenta triángulos en un grafo?</b></summary> 
Depende de la representación: - Con matriz de adyacencia → `O(n³)` - Con lista de adyacencia puede optimizarse a `O(m√m)` o mejor, dependiendo del enfoque. La complejidad general depende de cómo se consultan los vecinos. 
</details>

<details> <summary><b>¿Qué significa que dos vértices estén a distancia 2 en un grafo?</b></summary> 
Dos vértices `i` y `j` están a distancia 2 si existe un vértice `k` tal que `(i, k)` y `(k, j)` son aristas del grafo. 
</details>

<details> <summary><b>¿Cómo determinar si dos vértices están a distancia 2?</b></summary> 
Verificar si existe al menos un vértice `k` que sea vecino tanto de `i` como de `j`. Esto puede hacerse recorriendo los vecinos de `i` y comprobando si alguno está conectado con `j`. 
</details>

<details> <summary><b>¿Cuál es la complejidad de verificar si dos vértices están a distancia 2?</b></summary> 
Con una lista de adyacencia, el costo depende de los grados de `i` y `j`: `O(d(i) + d(j))`. Con una matriz de adyacencia, el costo es `O(n)`. 
</details>

<details> <summary><b>¿Qué es un vértice universal?</b></summary> 
Es un vértice que es vecino de todos los demás vértices del grafo. 
</details>

<details> <summary><b>¿Cómo determinar si un vértice es universal?</b></summary> 
Comprobar si su grado es igual a `n - 1`, donde `n` es la cantidad total de vértices del grafo. 
</details>
<details> <summary><b>¿Cuál es la complejidad de determinar si un vértice es universal?</b></summary> 
- Con una matriz de adyacencia: `O(n)` - Con una lista de adyacencia: `O(d(i))` 
</details>

<details> <summary><b>¿Se puede determinar en O(1) si un vértice es universal?</b></summary> 
Sí. Si se mantiene actualizado el grado de cada vértice como atributo dentro del grafo, puede verificarse en tiempo constante si su grado es `n - 1`. 
</details>

---

## ⚖️ Comparaciones y Aplicaciones
<details> <summary><b>¿Qué estructura conviene usar para grafos densos?</b></summary> 
La matriz de adyacencia, ya que las operaciones sobre aristas tienen costo constante `O(1)` y el número de aristas es alto (`m ≈ n²`). 
</details>

<details> <summary><b>¿Qué estructura conviene usar para grafos poco densos?</b></summary> 
La lista de adyacencia, porque el número de aristas `m` es mucho menor que `n²`, y recorrer vecinos es más eficiente. 
</details>

<details> <summary><b>¿Qué complejidad tienen BFS y DFS si el grafo se representa con listas de adyacencia?</b></summary> 
Ambos algoritmos tienen una complejidad de O(n + m). 
</details>

<details> <summary><b>¿Qué complejidad tienen BFS y DFS si el grafo se representa con matriz de adyacencia?</b></summary> 
Ambos algoritmos tienen una complejidad de O(n²). 
</details>

