# 🧩 Semana 11 – Preguntas y Respuestas tipo Anki

## 🔹 Algoritmos geneticos

<details>
<summary><b>Que es un algoritmo genetico?</b></summary>
ES una tecnica que se encuadra dentro de las heuristicas (no garantiza una solucion exacta), es un algoritmo eficiente.
la idea general se basa en la teoria de la evolucion de las especies y se la denomina bio-inspired computing
</details>

<details>
<summary><b>Que hace un algoritmo genetico?</b></summary>
Simula una población de individuos(soluciones para el problema) que va evolucionando hasta encontrar una buena solucion. Itera sobre las posibles soluciones y sobreviven las
</details>

<details>
<summary><b>Que es un candidato a solucion en el problema de la mochila?</b></summary>
Se representa como un subconjunto de los elementos (puede cumplir el peso maximo o no)
</details>

<details>
<summary><b>como se representa una solucion de un algoritmo genetico?</b></summary>
Se representa una solucion por medio de una secuencia de bits, denominados un cromosoma o individuo
</details>

<details>
<summary><b>Que es una simulacion?</b></summary>
Se itera sobre
</details>

<details>
<summary><b>Que ocurre dentro de una simulación de un algoritmo genético?</b></summary>
Algunos individuos mutan espontáneamente
Algunos pares de individuos se combinan, generando individuos hijos
los peores individuos se eliminan y se reemplazan por nuevos
</details>

<details>
<summary><b>Que es la función de fitness?</b></summary>
Evalua cuales son los peores individuos y esta mide la calidad de un individuo
</details>

<details>
<summary><b>Que es la mutación de un algoritmo genético?</b></summary>
Afecta a algunos individuos aleatoria mente y cambia algún bit (puede ser 1 o mas) por ej: 1001 -> 1011
</details>

<details>
<summary><b>que es la recombinacion o que 2 individuos tengan hijos?</b></summary>
La recombinación genera 2 individuos hijos a partir de dos individuos padres
</details>

<details>
<summary><b>Que se necesita para plantear un algoritmo genético?</b></summary>
* Plantear la codificación de una solución con secuencia de bits.
* Definir una función de fitness adecuada para el problema.
* Cantidad de individuos en la poblacion m
* tasa de mutacion tm(probabilidad de seleccionar un individuo para mutarlo)
* La tasa de recombinacion tr (probabilidad de seleccionar un individuo para recombinarlo)
Algunos valores tipicos m = 1000, tm = 0.001 y tr=0.7 (se deben ajustar empiricamente)
</details>

<details>
<summary><b>Cuando termina un algoritmo genetico?</b></summary>
No hay un criterio definido pero algunos podrian ser los siguientes:
* Cuando se llega a un maximo de iteraciones
* CUnado la mejor solucion tiene una calidad mayor a un valor establecido
* cuando pasa por una cierta cantidad de iteraciones sin mejora
</details>

<details>
<summary><b>¿pregunta</b></summary>

</details>

<details>
<summary><b>¿pregunta</b></summary>

</details>
