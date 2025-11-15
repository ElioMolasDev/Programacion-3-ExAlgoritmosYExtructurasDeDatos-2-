# 🚗 Camino Mínimo – Preguntas y Respuestas tipo Anki

---

<details>
<summary><b>¿Qué es el problema del camino mínimo?</b></summary>
<ul>
<li>Dados un grafo dirigido G = (N, A). lo nodos s, t ∈ N de origen y destino y una función de distancia d : A → R+.
<li>Se busca encontrar una secuencia de aristas entre dos vértices de un grafo ponderado tal que la suma de los pesos de dichas aristas sea mínima.</li>
</ul>
</details>

---

<details>
<summary><b>¿Qué representa el peso de una arista en el contexto del camino mínimo?</b></summary>
Representa un costo, distancia o tiempo asociado al recorrido entre dos vértices conectados.
</details>

---

<details>
<summary><b>¿Cuáles son los tipos de problemas de camino mínimo más comunes?</b></summary>
<il>
<li>Desde una fuente a todos los demás vértices (fuente única).</li>  
<li>Entre todos los pares de vértices (todos los pares).</li>  
<li>Entre un origen y un destino específico.</li>
  </il>
  </details>
  
---

<details>
<summary><b>¿Qué Ocurre si G contiene un ciclo con pesos negativos?</b></summary>
si G tiene algún ciclo con peso negativo alcanzable desde s, el concepto de camino mı́nimo deja de estar bien definido.
</details>

---

<details>
<summary><b>¿Que es la propiedad de sub estructura Optima??</b></summary>
Sea Pij un camino mı́nimo entre i y j, y sea k ∈ Pij . Entonces, el
subcamino de Pij entre i y k es un camino mı́nimo entre i y k.
</details>

---

<details>
<summary><b>¿Qué algoritmos se utilizan para resolver el problema del camino mínimo?</b></summary>
Los principales son:
<il>
  <li>Dijkstra (para grafos con pesos no negativos).</li>  
  <li>Bellman-Ford (admite pesos negativos).</li>  
  <li>Floyd-Warshall (todos los pares de vértices).</li>
</il>

</details>

---

<details>
<summary><b>¿Cuál es la idea principal del algoritmo de Dijkstra?</b></summary>
• Asumimos que las longitudes de las aristas son positivas. El grafo puede ser orientado o no orientado.
  <br>
• Asignar distancias tentativas ds = 0 y di = ∞ para i 6= s. 
<br>
• Mientras el destino no esté visitado:
<br>
  • Seleccionar como nodo actual i el nodo no visitado con menor distancia tentativa, y marcarlo como visitado.
<br>
  • Para cada j ∈ N + (i) no visitado, calcular dj0 = di + dij . Si dj0 menor a dj entonces fijar dj := dj0
<br>
  • Retornar dt 
                                                     
</details>

---

<details>
<summary><b>¿Qué condición debe cumplirse para usar el algoritmo de Dijkstra?</b></summary>
El grafo no debe contener pesos negativos en sus aristas.
</details>

---

<details>
<summary><b>¿Qué estructura de datos se usa para optimizar el algoritmo de Dijkstra?</b></summary>
Una cola de prioridad (min-heap), que permite extraer el vértice con menor distancia en `O(log V)`.
</details>

---

<details>
<summary><b>¿Cuál es la complejidad del algoritmo de Dijkstra?</b></summary>
- Con matriz de adyacencia: `O(V²)`  
- Con listas de adyacencia y cola de prioridad: `O(E log V)`
</details>

---

<details>
<summary><b>¿Qué sucede si el grafo tiene aristas con pesos negativos?</b></summary>
El algoritmo de Dijkstra puede fallar, ya que los caminos cortos podrían modificarse después de visitar un vértice.  
En ese caso, se utiliza Bellman-Ford.
</details>

---

<details>
<summary><b>¿Cuál es la idea principal del algoritmo de Bellman-Ford?</b></summary>
Relaja todas las aristas V - 1 veces, garantizando la distancia mínima incluso con aristas de peso negativo.  
Además, permite detectar ciclos negativos.
</details>

---

<details>
<summary><b>¿Qué es una operación de relajación en los algoritmos de camino mínimo?</b></summary>
Es el proceso de actualizar la distancia mínima a un vértice si se encuentra un camino más corto a través de otro vértice intermedio.
</details>

---

<details>
<summary><b>¿Qué complejidad tiene el algoritmo de Bellman-Ford?</b></summary>
Tiene una complejidad de **O(V · E)**.
</details>

---

<details>
<summary><b>¿Qué resuelve el algoritmo de Floyd-Warshall?</b></summary>
Calcula los **caminos mínimos entre todos los pares de vértices** de un grafo ponderado (con o sin pesos negativos, pero sin ciclos negativos).
</details>

---

<details>
<summary><b>¿Cuál es la complejidad del algoritmo de Floyd-Warshall?</b></summary>
Tiene complejidad **O(V³)**, ya que utiliza tres bucles anidados para recorrer todos los vértices.
</details>

---

<details>
<summary><b>¿Qué principio utiliza el algoritmo de Floyd-Warshall?</b></summary>
Se basa en el **principio de optimalidad**:  
un subcamino de un camino mínimo también es un camino mínimo.
</details>

---

<details>
<summary><b>¿Qué ocurre si el grafo contiene un ciclo negativo?</b></summary>
Los algoritmos de camino mínimo **no pueden definir un resultado válido**, ya que el costo total puede decrecer indefinidamente.
</details>

---

<details>
<summary><b>¿Qué aplicaciones prácticas tienen los algoritmos de camino mínimo?</b></summary>

- Navegadores GPS y rutas óptimas.  
- Enrutamiento en redes de comunicación (OSPF, RIP).  
- Planificación logística y transporte.  
- Optimización de recursos en sistemas distribuidos.
</details>

---

<details>
<summary><b>¿Qué propiedad clave se cumple en los caminos mínimos?</b></summary>
Los **subcaminos** de un camino mínimo también son caminos mínimos entre sus vértices extremos.
</details>

---

<details>
<summary><b>¿Por qué el problema del camino mínimo se considera bien resuelto?</b></summary>
Porque existen algoritmos **eficientes y correctos** (Dijkstra, Bellman-Ford, Floyd-Warshall) que garantizan soluciones óptimas en tiempo polinomial.
</details>

---


