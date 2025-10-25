# 🧩 Preguntas y Respuestas – Recorridos y Algoritmos sobre Grafos

## 🗺️ Recorrido de Grafos (General)
<details>
<summary><b>¿Cuál es el problema principal que busca resolver un algoritmo de recorrido de grafos?</b></summary>
Determinar si un grafo es conexo, o, más generalmente, obtener todos los vértices que son alcanzables a partir de un vértice inicial $s \in V$ arbitrario. 
</details>

<details>
<summary><b>¿Cuál es la idea básica del algoritmo de recorrido?</b></summary>
Partir de un vértice inicial $s \in V$ y, de forma iterativa, obtener todos los vértices a los que se puede llegar a partir de $s$. 
</details>

<details>
<summary><b>¿Qué condición determina si un grafo es conexo después de un recorrido?</b></summary>
  [cite_start]Si los vértices marcados son **todos** los vértices del grafo, entonces el grafo es conexo. [cite: 284, 287, 290]
</details>

<details>
<summary><b>¿Qué estructura de datos se utiliza para implementar la lista $L$ en el recorrido?</b></summary>
  [cite_start]La lista $L$ (que contiene los vértices a visitar) puede implementarse como una **cola** o una **pila**. [cite: 282, 283]
</details>

<details>
<summary><b>¿Qué algoritmo de recorrido resulta si $L$ se implementa con una **cola**?</b></summary>
  [cite_start]Se obtiene el algoritmo **BFS (Breadth-First Search)**, el cual recorre los vértices en orden de distancia creciente desde el vértice inicial $s$. [cite: 282, 285, 288]
</details>

<details>
<summary><b>¿Qué algoritmo de recorrido resulta si $L$ se implementa con una **pila**?</b></summary>
  [cite_start]Se obtiene el algoritmo **DFS (Depth-First Search)**, el cual tiende a encontrar primero el vértice más lejano al vértice inicial $s$. [cite: 283, 286, 289]
</details>

---

## ⚙️ Complejidad Computacional

<details>
<summary><b>¿Cuál es la complejidad computacional del recorrido de grafos si está implementado sobre una **matriz de adyacencia**?</b></summary>
  Es $\mathbf{O(n^2)}$, donde $n = |V|$ (cantidad de vértices). [cite_start]Esto se debe a que obtener los vecinos de un vértice es $O(n)$, y el ciclo exterior realiza $n$ iteraciones en el peor caso. [cite: 295, 300, 310, 330]
</details>

<details>
<summary><b>¿Cuál es la complejidad computacional del recorrido de grafos si está implementado sobre **listas de vecinos**?</b></summary>
  Es $\mathbf{O(m)}$, donde $m = |E|$ (cantidad de aristas). [cite_start]Esto se debe a que la complejidad total es la suma de los grados de todos los vértices, $\sum_{i \in V} O(d(i))$, y por el Handshaking Lemma $\sum_{i \in V} d(i) = 2m$. [cite: 329, 330]
</details>

<details>
<summary><b>¿En qué caso se prefiere la implementación con **listas de vecinos**?</b></summary>
  [cite_start]Se prefiere cuando el grafo es **poco denso**, es decir, cuando la cantidad de aristas es $m = O(n)$ (lineal en el número de vértices). [cite: 333, 340]
</details>

<details>
<summary><b>¿Cuál es la complejidad en el peor caso para ambas implementaciones (matriz y lista)?</b></summary>
  [cite_start]El peor caso es $\mathbf{O(n^2)}$ para ambas, ya que en general $m = O(n^2)$ (para un grafo denso). [cite: 332, 339]
</details>

---

## 💡 Ejercicios y Algoritmos

<details>
<summary><b>¿Qué es un **triángulo** en un grafo?</b></summary>
  [cite_start]Un triángulo es un conjunto de **tres vértices distintos** que son **vecinos dos a dos** (una clique de tres vértices). [cite: 371]
</details>

<details>
<summary><b>¿Cómo se define la **distancia 2** entre dos vértices $i$ y $j$?</b></summary>
  [cite_start]Los vértices $i$ y $j$ están a distancia 2 si existe un vértice $k$ tal que la arista $ik$ y la arista $kj$ pertenecen al conjunto de aristas $E$. [cite: 375]
</details>

<details>
<summary><b>¿Qué es un **vértice universal**?</b></summary>
  [cite_start]Un vértice universal es aquel que es **vecino de todos los otros vértices** en el grafo. [cite: 378]
</details>

<details>
<summary><b>¿Cuál es la complejidad computacional para determinar si un vértice es universal?</b></summary>
  [cite_start]La complejidad de un método directo para verificar si un vértice es vecino de todos los demás dependerá de la representación, pero la pregunta plantea si puede implementarse en $\mathbf{O(1)}$ modificando la representación interna del grafo. [cite: 380, 381]
</details>

