## 🧩 Conceptos básicos

<details>
<summary>¿Que es el problema de flujo maximo?</summary>
dado grafo dirigido G=(N,A), los nodos especiales s (origen) y t (destino), y una función de capacidad c para los arcos se debe encontrar el valor máximo de flujo que se puede transportar desde un nodo origen (s) hasta un nodo destino (t) en la red.
</details>

<details>
<summary>¿Cuáles son las dos condiciones que un envío de cantidades debe cumplir para ser un "flujo" válido?</summary>
  <ul>
    <li>Restricción de Capacidad: El flujo por un arco no debe superar su capacidad.</li>
    <li>Conservación del Flujo: En todos los nodos intermedios, el flujo que entra debe ser igual al flujo que sale.</li>
  </ul>
</details>

<details>
<summary>¿Qué es la "restricción de capacidad" y cómo se representa matemáticamente?</summary>
Es la condición de que la cantidad de flujo f(e) enviada por un arco e debe ser menor o igual a su capacidad c(e), es decir, f(e)<= c(e).
</details>

<details>
<summary>¿Cómo se calcula el valor del flujo (F)?</summary>
Se calcula como la cantidad total de flujo que sale del nodo origen (s).
</details>

## ✂️ Cortes en la red

<details>
<summary>Defina el concepto de un "corte" en una red de flujo</summary>
Un corte en la red G = (N, A) es un subconjunto S ⊆ N \ {t} : s ∈ S. S es un subconjunto incluido en N - el nodo t (nodo de destino) talque s (nodo de origen) pertenece al subconjunto S
</details>

<details>
<summary>¿Qué relación existe entre el flujo y la capacidad de un corte?</summary>
<ul>
  <li>Sea F un flujo definido en la red G = (N, A) y S un corte -> F = (Sumarotia flujos de los arcos f(e) de salida) - (Sumarotia flujos de los arcos f(e) de entrada)</li>
  <li>Para todo flujo F y todo corte S, se cumple F≤c(S).</li>
</ul>
  
</details>

<details>
<summary>¿¿Qué ocurre si F=c(S)??</summary>
Entonces f es un flujo máximo y S un corte mínimo (certificado de optimalidad).
</details>

## 🔄 Red residual y caminos de aumento
<details>
<summary>¿¿Qué es la red residual R(N,f)??</summary>
Dada una red G = (N, A) con función de capacidad c y un flujo factible f , definimos la red residual R(N, f ) = (N, AR ), donde:
<il>
  <li>vw ∈ AR si f (vw ) <. c(vw ),</li>
  <li>wv ∈ AR si f (vw ) > 0. </li>
<il>
</details>

<summary>¿¿Qué es un camino de aumento??</summary>
Un camino de aumento P es un camino orientado de s a t en la red Recidual R(N, f)
</details>

## ⚙️ Algoritmo de Ford y Fulkerson


<details>
<summary>¿Qué es un "camino de aumento" en el contexto del Algoritmo de Ford y Fulkerson?</summary>
Es un camino orientado desde el origen (s) hasta el destino (t) en la Red Residual que tiene capacidad disponible para transportar flujo adicional.
</details>

<details>
<summary>¿Cuál es el criterio de parada del Algoritmo de Ford y Fulkerson?</summary>
f es un flujo es máximo cuando no se puede encontrar ningún camino de aumento P en la Red Residual.
</details>

<details>
<summary>¿Que teoremas salen del algoritmo Ford y Fulkenson?</summary>
• Si las capacidades de los arcos de la red son enteras,
entonces el problema de flujo máximo tiene un flujo máximo
entero    
• Teorema: Si los valores del flujo inicial y las capacidades de los
arcos de la red son enteras, entonces el método de Ford y
Fulkerson realiza a lo sumo nU iteraciones, donde U es una cota
superior finita para el valor de las capacidades.
</details>

<details>
<summary>¿Cual es la complejidad del algoritmo Ford y Fulkenson?</summary>
El algoritmo de Ford y Fulkerson obtiene un flujo máximo con complejidad O(nmU), donde U = max [e ∈ E c(e)]. esto es pseudo-Polinomial y esto no es satisfactorio
</details>

## ⚙️ Algoritmo de Edmon y Karps

<details>
<summary>¿que hace el algoritmo de Edmon y Karps?</summary>
este algoritmo consiste en usar BFS para buscar caminos de aumento y su complejidad es O(nm²).
</details>
 
