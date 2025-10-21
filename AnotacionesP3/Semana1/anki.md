# 🧩 Semana 1 – Preguntas y Respuestas tipo Anki

## 🔹 Complejidad Computacional

<details>
<summary><b>¿Qué estudia la complejidad computacional?</b></summary>
Analiza el tiempo y los recursos necesarios para ejecutar un algoritmo según el tamaño de la entrada.
</details>

<details>
<summary>**¿Cuál es la forma habitual de medir el tiempo de ejecución de un algoritmo?**</summary>
Evaluando el peor caso en función del tamaño de la entrada del algoritmo.
</details>

<details>
<summary>**En el contexto de la Notación O grande (Big O), si $f \in O(g)$, ¿qué significa intuitivamente esta relación para valores grandes de $n$?**</summary>
La función g(n) "le gana" a f(n) o f(n) crece a lo sumo tan rápido como g(n).
La definición formal de f∈O(g) implica que existe un factor α y un n0 tal que f(n)≤αg(n) para todo n≥n0
</details>

<details>
<summary>**¿qué modelo se utiliza para los análisis de complejidad computacional en la materia, asumiendo que cada dato individual ocupa una posición de memoria?**</summary>
Modelo uniforme
El modelo uniforme asume que cada dato individual ocupa una posición individual de memoria y es el modelo de base para el análisis en el contexto de la materia
</details>

<details>
<summary>¿Qué mide la eficiencia temporal?</summary>
La cantidad de operaciones o el tiempo de ejecución que requiere un algoritmo.
</details>

<details>
<summary>¿Qué mide la eficiencia espacial?</summary>
La cantidad de memoria utilizada durante la ejecución.
</details>

<details>
<summary>¿Qué representa la notación O grande?</summary>
Una cota superior del crecimiento de la función de complejidad, describiendo el peor caso.
</details>

<details>
<summary>¿Cuál es la complejidad de la búsqueda binaria?</summary>
O(log n)
</details>

<details>
<summary>¿Cuál es la complejidad del ordenamiento burbuja?</summary>
O(n²)
</details>

<details>
<summary>¿Qué complejidad tiene QuickSort en el mejor y peor caso?</summary>
Mejor/promedio → O(n log n), peor → O(n²)
</details>

<details>
<summary>¿Qué tipo de complejidad tienen los algoritmos de fuerza bruta?</summary>
Exponencial, típicamente O(2ⁿ).
</details>

---

## 🔹 Divide and Conquer

<details>
<summary>**¿Qué significa “Divide and Conquer”?**</summary>
Es una estrategia que divide un problema en subproblemas más pequeños, los resuelve recursivamente y combina las soluciones.
</details>

<details>
<summary>**¿Cuáles son las tres etapas de Divide and Conquer?**</summary>
Dividir la instancia, resolver recursivamente los subproblemas, y combinar las soluciones.
</details>

<details>
<summary>**¿Qué algoritmo de ordenamiento se basa en Divide and Conquer?**</summary>
MergeSort y QuickSort.
</details>

<details>
<summary>**En el contexto de Divide y Vencerás aplicado al ordenamiento de arreglos, ¿cuál es la principal diferencia entre Mergesort y Quicksort con respecto a la división y combinación de subproblemas?**</summary>
Mergesort divide primero y su combinación (apareo) es la parte costosa; Quicksort separa primero con un pivote, haciendo que la combinación sea sencilla.
Mergesort realiza el apareo (combinación) como el trabajo principal después de la recursión. Quicksort realiza el trabajo principal (particionar con el pivote) antes de la recursión, dejando la combinación sencilla.
</details>

<details>
<summary>**¿Cuál es la complejidad del peor caso de Quicksort, y en qué situación típica ocurre según el material**</summary>
Reducir la complejidad y resolver problemas grandes de forma más eficiente mediante recursión.
</details>

<details>
<summary>**¿Cuál es el propósito de dividir un problema en subproblemas más pequeños?**</summary>
Peor caso O(n^2), ocurre cuando el arreglo está ordenado al revés.
En esta situación, o cuando está completamente ordenado, el pivote siempre resulta ser el elemento más grande o más pequeño, lo que lleva a un desbalance y a la complejidad cuadrática.
</details>

<details>
<summary>**¿Cuál es un problemas que se menciona como un ejemplo para el cual la técnica Divide y Vencerás es la base de algoritmos eficientes, además del ordenamiento de arreglos?**</summary>
La multiplicación de números grandes.
El Algoritmo de Karatsuba para la multiplicación de enteros grandes se presenta como un ejemplo clave de Divide y Vencerás que mejora la complejidad cuadrática.
</details>

<details>
<summary>**El Algoritmo de Karatsuba para multiplicar dos enteros grandes $x$ e $y$ (basado en Divide y Vencerás) logra una complejidad más eficiente que $O(n^2)$ al reducir el número de multiplicaciones recursivas a:**</summary>
Tres (3) multiplicaciones recursivas de sub-problemas.
Karatsuba necesita calcular A=x1.y1, B=x2.y2 y C=(x1+x2)(y1+y2), lo que suma tres multiplicaciones recursivas en lugar de las cuatro del método clásico, logrando una complejidad de O(n^1.585).
</details>


