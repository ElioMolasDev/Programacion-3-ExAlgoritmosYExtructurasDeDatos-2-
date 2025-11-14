## 🧩 Conceptos básicos

<details>
<summary>¿Que es el problema de flujo maximo?</summary>
dado grafo dirigido G=(N,A), los nodos especiales s (origen) y t (destino), y una función de capacidad c para los arcos se debe encontrar el valor máximo de flujo que se puede transportar desde un nodo origen (s) hasta un nodo destino (t) en la red.
</details>

<details>
<summary>¿Cuáles son las dos condiciones que un envío de cantidades debe cumplir para ser un "flujo" válido?</summary>
1. Restricción de Capacidad: El flujo por un arco no debe superar su capacidad.
2. Conservación del Flujo: En todos los nodos intermedios, el flujo que entra debe ser igual al flujo que sale.
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
Para todo flujo F y todo corte S, se cumple F≤c(S).
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

## ⚙️ Algoritmo de Ford y Fulkerson


<details>
<summary>¿Qué es un "camino de aumento" en el contexto del Algoritmo de Ford y Fulkerson?</summary>
Es un camino orientado desde el origen (s) hasta el destino (t) en la Red Residual que tiene capacidad disponible para transportar flujo adicional.
</details>

<details>
<summary>¿Cuál es el criterio de parada del Algoritmo de Ford y Fulkerson?</summary>
El flujo es máximo cuando no se puede encontrar ningún camino de aumento en la Red Residual.
</details>

<details>
<summary>¿Qué significa que F = c(S) para un flujo f y un corte S?</summary>
Significa que f es un flujo máximo y S es un corte de capacidad mínima.
</details>
