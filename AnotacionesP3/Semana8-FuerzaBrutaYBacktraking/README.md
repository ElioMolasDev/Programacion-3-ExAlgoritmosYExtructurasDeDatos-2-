# Algoritmos de Fuerza Bruta y Backtracking

## Conceptos Fundamentales

### Problemas Computacionales

En teoría de complejidad computacional, un **problema** es la descripción de los datos de entrada y la respuesta esperada para cada entrada. Una **instancia** es un conjunto válido de datos de entrada específicos.

#### Tipos de Problemas

**Problemas de Decisión**: Aquellos cuya respuesta es un valor booleano (sí/no, verdadero/falso).

*Ejemplo*: ¿Existe una solución válida para un tablero de Sudoku dado?

**Problemas de Optimización**: Consisten en encontrar la mejor solución dentro de un conjunto factible, maximizando o minimizando una función objetivo.

```
z* = max f(x)  o  z* = min f(x)
     x∈S              x∈S
```

Donde:
- `f: S → R` es la función objetivo
- `S` es la región factible (conjunto de soluciones válidas)
- `z*` es el valor óptimo
- `x*` es una solución óptima si `f(x*) = z*`

---

## Algoritmos de Fuerza Bruta

### Definición

Un algoritmo de **fuerza bruta** (también llamado búsqueda exhaustiva o *generate and test*) consiste en generar todas las soluciones factibles de un problema y seleccionar la mejor.

### Características

**Ventajas:**
- Técnica trivial pero muy general
- Fácil de implementar
- Algoritmo exacto: si existe solución, siempre la encuentra

**Desventajas:**
- Complejidad típicamente exponencial
- Impracticable para instancias grandes debido a la **explosión combinatoria**

### Ejemplos Clásicos

#### 1. Problema de Clique Máxima

**Definición**: Una clique es un conjunto de vértices en un grafo donde todos son vecinos entre sí.

**Objetivo**: Encontrar el tamaño ω(G) de la mayor clique en un grafo G.

**Enfoque de fuerza bruta**:
1. Generar todos los subconjuntos de vértices (conjunto de partes)
2. Para cada subconjunto, verificar si es una clique
3. Calcular su tamaño y quedarse con el mayor

**Complejidad**: O(2ⁿ) - si hay n vértices, hay 2ⁿ subconjuntos posibles

#### 2. Problema del Viajante de Comercio (TSP)

**Definición**: Dado un conjunto de n ciudades y una matriz de distancias, encontrar el recorrido que pase por todas las ciudades minimizando la distancia total.

**Enfoque de fuerza bruta**:
1. Generar todas las permutaciones del conjunto de ciudades
2. Calcular la distancia total de cada recorrido
3. Seleccionar la permutación con menor distancia

**Complejidad**: O(n² · n!) - hay n! permutaciones posibles

**Nota**: No se conocen algoritmos con mejor caso que O(n!) para TSP, y se sospecha que no existen.

### Implementación Recursiva

Los algoritmos de fuerza bruta típicamente se implementan mediante recursión:

```java
// Generación de subconjuntos (Clique)
private void recursion(int inicial) {
    // Caso base: procesamos todos los vértices
    if(inicial == grafo.vertices()) {
        if(esClique(actual) && actual.size() > incumbente.size())
            incumbente = clonar(actual);
        return;
    }
    
    // Caso recursivo: incluir o no incluir el vértice actual
    actual.agregar(inicial);
    recursion(inicial+1);
    
    actual.eliminar(inicial);
    recursion(inicial+1);
}
```

---

## Backtracking

### Definición

**Backtracking** es una técnica que recorre exhaustivamente todos los posibles candidatos a solución, pero **interrumpe** la construcción de un candidato cuando detecta que no será una solución válida.

### Requisitos

Solo puede aplicarse a problemas que tengan:
- Una noción de **solución parcial** (o parcialmente construida)
- Capacidad de testear rápidamente si la solución parcial es incoherente o no puede completarse

### Ventaja sobre Fuerza Bruta

Al saltear soluciones parciales inválidas (**poda**), no recorre todas las posibles soluciones, siendo generalmente más eficiente que fuerza bruta.

### Árbol de Soluciones

El proceso de backtracking puede visualizarse mediante un árbol donde:
1. Cada nivel agrega un elemento a la construcción de la solución
2. Las hojas corresponden a candidatos completos

**Diferencias**:
- **Fuerza bruta**: recorre todo el árbol hasta todas las hojas
- **Backtracking**: poda ramas donde detecta que no hay soluciones

### Ejemplos Clásicos

#### 1. Problema de las 8 Reinas

**Objetivo**: Ubicar 8 reinas en un tablero de ajedrez 8×8 sin que ninguna amenace a otra.

**Fuerza bruta**: C(64,8) = 4,426,165,368 combinaciones

**Optimización básica**: Una reina por columna → 8⁸ = 16,777,216 combinaciones

**Backtracking**:
1. Colocar una reina en la primera columna
2. Colocar una reina en la segunda columna que no ataque a la primera
3. Si no es posible, retroceder al paso anterior (backtrack)
4. Continuar hasta completar las 8 columnas

**Clave**: Interrumpir la construcción tan pronto se detecta que dos reinas se amenazan.

```java
static void nreinas(SolucionParcial actual, int col) {
    if(col == 8) {
        // ¡Encontramos una solución!
        return;
    }
    
    for(int i=0; i<8; ++i) {
        if(!estaAmenazado(i, col, actual)) {
            agregar(actual, i, col);
            nreinas(actual, col+1);
            sacar(actual, i, col);
        }
    }
}
```

#### 2. Resolver Sudokus

**Problema**: Completar un tablero con números del 1 al 9 sin repeticiones en filas, columnas ni bloques 3×3.

**Algoritmo de backtracking**:
1. En cada nivel de recursión, analizar todas las posibilidades para un casillero
2. Para cada valor posible, asignarlo y realizar llamada recursiva
3. **Caso base 1**: Hay repeticiones → retroceder
4. **Caso base 2**: Tablero completo sin repeticiones → solución encontrada

**Observación**: Con este esquema se pueden contar todas las soluciones posibles. Un Sudoku necesita al menos 17 casilleros predeterminados para tener solución única.

### Implementación Típica

Los algoritmos de backtracking se implementan típicamente mediante **recursión**, donde:
- La función explora todas las opciones en cada nivel
- Deshace cambios al retroceder (backtrack)
- Poda ramas inválidas tempranamente

---

## Comparación: Fuerza Bruta vs Backtracking

| Aspecto | Fuerza Bruta | Backtracking |
|---------|--------------|--------------|
| **Exploración** | Todas las soluciones completas | Soluciones parciales con poda |
| **Eficiencia** | Siempre examina todo el espacio | Puede reducir significativamente el espacio |
| **Aplicabilidad** | Cualquier problema de búsqueda | Requiere noción de solución parcial |
| **Complejidad** | Típicamente exponencial | Mejor que fuerza bruta, pero aún puede ser exponencial |

---

## Conclusiones

Ambas técnicas son fundamentales en algoritmia:

- **Fuerza bruta** es útil para problemas pequeños, como referencia teórica, o cuando no existe mejor alternativa
- **Backtracking** mejora significativamente la eficiencia al podar el espacio de búsqueda
- Para problemas grandes, ambas técnicas pueden ser impracticables, requiriendo enfoques más avanzados (heurísticas, programación dinámica, etc.)

La elección entre estas técnicas y otras más avanzadas depende del tamaño del problema, las restricciones de tiempo, y la necesidad de encontrar la solución óptima versus una solución aproximada.

---

*Material basado en las clases de Programación III - UNGS*
