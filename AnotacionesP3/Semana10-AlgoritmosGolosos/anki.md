# Preguntas Anki - Algoritmos Golosos

## 🎯 Conceptos Básicos

<details>
<summary>¿Qué es un algoritmo goloso (greedy)?</summary>
Es un algoritmo que construye una solución seleccionando en cada paso la mejor alternativa local, sin considerar (o haciéndolo débilmente) las implicancias futuras de esta selección.
</details>

<details>
<summary>¿Qué tipo de soluciones proporcionan habitualmente los algoritmos golosos?</summary>
Habitualmente proporcionan heurísticas sencillas para problemas de optimización, permitiendo construir soluciones razonables pero generalmente sub-óptimas.
</details>

<details>
<summary>¿Los algoritmos golosos siempre dan soluciones sub-óptimas?</summary>
No, en ocasiones pueden dar interesantes sorpresas y encontrar soluciones óptimas para ciertos problemas específicos.
</details>

<details>
<summary>¿Qué relación tienen los algoritmos golosos con las heurísticas?</summary>
Los algoritmos golosos son un caso especial de algoritmos heurísticos. Las mismas consideraciones sobre calidad vs. complejidad se pueden hacer con cualquier heurística.
</details>

## 🎒 Problema de la Mochila

<details>
<summary>¿Cuáles son los datos de entrada del problema de la mochila?</summary>
<ul>
  <li>Capacidad C de la mochila (peso máximo)</li>
  <li>Cantidad n de objetos</li>
  <li>Peso pᵢ de cada objeto i</li>
  <li>Beneficio bᵢ de cada objeto i</li>
</ul>
</details>

<details>
<summary>¿Cuál es el objetivo del problema de la mochila?</summary>
Determinar qué objetos incluir en la mochila sin exceder el peso máximo C, de modo tal de maximizar el beneficio total entre los objetos seleccionados.
</details>

<details>
<summary>Mencione tres estrategias golosas para el problema de la mochila</summary>
<ol>
  <li>Agregar el objeto con mayor beneficio bᵢ</li>
  <li>Agregar el objeto con menor peso pᵢ</li>
  <li>Agregar el objeto que maximice la relación bᵢ/pᵢ (beneficio/peso)</li>
</ol>
</details>

<details>
<summary>¿Cuál estrategia golosa suele dar mejores resultados en el problema de la mochila?</summary>
La estrategia de maximizar la relación bᵢ/pᵢ (beneficio/peso) suele dar mejores resultados en la práctica.
</details>

<details>
<summary>¿Los algoritmos golosos garantizan encontrar la solución óptima para el problema de la mochila?</summary>
No, estos algoritmos no garantizan encontrar la solución óptima. Pueden dar soluciones razonables pero sub-óptimas.
</details>

<details>
<summary>¿Cuál es la complejidad de un algoritmo goloso para la mochila con ordenamiento previo?</summary>
O(n log n) debido al ordenamiento inicial de los objetos según el criterio elegido.
</details>

## 🚗 Problema del Viajante de Comercio (TSP)

<details>
<summary>¿Cómo funciona el algoritmo goloso para el problema del viajante de comercio?</summary>
<ol>
  <li>Comenzar en una ciudad arbitraria</li>
  <li>En cada paso, moverse a la ciudad más cercana (aún no visitada)</li>
  <li>Continuar hasta visitar todas las ciudades</li>
</ol>
</details>

<details>
<summary>¿Cuál es la complejidad del algoritmo goloso para TSP?</summary>
O(n²), porque en cada paso (hay n pasos) debemos buscar entre las ciudades aún no visitadas la que se encuentre más cerca.
</details>

<details>
<summary>¿El algoritmo goloso garantiza encontrar la solución óptima para TSP?</summary>
No, no garantiza encontrar la solución óptima. Puede dar soluciones razonables en muchos casos, pero en algunos puede dar soluciones muy alejadas del óptimo.
</details>

## ⚖️ Comparación: Fuerza Bruta vs. Golosos

<details>
<summary>Compare la calidad de solución entre algoritmos de fuerza bruta y algoritmos golosos</summary>
<ul>
  <li>Fuerza bruta: Calidad óptima (garantizada)</li>
  <li>Algoritmos golosos: Calidad sub-óptima (no garantizada)</li>
</ul>
</details>

<details>
<summary>Compare la complejidad computacional entre algoritmos de fuerza bruta y algoritmos golosos</summary>
<ul>
  <li>Fuerza bruta: Complejidad alta (exponencial)</li>
  <li>Algoritmos golosos: Complejidad eficiente (polinomial)</li>
</ul>
</details>

<details>
<summary>¿Cuál es el trade-off fundamental de los algoritmos golosos?</summary>
Sacrifican la garantía de optimalidad (calidad de solución) a cambio de eficiencia computacional (complejidad polinomial).
</details>

## ⭐ Algoritmos Golosos Exactos

<details>
<summary>¿Qué es un algoritmo goloso exacto?</summary>
Es un algoritmo goloso que siempre encuentra la solución óptima para un problema específico.
</details>

<details>
<summary>¿Por qué los algoritmos golosos exactos representan una situación ideal?</summary>
Porque hallamos algoritmos eficientes (complejidad polinomial) con garantía de optimalidad (siempre encuentran el óptimo).
</details>

<details>
<summary>¿Se pueden encontrar algoritmos golosos exactos para cualquier problema?</summary>
No, no siempre se pueden hallar algoritmos con estas características. Depende del problema en cuestión.
</details>

## ⏰ Ejemplo: Minimizar Tiempo Promedio de Espera

<details>
<summary>¿Cuál es el problema de minimizar el tiempo promedio de espera?</summary>
Dados n clientes con tiempos de atención tᵢ conocidos, determinar en qué orden atenderlos para minimizar el tiempo promedio de espera de todos los clientes.
</details>

<details>
<summary>¿Cuál es el algoritmo goloso para minimizar el tiempo promedio de espera?</summary>
Ordenar los clientes de menor a mayor tiempo de atención, y atenderlos en ese orden.
</details>

<details>
<summary>¿Este algoritmo goloso encuentra la solución óptima?</summary>
Sí, este algoritmo genera una solución óptima. Es un ejemplo de algoritmo goloso exacto.
</details>

<details>
<summary>¿Cuál es la complejidad del algoritmo para minimizar el tiempo promedio de espera?</summary>
O(n log n) debido al ordenamiento de los clientes.
</details>

<details>
<summary>¿Cómo se demuestra que el algoritmo de tiempo promedio de espera es óptimo?</summary>
Por contradicción e intercambio: Si existe k tal que tₖ > tₖ₊₁, al intercambiar estos dos clientes se obtiene un tiempo promedio menor. Por lo tanto, si una permutación no está ordenada, no es óptima.
</details>

<details>
<summary>¿Por qué ordenar por tiempo creciente minimiza el tiempo promedio de espera?</summary>
Porque al atender primero a los clientes con menor tiempo, reducimos el tiempo de espera de todos los clientes posteriores. Cada cliente posterior se beneficia de que los anteriores hayan sido atendidos rápidamente.
</details>

## 🎯 Propiedades de Algoritmos Golosos Óptimos

<details>
<summary>¿Qué es la propiedad de elección golosa (greedy choice property)?</summary>
Es la propiedad que indica que una elección local óptima lleva a una solución global óptima.
</details>

<details>
<summary>¿Qué es la subestructura óptima (optimal substructure)?</summary>
Es la propiedad que indica que una solución óptima del problema contiene soluciones óptimas a sus subproblemas.
</details>

<details>
<summary>¿Qué propiedades debe tener un problema para que un algoritmo goloso encuentre la solución óptima?</summary>
<ul>
  <li>Propiedad de elección golosa: Una elección local óptima lleva a una solución global óptima</li>
  <li>Subestructura óptima: Una solución óptima contiene soluciones óptimas a sus subproblemas</li>
</ul>
</details>

## 📋 Cuándo Usar Algoritmos Golosos

<details>
<summary>Mencione 4 ventajas de los algoritmos golosos</summary>
<ul>
  <li>Simplicidad: Fáciles de entender e implementar</li>
  <li>Eficiencia: Complejidad polinomial</li>
  <li>Soluciones razonables: Aunque no óptimas, útiles en la práctica</li>
  <li>Punto de partida: Pueden servir como base para heurísticas más sofisticadas</li>
</ul>
</details>

<details>
<summary>Mencione 3 desventajas de los algoritmos golosos</summary>
<ul>
  <li>No garantizan optimalidad (excepto en casos especiales probados)</li>
  <li>Decisiones irreversibles: No hay backtracking</li>
  <li>Miopía: Solo consideran beneficio local, no global</li>
</ul>
</details>

<details>
<summary>¿Cuándo es apropiado aplicar algoritmos golosos?</summary>
<ol>
  <li>Cuando el problema admite un algoritmo goloso exacto</li>
  <li>Como heurística para problemas NP-completos donde se necesita una solución rápida</li>
  <li>Como aproximación inicial que luego puede mejorarse</li>
  <li>Cuando la solución óptima no es crítica y se prioriza la eficiencia</li>
</ol>
</details>

## 🔧 Diseño y Estrategia

<details>
<summary>¿Cuáles son los pasos para diseñar un algoritmo goloso?</summary>
<ol>
  <li>Identificar la elección golosa: ¿Qué criterio local usar en cada paso?</li>
  <li>Demostrar optimalidad (si es posible): Usando intercambio, inducción, etc.</li>
  <li>Analizar complejidad: ¿Qué tan eficiente es?</li>
  <li>Evaluar calidad: Si no es óptimo, ¿qué tan buena es la aproximación?</li>
</ol>
</details>

<details>
<summary>¿Qué técnicas se pueden usar para demostrar la optimalidad de un algoritmo goloso?</summary>
<ul>
  <li>Demostración por intercambio (exchange argument)</li>
  <li>Inducción matemática</li>
  <li>Propiedades de subestructura óptima</li>
</ul>
</details>

## 📚 Ejemplos de Problemas

<details>
<summary>Mencione 5 problemas que tienen algoritmos golosos exactos</summary>
<ul>
  <li>Árbol generador mínimo (Kruskal, Prim)</li>
  <li>Caminos mínimos (Dijkstra)</li>
  <li>Códigos de Huffman</li>
  <li>Problema de selección de actividades</li>
  <li>Minimizar tiempo promedio de espera</li>
</ul>
</details>

<details>
<summary>Mencione 4 problemas donde los algoritmos golosos son solo heurísticas</summary>
<ul>
  <li>Problema de la mochila (versión 0-1)</li>
  <li>Problema del viajante de comercio (TSP)</li>
  <li>Coloreo de grafos</li>
  <li>Problema de bin packing</li>
</ul>
</details>

## 🔄 Diferencias con Otras Técnicas

<details>
<summary>¿Cuál es la diferencia principal entre algoritmos golosos y backtracking?</summary>
Los algoritmos golosos toman decisiones irreversibles y no retroceden, mientras que backtracking puede deshacer decisiones y explorar otras alternativas cuando encuentra que una ruta no es viable.
</details>

<details>
<summary>¿Por qué los algoritmos golosos son más eficientes que backtracking?</summary>
Porque no exploran múltiples alternativas ni retroceden. Toman una decisión local en cada paso y continúan, lo que resulta en complejidad polinomial en lugar de exponencial.
</details>

<details>
<summary>¿Los algoritmos golosos pueden usarse para problemas NP-completos?</summary>
Sí, pueden usarse como heurísticas para obtener soluciones razonables en tiempo polinomial, aunque no garantizan encontrar la solución óptima.
</details>

## 🎓 Conceptos Avanzados

<details>
<summary>¿Qué significa que un algoritmo goloso es "miope"?</summary>
Significa que solo considera el beneficio local o inmediato de cada decisión, sin evaluar las consecuencias futuras o el impacto global de esa elección.
</details>

<details>
<summary>¿Cuál es la clave para reconocer cuándo usar algoritmos golosos?</summary>
Reconocer cuándo un problema admite un algoritmo goloso óptimo (mediante sus propiedades estructurales) y cuándo solo sirve como heurística aproximada.
</details>

<details>
<summary>¿Qué representa el "trade-off" fundamental en algoritmos para optimización?</summary>
El balance entre calidad de solución (optimalidad) y complejidad computacional (eficiencia). Los algoritmos golosos sacrifican garantía de optimalidad por eficiencia.
</details>
