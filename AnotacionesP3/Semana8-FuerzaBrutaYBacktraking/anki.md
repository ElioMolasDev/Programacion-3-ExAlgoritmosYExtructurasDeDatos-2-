# Preguntas Anki - Fuerza Bruta y Backtracking

## 🧩 Conceptos básicos

<details>
<summary>¿Qué es un problema en el contexto de complejidad computacional?</summary>
Es la descripción de los datos de entrada y la respuesta a proporcionar para cada dato de entrada.
</details>

<details>
<summary>¿Qué es una instancia de un problema?</summary>
Es un juego válido de datos de entrada para un problema específico.
</details>

<details>
<summary>¿Qué es un problema de decisión?</summary>
Es un problema cuya respuesta es un valor booleano (verdadero o falso).
</details>

<details>
<summary>¿Qué es un problema de optimización?</summary>
Es un problema que consiste en encontrar la mejor solución dentro de un conjunto factible, maximizando o minimizando una función objetivo: z* = max f(x) o z* = min f(x), donde x ∈ S.
</details>

<details>
<summary>¿Qué es la función objetivo en un problema de optimización?</summary>
Es la función f: S → R que se busca maximizar o minimizar para encontrar la solución óptima del problema.
</details>

<details>
<summary>¿Qué es la región factible en un problema de optimización?</summary>
Es el conjunto S de todas las soluciones factibles (válidas) del problema. Los elementos x ∈ S se llaman soluciones factibles.
</details>

<details>
<summary>¿Qué es un óptimo del problema?</summary>
Es cualquier solución factible x* ∈ S tal que f(x*) = z*, donde z* es el valor óptimo del problema.
</details>

## 💪 Algoritmos de Fuerza Bruta

<details>
<summary>¿Qué es un algoritmo de fuerza bruta?</summary>
Es un algoritmo que consiste en generar todas las soluciones factibles de un problema y quedarse con la mejor. También se le llama búsqueda exhaustiva o "generate and test".
</details>

<details>
<summary>¿Cuáles son las principales ventajas de los algoritmos de fuerza bruta?</summary>
<ul>
  <li>Es una técnica muy general que se puede aplicar a cualquier problema</li>
  <li>Suele ser fácil de implementar</li>
  <li>Es un algoritmo exacto: si hay solución, siempre la encuentra</li>
</ul>
</details>

<details>
<summary>¿Cuál es el principal problema de los algoritmos de fuerza bruta?</summary>
Su complejidad, que habitualmente es exponencial, lo cual los hace impracticables para instancias grandes debido a la explosión combinatoria.
</details>

<details>
<summary>¿Qué es la explosión combinatoria?</summary>
Es el efecto que ocurre cuando el número de posibles soluciones crece exponencialmente con el tamaño de la entrada, haciendo que el algoritmo sea impracticable incluso para instancias moderadamente grandes.
</details>

## 🔍 Problema de Clique Máxima

<details>
<summary>¿Qué es una clique en un grafo?</summary>
Es un conjunto de vértices que son vecinos dos a dos (todos los vértices están conectados entre sí).
</details>

<details>
<summary>¿Cómo se define el problema de clique máxima?</summary>
Entrada: Un grafo G. Salida: El tamaño ω(G) de la mayor clique de G.
</details>

<details>
<summary>¿Cuál es la complejidad de un algoritmo de fuerza bruta para el problema de clique máxima?</summary>
Al menos O(2^n), donde n es el número de vértices, porque debe generar y evaluar todos los 2^n subconjuntos posibles del conjunto de vértices.
</details>

<details>
<summary>¿Cómo funciona el algoritmo de fuerza bruta para clique máxima?</summary>
<ol>
  <li>Generar todos los subconjuntos posibles de vértices (conjunto de partes)</li>
  <li>Para cada subconjunto, revisar si es una clique</li>
  <li>Calcular su tamaño y quedarse con el mayor</li>
</ol>
</details>

## 🚗 Problema del Viajante de Comercio (TSP)

<details>
<summary>¿Cómo se define el problema del viajante de comercio (TSP)?</summary>
Entrada: n ciudades y una matriz simétrica A ∈ R^(n×n) de distancias entre ciudades. Salida: El orden en que se deben recorrer las ciudades para minimizar la distancia total.
</details>

<details>
<summary>¿Cómo se representa un recorrido en el problema TSP?</summary>
Un recorrido está dado por una permutación del conjunto C = {0, ..., n-1} de ciudades.
</details>

<details>
<summary>¿Cuál es la complejidad de un algoritmo de fuerza bruta para TSP?</summary>
O(n² · n!), porque hay n! permutaciones posibles y calcular la distancia de cada recorrido toma O(n²) operaciones.
</details>

<details>
<summary>¿Cuántas permutaciones existen para un conjunto de n elementos?</summary>
n! (factorial de n) permutaciones.
</details>

<details>
<summary>¿Se conocen algoritmos eficientes para resolver TSP de forma exacta?</summary>
No, no se conocen algoritmos con un peor caso mejor que O(n!) para el problema del viajante de comercio, y se sospecha que no existen.
</details>

## 🔙 Backtracking - Conceptos

<details>
<summary>¿Qué es el backtracking?</summary>
Es una técnica que recorre exhaustivamente todos los posibles candidatos a solución de un problema, pero interrumpe la construcción de un candidato cuando detecta que no será una solución válida.
</details>

<details>
<summary>¿Qué requisitos debe tener un problema para aplicar backtracking?</summary>
Debe tener una noción de solución parcial (o parcialmente construida), de modo que se pueda testear rápidamente si la solución parcial es incoherente o no puede completarse a una solución del problema.
</details>

<details>
<summary>¿Por qué backtracking es más eficiente que fuerza bruta?</summary>
Porque al saltear las soluciones parciales que no tienen sentido (poda), no recorre todas las posibles soluciones, reduciendo significativamente el espacio de búsqueda.
</details>

<details>
<summary>¿Qué es el árbol de soluciones en backtracking?</summary>
Es una visualización del proceso donde:
<ul>
  <li>En cada nivel se agrega un elemento a la construcción de la solución</li>
  <li>Las hojas corresponden a los candidatos a soluciones</li>
</ul>
</details>

<details>
<summary>¿Qué significa "podar" una rama del árbol de soluciones?</summary>
Significa saltear o ignorar todas las soluciones que se derivan de una solución parcial inválida, evitando explorar ramas del árbol donde se detecta que no hay soluciones válidas.
</details>

<details>
<summary>¿Cómo se implementan típicamente los algoritmos de backtracking?</summary>
Se implementan típicamente por medio de una recursión, donde cada llamada recursiva explora una opción y retrocede (deshace cambios) cuando encuentra que no es viable.
</details>

## 👑 Problema de las 8 Reinas

<details>
<summary>¿Cuál es el objetivo del problema de las 8 reinas?</summary>
Ubicar 8 reinas en un tablero de ajedrez (8×8) de modo tal que ninguna amenace a otra.
</details>

<details>
<summary>¿Cuántas combinaciones debe analizar un algoritmo de fuerza bruta para el problema de las 8 reinas?</summary>
C(64, 8) = 4,426,165,368 combinaciones si consideramos todos los posibles conjuntos de 8 casillas.
</details>

<details>
<summary>¿Cómo se puede reducir el espacio de búsqueda en el problema de las 8 reinas antes de aplicar backtracking?</summary>
Considerando solamente una reina por cada columna, lo que reduce las combinaciones a 8^8 = 16,777,216.
</details>

<details>
<summary>¿Cómo funciona el algoritmo de backtracking para las 8 reinas?</summary>
<ol>
  <li>Poner una reina en la primera columna</li>
  <li>Poner una reina en la segunda columna que no se ataque con la primera. Si no se puede, volver al paso 1</li>
  <li>Poner una reina en la tercera columna que no se ataque con las dos primeras. Si no se puede, volver al paso 2</li>
  <li>Continuar hasta completar las 8 columnas</li>
</ol>
</details>

<details>
<summary>¿Cuál es el paso clave en el algoritmo de backtracking para las 8 reinas?</summary>
Interrumpir la construcción de la solución tan pronto como se detecta que no es posible continuar porque algún par de reinas se amenaza mutuamente.
</details>

## 🎲 Resolución de Sudokus

<details>
<summary>¿Qué es un Sudoku?</summary>
Es un juego en el que hay que completar un tablero con números del 1 al 9 de modo que no haya repeticiones en las filas, columnas, ni bloques de 3×3.
</details>

<details>
<summary>¿Cuántos casilleros predeterminados necesita un Sudoku para tener solución única?</summary>
Si hay menos de 17 casilleros predeterminados, la solución no es única.
</details>

<details>
<summary>¿Cómo funciona el algoritmo de backtracking para resolver Sudokus?</summary>
<ol>
  <li>En cada nivel de la recursión se analizan todas las posibilidades para un casillero</li>
  <li>Para cada valor posible, se asigna y se realiza la llamada recursiva</li>
  <li>Caso base 1: Si hay repeticiones en alguna fila, columna o bloque, se sale de la función</li>
  <li>Caso base 2: Si se completa el tablero sin repeticiones, se informa la solución</li>
</ol>
</details>

<details>
<summary>¿Qué información adicional se puede obtener con el algoritmo de backtracking para Sudokus?</summary>
Con este esquema se pueden contar cuántas soluciones tiene el problema, no solo encontrar una solución válida.
</details>

## 📊 Comparación y Análisis

<details>
<summary>¿En qué se diferencia el recorrido del árbol de soluciones entre fuerza bruta y backtracking?</summary>
<ul>
  <li>Fuerza bruta: recorre todo el árbol en orden, llegando hasta todas las hojas</li>
  <li>Backtracking: poda las ramas del árbol en las que detecta que no hay soluciones, evitando explorar caminos inválidos</li>
</ul>
</details>

<details>
<summary>¿Cuál es la relación entre el árbol de soluciones y las llamadas recursivas en backtracking?</summary>
El recorrido del árbol de soluciones en backtracking corresponde al árbol de llamadas recursivas del algoritmo.
</details>

<details>
<summary>¿Cuándo es apropiado usar fuerza bruta a pesar de su ineficiencia?</summary>
<ul>
  <li>Para instancias muy pequeñas del problema</li>
  <li>Como referencia teórica o punto de comparación</li>
  <li>Cuando no existe una mejor alternativa conocida</li>
  <li>Cuando la simplicidad de implementación es más importante que la eficiencia</li>
</ul>
</details>

<details>
<summary>¿Qué técnicas se pueden usar cuando ni fuerza bruta ni backtracking son practicables?</summary>
Se pueden usar técnicas más avanzadas como heurísticas, algoritmos aproximados, programación dinámica, o métodos probabilísticos.
</details>
