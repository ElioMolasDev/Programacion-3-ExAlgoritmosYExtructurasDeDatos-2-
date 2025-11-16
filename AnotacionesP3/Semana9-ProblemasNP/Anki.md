# Preguntas Anki - NP-Completitud

## 🧩 Problemas de Decisión

<details>
<summary>¿Qué es un problema de decisión?</summary>
Es un problema cuya respuesta es un valor de tipo boolean (verdadero o falso).
</details>

<details>
<summary>¿Cómo se puede convertir el problema de "sumar elementos de un arreglo" en un problema de decisión?</summary>
Entrada: Un arreglo A y un número real k ∈ R. Salida: ¿Es cierto que la suma de los elementos de A es mayor o igual que k?
</details>

<details>
<summary>¿Cómo se puede usar un algoritmo para un problema de decisión para resolver el problema de optimización original?</summary>
Utilizando búsqueda binaria sobre el parámetro k, se puede convertir un algoritmo polinomial para el problema de decisión en un algoritmo polinomial para el problema original.
</details>

## 🎲 Computadoras No Determinísticas

<details>
<summary>¿Qué es una computadora no determinística?</summary>
Es una computadora que incluye una operación guess(A), que genera una opción aleatoriamente seleccionada del conjunto A.
</details>

<details>
<summary>¿Cuándo decimos que un algoritmo no determinístico resuelve un problema de decisión?</summary>
Cuando existe una secuencia de resultados de guess() que retorna true si y solo si la respuesta correcta es afirmativa.
</details>

<details>
<summary>¿Qué requisitos debe cumplir un algoritmo no determinístico?</summary>
<ul>
  <li>No siempre tiene que dar la respuesta correcta - solo debe existir UNA ejecución que retorne true cuando la respuesta es afirmativa</li>
  <li>Si la respuesta correcta es false, entonces SIEMPRE debe retornar false</li>
</ul>
</details>

## 📊 La Clase NP

<details>
<summary>¿Qué es la clase NP?</summary>
Es la clase compuesta por los problemas que se pueden resolver en tiempo polinomial por un algoritmo no determinístico.
</details>

<details>
<summary>¿Qué NO implica que un problema esté en NP?</summary>
NO implica que el problema se pueda resolver en tiempo eficiente en una computadora determinística normal.
</details>

<details>
<summary>¿Qué relación existe entre la clase P y la clase NP?</summary>
Los algoritmos determinísticos también son no determinísticos, con lo cual los problemas polinomiales están en NP. Por lo tanto, P ⊆ NP.
</details>

<details>
<summary>¿Por qué el problema TSP (versión de decisión) está en NP?</summary>
Porque se puede escribir un algoritmo no determinístico que use guess() para generar un circuito y luego verificar en tiempo polinomial si su distancia es menor o igual que k.
</details>

<details>
<summary>¿Por qué el problema de resolver un Sudoku está en NP?</summary>
Porque se puede usar guess() para llenar cada casillero libre con un número del 1 al 9, y luego verificar en tiempo polinomial si la matriz resultante es válida.
</details>

<details>
<summary>Mencione 5 problemas que están en NP</summary>
<ul>
  <li>Buscar un elemento en un arreglo</li>
  <li>Camino mínimo entre dos ciudades</li>
  <li>Camino máximo entre dos ciudades</li>
  <li>Clique máxima</li>
  <li>TSP (Traveling Salesman Problem)</li>
</ul>
</details>

## 🔄 Transformaciones y Reducciones

<details>
<summary>¿Qué es una transformación de un problema A en un problema B?</summary>
Es un programa p que toma un input I para A y lo convierte en un input p(I) = I' para B, de modo tal que A(I) = true si y solo si B(I') = true.
</details>

<details>
<summary>¿Qué es una transformación polinomial?</summary>
Es una transformación donde el programa p es un algoritmo polinomial en el tamaño de I.
</details>

<details>
<summary>¿Qué significa la notación A ≤P B?</summary>
Significa que existe una transformación polinomial de A en B, y denota que B es igual o más difícil que A.
</details>

<details>
<summary>¿Cómo se puede usar un algoritmo que resuelve B para resolver A cuando A ≤P B?</summary>
<ol>
  <li>Dado el input I para A, calcular I' = p(I)</li>
  <li>Aplicar el algoritmo b sobre I' y retornar b(I')</li>
</ol>
</details>

## 🔴 Problemas NP-Completos - Definición

<details>
<summary>¿Qué es un problema NP-completo?</summary>
Un problema B ∈ NP es NP-completo si A ≤P B para todo otro problema A ∈ NP. Son los problemas más difíciles dentro de NP.
</details>

<details>
<summary>¿Qué característica tienen los problemas NP-completos en términos de dificultad?</summary>
Son los problemas MÁS DIFÍCILES dentro de NP, de acuerdo con la relación de dificultad dada por las transformaciones polinomiales.
</details>

<details>
<summary>¿Se conocen algoritmos polinomiales para problemas NP-completos?</summary>
No, no se conocen algoritmos polinomiales para resolver estos problemas.
</details>

<details>
<summary>¿Qué pasaría si se encontrara un algoritmo polinomial para algún problema NP-completo?</summary>
Entonces P = NP y todos los problemas en NP se podrían resolver en tiempo polinomial.
</details>

<details>
<summary>¿Qué pasaría si se probara que NO existe un algoritmo polinomial para algún problema NP-completo?</summary>
Entonces P ≠ NP y todos los problemas NP-completos serían exponenciales (inherentemente difíciles).
</details>

## 🎯 Teorema de Cook-Levin

<details>
<summary>¿Qué es el problema SAT (Satisfactibilidad)?</summary>
Entrada: Una fórmula proposicional f. Salida: ¿Existe una asignación de valores de verdad a las proposiciones de f que hace que f sea verdadera?
</details>

<details>
<summary>¿Qué establece el Teorema de Cook-Levin?</summary>
Establece que SAT es NP-completo. Fue probado por Cook en 1971 y Levin en 1973.
</details>

<details>
<summary>¿Por qué es importante el Teorema de Cook-Levin?</summary>
Fue la PRIMERA demostración de que un problema es NP-completo, estableciendo el punto de partida para demostrar que otros problemas son NP-completos.
</details>

<details>
<summary>¿Cuántos problemas NP-completos se conocen actualmente?</summary>
Se conocen más de 3,000 problemas NP-completos. Richard Karp demostró en 1972 que 21 problemas son NP-completos partiendo del Teorema de Cook-Levin.
</details>

## 🔬 Demostrar NP-Completitud

<details>
<summary>¿Cuáles son los dos pasos para demostrar que un problema B es NP-completo?</summary>
<ol>
  <li>Verificar que B ∈ NP (generalmente fácil)</li>
  <li>Encontrar una transformación polinomial desde un problema NP-completo conocido C hacia B, es decir, mostrar que C ≤P B</li>
</ol>
</details>

<details>
<summary>¿Por qué si C ≤P B y C es NP-completo, entonces B es NP-completo?</summary>
Porque para todo problema A ∈ NP se cumple que A ≤P C, y por transitividad A ≤P C ≤P B, por lo tanto A ≤P B para todo A ∈ NP, que es la definición de NP-completo.
</details>

<details>
<summary>¿Cómo se transforma una instancia del TSP en una instancia del VRP para probar que VRP es NP-completo?</summary>
Dada una instancia del TSP (matriz A, número k), se construye la instancia del VRP con: misma matriz A, m = 1 camión, capacidad ci = 1 para cada cliente, capacidad C = n del camión, y el mismo k. La solución se preserva en ambos sentidos.
</details>

## 📝 Ejemplos de Problemas NP-Completos

<details>
<summary>Mencione al menos 8 problemas NP-completos</summary>
<ul>
  <li>Clique máxima en grafos</li>
  <li>Problema del viajante de comercio (TSP)</li>
  <li>Problema de la mochila (Knapsack)</li>
  <li>Problema de ruteo de vehículos (VRP)</li>
  <li>Set partition</li>
  <li>Programación de máquinas homogéneas</li>
  <li>Sudoku</li>
  <li>Tetris</li>
  <li>SAT</li>
  <li>Coloreo de grafos</li>
</ul>
</details>

## 🔍 Ejemplo: 3-SAT y MIS

<details>
<summary>¿Qué es el problema 3-SAT?</summary>
Entrada: Una fórmula proposicional con a lo sumo tres proposiciones por cláusula. Salida: ¿Existe una valuación que haga verdadera a la fórmula?
</details>

<details>
<summary>¿Qué es un conjunto independiente en un grafo?</summary>
Es un conjunto de vértices que no son vecinos entre sí (ningún par de vértices está conectado por una arista).
</details>

<details>
<summary>¿Qué es el problema MIS (Conjunto Independiente Máximo)?</summary>
Entrada: Un grafo G y un número k ∈ Z+. Salida: ¿Existe un conjunto independiente en G de tamaño k o mayor?
</details>

<details>
<summary>¿Cómo se construye un grafo a partir de una fórmula 3-SAT para probar que MIS es NP-completo?</summary>
<ol>
  <li>Para cada cláusula, crear vértices (uno por cada literal)</li>
  <li>Conectar literales contradictorios (x y ¬x) entre diferentes cláusulas</li>
  <li>Si la fórmula tiene c cláusulas, fijar k = c</li>
</ol>
La fórmula es satisfactible si y solo si el grafo tiene un conjunto independiente de tamaño k o superior.
</details>

## ⚖️ La Conjetura P vs. NP

<details>
<summary>¿Cuáles son los dos escenarios posibles respecto a P vs. NP?</summary>
<ul>
  <li>P = NP: Todos los problemas en NP se pueden resolver en tiempo polinomial</li>
  <li>P ≠ NP: Los problemas NP-completos son intrínsecamente difíciles y no existe algoritmo polinomial para ellos</li>
</ul>
</details>

<details>
<summary>¿Qué importancia tiene el problema P vs. NP?</summary>
Es uno de los problemas del milenio con premio de U$S 1,000,000 y uno de los problemas abiertos más importantes de la computación.
</details>

<details>
<summary>¿Qué consecuencias tendría que P = NP?</summary>
<ul>
  <li>Positivas: Problemas de optimización, logística, biología computacional se volverían eficientemente resolubles</li>
  <li>Negativas: Los sistemas criptográficos actuales (como RSA, AES) quedarían obsoletos ya que se podrían romper eficientemente</li>
</ul>
</details>

<details>
<summary>¿Qué opinión prevalece entre los expertos sobre P vs. NP?</summary>
La mayoría de los expertos cree que P ≠ NP, es decir, que los problemas NP-completos son inherentemente difíciles.
</details>

## 🛠️ Estrategias Prácticas

<details>
<summary>Dado un problema de decisión, ¿cuáles son las tres posibilidades que tenemos?</summary>
<ol>
  <li>Existe un algoritmo polinomial (se demuestra encontrándolo)</li>
  <li>El problema es NP-completo (se demuestra por transformación polinomial)</li>
  <li>Es un problema abierto</li>
</ol>
</details>

<details>
<summary>¿Qué estrategias existen para abordar un problema NP-completo en la práctica?</summary>
<ol>
  <li>Analizar si el tamaño de las instancias permite fuerza bruta o backtracking</li>
  <li>Reducir a un problema NP-completo con solvers eficientes (SAT, programación lineal entera)</li>
  <li>Buscar casos particulares que se puedan resolver eficientemente</li>
  <li>Diseñar heurísticas ad hoc para el problema</li>
  <li>Diseñar metaheurísticas (algoritmos genéticos, evolutivos, etc.)</li>
</ol>
</details>

<details>
<summary>¿Es común que los problemas NP-completos tengan casos particulares polinomiales?</summary>
Sí, es habitual que los problemas NP-completos tengan casos particulares polinomiales, generalmente dados por restricciones sobre el input.
</details>

## ⚔️ Algoritmos Exactos vs. Heurísticas

<details>
<summary>¿Qué diferencias hay entre algoritmos exactos y heurísticos para problemas NP-completos?</summary>
<ul>
  <li>Exactos: Buena calidad de solución (óptima) pero mala complejidad (exponencial)</li>
  <li>Heurísticos: Buena complejidad (polinomial) pero calidad de solución no garantizada</li>
</ul>
</details>

<details>
<summary>¿Se puede tener un algoritmo con buena complejidad Y buena calidad de solución garantizada para problemas NP-completos?</summary>
No, a menos que P = NP. Hay un trade-off fundamental entre complejidad y calidad de solución garantizada.
</details>

<details>
<summary>¿Qué alternativas realistas existen para problemas NP-completos?</summary>
<ul>
  <li>Algoritmos exactos con tiempos razonables para instancias específicas</li>
  <li>Heurísticas con la mejor calidad de solución posible (sin garantías formales)</li>
</ul>
</details>

## 📚 Perspectiva Histórica

<details>
<summary>¿Qué libro clásico estableció las bases de la teoría de NP-completitud?</summary>
"Computers and Intractability: A Guide to the Theory of NP-Completeness" de Michael Garey y David Johnson (1979).
</details>

<details>
<summary>¿Cuál es la aplicación principal de la teoría de NP-completitud según Garey y Johnson?</summary>
Asistir a los diseñadores de algoritmos en dirigir sus esfuerzos de resolución de problemas hacia aquellos enfoques que tienen mayor probabilidad de llevar a algoritmos útiles.
</details>

<details>
<summary>¿Qué sucedió con la clase NP a lo largo de los años?</summary>
Con el paso de los años, se probó que la gran mayoría de problemas en NP es NP-completo. Quedan actualmente muy pocos problemas abiertos (como la factorización en primos).
</details>

## 🎓 Conceptos Avanzados

<details>
<summary>¿Qué significa que los problemas NP-completos estén relacionados entre sí?</summary>
Todos los problemas NP-completos son equivalentes en dificultad: si encontramos un algoritmo polinomial para UNO de ellos, automáticamente tenemos algoritmos polinomiales para TODOS ellos.
</details>

<details>
<summary>¿Por qué es útil saber que un problema es NP-completo en la práctica?</summary>
<ul>
  <li>Evita perder tiempo buscando un algoritmo polinomial exacto que probablemente no existe</li>
  <li>Justifica el uso de heurísticas y algoritmos aproximados</li>
  <li>Orienta hacia casos especiales o relajaciones del problema</li>
  <li>Informa decisiones sobre recursos y expectativas</li>
</ul>
</details>
