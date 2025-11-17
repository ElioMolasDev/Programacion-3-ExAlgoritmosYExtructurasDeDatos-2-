# 🌳 Árbol Generador Mínimo — Preguntas y Respuestas tipo Anki

---

## 🌲 Conceptos básicos de árboles

<details>
<summary>¿Qué es un árbol en teoría de grafos?</summary>
Un árbol es un grafo conexo sin circuitos.
</details>

<details>
<summary>¿Qué propiedades equivalentes caracterizan a un árbol?</summary>
Dado un grafo G = (V, E), son equivalentes:
<ul>
<li>G es un árbol</li>
<li>G no tiene circuitos simples, pero agregar cualquier arista crea exactamente un circuito simple</li>
<li>Existe exactamente un camino simple entre todo par de vértices</li>
<li>G es conexo, pero quitar cualquier arista lo desconecta</li>
</ul>
</details>

<details>
<summary>¿Qué es una hoja en un árbol?</summary>
Una hoja es un vértice de grado 1 (que tiene exactamente una arista conectada).
</details>

<details>
<summary>¿Cuántas hojas tiene como mínimo un árbol no trivial?</summary>
Todo árbol no trivial (con al menos dos vértices) tiene al menos dos hojas.
</details>

<details>
<summary>¿Qué relación existe entre vértices y aristas en un árbol?</summary>
Si G = (V, E) es un árbol, entonces |E| = |V| - 1
<br>
Es decir, un árbol con n vértices tiene exactamente n-1 aristas.
</details>

---

## 📊 Árbol Generador Mínimo

<details>
<summary>¿Qué es un árbol generador de un grafo G?</summary>
Un árbol generador de G es un subgrafo de G que:
<ul>
<li>Es un árbol</li>
<li>Tiene el mismo conjunto de vértices que G</li>
</ul>
</details>

<details>
<summary>¿Cómo se define la longitud de un árbol T?</summary>
Dada una función l : E → R que asigna pesos a las aristas, la longitud de T se define como:
<br>
l(T) = Σ l(e) para todas las aristas e ∈ T
<br>
Es decir, la suma de los pesos de todas sus aristas.
</details>

<details>
<summary>¿Qué es un Árbol Generador Mínimo (AGM)?</summary>
Dado un grafo G = (V, E), un AGM T es un árbol generador de G de mínima longitud, es decir:
<br>
l(T) ≤ l(T') para todo T' árbol generador de G
</details>

<details>
<summary>¿Cuál es una aplicación práctica del problema del AGM?</summary>
Diseño de redes eléctricas y de comunicación, donde se busca conectar todos los puntos minimizando el costo total de cableado.
</details>

---

## ⚙️ Algoritmo de Prim

<details>
<summary>¿Quiénes desarrollaron el algoritmo de Prim?</summary>
Fue descubierto independientemente por:
<ul>
<li>Vojtěch Jarník (1930)</li>
<li>Robert Prim (1957)</li>
<li>Edsger Dijkstra (1959)</li>
</ul>
</details>

<details>
<summary>¿Cuál es la idea principal del algoritmo de Prim?</summary>
• Iniciar con un vértice cualquiera
<br>
• En cada iteración, agregar la arista de peso mínimo que conecte el árbol actual con un vértice que no esté en el árbol
<br>
• Repetir hasta incluir todos los vértices
</details>

<details>
<summary>¿Cómo funciona el algoritmo de Prim paso a paso?</summary>
1. V<sub>T</sub> := {u} (u cualquier vértice de G), E<sub>T</sub> := ∅, i := 1
<br>
2. Mientras i ≤ n-1:
<br>
   • Elegir arista e = (u,v) de peso mínimo donde u ∈ V<sub>T</sub> y v ∉ V<sub>T</sub>
<br>
   • E<sub>T</sub> := E<sub>T</sub> ∪ {e}
<br>
   • V<sub>T</sub> := V<sub>T</sub> ∪ {v}
<br>
   • i := i + 1
<br>
3. Retornar T = (V<sub>T</sub>, E<sub>T</sub>)
</details>

<details>
<summary>¿El algoritmo de Prim garantiza encontrar un AGM?</summary>
Sí, el algoritmo de Prim es correcto. Dado un grafo G conexo, siempre determina un árbol generador mínimo de G.
</details>

<details>
<summary>¿Qué teorema fundamenta la correctitud del algoritmo de Prim?</summary>
Sea F un subconjunto de aristas en un AGM de G, y sea S un conjunto de vértices de una componente conexa de F. Sea ij una arista de peso mínimo entre S y S̄. Entonces, existe un AGM de G que incluye a todas las aristas de F ∪ {ij}.
</details>

---

## ⚙️ Algoritmo de Kruskal

<details>
<summary>¿Quién desarrolló el algoritmo de Kruskal y cuándo?</summary>
Joseph Kruskal lo desarrolló en 1956.
</details>

<details>
<summary>¿Cuál es la idea principal del algoritmo de Kruskal?</summary>
• Ordenar todas las aristas por peso
<br>
• En cada iteración, agregar la arista de menor peso que no forme un circuito con las aristas ya seleccionadas
<br>
• Repetir hasta tener n-1 aristas
</details>

<details>
<summary>¿Cómo funciona el algoritmo de Kruskal paso a paso?</summary>
1. E<sub>T</sub> := ∅, i := 1
<br>
2. Mientras i ≤ n-1:
<br>
   • Elegir arista e ∈ E de peso mínimo que no forme circuito con E<sub>T</sub>
<br>
   • E<sub>T</sub> := E<sub>T</sub> ∪ {e}
<br>
   • i := i + 1
<br>
3. Retornar T = (V, E<sub>T</sub>)
</details>

<details>
<summary>¿Qué diferencia principal hay entre Prim y Kruskal?</summary>
<b>Prim:</b> Construye el árbol expandiéndose desde un vértice inicial
<br>
<b>Kruskal:</b> Considera todas las aristas ordenadas por peso y las agrega si no crean ciclos
</details>

<details>
<summary>¿Para qué tipo de grafos es mejor usar Prim y para cuáles Kruskal?</summary>
<b>Prim:</b> Mejor para grafos densos
<br>
<b>Kruskal:</b> Mejor para grafos dispersos
</details>

---

## 🔗 Union-Find

<details>
<summary>¿Qué es la estructura de datos Union-Find?</summary>
Es una estructura que mantiene una colección de conjuntos disjuntos y permite:
<ul>
<li><b>Find:</b> Determinar a qué conjunto pertenece un elemento</li>
<li><b>Union:</b> Unir dos conjuntos en uno solo</li>
</ul>
</details>

<details>
<summary>¿Quiénes desarrollaron Union-Find y cuándo?</summary>
Bernard Galler y Michael Fischer la desarrollaron en 1964.
</details>

<details>
<summary>¿Para qué se usa Union-Find en el algoritmo de Kruskal?</summary>
Para detectar eficientemente si agregar una arista crearía un ciclo. Dos vértices están en el mismo conjunto si ya existe un camino entre ellos.
</details>

<details>
<summary>¿Cómo se representa Union-Find?</summary>
Con un arreglo donde cada vértice apunta a su padre. Los vértices forman árboles donde la raíz es el representante de la componente conexa.
</details>

<details>
<summary>¿Cómo se inicializa la estructura Union-Find?</summary>
Inicialmente cada vértice está en su propia componente conexa, es decir, cada vértice es su propio padre:
<br>
A[i] = i para todo i
</details>

<details>
<summary>¿Cómo funciona la operación Find en Union-Find?</summary>
<pre>
int root(int i) {
    while(A[i] != i)
        i = A[i];
    return i;
}
</pre>
Sigue los punteros hasta encontrar la raíz (el nodo que apunta a sí mismo).
</details>

<details>
<summary>¿Cómo funciona la operación Union en Union-Find?</summary>
<pre>
void union(int i, int j) {
    int ri = root(i);
    int rj = root(j);
    A[ri] = rj;
}
</pre>
Hace que la raíz de un árbol apunte a la raíz del otro.
</details>

<details>
<summary>¿Cuál es la complejidad básica de Union y Find sin optimizaciones?</summary>
Sin optimizaciones, ambas operaciones tienen complejidad O(n) en el peor caso (cuando el árbol se degenera en una lista).
</details>

---

## 🚀 Optimizaciones de Union-Find

<details>
<summary>¿Qué es la optimización "Union por tamaño"?</summary>
Consiste en llevar la cuenta del número de elementos en cada componente conexa y hacer que la raíz del árbol menor apunte a la raíz del árbol mayor.
<br>
Con esta optimización: Union y Find son O(log n)
</details>

<details>
<summary>¿Qué es Path Compression (compresión de caminos)?</summary>
Es una técnica de optimización que, al hacer Find, hace que todos los nodos en el camino apunten directamente a la raíz.
</details>

<details>
<summary>¿Qué es Path Splitting en Union-Find?</summary>
Es una técnica donde cada nodo apunta a su abuelo durante la operación Find.
</details>

<details>
<summary>¿Qué es Path Halving en Union-Find?</summary>
Es aplicar path splitting nodo de por medio durante la operación Find.
</details>

<details>
<summary>¿Cuál es la complejidad final de Union-Find con optimizaciones?</summary>
Si se usa alguna técnica de compactación y la unión por tamaño (o por altura), entonces el tiempo amortizado de cada operación es O(α(n)), donde α(n) es la inversa de la función de Ackermann.
</details>

<details>
<summary>¿Qué es la función de Ackermann?</summary>
Es una función definida recursivamente como:
<br>
A(m, n) = n + 1 si m = 0
<br>
A(m, n) = A(m-1, 1) si m > 0 y n = 0
<br>
A(m, n) = A(m-1, A(m, n-1)) si m > 0 y n > 0
<br>
Es una función que crece extremadamente rápido.
</details>

<details>
<summary>¿Qué tan eficiente es Union-Find optimizado en la práctica?</summary>
La función α(n) (inversa de Ackermann) crece tan lentamente que, a fines prácticos, α(n) ≤ 5 para cualquier valor razonable de n.
<br>
Esto hace que Union-Find sea casi constante en la práctica.
</details>

---

## 📈 Teoremas importantes

<details>
<summary>¿Qué propiedad de subestructura óptima cumplen los AGM?</summary>
Sea P<sub>ij</sub> un camino mínimo entre i y j, y sea k ∈ P<sub>ij</sub>. Entonces, el subcamino de P<sub>ij</sub> entre i y k es un camino mínimo entre i y k.
</details>

<details>
<summary>¿Qué garantiza que Prim y Kruskal encuentren un AGM?</summary>
Ambos algoritmos se basan en el teorema de que la arista de peso mínimo que conecta dos componentes conexas puede agregarse sin perder la propiedad de AGM.
</details>
