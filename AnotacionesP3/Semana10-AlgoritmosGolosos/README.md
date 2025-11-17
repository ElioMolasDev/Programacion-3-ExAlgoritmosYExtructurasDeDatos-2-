# Algoritmos Golosos (Greedy Algorithms)

## Definición

Un **algoritmo goloso** (o greedy) construye una solución seleccionando en cada paso la mejor alternativa local, sin considerar (o haciéndolo débilmente) las implicancias futuras de esta selección.

### Características Principales

1. **Proporcionan heurísticas sencillas** para problemas de optimización
2. **Generalmente** permiten construir soluciones razonables, pero **sub-óptimas**
3. **Sin embargo**, en ocasiones pueden dar interesantes sorpresas y encontrar soluciones óptimas

---

## El Problema de la Mochila

### Definición del Problema

**Datos de entrada:**
- Capacidad C ∈ R⁺ de la mochila (peso máximo)
- Cantidad n ∈ ℕ de objetos
- Peso pᵢ ∈ R⁺ del objeto i, para i = 1, ..., n
- Beneficio bᵢ ∈ R⁺ del objeto i, para i = 1, ..., n

**Objetivo:** Determinar qué objetos incluir en la mochila sin exceder el peso máximo C, de modo tal de maximizar el beneficio total.

### Algoritmos Golosos para la Mochila

Mientras no se haya excedido el peso de la mochila, agregar el objeto i que:

1. **Estrategia 1**: Tenga **mayor beneficio** bᵢ
2. **Estrategia 2**: Tenga **menor peso** pᵢ
3. **Estrategia 3**: **Maximice** la relación beneficio/peso: bᵢ/pᵢ

### Análisis

**Calidad de la solución:**
- Estos algoritmos **no garantizan** encontrar la solución óptima
- Pueden dar soluciones razonables pero sub-óptimas
- La estrategia 3 (maximizar bᵢ/pᵢ) suele dar mejores resultados en la práctica

**Complejidad:**
- Depende de la implementación
- Con ordenamiento previo: **O(n log n)**
- Sin ordenamiento, seleccionando en cada paso: **O(n²)**

---

## El Problema del Viajante de Comercio (TSP)

### Algoritmo Goloso para TSP

**Estrategia:** 
1. Comenzar en una ciudad arbitraria
2. En cada paso, moverse a la ciudad más cercana (aún no visitada)
3. Continuar hasta visitar todas las ciudades

### Análisis

**Complejidad:** **O(n²)**
- En cada paso debemos buscar entre las ciudades aún no visitadas la que se encuentre más cerca
- Hay n pasos, y en cada uno buscamos entre las ciudades restantes

**Calidad de la solución:**
- **No garantiza** encontrar la solución óptima
- Puede dar soluciones razonables en muchos casos
- En algunos casos puede dar soluciones muy alejadas del óptimo

---

## Comparación: Fuerza Bruta vs. Algoritmos Golosos

| Aspecto | Fuerza Bruta | Algoritmos Golosos |
|---------|--------------|-------------------|
| **Calidad de la solución** | Óptima (garantizada) | Sub-óptima (no garantizada) |
| **Complejidad** | Alta (exponencial) | Eficiente (polinomial) |
| **Aplicabilidad** | Instancias pequeñas | Instancias grandes |

### Observación Importante

Las mismas consideraciones se pueden hacer con cualquier **heurística**. Los algoritmos golosos son un **caso especial** de algoritmos heurísticos que toman decisiones locales sin retroceder.

---

## Algoritmos Golosos Exactos

### Definición

Para algunos problemas, se pueden plantear algoritmos golosos que **siempre encuentran la solución óptima**.

### Importancia

Se trata de una **situación ideal**, porque:
- Hallamos algoritmos **eficientes** (complejidad polinomial)
- Con **garantía de optimalidad** (siempre encuentran el óptimo)

### Limitación

No siempre se pueden hallar algoritmos con estas características. **Depende del problema en cuestión**.

---

## Ejemplo: Minimizando el Tiempo Promedio de Espera

### Definición del Problema

**Datos de entrada:**
- Cantidad n ∈ ℕ de clientes
- Tiempo tᵢ ∈ R⁺ de atención del cliente i, para i = 1, ..., n

**Objetivo:** Determinar en qué orden atender a los clientes para minimizar el tiempo promedio de espera.

### Algoritmo Goloso

**Estrategia:** Ordenar los clientes de menor a mayor tiempo de atención, y atenderlos en ese orden.

### Demostración de Optimalidad

**Teorema:** Este algoritmo genera una solución óptima.

**Demostración (por contradicción e intercambio):**

1. **Supuesto:** No ordenamos las tareas en orden creciente de tiempo
   - Existe k ∈ {1, ..., n-1} tal que tₖ > tₖ₊₁

2. **Intercambio:** Consideremos la misma permutación, pero intercambiando a los clientes k y k+1
   - Esta permutación está "un poco más ordenada"

3. **Comparación de tiempos:**
   - El tiempo promedio de la nueva permutación es **menor**
   - Esto se debe a que al intercambiar, el cliente k+1 (con menor tiempo) afecta a todos los clientes posteriores

4. **Conclusión:** Si una permutación no está ordenada, **no es óptima**
   - Por lo tanto, la permutación ordenada es óptima

### Análisis Detallado

**¿Por qué funciona?**

Si tenemos dos clientes consecutivos con tₖ > tₖ₊₁:
- **Antes del intercambio:**
  - Cliente k espera: W (tiempo acumulado antes de k)
  - Cliente k+1 espera: W + tₖ
  - Tiempo total de espera para estos dos: W + (W + tₖ) = 2W + tₖ

- **Después del intercambio:**
  - Cliente k+1 espera: W
  - Cliente k espera: W + tₖ₊₁
  - Tiempo total de espera para estos dos: W + (W + tₖ₊₁) = 2W + tₖ₊₁

Como tₖ > tₖ₊₁, entonces 2W + tₖ > 2W + tₖ₊₁

**Además**, todos los clientes posteriores a k+1 se benefician del intercambio, ya que ahora esperan tₖ₊₁ menos en total.

**Complejidad:** **O(n log n)** debido al ordenamiento

---

## Cuándo Usar Algoritmos Golosos

### Ventajas

✅ **Simplicidad:** Fáciles de entender e implementar
✅ **Eficiencia:** Complejidad polinomial (generalmente O(n log n) o O(n²))
✅ **Soluciones razonables:** Aunque no óptimas, suelen ser útiles en la práctica
✅ **Punto de partida:** Pueden servir como base para heurísticas más sofisticadas

### Desventajas

❌ **No garantizan optimalidad:** Excepto en casos especiales probados
❌ **Decisiones irreversibles:** No hay backtracking
❌ **Miopía:** Solo consideran beneficio local, no global

### Cuándo Aplicarlos

1. **Cuando el problema admite un algoritmo goloso exacto** (como el ejemplo de tiempo de espera)
2. **Como heurística** para problemas NP-completos donde se necesita una solución rápida
3. **Como aproximación inicial** que luego puede mejorarse con otras técnicas
4. **Cuando la solución óptima no es crítica** y se prioriza la eficiencia

---

## Estrategia de Diseño

Para diseñar un algoritmo goloso:

1. **Identificar la elección golosa:** ¿Qué criterio local usar en cada paso?
2. **Demostrar optimalidad (si es posible):** Usando técnicas como:
   - Demostración por intercambio (exchange argument)
   - Inducción
   - Propiedades de subestructura óptima
3. **Analizar complejidad:** ¿Qué tan eficiente es?
4. **Evaluar calidad:** Si no es óptimo, ¿qué tan buena es la aproximación?

---

## Propiedades para Algoritmos Golosos Óptimos

Para que un algoritmo goloso encuentre la solución óptima, el problema debe tener:

### 1. Propiedad de Elección Golosa (Greedy Choice Property)

Una elección local óptima lleva a una solución global óptima.

### 2. Subestructura Óptima (Optimal Substructure)

Una solución óptima del problema contiene soluciones óptimas a sus subproblemas.

### Ejemplo: Tiempo Promedio de Espera

- ✅ **Elección golosa:** Elegir el cliente con menor tiempo de atención
- ✅ **Subestructura óptima:** Una vez elegido el primer cliente, el resto se ordena óptimamente de la misma manera

---

## Ejemplos Adicionales de Algoritmos Golosos

### Problemas con Algoritmos Golosos Exactos

1. **Árbol generador mínimo (Kruskal, Prim)**
2. **Caminos mínimos (Dijkstra)**
3. **Códigos de Huffman**
4. **Problema de selección de actividades**
5. **Minimizar tiempo promedio de espera**

### Problemas con Algoritmos Golosos Heurísticos

1. **Problema de la mochila (versión 0-1)**
2. **Problema del viajante de comercio (TSP)**
3. **Coloreo de grafos**
4. **Problema de bin packing**

---

## Conclusiones

Los algoritmos golosos son una herramienta fundamental en el diseño de algoritmos:

- **Ofrecen un trade-off** entre calidad de solución y eficiencia computacional
- **Son ideales** cuando se puede probar su optimalidad
- **Son útiles** como heurísticas rápidas para problemas difíciles
- **Requieren análisis cuidadoso** para determinar su calidad
- **Representan decisiones irreversibles**, a diferencia de backtracking

La clave está en reconocer cuándo un problema admite un algoritmo goloso óptimo y cuándo solo sirve como heurística aproximada.

---

*Material basado en las clases de Programación III - UNGS*
