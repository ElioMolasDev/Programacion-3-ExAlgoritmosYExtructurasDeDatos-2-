# 🧩 Semana 2 – Preguntas y Respuestas tipo Anki

## 🔹Teoria de Grafos

<details> <summary><b>¿Qué es un grafo?</b></summary>
Un grafo es un par de conjuntos G=(V,E), donde:
* V es el conjunto de vértices.
* E⊆{ij∈V×V:i distinto a j} es el conjunto de aristas.
Cada arista conecta un par de vértices.

</details>
<details> <summary><b>¿Qué significa que dos vértices sean vecinos?</b></summary>
Dos vértices i y j son vecinos si existe una arista ij∈E que los une.
</details>

<details> <summary><b>¿Qué es el vecindario de un vértice?</b></summary>
El vecindario de un vértice i es el conjunto de vertices para los cuales existe un arista que los una.
N(i) = {j∈V : ij ∈ E}
</details>


<details> <summary><b>¿Qué es el grado de un vértice?</b></summary>
El grado de un vértice i es la cantidad de vecinos que tiene:
 d(i) = |N(i)|
</details>

<details> <summary><b>¿Qué es un camino entre dos vértices?</b></summary>
Un camino entre i y j es una secuencia de aristas consecutivas que conectan ambos vértices.
</details>


<details> <summary><b>¿Qué es la distancia entre dos vértices?</b></summary>
La distancia entre dos vértices es la cantidad mínima de aristas que hay en un camino que los une.
</details>

<details> <summary><b>¿Qué es un grafo conexo?</b></summary>
Un grafo es conexo si existe un camino entre todo par de vértices.
</details>

<details> <summary><b>¿Qué es una componente conexa?</b></summary>
Una componente conexa es un subconjunto de vértices conexo.
Un grafo conexo tiene exactamente una componente conexa.
</details>

<details> <summary><b>¿Qué es un vértice aislado?</b></summary>
Un vértice aislado es aquel que no tiene aristas incidentes, es decir, su grado es 
d(i)=0
</details>


## 🧮 Representaciones de Grafos
<details> <summary><b>¿Qué es la matriz de adyacencia de un grafo?</b></summary>
Es una matriz cuadrada 
A=(aij) donde:
* aij =1 si existe la arista 
* aij =0 si no existe.

</details>
<details> <summary><b>¿Cuáles son las ventajas de la matriz de adyacencia?</b></summary>
Agregar una arista → O(1)
Eliminar una arista → O(1)
Consultar si existe una arista → O(1)
</details>

<details> <summary><b>¿Cuáles son las desventajas de la matriz de adyacencia?</b></summary>
Agregar un vértice → O(n²)
Eliminar un vértice → O(n²)
Obtener todos los vecinos de un vértice → O(n)
</details>

<details> <summary><b>¿Qué es la matriz de incidencia de un grafo?</b></summary>
Es una matriz 
M=(mie) de tamaño ∣V∣×∣E∣ tal que:
* mie =1 si el vértice i es extremo de la arista e.
* mie =0 en caso contrario.
</details>

<details> <summary><b>¿Qué es una lista de adyacencia o lista de vecinos?</b></summary>
Es una representación donde cada vértice tiene una lista o conjunto que contiene a todos sus vecinos.
Por ejemplo:
1 → 2, 3 
2 → 1, 3, 4 
3 → 1, 2, 4, 6 
...
</details>

<details> <summary><b>¿Cuáles son las ventajas de usar listas de vecinos?</b></summary>
Obtener todos los vecinos → O(1)
Agregar un vértice → O(1) amortizado
Agregar una arista → O(1) promedio
Eliminar una arista → O(1) promedio
Consultar si existe una arista → O(1) promedio
</details>

<details> <summary><b>¿Cuál es la desventaja de las listas de vecinos?</b></summary>
Eliminar un vértice cuesta O(n) en el peor caso.
(Si se usan TreeSet, las operaciones sobre aristas pueden costar O(log n)).
</details>

## 🔁 Grafos Dirigidos
<details> <summary><b>¿Qué es un grafo dirigido (o digrafo)?</b></summary>
Un grafo dirigido es un par D=(N,A) donde:
* N es el conjunto de nodos.
* A⊆{(i,j)∈N×N:i distinto de j} es el conjunto de arcos (pares ordenados).
</details>

<details> <summary><b>¿Qué diferencia hay entre aristas y arcos?</b></summary>
* En un grafo no dirigido, las aristas no tienen dirección.
* En un grafo dirigido, los arcos tienen sentido, es decir, el orden importa: (i,j) ≠ (j,i).
</details>

<details> <summary><b>¿Qué son el grado de entrada y el grado de salida?</b></summary>

* Grado de entrada:
    d−(i)=∣{j∈N:(j,i)∈A}∣
* Grado de salida:
    d+(i)=∣{j∈N:(i,j)∈A}∣
</details>

<details> <summary><b>¿Qué es un camino en un grafo dirigido?</b></summary>
Es una secuencia de arcos entre nodos, donde cada arco sigue la dirección establecida en el grafo.
</details>

