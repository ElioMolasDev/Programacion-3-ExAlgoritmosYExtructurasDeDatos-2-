# 🧠 Árbol Generador Mínimo (AGM) – Preguntas y Respuestas tipo Anki

---

<details>
<summary><b>¿Qué es un árbol en teoría de grafos?</b></summary>
Un árbol es un grafo conexo sin circuitos.
</details>

---

<details>
<summary><b>¿Qué propiedades equivalentes tiene un árbol?</b></summary>
<il>
<li>Es un grafo sin circuitos simples, pero si se agrega cualquier arista, se forma exactamente un circuito.</li>  
<li>Existe un único camino simple entre cada par de vértices.  </li>
<li>Es conexo, pero si se elimina una arista, el grafo se vuelve no conexo. </li>  
<li>Cumple que |E| = |V| - 1.</li>
</il>
</details>

---

<details>
<summary><b>¿Qué es una hoja en un árbol?</b></summary>
Una hoja es un vértice de grado 1.
</details>

---

<details>
<summary><b>¿Qué teorema se cumple en todo árbol no trivial?</b></summary>
Todo árbol con al menos dos vértices tiene al menos dos hojas.
</details>

---

<details>
<summary><b>¿Cuántas aristas tiene un árbol con |V| vértices?</b></summary>
Tiene exactamente |V| - 1 aristas.
</details>

---

<details>
<summary><b>¿Qué es un árbol generador de un grafo?</b></summary>
Es un subgrafo que:
<ul>
<li>Es un árbol.</li>  
<li>Contiene todos los vértices del grafo original.</li>
</ul>
</details>

---

<details>
<summary><b>¿Qué es un Árbol Generador Mínimo (AGM)?</b></summary>
Es un árbol generador que minimiza la suma de los pesos de sus aristas:  
l(T) ≤ l(T′) para todo T′ árbol generador de G.
</details>

---

<details>
<summary><b>¿Qué representa la longitud de un árbol T?</b></summary>
La suma de los pesos de sus aristas:  
l(T) = ∑ l(e) para cada arista e ∈ T.
</details>

---

<details>
<summary><b>¿Qué aplicación práctica tiene el AGM?</b></summary>
Se utiliza en el diseño de redes eléctricas, de comunicación o transporte, donde se busca conectar todos los puntos con costo mínimo.
</details>

---

<details>
<summary><b>¿En qué consiste el Algoritmo de Prim?</b></summary>
<il>
<li>Comienza con un vértice cualquiera u. </li>  
<li>En cada paso, agrega la arista de menor peso que conecte un vértice del árbol con uno fuera de él.  </li>
<li>Repite hasta incluir todos los vértices.</li>
</il>
</details>

---

<details>
<summary><b>¿Cuál es la idea central del algoritmo de Prim?</b></summary>
Expandir un solo árbol creciendo desde un vértice inicial hacia los demás, eligiendo siempre la arista más barata que conecte el árbol actual con el resto.
</details>

---

<details>
<summary><b>¿Qué garantiza la corrección del algoritmo de Prim?</b></summary>
Teorema: Si F es un subconjunto de aristas de un AGM y S una componente conexa de F, entonces existe un AGM que incluye a todas las aristas de F ∪ {ij}, donde ij es la arista de peso mínimo entre S y su complemento.
</details>

---

<details>
<summary><b>¿Qué complejidad computacional tiene el algoritmo de Prim?</b></summary>
Depende de la estructura usada:
<ul>
<li>Con matriz de adyacencia: O(n²)</li>  
<li>Con montículos y listas de adyacencia: O(E log V)</li>
</ul>
</details>

---

<details>
<summary><b>¿En qué consiste el algoritmo de Kruskal?</b></summary>
1. Ordena todas las aristas por peso creciente.  
2. Agrega las aristas más livianas sin formar ciclos, hasta tener n-1 aristas.
</details>

---

<details>
<summary><b>¿Qué estructura de datos mejora la eficiencia del algoritmo de Kruskal?</b></summary>
La estructura Union-Find (o conjunto disjunto), que permite determinar eficientemente si dos vértices pertenecen a la misma componente.
</details>

---

<details>
<summary><b>¿Qué operaciones básicas tiene Union-Find?</b></summary>
- find(i): devuelve la raíz del conjunto donde está i.  
- union(i, j): une los conjuntos que contienen a i y j.
</details>

---

<details>
<summary><b>¿Cuál es la complejidad básica de Union-Find sin optimizaciones?</b></summary>
Ambas operaciones (union y find) tienen complejidad O(n).
</details>

---

<details>
<summary><b>¿Cómo se mejora la eficiencia de Union-Find?</b></summary>
- Haciendo que la raíz del árbol más pequeño apunte a la raíz del más grande (union por tamaño o altura).  
- Aplicando técnicas de compactación de caminos durante el find.
</details>

---

<details>
<summary><b>¿Qué técnicas de compactación existen en Union-Find?</b></summary>

1. Path compression: todos los nodos apuntan directamente a la raíz.  
2. Path splitting: cada nodo apunta a su abuelo.  
3. Path halving: aplica path splitting en nodos alternos.
</details>

---

<details>
<summary><b>¿Qué complejidad se logra aplicando union por tamaño y compresión?</b></summary>
Tiempo amortizado por operación: O(α(n)),  
donde α(n) es la inversa de la función de Ackermann (crece extremadamente lento, ≤ 5 en la práctica).
</details>

---

<details>
<summary><b>¿Qué es la función de Ackermann?</b></summary>
A(m, n) =
  <ul>
<li>n + 1 si m = 0 </li> 
<li>A(m − 1, 1) si m > 0 y n = 0 </li> 
<li>A(m − 1, A(m, n − 1)) si m > 0 y n > 0 </li> 
  </ul>
Es una función que crece muy rápidamente, y su inversa se usa en el análisis de Union-Find.
</details>

---

<details>
<summary><b>¿Por qué decimos que el problema del AGM está bien resuelto?</b></summary>
Porque existen algoritmos eficientes y correctos (Prim y Kruskal) que garantizan obtener un árbol generador mínimo en tiempo polinomial.
</details>

---

<details>
<summary><b>¿Cómo se puede obtener un árbol generador máximo?</b></summary>
Ejecutando los algoritmos de Prim o Kruskal, pero considerando los pesos negativos o eligiendo siempre las aristas de mayor peso.
</details>

---

<details>
<summary><b>¿Qué ocurre si un grafo tiene más de un árbol generador mínimo?</b></summary>
Todos los árboles generadores mínimos tienen el mismo peso total.
</details>

---

<details>
<summary><b>¿Qué tipo de grafos pueden tener más de un AGM?</b></summary>
Grafos en los que existen varias combinaciones de aristas con igual peso total mínimo.
</details>

---
