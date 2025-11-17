# Preguntas Anki - Algoritmos Genéticos

## 🧬 Conceptos Fundamentales

<details>
<summary>¿Qué son los algoritmos genéticos?</summary>
Son una técnica de optimización heurística inspirada en la teoría de evolución de las especies con selección natural (bio-inspired computing) que simula una población de individuos que evoluciona hasta encontrar una buena solución.
</details>

<details>
<summary>¿Qué características tienen los algoritmos genéticos?</summary>
<ul>
  <li>Son algoritmos heurísticos (no garantizan la solución exacta)</li>
  <li>Son algoritmos eficientes (complejidad polinomial)</li>
  <li>Están inspirados en la evolución biológica</li>
</ul>
</details>

<details>
<summary>¿En qué grupo de algoritmos se encuadran los algoritmos genéticos?</summary>
Se encuadran en el grupo de algoritmos heurísticos con buena complejidad pero sin garantía de encontrar la solución óptima.
</details>

<details>
<summary>¿De qué teoría biológica están inspirados los algoritmos genéticos?</summary>
Están inspirados en la teoría de evolución de las especies con selección natural. La idea general se denomina bio-inspired computing.
</details>

## 🧩 Contexto: Exactos vs. Heurísticas

<details>
<summary>Compare algoritmos exactos y heurísticos en términos de calidad de solución y complejidad</summary>
<ul>
  <li>Algoritmos exactos: Buena calidad (óptima) pero mala complejidad (exponencial)</li>
  <li>Algoritmos heurísticos: Mala calidad (aproximada) pero buena complejidad (polinomial)</li>
</ul>
</details>

<details>
<summary>¿Se puede tener un algoritmo con buena complejidad Y buena calidad de solución garantizada?</summary>
No, a menos que P = NP. Hay un trade-off fundamental entre calidad de solución y complejidad.
</details>

<details>
<summary>¿Qué alternativas realistas tenemos para problemas NP-completos?</summary>
<ul>
  <li>Algoritmos exactos con tiempos razonables para instancias específicas</li>
  <li>Heurísticas con la mejor calidad de solución posible (sin garantías)</li>
</ul>
</details>

## 🔤 Terminología Genética

<details>
<summary>¿Qué es un individuo o cromosoma en algoritmos genéticos?</summary>
Es una solución candidata representada como una secuencia de bits.
</details>

<details>
<summary>¿Qué es un gen en algoritmos genéticos?</summary>
Es una parte específica de un cromosoma que codifica un atributo particular de la solución.
</details>

<details>
<summary>¿Qué es la población en algoritmos genéticos?</summary>
Es un conjunto de individuos (soluciones candidatas) que evolucionan juntos.
</details>

<details>
<summary>¿Qué es la función de fitness?</summary>
Es una función que evalúa la calidad de un individuo (solución). Mide qué tan buena es una solución para el problema.
</details>

<details>
<summary>¿Cómo se codifica una solución para el problema de la mochila en un algoritmo genético?</summary>
Como una secuencia de n bits, donde el bit i es 1 si el objeto i está incluido en la mochila y 0 en caso contrario. Ejemplo: 0001010110101001010
</details>

## ⚙️ Operadores Genéticos

<details>
<summary>¿Qué es la mutación en algoritmos genéticos?</summary>
Es la modificación aleatoria de algunos bits en un individuo. Por ejemplo, cambiar un 0 por 1 o viceversa en una posición aleatoria del cromosoma.
</details>

<details>
<summary>¿Qué es la recombinación o crossover?</summary>
Es la combinación de dos individuos padres para generar dos individuos hijos, intercambiando partes de sus cromosomas.
</details>

<details>
<summary>¿Qué es la selección natural en algoritmos genéticos?</summary>
Es la eliminación de los peores individuos según la función de fitness y su reemplazo por nuevos individuos (aleatorios o generados por mutación/recombinación).
</details>

<details>
<summary>¿Cómo funciona el crossover de un punto?</summary>
Se elige un punto de corte aleatorio, y los dos padres intercambian sus segmentos después de ese punto para generar dos hijos.
</details>

## 📊 Parámetros

<details>
<summary>¿Cuáles son los tres parámetros principales de un algoritmo genético?</summary>
<ul>
  <li>Tamaño de la población (m): cantidad de individuos</li>
  <li>Tasa de mutación (tₘ): probabilidad de mutar un individuo</li>
  <li>Tasa de recombinación (tᵣ): probabilidad de recombinar un individuo</li>
</ul>
</details>

<details>
<summary>¿Cuáles son los valores típicos para los parámetros de un algoritmo genético?</summary>
<ul>
  <li>m = 1000 (tamaño de población)</li>
  <li>tₘ = 0.001 o 0.1% (tasa de mutación)</li>
  <li>tᵣ = 0.7 o 70% (tasa de recombinación)</li>
</ul>
Estos valores deben ajustarse empíricamente según el problema.
</details>

<details>
<summary>¿Qué es la tasa de mutación?</summary>
Es la probabilidad de seleccionar un individuo para mutarlo. Valor típico: tₘ = 0.001 (0.1%).
</details>

<details>
<summary>¿Qué es la tasa de recombinación?</summary>
Es la probabilidad de seleccionar un individuo para recombinarlo con otro. Valor típico: tᵣ = 0.7 (70%).
</details>

<details>
<summary>¿Cómo se deben ajustar los parámetros de un algoritmo genético?</summary>
Los parámetros deben ajustarse empíricamente para cada problema específico, ya que no hay valores universalmente óptimos.
</details>

## 🔄 Esquema del Algoritmo

<details>
<summary>¿Cuál es el esquema general de un algoritmo genético?</summary>
<ol>
  <li>Generar la población P aleatoriamente</li>
  <li>Mientras la población no es satisfactoria:</li>
  <li>- Seleccionar individuos y mutarlos</li>
  <li>- Seleccionar pares de individuos y recombinarlos</li>
  <li>- Eliminar peores individuos según fitness</li>
  <li>- Reemplazar eliminados con nuevos individuos</li>
  <li>Retornar el mejor individuo de P</li>
</ol>
</details>

<details>
<summary>¿Qué operaciones se realizan en cada iteración de un algoritmo genético?</summary>
<ol>
  <li>Algunos individuos mutan espontáneamente</li>
  <li>Algunos pares de individuos se combinan, generando hijos</li>
  <li>Los peores individuos se eliminan y se reemplazan por nuevos</li>
</ol>
</details>

## 🏁 Criterios de Terminación

<details>
<summary>¿Cuándo termina un algoritmo genético?</summary>
<ul>
  <li>Cuando se llega a un máximo de iteraciones</li>
  <li>Cuando la mejor solución tiene un fitness por encima de cierto umbral</li>
  <li>Cuando pasa una cierta cantidad de iteraciones sin mejora</li>
</ul>
</details>

<details>
<summary>¿Es posible saber con certeza cuándo un algoritmo genético alcanzó la solución óptima?</summary>
No, en general no hay un criterio definido. Un algoritmo genético es un proceso iterativo que se espera que sea convergente a la solución óptima, pero no es posible saber cuándo llega exactamente al óptimo.
</details>

<details>
<summary>¿Qué significa que un algoritmo genético sea convergente?</summary>
Significa que se espera que con suficientes iteraciones se acerque cada vez más a la solución óptima, aunque no hay garantía de alcanzarla ni de saber cuándo se alcanzó.
</details>

## 🎒 Ejemplo: Problema de la Mochila

<details>
<summary>¿Cómo se especifica un algoritmo genético para el problema de la mochila?</summary>
<ul>
  <li>Codificación: n bits, donde bit i = 1 si objeto i está incluido</li>
  <li>Fitness: beneficio total (penalizando si excede capacidad)</li>
  <li>Mutación: invertir un bit aleatorio</li>
  <li>Recombinación: combinar dos soluciones en punto de corte</li>
</ul>
</details>

<details>
<summary>¿Qué representa un 1 y un 0 en el cromosoma del problema de la mochila?</summary>
<ul>
  <li>1 = el objeto está incluido en la mochila</li>
  <li>0 = el objeto NO está incluido en la mochila</li>
</ul>
</details>

## ⭕ Ejemplo: Círculo Más Grande

<details>
<summary>¿Cuál es el problema del círculo más grande?</summary>
Dado un conjunto de círculos en el plano, encontrar el círculo más grande que se puede dibujar sin tocar los círculos existentes.
</details>

<details>
<summary>¿Cómo se codifica una solución para el problema del círculo más grande?</summary>
Se usan 3k bits divididos en tres genes: x (k bits), y (k bits) y r (k bits), que representan el centro (x, y) y el radio r del círculo.
</details>

<details>
<summary>¿Qué es un gen en el ejemplo del círculo más grande?</summary>
Cada una de las tres partes del cromosoma (x, y, r) se denomina un gen, y juntas conforman un cromosoma o individuo completo.
</details>

<details>
<summary>¿Cuál es la función de fitness para el problema del círculo más grande?</summary>
fitness = área del círculo - cantidad de círculos del input que interseca. Busca maximizar el área mientras minimiza intersecciones.
</details>

<details>
<summary>¿Qué complejidad tiene el problema del círculo más grande en diferentes dimensiones?</summary>
<ul>
  <li>En 2D: Se puede resolver eficientemente</li>
  <li>En más dimensiones: Tiene complejidad exponencial</li>
</ul>
</details>

## 🛠️ Diseño de Algoritmos Genéticos

<details>
<summary>¿Qué dos cosas es necesario especificar para plantear un algoritmo genético?</summary>
<ol>
  <li>Cómo se codifica una solución con secuencias de bits</li>
  <li>Una función de fitness adecuada para el problema</li>
</ol>
</details>

<details>
<summary>¿Qué pasos son esenciales para diseñar un algoritmo genético?</summary>
<ol>
  <li>Definir la codificación (cómo representar soluciones como bits)</li>
  <li>Diseñar la función de fitness (medir calidad)</li>
  <li>Configurar parámetros (m, tₘ, tᵣ, criterio de terminación)</li>
  <li>Implementar operadores (mutación, recombinación, selección)</li>
</ol>
</details>

<details>
<summary>¿Qué características debe tener una buena función de fitness?</summary>
<ul>
  <li>Debe ser rápida de evaluar (se calcula muchas veces)</li>
  <li>Debe discriminar bien entre soluciones buenas y malas</li>
  <li>Debe guiar la búsqueda hacia buenas soluciones</li>
  <li>Considerar penalizaciones para soluciones inválidas</li>
</ul>
</details>

## ✅ Ventajas y Desventajas

<details>
<summary>Mencione 4 ventajas de los algoritmos genéticos</summary>
<ul>
  <li>No requieren información del gradiente (útil para problemas discretos)</li>
  <li>Exploran ampliamente el espacio de búsqueda (evitan mínimos locales)</li>
  <li>Paralelizables naturalmente</li>
  <li>Aplicables a diversos problemas sin adaptaciones complejas</li>
</ul>
</details>

<details>
<summary>Mencione 4 desventajas de los algoritmos genéticos</summary>
<ul>
  <li>No garantizan encontrar el óptimo (son heurísticas)</li>
  <li>Muchos parámetros para ajustar empíricamente</li>
  <li>Pueden ser lentos para converger</li>
  <li>No hay criterio claro de optimalidad</li>
</ul>
</details>

## 🎯 Cuándo Usar Algoritmos Genéticos

<details>
<summary>¿Cuándo es ideal usar algoritmos genéticos?</summary>
<ul>
  <li>Problemas NP-completos que necesitan solución razonable en tiempo polinomial</li>
  <li>Espacios de búsqueda grandes y complejos con muchos mínimos locales</li>
  <li>Problemas de optimización combinatoria difíciles</li>
  <li>Cuando no se conoce estructura del problema para heurística específica</li>
</ul>
</details>

<details>
<summary>¿Cuándo NO se recomiendan los algoritmos genéticos?</summary>
<ul>
  <li>Problemas con algoritmos exactos eficientes conocidos</li>
  <li>Cuando se requiere garantía de optimalidad</li>
  <li>Espacios de búsqueda muy pequeños (fuerza bruta es más simple)</li>
  <li>Tiempo muy limitado para ajustar parámetros</li>
</ul>
</details>

## 🔬 Conceptos Avanzados

<details>
<summary>¿Qué es el balance exploración-explotación en algoritmos genéticos?</summary>
<ul>
  <li>Exploración: Búsqueda amplia del espacio (alta mutación)</li>
  <li>Explotación: Refinamiento de soluciones conocidas (baja mutación, alta selección)</li>
</ul>
El algoritmo debe balancear ambas para encontrar buenas soluciones sin quedar atrapado en óptimos locales.
</details>

<details>
<summary>¿Qué es el elitismo en algoritmos genéticos?</summary>
Es la estrategia de preservar siempre los mejores individuos encontrados, asegurando que no se pierdan buenas soluciones durante la evolución.
</details>

<details>
<summary>¿Qué puede pasar si la tasa de mutación es muy alta?</summary>
El algoritmo se comporta como búsqueda aleatoria, perdiendo la capacidad de refinar soluciones buenas.
</details>

<details>
<summary>¿Qué puede pasar si la tasa de mutación es muy baja?</summary>
El algoritmo puede converger prematuramente a un óptimo local, sin explorar suficiente el espacio de búsqueda.
</details>

## 📚 Comparación con Otras Técnicas

<details>
<summary>Compare los algoritmos genéticos con los algoritmos golosos</summary>
<ul>
  <li>Golosos: Decisiones irreversibles, más rápidos, soluciones locales</li>
  <li>Genéticos: Exploración global, más lentos, evitan óptimos locales</li>
</ul>
</details>

<details>
<summary>Compare los algoritmos genéticos con backtracking</summary>
<ul>
  <li>Backtracking: Exacto, exhaustivo con poda, complejidad exponencial</li>
  <li>Genéticos: Heurístico, muestreo inteligente, complejidad polinomial</li>
</ul>
</details>

<details>
<summary>¿Cuál es la diferencia clave entre algoritmos genéticos y fuerza bruta?</summary>
Fuerza bruta explora exhaustivamente todas las soluciones (garantía de óptimo), mientras que los algoritmos genéticos muestrean inteligentemente el espacio usando evolución (más rápido pero sin garantía).
</details>

## 🎓 Conceptos Teóricos

<details>
<summary>¿Por qué se dice que los algoritmos genéticos son "bio-inspired"?</summary>
Porque están inspirados directamente en mecanismos biológicos: mutación, recombinación sexual (crossover), selección natural (supervivencia del más apto) y evolución de poblaciones.
</details>

<details>
<summary>¿Qué principio biológico se simula con la función de fitness?</summary>
El principio de "supervivencia del más apto" (survival of the fittest): los individuos con mejor fitness tienen mayor probabilidad de sobrevivir y reproducirse.
</details>
