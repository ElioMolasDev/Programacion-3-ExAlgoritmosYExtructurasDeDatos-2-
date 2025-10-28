<details>
<summary>¿Cuál es el propósito del Problema del Flujo Máximo?</summary>
Encontrar el valor máximo de flujo que se puede transportar desde un nodo origen (s) hasta un nodo destino (t) en una red dirigida.
</details>

<details>
<summary>¿Qué elementos componen la entrada de una red de flujo?</summary>
Un grafo dirigido G=(N,A), los nodos especiales s (origen) y t (destino), y una función de capacidad c para los arcos.
</details>

<details>
<summary>¿Cuáles son las dos condiciones que un envío de cantidades debe cumplir para ser un "flujo" válido?</summary>
1. Restricción de Capacidad: El flujo por un arco no debe superar su capacidad.
2. Conservación del Flujo: En todos los nodos intermedios, el flujo que entra debe ser igual al flujo que sale.
</details>

<details>
<summary>¿Qué es la "restricción de capacidad" y cómo se representa matemáticamente?</summary>
Es la condición de que la cantidad de flujo f(e) enviada por un arco e debe ser menor o igual a su capacidad c(e), es decir, f(e)\le c(e).
</details>

<details>
<summary>¿Cómo se calcula el valor del flujo (F)?</summary>
Se calcula como la cantidad total de flujo que sale del nodo origen (s).
</details>

<details>
<summary>Defina el concepto de un "corte" en una red de flujo</summary>
Es una partición de los nodos en dos conjuntos, S y \overline{S}, donde el nodo origen s está en S y el nodo destino t está en \overline{S}.
</details>

<details>
<summary>¿Qué establece el Teorema de Flujo Máximo - Corte Mínimo?</summary>
Establece que el valor del flujo máximo es igual a la capacidad del corte mínimo en la red.
</details>

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
